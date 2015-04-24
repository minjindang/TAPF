package tw.gov.nta.sql.account.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the account_report_build table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="account_report_build"
 */

public abstract class BaseAccountReportBuild  implements Comparable, Serializable {

	public static String REF = "AccountReportBuild";
	public static String PROP_DEBT_TYPE = "debtType";
	public static String PROP_SEQUENCE = "sequence";
	public static String PROP_CONDITIONAL = "conditional";
	public static String PROP_REPORT_CODE = "reportCode";
	public static String PROP_ID = "id";


	// constructors
	public BaseAccountReportBuild () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccountReportBuild (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAccountReportBuild (
		java.lang.Integer id,
		java.lang.String debtType,
		java.lang.String reportCode,
		java.lang.Long sequence) {

		this.setId(id);
		this.setDebtType(debtType);
		this.setReportCode(reportCode);
		this.setSequence(sequence);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String debtType;
	private java.lang.String reportCode;
	private java.lang.Long sequence;
	private java.lang.String conditional;



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
	 * Return the value associated with the column: DEBT_TYPE
	 */
	public java.lang.String getDebtType () {
		return debtType;
	}

	/**
	 * Set the value related to the column: DEBT_TYPE
	 * @param debtType the DEBT_TYPE value
	 */
	public void setDebtType (java.lang.String debtType) {
		this.debtType = debtType;
	}



	/**
	 * Return the value associated with the column: REPORT_CODE
	 */
	public java.lang.String getReportCode () {
		return reportCode;
	}

	/**
	 * Set the value related to the column: REPORT_CODE
	 * @param reportCode the REPORT_CODE value
	 */
	public void setReportCode (java.lang.String reportCode) {
		this.reportCode = reportCode;
	}



	/**
	 * Return the value associated with the column: SEQUENCE
	 */
	public java.lang.Long getSequence () {
		return sequence;
	}

	/**
	 * Set the value related to the column: SEQUENCE
	 * @param sequence the SEQUENCE value
	 */
	public void setSequence (java.lang.Long sequence) {
		this.sequence = sequence;
	}



	/**
	 * Return the value associated with the column: CONDITIONAL
	 */
	public java.lang.String getConditional () {
		return conditional;
	}

	/**
	 * Set the value related to the column: CONDITIONAL
	 * @param conditional the CONDITIONAL value
	 */
	public void setConditional (java.lang.String conditional) {
		this.conditional = conditional;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.account.AccountReportBuild)) return false;
		else {
			tw.gov.nta.sql.account.AccountReportBuild accountReportBuild = (tw.gov.nta.sql.account.AccountReportBuild) obj;
			if (null == this.getId() || null == accountReportBuild.getId()) return false;
			else return (this.getId().equals(accountReportBuild.getId()));
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