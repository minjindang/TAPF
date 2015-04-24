/* CPMA0104.java
 程式目的：CPMA01 新增
 程式代號：CPMA01
 程式日期：0950303
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.form.Cpma0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;

public class CPMA0104 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		// PayManager.repayDebt()
		Cpma0101Form myform= (Cpma0101Form)form;
		PayManager myManager = new PayManager();
		DebtManager debtManager = new DebtManager();
		DebtMain myDebt = new DebtMain();
		DebtMainDAO tDebtMainDAO = new DebtMainDAO();
		if(null != myform.getIscheck() && 0 != myform.getIscheck().length)
		{
			for(int index=0;index<myform.getIscheck().length;index++)
			{	
				if(null != myform.getIscheck()[index] && !"".equals(myform.getIscheck()[index]))
				{	
					myManager.repayDebt(myform.getPaymentId()[Integer.parseInt(myform.getIscheck()[index].toString())-1]
						,1
						,1
						,myform.getCapitalAmountPay()[Integer.parseInt(myform.getIscheck()[index].toString())-1].doubleValue()
						,myform.getInterestAmountPay()[Integer.parseInt(myform.getIscheck()[index].toString())-1].doubleValue()
						,myform.getQryrepayDate()
						,myform.getPlanRepayDate()
						,myform.getDays()[Integer.parseInt(myform.getIscheck()[index].toString())-1]
						,new Date(myform.getInterestDate()[Integer.parseInt(myform.getIscheck()[index].toString())-1])
						,myform.getEndDate()
						);
					myDebt = debtManager.getBean(myform.getDebtMainId()[Integer.parseInt(myform.getIscheck()[index].toString())-1]);
					if(myform.getCapitalAmountPay()[Integer.parseInt(myform.getIscheck()[index].toString())-1].compareTo(new BigDecimal(0)) !=0 | myDebt.getIssue().getDebtType().equals("C")){
						BigDecimal issueAmount = myDebt.getIssueAmount();
						BigDecimal payAmount = new PayManager().getCapitalByDebt(myDebt.getId());
						if(issueAmount.compareTo(payAmount)== -1  || (myDebt.getIssue().getDebtType().equals("C") && issueAmount.compareTo(payAmount)!= -1))
						myDebt.setInterestDate(myform.getQryrepayDate());
						tDebtMainDAO.update(myDebt);
					}
				}	
			}	
			setAlertMessage(request,"新增成功");
		}	
		
	}

}
