package tw.gov.nta.debt.common;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.InterestAdjustMain;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;
import tw.gov.nta.sql.debt.dao.DebtRateDetDAO;
import tw.gov.nta.sql.debt.dao.InterestAdjustMainDAO;

public class InterestAdjustManager extends IManager{
	
	InterestAdjustMainDAO adjustDao = InterestAdjustMainDAO.getInstance();
	 
	/**
	 * 新增利息調整資料
	 * @param planId
	 * @param newGroupId
	 * @param changeDate
	 */
	public void createInterestAdjust(DebtPlanDet plan, BigDecimal pInterestAmount, BigDecimal pRate ) {
		
	    int value = Integer.parseInt(plan.getId().toString());
	    int planId = Integer.valueOf(value).intValue();
	    
		BigDecimal tAdjustSum = countInterestAdjust(plan.getDebt().getId(), planId, pInterestAmount);
		if (tAdjustSum.equals(0)) {
			return;
		}
		
		Date changeDate = plan.getRepayDate();
		int newGroupId = 1;
		
		InterestAdjustMain tInterestAdjustMain = createBean(plan, changeDate, pRate, tAdjustSum, newGroupId);
		new InterestAdjustMainDAO().save(tInterestAdjustMain);
	}
	 
	/**
	 * 計算利息調整金額
	 * @param pDebtId
	 * @param pNewGroupId
	 * @param pCountType
	 * @return
	 */

	public BigDecimal countInterestAdjust(int pDebtId, int pPlanId, BigDecimal pInterestAmount) {
		
		List interestAdjustList = byDebtId(pDebtId);
		BigDecimal tChangeInterestAmount = new BigDecimal(0);
		InterestAdjustMain tInterestAdjust = null;
		
		for(Iterator tIterator = interestAdjustList.iterator(); tIterator.hasNext();){
			tInterestAdjust = (InterestAdjustMain) tIterator.next();
			if(tInterestAdjust.getChangeInterestAmount() != null)
				tChangeInterestAmount = tChangeInterestAmount.add(tInterestAdjust.getChangeInterestAmount());
		}
		
		DebtManager tDebtManager = new DebtManager();
		DebtMain tDebtMainDto = tDebtManager.getBean(pDebtId);
		BigDecimal tOriginInterest = tDebtMainDto.getOriginInterestAmount();
		BigDecimal tNewInterest = pInterestAmount;
		
		return tNewInterest.subtract(tOriginInterest).subtract(tChangeInterestAmount);
	}
	 
	/**
	 * 新增利息調整Dto
	 * @param pDebtId
	 * @param pChangeDate
	 * @param pGroupId
	 * @return
	 */
	public InterestAdjustMain createBean (DebtPlanDet plan, Date pChangeDate, BigDecimal pChangeRate, BigDecimal pAdjustSum, int pGroupId) {
		
		InterestAdjustMain tInterestAdjustMainDto = new InterestAdjustMain();
		
        Date date = new Date();        
        SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");        
        System.out.println(YYYYMMDD.format(date));
		
		tInterestAdjustMainDto.setPlan(plan);
		tInterestAdjustMainDto.setDebtId(plan.getDebt().getId());
		tInterestAdjustMainDto.setChangeDate(pChangeDate);
		tInterestAdjustMainDto.setChangeRate(pChangeRate);
		tInterestAdjustMainDto.setChangeInterestAmount(pAdjustSum.setScale(20,4));
		tInterestAdjustMainDto.setGroupId(pGroupId);
		tInterestAdjustMainDto.setAdjustType("R");
		tInterestAdjustMainDto.setUserid("TAPF");
		tInterestAdjustMainDto.setModDate(date);
		return tInterestAdjustMainDto;
		
	}
	
	public List byDebtId(int pDebtId){
		Session tSession = new InterestAdjustMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(InterestAdjustMain.class);
		if(0 != pDebtId)
		{	
			criteria.add(Expression.eq("debtId", pDebtId));
		}
	    List tResult = criteria.list();
	    tSession.close();
	    return tResult;
	}

	/**
	 * 取得利息調整Dto
	 */
	public InterestAdjustMain getBean(int pId) {
		return new InterestAdjustMainDAO().get(new Integer(pId));
	}

	/**
	 * 檢查Dto
	 */
	protected boolean checkBean(Object pBean) {
		return true;
	}
	
	public int getRateDay(Date pStartDate, Date pEndDate){
		return (int)(((pEndDate.getTime() - pStartDate.getTime()) / 86400000L));
	}

	/**
	 * 無規格，暫緩實做
	 * @param pDto
	 */
	public void confirm(Object pDto) {

	}
}