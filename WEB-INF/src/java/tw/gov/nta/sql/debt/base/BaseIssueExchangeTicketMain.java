package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the issue_exchange_ticket_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="issue_exchange_ticket_main"
 */

public abstract class BaseIssueExchangeTicketMain  implements Comparable, Serializable {

	public static String REF = "IssueExchangeTicketMain";
	public static String PROP_INTEREST_AMOUNT = "interestAmount";
	public static String PROP_ACCUM_CAPITAL_AMOUNT = "accumCapitalAmount";
	public static String PROP_BANK_ID = "bankId";
	public static String PROP_CAPITAL_AMOUNT = "capitalAmount";
	public static String PROP_ACCUM_INTEREST_AMOUNT = "accumInterestAmount";
	public static String PROP_CAPITAL_SERIAL = "capitalSerial";
	public static String PROP_DEBT = "debt";
	public static String PROP_ID = "id";
	public static String PROP_INTEREST_SERIAL = "interestSerial";
	public static String PROP_EXCHANGE_DATE = "exchangeDate";


	// constructors
	public BaseIssueExchangeTicketMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIssueExchangeTicketMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseIssueExchangeTicketMain (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtMain debt,
		java.math.BigDecimal accumCapitalAmount,
		java.math.BigDecimal capitalAmount,
		java.util.Date exchangeDate,
		java.math.BigDecimal interestAmount) {

		this.setId(id);
		this.setDebt(debt);
		this.setAccumCapitalAmount(accumCapitalAmount);
		this.setCapitalAmount(capitalAmount);
		this.setExchangeDate(exchangeDate);
		this.setInterestAmount(interestAmount);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal accumCapitalAmount;
	private java.math.BigDecimal accumInterestAmount;
	private java.lang.Integer bankId;
	private java.math.BigDecimal capitalAmount;
	private java.lang.Integer capitalSerial;
	private java.util.Date exchangeDate;
	private java.math.BigDecimal interestAmount;
	private java.lang.Integer interestSerial;

	// many to one
	private tw.gov.nta.sql.debt.DebtMain debt;



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
	 * Return the value associated with the column: accum_capital_amount
	 */
	public java.math.BigDecimal getAccumCapitalAmount () {
		return accumCapitalAmount;
	}

	/**
	 * Set the value related to the column: accum_capital_amount
	 * @param accumCapitalAmount the accum_capital_amount value
	 */
	public void setAccumCapitalAmount (java.math.BigDecimal accumCapitalAmount) {
		this.accumCapitalAmount = accumCapitalAmount;
	}



	/**
	 * Return the value associated with the column: accum_interest_amount
	 */
	public java.math.BigDecimal getAccumInterestAmount () {
		return accumInterestAmount;
	}

	/**
	 * Set the value related to the column: accum_interest_amount
	 * @param accumInterestAmount the accum_interest_amount value
	 */
	public void setAccumInterestAmount (java.math.BigDecimal accumInterestAmount) {
		this.accumInterestAmount = accumInterestAmount;
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
	 * Return the value associated with the column: capital_amount
	 */
	public java.math.BigDecimal getCapitalAmount () {
		return capitalAmount;
	}

	/**
	 * Set the value related to the column: capital_amount
	 * @param capitalAmount the capital_amount value
	 */
	public void setCapitalAmount (java.math.BigDecimal capitalAmount) {
		this.capitalAmount = capitalAmount;
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
	 * Return the value associated with the column: DEBT_ID
	 */
	public tw.gov.nta.sql.debt.DebtMain getDebt () {
		return debt;
	}

	/**
	 * Set the value related to the column: PLAN_ID
	 * @param plan the PLAN_ID value
	 */
	public void setDebt (tw.gov.nta.sql.debt.DebtMain debt) {
		this.debt = debt;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.IssueExchangeTicketMain)) return false;
		else {
			tw.gov.nta.sql.debt.IssueExchangeTicketMain issueExchangeTicketMain = (tw.gov.nta.sql.debt.IssueExchangeTicketMain) obj;
			if (null == this.getId() || null == issueExchangeTicketMain.getId()) return false;
			else return (this.getId().equals(issueExchangeTicketMain.getId()));
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