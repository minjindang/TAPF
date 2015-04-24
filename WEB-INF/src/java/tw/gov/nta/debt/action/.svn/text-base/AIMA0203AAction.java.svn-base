package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.debt.form.Aima0203MForm;
import tw.gov.nta.sql.debt.IssueTicketDet;

public class AIMA0203AAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0203MForm aima0203MForm = (Aima0203MForm) form;
		IssueTicketDet tIssueTicketDet = aima0203MForm.getIssueTicketDet();
		tIssueTicketDet.setIssue(new IssueManager().getBean(aima0203MForm.getIssueMainId()));
		tIssueTicketDet.setId(null);
		try{
			new TicketManager().confirm(tIssueTicketDet);
			setAlertMessage(request,Messages.SUCCESS_ADD);
			request.setAttribute("ticketDetId",tIssueTicketDet.getId());
			form = aima0203MForm;
		}
		catch(Exception e){
			setAlertMessage(request,Messages.FAILURE_ADD);
			throw new Exception("");
		}
	}
}
