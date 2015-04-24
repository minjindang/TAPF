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

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.ShortDebtManager;
import tw.gov.nta.shortterm.form.Dima0202Form;
import tw.gov.nta.system.common.BankCodeManage;
public class DIMA0210 extends DefaultAction
{
	 public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception{
		 Dima0202Form myForm = (Dima0202Form)form;
			myForm.setBank(BankCodeManage.get(myForm.getBankId()));
			IssueManager issueManager = new IssueManager();
			myForm.setIssue(issueManager.getBean(myForm.getKindId()));
			ShortDebtManager shortDebtManager = new ShortDebtManager();
			if(!("Y").equals(myForm.getAccrue()))
				myForm.setAccrue("N");
			try{
				//debt.confirm(myForm.getDebtMain());
				new DebtManager().upDate(myForm.getDebtMain());
				setAlertMessage(request,"更新成功");
				return mapping.findForward("success");
			}
			catch(Exception e){
				e.printStackTrace();
				setAlertMessage(request,"更新失敗,金額大於可借額度");
				return mapping.findForward("fail");
			}
			
	 }
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		
	}
}