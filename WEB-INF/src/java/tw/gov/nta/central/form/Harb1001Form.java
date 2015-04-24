/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.central.form;

import java.util.List;

import tw.gov.nta.central.common.UnitAllocate;
import gov.dnt.tame.common.SupportForm;
public class Harb1001Form extends SupportForm
{
	private static final long serialVersionUID = 1L;
	private String supYear;
	private String supMonth;
	private String monKind;
	
	public String getMonKind() {
		return monKind;
	}
	public void setMonKind(String monKind) {
		this.monKind = monKind;
	}
	public String getSupMonth()
	{
		return supMonth;
	}
	public void setSupMonth(String supMonth)
	{
		this.supMonth = supMonth;
	}
	public String getSupYear()
	{
		return supYear;
	}
	public void setSupYear(String supYear)
	{
		this.supYear = supYear;
	}
	public List getSupYearList() {
        return UnitAllocate.getYearLabelList(getMonKind());
	}

	public List getSupMonthList() {
        return UnitAllocate.getMonthLabelWithYearList(getSupYear(),getMonKind());
	}
}
