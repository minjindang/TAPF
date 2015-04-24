/* CPMA0101.java
 程式目的：CPMA01 LOADPAGE 
 程式代號：CPMA01
 程式日期：0950303
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DayCount;
import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Cpma0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;

public class CPMA0101 extends DefaultAction {

	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		//連結至畫面cpma0102a 傳入參數短期借款資料之id,償還日期repaydate償還方式debttype
		Cpma0101Form myform= (Cpma0101Form)form;
		IssueManager issueManager = new IssueManager();
		PlanManager planManager = new PlanManager();
		IssueMain issueMain = new IssueMain();
		if(myform.getIssueId() != 0)
			issueMain = issueManager.getBean(myform.getIssueId());
		else
			issueMain = issueManager.getBean(Integer.parseInt(myform.getDebtName()));
		request.setAttribute("DayCount","");
		if(null != issueMain.getIssueDate() && null != issueMain.getDueDate())		//查檢金額是否為null
			request.setAttribute("DayCount",DayCount.dayCount(issueMain.getIssueDate(),issueMain.getDueDate(),issueMain.getShowType()));
		if(null == issueMain.getExpectAmount())		//查檢金額是否為null
			issueMain.setExpectAmount(new BigDecimal(0));
		if(null == issueMain.getIssueAmount())
			issueMain.setIssueAmount(new BigDecimal(0));
		if(null == issueMain.getCapitalAmount())
			issueMain.setCapitalAmount(new BigDecimal(0));
		
		myform.setMyMain(issueMain);
		try
		{
			List collection = new LinkedList();
			List list = (List) planManager.getIssueIdPDateDMarkN(myform.getIssueId(),myform.getPlanRepayDate(),"N");
			for(Iterator it = list.iterator();it.hasNext();){
				DebtPlanDet dto = (DebtPlanDet)it.next();
				BigDecimal payAmount = new PayManager().getCapitalByDebt(dto.getDebt().getId());
				DebtMain debtMain = dto.getDebt();
				if(payAmount.compareTo(debtMain.getIssueAmount()) != 0){
					collection.add(dto);
				}
			}
//			List debtList = (List)new DebtManager().getBeanByIssue(issueMain.getId());
//			for(Iterator debtIt = debtList.iterator();debtIt.hasNext();){
//				DebtMain debtMain = (DebtMain)debtIt.next();
//				List list = (List) planManager.getAllPlanListByDebt(debtMain);
//				BigDecimal payAmount = new BigDecimal(0);
//				for(Iterator it = list.iterator();it.hasNext();){
//					DebtPlanDet dto = (DebtPlanDet)it.next();
//					payAmount = payAmount.add(dto.getCapitalAmount());
//				}
//				if(payAmount.compareTo(debtMain.getIssueAmount()) != 0){
//					for(Iterator it = list.iterator();it.hasNext();){
//						DebtPlanDet dto = (DebtPlanDet)it.next();
//						dto.getDebt().setInterestDate(new PlanManager().getMaxInterestDate(dto));
//						collection.add(dto);
//					}
//				}
//			}
//			for(Iterator it = list.iterator();it.hasNext();){
//				DebtPlanDet dto = (DebtPlanDet)it.next();
//				
//				if(new PayManager().getListByPlan(dto.getId().intValue()).isEmpty()){
//					dto.getDebt().setInterestDate(new PlanManager().getMaxInterestDate(dto));
//					System.out.println(dto.getDebt().getId());
//					System.out.println(dto.getDebt().getInterestDate());
//					System.out.println(dto.getDebt().getBank().getId());
//					collection.add(dto);
//				}
//			}

			myform.setIssueId(issueMain.getId());
			request.setAttribute("collection",collection);
			request.setAttribute("showType",issueMain.getShowType());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("PayManager byIssueIdPDate have a exception !!");
		}
	}

}
