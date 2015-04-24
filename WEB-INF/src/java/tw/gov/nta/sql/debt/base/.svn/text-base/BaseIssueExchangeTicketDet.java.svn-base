package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the issue_exchange_ticket_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="issue_exchange_ticket_det"
 */

public abstract class BaseIssueExchangeTicketDet  implements Comparable, Serializable {

	public static String REF = "IssueExchangeTicketDet";
	public static String PROP_DEBT_ID = "debtId";
	public static String PROP_BANK_ID = "bankId";
	public static String PROP_ACCUM_AMOUNT = "accumAmount";
	public static String PROP_ACCUM_COUNT = "accumCount";
	public static String PROP_TICKET_NAME = "ticketName";
	public static String PROP_TICKET_COUNT = "ticketCount";
	public static String PROP_TOTAL_AMOUNT = "totalAmount";
	public static String PROP_CAPITAL_SERIAL = "capitalSerial";
	public static String PROP_TICKET_AMOUNT = "ticketAmount";
	public static String PROP_ID = "id";
	public static String PROP_INTEREST_SERIAL = "interestSerial";
	public static String PROP_EXCHANGE_DATE = "exchangeDate";


	// constructors
	public BaseIssueExchangeTicketDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIssueExchangeTicketDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseIssueExchangeTicketDet (
		java.lang.Integer id,
		java.lang.Integer debtId,
		java.util.Date exchangeDate,
		java.lang.Long ticketCount,
		java.math.BigDecimal totalAmount) {

		this.setId(id);
		this.setDebtId(debtId);
		this.setExchangeDate(exchangeDate);
		this.setTicketCount(ticketCount);
		this.setTotalAmount(totalAmount);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer debtId;
	private java.lang.Integer capitalSerial;
	private java.lang.Integer interestSerial;
	private java.lang.Integer bankId;
	private java.util.Date exchangeDate;
	private java.lang.String ticketName;
	private java.math.BigDecimal ticketAmount;
	private java.lang.Long ticketCount;
	private java.math.BigDecimal totalAmount;
	private java.lang.Long accumCount;
	private java.math.BigDecimal accumAmount;



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
	 * Return the value associated with the column: debt_id
	 */
	public java.lang.Integer getDebtId () {
		return debtId;
	}

	/**
	 * Set the value related to the column: debt_id
	 * @param debtId the debt_id value
	 */
	public void setDebtId (java.lang.Integer debtId) {
		this.debtId = debtId;
	}



	/**
	 * Return the value associated with the column: capital_serial
	 */
	public java.lang.Integer getCapitalSerial () {
		return capitalSerial;
	}

	/**
	 * Set the value related to the column: capital_serial
	 * @param capitalSerial the capital_serial value
	 */
	public void setCapitalSerial (java.lang.Integer capitalSerial) {
		this.capitalSerial = capitalSerial;
	}



	/**
	 * Return the value associated with the column: interest_serial
	 */
	public java.lang.Integer getInterestSerial () {
		return interestSerial;
	}

	/**
	 * Set the value related to the column: interest_serial
	 * @param interestSerial the interest_serial value
	 */
	public void setInterestSerial (java.lang.Integer interestSerial) {
		this.interestSerial = interestSerial;
	}



	/**
	 * Return the value associated with the column: bank_id
	 */
	public java.lang.Integer getBankId () {
		return bankId;
	}

	/**
	 * Set the value related to the column: bank_id
	 * @param bankId the bank_id value
	 */
	public void setBankId (java.lang.Integer bankId) {
		this.bankId = bankId;
	}



	/**
	 * Return the value associated with the column: exchange_date
	 */
	public java.util.Date getExchangeDate () {
		return exchangeDate;
	}

	/**
	 * Set the value related to the column: exchange_date
	 * @param exchangeDate the exchange_date value
	 */
	public void setExchangeDate (java.util.Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}



	/**
	 * Return the value associated with the column: ticket_name
	 */
	public java.lang.String getTicketName () {
		return ticketName;
	}

	/**
	 * Set the value related to the column: ticket_name
	 * @param ticketName the ticket_name value
	 */
	public void setTicketName (java.lang.String ticketName) {
		this.ticketName = ticketName;
	}



	/**
	 * Return the value associated with the column: ticket_amount
	 */
	public java.math.BigDecimal getTicketAmount () {
		return ticketAmount;
	}

	/**
	 * Set the value related to the column: ticket_amount
	 * @param ticketAmount the ticket_amount value
	 */
	public void setTicketAmount (java.math.BigDecimal ticketAmount) {
		this.ticketAmount = ticketAmount;
	}



	/**
	 * Return the value associated with the column: ticket_count
	 */
	public java.lang.Long getTicketCount () {
		return ticketCount;
	}

	/**
	 * Set the value related to the column: ticket_count
	 * @param ticketCount the ticket_count value
	 */
	public void setTicketCount (java.lang.Long ticketCount) {
		this.ticketCount = ticketCount;
	}



	/**
	 * Return the value associated with the column: total_amount
	 */
	public java.math.BigDecimal getTotalAmount () {
		return totalAmount;
	}

	/**
	 * Set the value related to the column: total_amount
	 * @param totalAmount the total_amount value
	 */
	public void setTotalAmount (java.math.BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}



	/**
	 * Return the value associated with the column: accum_count
	 */
	public java.lang.Long getAccumCount () {
		return accumCount;
	}

	/**
	 * Set the value related to the column: accum_count
	 * @param accumCount the accum_count value
	 */
	public void setAccumCount (java.lang.Long accumCount) {
		this.accumCount = accumCount;
	}



	/**
	 * Return the value associated with the column: accum_amount
	 */
	public java.math.BigDecimal getAccumAmount () {
		return accumAmount;
	}

	/**
	 * Set the value related to the column: accum_amount
	 * @param accumAmount the accum_amount value
	 */
	public void setAccumAmount (java.math.BigDecimal accumAmount) {
		this.accumAmount = accumAmount;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.IssueExchangeTicketDet)) return false;
		else {
			tw.gov.nta.sql.debt.IssueExchangeTicketDet issueExchangeTicketDet = (tw.gov.nta.sql.debt.IssueExchangeTicketDet) obj;
			if (null == this.getId() || null == issueExchangeTicketDet.getId()) return false;
			else return (this.getId().equals(issueExchangeTicketDet.getId()));
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