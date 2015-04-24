package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BaseDebtPlanTicketDet;



public class DebtPlanTicketDet extends BaseDebtPlanTicketDet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public DebtPlanTicketDet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public DebtPlanTicketDet (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public DebtPlanTicketDet (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtPlanDet plan) {

		super (
			id,
			plan);
	}

/*[CONSTRUCTOR MARKER END]*/


}