/**
 * @author AndrewSung
 * @date 2006/3/7
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.shortterm.form.Dima0201Form;
public class DIMA0213 extends DefaultAction
{

	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dima0201Form myForm = (Dima0201Form)form;
		if (myForm.getKindId() != null && myForm.getKindId() != 0)
			myForm.setId(myForm.getKindId());
		System.out.println("id===="+myForm.getId());
		IssueManager issueManager = new IssueManager();
		myForm.setIssuMain(issueManager.getBean(myForm.getId()));
		DebtManager debtManager = new DebtManager();
		List collection = debtManager.getBeanByIssue(myForm.getId());
		myForm.setDebtMains(collection);
	}
}
