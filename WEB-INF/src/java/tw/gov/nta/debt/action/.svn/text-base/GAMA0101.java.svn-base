/* GAMA0101.java
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
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;

public class GAMA0101 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
//		try
//		{
				Cima0101Form myForm = (Cima0101Form)form;
				//呼叫 Service 新增資料
				myForm.setUserid(this.getUserId(request));
				myForm.setModDate(new Date());
				IssueManager myManager = new IssueManager();
				myForm.setDebtType("E");		//債務別寫死的
				if("on".equals(myForm.getBondType()))
				{
					myForm.setBondType("1");	//true
				}
				else
				{
					myForm.setBondType("2");	//false
				}
				myForm.setExpectAmount(myForm.getExpectAmount().setScale(4,5));
				
				myForm.getMyIss().setAverageRate(new BigDecimal(0));
				myForm.getMyIss().setIssueKind("0");
				myForm.getMyIss().setCapitalAmount(new BigDecimal(0));
				myForm.getMyIss().setInterestAmount(new BigDecimal(0));
				myForm.getMyIss().setRateKind("0");
				
//				myForm.getMyIss().setBudgetCode(0);
//				myForm.getMyIss().setDebtCode(0);
				
				myManager.confirm(myForm.getMyIss());
				setAlertMessage(request,"新增成功");
				IssueMain myIssue = new IssueMain();
				myIssue = myManager.getBean(myForm.getId());
				if(null == myIssue.getIssueAmount())
				{
					myIssue.setIssueAmount(new BigDecimal(0));
				}
				if(null == myIssue.getCapitalAmount())
				{
					myIssue.setCapitalAmount(new BigDecimal(0));
				}
				myForm.setMyIss(myIssue);
				//剛新增後不會有Detail request.setAttribute("collection",myDManager.getBeanByIssue(myForm.getId()));
				DebtMain debtMain = new DebtMain();
				debtMain.setIssue(myForm.getMyIss());
				debtMain.setDebtCode(myForm.getDebtCode());
				debtMain.setBudgetCode(myForm.getBudgetCode());
				debtMain.setIssueAmount(myForm.getExpectAmount());
				new DebtManager().confirm(debtMain);
				
				DebtPlanDet debtPlanDet = new DebtPlanDet();
				debtPlanDet.setIssueId(debtMain.getIssue().getId());
				debtPlanDet.setDebt(debtMain);
				debtPlanDet.setRepayDate(myForm.getDueDate());
				debtPlanDet.setCapitalAmount(debtMain.getIssueAmount());
				debtPlanDet.setCapitalSerial(new Integer(0));
				debtPlanDet.setInterestSerial(new Integer(0));
				new PlanManager().confirm(debtPlanDet);
//		}
//		catch(Exception e)
//		{
//			setAlertMessage(request,"新增失敗");
//		}
	}

}
