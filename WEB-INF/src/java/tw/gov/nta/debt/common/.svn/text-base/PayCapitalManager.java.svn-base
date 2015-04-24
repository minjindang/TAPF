package tw.gov.nta.debt.common;

import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.IssueExchangeDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.IssueExchangeDetDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class PayCapitalManager {

	/**
	 * 以現金付款
	 * @param pCapitalNo
	 * @param pCapitalAmount
	 * @param pPaymentMainDto
	 * @return
	 */
	public PaymentMain payCaptialByCash(int pCapitalNo, double pCapitalAmount, PaymentMain pPaymentMainDto) {
		return payCaptialByCash(pCapitalNo,pCapitalAmount,pPaymentMainDto,new IssueMainDAO().getSession());
	}	
	
	/**
	 * 以現金付款
	 * @param pCapitalNo
	 * @param pCapitalAmount
	 * @param pPaymentMainDto
	 * @return
	 */
	public PaymentMain payCaptialByCash(int pCapitalNo, double pCapitalAmount, PaymentMain pPaymentMainDto,Session session) {
		PaymentMain tPaymentMainDto = new PaymentMain();
		tPaymentMainDto.setIssueId(pPaymentMainDto.getIssueId());
		tPaymentMainDto.setDebtId(pPaymentMainDto.getDebtId());
		tPaymentMainDto.setPlan(pPaymentMainDto.getPlan());
		tPaymentMainDto.setCapitalAmount(pPaymentMainDto.getCapitalAmount());
		tPaymentMainDto.setCapitalSerial(pPaymentMainDto.getCapitalSerial());
		tPaymentMainDto.setPlanRepayDate(pPaymentMainDto.getRepayDate());
		tPaymentMainDto.setManageCapitalAmount(pPaymentMainDto.getCapitalAmount());
		//--------------------------
		IssueMain tIssueMainDto = new IssueMainDAO().get(new Integer(tPaymentMainDto.getIssueId()),session);
		tPaymentMainDto.setBalanceCapitalAmount(tIssueMainDto.getIssueAmount().subtract(tIssueMainDto.getCapitalAmount()).subtract(new BigDecimal(pCapitalAmount)));


		int tInterval = getInterestInterval(pPaymentMainDto, tIssueMainDto,session);
		if(tInterval < 0)
			//tPaymentMainDto.setInterestDays(new Integer((int)(((pPaymentMainDto.getRepayDate().getTime() - tIssueMainDto.getIssueDate().getTime())/86400000L) + 1)));
			tPaymentMainDto.setInterestDays(DateUtil.getDays(tIssueMainDto.getIssueDate(),pPaymentMainDto.getRepayDate()));
		else
			tPaymentMainDto.setInterestDays(tInterval);
		return tPaymentMainDto;
	}

	/**
	 * 以股票付款
	 * @param pCapitalNo
	 * @param pCapitalAmount
	 * @param pPaymentMainDto
	 * @return
	 */
	public PaymentMain payCaptialByStock(int pCapitalNo, double pCapitalAmount, PaymentMain pPaymentMainDto) {
		return payCaptialByStock(pCapitalNo,pCapitalAmount,pPaymentMainDto,new IssueMainDAO().getSession() );
	}	
	
	/**
	 * 以股票付款
	 * @param pCapitalNo
	 * @param pCapitalAmount
	 * @param pPaymentMainDto
	 * @return
	 */
	public PaymentMain payCaptialByStock(int pCapitalNo, double pCapitalAmount, PaymentMain pPaymentMainDto,Session session) {
		PaymentMain tPaymentMainDto = new PaymentMain();
		tPaymentMainDto.setIssueId(pPaymentMainDto.getIssueId());
		tPaymentMainDto.setDebtId(pPaymentMainDto.getDebtId());
		tPaymentMainDto.setPlan(pPaymentMainDto.getPlan());
		tPaymentMainDto.setRepayDate(pPaymentMainDto.getRepayDate());
		tPaymentMainDto.setCapitalAmount(pPaymentMainDto.getCapitalAmount());
		tPaymentMainDto.setCapitalSerial(pPaymentMainDto.getCapitalSerial());
		tPaymentMainDto.setPlanRepayDate(pPaymentMainDto.getRepayDate());
		tPaymentMainDto.setManageCapitalAmount(pPaymentMainDto.getCapitalAmount());
		//--------------------------		
		IssueMain tIssueMainDto = new IssueMainDAO().get(new Integer(tPaymentMainDto.getIssueId()),session);
		
		BigDecimal issueCapitalAmount = tIssueMainDto.getCapitalAmount();
		
		if (issueCapitalAmount == null) {
			issueCapitalAmount = new BigDecimal(0);
		}
		tPaymentMainDto.setBalanceCapitalAmount(tIssueMainDto.getIssueAmount().subtract(issueCapitalAmount).subtract(new BigDecimal(pCapitalAmount)));

		int tInterval = getInterestInterval(pPaymentMainDto, tIssueMainDto,session);

		if(tInterval < 0)
			//tPaymentMainDto.setInterestDays(new Integer((int)(((pPaymentMainDto.getRepayDate().getTime() - tIssueMainDto.getIssueDate().getTime())/86400000L) + 1)));
			tPaymentMainDto.setInterestDays(DateUtil.getDays(tIssueMainDto.getIssueDate(),pPaymentMainDto.getRepayDate()));
		else
			tPaymentMainDto.setInterestDays(tInterval);
		IssueExchangeDet tIssueExchangeDet = new IssueExchangeDetDAO().get(new Integer(tPaymentMainDto.getIssueId()),session);

		if(tIssueExchangeDet != null){
			tIssueExchangeDet.setExchangeAmount(tIssueExchangeDet.getExchangeAmount().add(new BigDecimal(pCapitalAmount)));
			tIssueExchangeDet.setExchangeStockAmount(tIssueExchangeDet.getExchangeStockAmount().add(new BigDecimal(pCapitalAmount).divide(((tIssueExchangeDet.getOriginalPrice()!= null)?tIssueExchangeDet.getOriginalPrice():new BigDecimal(1)),4,5)));
		}
		else{
			tIssueExchangeDet = new IssueExchangeDet();
			tIssueExchangeDet.setIssue(tIssueMainDto);
			tIssueExchangeDet.setExchangeAmount(new BigDecimal(pCapitalAmount));
			tIssueExchangeDet.setExchangeStockAmount(new BigDecimal(pCapitalAmount));  //*** BigDecimal 小數太多會error
		}
		
		new IssueExchangeDetDAO().saveOrUpdate(tIssueExchangeDet,session);		
		return tPaymentMainDto;
	}
	
	private int getInterestInterval(PaymentMain pPaymentMainDto, IssueMain pIssueMainDto,Session session){
		Date tStartDate = null;
		Criteria criteria = session.createCriteria(PaymentMain.class);
		criteria.add(Expression.eq("plan.id", new Integer(pPaymentMainDto.getPlan().getId())));	//**** plan 是有關連的table 
		criteria.add(Expression.eq("debtId", new Integer(pPaymentMainDto.getDebtId())));
		criteria.add(Expression.eq("issueId", new Integer(pPaymentMainDto.getIssueId())));
		List tList = criteria.list();
		if((null == tList || 0 == tList.size()))		//*** list null 時不會是null
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
 
