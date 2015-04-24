package tw.gov.nta.debt.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.base._BaseRootDAO;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class PlanManagerTest extends TestCase {
	PlanManager manager;
	DebtMainDAO debtDao = new DebtMainDAO();
	IssueMainDAO issueDao = new IssueMainDAO();
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		manager = new PlanManager();
		_BaseRootDAO.initialize();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	/*
	 * Test method for 'tw.gov.nta.debt.common.PlanManager.getAllPlanList()'
	 */
//	public void testGetAllPlanList() {
//		
//		assertTrue(manager.getAllPlanList().size() > 6);
//	}

//	/*
//	 * Test method for 'tw.gov.nta.debt.common.PlanManager.getAllPlanListByDebt(DebtMain)'
//	 */
//	public void testGetAllPlanListByDebt() {
//		
//		for(Iterator iterator = debtDao.findAll().iterator();iterator.hasNext();){
//			DebtMain dm = (DebtMain)iterator.next();
//			if (Integer.valueOf(193).equals(dm.getId())){
//				System.out.println("193");
//				assertTrue(manager.getAllPlanListByDebt(dm).size() > 0);
//			}
//			
//		}
//		
//	}

	/*
	 * Test method for 'tw.gov.nta.debt.common.PlanManager.getAllPlanListByIssue(IssueMain)'
	 */
	public void testGetAllPlanListByIssue() {
		Session session = issueDao.createNewSession();
		//Query query = session.createQuery("from IssueMain where userid=:userid and issueDate <:issueDate and debtType = 'A' ");
//		Query query = session.createQuery("from IssueMain where userid=:userid and  debtType = 'A' ");
//		Query query = session.createQuery("from IssueMain where debtType = 'B' and account_year < '096' ");
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(1994,1,1);
//		query.setString("userid","EXCEL");
		//query.setDate("issueDate",calendar.getTime());
		Query query = session.createQuery("from IssueMain where id = 3880 ");
		List list = query.list();
		Transaction tx = session.beginTransaction();
		Date endDate = null;

		try {
			for(Iterator iterator = list.iterator();iterator.hasNext();){
				IssueMain im = (IssueMain)iterator.next();
//		  IssueMain im =   issueDao.get(861);
				
				if("A".equals(im.getDebtType())) {
					endDate = im.getFinishDate();
				}else {
					endDate = im.getDueDate();
				}
				
				
				for(Iterator iterator2 = im.getDebtMains().iterator();iterator2.hasNext();) {
					DebtMain debt = (DebtMain)iterator2.next();
					System.out.println(im.getId()+im.getDebtName());
					manager.buildPlan(debt,im.getIssueDate(),endDate,session);
				}
					
	//			assertTrue(manager.getAllPlanListByIssue(im).size() > 0);
			}
			tx.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
