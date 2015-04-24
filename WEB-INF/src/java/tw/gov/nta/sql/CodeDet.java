package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseCodeDet;



public class CodeDet extends BaseCodeDet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CodeDet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CodeDet (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CodeDet (
		java.lang.Integer id,
		tw.gov.nta.sql.CodeMain kind,
		java.lang.String codeNo,
		java.lang.String codeName,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		super (
			id,
			kind,
			codeNo,
			codeName,
			usrid,
			modDate,
			createDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}