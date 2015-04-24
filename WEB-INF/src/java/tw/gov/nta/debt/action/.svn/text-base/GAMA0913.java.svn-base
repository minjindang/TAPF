package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.InterestAdjustManager;
import tw.gov.nta.debt.common.InterestCounter;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;

public class GAMA0913 extends DefaultAction {

	@Override
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form,HttpServletRequest request, 
			HttpServletResponse response, Connection connection) throws Exception
	 {
		// TODO Auto-generated method stub
		RateManager myRate = new RateManager();
		List ratelist = (List)request.getSession().getAttribute("ratelist");
//		Date tempDate = ((DebtRateDet)(ratelist.get(0))).getEffectiveDate();
		Date tempDate = (Date)((Map)ratelist.get(0)).get("effectiveDate");
//		tempDate = DateUtil.computeDueDate(tempDate,-1);
		boolean isOkDate = true;
		DebtMain debtMain = new DebtMain();
		
		if(null != ratelist && 0 != ratelist.size())
		{	
//			for(Iterator it = ratelist.iterator();it.hasNext();)
//			{
//				DebtRateDet myDebtRate = (DebtRateDet)it.next();
//				
//				if(0 != DateUtil.getDays(myDebtRate.getEffectiveDate(),(DateUtil.computeDueDate(tempDate,1))))
//				{
//					isOkDate = false;
//					break;
//				}	
//				tempDate = myDebtRate.getSuspendDate();
//				debtMain = myDebtRate.getDebt();
//			}
			for (int i=0; i<ratelist.size(); i++)
			{
				Map myDebtRate = (Map)ratelist.get(i);
				
//				if(0 != DateUtil.getDays((Date)myDebtRate.get("effectiveDate"),DateUtil.computeDueDate(tempDate,1)))
				if(0 != DateUtil.getDays((Date)myDebtRate.get("effectiveDate"),tempDate))
				{
					isOkDate = false;
					break;
				}
				tempDate = (Date)myDebtRate.get("suspendDate");
				debtMain = (DebtMain)myDebtRate.get("debt");
			}
			
			if(isOkDate)
			{
				
				for (int i=0; i<ratelist.size(); i++)
				{
					DebtRateDet debtRateDet = new DebtRateDet();
					Map myDebtRate = (Map)ratelist.get(i);
					debtRateDet.setId((Integer)myDebtRate.get("id"));
					debtRateDet.setDebt((DebtMain)myDebtRate.get("debt"));
					DebtManager debtManager = new DebtManager();
					DebtMain debtMainDate = debtManager.getBean((Integer)myDebtRate.get("debtId"));
					debtRateDet.setDebt(debtMainDate);
					debtRateDet.setEffectiveDate((Date)myDebtRate.get("effectiveDate"));
					debtRateDet.setSuspendDate((Date)myDebtRate.get("suspendDate"));
					debtRateDet.setDeleteMark((String)myDebtRate.get("deleteMark"));
					debtRateDet.setGroupId((Integer)myDebtRate.get("groupId"));
					debtRateDet.setDebtRate((BigDecimal)myDebtRate.get("debtRate"));
					ratelist.set(i,debtRateDet);
				}
				myRate.confirm(ratelist);
				if(null != debtMain)
				{	
					changePlan(debtMain,request);
				}	
				request.getSession().removeAttribute("ratelist");
				setAlertMessage(request,"確認完成");
				return mapping.findForward("success");
			}
			else
			{
				setAlertMessage(request,"日期不正確");
				return mapping.findForward("failure");
			}
			
		}
		setAlertMessage(request,"無新增資料");
		return mapping.findForward("failure");
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	
    }
	
	public void changePlan(DebtMain debtMain, HttpServletRequest request)
	{
		PlanManager planManager = new PlanManager();
		InterestCounter interestCounter = new InterestCounter();
		List planList = planManager.byDebtId(debtMain.getId());
		if(null != planList && 0 != planList.size())
		{
			interestCounter.planListCountInterest(planList);
			try
			{ 
				planManager.confirmInterst(planList); 
				changeAdjust(planList,request);
			}
			catch(Exception e)
			{
				System.out.println("GAMA0913 (do update debtPlanDet):"+ e.toString());
			}
		}	
	}

	public void changeAdjust(List planList, HttpServletRequest request){
		
		InterestAdjustManager myInterestAdjustManager = new InterestAdjustManager();
		Date effectiveDate = (Date)request.getSession().getAttribute("EffectiveDate");
		BigDecimal newRate = (BigDecimal)request.getSession().getAttribute("NewRate");
		Boolean isDelete = (Boolean)request.getSession().getAttribute("isDelete");
		BigDecimal newInterestAmount = new BigDecimal(0);
		Date testDate = effectiveDate;
		
		//新的利息總和
		for(Iterator tIterator = planList.iterator();tIterator.hasNext();){
			DebtPlanDet tDebtPlanDet = (DebtPlanDet)tIterator.next();
			newInterestAmount = newInterestAmount.add(tDebtPlanDet.getInterestAmount());				
		}
		
		for(Iterator tIterator = planList.iterator();tIterator.hasNext();){
			
			DebtPlanDet tDebtPlanDet = (DebtPlanDet)tIterator.next();
			
			long planDate = (tDebtPlanDet.getRepayDate()).getTime();
			long formDate = (effectiveDate).getTime();	
			long test1Date = (long) 1072886400000.00000;

			//寫利率調整檔Interest_adjust_main
			if(planDate == formDate){
				if (isDelete){
					myInterestAdjustManager.createInterestAdjust(tDebtPlanDet,newInterestAmount,newRate);
				}else{
					System.out.println("不寫入Interest_adjust_main");
				}
					
			}

		}
	}

}
