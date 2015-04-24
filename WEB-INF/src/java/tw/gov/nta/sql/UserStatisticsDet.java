package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseUserStatisticsDet;



public class UserStatisticsDet extends BaseUserStatisticsDet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UserStatisticsDet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UserStatisticsDet (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UserStatisticsDet (
		java.lang.Integer id,
		tw.gov.nta.sql.UserStatisticsMain userStatisticsMain,
		java.lang.String accountYear,
		java.lang.String dataType) {

		super (
			id,
			userStatisticsMain,
			accountYear,
			dataType);
	}

/*[CONSTRUCTOR MARKER END]*/


}