/*
 * ¦b 2006/2/22 «Ø¥ß
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.NationCodeManager;
import tw.gov.nta.system.common.NationDebitManager;
import tw.gov.nta.system.form.Gama0201Form;

/**
 * @author AndrewSung
 */
public class GAMA0201 extends DefaultAction
{
    @SuppressWarnings("static-access")
	public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Gama0201Form myForm = (Gama0201Form) form;
    	myForm.setAccountYear(myForm.getQryAccountYear());
    	myForm.setNationCode(NationCodeManager.get(myForm.getQryNationCode()));
    	List collection = NationDebitManager.query(myForm.getNationDebitMain(),"%");
    	request.setAttribute("collection",collection);
    }
}