/*
 * ¦b 2006/2/22 «Ø¥ß
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.Eama0201Form;
import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.debt.account.AccountPhaseMain;

/**
 * @author Linus.Tseng
 */
public class EAMA0202 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Eama0201Form myForm = (Eama0201Form) form;
    	DebtAccountManager manager = new DebtAccountManager();
    	AccountPhaseMain accountPhaseMain= manager.getPhase(myForm.getId());
    	myForm.setAccountPhase(accountPhaseMain);
    }

}
