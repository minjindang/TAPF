/* BIMA0107.java
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
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.TreasuryIssueManager;
import tw.gov.nta.exchequer.form.Bima0101Form;
import tw.gov.nta.sql.debt.IssueMain;

public class BIMA0107 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		//���o�e�����
		Bima0101Form myForm =(Bima0101Form)form;
		// �P�_�O�_�i��s���
		TreasuryIssueManager myManager = new TreasuryIssueManager();
		myForm.setIssueSerial("F"+myForm.getAccountYear()+"_"+myForm.getSerialNo());
		myForm.setChargeRate(myForm.getChargeRate().divide(new BigDecimal(1000)));
		//
//		try{
		//	myManager.confirm(myForm.getIssueMain());
		//	setAlertMessage(request,Messages.SUCCESS_MODIFY);
//		}
//		catch(Exception e){
//			setAlertMessage(request,"�w�I�ڡA���i�ק���!!");
//			//myForm.setIssueMain(new IssueManager().getBean(myForm.getId()));
//		}
//		��Mic�n�D�Ȯɨ����ˮ� 0950627
		if( myManager.isModify(myForm.getIssueMain()))
		{
			myManager.confirm(myForm.getIssueMain());
			setAlertMessage(request,Messages.SUCCESS_MODIFY);
		}
		else
		{
			setAlertMessage(request,"�w���I�ڸ�ơA���o��s�I");
		}
	}
}