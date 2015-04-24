/* BIMA0207.java
 �{���ت��GBIMA02
 �{���N���GBIMA02
 �{������G0950301
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TreasuryPayManager;
import tw.gov.nta.exchequer.form.Bima0201Form;

import gov.dnt.tame.common.DefaultAction;

public class BIMA0207 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		// ��TreasuryPaymentManager.isModify���ˬd�O�_���F��R��������
		// ��TreasuryPaymentManager.comform�ӧR�����
		Bima0201Form myForm = (Bima0201Form)form;
		TreasuryPayManager myManager = new TreasuryPayManager();
		if(myManager.isModify(myForm.getPaymentMain()))
		{
			myForm.setAverageRate(myForm.getAverageRate().divide(new BigDecimal(100)));
			myForm.setInterestAmount(myForm.getManageInterestAmount());
			myManager.confirm(myForm.getPaymentMain());
			setAlertMessage(request,"��s���\");
		}
		else
		{
			setAlertMessage(request,"����R�����");
		}
	}
}
