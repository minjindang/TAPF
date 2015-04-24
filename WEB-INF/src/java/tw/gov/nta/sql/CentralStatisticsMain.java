package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseCentralStatisticsMain;



public class CentralStatisticsMain extends BaseCentralStatisticsMain {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CentralStatisticsMain () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CentralStatisticsMain (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CentralStatisticsMain (
		java.lang.Integer id,
		java.lang.String accountYear,
		java.lang.Integer budgetCode,
		java.lang.Integer debtCode,
		java.lang.String debtType,
		java.lang.String boundCode,
		boolean debt,
		java.lang.String accountKind,
		boolean account,
		java.math.BigDecimal issueAmount,
		java.math.BigDecimal payAmount,
		java.math.BigDecimal remainAmount,
		java.math.BigDecimal interestAmount) {

		super (
			id,
			accountYear,
			budgetCode,
			debtCode,
			debtType,
			boundCode,
			debt,
			accountKind,
			account,
			issueAmount,
			payAmount,
			remainAmount,
			interestAmount);
	}

/*[CONSTRUCTOR MARKER END]*/


}