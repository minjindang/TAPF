/* BIMA0208.java
 �{���ت��GBIMA02
 �{���N���GBIMA02
 �{������G0950302
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TreasuryPayManager;
import tw.gov.nta.exchequer.form.Bima0201Form;

import gov.dnt.tame.common.DefaultAction;

public class BIMA0208 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
//		 ��TreasuryPaymentManager.isModify���ˬd�O�_���F��R��������
		// ��TreasuryPaymentManager.cancel�ӧR�����
		Bima0201Form myForm = (Bima0201Form)form;
		TreasuryPayManager myManager = new TreasuryPayManager();
		if(myManager.isModify(myForm.getPaymentMain()))
		{
			myManager.cancel(myForm.getPaymentMain());
			setAlertMessage(request,"�R�����\");
		}
		else
		{
			setAlertMessage(request,"�R������");
		}
	}
}
