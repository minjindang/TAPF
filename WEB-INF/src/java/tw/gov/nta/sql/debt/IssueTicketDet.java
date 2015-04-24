package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BaseIssueTicketDet;



public class IssueTicketDet extends BaseIssueTicketDet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public IssueTicketDet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public IssueTicketDet (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public IssueTicketDet (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.IssueMain issue) {

		super (
			id,
			issue);
	}

/*[CONSTRUCTOR MARKER END]*/


}