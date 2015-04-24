/* DIMA0105.java
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.ContractBankManager;
import tw.gov.nta.shortterm.form.Dima0101Form;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.DefaultBankRef;
import tw.gov.nta.system.common.BankCodeManage;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class DIMA0105 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO 自動產生方法 Stub
		Dima0101Form myform = (Dima0101Form) form;
			//使用 Service:ContractBankManager
			//使用 ContractBankManager.confirm
		ContractBankManager myManager = new ContractBankManager();
		BankRef myBank = new DefaultBankRef();
		myBank = BankCodeManage.get(myform.getBankId());
		myform.getMyConBean().setBank(myBank);
		myManager.confirm(myform.getMyConBean());
		setAlertMessage(request,"修改成功");
	}

}
