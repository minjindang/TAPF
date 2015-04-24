package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.surplusage.common.Gara04TempManager;
import tw.gov.nta.surplusage.form.Gama0701Form;

public class GAMA0703 extends DefaultAction {

	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception
	{
		Gama0701Form myForm = (Gama0701Form) form;
    	if(Gara04TempManager.isModify(myForm.getGara04Temp()))
    	{
    		Gara04TempManager.create(myForm.getGara04Temp());
    		myForm.setQryAccountYear(myForm.getAccountYear());
    		setAlertMessage(request,Messages.SUCCESS_ADD);
    		return mapping.findForward("success");
    		
    	}
    	else
    	{
    		myForm.setAccountYear("");
    		setAlertMessage(request,"新增失敗，此年度已建立");
   		 	return mapping.findForward("failure");
    	}
		
	}
	public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	
    }
}
