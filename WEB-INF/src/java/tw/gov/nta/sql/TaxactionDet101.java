package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseTaxactionDet101;

public class TaxactionDet101 extends BaseTaxactionDet101{
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
		public TaxactionDet101 () {
			super();
		}

		/**
		 * Constructor for primary key
		 */
		public TaxactionDet101 (java.lang.Integer id) {
			super(id);
		}

		/**
		 * Constructor for required fields
		 */
		public TaxactionDet101 (
				java.lang.Integer id,
				java.lang.String taxYear,
				java.lang.String taxMonth,
				java.math.BigDecimal nationTax,
				String financialCheck,
				java.math.BigDecimal financial,
				java.math.BigDecimal intTax,	
				java.math.BigDecimal fillAmount,
				java.math.BigDecimal nationRate,
				java.math.BigDecimal localRate,
				java.math.BigDecimal intRate,
				java.math.BigDecimal totMon) {

			super (
				id,
				taxYear,
				taxMonth,
				nationTax,
				financialCheck,
				financial,
				intTax,
				fillAmount,
				nationRate,
				localRate,
				intRate,
				totMon);
		}

	/*[CONSTRUCTOR MARKER END]*/
}
