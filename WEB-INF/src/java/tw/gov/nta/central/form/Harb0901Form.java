/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.central.form;

import gov.dnt.tame.common.SupportForm;

import java.util.List;

import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.system.common.CodeDetManage;
public class Harb0901Form extends SupportForm
{
	private static final long serialVersionUID = 1L;
	private String prtKind;
	private String minus;
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
	public String getMinus() {
		return minus;
	}
	public void setMinus(String minus) {
		this.minus = minus;
	}
	public String getPrtKind() {
		return prtKind;
	}
	public void setPrtKind(String prtKind) {
		this.prtKind = prtKind;
	}
	

	public List getSupYearList() {
        return UnitAllocate.getYearLabelList(getMonKind());
	}

	public List getSupMonthList() {
        return UnitAllocate.getMonthLabelWithYearList(getSupYear(),getMonKind());
	}
	//專案補助
	public List getPrtKindList() {
        return CodeDetManage.getCodeDet("CK");
	}
	//普通統籌
	public List getPrtKindList2() {
		return CodeDetManage.getCodeDet("CK1");
	}
}
