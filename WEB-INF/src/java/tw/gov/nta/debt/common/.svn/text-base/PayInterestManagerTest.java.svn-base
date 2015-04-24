package tw.gov.nta.debt.common;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class PayInterestManagerTest {
	 
	/**
	 * 產生付息資料
	 * @param pInterestNo
	 * @param pInterestAmount
	 * @param pPaymentMainDto
	 * @return
	 */
	public PaymentMain payInterest(int pInterestNo, double pInterestAmount, PaymentMain pPaymentMainDto,Session session) {
		PaymentMain tPaymentMainDto = new PaymentMain();
		tPaymentMainDto.setIssueId(pPaymentMainDto.getIssueId());
		tPaymentMainDto.setDebtId(pPaymentMainDto.getDebtId());
		tPaymentMainDto.setPlan(pPaymentMainDto.getPlan());
		tPaymentMainDto.setRepayDate(pPaymentMainDto.getRepayDate());
		tPaymentMainDto.setInterestAmount(new BigDecimal(pInterestAmount));
		tPaymentMainDto.setInterestSerial(String.valueOf(pInterestNo));
		tPaymentMainDto.setPlanRepayDate(pPaymentMainDto.getRepayDate());
		setAccruePlanAmount(tPaymentMainDto,session);
		//-------------------------------------
		IssueMain tIssueMain = (IssueMain)session.get(IssueMain.class,new Integer(tPaymentMainDto.getIssueId()));
		int tInterval = getInterestInterval(tPaymentMainDto, tIssueMain);
		if(tInterval < 0)
			tPaymentMainDto.setInterestDays(new Integer((int)(((pPaymentMainDto.getRepayDate().getTime() - tIssueMain.getIssueDate().getTime())/86400000L) + 1)));
		else
			tPaymentMainDto.setInterestDays(tInterval);
		return tPaymentMainDto;
	}

	/**
	 * 取得計息天數
	 * @param pPaymentMainDto
	 * @param pIssueMainDto
	 * @return
	 */
	private int getInterestInterval(PaymentMain pPaymentMainDto, IssueMain pIssueMainDto){
		Date tStartDate = null;
		Session tSession = new PaymentMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(PaymentMain.class);
		criteria.add(Expression.eq("plan.id", new Integer(pPaymentMainDto.getPlan().getId())));		//** plan是個表
		criteria.add(Expression.eq("debtId", new Integer(pPaymentMainDto.getDebtId())));
		criteria.add(Expression.eq("issueId", new Integer(pPaymentMainDto.getIssueId())));
		List tList = criteria.list();
		if(null == tList || 0 == tList.size())		//** list 不會有 null 會是0
			tStartDate = pIssueMainDto.getIssueDate();
		else{
			PaymentMain tTempPaymentMainDto = null;
			Iterator tIterator = tList.iterator();
			while(tIterator.hasNext()){
				tTempPaymentMainDto = (PaymentMain) tIterator.next();
				if(tStartDate == null || tStartDate.getTime() < tTempPaymentMainDto.getRepayDate().getTime())
					tStartDate = tTempPaymentMainDto.getRepayDate();
			}
		}
		tSession.close();
		return new InterestCounter().getRateDay(tStartDate, pPaymentMainDto.getRepayDate());
	}
	//新增預計還款金額及還款利息
	private void setAccruePlanAmount(PaymentMain paymentMainDto, Session session) {
		// TODO Auto-generated method stub
		Date repayDate = paymentMainDto.getRepayDate();
		String capitalSerial = paymentMainDto.getCapitalSerial();
		BigDecimal capitalAmount = new BigDecimal(0);
		BigDecimal planCapitalAmount = new BigDecimal(0);
		BigDecimal planInterestAmount = new BigDecimal(0);
		StringBuffer queryString = new StringBuffer();
		queryString.append(" from PaymentMain p ");
		queryString.append(" where p.plan =:plan ");
		queryString.append(" and p.repayDate = :repayDate ");
		//付息
		if(capitalSerial == null || "".equals(capitalSerial) || "0".equals(capitalSerial.trim())) {
			queryString.append(" and p.capitalSerial <> 0 ");
			StringBuffer queryString2 = new StringBuffer();
			queryString2.append(" from DebtPlanDet d ");
			queryString2.append(" where d.debt = :debt ");
			queryString2.append("   and d.repayDate = :repayDate ");
			queryString2.append(" and d.capitalSerial <> 0 ");
			Query query2 = session.createQuery(queryString2.toString());
			query2.setParameter("debt",paymentMainDto.getPlan().getDebt());
			query2.setParameter("repayDate",repayDate);
			List planList = query2.list();
			for(Iterator iterator = planList.iterator();iterator.hasNext();) {
				planCapitalAmount = planCapitalAmount.add(((DebtPlanDet)iterator.next()).getCapitalAmount());
			}
		//還本
		}else {
			queryString.append(" and p.capitalSerial = 0 ");
			planCapitalAmount = paymentMainDto.getPlan().getCapitalAmount();
		}
		
		Query query = session.createQuery(queryString.toString());
		query.setParameter("plan",paymentMainDto.getPlan());
		query.setParameter("repayDate",repayDate);
		List paymentList = query.list();
		for(Iterator iterator = paymentList.iterator();iterator.hasNext();) {
			PaymentMain payment = (PaymentMain)iterator.next();
			//還本
			if (capitalSerial == null || "".equals(capitalSerial) || "0".equals(capitalSerial.trim())) {
				capitalAmount = payment.getCapitalAmount();
				planInterestAmount = capitalAmount.divide(planCapitalAmount).multiply(paymentMainDto.getPlan().getInterestAmount());
			}else {
			//付息
				capitalAmount = paymentMainDto.getCapitalAmount();
				payment.setManageInterestAmount(capitalAmount.divide(planCapitalAmount).multiply(paymentMainDto.getPlan().getInterestAmount()));
				session.saveOrUpdate(payment);
			}
		}
		paymentMainDto.setManageCapitalAmount(planCapitalAmount);
		paymentMainDto.setManageInterestAmount(planInterestAmount);
	}	
	
}
 
