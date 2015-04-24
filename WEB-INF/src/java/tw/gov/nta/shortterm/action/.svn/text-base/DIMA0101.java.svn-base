/* DIMA0101.java
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
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.common.ContractBankManager;
import tw.gov.nta.shortterm.form.Dima0101Form;
import tw.gov.nta.system.common.BankCodeManage;




/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class DIMA0101 extends DefaultAction {
    public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception
    {
    	Dima0101Form myform = (Dima0101Form) form;
		myform.setModDate(new Date());
		myform.setUserid(this.getUserId(request));
		//使用 ContractBankManager
		//使用 ContractBankManager.confirm新增
		ContractBankManager manager = new ContractBankManager();
		myform.setBank(BankCodeManage.get(myform.getBankId()));
		try{
			manager.confirm(myform.getMyConBean());
			setAlertMessage(request,"新增成功");
		}catch(Exception e){
			setAlertMessage(request,"新增失敗");
			throw e;
		}
		
    }
}
