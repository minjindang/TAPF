package tw.gov.nta.debt.action;

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
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Aima0102MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;
import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.Messages;

public class AIMA0105AAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {	
		Aima0102MForm aima0102MForm = (Aima0102MForm) form;
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		if(request.getAttribute("debtId")!=null)
			aima0102MForm.setDebtMain(new DebtManager().getBean(Integer.parseInt(request.getAttribute("debtId").toString())));
		else
			aima0102MForm.setDebtMain(new DebtManager().getBean(aima0102MForm.getDebtId()));
		
		BigDecimal advanceAmount = aima0102MForm.getAdvanceAmount();//���e�R�^����
		Date advanceDate = aima0102MForm.getAdvanceDate();//���e�R�^���
		BigDecimal advanceRate = aima0102MForm.getAdvanceRate();//���e�R�^�̧C�o�ЧQ�v
		BigDecimal issueAmount = aima0102MForm.getDebtMain().getIssueAmount();//�R�^�`���B
		BigDecimal issueRate = aima0102MForm.getDebtMain().getIssue().getAverageRate();//�����Q�v
		Date repayDate = new PayManager().getMaxDateByDebt(aima0102MForm.getDebtMain().getId());//�W�@���ٴڤ�
		List planList = (List)run.query(nextRepayDateSQL(aima0102MForm.getDebtMain().getId(),repayDate), new MapListHandler());
		Map planMapData = (Map)planList.get(0);
		Date nextRepayDate = (Date)planMapData.get("repay_Date");//�U�@���ٴڤ�
		if(null == repayDate || "".equals(repayDate))
			repayDate = aima0102MForm.getIssueDate();
//		BigDecimal advanceInterest = new BigDecimal(0);//���p�Q��
//		BigDecimal buyPremium = new BigDecimal(0);//�R�^�����
//		BigDecimal buyAmount = new BigDecimal(0);//�R�^����
//		BigDecimal advanceTax =  new BigDecimal(0);//�����|��
//		BigDecimal finalAmount =  new BigDecimal(0);//�|��R�i���B
		int interestAlternate = Integer.parseInt(aima0102MForm.getIssueMain().getInterestAlternate().toString());//�v�I�Q������N
		int interestSerial = 0;//�w�v�I�̤j�Q������n
//		//���o�w�v�I�̤j�Q������
		List paymentMainList = new PayManager().getListByDebt(aima0102MForm.getDebtMain().getId());
//		BigDecimal advanceCapitalAmount = new BigDecimal(0);//�w�v�I���I
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
//			if(null != paymentMain && null != paymentMain.getCapitalAmount())
//				advanceCapitalAmount = advanceCapitalAmount.add(paymentMain.getCapitalAmount());
		}
//		if(issueAmount.compareTo(advanceCapitalAmount.add(advanceAmount)) < 0){
//			setAlertMessage(request, "�w�I�Ƥw�W�L�����`�B�A�нT�{!!");
//			throw new Exception("AIMA0105 ERROE");	
//		}			
		int serial = interestAlternate-interestSerial;//�Ѿl�v�I����
		BigDecimal d = new BigDecimal(DateUtil.getDays(repayDate,nextRepayDate));//D
		if(d.compareTo(new BigDecimal(0)) == 0)
			d = new BigDecimal(1);
		BigDecimal d1 = new BigDecimal(DateUtil.getDays(advanceDate,nextRepayDate));//D1
		BigDecimal calDate = d1.divide(d,9,BigDecimal.ROUND_HALF_EVEN);//D1/D
//		advanceRate = new BigDecimal(1).add(advanceRate.divide(new BigDecimal(100)));//1+�̧C�o�ЧQ�v
		double advanceRateDouble = Double.valueOf(advanceRate.toString());
