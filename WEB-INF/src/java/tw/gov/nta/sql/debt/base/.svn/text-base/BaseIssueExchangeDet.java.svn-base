package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the issue_exchange_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="issue_exchange_det"
 */

public abstract class BaseIssueExchangeDet  implements Comparable, Serializable {

	public static String REF = "IssueExchangeDet";
	public static String PROP_GET_PRICE = "getPrice";
	public static String PROP_LIBERATE_STOCK_AMOUNT = "liberateStockAmount";
	public static String PROP_ISSUE = "issue";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_ORIGINAL_PRICE = "originalPrice";
	public static String PROP_EXCHANGE_STOCK_AMOUNT = "exchangeStockAmount";
	public static String PROP_USERID = "userid";
	public static String PROP_EXCHANGE_AMOUNT = "exchangeAmount";
	public static String PROP_BANK_CODE = "bankCode";
	public static String PROP_SALE_RATE = "saleRate";
	public static String PROP_FOREIGN_CAPITAL = "foreignCapital";
	public static String PROP_BACK_RATE = "backRate";
	public static String PROP_EXCHANGE_STOCK_CODE = "exchangeStockCode";
	public static String PROP_EXCHANGE_LESS_AMOUNT = "exchangeLessAmount";
	public static String PROP_ID = "id";
	public static String PROP_TOTAL_STOCK_AMOUNT = "totalStockAmount";


