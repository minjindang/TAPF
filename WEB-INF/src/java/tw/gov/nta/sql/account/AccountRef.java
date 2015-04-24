package tw.gov.nta.sql.account;

import tw.gov.nta.sql.account.base.BaseAccountRef;



public class AccountRef extends BaseAccountRef {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public AccountRef () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AccountRef (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public AccountRef (
		java.lang.Integer id,
		java.lang.String accountCode,
		java.lang.String accountName,
		java.lang.String accountType) {

		super (
			id,
			accountCode,
			accountName,
			accountType);
	}

/*[CONSTRUCTOR MARKER END]*/


}