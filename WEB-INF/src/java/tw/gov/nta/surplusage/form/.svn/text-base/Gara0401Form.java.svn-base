package tw.gov.nta.surplusage.form;

import tw.gov.nta.sql.debt.GaraNote;
import gov.dnt.tame.common.SupportForm;

public class Gara0401Form extends GaraBaseForm {
	private static final long serialVersionUID = 1L;
	private String startYear;
	private String endYear;
	private String amountUnit;
//	private String memo;
//	
//	public String getMemo() {
//		return memo;
//	}
//	public void setMemo(String memo) {
//		this.memo = memo;
//	}
	public String getAmountUnit() {
		return amountUnit;
	}
	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}
	public String getEndYear()
	{
		return endYear;
	}
	public void setEndYear(String endYear)
	{
		if (endYear.length()<3 && !"".equals(endYear.trim())){
			if(endYear.length()<2)
				endYear = "00"+endYear;
			else
				endYear = "0"+endYear;
		}
		this.endYear = endYear.trim();
	}
	public String getStartYear()
	{
		return startYear;
	}
	public void setStartYear(String startYear)
	{
		if (startYear.length()<3 && !"".equals(startYear.trim())){
			if(startYear.length()<2)
				startYear = "00"+startYear;
			else
				startYear = "0"+startYear;
		}
		this.startYear = startYear.trim();
	}
	

}
