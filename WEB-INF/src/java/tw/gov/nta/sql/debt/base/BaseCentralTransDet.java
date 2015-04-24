package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the central_trans_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="central_trans_det"
 */

public abstract class BaseCentralTransDet  implements Comparable, Serializable {

	public static String REF = "CentralTransDet";
	public static String PROP_USRID = "usrid";
	public static String PROP_REMARK = "remark";
	public static String PROP_ISSUE_ID = "issueId";
	public static String PROP_TICKET_NAME = "ticketName";
	public static String PROP_TICKET_COUNT = "ticketCount";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_TOTAL_AMOUNT = "totalAmount";
	public static String PROP_CRE_DATE = "creDate";
	public static String PROP_TICKET_AMOUNT = "ticketAmount";
	public static String PROP_ID = "id";
	public static String PROP_TRANS_ID = "transId";


	// constructors
	public BaseCentralTransDet () {
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCentralTransDet (
		java.lang.Integer id,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date creDate,
		java.lang.Integer issueId,
		java.lang.Integer transId,
		java.lang.String ticketName,
		java.math.BigDecimal ticketAmount,
		java.lang.Integer ticketCount,
		java.math.BigDecimal totalAmount) {

		this.setId(id);
		this.setUsrid(usrid);
		this.setModDate(modDate);
		this.setCreDate(creDate);
		this.setIssueId(issueId);
		this.setTransId(transId);
		this.setTicketName(ticketName);
		this.setTicketAmount(ticketAmount);
		this.setTicketCount(ticketCount);
		this.setTotalAmount(totalAmount);
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.Integer id;
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date creDate;
	private java.lang.Integer issueId;
	private java.lang.Integer transId;
	private java.lang.String ticketName;
	private java.math.BigDecimal ticketAmount;
	private java.lang.Integer ticketCount;
	private java.math.BigDecimal totalAmount;






	/**
	 * Return the value associated with the column: ID
	 */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the value related to the column: ID
	 * @param id the ID value
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: USRID
	 */
	public java.lang.String getUsrid () {
		return usrid;
	}

	/**
	 * Set the value related to the column: USRID
	 * @param usrid the USRID value
	 */
	public void setUsrid (java.lang.String usrid) {
		this.usrid = usrid;
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
	 * Return the value associated with the column: CRE_DATE
	 */
	public java.util.Date getCreDate () {
		return creDate;
	}

	/**
	 * Set the value related to the column: CRE_DATE
	 * @param creDate the CRE_DATE value
	 */
	public void setCreDate (java.util.Date creDate) {
		this.creDate = creDate;
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
	 * Return the value associated with the column: TRANS_ID
	 */
	public java.lang.Integer getTransId () {
		return transId;
	}

	/**
	 * Set the value related to the column: TRANS_ID
	 * @param transId the TRANS_ID value
	 */
	public void setTransId (java.lang.Integer transId) {
		this.transId = transId;
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
	public java.lang.Integer getTicketCount () {
		return ticketCount;
	}

	/**
	 * Set the value related to the column: TICKET_COUNT
	 * @param ticketCount the TICKET_COUNT value
	 */
	public void setTicketCount (java.lang.Integer ticketCount) {
		this.ticketCount = ticketCount;
	}



	/**
	 * Return the value associated with the column: TOTAL_AMOUNT
	 */
	public java.math.BigDecimal getTotalAmount () {
		return totalAmount;
	}

	/**
	 * Set the value related to the column: TOTAL_AMOUNT
	 * @param totalAmount the TOTAL_AMOUNT value
	 */
	public void setTotalAmount (java.math.BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
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