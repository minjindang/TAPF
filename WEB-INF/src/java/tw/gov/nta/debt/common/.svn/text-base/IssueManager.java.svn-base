package tw.gov.nta.debt.common;

import gov.dnt.tame.common.HibernateSessionRequestFilter;
import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ListToolManager;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.debt.ContractBankMain;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.ContractBankMainDAO;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class IssueManager extends IManager {
	
	private IssueMainDAO dao;

	public IssueManager() {
		dao = new IssueMainDAO();
	}

	/**
	 * 新增發行DTO
	 * @param pDebtType:債種
	 * @return
	 */
	public IssueMain createBean(String pDebtType) {
		IssueMain tIssueMainDto = new IssueMain();
		tIssueMainDto.setDebtType(pDebtType);
	    return tIssueMainDto;
	}
	
	/**
	 * 提前償前償還本金
	 * @param aIssueMain
	 * @throws Exception
	 */
	public void advancePayment(DebtMain aDebtMain, BigDecimal advanceAmount, Date advanceDate) throws Exception{
		DebtMain aOldDebtMain = new DebtManager().getBean(aDebtMain.getId());//取得原debtMain資料
		Double capitalAmount = new PayManager().getCapitalByDept(aDebtMain.getId());//取得已償付之本金
		BigDecimal issueAmount = aOldDebtMain.getIssueAmount();//原預算別下發行本金
		BigDecimal residualAmount = issueAmount.divide(new BigDecimal(capitalAmount),4,BigDecimal.ROUND_HALF_UP).divide(advanceAmount,4,BigDecimal.ROUND_HALF_UP);
		if(residualAmount.compareTo(new BigDecimal(0)) < 0)
			throw new Exception("residualAmount < 0");//提前償付的後的本金不可以小於0
		
		PlanManager tPlanManager = new PlanManager();
		List planList = tPlanManager.getAllPlanListByDebtNotDelete(aOldDebtMain);//取得該DebtMain下所有Plan(deleteMark = N)
		for(Iterator itPlan=planList.iterator();itPlan.hasNext();){
			DebtPlanDet planDto = (DebtPlanDet)itPlan.next();
			BigDecimal paymentData = new PayManager().getInterestByPlan(planDto.getId());
			if(null == paymentData || paymentData.compareTo(new BigDecimal(0)) == 0 || planDto.getCapitalAmount().compareTo(new BigDecimal(0)) > 0)
//			if(null == paymentData || paymentData.compareTo(new BigDecimal(0)) == 0)
				tPlanManager.delete(planDto);//刪除Plan
		}
		aOldDebtMain.getIssue().setIssueDate(aOldDebtMain.getIssue().getIssueDate());
		aOldDebtMain.getIssue().setFinishDate(aOldDebtMain.getIssue().getFinishDate());
		tPlanManager.buildPlan(aOldDebtMain,aOldDebtMain.getIssue().getIssueDate(),aOldDebtMain.getIssue().getFinishDate());	//重新產生Plan
	}
	
	/**
	 * 更新IssueMain,當發行日期 & 利率有異動,則底下之發行金額DebtMain需重新產生Plan,若有payment資料則不得更新
	 * @param IssueMain
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void checkAndUpdate(IssueMain pIssueMain) throws Exception{
		Session tSession = dao.getSession(); 
		IssueMain tOldIssueMain = getBean(pIssueMain.getId());
		Calendar oldCalendar =  Calendar.getInstance();
		Calendar newCalendar =  Calendar.getInstance();
		oldCalendar.setTime(tOldIssueMain.getIssueDate());
		newCalendar.setTime(pIssueMain.getIssueDate());
		
		if(! oldCalendar.equals(newCalendar)|| 
				!tOldIssueMain.getIssueInterval().equals(pIssueMain.getIssueInterval()) ||
				//20090320增加"票面利率"更動時，可以更新資料
				!tOldIssueMain.getAverageRate().equals(pIssueMain.getAverageRate())){	//判斷發行日期與利率是否有更新
			List tIssueMinaList = new LinkedList();
			//若issueId == sourceIssueId 則此issue為原始公債,需同時更新增額公債sourceIssueId == issueId之增額公債之debt
			if(pIssueMain.getId().equals(pIssueMain.getSourceIssueId())){	
				Session session = new IssueMainDAO().getSession();
				String hql = " from IssueMain where id != "+pIssueMain.getId()+" and sourceIssueId =" +pIssueMain.getId();
				Query query = session.createQuery(hql);
				tIssueMinaList.addAll(query.list()); 
			}
			tIssueMinaList.add(pIssueMain);
			//確認此issueMain底下沒有payment若有則不處理其他動作並且不更新issueMain
			for(Iterator itIssueMain = tIssueMinaList.iterator();itIssueMain.hasNext();){
				IssueMain tempIssueMain = (IssueMain)itIssueMain.next();
				if(!isModify(tempIssueMain))
					throw new Exception("have Payment");
			}
			confirm(pIssueMain);
			for(Iterator itIssueMain = tIssueMinaList.iterator();itIssueMain.hasNext();){
				IssueMain tIssueMain = (IssueMain)itIssueMain.next();
				List debtList = new DebtManager().getBeanByIssue(tIssueMain.getId());//取得該issueMain底下所有的DebtMain
				for(Iterator it = debtList.iterator();it.hasNext();){
					DebtMain tDebtMain = (DebtMain)it.next();
					List rateList = new RateManager().getEffectiveRate(tDebtMain.getId());//取得該DebtMain下所有Rate
					for(Iterator itRate = rateList.iterator();itRate.hasNext();){
						DebtRateDet rateDto = (DebtRateDet)itRate.next();//將原先Rate.DeleteMark 設成Y
						rateDto.setDeleteMark("Y");
						new RateManager().confirm(rateDto) ;
					}
					RateManager tRateManager = new RateManager();
					DebtRateDet tDebtRateDet = tRateManager.createBean(tDebtMain.getId().intValue());
					tDebtRateDet.setEffectiveDate(tIssueMain.getIssueDate());
					tDebtRateDet.setSuspendDate(tIssueMain.getFinishDate());
					tDebtRateDet.setDebtRate(tIssueMain.getAverageRate());
					tDebtRateDet.setDeleteMark("N");
					tRateManager.confirm(tDebtRateDet);//重新產生Rate
					PlanManager tPlanManager = new PlanManager();
					List planList = tPlanManager.getAllPlanListByDebt(tDebtMain);//取得該DebtMain下所有Plan
					for(Iterator itPlan=planList.iterator();itPlan.hasNext();){
						DebtPlanDet planDto = (DebtPlanDet)itPlan.next();
						tPlanManager.delete(planDto);//刪除Plan
					}
					tDebtMain.getIssue().setIssueDate(pIssueMain.getIssueDate());
					tDebtMain.getIssue().setFinishDate(pIssueMain.getFinishDate());
					tPlanManager.buildPlan(tDebtMain,pIssueMain.getIssueDate(),pIssueMain.getFinishDate());	//重新產生Plan
				}
			}
		}
		else{
			confirm(pIssueMain);
		}
	}
	/**
	 * 確認發行
	 */
	public void confirm(Object pDto) throws Exception {
		IssueMain pIssueMainDto = (IssueMain) pDto;
		if(!checkBean(pIssueMainDto))
			throw new Exception("checkBean false!");
		pIssueMainDto.setDebtShortName(pIssueMainDto.getDebtName().replace("中央政府", ""));
		pIssueMainDto.setChargeRate(adjustBigDecimal(pIssueMainDto.getChargeRate(), 10));
		//pIssueMainDto.setChargeRate(new BigDecimal(0.0009));
		pIssueMainDto.setCapitalAmount(adjustBigDecimal(pIssueMainDto.getCapitalAmount(), 4));
		pIssueMainDto.setInterestAmount(adjustBigDecimal(pIssueMainDto.getInterestAmount(), 4));
		pIssueMainDto.setSellAmount(adjustBigDecimal(pIssueMainDto.getSellAmount(), 4));
		pIssueMainDto.setIssueAmount(adjustBigDecimal(pIssueMainDto.getIssueAmount(), 4));
		pIssueMainDto.setAverageRate(adjustBigDecimal(pIssueMainDto.getAverageRate(), 10));
		pIssueMainDto.setExpectAmount(adjustBigDecimal(pIssueMainDto.getExpectAmount(), 4));
		pIssueMainDto.setModDate(new Date());
		if( pIssueMainDto.getZeroInterestStatus() == null ||pIssueMainDto.getZeroInterestStatus().equals(null) || pIssueMainDto.getZeroInterestStatus().equals(""))
			pIssueMainDto.setZeroInterestStatus("N");
		dao.saveOrUpdate(pIssueMainDto);
		if (pIssueMainDto.getSourceIssueId() == null) {
			pIssueMainDto.setSourceIssueId(pIssueMainDto.getId());
			dao.saveOrUpdate(pIssueMainDto);
		}
	}
	
	private BigDecimal adjustBigDecimal(BigDecimal pAmount, int pScale)
	{
		return pAmount==null?null:pAmount.setScale(pScale, 5);
	}
	
	/**
	 * 取得發行的Dto
	 */
	public IssueMain getBean(int pId){
		return getBean(pId,dao.getSession());
	}

	/**
	 * 取得發行的Dto
	 */
	public IssueMain getBean(int pId,Session session){
		return dao.get(new Integer(pId),session);
	}	
	/**
	 * 取消發行
	 * @param pIssueId
	 * @throws Exception
	 */
	public void cancel(int pIssueId) throws Exception {
		IssueMain tIssueMain = dao.get(new Integer(pIssueId));
		if(!isModify(tIssueMain))
			throw new Exception();
		//刪除debt
		DebtMain tDebtMainDto = null;
		List tList = new DebtManager().getBeanByIssue(pIssueId);
		Iterator tIterator = null;
		if(tList != null && !tList.isEmpty() ){
			tIterator = tList.iterator();
			RateManager tRateManager = new RateManager();
			DebtManager tDebtManager = new DebtManager();
			
			//刪除Plan
			new PlanManager().cancelByIssue(pIssueId);
			
			while(tIterator.hasNext()){
				tDebtMainDto = (DebtMain) tIterator.next();
//				if(tIssueMain.getDebtType().equals("D")){
//					List contractBankList = new ContractBankManager().Search(new String[]{"contractYear","bank.id"},new Object[]{tIssueMain.getAccountYear(),tDebtMainDto.getBank().getId()},new String[]{"=","="},new String[]{""});
//					ContractBankMain contractBankMain = (ContractBankMain) contractBankList.get(0);
//					contractBankMain.setBorrowAmount(contractBankMain.getBorrowAmount().subtract(tDebtMainDto.getIssueAmount()));
//					new ContractBankMainDAO().saveOrUpdate(contractBankMain);
//				}
				tRateManager.deleteByDebtId(tDebtMainDto.getId());
				tDebtManager.cancel(tDebtMainDto.getId().intValue());
			}
		}
		TicketManager tTicketManager = new TicketManager();
		tList = tTicketManager.getBeanByIssue(tIssueMain.getId().intValue());
		if(tList != null && !tList.isEmpty() ){
			for(tIterator = tList.iterator(); tIterator.hasNext(); ){
				tTicketManager.cancel(((IssueTicketDet)tIterator.next()).getId().intValue());
			}
		}
		dao.delete(tIssueMain.getId());
	}
	 
	/**
	 * check發行的DTO
	 * @param bean
	 * @return
	 */
	protected boolean checkBean(Object pBean) {
		return true;
	}
	
	/**
	 * 檢核年度期次是否重複
	 * @param pIssueMainDto
	 * @return boolean
	 * 20060706 Andrew Sung
	 */
	public boolean checkSerialNo(IssueMain pIssueMainDto) {
		StringBuffer hqlStr = new StringBuffer("select id from IssueMain ");
        if(!"".equals(pIssueMainDto.getDebtType()))
        	hqlStr.append( " where debtType='" +pIssueMainDto.getDebtType()+ "' ");
        if(!"".equals(pIssueMainDto.getAccountYear()) && pIssueMainDto.getAccountYear() != null)
        	hqlStr.append( " and accountYear='" +pIssueMainDto.getAccountYear()+ "' ");
        if(!"".equals(pIssueMainDto.getSerialNo()) && pIssueMainDto.getSerialNo() != null)
        	hqlStr.append( " and serialNo='" +pIssueMainDto.getSerialNo()+ "' ");
        Session session = new IssueMainDAO().getSession();
		Query query = session.createQuery(hqlStr.toString());
		List collection = query.list();
		return collection.size()==0 || collection == null;
	}
	/**
	 * 確認是否可修改
	 * @param pIssueMainDto
	 * @return
	 */
	public boolean isModify(IssueMain pIssueMainDto) {

		Session tSession = new PaymentMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(PaymentMain.class);
		criteria.add(Expression.eq("issueId", pIssueMainDto.getId()));
		List tList = criteria.list();
		tSession.close();
		return tList == null || tList.size() == 0;
	}
	
	/**
	 * 查詢發行資料
	 * @param pCols
	 * @param pValues
	 * @param pConds
	 * @param pOrderby
	 * @return
	 */
	public List Search(String[] pCols, Object[] pValues, String[] pConds, String[] pOrderby){
		Session tSession = dao.getSession();
		Criteria criteria = tSession.createCriteria(IssueMain.class);
		if(pCols != null && pValues != null && pConds != null){
			for(int i = 0 ; i < pCols.length ; i++){
				if(pCols[i] == null || pValues[i] == null || pConds[i] == null || "".equals(pCols[i]) || "".equals(pValues[i]) || "".equals(pConds[i]))
					continue;
				if(pConds[i].equals("="))
					criteria.add(Expression.eq(pCols[i], pValues[i]));
				else if(pConds[i].equals(">"))
					criteria.add(Expression.gt(pCols[i], pValues[i]));
				else if(pConds[i].equals("<"))
					criteria.add(Expression.lt(pCols[i], pValues[i]));
				else if(pConds[i].equals(">="))
					criteria.add(Expression.ge(pCols[i], pValues[i]));
				else if(pConds[i].equals("<="))
					criteria.add(Expression.le(pCols[i], pValues[i]));
				else if(pConds[i].equals("like"))
					criteria.add(Expression.like(pCols[i], pValues[i]));
				else if(pConds[i].equals("in"))
					criteria.add(Expression.in(pCols[i], (Object [])pValues[i]));
			}
		}
		if(pOrderby != null){
			for(int i = 0 ; i < pOrderby.length ; i++){
				if(pOrderby[i] == null || "".equals(pOrderby[i])) continue;
				criteria.addOrder(Order.desc(pOrderby[i]));
			}
		}
		List tResultList = criteria.list();
		tSession.close();
		return tResultList;
	}
	@SuppressWarnings("deprecation")
	public BigDecimal getRepayInterestAmount(BigDecimal pIssueAmount , BigDecimal pAverageRate , Date pStartDate , Date pEndDate){
		BigDecimal daysByYear = new BigDecimal("365");
		BigDecimal diffOriginDay = new BigDecimal(0);
		BigDecimal repayInterestAmount = new BigDecimal(0);
		Date pEndDateAfter = new Date(pStartDate.getYear()+1,pStartDate.getMonth() ,pStartDate.getDay()); 
		
		/*if((pIssueAmount != null && pIssueAmount.compareTo(new BigDecimal(0))!=0 )&& pAverageRate != null && pStartDate!= null && pEndDate!=null){*/
		
			if((pIssueAmount != null)&& pAverageRate != null && pStartDate!= null && pEndDate!=null){
			 diffOriginDay = new BigDecimal(DateUtil.getDays( pStartDate, pEndDate ).toString());
			 
			 //計算閏年
			 int leapYear = Integer.parseInt(String.valueOf(pStartDate).substring(0,4));
			 int leapMonth = pStartDate.getMonth()+1;
//			 int leapDay = pStartDate.getDay();
			 boolean leapYearYN = false;
			 if(leapYear%4 == 0){
				 if(leapYear%100 == 0 && leapYear%400 == 0 && (leapMonth == 1 || leapMonth == 2)){
					 leapYearYN = true;
				 }else if(leapYear%100 != 0 && (leapMonth == 1 || leapMonth == 2)){
					 leapYearYN = true;
				 }
			 }
			 
			 if(leapYearYN){
				 daysByYear = new BigDecimal("366");
			 }else{
				 daysByYear = new BigDecimal("365");
			 }
			 
//			 for(int i = pStartDate.getYear();i<=pEndDateAfter.getYear();i++){
//				 if((new GregorianCalendar().isLeapYear(i))){
//					 if(pEndDateAfter.getYear()> i ){
//						 //0970616 modify by mulder
////						 daysByYear = new BigDecimal("366");
//						 daysByYear = new BigDecimal("365");
//						 break;
//					 }else if(pEndDateAfter.getYear()== i && pEndDateAfter.getMonth() > 1){
//						 daysByYear = new BigDecimal("366");
//						 break;
//					 }else if(pEndDateAfter.getYear()== i && pEndDateAfter.getMonth() == 1 && pEndDateAfter.getDate()== 29){
//						 daysByYear = new BigDecimal("366");
//						 break;
//					 }
//				 }
//			 }
			repayInterestAmount = (pIssueAmount.multiply(pAverageRate).multiply(diffOriginDay).divide(daysByYear,5).divide(new BigDecimal(100))).setScale(0,BigDecimal.ROUND_HALF_UP);
			return repayInterestAmount;
		}
		else
			return new BigDecimal(0);
	}

	/**
	 * 取得CombinText List
	 * @param null
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getDebtNameLabelList() throws HibernateException
	{
        return getDebtNameLabelList("");
	}

	/**
	 * 取得CombinText List
	 * @param pDebtType
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getDebtNameLabelList(String pDebtType) throws HibernateException
	{
        StringBuffer hqlStr = new StringBuffer("select id, debtName from IssueMain ");
        if(!"".equals(pDebtType))
        	hqlStr.append( " where debtType='" +pDebtType+ "' ");
        hqlStr.append( " order by accountYear desc, serialNo desc " );
        return ListToolManager.getList(hqlStr.toString());
	}
	
	/**
	 * 取得CombinText List
	 * @param pDebtType
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getDebtNameRepayLabelList(String pDebtType) throws HibernateException
	{
        StringBuffer hqlStr = new StringBuffer("select A.id, A.debtName from IssueMain A, PaymentMain B where A.id=B.issueId ");
        if(!"".equals(pDebtType))
        	hqlStr.append( " and A.debtType='" +pDebtType+ "' ");
        hqlStr.append( " and B.repayDate < B.planRepayDate " );
        hqlStr.append( " group by A.id, A.debtName " );
        hqlStr.append( " order by A.id " );
        return ListToolManager.getList(hqlStr.toString());
	}

	/**
	 * 取得CombinText List
	 * @param null
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getIssueKind() throws HibernateException
	{
        return ListToolManager.getList("select issueKind, issueKind from IssueMain ");
	}
	/**
	 * 取得CombinText List
	 * @param null
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getSellStatus() throws HibernateException
	{
        return ListToolManager.getList("select sellStatus, sellStatus from IssueMain ");
	}
	
	/**
	 * 以債種查出發行期別取得CombinText List
	 * @param null
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getIssueSerial(String pType) throws HibernateException
	{
		StringBuffer hqlStr = new StringBuffer("select id, issueSerial from IssueMain ");
        if(!"".equals(pType))
        	hqlStr.append( " where debtType='" +pType+ "' ");
        hqlStr.append( " order by issueSerial desc");
        return ListToolManager.getList(hqlStr.toString());
	}
	
	public static List<LabelValueBean> getIssueSerialByBudget(String pType,Integer budgetCode){
		StringBuffer hqlStr = new StringBuffer("select id, issueSerial from IssueMain ");
        hqlStr.append( " where debtType='" +pType+ "' ");
        hqlStr.append( "   and budgetCode=" +budgetCode+ " ");
        hqlStr.append( "   order by issueSerial asc ");
        return ListToolManager.getList(hqlStr.toString());
	}

	public static List<LabelValueBean> getIssueSerial2(String pType)
	{
		StringBuffer hqlStr = new StringBuffer("select issueSerial, issueSerial from IssueMain ");
        hqlStr.append( " where debtType='" +pType+ "' ");
        hqlStr.append( " order by issueSerial asc ");
        return ListToolManager.getList(hqlStr.toString());
	}
	public static List<LabelValueBean> getDebtName(String pType)
	{
		StringBuffer hqlStr = new StringBuffer("select debtName, debtName from IssueMain ");
        hqlStr.append( " where debtType='" +pType+ "' ");
        return ListToolManager.getList(hqlStr.toString());
	}
	public static List<LabelValueBean> getIssueSerial(String pType, String pBudgetCode , String pLow) throws HibernateException
	{
		StringBuffer hqlStr = new StringBuffer("select id, issueSerial from IssueMain ");
        if(!"".equals(pType))
        	hqlStr.append( " where debtType='" +pType+ "' ");
        if(!"".equals(pBudgetCode) && !"".equals(pLow))
        	hqlStr.append(" and budgetCode "+pLow+ "(select id from BudgetRef where budgetType = '"+pBudgetCode+"' )");
        hqlStr.append(" order by accountYear desc , serialNo desc ");
        System.out.println(hqlStr.toString());
        return ListToolManager.getList(hqlStr.toString());
	}
	
	/**
	 * 取得增額公債代號
	 * @param IssueMain
	 * @return String
	 * @throws HibernateException
	 */
	public String getNextIssueSerial(IssueMain issueMain) throws HibernateException
	{
		String issueSerial = issueMain.getIssueSerial();
		char[] charArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Session session = dao.getSession();
        //Query query = session.createQuery( " from IssueMain issueMain where issueMain.issueSerial like '"+issueSerial+"%'" );
        //取得該原始公債之增額公債中最大的增額公債期別
        Query query = session.createQuery( "select max(issueMain.issueSerial) from IssueMain issueMain where issueMain.sourceIssueId = "+issueMain.getId());
        List list = query.list();
        System.out.println(list);
        String addIssueSerial = null;
        if( list!=null && !list.isEmpty()&& list.size()>0 ){
        	String maxIssueSerial = (String)list.get(0);
        	if((int)maxIssueSerial.charAt(maxIssueSerial.length()-1) >= 65 && (int)maxIssueSerial.charAt(maxIssueSerial.length()-1) <= 90)
        		addIssueSerial = issueSerial + charArray[((int)maxIssueSerial.charAt(maxIssueSerial.length()-1))-64];
        	else
        		addIssueSerial = issueSerial + charArray[0];
        }
        else{
        	addIssueSerial = issueSerial + charArray[0];
        }
        session.close();
    	return addIssueSerial;
	}

	public IssueMainDAO getDao() {
		return dao;
	}

	public void setDao(IssueMainDAO dao) {
		this.dao = dao;
	}
}
 
