package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Year_amount_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Year_amount_ref"
 */

public abstract class BaseYearAmountRef  implements Comparable, Serializable {

	public static String REF = "YearAmountRef";
	public static String PROP_DATA_TYPE = "dataType";
	public static String PROP_REMARK = "remark";
	public static String PROP_AUDIT_AMOUNT = "auditAmount";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_USERID = "userid";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_ACCOUNT_YEAR = "accountYear";
	public static String PROP_KEEP_DAMOUNT = "keepDamount";
	public static String PROP_DEBT_CODE = "debtCode";
	public static String PROP_BUDGET_AMOUNT = "budgetAmount";
	public static String PROP_KEEP_AMOUNT = "keepAmount";
	public static String PROP_REAL_YN = "realYn";
	public static String PROP_KEEP_YN = "keepYn";
	public static String PROP_AUDIT_UAMOUNT = "auditUamount";
	public static String PROP_BUDGET_UAMOUNT = "budgetUamount";
	public static String PROP_AUDIT_YN = "auditYn";
	public static String PROP_BUDGET_YN = "budgetYn";
	public static String PROP_BUDGET_DAMOUNT = "budgetDamount";
	public static String PROP_REAL_AMOUNT = "realAmount";
	public static String PROP_KEEP_UAMOUNT = "keepUamount";
	public static String PROP_REAL_DAMOUNT = "realDamount";
	public static String PROP_AUDIT_DAMOUNT = "auditDamount";
	public static String PROP_REAL_UAMOUNT = "realUamount";
	public static String PROP_ID = "id";
	public static String PROP_BUDGET_CODE = "budgetCode";


