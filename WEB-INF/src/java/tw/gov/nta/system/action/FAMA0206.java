/* FAMA0206.java
�{���ت��GFAMA02
�{���N���GFAMA02
�{������G0950222
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.BudgetCodeManager;
import tw.gov.nta.system.form.Fama0201Form;

/**
 * @author EricChen
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class FAMA0206 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO �۰ʲ��ͤ�k Stub
		//		���o formBean
		Fama0201Form myform = (Fama0201Form) form;

		//�ϥ�Service:BudgetRef
		//�ϥ� BudgetCodeManager.delete
		BudgetCodeManager.delete(myform.getId());
		setAlertMessage(request,"�R�����\");

	}

}
