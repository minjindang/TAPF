package tw.gov.nta.debt.common;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.InterestAdjustMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.base._BaseRootDAO;
import tw.gov.nta.sql.debt.dao.DebtRateDetDAO;

public class InterestAdjustManagerTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
		_BaseRootDAO.initialize();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testCreateInterestAdjust() {
		Session session = DebtRateDetDAO.getInstance().createNewSession();
		StringBuffer queryString = new StringBuffer();
//		queryString.append("from DebtMain debt where debt.issue.id <> 3471 and debt.issue.debtType = 'C' and debt.budgetCode <> 0 and debt.accrue = 'Y' order by debt.id");
		queryString.append("from DebtMain debt where debt.id = 4767");
		Calendar calendar = Calendar.getInstance();
		InterestCounter counter = new InterestCounter();
		Query debtQuery = session.createQuery(queryString.toString());
		
		List debtList = debtQuery.list();
//		org.hibernate.Transaction tx = session.beginTransaction();
		try {
			for(Iterator iterator = debtList.iterator();iterator.hasNext();) {
				DebtMain debt = (DebtMain)iterator.next();		
				Date issueDate = debt.getIssue().getIssueDate();
				Date dueDate = debt.getIssue().getDueDate();
//				setPlanInterestAmount(debt,issueDate,debt.getOriginInterestAmount(),session);		
				queryString = new StringBuffer();
				queryString.append("from DebtRateDet rate where rate.debt = :debt and rate.deleteMark = 'N' order by rate.effectiveDate");
				Query rateQuery = session.createQuery(queryString.toString());
				rateQuery.setParameter("debt",debt);
				List computeRateList = new ArrayList();				
				List rateList = rateQuery.list();
				
				queryString = new StringBuffer();
				queryString.append("from DebtPlanDet plan where plan.debt = :debt and plan.deleteMark = 'N' order by plan.repayDate");
				Query planQuery = session.createQuery(queryString.toString());			
				planQuery.setParameter("debt",debt);
				List planList = planQuery.list();	
				
				for(Iterator rateIterator = rateList.iterator();rateIterator.hasNext();) {
					DebtRateDet rateDet = (DebtRateDet)rateIterator.next();
					rateDet.setSuspendDate(dueDate);
					calendar.setTime(rateDet.getEffectiveDate());
					calendar.add(Calendar.DATE,-1);
					for(Iterator tempIterator = computeRateList.iterator();tempIterator.hasNext();) {
						DebtRateDet tempRate = (DebtRateDet)tempIterator.next();
						if (tempRate.getSuspendDate().equals(dueDate))
							tempRate.setSuspendDate(calendar.getTime());
					}
					computeRateList.add(rateDet);
					
					if (computeRateList.size() == 1) {
						//計算原始總預估利息
						BigDecimal originInterestAmount = counter.countInterest(issueDate,dueDate,computeRateList,debt.getIssueAmount().doubleValue(),3);
						debt.setOriginInterestAmount(originInterestAmount);
						session.save(debt);

						Date planDate = issueDate;
						BigDecimal remainAmount = debt.getIssueAmount();
						for(Iterator sharePlanIterator = planList.iterator();sharePlanIterator.hasNext();) {
							DebtPlanDet planOne = (DebtPlanDet)sharePlanIterator.next();	
							calendar.setTime(planOne.getRepayDate());
							calendar.add(Calendar.DATE,-1);
							BigDecimal originPlanAmount = counter.countInterest(planDate,calendar.getTime(),computeRateList,remainAmount.doubleValue(),3);
							planOne.setInterestAmount(originPlanAmount);
							remainAmount = remainAmount.subtract(planOne.getCapitalAmount());
							planDate = planOne.getRepayDate();
						}
					}
					queryString = new StringBuffer();
					queryString.append("from PaymentMain payment where payment.debtId = :debtId and payment.repayDate >= :effectDate order by payment.repayDate");
					Query paymentQuery = session.createQuery(queryString.toString());			
					paymentQuery.setParameter("debtId",debt.getId());
					paymentQuery.setParameter("effectDate",rateDet.getEffectiveDate());
					List paymentList = paymentQuery.list();
					
					for(Iterator paymentIterator = paymentList.iterator();paymentIterator.hasNext();) {
						PaymentMain payment = (PaymentMain)paymentIterator.next();
						payment.setManageInterestAmount(new BigDecimal(0));
						Date planStartDate = issueDate;
						BigDecimal adjustAmount = new BigDecimal(0);
						for(Iterator planIterator = planList.iterator();planIterator.hasNext();) {
							DebtPlanDet plan = (DebtPlanDet)planIterator.next();
							BigDecimal originPlanInterestAmount = plan.getInterestAmount();
							if(plan.getRepayDate().after(payment.getRepayDate()) || plan.getRepayDate().equals(payment.getRepayDate())) {
								if(payment.getCapitalAmount().intValue()!=0) {
								//if(paymentRepayDate.after(planStartDate)&&paymentRepayDate.before(plan.getRepayDate())) {
									BigDecimal paymentManagementInterestAmount = counter.countInterest(planStartDate,plan.getRepayDate(),computeRateList,payment.getCapitalAmount().doubleValue(),3);
									payment.setManageInterestAmount(payment.getManageInterestAmount().add(paymentManagementInterestAmount));
								}else {
									payment.setManageInterestAmount(plan.getInterestAmount());
								}
								BigDecimal remainCapitalAmount = new DebtManager().getRemainAmount(debt.getId(),plan.getRepayDate(),session);
								BigDecimal counterInterestAmount = counter.countInterest(planStartDate,plan.getRepayDate(),computeRateList,remainCapitalAmount.doubleValue(),3).setScale(0,BigDecimal.ROUND_HALF_UP);									
								adjustAmount = adjustAmount.add(counterInterestAmount.subtract(originPlanInterestAmount)).setScale(0,BigDecimal.ROUND_HALF_UP);		
								plan.setInterestAmount(counterInterestAmount);
							}
							planStartDate = plan.getRepayDate();
						}
						
						
						if(adjustAmount.intValue()>0) {
							InterestAdjustMain interestAdjustMain = new InterestAdjustMain();
							interestAdjustMain.setGroupId(rateDet.getGroupId());
							interestAdjustMain.setChangeDate(payment.getRepayDate());
							interestAdjustMain.setDebtId(debt.getId());
							interestAdjustMain.setUserid("EXCEL");
							interestAdjustMain.setModDate(new Date());
							interestAdjustMain.setPlan(payment.getPlan());
							interestAdjustMain.setChangeInterestAmount(adjustAmount);
							if(payment.getRepayDate().equals(rateDet.getEffectiveDate())) {
								interestAdjustMain.setAdjustType("R");
							}else {
								interestAdjustMain.setAdjustType("M");
							}
							session.saveOrUpdate(interestAdjustMain);
						}
						payment.setManageInterestAmount(payment.getManageInterestAmount().setScale(0,BigDecimal.ROUND_HALF_UP));
						session.saveOrUpdate(payment);
					}
				}
				for(Iterator updatePlanIterator = planList.iterator();updatePlanIterator.hasNext();) {
					DebtPlanDet planOne = (DebtPlanDet)updatePlanIterator.next();					
					session.saveOrUpdate(planOne);
				}
			}
//			tx.commit();
		}catch(Exception e) {
//			tx.rollback();
			e.printStackTrace();
		}

		session.close();
	}
