package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Apra1401Form extends SupportForm {

	private static final long serialVersionUID = 1L;
	public Apra1401Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Date closeSdate;
	private Date closeEdate;
	private String bankName;
	private String bankCName;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
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
	public String getBankCName() {
		return bankCName;
	}
	public void setBankCName(String bankCName) {
		this.bankCName = bankCName;
	}
}
