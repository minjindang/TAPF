package tw.gov.nta.debt.action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueDetManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueDet;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

import gov.dnt.tame.common.DefaultAction;

public class CIMA0134 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Session session = new PaymentMainDAO().createNewSession();
		//Cima0101Form myForm = (Cima0101Form)request.getAttribute("Cima0101Form");
		Cima0101Form myForm = (Cima0101Form)form;
		if(0 == myForm.getDebtId())
		{	
			myForm.setDebtId((Integer)request.getAttribute("debtId"));
		}	
		if(null == myForm.getId() || 0 == myForm.getId())
		{	
			myForm.setId((Integer)request.getAttribute("id"));
		}	
		if(null == myForm.getDebtCode() || 0 == myForm.getDebtCode())
		{	
			myForm.setDebtCode((Integer)request.getAttribute("debtCode"));
		}	
		if(null == myForm.getBudgetCode() || 0 == myForm.getBudgetCode())
		{	
			myForm.setBudgetCode((Integer)request.getAttribute("budgetCode"));
		}	
		if(null == myForm.getBudgetYear() || "".equals(myForm.getBudgetYear()))
		{	
			myForm.setBudgetYear((String)request.getAttribute("budgetYear"));
		}
		
		//呼叫 Service 新增資料
		BigDecimal tempAmount = new BigDecimal(0);	//issueDet 的planAmount加總
		BigDecimal sumAmount = new BigDecimal(0);	//debtMain 的issueAmount加總
		
		IssueDetManager issueDetManager = new IssueDetManager();
		DebtManager debtManager = new DebtManager();
		RateManager myRate = new RateManager();
		PlanManager myPlan = new PlanManager();
		
		String[] cols = {"issueId","budgetYear","budgetCode","debtCode"}; //issueDet用
		String[] cols2 = {"issue.id","budgetYear","budgetCode","debtCode"}; //debtMain用
		Object[] objs = {myForm.getId(),myForm.getBudgetYear(),myForm.getBudgetCode(),myForm.getDebtCode()};
		String[] pConds ={"=","=","=","="};
		String[] pOrderby = null;
		
		if(null != myForm.getBudgetYear() && !"".equals(myForm.getBudgetYear()) 	//必要條件需要全部都有不然不查
				&& 0 != myForm.getBudgetCodeDebt() && 0 != myForm.getDebtCodeDebt())
		{	
			List list = issueDetManager.Search(cols,objs,pConds,pOrderby);
			if(null != list && 0!=list.size())
			{
				for(Iterator it=list.iterator();it.hasNext();)
				{
					IssueDet issueDet = (IssueDet)it.next();
					if(null != issueDet.getPlanAmount())
					{
						tempAmount = tempAmount.add(issueDet.getPlanAmount());
					}	
				}	
			}	
			
			List debtList = debtManager.Search(cols2,objs,pConds,pOrderby);
			if(null != debtList && 0!= debtList.size())
			{
				for(Iterator it2 = debtList.iterator();it2.hasNext();)
				{	
					DebtMain debtMain = (DebtMain)it2.next();
					if(debtMain.getId() != myForm.getDebtId())
					{
						if(null != debtMain.getIssueAmount())
						{
							sumAmount = sumAmount.add(debtMain.getIssueAmount());
						}
					}	
				}
			}	
			
		}
		
		myForm.setRatelist(myRate.getEffectiveRate(debtManager.getBean(myForm.getDebtId()),session));
		request.getSession().setAttribute("ratelist",myForm.getRatelist());
		myForm.setCaplist(myPlan.byDebtId(myForm.getDebtId()));
		request.getSession().setAttribute("caplist",myForm.getCaplist());
		request.setAttribute("ratelist",myForm.getRatelist());
		request.setAttribute("caplist",myForm.getCaplist());
		request.setAttribute("rRateList",new LinkedList());
		request.setAttribute("rCapList",new LinkedList());
		
		/** 顯示 第三個 List 參考cpma0101MLform.jsp cpma0101MLOAD.java**/
		
		StringBuffer str3 = new StringBuffer();
		str3.append("from PaymentMain pay where pay.issueId = ");
		str3.append(myForm.getId());
		str3.append(" and pay.debtId = ");
		str3.append(myForm.getDebtId());
		Query query = session.createQuery(str3.toString());
		List list3 = query.list();
		request.setAttribute("collection",list3);
		session.close();
		
		
		myForm.setPlanAmount(tempAmount.subtract(sumAmount));
		request.setAttribute("planAmount",tempAmount.subtract(sumAmount));
	}
}
