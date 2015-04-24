package tw.gov.nta.debt.form;

import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

import gov.dnt.tame.common.SupportForm;

public class Cprb0301Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	public Cprb0301Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String issueSerial;
	private Date startDate;
	private Date endDate;
	IssueMainDAO myIssue = new IssueMainDAO();
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getIssueSerial() {
		return issueSerial;
	}
	public void setIssueSerial(String issueSerial) {
		this.issueSerial = issueSerial;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public List getSerialNoList()
	{
		Session session = new IssueMainDAO().getSession();
	    Criteria criteria = session.createCriteria(IssueMain.class);
	    criteria.add(Expression.eq("debtType","E"));
	    List resultList = criteria.list();
		session.close();
		return resultList;
	}
}
