package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BaseDebtMain;



public class DebtMain extends BaseDebtMain {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public DebtMain () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public DebtMain (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public DebtMain (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.IssueMain issue,
		java.lang.Integer debtCode,
		java.lang.Integer budgetCode) {

		super (
			id,
			issue,
			debtCode,
			budgetCode);
	}

/*[CONSTRUCTOR MARKER END]*/


}