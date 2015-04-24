package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.math.BigInteger;
import java.io.Serializable;


/**
 * This is an object that contains data related to the debt_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="debt_main"
 */

public abstract class BaseDebtMain  implements Comparable, Serializable {

	public static String REF = "DebtMain";
	public static String PROP_BANK = "bank";
	public static String PROP_REMARK = "remark";
	public static String PROP_BUDGET_YEAR = "budgetYear";
	public static String PROP_ISSUE = "issue";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_ORIGIN_INTEREST_AMOUNT = "originInterestAmount";
	public static String PROP_ACCRUE = "accrue";
	public static String PROP_ACCRUE_DATE = "accrueDate";
	public static String PROP_USERID = "userid";
	public static String PROP_DEBT_SERIAL = "debtSerial";
	public static String PROP_COMPARE_FLAG = "compareFlag";
	public static String PROP_FALL_AMOUNT = "fallAmount";
	public static String PROP_DEBT_CODE = "debtCode";
	public static String PROP_REAL_AMOUNT = "realAmount";
	public static String PROP_ISSUE_AMOUNT = "issueAmount";
	public static String PROP_COMPARE_AMOUNT = "compareAmount";
	public static String PROP_GET = "Get";
	public static String PROP_INTEREST_DATE = "interestDate";
	public static String PROP_DIVERSITY_AMOUNT = "diversityAmount";
	public static String PROP_ISSUE_COST_AMOUNT = "issueCostAmount";
	public static String PROP_ID = "id";
	public static String PROP_PAYABLE_INTEREST_AMOUNT = "payableInterestAmount";
	public static String PROP_BUDGET_CODE = "budgetCode";
	public static String PROP_COMPARE_RATE = "compareRate";


