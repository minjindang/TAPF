package tw.gov.nta.sql.debt.account.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the account_phase_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="account_phase_main"
 */

public abstract class BaseAccountPhaseMain  implements Comparable, Serializable {

	public static String REF = "AccountPhaseMain";
	public static String PROP_DEBT_TYPE = "debtType";
	public static String PROP_PHASE_NAME = "phaseName";
	public static String PROP_PHASE_TYPE = "phaseType";
	public static String PROP_VOUCHER_DATE_RULE = "voucherDateRule";
	public static String PROP_PHASE_SERIAL = "phaseSerial";
	public static String PROP_GET_TABLE = "getTable";
	public static String PROP_PHASE_CODE = "phaseCode";
	public static String PROP_PHASE_SHORT_NAME = "phaseShortName";
	public static String PROP_ID = "id";
	public static String PROP_EXEC_WHEN = "execWhen";
	public static String PROP_ISSUE_KIND = "issueKind";


	// constructors
	public BaseAccountPhaseMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccountPhaseMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAccountPhaseMain (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtTypeRef debtType,
		java.lang.String phaseCode,
		java.lang.String phaseName,
		java.lang.String phaseShortName,
		java.lang.Integer phaseType,
		java.lang.String issueKind) {

		this.setId(id);
		this.setDebtType(debtType);
		this.setPhaseCode(phaseCode);
		this.setPhaseName(phaseName);
		this.setPhaseShortName(phaseShortName);
		this.setPhaseType(phaseType);
		this.setIssueKind(issueKind);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String phaseCode;
	private java.lang.String phaseName;
	private java.lang.String phaseShortName;
	private java.lang.Integer phaseType;
	private java.lang.String issueKind;
	private java.lang.String getTable;
	private java.lang.String execWhen;
	private java.lang.Integer voucherDateRule;
	private java.lang.Integer phaseSerial;

	// many to one
	private tw.gov.nta.sql.debt.DebtTypeRef debtType;

	// collections
	private java.util.Set<tw.gov.nta.sql.debt.account.AccountPhaseDet> accountPhaseDets;
	private java.util.Set<tw.gov.nta.sql.account.VoucherMain> vouchers;



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
	 * Return the value associated with the column: phase_code
	 */
	public java.lang.String getPhaseCode () {
		return phaseCode;
	}

	/**
	 * Set the value related to the column: phase_code
	 * @param phaseCode the phase_code value
	 */
	public void setPhaseCode (java.lang.String phaseCode) {
		this.phaseCode = phaseCode;
	}



	/**
	 * Return the value associated with the column: phase_name
	 */
	public java.lang.String getPhaseName () {
		return phaseName;
	}

	/**
	 * Set the value related to the column: phase_name
	 * @param phaseName the phase_name value
	 */
	public void setPhaseName (java.lang.String phaseName) {
		this.phaseName = phaseName;
	}



	/**
	 * Return the value associated with the column: phase_short_name
	 */
	public java.lang.String getPhaseShortName () {
		return phaseShortName;
	}

	/**
	 * Set the value related to the column: phase_short_name
	 * @param phaseShortName the phase_short_name value
	 */
	public void setPhaseShortName (java.lang.String phaseShortName) {
		this.phaseShortName = phaseShortName;
	}



	/**
	 * Return the value associated with the column: phase_type
	 */
	public java.lang.Integer getPhaseType () {
		return phaseType;
	}

	/**
	 * Set the value related to the column: phase_type
	 * @param phaseType the phase_type value
	 */
	public void setPhaseType (java.lang.Integer phaseType) {
		this.phaseType = phaseType;
	}



	/**
	 * Return the value associated with the column: issue_kind
	 */
	public java.lang.String getIssueKind () {
		return issueKind;
	}

	/**
	 * Set the value related to the column: issue_kind
	 * @param issueKind the issue_kind value
	 */
	public void setIssueKind (java.lang.String issueKind) {
		this.issueKind = issueKind;
	}



	/**
	 * Return the value associated with the column: get_table
	 */
	public java.lang.String getGetTable () {
		return getTable;
	}

	/**
	 * Set the value related to the column: get_table
	 * @param getTable the get_table value
	 */
	public void setGetTable (java.lang.String getTable) {
		this.getTable = getTable;
	}



	/**
	 * Return the value associated with the column: exec_when
	 */
	public java.lang.String getExecWhen () {
		return execWhen;
	}

	/**
	 * Set the value related to the column: exec_when
	 * @param execWhen the exec_when value
	 */
	public void setExecWhen (java.lang.String execWhen) {
		this.execWhen = execWhen;
	}



	/**
	 * Return the value associated with the column: voucher_date_rule
	 */
	public java.lang.Integer getVoucherDateRule () {
		return voucherDateRule;
	}

	/**
	 * Set the value related to the column: voucher_date_rule
	 * @param voucherDateRule the voucher_date_rule value
	 */
	public void setVoucherDateRule (java.lang.Integer voucherDateRule) {
		this.voucherDateRule = voucherDateRule;
	}



	/**
	 * Return the value associated with the column: phase_serial
	 */
	public java.lang.Integer getPhaseSerial () {
		return phaseSerial;
	}

	/**
	 * Set the value related to the column: phase_serial
	 * @param phaseSerial the phase_serial value
	 */
	public void setPhaseSerial (java.lang.Integer phaseSerial) {
		this.phaseSerial = phaseSerial;
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



	/**
	 * Return the value associated with the column: accountPhaseDets
	 */
	public java.util.Set<tw.gov.nta.sql.debt.account.AccountPhaseDet> getAccountPhaseDets () {
		return accountPhaseDets;
	}

	/**
	 * Set the value related to the column: accountPhaseDets
	 * @param accountPhaseDets the accountPhaseDets value
	 */
	public void setAccountPhaseDets (java.util.Set<tw.gov.nta.sql.debt.account.AccountPhaseDet> accountPhaseDets) {
		this.accountPhaseDets = accountPhaseDets;
	}

	public void addToaccountPhaseDets (tw.gov.nta.sql.debt.account.AccountPhaseDet accountPhaseDet) {
		if (null == getAccountPhaseDets()) setAccountPhaseDets(new java.util.TreeSet<tw.gov.nta.sql.debt.account.AccountPhaseDet>());
		getAccountPhaseDets().add(accountPhaseDet);
	}



	/**
	 * Return the value associated with the column: vouchers
	 */
	public java.util.Set<tw.gov.nta.sql.account.VoucherMain> getVouchers () {
		return vouchers;
	}

	/**
	 * Set the value related to the column: vouchers
	 * @param vouchers the vouchers value
	 */
	public void setVouchers (java.util.Set<tw.gov.nta.sql.account.VoucherMain> vouchers) {
		this.vouchers = vouchers;
	}

	public void addTovouchers (tw.gov.nta.sql.account.VoucherMain voucherMain) {
		if (null == getVouchers()) setVouchers(new java.util.TreeSet<tw.gov.nta.sql.account.VoucherMain>());
		getVouchers().add(voucherMain);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.account.AccountPhaseMain)) return false;
		else {
			tw.gov.nta.sql.debt.account.AccountPhaseMain accountPhaseMain = (tw.gov.nta.sql.debt.account.AccountPhaseMain) obj;
			if (null == this.getId() || null == accountPhaseMain.getId()) return false;
			else return (this.getId().equals(accountPhaseMain.getId()));
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