//
//	private void setPlanInterestAmount(DebtMain debt,Date startDate, BigDecimal changeInterestAmount, Session session) {
//		// TODO Auto-generated method stub
//		StringBuffer queryString = new StringBuffer();
//		queryString.append("from DebtPlanDet plan where plan.debt = :debt and plan.repayDate > :repayDate and plan.deleteMark = 'N' order by plan.repayDate");
//		Query planQuery = session.createQuery(queryString.toString());			
//		planQuery.setParameter("debt",debt);
//		planQuery.setParameter("repayDate",startDate);
//		List planList = planQuery.list();	
//
//		int planCount = planList.size();
//		BigDecimal adjustAmount = null;
//		if(changeInterestAmount.intValue() == 0 || planCount == 0 ) {
//			return;
//		}else {
//			 adjustAmount = new BigDecimal(changeInterestAmount.doubleValue()/planCount).setScale(0,BigDecimal.ROUND_HALF_UP);
//		}
//
//		for(Iterator iterator = planList.iterator();iterator.hasNext();) {
//			DebtPlanDet planOne = (DebtPlanDet)iterator.next();
//			BigDecimal originInterestAmount = planOne.getInterestAmount();
//			if (originInterestAmount == null) {
//				originInterestAmount = new BigDecimal(0);
//			}
//			
//			planOne.setInterestAmount(originInterestAmount.add(adjustAmount));
//			session.saveOrUpdate(planOne);
//			//session.evict(planOne);
//		}
//	}

}
