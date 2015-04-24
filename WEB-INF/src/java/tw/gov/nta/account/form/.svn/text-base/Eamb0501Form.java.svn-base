package tw.gov.nta.account.form;

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

public class Eamb0501Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private String accountYear;
	private String accountMonth;
	private String issueYear;
	private int issueId;
	/**
	 * @return Returns the accountMonth.
	 */
	public String getAccountMonth() {
		return accountMonth;
	}
	/**
	 * @param accountMonth The accountMonth to set.
	 */
	public void setAccountMonth(String accountMonth) {
		this.accountMonth = accountMonth;
	}
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
	 * ¶Å°È¦WºÙ ¦Cªí
	 */
	public List getIssueList() {
		IssueMainDAO dao = IssueMainDAO.getInstance();
		List issueList = new ArrayList();
/*		if("A".equals(debtType.getTypeCode().trim())) {
			StringBuffer queryString = new StringBuffer();
			queryString.append("from DebtMain debt where debt.issue.debtType = :debtType");
			if (getIssueYear()!=null && !"".equals(getIssueYear())) {
				queryString.append(" and debt.issue.accountYear = :accountYear");
			}else {
				queryString.append(" and 1 = 2");
			}			
			if (getIssueMonth()!=null&&!"".equals(getIssueMonth())) {
				queryString.append(" and exists(select 1 from IssueMain issue where issue.id = debt.issue.sourceIssueId ");
				queryString.append("                  and issue.issueDate between :monthStartDate and :monthEndDate)");
			}
			Query query = dao.getSession().createQuery(queryString.toString());
			
			if (getIssueYear()!=null && !"".equals(getIssueYear())) {
				query.setString("accountYear",getIssueYear());
			}
			if (getIssueMonth()!=null&&!"".equals(getIssueMonth())) {
				Date monthStartDate = DateUtil.str2Date(getIssueYear()+getIssueMonth()+"01");
				Date monthEndDate = DateUtil.getLastDateOfMonth(monthStartDate);
				query.setDate("monthStartDate",monthStartDate);
				query.setDate("monthEndDate",monthEndDate);
			}
			issueList = query.list();
			
		}else { */
			Criteria criteria = dao.getSession().createCriteria(IssueMain.class);
			
			criteria.add(Expression.eq("debtType","A"));
			
			if (getIssueYear()!=null && !"".equals(getIssueYear())) {
				criteria.add(Expression.eq("accountYear",getIssueYear()));
			}else {
				return new ArrayList();
			}
			
			
			criteria.add(Expression.ne("budgetCode",4));
			criteria.addOrder(Order.asc("accountYear"));
			criteria.addOrder(Order.asc("serialNo"));
			
			issueList = criteria.list();
//		}
		if (issueList.size() > 0 && getIssueId() == 0) {
			setIssueId(((IssueMain)issueList.get(0)).getId());	
		}
		return issueList;
	}
	public String getIssueYear() {
		return issueYear;
	}
	/**
	 * @param issueYear The issueYear to set.
	 */
	public void setIssueYear(String issueYear) {
		if(issueYear.trim().length() == 2) 
			this.issueYear = "0" + issueYear;
		else
			this.issueYear = issueYear;
	}
	
	/**
	 * @param issueId The issueId to set.
	 */
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	
	/**
	 * @return Returns the issueId.
	 */
	public int getIssueId() {
		return issueId;
	}	
}
