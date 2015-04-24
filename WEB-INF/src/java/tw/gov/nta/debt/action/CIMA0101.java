/* CIMA0101.java
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
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.IssueMain;

public class CIMA0101 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		try
		{
				Cima0101Form myForm = (Cima0101Form)form;
				//呼叫 Service 新增資料
				myForm.setUserid(this.getUserId(request));
				myForm.setModDate(new Date());
				IssueManager myManager = new IssueManager();
				myForm.setDebtType("C");		//債務別寫死的
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
				myForm.getMyIss().setCapitalAmount(new BigDecimal(0));
				myForm.getMyIss().setInterestAmount(new BigDecimal(0));
				myForm.getMyIss().setRateKind("0");
				
				myForm.getMyIss().setBudgetCode(0);
				myForm.getMyIss().setDebtCode(0);
				
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
		}
		catch(Exception e)
		{
			setAlertMessage(request,"新增失敗");
		}
	}

}
