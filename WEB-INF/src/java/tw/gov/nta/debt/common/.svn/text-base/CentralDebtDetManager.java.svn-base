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


import tw.gov.nta.sql.debt.CentralDebtDet;

import tw.gov.nta.sql.debt.dao.CentralDebtDetDAO;


public class CentralDebtDetManager extends IManager{
	private CentralDebtDetDAO dao;

	public CentralDebtDetManager() {
		dao = new CentralDebtDetDAO();
	}

	@Override
	protected boolean checkBean(Object pBean) {
		return false;
	}

	@Override
	public void confirm(Object pDto) throws Exception {
		CentralDebtDet pCentralDebtDet = (CentralDebtDet)pDto;
		dao.saveOrUpdate(pCentralDebtDet);
	}
	public void delete(CentralDebtDet tCentralDebtDetn){
		dao.delete(tCentralDebtDetn);
	}
	public CentralDebtDet getBean(int id){
		return dao.get(id);
	}
	public List Search(String[] pCols, Object[] pValues, String[] pConds, String[] pOrderby){
		Session tSession = dao.getSession();
		Criteria criteria = tSession.createCriteria(CentralDebtDet.class);
		if(pCols != null && pValues != null && pConds != null){
			for(int i = 0 ; i < pCols.length ; i++){
				if(pCols[i] == null || pValues[i] == null || pConds[i] == null 
						|| "".equals(pCols[i]) || "".equals(pValues[i]) || 
						"".equals(pConds[i]) || pValues[i].equals(0))
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
				//criteria.addOrder(Order.asc(pOrderby[i]));
			}
		}
		List tResultList = criteria.list();
		tSession.close();
		return tResultList;
	} 
}
