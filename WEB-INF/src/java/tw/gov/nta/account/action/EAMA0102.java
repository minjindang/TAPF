/**
 * @author LinusTseng
 * @date 2006/3/8
 */

package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.common.AccountManager;
import tw.gov.nta.account.form.Eama0101Form;
import tw.gov.nta.sql.debt.DebtTypeRef;

public class EAMA0102 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
//        Eama0101Form eama0101Form =  form;
        //將查詢條件放入資料庫中對應之欄位

        //使用DebitCodeManage.query對輸入之資料(Dto)作查詢
		AccountManager accountManager = new AccountManager();
		Eama0101Form myform = (Eama0101Form)form;
		myform.setDebtType((DebtTypeRef)request.getSession().getAttribute("debtType"));
        List collection = accountManager.queryCode(myform.getAccountRef());
        request.setAttribute("collection",collection);
	}

}
