package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import tw.gov.nta.sql.debt.dao.BankRefDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class Cpra0201Form extends SupportForm {
	private static final long serialVersionUID = 1L;


	public Cpra0201Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String issueSerial;
	private String bankCode;
	private String bankName;
	private Integer bankId;
	private Date tempDate;
	private BigDecimal tempDecimal;
	private Integer planId;
	private Integer issueId;
	BankRefDAO myBank = new BankRefDAO();
	IssueMainDAO myIssue = new IssueMainDAO();
	
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getIssueSerial() {
		return issueSerial;
	}
	public void setIssueSerial(String issueSerial) {
		this.issueSerial = issueSerial;
	}
	public List getBankCodeList()
	{
		return ListToolManager.getList("select id , bankName from BankRef");
	}
//	public List getBankCodeList()
//	{
//		List debtlist = getDebtMainList();
//		List banklist = new LinkedList();
//		Session session = new BankRefDAO().getSession();
//		for(Iterator it = debtlist.iterator();it.hasNext();)
//		{	
//			Criteria criteria = session.createCriteria(BankRef.class);
//			DebtMain myDebt = (DebtMain)it.next();
//			if(null !=myDebt.getBank() && 0 != myDebt.getBank().getId())
//			{
//				criteria.add(Expression.eq("id", myDebt.getBank().getId()));
//			}
//	    	banklist.addAll(criteria.list());
//		}
//		return banklist;
//	}
//	public List getDebtMainList()
//	{
//		Session session = new DebtMainDAO().getSession();
//	    Criteria criteria = session.createCriteria(DebtMain.class);
//	    if(null != getIssueSerial())
//	    {
//	    	criteria.add(Expression.eq("issueId", getIssueSerial()));
//	    }
//	    List resultList = criteria.list();
//		session.close();
//		return resultList;
//	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public Date getTempDate() {
		return tempDate;
	}
	public void setTempDate(Date tempDate) {
		this.tempDate = tempDate;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public BigDecimal getTempDecimal() {
		return tempDecimal;
	}
	public void setTempDecimal(BigDecimal tempDecimal) {
		this.tempDecimal = tempDecimal;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

}
