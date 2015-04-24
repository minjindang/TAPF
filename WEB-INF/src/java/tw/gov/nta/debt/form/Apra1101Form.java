package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Apra1101Form extends SupportForm {

	private static final long serialVersionUID = 1L;
	private Date closeSdate;
	private Date closeEdate;
	private String bankName;
	private Integer bankId;
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
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
