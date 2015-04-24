package tw.gov.nta.sql.base;
import gov.dnt.tame.util.DateUtil;

import java.lang.Comparable;
import java.io.Serializable;
public abstract class BaseNationalDebtDueDateMain implements Comparable, Serializable{
	public static String REF = "NationalDebtDueDateMain";
	public static String PROP_ISSUE_ID = "isseId";
	public static String PROP_Plan_ID = "planId";
	public static String PROP_REPAY_DATE = "repayDate";
	public static String PROP_DEBT_NAME = "debtName";
	public static String PROP_CAPITAL_SERIAL = "capitalSerial";
	public static String PROP_INTEREST_SERIAL = "interestSerial";
	public static String PROP_CAPITAL_AMOUNT = "capitalAmount";
	public static String PROP_INTEREST_AMOUNT = "interestAmount";
	public static String PROP_REPAY_HANDLE = "repayHandle";
	public static String PROP_REPAY_NUMBER = "repayNumber";
	public static String PROP_ACCOUNT_DATE = "accountDate";
	public static String PROP_ACCOUNT_NUMBER = "accountNumber";
	public static String PROP_FUND_NUMBER = "fundNumber";
	public static String PROP_SECRETARY_DATE = "secretaryDate";
	public static String PROP_ID = "id";	


	// constructors
	public BaseNationalDebtDueDateMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNationalDebtDueDateMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}



	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private Integer isseId;
	private Integer planId;
	private java.util.Date repayDate;
	private java.lang.String debtName;
	private Integer capitalSerial;
	private Integer interestSerial;
	private java.math.BigDecimal capitalAmount;
	private java.math.BigDecimal interestAmount;
	private java.util.Date repayHandle;
	private java.lang.String repayNumber;
	private java.util.Date accountDate;
	private java.lang.String accountNumber;
	private java.lang.String fundNumber;
	private java.util.Date secretaryDate;
	private Integer state;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IdentityGenerator"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}


	public java.util.Date getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(java.util.Date accountDate) {
		this.accountDate = accountDate;
	}

	public java.lang.String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(java.lang.String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public java.math.BigDecimal getCapitalAmount() {
		return capitalAmount;
	}

	public void setCapitalAmount(java.math.BigDecimal capitalAmount) {
		this.capitalAmount = capitalAmount;
	}

	public Integer getCapitalSerial() {
		return capitalSerial;
	}

	public void setCapitalSerial(Integer capitalSerial) {
		this.capitalSerial = capitalSerial;
	}

	public java.lang.String getDebtName() {
		return debtName;
	}

	public void setDebtName(java.lang.String debtName) {
		this.debtName = debtName;
	}

	public java.lang.String getFundNumber() {
		return fundNumber;
	}

	public void setFundNumber(java.lang.String fundNumber) {
		this.fundNumber = fundNumber;
	}

	public java.math.BigDecimal getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(java.math.BigDecimal interestAmount) {
		this.interestAmount = interestAmount;
	}

	public Integer getInterestSerial() {
		return interestSerial;
	}

	public void setInterestSerial(Integer interestSerial) {
		this.interestSerial = interestSerial;
	}

	public Integer getIsseId() {
		return isseId;
	}

	public void setIsseId(Integer isseId) {
		this.isseId = isseId;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer paymentId) {
		this.planId = paymentId;
	}

	public java.util.Date getRepayDate() {
		//return DateUtil.date2ROCStr(repayDate);
		return repayDate;
	}

	public void setRepayDate(java.util.Date repayDate) {
		//this.repayDate = DateUtil.str2Date(repayDate);
		this.repayDate = repayDate;
	}

	public java.util.Date getRepayHandle() {
		return repayHandle;
	}

	public void setRepayHandle(java.util.Date repayHandle) {
		this.repayHandle = repayHandle;
	}

	public java.lang.String getRepayNumber() {
		return repayNumber;
	}

	public void setRepayNumber(java.lang.String repayNumber) {
		this.repayNumber = repayNumber;
	}

	public java.util.Date getSecretaryDate() {
		return secretaryDate;
	}

	public void setSecretaryDate(java.util.Date secretaryDate) {
		this.secretaryDate = secretaryDate;
	}
	
	

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.TaxactionDet)) return false;
		else {
			tw.gov.nta.sql.TaxactionDet taxactionDet = (tw.gov.nta.sql.TaxactionDet) obj;
			if (null == this.getId() || null == taxactionDet.getId()) return false;
			else return (this.getId().equals(taxactionDet.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}
}
