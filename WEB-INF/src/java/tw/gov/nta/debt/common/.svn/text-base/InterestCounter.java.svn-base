package tw.gov.nta.debt.common;

import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;

public class InterestCounter {
	 
	/**
	 * 以某利率計算利息
	 * @param pStartDate
	 * @param pEndDate
	 * @param pRateList
	 * @param amount
	 * @param pCountType
	 * @return
	 */
	public BigDecimal countInterest(Date pStartDate, Date pEndDate, List pRateList, double amount, int pCountType) {
		//1.計算利息總計
		double tSum = 0;
		//2.依利率執行迴圈
		DebtRateDet tDebtRateDetDto = null; 
		if (pStartDate.after(pEndDate))
			pStartDate = pEndDate;
		for(Iterator tIterator = pRateList.iterator();tIterator.hasNext();){
			tDebtRateDetDto = (DebtRateDet) tIterator.next();
			Date effectDate = tDebtRateDetDto.getEffectiveDate();
			Date suspendDate = tDebtRateDetDto.getSuspendDate();
			Date countStartDate = null;
			Date countEndDate = null;
			
			//2.1計算計息天數
			int tDays = 0;
			
			//如果開始結束日期不在有效日期內，就不計算(計息天數 = 0)
			if(pEndDate.before(effectDate) || pStartDate.after(suspendDate)) {
				tDays = 0;
			}
			else {
				//如果開始日期小於有效日期，計算開始日期就等於有效日期
				//                  不然計算開始日期等於開始日期
				if(pStartDate.before(effectDate))
					countStartDate = effectDate;
				else
					countStartDate = pStartDate;
				
				//如果結束日期大於截止日期，計算結束日期就等於截止日期
				//                  不然計算截止日期等於結束日期
				
				if(pEndDate.after(suspendDate))
					countEndDate = DateUtil.computeDueDate(suspendDate,1);
				else
					countEndDate = pEndDate;			
			
				tDays = getRateDay(countStartDate, countEndDate);
			}
			//2.2計算年利率基數
			int tBaseDays = 0;
			if(null != countStartDate && null != countEndDate)
			{
				tBaseDays = isLeap(countStartDate, countEndDate)?366:365;
			}
			//2.3計算利息
			//新增3.算足年的
			if(!(pEndDate.before(effectDate) || pStartDate.after(suspendDate))) {
				if(pCountType == 0 && 0 != tBaseDays)
					tSum += simpleCount(amount, tDebtRateDetDto.getDebtRate().doubleValue(),tDays , tBaseDays);
				else if(pCountType == 1 && 0 != tBaseDays)
					tSum += compleCount(amount, tDebtRateDetDto.getDebtRate().doubleValue(),tDays , tBaseDays);
				else if(pCountType == 3)
					tSum += yearCount(amount,tDebtRateDetDto,countStartDate,countEndDate);
			}

		}
		BigDecimal interest = new BigDecimal(tSum);
		interest = interest.setScale(10,BigDecimal.ROUND_HALF_UP);
	    return interest;
	}
	 
	private double yearCount(double amount, DebtRateDet rate, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		List rateList = new ArrayList();
		rateList.add(rate);
		calendar.setTime(startDate);
		int yearDiff = 0;
		if(endDate.before(rate.getEffectiveDate()) || startDate.after(rate.getSuspendDate())) {
			return 0;
		}
		double interestAmount = 0.0;
		int startYear = calendar.get(Calendar.YEAR);
		calendar.add(Calendar.YEAR,1);
		int startMonth = calendar.get(Calendar.MONTH);
		int startDay = calendar.get(Calendar.DATE);		
		if(calendar.getTime().before(endDate)||calendar.getTime().equals(endDate)) { //有足年
			calendar.setTime(endDate);
			int endYear = calendar.get(Calendar.YEAR);
			int endMonth = calendar.get(Calendar.MONTH);
			int endDay = calendar.get(Calendar.DATE);	
			if((endMonth>startMonth) ||(endMonth==startMonth && endDay>=startDay)) {
				yearDiff = endYear - startYear;
			}else {
				yearDiff = endYear - startYear - 1;
			}
			interestAmount = amount * (rate.getDebtRate().doubleValue()/100) * yearDiff;
			calendar.setTime(startDate);
			calendar.add(Calendar.YEAR,yearDiff);
			interestAmount = interestAmount + countInterest(calendar.getTime(),endDate, rateList, amount, 0).doubleValue();
		}else {
			interestAmount = interestAmount + countInterest(startDate,endDate, rateList, amount, 0).doubleValue();	
		}

		return interestAmount;
	}

