package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the central_exchange_month table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="central_exchange_month"
 */

public abstract class BaseCentralExchangeMonth  implements Comparable, Serializable {

	public static String REF = "CentralExchangeMonth";
	public static String PROP_USRID = "usrid";
	public static String PROP_EXG_STOCK = "exgStock";
	public static String PROP_REMARK = "remark";
	public static String PROP_EXG_AMOUNT = "exgAmount";
	public static String PROP_BANK_ID = "bankId";
	public static String PROP_ISSUE_ID = "issueId";
	public static String PROP_TERM_YM = "termYm";
	public static String PROP_TOTAL_LESS_AMOUNT = "totalLessAmount";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_EXG_LESS_AMOUNT = "exgLessAmount";
	public static String PROP_ID = "id";


	// constructors
	public BaseCentralExchangeMonth () {
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.Integer id;
	private java.lang.Integer usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;
	private java.lang.String issueId;
	private java.lang.String bankId;
	private java.math.BigDecimal exgStock;
	private java.math.BigDecimal exgAmount;
	private java.math.BigDecimal exgLessAmount;
	private java.math.BigDecimal totalLessAmount;
	private java.lang.String termYm;






	/**
	 * Return the value associated with the column: id
	 */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the value related to the column: id
	 * @param id the id value
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: usrid
	 */
	public java.lang.Integer getUsrid () {
		return usrid;
	}

	/**
	 * Set the value related to the column: usrid
	 * @param usrid the usrid value
	 */
	public void setUsrid (java.lang.Integer usrid) {
		this.usrid = usrid;
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
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: create_Date
	 */
	public java.util.Date getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: create_Date
	 * @param createDate the create_Date value
	 */
	public void setCreateDate (java.util.Date createDate) {
		this.createDate = createDate;
	}



	/**
	 * Return the value associated with the column: issue_id
	 */
	public java.lang.String getIssueId () {
		return issueId;
	}

	/**
	 * Set the value related to the column: issue_id
	 * @param issueId the issue_id value
	 */
	public void setIssueId (java.lang.String issueId) {
		this.issueId = issueId;
	}



	/**
	 * Return the value associated with the column: BANK_ID
	 */
	public java.lang.String getBankId () {
		return bankId;
	}

	/**
	 * Set the value related to the column: BANK_ID
	 * @param bankId the BANK_ID value
	 */
	public void setBankId (java.lang.String bankId) {
		this.bankId = bankId;
	}



	/**
	 * Return the value associated with the column: exg_stock
	 */
	public java.math.BigDecimal getExgStock () {
		return exgStock;
	}

	/**
	 * Set the value related to the column: exg_stock
	 * @param exgStock the exg_stock value
	 */
	public void setExgStock (java.math.BigDecimal exgStock) {
		this.exgStock = exgStock;
	}



	/**
	 * Return the value associated with the column: exg_amount
	 */
	public java.math.BigDecimal getExgAmount () {
		return exgAmount;
	}

	/**
	 * Set the value related to the column: exg_amount
	 * @param exgAmount the exg_amount value
	 */
	public void setExgAmount (java.math.BigDecimal exgAmount) {
		this.exgAmount = exgAmount;
	}



	/**
	 * Return the value associated with the column: exg_less_amount
	 */
	public java.math.BigDecimal getExgLessAmount () {
		return exgLessAmount;
	}

	/**
	 * Set the value related to the column: exg_less_amount
	 * @param exgLessAmount the exg_less_amount value
	 */
	public void setExgLessAmount (java.math.BigDecimal exgLessAmount) {
		this.exgLessAmount = exgLessAmount;
	}



	/**
	 * Return the value associated with the column: total_less_amount
	 */
	public java.math.BigDecimal getTotalLessAmount () {
		return totalLessAmount;
	}

	/**
	 * Set the value related to the column: total_less_amount
	 * @param totalLessAmount the total_less_amount value
	 */
	public void setTotalLessAmount (java.math.BigDecimal totalLessAmount) {
		this.totalLessAmount = totalLessAmount;
	}



	/**
	 * Return the value associated with the column: TERM_YM
	 */
	public java.lang.String getTermYm () {
		return termYm;
	}

	/**
	 * Set the value related to the column: TERM_YM
	 * @param termYm the TERM_YM value
	 */
	public void setTermYm (java.lang.String termYm) {
		this.termYm = termYm;
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