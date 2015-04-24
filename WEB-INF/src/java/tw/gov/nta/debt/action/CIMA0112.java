/* CIMA0112.java
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

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.MiddleDebtManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtMain;

public class CIMA0112 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myForm = (Cima0101Form)form;
		DebtManager myDManager = new DebtManager();
		DebtMain myDMain = myDManager.getBean(myForm.getDebtId());
		//呼叫 Service 刪除資料
		MiddleDebtManager myManager = new MiddleDebtManager();
		if(0 != myForm.getDebtId() && null != myDMain  )
		{
			myManager.cancel(myForm.getDebtId());
			setAlertMessage(request,"刪除成功");
			myForm.setDebtId(0);
		}
		else
		{
			setAlertMessage(request,"無此資料");
		}	
			
	}

}
