/* FAMA0606.java
�{���ت��GFAMA06
�{���N���GFAMA06
�{������G0950223
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

import tw.gov.nta.system.common.NationCodeManager;
import tw.gov.nta.system.form.Fama0601Form;

/**
 * @author EricChen
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class FAMA0606 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO �۰ʲ��ͤ�k Stub
		//���o formBean
		Fama0601Form myform = (Fama0601Form) form;	

		//�ϥ�Service:NationCodeManager
		//�ϥ� NationCodeManager.delete
		NationCodeManager.delete(myform.getId());
		setAlertMessage(request,"�R�����\");
		
	}

}
