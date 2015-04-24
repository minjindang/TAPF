/**
 * @author AndrewSung
 * @date 2006/3/7
 * 將查詢出之多筆資料連結至畫面
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.shortterm.form.Dima0201Form;
public class DIMA0203 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dima0201Form myForm = (Dima0201Form)form;
		myForm.setAccountYear(myForm.getQryAccountYear());
		myForm.setSerialNo(myForm.getQrySerialNo());
		IssueManager issueManager = new IssueManager();
		String[] name = {"accountYear","serialNo","id","debtType"};
		Object[] value ={myForm.getAccountYear()+"%",myForm.getSerialNo()+"%",(myForm.getQryId()!= 0)?myForm.getQryId():"","D"};
		String[] cond = {"like","like",(myForm.getQryId()!= 0)?"=":"","="};
		String[] orderBy ={"accountYear","serialNo"};
		List collection = issueManager.Search(name,value,cond,orderBy);
		request.setAttribute("collection",collection);
	}

}
