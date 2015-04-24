package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BasePaymentMain;



public class PaymentMain extends BasePaymentMain {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PaymentMain () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PaymentMain (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PaymentMain (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtPlanDet plan,
		java.lang.Integer issueId,
		java.lang.Integer debtId) {

		super (
			id,
			plan,
			issueId,
			debtId);
	}

/*[CONSTRUCTOR MARKER END]*/


}