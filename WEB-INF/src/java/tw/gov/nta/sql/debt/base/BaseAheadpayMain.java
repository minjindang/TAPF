package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the aheadpay_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="aheadpay_main"
 */

public abstract class BaseAheadpayMain  implements Comparable, Serializable {

	public static String REF = "AheadpayMain";
	public static String PROP_FILE_NO = "fileNo";
	public static String PROP_LOW_RATE = "lowRate";
	public static String PROP_MANAGER = "manager";
	public static String PROP_USER_ID = "userId";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_BID_AMOUNT = "bidAmount";
	public static String PROP_AHEAD_DATE = "aheadDate";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_ACCOUNT_YEAR = "accountYear";
	public static String PROP_ISSUE_DATE = "issueDate";
	public static String PROP_ISSUE_AMOUNT = "issueAmount";
	public static String PROP_HIGHT_RATE = "hightRate";
	public static String PROP_ISSUE_DAYS = "issueDays";
	public static String PROP_DEBT_NAME = "debtName";
	public static String PROP_AVERAGE_RATE = "averageRate";
	public static String PROP_INTEREST_AMOUNT = "interestAmount";
	public static String PROP_BOND_TYPE = "bondType";
	public static String PROP_BID_RATE = "bidRate";
	public static String PROP_ISSUE_SERIAL = "issueSerial";
	public static String PROP_PAYMENT_ID = "paymentId";
	public static String PROP_ORGISSUE_AMOUNT = "orgissueAmount";
	public static String PROP_ISSUE_ID = "issueId";
	public static String PROP_GOTBID_AMOUNT = "gotbidAmount";
	public static String PROP_DUE_DATE = "dueDate";
	public static String PROP_ID = "id";


	// constructors
	public BaseAheadpayMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAheadpayMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer issueId;
	private java.lang.Integer paymentId;
	private java.lang.String fileNo;
	private java.lang.String issueSerial;
	private java.lang.Integer bondType;
	private java.lang.String accountYear;
	private java.util.Date issueDate;
	private java.math.BigDecimal issueAmount;
	private java.math.BigDecimal bidAmount;
	private java.math.BigDecimal bidRate;
	private java.math.BigDecimal gotbidAmount;
	private java.math.BigDecimal orgissueAmount;
	private java.math.BigDecimal interestAmount;
	private java.math.BigDecimal lowRate;
	private java.math.BigDecimal hightRate;
	private java.math.BigDecimal averageRate;
	private java.util.Date dueDate;
	private java.lang.String debtName;
	private java.lang.Integer issueDays;
	private java.util.Date aheadDate;
	private boolean manager;
	private java.util.Date createDate;
	private java.util.Date modDate;
	private java.lang.String userId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IdentityGenerator"
     *  column="id"
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




	/**
	 * Return the value associated with the column: issue_id
	 */
	public java.lang.Integer getIssueId () {
		return issueId;
	}

	/**
	 * Set the value related to the column: issue_id
	 * @param issueId the issue_id value
	 */
	public void setIssueId (java.lang.Integer issueId) {
		this.issueId = issueId;
	}



	/**
	 * Return the value associated with the column: payment_id
	 */
	public java.lang.Integer getPaymentId () {
		return paymentId;
	}

	/**
	 * Set the value related to the column: payment_id
	 * @param paymentId the payment_id value
	 */
	public void setPaymentId (java.lang.Integer paymentId) {
		this.paymentId = paymentId;
	}



	/**
	 * Return the value associated with the column: file_no
	 */
	public java.lang.String getFileNo () {
		return fileNo;
	}

	/**
	 * Set the value related to the column: file_no
	 * @param fileNo the file_no value
	 */
	public void setFileNo (java.lang.String fileNo) {
		this.fileNo = fileNo;
	}



	/**
	 * Return the value associated with the column: issue_serial
	 */
	public java.lang.String getIssueSerial () {
		return issueSerial;
	}

	/**
	 * Set the value related to the column: issue_serial
	 * @param issueSerial the issue_serial value
	 */
	public void setIssueSerial (java.lang.String issueSerial) {
		this.issueSerial = issueSerial;
	}



	/**
	 * Return the value associated with the column: bond_type
	 */
	public java.lang.Integer getBondType () {
		return bondType;
	}

	/**
	 * Set the value related to the column: bond_type
	 * @param bondType the bond_type value
	 */
	public void setBondType (java.lang.Integer bondType) {
		this.bondType = bondType;
	}



	/**
	 * Return the value associated with the column: account_year
	 */
	public java.lang.String getAccountYear () {
		return accountYear;
	}

	/**
	 * Set the value related to the column: account_year
	 * @param accountYear the account_year value
	 */
	public void setAccountYear (java.lang.String accountYear) {
		this.accountYear = accountYear;
	}



	/**
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate () {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * @param issueDate the issue_date value
	 */
	public void setIssueDate (java.util.Date issueDate) {
		this.issueDate = issueDate;
	}



	/**
	 * Return the value associated with the column: issue_amount
	 */
	public java.math.BigDecimal getIssueAmount () {
		return issueAmount;
	}

	/**
	 * Set the value related to the column: issue_amount
	 * @param issueAmount the issue_amount value
	 */
	public void setIssueAmount (java.math.BigDecimal issueAmount) {
		this.issueAmount = issueAmount;
	}



	/**
	 * Return the value associated with the column: bid_amount
	 */
	public java.math.BigDecimal getBidAmount () {
		return bidAmount;
	}

