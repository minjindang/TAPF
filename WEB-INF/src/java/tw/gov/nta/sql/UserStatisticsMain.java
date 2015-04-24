package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseUserStatisticsMain;



public class UserStatisticsMain extends BaseUserStatisticsMain {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UserStatisticsMain () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UserStatisticsMain (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UserStatisticsMain (
		java.lang.Integer id,
		java.lang.String accountYear,
		java.lang.Integer budgetCode,
		java.lang.Integer debtCode,
		java.lang.String boundCode) {

		super (
			id,
			accountYear,
			budgetCode,
			debtCode,
			boundCode);
	}

/*[CONSTRUCTOR MARKER END]*/


}