/*
 * 在 2006/2/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.exchequer.form;

import gov.dnt.tame.common.SupportForm;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class Bira0601Form extends SupportForm  {
	private static final long serialVersionUID = 1L;
	private String budgetCode;
	private String debtCode;
	private String accountSYear;
	private String accountEYear;

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
