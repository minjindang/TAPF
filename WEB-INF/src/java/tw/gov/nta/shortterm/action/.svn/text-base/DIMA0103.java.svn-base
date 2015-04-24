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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.ContractBankManager;
import tw.gov.nta.shortterm.form.Dima0101Form;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.ContractBankMain;
import tw.gov.nta.sql.debt.DefaultBankRef;
import tw.gov.nta.system.common.BankCodeManage;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class DIMA0103 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO 自動產生方法 Stub
		// 尚未定義
			Dima0101Form myform = (Dima0101Form) form;

			 ContractBankManager myManager = new ContractBankManager();
			//TODO
			BankRef myBank = new BankRef();
			Object[] pValues = new Object[2];
			String pConds[] = new String [2];
			String pCols[] = {"contractYear","bank"};
			myBank = BankCodeManage.get(myform.getBankId());
			if(myBank == null){
				pValues[1] = null;
				pConds[1] = null;
			}
			else{
				pValues[1] = myBank;
				pConds[1] = "=";
			}
			if(myform.getQrycontractyear().equals("")){
				pValues[0] = null;
				pConds[0] = null;
			}
			else{
				pValues[0] = myform.getQrycontractyear() + "%";
				pConds[0] = "like";
			}

		 	List list = myManager.Search(pCols,pValues,pConds,pCols);
		 	List collection = new LinkedList();
			for(Iterator it =list.iterator();it.hasNext();)
			{	
				ContractBankMain dto = (ContractBankMain)it.next();
				BigDecimal borrowAmount = new tw.gov.nta.debt.common.ContractBankManager().recountBorrowAmount(dto.getBank().getId(),dto.getContractYear(), connection);
				dto.setBorrowAmount((borrowAmount.compareTo(new BigDecimal(0)) != -1)?borrowAmount:new BigDecimal(0));
				collection.add(dto);
			}	
		 	//return to jsp
		 	request.setAttribute("collection",collection);
		

	}

}
