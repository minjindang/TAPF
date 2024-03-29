package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the issue_ticket_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="issue_ticket_det"
 */

public abstract class BaseIssueTicketDet  implements Comparable, Serializable {

	public static String REF = "IssueTicketDet";
	public static String PROP_ISSUE = "issue";
	public static String PROP_TICKET_NAME = "ticketName";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_TICKET_COUNT = "ticketCount";
	public static String PROP_TICKET_TOTAL = "ticketTotal";
	public static String PROP_USERID = "userid";
	public static String PROP_TICKET_AMOUNT = "ticketAmount";
	public static String PROP_ID = "id";


	// constructors
	public BaseIssueTicketDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIssueTicketDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseIssueTicketDet (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.IssueMain issue) {

		this.setId(id);
		this.setIssue(issue);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ticketName;
	private java.math.BigDecimal ticketAmount;
	private java.math.BigDecimal ticketTotal;
	private java.lang.Long ticketCount;
	private java.lang.String userid;
	private java.util.Date modDate;

	// many to one
	private tw.gov.nta.sql.debt.IssueMain issue;



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
	 * Return the value associated with the column: TICKET_TOTAL
	 */
	public java.math.BigDecimal getTicketTotal () {
		return ticketTotal;
	}

	/**
	 * Set the value related to the column: TICKET_TOTAL
	 * @param ticketTotal the TICKET_TOTAL value
	 */
	public void setTicketTotal (java.math.BigDecimal ticketTotal) {
		this.ticketTotal = ticketTotal;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.IssueTicketDet)) return false;
		else {
			tw.gov.nta.sql.debt.IssueTicketDet issueTicketDet = (tw.gov.nta.sql.debt.IssueTicketDet) obj;
			if (null == this.getId() || null == issueTicketDet.getId()) return false;
			else return (this.getId().equals(issueTicketDet.getId()));
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