//		
//		/**
//		 * ���Ŵ��e�R�^�p�⤽��
//		 * 
//		 * N�G�o��γѾl�y�q�~��(�p���I��L����i��ܾ��)
//		 * D�G�W�@���I����ܤU�@���I���餧��ڤѼ�(�p�����p��)
//		 * D1�G���ŶR�^��ܤU�@���I���餧��ڤѼơA1<=D1<=D(�p�����p��)
//		 */
//		
//		//���p�Q��(advanceInterest) = �o�Э��B*�����Q�v*(1-D1/D)
//		advanceInterest = (advanceAmount.multiply(issueRate.divide(new BigDecimal(100)))).multiply(new BigDecimal(1).subtract(calDate));
//		advanceInterest = advanceInterest.setScale(0,BigDecimal.ROUND_HALF_EVEN);
//		
//		//�R�^����(buyAmount) = N�Un=1 ((�o�Э��B*�����Q�v)/((1+�̧C�o�ЧQ�v)^(n-1+D1/D)))+�o�Э��B/((1+�̧C�o�ЧQ�v)^(N-1+D1/D))
//		//�R�^�Q����{(sigma)
		BigDecimal sigma = new BigDecimal(0);
		//�R�^�����Q��(buyInterest)
		BigDecimal buyInterest = new BigDecimal(0);
		for(int i=0; i<serial; i++)
		{
			//(�o�Э��B*�����Q�v)
			BigDecimal cal1 = advanceAmount.multiply(issueRate.divide(new BigDecimal(100)));
			//((1+�̧C�o�ЧQ�v)^(n-1+D1/D)))
			double sqrt = i+Double.valueOf(calDate.toString());
			BigDecimal cal2 = new BigDecimal(java.lang.Math.pow(advanceRateDouble,sqrt));
			sigma = sigma.add(cal1.divide(cal2,9,BigDecimal.ROUND_HALF_EVEN));
			buyInterest = buyInterest.add(cal1);
		}
//		//�R�^������{(cal3)
//		//�o�Э��B/((1+�̧C�o�ЧQ�v)^(N-1+D1/D))
//		double sqrt = (serial-1)+Double.valueOf(calDate.toString());
//		BigDecimal cal3 = advanceAmount.divide(new BigDecimal(java.lang.Math.pow(advanceRateDouble,sqrt)),9,BigDecimal.ROUND_HALF_EVEN);
//		buyAmount = sigma.add(cal3);
//		buyAmount = buyAmount.setScale(0,BigDecimal.ROUND_HALF_EVEN);
//		
//		//�����|��(advanceTax) = ���p�Q��*10%
//		advanceTax = advanceInterest.multiply(new BigDecimal(10).divide(new BigDecimal(100)));
//		advanceTax = advanceTax.setScale(0,BigDecimal.ROUND_HALF_EVEN);
//		
//		//�|��R�i���B(finalAmount) = �R�^����-�����|��
//		finalAmount = buyAmount.subtract(advanceTax);
//		
//		//�R�^�����(buyPremium) = �R�^����-�o�Э��B-���p�Q��
//		buyPremium = buyAmount.subtract(advanceAmount).subtract(advanceInterest);
//
//		if(advanceInterest.compareTo(new BigDecimal(0)) < 0){
//			setAlertMessage(request, "[���p�Q��]�N���t�ơA�нT�{!!");
//			throw new Exception("AIMA0105 ERROE");	
//		}		
//		if(advanceInterest.compareTo(new BigDecimal(0)) < 0){
//			setAlertMessage(request, "[�R�^����]�N���t�ơA�нT�{!!");
//			throw new Exception("AIMA0105 ERROE");	
//		}		
//		if(advanceInterest.compareTo(new BigDecimal(0)) < 0){
//			setAlertMessage(request, "[�����|��]�N���t�ơA�нT�{!!");
//			throw new Exception("AIMA0105 ERROE");	
//		}		
//		if(advanceInterest.compareTo(new BigDecimal(0)) < 0){
//			setAlertMessage(request, "[�|��R�i���B]�N���t�ơA�нT�{!!");
//			throw new Exception("AIMA0105 ERROE");	
//		}		
//		aima0102MForm.setAdvanceInterest(advanceInterest);
//		aima0102MForm.setBuyAmount(buyAmount);
//		aima0102MForm.setAdvanceTax(advanceTax);
//		aima0102MForm.setFinalAmount(finalAmount);
//		aima0102MForm.setBuyPremium(buyPremium);
		
		//�N���e�v�I�g�J�٥��I����
		PaymentMain paymentMain = new PaymentMain();
		List paymentList = new PayManager().getListByDebt(aima0102MForm.getDebtId());
		String capitalSerial = "1";
		if(null!= paymentList && paymentList.size() > 1){
			for(Iterator it = paymentList.iterator();it.hasNext();)
			{
				PaymentMain paymentData = (PaymentMain)it.next();
				if(!"0".equals(paymentData.getCapitalSerial()))
					capitalSerial = String.valueOf(Integer.parseInt(paymentData.getCapitalSerial().trim())+1);
			}
		}
		
		paymentMain.setIssueId(aima0102MForm.getDebtMain().getIssue().getId());
		paymentMain.setDebtId(aima0102MForm.getDebtMain().getId());
		
		DebtPlanDet debtPlanDet = new DebtPlanDet();
		planList = new PlanManager().getAllPlanListByDebtNotDelete(aima0102MForm.getDebtMain());
		for(Iterator it = planList.iterator();it.hasNext();)
		{
			DebtPlanDet planData = (DebtPlanDet)it.next();
			if(null != planData.getCapitalAmount() && planData.getCapitalAmount().compareTo(new BigDecimal(0)) > 0)
				debtPlanDet = planData;
		}

		paymentMain.setPlan(debtPlanDet);
		paymentMain.setRepayDate(aima0102MForm.getAdvanceDate());
		paymentMain.setCapitalAmount(aima0102MForm.getAdvanceAmount());
		paymentMain.setInterestAmount(aima0102MForm.getAdvanceInterest().add(aima0102MForm.getBuyPremium()));
		paymentMain.setCapitalSerial(capitalSerial);
		paymentMain.setInterestSerial(String.valueOf(interestSerial));
		paymentMain.setPlanRepayDate(debtPlanDet.getRepayDate());
		paymentMain.setInterestDays(DateUtil.getDays(advanceDate,nextRepayDate));
		paymentMain.setBalanceCapitalAmount(aima0102MForm.getDebtMain().getIssueAmount());
		paymentMain.setAverageRate(aima0102MForm.getAdvanceRate());
		paymentMain.setBuyStatus("0");
		paymentMain.setUserid(this.getUserId(request));
		paymentMain.setModDate(new Date());
		paymentMain.setStartDate(aima0102MForm.getAdvanceDate());
		paymentMain.setEndDate(nextRepayDate);
