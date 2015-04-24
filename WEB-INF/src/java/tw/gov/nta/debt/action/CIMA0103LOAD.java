package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class CIMA0103LOAD extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		DebtManager myDebt = new DebtManager();
		Cima0101Form myform = (Cima0101Form)form;
		myform.setRatelist((List)request.getSession().getAttribute("ratelist"));
		myform.setCaplist((List)request.getSession().getAttribute("caplist"));
		myform.setNewcaplist((List)request.getSession().getAttribute("newcaplist"));
		request.setAttribute("ratelist",myform.getRatelist());
		request.setAttribute("caplist",myform.getCaplist());
		request.setAttribute("newcaplist",myform.getNewcaplist());
		if(0 != myform.getDebtId())
		{
			myform.setMyDMain(myDebt.getBean(myform.getDebtId()));
			if(0 != myform.getBankId())
			{
				myform.setBankRef(myform.getMyDMain().getBank());
			}
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
		
		myform.setPlanAmount((BigDecimal)(request.getAttribute("planAmount")));
		
	}

}
