package tw.gov.nta.surplusage.form;

import gov.dnt.tame.common.SupportForm;

public class Gara1701Form extends GaraBaseForm {
	private static final long serialVersionUID = 1L;

	public Gara1701Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String issueYear;
	private String amountUnit;
	private String amountUnitLabel;
	public String getAmountUnit() {
		return amountUnit;
	}
	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}
	public String getIssueYear() {
		return issueYear;
	}
	public void setIssueYear(String issueYear) {
		issueYear=issueYear.trim();
		if (issueYear.length() < 3 && !"".equals(issueYear)){
			for (int i = 0 ; i < 3-issueYear.length() ; i++){
				issueYear = "0" + issueYear;
			}	
		}
		this.issueYear = issueYear;
	}
	public String getAmountUnitLabel() {
		return amountUnitLabel;
	}
	public void setAmountUnitLabel(String amountUnitLabel) {
		this.amountUnitLabel = amountUnitLabel;
	}
	
}
