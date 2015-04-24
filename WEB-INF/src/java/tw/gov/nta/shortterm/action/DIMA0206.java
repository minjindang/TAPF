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
import tw.gov.nta.sql.debt.PaymentMain;
public class DIMA0206 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dima0201Form myForm = (Dima0201Form)form;
		IssueManager issueManager = new IssueManager();
		PaymentMain payMentMain = new PaymentMain();
		payMentMain.setIssueId(myForm.getId());
		issueManager.cancel(myForm.getId());
		setAlertMessage(request,"§R°£¦¨¥\");
	}
}
