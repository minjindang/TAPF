package tw.gov.nta.sql.debt.account.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the account_phase_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="account_phase_det"
 */

public abstract class BaseAccountPhaseDet  implements Comparable, Serializable {

	public static String REF = "AccountPhaseDet";
	public static String PROP_ACCOUNT_CODE = "accountCode";
	public static String PROP_ACCOUNT_PHASE = "accountPhase";
	public static String PROP_ACCOUNT_TYPE = "accountType";
	public static String PROP_ID = "id";
	public static String PROP_FORMULA = "formula";


	// constructors
	public BaseAccountPhaseDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccountPhaseDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAccountPhaseDet (
		java.lang.Integer id,
		tw.gov.nta.sql.account.AccountRef accountCode,
		tw.gov.nta.sql.debt.account.AccountPhaseMain accountPhase,
		java.lang.String accountType) {

		this.setId(id);
		this.setAccountCode(accountCode);
		this.setAccountPhase(accountPhase);
		this.setAccountType(accountType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String formula;
	private java.lang.String accountType;

	// many to one
	private tw.gov.nta.sql.account.AccountRef accountCode;
	private tw.gov.nta.sql.debt.account.AccountPhaseMain accountPhase;



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
	 * Return the value associated with the column: formula
	 */
	public java.lang.String getFormula () {
		return formula;
	}

	/**
	 * Set the value related to the column: formula
	 * @param formula the formula value
	 */
	public void setFormula (java.lang.String formula) {
		this.formula = formula;
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
	 * Return the value associated with the column: account_code_id
	 */
	public tw.gov.nta.sql.account.AccountRef getAccountCode () {
		return accountCode;
	}

	/**
	 * Set the value related to the column: account_code_id
	 * @param accountCode the account_code_id value
	 */
	public void setAccountCode (tw.gov.nta.sql.account.AccountRef accountCode) {
		this.accountCode = accountCode;
	}



	/**
	 * Return the value associated with the column: account_phase_id
	 */
	public tw.gov.nta.sql.debt.account.AccountPhaseMain getAccountPhase () {
		return accountPhase;
	}

	/**
	 * Set the value related to the column: account_phase_id
	 * @param accountPhase the account_phase_id value
	 */
	public void setAccountPhase (tw.gov.nta.sql.debt.account.AccountPhaseMain accountPhase) {
		this.accountPhase = accountPhase;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.account.AccountPhaseDet)) return false;
		else {
			tw.gov.nta.sql.debt.account.AccountPhaseDet accountPhaseDet = (tw.gov.nta.sql.debt.account.AccountPhaseDet) obj;
			if (null == this.getId() || null == accountPhaseDet.getId()) return false;
			else return (this.getId().equals(accountPhaseDet.getId()));
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