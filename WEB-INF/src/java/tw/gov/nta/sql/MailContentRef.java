package tw.gov.nta.sql;

import tw.gov.nta.sql.base.BaseMailContentRef;



public class MailContentRef extends BaseMailContentRef {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MailContentRef () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MailContentRef (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MailContentRef (
		java.lang.Integer id,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate,
		java.lang.String monKind,
		java.lang.String titlea,
		java.lang.String titleb,
		java.lang.String contenta,
		java.lang.String contentb) {

		super (
			id,
			usrid,
			modDate,
			createDate,
			monKind,
			titlea,
			titleb,
			contenta,
			contentb);
	}

/*[CONSTRUCTOR MARKER END]*/


}