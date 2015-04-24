package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseUnitPercentDet101;

public class UnitPercentDet101 extends BaseUnitPercentDet101 {

	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
		public UnitPercentDet101 () {
			super();
		}

		/**
		 * Constructor for primary key
		 */
		public UnitPercentDet101 (java.lang.Integer id) {
			super(id);
		}

		/**
		 * Constructor for required fields
		 */
		public UnitPercentDet101 (
			java.lang.Integer id,
			tw.gov.nta.sql.UnitInfoMain unitInfo,
			java.lang.String usrid,
			java.util.Date modDate,
			java.math.BigDecimal financial,
			java.math.BigDecimal tpercent,
			java.lang.String tyear) {

			super (
				id,
				unitInfo,
				usrid,
				modDate,
				financial,
				tpercent,
				tyear);
		}

	/*[CONSTRUCTOR MARKER END]*/

}
