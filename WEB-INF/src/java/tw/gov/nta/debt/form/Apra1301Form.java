package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Apra1301Form extends SupportForm {

	private static final long serialVersionUID = 1L;
	public Apra1301Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Date closeSdate;
	private Date closeEdate;
	public Date getCloseEdate() {
		return closeEdate;
	}
	public void setCloseEdate(Date closeEdate) {
		this.closeEdate = closeEdate;
	}
	public Date getCloseSdate() {
		return closeSdate;
	}
	public void setCloseSdate(Date closeSdate) {
		this.closeSdate = closeSdate;
	}
	
}
