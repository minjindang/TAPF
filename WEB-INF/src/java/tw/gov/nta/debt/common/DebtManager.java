package tw.gov.nta.debt.common;

import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class DebtManager extends IManager {
	private DebtMainDAO dao = new DebtMainDAO();
	/**
	 * 新增借款Dto
	 * @param pIssueId
	 * @return
	 */
	public DebtMain createBean(int pIssueId) {
		DebtMain tDebtMainDto = new DebtMain();
		tDebtMainDto.setIssue(new IssueManager().getBean(pIssueId));		
		return tDebtMainDto;
	}
	 
	/**
	 * 設定借款Dto之相關欄位資料，目前只回應true
	 * @param bean
	 * @return
	 */
	public boolean checkBean(Object pDeptMain) {
		DebtMain tDebtMain = (DebtMain)pDeptMain;
		Session tSession = new DebtMainDAO().getSession();
		Criteria tCriteria = tSession.createCriteria(IssueDet.class);
		tCriteria.add(Expression.eq("issueId", tDebtMain.getIssue().getId()));
		if( 1 == tDebtMain.getIssueAmount().compareTo(new BigDecimal(0)))
		{	
			tCriteria.add(Expression.eq("budgetYear", tDebtMain.getBudgetYear()));
			tCriteria.add(Expression.eq("debtCode", tDebtMain.getDebtCode()));
			tCriteria.add(Expression.eq("budgetCode", tDebtMain.getBudgetCode()));
		}	
		List list = tCriteria.list();
		tSession.close();
		if(list.size() == 0)
			return false;
		else
			return true;
	}
	 
	/**
	 * 取消借款
	 * @param pDebtId
	 */
	public void cancel(int pDebtId) throws Exception{
		if(!isModify(pDebtId))
			throw new Exception("具還本付息資料");
		DebtMain debtMain = new DebtManager().getBean(pDebtId);
		List planList = new PlanManager().getAllPlanListByDebt(debtMain);
		for(Iterator it = planList.iterator();it.hasNext();){
			DebtPlanDet planDet = (DebtPlanDet)it.next();
			new PlanManager().delete(planDet);
		}
		new DebtMainDAO().delete(new Integer(pDebtId));
	}
	 
	/**
	 * 取得借款資料
	 * @param pId
	 * @return
	 */
	public DebtMain getBean(int pId) {
		return new DebtMainDAO().get(new Integer(pId));
	}
	 
	/**
	 * 查詢是否該發行已做還本付息
	 * @param pId
	 * @return:若已做還本付息，則回傳false
	 */
	public boolean isModify(int pId) {
		Session session = new PaymentMainDAO().getSession();
		Criteria criteria = session.createCriteria(PaymentMain.class);
		criteria.add(Expression.eq("debtId", pId));
		List tResult = criteria.list();
		session.close();
		return tResult == null || tResult.size()==0;
	}
	 
	/**
	 * 取得借款已付本金金額
	 * @param pQueryDate
	 * @return
	 */
	public BigDecimal getPaidAmount(int debtId,Date pQueryDate) {
		Session session = new PaymentMainDAO().getSession();
		return getPaidAmount(debtId,pQueryDate,session);
	}

	/**
	 * 取得借款已付本金金額
	 * @param pQueryDate
	 * @return
	 */
	public BigDecimal getPaidAmount(int debtId,Date pQueryDate,Session session) {
		StringBuffer queryString = new StringBuffer();
		queryString.append("select isnull(sum(p.capitalAmount),0) from PaymentMain p ");
		queryString.append(" where p.repayDate < :repayDate ");
		queryString.append("   and p.debtId = :debtId");
		
		Query query = session.createQuery(queryString.toString());
		query.setDate("repayDate",pQueryDate);
		query.setInteger("debtId",debtId);
		List result = query.list();
		BigDecimal totalCapitalAmount = null;
		if(result.size() > 0){
			totalCapitalAmount = (BigDecimal)result.get(0);
		}else {
			totalCapitalAmount = new BigDecimal(0);
		}
		return totalCapitalAmount;
	}	
	
	/**
	 * 取得借款未付本金金額
	 * @param pDebtId
	 * @param pQueryDate
	 * @return
	 */
	public BigDecimal getRemainAmount(int pDebtId, Date pQueryDate) {
		Session session = DebtMainDAO.getInstance().getSession();
		return getRemainAmount(pDebtId,pQueryDate,session);
		

	}

	/**
	 * 取得借款未付本金金額
	 * @param pDebtId
	 * @param pQueryDate
	 * @return
	 */
	public BigDecimal getRemainAmount(int debtId, Date pQueryDate,Session session) {
		DebtMain debt = (DebtMain)session.get(DebtMain.class,debtId);
		BigDecimal issueAmount = debt.getIssueAmount();
		return issueAmount.subtract(getPaidAmount(debtId,pQueryDate,session));
	}
	
	 
	/**
	 * 依發行id取得借款之Dto
	 * @param pIssueId:發行主鍵值
	 * @return:所有查詢到的dto
	 */
	public List getBeanByIssue(int pIssueId)
	{
		Session tSession = new DebtMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(DebtMain.class);
		criteria.add(Expression.eq("issue.id", pIssueId));
		criteria.addOrder(Order.asc("compareRate"));
		List tResult = criteria.list();
		tSession.close();
		return tResult;
	}
	 
	/**
	 * 依發行id取得借款總額
	 * @param pIssueId
	 * @return
	 */
	public BigDecimal getAmountByIssue(int pIssueId){
		BigDecimal tAmount = new BigDecimal(0);
		List tList = getBeanByIssue(pIssueId);
		DebtMain tDebtMainDto = null;
		if(tList != null && tList.size() != 0){
			Iterator tIterator = tList.iterator();
			while(tIterator.hasNext()){
				tDebtMainDto = (DebtMain) tIterator.next();
				if("Y".equalsIgnoreCase(tDebtMainDto.getAccrue()))
					tAmount = tAmount.add(tDebtMainDto.getIssueAmount());
			}
		}		
		return tAmount;
	}

	/**
	 * 確定借款
	 * @throws Exception 
	 */
	public void confirm(Object pObject) throws Exception {
		DebtMain pDebtMainDto = (DebtMain) pObject;
        //1、檢核DTO是否有錯
		if(pDebtMainDto.getIssue().getDebtType().equals("C"))
			if(!checkBean(pDebtMainDto)) throw new Exception();
        recountBean(pDebtMainDto);
        //2、如果沒有錯則新增計畫DAO
        DebtMainDAO tDebtMainDAO = new DebtMainDAO();
        //3、儲存DTO
        tDebtMainDAO.saveOrUpdate(pDebtMainDto);

//        System.out.println(pDebtMainDto);
	}
	public void upDate(DebtMain debtMain) throws Exception {
		if(!isModify(debtMain.getId()))
			throw new Exception("具還本付息資料");
		DebtMain oldDebtMain = getBean(debtMain.getId());
		if(debtMain.getIssueAmount().setScale(0,BigDecimal.ROUND_HALF_UP).equals(oldDebtMain.getIssueAmount().setScale(0,BigDecimal.ROUND_HALF_UP))){
			confirm(debtMain);
		}
		else{
			confirm(debtMain);
			List planList = new PlanManager().getAllPlanListByDebt(debtMain);
			for(Iterator it = planList.iterator();it.hasNext();){
				DebtPlanDet planDet = (DebtPlanDet)it.next();
				new PlanManager().delete(planDet);
			}
			PlanManager tPlanManager = new PlanManager();
			tPlanManager.buildPlan(debtMain,debtMain.getIssue().getIssueDate(),debtMain.getIssue().getFinishDate());
			if(debtMain.getIssue().getDebtType().equals("A")){
				List tPlanList = tPlanManager.byDebtId(debtMain.getId());
				BigDecimal interestAmount = new BigDecimal(0);
				for(Iterator it = tPlanList.iterator();it.hasNext();){
					DebtPlanDet tPlanDet = (DebtPlanDet)it.next();
					interestAmount = interestAmount.add(tPlanDet.getInterestAmount());
				}
				debtMain.setOriginInterestAmount(interestAmount);
				new DebtMainDAO().update(debtMain);
			}
				
		}
		
	}

	//儲存前將一些預設值進行計算
	private void recountBean(DebtMain debtMainDto) {
		// TODO Auto-generated method stub
		

		
		IssueMain issue = debtMainDto.getIssue();
		if (!issue.getDebtType().equals("A")){
//			差價金額 = 發行金額 - 實收金額	
			if(debtMainDto.getRealAmount() != null)
				debtMainDto.setDiversityAmount(debtMainDto.getIssueAmount().subtract(debtMainDto.getRealAmount()));
			else 
				debtMainDto.setDiversityAmount(debtMainDto.getIssueAmount());
		}
		//如果發行是增額時要算應付利息
		BigDecimal payableInterestAmount = new BigDecimal(0);
		if (!issue.getId().equals(issue.getSourceIssueId())) {
			//應付利息 = 增額金額 * 利率 * 與原始發行相差天數
			//先算出每天應付利息

			//再算出增額與原始天數的差額 
			IssueMain sourceIssueMain =new IssueManager().getBean(issue.getSourceIssueId());
			int days = DateUtil.getDays( sourceIssueMain.getIssueDate(), issue.getIssueDate() );
			
			//是否要算365還是366天
			int countBase = 365;
			if(new InterestCounter().isLeap(sourceIssueMain.getIssueDate(),issue.getIssueDate())) {
				countBase = 366;
			}
			BigDecimal averageRate = issue.getAverageRate().setScale(5,BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(100),13,5);
			BigDecimal daysPayableInterest = (debtMainDto.getIssueAmount().multiply(averageRate).divide(new BigDecimal(countBase),13,5));
	
			payableInterestAmount = daysPayableInterest.multiply(new BigDecimal(days));
			 
			
		}
		
		//新增debt_serial = issue_serial + debit_code
		debtMainDto.setDebtSerial(debtMainDto.getIssue().getIssueSerial()+ debtMainDto.getDebtCode());
		if (!issue.getDebtType().equals("A")){
			debtMainDto.setPayableInterestAmount(payableInterestAmount);
		}
		
	}

	/**
	 * 查詢借款資料
	 * @param pCols
	 * @param pValues
	 * @param pConds
	 * @param pOrderby
	 * @return
	 */
	public List Search(String[] pCols, Object[] pValues, String[] pConds, String[] pOrderby){
		Session tSession = new PaymentMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(DebtMain.class);
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
			}
		}
		if(pOrderby != null){
			for(int i = 0 ; i < pOrderby.length ; i++){
				if(pOrderby[i] == null || "".equals(pOrderby[i])) continue;
				criteria.addOrder(Order.asc(pOrderby[i]));
			}
		}
		List tResultList = criteria.list();
		tSession.close();
		return tResultList;
	}
	
	public List SearchHQL(String[] pCols, Object[] pValues, String[] pConds, String[] pOrderby){
		Session tSession = new DebtMainDAO().getSession();
		StringBuffer sql = new StringBuffer("select distinct debtMain.issue from DebtMain debtMain where 1 = 1 ");
		
		if(pCols != null && pValues != null && pConds != null){
			for(int i = 0 ; i < pCols.length ; i++){
				if(pCols[i] == null || pValues[i] == null || pConds[i] == null || "".equals(pCols[i]) || "".equals(pValues[i]) || "".equals(pConds[i]))
				{	
					continue;
				}
				else
				{
					sql.append("and "+ pCols[i] + " " + pConds[i] + " " + pValues[i]);
				}	
			}
		}
		if(pOrderby != null){
			sql.append(" order by ");
			for(int i = 0 ; i < pOrderby.length ; i++){
				if(pOrderby[i] == null || "".equals(pOrderby[i])) continue;
				sql.append(pOrderby[i]);
				if(i!= (pOrderby.length-1))
				{
					sql.append(" , ");
				}
			}
		}
		Query query = tSession.createQuery(sql.toString());
		List tResultList = query.list();
		tSession.close();
		return tResultList;
	}

}
 
