/**
 * @author AndrewSung
 * @date 2006/3/7
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.ShortDebtManager;
import tw.gov.nta.shortterm.form.Dima0201Form;
import tw.gov.nta.shortterm.form.Dima0202Form;
import tw.gov.nta.system.common.BankCodeManage;
public class DIMA0208 extends DefaultAction
{
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception{
		Dima0202Form myForm = (Dima0202Form)form;
		Dima0201Form dima0201Form = new Dima0201Form();
		IssueManager issueManager = new IssueManager();
		myForm.setIssue(issueManager.getBean(myForm.getId()));
		myForm.setBank(BankCodeManage.get(myForm.getBankId()));
		myForm.setAccrue("N");
		dima0201Form.setId(myForm.getId());
		myForm.setId(null);
		ShortDebtManager shortDebtManager = new ShortDebtManager();
		try{
			shortDebtManager.confirm(myForm.getDebtMain());
			setAlertMessage(request,"新增成功");
			return mapping.findForward("success");
		}
		catch(Exception e){
			myForm.setId(dima0201Form.getId());
			System.out.println(e);
			setAlertMessage(request,"新增失敗,金額大於可借額度");
			return mapping.findForward("fail");
		}
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
	}

}
