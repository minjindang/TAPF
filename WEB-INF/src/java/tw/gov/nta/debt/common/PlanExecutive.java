package tw.gov.nta.debt.common;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

/**
 * 計畫執行人
 * 依計畫執行還本付息
 * @author nicetea
 */
public class PlanExecutive {
    
    /**
     * 執行還本付息計畫
     * @param executeDate:執行日期
     * @throws HibernateException
     */
	public void executePlan(Date executeDate){
	    //1、取得DebtPlanDet的List
		PaymentMainDAO dao = PaymentMainDAO.getInstance();
		
		Session session = dao.getSession();
		
		executePlan(executeDate,session);
		
		session.close();
		
	}	 	
	
	public void executePlan(Date executeDate,Session session){
	    //1、取得DebtPlanDet的List
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("from DebtPlanDet As T ");
		buffer.append("where (T.debt.issue.debtType in ('B','A'))");
		buffer.append(" and T.repayDate <= ? and T.repayDate >= '2007/01/01' ");
		buffer.append(" and not exists(Select 1 from PaymentMain P where P.plan.id = T.id and P.repayType = '0')");
		buffer.append(" and T.deleteMark <> 'Y' ");
		Query query = session.createQuery(buffer.toString());
		query.setParameter(0,executeDate);
		
	    List tAllPlanList = query.list();
	    
	    if(tAllPlanList == null || tAllPlanList.size() == 0) return;
	    //2、將所有的計畫的List執行還本付息
	    
	    DebtPlanDet tDebtPlanDetDTO = null;
	    PayManager paymanager = new PayManager();
	    BigDecimal interestAmount = null;
	    BigDecimal capitalAmount = null;
	    
	    for(Iterator tIterator = tAllPlanList.iterator();tIterator.hasNext();){
	        tDebtPlanDetDTO = (DebtPlanDet) tIterator.next();
	        IssueMain issue = tDebtPlanDetDTO.getDebt().getIssue();
//	        if (issue.getIssueSerial().equals("BDB0401")){
//	        	System.out.println("---------------------------------------------");
//	        	System.out.println(issue.getIssueSerial());
//	        	System.out.println(issue.getIssueKind());
//	       }
	        
	        if("A".equals(issue.getDebtType())&&"1".equals(issue.getIssueKind())){
	        	interestAmount = tDebtPlanDetDTO.getTransferInterestAmount();
	        	capitalAmount = tDebtPlanDetDTO.getTransferCapitalAmount();
	        }else if ("B".equals(issue.getDebtType())){
		        //提前買回
		        Integer issue_id = (Integer)tDebtPlanDetDTO.getIssueId();
		        //payment_Main
		        StringBuffer paymentMainBuffer = new StringBuffer();
		        paymentMainBuffer.append("from PaymentMain where issueId = ?");
		        Query paymentMainQuery = session.createQuery(paymentMainBuffer.toString());
		        paymentMainQuery.setParameter(0,issue_id);
		        List paymentMainSize = paymentMainQuery.list();
		        
//		        BigDecimal pCapitalAmount = new BigDecimal(0);
//		        BigDecimal pInterestAmount = new BigDecimal(0);
		        BigDecimal pCapitalAmount = null;
		        BigDecimal pInterestAmount = null;
		        if (paymentMainSize.size() > 0)
		        {
			        //payment_Main
			        StringBuffer issueMainBuffer = new StringBuffer();
			        issueMainBuffer.append("from IssueMain where id = ?");
			        Query issueMainQuery = session.createQuery(issueMainBuffer.toString());
			        issueMainQuery.setParameter(0,issue_id);
			        List<IssueMain> issueMainList = issueMainQuery.list();
			        BigDecimal issueMainIssueAmount = issueMainList.get(0).getIssueAmount();
			        
			        //dept_plant_det
			        StringBuffer debtPlanDetBuffer = new StringBuffer();
			        debtPlanDetBuffer.append("from DebtPlanDet where issueId = ?");
			        Query debtPlanDetQuery = session.createQuery(debtPlanDetBuffer.toString());
			        debtPlanDetQuery.setParameter(0,issue_id);
			        List<DebtPlanDet> debtPlanDetList = debtPlanDetQuery.list();
			        BigDecimal debtPlanDetCapitalAmount = debtPlanDetList.get(0).getCapitalAmount();
			        
			        //payment_Main
			        BigDecimal paymentMainCapitalAmount = new BigDecimal(0);
			        BigDecimal paymentMainBalanceCapitalAmount = new BigDecimal(0);
			        for (Iterator pIterator = paymentMainSize.iterator(); pIterator.hasNext();)
			        {
			        	PaymentMain paymentMainDTO = (PaymentMain)pIterator.next();
			        	if (null != paymentMainDTO.getCapitalAmount())
			        		paymentMainCapitalAmount = paymentMainCapitalAmount.add((BigDecimal)(paymentMainDTO.getCapitalAmount()));
			        	if (null != paymentMainDTO.getBalanceCapitalAmount())
			        		paymentMainBalanceCapitalAmount = paymentMainBalanceCapitalAmount.add((BigDecimal)(paymentMainDTO.getBalanceCapitalAmount()));
			        }
			        //加總
			        if (null != paymentMainCapitalAmount && !paymentMainCapitalAmount.equals(0))
			        	pCapitalAmount = debtPlanDetCapitalAmount.subtract(paymentMainCapitalAmount);
			        pInterestAmount = issueMainIssueAmount.subtract(paymentMainBalanceCapitalAmount).subtract((debtPlanDetCapitalAmount).subtract(paymentMainCapitalAmount));
		        }
	        	
	        	if (null != pInterestAmount && !"".equals(pInterestAmount))
	        		interestAmount = pInterestAmount;
	        	else
	        		interestAmount = tDebtPlanDetDTO.getInterestAmount();
	        	if (null != pCapitalAmount && !"".equals(pCapitalAmount))
	        		capitalAmount = pCapitalAmount;
	        	else
	        		capitalAmount = tDebtPlanDetDTO.getCapitalAmount();
	        }
	        else {
	        	interestAmount = tDebtPlanDetDTO.getInterestAmount();
	        	capitalAmount = tDebtPlanDetDTO.getCapitalAmount();
	        }
	      //  if (issue.getIssueSerial().equals("91D0201")){
	      //  	System.out.println("interestAmount:"+interestAmount);
	       // 	System.out.println("capitalAmount:"+capitalAmount);
	      //  }
	        
	        PaymentMain payment = paymanager.repayDebt(tDebtPlanDetDTO.getId(), tDebtPlanDetDTO.getCapitalSerial(), tDebtPlanDetDTO.getInterestSerial(), capitalAmount.doubleValue(), interestAmount.doubleValue(), tDebtPlanDetDTO.getRepayDate(),session);
	       // if (issue.getIssueSerial().equals("91D0201")){
//	        	System.out.println("-----payment-------------------------------------");
//	        	System.out.println(payment.getDebtId());
//	        	System.out.println(payment.getIssueId());
//	        	System.out.println(payment.getInterestAmount());
//	        	System.out.println(payment.getCapitalAmount());
//	        	System.out.println(payment.getRepayDate());
	       // }
	        payment.setRepayType("0");
	        new PaymentMainDAO().saveOrUpdate(payment,session);
	        new PaymentMainDAO().saveOrUpdate(payment);
	        //new PaymentMainDAO().saveOrUpdate(payment,session);
	        //session.saveOrUpdate(payment);
	        //session.saveOrUpdate(payment);
	        //session.save(payment);
	        //session.flush();
	        //session.save(payment);
	        
	       // if (issue.getIssueSerial().equals("91D0201")){
	       // 	System.out.println("-----end-------------------------------------");
	       // }
	        
	    }
        session.flush();
	    
	}	 
}
 
