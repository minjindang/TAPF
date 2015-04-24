/*
 * ¦b 2006/2/22 «Ø¥ß
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.Eama0202Form;
import tw.gov.nta.debt.account.common.DebtAccountManager;

/**
 * @author AndrewSung
 */
public class EAMA0210 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Eama0202Form myForm = (Eama0202Form) form;
    	DebtAccountManager manager = new DebtAccountManager();
    	myForm.setPhaseDet(manager.getPhaseDet(myForm.getId()));
    }

}
