package tw.gov.nta.sql.debt.account;

import tw.gov.nta.sql.debt.account.base.BaseVoucherNoRef;



public class VoucherNoRef extends BaseVoucherNoRef {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public VoucherNoRef () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public VoucherNoRef (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public VoucherNoRef (
		java.lang.Integer id,
		java.lang.String accountYear,
		java.lang.String debtCode,
		java.lang.String issueSerial,
		java.lang.Integer serialNo,
		java.lang.Integer voucherType) {

		super (
			id,
			accountYear,
			debtCode,
			issueSerial,
			serialNo,
			voucherType);
	}

/*[CONSTRUCTOR MARKER END]*/


}