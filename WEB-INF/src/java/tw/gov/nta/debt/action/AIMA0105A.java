package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Aima0102MForm;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.PaymentMain;

public class AIMA0105A extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {	
		Aima0102MForm aima0102MForm = (Aima0102MForm) form;
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		if(request.getAttribute("debtId")!=null)
			aima0102MForm.setDebtMain(new DebtManager().getBean(Integer.parseInt(request.getAttribute("debtId").toString())));
		else
			aima0102MForm.setDebtMain(new DebtManager().getBean(aima0102MForm.getDebtId()));
		
		BigDecimal advanceAmount = aima0102MForm.getAdvanceAmount();//提前買回本金
		Date advanceDate = aima0102MForm.getAdvanceDate();//提前買回日期
		BigDecimal advanceRate = aima0102MForm.getAdvanceRate();//提前買回最低得標利率
		BigDecimal issueAmount = aima0102MForm.getDebtMain().getIssueAmount();//買回總面額
		BigDecimal issueRate = aima0102MForm.getDebtMain().getIssue().getAverageRate();//票面利率
		Date repayDate = new PayManager().getMaxDateByDebt(aima0102MForm.getDebtMain().getId());//上一期還款日
		List planList = (List)run.query(nextRepayDateSQL(aima0102MForm.getDebtMain().getId(),repayDate), new MapListHandler());
		Map planMapData = (Map)planList.get(0);
		Date nextRepayDate = (Date)planMapData.get("repay_Date");//下一期還款日
		if(null == repayDate || "".equals(repayDate))
			repayDate = aima0102MForm.getIssueDate();
		BigDecimal advanceInterest = new BigDecimal(0);//應計利息
		BigDecimal buyPremium = new BigDecimal(0);//買回溢折價
		BigDecimal buyAmount = new BigDecimal(0);//買回價款
		BigDecimal advanceTax =  new BigDecimal(0);//應扣稅款
		BigDecimal finalAmount =  new BigDecimal(0);//稅後買進金額
		int interestAlternate = Integer.parseInt(aima0102MForm.getIssueMain().getInterestAlternate().toString());//償付利息期次N
		int interestSerial = 0;//已償付最大利息期次n
		//取得已償付最大利息期次
		List paymentMainList = new PayManager().getListByDebt(aima0102MForm.getDebtMain().getId());
		BigDecimal advanceCapitalAmount = new BigDecimal(0);//已償付本付
		for(Iterator it = paymentMainList.iterator();it.hasNext();)
		{
			PaymentMain paymentMain = (PaymentMain)it.next();
			if(null != paymentMain && null != paymentMain.getInterestSerial())
			{
				if(0 == interestSerial)
					interestSerial = Integer.parseInt(paymentMain.getInterestSerial());
				else {
					if(Integer.parseInt(paymentMain.getInterestSerial()) > interestSerial)
						interestSerial = Integer.parseInt(paymentMain.getInterestSerial());
				}
			}
			if(null != paymentMain && null != paymentMain.getCapitalAmount())
				advanceCapitalAmount = advanceCapitalAmount.add(paymentMain.getCapitalAmount());
		}
		if(issueAmount.compareTo(advanceCapitalAmount.add(advanceAmount)) < 0){
			setAlertMessage(request, "已付數已超過票面總額，請確認!!");
			throw new Exception("AIMA0105 ERROE");	
		}			
		int serial = interestAlternate-interestSerial;//剩餘償付期次
		BigDecimal d = new BigDecimal(DateUtil.getDays(repayDate,nextRepayDate));//D
		if(d.compareTo(new BigDecimal(0)) == 0)
			d = new BigDecimal(1);
		BigDecimal d1 = new BigDecimal(DateUtil.getDays(advanceDate,nextRepayDate));//D1
		BigDecimal calDate = d1.divide(d,9,BigDecimal.ROUND_HALF_EVEN);//D1/D
		advanceRate = new BigDecimal(1).add(advanceRate.divide(new BigDecimal(100)));//1+最低得標利率
		double advanceRateDouble = Double.valueOf(advanceRate.toString());
		
		/**
		 * 公債提前買回計算公式
		 * 
		 * N：發行或剩餘流通年數(小數點後無條件進位至整數)
		 * D：上一期付息日至下一期付息日之實際天數(計首不計尾)
		 * D1：公債買回日至下一期付息日之實際天數，1<=D1<=D(計首不計尾)
		 */
		
