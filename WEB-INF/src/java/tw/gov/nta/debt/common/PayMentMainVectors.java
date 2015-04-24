package tw.gov.nta.debt.common;


public class PayMentMainVectors {
	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String isRepay;
	private java.lang.String repayDate;

	public String getIsRepay() {
		return isRepay;
	}
	public void setIsRepay(String isRepay) {
		if( "on".equals( isRepay ) )
			this.isRepay = "Y";
		else
			this.isRepay = "N";
	}
	public String getRepayDate() {
		return repayDate;
	}
	public void setRepayDate(String repayDate) {
		this.repayDate = repayDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
