/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.HibernateException;

import tw.gov.nta.account.form.Eama0202Form;
import tw.gov.nta.debt.account.common.DebtAccountManager;

/**
 * @author AndrewSung
 */
public class EAMA0212 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Eama0202Form myForm = (Eama0202Form) form;
    	DebtAccountManager manager = new DebtAccountManager();
    	try{
    		manager.createPhaseDet(myForm.getPhaseDet());
    		setAlertMessage(request,"新增成功");
    	}catch(HibernateException e){
    		e.printStackTrace();
    		setAlertMessage(request,"新增失敗");
    	}
    }

}
