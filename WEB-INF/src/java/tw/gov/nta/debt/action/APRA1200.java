/* APRA0901.java ����
 �{���ت��GAPRA09
 �{���N���GAPRA09
 �{������G0950308
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
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
