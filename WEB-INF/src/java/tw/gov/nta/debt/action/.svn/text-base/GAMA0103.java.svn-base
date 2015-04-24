/* GAMA0103.java
 程式目的：GAMA03
 程式代號：GAMA03
 程式日期：0950307
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Cima0101Form;

public class GAMA0103 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myForm = (Cima0101Form)form;
		//呼叫 Service 查詢資料
		IssueManager myManager = new IssueManager();
		String pcols[] = {"accountYear","serialNo","issueSerial","debtName","debtType"};
		myForm.setAccountYear(myForm.getQryaccountYear());
		myForm.setSerialNo(myForm.getQryserialNo());
		myForm.setIssueSerial(myForm.getQryissueSerial());
		myForm.setDebtName(myForm.getQrydebtName());
		String pValues[] = {myForm.getAccountYear()+ "%",
				myForm.getSerialNo()+ "%",
				myForm.getIssueSerial()+ "%",
				myForm.getDebtName(),
				"E"};
		
		String pConds[] = {"like","like","like","=","="};
		List list =  myManager.Search(pcols,pValues,pConds,pcols);
		request.setAttribute("collection",list);
	}

}
