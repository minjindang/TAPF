/* BIMA0112.java
 �{���ت��GBIMA01
 �{���N���GBIMA01
 �{������G0950303
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
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
		setAlertMessage(request,"�R�����\");
	}
}
