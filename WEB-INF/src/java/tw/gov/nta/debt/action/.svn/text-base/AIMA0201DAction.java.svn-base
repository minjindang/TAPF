package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0201MForm;
import tw.gov.nta.sql.debt.IssueMain;

public class AIMA0201DAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//get FormBean
		Aima0201MForm aima0201MForm = (Aima0201MForm) form;
		//get IssueMain
		IssueMain tIssueMain = aima0201MForm.getIssueMain();
		//get IssueMain.id
		int pIssueId = tIssueMain.getId().intValue();
		//do cancel
		try{
			new IssueManager().cancel(pIssueId);
			setAlertMessage(request,Messages.SUCCESS_DELETE);
		}
		catch(Exception e){
			request.setAttribute("sourceIssueMain",new IssueManager().getBean(aima0201MForm.getSourceIssueId()));
			setAlertMessage(request,Messages.FAILURE_DELETE);
			throw new Exception("Failure Delete");
		}
		

	}
}
