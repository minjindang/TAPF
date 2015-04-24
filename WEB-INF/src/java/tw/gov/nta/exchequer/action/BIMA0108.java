/* BIMA0108.java
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
import tw.gov.nta.exchequer.form.Bima0101Form;

public class BIMA0108 extends DefaultAction {

	@Override
	 public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
			 HttpServletResponse response, Connection connection) throws Exception{
		// TODO Auto-generated method stub
		Bima0101Form myForm = (Bima0101Form)form;
		IssueManager issueManager = new IssueManager();
		try{
			issueManager.cancel(myForm.getId());
			setAlertMessage(request,"刪除成功");
			return mapping.findForward("success");
		}catch(Exception e){
			
			setAlertMessage(request,"刪除失敗，請重新執行");
			return mapping.findForward("fail");
		}
		
		
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	}

}
