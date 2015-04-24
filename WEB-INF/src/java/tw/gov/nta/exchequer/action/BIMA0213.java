/* BIMA0213.java
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
		// ���o�e����form
		Bima0202Form myForm = (Bima0202Form)form;
		//��form��get bean �A�ǵ�PaymentTicketManager.confirm() �s�W���ʧ@
		if(myForm.getPaymentMainId()==null || myForm.getPaymentMainId()==0)
			myForm.setPaymentMainId(myForm.getId());
		myForm.setId(null);
		TicketManager myManager = new TicketManager();
		myForm.setIssue(new IssueManager().getBean(myForm.getQryIssueId()));
		myManager.confirm(myForm.getIssueTicketDet());
		setAlertMessage(request,"�s�W���\");
	}
}
