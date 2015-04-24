/* BIMA0106.java
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
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.exchequer.form.Bima0101Form;

public class BIMA0106 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
		//取得畫面資料
		  Bima0101Form myForm = (Bima0101Form)form;
		// 給 發行資料id 做查詢動作 取得債票資料
		  TicketManager myManager = new TicketManager();
		  List list = (List)myManager.getBeanByIssue(myForm.getIssueMain().getId());
		// 給畫面
		  request.setAttribute("collection",list);
		
	}

}
