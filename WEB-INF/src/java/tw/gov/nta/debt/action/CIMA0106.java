/* CIMA0106.java
 程式目的：CIMA01
 程式代號：CIMA01
 程式日期：0950307
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Cima0101Form;

public class CIMA0106 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myForm = (Cima0101Form)form;
		//呼叫 Service 刪除資料
		IssueManager myManager = new IssueManager();
		try
		{
			myManager.cancel(myForm.getId());
			setAlertMessage(request,"刪除成功");
		}
		catch(Exception e)
		{
			setAlertMessage(request,"無法刪除");
		}
		
	}

}
