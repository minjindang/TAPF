package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseTaxactionDet;



public class TaxactionDet extends BaseTaxactionDet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TaxactionDet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TaxactionDet (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TaxactionDet (
		java.lang.Integer id,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate,
		java.lang.String taxKind,
		java.lang.String taxYear,
		java.lang.String taxMonth) {

		super (
			id,
			usrid,
			modDate,
			createDate,
			taxKind,
			taxYear,
			taxMonth);
	}

/*[CONSTRUCTOR MARKER END]*/


}