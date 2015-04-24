package tw.gov.nta.sql.debt;

import tw.gov.nta.sql.debt.base.BaseIssueMain;



public class IssueMain extends BaseIssueMain {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public IssueMain () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public IssueMain (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public IssueMain (
		java.lang.Integer id,
		java.lang.Integer debtCode,
		java.lang.Integer budgetCode,
		java.lang.String issueSerial,
		java.lang.String accountYear,
		java.lang.String serialNo) {

		super (
			id,
			debtCode,
			budgetCode,
			issueSerial,
			accountYear,
			serialNo);
	}

/*[CONSTRUCTOR MARKER END]*/


}