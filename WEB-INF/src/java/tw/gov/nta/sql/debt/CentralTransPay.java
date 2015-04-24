package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BaseCentralTransPay;



public class CentralTransPay extends BaseCentralTransPay {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CentralTransPay () {
		super();
	}

	/**
	 * Constructor for required fields
	 */
	public CentralTransPay (
		java.lang.Integer id,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date creDate,
		java.lang.Integer bankId,
		java.lang.Integer ticketCount,
		java.lang.Integer issueId,
		java.lang.Integer paymentId,
		java.math.BigDecimal payDate,
		java.lang.String attachSerial) {

		super (
			id,
			usrid,
			modDate,
			creDate,
			bankId,
			ticketCount,
			issueId,
			paymentId,
			payDate,
			attachSerial);
	}

/*[CONSTRUCTOR MARKER END]*/


}