		//應計利息(advanceInterest) = 得標面額*票面利率*(1-D1/D)
		advanceInterest = (advanceAmount.multiply(issueRate.divide(new BigDecimal(100)))).multiply(new BigDecimal(1).subtract(calDate));
		advanceInterest = advanceInterest.setScale(0,BigDecimal.ROUND_HALF_EVEN);
		
		//買回價款(buyAmount) = NΣn=1 ((得標面額*票面利率)/((1+最低得標利率)^(n-1+D1/D)))+得標面額/((1+最低得標利率)^(N-1+D1/D))
		BigDecimal sigma = new BigDecimal(0);
		for(int i=0; i<serial; i++)
		{
			//(得標面額*票面利率)
			BigDecimal cal1 = advanceAmount.multiply(issueRate.divide(new BigDecimal(100)));
			//((1+最低得標利率)^(n-1+D1/D)))
			double sqrt = i+Double.valueOf(calDate.toString());
			BigDecimal cal2 = new BigDecimal(java.lang.Math.pow(advanceRateDouble,sqrt));
			sigma = sigma.add(cal1.divide(cal2,9,BigDecimal.ROUND_HALF_EVEN));
		}
		//得標面額/((1+最低得標利率)^(N-1+D1/D))
		double sqrt = (serial-1)+Double.valueOf(calDate.toString());
		BigDecimal cal3 = advanceAmount.divide(new BigDecimal(java.lang.Math.pow(advanceRateDouble,sqrt)),9,BigDecimal.ROUND_HALF_EVEN);
		buyAmount = sigma.add(cal3);
		buyAmount = buyAmount.setScale(0,BigDecimal.ROUND_HALF_EVEN);
		
		//應扣稅款(advanceTax) = 應計利息*10%
		advanceTax = advanceInterest.multiply(new BigDecimal(10).divide(new BigDecimal(100)));
		advanceTax = advanceTax.setScale(0,BigDecimal.ROUND_HALF_EVEN);
		
		//稅後買進金額(finalAmount) = 買回價款-應扣稅款
		finalAmount = buyAmount.subtract(advanceTax);
		
		//買回溢折價(buyPremium) = 買回價款-得標面額-應計利息
		buyPremium = buyAmount.subtract(advanceAmount).subtract(advanceInterest);

		if(advanceInterest.compareTo(new BigDecimal(0)) < 0){
			setAlertMessage(request, "[應計利息]將為負數，請確認!!");
			throw new Exception("AIMA0105 ERROE");	
		}		
		if(advanceInterest.compareTo(new BigDecimal(0)) < 0){
			setAlertMessage(request, "[買回價款]將為負數，請確認!!");
			throw new Exception("AIMA0105 ERROE");	
		}		
		if(advanceInterest.compareTo(new BigDecimal(0)) < 0){
			setAlertMessage(request, "[應扣稅款]將為負數，請確認!!");
			throw new Exception("AIMA0105 ERROE");	
		}		
		if(advanceInterest.compareTo(new BigDecimal(0)) < 0){
			setAlertMessage(request, "[稅後買進金額]將為負數，請確認!!");
			throw new Exception("AIMA0105 ERROE");	
		}		
		aima0102MForm.setAdvanceInterest(advanceInterest);
		aima0102MForm.setBuyAmount(buyAmount);
		aima0102MForm.setAdvanceTax(advanceTax);
		aima0102MForm.setFinalAmount(finalAmount);
		aima0102MForm.setBuyPremium(buyPremium);
	}
	
	protected SQLJob nextRepayDateSQL(Integer debtId, Date repayDate){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select top 1 * from debt_plan_det ");
		sqljob.appendSQL("where 1=1 ");
		sqljob.appendSQLCondition("debt_id = ? ");
		sqljob.addParameter(debtId);
		sqljob.appendSQLCondition("capital_serial <> 1");
		if(null != repayDate && !"".equals(repayDate)) {
			sqljob.appendSQLCondition("repay_Date > ? ");
			sqljob.addParameter(repayDate);
		}
		sqljob.appendSQL("order by repay_Date");
		return sqljob;
	}

}
