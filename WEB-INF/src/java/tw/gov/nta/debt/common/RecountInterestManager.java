package tw.gov.nta.debt.common;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.ExtendDueDateMain;
import tw.gov.nta.sql.debt.InterestAdjustMain;
import tw.gov.nta.sql.debt.PaymentMain;

public class RecountInterestManager  {

	
	public void InterestAdjust(DebtMain debt,Session session) {

		InterestCounter counter = new InterestCounter();

		DebtManager debtManager = new DebtManager();
	
		StringBuffer queryString = new StringBuffer();
		Date issueDate = debt.getIssue().getIssueDate();
		Date interestDate = debt.getInterestDate() ;
		
		queryString = new StringBuffer();
		queryString.append("from ExtendDueDateMain e where e.debt = :debt order by e.oldDueDate");
		Query extendQuery = session.createQuery(queryString.toString());	
		extendQuery.setParameter("debt",debt);
		List extendList = extendQuery.list();
		
		Date dueDate = debt.getIssue().getDueDate();
		
		if(extendList.size() > 0){
			dueDate = ((ExtendDueDateMain)extendList.get(0)).getOldDueDate();
		}
		
		//計算原始總預估利息
		DebtRateDet tempRateDet = new DebtRateDet();
		tempRateDet.setDebt(debt);
		tempRateDet.setDebtRate(debt.getCompareRate());
		tempRateDet.setDeleteMark("N");
		tempRateDet.setEffectiveDate(issueDate);
		tempRateDet.setGroupId(1);
		tempRateDet.setSuspendDate(dueDate);
		List tempRateList = new ArrayList();
		tempRateList.add(tempRateDet);
		
		
		BigDecimal originInterestAmount = counter.countInterest(issueDate,dueDate,tempRateList,debt.getIssueAmount().doubleValue(),3);
		debt.setOriginInterestAmount(originInterestAmount.setScale(0,BigDecimal.ROUND_HALF_UP));
//		session.saveOrUpdate(debt);

		queryString = new StringBuffer();

		queryString.append("select min(d.id) as plan_id,min(p.id) as payment_id,isnull(p.repay_date,d.repay_date) as pay_date ");
		queryString.append(" from debt_plan_det d,payment_main p");
		queryString.append(" where d.debt_id =:debt and d.debt_id *= p.debt_id and  d.delete_mark = 'N'  and d.id *= p.plan_id");
		queryString.append(" group by isnull(p.repay_date,d.repay_date)");
		queryString.append(" order by isnull(p.repay_date,d.repay_date)");
		//queryString.append("from DebtPlanDet plan where plan.debt = :debt and plan.deleteMark = 'N' order by plan.repayDate");
		Query payQuery = session.createSQLQuery(queryString.toString());			
		payQuery.setParameter("debt",debt.getId());
		List payList = payQuery.list();	

		queryString = new StringBuffer();
		queryString.append("from DebtRateDet rate where rate.debt = :debt and rate.deleteMark = 'N' order by rate.effectiveDate");
		Query rateQuery = session.createQuery(queryString.toString());
		rateQuery.setParameter("debt",debt);	
		List rateList = rateQuery.list();
		Date prePlanDate;
		if (interestDate != null && interestDate != null){
			prePlanDate = interestDate;
		}else{
			prePlanDate = issueDate;
		}
				
		PaymentMain prePayment = null;
		DebtPlanDet prePlan = null;
		for(Iterator payIterator = payList.iterator();payIterator.hasNext();) {
			Object[] result = (Object[])payIterator.next();
			PaymentMain payment = null;
			
			DebtPlanDet plan = null;
			
			Date payDate = (Date)result[2];
			queryString = new StringBuffer();
			queryString.append("from PaymentMain payment where payment.debtId = :debtId and payment.repayDate = :repayDate order by payment.repayDate");
			Query paymentQuery = session.createQuery(queryString.toString());			
			paymentQuery.setParameter("debtId",debt.getId());
			paymentQuery.setParameter("repayDate",payDate);
			List paymentList = paymentQuery.list();
			if(paymentList.size()!=0) {
				payment = (PaymentMain)paymentList.get(0);	
			}
			
			queryString = new StringBuffer();
			queryString.append("from DebtPlanDet plan where plan.debt = :debt and plan.repayDate = :repayDate and plan.deleteMark = 'N' order by plan.repayDate");
			Query planQuery = session.createQuery(queryString.toString());			
			planQuery.setParameter("debt",debt);
			planQuery.setParameter("repayDate",payDate);
			List planOne = planQuery.list();
			if(planOne.size()>0) {
				plan = (DebtPlanDet)planOne.get(0);	
			}
			DebtRateDet afterRateDet = null;
			List computeRateList = new ArrayList();
			List coumuteRateList2 = new ArrayList();
			for(Iterator rateIterator = rateList.iterator();rateIterator.hasNext();) {
				DebtRateDet rateDet = (DebtRateDet)rateIterator.next();
				if(rateDet.getEffectiveDate().before(prePlanDate) || rateDet.getEffectiveDate().equals(prePlanDate)) {
					computeRateList.add(rateDet);
					coumuteRateList2.add(rateDet);		
				}
					
				if(rateDet.getEffectiveDate().equals(payDate) || (rateDet.getEffectiveDate().after(prePlanDate) && rateDet.getEffectiveDate().before(payDate))) {
					afterRateDet = new DebtRateDet();
					afterRateDet.setDebt(debt);
					afterRateDet.setDebtRate(rateDet.getDebtRate());
					afterRateDet.setEffectiveDate(rateDet.getEffectiveDate());
					Date newDueDate = getDueDate(rateDet.getEffectiveDate(),extendList,dueDate);

					afterRateDet.setSuspendDate(newDueDate);
					coumuteRateList2.add(afterRateDet);							
				}
			}

			if(computeRateList.size() > 0) {
				DebtRateDet tempComputeRateDet = (DebtRateDet)computeRateList.get(computeRateList.size() - 1);
				DebtRateDet computeRateDet = new DebtRateDet();
				computeRateDet.setDebt(debt);
				computeRateDet.setDebtRate(tempComputeRateDet.getDebtRate());
				Date newDueDate = getDueDate(tempComputeRateDet.getEffectiveDate(),extendList,dueDate);
				
				computeRateDet.setEffectiveDate(tempComputeRateDet.getEffectiveDate());
			
				computeRateDet.setSuspendDate(newDueDate);
				computeRateList.remove(tempComputeRateDet);
				computeRateList.add(computeRateDet);
				
				BigDecimal beforeInterestAmount = new BigDecimal(0);
				BigDecimal afterInterestAmount = new BigDecimal(0);
				
				BigDecimal remainCapitalAmount = debtManager.getRemainAmount(debt.getId(),payDate,session);
				
				//計算各期預估利息
				BigDecimal interestAmount = new BigDecimal(0);
				if(plan ==null) {
					interestAmount = counter.countInterest(prePlanDate,payDate,computeRateList,remainCapitalAmount.doubleValue(),3);
				}else{
					if (plan.getRepayDate().after(prePlanDate)){
						interestAmount = counter.countInterest(prePlanDate,payDate,computeRateList,remainCapitalAmount.doubleValue(),3);
					}else{
						interestAmount = plan.getInterestAmount();
					}
				}

				if(plan !=null) {
					plan.setInterestAmount(interestAmount.setScale(0,BigDecimal.ROUND_HALF_UP));
				}
				if(payment !=null) {
					BigDecimal capitalAmount = new BigDecimal(0);
					
					if(payment.getCapitalAmount().intValue() != 0) {
						newDueDate = getDueDate(prePlanDate,extendList,dueDate);
						beforeInterestAmount = counter.countInterest(prePlanDate,newDueDate,computeRateList,remainCapitalAmount.doubleValue(),3);
						capitalAmount = payment.getCapitalAmount();			
						
						BigDecimal beforeAfterInterestAmount = counter.countInterest(prePlanDate,payDate,computeRateList,remainCapitalAmount.doubleValue(),3);
						
						newDueDate = getDueDate(payDate,extendList,dueDate);
						afterInterestAmount =  beforeAfterInterestAmount.add(counter.countInterest(payDate,newDueDate,computeRateList,remainCapitalAmount.subtract(capitalAmount).doubleValue(),3));
						
						queryString = new StringBuffer();
						queryString.append(" from InterestAdjustMain i where i.changeDate =:repayDate and i.debtId =:debtId");
						Query adjustQuery = session.createQuery(queryString.toString());			
						adjustQuery.setParameter("debtId",debt.getId());
						adjustQuery.setParameter("repayDate",payDate);
						List adjustList = adjustQuery.list();
						if(adjustList.size()==0){
							InterestAdjustMain interestAdjustMain = new InterestAdjustMain();
							interestAdjustMain.setGroupId(1);
							interestAdjustMain.setChangeDate(payDate);
							interestAdjustMain.setDebtId(debt.getId());
							interestAdjustMain.setUserid("EXCEL");
							interestAdjustMain.setModDate(new Date());
							interestAdjustMain.setPlan(payment.getPlan());
							BigDecimal adjustAmount = afterInterestAmount.subtract(beforeInterestAmount).setScale(0,BigDecimal.ROUND_HALF_UP);
							interestAdjustMain.setChangeInterestAmount(adjustAmount);		
							interestAdjustMain.setAdjustType("M");
//							session.saveOrUpdate(interestAdjustMain);	
							payment.setManageInterestAmount(payment.getInterestAmount().add(adjustAmount.abs()));
						}
						
						//if((remainCapitalAmount.subtract(capitalAmount)).longValue() == 0) {
						if(capitalAmount.longValue() > 0) {
							newDueDate = getDueDate(prePlanDate,extendList,dueDate);
							
							//BigDecimal manageInterestAmount = counter.countInterest(prePlanDate,newDueDate,computeRateList,remainCapitalAmount.doubleValue(),3);
							BigDecimal manageInterestAmount = counter.countInterest(prePlanDate,newDueDate,computeRateList,capitalAmount.doubleValue(),3);
							payment.setManageInterestAmount(manageInterestAmount.setScale(0,BigDecimal.ROUND_HALF_UP));
						}
					}
					
					
					
				}
				if(computeRateList.size()!=coumuteRateList2.size() & payment!=null) {
					newDueDate = getDueDate(prePlanDate,extendList,dueDate);
					beforeInterestAmount = counter.countInterest(prePlanDate,newDueDate,computeRateList,remainCapitalAmount.doubleValue(),3);
					afterInterestAmount = counter.countInterest(prePlanDate,newDueDate,coumuteRateList2,remainCapitalAmount.doubleValue(),3);
					BigDecimal adjustAmount = afterInterestAmount.subtract(beforeInterestAmount).setScale(0,BigDecimal.ROUND_HALF_UP);
					if(adjustAmount.intValue() != 0) {
						queryString = new StringBuffer();
						queryString.append(" from InterestAdjustMain i where i.changeDate =:repayDate and i.debtId =:debtId");
						Query adjustQuery = session.createQuery(queryString.toString());			
						adjustQuery.setParameter("debtId",debt.getId());
						adjustQuery.setParameter("repayDate",payDate);
						List adjustList = adjustQuery.list();
						if(adjustList.size()==0){
							InterestAdjustMain interestAdjustMain = new InterestAdjustMain();
							interestAdjustMain.setGroupId(1);
							interestAdjustMain.setChangeDate(payDate);
							interestAdjustMain.setDebtId(debt.getId());
							interestAdjustMain.setUserid("EXCEL");
							interestAdjustMain.setModDate(new Date());
							if(payment !=null) {
								interestAdjustMain.setPlan(payment.getPlan());
							}else {
								interestAdjustMain.setPlan(plan);
							}
							interestAdjustMain.setChangeInterestAmount(adjustAmount);
							interestAdjustMain.setAdjustType("R");
//							session.saveOrUpdate(interestAdjustMain);
						}						
					}				
				}
			}
			//prePlanDate = payDate;
			if(plan !=null) {
//				session.saveOrUpdate(plan);
			}
			if(payment !=null) {
				session.saveOrUpdate(payment);
			}
			prePayment = payment;
			prePlan = plan;
		}			
	}
	
	private Date getDueDate(Date preDate,List extendList,Date dueDate){
		Date newDueDate = dueDate;
		if(preDate.after(dueDate)){
			if(preDate.after(dueDate)){				
				for(Iterator iterator= extendList.iterator();iterator.hasNext();){
					ExtendDueDateMain extendItem = (ExtendDueDateMain)iterator.next();
					if(preDate.after(extendItem.getOldDueDate())||preDate.equals(extendItem.getOldDueDate())){
						newDueDate = extendItem.getOldDueDate();
					}
				}
			}	
		}
		return newDueDate;
	}
}
