package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Aima0202MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;

public class AIMA0202AAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0202MForm aima0202MForm = (Aima0202MForm) form;
		DebtMain tDebtMain = aima0202MForm.getDebtMain();
		IssueMain tIssueMain = new IssueManager().getBean(aima0202MForm.getIssueMainId());
		tDebtMain.setIssue(tIssueMain);

		try{
			tDebtMain.setId(null);
			BigDecimal payableInterestAmount = new BigDecimal("0");
			payableInterestAmount = tIssueMain.getPayableInterestAmount().multiply(tDebtMain.getIssueAmount().divide(tIssueMain.getIssueAmount(),3,BigDecimal.ROUND_HALF_EVEN));
//			tDebtMain.setPayableInterestAmount(tIssueMain.getPayableInterestAmount());
			tDebtMain.setPayableInterestAmount(payableInterestAmount.setScale(0,BigDecimal.ROUND_HALF_UP));
			tDebtMain.setDiversityAmount(aima0202MForm.getDiversityAmount());
			tDebtMain.setOriginInterestAmount(tDebtMain.getIssueAmount().multiply(new BigDecimal(tIssueMain.getIssueInterval())).multiply(tIssueMain.getAverageRate().divide(new BigDecimal(100))));
			new DebtManager().confirm(tDebtMain);
			RateManager tRateManager = new RateManager();
			
			DebtRateDet tDebtRateDet = tRateManager.createBean(tDebtMain.getId().intValue());
				
			tDebtRateDet.setEffectiveDate(tIssueMain.getIssueDate());
			tDebtRateDet.setSuspendDate(tIssueMain.getDueDate());
			tDebtRateDet.setDebtRate(tIssueMain.getAverageRate());
			tDebtRateDet.setDeleteMark("N");
			tRateManager.confirm(tDebtRateDet);
			tDebtRateDet = (DebtRateDet) tRateManager.getBean(tDebtRateDet.getId().intValue());
			PlanManager tPlanManager = new PlanManager();
			tPlanManager.buildPlan(tDebtMain,tIssueMain.getIssueDate(),tIssueMain.getFinishDate());
			setAlertMessage(request,Messages.SUCCESS_ADD);
			request.setAttribute("debtId",tDebtMain.getId());
		}
		catch(Exception e){
			setAlertMessage(request,Messages.FAILURE_ADD);
			throw new Exception(Messages.FAILURE_ADD);
		}
		
	}
	
//	private Collection generatePlanByIssueMain(IssueMain pIssueMain, DebtMain pDebtMain, DebtRateDet pDebtRateDet){
//		PlanManager tPlanManager = new PlanManager();
//		//付息間距
//		int tRepayInterestInterval = pIssueMain.getIssueInterval().intValue() * 12 / pIssueMain.getInterestAlternate().intValue();
//		//還本間距
//		int tRepayCapitalInterval = pIssueMain.getIssueInterval().intValue() * 12 / pIssueMain.getInterestAlternate().intValue();
//		HashMap tMap = new HashMap();
//		Calendar tCalendar = Calendar.getInstance();
//		tCalendar.setTime(pIssueMain.getIssueDate());
//		DebtPlanDet tDebtPlanDet = null;
//		InterestAdjustManager tInterestAdjustManager = new InterestAdjustManager();
//		//計算利息
//		for(int i = 0 ; i < pIssueMain.getInterestAlternate().intValue() ; i++){
//			tCalendar.roll(Calendar.MONTH, tRepayInterestInterval);
//			tDebtPlanDet = tPlanManager.createBean(pDebtMain.getId().intValue());
//			tDebtPlanDet.setIssueId(pIssueMain.getId());
//			tDebtPlanDet.setRepayDate(tCalendar.getTime());
//			tDebtPlanDet.setInterestAmount(tInterestAdjustManager.countInterestAdjust(pDebtMain.getId().intValue(), pDebtRateDet.getGroupId().intValue(), 0).setScale(4, 5));
//			tDebtPlanDet.setInterestSerial(i);
//			tMap.put(tCalendar.getTime(), tDebtPlanDet);
//		}
//		tCalendar.setTime(pIssueMain.getIssueDate());//還原日期
//		//計算本金
//		for(int i = 0 ; i < pIssueMain.getRepayAlternate().intValue() ; i++){
//			tCalendar.roll(Calendar.MONTH, tRepayCapitalInterval);
//			tDebtPlanDet = (DebtPlanDet) tMap.get(tCalendar.getTime());
//			if(tDebtPlanDet == null){
//				tDebtPlanDet = tPlanManager.createBean(pDebtMain.getId().intValue());
//				tDebtPlanDet.setIssueId(pIssueMain.getId());
//				tDebtPlanDet.setRepayDate(tCalendar.getTime());
//				tMap.put(tCalendar.getTime(), tDebtPlanDet);
//			}
//			tDebtPlanDet.setCapitalAmount((pDebtMain.getIssueAmount()!= null)?pDebtMain.getIssueAmount().divide(new BigDecimal(pIssueMain.getRepayAlternate().intValue()), 4, 5):new BigDecimal(0));
//			tDebtPlanDet.setCapitalSerial(i);
//		}
//		return tMap.values();
//	}
}
