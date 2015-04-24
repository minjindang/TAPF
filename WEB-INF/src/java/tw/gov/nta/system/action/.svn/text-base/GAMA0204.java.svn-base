/*
 * ¦b 2006/2/22 «Ø¥ß
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.NationDebitManager;
import tw.gov.nta.system.form.Gama0201Form;

/**
 * @author AndrewSung
 */
public class GAMA0204 extends DefaultAction
{
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Gama0201Form myForm = (Gama0201Form) form;
    	myForm.setNationDebitMain(NationDebitManager.get(myForm.getId()));
    }
}