//		paymentMain.setAdvanceTax(advanceInterest);
		paymentMain.setAdvanceTax(aima0102MForm.getAdvanceInterest());
		paymentMain.setRepayType("0");
//		paymentMain.setBuyAmount(buyAmount);
		paymentMain.setBuyAmount(aima0102MForm.getBuyAmount());
		paymentMain.setBuyPremium(aima0102MForm.getBuyPremium());
		paymentMain.setBuyInterest(buyInterest);
		PaymentMainDAO paymentMainDAO = new PaymentMainDAO();
		Integer paymentId = paymentMainDAO.save(paymentMain);
		
		//��s�ٴڭp�eDebtPlanDet
		IssueManager issueManager = new IssueManager();
		DebtMain debtMain = new DebtManager().getBean(aima0102MForm.getDebtId());
		issueManager.advancePayment(debtMain,advanceAmount,advanceDate);
		
		planList = new PlanManager().getAllPlanListByDebtNotDelete(aima0102MForm.getDebtMain());
		BigDecimal planInterestAmount = new BigDecimal(0);
		BigDecimal originInterestAmount = new BigDecimal(0);
		for(Iterator it = planList.iterator();it.hasNext();)
		{
			DebtPlanDet planData = (DebtPlanDet)it.next();
			planInterestAmount = planInterestAmount.add(planData.getInterestAmount());
			originInterestAmount = originInterestAmount.add(planData.getOriginInterestAmount());
		}
		BigDecimal manageInterestAmount = new BigDecimal(0);
		if(null != aima0102MForm.getDebtMain().getOriginInterestAmount() && !"".equals(aima0102MForm.getDebtMain().getOriginInterestAmount()))
			manageInterestAmount = aima0102MForm.getDebtMain().getOriginInterestAmount().subtract(planInterestAmount);
		BigDecimal manageCapitalAmount = planInterestAmount.subtract(originInterestAmount);
		paymentMain.setId(paymentId);
		paymentMain.setManageInterestAmount(manageInterestAmount);
		paymentMain.setManageCapitalAmount(manageCapitalAmount);
		paymentMainDAO.saveOrUpdate(paymentMain);

		List listPayment = (List) run.query(sqlPayment(aima0102MForm.getDebtId().toString(),request), new MapListHandler());

		for(Iterator it = listPayment.iterator();it.hasNext();){
			Map map = (Map)it.next();
			run.update(connection,insertDebtPlanDet(map));
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("select max(id) as plan_id from DEBT_PLAN_DET where issue_id = ?");
			sqljob.addParameter(map.get("ISSUE_ID"));
			List planListMaxID = (List)run.query(sqljob, new MapListHandler());
			for(Iterator it1 = planListMaxID.iterator();it1.hasNext();){
				Map map1 = (Map)it1.next();
				SQLJob sqljob1 = new SQLJob();
				sqljob1.appendSQL("update PAYMENT_MAIN set plan_id = ? where id = ?");
				sqljob1.addParameter(map1.get("plan_id"));
				sqljob1.addParameter(paymentId);
				run.update(connection,sqljob1);
				sqljob1 = new SQLJob();
				sqljob1.appendSQL("update ISSUE_MAIN set CAPITAL_AMOUNT = ? where id = ?");
				sqljob1.addParameter(map.get("CAPITAL_AMOUNT"));
				sqljob1.addParameter(map.get("ISSUE_ID"));
				run.update(connection,sqljob1);
			}
		}
		setAlertMessage(request,"�s�W���\!!");
	}
	//�d�ߥXdebt_id�U�A�Ҧ����e�v�I����ơA�n�g�^debt_plan_det��
	protected SQLJob sqlPayment(String debtId, HttpServletRequest request){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("SELECT ISSUE_ID, DEBT_ID, PLAN_REPAY_DATE, CAPITAL_AMOUNT, INTEREST_AMOUNT, ");
		sqljob.appendSQL("(CAPITAL_AMOUNT + INTEREST_AMOUNT) * (SELECT I.AVERAGE_RATE FROM ISSUE_MAIN I WHERE I.ID = ISSUE_ID) as CHARGE_AMOUNT, ");
		sqljob.appendSQL("CAPITAL_SERIAL, INTEREST_SERIAL, ? as USERID, ? as MOD_DATE, 'N' as DELETE_MARK, 0 as ORIGIN_INTEREST_AMOUNT, ");
		sqljob.appendSQL("(SELECT P.RATE_GROUP_ID FROM DEBT_PLAN_DET P WHERE P.ID = PLAN_ID) as RATE_GROUP_ID ");
		sqljob.appendSQL("FROM PAYMENT_MAIN ");
		sqljob.appendSQL("WHERE DEBT_ID = ? ");
		sqljob.appendSQL("and REPAY_DATE <> PLAN_REPAY_DATE ");
		sqljob.appendSQL("and CAPITAL_AMOUNT > 0 ");
		
		sqljob.addParameter(this.getUserId(request));
		sqljob.addParameter(new Date());
		sqljob.addParameter(debtId);
		
//		System.out.println(sqljob.toString());
		return sqljob;
	}
	//�N���e�R�^��Ƽg�^debt_plan_det
	protected SQLJob insertDebtPlanDet(Map map)
	{
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("INSERT INTO DEBT_PLAN_DET (ISSUE_ID, DEBT_ID, REPAY_DATE, CAPITAL_AMOUNT, INTEREST_AMOUNT, CHARGE_AMOUNT, ");
		sqljob.appendSQL("CAPITAL_SERIAL, INTEREST_SERIAL, USERID, MOD_DATE, DELETE_MARK, ORIGIN_INTEREST_AMOUNT, RATE_GROUP_ID) ");
		sqljob.appendSQL("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		sqljob.addParameter(map.get("ISSUE_ID"));
		sqljob.addParameter(map.get("DEBT_ID"));
		sqljob.addParameter(map.get("PLAN_REPAY_DATE"));
		sqljob.addParameter(map.get("CAPITAL_AMOUNT"));
		sqljob.addParameter(map.get("INTEREST_AMOUNT"));
		sqljob.addParameter(map.get("CHARGE_AMOUNT"));
		sqljob.addParameter(map.get("CAPITAL_SERIAL"));
		sqljob.addParameter(map.get("INTEREST_SERIAL"));
		sqljob.addParameter(map.get("USERID"));
		sqljob.addParameter(map.get("MOD_DATE"));
		sqljob.addParameter(map.get("DELETE_MARK"));
		sqljob.addParameter(map.get("ORIGIN_INTEREST_AMOUNT"));
		sqljob.addParameter(map.get("RATE_GROUP_ID"));
		
		return sqljob;
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
