/* BIMA0113.java
 程式目的：BIMA01
 程式代號：BIMA01
 程式日期：0950303
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.exchequer.form.Bima0102Form;

public class BIMA0113 extends DefaultAction {
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, 
										HttpServletRequest request, HttpServletResponse response, 
										Connection connection) throws Exception
	{
		
		Bima0102Form myForm = (Bima0102Form)form;
		TicketManager ticketManager = new TicketManager();
		//if(ticketManager.confirm(myForm.getIssueTicketDet()))
		//{
		IssueManager issueManager = new IssueManager();
		myForm.setIssue(issueManager.getBean(myForm.getId()));
		myForm.setIssueId(myForm.getId());
		myForm.setId(null);
		ticketManager.confirm(myForm.getIssueTicketDet());
		setAlertMessage(request,"儲存成功");
		return mapping.findForward("success");
		//}
		//else
		//{
		//	setAlertMessage(request,"儲存失敗");
	    //    return mapping.findForward("fail");
		//}
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
