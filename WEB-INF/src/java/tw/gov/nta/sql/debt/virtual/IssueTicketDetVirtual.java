package tw.gov.nta.sql.debt.virtual;

import java.math.BigDecimal;
import java.util.Date;

import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;

	public class IssueTicketDetVirtual extends IssueTicketDet {

	private static final long serialVersionUID = 1L;
	private IssueTicketDet issueTicketDet = null;
	
	public IssueTicketDetVirtual(IssueTicketDet pIssueTicketDet){
		issueTicketDet = pIssueTicketDet;
	}
	
	public BigDecimal getTotalAmount(){
		if(getTicketAmount() != null && getTicketCount() != null)
			return getTicketAmount().multiply(new BigDecimal(getTicketCount()));
		return
			null;
	}

	public int compareTo(Object obj) {
		return issueTicketDet.compareTo(obj);
	}

	public boolean equals(Object obj) {
		return issueTicketDet.equals(obj);
	}

	public Integer getId() {
		return issueTicketDet.getId();
	}

	public IssueMain getIssue() {
		return issueTicketDet.getIssue();
	}

	public Date getModDate() {
		return issueTicketDet.getModDate();
	}

	public BigDecimal getTicketAmount() {
		return issueTicketDet.getTicketAmount();
	}

	public Long getTicketCount() {
		return issueTicketDet.getTicketCount();
	}

	public String getTicketName() {
		return issueTicketDet.getTicketName();
	}

	public String getUserid() {
		return issueTicketDet.getUserid();
	}

	public int hashCode() {
		return issueTicketDet.hashCode();
	}

	public void setId(Integer id) {
		issueTicketDet.setId(id);
	}

	public void setIssue(IssueMain issue) {
		issueTicketDet.setIssue(issue);
	}

	public void setModDate(Date modDate) {
		issueTicketDet.setModDate(modDate);
	}

	public void setTicketAmount(BigDecimal ticketAmount) {
		issueTicketDet.setTicketAmount(ticketAmount);
	}

	public void setTicketCount(Long ticketCount) {
		issueTicketDet.setTicketCount(ticketCount);
	}

	public void setTicketName(String ticketName) {
		issueTicketDet.setTicketName(ticketName);
	}

	public void setUserid(String userid) {
		issueTicketDet.setUserid(userid);
	}

	public String toString() {
		return issueTicketDet.toString();
	}

	public IssueTicketDet getIssueTicketDet() {
		return issueTicketDet;
	}

	public void setIssueTicketDet(IssueTicketDet issueTicketDet) {
		this.issueTicketDet = issueTicketDet;
	}
}
