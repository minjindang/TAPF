package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.debt.form.Aima0203MForm;

public class AIMA0203L extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0203MForm aima0203MForm = (Aima0203MForm) form;
		List tIssueTicketList = new TicketManager().getBeanByIssue(aima0203MForm.getIssueMainId());
		request.setAttribute("collection", tIssueTicketList);
	}
}
