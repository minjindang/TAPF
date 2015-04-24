package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0201MForm;
import tw.gov.nta.sql.debt.IssueMain;

public class AIMA0201MAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//get FormBean
		Aima0201MForm aima0201MForm = (Aima0201MForm) form;
		//get IssueMain
		IssueMain tIssueMain = aima0201MForm.getIssueMain();
		tIssueMain.setDebtType("A");
		tIssueMain.setBondKind("3");
		tIssueMain.setPayableInterestAmount(aima0201MForm.getRepayInterestAmount());
		//do confirm
		try{
			new IssueManager().checkAndUpdate(tIssueMain);
			setAlertMessage(request, Messages.SUCCESS_MODIFY);
		}
		catch(Exception e){
			request.setAttribute("sourceIssueMain",new IssueManager().getBean(aima0201MForm.getSourceIssueId()));
			System.out.println(e);
			setAlertMessage(request, Messages.FAILURE_MODIFY);
		}
	}
}
