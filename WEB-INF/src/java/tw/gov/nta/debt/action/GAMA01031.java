/* CIMA0103.java
 程式目的：CIMA03
 程式代號：CIMA03
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

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Cima0101Form;

public class GAMA01031 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myForm = (Cima0101Form)form;
		//呼叫 Service 查詢資料
		DebtManager debtManager= new DebtManager();
		IssueManager issueManager = new IssueManager();
		if((null != myForm.getBudgetCode() && 0 != myForm.getBudgetCode()) || (null != myForm.getBudgetCode() && 0 != myForm.getBudgetCode()))
		{	
			String pCols[] = {"debtMain.issue.accountYear","debtMain.issue.serialNo","debtMain.issue.issueSerial",
					"debtMain.issue.debtName","debtMain.issue.debtType","debtMain.issue.issueKind",
					"debtMain.debtCode","debtMain.budgetCode","debtMain.issue.bondType"};
			myForm.setAccountYear(myForm.getQryaccountYear());
			myForm.setSerialNo(myForm.getQryserialNo());
			myForm.setIssueSerial(myForm.getQryissueSerial());
			myForm.setDebtName(myForm.getQrydebtName());
			String pValues[] = {!"".equals(myForm.getAccountYear())?"'"+myForm.getAccountYear()+"%'":"",
					!"".equals(myForm.getSerialNo())?"'"+myForm.getSerialNo()+"%'":"",
					!"".equals(myForm.getIssueSerial())?"'"+myForm.getIssueSerial()+"%'":"",		
					!"".equals(myForm.getDebtName())?"'"+myForm.getDebtName()+"'":"",				
					"'E'",
					!"".equals(myForm.getIssueKind())?"'"+myForm.getIssueKind()+"'":"",	
					0 == myForm.getDebtCode()?"":Integer.toString(myForm.getDebtCode()),	
					0 == myForm.getBudgetCode()?"":Integer.toString(myForm.getBudgetCode()),	
					!"".equals(myForm.getBondType())?"'"+myForm.getBondType()+"'":""			
					};
			
			String pConds[] = {"like","like","like","=","=","=","=","=","="};	
			String orders[] = {"debtMain.issue.accountYear desc ","debtMain.issue.serialNo desc ","debtMain.issue.issueSerial desc ",
					"debtMain.issue.debtName desc ","debtMain.issue.issueDate desc ","debtMain.issue.dueDate desc "};
			List list =  debtManager.SearchHQL(pCols,pValues,pConds,orders);
			request.setAttribute("collection",list);
		}
		else
		{
			String pcols[] = {"accountYear","serialNo","issueSerial","debtName","debtType","issueKind","bondType"};
			myForm.setAccountYear(myForm.getQryaccountYear());
			myForm.setSerialNo(myForm.getQryserialNo());
			myForm.setIssueSerial(myForm.getQryissueSerial());
			myForm.setDebtName(myForm.getQrydebtName());
			String pValues[] = {myForm.getAccountYear()+ "%",
					myForm.getSerialNo()+ "%",
					myForm.getIssueSerial()+ "%",
					myForm.getDebtName(),
					"E",
					myForm.getIssueKind(),
					!"".equals(myForm.getBondType())?myForm.getBondType():""		
					};
			
			String pConds[] = {"like","like","like","=","=","=","="};
			List list =  issueManager.Search(pcols,pValues,pConds,pcols);
			request.setAttribute("collection",list);
		}	
	}
}
