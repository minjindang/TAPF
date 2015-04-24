/*
 * 在 2006/3/22 建立
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.HibernateException;

import tw.gov.nta.account.common.AccountManager;
import tw.gov.nta.account.form.Eama0101Form;

/**
 * @author AndrewSung
 */
public class EAMA0104 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Eama0101Form myForm = (Eama0101Form) form;
    	AccountManager manager = new AccountManager();
    	try {
			manager.deleteCode(myForm.getId());
			setAlertMessage(request,"刪除成功");
    	} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setAlertMessage(request,"刪除失敗");
		}
    }

}
