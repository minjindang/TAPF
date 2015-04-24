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

import tw.gov.nta.debt.common.InterestCounter;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class GAMA0102MCOUNT extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		myform.setRatelist((List)request.getSession().getAttribute("ratelist"));
		myform.setCaplist((List)request.getSession().getAttribute("caplist"));
		request.setAttribute("ratelist",myform.getRatelist());
		request.setAttribute("caplist",myform.getCaplist());
		InterestCounter myCounter = new InterestCounter();
		BigDecimal tempCount = new BigDecimal(0);
		List list = new LinkedList();
		if(null == myform.getIssueAmountDet())
		{
			myform.setIssueAmountDet(new BigDecimal(0));
		}
		if(null != myform.getAccrue())
		{
			myform.setAccrue("on");
		}	
		if(null != myform.getMyDMain().getId())
		{
			RateManager myRate = new RateManager();
			list = myRate.getEffectiveRate(myform.getMyDMain().getId());
		}
		else
		{
			DebtRateDet debtRateDet = new DebtRateDet();
			debtRateDet.setDebtRate(myform.getCompareRate());
			debtRateDet.setEffectiveDate(myform.getIssueDate());	//起始日
			debtRateDet.setSuspendDate(myform.getDueDate());		//結束日
			list.add(debtRateDet);
		}
		tempCount = myCounter.countInterest(myform.getIssueDate(),myform.getDueDate(),
				list,myform.getIssueAmountDet().doubleValue(),0);
		myform.setOriginInterestAmount(tempCount.setScale(0,5));
		myform.setTotalAmount(myform.getIssueAmountDet().add(myform.getOriginInterestAmount()).setScale(0,5));
		
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
