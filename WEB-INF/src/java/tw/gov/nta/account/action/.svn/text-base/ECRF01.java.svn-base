package tw.gov.nta.account.action;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.DebtRateDetDAO;

public class ECRF01 extends TestCase {
	
	public void executeQuery() {
		Session session = DebtRateDetDAO.getInstance().createNewSession();
		StringBuffer queryString = new StringBuffer();

		queryString.append("from IssueMain issue where issue.debtType = 'C' and issue.id <> 3471 order by issue.id");
		Query issueQuery = session.createQuery(queryString.toString());
		List issueList = issueQuery.list();
		org.hibernate.Transaction tx = session.beginTransaction();
		try {
			for(Iterator issueIterator = issueList.iterator();issueIterator.hasNext();) {
				IssueMain issue = (IssueMain)issueIterator.next();
				queryString.append("from DebtMain debt where debt.issue =:issue and debt.budgetCode <> 0 and debt.accrue = 'Y' order by debt.id");
				Query debtQuery = session.createQuery(queryString.toString());
				debtQuery.setParameter("issue",issue);
				List debtList = debtQuery.list();
	
				for(Iterator iterator = debtList.iterator();iterator.hasNext();) {
					DebtMain debt = (DebtMain)iterator.next();
									
					Date issueDate = debt.getIssue().getIssueDate();
					Date dueDate = debt.getIssue().getDueDate();
//					String issueAmount = debt.getIssue().getIssueSerial();
					
					queryString = new StringBuffer();
					queryString.append("from DebtRateDet rate where rate.debt = :debt and rate.deleteMark = 'N' order by rate.effectiveDate");
					Query rateQuery = session.createQuery(queryString.toString());
					rateQuery.setParameter("debt",debt);				
					List rateList = rateQuery.list();
					
					for(Iterator rateIterator = rateList.iterator();rateIterator.hasNext();) {
						DebtRateDet rateDet = (DebtRateDet)rateIterator.next();
						queryString = new StringBuffer();
						queryString.append("from PaymentMain payment where payment.plan.debt = :debt and repayDate between :effectDate and :suspendDate order by payment.repayDate");
						Query paymentQuery = session.createQuery(queryString.toString());			
						paymentQuery.setParameter("debt",debt);
						paymentQuery.setParameter("effectDate",rateDet.getEffectiveDate());
						paymentQuery.setParameter("suspendDate",rateDet.getSuspendDate());
						List paymentList = paymentQuery.list();
						for(Iterator paymentIterator = paymentList.iterator();paymentIterator.hasNext();) {
							PaymentMain payment = (PaymentMain)paymentIterator.next();
							DebtPlanDet plan = payment.getPlan();
							
							//1.塞入issue.issueSerial    第一筆塞 其他不用
							//2.塞入issue.dueDate.getYear - issue.issueDate.getYear 的年  第一筆塞 其他不用
							//3.塞入issue.issueDate		第一筆塞 其他不用
							//4.塞入issue.dueDate		第一筆塞 其他不用
							//5.塞入debt.bankId 至bankRef抓bankName 第一筆塞 其他不用
							//6.塞入debt.issueAmount				第一筆塞 其他不用
							//7.塞入payment.repayDate
							//8.塞入rate.debtRate		跟上一個一樣時不塞
							//9.如果payment.capitalAmount > 0 && payment.repayDate >= plan.repayDate 塞入 payment.capitalAmount
							//10.如果payment.capitalAmount > 0 && payment.repayDate < plan.repayDate 塞入 payment.capitalAmount
							//11.該debt的累積還本金額(9 + 10)
							//12.如果payment.interestAmount > 0 && payment.repayDate >= plan.repayDate 塞入 payment.interestAmount
							//13.如果payment.interestAmount > 0 && payment.repayDate < plan.repayDate 塞入 payment.interestAmount
							//14.該debt的累積還本金額(12 + 13)
							//備註塞0
						}
					}
				}
				//塞issue的合計
			}
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		session.close();
	}


}
