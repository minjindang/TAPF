package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0201MForm;

public class AIMA0201M extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0201MForm aima0201MForm = (Aima0201MForm) form;
		if(request.getAttribute("issueMainId")!=null)
			aima0201MForm.setIssueMain(new IssueManager().getBean(Integer.parseInt(request.getAttribute("issueMainId").toString())));
		else
			aima0201MForm.setIssueMain(new IssueManager().getBean(aima0201MForm.getIssueMainId().intValue()));
		
		request.setAttribute("sourceIssueMain",new IssueManager().getBean(aima0201MForm.getSourceIssueId()));
		if(request.getSession().getAttribute("debtRateList")!=null)
			request.getSession().removeAttribute("debtRateList");
	}
}
