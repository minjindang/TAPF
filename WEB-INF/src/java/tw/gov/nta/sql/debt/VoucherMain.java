package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BaseVoucherMain;



public class VoucherMain extends BaseVoucherMain {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public VoucherMain () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public VoucherMain (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public VoucherMain (
		java.lang.Integer id,
		java.lang.Integer sourceId,
		java.lang.String sourceType,
		java.lang.String voucherNo,
		java.lang.Integer proceduceCode,
		java.lang.String voucherType) {

		super (
			id,
			sourceId,
			sourceType,
			voucherNo,
			proceduceCode,
			voucherType);
	}

/*[CONSTRUCTOR MARKER END]*/


}