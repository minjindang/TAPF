package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Cpma0101Form;

public class CPMA0101LIST extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cpma0101Form myform= (Cpma0101Form)form;
		PlanManager myPlan = new PlanManager();
		request.setAttribute("oklist",0);
		myform.setOklist(0);
		if(null != myform.getDebtName() && !"".equals(myform.getDebtName())) 
		{
			request.setAttribute("oklist",myform.getDebtName());
			myform.setOklist(myform.getIssueId());
		}
	}

}
