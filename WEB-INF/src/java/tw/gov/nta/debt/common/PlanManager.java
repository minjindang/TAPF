package tw.gov.nta.debt.common;

import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ListToolManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtPlanTicketDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class PlanManager{
 
	/**
	 * 依傳入參數新增計畫資訊至資料庫
	 * @param startDate:計畫開始日期
	 * @param endDate：計畫結束日期
	 * @throws Exception 
	 * @throws HibernateException
	 */

    InterestCounter interestCounter = new InterestCounter();
    DebtManager debtManager = new DebtManager();
    DebtPlanDetDAO planDao = DebtPlanDetDAO.getInstance();

    public void buildPlan(DebtMain debt, Date startDate, Date endDate) throws Exception{
        Session session = planDao.getSession();
        Transaction tx = session.beginTransaction();
        try {
        	buildPlan(debt,startDate,endDate,session);
        	tx.commit();
        }catch (Exception e) {
			// TODO: handle exception
        	tx.rollback();
		}
	}

    
    public void buildPlan(DebtMain debt, Date startDate, Date endDate,Session session) throws Exception{
    	List tList = generatePlanList(debt, startDate, endDate ,session);
        confirm(tList,session);
	}    

    public void confirm(List planList) throws Exception{
    	Session session = planDao.getSession();
    	Transaction tx = session.beginTransaction();
    	try {
	    	confirm(planList,session);
	    	tx.commit();
    	}catch(Exception ex) {
    		tx.rollback();
    	}
	}         
    
    public void confirm(List planList,Session session) throws Exception{
		if(planList == null || planList.size() == 0)
			throw new Exception("無計畫資料");
		for(Iterator iterator = planList.iterator();iterator.hasNext();){
			confirm((DebtPlanDet)iterator.next(),session);		
		}	
	}     
	/**
	 * 產生預設空白之PlanBean
	 * @param debtId
	 * @return
	 */
    
    public DebtPlanDet createBean(DebtMain debt) {
    	DebtPlanDet tDebtPlanDet = new DebtPlanDet();
        tDebtPlanDet.setIssueId(debt.getIssue().getId());
        tDebtPlanDet.setDebt(debt);
		return tDebtPlanDet;
	}
    
    public DebtPlanDet createBean(int debtId) {
        DebtPlanDet tDebtPlanDet = new DebtPlanDet();
        DebtMain tDebtMain = debtManager.getBean(debtId);
        tDebtPlanDet.setIssueId(tDebtMain.getIssue().getId());
        tDebtPlanDet.setDebt(tDebtMain);
		return tDebtPlanDet;
	}
    
    /**加 一 支
	 * 依發行取得所有還本付息資料
	 * @param pIssueId
	 * @return
	 */
	public List byIssueIdPDate(int pIssueId , Date planRepayDate){
		Session tSession = planDao.getSession();
		Criteria criteria = tSession.createCriteria(DebtPlanDet.class);
		if(0 != pIssueId)
		{	
	    	criteria.add(Expression.eq("issueId", new Integer(pIssueId)));
		}
		if(null != planRepayDate)
		{
			criteria.add(Expression.eq("repayDate", planRepayDate));	//debtplan.repaydate
		}
	    List tResult = criteria.list();
	    tSession.close();
	    return tResult;
	}
	 /**加 一 支
	 * 依發行取得所有還本付息資料
	 * @param pIssueId
	 * @return
	 */
	public List getIssueIdPDateDMarkN(int pIssueId , Date planRepayDate,String deleteMark){
		Session tSession = planDao.getSession();
		Criteria criteria = tSession.createCriteria(DebtPlanDet.class);
		if(0 != pIssueId)
		{	
	    	criteria.add(Expression.eq("issueId", new Integer(pIssueId)));
		}
		if(null != planRepayDate)
		{
			criteria.add(Expression.eq("repayDate", planRepayDate));	//debtplan.repaydate
		}
		if(null != deleteMark)
		{	
			criteria.add(Expression.eq("deleteMark",deleteMark));
		}
	    List tResult = criteria.list();
//	    tSession.close();
	    return tResult;
	}
	public Date getMaxInterestDate(DebtPlanDet pDebtPlanDet){
		Session tSession = planDao.getSession();
		String hql = "select min(d.interestDate) as interestDate from DebtMain d ";
		hql +=" where d.issue.id = " + pDebtPlanDet.getIssueId();
		hql +=" and d.bank.id = " + pDebtPlanDet.getDebt().getBank().getId();
		Query query = tSession.createQuery(hql);
		return (Date)query.list().get(0);
	}
	 /**加 一 支
	 * 依Debtid取得所有還本付息資料
	 * @param pIssueId
	 * @return
	 */
	public List byDebtId(int pDebtId){
		Session tSession = planDao.getSession();
		Criteria criteria = tSession.createCriteria(DebtPlanDet.class);
		if(0 != pDebtId)
		{	
	    	criteria.add(Expression.eq("debt.id", new Integer(pDebtId)));
	    	criteria.add(Expression.eq("deleteMark","N"));
		}
	    criteria.addOrder(Order.asc("repayDate"));
	    List tResult = criteria.list();
	    tSession.close();
	    return tResult;
	}
    /**
     * 新增Method依照DebtPlanDet取得環本付息資料
     * @param pDebtMainDto
     * @return List
     * @author Andrew Sung
     */
	public List byDebtPlan(DebtPlanDet pDto){
		Session tSession = planDao.getSession();
		Criteria criteria = tSession.createCriteria(PaymentMain.class);
		criteria.add(Expression.eq("plan",pDto));
		List tResult = criteria.list();
		tSession.close();
		return tResult;
	}
    /**
     * 新增Method取得該Debt還本記錄最後一筆資料
     * @param pDebtMainDto
     * @return PaymentMain
     * @author Andrew Sung
     */
	public List maxDateByDebt(){
		Session tSession = planDao.getSession();
		Criteria criteria = tSession.createCriteria(PaymentMain.class);
		criteria.setProjection(Projections.max("repayDate"));
		List list = criteria.list();
		tSession.close();
		return list;
	}
    
	/**
	 * 依傳入條件產生多筆計畫
	 * @param debtId 要產生計畫的借款
	 * @param startDate 計畫產生開始日期
	 * @param endDate   計畫產生結束日期
	 * @return
	 * @throws HibernateException
	 */
    public List generatePlanList(DebtMain debt, Date startDate, Date endDate,Session session){
        List<DebtPlanDet> resultList = new ArrayList<DebtPlanDet>();
        IssueMain issue = debt.getIssue();
        Date issueEndDate = null;
        Date issueStartDate = null;
        //如果是公債，結束日期為finishDate
        //其他債種帶dueDate
		if("A".equals(issue.getDebtType())) {
			issueEndDate = issue.getFinishDate();
		}else {
			issueEndDate = issue.getDueDate();
		}
		
		issueStartDate = issue.getIssueDate();
		
		//如果是增額公債，開始付息跟開始還本日期要抓原始發行的日期
        try {
	        if (!issue.getId().equals(issue.getSourceIssueId())&& issue.getSourceIssueId()!=null) {
	        	IssueMain sourceIssue = (IssueMain)session.get(IssueMain.class,issue.getSourceIssueId());
	        	issue.setFirstInterestDate(sourceIssue.getFirstInterestDate());
	        	issue.setFirstRepayDate(sourceIssue.getFirstRepayDate());
	        	issueStartDate = sourceIssue.getIssueDate();
        }
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
        String capitalCountBaseRule = null; //區間計算原則 Month/Day
        String interestCountbaseRule = null;//區間計算原則 Month/Day
        
        //如果沒有首次付息日期(目前發生在中長借 跟短借)
        //就先設結束日期
        if (issue.getFirstInterestDate() == null)
        	issue.setFirstInterestDate(issueEndDate);
        
        //取得付本次數
        Integer totalPayCapitalTimes = issue.getRepayAlternate();
        
        //沒有設或為零時，次數設為1
        if (totalPayCapitalTimes == null || totalPayCapitalTimes.intValue() == 0)
        	totalPayCapitalTimes = 1;
        
        //取得付息次數
        Integer totalPayInterestTimes = issue.getInterestAlternate();
        
        //沒有設或為零時，次數設為1
        if (totalPayInterestTimes == null || totalPayInterestTimes.intValue() == 0)
        	totalPayInterestTimes = 1;
        
        Calendar calendar = Calendar.getInstance();

        //計算還本及計息區間
        /*
         * 首次還本付息的日如果等於到期日期的日 (1/1的1號 = 3/1的1號)
         * 就用月份的算法
         * 不然就用天數來算區間
         */
        calendar.setTime(issueEndDate);
        
        int dueYear = calendar.get(Calendar.YEAR);
        int dueMonth = calendar.get(Calendar.MONTH);
        int dueDate = calendar.get(Calendar.DATE);
        int dueMaximumDate = calendar.getActualMaximum(Calendar.DATE);
        
        //取得還本間距
        int payCapitalPeriod = 0;
        
        calendar.setTime(issue.getFirstRepayDate());
        
        int firstRepayYear = calendar.get(Calendar.YEAR);
        int firstRepayMonth = calendar.get(Calendar.MONTH);
        int firstRepayDate = calendar.get(Calendar.DATE);
        int firstRepayMaximumDate = calendar.getActualMaximum(Calendar.DATE);
        
        //如果日數相同或都是月底就用月間距來算
        if (dueDate == firstRepayDate ||(firstRepayDate == firstRepayMaximumDate && dueDate == dueMaximumDate)) {
        	capitalCountBaseRule = "Month";
        	//取得間距的長度
        	if (totalPayCapitalTimes > 1) {
        		payCapitalPeriod = ((dueYear - firstRepayYear) * 12 + (dueMonth - firstRepayMonth)) /(totalPayCapitalTimes - 1) ;
        	}else {
        		payCapitalPeriod = 0;
        	}
        }else {              
        	capitalCountBaseRule = "Day";
        	if(totalPayCapitalTimes > 1) {
                //取得還本間距
                int payCapitalDayBetween =  DateUtil.getDays(issue.getFirstRepayDate(),issueEndDate);
        		payCapitalPeriod = payCapitalDayBetween / (totalPayCapitalTimes - 1);
        	}else {
        		payCapitalPeriod = 0;
        	}
        }
        
        //取得付息間距
        int payInterestPeriod = 0;
        
        calendar.setTime(issue.getFirstInterestDate());
        
        firstRepayYear = calendar.get(Calendar.YEAR);
        firstRepayMonth = calendar.get(Calendar.MONTH);
        firstRepayDate = calendar.get(Calendar.DATE);     
        firstRepayMaximumDate = calendar.getActualMaximum(Calendar.DATE);

        if (dueDate == firstRepayDate ||(firstRepayDate == firstRepayMaximumDate && dueDate == dueMaximumDate)) {
        	interestCountbaseRule = "Month";
        	if(totalPayInterestTimes > 1) {
        		//付息間距長度
        		payInterestPeriod = ((dueYear - firstRepayYear) * 12 + (dueMonth - firstRepayMonth)) / (totalPayInterestTimes - 1);
        	}else {
        		payInterestPeriod = 0;
        	}
        }else {
        	interestCountbaseRule = "Day";
        	if(totalPayInterestTimes > 1) {
                int payInterestDayBetween =  DateUtil.getDays(issue.getFirstInterestDate(),issueEndDate); 
        		payInterestPeriod = payInterestDayBetween / (totalPayInterestTimes - 1) ;
        	}else {
        		payInterestPeriod = 0;
        	}
        }
        
//      初始化日曆日期為首次還本日期
        calendar.setTime(issue.getFirstRepayDate());
        
        //取得利率列表
        
        //先取得有效利率的group_id
        RateManager rateManager = new RateManager();
        int rateGroupId = rateManager.getEffectRateGroupId(debt,session);
        
        
        //產生還本資料
        //從issueDate開始，依還本間距長度，產生各期還本
        //如果產生計畫日期小於開始日期or大於結束日期就不產生
        
        Date originalPlanDate = null;
        Date planDate = issueStartDate;
        
        //累積還本金額
        BigDecimal accumCapitalAmount = new BigDecimal(0);
    	if("A".equals(debt.getIssue().getDebtType()))
    	{
    		Double capitalAmount = new PayManager().getCapitalByDept(debt.getId());//取得已償付之本金
    		if(null != capitalAmount && capitalAmount > 0)
    			accumCapitalAmount = new BigDecimal(capitalAmount);
    	}
        rateManager.getEffectRateGroupId(debt,session);
        for(int periodNo = 1 ; periodNo <= totalPayCapitalTimes ; periodNo++){	
        	//前一個計畫日期
        	originalPlanDate = planDate;
        	
        	//取得計畫日期
        	planDate = getPlanDate(issue,issue.getFirstRepayDate(),capitalCountBaseRule,payCapitalPeriod,periodNo);
        	
        	//取得剩餘本金
        	//剩餘本金 = 發行金額 - 已計畫還本金額
        	BigDecimal remainAmount = debt.getIssueAmount().subtract(accumCapitalAmount);
        	remainAmount = remainAmount.setScale(4,BigDecimal.ROUND_UP);
        	
        	//產生該期還本計畫
        	DebtPlanDet plan = generatePlan("C",debt, planDate, remainAmount, periodNo ,totalPayCapitalTimes - periodNo + 1,originalPlanDate,capitalCountBaseRule,payCapitalPeriod,rateGroupId,session);
        	
       		resultList.add(plan);
        	
        	//更新已計畫還本金額
        	accumCapitalAmount = accumCapitalAmount.add(plan.getCapitalAmount());
        }
        
        //產生付息資料
        originalPlanDate = null;
        planDate = issueStartDate;   
        
        for(int periodNo = 1 ; periodNo <= totalPayInterestTimes ; periodNo++){
        	originalPlanDate = planDate;
           	planDate = getPlanDate(issue,issue.getFirstInterestDate(),interestCountbaseRule,payInterestPeriod,periodNo);  	
        	BigDecimal remainAmount = getRemainCapital(planDate,resultList);//取得計畫日期時剩餘本金
           	DebtPlanDet plan = generatePlan("I",debt, planDate, remainAmount, periodNo ,totalPayInterestTimes - periodNo + 1,originalPlanDate,interestCountbaseRule,payInterestPeriod,rateGroupId,session);
            resultList.add(plan);
        }
        
    	//如果該期還本計畫在開始及結束之間就產生
        for(Iterator iterator = resultList.iterator();iterator.hasNext();) {
        	DebtPlanDet plan = (DebtPlanDet)iterator.next();
        	if (!(plan.getRepayDate().after(startDate)&&(planDate.before(endDate) || planDate.equals(endDate))))
        		iterator.remove();
    	}
		return resultList;
	}
	 
	private BigDecimal getRemainCapital(Date planDate, List planList) {
		// TODO Auto-generated method stub
		BigDecimal remainCapitalAmount = new BigDecimal(0);
		
		for(Iterator iterator = planList.iterator();iterator.hasNext();) {
			DebtPlanDet plan = (DebtPlanDet)iterator.next();
			Date planRepayDate = plan.getRepayDate();
			
			if (planRepayDate.after(planDate)|| planRepayDate.equals(planDate))			
				remainCapitalAmount = remainCapitalAmount.add(plan.getCapitalAmount());
		}	
		return remainCapitalAmount;
	}


	private Date getPlanDate(IssueMain issue,Date firstRepayDate, String countBaseRule,int period,int periodNo) {
		// TODO Auto-generated method stub
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(firstRepayDate);
		
       	if("Month".equals(countBaseRule))
    		calendar.add(Calendar.MONTH,period * (periodNo - 1) );
    	else
    		calendar.add(Calendar.DATE,period * (periodNo - 1) );
       	
       	Date playDate = calendar.getTime();
		return playDate;
	}

	/**
	 * 依傳入條件產生單筆計畫
	 * @param planType 計畫種類 'C' =>本金 'I' =>利息 
	 * @param planDate 計畫日期
	 * @param remainCapital 計畫日期時剩餘本金
	 * @param remainPeriod  剩餘期數
	 * @return
	 * @throws HibernateException
	 */
    private DebtPlanDet generatePlan(String planType,DebtMain debt, Date planDate, BigDecimal remainCapital,int currentPeriod, int remainPeriod,Date originalPlanDate,String countbaseRule,int payPeriod,int rateGroupId,Session session){
        //1、產生新的PlanBean
        DebtPlanDet debtPlanDetDTO = (DebtPlanDet) createBean(debt);
        BigDecimal capitalAmount = null,interestAmount = null;
        Calendar calendar = Calendar.getInstance();

        if ("C".equals(planType))
	        //2、剩餘本金除以剩餘期數取得該期計畫還款本 金金額
        	//債種為B國庫券或債種為A=>公債 且為零息公債(zeroInterestStatus = 'Y')時，
        	//還本金額為實際借款金額
        	
        	if(("B".equals(debt.getIssue().getDebtType()))||
        		 ("A".equals(debt.getIssue().getDebtType()) && 
       			 "Y".equals(debt.getIssue().getZeroInterestStatus()))) {
        		//提前償付本金(公債)
        		BigDecimal accumCapitalAmount = new BigDecimal(0);
        		Double paymentCapitalAmount = new PayManager().getCapitalByDept(debt.getId());//取得已償付之本金
        		if(null != paymentCapitalAmount && paymentCapitalAmount > 0)
        			accumCapitalAmount = new BigDecimal(paymentCapitalAmount);
        		
        		capitalAmount = debt.getRealAmount().subtract(accumCapitalAmount);
        	}else {
        		capitalAmount = remainCapital.divide(new BigDecimal(remainPeriod),2);
        	}
        else
        	capitalAmount = new BigDecimal(0);
        
        //4、計算該期計畫付息金額
        if ("I".equals(planType)) {
        	//債種為B=>國庫券時，付息金額為差價金額
        	//債種為A=>公債 且為零息公債(zeroInterestStatus = 'Y')時，付息金額為差價金額
        	if("B".equals(debt.getIssue().getDebtType())) {
        		interestAmount = debt.getDiversityAmount();
        	}else if("A".equals(debt.getIssue().getDebtType()) && 
        			 "Y".equals(debt.getIssue().getZeroInterestStatus())) {
        		interestAmount = debt.getDiversityAmount().multiply(new BigDecimal(-1));
        	}else{
	            calendar.setTime(planDate);
		        Date countDate = calendar.getTime();
		        
		        //取得使用利率列表
		        List rateList = new RateManager().getRateByGroupId(debt,rateGroupId,session);
		        
		        if ("Month".equals(countbaseRule)&&"A".equals(debt.getIssue().getDebtType())) {
	        		double rate = ((DebtRateDet)rateList.get(0)).getDebtRate().doubleValue();
	        		interestAmount = new BigDecimal(remainCapital.doubleValue() * (rate/100) * (payPeriod/12.0)).setScale(10,BigDecimal.ROUND_HALF_UP);
		        }else {
		        	interestAmount = interestCounter.countInterest(originalPlanDate, countDate, rateList, remainCapital.doubleValue(), 0);
		        }
        	}
	    }else {
        	interestAmount = new BigDecimal(0);
        }
 
        debtPlanDetDTO.setRepayDate(planDate);//計畫日期
        debtPlanDetDTO.setCapitalAmount(capitalAmount);//計畫還款金額
        debtPlanDetDTO.setInterestAmount(interestAmount);
        debtPlanDetDTO.setRateGroupId(rateGroupId);
        //取得計畫付息金額
        /**
         * 因為公債發行增額公債時，會預先扣一筆應付利息，金額為增額發行前的利息(有記在issue裡)
         * 必須於發行後第一次付息時扣除，因此要計算原始應付利息(interestAmount)及實際計畫利息(payableInterestAmount)
         */
        if ("I".equals(planType)&&"A".equals(debt.getIssue().getDebtType())
        		&&!debt.getIssue().getId().equals(debt.getIssue().getSourceIssueId())
        		&&getPeriod(debt.getIssue().getIssueDate(),debt.getIssue().getFirstInterestDate(),debt.getIssue().getFinishDate(),countbaseRule,payPeriod) == currentPeriod ){
        	BigDecimal payableInterestAmount = debt.getIssue().getPayableInterestAmount();        	
        	if (payableInterestAmount == null)
        		payableInterestAmount = new BigDecimal(0);
        	 	
        	BigDecimal originInterestAmount = interestAmount.subtract(payableInterestAmount);
        	//~~~~~~~~~~~~~~~20101028修改為應付利息僅在第一個預算別
        	List planList = new PlanManager().getIssueIdPDateDMarkN(debt.getIssue().getId(),null,"N");
        	String deleteYN = "N";
        	if(null != planList && !planList.isEmpty()){
            	for(Iterator planIterator = planList.iterator();planIterator.hasNext();) {
            		DebtPlanDet plan = (DebtPlanDet)planIterator.next();
            		if("N".equals(plan.getDeleteMark())){
            			deleteYN = "Y";
            			break;
            		}
            	}
        	}
    		
    		if(!"Y".equals(deleteYN))
            	debtPlanDetDTO.setOriginInterestAmount(originInterestAmount);
    		else
    			debtPlanDetDTO.setOriginInterestAmount(interestAmount);//計畫原始應付息金額
        	//~~~~~~~~~~~~~~~~~~~~~~~
        }else {
            debtPlanDetDTO.setOriginInterestAmount(interestAmount);//計畫原始應付息金額
        }
 
        if ("C".equals(planType)) {
        	if ("A".equals(debt.getIssue().getDebtType())||"B".equals(debt.getIssue().getDebtType())||"C".equals(debt.getIssue().getDebtType())){
        		BigDecimal chargeRate = debt.getIssue().getChargeRate();
        		if (chargeRate == null)
        			chargeRate = new BigDecimal(0);
        		
        		BigDecimal chargeAmount = chargeRate.multiply(capitalAmount.add(interestAmount));//手續費
        		debtPlanDetDTO.setChargeAmount(chargeAmount);//計畫手續費金額
        	}
        	debtPlanDetDTO.setCapitalSerial(currentPeriod);
            debtPlanDetDTO.setInterestSerial(0);
        }else if("I".equals(planType)) {
        	debtPlanDetDTO.setCapitalSerial(0);
        	debtPlanDetDTO.setInterestSerial(currentPeriod);
    	}
        //預設值
        debtPlanDetDTO.setUserid("Batch");
        debtPlanDetDTO.setModDate(new Date());
        debtPlanDetDTO.setDeleteMark("N");
		return debtPlanDetDTO;
	}

	/**
	 * 確認單筆計畫資訊
	 * @param plan
	 * @throws Exception 
	 * @throws HibernateException
	 */
    public void confirm(DebtPlanDet pDto) throws Exception {
    	Session session = planDao.getSession();
    	Transaction tx =  session.beginTransaction();
    	try {
	    	confirm(pDto,session);
	    	tx.commit();
    	}catch(Exception e) {
    		tx.rollback();
    		throw e;
    	}
	}

	/**
	 * 確認單筆計畫資訊
	 * @param plan
	 * @throws HibernateException
	 */
    public void confirm(DebtPlanDet pDto,Session session) {
    
    	DebtPlanDet tDebtPlanDetDto = (DebtPlanDet)pDto;

    	//檢核是否為更新
    	if (!(pDto.getId() == null)){
    		tDebtPlanDetDto = (DebtPlanDet) session.get(DebtPlanDet.class, pDto.getId());
    	}
    	
        //1、檢核DTO是否有錯
//        if(!checkBean(tDebtPlanDetDto)) return;
    	if (!checkBean(tDebtPlanDetDto))
    	{
    		System.out.println("@@@@@"+tDebtPlanDetDto.getId());
    		return;
    	} else {
    		System.out.println(tDebtPlanDetDto.getId());
    	}
        //2、如果沒有錯則新增計畫DAO
        
        //3、儲存DTO
        tDebtPlanDetDto.setCapitalAmount(adjustBigDecimal(tDebtPlanDetDto.getCapitalAmount(), 4));
        tDebtPlanDetDto.setChargeAmount(adjustBigDecimal(tDebtPlanDetDto.getChargeAmount(), 4));
//        tDebtPlanDetDto.setInterestAmount(adjustBigDecimal(tDebtPlanDetDto.getInterestAmount(), 4));
        tDebtPlanDetDto.setInterestAmount(adjustBigDecimal(pDto.getInterestAmount(), 4));
        if (tDebtPlanDetDto.getDeleteMark() == null)
        	tDebtPlanDetDto.setDeleteMark("N");
 
        //如果新增時
        //存在同一借款的同一還本別&同一付息期別的計畫，則原計畫的deleteMark設為'Y'
        boolean saveYN = true;
        if (tDebtPlanDetDto.getId() == null) {
        	StringBuffer queryString = new StringBuffer("from DebtPlanDet p ");
        	queryString.append(" where p.debt.issue.debtType <> 'C' and p.debt = :debt and p.interestSerial =:interestSerial and p.capitalSerial = :capitalSerial and p.deleteMark = 'N'");

        	Query query = session.createQuery(queryString.toString());
        	query.setParameter("debt",tDebtPlanDetDto.getDebt());
        	if (tDebtPlanDetDto.getCapitalSerial() == null){
        		if (tDebtPlanDetDto.getCapitalAmount().intValue() > 0){
        			tDebtPlanDetDto.setCapitalSerial(1);
        		}else{
        			tDebtPlanDetDto.setCapitalSerial(0);
        		}
        	}
        	if (tDebtPlanDetDto.getInterestSerial() == null){
        		if (tDebtPlanDetDto.getInterestAmount().intValue() > 0){
        			tDebtPlanDetDto.setInterestSerial(1);
        		}else{
        			tDebtPlanDetDto.setInterestSerial(0);
        		}
        	}       	
        	query.setInteger("capitalSerial",tDebtPlanDetDto.getCapitalSerial());
        	query.setInteger("interestSerial",tDebtPlanDetDto.getInterestSerial());
        	List planList = query.list();
        	for(Iterator planIterator = planList.iterator();planIterator.hasNext();) {
        		DebtPlanDet plan = (DebtPlanDet)planIterator.next();
            	if("A".equals(plan.getDebt().getIssue().getDebtType()))
            	{
            		StringBuffer queryAdvanceString = new StringBuffer("from PaymentMain p ");
            		queryAdvanceString.append(" where p.issueId = " + plan.getDebt().getIssue().getId());
            		queryAdvanceString.append(" and p.capitalAmount > 0 ");
            		queryAdvanceString.append(" and p.modDate between '" + 
            				DateUtil.date2Str(new Date()) + "' and '" + DateUtil.dateIncrease(DateUtil.date2Str(new Date()),1) + "'");
            		PaymentMainDAO payDao = PaymentMainDAO.getInstance();
            		Session pSession = payDao.getSession();
            		query = pSession.createQuery(queryAdvanceString.toString());
            		List issueMainList = query.list();
            		
            		if(issueMainList.size() > 0)
            			saveYN = false;	
            	}
            	if(saveYN)
            		plan.setDeleteMark("Y");
        		try {
        			isModified(plan,session);
        		}catch(HibernateException ex) {
        			ex.printStackTrace();
            		throw new HibernateException(ex.getMessage());
            	}
        		if(saveYN)
        			session.saveOrUpdate(plan);
        	}
        }else {
        	try {
        		isModified(tDebtPlanDetDto,session);
        	}catch(HibernateException ex) {
        		throw new HibernateException(ex.getMessage());
        	}
        }
        if(saveYN)
        	session.saveOrUpdate(tDebtPlanDetDto);

        //如果發行是債票形式，要多加insert 到DebtPlanTicketDet
        if ("1".equals(tDebtPlanDetDto.getDebt().getIssue().getIssueKind())) {
        	insertDebtPlanTicketDet(tDebtPlanDetDto,session);
        }
	}    
    
	private BigDecimal adjustBigDecimal(BigDecimal pAmount, int pScale){
		if(pAmount == null)
			return null;
		return pAmount.setScale(pScale, 5);
	}
	public void delete(DebtPlanDet pDto){
		pDto.setDeleteMark("Y");
		new DebtPlanDetDAO().saveOrUpdate(pDto);
		
	}
	/**
	 * 檢核計畫資料是否正確
	 * @param pDTO
	 * @return
	 */
    public boolean checkBean(Object pDto) {
    	DebtPlanDet tDebtPlanDetDto = (DebtPlanDet)pDto;
        BigDecimal tZero = new BigDecimal(0);
        if(tDebtPlanDetDto.getCapitalAmount() == null)
        	tDebtPlanDetDto.setCapitalAmount(tZero);
        if(tDebtPlanDetDto.getInterestAmount() == null)
        	tDebtPlanDetDto.setInterestAmount(tZero);
		if(tDebtPlanDetDto.getChargeAmount() == null)
			tDebtPlanDetDto.setChargeAmount(tZero);
        //檢查計畫還款金額、計畫付息金額、計畫手續費金額是否皆大於等於零
		return (tDebtPlanDetDto.getCapitalAmount().compareTo(tZero) != -1) && (tDebtPlanDetDto.getInterestAmount().compareTo(tZero) != -1) && (tDebtPlanDetDto.getChargeAmount().compareTo(tZero) != -1);
	}

	/**
	 * 取得所有的計畫資訊
	 * @return
	 * @throws HibernateException
	 */
    public List getAllPlanList() {
        DebtPlanDetDAO tDebtPlanDetDAO = new DebtPlanDetDAO();
                Query debtPlanQuery= tDebtPlanDetDAO.getQuery("from DebtPlanDet",tDebtPlanDetDAO.getSession());
        return debtPlanQuery.list();
//        return tDebtPlanDetDAO.findAll();
    }   
    
	/**
	 * 取得該筆借款所有的計畫資訊
	 * @return
	 * @throws HibernateException
	 */
    public List getAllPlanListByDebt(DebtMain debt) {
    	ArrayList ls = new ArrayList();
    	Session session = new PaymentMainDAO().getSession();
    	 Criteria criteria = session.createCriteria(DebtPlanDet.class);
    	 criteria.add(Expression.eq("debt",debt));
    	 List list = criteria.list();
    	 session.close();
    	 return list;
//    	for(Iterator a = debt.getDebtPlanDets().iterator();a.hasNext();)
//    		ls.add(a.next());
//    	return ls;
    	//return new ArrayList<DebtPlanDet>(debt.getDebtPlanDets());

	}
    public List getAllPlanListByDebtNotDelete(DebtMain debt) {
    	ArrayList ls = new ArrayList();
    	Session session = new PaymentMainDAO().getSession();
    	 Criteria criteria = session.createCriteria(DebtPlanDet.class);
    	 criteria.add(Expression.eq("debt",debt));
    	 criteria.add(Expression.eq("deleteMark","N"));
    	 List list = criteria.list();
    	 session.close();
    	 return list;
	}
	/**
	 * 取得該筆發行所有的計畫資訊
	 * @return
	 * @throws HibernateException
	 */
    public List getAllPlanListByIssue(IssueMain issue,Session session) {
        Set debtSet = issue.getDebtMains();
        List planList = new ArrayList();
        
        for(Iterator iterator = debtSet.iterator();iterator.hasNext();) {
        	planList.addAll(generatePlanList((DebtMain)iterator.next(),issue.getIssueDate(),issue.getDueDate(),session));
        }
        	
        return planList;
	}
    
	/**
	 * 取得單筆計畫資訊
	 * @param planId
	 * @return
	 * @throws HibernateException
	 */
    public DebtPlanDet getBean(int planId) {
		return getBean(planId,planDao.getSession());
	}
    
	/**
	 * 取得單筆計畫資訊
	 * @param planId
	 * @return
	 * @throws HibernateException
	 */
    public DebtPlanDet getBean(int planId,Session session) {
		return planDao.get(new Integer(planId),session);
	}


    /**
     * 依發行主鍵值取消所有計畫
     * @param pIssueId
     * @throws HibernateException
     */
    public void cancelByIssue(int pIssueId){
        Session tSession = planDao.getSession();
        Criteria criteria = tSession.createCriteria(DebtPlanDet.class);
        DebtPlanDet tDebtPlanDet = null;
        criteria.add(Expression.eq("issueId", new Integer(pIssueId)));
        List tList = criteria.list();
        if(tList == null || tList.size() == 0) return;
        Iterator tIterator = tList.iterator();
        while(tIterator.hasNext()){
        	tDebtPlanDet = (DebtPlanDet)tIterator.next();
        	System.out.println("刪掉" + tDebtPlanDet.getId());
        	planDao.delete(tDebtPlanDet.getId(),tSession);
        }
        tSession.close();
    }
    
    /**
     * 依發行主鍵值取消所有計畫
     * @param issueId
     * @throws HibernateException
     */
    public void cancelByDebt(int pDebtId){
        DebtPlanDetDAO tDebtPlanDetDAO = new DebtPlanDetDAO();
        Session session = tDebtPlanDetDAO.getSession();
        Criteria criteria = session.createCriteria(DebtPlanDet.class);
        DebtMain tDebtMain = new DebtMain();
		tDebtMain.setId(new Integer(pDebtId));
        criteria.add(Expression.eq("debt", tDebtMain));
        List tList = criteria.list();
        if(tList == null || tList.size() == 0) return;
        Iterator tIterator = tList.iterator();
        Transaction tx = session.beginTransaction();
        
        while(tIterator.hasNext()) {
        	DebtPlanDet plan = (DebtPlanDet)tIterator.next();
        	try {
        		isModified(plan,session);
        	}catch(HibernateException ex) {
        		tx.rollback();
        		throw new HibernateException(ex.getMessage());
        	}
        	
        	tDebtPlanDetDAO.delete(plan,session);
        }   
        tx.commit();
    }    

    /**
	 * 取得CombinText List
	 * @param null
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getPlan(String value) throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        DebtPlanDetDAO dao = new DebtPlanDetDAO();
		Session session = dao.getSession();
		StringBuffer strbuff = new StringBuffer();
		strbuff.append("select debtPlanDet.repayDate from DebtPlanDet debtPlanDet, IssueMain issueMain ");
		strbuff.append("where 1 = 1");
		if(null != value && !"".equals(value) && !" ".equals(value))
		{
			strbuff.append(" and issueMain.id = '");
			strbuff.append(value);
			strbuff.append("'");
		}
		strbuff.append(" and debtPlanDet.issueId = issueMain.id and debtPlanDet.deleteMark ='N'");
		strbuff.append(" group by debtPlanDet.repayDate order by debtPlanDet.repayDate");
		Query query = session.createQuery(strbuff.toString());
        List collection = query.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	Date repayDate = (Date) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(DateUtil.date2ROCStr((Date)repayDate));		//****
            	labelValueBean.setValuess(DateUtil.date2ROCStr((Date)repayDate));	//***
            	labelValueBeanList.add(labelValueBean);
            }
        }
        return labelValueBeanList;
	}
	
	private void insertDebtPlanTicketDet(DebtPlanDet plan,Session session) {
		IssueMain issue = (IssueMain)session.get(IssueMain.class,plan.getDebt().getIssue().getId());
		Set issueTicketDets = issue.getIssueTicketDets();
		
		BigDecimal issueAmount = plan.getDebt().getIssue().getIssueAmount();
		for(Iterator iterator = issueTicketDets.iterator();iterator.hasNext();) {
			IssueTicketDet issueTicket = (IssueTicketDet)iterator.next();
			BigDecimal ticketTotal = issueTicket.getTicketAmount();
			DebtPlanTicketDet debtPlanTicketDet = new DebtPlanTicketDet();
			debtPlanTicketDet.setPlan(plan);
			debtPlanTicketDet.setTicketCount(issueTicket.getTicketCount());
			debtPlanTicketDet.setTicketName(issueTicket.getTicketName());
			debtPlanTicketDet.setTicketAmount(issueTicket.getTicketAmount());
			BigDecimal rate = new BigDecimal(0);
			if (issueAmount.doubleValue() != 0.0) {
				rate = ticketTotal.divide(issueAmount,3);
			}
			
			debtPlanTicketDet.setCapitalAmount(plan.getCapitalAmount().multiply(rate));
			debtPlanTicketDet.setInterestAmount(plan.getInterestAmount().multiply(rate));
			debtPlanTicketDet.setModDate(plan.getModDate());
			debtPlanTicketDet.setUserid(plan.getUserid());
			session.saveOrUpdate(debtPlanTicketDet);
		}
	}
	
	private int getPeriod(Date checkDate,Date startDate,Date endDate,String countbaseRule,int datePeriod) {
	   Calendar calendar = Calendar.getInstance();
	   calendar.setTime(startDate);
	   
       for(int periodNo=1;calendar.getTime().before(endDate);){
    	 if (calendar.getTime().after(checkDate) || calendar.getTime().equals(checkDate))
    		 return periodNo;
    	 
    	 if ("Month".equals(countbaseRule)) {
    		 calendar.add(Calendar.MONTH,datePeriod);
    	 }else {
    		 calendar.add(Calendar.DATE,datePeriod);
    	 }
    	 periodNo ++;	 
       }
       return 1;
	}
	
	public void setDeleteRemark(List obj){
		DebtPlanDetDAO myDAO = new DebtPlanDetDAO();
		if(null != obj && 0 !=obj.size())
		{
			for(Iterator it=obj.iterator();it.hasNext();)
			{
				DebtPlanDet debtPlanDet = (DebtPlanDet)it.next();
				debtPlanDet.setDeleteMark("Y");
				myDAO.update(debtPlanDet);
			}
		}
	}
	
	//判斷是否可修改資料
	private void isModified(DebtPlanDet plan,Session session) throws HibernateException{
		//如果有該計畫之還本資料時，不可以異動該計畫
       	StringBuffer queryString = new StringBuffer("from PaymentMain p ");
    	queryString.append(" where p.plan = :plan");
    	Query query = session.createQuery(queryString.toString());
    	query.setParameter("plan",plan);
    	List paymentList = query.list();
    	
    	//是否為公債提前償付 20100302 Chris Wu 
    	boolean advance = true;
    	if("A".equals(plan.getDebt().getIssue().getDebtType()))
    	{
    		StringBuffer queryAdvanceString = new StringBuffer("from PaymentMain p ");
    		queryAdvanceString.append(" where p.issueId = " + plan.getDebt().getIssue().getId());
    		queryAdvanceString.append(" and p.capitalAmount > 0 ");
    		queryAdvanceString.append(" and p.modDate between '" + 
    				DateUtil.date2Str(new Date()) + "' and '" + DateUtil.dateIncrease(DateUtil.date2Str(new Date()),1) + "'");
    		query = session.createQuery(queryAdvanceString.toString());
    		List issueMainList = query.list();
    		
    		if(issueMainList.size() > 0)
    			advance = false;	
    	}    	
    	//end
    	
    	if( paymentList.size() > 0 && advance) {
    		throw new HibernateException("已有付款資料時，不可修改計畫資料!");
    	}
	}
	
	public BigDecimal getMiddlePlanInterestAmount(int planId){
		DebtPlanDet plan = planDao.get(planId);
		int debtId = plan.getDebt().getId();
		Date nowPlanDate = plan.getRepayDate();
		Date lastPlanDate = new Date();
		BigDecimal debtCapitalAmount = new DebtMainDAO().get(debtId).getIssueAmount();
		BigDecimal palnCapitalAmount = new BigDecimal(0);
		String hql = "select max(plan.repayDate) from DebtPlanDet plan where plan.deleteMark='N'";
		hql += " and plan.debt.id="+debtId;
		hql += " and plan.repayDate < '"+new DateUtil().date2Str(nowPlanDate, "yyyy/MM/dd")+"'";
		Query query = planDao.getSession().createQuery(hql);
		if(query.list().get(0)!=null)
			lastPlanDate = (Date) query.list().get(0);
		else{
			lastPlanDate = new IssueManager().getBean(plan.getIssueId()).getIssueDate();
		}
		hql = "select isNull(sum(plan.capitalAmount),0) from DebtPlanDet plan where plan.deleteMark='N'";
		hql += " and plan.debt.id="+debtId;
		hql += " and plan.repayDate < '"+new DateUtil().date2Str(nowPlanDate, "yyyy/MM/dd")+"'";
		query = planDao.getSession().createQuery(hql);
		if(query.list().get(0)!=null)
			palnCapitalAmount = (BigDecimal) query.list().get(0);
		RateManager rm = new RateManager();
		List rate = rm.getEffectiveRate(debtId);
		BigDecimal interestAmount = new InterestCounter().countInterest(lastPlanDate,nowPlanDate, rate ,(debtCapitalAmount.subtract(palnCapitalAmount)).doubleValue() ,0);
		//System.out.println(interestAmount.doubleValue());
		return interestAmount;
	}
	
    public void confirmInterst(List planList) throws Exception{
    	Session session = planDao.getSession();
    	Transaction tx = session.beginTransaction();
    	try {
    		confirmInterst(planList,session);
	    	tx.commit();
    	}catch(Exception ex) {
    		tx.rollback();
    	}
	}         
    
    public void confirmInterst(List planList,Session session) throws Exception{

		if(planList == null || planList.size() == 0)
			throw new Exception("無計畫資料");
		for(Iterator iterator = planList.iterator();iterator.hasNext();){
			confirmInterst((DebtPlanDet)iterator.next(),session);		
		}
		
	}
    
    public void confirmInterst(DebtPlanDet pDto,Session session) {
        
    	DebtPlanDet tDebtPlanDetDto = (DebtPlanDet)pDto;

    	//檢核是否為更新
    	if (!(pDto.getId() == null)){
    		tDebtPlanDetDto = (DebtPlanDet) session.get(DebtPlanDet.class, pDto.getId());
    	}
    	
        //1、檢核DTO是否有錯
        if(!checkBean(tDebtPlanDetDto)) return;
        //2、如果沒有錯則新增計畫DAO
        
        //3、儲存DTO
        tDebtPlanDetDto.setCapitalAmount(adjustBigDecimal(tDebtPlanDetDto.getCapitalAmount(), 4));
        tDebtPlanDetDto.setChargeAmount(adjustBigDecimal(tDebtPlanDetDto.getChargeAmount(), 4));
        tDebtPlanDetDto.setInterestAmount(adjustBigDecimal(pDto.getInterestAmount(), 4));
        if (tDebtPlanDetDto.getDeleteMark() == null)
        	tDebtPlanDetDto.setDeleteMark("N");
       
        session.saveOrUpdate(tDebtPlanDetDto);

	}
}
 
