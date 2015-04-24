package tw.gov.nta.debt.common;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.kangdainfo.ast.sql.SQLRunnerException;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class PayManager extends IManager {
	 
	/**
	 * 產生還本付息資料
	 * @param pPlanId
	 * @param pCapitalNo
	 * @param pInterestNo
	 * @param pCaptialAmount
	 * @param pInterestAmount
	 * @param pRepayDate
	 */
	
	public void repayDebt(int pPlanId, int pCapitalNo, int pInterestNo, double pCaptialAmount, double pInterestAmount, Date pRepayDate){
		this.repayDebt( pPlanId,  pCapitalNo,  pInterestNo,  pCaptialAmount,  pInterestAmount,  pRepayDate,"0");
	}

	public PaymentMain repayDebt(int pPlanId, int pCapitalNo, int pInterestNo, double pCaptialAmount, double pInterestAmount, Date pRepayDate,Session session){
		return this.repayDebt( pPlanId,  pCapitalNo,  pInterestNo,  pCaptialAmount,  pInterestAmount,  pRepayDate,"0",session);
	}
	
	public PaymentMain repayDebt(int pPlanId, int pCapitalNo, int pInterestNo, double pCaptialAmount, double pInterestAmount, Date pRepayDate, Object pInterestDays){
		return this.repayDebt( pPlanId,  pCapitalNo,  pInterestNo,  pCaptialAmount,  pInterestAmount,  pRepayDate,pInterestDays,new IssueMainDAO().getSession());
	}

	public PaymentMain repayDebt(int pPlanId, int pCapitalNo, int pInterestNo, double pCaptialAmount, double pInterestAmount, Date pRepayDate, Object pInterestDays,Session session){
		BigDecimal capitalAmount = new BigDecimal(0);
		PaymentMain tPaymentMainDto = createBean(pPlanId,session);	
		tPaymentMainDto.setRepayDate(pRepayDate);
		PayCapitalManager tPayCapitalManager = new PayCapitalManager();
		if(isExgStock(pPlanId,session))
			tPaymentMainDto = tPayCapitalManager.payCaptialByStock(pCapitalNo, pCaptialAmount, tPaymentMainDto,session);
		else
			tPaymentMainDto = tPayCapitalManager.payCaptialByCash(pCapitalNo, pCaptialAmount, tPaymentMainDto,session);
		tPaymentMainDto = new PayInterestManager().payInterest(pInterestNo, pInterestAmount, tPaymentMainDto,session);
		tPaymentMainDto.setCapitalAmount(new BigDecimal(pCaptialAmount));
		tPaymentMainDto.setCapitalSerial(new Integer(pCapitalNo).toString());
		tPaymentMainDto.setModDate(new Date());
		tPaymentMainDto.setRepayType(tPaymentMainDto.getPlan().getDebt().getIssue().getIssueKind());
		if(session != null){
			new PaymentMainDAO().save(tPaymentMainDto,session);	  
		}else{
			new PaymentMainDAO().save(tPaymentMainDto);	 
		}
	    //更新issueMain還本資料
	    IssueMain tIssueMain = new IssueManager().getBean(tPaymentMainDto.getIssueId());
	    if (tIssueMain.getCapitalAmount() == null)
	    	tIssueMain.setCapitalAmount(new BigDecimal(0));
	    tIssueMain.setCapitalAmount(tIssueMain.getCapitalAmount().add(new BigDecimal(pCaptialAmount)));
	    tIssueMain.setModDate(new Date());
	    if(session!=null){
	    	new IssueMainDAO().update(tIssueMain,session);
	    }else{
	    	new IssueMainDAO().update(tIssueMain);
	    }
	    
	    return tPaymentMainDto;
	    
	}	
	public void repayDebt(int pPlanId, int pCapitalNo, int pInterestNo, double pCaptialAmount, 
			double pInterestAmount, Date pRepayDate,Date planRepayDate , int pInterestDays,Date startDate , Date endDate){
		PaymentMain tPaymentMainDto = createBean(pPlanId);	
		tPaymentMainDto.setRepayDate(pRepayDate);
		PayCapitalManager tPayCapitalManager = new PayCapitalManager();
		if(isExgStock(pPlanId))
			tPaymentMainDto = tPayCapitalManager.payCaptialByStock(pCapitalNo, pCaptialAmount, tPaymentMainDto);
		else
			tPaymentMainDto = tPayCapitalManager.payCaptialByCash(pCapitalNo, pCaptialAmount, tPaymentMainDto);
		tPaymentMainDto = new PayInterestManager().payInterest(pInterestNo, pInterestAmount, tPaymentMainDto);
		tPaymentMainDto.setCapitalAmount(new BigDecimal(pCaptialAmount));
		tPaymentMainDto.setCapitalSerial(new Integer(pCapitalNo).toString());
		tPaymentMainDto.setPlanRepayDate(planRepayDate);
		tPaymentMainDto.setInterestDays(pInterestDays);
		tPaymentMainDto.setStartDate(startDate);
		tPaymentMainDto.setEndDate(endDate);
	    
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String sRepayDate = df.format(pRepayDate);
	    
//	    String hqlStrPay = "select  sum(pay.interestAmount) from PaymentMain pay  where pay.issueId  = "+tPaymentMainDto.getIssueId()+" and pay.debtId  = "+tPaymentMainDto.getDebtId()+" and pay.repayDate< '"+sRepayDate+"'";
//		String hqlStr    = "select sum(plan.interestAmount) from DebtPlanDet plan where plan.debt.id = "+tPaymentMainDto.getDebtId() +" and plan.debt.issue.id = "+tPaymentMainDto.getIssueId();
//		Session tSession = new IssueMainDAO().getSession();
//		Query query = tSession.createQuery(hqlStr);
//		Query queryPay = tSession.createQuery(hqlStrPay);
//		Double manageInterestAmount ;
//		try
//		{
//			manageInterestAmount = new Double(String.valueOf(query.list().get(0)));
//		}
//		catch (Exception e)
//		{
//			manageInterestAmount = new Double(0);
//		}
//		
//		try
//		{
//			manageInterestAmount -= (new Double(String.valueOf(queryPay.list().get(0))));
//		}
//		catch (Exception e)
//		{
//		}
//		tPaymentMainDto.setManageInterestAmount(new BigDecimal(manageInterestAmount));
		
	    
		new PaymentMainDAO().save(tPaymentMainDto);	  
	    //更新issueMain還本資料
	    IssueMain tIssueMain = new IssueManager().getBean(tPaymentMainDto.getIssueId());
	    BigDecimal issueCapitalAmount = tIssueMain.getCapitalAmount();
	    if (issueCapitalAmount == null)
	    	issueCapitalAmount = new BigDecimal(0);
	    
	    tIssueMain.setCapitalAmount(tIssueMain.getCapitalAmount().add(new BigDecimal(pCaptialAmount)));
	    if(null == tPaymentMainDto.getInterestAmount())
	    {
	    	tPaymentMainDto.setInterestAmount(new BigDecimal(0));
	    }
	    if(null == tIssueMain.getInterestAmount())
	    {
	    	tIssueMain.setInterestAmount(new BigDecimal(0));
	    }	
	    tIssueMain.setInterestAmount(tIssueMain.getInterestAmount().add(tPaymentMainDto.getInterestAmount()));
	    
	    new IssueMainDAO().update(tIssueMain);
	    setManagerInterestAmount(tPaymentMainDto);
	    
	    //更新DebtMain還本資料
//	    DebtMain tDebtMain = new DebtManager().getBean(tPaymentMainDto.getDebtId());
//	    tDebtMain.setInterestDate(tPaymentMainDto.getRepayDate());	    
//	    new DebtMainDAO().update(tDebtMain);
	}
	
	
	private void setManagerInterestAmount(PaymentMain paymentMainDto) {
		// TODO Auto-generated method stub
		DebtMain debt = paymentMainDto.getPlan().getDebt();
		if(!"C".equals(debt.getIssue().getDebtType().trim())){
			return;
		}else{
			Session session = new DebtMainDAO().createNewSession();
			new RecountInterestManager().InterestAdjust(debt,session);
			session.flush();
			session.close();
		}
		
	}

	/**
	 * 查詢付息資料
	 * @param payDate
	 * @return
	 * @throws HibernateException
	 */
	public PaymentMain getInterestInfo(Date payDate, int pPlanId){
	    PaymentMainDAO tPaymentMainDAO = new PaymentMainDAO();
	    Session tSession = tPaymentMainDAO.getSession();
	    Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("planId", new Integer(pPlanId)));
	    BigDecimal tTotalCapitalAmount = new BigDecimal(0); 

	    PaymentMain tPaymentMainDto = new PaymentMain();
	    DebtPlanDet debtPlanDetDto = new DebtPlanDetDAO().get(new Integer(pPlanId));
	    tPaymentMainDto.setRepayDate(payDate);
	    tPaymentMainDto.setCapitalAmount(debtPlanDetDto.getCapitalAmount().subtract(tTotalCapitalAmount));
	    tPaymentMainDto.setPlanRepayDate(debtPlanDetDto.getRepayDate());
	    IssueMainDAO tIssueMainDao = new IssueMainDAO();
	    IssueMain tIssueMainDto = tIssueMainDao.get(debtPlanDetDto.getIssueId());
	    List tPaymentMainDtoList = criteria.list();
	    PaymentMain tTempPaymentMainDto = null;
	    Date tBigestDate = null;
	    if(tPaymentMainDtoList == null)
	    	tBigestDate = tIssueMainDto.getIssueDate();
	    else{
		    Iterator tIterator = tPaymentMainDtoList.iterator();//若List為null則會爆出Exception
		    while(tIterator.hasNext()){//計算Capital_amount總合
		    	tTempPaymentMainDto = (PaymentMain) tIterator.next();
		    	tTotalCapitalAmount.add(tTempPaymentMainDto.getCapitalAmount());
		    	if(tBigestDate == null || tBigestDate.getTime() < tTempPaymentMainDto.getRepayDate().getTime())
		    		tBigestDate = tTempPaymentMainDto.getRepayDate();
		    }	    	
	    }
	    //(8)
	    tPaymentMainDto.setBalanceCapitalAmount(tIssueMainDto.getIssueAmount().subtract(tIssueMainDto.getCapitalAmount()).subtract(tPaymentMainDto.getCapitalAmount()));
	    //(9)
	    tPaymentMainDto.setManageCapitalAmount(debtPlanDetDto.getCapitalAmount());
	    //(10)
	    tPaymentMainDto.setInterestAmount(new BigDecimal(calculateInterest(payDate, tBigestDate, pPlanId, tPaymentMainDto.getCapitalAmount(), new PlanManager().getBean(pPlanId).getDebt().getId().intValue())));
	    tPaymentMainDto.setInterestDays(new Integer((int)( (payDate.getTime() - tBigestDate.getTime()) / 86400000L) + 1));
	    //(11)已於上面做完
	    //(12)
	    tSession.close();
		return tPaymentMainDto;
	}
	 
	/**
	 * 計算利息資料
	 * @param calculateDate
	 * @return
	 */
	private double calculateInterest(Date calculateDate, Date endDate, int pPlanId, BigDecimal pCapitalAmount, int pDebtId) {
		return (new InterestCounter().countInterest(calculateDate, endDate, new RateManager().getEffectiveRate(pDebtId), pCapitalAmount.doubleValue(), 0)).doubleValue();
	}
	 
	/**
	 * 是否為交換公債
	 * @return
	 * @throws HibernateException
	 */
	protected boolean isExgStock(int pPlanId) {
	    return isExgStock(pPlanId,new DebtPlanDetDAO().getSession());
	}

	/**
	 * 是否為交換公債
	 * @return
	 * @throws HibernateException
	 */
	protected boolean isExgStock(int pPlanId,Session session) {
	    DebtPlanDetDAO tDebtPlanDetDAO = new DebtPlanDetDAO();
	    DebtPlanDet tDebtPlanDetDTO = new DebtPlanDet();
	    if(session == null)
	    	tDebtPlanDetDTO = tDebtPlanDetDAO.get(new Integer(pPlanId));
	    else
	    	tDebtPlanDetDTO = tDebtPlanDetDAO.get(new Integer(pPlanId),session);
	    Criteria criteria = session.createCriteria(IssueMain.class);
	    criteria.add(Expression.eq("id", tDebtPlanDetDTO.getIssueId()));	//***
	    List tList = criteria.list();
	    return tList != null && tList.size() != 0;
	}	
	
	/**
	 * 確定是否可修改，目前只回應true
	 * @param bean
	 * @return
	 */
	public boolean isModify(PaymentMain bean) {
		return true;//依規格目前只回應true
	}
	 
	/**
	 * Check還本付息DTO
	 * 尚未實做
	 * @param bena
	 * @return
	 */
	public boolean checkBean(Object pPaymentDto) {
		return true;//未開規格
	}

	/**
	 * 新增付款Dto
	 * @param planId
	 * @return
	 */
	public PaymentMain createBean(int planId) {			//* 要set repayDate 不然有支method要算拿不到 會變null 而error
		return createBean(planId,new DebtPlanDetDAO().getSession());
	}

	/**
	 * 新增付款Dto
	 * @param planId
	 * @return
	 */
	public PaymentMain createBean(int planId,Session session) {			//* 要set repayDate 不然有支method要算拿不到 會變null 而error
		PaymentMain tPaymentMainDto = new PaymentMain();
		DebtPlanDet tDebtPlanDetDto = new DebtPlanDet();
		if (session == null)
			tDebtPlanDetDto = new DebtPlanDetDAO().get(new Integer(planId));
		else{
//			tDebtPlanDetDto = new DebtPlanDetDAO().get(new Integer(planId),session);
		
			StringBuffer buffer = new StringBuffer();
			buffer.append("from DebtPlanDet As T ");
			buffer.append("where T.id = ?");
			Query query = session.createQuery(buffer.toString());
			query.setParameter(0,planId);		
		    List tAllPlanList = query.list();
		    if(null != tAllPlanList && !tAllPlanList.isEmpty()){
			    for(Iterator tIterator = tAllPlanList.iterator();tIterator.hasNext();){
			    	tDebtPlanDetDto = (DebtPlanDet) tIterator.next();
			    }	    	
		    }
		}
		
		tPaymentMainDto.setIssueId(tDebtPlanDetDto.getIssueId());	
		tPaymentMainDto.setDebtId(tDebtPlanDetDto.getDebt().getId());
		tPaymentMainDto.setPlan(new PlanManager().getBean(planId));
		return tPaymentMainDto ;
	}
	
	/**
	 * 取得付款的Dto
	 */
	public PaymentMain getBean(int pId) {
		return new PaymentMainDAO().get(new Integer(pId));
	}

	/**
	 * 確認存入
	 */
	public void confirm(Object pDTO){
        PaymentMain tPaymentMainDto = (PaymentMain)pDTO;
        //1、檢核DTO是否有錯
        if(!checkBean(tPaymentMainDto)) return;
        //2、如果沒有錯則新增計畫DAO
        PaymentMainDAO tPaymentMainDAO = new PaymentMainDAO();
        //3、儲存DTO
        tPaymentMainDAO.saveOrUpdate(tPaymentMainDto);		
	}
	
	
	
	/**
	 * 依借款取得最後一筆還款日期
	 * @param pDebtId
	 * @return
	 */
	public Date getMaxDateByDebt(int pDebtId){
		Session tSession = new PaymentMainDAO().getSession();
	    Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("debtId", new Integer(pDebtId)));
	    criteria.setProjection(Projections.max("repayDate"));
	    Date tRepayDate = (Date)criteria.list().get(0);
	    tSession.close();
	    return tRepayDate;
	}
	
	/**
	 * 依借款主鍵值取得所有的借款總額
	 * @param pDebtId:借款主鍵值
	 * @return:借款總額
	 */
	public BigDecimal getCapitalByDebt(int pDebtId){
		BigDecimal tResult = new BigDecimal(0);
		Session tSession = new PaymentMainDAO().getSession();
	    Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("debtId", new Integer(pDebtId)));
	    List list = criteria.list();
	    for(Iterator it=list.iterator();it.hasNext();)
	    {	
	    	PaymentMain paymentMain = (PaymentMain)it.next();
	    	tResult = tResult.add(paymentMain.getCapitalAmount());
	    }	
	    tSession.close();
		return tResult;
	}
	/**
	 * 依借款主鍵值取得所有的借款總額
	 * @param pDebtId:借款主鍵值
	 * @param startDate:查詢期間
	 * @return:借款總額
	 */
	public BigDecimal getCapitalByDebt(int pDebtId, Date startDate){
		BigDecimal tResult = new BigDecimal(0);
		Session tSession = new PaymentMainDAO().getSession();
	    Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("debtId", new Integer(pDebtId)));
	    criteria.add(Expression.lt("repayDate", startDate));
	    List list = criteria.list();
	    for(Iterator it=list.iterator();it.hasNext();)
	    {	
	    	PaymentMain paymentMain = (PaymentMain)it.next();
	    	tResult = tResult.add(paymentMain.getCapitalAmount());
	    }	
	    tSession.close();
		return tResult;
	}
	
	/** 加 一 支
	 * 依計畫主鍵值取得所有的借款總額
	 * @param pPlanId:借款主鍵值
	 * @return:借款總額
	 */
	public BigDecimal getCapitalByPlan(int pPlanId){
		BigDecimal tResult = new BigDecimal(0);
		BigDecimal tempValue = new BigDecimal(0);
		Session tSession = new PaymentMainDAO().getSession();
	    Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("plan.id", new Integer(pPlanId)));
	    Iterator tIterator = criteria.list().iterator();
	    while(tIterator.hasNext())
	    {
	    	tempValue = ((PaymentMain)tIterator.next()).getCapitalAmount() ;	
	    	if(null != tempValue)		//**
	    	{
	    		tResult = tResult.add(tempValue);	//**
	    	}
	    }	
