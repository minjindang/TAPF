package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BaseIssueExchangeDet;



public class IssueExchangeDet extends BaseIssueExchangeDet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public IssueExchangeDet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public IssueExchangeDet (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public IssueExchangeDet (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.IssueMain issue) {

		super (
			id,
			issue);
	}

/*[CONSTRUCTOR MARKER END]*/


}