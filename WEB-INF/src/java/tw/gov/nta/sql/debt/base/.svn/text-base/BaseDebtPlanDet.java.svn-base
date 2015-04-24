package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the debt_plan_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="debt_plan_det"
 */

public abstract class BaseDebtPlanDet  implements Comparable, Serializable {

	public static String REF = "DebtPlanDet";
	public static String PROP_INTEREST_AMOUNT = "interestAmount";
	public static String PROP_REPORT_FLAG = "reportFlag";
	public static String PROP_REPAY_DATE = "repayDate";
	public static String PROP_TRANSFER_CAPITAL_AMOUNT = "transferCapitalAmount";
	public static String PROP_DEBT = "debt";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_ORIGIN_INTEREST_AMOUNT = "originInterestAmount";
	public static String PROP_USERID = "userid";
	public static String PROP_CHARGE_AMOUNT = "chargeAmount";
	public static String PROP_INTEREST_SERIAL = "interestSerial";
	public static String PROP_DELETE_MARK = "deleteMark";
	public static String PROP_RATE_GROUP_ID = "rateGroupId";
	public static String PROP_ISSUE_ID = "issueId";
	public static String PROP_CAPITAL_AMOUNT = "capitalAmount";
	public static String PROP_CAPITAL_SERIAL = "capitalSerial";
	public static String PROP_TRANSFER_INTEREST_AMOUNT = "transferInterestAmount";
	public static String PROP_ID = "id";