//	    tSession.close();
		return tResult;
	}
	/** 加 一 支
	 * 依計畫主鍵值取得所有的利息總額
	 * @param pPlanId:借款主鍵值
	 * @return:利息總額
	 */
	public BigDecimal getInterestByPlan(int pPlanId){
		BigDecimal tResult = new BigDecimal(0);
		BigDecimal tempValue = new BigDecimal(0);
		Session tSession = new PaymentMainDAO().getSession();
	    Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("plan.id", new Integer(pPlanId)));
	    Iterator tIterator = criteria.list().iterator();
	    while(tIterator.hasNext())
	    {
	    	tempValue = ((PaymentMain)tIterator.next()).getInterestAmount() ;	
	    	if(null != tempValue)		//**
	    	{
	    		tResult = tResult.add(tempValue);	//**
	    	}
	    }	
	    tSession.close();
		return tResult;
	}
	
	
	/**
	 * 依發行取得所有還本付息資料
	 * @param pIssueId
	 * @return
	 */
	public List getDataByIssue(int pIssueId){
		Session tSession = new PaymentMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("issueId", new Integer(pIssueId)));
	    criteria.add(Expression.isNull("sourcId"));
	    criteria.addOrder(Order.asc("repayDate"));
	    List tResult = criteria.list();
	    tSession.close();
	    return tResult;
	}
	/**
	 * 依借款取得所有已付息金額
	 * @param pDebtId
	 * @return
	 */
	public double getInterestByDept(int pDebtId){
		Session tSession = new PaymentMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("debtId", new Integer(pDebtId)));
		List tList = criteria.list();
		double tResult = 0;
		if(tList != null && tList.size() != 0){
			Iterator tIterator = tList.iterator();
			while(tIterator.hasNext())
				tResult += ((PaymentMain)tIterator.next()).getInterestAmount().doubleValue();
		}
		tSession.close();
		return tResult;
	}
	
	/**
	 * 卷借款取得所有已還本金額
	 * @param pDebtId
	 * @return
	 */
	public double getCapitalByDept(int pDebtId){
		Session tSession = new PaymentMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("debtId", new Integer(pDebtId)));
		List tList = criteria.list();
		double tResult = 0;
		if(tList != null && tList.size() != 0){
			Iterator tIterator = tList.iterator();
			while(tIterator.hasNext())
				tResult += ((PaymentMain)tIterator.next()).getCapitalAmount().doubleValue();
		}
