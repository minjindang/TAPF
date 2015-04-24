package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara4201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA4201 extends ExcelReportBaseAction  {
	private final static String TEMP_TABLE_NAME = "GARA42_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA42_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL(Gara4201Form myForm){
		SQLJob sqljob = new SQLJob();
		Integer year = Integer.valueOf(myForm.getAccountYear()) + 1911;
		
		sqljob.appendSQL("select i.id, ");
		sqljob.appendSQL("i.debt_short_name, ");
		sqljob.appendSQL("(i.issue_amount - (select sum(dpd2.capital_amount) " +
				"from debt_plan_det dpd2 where d.id = dpd2.debt_id and year(dpd2.repay_date) < ?)) as issue_amount, ");
		sqljob.addParameter(year);
		sqljob.appendSQL("max(dpd.repay_date) as repay_date, ");
		sqljob.appendSQL("dpd.capital_amount as capital_amount, ");
		sqljob.appendSQL("(i.issue_amount - isnull((select sum(capital_amount) " +
				"from payment_main where issue_id = i.id and repay_date <= r.effective_date), 0)) as remain_amount, ");
		sqljob.appendSQL("r.effective_date, ");
		sqljob.appendSQL("r.suspend_date, ");
		sqljob.appendSQL("datediff(day,r.effective_date,r.suspend_date) as interest_days, ");
		sqljob.appendSQL("r.debt_rate ");
		sqljob.appendSQL("from issue_main i, debt_main d, debt_rate_det r, debt_plan_det dpd ");
		sqljob.appendSQL("where i.id = d.issue_id ");
		sqljob.appendSQLCondition("d.id = r.debt_id ");
		sqljob.appendSQLCondition("i.id = dpd.issue_id ");
		sqljob.appendSQLCondition("d.id = dpd.debt_id ");
		sqljob.appendSQLCondition("i.debt_type ='F' ");
		sqljob.appendSQLCondition("i.account_year = '096' ");
//		sqljob.appendSQLCondition("r.delete_mark <> 'Y' ");
		if (year != 2008)
		{
			sqljob.appendSQLCondition("r.suspend_date > (select repay_date from payment_main where d.id = debt_id and year(repay_date) = ?) ");
			sqljob.addParameter(year-1);
		} else {
			sqljob.appendSQLCondition("r.suspend_date >= (select repay_date from payment_main where d.id = debt_id and year(repay_date) = ?) ");
			sqljob.addParameter(year-1);
		}
		sqljob.appendSQLCondition("r.suspend_date <= (select repay_date from payment_main where d.id = debt_id and year(repay_date) = ?) ");
		sqljob.addParameter(year);
		sqljob.appendSQLCondition("year(dpd.repay_date) = ? ");
		sqljob.addParameter(year);
		sqljob.appendSQL("group by i.id, i.debt_short_name, dpd.capital_amount,r.effective_date, r.suspend_date,i.issue_amount,d.id,r.debt_rate");
		
		System.out.println(sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );	
		Gara4201Form myForm = (Gara4201Form) form;
		
		SQLJob sqljob = SQL((Gara4201Form)form);
		List tList = (List) run.query(sqljob, new MapListHandler());
		Map tMap = null;
		Integer issueId = null; 
		BigDecimal capitalAmount = new BigDecimal(0);
		BigDecimal totInterestAmount = new BigDecimal(0);
		BigDecimal totCapital = new BigDecimal(0);
		BigDecimal totInterest = new BigDecimal(0);
		BigDecimal totAmount = new BigDecimal(0);
		Date finalDate = new Date();
		int tmp = 0;//判斷是不是第一筆資料
		int leapYear = 1;//已知，096/09/21~097/07/01經過潤年，所以要用366計算
		
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			
			if (issueId == null || !issueId.equals((Integer)tMap.get("id"))) {
				if (issueId != null){
					Map dMap = new HashMap();
					dMap.put("debt_short_name","小計");
					dMap.put("interest_amount",totInterestAmount);
					dMap.put("tot_amount",capitalAmount.add(totInterestAmount));
					totAmount = totAmount.add((capitalAmount.add(totInterestAmount)));
					run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));	
				}
				issueId = (Integer)tMap.get("id");
				tmp = 0;
				leapYear = 1;
			}
			
			if (tmp == 0){
				totInterestAmount = new BigDecimal(0);
				Map dMap = new HashMap();
				dMap.put("debt_short_name",(String)tMap.get("debt_short_name"));
				dMap.put("issue_amount",(BigDecimal)tMap.get("issue_amount"));
				dMap.put("repay_date",(Date)tMap.get("repay_date"));
				finalDate = (Date)tMap.get("repay_date");
				capitalAmount = (BigDecimal)tMap.get("capital_amount");
				dMap.put("capital_amount",capitalAmount);
				totCapital = totCapital.add(capitalAmount);
				BigDecimal remainAmount = (BigDecimal)tMap.get("remain_amount");
				dMap.put("remain_amount",remainAmount);
				Date effectiveDate = (Date)tMap.get("effective_date");
				Date suspendDate = (Date)tMap.get("suspend_date");
				String betweenDate = DateUtil.date2ROCStr(effectiveDate,"yyy/MM/dd") + "~" + DateUtil.date2ROCStr(suspendDate,"yyy/MM/dd");
				dMap.put("between_date",betweenDate);
				Integer days = (Integer)tMap.get("interest_days");
				dMap.put("interest_days",days);
				Double interestDays;
				if (leapYear == 2 && "097".equals(myForm.getAccountYear())){
					interestDays = (Double.valueOf(days)/Double.valueOf(366));
					leapYear++;
				}else {
					interestDays = (Double.valueOf(days)/Double.valueOf(365));
					leapYear++;
				}
				BigDecimal debtRate = (BigDecimal)tMap.get("debt_rate");
				debtRate = debtRate.setScale(3,BigDecimal.ROUND_DOWN);
				dMap.put("debt_rate",String.valueOf(debtRate)+"%");
				BigDecimal interestAmount = new BigDecimal(0);
				//結欠本金*利率/100*天數/365
				interestAmount = (remainAmount.multiply(debtRate.divide(new BigDecimal(100)))).multiply(BigDecimal.valueOf(interestDays));
				dMap.put("interest_amount",interestAmount);
				totInterestAmount = totInterestAmount.add(interestAmount);
				totInterest = totInterest.add(interestAmount);
				tmp++;
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));	
			} else {
				Map dMap = new HashMap();
				BigDecimal remainAmount = (BigDecimal)tMap.get("remain_amount");
				dMap.put("remain_amount",remainAmount);
				Date effectiveDate = (Date)tMap.get("effective_date");
				Date suspendDate = (Date)tMap.get("suspend_date");
				String betweenDate = DateUtil.date2ROCStr(effectiveDate,"yyy/MM/dd") + "~" + DateUtil.date2ROCStr(suspendDate,"yyy/MM/dd");
				dMap.put("between_date",betweenDate);
				Integer days = (Integer)tMap.get("interest_days");
				dMap.put("interest_days",days);
				Double interestDays;
				if (leapYear == 2 && "097".equals(myForm.getAccountYear())){
					interestDays = (Double.valueOf(days)/Double.valueOf(366));
					leapYear++;
				}else {
					interestDays = (Double.valueOf(days)/Double.valueOf(365));
					leapYear++;
				}
				BigDecimal debtRate = (BigDecimal)tMap.get("debt_rate");
				debtRate = debtRate.setScale(3,BigDecimal.ROUND_DOWN);
				dMap.put("debt_rate",String.valueOf(debtRate)+"%");
				BigDecimal interestAmount = new BigDecimal(0);
				//結欠本金*利率/100*天數/365
				interestAmount = (remainAmount.multiply(debtRate.divide(new BigDecimal(100)))).multiply(BigDecimal.valueOf(interestDays));
				dMap.put("interest_amount",interestAmount);
				totInterestAmount = totInterestAmount.add(interestAmount);
				totInterest = totInterest.add(interestAmount);
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));					
			}
		}
		//最後一筆資料
		Map dMap = new HashMap();
		dMap.put("debt_short_name","小計");
		dMap.put("interest_amount",totInterestAmount);
		dMap.put("tot_amount",capitalAmount.add(totInterestAmount));
		totAmount = totAmount.add((capitalAmount.add(totInterestAmount)));
		run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
		//最後的合計
		dMap = new HashMap();
		dMap.put("debt_short_name","總計");
		dMap.put("capital_amount",totCapital);
		dMap.put("interest_amount",totInterest);
		dMap.put("tot_amount",totAmount);
		run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
		
		request.setAttribute("accountYear",myForm.getAccountYear());
		request.setAttribute("accountMonth",finalDate.getMonth()+1);
		request.setAttribute("accountFinalDate",DateUtil.date2ChineseROC2(finalDate));
	}
}
