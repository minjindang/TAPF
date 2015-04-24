package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BaseCentralTransDet;



public class CentralTransDet extends BaseCentralTransDet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CentralTransDet () {
		super();
	}

	/**
	 * Constructor for required fields
	 */
	public CentralTransDet (
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

		super (
			id,
			usrid,
			modDate,
			creDate,
			issueId,
			transId,
			ticketName,
			ticketAmount,
			ticketCount,
			totalAmount);
	}

/*[CONSTRUCTOR MARKER END]*/


}