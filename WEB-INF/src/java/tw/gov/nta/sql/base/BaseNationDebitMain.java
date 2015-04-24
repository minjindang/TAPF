package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Nation_debit_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Nation_debit_main"
 */

public abstract class BaseNationDebitMain  implements Comparable, Serializable {

	public static String REF = "NationDebitMain";
	public static String PROP_REMAIN_PAY_RATE = "remainPayRate";
	public static String PROP_AUDIT_AMOUNT = "auditAmount";
	public static String PROP_GNP_AMOUNT = "gnpAmount";
	public static String PROP_REMAIN_RATE = "remainRate";
	public static String PROP_GNP_YEAR_AMOUNT = "gnpYearAmount";
	public static String PROP_ACCOUNT_YEAR = "accountYear";
	public static String PROP_GDP_AMOUNT = "gdpAmount";
	public static String PROP_CASE_RATE = "caseRate";
	public static String PROP_REAL_AMOUNT = "realAmount";
	public static String PROP_BUDGET_AMOUNT = "budgetAmount";
	public static String PROP_KEEP_AMOUNT = "keepAmount";
	public static String PROP_PERGNP_AMOUNT = "pergnpAmount";
	public static String PROP_NOPAY_AMOUNT = "nopayAmount";
	public static String PROP_NATION_CODE = "nationCode";
	public static String PROP_GNP_ACCOUNT_AMOUNT = "gnpAccountAmount";
	public static String PROP_ID = "id";
	public static String PROP_BORROW_AMOUNT = "borrowAmount";
	public static String PROP_GNP_YEAR_AMOUNT1 = "gnpYearAmount1";


