package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Central_bank_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Central_bank_ref"
 */

public abstract class BaseCentralBankRef  implements Comparable, Serializable {

	public static String REF = "CentralBankRef";
	public static String PROP_FREE_UNIT = "FreeUnit";
	public static String PROP_BANK_TYPE = "BankType";
	public static String PROP_BANK_NAME = "BankName";
	public static String PROP_ID = "id";
	public static String PROP_BANK_NO = "BankNo";


	// constructors
	public BaseCentralBankRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCentralBankRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bankNo;
	private java.lang.String bankName;
	private java.lang.String bankType;
	private java.lang.String freeUnit;



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
	 * Return the value associated with the column: bank_no
	 */
	public java.lang.String getBankNo () {
		return bankNo;
	}

	/**
	 * Set the value related to the column: bank_no
	 * @param bankNo the bank_no value
	 */
	public void setBankNo (java.lang.String bankNo) {
		this.bankNo = bankNo;
	}



	/**
	 * Return the value associated with the column: bank_name
	 */
	public java.lang.String getBankName () {
		return bankName;
	}

	/**
	 * Set the value related to the column: bank_name
	 * @param bankName the bank_name value
	 */
	public void setBankName (java.lang.String bankName) {
		this.bankName = bankName;
	}



	/**
	 * Return the value associated with the column: bank_type
	 */
	public java.lang.String getBankType () {
		return bankType;
	}

	/**
	 * Set the value related to the column: bank_type
	 * @param bankType the bank_type value
	 */
	public void setBankType (java.lang.String bankType) {
		this.bankType = bankType;
	}



	/**
	 * Return the value associated with the column: free_unit
	 */
	public java.lang.String getFreeUnit () {
		return freeUnit;
	}

	/**
	 * Set the value related to the column: free_unit
	 * @param freeUnit the free_unit value
	 */
	public void setFreeUnit (java.lang.String freeUnit) {
		this.freeUnit = freeUnit;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.CentralBankRef)) return false;
		else {
			tw.gov.nta.sql.debt.CentralBankRef centralBankRef = (tw.gov.nta.sql.debt.CentralBankRef) obj;
			if (null == this.getId() || null == centralBankRef.getId()) return false;
			else return (this.getId().equals(centralBankRef.getId()));
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