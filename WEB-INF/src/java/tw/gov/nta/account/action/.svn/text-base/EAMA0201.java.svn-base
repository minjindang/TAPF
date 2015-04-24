/*
 * ¦b 2006/2/22 «Ø¥ß
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.Eama0201Form;
import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.account.AccountPhaseMain;

/**
 * @author AndrewSung
 */
public class EAMA0201 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Eama0201Form myForm = (Eama0201Form) form;
    	DebtAccountManager manager = new DebtAccountManager();
    	myForm.setDebtType((DebtTypeRef)request.getSession().getAttribute("debtType"));
    	List accountPhases = manager.queryPhase(myForm.getAccountPhase());
    	List<Eama0201Form> collection = new ArrayList<Eama0201Form>();
    	for (Iterator iterator = accountPhases.iterator();iterator.hasNext();){
    		Eama0201Form eama0201form = new Eama0201Form();
    		eama0201form.setAccountPhase((AccountPhaseMain)iterator.next());
    		collection.add(eama0201form);
    	}
        
    	request.setAttribute("collection",collection);
    }
}
