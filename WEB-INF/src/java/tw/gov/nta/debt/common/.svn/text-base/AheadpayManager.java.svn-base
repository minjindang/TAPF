/**
*
* @author Andrew Sung
* @createDate 2006/12/5
*/
package tw.gov.nta.debt.common;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.debt.AheadpayMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.AheadpayMainDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class AheadpayManager extends IManager{
	private AheadpayMainDAO dao;

	public AheadpayManager() {
		dao = new AheadpayMainDAO();
	}

	@Override
	protected boolean checkBean(Object pBean) {
		return false;
	}

	@Override
	public void confirm(Object pDto) throws Exception {
		AheadpayMain pAheadpayMain = (AheadpayMain)pDto;
		dao.saveOrUpdate(pAheadpayMain);
	}
	public void delete(AheadpayMain tAheadpayMain){
		dao.delete(tAheadpayMain);
	}
	public AheadpayMain getBean(int id){
		return dao.get(id);
	}
	public List Search(String[] pCols, Object[] pValues, String[] pConds, String[] pOrderby){
		Session tSession = dao.getSession();
		Criteria criteria = tSession.createCriteria(AheadpayMain.class);
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
}
