package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.math.BigDecimal;
import java.io.Serializable;


/**
 * This is an object that contains data related to the payment_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="payment_main"
 */

public abstract class BasePaymentMain  implements Comparable, Serializable {

	public static String REF = "PaymentMain";
	public static String PROP_INTEREST_AMOUNT = "interestAmount";
	public static String PROP_PLAN_REPAY_DATE = "planRepayDate";
	public static String PROP_END_DATE = "endDate";
	public static String PROP_DEBT_ID = "debtId";
	public static String PROP_REPAY_DATE = "repayDate";
	public static String PROP_INTEREST_DAYS = "interestDays";
	public static String PROP_BUY_STATUS = "buyStatus";
	public static String PROP_BALANCE_CAPITAL_AMOUNT = "balanceCapitalAmount";
	public static String PROP_START_DATE = "startDate";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_MANAGE_CAPITAL_AMOUNT = "manageCapitalAmount";
	public static String PROP_USERID = "userid";
	public static String PROP_INTEREST_SERIAL = "interestSerial";
	public static String PROP_MANAGE_INTEREST_AMOUNT = "manageInterestAmount";
	public static String PROP_SOURC_ID = "sourcId";
	public static String PROP_ISSUE_ID = "issueId";
	public static String PROP_CAPITAL_AMOUNT = "capitalAmount";
	public static String PROP_CAPITAL_SERIAL = "capitalSerial";
	public static String PROP_PLAN = "plan";
	public static String PROP_REPAY_TYPE = "repayType";
	public static String PROP_ID = "id";
	public static String PROP_BUY_AMOUNT = "buyAmount";
	public static String PROP_AVERAGE_RATE = "averageRate";
	public static String PROP_CHARGE_AMOUNT = "chargeAmount";
	public static String PROP_ADVANCE_TAX = "advanceTax";
	public static String PROP_BUY_PREMIUM = "buyPremium";
	public static String PROP_BUY_INTEREST = "buyInterest";


