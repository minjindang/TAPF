package tw.gov.nta.debt.common;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.debt.IssueDet;
import tw.gov.nta.sql.debt.dao.IssueDetDAO;

public class IssueDetManager extends IManager {

	@Override
	public void confirm(Object pDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean checkBean(Object pBean) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * 用issueId取得List IssueDet的資料
	 */
	
	public List getListByIssueID(Integer id)
	{
		Session tSession = new IssueDetDAO().getSession();
		Criteria criteria = tSession.createCriteria(IssueDet.class);
		criteria.add(Expression.eq("issueId", id));
		List tResult = criteria.list();
		tSession.close();
		return tResult;
	}
	
	/**
	 * 用issueDetId取得單筆IssueDet的資料
	 */
	
	public IssueDet getBeanByID(Integer id)
	{
		return (new IssueDetDAO().get(id));
	}
	
	/**
	 * 用新增或修改一筆資料
	 */
	
	public void IssueDetConfirm(IssueDet issueDet)
	{	if(null != issueDet)
		{	
			IssueDetDAO issueDetDAO = new IssueDetDAO();
			issueDetDAO.saveOrUpdate(issueDet);
		}	
	}
	
	/**
	 * 用刪除一筆資料
	 */
	
	public void IssueDetDelete(IssueDet issueDet)
	{
		if(null != issueDet)
		{	
			IssueDetDAO issueDetDAO = new IssueDetDAO();
			issueDetDAO.delete(issueDet);
		}
	}
	
	
	/**
	 * 查詢IssueDet資料
	 * @param pCols
	 * @param pValues
	 * @param pConds
	 * @param pOrderby
	 * @return
	 */
	public List Search(String[] pCols, Object[] pValues, String[] pConds, String[] pOrderby){
		Session tSession = new IssueDetDAO().getSession();
		Criteria criteria = tSession.createCriteria(IssueDet.class);
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
				criteria.addOrder(Order.asc(pOrderby[i]));
			}
		}
		List tResultList = criteria.list();
		tSession.close();
		return tResultList;
	}
	
	/**
	 * 用HSQL查詢
	 */
	public List getIssueDetListBySql(StringBuffer sql)
	{
		Session session = new IssueDetDAO().getSession();
		Query query = session.createQuery(sql.toString());
		return query.list();
	}
}
