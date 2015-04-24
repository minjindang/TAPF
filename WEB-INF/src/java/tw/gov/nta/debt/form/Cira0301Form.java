package tw.gov.nta.debt.form;

import java.util.Date;
import java.util.List;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

public class Cira0301Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	public Cira0301Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String status;
	private String startYear;
	private String endYear;
	private Date startDate;
	private Date endDate;
	private String budgetCode;
	private String debtCode;
	private String startSerial;
	private String endSerial;
	private String baseUnit;
	private String bankCode;
	private String baseUnitValue;
	private String showType;
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
	public String getEndSerial() {
		return endSerial;
	}
	public void setEndSerial(String endSerial) {
		this.endSerial = endSerial;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getStartSerial() {
		return startSerial;
	}
	public void setStartSerial(String startSerial) {
		this.startSerial = startSerial;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBaseUnitValue() {
		return baseUnitValue;
	}
	public void setBaseUnitValue(String baseUnitValue) {
		this.baseUnitValue = baseUnitValue;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getShowType() {
		return showType;
	}
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public List getTypeList()
	{
        return new ListToolManager().getList("select codeDet.codeNo , codeDet.codeName from CodeDet codeDet where codeDet.kind.kindNo = 'YMD' order by codeDet.codeName ");
	}
	
}
