package tw.gov.nta.debt.common;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueExchangeDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueExchangeDetDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;


public class TransBondManager extends IManager {

	/**
	 * �s�W�o��Bean
	 * @param pDebtType
	 * @return
	 */
	public IssueExchangeDet createBean(String pDebtType){
		return new IssueExchangeDet();		
	}
	
	/**
	 * ���o�o�檫��
	 */
	public Object getBean(int pId) {
		return new IssueExchangeDetDAO().get(new Integer(pId));
	}

	/**
	 * �s�W�o��
	 */
	public void confirm(Object pDto) throws Exception {
		IssueExchangeDet tIssueExchangeDet = (IssueExchangeDet) pDto;
		if(!checkBean(tIssueExchangeDet))
			throw new Exception();
		new IssueExchangeDetDAO().saveOrUpdate(tIssueExchangeDet);		
	}

	/**
	 * check�o��Bean
	 */
	protected boolean checkBean(Object pBean) {
		return true;
	}
	
	/**
	 * �̵o��N�����o
	 * Bean
	 * @param pId
	 * @return
	 */
	public IssueExchangeDet getBeanByIssue(int pId){
		IssueMain tIssueMain = new IssueManager().getBean(pId);
		if(tIssueMain == null)
			return null;
		Session tSession = new IssueExchangeDetDAO().getSession();
		Criteria tCriteria = tSession.createCriteria(IssueExchangeDet.class);
		tCriteria.add(Restrictions.eq("debtType", tIssueMain));
		List tList = tCriteria.list();
		tSession.close();
		if(tList == null || tList.size() == 0)
			return null;
		return (IssueExchangeDet)tList.get(0);
	}
	
	/**
	 * �����o��
	 * @param pIssueId
	 * @return
	 * @throws Exception 
	 */
	public boolean cancel(int pIssueId) throws Exception{
		IssueExchangeDet tIssueExchangeDet = (IssueExchangeDet) this.getBean(pIssueId);
		if(tIssueExchangeDet == null)
			return false;
		if(!isModify(tIssueExchangeDet))
			return false;
		new IssueMainDAO().delete(new Integer(pIssueId));
		List tList = new DebtManager().getBeanByIssue(pIssueId);
		if(tList != null && tList.size() != 0){
			RateManager tRateManager = new RateManager();
			DebtManager tDebtManager = new DebtManager();
			Integer tDebtId = null;
			for(Iterator tIterator = tList.iterator(); tIterator.hasNext();){
				tDebtId = ((DebtMain)tIterator.next()).getId();
				tRateManager.deleteByDebtId(tDebtId);
				tDebtManager.cancel(tDebtId);
			}
			new PlanManager().cancelByIssue(pIssueId);
		}
		return true;
	}

	public boolean isModify(IssueExchangeDet pIssueExchangeDet){
		return new PayManager().hasPayment(pIssueExchangeDet.getIssue().getId());
	}
	
	/**
	 * �d��ñ���Ȧ���
	 * @param pcols:�h�����
	 * @param pValues:�h���ƭ�
	 * @param pConds:�h������(=,>,<,>=,<=)
	 * @param pOrderby:�h���ƧǱ���
	 * @return:�d�ߵ��G�M��
	 */
	public List Search(String[] pCols, Object[] pValues, String[] pConds, String[] pOrderby){
		Session tSession = new IssueExchangeDetDAO().getSession();
		Criteria tCriteria = tSession.createCriteria(IssueExchangeDet.class);
		if(pCols != null && pValues != null && pConds != null){
			for(int i = 0 ; i < pCols.length ; i++){
				if(pConds[i] == null || pCols[i] == null || pValues[i] == null || "".equals(pCols[i]) || "".equals(pValues[i]) || "".equals(pConds[i]))
					continue;
				if(pConds[i].equals("="))
					tCriteria.add(Expression.eq(pCols[i], pValues[i]));
				else if(pConds[i].equals(">"))
					tCriteria.add(Expression.gt(pCols[i], pValues[i]));
				else if(pConds[i].equals("<"))
					tCriteria.add(Expression.lt(pCols[i], pValues[i]));
				else if(pConds[i].equals(">="))
					tCriteria.add(Expression.ge(pCols[i], pValues[i]));
				else if(pConds[i].equals("<="))
					tCriteria.add(Expression.le(pCols[i], pValues[i]));
				else if(pConds[i].equals("like"))
					tCriteria.add(Expression.like(pCols[i], pValues[i]));
			}
		}
		if(pOrderby != null){
			for(int i = 0 ; i < pOrderby.length ; i++){
				if(pOrderby[i] == null || "".equals(pOrderby[i])) continue;
				tCriteria.addOrder(Order.asc(pOrderby[i]));
			}
		}
		List tResultList = tCriteria.list();
		tSession.close();
		return tResultList;
	}
	
}
 
