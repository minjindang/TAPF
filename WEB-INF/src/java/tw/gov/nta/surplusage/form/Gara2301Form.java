package tw.gov.nta.surplusage.form;

import gov.dnt.tame.common.SupportForm;

public class Gara2301Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String budgetCode ; //�w��O
	private String debtCode ; //�ŰȧO
	private String amountUnit;
	
	public String getAmountUnit() {
		return amountUnit;
	}
	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}
	public String getBudgetCode() {
		return budgetCode;
	}
	public void setBudgetCode(String budgetCode) {
		this.budgetCode = budgetCode;
	}
	public String getDebtCode() {
		return debtCode;
	}
	public void setDebtCode(String debtCode) {
		this.debtCode = debtCode;
	}
}
