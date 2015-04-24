package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseDebitRef;



public class DebitRef extends BaseDebitRef {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public DebitRef () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public DebitRef (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public DebitRef (
		java.lang.Integer id,
		tw.gov.nta.sql.BudgetRef budgetCode,
		java.lang.String debitType,
		java.lang.String debitName,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		super (
			id,
			budgetCode,
			debitType,
			debitName,
			usrid,
			modDate,
			createDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}