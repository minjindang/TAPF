package tw.gov.nta.sql.account;

import tw.gov.nta.sql.account.base.BaseVoucherSourceDet;



public class VoucherSourceDet extends BaseVoucherSourceDet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public VoucherSourceDet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public VoucherSourceDet (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public VoucherSourceDet (
		java.lang.Integer id,
		java.lang.Integer sourceId) {

		super (
			id,
			sourceId);
	}

/*[CONSTRUCTOR MARKER END]*/


}