	// constructors
	public BaseIssueExchangeDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIssueExchangeDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseIssueExchangeDet (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.IssueMain issue) {

		this.setId(id);
		this.setIssue(issue);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal totalStockAmount;
	private java.math.BigDecimal getPrice;
	private java.math.BigDecimal backRate;
	private java.math.BigDecimal saleRate;
	private java.math.BigDecimal foreignCapital;
	private java.lang.Integer exchangeStockCode;
	private java.math.BigDecimal originalPrice;
	private java.lang.Integer bankCode;
	private java.math.BigDecimal exchangeStockAmount;
	private java.math.BigDecimal liberateStockAmount;
	private java.math.BigDecimal exchangeAmount;
	private java.math.BigDecimal exchangeLessAmount;
	private java.lang.String userid;
	private java.util.Date modDate;

	// many to one
	private tw.gov.nta.sql.debt.IssueMain issue;



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
	 * Return the value associated with the column: TOTAL_STOCK_AMOUNT
	 */
	public java.math.BigDecimal getTotalStockAmount () {
		return totalStockAmount;
	}

	/**
	 * Set the value related to the column: TOTAL_STOCK_AMOUNT
	 * @param totalStockAmount the TOTAL_STOCK_AMOUNT value
	 */
	public void setTotalStockAmount (java.math.BigDecimal totalStockAmount) {
		this.totalStockAmount = totalStockAmount;
	}



	/**
	 * Return the value associated with the column: GET_PRICE
	 */
	public java.math.BigDecimal getGetPrice () {
		return getPrice;
	}

	/**
	 * Set the value related to the column: GET_PRICE
	 * @param getPrice the GET_PRICE value
	 */
	public void setGetPrice (java.math.BigDecimal getPrice) {
		this.getPrice = getPrice;
	}



	/**
	 * Return the value associated with the column: BACK_RATE
	 */
	public java.math.BigDecimal getBackRate () {
		return backRate;
	}

	/**
	 * Set the value related to the column: BACK_RATE
	 * @param backRate the BACK_RATE value
	 */
	public void setBackRate (java.math.BigDecimal backRate) {
		this.backRate = backRate;
	}



	/**
	 * Return the value associated with the column: SALE_RATE
	 */
	public java.math.BigDecimal getSaleRate () {
		return saleRate;
	}

	/**
	 * Set the value related to the column: SALE_RATE
	 * @param saleRate the SALE_RATE value
	 */
	public void setSaleRate (java.math.BigDecimal saleRate) {
		this.saleRate = saleRate;
	}



	/**
	 * Return the value associated with the column: FOREIGN_CAPITAL
	 */
	public java.math.BigDecimal getForeignCapital () {
		return foreignCapital;
	}

	/**
	 * Set the value related to the column: FOREIGN_CAPITAL
	 * @param foreignCapital the FOREIGN_CAPITAL value
	 */
	public void setForeignCapital (java.math.BigDecimal foreignCapital) {
		this.foreignCapital = foreignCapital;
	}



	/**
	 * Return the value associated with the column: EXCHANGE_STOCK_CODE
	 */
	public java.lang.Integer getExchangeStockCode () {
		return exchangeStockCode;
	}

	/**
	 * Set the value related to the column: EXCHANGE_STOCK_CODE
	 * @param exchangeStockCode the EXCHANGE_STOCK_CODE value
	 */
	public void setExchangeStockCode (java.lang.Integer exchangeStockCode) {
		this.exchangeStockCode = exchangeStockCode;
	}



	/**
	 * Return the value associated with the column: ORIGINAL_PRICE
	 */
	public java.math.BigDecimal getOriginalPrice () {
		return originalPrice;
	}

	/**
	 * Set the value related to the column: ORIGINAL_PRICE
	 * @param originalPrice the ORIGINAL_PRICE value
	 */
	public void setOriginalPrice (java.math.BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}



	/**
	 * Return the value associated with the column: BANK_CODE
	 */
	public java.lang.Integer getBankCode () {
		return bankCode;
	}

	/**
	 * Set the value related to the column: BANK_CODE
	 * @param bankCode the BANK_CODE value
	 */
	public void setBankCode (java.lang.Integer bankCode) {
		this.bankCode = bankCode;
	}



	/**
	 * Return the value associated with the column: EXCHANGE_STOCK_AMOUNT
	 */
	public java.math.BigDecimal getExchangeStockAmount () {
		return exchangeStockAmount;
	}

	/**
	 * Set the value related to the column: EXCHANGE_STOCK_AMOUNT
	 * @param exchangeStockAmount the EXCHANGE_STOCK_AMOUNT value
	 */
	public void setExchangeStockAmount (java.math.BigDecimal exchangeStockAmount) {
		this.exchangeStockAmount = exchangeStockAmount;
	}



	/**
	 * Return the value associated with the column: LIBERATE_STOCK_AMOUNT
	 */
	public java.math.BigDecimal getLiberateStockAmount () {
		return liberateStockAmount;
	}

	/**
	 * Set the value related to the column: LIBERATE_STOCK_AMOUNT
	 * @param liberateStockAmount the LIBERATE_STOCK_AMOUNT value
	 */
	public void setLiberateStockAmount (java.math.BigDecimal liberateStockAmount) {
		this.liberateStockAmount = liberateStockAmount;
	}



	/**
	 * Return the value associated with the column: EXCHANGE_AMOUNT
	 */
	public java.math.BigDecimal getExchangeAmount () {
		return exchangeAmount;
	}

	/**
	 * Set the value related to the column: EXCHANGE_AMOUNT
	 * @param exchangeAmount the EXCHANGE_AMOUNT value
	 */
	public void setExchangeAmount (java.math.BigDecimal exchangeAmount) {
		this.exchangeAmount = exchangeAmount;
	}



	/**
	 * Return the value associated with the column: EXCHANGE_LESS_AMOUNT
	 */
	public java.math.BigDecimal getExchangeLessAmount () {
		return exchangeLessAmount;
	}

	/**
	 * Set the value related to the column: EXCHANGE_LESS_AMOUNT
	 * @param exchangeLessAmount the EXCHANGE_LESS_AMOUNT value
	 */
	public void setExchangeLessAmount (java.math.BigDecimal exchangeLessAmount) {
		this.exchangeLessAmount = exchangeLessAmount;
	}



	/**
	 * Return the value associated with the column: USERID
	 */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: USERID
	 * @param userid the USERID value
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
	}



	/**
	 * Return the value associated with the column: MOD_DATE
	 */
	public java.util.Date getModDate () {
		return modDate;
	}

	/**
	 * Set the value related to the column: MOD_DATE
	 * @param modDate the MOD_DATE value
	 */
	public void setModDate (java.util.Date modDate) {
		this.modDate = modDate;
	}



	/**
	 * Return the value associated with the column: ISSUE_ID
	 */
	public tw.gov.nta.sql.debt.IssueMain getIssue () {
		return issue;
	}

	/**
	 * Set the value related to the column: ISSUE_ID
	 * @param issue the ISSUE_ID value
	 */
	public void setIssue (tw.gov.nta.sql.debt.IssueMain issue) {
		this.issue = issue;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.IssueExchangeDet)) return false;
		else {
			tw.gov.nta.sql.debt.IssueExchangeDet issueExchangeDet = (tw.gov.nta.sql.debt.IssueExchangeDet) obj;
			if (null == this.getId() || null == issueExchangeDet.getId()) return false;
			else return (this.getId().equals(issueExchangeDet.getId()));
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