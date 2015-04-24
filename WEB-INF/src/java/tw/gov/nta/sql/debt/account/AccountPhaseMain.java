package tw.gov.nta.sql.debt.account;

import tw.gov.nta.sql.debt.account.base.BaseAccountPhaseMain;



public class AccountPhaseMain extends BaseAccountPhaseMain {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public AccountPhaseMain () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AccountPhaseMain (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public AccountPhaseMain (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtTypeRef debtType,
		java.lang.String phaseCode,
		java.lang.String phaseName,
		java.lang.String phaseShortName,
		java.lang.Integer phaseType,
		java.lang.String issueKind) {

		super (
			id,
			debtType,
			phaseCode,
			phaseName,
			phaseShortName,
			phaseType,
			issueKind);
	}

/*[CONSTRUCTOR MARKER END]*/


}