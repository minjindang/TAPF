package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Year_plan_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Year_plan_ref"
 */

public abstract class BaseYearPlanRef  implements Comparable, Serializable {

	public static String REF = "YearPlanRef";
	public static String PROP_PLAN_YEAR = "planYear";
	public static String PROP_YEAR_AMOUNT = "yearAmount";
	public static String PROP_USRID = "usrid";
	public static String PROP_REMARK = "remark";
	public static String PROP_DEBIT_TYPE = "debitType";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_ID = "id";
	public static String PROP_BORROW_AMOUNT = "borrowAmount";
	public static String PROP_BUDGET_CODE = "budgetCode";


	// constructors
	public BaseYearPlanRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseYearPlanRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseYearPlanRef (
		java.lang.Integer id,
		java.lang.String planYear,
		java.lang.Integer budgetCode,
		java.math.BigDecimal yearAmount,
		java.math.BigDecimal borrowAmount,
		java.lang.Integer debitType,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		this.setId(id);
		this.setPlanYear(planYear);
		this.setBudgetCode(budgetCode);
		this.setYearAmount(yearAmount);
		this.setBorrowAmount(borrowAmount);
		this.setDebitType(debitType);
		this.setUsrid(usrid);
		this.setModDate(modDate);
		this.setCreateDate(createDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String planYear;
	private java.lang.Integer budgetCode;
	private java.math.BigDecimal yearAmount;
	private java.math.BigDecimal borrowAmount;
	private java.lang.Integer debitType;
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;



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
	 * Return the value associated with the column: PLAN_YEAR
	 */
	public java.lang.String getPlanYear () {
		return planYear;
	}

	/**
	 * Set the value related to the column: PLAN_YEAR
	 * @param planYear the PLAN_YEAR value
	 */
	public void setPlanYear (java.lang.String planYear) {
		this.planYear = planYear;
	}



	/**
	 * Return the value associated with the column: BUDGET_CODE
	 */
	public java.lang.Integer getBudgetCode () {
		return budgetCode;
	}

	/**
	 * Set the value related to the column: BUDGET_CODE
	 * @param budgetCode the BUDGET_CODE value
	 */
	public void setBudgetCode (java.lang.Integer budgetCode) {
		this.budgetCode = budgetCode;
	}



	/**
	 * Return the value associated with the column: YEAR_AMOUNT
	 */
	public java.math.BigDecimal getYearAmount () {
		return yearAmount;
	}

	/**
	 * Set the value related to the column: YEAR_AMOUNT
	 * @param yearAmount the YEAR_AMOUNT value
	 */
	public void setYearAmount (java.math.BigDecimal yearAmount) {
		this.yearAmount = yearAmount;
	}



	/**
	 * Return the value associated with the column: BORROW_AMOUNT
	 */
	public java.math.BigDecimal getBorrowAmount () {
		return borrowAmount;
	}

	/**
	 * Set the value related to the column: BORROW_AMOUNT
	 * @param borrowAmount the BORROW_AMOUNT value
	 */
	public void setBorrowAmount (java.math.BigDecimal borrowAmount) {
		this.borrowAmount = borrowAmount;
	}



	/**
	 * Return the value associated with the column: DEBIT_TYPE
	 */
	public java.lang.Integer getDebitType () {
		return debitType;
	}

	/**
	 * Set the value related to the column: DEBIT_TYPE
	 * @param debitType the DEBIT_TYPE value
	 */
	public void setDebitType (java.lang.Integer debitType) {
		this.debitType = debitType;
	}



	/**
	 * Return the value associated with the column: USRID
	 */
	public java.lang.String getUsrid () {
		return usrid;
	}

	/**
	 * Set the value related to the column: USRID
	 * @param usrid the USRID value
	 */
	public void setUsrid (java.lang.String usrid) {
		this.usrid = usrid;
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
	 * Return the value associated with the column: REMARK
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: REMARK
	 * @param remark the REMARK value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: CREATE_DATE
	 */
	public java.util.Date getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: CREATE_DATE
	 * @param createDate the CREATE_DATE value
	 */
	public void setCreateDate (java.util.Date createDate) {
		this.createDate = createDate;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.YearPlanRef)) return false;
		else {
			tw.gov.nta.sql.YearPlanRef yearPlanRef = (tw.gov.nta.sql.YearPlanRef) obj;
			if (null == this.getId() || null == yearPlanRef.getId()) return false;
			else return (this.getId().equals(yearPlanRef.getId()));
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