package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the BANKF table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BANKF"
 */

public abstract class BaseBankf  implements Comparable, Serializable {

	public static String REF = "Bankf";
	public static String PROP_BANK_FNAME = "BankFname";
	public static String PROP_TPSBANK = "Tpsbank";
	public static String PROP_BANK_ANAME = "BankAname";
	public static String PROP_ACCOUNT_NO2 = "AccountNo2";
	public static String PROP_ACCOUNT_NO = "AccountNo";
	public static String PROP_BANK_CODE = "BankCode";


	// constructors
	public BaseBankf () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBankf (java.lang.Integer bankCode) {
		this.setBankCode(bankCode);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBankf (
		java.lang.Integer bankCode,
		java.lang.String tpsbank,
		java.lang.String bankAname,
		java.lang.String bankFname) {

		this.setBankCode(bankCode);
		this.setTpsbank(tpsbank);
		this.setBankAname(bankAname);
		this.setBankFname(bankFname);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer bankCode;

	// fields
	private java.lang.String tpsbank;
	private java.lang.String bankAname;
	private java.lang.String bankFname;
	private java.lang.String accountNo;
	private java.lang.String accountNo2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="BANK_CODE"
     */
	public java.lang.Integer getBankCode () {
		return bankCode;
	}

	/**
	 * Set the unique identifier of this class
	 * @param bankCode the new ID
	 */
	public void setBankCode (java.lang.Integer bankCode) {
		this.bankCode = bankCode;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: TPSBANK
	 */
	public java.lang.String getTpsbank () {
		return tpsbank;
	}

	/**
	 * Set the value related to the column: TPSBANK
	 * @param tpsbank the TPSBANK value
	 */
	public void setTpsbank (java.lang.String tpsbank) {
		this.tpsbank = tpsbank;
	}



	/**
	 * Return the value associated with the column: BANK_ANAME
	 */
	public java.lang.String getBankAname () {
		return bankAname;
	}

	/**
	 * Set the value related to the column: BANK_ANAME
	 * @param bankAname the BANK_ANAME value
	 */
	public void setBankAname (java.lang.String bankAname) {
		this.bankAname = bankAname;
	}



	/**
	 * Return the value associated with the column: BANK_FNAME
	 */
	public java.lang.String getBankFname () {
		return bankFname;
	}

	/**
	 * Set the value related to the column: BANK_FNAME
	 * @param bankFname the BANK_FNAME value
	 */
	public void setBankFname (java.lang.String bankFname) {
		this.bankFname = bankFname;
	}



	/**
	 * Return the value associated with the column: ACCOUNT_NO
	 */
	public java.lang.String getAccountNo () {
		return accountNo;
	}

	/**
	 * Set the value related to the column: ACCOUNT_NO
	 * @param accountNo the ACCOUNT_NO value
	 */
	public void setAccountNo (java.lang.String accountNo) {
		this.accountNo = accountNo;
	}



	/**
	 * Return the value associated with the column: ACCOUNT_NO2
	 */
	public java.lang.String getAccountNo2 () {
		return accountNo2;
	}

	/**
	 * Set the value related to the column: ACCOUNT_NO2
	 * @param accountNo2 the ACCOUNT_NO2 value
	 */
	public void setAccountNo2 (java.lang.String accountNo2) {
		this.accountNo2 = accountNo2;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.Bankf)) return false;
		else {
			tw.gov.nta.sql.debt.Bankf bankf = (tw.gov.nta.sql.debt.Bankf) obj;
			if (null == this.getBankCode() || null == bankf.getBankCode()) return false;
			else return (this.getBankCode().equals(bankf.getBankCode()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getBankCode()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getBankCode().hashCode();
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