package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the issue_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="issue_main"
 */

public abstract class BaseIssueMain  implements Comparable, Serializable {

	public static String REF = "IssueMain";
	public static String PROP_REMARK = "remark";
	public static String PROP_CHARGE_RATE = "chargeRate";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_USERID = "userid";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_FINISH_DATE = "finishDate";
	public static String PROP_ACCOUNT_YEAR = "accountYear";
	public static String PROP_PAY_LIMIT = "payLimit";
	public static String PROP_ISSUE_KIND = "issueKind";
	public static String PROP_SHOW_TYPE = "showType";
	public static String PROP_ISSUE_DATE = "issueDate";
	public static String PROP_DEBT_CODE = "debtCode";
	public static String PROP_RATE_KIND = "rateKind";
	public static String PROP_ISSUE_AMOUNT = "issueAmount";
	public static String PROP_CAPITAL_AMOUNT = "capitalAmount";
	public static String PROP_FIRST_REPAY_DATE = "firstRepayDate";
	public static String PROP_CONTINUE_DATE = "continueDate";
	public static String PROP_FIRST_INTEREST_DATE = "firstInterestDate";
	public static String PROP_DEBT_NAME = "debtName";
	public static String PROP_PAYABLE_INTEREST_AMOUNT = "payableInterestAmount";
	public static String PROP_AVERAGE_RATE = "averageRate";
	public static String PROP_ISSUE_INTERVAL = "issueInterval";
	public static String PROP_INTEREST_AMOUNT = "interestAmount";
	public static String PROP_SELL_AMOUNT = "sellAmount";
	public static String PROP_SOURCE_ISSUE_ID = "sourceIssueId";
	public static String PROP_INTEREST_ALTERNATE = "interestAlternate";
	public static String PROP_EXPECT_AMOUNT = "expectAmount";
	public static String PROP_BOND_TYPE = "bondType";
	public static String PROP_BOND_SELL_STATUS = "bondSellStatus";
	public static String PROP_ISSUE_SERIAL = "issueSerial";
	public static String PROP_ZERO_INTEREST_STATUS = "zeroInterestStatus";
	public static String PROP_SERIAL_NO = "serialNo";
	public static String PROP_REPAY_ALTERNATE = "repayAlternate";
	public static String PROP_DEBT_SHORT_NAME = "debtShortName";
	public static String PROP_DEBT_TYPE = "debtType";
	public static String PROP_SELL_STATUS = "sellStatus";
	public static String PROP_REAL_AMOUNT = "realAmount";
	public static String PROP_BOND_KIND = "bondKind";
	public static String PROP_DUE_DATE = "dueDate";
	public static String PROP_CASH_DUE_DATE = "cashDueDate";
	public static String PROP_ID = "id";
	public static String PROP_BUDGET_CODE = "budgetCode";


