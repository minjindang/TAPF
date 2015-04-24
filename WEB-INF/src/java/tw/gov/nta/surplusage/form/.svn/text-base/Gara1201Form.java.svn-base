package tw.gov.nta.surplusage.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;

public class Gara1201Form extends GaraBaseForm {
	private static final long serialVersionUID = 1L;
	private String issueYear;
	private BigDecimal amountUnit;
	private Date createDate;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public BigDecimal getAmountUnit() {
		return amountUnit;
	}
	public void setAmountUnit(BigDecimal amountUnit) {
		this.amountUnit = amountUnit;
	}
	public String getIssueYear() {
		return issueYear;
	}
	public void setIssueYear(String issueYear) {
		if (issueYear.length()<3){
			if(issueYear.length()<2)
				issueYear = "00"+issueYear;
			else
				issueYear = "0"+issueYear;
		}
		this.issueYear = issueYear;
	}
	
}
