package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BaseInterestAdjustMain;



public class InterestAdjustMain extends BaseInterestAdjustMain {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InterestAdjustMain () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InterestAdjustMain (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public InterestAdjustMain (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtPlanDet plan,
		java.lang.Integer groupId,
		java.lang.Integer debtId,
		java.math.BigDecimal changeRate) {

		super (
			id,
			plan,
			groupId,
			debtId,
			changeRate);
	}

/*[CONSTRUCTOR MARKER END]*/


}