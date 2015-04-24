package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BaseDebtPlanDet;



public class DebtPlanDet extends BaseDebtPlanDet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public DebtPlanDet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public DebtPlanDet (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public DebtPlanDet (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtMain debt,
		java.lang.Integer issueId) {

		super (
			id,
			debt,
			issueId);
	}

/*[CONSTRUCTOR MARKER END]*/


}