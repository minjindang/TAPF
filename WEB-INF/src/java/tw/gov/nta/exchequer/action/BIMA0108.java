/* BIMA0108.java
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

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.exchequer.form.Bima0101Form;

public class BIMA0108 extends DefaultAction {

	@Override
	 public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
			 HttpServletResponse response, Connection connection) throws Exception{
		// TODO Auto-generated method stub
		Bima0101Form myForm = (Bima0101Form)form;
		IssueManager issueManager = new IssueManager();
		try{
			issueManager.cancel(myForm.getId());
			setAlertMessage(request,"�R�����\");
			return mapping.findForward("success");
		}catch(Exception e){
			
			setAlertMessage(request,"�R�����ѡA�Э��s����");
			return mapping.findForward("fail");
		}
		
		
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	}

}
