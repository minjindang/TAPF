package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import antlr.collections.List;

import tw.gov.nta.debt.common.DebtPlanDetVectors;
import tw.gov.nta.shortterm.form.Dpma0101Form;
import tw.gov.nta.sql.debt.DebtPlanDet;

public class DPMA0101Calculate extends DefaultAction  {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Dpma0101Form myform= (Dpma0101Form)form;
//		PlanManager planManager = new PlanManager();
//		myform.setMyMain(new IssueManager().getBean(myform.getIssueId()));
//		List collection = new LinkedList();
		try
		{
			BigDecimal countDay = null;
			Date issueDate = (Date)myform.getIssueDate();
			Date repayDate = (Date)myform.getRepayDate(); 
			String days = (String)myform.getRepayDays();
			BigDecimal rate = (BigDecimal)myform.getRate();
			BigDecimal capitalAmountPay = (BigDecimal)myform.getCapitalAmountPay();
			tw.gov.nta.debt.common.InterestCounter myCounter = new tw.gov.nta.debt.common.InterestCounter();
			if(!myCounter.isLeap(issueDate,repayDate)){
				countDay = new BigDecimal(365);
			}else{
				countDay = new BigDecimal(366);
			}
			BigDecimal interestAmount = capitalAmountPay.multiply(rate.divide(new BigDecimal(100))).
				multiply(new BigDecimal(days)).divide(countDay,5).setScale(0,BigDecimal.ROUND_HALF_UP);
			
			BigDecimal totalAmountGuess = capitalAmountPay.add(interestAmount);
		

//			for(int i=0; i<myform.getDebtPlanDets().size(); i++)
//			{
//				myform.getd
//			}
			
			
			
			request.setAttribute("interestAmountPay",interestAmount);
			request.setAttribute("capitalAmountGuess",capitalAmountPay);
			request.setAttribute("totalAmountGuess",totalAmountGuess);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("PayManager byIssueIdPDate have a exception !!");
		}
	}

}
