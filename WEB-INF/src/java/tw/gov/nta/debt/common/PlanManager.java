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
	 * �̶ǤJ�ѼƷs�W�p�e��T�ܸ�Ʈw
	 * @param startDate:�p�e�}�l���
	 * @param endDate�G�p�e�������
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
			throw new Exception("�L�p�e���");
		for(Iterator iterator = planList.iterator();iterator.hasNext();){
			confirm((DebtPlanDet)iterator.next(),session);		
		}	
	}     
	/**
	 * ���͹w�]�ťդ�PlanBean
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
    
    /**�[ �@ ��
	 * �̵o����o�Ҧ��٥��I�����
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
	 /**�[ �@ ��
	 * �̵o����o�Ҧ��٥��I�����
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
	 /**�[ �@ ��
	 * ��Debtid���o�Ҧ��٥��I�����
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
     * �s�WMethod�̷�DebtPlanDet���o�����I�����
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
     * �s�WMethod���o��Debt�٥��O���̫�@�����
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
	 * �̶ǤJ���󲣥ͦh���p�e
	 * @param debtId �n���ͭp�e���ɴ�
	 * @param startDate �p�e���Ͷ}�l���
	 * @param endDate   �p�e���͵������
	 * @return
	 * @throws HibernateException
	 */
    public List generatePlanList(DebtMain debt, Date startDate, Date endDate,Session session){
        List<DebtPlanDet> resultList = new ArrayList<DebtPlanDet>();
        IssueMain issue = debt.getIssue();
        Date issueEndDate = null;
        Date issueStartDate = null;
        //�p�G�O���šA���������finishDate
        //��L�źرadueDate
		if("A".equals(issue.getDebtType())) {
			issueEndDate = issue.getFinishDate();
		}else {
			issueEndDate = issue.getDueDate();
		}
		
		issueStartDate = issue.getIssueDate();
		
		//�p�G�O�W�B���šA�}�l�I����}�l�٥�����n���l�o�檺���
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
        
        
        String capitalCountBaseRule = null; //�϶��p���h Month/Day
        String interestCountbaseRule = null;//�϶��p���h Month/Day
        
        //�p�G�S�������I�����(�ثe�o�ͦb������ ��u��)
        //�N���]�������
        if (issue.getFirstInterestDate() == null)
        	issue.setFirstInterestDate(issueEndDate);
        
        //���o�I������
        Integer totalPayCapitalTimes = issue.getRepayAlternate();
        
        //�S���]�ά��s�ɡA���Ƴ]��1
        if (totalPayCapitalTimes == null || totalPayCapitalTimes.intValue() == 0)
        	totalPayCapitalTimes = 1;
        
        //���o�I������
        Integer totalPayInterestTimes = issue.getInterestAlternate();
        
        //�S���]�ά��s�ɡA���Ƴ]��1
        if (totalPayInterestTimes == null || totalPayInterestTimes.intValue() == 0)
        	totalPayInterestTimes = 1;
        
        Calendar calendar = Calendar.getInstance();

        //�p���٥��έp���϶�
        /*
         * �����٥��I������p�G������������� (1/1��1�� = 3/1��1��)
         * �N�Τ������k
         * ���M�N�ΤѼƨӺ�϶�
         */
        calendar.setTime(issueEndDate);
        
        int dueYear = calendar.get(Calendar.YEAR);
        int dueMonth = calendar.get(Calendar.MONTH);
        int dueDate = calendar.get(Calendar.DATE);
        int dueMaximumDate = calendar.getActualMaximum(Calendar.DATE);
        
        //���o�٥����Z
        int payCapitalPeriod = 0;
        
        calendar.setTime(issue.getFirstRepayDate());
        
        int firstRepayYear = calendar.get(Calendar.YEAR);
        int firstRepayMonth = calendar.get(Calendar.MONTH);
        int firstRepayDate = calendar.get(Calendar.DATE);
        int firstRepayMaximumDate = calendar.getActualMaximum(Calendar.DATE);
        
        //�p�G��ƬۦP�γ��O�멳�N�Τ붡�Z�Ӻ�
        if (dueDate == firstRepayDate ||(firstRepayDate == firstRepayMaximumDate && dueDate == dueMaximumDate)) {
        	capitalCountBaseRule = "Month";
        	//���o���Z������
        	if (totalPayCapitalTimes > 1) {
        		payCapitalPeriod = ((dueYear - firstRepayYear) * 12 + (dueMonth - firstRepayMonth)) /(totalPayCapitalTimes - 1) ;
        	}else {
        		payCapitalPeriod = 0;
        	}
        }else {              
        	capitalCountBaseRule = "Day";
        	if(totalPayCapitalTimes > 1) {
                //���o�٥����Z
                int payCapitalDayBetween =  DateUtil.getDays(issue.getFirstRepayDate(),issueEndDate);
        		payCapitalPeriod = payCapitalDayBetween / (totalPayCapitalTimes - 1);
        	}else {
        		payCapitalPeriod = 0;
        	}
        }
        
        //���o�I�����Z
        int payInterestPeriod = 0;
        
        calendar.setTime(issue.getFirstInterestDate());
        
        firstRepayYear = calendar.get(Calendar.YEAR);
        firstRepayMonth = calendar.get(Calendar.MONTH);
        firstRepayDate = calendar.get(Calendar.DATE);     
        firstRepayMaximumDate = calendar.getActualMaximum(Calendar.DATE);

        if (dueDate == firstRepayDate ||(firstRepayDate == firstRepayMaximumDate && dueDate == dueMaximumDate)) {
        	interestCountbaseRule = "Month";
        	if(totalPayInterestTimes > 1) {
        		//�I�����Z����
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
        
//      ��l�Ƥ�����������٥����
        calendar.setTime(issue.getFirstRepayDate());
        
        //���o�Q�v�C��
        
        //�����o���ħQ�v��group_id
        RateManager rateManager = new RateManager();
        int rateGroupId = rateManager.getEffectRateGroupId(debt,session);
        
        
        //�����٥����
        //�qissueDate�}�l�A���٥����Z���סA���ͦU���٥�
        //�p�G���ͭp�e����p��}�l���or�j�󵲧�����N������
        
        Date originalPlanDate = null;
        Date planDate = issueStartDate;
        
        //�ֿn�٥����B
        BigDecimal accumCapitalAmount = new BigDecimal(0);
    	if("A".equals(debt.getIssue().getDebtType()))
    	{
    		Double capitalAmount = new PayManager().getCapitalByDept(debt.getId());//���o�w�v�I������
    		if(null != capitalAmount && capitalAmount > 0)
    			accumCapitalAmount = new BigDecimal(capitalAmount);
    	}
        rateManager.getEffectRateGroupId(debt,session);
        for(int periodNo = 1 ; periodNo <= totalPayCapitalTimes ; periodNo++){	
        	//�e�@�ӭp�e���
        	originalPlanDate = planDate;
        	
        	//���o�p�e���
        	planDate = getPlanDate(issue,issue.getFirstRepayDate(),capitalCountBaseRule,payCapitalPeriod,periodNo);
        	
        	//���o�Ѿl����
        	//�Ѿl���� = �o����B - �w�p�e�٥����B
        	BigDecimal remainAmount = debt.getIssueAmount().subtract(accumCapitalAmount);
        	remainAmount = remainAmount.setScale(4,BigDecimal.ROUND_UP);
        	
        	//���͸Ӵ��٥��p�e
        	DebtPlanDet plan = generatePlan("C",debt, planDate, remainAmount, periodNo ,totalPayCapitalTimes - periodNo + 1,originalPlanDate,capitalCountBaseRule,payCapitalPeriod,rateGroupId,session);
        	
       		resultList.add(plan);
        	
        	//��s�w�p�e�٥����B
        	accumCapitalAmount = accumCapitalAmount.add(plan.getCapitalAmount());
        }
        
        //���ͥI�����
        originalPlanDate = null;
        planDate = issueStartDate;   
        
        for(int periodNo = 1 ; periodNo <= totalPayInterestTimes ; periodNo++){
        	originalPlanDate = planDate;
           	planDate = getPlanDate(issue,issue.getFirstInterestDate(),interestCountbaseRule,payInterestPeriod,periodNo);  	
        	BigDecimal remainAmount = getRemainCapital(planDate,resultList);//���o�p�e����ɳѾl����
           	DebtPlanDet plan = generatePlan("I",debt, planDate, remainAmount, periodNo ,totalPayInterestTimes - periodNo + 1,originalPlanDate,interestCountbaseRule,payInterestPeriod,rateGroupId,session);
            resultList.add(plan);
        }
        
    	//�p�G�Ӵ��٥��p�e�b�}�l�ε��������N����
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
	 * �̶ǤJ���󲣥ͳ浧�p�e
	 * @param planType �p�e���� 'C' =>���� 'I' =>�Q�� 
	 * @param planDate �p�e���
	 * @param remainCapital �p�e����ɳѾl����
	 * @param remainPeriod  �Ѿl����
	 * @return
	 * @throws HibernateException
	 */
    private DebtPlanDet generatePlan(String planType,DebtMain debt, Date planDate, BigDecimal remainCapital,int currentPeriod, int remainPeriod,Date originalPlanDate,String countbaseRule,int payPeriod,int rateGroupId,Session session){
        //1�B���ͷs��PlanBean
        DebtPlanDet debtPlanDetDTO = (DebtPlanDet) createBean(debt);
        BigDecimal capitalAmount = null,interestAmount = null;
        Calendar calendar = Calendar.getInstance();

        if ("C".equals(planType))
	        //2�B�Ѿl�������H�Ѿl���ƨ��o�Ӵ��p�e�ٴڥ� �����B
        	//�źج�B��w��ζźج�A=>���� �B���s������(zeroInterestStatus = 'Y')�ɡA
        	//�٥����B����ڭɴڪ��B
        	
        	if(("B".equals(debt.getIssue().getDebtType()))||
        		 ("A".equals(debt.getIssue().getDebtType()) && 
       			 "Y".equals(debt.getIssue().getZeroInterestStatus()))) {
        		//���e�v�I����(����)
        		BigDecimal accumCapitalAmount = new BigDecimal(0);
        		Double paymentCapitalAmount = new PayManager().getCapitalByDept(debt.getId());//���o�w�v�I������
        		if(null != paymentCapitalAmount && paymentCapitalAmount > 0)
        			accumCapitalAmount = new BigDecimal(paymentCapitalAmount);
        		
        		capitalAmount = debt.getRealAmount().subtract(accumCapitalAmount);
        	}else {
        		capitalAmount = remainCapital.divide(new BigDecimal(remainPeriod),2);
        	}
        else
        	capitalAmount = new BigDecimal(0);
        
        //4�B�p��Ӵ��p�e�I�����B
        if ("I".equals(planType)) {
        	//�źج�B=>��w��ɡA�I�����B���t�����B
        	//�źج�A=>���� �B���s������(zeroInterestStatus = 'Y')�ɡA�I�����B���t�����B
        	if("B".equals(debt.getIssue().getDebtType())) {
        		interestAmount = debt.getDiversityAmount();
        	}else if("A".equals(debt.getIssue().getDebtType()) && 
        			 "Y".equals(debt.getIssue().getZeroInterestStatus())) {
        		interestAmount = debt.getDiversityAmount().multiply(new BigDecimal(-1));
        	}else{
	            calendar.setTime(planDate);
		        Date countDate = calendar.getTime();
		        
		        //���o�ϥΧQ�v�C��
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
 
        debtPlanDetDTO.setRepayDate(planDate);//�p�e���
        debtPlanDetDTO.setCapitalAmount(capitalAmount);//�p�e�ٴڪ��B
        debtPlanDetDTO.setInterestAmount(interestAmount);
        debtPlanDetDTO.setRateGroupId(rateGroupId);
        //���o�p�e�I�����B
        /**
         * �]�����ŵo��W�B���ŮɡA�|�w�����@�����I�Q���A���B���W�B�o��e���Q��(���O�bissue��)
         * ������o���Ĥ@���I���ɦ����A�]���n�p���l���I�Q��(interestAmount)�ι�ڭp�e�Q��(payableInterestAmount)
         */
        if ("I".equals(planType)&&"A".equals(debt.getIssue().getDebtType())
        		&&!debt.getIssue().getId().equals(debt.getIssue().getSourceIssueId())
        		&&getPeriod(debt.getIssue().getIssueDate(),debt.getIssue().getFirstInterestDate(),debt.getIssue().getFinishDate(),countbaseRule,payPeriod) == currentPeriod ){
        	BigDecimal payableInterestAmount = debt.getIssue().getPayableInterestAmount();        	
        	if (payableInterestAmount == null)
        		payableInterestAmount = new BigDecimal(0);
        	 	
        	BigDecimal originInterestAmount = interestAmount.subtract(payableInterestAmount);
        	//~~~~~~~~~~~~~~~20101028�קאּ���I�Q���Ȧb�Ĥ@�ӹw��O
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
    			debtPlanDetDTO.setOriginInterestAmount(interestAmount);//�p�e��l���I�����B
        	//~~~~~~~~~~~~~~~~~~~~~~~
        }else {
            debtPlanDetDTO.setOriginInterestAmount(interestAmount);//�p�e��l���I�����B
        }
 
        if ("C".equals(planType)) {
        	if ("A".equals(debt.getIssue().getDebtType())||"B".equals(debt.getIssue().getDebtType())||"C".equals(debt.getIssue().getDebtType())){
        		BigDecimal chargeRate = debt.getIssue().getChargeRate();
        		if (chargeRate == null)
        			chargeRate = new BigDecimal(0);
        		
        		BigDecimal chargeAmount = chargeRate.multiply(capitalAmount.add(interestAmount));//����O
        		debtPlanDetDTO.setChargeAmount(chargeAmount);//�p�e����O���B
        	}
        	debtPlanDetDTO.setCapitalSerial(currentPeriod);
            debtPlanDetDTO.setInterestSerial(0);
        }else if("I".equals(planType)) {
        	debtPlanDetDTO.setCapitalSerial(0);
        	debtPlanDetDTO.setInterestSerial(currentPeriod);
    	}
        //�w�]��
        debtPlanDetDTO.setUserid("Batch");
        debtPlanDetDTO.setModDate(new Date());
        debtPlanDetDTO.setDeleteMark("N");
		return debtPlanDetDTO;
	}

	/**
	 * �T�{�浧�p�e��T
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
	 * �T�{�浧�p�e��T
	 * @param plan
	 * @throws HibernateException
	 */
    public void confirm(DebtPlanDet pDto,Session session) {
    
    	DebtPlanDet tDebtPlanDetDto = (DebtPlanDet)pDto;

    	//�ˮ֬O�_����s
    	if (!(pDto.getId() == null)){
    		tDebtPlanDetDto = (DebtPlanDet) session.get(DebtPlanDet.class, pDto.getId());
    	}
    	
        //1�B�ˮ�DTO�O�_����
//        if(!checkBean(tDebtPlanDetDto)) return;
    	if (!checkBean(tDebtPlanDetDto))
    	{
    		System.out.println("@@@@@"+tDebtPlanDetDto.getId());
    		return;
    	} else {
    		System.out.println(tDebtPlanDetDto.getId());
    	}
        //2�B�p�G�S�����h�s�W�p�eDAO
        
        //3�B�x�sDTO
        tDebtPlanDetDto.setCapitalAmount(adjustBigDecimal(tDebtPlanDetDto.getCapitalAmount(), 4));
        tDebtPlanDetDto.setChargeAmount(adjustBigDecimal(tDebtPlanDetDto.getChargeAmount(), 4));
//        tDebtPlanDetDto.setInterestAmount(adjustBigDecimal(tDebtPlanDetDto.getInterestAmount(), 4));
        tDebtPlanDetDto.setInterestAmount(adjustBigDecimal(pDto.getInterestAmount(), 4));
        if (tDebtPlanDetDto.getDeleteMark() == null)
        	tDebtPlanDetDto.setDeleteMark("N");
 
        //�p�G�s�W��
        //�s�b�P�@�ɴڪ��P�@�٥��O&�P�@�I�����O���p�e�A�h��p�e��deleteMark�]��'Y'
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

        //�p�G�o��O�Ų��Φ��A�n�h�[insert ��DebtPlanTicketDet
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
	 * �ˮ֭p�e��ƬO�_���T
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
        //�ˬd�p�e�ٴڪ��B�B�p�e�I�����B�B�p�e����O���B�O�_�Ҥj�󵥩�s
		return (tDebtPlanDetDto.getCapitalAmount().compareTo(tZero) != -1) && (tDebtPlanDetDto.getInterestAmount().compareTo(tZero) != -1) && (tDebtPlanDetDto.getChargeAmount().compareTo(tZero) != -1);
	}

	/**
	 * ���o�Ҧ����p�e��T
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
	 * ���o�ӵ��ɴکҦ����p�e��T
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
	 * ���o�ӵ��o��Ҧ����p�e��T
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
	 * ���o�浧�p�e��T
	 * @param planId
	 * @return
	 * @throws HibernateException
	 */
    public DebtPlanDet getBean(int planId) {
		return getBean(planId,planDao.getSession());
	}
    
	/**
	 * ���o�浧�p�e��T
	 * @param planId
	 * @return
	 * @throws HibernateException
	 */
    public DebtPlanDet getBean(int planId,Session session) {
		return planDao.get(new Integer(planId),session);
	}


    /**
     * �̵o��D��Ȩ����Ҧ��p�e
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
        	System.out.println("�R��" + tDebtPlanDet.getId());
        	planDao.delete(tDebtPlanDet.getId(),tSession);
        }
        tSession.close();
    }
    
    /**
     * �̵o��D��Ȩ����Ҧ��p�e
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
	 * ���oCombinText List
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
	
	//�P�_�O�_�i�ק���
	private void isModified(DebtPlanDet plan,Session session) throws HibernateException{
		//�p�G���ӭp�e���٥���ƮɡA���i�H���ʸӭp�e
       	StringBuffer queryString = new StringBuffer("from PaymentMain p ");
    	queryString.append(" where p.plan = :plan");
    	Query query = session.createQuery(queryString.toString());
    	query.setParameter("plan",plan);
    	List paymentList = query.list();
    	
    	//�O�_�����Ŵ��e�v�I 20100302 Chris Wu 
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
    		throw new HibernateException("�w���I�ڸ�ƮɡA���i�ק�p�e���!");
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
			throw new Exception("�L�p�e���");
		for(Iterator iterator = planList.iterator();iterator.hasNext();){
			confirmInterst((DebtPlanDet)iterator.next(),session);		
		}
		
	}
    
    public void confirmInterst(DebtPlanDet pDto,Session session) {
        
    	DebtPlanDet tDebtPlanDetDto = (DebtPlanDet)pDto;

    	//�ˮ֬O�_����s
    	if (!(pDto.getId() == null)){
    		tDebtPlanDetDto = (DebtPlanDet) session.get(DebtPlanDet.class, pDto.getId());
    	}
    	
        //1�B�ˮ�DTO�O�_����
        if(!checkBean(tDebtPlanDetDto)) return;
        //2�B�p�G�S�����h�s�W�p�eDAO
        
        //3�B�x�sDTO
        tDebtPlanDetDto.setCapitalAmount(adjustBigDecimal(tDebtPlanDetDto.getCapitalAmount(), 4));
        tDebtPlanDetDto.setChargeAmount(adjustBigDecimal(tDebtPlanDetDto.getChargeAmount(), 4));
        tDebtPlanDetDto.setInterestAmount(adjustBigDecimal(pDto.getInterestAmount(), 4));
        if (tDebtPlanDetDto.getDeleteMark() == null)
        	tDebtPlanDetDto.setDeleteMark("N");
       
        session.saveOrUpdate(tDebtPlanDetDto);

	}
}
 