	// constructors
	public BaseNationDebitMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNationDebitMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseNationDebitMain (
		java.lang.Integer id,
		tw.gov.nta.sql.NationRef nationCode,
		java.lang.String accountYear,
		java.math.BigDecimal gdpAmount,
		java.math.BigDecimal gnpAmount,
		java.math.BigDecimal pergnpAmount,
		java.math.BigDecimal borrowAmount,
		java.math.BigDecimal nopayAmount) {

		this.setId(id);
		this.setNationCode(nationCode);
		this.setAccountYear(accountYear);
		this.setGdpAmount(gdpAmount);
		this.setGnpAmount(gnpAmount);
		this.setPergnpAmount(pergnpAmount);
		this.setBorrowAmount(borrowAmount);
		this.setNopayAmount(nopayAmount);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String accountYear;
	private java.math.BigDecimal gdpAmount;
	private java.math.BigDecimal gnpAmount;
	private java.math.BigDecimal pergnpAmount;
	private java.math.BigDecimal budgetAmount;
	private java.math.BigDecimal auditAmount;
	private java.math.BigDecimal realAmount;
	private java.math.BigDecimal keepAmount;
	private java.math.BigDecimal borrowAmount;
	private java.math.BigDecimal nopayAmount;
	private java.math.BigDecimal remainRate;
	private java.math.BigDecimal gnpYearAmount;
	private java.math.BigDecimal gnpYearAmount1;
	private java.math.BigDecimal gnpAccountAmount;
	private java.math.BigDecimal caseRate;
	private java.math.BigDecimal remainPayRate;

	// many to one
	private tw.gov.nta.sql.NationRef nationCode;



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
	 * Return the value associated with the column: GDP_AMOUNT
	 */
	public java.math.BigDecimal getGdpAmount () {
		return gdpAmount;
	}

	/**
	 * Set the value related to the column: GDP_AMOUNT
	 * @param gdpAmount the GDP_AMOUNT value
	 */
	public void setGdpAmount (java.math.BigDecimal gdpAmount) {
		this.gdpAmount = gdpAmount;
	}



	/**
	 * Return the value associated with the column: GNP_AMOUNT
	 */
	public java.math.BigDecimal getGnpAmount () {
		return gnpAmount;
	}

	/**
	 * Set the value related to the column: GNP_AMOUNT
	 * @param gnpAmount the GNP_AMOUNT value
	 */
	public void setGnpAmount (java.math.BigDecimal gnpAmount) {
		this.gnpAmount = gnpAmount;
	}



	/**
	 * Return the value associated with the column: PERGNP_AMOUNT
	 */
	public java.math.BigDecimal getPergnpAmount () {
		return pergnpAmount;
	}

	/**
	 * Set the value related to the column: PERGNP_AMOUNT
	 * @param pergnpAmount the PERGNP_AMOUNT value
	 */
	public void setPergnpAmount (java.math.BigDecimal pergnpAmount) {
		this.pergnpAmount = pergnpAmount;
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
	 * Return the value associated with the column: NOPAY_AMOUNT
	 */
	public java.math.BigDecimal getNopayAmount () {
		return nopayAmount;
	}

	/**
	 * Set the value related to the column: NOPAY_AMOUNT
	 * @param nopayAmount the NOPAY_AMOUNT value
	 */
	public void setNopayAmount (java.math.BigDecimal nopayAmount) {
		this.nopayAmount = nopayAmount;
	}



	/**
	 * Return the value associated with the column: REMAIN_RATE
	 */
	public java.math.BigDecimal getRemainRate () {
		return remainRate;
	}

	/**
	 * Set the value related to the column: REMAIN_RATE
	 * @param remainRate the REMAIN_RATE value
	 */
	public void setRemainRate (java.math.BigDecimal remainRate) {
		this.remainRate = remainRate;
	}



	/**
	 * Return the value associated with the column: GNP_YEAR_AMOUNT
	 */
	public java.math.BigDecimal getGnpYearAmount () {
		return gnpYearAmount;
	}

	/**
	 * Set the value related to the column: GNP_YEAR_AMOUNT
	 * @param gnpYearAmount the GNP_YEAR_AMOUNT value
	 */
	public void setGnpYearAmount (java.math.BigDecimal gnpYearAmount) {
		this.gnpYearAmount = gnpYearAmount;
	}



	/**
	 * Return the value associated with the column: GNP_YEAR_AMOUNT1
	 */
	public java.math.BigDecimal getGnpYearAmount1 () {
		return gnpYearAmount1;
	}

	/**
	 * Set the value related to the column: GNP_YEAR_AMOUNT1
	 * @param gnpYearAmount1 the GNP_YEAR_AMOUNT1 value
	 */
	public void setGnpYearAmount1 (java.math.BigDecimal gnpYearAmount1) {
		this.gnpYearAmount1 = gnpYearAmount1;
	}



	/**
	 * Return the value associated with the column: GNP_ACCOUNT_AMOUNT
	 */
	public java.math.BigDecimal getGnpAccountAmount () {
		return gnpAccountAmount;
	}

	/**
	 * Set the value related to the column: GNP_ACCOUNT_AMOUNT
	 * @param gnpAccountAmount the GNP_ACCOUNT_AMOUNT value
	 */
	public void setGnpAccountAmount (java.math.BigDecimal gnpAccountAmount) {
		this.gnpAccountAmount = gnpAccountAmount;
	}



	/**
	 * Return the value associated with the column: case_rate
	 */
	public java.math.BigDecimal getCaseRate () {
		return caseRate;
	}

	/**
	 * Set the value related to the column: case_rate
	 * @param caseRate the case_rate value
	 */
	public void setCaseRate (java.math.BigDecimal caseRate) {
		this.caseRate = caseRate;
	}



	/**
	 * Return the value associated with the column: remain_pay_rate
	 */
	public java.math.BigDecimal getRemainPayRate () {
		return remainPayRate;
	}

	/**
	 * Set the value related to the column: remain_pay_rate
	 * @param remainPayRate the remain_pay_rate value
	 */
	public void setRemainPayRate (java.math.BigDecimal remainPayRate) {
		this.remainPayRate = remainPayRate;
	}



	/**
	 * Return the value associated with the column: NATION_CODE
	 */
	public tw.gov.nta.sql.NationRef getNationCode () {
		return nationCode;
	}

	/**
	 * Set the value related to the column: NATION_CODE
	 * @param nationCode the NATION_CODE value
	 */
	public void setNationCode (tw.gov.nta.sql.NationRef nationCode) {
		this.nationCode = nationCode;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.NationDebitMain)) return false;
		else {
			tw.gov.nta.sql.NationDebitMain nationDebitMain = (tw.gov.nta.sql.NationDebitMain) obj;
			if (null == this.getId() || null == nationDebitMain.getId()) return false;
			else return (this.getId().equals(nationDebitMain.getId()));
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