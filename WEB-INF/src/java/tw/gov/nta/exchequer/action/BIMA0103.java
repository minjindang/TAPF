/* BIMA0103.java
 程式目的：BIMA01
 程式代號：BIMA01
 程式日期：0950303
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.action;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TreasuryIssueManager;
import tw.gov.nta.exchequer.form.Bima0101Form;

import gov.dnt.tame.common.DefaultAction;

public class BIMA0103 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		 // 取得畫面資料
		 Bima0101Form myForm = (Bima0101Form)form;
		 if(myForm.getQryaccountYear()!=null ||myForm.getQrybudgetCode()!=null||myForm.getQrydebtCode()!=null||myForm.getQrydebtName()!=null)
		 {
			 Integer debtCode = myForm.getQrydebtCode();
			 Integer budgetCode = myForm.getQrybudgetCode();
			 if (debtCode ==0 )
				 debtCode = null;
			 if (budgetCode ==0 )
				 budgetCode = null;
			 
			 String[] clos = {"debtCode","budgetCode","accountYear","id","debtType"};
			 Object[] values={debtCode,budgetCode,myForm.getQryaccountYear(),(myForm.getQrydebtName().intValue() == 0)?null:myForm.getQrydebtName(),"B"};
			 String[] cond={"=","=","like","=","="};
			 String[] orderby={"issueSerial","accountYear"};
			 // 做查詢 Service:TreasuryIssueManager
			 TreasuryIssueManager myManager = new TreasuryIssueManager();
			 List list = (List)myManager.search(clos,values,cond,orderby,true);
			 // 給畫面
			 request.setAttribute("collection",list);
		 }
	}
}
