package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the central_issue_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="central_issue_det"
 */

public abstract class BaseCentralIssueDet  implements Comparable, Serializable {

	public static String REF = "CentralIssueDet";
	public static String PROP_PRICE10000 = "Price10000";
	public static String PROP_FREE_AMOUNT = "FreeAmount";
	public static String PROP_PRICE10 = "Price10";
	public static String PROP_UNIT_CODE = "UnitCode";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_MOD_DATE = "ModDate";
	public static String PROP_PRICE5000 = "Price5000";
	public static String PROP_BID_AMOUNT = "BidAmount";
	public static String PROP_CREATE_DATE = "CreateDate";
	public static String PROP_PRICE1000 = "Price1000";
	public static String PROP_PRICE1 = "Price1";
	public static String PROP_PRICE500 = "Price500";
	public static String PROP_ISSUE_PRICE = "IssuePrice";
	public static String PROP_USE = "Use";
	public static String PROP_PRICE05 = "Price05";
	public static String PROP_GOTBID_RATE = "GotbidRate";
	public static String PROP_PRICE5 = "Price5";
	public static String PROP_ISSUE_SERIAL = "IssueSerial";
	public static String PROP_PRICE50000 = "Price50000";
	public static String PROP_PRICE100 = "Price100";
	public static String PROP_ISSUE_ID = "IssueId";
	public static String PROP_GOTBID_AMOUNT = "GotbidAmount";
	public static String PROP_PRICE50 = "Price50";
	public static String PROP_PRICE100000 = "Price100000";
	public static String PROP_ID = "id";


