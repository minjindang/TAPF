package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.math.BigDecimal;
import java.io.Serializable;


/**
 * This is an object that contains data related to the interest_adjust_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="interest_adjust_main"
 */

public abstract class BaseInterestAdjustMain  implements Comparable, Serializable {

	public static String REF = "InterestAdjustMain";
	public static String PROP_ADJUST_TYPE = "adjustType";
	public static String PROP_DEBT_ID = "debtId";
	public static String PROP_GROUP_ID = "groupId";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_CHANGE_DATE = "changeDate";
	public static String PROP_CHANGE_RATE = "changeRate";
	public static String PROP_USERID = "userid";
	public static String PROP_PLAN = "plan";
	public static String PROP_ID = "id";
	public static String PROP_CHANGE_INTEREST_AMOUNT = "changeInterestAmount";


	// constructors
	public BaseInterestAdjustMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInterestAdjustMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseInterestAdjustMain (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtPlanDet plan,
		java.lang.Integer groupId,
		java.lang.Integer debtId,
		java.math.BigDecimal changeRate) {

		this.setId(id);
		this.setPlan(plan);
		this.setGroupId(groupId);
		this.setDebtId(debtId);
		this.setChangeRate(changeRate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date changeDate;
	private java.math.BigDecimal changeInterestAmount;
	private java.lang.Integer groupId;
	private java.lang.String userid;
	private java.util.Date modDate;
	private java.lang.Integer debtId;
	private java.lang.String adjustType;
	private java.math.BigDecimal changeRate;

	// many to one
	private tw.gov.nta.sql.debt.DebtPlanDet plan;



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
	 * Return the value associated with the column: CHANGE_DATE
	 */
	public java.util.Date getChangeDate () {
		return changeDate;
	}

	/**
	 * Set the value related to the column: CHANGE_DATE
	 * @param changeDate the CHANGE_DATE value
	 */
	public void setChangeDate (java.util.Date changeDate) {
		this.changeDate = changeDate;
	}



	/**
	 * Return the value associated with the column: CHANGE_INTEREST_AMOUNT
	 */
	public java.math.BigDecimal getChangeInterestAmount () {
		return changeInterestAmount;
	}

	/**
	 * Set the value related to the column: CHANGE_INTEREST_AMOUNT
	 * @param changeInterestAmount the CHANGE_INTEREST_AMOUNT value
	 */
	public void setChangeInterestAmount (java.math.BigDecimal changeInterestAmount) {
		this.changeInterestAmount = changeInterestAmount;
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
	 * Return the value associated with the column: debt_id
	 */
	public java.lang.Integer getDebtId () {
		return debtId;
	}

	/**
	 * Set the value related to the column: debt_id
	 * @param debtId the debt_id value
	 */
	public void setDebtId (java.lang.Integer debtId) {
		this.debtId = debtId;
	}



	/**
	 * Return the value associated with the column: adjust_type
	 */
	public java.lang.String getAdjustType () {
		return adjustType;
	}

	/**
	 * Set the value related to the column: adjust_type
	 * @param adjustType the adjust_type value
	 */
	public void setAdjustType (java.lang.String adjustType) {
		this.adjustType = adjustType;
	}



	/**
	 * Return the value associated with the column: plan_id
	 */
	public tw.gov.nta.sql.debt.DebtPlanDet getPlan () {
		return plan;
	}

	/**
	 * Set the value related to the column: plan_id
	 * @param plan the plan_id value
	 */
	public void setPlan (tw.gov.nta.sql.debt.DebtPlanDet plan) {
		this.plan = plan;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.InterestAdjustMain)) return false;
		else {
			tw.gov.nta.sql.debt.InterestAdjustMain interestAdjustMain = (tw.gov.nta.sql.debt.InterestAdjustMain) obj;
			if (null == this.getId() || null == interestAdjustMain.getId()) return false;
			else return (this.getId().equals(interestAdjustMain.getId()));
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
	
	/**
	 * Return the value associated with the column: debt_id
	 */
	public BigDecimal getChangeRate () {
		return changeRate;
	}

	/**
	 * Set the value related to the column: debt_id
	 * @param debtId the debt_id value
	 */
	public void setChangeRate (BigDecimal changeRate) {
		this.changeRate = changeRate;
	}


}