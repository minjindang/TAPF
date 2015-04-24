/* DIMA0301.java
程式目的：DIMA03
程式代號：DIMA03
程式日期：0950224
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.shortterm.form.Dima0301Form;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class DIMA0301 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO 自動產生方法 Stub
		
		Dima0301Form myform = (Dima0301Form)form;
			//使用 Service:DebtManager
			//使用 DebtManager.search  查詢
		IssueManager myManager = new IssueManager();
		String pcols[] = {"accountYear","serialNo","id","debtType"};
		Object pValues[] = {myform.getQryAccountYear()+"%",myform.getQrySerialNo(),((myform.getQryId()!=0)?myform.getQryId():""),"D"};
		String pConds[] = {"like","=","=","="};
//		String pcols[] = {};
//		String pValues[] = {};
//		String pConds[] = {};
		List list = myManager.Search(pcols,pValues,pConds,pcols);
		request.setAttribute("collection",list);

	}

}
