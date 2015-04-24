/* CIMA0106.java
 �{���ت��GCIMA01
 �{���N���GCIMA01
 �{������G0950307
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

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Cima0101Form;

public class CIMA0106 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myForm = (Cima0101Form)form;
		//�I�s Service �R�����
		IssueManager myManager = new IssueManager();
		try
		{
			myManager.cancel(myForm.getId());
			setAlertMessage(request,"�R�����\");
		}
		catch(Exception e)
		{
			setAlertMessage(request,"�L�k�R��");
		}
		
	}

}
