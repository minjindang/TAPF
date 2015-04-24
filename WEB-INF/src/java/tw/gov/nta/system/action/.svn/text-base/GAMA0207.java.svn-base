/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.system.common.NationCodeManager;
import tw.gov.nta.system.common.NationDebitManager;
import tw.gov.nta.system.form.Gama0201Form;

/**
 * @author AndrewSung
 */
public class GAMA0207 extends DefaultAction
{
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception
	{
		Gama0201Form myForm = (Gama0201Form) form;
		myForm.setNationCode(NationCodeManager.get(myForm.getNationRefId()));
    	if(NationDebitManager.isModify(myForm.getNationDebitMain()))
    	{
    		NationDebitManager.create(myForm.getNationDebitMain());
    		setAlertMessage(request,Messages.SUCCESS_ADD);
    		return mapping.findForward("success");
    	}
    	else
    	{
    		myForm.setAccountYear("");
    		myForm.setNationCode(null);
    		setAlertMessage(request,"新增失敗:類別代碼重複");
   		 	return mapping.findForward("failure");
    	}
		
	}
   
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	
    }

}
