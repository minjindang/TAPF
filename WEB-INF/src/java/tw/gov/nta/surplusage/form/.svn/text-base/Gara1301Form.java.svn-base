package tw.gov.nta.surplusage.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Gara1301Form extends GaraBaseForm {
	private static final long serialVersionUID = 1L;

	public Gara1301Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String issueSdate;
	private String issueEdate;
	private String amountUnit;
	private String amountUnitLabel;
	private Date createDate;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getAmountUnit() {
		return amountUnit;
	}
	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}
	public String getIssueEdate() {
		return issueEdate;
	}
	public void setIssueEdate(String issueEdate) {
		issueEdate=issueEdate.trim();
		if (issueEdate.length() < 3 && !"".equals(issueEdate)){
			for (int i = 0 ; i < 3-issueEdate.length() ; i++){
				issueEdate = "0" + issueEdate;
			}	
		}
		this.issueEdate = issueEdate;
	}
	public String getIssueSdate() {
		return issueSdate;
	}
	public void setIssueSdate(String issueSdate) {
		issueSdate=issueSdate.trim();
		if (issueSdate.length() < 3 && !"".equals(issueSdate)){
			for (int i = 0 ; i < 3-issueSdate.length() ; i++){
				issueSdate = "0" + issueSdate;
			}	
		}
		this.issueSdate = issueSdate;
	}
	public String getAmountUnitLabel() {
		return amountUnitLabel;
	}
	public void setAmountUnitLabel(String amountUnitLabel) {
		this.amountUnitLabel = amountUnitLabel;
	}
}
