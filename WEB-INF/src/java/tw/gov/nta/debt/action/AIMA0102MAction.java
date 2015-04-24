package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Aima0102MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;

public class AIMA0102MAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0102MForm aima0102MForm = (Aima0102MForm) form;
		DebtMain tDebtMain = aima0102MForm.getDebtMain();
		tDebtMain.setIssue(new IssueManager().getBean(aima0102MForm.getIssueMainId()));
		tDebtMain.setDiversityAmount(aima0102MForm.getDiversityAmount());
		tDebtMain.setIssueCostAmount(aima0102MForm.getIssueCostAmount());
		DebtManager manager = new DebtManager();
//		try{
			manager.upDate(tDebtMain);
			setAlertMessage(request,Messages.SUCCESS_MODIFY);
//		}
//		catch(Exception e){
//			setAlertMessage(request,Messages.FAILURE_MODIFY);
//			throw new Exception(Messages.FAILURE_MODIFY);
//		}
		
	}
}
