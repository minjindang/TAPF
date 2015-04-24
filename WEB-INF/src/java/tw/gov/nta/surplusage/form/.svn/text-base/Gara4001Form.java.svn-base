package tw.gov.nta.surplusage.form;

import gov.dnt.tame.common.SupportForm;

public class Gara4001Form extends GaraBaseForm
{	
	private static final long serialVersionUID = 1L;
	private String accountSYear;
	private String accountEYear;
	private String amountUnit;
	
	public String getAmountUnit() {
		return amountUnit;
	}
	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
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
