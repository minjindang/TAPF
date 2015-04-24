package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Central_statistics_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Central_statistics_main"
 */

public abstract class BaseCentralStatisticsMain  implements Comparable, Serializable {

	public static String REF = "CentralStatisticsMain";
	public static String PROP_ACCOUNT = "account";
	public static String PROP_INTEREST_AMOUNT = "interestAmount";
	public static String PROP_YEAR_KIND = "yearKind";
	public static String PROP_DEBT = "debt";
	public static String PROP_BOUND_CODE = "boundCode";
	public static String PROP_REMAIN_AMOUNT = "remainAmount";
	public static String PROP_ACCOUNT_TYPE = "accountType";
	public static String PROP_ACCOUNT_YEAR = "accountYear";
	public static String PROP_DEBT_TYPE = "debtType";
	public static String PROP_DEBT_CODE = "debtCode";
	public static String PROP_INOUT_TYPE = "inoutType";
	public static String PROP_ACCOUNT_KIND = "accountKind";
	public static String PROP_ISSUE_AMOUNT = "issueAmount";
	public static String PROP_PAY_AMOUNT = "payAmount";
	public static String PROP_ID = "id";
	public static String PROP_BUDGET_CODE = "budgetCode";


	// constructors
	public BaseCentralStatisticsMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCentralStatisticsMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCentralStatisticsMain (
		java.lang.Integer id,
		java.lang.String accountYear,
		java.lang.Integer budgetCode,
		java.lang.Integer debtCode,
		java.lang.String debtType,
		java.lang.String boundCode,
		boolean debt,
		java.lang.String accountKind,
		boolean account,
		java.math.BigDecimal issueAmount,
		java.math.BigDecimal payAmount,
		java.math.BigDecimal remainAmount,
		java.math.BigDecimal interestAmount) {

		this.setId(id);
		this.setAccountYear(accountYear);
		this.setBudgetCode(budgetCode);
		this.setDebtCode(debtCode);
		this.setDebtType(debtType);
		this.setBoundCode(boundCode);
		this.setDebt(debt);
		this.setAccountKind(accountKind);
		this.setAccount(account);
		this.setIssueAmount(issueAmount);
		this.setPayAmount(payAmount);
		this.setRemainAmount(remainAmount);
		this.setInterestAmount(interestAmount);
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
	private java.lang.String debtType;
	private java.lang.String boundCode;
	private boolean debt;
	private java.lang.String accountKind;
	private boolean account;
	private java.math.BigDecimal issueAmount;
	private java.math.BigDecimal payAmount;
	private java.math.BigDecimal remainAmount;
	private java.math.BigDecimal interestAmount;
	private java.lang.String yearKind;
	private java.lang.String accountType;
	private java.lang.String inoutType;



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
	 * Return the value associated with the column: BOUND_CODE
	 */
	public java.lang.String getBoundCode () {
		return boundCode;
	}

	/**
	 * Set the value related to the column: BOUND_CODE
	 * @param boundCode the BOUND_CODE value
	 */
	public void setBoundCode (java.lang.String boundCode) {
		this.boundCode = boundCode;
	}



	/**
	 * Return the value associated with the column: IS_DEBT
	 */
	public boolean isDebt () {
		return debt;
	}

	/**
	 * Set the value related to the column: IS_DEBT
	 * @param debt the IS_DEBT value
	 */
	public void setDebt (boolean debt) {
		this.debt = debt;
	}



	/**
	 * Return the value associated with the column: ACCOUNT_KIND
	 */
	public java.lang.String getAccountKind () {
		return accountKind;
	}

	/**
	 * Set the value related to the column: ACCOUNT_KIND
	 * @param accountKind the ACCOUNT_KIND value
	 */
	public void setAccountKind (java.lang.String accountKind) {
		this.accountKind = accountKind;
	}



	/**
	 * Return the value associated with the column: IS_ACCOUNT
	 */
	public boolean isAccount () {
		return account;
	}

	/**
	 * Set the value related to the column: IS_ACCOUNT
	 * @param account the IS_ACCOUNT value
	 */
	public void setAccount (boolean account) {
		this.account = account;
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
	 * Return the value associated with the column: PAY_AMOUNT
	 */
	public java.math.BigDecimal getPayAmount () {
		return payAmount;
	}

	/**
	 * Set the value related to the column: PAY_AMOUNT
	 * @param payAmount the PAY_AMOUNT value
	 */
	public void setPayAmount (java.math.BigDecimal payAmount) {
		this.payAmount = payAmount;
	}



	/**
	 * Return the value associated with the column: REMAIN_AMOUNT
	 */
	public java.math.BigDecimal getRemainAmount () {
		return remainAmount;
	}

	/**
	 * Set the value related to the column: REMAIN_AMOUNT
	 * @param remainAmount the REMAIN_AMOUNT value
	 */
	public void setRemainAmount (java.math.BigDecimal remainAmount) {
		this.remainAmount = remainAmount;
	}



	/**
	 * Return the value associated with the column: INTEREST_AMOUNT
	 */
	public java.math.BigDecimal getInterestAmount () {
		return interestAmount;
	}

	/**
	 * Set the value related to the column: INTEREST_AMOUNT
	 * @param interestAmount the INTEREST_AMOUNT value
	 */
	public void setInterestAmount (java.math.BigDecimal interestAmount) {
		this.interestAmount = interestAmount;
	}



	/**
	 * Return the value associated with the column: year_kind
	 */
	public java.lang.String getYearKind () {
		return yearKind;
	}

	/**
	 * Set the value related to the column: year_kind
	 * @param yearKind the year_kind value
	 */
	public void setYearKind (java.lang.String yearKind) {
		this.yearKind = yearKind;
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
	 * Return the value associated with the column: inout_type
	 */
	public java.lang.String getInoutType () {
		return inoutType;
	}

	/**
	 * Set the value related to the column: inout_type
	 * @param inoutType the inout_type value
	 */
	public void setInoutType (java.lang.String inoutType) {
		this.inoutType = inoutType;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.CentralStatisticsMain)) return false;
		else {
			tw.gov.nta.sql.CentralStatisticsMain centralStatisticsMain = (tw.gov.nta.sql.CentralStatisticsMain) obj;
			if (null == this.getId() || null == centralStatisticsMain.getId()) return false;
			else return (this.getId().equals(centralStatisticsMain.getId()));
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