	/**
	 * 計算單利
	 * @param pPrice
	 * @param pRate
	 * @param pDays
	 * @param pBaseDays
	 * @return
	 */
	private double simpleCount(double pPrice, double pRate, int pDays, int pBaseDays) {
		return pPrice * (pRate / 100) * ((double)pDays / (double)pBaseDays);
	}
	 
	/**
	 * 計算複利
	 * @param pPrice
	 * @param pRate
	 * @param pDays
	 * @param pBaseDays
	 * @return
	 */
	private double compleCount(double pPrice, double pRate, int pDays, int pBaseDays) {
		return pPrice * (Math.pow((1+pRate)/100, pDays/pBaseDays))  ;
	}
	 
	/**
	 * 判斷時間是否跨越潤年的2月29日
	 * @param pStartDate
	 * @param pEndDate
	 * @return
	 */
	public boolean isLeap(Date pStartDate, Date pEndDate) {
		GregorianCalendar tStartCalendar = new GregorianCalendar();
		tStartCalendar.setTime(pStartDate);
		GregorianCalendar tEndCalendar = new GregorianCalendar();
		tEndCalendar.setTime(pEndDate);
		Calendar calendar = Calendar.getInstance();
		Date day229 = null;
		
		//Megan 0950624
		int startYear = tStartCalendar.get(Calendar.YEAR);
		int endYear = tEndCalendar.get(Calendar.YEAR);
		for(int i=startYear; i<=endYear; i++)
		{
			//如果跨潤年
			if (tStartCalendar.isLeapYear(i)){
				calendar.set(i,1,28);
				day229 = calendar.getTime();
				if (tStartCalendar.getTime().before(day229) && tEndCalendar.getTime().after(day229))
					return true;
			}
		
		}
		return false;
	}
	
//	/**
//	 * 檢查是否潤年
//	 * @param pYear:西元年
//	 * @return:潤年與否
//	 */
//	private boolean checkYear(int pYear){
//		return pYear % 4 == 0 && pYear % 100 != 0 || pYear%400 == 0;
//	}
	
	/**
	 * 計算天數
	 * @param pStartDate
	 * @param pEndDate
	 * @return
	 */
	public int getRateDay(Date pStartDate, Date pEndDate){
		return (int)(((pEndDate.getTime() - pStartDate.getTime()) / 86400000L));
	}
	
	//傳debtPlanDet的list可以算出利息
	public void planListCountInterest(List list)
	{
		int index = 0;
		Date startDate = new Date();
		Date endDate= new Date();
		Date beforeEndDate = new Date();
		BigDecimal amount = new BigDecimal(0);
		List rateList = null;
		InterestCounter doCount = new InterestCounter();
		RateManager rateManager = new RateManager();
		if(null != list && 0 != list.size())
		{
			for(Iterator it=list.iterator();it.hasNext();)
			{	
				DebtPlanDet debtPlanDet = (DebtPlanDet)it.next();

				if(0==index)	//第一筆 用 issueMain 的 issueDate 其餘為前一筆的repayDate
				{
					startDate = debtPlanDet.getDebt().getIssue().getIssueDate(); 
				}
				
				endDate = debtPlanDet.getRepayDate();
				amount = debtPlanDet.getDebt().getIssueAmount();
				rateList = rateManager.getEffectiveRate(debtPlanDet.getDebt().getId());
				debtPlanDet.setInterestAmount(doCount.countInterest(startDate,endDate,rateList,amount.doubleValue(),0));
				
				startDate = endDate;
					
				index = index + 1 ;
				
			}
		}	 
	}
}
 
