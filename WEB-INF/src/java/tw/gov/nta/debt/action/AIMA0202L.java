package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Aima0202MForm;
import tw.gov.nta.sql.debt.IssueMain;

public class AIMA0202L extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0202MForm aima0202MForm = (Aima0202MForm) form;
		IssueMain issueMain = new IssueManager().getBean(aima0202MForm.getIssueMainId());
		IssueMain sourceIssueMain = new IssueManager().getBean(issueMain.getSourceIssueId());
		BigDecimal issueAmount = (issueMain.getIssueAmount()!=null)?issueMain.getIssueAmount():new BigDecimal(0);
		BigDecimal averageRate = (issueMain.getAverageRate()!=null)?issueMain.getAverageRate():new BigDecimal(0);
		BigDecimal repayInterestAmount = new IssueManager().getRepayInterestAmount(issueAmount,averageRate,sourceIssueMain.getIssueDate(),issueMain.getIssueDate()); 
		aima0202MForm.setRepayInterestAmount(repayInterestAmount);
		List tDebtMainList = new DebtManager().getBeanByIssue(aima0202MForm.getIssueMainId());
		request.setAttribute("collection",tDebtMainList);
	}
}
