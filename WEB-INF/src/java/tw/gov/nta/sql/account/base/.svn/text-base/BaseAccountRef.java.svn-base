package tw.gov.nta.sql.account.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the account_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="account_ref"
 */

public abstract class BaseAccountRef  implements Comparable, Serializable {

	public static String REF = "AccountRef";
	public static String PROP_DEBT_TYPE = "debtType";
	public static String PROP_ACCOUNT_CODE = "accountCode";
	public static String PROP_REMARK = "remark";
	public static String PROP_ACCOUNT_TYPE = "accountType";
	public static String PROP_ID = "id";
	public static String PROP_ACCOUNT_NAME = "accountName";


	// constructors
	public BaseAccountRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccountRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAccountRef (
		java.lang.Integer id,
		java.lang.String accountCode,
		java.lang.String accountName,
		java.lang.String accountType) {

		this.setId(id);
		this.setAccountCode(accountCode);
		this.setAccountName(accountName);
		this.setAccountType(accountType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String accountCode;
	private java.lang.String accountName;
	private java.lang.String accountType;
	private java.lang.String remark;

	// many to one
	private tw.gov.nta.sql.debt.DebtTypeRef debtType;



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
	 * Return the value associated with the column: account_code
	 */
	public java.lang.String getAccountCode () {
		return accountCode;
	}

	/**
	 * Set the value related to the column: account_code
	 * @param accountCode the account_code value
	 */
	public void setAccountCode (java.lang.String accountCode) {
		this.accountCode = accountCode;
	}



	/**
	 * Return the value associated with the column: account_name
	 */
	public java.lang.String getAccountName () {
		return accountName;
	}

	/**
	 * Set the value related to the column: account_name
	 * @param accountName the account_name value
	 */
	public void setAccountName (java.lang.String accountName) {
		this.accountName = accountName;
	}



	/**
	 * Return the value associated with the column: account_type
	 */
	public java.lang.String getAccountType () {
		return accountType;
	}

	/**
	 * Set the value related to the column: account_type
	 * @param accountType the account_type value
	 */
	public void setAccountType (java.lang.String accountType) {
		this.accountType = accountType;
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
	 * Return the value associated with the column: debt_type
	 */
	public tw.gov.nta.sql.debt.DebtTypeRef getDebtType () {
		return debtType;
	}

	/**
	 * Set the value related to the column: debt_type
	 * @param debtType the debt_type value
	 */
	public void setDebtType (tw.gov.nta.sql.debt.DebtTypeRef debtType) {
		this.debtType = debtType;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.account.AccountRef)) return false;
		else {
			tw.gov.nta.sql.account.AccountRef accountRef = (tw.gov.nta.sql.account.AccountRef) obj;
			if (null == this.getId() || null == accountRef.getId()) return false;
			else return (this.getId().equals(accountRef.getId()));
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