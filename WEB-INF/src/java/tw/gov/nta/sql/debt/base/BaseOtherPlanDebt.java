package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Other_plan_debt table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Other_plan_debt"
 */

public abstract class BaseOtherPlanDebt  implements Comparable, Serializable {

	public static String REF = "OtherPlanDebt";
	public static String PROP_YEARS = "years";
	public static String PROP_ISSUE_DATE = "issueDate";
	public static String PROP_DEBT_CODE = "debtCode";
	public static String PROP_PAY_DATE = "payDate";
	public static String PROP_CAPITAL_AMOUNT = "capitalAmount";
	public static String PROP_REPAY_DATE = "repayDate";
	public static String PROP_PAY_AMOUNT = "payAmount";
	public static String PROP_ISSUE_SERIAL = "issueSerial";
	public static String PROP_ID1 = "id1";
	public static String PROP_ID = "id";
	public static String PROP_DEBT_NAME = "debtName";


	// constructors
	public BaseOtherPlanDebt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtherPlanDebt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal capitalAmount;
	private java.lang.Integer debtCode;
	private java.lang.String debtName;
	private java.lang.Integer id1;
	private java.util.Date issueDate;
	private java.lang.String issueSerial;
	private java.math.BigDecimal payAmount;
	private java.util.Date payDate;
	private java.util.Date repayDate;
	private java.lang.Integer years;



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
	 * Return the value associated with the column: capital_amount
	 */
	public java.math.BigDecimal getCapitalAmount () {
		return capitalAmount;
	}

	/**
	 * Set the value related to the column: capital_amount
	 * @param capitalAmount the capital_amount value
	 */
	public void setCapitalAmount (java.math.BigDecimal capitalAmount) {
		this.capitalAmount = capitalAmount;
	}



	/**
	 * Return the value associated with the column: debt_code
	 */
	public java.lang.Integer getDebtCode () {
		return debtCode;
	}

	/**
	 * Set the value related to the column: debt_code
	 * @param debtCode the debt_code value
	 */
	public void setDebtCode (java.lang.Integer debtCode) {
		this.debtCode = debtCode;
	}



	/**
	 * Return the value associated with the column: debt_name
	 */
	public java.lang.String getDebtName () {
		return debtName;
	}

	/**
	 * Set the value related to the column: debt_name
	 * @param debtName the debt_name value
	 */
	public void setDebtName (java.lang.String debtName) {
		this.debtName = debtName;
	}



	/**
	 * Return the value associated with the column: id1
	 */
	public java.lang.Integer getId1 () {
		return id1;
	}

	/**
	 * Set the value related to the column: id1
	 * @param id1 the id1 value
	 */
	public void setId1 (java.lang.Integer id1) {
		this.id1 = id1;
	}



	/**
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate () {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * @param issueDate the issue_date value
	 */
	public void setIssueDate (java.util.Date issueDate) {
		this.issueDate = issueDate;
	}



	/**
	 * Return the value associated with the column: issue_serial
	 */
	public java.lang.String getIssueSerial () {
		return issueSerial;
	}

	/**
	 * Set the value related to the column: issue_serial
	 * @param issueSerial the issue_serial value
	 */
	public void setIssueSerial (java.lang.String issueSerial) {
		this.issueSerial = issueSerial;
	}



	/**
	 * Return the value associated with the column: pay_amount
	 */
	public java.math.BigDecimal getPayAmount () {
		return payAmount;
	}

	/**
	 * Set the value related to the column: pay_amount
	 * @param payAmount the pay_amount value
	 */
	public void setPayAmount (java.math.BigDecimal payAmount) {
		this.payAmount = payAmount;
	}



	/**
	 * Return the value associated with the column: pay_date
	 */
	public java.util.Date getPayDate () {
		return payDate;
	}

	/**
	 * Set the value related to the column: pay_date
	 * @param payDate the pay_date value
	 */
	public void setPayDate (java.util.Date payDate) {
		this.payDate = payDate;
	}



	/**
	 * Return the value associated with the column: repay_date
	 */
	public java.util.Date getRepayDate () {
		return repayDate;
	}

	/**
	 * Set the value related to the column: repay_date
	 * @param repayDate the repay_date value
	 */
	public void setRepayDate (java.util.Date repayDate) {
		this.repayDate = repayDate;
	}



	/**
	 * Return the value associated with the column: years
	 */
	public java.lang.Integer getYears () {
		return years;
	}

	/**
	 * Set the value related to the column: years
	 * @param years the years value
	 */
	public void setYears (java.lang.Integer years) {
		this.years = years;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.OtherPlanDebt)) return false;
		else {
			tw.gov.nta.sql.debt.OtherPlanDebt otherPlanDebt = (tw.gov.nta.sql.debt.OtherPlanDebt) obj;
			if (null == this.getId() || null == otherPlanDebt.getId()) return false;
			else return (this.getId().equals(otherPlanDebt.getId()));
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