package tw.gov.nta.shortterm.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.DateUtil;

public class Dira0401Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	public Dira0401Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int issueId;
	private String issueYear;
	private String accountYear;
	private String serialNo;
	private Date baseDate;
	public String getAccountYear() {
		return accountYear;
	}
	public void setAccountYear(String accountYear) {
		this.accountYear = accountYear;
	}
	public Date getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(Date baseDate) {
		this.baseDate = baseDate;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public String getIssueYear() {
		return issueYear;
	}
	public void setIssueYear(String issueYear) {
		if(issueYear.length()==2)
			issueYear = "0"+issueYear;
		
		this.issueYear = issueYear;
	}
	public List getIssueList() {
		IssueMainDAO dao = IssueMainDAO.getInstance();
		List issueList = new ArrayList();

		Criteria criteria = dao.getSession().createCriteria(IssueMain.class);
		
		criteria.add(Expression.eq("debtType","D"));
		
		if (getIssueYear()!=null && !"".equals(getIssueYear())) {
			criteria.add(Expression.eq("accountYear",getIssueYear()));
		}else {
			return new ArrayList();
		}
		criteria.addOrder(Order.asc("accountYear"));
		criteria.addOrder(Order.asc("serialNo"));
		
		issueList = criteria.list();

		if (issueList.size() > 0 && getIssueId() == 0) {
			setIssueId(((IssueMain)issueList.get(0)).getId());	
		}
		return issueList;
	}

}
