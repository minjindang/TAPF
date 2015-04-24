/* BIMA0213.java
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

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.exchequer.form.Bima0202Form;

public class BIMA0213 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		// 取得畫面的form
		Bima0202Form myForm = (Bima0202Form)form;
		//用form來get bean 再傳給PaymentTicketManager.confirm() 新增的動作
		if(myForm.getPaymentMainId()==null || myForm.getPaymentMainId()==0)
			myForm.setPaymentMainId(myForm.getId());
		myForm.setId(null);
		TicketManager myManager = new TicketManager();
		myForm.setIssue(new IssueManager().getBean(myForm.getQryIssueId()));
		myManager.confirm(myForm.getIssueTicketDet());
		setAlertMessage(request,"新增成功");
	}
}
