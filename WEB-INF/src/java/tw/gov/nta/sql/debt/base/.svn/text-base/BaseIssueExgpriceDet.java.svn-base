package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the issue_exgprice_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="issue_exgprice_det"
 */

public abstract class BaseIssueExgpriceDet  implements Comparable, Serializable {

	public static String REF = "IssueExgpriceDet";
	public static String PROP_CHANGE_PRICE = "changePrice";
	public static String PROP_STOCK_AMOUNT = "stockAmount";
	public static String PROP_NOT_AMOUNT = "notAmount";
	public static String PROP_CHANGE_AMOUNT = "changeAmount";
	public static String PROP_ISSUE = "issue";
	public static String PROP_SUM_STOCK = "sumStock";
	public static String PROP_CHANGE_DATE = "changeDate";
	public static String PROP_CHANGE_REASON = "changeReason";
	public static String PROP_ID = "id";


	// constructors
	public BaseIssueExgpriceDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIssueExgpriceDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal changePrice;
	private java.util.Date changeDate;
	private java.math.BigDecimal sumStock;
	private java.math.BigDecimal stockAmount;
	private java.math.BigDecimal notAmount;
	private java.math.BigDecimal changeAmount;
	private java.lang.String changeReason;

	// many to one
	private tw.gov.nta.sql.debt.IssueMain issue;



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
	 * Return the value associated with the column: change_price
	 */
	public java.math.BigDecimal getChangePrice () {
		return changePrice;
	}

	/**
	 * Set the value related to the column: change_price
	 * @param changePrice the change_price value
	 */
	public void setChangePrice (java.math.BigDecimal changePrice) {
		this.changePrice = changePrice;
	}



	/**
	 * Return the value associated with the column: change_date
	 */
	public java.util.Date getChangeDate () {
		return changeDate;
	}

	/**
	 * Set the value related to the column: change_date
	 * @param changeDate the change_date value
	 */
	public void setChangeDate (java.util.Date changeDate) {
		this.changeDate = changeDate;
	}



	/**
	 * Return the value associated with the column: sum_stock
	 */
	public java.math.BigDecimal getSumStock () {
		return sumStock;
	}

	/**
	 * Set the value related to the column: sum_stock
	 * @param sumStock the sum_stock value
	 */
	public void setSumStock (java.math.BigDecimal sumStock) {
		this.sumStock = sumStock;
	}



	/**
	 * Return the value associated with the column: stock_amount
	 */
	public java.math.BigDecimal getStockAmount () {
		return stockAmount;
	}

	/**
	 * Set the value related to the column: stock_amount
	 * @param stockAmount the stock_amount value
	 */
	public void setStockAmount (java.math.BigDecimal stockAmount) {
		this.stockAmount = stockAmount;
	}



	/**
	 * Return the value associated with the column: not_amount
	 */
	public java.math.BigDecimal getNotAmount () {
		return notAmount;
	}

	/**
	 * Set the value related to the column: not_amount
	 * @param notAmount the not_amount value
	 */
	public void setNotAmount (java.math.BigDecimal notAmount) {
		this.notAmount = notAmount;
	}



	/**
	 * Return the value associated with the column: change_amount
	 */
	public java.math.BigDecimal getChangeAmount () {
		return changeAmount;
	}

	/**
	 * Set the value related to the column: change_amount
	 * @param changeAmount the change_amount value
	 */
	public void setChangeAmount (java.math.BigDecimal changeAmount) {
		this.changeAmount = changeAmount;
	}



	/**
	 * Return the value associated with the column: change_reason
	 */
	public java.lang.String getChangeReason () {
		return changeReason;
	}

	/**
	 * Set the value related to the column: change_reason
	 * @param changeReason the change_reason value
	 */
	public void setChangeReason (java.lang.String changeReason) {
		this.changeReason = changeReason;
	}



	/**
	 * Return the value associated with the column: issue_id
	 */
	public tw.gov.nta.sql.debt.IssueMain getIssue () {
		return issue;
	}

	/**
	 * Set the value related to the column: issue_id
	 * @param issue the issue_id value
	 */
	public void setIssue (tw.gov.nta.sql.debt.IssueMain issue) {
		this.issue = issue;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.IssueExgpriceDet)) return false;
		else {
			tw.gov.nta.sql.debt.IssueExgpriceDet issueExgpriceDet = (tw.gov.nta.sql.debt.IssueExgpriceDet) obj;
			if (null == this.getId() || null == issueExgpriceDet.getId()) return false;
			else return (this.getId().equals(issueExgpriceDet.getId()));
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