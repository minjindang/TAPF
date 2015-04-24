package tw.gov.nta.surplusage.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;

public class Gara1101Form extends GaraBaseForm {
	private static final long serialVersionUID = 1L;
	private String startYear;
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
	public String getStartYear()
	{
		return startYear;
	}
	public void setStartYear(String startYear)
	{
		if (startYear.length()<3){
			if(startYear.length()<2)
				startYear = "00"+startYear;
			else
				startYear = "0"+startYear;
		}
		this.startYear = startYear;
	}
	

}
