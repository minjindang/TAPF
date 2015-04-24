package tw.gov.nta.surplusage.form;

import gov.dnt.tame.common.SupportForm;

public class Gara1901Form extends GaraBaseForm {
	private static final long serialVersionUID = 1L;
	private String accountYear; 
	private String accountMonth;
	private String amountUnit;
	
	public String getAccountMonth() {
		return accountMonth;
	}
	public void setAccountMonth(String accountMonth) {
		this.accountMonth = accountMonth;
	}
	public String getAccountYear() {
		return accountYear;
	}
	public void setAccountYear(String accountYear) {
		if (accountYear.length()<3 && !"".equals(accountYear.trim())){
			if(accountYear.length()<2)
				accountYear = "00"+accountYear;
			else
				accountYear = "0"+accountYear;
		}
		this.accountYear = accountYear.trim();
	}
	public String getAmountUnit() {
		return amountUnit;
	}
	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}
	
	
	
	
}
