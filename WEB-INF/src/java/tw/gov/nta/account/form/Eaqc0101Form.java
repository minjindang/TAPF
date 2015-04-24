package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;

public class Eaqc0101Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String accountYear;
	private Integer month;
	private Integer issueId;
	private String voucherType;
	private String post;
	private int page;
	public String getAccountYear() {
		return accountYear;
	}
	public void setAccountYear(String accountYear) {
		this.accountYear = accountYear;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getVoucherType() {
		return voucherType;
	}
	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

}
