package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.hibernate.Session;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Aima0101MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;

public class AIMA0101MAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//get FormBean
		Aima0101MForm aima0101MForm = (Aima0101MForm) form;
		//get IssueMain
		IssueMain oldIssueMain = new IssueManager().getBean(aima0101MForm.getIssueMain().getId());
		IssueMain tIssueMain = aima0101MForm.getIssueMain();
		tIssueMain.setDebtType("A");
		tIssueMain.setBondKind("1");
		//do confirm
		try{
			new IssueManager().checkAndUpdate(tIssueMain);
			setAlertMessage(request, Messages.SUCCESS_MODIFY);
		}
		catch(Exception e){
			System.out.println(e);
			setAlertMessage(request, Messages.FAILURE_MODIFY);
		}
	}
}
