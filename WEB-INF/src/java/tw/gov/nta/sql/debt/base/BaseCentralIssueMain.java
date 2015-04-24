package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the central_issue_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="central_issue_main"
 */

public abstract class BaseCentralIssueMain  implements Comparable, Serializable {

	public static String REF = "CentralIssueMain";
	public static String PROP_LOW_RATE = "LowRate";
	public static String PROP_MANAGER = "Manager";
	public static String PROP_MOD_DATE = "ModDate";
	public static String PROP_BID_AMOUNT = "BidAmount";
	public static String PROP_USERID = "Userid";
	public static String PROP_CREATE_DATE = "CreateDate";
	public static String PROP_ACCOUNT_YEAR = "AccountYear";
	public static String PROP_ISSUE_KIND = "IssueKind";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_ISSUE_AMOUNT = "IssueAmount";
	public static String PROP_HIGHT_RATE = "HightRate";
	public static String PROP_REACHBID_AMOUNT = "ReachbidAmount";
	public static String PROP_ISSUE_DAYS = "IssueDays";
	public static String PROP_DEBT_NAME = "DebtName";
	public static String PROP_AVERAGE_RATE = "AverageRate";
	public static String PROP_SELL_AMOUNT = "SellAmount";
	public static String PROP_BOND_TYPE = "BondType";
	public static String PROP_BID_RATE = "BidRate";
	public static String PROP_ISSUE_SERIAL = "IssueSerial";
	public static String PROP_TOTALBID_AMOUNT = "TotalbidAmount";
	public static String PROP_ISSUE_ID = "IssueId";
	public static String PROP_GOTBID_AMOUNT = "GotbidAmount";
	public static String PROP_DUE_DATE = "DueDate";
	public static String PROP_NOUSE_AMOUNT = "NouseAmount";
	public static String PROP_ID = "id";


	// constructors
	public BaseCentralIssueMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCentralIssueMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer issueId;
	private java.lang.String issueSerial;
	private java.util.Date dueDate;
	private java.lang.String debtName;
	private java.lang.Integer issueDays;
	private java.lang.String bondType;
	private java.lang.String issueKind;
	private java.lang.String accountYear;
	private java.util.Date issueDate;
	private java.math.BigDecimal bidAmount;
	private java.math.BigDecimal bidRate;
	private java.math.BigDecimal reachbidAmount;
	private java.math.BigDecimal gotbidAmount;
	private java.math.BigDecimal totalbidAmount;
	private java.math.BigDecimal lowRate;
	private java.math.BigDecimal hightRate;
	private java.math.BigDecimal averageRate;
	private java.math.BigDecimal sellAmount;
	private java.math.BigDecimal nouseAmount;
	private boolean manager;
	private java.util.Date createDate;
	private java.util.Date modDate;
	private java.lang.String userid;
	private java.math.BigDecimal issueAmount;



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
	 * Return the value associated with the column: bond_type
	 */
	public java.lang.String getBondType () {
		return bondType;
	}

	/**
	 * Set the value related to the column: bond_type
	 * @param bondType the bond_type value
	 */
	public void setBondType (java.lang.String bondType) {
		this.bondType = bondType;
	}



	/**
	 * Return the value associated with the column: issue_kind
	 */
	public java.lang.String getIssueKind () {
		return issueKind;
	}

	/**
	 * Set the value related to the column: issue_kind
	 * @param issueKind the issue_kind value
	 */
	public void setIssueKind (java.lang.String issueKind) {
		this.issueKind = issueKind;
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
	 * Return the value associated with the column: reachbid_amount
	 */
	public java.math.BigDecimal getReachbidAmount () {
		return reachbidAmount;
	}

	/**
	 * Set the value related to the column: reachbid_amount
	 * @param reachbidAmount the reachbid_amount value
	 */
	public void setReachbidAmount (java.math.BigDecimal reachbidAmount) {
		this.reachbidAmount = reachbidAmount;
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
	 * Return the value associated with the column: totalbid_amount
	 */
	public java.math.BigDecimal getTotalbidAmount () {
		return totalbidAmount;
	}

	/**
	 * Set the value related to the column: totalbid_amount
	 * @param totalbidAmount the totalbid_amount value
	 */
	public void setTotalbidAmount (java.math.BigDecimal totalbidAmount) {
		this.totalbidAmount = totalbidAmount;
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
	 * Return the value associated with the column: sell_amount
	 */
	public java.math.BigDecimal getSellAmount () {
		return sellAmount;
	}

	/**
	 * Set the value related to the column: sell_amount
	 * @param sellAmount the sell_amount value
	 */
	public void setSellAmount (java.math.BigDecimal sellAmount) {
		this.sellAmount = sellAmount;
	}



	/**
	 * Return the value associated with the column: nouse_amount
	 */
	public java.math.BigDecimal getNouseAmount () {
		return nouseAmount;
	}

	/**
	 * Set the value related to the column: nouse_amount
	 * @param nouseAmount the nouse_amount value
	 */
	public void setNouseAmount (java.math.BigDecimal nouseAmount) {
		this.nouseAmount = nouseAmount;
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
	 * Return the value associated with the column: userid
	 */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: userid
	 * @param userid the userid value
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.CentralIssueMain)) return false;
		else {
			tw.gov.nta.sql.debt.CentralIssueMain centralIssueMain = (tw.gov.nta.sql.debt.CentralIssueMain) obj;
			if (null == this.getId() || null == centralIssueMain.getId()) return false;
			else return (this.getId().equals(centralIssueMain.getId()));
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