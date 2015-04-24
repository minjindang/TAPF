package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

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

public class GAMA0102MLOAD extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		RateManager myRate = new RateManager();
		PlanManager myPlan = new PlanManager();
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
		myform.setRatelist(myRate.getEffectiveRate(myform.getDebtId()));
		request.getSession().setAttribute("ratelist",myform.getRatelist());
		myform.setCaplist(myPlan.byDebtId(myform.getDebtId()));
		request.getSession().setAttribute("caplist",myform.getCaplist());
		request.setAttribute("ratelist",myform.getRatelist());
		request.setAttribute("caplist",myform.getCaplist());
		request.setAttribute("rRateList",new LinkedList());
		request.setAttribute("rCapList",new LinkedList());
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
		
		/** 顯示 第三個 List 參考cpma0101MLform.jsp cpma0101MLOAD.java**/
		Session session = new PaymentMainDAO().createNewSession();
		StringBuffer str3 = new StringBuffer();
		str3.append("from PaymentMain pay where pay.issueId = ");
		str3.append(myform.getId());
		str3.append(" and pay.debtId = ");
		str3.append(myform.getDebtId());
		Query query = session.createQuery(str3.toString());
		List list3 = query.list();
		request.setAttribute("collection",list3);
		session.close();
		
		
	}

}
