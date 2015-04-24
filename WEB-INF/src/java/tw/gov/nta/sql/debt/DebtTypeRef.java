package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BaseDebtTypeRef;



public class DebtTypeRef extends BaseDebtTypeRef {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public DebtTypeRef () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public DebtTypeRef (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public DebtTypeRef (
		java.lang.Integer id,
		java.lang.String typeCode,
		java.lang.String typeName,
		java.lang.String type) {

		super (
			id,
			typeCode,
			typeName,
			type);
	}

/*[CONSTRUCTOR MARKER END]*/


}