package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.debt.form.Aima0103MForm;
import tw.gov.nta.sql.debt.IssueTicketDet;

public class AIMA0103AAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0103MForm aima0103MForm = (Aima0103MForm) form;
		IssueTicketDet tIssueTicketDet = aima0103MForm.getIssueTicketDet();
		tIssueTicketDet.setIssue(new IssueManager().getBean(aima0103MForm.getIssueMainId()));
		tIssueTicketDet.setId(null);
		try{
			new TicketManager().confirm(tIssueTicketDet);
			setAlertMessage(request,Messages.SUCCESS_ADD);
			request.setAttribute("ticketDetId",tIssueTicketDet.getId());
			form = aima0103MForm;
		}
		catch(Exception e){
			setAlertMessage(request,Messages.FAILURE_ADD);
			throw new Exception("");
		}
	}
}
