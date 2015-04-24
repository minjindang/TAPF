/* BIMA0107.java
 程式目的：BIMA01
 程式代號：BIMA01
 程式日期：0950303
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.TreasuryIssueManager;
import tw.gov.nta.exchequer.form.Bima0101Form;
import tw.gov.nta.sql.debt.IssueMain;

public class BIMA0107 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		//取得畫面資料
		Bima0101Form myForm =(Bima0101Form)form;
		// 判斷是否可更新資料
		TreasuryIssueManager myManager = new TreasuryIssueManager();
		myForm.setIssueSerial("F"+myForm.getAccountYear()+"_"+myForm.getSerialNo());
		myForm.setChargeRate(myForm.getChargeRate().divide(new BigDecimal(1000)));
		//
//		try{
		//	myManager.confirm(myForm.getIssueMain());
		//	setAlertMessage(request,Messages.SUCCESS_MODIFY);
//		}
//		catch(Exception e){
//			setAlertMessage(request,"已付款，不可修改資料!!");
//			//myForm.setIssueMain(new IssueManager().getBean(myForm.getId()));
//		}
//		依Mic要求暫時取消檢核 0950627
		if( myManager.isModify(myForm.getIssueMain()))
		{
			myManager.confirm(myForm.getIssueMain());
			setAlertMessage(request,Messages.SUCCESS_MODIFY);
		}
		else
		{
			setAlertMessage(request,"已有付款資料，不得更新！");
		}
	}
}