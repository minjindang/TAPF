/* HAMB0704.java
 �{���ت��GHAMB07��r
 �{���N���GHAMB07
 �{������G0950222
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb0701Form;

public class HAMC0704 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		//	��s�U���q�l�l�󱵦�����
		Hamb0701Form myform = (Hamb0701Form) form;
		myform.setUsrid(this.getUserId(request));
		myform.setModDate(new Date());
		//�� Service updateForRecive ��s
		UnitAllocate.updateForRecieve(myform.getId(),myform.getRecvDate());
		setAlertMessage(request, "��s���\");
		
	}

}
