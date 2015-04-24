package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Cpra0501Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	public Cpra0501Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer id;
	private Date startDate;
	private Date endDate;

	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
}
