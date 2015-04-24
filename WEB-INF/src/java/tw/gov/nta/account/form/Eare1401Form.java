package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;

public class Eare1401Form extends SupportForm{
	
	private static final long serialVersionUID = 1L;

	private String convertDate;
	private String convertType;
	private String convertTiming;
	private String convertKind;
	
	public String getConvertDate() {
		return convertDate;
	}
	public void setConvertDate(String convertDate) {
		this.convertDate = convertDate;
	}
	public String getConvertKind() {
		return convertKind;
	}
	public void setConvertKind(String convertKind) {
		this.convertKind = convertKind;
	}
	public String getConvertTiming() {
		return convertTiming;
	}
	public void setConvertTiming(String convertTiming) {
		this.convertTiming = convertTiming;
	}
	public String getConvertType() {
		return convertType;
	}
	public void setConvertType(String convertType) {
		this.convertType = convertType;
	}
}