//		tSession.close();
		return tResult;		
	}
	
	/**
	 * 依計畫取得最後一筆還款日期
	 * @param pPlanId
	 * @return
	 */
	public Date getMaxDateByPlan(DebtPlanDet pPlan){
		Session tSession = new PaymentMainDAO().getSession();
	    Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("plan", pPlan));
	    criteria.setProjection(Projections.max("repayDate"));
	    Date tRepayDate = (Date)criteria.list().get(0);
	    tSession.close();
	    return tRepayDate;
	}
	
	/**
	 * 依計畫取得最後一筆還款日期
	 * @param pPlanId
	 * @return
	 */
	public Date getMaxDateByPlan(Integer planId){
		Session tSession = new PaymentMainDAO().getSession();
	    Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("plan.id", planId));
	    criteria.setProjection(Projections.max("repayDate"));
	    Date tRepayDate = (Date)criteria.list().get(0);
	    tSession.close();
	    return tRepayDate;
	}
	
	public boolean hasPayment(int pIssueId){
		Session tSession = new PaymentMainDAO().getSession();
	    Criteria tCriteria = tSession.createCriteria(PaymentMain.class);
	    tCriteria.add(Expression.eq("issueId", new Integer(pIssueId)));
	    List tList = tCriteria.list();
	    tSession.close();
	    return tList != null && tList.size() != 0;
	}
	public List getListByPlan(int pPlanId){
		Session tSession = new PaymentMainDAO().getSession();
	    Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("plan.id", new Integer(pPlanId)));
	    criteria.addOrder(Order.asc("repayDate"));
	    List tList = criteria.list();
	    tSession.close();
		return tList;
	}
	//取得提前還款資訊
	public List getListByPlan(int pPlanId,Date dueDate){
		Session tSession = new PaymentMainDAO().getSession();
	    Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("plan.id", new Integer(pPlanId)));
	    criteria.add(Expression.lt("repayDate", dueDate));
	    criteria.addOrder(Order.asc("repayDate"));
	    System.out.println(criteria.toString());
	    List tList = criteria.list();
	    tSession.close();
		return tList;
	}
	
	public List getListByDebt(Integer debtId){
		Session tSession = new PaymentMainDAO().createNewSession();
	    Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("debtId",debtId));
	    List tList = criteria.list();
	    tSession.close();
		return tList;
	}

}