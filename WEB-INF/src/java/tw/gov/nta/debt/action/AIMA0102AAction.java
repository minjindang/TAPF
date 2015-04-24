package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Aima0102MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;

public class AIMA0102AAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0102MForm aima0102MForm = (Aima0102MForm) form;
		DebtMain tDebtMain = aima0102MForm.getDebtMain();
		IssueMain tIssueMain = aima0102MForm.getIssueMain();
		tDebtMain.setIssue(tIssueMain);

		try{
			tDebtMain.setId(null);
			tDebtMain.setPayableInterestAmount(tIssueMain.getPayableInterestAmount());
			tDebtMain.setOriginInterestAmount(tDebtMain.getIssueAmount().multiply(new BigDecimal(tIssueMain.getIssueInterval())).multiply(tIssueMain.getAverageRate().divide(new BigDecimal(100))));
			new DebtManager().confirm(tDebtMain);
			RateManager tRateManager = new RateManager();
			DebtRateDet tDebtRateDet = tRateManager.createBean(tDebtMain.getId().intValue());
			tDebtRateDet.setEffectiveDate(tIssueMain.getIssueDate());
			tDebtRateDet.setSuspendDate(tIssueMain.getFinishDate());
			tDebtRateDet.setDebtRate(tIssueMain.getAverageRate());
			tDebtRateDet.setDeleteMark("N");
			tRateManager.confirm(tDebtRateDet);
			tDebtRateDet = (DebtRateDet) tRateManager.getBean(tDebtRateDet.getId().intValue());
			PlanManager tPlanManager = new PlanManager();
			tPlanManager.buildPlan(tDebtMain,tIssueMain.getIssueDate(),tIssueMain.getFinishDate());
			List tPlanList = tPlanManager.byDebtId(tDebtMain.getId());
			BigDecimal interestAmount = new BigDecimal(0);
			for(Iterator it = tPlanList.iterator();it.hasNext();){
				DebtPlanDet tPlanDet = (DebtPlanDet)it.next();
				interestAmount = interestAmount.add(tPlanDet.getInterestAmount());
			}
			tDebtMain.setOriginInterestAmount(interestAmount);
			new DebtManager().confirm(tDebtMain);
			setAlertMessage(request,Messages.SUCCESS_ADD);
			request.setAttribute("debtId",tDebtMain.getId());
		}
		catch(Exception e){
			System.out.println(e);
			setAlertMessage(request,Messages.FAILURE_ADD);
			throw new Exception(Messages.FAILURE_ADD);
		}
		
	}
}
