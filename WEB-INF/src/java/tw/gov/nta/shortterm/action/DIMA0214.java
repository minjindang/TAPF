/**
 * @author AndrewSung
 * @date 2006/3/7
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.ShortDebtManager;
import tw.gov.nta.shortterm.form.Dima0202Form;
import tw.gov.nta.sql.debt.IssueMain;
public class DIMA0214 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dima0202Form myForm = (Dima0202Form)form;
		IssueMain issueMain= new IssueManager().getBean(myForm.getKindId());
		
		myForm.setDays((DateUtil.getDays(issueMain.getIssueDate(),issueMain.getDueDate())).toString()+"ค้");
		ShortDebtManager shortDebtManager = new ShortDebtManager();
		myForm.setDebtMain(shortDebtManager.getBean(myForm.getId()));
		myForm.setAllAmount(myForm.getIssueAmount().add(myForm.getOriginInterestAmount()));
		myForm.setDebtName(issueMain.getDebtName());
		myForm.setIssueDate(issueMain.getIssueDate());
		myForm.setDueDate(issueMain.getDueDate());
		myForm.setAccountYear(issueMain.getAccountYear());
	}
}