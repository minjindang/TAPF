package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BasePaymentTicketDet;



public class PaymentTicketDet extends BasePaymentTicketDet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PaymentTicketDet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PaymentTicketDet (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PaymentTicketDet (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.PaymentMain payment) {

		super (
			id,
			payment);
	}

/*[CONSTRUCTOR MARKER END]*/


}