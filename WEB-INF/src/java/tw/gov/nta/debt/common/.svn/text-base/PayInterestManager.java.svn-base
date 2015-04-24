package tw.gov.nta.debt.common;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class PayInterestManager {
	 
	/**
	 * 產生付息資料
	 * @param pInterestNo
	 * @param pInterestAmount
	 * @param pPaymentMainDto
	 * @return
	 */
	public PaymentMain payInterest(int pInterestNo, double pInterestAmount, PaymentMain pPaymentMainDto) {
		return payInterest(pInterestNo, pInterestAmount, pPaymentMainDto,new IssueMainDAO().getSession()) ;
	}

	
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
		tPaymentMainDto.setManageInterestAmount(pPaymentMainDto.getInterestAmount());
		//-------------------------------------
		IssueMain tIssueMain = new IssueMainDAO().get(new Integer(tPaymentMainDto.getIssueId()),session);
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
		Session tSession = new PaymentMainDAO().getSession();
		return getInterestInterval(pPaymentMainDto, pIssueMainDto,tSession);
	}
	
	/**
	 * 取得計息天數
	 * @param pPaymentMainDto
	 * @param pIssueMainDto
	 * @return
	 */
	private int getInterestInterval(PaymentMain pPaymentMainDto, IssueMain pIssueMainDto,Session session){
		Date tStartDate = null;
		Criteria criteria = session.createCriteria(PaymentMain.class);
		criteria.add(Expression.eq("plan.id", new Integer(pPaymentMainDto.getPlan().getId())));		//** plan是個表
		criteria.add(Expression.eq("debtId", new Integer(pPaymentMainDto.getDebtId())));
		criteria.add(Expression.eq("issueId", new Integer(pPaymentMainDto.getIssueId())));
		List tList = criteria.list();
		if((null == tList || 0 == tList.size()) || "D".equals(pIssueMainDto.getDebtType()))		//** list 不會有 null 會是0
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

		return new InterestCounter().getRateDay(tStartDate, pPaymentMainDto.getRepayDate());
	}	
}
 
