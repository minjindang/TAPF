/**
 * @author AndrewSung
 * @date 2006/3/7
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.shortterm.form.Dima0201Form;
public class DIMA0205 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dima0201Form myForm = (Dima0201Form)form;
		myForm.setDebtType("D");
		IssueManager issueManager = new IssueManager();
		issueManager.confirm(myForm.getIssuMain());
		setAlertMessage(request,"更新成功");

	}

}
