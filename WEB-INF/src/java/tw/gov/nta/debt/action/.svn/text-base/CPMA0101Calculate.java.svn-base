package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DayCount;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Cpma0101Form;
import tw.gov.nta.sql.debt.DebtPlanDet;

public class CPMA0101Calculate extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cpma0101Form myform= (Cpma0101Form)form;
		PlanManager planManager = new PlanManager();
		myform.setMyMain(new IssueManager().getBean(myform.getIssueId()));
		List collection = new LinkedList();
		try
		{
			for(int index=0;index<myform.getPaymentId().length;index++)
			{	
				DebtPlanDet dto = planManager.getBean(myform.getPaymentId()[index]);
				dto.setCapitalAmount(myform.getCapitalAmountPay()[index]);
				collection.add(dto);
				
			}	
			request.setAttribute("DayCount",DayCount.dayCount(myform.getIssueDate(),myform.getDueDate(),myform.getShowType()));
			request.setAttribute("collection",collection);
			request.setAttribute("showType",myform.getShowType());
			request.setAttribute("thisPay","T");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("PayManager byIssueIdPDate have a exception !!");
		}
	}

}
