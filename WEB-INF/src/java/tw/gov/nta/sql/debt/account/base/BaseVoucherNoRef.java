package tw.gov.nta.sql.debt.account.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the voucher_no_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="voucher_no_ref"
 */

public abstract class BaseVoucherNoRef  implements Comparable, Serializable {

	public static String REF = "VoucherNoRef";
	public static String PROP_DEBT_TYPE = "debtType";
	public static String PROP_VOUCHER_TYPE = "voucherType";
	public static String PROP_PAYMENT_SERIAL_NO = "paymentSerialNo";
	public static String PROP_DEBT_CODE = "debtCode";
	public static String PROP_ISSUE_SERIAL = "issueSerial";
	public static String PROP_SERIAL_NO = "serialNo";
	public static String PROP_ID = "id";
	public static String PROP_ACCOUNT_YEAR = "accountYear";


	// constructors
	public BaseVoucherNoRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVoucherNoRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseVoucherNoRef (
		java.lang.Integer id,
		java.lang.String accountYear,
		java.lang.String debtCode,
		java.lang.String issueSerial,
		java.lang.Integer serialNo,
		java.lang.Integer voucherType) {

		this.setId(id);
		this.setAccountYear(accountYear);
		this.setDebtCode(debtCode);
		this.setIssueSerial(issueSerial);
		this.setSerialNo(serialNo);
		this.setVoucherType(voucherType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String accountYear;
	private java.lang.String debtCode;
	private java.lang.String issueSerial;
	private java.lang.Integer serialNo;
	private java.lang.Integer voucherType;
	private java.lang.String paymentSerialNo;
	private java.lang.String debtType;



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
	 * Return the value associated with the column: debt_code
	 */
	public java.lang.String getDebtCode () {
		return debtCode;
	}

	/**
	 * Set the value related to the column: debt_code
	 * @param debtCode the debt_code value
	 */
	public void setDebtCode (java.lang.String debtCode) {
		this.debtCode = debtCode;
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
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.Integer getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * @param serialNo the serial_no value
	 */
	public void setSerialNo (java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}



	/**
	 * Return the value associated with the column: voucher_type
	 */
	public java.lang.Integer getVoucherType () {
		return voucherType;
	}

	/**
	 * Set the value related to the column: voucher_type
	 * @param voucherType the voucher_type value
	 */
	public void setVoucherType (java.lang.Integer voucherType) {
		this.voucherType = voucherType;
	}



	/**
	 * Return the value associated with the column: payment_serial_no
	 */
	public java.lang.String getPaymentSerialNo () {
		return paymentSerialNo;
	}

	/**
	 * Set the value related to the column: payment_serial_no
	 * @param paymentSerialNo the payment_serial_no value
	 */
	public void setPaymentSerialNo (java.lang.String paymentSerialNo) {
		this.paymentSerialNo = paymentSerialNo;
	}



	/**
	 * Return the value associated with the column: debt_type
	 */
	public java.lang.String getDebtType () {
		return debtType;
	}

	/**
	 * Set the value related to the column: debt_type
	 * @param debtType the debt_type value
	 */
	public void setDebtType (java.lang.String debtType) {
		this.debtType = debtType;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.account.VoucherNoRef)) return false;
		else {
			tw.gov.nta.sql.debt.account.VoucherNoRef voucherNoRef = (tw.gov.nta.sql.debt.account.VoucherNoRef) obj;
			if (null == this.getId() || null == voucherNoRef.getId()) return false;
			else return (this.getId().equals(voucherNoRef.getId()));
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