/*
 * 在 2006/2/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.exchequer.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class Bira0501Form extends SupportForm  {
	private static final long serialVersionUID = 1L;
	private String budgetCode;
	private String debtCode;
	private Date issueSdate;
	private Date issueEdate;

	/**
	 * @return 傳回 budgetCode。
	 */
	public String getBudgetCode() {
		return budgetCode;
	}
	/**
	 * @param budgetCode 要設定的 budgetCode。
	 */
	public void setBudgetCode(String budgetCode) {
		this.budgetCode = budgetCode;
	}
	/**
	 * @return 傳回 debtCode。
	 */
	public String getDebtCode() {
		return debtCode;
	}
	/**
	 * @param debtCode 要設定的 debtCode。
	 */
	public void setDebtCode(String debtCode) {
		this.debtCode = debtCode;
	}

	/**
	 * @return 傳回 issueEdate。
	 */
	public Date getIssueEdate() {
		return issueEdate;
	}
	/**
	 * @param issueEdate 要設定的 issueEdate。
	 */
	public void setIssueEdate(Date issueEdate) {
		this.issueEdate = issueEdate;
	}
	/**
	 * @return 傳回 issueSdate。
	 */
	public Date getIssueSdate() {
		return issueSdate;
	}
	/**
	 * @param issueSdate 要設定的 issueSdate。
	 */
	public void setIssueSdate(Date issueSdate) {
		this.issueSdate = issueSdate;
	}
}
