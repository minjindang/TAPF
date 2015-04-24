/**
*
* @author Andrew Sung
* @createDate 2006/10/18
*/
package tw.gov.nta.surplusage.common;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.debt.OtherPlanDebt;
import tw.gov.nta.sql.debt.dao.OtherPlanDebtDAO;

public class OtherPlanDebtManager {
	private OtherPlanDebtDAO dao = new OtherPlanDebtDAO();
	public List getList(){
		Session tSession = dao.getSession();
		Criteria criteria = tSession.createCriteria(OtherPlanDebt.class);
		criteria.addOrder(Order.asc("issueSerial"));
		List tResultList = criteria.list();
		tSession.close();
		return tResultList;
	}
	public void confirm(OtherPlanDebt pDto){
		dao.saveOrUpdate(pDto);
	}
	public void delete(OtherPlanDebt pDto){
		dao.delete(pDto.getId());
	}
	public OtherPlanDebt getBean(Integer pId){
		return dao.get(pId);
	}
}