	// constructors
	public BaseYearAmountRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseYearAmountRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseYearAmountRef (
		java.lang.Integer id,
		java.util.Date modDate,
		java.util.Date createDate) {

		this.setId(id);
		this.setModDate(modDate);
		this.setCreateDate(createDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String accountYear;
	private java.lang.Integer budgetCode;
	private java.lang.Integer debtCode;
	private java.math.BigDecimal budgetAmount;
	private java.math.BigDecimal budgetDamount;
	private java.math.BigDecimal budgetUamount;
	private boolean budgetYn;
	private java.math.BigDecimal auditAmount;
	private java.math.BigDecimal auditDamount;
	private java.math.BigDecimal auditUamount;
	private boolean auditYn;
	private java.math.BigDecimal realAmount;
	private java.math.BigDecimal realDamount;
	private java.math.BigDecimal realUamount;
	private boolean realYn;
	private java.math.BigDecimal keepAmount;
	private java.math.BigDecimal keepDamount;
	private java.math.BigDecimal keepUamount;
	private boolean keepYn;
	private java.lang.String userid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;
	private java.lang.Integer dataType;



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
	 * Return the value associated with the column: ACCOUNT_YEAR
	 */
	public java.lang.String getAccountYear () {
		return accountYear;
	}

	/**
	 * Set the value related to the column: ACCOUNT_YEAR
	 * @param accountYear the ACCOUNT_YEAR value
	 */
	public void setAccountYear (java.lang.String accountYear) {
		this.accountYear = accountYear;
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
	 * Return the value associated with the column: DEBT_CODE
	 */
	public java.lang.Integer getDebtCode () {
		return debtCode;
	}

	/**
	 * Set the value related to the column: DEBT_CODE
	 * @param debtCode the DEBT_CODE value
	 */
	public void setDebtCode (java.lang.Integer debtCode) {
		this.debtCode = debtCode;
	}



	/**
	 * Return the value associated with the column: BUDGET_AMOUNT
	 */
	public java.math.BigDecimal getBudgetAmount () {
		return budgetAmount;
	}

	/**
	 * Set the value related to the column: BUDGET_AMOUNT
	 * @param budgetAmount the BUDGET_AMOUNT value
	 */
	public void setBudgetAmount (java.math.BigDecimal budgetAmount) {
		this.budgetAmount = budgetAmount;
	}



	/**
	 * Return the value associated with the column: BUDGET_DAMOUNT
	 */
	public java.math.BigDecimal getBudgetDamount () {
		return budgetDamount;
	}

	/**
	 * Set the value related to the column: BUDGET_DAMOUNT
	 * @param budgetDamount the BUDGET_DAMOUNT value
	 */
	public void setBudgetDamount (java.math.BigDecimal budgetDamount) {
		this.budgetDamount = budgetDamount;
	}



	/**
	 * Return the value associated with the column: BUDGET_UAMOUNT
	 */
	public java.math.BigDecimal getBudgetUamount () {
		return budgetUamount;
	}

	/**
	 * Set the value related to the column: BUDGET_UAMOUNT
	 * @param budgetUamount the BUDGET_UAMOUNT value
	 */
	public void setBudgetUamount (java.math.BigDecimal budgetUamount) {
		this.budgetUamount = budgetUamount;
	}



	/**
	 * Return the value associated with the column: BUDGET_YN
	 */
	public boolean isBudgetYn () {
		return budgetYn;
	}

	/**
	 * Set the value related to the column: BUDGET_YN
	 * @param budgetYn the BUDGET_YN value
	 */
	public void setBudgetYn (boolean budgetYn) {
		this.budgetYn = budgetYn;
	}



	/**
	 * Return the value associated with the column: AUDIT_AMOUNT
	 */
	public java.math.BigDecimal getAuditAmount () {
		return auditAmount;
	}

	/**
	 * Set the value related to the column: AUDIT_AMOUNT
	 * @param auditAmount the AUDIT_AMOUNT value
	 */
	public void setAuditAmount (java.math.BigDecimal auditAmount) {
		this.auditAmount = auditAmount;
	}



	/**
	 * Return the value associated with the column: AUDIT_DAMOUNT
	 */
	public java.math.BigDecimal getAuditDamount () {
		return auditDamount;
	}

	/**
	 * Set the value related to the column: AUDIT_DAMOUNT
	 * @param auditDamount the AUDIT_DAMOUNT value
	 */
	public void setAuditDamount (java.math.BigDecimal auditDamount) {
		this.auditDamount = auditDamount;
	}



	/**
	 * Return the value associated with the column: AUDIT_UAMOUNT
	 */
	public java.math.BigDecimal getAuditUamount () {
		return auditUamount;
	}

	/**
	 * Set the value related to the column: AUDIT_UAMOUNT
	 * @param auditUamount the AUDIT_UAMOUNT value
	 */
	public void setAuditUamount (java.math.BigDecimal auditUamount) {
		this.auditUamount = auditUamount;
	}



	/**
	 * Return the value associated with the column: AUDIT_YN
	 */
	public boolean isAuditYn () {
		return auditYn;
	}

	/**
	 * Set the value related to the column: AUDIT_YN
	 * @param auditYn the AUDIT_YN value
	 */
	public void setAuditYn (boolean auditYn) {
		this.auditYn = auditYn;
	}



	/**
	 * Return the value associated with the column: REAL_AMOUNT
	 */
	public java.math.BigDecimal getRealAmount () {
		return realAmount;
	}

	/**
	 * Set the value related to the column: REAL_AMOUNT
	 * @param realAmount the REAL_AMOUNT value
	 */
	public void setRealAmount (java.math.BigDecimal realAmount) {
		this.realAmount = realAmount;
	}



	/**
	 * Return the value associated with the column: REAL_DAMOUNT
	 */
	public java.math.BigDecimal getRealDamount () {
		return realDamount;
	}

	/**
	 * Set the value related to the column: REAL_DAMOUNT
	 * @param realDamount the REAL_DAMOUNT value
	 */
	public void setRealDamount (java.math.BigDecimal realDamount) {
		this.realDamount = realDamount;
	}



	/**
	 * Return the value associated with the column: REAL_UAMOUNT
	 */
	public java.math.BigDecimal getRealUamount () {
		return realUamount;
	}

	/**
	 * Set the value related to the column: REAL_UAMOUNT
	 * @param realUamount the REAL_UAMOUNT value
	 */
	public void setRealUamount (java.math.BigDecimal realUamount) {
		this.realUamount = realUamount;
	}



	/**
	 * Return the value associated with the column: REAL_YN
	 */
	public boolean isRealYn () {
		return realYn;
	}

	/**
	 * Set the value related to the column: REAL_YN
	 * @param realYn the REAL_YN value
	 */
	public void setRealYn (boolean realYn) {
		this.realYn = realYn;
	}



	/**
	 * Return the value associated with the column: KEEP_AMOUNT
	 */
	public java.math.BigDecimal getKeepAmount () {
		return keepAmount;
	}

	/**
	 * Set the value related to the column: KEEP_AMOUNT
	 * @param keepAmount the KEEP_AMOUNT value
	 */
	public void setKeepAmount (java.math.BigDecimal keepAmount) {
		this.keepAmount = keepAmount;
	}



	/**
	 * Return the value associated with the column: KEEP_DAMOUNT
	 */
	public java.math.BigDecimal getKeepDamount () {
		return keepDamount;
	}

	/**
	 * Set the value related to the column: KEEP_DAMOUNT
	 * @param keepDamount the KEEP_DAMOUNT value
	 */
	public void setKeepDamount (java.math.BigDecimal keepDamount) {
		this.keepDamount = keepDamount;
	}



	/**
	 * Return the value associated with the column: KEEP_UAMOUNT
	 */
	public java.math.BigDecimal getKeepUamount () {
		return keepUamount;
	}

	/**
	 * Set the value related to the column: KEEP_UAMOUNT
	 * @param keepUamount the KEEP_UAMOUNT value
	 */
	public void setKeepUamount (java.math.BigDecimal keepUamount) {
		this.keepUamount = keepUamount;
	}



	/**
	 * Return the value associated with the column: KEEP_YN
	 */
	public boolean isKeepYn () {
		return keepYn;
	}

	/**
	 * Set the value related to the column: KEEP_YN
	 * @param keepYn the KEEP_YN value
	 */
	public void setKeepYn (boolean keepYn) {
		this.keepYn = keepYn;
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



	/**
	 * Return the value associated with the column: data_type
	 */
	public java.lang.Integer getDataType () {
		return dataType;
	}

	/**
	 * Set the value related to the column: data_type
	 * @param dataType the data_type value
	 */
	public void setDataType (java.lang.Integer dataType) {
		this.dataType = dataType;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.YearAmountRef)) return false;
		else {
			tw.gov.nta.sql.YearAmountRef yearAmountRef = (tw.gov.nta.sql.YearAmountRef) obj;
			if (null == this.getId() || null == yearAmountRef.getId()) return false;
			else return (this.getId().equals(yearAmountRef.getId()));
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