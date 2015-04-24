package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0101MForm;

public class AIMA0101M extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0101MForm aima0101MForm = (Aima0101MForm) form;
		if(request.getAttribute("issueMainId")!=null)
			aima0101MForm.setIssueMain(new IssueManager().getBean(Integer.parseInt(request.getAttribute("issueMainId").toString())));
		else
			aima0101MForm.setIssueMain(new IssueManager().getBean(aima0101MForm.getIssueMainId().intValue()));
		if(request.getSession().getAttribute("debtRateList")!=null)
			request.getSession().removeAttribute("debtRateList");
	}
}
