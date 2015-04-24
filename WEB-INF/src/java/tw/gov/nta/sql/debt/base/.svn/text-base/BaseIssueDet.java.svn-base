package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the issue_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="issue_det"
 */

public abstract class BaseIssueDet  implements Comparable, Serializable {

	public static String REF = "IssueDet";
	public static String PROP_PLAN_AMOUNT = "planAmount";
	public static String PROP_DELETE_REMARK = "deleteRemark";
	public static String PROP_DEBT_CODE = "debtCode";
	public static String PROP_REAL_AMOUNT = "realAmount";
	public static String PROP_ISSUE_ID = "issueId";
	public static String PROP_BUDGET_YEAR = "budgetYear";
	public static String PROP_ID = "id";
	public static String PROP_BUDGET_CODE = "budgetCode";


	// constructors
	public BaseIssueDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIssueDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer issueId;
	private java.lang.Integer debtCode;
	private java.lang.Integer budgetCode;
	private java.lang.String budgetYear;
	private java.math.BigDecimal planAmount;
	private java.math.BigDecimal realAmount;
	private java.lang.String deleteRemark;



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
	 * Return the value associated with the column: issue_id
	 */
	public java.lang.Integer getIssueId () {
		return issueId;
	}

	/**
	 * Set the value related to the column: issue_id
	 * @param issueId the issue_id value
	 */
	public void setIssueId (java.lang.Integer issueId) {
		this.issueId = issueId;
	}



	/**
	 * Return the value associated with the column: Debt_code
	 */
	public java.lang.Integer getDebtCode () {
		return debtCode;
	}

	/**
	 * Set the value related to the column: Debt_code
	 * @param debtCode the Debt_code value
	 */
	public void setDebtCode (java.lang.Integer debtCode) {
		this.debtCode = debtCode;
	}



	/**
	 * Return the value associated with the column: Budget_code
	 */
	public java.lang.Integer getBudgetCode () {
		return budgetCode;
	}

	/**
	 * Set the value related to the column: Budget_code
	 * @param budgetCode the Budget_code value
	 */
	public void setBudgetCode (java.lang.Integer budgetCode) {
		this.budgetCode = budgetCode;
	}



	/**
	 * Return the value associated with the column: budget_year
	 */
	public java.lang.String getBudgetYear () {
		return budgetYear;
	}

	/**
	 * Set the value related to the column: budget_year
	 * @param budgetYear the budget_year value
	 */
	public void setBudgetYear (java.lang.String budgetYear) {
		this.budgetYear = budgetYear;
	}



	/**
	 * Return the value associated with the column: plan_amount
	 */
	public java.math.BigDecimal getPlanAmount () {
		return planAmount;
	}

	/**
	 * Set the value related to the column: plan_amount
	 * @param planAmount the plan_amount value
	 */
	public void setPlanAmount (java.math.BigDecimal planAmount) {
		this.planAmount = planAmount;
	}



	/**
	 * Return the value associated with the column: real_amount
	 */
	public java.math.BigDecimal getRealAmount () {
		return realAmount;
	}

	/**
	 * Set the value related to the column: real_amount
	 * @param realAmount the real_amount value
	 */
	public void setRealAmount (java.math.BigDecimal realAmount) {
		this.realAmount = realAmount;
	}



	/**
	 * Return the value associated with the column: delete_remark
	 */
	public java.lang.String getDeleteRemark () {
		return deleteRemark;
	}

	/**
	 * Set the value related to the column: delete_remark
	 * @param deleteRemark the delete_remark value
	 */
	public void setDeleteRemark (java.lang.String deleteRemark) {
		this.deleteRemark = deleteRemark;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.IssueDet)) return false;
		else {
			tw.gov.nta.sql.debt.IssueDet issueDet = (tw.gov.nta.sql.debt.IssueDet) obj;
			if (null == this.getId() || null == issueDet.getId()) return false;
			else return (this.getId().equals(issueDet.getId()));
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