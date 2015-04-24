/* GAMA0109.java
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

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.MiddleDebtManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.DefaultBankRef;
import tw.gov.nta.system.common.BankCodeManage;

public class GAMA0109 extends DefaultAction {

	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myForm = (Cima0101Form)form;
		//呼叫 Service 新增資料
		BankRef mybank = new DefaultBankRef();
		mybank = BankCodeManage.get(myForm.getBankId());
		IssueManager issueManager = new IssueManager();
		myForm.getMyDMain().setIssue(issueManager.getBean(myForm.getId()));
		myForm.getMyDMain().setBank(mybank);
		MiddleDebtManager myManager = new MiddleDebtManager();
		
		myForm.setCompareRate((myForm.getCompareRate().setScale(3,5)));
		if(0 != myForm.getIssueAmountDet().intValue())
		{
			myForm.setAccrue("Y");	//若得標金額不為0,則設得標否欄位(accrue)為Y
		}	
		else
		{
			myForm.setAccrue("N");	
		}
		if(myManager.checkBean(myForm.getMyDMain())){
			myManager.confirm(myForm.getMyDMain());
			myForm.setDebtId(myForm.getMyDMain().getId());
			setAlertMessage(request,"新增成功");
			return mapping.findForward("success");
		}
		else{
			setAlertMessage(request,"新增失敗，年度、預算別、債務別無借款計畫資料");
			return mapping.findForward("fail");
		}
		
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	}

}
