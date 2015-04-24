package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the central_Debt_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="central_Debt_det"
 */

public abstract class BaseCentralDebtDet  implements Comparable, Serializable {

	public static String REF = "CentralDebtDet";
	public static String PROP_FILE_NO = "FileNo";
	public static String PROP_SELL_AMOUNT = "SellAmount";
	public static String PROP_FREE_AMOUNT = "FreeAmount";
	public static String PROP_UNIT_CODE = "UnitCode";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_MOD_DATE = "ModDate";
	public static String PROP_PAYMENT_ID = "PaymentId";
	public static String PROP_ISSUE_SERIAL = "IssueSerial";
	public static String PROP_CREATE_DATE = "CreateDate";
	public static String PROP_SELL_RATE = "SellRate";
	public static String PROP_ISSUE_ID = "IssueId";
	public static String PROP_ISSUE_PRICE = "IssuePrice";
	public static String PROP_ID = "id";


	// constructors
	public BaseCentralDebtDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCentralDebtDet (java.lang.Integer id) {
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
	private java.lang.Integer unitCode;
	private java.math.BigDecimal issuePrice;
	private java.math.BigDecimal sellRate;
	private java.math.BigDecimal sellAmount;
	private java.math.BigDecimal freeAmount;
	private java.util.Date createDate;
	private java.util.Date modDate;
	private java.lang.String userId;



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
	 * Return the value associated with the column: unit_code
	 */
	public java.lang.Integer getUnitCode () {
		return unitCode;
	}

	/**
	 * Set the value related to the column: unit_code
	 * @param unitCode the unit_code value
	 */
	public void setUnitCode (java.lang.Integer unitCode) {
		this.unitCode = unitCode;
	}



	/**
	 * Return the value associated with the column: issue_price
	 */
	public java.math.BigDecimal getIssuePrice () {
		return issuePrice;
	}

	/**
	 * Set the value related to the column: issue_price
	 * @param issuePrice the issue_price value
	 */
	public void setIssuePrice (java.math.BigDecimal issuePrice) {
		this.issuePrice = issuePrice;
	}



	/**
	 * Return the value associated with the column: sell_rate
	 */
	public java.math.BigDecimal getSellRate () {
		return sellRate;
	}

	/**
	 * Set the value related to the column: sell_rate
	 * @param sellRate the sell_rate value
	 */
	public void setSellRate (java.math.BigDecimal sellRate) {
		this.sellRate = sellRate;
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
	 * Return the value associated with the column: free_amount
	 */
	public java.math.BigDecimal getFreeAmount () {
		return freeAmount;
	}

	/**
	 * Set the value related to the column: free_amount
	 * @param freeAmount the free_amount value
	 */
	public void setFreeAmount (java.math.BigDecimal freeAmount) {
		this.freeAmount = freeAmount;
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
		if (!(obj instanceof tw.gov.nta.sql.debt.CentralDebtDet)) return false;
		else {
			tw.gov.nta.sql.debt.CentralDebtDet centralDebtDet = (tw.gov.nta.sql.debt.CentralDebtDet) obj;
			if (null == this.getId() || null == centralDebtDet.getId()) return false;
			else return (this.getId().equals(centralDebtDet.getId()));
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