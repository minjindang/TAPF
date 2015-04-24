package tw.gov.nta.sql.debt.account.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the EAQC01_RPT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="EAQC01_RPT"
 */

public abstract class BaseEaqc01Rpt  implements Comparable, Serializable {

	public static String REF = "Eaqc01Rpt";
	public static String PROP_ACCOUNT_AMOUNT_D = "accountAmountD";
	public static String PROP_VOUCHER_DATE = "voucherDate";
	public static String PROP_ACCOUNT_AMOUNT_C = "accountAmountC";
	public static String PROP_VOUCHER_NO = "voucherNo";
	public static String PROP_ID = "id";
	public static String PROP_ACCOUNT_NAME = "accountName";


	// constructors
	public BaseEaqc01Rpt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEaqc01Rpt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String voucherNo;
	private java.util.Date voucherDate;
	private java.lang.String accountName;
	private java.math.BigDecimal accountAmountD;
	private java.math.BigDecimal accountAmountC;



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
	 * Return the value associated with the column: Voucher_No
	 */
	public java.lang.String getVoucherNo () {
		return voucherNo;
	}

	/**
	 * Set the value related to the column: Voucher_No
	 * @param voucherNo the Voucher_No value
	 */
	public void setVoucherNo (java.lang.String voucherNo) {
		this.voucherNo = voucherNo;
	}



	/**
	 * Return the value associated with the column: Voucher_Date
	 */
	public java.util.Date getVoucherDate () {
		return voucherDate;
	}

	/**
	 * Set the value related to the column: Voucher_Date
	 * @param voucherDate the Voucher_Date value
	 */
	public void setVoucherDate (java.util.Date voucherDate) {
		this.voucherDate = voucherDate;
	}



	/**
	 * Return the value associated with the column: Account_Name
	 */
	public java.lang.String getAccountName () {
		return accountName;
	}

	/**
	 * Set the value related to the column: Account_Name
	 * @param accountName the Account_Name value
	 */
	public void setAccountName (java.lang.String accountName) {
		this.accountName = accountName;
	}



	/**
	 * Return the value associated with the column: Account_Amount_D
	 */
	public java.math.BigDecimal getAccountAmountD () {
		return accountAmountD;
	}

	/**
	 * Set the value related to the column: Account_Amount_D
	 * @param accountAmountD the Account_Amount_D value
	 */
	public void setAccountAmountD (java.math.BigDecimal accountAmountD) {
		this.accountAmountD = accountAmountD;
	}



	/**
	 * Return the value associated with the column: Account_Amount_C
	 */
	public java.math.BigDecimal getAccountAmountC () {
		return accountAmountC;
	}

	/**
	 * Set the value related to the column: Account_Amount_C
	 * @param accountAmountC the Account_Amount_C value
	 */
	public void setAccountAmountC (java.math.BigDecimal accountAmountC) {
		this.accountAmountC = accountAmountC;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.account.Eaqc01Rpt)) return false;
		else {
			tw.gov.nta.sql.debt.account.Eaqc01Rpt eaqc01Rpt = (tw.gov.nta.sql.debt.account.Eaqc01Rpt) obj;
			if (null == this.getId() || null == eaqc01Rpt.getId()) return false;
			else return (this.getId().equals(eaqc01Rpt.getId()));
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