	// constructors
	public BaseDebtMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDebtMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDebtMain (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.IssueMain issue,
		java.lang.Integer debtCode,
		java.lang.Integer budgetCode) {

		this.setId(id);
		this.setIssue(issue);
		this.setDebtCode(debtCode);
		this.setBudgetCode(budgetCode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer debtCode;
	private java.lang.Integer budgetCode;
	private java.math.BigDecimal realAmount;
	private java.math.BigDecimal issueAmount;
	private java.math.BigDecimal originInterestAmount;
	private java.math.BigDecimal compareAmount;
	private java.lang.String accrue;
	private java.lang.String compareFlag;
	private java.util.Date accrueDate;
	private java.math.BigDecimal compareRate;
	private java.lang.String userid;
	private java.util.Date modDate;
	private java.util.Date interestDate;
	private java.math.BigDecimal diversityAmount;
	private java.math.BigDecimal issueCostAmount;
	private java.math.BigDecimal fallAmount;
	private java.lang.String get;
	private java.lang.String budgetYear;
	private java.lang.String remark;
	private java.math.BigDecimal payableInterestAmount;
	private java.lang.String debtSerial;

	// many to one
	private tw.gov.nta.sql.debt.IssueMain issue;
	private tw.gov.nta.sql.debt.BankRef bank;

	// collections
	private java.util.Set<tw.gov.nta.sql.debt.InterestAdjustMain> interestAdjustMains;
	private java.util.Set<tw.gov.nta.sql.debt.DebtRateDet> debtRateDets;
	private java.util.Set<tw.gov.nta.sql.debt.DebtPlanDet> debtPlanDets;



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
	 * Return the value associated with the column: ISSUE_AMOUNT
	 */
	public java.math.BigDecimal getIssueAmount () {
		return issueAmount;
	}

	/**
	 * Set the value related to the column: ISSUE_AMOUNT
	 * @param issueAmount the ISSUE_AMOUNT value
	 */
	public void setIssueAmount (java.math.BigDecimal issueAmount) {
		this.issueAmount = issueAmount;
	}



	/**
	 * Return the value associated with the column: ORIGIN_INTEREST_AMOUNT
	 */
	public java.math.BigDecimal getOriginInterestAmount () {
		return originInterestAmount;
	}

	/**
	 * Set the value related to the column: ORIGIN_INTEREST_AMOUNT
	 * @param originInterestAmount the ORIGIN_INTEREST_AMOUNT value
	 */
	public void setOriginInterestAmount (java.math.BigDecimal originInterestAmount) {
		this.originInterestAmount = originInterestAmount;
	}



	/**
	 * Return the value associated with the column: COMPARE_AMOUNT
	 */
	public java.math.BigDecimal getCompareAmount () {
		return compareAmount;
	}

	/**
	 * Set the value related to the column: COMPARE_AMOUNT
	 * @param compareAmount the COMPARE_AMOUNT value
	 */
	public void setCompareAmount (java.math.BigDecimal compareAmount) {
		this.compareAmount = compareAmount;
	}



	/**
	 * Return the value associated with the column: ACCRUE
	 */
	public java.lang.String getAccrue () {
		return accrue;
	}

	/**
	 * Set the value related to the column: ACCRUE
	 * @param accrue the ACCRUE value
	 */
	public void setAccrue (java.lang.String accrue) {
		this.accrue = accrue;
	}



	/**
	 * Return the value associated with the column: compare_flag
	 */
	public java.lang.String getCompareFlag () {
		return compareFlag;
	}

	/**
	 * Set the value related to the column: compare_flag
	 * @param compareFlag the compare_flag value
	 */
	public void setCompareFlag (java.lang.String compareFlag) {
		this.compareFlag = compareFlag;
	}



	/**
	 * Return the value associated with the column: ACCRUE_DATE
	 */
	public java.util.Date getAccrueDate () {
		return accrueDate;
	}

	/**
	 * Set the value related to the column: ACCRUE_DATE
	 * @param accrueDate the ACCRUE_DATE value
	 */
	public void setAccrueDate (java.util.Date accrueDate) {
		this.accrueDate = accrueDate;
	}



	/**
	 * Return the value associated with the column: COMPARE_RATE
	 */
	public java.math.BigDecimal getCompareRate () {
		return compareRate;
	}

	/**
	 * Set the value related to the column: COMPARE_RATE
	 * @param compareRate the COMPARE_RATE value
	 */
	public void setCompareRate (java.math.BigDecimal compareRate) {
		this.compareRate = compareRate;
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
	 * Return the value associated with the column: interest_date
	 */
	public java.util.Date getInterestDate () {
		return interestDate;
	}

	/**
	 * Set the value related to the column: interest_date
	 * @param interestDate the interest_date value
	 */
	public void setInterestDate (java.util.Date interestDate) {
		this.interestDate = interestDate;
	}



	/**
	 * Return the value associated with the column: DIVERSITY_AMOUNT
	 */
	public java.math.BigDecimal getDiversityAmount () {
		return diversityAmount;
	}

	/**
	 * Set the value related to the column: DIVERSITY_AMOUNT
	 * @param diversityAmount the DIVERSITY_AMOUNT value
	 */
	public void setDiversityAmount (java.math.BigDecimal diversityAmount) {
		this.diversityAmount = diversityAmount;
	}



	/**
	 * Return the value associated with the column: FALL_AMOUNT
	 */
	public java.math.BigDecimal getFallAmount () {
		return fallAmount;
	}

	/**
	 * Set the value related to the column: FALL_AMOUNT
	 * @param fallAmount the FALL_AMOUNT value
	 */
	public void setFallAmount (java.math.BigDecimal fallAmount) {
		this.fallAmount = fallAmount;
	}



	/**
	 * Return the value associated with the column: GET
	 */
	public java.lang.String getGet () {
		return get;
	}

	/**
	 * Set the value related to the column: GET
	 * @param get the GET value
	 */
	public void setGet (java.lang.String get) {
		this.get = get;
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
	 * Return the value associated with the column: payable_interest_amount
	 */
	public java.math.BigDecimal getPayableInterestAmount () {
		return payableInterestAmount;
	}

	/**
	 * Set the value related to the column: payable_interest_amount
	 * @param payableInterestAmount the payable_interest_amount value
	 */
	public void setPayableInterestAmount (java.math.BigDecimal payableInterestAmount) {
		this.payableInterestAmount = payableInterestAmount;
	}



	/**
	 * Return the value associated with the column: debt_serial
	 */
	public java.lang.String getDebtSerial () {
		return debtSerial;
	}

	/**
	 * Set the value related to the column: debt_serial
	 * @param debtSerial the debt_serial value
	 */
	public void setDebtSerial (java.lang.String debtSerial) {
		this.debtSerial = debtSerial;
	}



	/**
	 * Return the value associated with the column: ISSUE_ID
	 */
	public tw.gov.nta.sql.debt.IssueMain getIssue () {
		return issue;
	}

	/**
	 * Set the value related to the column: ISSUE_ID
	 * @param issue the ISSUE_ID value
	 */
	public void setIssue (tw.gov.nta.sql.debt.IssueMain issue) {
		this.issue = issue;
	}



	/**
	 * Return the value associated with the column: BANK_ID
	 */
	public tw.gov.nta.sql.debt.BankRef getBank () {
		return bank;
	}

	/**
	 * Set the value related to the column: BANK_ID
	 * @param bank the BANK_ID value
	 */
	public void setBank (tw.gov.nta.sql.debt.BankRef bank) {
		this.bank = bank;
	}



	/**
	 * Return the value associated with the column: interestAdjustMains
	 */
	public java.util.Set<tw.gov.nta.sql.debt.InterestAdjustMain> getInterestAdjustMains () {
		return interestAdjustMains;
	}

	/**
	 * Set the value related to the column: interestAdjustMains
	 * @param interestAdjustMains the interestAdjustMains value
	 */
	public void setInterestAdjustMains (java.util.Set<tw.gov.nta.sql.debt.InterestAdjustMain> interestAdjustMains) {
		this.interestAdjustMains = interestAdjustMains;
	}

	public void addTointerestAdjustMains (tw.gov.nta.sql.debt.InterestAdjustMain interestAdjustMain) {
		if (null == getInterestAdjustMains()) setInterestAdjustMains(new java.util.TreeSet<tw.gov.nta.sql.debt.InterestAdjustMain>());
		getInterestAdjustMains().add(interestAdjustMain);
	}



	/**
	 * Return the value associated with the column: debtRateDets
	 */
	public java.util.Set<tw.gov.nta.sql.debt.DebtRateDet> getDebtRateDets () {
		return debtRateDets;
	}

	/**
	 * Set the value related to the column: debtRateDets
	 * @param debtRateDets the debtRateDets value
	 */
	public void setDebtRateDets (java.util.Set<tw.gov.nta.sql.debt.DebtRateDet> debtRateDets) {
		this.debtRateDets = debtRateDets;
	}

	public void addTodebtRateDets (tw.gov.nta.sql.debt.DebtRateDet debtRateDet) {
		if (null == getDebtRateDets()) setDebtRateDets(new java.util.TreeSet<tw.gov.nta.sql.debt.DebtRateDet>());
		getDebtRateDets().add(debtRateDet);
	}



	/**
	 * Return the value associated with the column: debtPlanDets
	 */
	public java.util.Set<tw.gov.nta.sql.debt.DebtPlanDet> getDebtPlanDets () {
		return debtPlanDets;
	}

	/**
	 * Set the value related to the column: debtPlanDets
	 * @param debtPlanDets the debtPlanDets value
	 */
	public void setDebtPlanDets (java.util.Set<tw.gov.nta.sql.debt.DebtPlanDet> debtPlanDets) {
		this.debtPlanDets = debtPlanDets;
	}

	public void addTodebtPlanDets (tw.gov.nta.sql.debt.DebtPlanDet debtPlanDet) {
		if (null == getDebtPlanDets()) setDebtPlanDets(new java.util.TreeSet<tw.gov.nta.sql.debt.DebtPlanDet>());
		getDebtPlanDets().add(debtPlanDet);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.DebtMain)) return false;
		else {
			tw.gov.nta.sql.debt.DebtMain debtMain = (tw.gov.nta.sql.debt.DebtMain) obj;
			if (null == this.getId() || null == debtMain.getId()) return false;
			else return (this.getId().equals(debtMain.getId()));
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

	public java.math.BigDecimal getIssueCostAmount() {
		return issueCostAmount;
	}

	public void setIssueCostAmount(java.math.BigDecimal issueCostAmount) {
		this.issueCostAmount = issueCostAmount;
	}


}