	// constructors
	public BaseCentralIssueDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCentralIssueDet (java.lang.Integer id) {
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
	private java.lang.Integer unitCode;
	private java.math.BigDecimal bidAmount;
	private java.math.BigDecimal gotbidAmount;
	private boolean use;
	private java.math.BigDecimal issuePrice;
	private java.math.BigDecimal freeAmount;
	private java.math.BigDecimal price10000;
	private java.math.BigDecimal price1000;
	private java.math.BigDecimal price500;
	private java.math.BigDecimal price100;
	private java.math.BigDecimal price50;
	private java.util.Date createDate;
	private java.util.Date modDate;
	private java.lang.String userId;
	private java.math.BigDecimal gotbidRate;
	private java.math.BigDecimal price05;
	private java.math.BigDecimal price1;
	private java.math.BigDecimal price5;
	private java.math.BigDecimal price10;
	private java.math.BigDecimal price5000;
	private java.math.BigDecimal price50000;
	private java.math.BigDecimal price100000;



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
	 * Return the value associated with the column: is_use
	 */
	public boolean isUse () {
		return use;
	}

	/**
	 * Set the value related to the column: is_use
	 * @param use the is_use value
	 */
	public void setUse (boolean use) {
		this.use = use;
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
	 * Return the value associated with the column: Free_amount
	 */
	public java.math.BigDecimal getFreeAmount () {
		return freeAmount;
	}

	/**
	 * Set the value related to the column: Free_amount
	 * @param freeAmount the Free_amount value
	 */
	public void setFreeAmount (java.math.BigDecimal freeAmount) {
		this.freeAmount = freeAmount;
	}



	/**
	 * Return the value associated with the column: price_10000
	 */
	public java.math.BigDecimal getPrice10000 () {
		return price10000;
	}

	/**
	 * Set the value related to the column: price_10000
	 * @param price10000 the price_10000 value
	 */
	public void setPrice10000 (java.math.BigDecimal price10000) {
		this.price10000 = price10000;
	}



	/**
	 * Return the value associated with the column: price_1000
	 */
	public java.math.BigDecimal getPrice1000 () {
		return price1000;
	}

	/**
	 * Set the value related to the column: price_1000
	 * @param price1000 the price_1000 value
	 */
	public void setPrice1000 (java.math.BigDecimal price1000) {
		this.price1000 = price1000;
	}



	/**
	 * Return the value associated with the column: price_500
	 */
	public java.math.BigDecimal getPrice500 () {
		return price500;
	}

	/**
	 * Set the value related to the column: price_500
	 * @param price500 the price_500 value
	 */
	public void setPrice500 (java.math.BigDecimal price500) {
		this.price500 = price500;
	}



	/**
	 * Return the value associated with the column: price_100
	 */
	public java.math.BigDecimal getPrice100 () {
		return price100;
	}

	/**
	 * Set the value related to the column: price_100
	 * @param price100 the price_100 value
	 */
	public void setPrice100 (java.math.BigDecimal price100) {
		this.price100 = price100;
	}



	/**
	 * Return the value associated with the column: price_50
	 */
	public java.math.BigDecimal getPrice50 () {
		return price50;
	}

	/**
	 * Set the value related to the column: price_50
	 * @param price50 the price_50 value
	 */
	public void setPrice50 (java.math.BigDecimal price50) {
		this.price50 = price50;
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



	/**
	 * Return the value associated with the column: gotbid_rate
	 */
	public java.math.BigDecimal getGotbidRate () {
		return gotbidRate;
	}

	/**
	 * Set the value related to the column: gotbid_rate
	 * @param gotbidRate the gotbid_rate value
	 */
	public void setGotbidRate (java.math.BigDecimal gotbidRate) {
		this.gotbidRate = gotbidRate;
	}



	/**
	 * Return the value associated with the column: price_05
	 */
	public java.math.BigDecimal getPrice05 () {
		return price05;
	}

	/**
	 * Set the value related to the column: price_05
	 * @param price05 the price_05 value
	 */
	public void setPrice05 (java.math.BigDecimal price05) {
		this.price05 = price05;
	}



	/**
	 * Return the value associated with the column: price_1
	 */
	public java.math.BigDecimal getPrice1 () {
		return price1;
	}

	/**
	 * Set the value related to the column: price_1
	 * @param price1 the price_1 value
	 */
	public void setPrice1 (java.math.BigDecimal price1) {
		this.price1 = price1;
	}



	/**
	 * Return the value associated with the column: price_5
	 */
	public java.math.BigDecimal getPrice5 () {
		return price5;
	}

	/**
	 * Set the value related to the column: price_5
	 * @param price5 the price_5 value
	 */
	public void setPrice5 (java.math.BigDecimal price5) {
		this.price5 = price5;
	}



	/**
	 * Return the value associated with the column: price_10
	 */
	public java.math.BigDecimal getPrice10 () {
		return price10;
	}

	/**
	 * Set the value related to the column: price_10
	 * @param price10 the price_10 value
	 */
	public void setPrice10 (java.math.BigDecimal price10) {
		this.price10 = price10;
	}



	/**
	 * Return the value associated with the column: price_5000
	 */
	public java.math.BigDecimal getPrice5000 () {
		return price5000;
	}

	/**
	 * Set the value related to the column: price_5000
	 * @param price5000 the price_5000 value
	 */
	public void setPrice5000 (java.math.BigDecimal price5000) {
		this.price5000 = price5000;
	}



	/**
	 * Return the value associated with the column: price_50000
	 */
	public java.math.BigDecimal getPrice50000 () {
		return price50000;
	}

	/**
	 * Set the value related to the column: price_50000
	 * @param price50000 the price_50000 value
	 */
	public void setPrice50000 (java.math.BigDecimal price50000) {
		this.price50000 = price50000;
	}



	/**
	 * Return the value associated with the column: price_100000
	 */
	public java.math.BigDecimal getPrice100000 () {
		return price100000;
	}

	/**
	 * Set the value related to the column: price_100000
	 * @param price100000 the price_100000 value
	 */
	public void setPrice100000 (java.math.BigDecimal price100000) {
		this.price100000 = price100000;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.CentralIssueDet)) return false;
		else {
			tw.gov.nta.sql.debt.CentralIssueDet centralIssueDet = (tw.gov.nta.sql.debt.CentralIssueDet) obj;
			if (null == this.getId() || null == centralIssueDet.getId()) return false;
			else return (this.getId().equals(centralIssueDet.getId()));
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