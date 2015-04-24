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
							
							//1.��Jissue.issueSerial    �Ĥ@���� ��L����
							//2.��Jissue.dueDate.getYear - issue.issueDate.getYear ���~  �Ĥ@���� ��L����
							//3.��Jissue.issueDate		�Ĥ@���� ��L����
							//4.��Jissue.dueDate		�Ĥ@���� ��L����
							//5.��Jdebt.bankId ��bankRef��bankName �Ĥ@���� ��L����
							//6.��Jdebt.issueAmount				�Ĥ@���� ��L����
							//7.��Jpayment.repayDate
							//8.��Jrate.debtRate		��W�@�Ӥ@�ˮɤ���
							//9.�p�Gpayment.capitalAmount > 0 && payment.repayDate >= plan.repayDate ��J payment.capitalAmount
							//10.�p�Gpayment.capitalAmount > 0 && payment.repayDate < plan.repayDate ��J payment.capitalAmount
							//11.��debt���ֿn�٥����B(9 + 10)
							//12.�p�Gpayment.interestAmount > 0 && payment.repayDate >= plan.repayDate ��J payment.interestAmount
							//13.�p�Gpayment.interestAmount > 0 && payment.repayDate < plan.repayDate ��J payment.interestAmount
							//14.��debt���ֿn�٥����B(12 + 13)
							//�Ƶ���0
						}
					}
				}
				//��issue���X�p
			}
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		session.close();
	}


}
