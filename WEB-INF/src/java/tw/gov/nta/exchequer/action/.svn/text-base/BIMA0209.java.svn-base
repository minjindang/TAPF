/* BIMA0209.java
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

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.exchequer.form.Bima0202Form;

public class BIMA0209 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0202Form myForm = (Bima0202Form)form;
		TicketManager myManager = new TicketManager();
		//使用TicketManager(提前買回資料的id) 塞給dto 至修改畫面
		myForm.setIssueTicketDet(myManager.getBean(myForm.getId()));
		BigDecimal tickCount = BigDecimal.valueOf((myForm.getTicketCount()).longValue());
		myForm.setTotalAmount(myForm.getTicketAmount().multiply(tickCount));
	}
}