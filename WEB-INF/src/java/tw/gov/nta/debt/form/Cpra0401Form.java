package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Cpra0401Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	public Cpra0401Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String  baseDate;
	public String getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}
}