	// constructors
	public BaseDebtPlanDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDebtPlanDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDebtPlanDet (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtMain debt,
		java.lang.Integer issueId) {

		this.setId(id);
		this.setDebt(debt);
		this.setIssueId(issueId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer issueId;
	private java.util.Date repayDate;
	private java.math.BigDecimal capitalAmount;
	private java.math.BigDecimal interestAmount;
	private java.math.BigDecimal chargeAmount;
	private java.lang.Integer capitalSerial;
	private java.lang.Integer interestSerial;
	private java.lang.String userid;
	private java.util.Date modDate;
	private java.lang.String deleteMark;
	private java.math.BigDecimal originInterestAmount;
	private java.math.BigDecimal transferCapitalAmount;
	private java.math.BigDecimal transferInterestAmount;
	private java.lang.Integer rateGroupId;
	private java.lang.String reportFlag;

	// many to one
	private tw.gov.nta.sql.debt.DebtMain debt;

	// collections
	private java.util.Set<tw.gov.nta.sql.debt.PaymentMain> paymentMains;
	private java.util.Set<tw.gov.nta.sql.debt.IssueExchangeTicketMain> issueExchangeTicketMains;



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
	 * Return the value associated with the column: CHARGE_AMOUNT
	 */
	public java.math.BigDecimal getChargeAmount () {
		return chargeAmount;
	}

	/**
	 * Set the value related to the column: CHARGE_AMOUNT
	 * @param chargeAmount the CHARGE_AMOUNT value
	 */
	public void setChargeAmount (java.math.BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}



	/**
	 * Return the value associated with the column: CAPITAL_SERIAL
	 */
	public java.lang.Integer getCapitalSerial () {
		return capitalSerial;
	}

	/**
	 * Set the value related to the column: CAPITAL_SERIAL
	 * @param capitalSerial the CAPITAL_SERIAL value
	 */
	public void setCapitalSerial (java.lang.Integer capitalSerial) {
		this.capitalSerial = capitalSerial;
	}



	/**
	 * Return the value associated with the column: INTEREST_SERIAL
	 */
	public java.lang.Integer getInterestSerial () {
		return interestSerial;
	}

	/**
	 * Set the value related to the column: INTEREST_SERIAL
	 * @param interestSerial the INTEREST_SERIAL value
	 */
	public void setInterestSerial (java.lang.Integer interestSerial) {
		this.interestSerial = interestSerial;
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
	 * Return the value associated with the column: delete_mark
	 */
	public java.lang.String getDeleteMark () {
		return deleteMark;
	}

	/**
	 * Set the value related to the column: delete_mark
	 * @param deleteMark the delete_mark value
	 */
	public void setDeleteMark (java.lang.String deleteMark) {
		this.deleteMark = deleteMark;
	}



	/**
	 * Return the value associated with the column: origin_interest_amount
	 */
	public java.math.BigDecimal getOriginInterestAmount () {
		return originInterestAmount;
	}

	/**
	 * Set the value related to the column: origin_interest_amount
	 * @param originInterestAmount the origin_interest_amount value
	 */
	public void setOriginInterestAmount (java.math.BigDecimal originInterestAmount) {
		this.originInterestAmount = originInterestAmount;
	}



	/**
	 * Return the value associated with the column: transfer_capital_amount
	 */
	public java.math.BigDecimal getTransferCapitalAmount () {
		return transferCapitalAmount;
	}

	/**
	 * Set the value related to the column: transfer_capital_amount
	 * @param transferCapitalAmount the transfer_capital_amount value
	 */
	public void setTransferCapitalAmount (java.math.BigDecimal transferCapitalAmount) {
		this.transferCapitalAmount = transferCapitalAmount;
	}



	/**
	 * Return the value associated with the column: transfer_interest_amount
	 */
	public java.math.BigDecimal getTransferInterestAmount () {
		return transferInterestAmount;
	}

	/**
	 * Set the value related to the column: transfer_interest_amount
	 * @param transferInterestAmount the transfer_interest_amount value
	 */
	public void setTransferInterestAmount (java.math.BigDecimal transferInterestAmount) {
		this.transferInterestAmount = transferInterestAmount;
	}



	/**
	 * Return the value associated with the column: rate_group_id
	 */
	public java.lang.Integer getRateGroupId () {
		return rateGroupId;
	}

	/**
	 * Set the value related to the column: rate_group_id
	 * @param rateGroupId the rate_group_id value
	 */
	public void setRateGroupId (java.lang.Integer rateGroupId) {
		this.rateGroupId = rateGroupId;
	}



	/**
	 * Return the value associated with the column: report_flag
	 */
	public java.lang.String getReportFlag () {
		return reportFlag;
	}

	/**
	 * Set the value related to the column: report_flag
	 * @param reportFlag the report_flag value
	 */
	public void setReportFlag (java.lang.String reportFlag) {
		this.reportFlag = reportFlag;
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



	/**
	 * Return the value associated with the column: paymentMains
	 */
	public java.util.Set<tw.gov.nta.sql.debt.PaymentMain> getPaymentMains () {
		return paymentMains;
	}

	/**
	 * Set the value related to the column: paymentMains
	 * @param paymentMains the paymentMains value
	 */
	public void setPaymentMains (java.util.Set<tw.gov.nta.sql.debt.PaymentMain> paymentMains) {
		this.paymentMains = paymentMains;
	}

	public void addTopaymentMains (tw.gov.nta.sql.debt.PaymentMain paymentMain) {
		if (null == getPaymentMains()) setPaymentMains(new java.util.TreeSet<tw.gov.nta.sql.debt.PaymentMain>());
		getPaymentMains().add(paymentMain);
	}



	/**
	 * Return the value associated with the column: issueExchangeTicketMains
	 */
	public java.util.Set<tw.gov.nta.sql.debt.IssueExchangeTicketMain> getIssueExchangeTicketMains () {
		return issueExchangeTicketMains;
	}

	/**
	 * Set the value related to the column: issueExchangeTicketMains
	 * @param issueExchangeTicketMains the issueExchangeTicketMains value
	 */
	public void setIssueExchangeTicketMains (java.util.Set<tw.gov.nta.sql.debt.IssueExchangeTicketMain> issueExchangeTicketMains) {
		this.issueExchangeTicketMains = issueExchangeTicketMains;
	}

	public void addToissueExchangeTicketMains (tw.gov.nta.sql.debt.IssueExchangeTicketMain issueExchangeTicketMain) {
		if (null == getIssueExchangeTicketMains()) setIssueExchangeTicketMains(new java.util.TreeSet<tw.gov.nta.sql.debt.IssueExchangeTicketMain>());
		getIssueExchangeTicketMains().add(issueExchangeTicketMain);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.DebtPlanDet)) return false;
		else {
			tw.gov.nta.sql.debt.DebtPlanDet debtPlanDet = (tw.gov.nta.sql.debt.DebtPlanDet) obj;
			if (null == this.getId() || null == debtPlanDet.getId()) return false;
			else return (this.getId().equals(debtPlanDet.getId()));
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