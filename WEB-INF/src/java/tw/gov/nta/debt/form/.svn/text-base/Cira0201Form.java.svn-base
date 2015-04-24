package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class Cira0201Form extends SupportForm {
	private static final long serialVersionUID = 1L;


	public Cira0201Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String issueSerial;
	private String baseUnit;
	private String baseUnitLabel;
	IssueMainDAO myIssue = new IssueMainDAO();
	public String getIssueSerial() {
		return issueSerial;
	}
	public String getBaseUnit() {
		return baseUnit;
	}
	public void setBaseUnit(String baseUnit) {
		this.baseUnit = baseUnit;
	}
	public void setIssueSerial(String issueSerial) {
		this.issueSerial = issueSerial;
	}
	public List getSerialNoList()
	{
		Session session = new IssueMainDAO().getSession();
	    Criteria criteria = session.createCriteria(IssueMain.class);
	    criteria.add(Expression.eq("debtType","C"));
	    List resultList = criteria.list();
		session.close();
		return resultList;
	}
	public String getBaseUnitLabel() {
		return baseUnitLabel;
	}
	public void setBaseUnitLabel(String baseUnitLabel) {
		this.baseUnitLabel = baseUnitLabel;
	}
}
