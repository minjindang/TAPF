/* GAMA0105.java
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

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Cima0101Form;

public class GAMA0105 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		try
		{
				Cima0101Form myForm = (Cima0101Form)form;
				//Cima0101Form myForm = (Cima0101Form) request.getSession().getAttribute("Cima0101Form");
		//		myForm.setUserid((String) request.getSession().getAttribute("ACCOUNT"));
		//		myForm.setModDate(new Date());
				IssueManager myIssue = new IssueManager();
				//�I�s Service ��s
				myForm.getMyIss().setDebtType("E");
				if("on".equals(myForm.getMyIss().getBondType()))
				{
					myForm.getMyIss().setBondType("1");	//true
				}
				else
				{
					myForm.getMyIss().setBondType("2");	//false
				}
//				myForm.getMyIss().setBudgetCode(0);
//				myForm.getMyIss().setDebtCode(0);
				myIssue.confirm(myForm.getMyIss());
				setAlertMessage(request,"��s���\");
		}
		catch(Exception e)
		{
			setAlertMessage(request,"��s����");
		}
	}

}
