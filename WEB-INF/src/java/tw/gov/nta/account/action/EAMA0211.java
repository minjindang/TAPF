/*
 * ¦b 2006/2/22 «Ø¥ß
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.Eama0201Form;
import tw.gov.nta.account.form.Eama0202Form;
import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.account.dao.AccountRefDAO;

/**
 * @author AndrewSung
 */
public class EAMA0211 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Eama0201Form eama0201Form = (Eama0201Form)request.getAttribute("Eama0201Form");
    	Eama0202Form eama0202Form = (Eama0202Form)form;
    	if (eama0201Form != null) {
	    	eama0202Form.setAccountPhase(eama0201Form.getAccountPhase());
    	}else {
    		DebtAccountManager manager = new DebtAccountManager();
    		eama0202Form.setAccountPhase(manager.getPhase(eama0202Form.getAccountPhase().getId()));

    		eama0202Form.setAccountCode(AccountRefDAO.getInstance().get(eama0202Form.getAccountCode().getId()));
    	}
    }

}
