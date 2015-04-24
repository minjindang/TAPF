package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the central_exchange_less_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="central_exchange_less_det"
 */

public abstract class BaseCentralExchangeLessDet  implements Comparable, Serializable {

	public static String REF = "CentralExchangeLessDet";
	public static String PROP_USRID = "usrid";
	public static String PROP_PAY_MONTH_AMOUNT = "payMonthAmount";
	public static String PROP_PAY_FUND = "payFund";
	public static String PROP_REMARK = "remark";
	public static String PROP_BANK_ID = "bankId";
	public static String PROP_ISSUE_ID = "issueId";
	public static String PROP_TERM_YM = "termYm";
	public static String PROP_LESS_FUND_AMOUNT = "lessFundAmount";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_ID = "id";


	// constructors
	public BaseCentralExchangeLessDet () {
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.Integer id;
	private java.lang.Integer usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;
	private java.lang.Integer issueId;
	private java.lang.String termYm;
	private java.lang.Integer bankId;
	private java.math.BigDecimal payFund;
	private java.math.BigDecimal payMonthAmount;
	private java.math.BigDecimal lessFundAmount;






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



	/**
	 * Return the value associated with the column: BANK_ID
	 */
	public java.lang.Integer getBankId () {
		return bankId;
	}

	/**
	 * Set the value related to the column: BANK_ID
	 * @param bankId the BANK_ID value
	 */
	public void setBankId (java.lang.Integer bankId) {
		this.bankId = bankId;
	}



	/**
	 * Return the value associated with the column: pay_fund
	 */
	public java.math.BigDecimal getPayFund () {
		return payFund;
	}

	/**
	 * Set the value related to the column: pay_fund
	 * @param payFund the pay_fund value
	 */
	public void setPayFund (java.math.BigDecimal payFund) {
		this.payFund = payFund;
	}



	/**
	 * Return the value associated with the column: pay_month_amount
	 */
	public java.math.BigDecimal getPayMonthAmount () {
		return payMonthAmount;
	}

	/**
	 * Set the value related to the column: pay_month_amount
	 * @param payMonthAmount the pay_month_amount value
	 */
	public void setPayMonthAmount (java.math.BigDecimal payMonthAmount) {
		this.payMonthAmount = payMonthAmount;
	}



	/**
	 * Return the value associated with the column: less_fund_amount
	 */
	public java.math.BigDecimal getLessFundAmount () {
		return lessFundAmount;
	}

	/**
	 * Set the value related to the column: less_fund_amount
	 * @param lessFundAmount the less_fund_amount value
	 */
	public void setLessFundAmount (java.math.BigDecimal lessFundAmount) {
		this.lessFundAmount = lessFundAmount;
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