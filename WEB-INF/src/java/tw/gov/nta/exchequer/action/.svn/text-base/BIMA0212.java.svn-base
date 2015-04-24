/* BIMA0212.java
 程式目的：BIMA02
 程式代號：BIMA02
 程式日期：0950302
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.exchequer.form.Bima0202Form;

public class BIMA0212 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		// 用PaymentTicketManager.isModify來檢查是否有達到刪除的條件
		// 用PaymentTicketManager.cancel 做刪除
		Bima0202Form myForm = (Bima0202Form)form;
		TicketManager myManager = new TicketManager();
		// TicketManager().isModify驗證有問題,所以先跳過驗證
		//myForm.setIssue(new IssueManager().getBean(myForm.getQryIssueId()));
		//if(myManager.isModify(myForm.getIssueTicketDet()))
		//{
			try
			{
				myManager.cancel(myForm.getId());
				setAlertMessage(request,"更新成功");
			}
			catch(Exception exception)
			{
				setAlertMessage(request,"更新失敗");
			}
		//}
		//else
		//{
		//	setAlertMessage(request,"不准刪除資料");
		//}
	}
}
