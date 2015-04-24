/*
 * 在 2006/2/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.exchequer.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class Bira1701Form extends SupportForm  {
	private static final long serialVersionUID = 1L;
	private String bandNo;
	private String bankName;
	private String amountUnit;
	private Date issueSdate;
	private Date issueEdate;
	private String accountSYear;
	private String accountEYear;
	private Integer issueId;
	
	public String getBandNo() {
		return bandNo;
	}
	public void setBandNo(String bandNo) {
		this.bandNo = bandNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public String getAmountUnit() {
		return amountUnit;
	}
	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
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
	public String getAccountEYear() {
		return accountEYear;
	}
	public void setAccountEYear(String accountEYear) {
		accountEYear=accountEYear.trim();
		if (accountEYear.length() < 3 && !"".equals(accountEYear)){
			for (int i = 0 ; i < 3-accountEYear.length() ; i++){
				accountEYear = "0" + accountEYear;
			}	
		}
		this.accountEYear = accountEYear;
	}
	public String getAccountSYear() {
		return accountSYear;
	}
	public void setAccountSYear(String accountSYear) {
		accountSYear=accountSYear.trim();
		if (accountSYear.length() < 3 && !"".equals(accountSYear)){
			for (int i = 0 ; i < 3-accountSYear.length() ; i++){
				accountSYear = "0" + accountSYear;
			}	
		}
		this.accountSYear = accountSYear;
	}
}
