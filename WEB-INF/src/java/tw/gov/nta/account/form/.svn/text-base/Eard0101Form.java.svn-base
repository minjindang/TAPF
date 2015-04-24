package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class Eard0101Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String accountYear;
	private String debtType;
	private Integer issueId;
	
	@Override
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		// TODO Auto-generated method stub
		super.reset(arg0, arg1);
		String sysDate = gov.dnt.tame.util.DateUtil.getSystemDate();
		setAccountYear(sysDate.substring(0,3));
		
	}
	
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
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
}
