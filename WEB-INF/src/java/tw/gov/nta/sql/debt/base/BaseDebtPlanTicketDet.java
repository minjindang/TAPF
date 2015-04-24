package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the debt_plan_ticket_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="debt_plan_ticket_det"
 */

public abstract class BaseDebtPlanTicketDet  implements Comparable, Serializable {

	public static String REF = "DebtPlanTicketDet";
	public static String PROP_INTEREST_AMOUNT = "interestAmount";
	public static String PROP_CAPITAL_AMOUNT = "capitalAmount";
	public static String PROP_TICKET_NAME = "ticketName";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_TICKET_COUNT = "ticketCount";
	public static String PROP_USERID = "userid";
	public static String PROP_PLAN = "plan";
	public static String PROP_TICKET_AMOUNT = "ticketAmount";
	public static String PROP_ID = "id";


	// constructors
	public BaseDebtPlanTicketDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDebtPlanTicketDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDebtPlanTicketDet (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtPlanDet plan) {

		this.setId(id);
		this.setPlan(plan);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ticketName;
	private java.math.BigDecimal ticketAmount;
	private java.lang.Long ticketCount;
	private java.lang.String userid;
	private java.util.Date modDate;
	private java.math.BigDecimal capitalAmount;
	private java.math.BigDecimal interestAmount;

	// many to one
	private tw.gov.nta.sql.debt.DebtPlanDet plan;



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
	 * Return the value associated with the column: TICKET_NAME
	 */
	public java.lang.String getTicketName () {
		return ticketName;
	}

	/**
	 * Set the value related to the column: TICKET_NAME
	 * @param ticketName the TICKET_NAME value
	 */
	public void setTicketName (java.lang.String ticketName) {
		this.ticketName = ticketName;
	}



	/**
	 * Return the value associated with the column: TICKET_AMOUNT
	 */
	public java.math.BigDecimal getTicketAmount () {
		return ticketAmount;
	}

	/**
	 * Set the value related to the column: TICKET_AMOUNT
	 * @param ticketAmount the TICKET_AMOUNT value
	 */
	public void setTicketAmount (java.math.BigDecimal ticketAmount) {
		this.ticketAmount = ticketAmount;
	}



	/**
	 * Return the value associated with the column: TICKET_COUNT
	 */
	public java.lang.Long getTicketCount () {
		return ticketCount;
	}

	/**
	 * Set the value related to the column: TICKET_COUNT
	 * @param ticketCount the TICKET_COUNT value
	 */
	public void setTicketCount (java.lang.Long ticketCount) {
		this.ticketCount = ticketCount;
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
	 * Return the value associated with the column: plan_ID
	 */
	public tw.gov.nta.sql.debt.DebtPlanDet getPlan () {
		return plan;
	}

	/**
	 * Set the value related to the column: plan_ID
	 * @param plan the plan_ID value
	 */
	public void setPlan (tw.gov.nta.sql.debt.DebtPlanDet plan) {
		this.plan = plan;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.DebtPlanTicketDet)) return false;
		else {
			tw.gov.nta.sql.debt.DebtPlanTicketDet debtPlanTicketDet = (tw.gov.nta.sql.debt.DebtPlanTicketDet) obj;
			if (null == this.getId() || null == debtPlanTicketDet.getId()) return false;
			else return (this.getId().equals(debtPlanTicketDet.getId()));
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