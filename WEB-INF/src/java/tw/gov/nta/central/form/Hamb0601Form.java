/*
程式目的：HAMB06文字
程式代號：HAMB06
程式日期：0950220
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.central.form;

import java.util.List;

import tw.gov.nta.central.common.UnitAllocate;
import gov.dnt.tame.common.SupportForm;

public class Hamb0601Form extends SupportForm
{
	private static final long serialVersionUID = 1L;

	private String SUP_YEAR;
	private String SUP_MONTH;
	private String SUP_DATE;
	private String supCount;
	private String monKind;
	
    public String getMonKind() {
		return monKind;
	}
	public void setMonKind(String monKind) {
		this.monKind = monKind;
	}
	public String getSUP_MONTH()
    {
        return SUP_MONTH;
    }
    public void setSUP_MONTH(String sup_month)
    {
        SUP_MONTH = sup_month;
    }
    public String getSUP_YEAR()
    {
        return SUP_YEAR;
    }
    public void setSUP_YEAR(String sup_year)
    {
        SUP_YEAR = sup_year;
    }
	public String getSUP_DATE() {
		return SUP_DATE;
	}
	public void setSUP_DATE(String sup_date) {
		SUP_DATE = sup_date;
	}
	public String getSupCount()
	{
		return supCount;
	}
	public void setSupCount(String supCount)
	{
		this.supCount = supCount;
	}
	public List getSupYearList() {
        return UnitAllocate.getYearLabelList(getMonKind());
	}
	
	public List getSupMonthList() {
        return UnitAllocate.getMonthLabelWithYearList(getSUP_YEAR(),getMonKind());
	}
}