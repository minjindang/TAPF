package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseBudgetRef;



public class BudgetRef extends BaseBudgetRef {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BudgetRef () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BudgetRef (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BudgetRef (
		java.lang.Integer id,
		java.lang.String budgetType,
		java.lang.String budgetName,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		super (
			id,
			budgetType,
			budgetName,
			usrid,
			modDate,
			createDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}