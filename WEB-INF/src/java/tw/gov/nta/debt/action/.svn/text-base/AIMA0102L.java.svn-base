package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.form.Aima0102MForm;

public class AIMA0102L extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0102MForm aima0102MForm = (Aima0102MForm) form;
		List tDebtMainList = new DebtManager().getBeanByIssue(aima0102MForm.getIssueMainId());
		request.setAttribute("collection",tDebtMainList);
	}
}
