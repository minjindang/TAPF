package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.account.AccountRef;
import tw.gov.nta.sql.account.dao.AccountRefDAO;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.DebtTypeRefDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class Earc0201Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String debtType;
	private Integer issueId;
	private String accountCode;
	private DebtTypeRef debtTypeObject;
	
	public DebtTypeRef getDebtTypeObject() {
		return debtTypeObject;
	}
	public void setDebtTypeObject(DebtTypeRef debtTypeObject) {
		this.debtTypeObject = debtTypeObject;
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
		DebtTypeRefDAO dao = DebtTypeRefDAO.getInstance();
		Criteria criteria = dao.getSession().createCriteria(DebtTypeRef.class);
		criteria.add(Expression.eq("typeCode",debtType));
		setDebtTypeObject((DebtTypeRef)criteria.list().get(0));
		
	}
	/**
	 * @return Returns the month.
	 */

	public List getIssueList() {
		IssueMainDAO dao = IssueMainDAO.getInstance();
		Criteria criteria = dao.getSession().createCriteria(IssueMain.class);
		
		criteria.add(Expression.eq("debtType",getDebtType()));
		
		return criteria.list();
		
	}		

//		if (null!=getMonth() && !"".equals(getMonth()))
//			criteria.add(Expression.eq("serialNo",myForm.getSerialNo()));
//		

	/**
	 * @return Returns the issueMainId.
	 */
	public List getAccountList() {
		AccountRefDAO dao = AccountRefDAO.getInstance();
		Criteria criteria = dao.getSession().createCriteria(AccountRef.class);
		
		criteria.add(Expression.eq("debtType",getDebtTypeObject()));
		
		return criteria.list();
		
	}	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
}
