/* DIMA0103.java
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

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.common.ContractBankManager;
import tw.gov.nta.shortterm.form.Dima0101Form;
import tw.gov.nta.sql.debt.ContractBankMain;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class DIMA0101MLOAD extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO 自動產生方法 Stub
		// 尚未定義
			Dima0101Form myform = (Dima0101Form) form;
			
			//myform.setBankCode(myform.getQrybankcode());
			myform.setContractYear(myform.getQrycontractyear());
		    
			//使用 Service:ContractBankManager
			//使用 ContractBankManager.query 查詢
			 ContractBankManager myManager = new ContractBankManager();
			//TODO
			ContractBankMain conBank = new ContractBankMain();
			conBank = myManager.getBean(myform.getId());
			myform.setMyConBean(conBank);
		 	myform.setBankId(conBank.getBank().getId());
		 	BigDecimal borrowAmount = new tw.gov.nta.debt.common.ContractBankManager().recountBorrowAmount(myform.getBank().getId(),myform.getContractYear(), connection);
		 	//BigDecimal borrowAmount = new tw.gov.nta.debt.common.ContractBankManager().recountBorrowAmount(myform.getBank().getId(),myform.getContractYear());
		 	myform.setBorrowAmount((borrowAmount.compareTo(new BigDecimal(0)) != -1)?borrowAmount:new BigDecimal(0));
		 	myform.setEnableborrow(myform.getContractAmount().subtract(myform.getBorrowAmount()));
	}

}
