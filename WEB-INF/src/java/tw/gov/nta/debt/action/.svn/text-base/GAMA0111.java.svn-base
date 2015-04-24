/* GAMA0111.java
 程式目的：GAMA01
 程式代號：GAMA01
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
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.InterestCounter;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.MiddleDebtManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.DefaultBankRef;
import tw.gov.nta.system.common.BankCodeManage;

public class GAMA0111 extends DefaultAction {

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

			InterestCounter myCounter = new InterestCounter();
			BigDecimal tempCount = new BigDecimal(0);
			List list = new LinkedList();
			if(null != myForm.getMyDMain().getId())
			{
				RateManager myRate = new RateManager();
				list = myRate.getEffectiveRate(myForm.getMyDMain().getId());
			}
			else
			{
				DebtRateDet debtRateDet = new DebtRateDet();
				debtRateDet.setDebtRate(myForm.getCompareRate());
				debtRateDet.setEffectiveDate(myForm.getIssueDate());	//起始日
				debtRateDet.setSuspendDate(myForm.getDueDate());		//結束日
				list.add(debtRateDet);
			}
			tempCount = myCounter.countInterest(myForm.getIssueDate(),myForm.getDueDate(),
					list,myForm.getIssueAmountDet().doubleValue(),0);
			myForm.setOriginInterestAmount(tempCount.setScale(0,5));
			myForm.setTotalAmount(myForm.getIssueAmountDet().add(myForm.getOriginInterestAmount()).setScale(0,5));
			
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
			myManager.confirm(myForm.getMyDMain());
			myForm.setDebtId(myForm.getMyDMain().getId());
			setAlertMessage(request,"修改成功");
		}
		else
		{
			setAlertMessage(request,"無此資料");
		}
		
	}

}
