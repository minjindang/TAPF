/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.HibernateException;

import tw.gov.nta.account.form.Eama0201Form;
import tw.gov.nta.debt.account.common.DebtAccountManager;

/**
 * @author AndrewSung
 */
public class EAMA0208 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */


	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.sql.Connection)
	 */
	@Override
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {
		// TODO Auto-generated method stub
	   	Eama0201Form myForm = (Eama0201Form) form;
    	DebtAccountManager manager = new DebtAccountManager();
    	try {
			manager.updatePhase(myForm.getAccountPhase());
			setAlertMessage(request,"更新成功");
    	} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setAlertMessage(request,"更新失敗");
		}
		
		return super.executeQuery(mapping, form, request, response, connection);
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
