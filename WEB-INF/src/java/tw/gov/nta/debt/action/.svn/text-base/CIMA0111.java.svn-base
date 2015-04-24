/* CIMA0111.java
 程式目的：CIMA01
 程式代號：CIMA01
 程式日期：0950307
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.MiddleDebtManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DefaultBankRef;
import tw.gov.nta.system.common.BankCodeManage;

public class CIMA0111 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myForm = (Cima0101Form)form;
		DebtManager myDManager = new DebtManager();
		DebtMain myDMain = myDManager.getBean(myForm.getDebtId());
		//呼叫 Service
		if(0 != myForm.getDebtId() && null != myDMain  )
		{
			BankRef mybank = new DefaultBankRef();
			mybank = BankCodeManage.get(myForm.getBankId());
			IssueManager issueManager = new IssueManager();
			myDMain.setIssue(issueManager.getBean(myForm.getId()));
			myDMain.setBank(mybank);
			myDMain.setBudgetCode(myForm.getBudgetCodeDebt());
			myDMain.setDebtCode(myForm.getDebtCodeDebt());
			myDMain.setCompareAmount(myForm.getCompareAmount());
			myDMain.setCompareRate(myForm.getCompareRate());
			myDMain.setAccrue(myForm.getAccrue());
			myDMain.setIssueAmount(myForm.getIssueAmountDet());
			myDMain.setOriginInterestAmount(myForm.getOriginInterestAmount());
			myDMain.setBudgetYear(myForm.getBudgetYear());
			myForm.setMyDMain(myDMain);
			MiddleDebtManager myManager = new MiddleDebtManager();
			myForm.setCompareRate((myForm.getCompareRate().setScale(3,5)));
			if(!myForm.getIssueAmountDet().equals(new BigDecimal(0)))
			{
				myForm.setAccrue("Y");	//若得標金額不為0,則設得標否欄位(accrue)為Y
			}	
			else
			{
				myForm.setAccrue("N");	
			}
			if("Y".equals(myForm.getCheckGetMark()))	//廢標否
			{
				myForm.getMyDMain().setCompareFlag("Y");
			}
			else
			{
				myForm.getMyDMain().setCompareFlag("N");
			}
			try
			{
				myManager.confirm(myForm.getMyDMain());
				myForm.setDebtId(myForm.getMyDMain().getId());
				setAlertMessage(request,"修改成功");
			}
			catch(Exception e)
			{
				setAlertMessage(request,"修改失敗");
				System.out.println(e.toString());
			}
		}
		else
		{
			setAlertMessage(request,"無此資料");
		}
		
	}

}
