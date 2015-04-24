package tw.gov.nta.debt.common;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.IssueTicketDetDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

/**
 * 尚未實做
 * @author nicetea
 *
 */
public class TicketManager extends IManager{
	
	/**
	 * 新增債票DTO
	 * @param pIssueId
	 * @return
	 */
	public IssueTicketDet createBean(int pIssueId){
		IssueTicketDet tIssueTicketDetDto = new IssueTicketDet(); 
		tIssueTicketDetDto.setIssue(new IssueManager().getBean(pIssueId));
		return tIssueTicketDetDto;
	}
	
	/**
	 * 檢核債票DTO，目前只回應true
	 * @param tDto
	 * @return
	 */
	public boolean checkBean(Object pDto){
//		IssueTicketDet pIssueTicketDetDto = (IssueTicketDet) pDto;
		return true;
	}
	
	/**
	 * 確定債票
	 * @param pIssueTicketDetDto
	 * @throws Exception
	 */
	public void confirm(Object pDto) throws Exception{
		IssueTicketDet tIssueTicketDetDto =  (IssueTicketDet) pDto;
		if(!checkBean(tIssueTicketDetDto))
			throw new Exception();
		IssueTicketDetDAO tIssueTicketDetDao = new IssueTicketDetDAO();
		Session tSession = tIssueTicketDetDao.getSession();
		Criteria criteria = tSession.createCriteria(IssueTicketDet.class);
		IssueMain tIssueMain = new IssueMain();
		tIssueMain.setId(tIssueTicketDetDto.getId());
		criteria.add(Expression.eq("issue", tIssueTicketDetDto.getIssue()));
		if(tIssueTicketDetDto.getId()!= null)
			criteria.add(Expression.ne("id", tIssueTicketDetDto.getId()));
		List tList = criteria.list();
		IssueTicketDet tIssueTicketDet = null;
		BigDecimal tTotalAmount = new BigDecimal(0);
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); ){
			tIssueTicketDet = (IssueTicketDet) tIterator.next();
			tTotalAmount = tTotalAmount.add(tIssueTicketDet.getTicketAmount().multiply(new BigDecimal(tIssueTicketDet.getTicketCount())));
		}
		tTotalAmount = tTotalAmount.add(tIssueTicketDetDto.getTicketAmount().multiply(new BigDecimal(tIssueTicketDetDto.getTicketCount())));
		IssueMain tIssueMainDto = new IssueManager().getBean(tIssueTicketDetDto.getIssue().getId());
		if(tIssueMainDto.getIssueAmount().compareTo(tTotalAmount) == -1)
			throw new Exception();
		tSession.close();
		new IssueTicketDetDAO().saveOrUpdate(tIssueTicketDetDto);		
	}
	
	/**
	 * 取消債票
	 */
	public void cancel(int pTicketId){
		new IssueTicketDetDAO().delete(new Integer(pTicketId));
	}
	
	/**
	 * 取得債票
	 */
	public IssueTicketDet getBean(int pId){
		return new IssueTicketDetDAO().get(new Integer(pId));
	}
	
	/**
	 * 是否可修改
	 * @param pIssueTicketDetDto
	 * @return
	 */
	public boolean isModify(IssueTicketDet pIssueTicketDetDto){
		Session tSession = new PaymentMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(PaymentMain.class);
		criteria.add(Expression.eq("issue", pIssueTicketDetDto.getIssue()));
		List tList = criteria.list();
		tSession.close();
		return tList == null || tList.size() == 0;
	}

	/**
	 * 依發行Id取得債票dto之list
	 * @param pIssueId
	 * @return
	 */
	public List getBeanByIssue(int pIssueId){
		IssueMain tIssueMain = new IssueManager().getBean(pIssueId);
		Session tSession = new IssueTicketDetDAO().getSession();
		Criteria criteria = tSession.createCriteria(IssueTicketDet.class);
		criteria.add(Expression.eq("issue", tIssueMain));
		List tList = criteria.list();
		tSession.close();	
		return tList;
	}
	
	/**
	 * 暫無實做
	 */
	public void getAccountInfo(Object object) {
	}
}