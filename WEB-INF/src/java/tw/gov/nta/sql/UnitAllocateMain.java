package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseUnitAllocateMain;



public class UnitAllocateMain extends BaseUnitAllocateMain {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UnitAllocateMain () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UnitAllocateMain (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UnitAllocateMain (
		java.lang.Integer id,
		tw.gov.nta.sql.UnitInfoMain unitInfo) {

		super (
			id,
			unitInfo);
	}

/*[CONSTRUCTOR MARKER END]*/


}