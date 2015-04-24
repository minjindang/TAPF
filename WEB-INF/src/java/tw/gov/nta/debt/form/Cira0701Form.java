package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Cira0701Form extends SupportForm {
	private static final long serialVersionUID = 1L;


	public Cira0701Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String startYear;
	private String endYear;
	private String forAll;
	private String budgetCode;
	private String debtCode;
	private String baseUnit;
	private String baseUnitValue;
	private Date baseDate;
	public String getBaseUnitValue() {
		return baseUnitValue;
	}
	public void setBaseUnitValue(String baseUnitValue) {
		this.baseUnitValue = baseUnitValue;
	}
	public String getBaseUnit() {
		return baseUnit;
	}
	public void setBaseUnit(String baseUnit) {
		this.baseUnit = baseUnit;
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
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public String getForAll() {
		return forAll;
	}
	public void setForAll(String forAll) {
		this.forAll = forAll;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public Date getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(Date baseDate) {
		this.baseDate = baseDate;
	}
	
}