	// constructors
	public BasePaymentMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePaymentMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePaymentMain (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtPlanDet plan,
		java.lang.Integer issueId,
		java.lang.Integer debtId) {

		this.setId(id);
		this.setPlan(plan);
		this.setIssueId(issueId);
		this.setDebtId(debtId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer issueId;
	private java.lang.Integer debtId;
	private java.util.Date repayDate;
	private java.math.BigDecimal capitalAmount;
	private java.math.BigDecimal interestAmount;
	private java.lang.String capitalSerial;
	private java.lang.String interestSerial;
	private java.util.Date planRepayDate;
	private java.lang.Integer interestDays;
	private java.math.BigDecimal balanceCapitalAmount;
	private java.math.BigDecimal manageInterestAmount;
	private java.math.BigDecimal manageCapitalAmount;
	private java.math.BigDecimal averageRate;
	private java.lang.String buyStatus;
	private java.math.BigDecimal buyAmount;
	private java.lang.String userid;
	private java.util.Date modDate;
	private java.util.Date startDate;
	private java.util.Date endDate;
	private java.lang.Integer sourcId;
	private java.lang.String repayType;
	private java.math.BigDecimal chargeAmount;
	private java.math.BigDecimal advanceTax;
	private java.math.BigDecimal buyPremium;
	private java.math.BigDecimal buyInterest;

	// many to one
	private tw.gov.nta.sql.debt.DebtPlanDet plan;

	// collections
	private java.util.Set<tw.gov.nta.sql.debt.PaymentTicketDet> paymentTicketDets;



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
	 * Return the value associated with the column: ISSUE_ID
	 */
	public java.lang.Integer getIssueId () {
		return issueId;
	}

	/**
	 * Set the value related to the column: ISSUE_ID
	 * @param issueId the ISSUE_ID value
	 */
	public void setIssueId (java.lang.Integer issueId) {
		this.issueId = issueId;
	}



	/**
	 * Return the value associated with the column: DEBT_ID
	 */
	public java.lang.Integer getDebtId () {
		return debtId;
	}

	/**
	 * Set the value related to the column: DEBT_ID
	 * @param debtId the DEBT_ID value
	 */
	public void setDebtId (java.lang.Integer debtId) {
		this.debtId = debtId;
	}



	/**
	 * Return the value associated with the column: REPAY_DATE
	 */
	public java.util.Date getRepayDate () {
		return repayDate;
	}

	/**
	 * Set the value related to the column: REPAY_DATE
	 * @param repayDate the REPAY_DATE value
	 */
	public void setRepayDate (java.util.Date repayDate) {
		this.repayDate = repayDate;
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
	 * Return the value associated with the column: CAPITAL_SERIAL
	 */
	public java.lang.String getCapitalSerial () {
		return capitalSerial;
	}

	/**
	 * Set the value related to the column: CAPITAL_SERIAL
	 * @param capitalSerial the CAPITAL_SERIAL value
	 */
	public void setCapitalSerial (java.lang.String capitalSerial) {
		this.capitalSerial = capitalSerial;
	}



	/**
	 * Return the value associated with the column: INTEREST_SERIAL
	 */
	public java.lang.String getInterestSerial () {
		return interestSerial;
	}

	/**
	 * Set the value related to the column: INTEREST_SERIAL
	 * @param interestSerial the INTEREST_SERIAL value
	 */
	public void setInterestSerial (java.lang.String interestSerial) {
		this.interestSerial = interestSerial;
	}



	/**
	 * Return the value associated with the column: PLAN_REPAY_DATE
	 */
	public java.util.Date getPlanRepayDate () {
		return planRepayDate;
	}

	/**
	 * Set the value related to the column: PLAN_REPAY_DATE
	 * @param planRepayDate the PLAN_REPAY_DATE value
	 */
	public void setPlanRepayDate (java.util.Date planRepayDate) {
		this.planRepayDate = planRepayDate;
	}



	/**
	 * Return the value associated with the column: INTEREST_DAYS
	 */
	public java.lang.Integer getInterestDays () {
		return interestDays;
	}

	/**
	 * Set the value related to the column: INTEREST_DAYS
	 * @param interestDays the INTEREST_DAYS value
	 */
	public void setInterestDays (java.lang.Integer interestDays) {
		this.interestDays = interestDays;
	}



	/**
	 * Return the value associated with the column: BALANCE_CAPITAL_AMOUNT
	 */
	public java.math.BigDecimal getBalanceCapitalAmount () {
		return balanceCapitalAmount;
	}

	/**
	 * Set the value related to the column: BALANCE_CAPITAL_AMOUNT
	 * @param balanceCapitalAmount the BALANCE_CAPITAL_AMOUNT value
	 */
	public void setBalanceCapitalAmount (java.math.BigDecimal balanceCapitalAmount) {
		this.balanceCapitalAmount = balanceCapitalAmount;
	}



	/**
	 * Return the value associated with the column: MANAGE_INTEREST_AMOUNT
	 */
	public java.math.BigDecimal getManageInterestAmount () {
		return manageInterestAmount;
	}

	/**
	 * Set the value related to the column: MANAGE_INTEREST_AMOUNT
	 * @param manageInterestAmount the MANAGE_INTEREST_AMOUNT value
	 */
	public void setManageInterestAmount (java.math.BigDecimal manageInterestAmount) {
		this.manageInterestAmount = manageInterestAmount;
	}



	/**
	 * Return the value associated with the column: MANAGE_CAPITAL_AMOUNT
	 */
	public java.math.BigDecimal getManageCapitalAmount () {
		return manageCapitalAmount;
	}

	/**
	 * Set the value related to the column: MANAGE_CAPITAL_AMOUNT
	 * @param manageCapitalAmount the MANAGE_CAPITAL_AMOUNT value
	 */
	public void setManageCapitalAmount (java.math.BigDecimal manageCapitalAmount) {
		this.manageCapitalAmount = manageCapitalAmount;
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
	 * Return the value associated with the column: BUY_STATUS
	 */
	public java.lang.String getBuyStatus () {
		return buyStatus;
	}

	/**
	 * Set the value related to the column: BUY_STATUS
	 * @param buyStatus the BUY_STATUS value
	 */
	public void setBuyStatus (java.lang.String buyStatus) {
		this.buyStatus = buyStatus;
	}



	/**
	 * Return the value associated with the column: BUY_AMOUNT
	 */
	public java.math.BigDecimal getBuyAmount () {
		return buyAmount;
	}

	/**
	 * Set the value related to the column: BUY_AMOUNT
	 * @param buyAmount the BUY_AMOUNT value
	 */
	public void setBuyAmount (java.math.BigDecimal buyAmount) {
		this.buyAmount = buyAmount;
	}

	public java.math.BigDecimal getBuyPremium() {
		return buyPremium;
	}

	public void setBuyPremium(java.math.BigDecimal buyPremium) {
		this.buyPremium = buyPremium;
	}

	public java.math.BigDecimal getBuyInterest() {
		return buyInterest;
	}

	public void setBuyInterest(java.math.BigDecimal buyInterest) {
		this.buyInterest = buyInterest;
	}

	public java.math.BigDecimal getAdvanceTax() {
		return advanceTax;
	}

	public void setAdvanceTax(java.math.BigDecimal advanceTax) {
		this.advanceTax = advanceTax;
	}

	public java.math.BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(java.math.BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
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
	 * Return the value associated with the column: start_date
	 */
	public java.util.Date getStartDate () {
		return startDate;
	}

	/**
	 * Set the value related to the column: start_date
	 * @param startDate the start_date value
	 */
	public void setStartDate (java.util.Date startDate) {
		this.startDate = startDate;
	}



	/**
	 * Return the value associated with the column: end_date
	 */
	public java.util.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: end_date
	 * @param endDate the end_date value
	 */
	public void setEndDate (java.util.Date endDate) {
		this.endDate = endDate;
	}



	/**
	 * Return the value associated with the column: source_id
	 */
	public java.lang.Integer getSourcId () {
		return sourcId;
	}

	/**
	 * Set the value related to the column: source_id
	 * @param sourcId the source_id value
	 */
	public void setSourcId (java.lang.Integer sourcId) {
		this.sourcId = sourcId;
	}



	/**
	 * Return the value associated with the column: repay_type
	 */
	public java.lang.String getRepayType () {
		return repayType;
	}

	/**
	 * Set the value related to the column: repay_type
	 * @param repayType the repay_type value
	 */
	public void setRepayType (java.lang.String repayType) {
		this.repayType = repayType;
	}



	/**
	 * Return the value associated with the column: PLAN_ID
	 */
	public tw.gov.nta.sql.debt.DebtPlanDet getPlan () {
		return plan;
	}

	/**
	 * Set the value related to the column: PLAN_ID
	 * @param plan the PLAN_ID value
	 */
	public void setPlan (tw.gov.nta.sql.debt.DebtPlanDet plan) {
		this.plan = plan;
	}



	/**
	 * Return the value associated with the column: paymentTicketDets
	 */
	public java.util.Set<tw.gov.nta.sql.debt.PaymentTicketDet> getPaymentTicketDets () {
		return paymentTicketDets;
	}

	/**
	 * Set the value related to the column: paymentTicketDets
	 * @param paymentTicketDets the paymentTicketDets value
	 */
	public void setPaymentTicketDets (java.util.Set<tw.gov.nta.sql.debt.PaymentTicketDet> paymentTicketDets) {
		this.paymentTicketDets = paymentTicketDets;
	}

	public void addTopaymentTicketDets (tw.gov.nta.sql.debt.PaymentTicketDet paymentTicketDet) {
		if (null == getPaymentTicketDets()) setPaymentTicketDets(new java.util.TreeSet<tw.gov.nta.sql.debt.PaymentTicketDet>());
		getPaymentTicketDets().add(paymentTicketDet);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.PaymentMain)) return false;
		else {
			tw.gov.nta.sql.debt.PaymentMain paymentMain = (tw.gov.nta.sql.debt.PaymentMain) obj;
			if (null == this.getId() || null == paymentMain.getId()) return false;
			else return (this.getId().equals(paymentMain.getId()));
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