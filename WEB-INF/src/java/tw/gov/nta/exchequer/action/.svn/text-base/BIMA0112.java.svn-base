/* BIMA0112.java
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

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.exchequer.form.Bima0102Form;

public class BIMA0112 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
	
		Bima0102Form myForm =(Bima0102Form)form;
		TicketManager ticketManager = new TicketManager();
		ticketManager.cancel(myForm.getId());
		setAlertMessage(request,"刪除成功");
	}
}
