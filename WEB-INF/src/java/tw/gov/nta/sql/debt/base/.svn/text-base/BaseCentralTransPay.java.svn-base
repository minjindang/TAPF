package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the central_trans_pay table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="central_trans_pay"
 */

public abstract class BaseCentralTransPay  implements Comparable, Serializable {

	public static String REF = "CentralTransPay";
	public static String PROP_USRID = "usrid";
	public static String PROP_PAY_DATE = "payDate";
	public static String PROP_REMARK = "remark";
	public static String PROP_ISSUE_ID = "issueId";
	public static String PROP_BANK_ID = "bankId";
	public static String PROP_ATTACH_SERIAL = "attachSerial";
	public static String PROP_TICKET_COUNT = "ticketCount";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_TOTAL_AMOUNT = "totalAmount";
	public static String PROP_CRE_DATE = "creDate";
	public static String PROP_PAYMENT_ID = "paymentId";
	public static String PROP_ID = "id";


	// constructors
	public BaseCentralTransPay () {
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCentralTransPay (
		java.lang.Integer id,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date creDate,
		java.lang.Integer bankId,
		java.lang.Integer ticketCount,
		java.lang.Integer issueId,
		java.lang.Integer paymentId,
		java.math.BigDecimal payDate,
		java.lang.String attachSerial) {

		this.setId(id);
		this.setUsrid(usrid);
		this.setModDate(modDate);
		this.setCreDate(creDate);
		this.setBankId(bankId);
		this.setTicketCount(ticketCount);
		this.setIssueId(issueId);
		this.setPaymentId(paymentId);
		this.setPayDate(payDate);
		this.setAttachSerial(attachSerial);
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.Integer id;
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date creDate;
	private java.lang.Integer bankId;
	private java.lang.Integer ticketCount;
	private java.math.BigDecimal totalAmount;
	private java.lang.Integer issueId;
	private java.lang.Integer paymentId;
	private java.math.BigDecimal payDate;
	private java.lang.String attachSerial;






	/**
	 * Return the value associated with the column: ID
	 */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the value related to the column: ID
	 * @param id the ID value
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: USRID
	 */
	public java.lang.String getUsrid () {
		return usrid;
	}

	/**
	 * Set the value related to the column: USRID
	 * @param usrid the USRID value
	 */
	public void setUsrid (java.lang.String usrid) {
		this.usrid = usrid;
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
	 * Return the value associated with the column: REMARK
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: REMARK
	 * @param remark the REMARK value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: CRE_DATE
	 */
	public java.util.Date getCreDate () {
		return creDate;
	}

	/**
	 * Set the value related to the column: CRE_DATE
	 * @param creDate the CRE_DATE value
	 */
	public void setCreDate (java.util.Date creDate) {
		this.creDate = creDate;
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
	 * Return the value associated with the column: TICKET_COUNT
	 */
	public java.lang.Integer getTicketCount () {
		return ticketCount;
	}

	/**
	 * Set the value related to the column: TICKET_COUNT
	 * @param ticketCount the TICKET_COUNT value
	 */
	public void setTicketCount (java.lang.Integer ticketCount) {
		this.ticketCount = ticketCount;
	}



	/**
	 * Return the value associated with the column: TOTAL_AMOUNT
	 */
	public java.math.BigDecimal getTotalAmount () {
		return totalAmount;
	}

	/**
	 * Set the value related to the column: TOTAL_AMOUNT
	 * @param totalAmount the TOTAL_AMOUNT value
	 */
	public void setTotalAmount (java.math.BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}



	/**
	 * Return the value associated with the column: ISSUE_ID
	 */
	public java.lang.Integer getIssueId () {
		return issueId;
	}

	/**
	 * Set the value related to the column: ISSUE_ID
	 * @param issueId the ISSUE_ID value
	 */
	public void setIssueId (java.lang.Integer issueId) {
		this.issueId = issueId;
	}



	/**
	 * Return the value associated with the column: PAYMENT_ID
	 */
	public java.lang.Integer getPaymentId () {
		return paymentId;
	}

	/**
	 * Set the value related to the column: PAYMENT_ID
	 * @param paymentId the PAYMENT_ID value
	 */
	public void setPaymentId (java.lang.Integer paymentId) {
		this.paymentId = paymentId;
	}



	/**
	 * Return the value associated with the column: PAY_DATE
	 */
	public java.math.BigDecimal getPayDate () {
		return payDate;
	}

	/**
	 * Set the value related to the column: PAY_DATE
	 * @param payDate the PAY_DATE value
	 */
	public void setPayDate (java.math.BigDecimal payDate) {
		this.payDate = payDate;
	}



	/**
	 * Return the value associated with the column: ATTACH_SERIAL
	 */
	public java.lang.String getAttachSerial () {
		return attachSerial;
	}

	/**
	 * Set the value related to the column: ATTACH_SERIAL
	 * @param attachSerial the ATTACH_SERIAL value
	 */
	public void setAttachSerial (java.lang.String attachSerial) {
		this.attachSerial = attachSerial;
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