	// constructors
	public BaseIssueMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIssueMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseIssueMain (
		java.lang.Integer id,
		java.lang.Integer debtCode,
		java.lang.Integer budgetCode,
		java.lang.String issueSerial,
		java.lang.String accountYear,
		java.lang.String serialNo) {

		this.setId(id);
		this.setDebtCode(debtCode);
		this.setBudgetCode(budgetCode);
		this.setIssueSerial(issueSerial);
		this.setAccountYear(accountYear);
		this.setSerialNo(serialNo);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer debtCode;
	private java.lang.Integer budgetCode;
	private java.util.Date issueDate;
	private java.math.BigDecimal issueAmount;
	private java.lang.String issueSerial;
	private java.lang.String accountYear;
	private java.lang.String serialNo;
	private java.lang.String debtType;
	private java.lang.String debtName;
	private java.lang.String debtShortName;
	private java.math.BigDecimal averageRate;
	private java.util.Date dueDate;
	private java.lang.String showType;
	private java.lang.String issueKind;
	private java.math.BigDecimal expectAmount;
	private java.lang.String remark;
	private java.lang.String bondType;
	private java.util.Date cashDueDate;
	private java.math.BigDecimal chargeRate;
	private java.lang.String sellStatus;
	private java.lang.String bondSellStatus;
	private java.math.BigDecimal capitalAmount;
	private java.math.BigDecimal interestAmount;
	private java.math.BigDecimal realAmount;
	private java.util.Date firstRepayDate;
	private java.util.Date firstInterestDate;
	private java.lang.Integer repayAlternate;
	private java.lang.Integer interestAlternate;
	private java.lang.Integer sourceIssueId;
	private java.lang.Integer issueInterval;
	private java.lang.String bondKind;
	private java.math.BigDecimal sellAmount;
	private java.lang.Integer payLimit;
	private java.lang.String rateKind;
	private java.lang.String userid;
	private java.util.Date modDate;
	private java.util.Date createDate;
	private java.math.BigDecimal payableInterestAmount;
	private java.util.Date finishDate;
	private java.util.Date continueDate;
	private java.lang.String zeroInterestStatus;

	// collections
	private java.util.Set<tw.gov.nta.sql.debt.IssueTicketDet> issueTicketDets;
	private java.util.Set<tw.gov.nta.sql.debt.IssueExchangeDet> issueExchangeDets;
	private java.util.Set<tw.gov.nta.sql.account.VoucherMain> vouchers;
	private java.util.Set<tw.gov.nta.sql.debt.DebtMain> debtMains;



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
	 * Return the value associated with the column: ISSUE_DATE
	 */
	public java.util.Date getIssueDate () {
		return issueDate;
	}

	/**
	 * Set the value related to the column: ISSUE_DATE
	 * @param issueDate the ISSUE_DATE value
	 */
	public void setIssueDate (java.util.Date issueDate) {
		this.issueDate = issueDate;
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
	 * Return the value associated with the column: ISSUE_SERIAL
	 */
	public java.lang.String getIssueSerial () {
		return issueSerial;
	}

	/**
	 * Set the value related to the column: ISSUE_SERIAL
	 * @param issueSerial the ISSUE_SERIAL value
	 */
	public void setIssueSerial (java.lang.String issueSerial) {
		this.issueSerial = issueSerial;
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
	 * Return the value associated with the column: SERIAL_NO
	 */
	public java.lang.String getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: SERIAL_NO
	 * @param serialNo the SERIAL_NO value
	 */
	public void setSerialNo (java.lang.String serialNo) {
		this.serialNo = serialNo;
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
	 * Return the value associated with the column: Debt_NAME
	 */
	public java.lang.String getDebtName () {
		return debtName;
	}

	/**
	 * Set the value related to the column: Debt_NAME
	 * @param debtName the Debt_NAME value
	 */
	public void setDebtName (java.lang.String debtName) {
		this.debtName = debtName;
	}



	/**
	 * Return the value associated with the column: Debt_Short_NAME
	 */
	public java.lang.String getDebtShortName () {
		return debtShortName;
	}

	/**
	 * Set the value related to the column: Debt_Short_NAME
	 * @param debtShortName the Debt_Short_NAME value
	 */
	public void setDebtShortName (java.lang.String debtShortName) {
		this.debtShortName = debtShortName;
	}



	/**
	 * Return the value associated with the column: AVERAGE_RATE
	 */
	public java.math.BigDecimal getAverageRate () {
		return averageRate;
	}

	/**
	 * Set the value related to the column: AVERAGE_RATE
	 * @param averageRate the AVERAGE_RATE value
	 */
	public void setAverageRate (java.math.BigDecimal averageRate) {
		this.averageRate = averageRate;
	}



	/**
	 * Return the value associated with the column: DUE_DATE
	 */
	public java.util.Date getDueDate () {
		return dueDate;
	}

	/**
	 * Set the value related to the column: DUE_DATE
	 * @param dueDate the DUE_DATE value
	 */
	public void setDueDate (java.util.Date dueDate) {
		this.dueDate = dueDate;
	}



	/**
	 * Return the value associated with the column: SHOW_TYPE
	 */
	public java.lang.String getShowType () {
		return showType;
	}

	/**
	 * Set the value related to the column: SHOW_TYPE
	 * @param showType the SHOW_TYPE value
	 */
	public void setShowType (java.lang.String showType) {
		this.showType = showType;
	}



	/**
	 * Return the value associated with the column: ISSUE_KIND
	 */
	public java.lang.String getIssueKind () {
		return issueKind;
	}

	/**
	 * Set the value related to the column: ISSUE_KIND
	 * @param issueKind the ISSUE_KIND value
	 */
	public void setIssueKind (java.lang.String issueKind) {
		this.issueKind = issueKind;
	}



	/**
	 * Return the value associated with the column: EXPECT_AMOUNT
	 */
	public java.math.BigDecimal getExpectAmount () {
		return expectAmount;
	}

	/**
	 * Set the value related to the column: EXPECT_AMOUNT
	 * @param expectAmount the EXPECT_AMOUNT value
	 */
	public void setExpectAmount (java.math.BigDecimal expectAmount) {
		this.expectAmount = expectAmount;
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
	 * Return the value associated with the column: BOND_TYPE
	 */
	public java.lang.String getBondType () {
		return bondType;
	}

	/**
	 * Set the value related to the column: BOND_TYPE
	 * @param bondType the BOND_TYPE value
	 */
	public void setBondType (java.lang.String bondType) {
		this.bondType = bondType;
	}



	/**
	 * Return the value associated with the column: CASH_DUE_DATE
	 */
	public java.util.Date getCashDueDate () {
		return cashDueDate;
	}

	/**
	 * Set the value related to the column: CASH_DUE_DATE
	 * @param cashDueDate the CASH_DUE_DATE value
	 */
	public void setCashDueDate (java.util.Date cashDueDate) {
		this.cashDueDate = cashDueDate;
	}



	/**
	 * Return the value associated with the column: CHARGE_RATE
	 */
	public java.math.BigDecimal getChargeRate () {
		return chargeRate;
	}

	/**
	 * Set the value related to the column: CHARGE_RATE
	 * @param chargeRate the CHARGE_RATE value
	 */
	public void setChargeRate (java.math.BigDecimal chargeRate) {
		this.chargeRate = chargeRate;
	}



	/**
	 * Return the value associated with the column: SELL_STATUS
	 */
	public java.lang.String getSellStatus () {
		return sellStatus;
	}

	/**
	 * Set the value related to the column: SELL_STATUS
	 * @param sellStatus the SELL_STATUS value
	 */
	public void setSellStatus (java.lang.String sellStatus) {
		this.sellStatus = sellStatus;
	}



	/**
	 * Return the value associated with the column: BOND_SELL_STATUS
	 */
	public java.lang.String getBondSellStatus () {
		return bondSellStatus;
	}

	/**
	 * Set the value related to the column: BOND_SELL_STATUS
	 * @param bondSellStatus the BOND_SELL_STATUS value
	 */
	public void setBondSellStatus (java.lang.String bondSellStatus) {
		this.bondSellStatus = bondSellStatus;
	}



	/**
	 * Return the value associated with the column: CAPITAL_AMOUNT
	 */
	public java.math.BigDecimal getCapitalAmount () {
		return capitalAmount;
	}

	/**
	 * Set the value related to the column: CAPITAL_AMOUNT
	 * @param capitalAmount the CAPITAL_AMOUNT value
	 */
	public void setCapitalAmount (java.math.BigDecimal capitalAmount) {
		this.capitalAmount = capitalAmount;
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
	 * Return the value associated with the column: real_Amount
	 */
	public java.math.BigDecimal getRealAmount () {
		return realAmount;
	}

	/**
	 * Set the value related to the column: real_Amount
	 * @param realAmount the real_Amount value
	 */
	public void setRealAmount (java.math.BigDecimal realAmount) {
		this.realAmount = realAmount;
	}



	/**
	 * Return the value associated with the column: FIRST_REPAY_DATE
	 */
	public java.util.Date getFirstRepayDate () {
		return firstRepayDate;
	}

	/**
	 * Set the value related to the column: FIRST_REPAY_DATE
	 * @param firstRepayDate the FIRST_REPAY_DATE value
	 */
	public void setFirstRepayDate (java.util.Date firstRepayDate) {
		this.firstRepayDate = firstRepayDate;
	}



	/**
	 * Return the value associated with the column: FIRST_INTEREST_DATE
	 */
	public java.util.Date getFirstInterestDate () {
		return firstInterestDate;
	}

	/**
	 * Set the value related to the column: FIRST_INTEREST_DATE
	 * @param firstInterestDate the FIRST_INTEREST_DATE value
	 */
	public void setFirstInterestDate (java.util.Date firstInterestDate) {
		this.firstInterestDate = firstInterestDate;
	}



	/**
	 * Return the value associated with the column: REPAY_ALTERNATE
	 */
	public java.lang.Integer getRepayAlternate () {
		return repayAlternate;
	}

	/**
	 * Set the value related to the column: REPAY_ALTERNATE
	 * @param repayAlternate the REPAY_ALTERNATE value
	 */
	public void setRepayAlternate (java.lang.Integer repayAlternate) {
		this.repayAlternate = repayAlternate;
	}



	/**
	 * Return the value associated with the column: INTEREST_ALTERNATE
	 */
	public java.lang.Integer getInterestAlternate () {
		return interestAlternate;
	}

	/**
	 * Set the value related to the column: INTEREST_ALTERNATE
	 * @param interestAlternate the INTEREST_ALTERNATE value
	 */
	public void setInterestAlternate (java.lang.Integer interestAlternate) {
		this.interestAlternate = interestAlternate;
	}



	/**
	 * Return the value associated with the column: SOURCE_ISSUE_ID
	 */
	public java.lang.Integer getSourceIssueId () {
		return sourceIssueId;
	}

	/**
	 * Set the value related to the column: SOURCE_ISSUE_ID
	 * @param sourceIssueId the SOURCE_ISSUE_ID value
	 */
	public void setSourceIssueId (java.lang.Integer sourceIssueId) {
		this.sourceIssueId = sourceIssueId;
	}



	/**
	 * Return the value associated with the column: ISSUE_INTERVAL
	 */
	public java.lang.Integer getIssueInterval () {
		return issueInterval;
	}

	/**
	 * Set the value related to the column: ISSUE_INTERVAL
	 * @param issueInterval the ISSUE_INTERVAL value
	 */
	public void setIssueInterval (java.lang.Integer issueInterval) {
		this.issueInterval = issueInterval;
	}



	/**
	 * Return the value associated with the column: BOND_KIND
	 */
	public java.lang.String getBondKind () {
		return bondKind;
	}

	/**
	 * Set the value related to the column: BOND_KIND
	 * @param bondKind the BOND_KIND value
	 */
	public void setBondKind (java.lang.String bondKind) {
		this.bondKind = bondKind;
	}



	/**
	 * Return the value associated with the column: SELL_AMOUNT
	 */
	public java.math.BigDecimal getSellAmount () {
		return sellAmount;
	}

	/**
	 * Set the value related to the column: SELL_AMOUNT
	 * @param sellAmount the SELL_AMOUNT value
	 */
	public void setSellAmount (java.math.BigDecimal sellAmount) {
		this.sellAmount = sellAmount;
	}



	/**
	 * Return the value associated with the column: PAY_LIMIT
	 */
	public java.lang.Integer getPayLimit () {
		return payLimit;
	}

	/**
	 * Set the value related to the column: PAY_LIMIT
	 * @param payLimit the PAY_LIMIT value
	 */
	public void setPayLimit (java.lang.Integer payLimit) {
		this.payLimit = payLimit;
	}



	/**
	 * Return the value associated with the column: RATE_KIND
	 */
	public java.lang.String getRateKind () {
		return rateKind;
	}

	/**
	 * Set the value related to the column: RATE_KIND
	 * @param rateKind the RATE_KIND value
	 */
	public void setRateKind (java.lang.String rateKind) {
		this.rateKind = rateKind;
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
	 * Return the value associated with the column: finish_date
	 */
	public java.util.Date getFinishDate () {
		return finishDate;
	}

	/**
	 * Set the value related to the column: finish_date
	 * @param finishDate the finish_date value
	 */
	public void setFinishDate (java.util.Date finishDate) {
		this.finishDate = finishDate;
	}



	/**
	 * Return the value associated with the column: continue_date
	 */
	public java.util.Date getContinueDate () {
		return continueDate;
	}

	/**
	 * Set the value related to the column: continue_date
	 * @param continueDate the continue_date value
	 */
	public void setContinueDate (java.util.Date continueDate) {
		this.continueDate = continueDate;
	}



	/**
	 * Return the value associated with the column: zero_interest_status
	 */
	public java.lang.String getZeroInterestStatus () {
		return zeroInterestStatus;
	}

	/**
	 * Set the value related to the column: zero_interest_status
	 * @param zeroInterestStatus the zero_interest_status value
	 */
	public void setZeroInterestStatus (java.lang.String zeroInterestStatus) {
		this.zeroInterestStatus = zeroInterestStatus;
	}



	/**
	 * Return the value associated with the column: issueTicketDets
	 */
	public java.util.Set<tw.gov.nta.sql.debt.IssueTicketDet> getIssueTicketDets () {
		return issueTicketDets;
	}

	/**
	 * Set the value related to the column: issueTicketDets
	 * @param issueTicketDets the issueTicketDets value
	 */
	public void setIssueTicketDets (java.util.Set<tw.gov.nta.sql.debt.IssueTicketDet> issueTicketDets) {
		this.issueTicketDets = issueTicketDets;
	}

	public void addToissueTicketDets (tw.gov.nta.sql.debt.IssueTicketDet issueTicketDet) {
		if (null == getIssueTicketDets()) setIssueTicketDets(new java.util.TreeSet<tw.gov.nta.sql.debt.IssueTicketDet>());
		getIssueTicketDets().add(issueTicketDet);
	}



	/**
	 * Return the value associated with the column: issueExchangeDets
	 */
	public java.util.Set<tw.gov.nta.sql.debt.IssueExchangeDet> getIssueExchangeDets () {
		return issueExchangeDets;
	}

	/**
	 * Set the value related to the column: issueExchangeDets
	 * @param issueExchangeDets the issueExchangeDets value
	 */
	public void setIssueExchangeDets (java.util.Set<tw.gov.nta.sql.debt.IssueExchangeDet> issueExchangeDets) {
		this.issueExchangeDets = issueExchangeDets;
	}

	public void addToissueExchangeDets (tw.gov.nta.sql.debt.IssueExchangeDet issueExchangeDet) {
		if (null == getIssueExchangeDets()) setIssueExchangeDets(new java.util.TreeSet<tw.gov.nta.sql.debt.IssueExchangeDet>());
		getIssueExchangeDets().add(issueExchangeDet);
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



	/**
	 * Return the value associated with the column: debtMains
	 */
	public java.util.Set<tw.gov.nta.sql.debt.DebtMain> getDebtMains () {
		return debtMains;
	}

	/**
	 * Set the value related to the column: debtMains
	 * @param debtMains the debtMains value
	 */
	public void setDebtMains (java.util.Set<tw.gov.nta.sql.debt.DebtMain> debtMains) {
		this.debtMains = debtMains;
	}

	public void addTodebtMains (tw.gov.nta.sql.debt.DebtMain debtMain) {
		if (null == getDebtMains()) setDebtMains(new java.util.TreeSet<tw.gov.nta.sql.debt.DebtMain>());
		getDebtMains().add(debtMain);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.IssueMain)) return false;
		else {
			tw.gov.nta.sql.debt.IssueMain issueMain = (tw.gov.nta.sql.debt.IssueMain) obj;
			if (null == this.getId() || null == issueMain.getId()) return false;
			else return (this.getId().equals(issueMain.getId()));
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