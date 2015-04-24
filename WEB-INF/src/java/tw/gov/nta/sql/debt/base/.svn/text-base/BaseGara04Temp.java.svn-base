package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the GARA04_TEMP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GARA04_TEMP"
 */

public abstract class BaseGara04Temp  implements Comparable, Serializable {

	public static String REF = "Gara04Temp";
	public static String PROP_YEAR_AMOUNT = "yearAmount";
	public static String PROP_BUDGET_CAPITAL = "budgetCapital";
	public static String PROP_INTEREST_PAYED = "interestPayed";
	public static String PROP_FUNDATION_CAPITAL = "fundationCapital";
	public static String PROP_ID = "id";
	public static String PROP_ACCOUNT_YEAR = "accountYear";


	// constructors
	public BaseGara04Temp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGara04Temp (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseGara04Temp (
		java.lang.Integer id,
		java.lang.String accountYear) {

		this.setId(id);
		this.setAccountYear(accountYear);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String accountYear;
	private java.math.BigDecimal budgetCapital;
	private java.math.BigDecimal fundationCapital;
	private java.math.BigDecimal interestPayed;
	private java.math.BigDecimal yearAmount;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: account_year
	 */
	public java.lang.String getAccountYear () {
		return accountYear;
	}

	/**
	 * Set the value related to the column: account_year
	 * @param accountYear the account_year value
	 */
	public void setAccountYear (java.lang.String accountYear) {
		this.accountYear = accountYear;
	}



	/**
	 * Return the value associated with the column: budget_capital
	 */
	public java.math.BigDecimal getBudgetCapital () {
		return budgetCapital;
	}

	/**
	 * Set the value related to the column: budget_capital
	 * @param budgetCapital the budget_capital value
	 */
	public void setBudgetCapital (java.math.BigDecimal budgetCapital) {
		this.budgetCapital = budgetCapital;
	}



	/**
	 * Return the value associated with the column: fundation_capital
	 */
	public java.math.BigDecimal getFundationCapital () {
		return fundationCapital;
	}

	/**
	 * Set the value related to the column: fundation_capital
	 * @param fundationCapital the fundation_capital value
	 */
	public void setFundationCapital (java.math.BigDecimal fundationCapital) {
		this.fundationCapital = fundationCapital;
	}



	/**
	 * Return the value associated with the column: interest_payed
	 */
	public java.math.BigDecimal getInterestPayed () {
		return interestPayed;
	}

	/**
	 * Set the value related to the column: interest_payed
	 * @param interestPayed the interest_payed value
	 */
	public void setInterestPayed (java.math.BigDecimal interestPayed) {
		this.interestPayed = interestPayed;
	}



	/**
	 * Return the value associated with the column: year_amount
	 */
	public java.math.BigDecimal getYearAmount () {
		return yearAmount;
	}

	/**
	 * Set the value related to the column: year_amount
	 * @param yearAmount the year_amount value
	 */
	public void setYearAmount (java.math.BigDecimal yearAmount) {
		this.yearAmount = yearAmount;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.Gara04Temp)) return false;
		else {
			tw.gov.nta.sql.debt.Gara04Temp gara04Temp = (tw.gov.nta.sql.debt.Gara04Temp) obj;
			if (null == this.getId() || null == gara04Temp.getId()) return false;
			else return (this.getId().equals(gara04Temp.getId()));
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