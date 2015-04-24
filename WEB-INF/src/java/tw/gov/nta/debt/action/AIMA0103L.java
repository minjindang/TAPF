package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.debt.form.Aima0103MForm;

public class AIMA0103L extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0103MForm aima0103MForm = (Aima0103MForm) form;
		List tIssueTicketList = new TicketManager().getBeanByIssue(aima0103MForm.getIssueMainId());
		request.setAttribute("collection", tIssueTicketList);
	}
}
