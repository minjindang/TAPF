package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
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

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GAMA0903 extends DefaultAction {

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
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob sqljob = SQL(myForm.getDebtId());
		List rateList = (List) run.query(sqljob, new MapListHandler());

		List result_d = new ArrayList(); 
		if (null != rateList && !rateList.isEmpty())
		{
			BigDecimal issueAmount = myForm.getIssueAmountDet();
			int leapYear = 1;//已知，096/09/21~097/07/01經過潤年，所以要用366計算
			for (Iterator it3 = rateList.iterator(); it3.hasNext();)
			{
				Map tMap = (Map)it3.next();
				Map dMap = new HashMap();
				issueAmount = issueAmount.subtract((BigDecimal)tMap.get("capital_amount"));
				Integer days = (Integer)tMap.get("days");
				dMap.put("issueAmount",issueAmount.setScale(0,BigDecimal.ROUND_DOWN));
				dMap.put("effectiveDate",tMap.get("effective_date"));
				dMap.put("suspendDate",tMap.get("suspend_date"));
				dMap.put("days",days);
				dMap.put("debtRate",tMap.get("debt_rate"));
				Double interestDays;
				if (leapYear == 2){
					interestDays = (Double.valueOf(days)/Double.valueOf(366));
					leapYear++;
				}else {
					interestDays = (Double.valueOf(days)/Double.valueOf(365));
					leapYear++;
				}
				BigDecimal debtRate = (BigDecimal)tMap.get("debt_rate");
				debtRate = debtRate.setScale(3,BigDecimal.ROUND_DOWN);
				BigDecimal interestAmount = new BigDecimal(0);
				//結欠本金*利率/100*天數/365
				interestAmount = (issueAmount.multiply(debtRate.divide(new BigDecimal(100)))).multiply(BigDecimal.valueOf(interestDays));
				dMap.put("interestAmount",interestAmount.setScale(0,BigDecimal.ROUND_CEILING));
				dMap.put("id",tMap.get("id"));
				dMap.put("groupId",tMap.get("group_Id"));
				dMap.put("deleteMark",tMap.get("delete_Mark"));
				dMap.put("debtId",tMap.get("debt_id"));
				result_d.add(dMap);
			}
		}
		
//		myForm.setRatelist(myRate.getEffectiveRate(debtManager.getBean(myForm.getDebtId()),session));
		myForm.setRatelist(result_d);
		request.getSession().setAttribute("ratelist",myForm.getRatelist());
		myForm.setCaplist(myPlan.byDebtId(myForm.getDebtId()));
		request.getSession().setAttribute("caplist",myForm.getCaplist());
		request.setAttribute("ratelist",myForm.getRatelist());
		request.setAttribute("caplist",myForm.getCaplist());
		request.setAttribute("rRateList",new LinkedList());
		request.setAttribute("rCapList",new LinkedList());
		
//		/** 顯示 第三個 List 參考cpma0101MLform.jsp cpma0101MLOAD.java**/
//		
//		StringBuffer str3 = new StringBuffer();
//		str3.append("from PaymentMain pay where pay.issueId = ");
//		str3.append(myForm.getId());
//		str3.append(" and pay.debtId = ");
//		str3.append(myForm.getDebtId());
//		Query query = session.createQuery(str3.toString());
//		List list3 = query.list();
//		request.setAttribute("collection",list3);
//		session.close();
//		
//		
//		myForm.setPlanAmount(tempAmount.subtract(sumAmount));
//		request.setAttribute("planAmount",tempAmount.subtract(sumAmount));
	}
	

	protected SQLJob SQL(int debtId){
		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("select debt_rate, effective_date, suspend_date,DateDiff(day,effective_date,suspend_date) as days, id as id, group_id as groupId, ");
		sqljob.appendSQL("select *, DateDiff(day,effective_date,suspend_date) as days, ");
		sqljob.appendSQL("isnull((select sum(capital_amount) from payment_main where debt_id = "+ debtId +" and repay_date =  effective_date),0) as capital_amount ");
		sqljob.appendSQL("from debt_rate_det where debt_id = " + debtId);
//		System.out.println(sqljob.toString());
		return sqljob;
	}

}
