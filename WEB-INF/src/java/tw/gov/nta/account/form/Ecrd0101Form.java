package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class Ecrd0101Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String accountYear;
	private Integer month;
	private String debtType;
	private Integer issueMainId;
	
	/**
	 * @return Returns the accountYear.
	 */
	/**
	 * @return Returns the accountYear.
	 */
	
	public String getAccountYear() {
		return accountYear;
	}
	/**
	 * @param accountYear The accountYear to set.
	 */
	public void setAccountYear(String accountYear) {
		this.accountYear = accountYear;
	}
	/**
	 * @return Returns the debtType.
	 */
	public String getDebtType() {
		return debtType;
	}
	/**
	 * @param debtType The debtType to set.
	 */
	public void setDebtType(String debtType) {
		this.debtType = debtType;
	}
	/**
	 * @return Returns the month.
	 */
	public Integer getMonth() {
		return month;
	}
	/**
	 * @param month The month to set.
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}

	public List getIssueList() {
		boolean is_query = false;
		IssueMainDAO dao = IssueMainDAO.getInstance();
		Criteria criteria = dao.getSession().createCriteria(IssueMain.class);
		
		criteria.add(Expression.eq("debtType",getDebtType()));
		
		if (null!=getAccountYear() && !"".equals(getAccountYear())) {
			criteria.add(Expression.eq("accountYear",getAccountYear()));
			is_query = true;
		}
			

//		if (null!=getMonth() && !"".equals(getMonth()))
//			criteria.add(Expression.eq("serialNo",myForm.getSerialNo()));
//		
		if (is_query)
			return criteria.list();
		else
			return new ArrayList();
	}
	/**
	 * @return Returns the issueMainId.
	 */
	public Integer getIssueMainId() {
		return issueMainId;
	}
	/**
	 * @param issueMainId The issueMainId to set.
	 */
	public void setIssueMainId(Integer issueMainId) {
		this.issueMainId = issueMainId;
	}
}
