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

/**
 * @author AndrewSung
 */
public class EAMA0207 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Eama0201Form myForm = (Eama0201Form) form;
    	DebtAccountManager manager = new DebtAccountManager();
    	myForm.getAccountPhaseDets();
//        request.setAttribute("collection",collection);
//        if ((null != gama0102Form.getKind().getId()) && (!"".equals(gama0102Form.getKind().getId())))
//        	myForm.setCodeMain(CodeMainManage.get((gama0102Form.getKind()).getId())) ;
    }

}
