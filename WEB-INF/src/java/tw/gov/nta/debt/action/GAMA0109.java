/* GAMA0109.java
 �{���ت��GGAMA01
 �{���N���GGAMA01
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
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.MiddleDebtManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.DefaultBankRef;
import tw.gov.nta.system.common.BankCodeManage;

public class GAMA0109 extends DefaultAction {

	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myForm = (Cima0101Form)form;
		//�I�s Service �s�W���
		BankRef mybank = new DefaultBankRef();
		mybank = BankCodeManage.get(myForm.getBankId());
		IssueManager issueManager = new IssueManager();
		myForm.getMyDMain().setIssue(issueManager.getBean(myForm.getId()));
		myForm.getMyDMain().setBank(mybank);
		MiddleDebtManager myManager = new MiddleDebtManager();
		
		myForm.setCompareRate((myForm.getCompareRate().setScale(3,5)));
		if(0 != myForm.getIssueAmountDet().intValue())
		{
			myForm.setAccrue("Y");	//�Y�o�Ъ��B����0,�h�]�o�Ч_���(accrue)��Y
		}	
		else
		{
			myForm.setAccrue("N");	
		}
		if(myManager.checkBean(myForm.getMyDMain())){
			myManager.confirm(myForm.getMyDMain());
			myForm.setDebtId(myForm.getMyDMain().getId());
			setAlertMessage(request,"�s�W���\");
			return mapping.findForward("success");
		}
		else{
			setAlertMessage(request,"�s�W���ѡA�~�סB�w��O�B�ŰȧO�L�ɴڭp�e���");
			return mapping.findForward("fail");
		}
		
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	}

}