	/**
	 * Set the value related to the column: bid_amount
	 * @param bidAmount the bid_amount value
	 */
	public void setBidAmount (java.math.BigDecimal bidAmount) {
		this.bidAmount = bidAmount;
	}



	/**
	 * Return the value associated with the column: bid_rate
	 */
	public java.math.BigDecimal getBidRate () {
		return bidRate;
	}

	/**
	 * Set the value related to the column: bid_rate
	 * @param bidRate the bid_rate value
	 */
	public void setBidRate (java.math.BigDecimal bidRate) {
		this.bidRate = bidRate;
	}



	/**
	 * Return the value associated with the column: gotbid_amount
	 */
	public java.math.BigDecimal getGotbidAmount () {
		return gotbidAmount;
	}

	/**
	 * Set the value related to the column: gotbid_amount
	 * @param gotbidAmount the gotbid_amount value
	 */
	public void setGotbidAmount (java.math.BigDecimal gotbidAmount) {
		this.gotbidAmount = gotbidAmount;
	}



	/**
	 * Return the value associated with the column: orgissue_amount
	 */
	public java.math.BigDecimal getOrgissueAmount () {
		return orgissueAmount;
	}

	/**
	 * Set the value related to the column: orgissue_amount
	 * @param orgissueAmount the orgissue_amount value
	 */
	public void setOrgissueAmount (java.math.BigDecimal orgissueAmount) {
		this.orgissueAmount = orgissueAmount;
	}



	/**
	 * Return the value associated with the column: interest_amount
	 */
	public java.math.BigDecimal getInterestAmount () {
		return interestAmount;
	}

	/**
	 * Set the value related to the column: interest_amount
	 * @param interestAmount the interest_amount value
	 */
	public void setInterestAmount (java.math.BigDecimal interestAmount) {
		this.interestAmount = interestAmount;
	}



	/**
	 * Return the value associated with the column: low_rate
	 */
	public java.math.BigDecimal getLowRate () {
		return lowRate;
	}

	/**
	 * Set the value related to the column: low_rate
	 * @param lowRate the low_rate value
	 */
	public void setLowRate (java.math.BigDecimal lowRate) {
		this.lowRate = lowRate;
	}



	/**
	 * Return the value associated with the column: hight_rate
	 */
	public java.math.BigDecimal getHightRate () {
		return hightRate;
	}

	/**
	 * Set the value related to the column: hight_rate
	 * @param hightRate the hight_rate value
	 */
	public void setHightRate (java.math.BigDecimal hightRate) {
		this.hightRate = hightRate;
	}



	/**
	 * Return the value associated with the column: average_rate
	 */
	public java.math.BigDecimal getAverageRate () {
		return averageRate;
	}

	/**
	 * Set the value related to the column: average_rate
	 * @param averageRate the average_rate value
	 */
	public void setAverageRate (java.math.BigDecimal averageRate) {
		this.averageRate = averageRate;
	}



	/**
	 * Return the value associated with the column: due_date
	 */
	public java.util.Date getDueDate () {
		return dueDate;
	}

	/**
	 * Set the value related to the column: due_date
	 * @param dueDate the due_date value
	 */
	public void setDueDate (java.util.Date dueDate) {
		this.dueDate = dueDate;
	}



	/**
	 * Return the value associated with the column: debt_name
	 */
	public java.lang.String getDebtName () {
		return debtName;
	}

	/**
	 * Set the value related to the column: debt_name
	 * @param debtName the debt_name value
	 */
	public void setDebtName (java.lang.String debtName) {
		this.debtName = debtName;
	}



	/**
	 * Return the value associated with the column: issue_days
	 */
	public java.lang.Integer getIssueDays () {
		return issueDays;
	}

	/**
	 * Set the value related to the column: issue_days
	 * @param issueDays the issue_days value
	 */
	public void setIssueDays (java.lang.Integer issueDays) {
		this.issueDays = issueDays;
	}



	/**
	 * Return the value associated with the column: ahead_date
	 */
	public java.util.Date getAheadDate () {
		return aheadDate;
	}

	/**
	 * Set the value related to the column: ahead_date
	 * @param aheadDate the ahead_date value
	 */
	public void setAheadDate (java.util.Date aheadDate) {
		this.aheadDate = aheadDate;
	}



	/**
	 * Return the value associated with the column: is_manager
	 */
	public boolean isManager () {
		return manager;
	}

	/**
	 * Set the value related to the column: is_manager
	 * @param manager the is_manager value
	 */
	public void setManager (boolean manager) {
		this.manager = manager;
	}



	/**
	 * Return the value associated with the column: create_date
	 */
	public java.util.Date getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: create_date
	 * @param createDate the create_date value
	 */
	public void setCreateDate (java.util.Date createDate) {
		this.createDate = createDate;
	}



	/**
	 * Return the value associated with the column: mod_date
	 */
	public java.util.Date getModDate () {
		return modDate;
	}

	/**
	 * Set the value related to the column: mod_date
	 * @param modDate the mod_date value
	 */
	public void setModDate (java.util.Date modDate) {
		this.modDate = modDate;
	}



	/**
	 * Return the value associated with the column: userId
	 */
	public java.lang.String getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: userId
	 * @param userId the userId value
	 */
	public void setUserId (java.lang.String userId) {
		this.userId = userId;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.AheadpayMain)) return false;
		else {
			tw.gov.nta.sql.debt.AheadpayMain aheadpayMain = (tw.gov.nta.sql.debt.AheadpayMain) obj;
			if (null == this.getId() || null == aheadpayMain.getId()) return false;
			else return (this.getId().equals(aheadpayMain.getId()));
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