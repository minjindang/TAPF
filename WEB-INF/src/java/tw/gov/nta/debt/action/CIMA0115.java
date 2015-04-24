/* CIMA0115.java
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
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtRateDet;

public class CIMA0115 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		List ratelist = (List)request.getSession().getAttribute("ratelist");	
		if( myform.getNowindex() <= ratelist.size())
		{
			DebtRateDet myRate = (DebtRateDet)ratelist.get(myform.getNowindex()-1);
			myRate.setEffectiveDate(myform.getEffectiveDate());
			myRate.setSuspendDate(myform.getSuspendDate());
			myRate.setDebtRate(myform.getDebtRate());
			ratelist.set(myform.getNowindex()-1,myRate);
			request.getSession().setAttribute("ratelist",ratelist);
			setAlertMessage(request,"修改成功");
		}
		else
		{
			setAlertMessage(request,"無此資料");
		}	
	}

}
