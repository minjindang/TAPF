package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the debt_rate_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="debt_rate_det"
 */

public abstract class BaseDebtRateDet  implements Comparable, Serializable {

	public static String REF = "DebtRateDet";
	public static String PROP_DEBT_RATE = "debtRate";
	public static String PROP_GROUP_ID = "groupId";
	public static String PROP_SUSPEND_DATE = "suspendDate";
	public static String PROP_DEBT = "debt";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_EFFECTIVE_DATE = "effectiveDate";
	public static String PROP_SEQ_NO = "seqNo";
	public static String PROP_USERID = "userid";
	public static String PROP_ID = "id";
	public static String PROP_DELETE_MARK = "deleteMark";


	// constructors
	public BaseDebtRateDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDebtRateDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDebtRateDet (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtMain debt,
		java.math.BigDecimal debtRate,
		java.util.Date effectiveDate,
		java.util.Date suspendDate,
		java.lang.String deleteMark,
		java.lang.Integer groupId) {

		this.setId(id);
		this.setDebt(debt);
		this.setDebtRate(debtRate);
		this.setEffectiveDate(effectiveDate);
		this.setSuspendDate(suspendDate);
		this.setDeleteMark(deleteMark);
		this.setGroupId(groupId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal debtRate;
	private java.lang.String deleteMark;
	private java.util.Date effectiveDate;
	private java.lang.Integer groupId;
	private java.util.Date modDate;
	private java.lang.Integer seqNo;
	private java.util.Date suspendDate;
	private java.lang.String userid;

	// many to one
	private tw.gov.nta.sql.debt.DebtMain debt;



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
	 * Return the value associated with the column: DEBT_RATE
	 */
	public java.math.BigDecimal getDebtRate () {
		return debtRate;
	}

	/**
	 * Set the value related to the column: DEBT_RATE
	 * @param debtRate the DEBT_RATE value
	 */
	public void setDebtRate (java.math.BigDecimal debtRate) {
		this.debtRate = debtRate;
	}



	/**
	 * Return the value associated with the column: DELETE_MARK
	 */
	public java.lang.String getDeleteMark () {
		return deleteMark;
	}

	/**
	 * Set the value related to the column: DELETE_MARK
	 * @param deleteMark the DELETE_MARK value
	 */
	public void setDeleteMark (java.lang.String deleteMark) {
		this.deleteMark = deleteMark;
	}



	/**
	 * Return the value associated with the column: EFFECTIVE_DATE
	 */
	public java.util.Date getEffectiveDate () {
		return effectiveDate;
	}

	/**
	 * Set the value related to the column: EFFECTIVE_DATE
	 * @param effectiveDate the EFFECTIVE_DATE value
	 */
	public void setEffectiveDate (java.util.Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}



	/**
	 * Return the value associated with the column: GROUP_ID
	 */
	public java.lang.Integer getGroupId () {
		return groupId;
	}

	/**
	 * Set the value related to the column: GROUP_ID
	 * @param groupId the GROUP_ID value
	 */
	public void setGroupId (java.lang.Integer groupId) {
		this.groupId = groupId;
	}



	/**
	 * Return the value associated with the column: MOD_DATE
	 */
	public java.util.Date getModDate () {
		return modDate;
	}

	/**
	 * Set the value related to the column: MOD_DATE
	 * @param modDate the MOD_DATE value
	 */
	public void setModDate (java.util.Date modDate) {
		this.modDate = modDate;
	}



	/**
	 * Return the value associated with the column: SEQ_NO
	 */
	public java.lang.Integer getSeqNo () {
		return seqNo;
	}

	/**
	 * Set the value related to the column: SEQ_NO
	 * @param seqNo the SEQ_NO value
	 */
	public void setSeqNo (java.lang.Integer seqNo) {
		this.seqNo = seqNo;
	}



	/**
	 * Return the value associated with the column: SUSPEND_DATE
	 */
	public java.util.Date getSuspendDate () {
		return suspendDate;
	}

	/**
	 * Set the value related to the column: SUSPEND_DATE
	 * @param suspendDate the SUSPEND_DATE value
	 */
	public void setSuspendDate (java.util.Date suspendDate) {
		this.suspendDate = suspendDate;
	}



	/**
	 * Return the value associated with the column: USERID
	 */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: USERID
	 * @param userid the USERID value
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
	}



	/**
	 * Return the value associated with the column: DEBT_ID
	 */
	public tw.gov.nta.sql.debt.DebtMain getDebt () {
		return debt;
	}

	/**
	 * Set the value related to the column: DEBT_ID
	 * @param debt the DEBT_ID value
	 */
	public void setDebt (tw.gov.nta.sql.debt.DebtMain debt) {
		this.debt = debt;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.DebtRateDet)) return false;
		else {
			tw.gov.nta.sql.debt.DebtRateDet debtRateDet = (tw.gov.nta.sql.debt.DebtRateDet) obj;
			if (null == this.getId() || null == debtRateDet.getId()) return false;
			else return (this.getId().equals(debtRateDet.getId()));
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