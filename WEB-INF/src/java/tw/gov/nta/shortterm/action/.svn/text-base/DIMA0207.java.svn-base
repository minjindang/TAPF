/**
*
* @author Andrew Sung
* @createDate 2006/6/7
*/
package tw.gov.nta.shortterm.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.shortterm.form.Dima0202Form;
import tw.gov.nta.sql.debt.IssueMain;

import gov.dnt.tame.common.DefaultAction;

public class DIMA0207 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Dima0202Form myForm = (Dima0202Form)form;
		IssueMain issueMain = new IssueManager().getBean(myForm.getId());
		myForm.setDebtName(issueMain.getDebtName());
		myForm.setIssueDate(issueMain.getIssueDate());
		myForm.setDueDate(issueMain.getDueDate());
	}
}
