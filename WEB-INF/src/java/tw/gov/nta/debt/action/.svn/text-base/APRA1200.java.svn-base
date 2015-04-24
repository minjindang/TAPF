/* APRA0901.java 報表
 程式目的：APRA09
 程式代號：APRA09
 程式日期：0950308
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

import tw.gov.nta.debt.common.PaidaManagerDAO;
import tw.gov.nta.debt.form.Apra1201Form;

public class APRA1200 extends DefaultAction {


	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Apra1201Form myForm = (Apra1201Form)form;
		PaidaManagerDAO dao = new PaidaManagerDAO(connection);
		myForm.setDebtNameList(dao.getPaidaNameLabelList());
	}
}
