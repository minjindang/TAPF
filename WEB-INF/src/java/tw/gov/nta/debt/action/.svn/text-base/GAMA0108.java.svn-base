/* GAMA0108.java
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

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.MiddleDebtManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtMain;

public class GAMA0108 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		//呼叫 Service 新增資料
		MiddleDebtManager myManager = new MiddleDebtManager();
		DebtManager myDManager = new DebtManager();
		DebtMain myDebt = new DebtMain();
		try
		{
			if(null !=  myform.getCountRow() && 0 != myform.getCountRow().length )  
			{
				for(int index=0;index<myform.getCountRow().length;index++)
				{	
						myDebt = myDManager.getBean(myform.getCountRow()[index]);
						if(null != myform.getIscheck()[index]  && myform.getCountRow()[index] == Integer.parseInt(myform.getIscheck()[index]))
						{	
							myDebt.setAccrue("Y");
						}
						else
						{
							myDebt.setAccrue("N");
						}
						myManager.confirm(myDebt);
				}	
				setAlertMessage(request,"修改成功");
			}
		}
		catch(Exception e)
		{
			setAlertMessage(request,"修改失敗");
		}
	
	}

}
