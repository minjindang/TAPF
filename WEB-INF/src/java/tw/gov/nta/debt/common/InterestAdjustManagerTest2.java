package tw.gov.nta.debt.common;


import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.InterestAdjustMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.base._BaseRootDAO;
import tw.gov.nta.sql.debt.dao.DebtRateDetDAO;

public class InterestAdjustManagerTest2 extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();

		_BaseRootDAO.initialize("hibernate_old.cfg.xml",new Configuration().configure("hibernate_old.cfg.xml"));
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testCreateInterestAdjust() {
		Session session = DebtRateDetDAO.getInstance().createNewSession();
		StringBuffer queryString = new StringBuffer();
//		queryString.append("from DebtMain debt where debt.issue.id <> 3471 and debt.issue.debtType = 'C' and debt.budgetCode <> 0 and debt.accrue = 'Y' order by debt.id");
		queryString.append("from DebtMain debt where debt.issue.id = 3437 and debt.accrue = 'Y' and debt.budgetCode <> 0 ");
//		queryString.append("from DebtMain debt where debt.id = 5473 and debt.accrue = 'Y' and debt.budgetCode <> 0 ");
		Calendar calendar = Calendar.getInstance();
		InterestCounter counter = new InterestCounter();
		Query debtQuery = session.createQuery(queryString.toString());
		
		DebtManager debtManager = new DebtManager();
		
		List debtList = debtQuery.list();
		org.hibernate.Transaction tx = session.beginTransaction();
		try {
			for(Iterator iterator = debtList.iterator();iterator.hasNext();) {
				DebtMain debt = (DebtMain)iterator.next();		
				Date issueDate = debt.getIssue().getIssueDate();
				Date dueDate = debt.getIssue().getDueDate();

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
				session.save(debt);

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
				Date prePlanDate = issueDate;
				
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
							afterRateDet.setSuspendDate(dueDate);
							coumuteRateList2.add(afterRateDet);							
						}
					}

					if(computeRateList.size() > 0) {
						DebtRateDet tempComputeRateDet = (DebtRateDet)computeRateList.get(computeRateList.size() - 1);
						DebtRateDet computeRateDet = new DebtRateDet();
						computeRateDet.setDebt(debt);
						computeRateDet.setDebtRate(tempComputeRateDet.getDebtRate());
						computeRateDet.setEffectiveDate(tempComputeRateDet.getEffectiveDate());
						computeRateDet.setSuspendDate(dueDate);
						computeRateList.remove(tempComputeRateDet);
						computeRateList.add(computeRateDet);
						
						BigDecimal beforeInterestAmount = new BigDecimal(0);
						BigDecimal afterInterestAmount = new BigDecimal(0);
						
						BigDecimal remainCapitalAmount = debtManager.getRemainAmount(debt.getId(),payDate,session);
						
						//計算各期預估利息

						BigDecimal interestAmount = counter.countInterest(prePlanDate,payDate,computeRateList,remainCapitalAmount.doubleValue(),3);
						if(plan !=null) {
							plan.setInterestAmount(interestAmount.setScale(0,BigDecimal.ROUND_HALF_UP));
						}
						if(payment !=null) {
							BigDecimal capitalAmount = new BigDecimal(0);
							if(payment.getCapitalAmount().intValue() != 0) {
								beforeInterestAmount = counter.countInterest(prePlanDate,dueDate,computeRateList,remainCapitalAmount.doubleValue(),3);
								capitalAmount = payment.getCapitalAmount();			
//								BigDecimal orgInterestAmount = new BigDecimal(0);
//								BigDecimal tagInterestAmount = new BigDecimal(0);
//								for(Iterator computeIterator = computeRateList.iterator();computeIterator.hasNext();) {
//									DebtRateDet srcRate = (DebtRateDet)computeIterator.next();
//									calendar.setTime(prePlanDate);
//									calendar.add(Calendar.DATE,-1);
//									if(srcRate.getSuspendDate().getTime()== calendar.getTime().getTime()) {
//										List tempList = new ArrayList();
//										DebtRateDet tagRate = new DebtRateDet();
//										tagRate.setDebt(debt);
//										tagRate.setDebtRate(srcRate.getDebtRate());
//										tagRate.setEffectiveDate(payDate);
//										tagRate.setSuspendDate(dueDate);
//										tempList.add(tagRate);
//										orgInterestAmount = counter.countInterest(payDate,dueDate,tempList,remainCapitalAmount.doubleValue(),3);
//									}else if(srcRate.getEffectiveDate().getTime() == prePlanDate.getTime()) {
//										List tempList = new ArrayList();
//										DebtRateDet tagRate = new DebtRateDet();
//										tagRate.setDebt(debt);
//										tagRate.setDebtRate(srcRate.getDebtRate());
//										tagRate.setEffectiveDate(payDate);
//										tagRate.setSuspendDate(dueDate);
//										tempList.add(tagRate);
//										tagInterestAmount = counter.countInterest(payDate,dueDate,tempList,remainCapitalAmount.doubleValue(),3);								
//									}
//								}
//								
//								if(tagInterestAmount.longValue() !=0) {
//									BigDecimal adjustAmount = orgInterestAmount.subtract(tagInterestAmount).setScale(0,BigDecimal.ROUND_HALF_UP);
//									InterestAdjustMain interestAdjustMain = new InterestAdjustMain();
//									interestAdjustMain.setGroupId(1);
//									interestAdjustMain.setChangeDate(prePlanDate);
//									interestAdjustMain.setDebtId(debt.getId());
//									interestAdjustMain.setUserid("EXCEL");
//									interestAdjustMain.setModDate(new Date());	
//									if(prePayment !=null) {
//										interestAdjustMain.setPlan(prePayment.getPlan());
//									}else {
//										interestAdjustMain.setPlan(prePlan);
//									}
//									interestAdjustMain.setChangeInterestAmount(adjustAmount);		
//									interestAdjustMain.setAdjustType("R");
//									session.saveOrUpdate(interestAdjustMain);								
//								}
								BigDecimal beforeAfterInterestAmount = counter.countInterest(prePlanDate,payDate,computeRateList,remainCapitalAmount.doubleValue(),3);
								afterInterestAmount =  beforeAfterInterestAmount.add(counter.countInterest(payDate,dueDate,computeRateList,remainCapitalAmount.subtract(capitalAmount).doubleValue(),3));
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
								session.saveOrUpdate(interestAdjustMain);								
								if((remainCapitalAmount.subtract(capitalAmount)).longValue() == 0) {
									BigDecimal manageInterestAmount = counter.countInterest(prePlanDate,dueDate,computeRateList,remainCapitalAmount.doubleValue(),3);
									payment.setManageInterestAmount(manageInterestAmount.setScale(0,BigDecimal.ROUND_HALF_UP));
								}else {
									payment.setManageInterestAmount(payment.getInterestAmount().add(adjustAmount.abs()));
								}
	
							}
							
							
							
						}
						if(computeRateList.size()!=coumuteRateList2.size() & payment!=null) {
							beforeInterestAmount = counter.countInterest(prePlanDate,dueDate,computeRateList,remainCapitalAmount.doubleValue(),3);
							afterInterestAmount = counter.countInterest(prePlanDate,dueDate,coumuteRateList2,remainCapitalAmount.doubleValue(),3);
							BigDecimal adjustAmount = afterInterestAmount.subtract(beforeInterestAmount).setScale(0,BigDecimal.ROUND_HALF_UP);
							if(adjustAmount.intValue() != 0) {
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
								session.saveOrUpdate(interestAdjustMain);
							}
							
						}
					}
					prePlanDate = payDate;
					if(plan !=null) {
						session.saveOrUpdate(plan);
					}
					if(payment !=null) {
						session.saveOrUpdate(payment);
					}
					prePayment = payment;
					prePlan = plan;
				}			
			}
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		session.close();
	}

}
