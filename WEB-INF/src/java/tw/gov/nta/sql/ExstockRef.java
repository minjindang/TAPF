package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseExstockRef;



public class ExstockRef extends BaseExstockRef {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ExstockRef () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ExstockRef (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ExstockRef (
		java.lang.Integer id,
		java.lang.String stockId,
		java.lang.String stockName,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		super (
			id,
			stockId,
			stockName,
			usrid,
			modDate,
			createDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}