
package tw.gov.nta.debt.common;

import java.util.Date;
import java.util.Iterator;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.debt.base._BaseRootDAO;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;

public class PlanExecutiveTest extends TestCase {
	public void setUp() {
		_BaseRootDAO.initialize();
	}
	
	public void testExecutePlan() {
		try {
			PlanExecutive plan = new PlanExecutive();
			DebtPlanDetDAO planDao = DebtPlanDetDAO.getInstance();
			Session session = planDao.createNewSession();
	//		Criteria criteria2 = planDao.getSession().createCriteria(DebtPlanDet.class);
	//		criteria2.add(Expression.eq("debt",1));
	//		planList = criteria2.list();
	//		Query query = session.createQuery("select distinct repayDate from DebtPlanDet T where  T.debt.issue.debtType=? and T.repayDate < ? and T.debt.issue.issueKind = '0' ");
	//		query.setString(0,"A");
	//		query.setDate(1,new Date());
			Query query = session.createQuery("select distinct repayDate from DebtPlanDet T where T.debt.issue.id = 3487 ");
			for(Iterator iterator = query.iterate();iterator.hasNext();) {
				Date planDate = (Date)iterator.next();
				System.out.println(planDate);
				plan.executePlan(planDate,session);
			}
				//		
			//Criteria criteria = session.getSession().createCriteria(PaymentMain.class);
	//		criteria.add(Expression.in("plan",planList));
	//		List paymentList = criteria.list();
	//		
	//		assertEquals(planList.size(),paymentList.size());
			
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
