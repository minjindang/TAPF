package tw.gov.nta.surplusage.form;

import gov.dnt.tame.common.SupportForm;

public class Gara2401Form extends GaraBaseForm {
	private static final long serialVersionUID = 1L;

	public Gara2401Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String accountSyear;
	private String accountEyear;
	private String amountUnit;
	public String getAccountEyear() {
		return accountEyear;
	}
	public void setAccountEyear(String accountEyear) {
		accountEyear=accountEyear.trim();
		if (accountEyear.length() < 3 && !"".equals(accountEyear)){
			for (int i = 0 ; i < 3-accountEyear.length() ; i++){
				accountEyear = "0" + accountEyear;
			}	
		}
		this.accountEyear = accountEyear;
	}
	public String getAccountSyear() {
		return accountSyear;
	}
	public void setAccountSyear(String accountSyear) {
		accountSyear=accountSyear.trim();
		if (accountSyear.length() < 3 && !"".equals(accountSyear)){
			for (int i = 0 ; i < 3-accountSyear.length() ; i++){
				accountSyear = "0" + accountSyear;
			}	
		}
		this.accountSyear = accountSyear;
	}
	public String getAmountUnit() {
		return amountUnit;
	}
	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}

}
