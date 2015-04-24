/**
 * @author LinusTseng
 * @date 2006/3/8
 */

package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.common.AccountManager;
import tw.gov.nta.account.form.Eama0101Form;
import tw.gov.nta.sql.account.AccountRef;


public class EAMA0105 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{

		Eama0101Form myForm = (Eama0101Form)form;
		AccountManager accountManager = new AccountManager();
		try{
			AccountRef accountRef = myForm.getAccountRef();
			accountManager.updateCode(accountRef);
			setAlertMessage(request,"更新成功");
		}
		catch(Exception e){
			e.printStackTrace();
			setAlertMessage(request,"更新失敗");
		}
		
	}

}
