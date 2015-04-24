/* BIMA0209.java
 �{���ت��GBIMA02
 �{���N���GBIMA02
 �{������G0950302
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
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
		//�ϥ�TicketManager(���e�R�^��ƪ�id) �뵹dto �ܭק�e��
		myForm.setIssueTicketDet(myManager.getBean(myForm.getId()));
		BigDecimal tickCount = BigDecimal.valueOf((myForm.getTicketCount()).longValue());
		myForm.setTotalAmount(myForm.getTicketAmount().multiply(tickCount));
	}
}