package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import tw.gov.nta.sql.dao.BudgetRefDAO;
import tw.gov.nta.sql.dao.DebitRefDAO;

public class Eamb0101Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private String accountYear;
	private String serialNo;
	private Integer budgetCode;
	private Integer debtCode;
	private String debtName;
	private String startIssueDate;
	private String endIssueDate;
	private String startDueDate;
	private String endDueDate;
	private String issueKind;
	private String month;
	private String startRepayDate;
	private String endRepayDate;
	private String chargeType;
	private String startExchangeDate;
	private String endExchangeDate;
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	/**
	 * @return Returns the endRepayDate.
	 */
	public String getEndRepayDate() {
		return endRepayDate;
	}
	/**
	 * @param endRepayDate The endRepayDate to set.
	 */
	public void setEndRepayDate(String endRepayDate) {
		this.endRepayDate = endRepayDate;
	}
	/**
	 * @return Returns the startRepayDate.
	 */
	public String getStartRepayDate() {
		return startRepayDate;
	}
	/**
	 * @param startRepayDate The startRepayDate to set.
	 */
	public void setStartRepayDate(String startRepayDate) {
		this.startRepayDate = startRepayDate;
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
		if (accountYear.length() ==2)
			accountYear = "0"+accountYear.trim();
		
		this.accountYear = accountYear;
	}
	/**
	 * @return Returns the budgetCode.
	 */
	public Integer getBudgetCode() {
		return budgetCode;
	}
	/**
	 * @param budgetCode The budgetCode to set.
	 */
	public void setBudgetCode(Integer budgetCode) {
		this.budgetCode = budgetCode;
	}
	/**
	 * @return Returns the debtCode.
	 */
	public Integer getDebtCode() {
		return debtCode;
	}
	/**
	 * @param debtCode The debtCode to set.
	 */
	public void setDebtCode(Integer debtCode) {
		this.debtCode = debtCode;
	}
	/**
	 * @return Returns the debtName.
	 */
	public String getDebtName() {
		return debtName;
	}
	/**
	 * @param debtName The debtName to set.
	 */
	public void setDebtName(String debtName) {
		this.debtName = debtName;
	}
	/**
	 * @return Returns the endDueDate.
	 */
	public String getEndDueDate() {
		return endDueDate;
	}
	/**
	 * @param endDueDate The endDueDate to set.
	 */
	public void setEndDueDate(String endDueDate) {
		this.endDueDate = endDueDate;
	}
	/**
	 * @return Returns the endIssueDate.
	 */
	public String getEndIssueDate() {
		return endIssueDate;
	}
	/**
	 * @param endIssueDate The endIssueDate to set.
	 */
	public void setEndIssueDate(String endIssueDate) {
		this.endIssueDate = endIssueDate;
	}
	/**
	 * @return Returns the issueKind.
	 */
	public String getIssueKind() {
		return issueKind;
	}
	/**
	 * @param issueKind The issueKind to set.
	 */
	public void setIssueKind(String issueKind) {
		this.issueKind = issueKind;
	}
	/**
	 * @return Returns the serialNo.
	 */
	public String getSerialNo() {
		return serialNo;
	}
	/**
	 * @param serialNo The serialNo to set.
	 */
	public void setSerialNo(String serialNo) {
		if(serialNo.trim().length() == 1) {
			try {
				int serialNum = Integer.parseInt(serialNo.trim());
				serialNo = "0"+serialNo;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				
			}
		}
		this.serialNo = serialNo;
	}
	/**
	 * @return Returns the startDueDate.
	 */
	public String getStartDueDate() {
		return startDueDate;
	}
	/**
	 * @param startDueDate The startDueDate to set.
	 */
	public void setStartDueDate(String startDueDate) {
		this.startDueDate = startDueDate;
	}
	/**
	 * @return Returns the startIssueDate.
	 */
	public String getStartIssueDate() {
		return startIssueDate;
	}
	/**
	 * @param startIssueDate The startIssueDate to set.
	 */
	public void setStartIssueDate(String startIssueDate) {
		this.startIssueDate = startIssueDate;
	}
	
	public String getStartExchangeDate() {
		return startExchangeDate;
	}
	public void setStartExchangeDate(String startExchangeDate) {
		this.startExchangeDate = startExchangeDate;
	}
	
	public String getEndExchangeDate() {
		return endExchangeDate;
	}
	public void setEndExchangeDate(String endExchangeDate) {
		this.endExchangeDate = endExchangeDate;
	}
	
	public List getAllBudgetCode() {
		BudgetRefDAO dao = BudgetRefDAO.getInstance();
		return dao.findAll();
	}

	public List getAllDebtCode() {
		DebitRefDAO dao = DebitRefDAO.getInstance();
		return dao.findAll();
	}
	/**
	 * @return Returns the month.
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month The month to set.
	 */
	public void setMonth(String month) {
		if (month !=null && !"".equals(month.trim())) {
			int monthnumber = Integer.parseInt(month);
			if(monthnumber < 10 && month.trim().length() < 2)
				month = "0"+ month;
		}
		
		this.month = month;
	}
}
