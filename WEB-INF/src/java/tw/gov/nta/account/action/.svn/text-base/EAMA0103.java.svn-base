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

public class EAMA0103 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
//        Eama0101Form eama0101Form =  form;
        //將查詢條件放入資料庫中對應之欄位
        //使用DebitCodeManage.query對輸入之資料(Dto)作查詢
		AccountManager accountManager = new AccountManager();
	    ((Eama0101Form)form).setAccountRef(accountManager.queryCode(((Eama0101Form)form).getId()));
	}

}
