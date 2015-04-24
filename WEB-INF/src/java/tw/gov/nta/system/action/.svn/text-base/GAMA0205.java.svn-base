/*
 * ¦b 2006/2/22 «Ø¥ß
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.NationCodeManager;
import tw.gov.nta.system.common.NationDebitManager;
import tw.gov.nta.system.form.Gama0201Form;

/**
 * @author AndrewSung
 */
public class GAMA0205 extends DefaultAction
{
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Gama0201Form myForm = (Gama0201Form) form;
    	myForm.setNationCode(NationCodeManager.get(myForm.getNationRefId()));
    	NationDebitManager.update(myForm.getId(),myForm.getNationDebitMain());
    	setAlertMessage(request,Messages.SUCCESS_MODIFY);
    }

}
