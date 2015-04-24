package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class GAMA0902MLOAD extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		DebtManager myDebt = new DebtManager();
		int budgetCode = 0;
		if(null != myform.getBudgetCodeDebt())
		{
			budgetCode = myform.getBudgetCodeDebt();
		}
		if(0 == myform.getDebtId())
		{
			myform.setDebtId(myform.getMyDMain().getId());
		}

		if(0 != myform.getDebtId())
		{
			myform.setMyDMain(myDebt.getBean(myform.getDebtId()));
		}
		if(null != myform.getBankId() && 0 != myform.getBankId())
		{
				myform.setBankRef(myform.getMyDMain().getBank());	
		}
		if(0 != budgetCode)
		{
			myform.getMyDMain().setBudgetCode(budgetCode);
		}
		request.setAttribute("debtId",myform.getDebtId());
		request.setAttribute("id",myform.getId());
		request.setAttribute("debtCode",myform.getDebtCode());
		request.setAttribute("budgetCode",myform.getBudgetCode());
		request.setAttribute("budgetYear",myform.getBudgetYear());
		//request.setAttribute("Cima0101Form",myform);
		myform.setPlanAmount((BigDecimal)(request.getAttribute("planAmount")));
	}

}
