package tw.gov.nta.sql.account.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the voucher_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="voucher_main"
 */

public abstract class BaseVoucherMain  implements Comparable, Serializable {

	public static String REF = "VoucherMain";
	public static String PROP_VOUCHER_DATE = "voucherDate";
	public static String PROP_POST_DATE = "postDate";
	public static String PROP_REMARK = "remark";
	public static String PROP_SOURCE_TYPE = "sourceType";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_ISSUE_KIND = "issueKind";
	public static String PROP_DELETE = "delete";
	public static String PROP_DEBT_TYPE = "debtType";
	public static String PROP_VOUCHER_TYPE = "voucherType";
	public static String PROP_USRID = "usrid";
	public static String PROP_DEBT_CODE = "debtCode";
	public static String PROP_ISSUE_ID = "issueId";
	public static String PROP_PHASE = "phase";
	public static String PROP_VOUCHER_SER = "voucherSer";
	public static String PROP_VOUCHER_NO = "voucherNo";
	public static String PROP_ID = "id";
	public static String PROP_POST_USR = "postUsr";
	public static String PROP_BUDGET_CODE = "budgetCode";


	// constructors
	public BaseVoucherMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVoucherMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseVoucherMain (
		java.lang.Integer id,
		java.lang.String sourceType,
		java.lang.String voucherNo,
		java.lang.Integer voucherType) {

		this.setId(id);
		this.setSourceType(sourceType);
		this.setVoucherNo(voucherNo);
		this.setVoucherType(voucherType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sourceType;
	private java.lang.String voucherNo;
	private java.lang.Integer voucherType;
	private java.util.Date voucherDate;
	private boolean delete;
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.Integer issueId;
	private java.lang.Integer voucherSer;
	private java.util.Date postDate;
	private java.lang.String postUsr;
	private java.lang.String remark;
	private java.lang.Integer budgetCode;
	private java.lang.Integer debtCode;
	private java.lang.String issueKind;

	// many to one
	private tw.gov.nta.sql.debt.account.AccountPhaseMain phase;
	private tw.gov.nta.sql.debt.DebtTypeRef debtType;

	// collections
	private java.util.Set<tw.gov.nta.sql.account.VoucherDet> voucherDets;
	private java.util.Set<tw.gov.nta.sql.account.VoucherSourceDet> voucherSourceDets;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IdentityGenerator"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: SOURCE_TYPE
	 */
	public java.lang.String getSourceType () {
		return sourceType;
	}

	/**
	 * Set the value related to the column: SOURCE_TYPE
	 * @param sourceType the SOURCE_TYPE value
	 */
	public void setSourceType (java.lang.String sourceType) {
		this.sourceType = sourceType;
	}



	/**
	 * Return the value associated with the column: VOUCHER_NO
	 */
	public java.lang.String getVoucherNo () {
		return voucherNo;
	}

	/**
	 * Set the value related to the column: VOUCHER_NO
	 * @param voucherNo the VOUCHER_NO value
	 */
	public void setVoucherNo (java.lang.String voucherNo) {
		this.voucherNo = voucherNo;
	}



	/**
	 * Return the value associated with the column: voucher_type
	 */
	public java.lang.Integer getVoucherType () {
		return voucherType;
	}

	/**
	 * Set the value related to the column: voucher_type
	 * @param voucherType the voucher_type value
	 */
	public void setVoucherType (java.lang.Integer voucherType) {
		this.voucherType = voucherType;
	}



	/**
	 * Return the value associated with the column: VOUCHER_DATE
	 */
	public java.util.Date getVoucherDate () {
		return voucherDate;
	}

	/**
	 * Set the value related to the column: VOUCHER_DATE
	 * @param voucherDate the VOUCHER_DATE value
	 */
	public void setVoucherDate (java.util.Date voucherDate) {
		this.voucherDate = voucherDate;
	}



	/**
	 * Return the value associated with the column: IS_DELETE
	 */
	public boolean isDelete () {
		return delete;
	}

	/**
	 * Set the value related to the column: IS_DELETE
	 * @param delete the IS_DELETE value
	 */
	public void setDelete (boolean delete) {
		this.delete = delete;
	}



	/**
	 * Return the value associated with the column: usr_id
	 */
	public java.lang.String getUsrid () {
		return usrid;
	}

	/**
	 * Set the value related to the column: usr_id
	 * @param usrid the usr_id value
	 */
	public void setUsrid (java.lang.String usrid) {
		this.usrid = usrid;
	}



	/**
	 * Return the value associated with the column: MOD_DATE
	 */
	public java.util.Date getModDate () {
		return modDate;
	}

	/**
	 * Set the value related to the column: MOD_DATE
	 * @param modDate the MOD_DATE value
	 */
	public void setModDate (java.util.Date modDate) {
		this.modDate = modDate;
	}



	/**
	 * Return the value associated with the column: issue_id
	 */
	public java.lang.Integer getIssueId () {
		return issueId;
	}

	/**
	 * Set the value related to the column: issue_id
	 * @param issueId the issue_id value
	 */
	public void setIssueId (java.lang.Integer issueId) {
		this.issueId = issueId;
	}



	/**
	 * Return the value associated with the column: voucher_ser
	 */
	public java.lang.Integer getVoucherSer () {
		return voucherSer;
	}

	/**
	 * Set the value related to the column: voucher_ser
	 * @param voucherSer the voucher_ser value
	 */
	public void setVoucherSer (java.lang.Integer voucherSer) {
		this.voucherSer = voucherSer;
	}



	/**
	 * Return the value associated with the column: post_date
	 */
	public java.util.Date getPostDate () {
		return postDate;
	}

	/**
	 * Set the value related to the column: post_date
	 * @param postDate the post_date value
	 */
	public void setPostDate (java.util.Date postDate) {
		this.postDate = postDate;
	}



	/**
	 * Return the value associated with the column: post_usr
	 */
	public java.lang.String getPostUsr () {
		return postUsr;
	}

	/**
	 * Set the value related to the column: post_usr
	 * @param postUsr the post_usr value
	 */
	public void setPostUsr (java.lang.String postUsr) {
		this.postUsr = postUsr;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: budget_code
	 */
	public java.lang.Integer getBudgetCode () {
		return budgetCode;
	}

	/**
	 * Set the value related to the column: budget_code
	 * @param budgetCode the budget_code value
	 */
	public void setBudgetCode (java.lang.Integer budgetCode) {
		this.budgetCode = budgetCode;
	}



	/**
	 * Return the value associated with the column: debt_code
	 */
	public java.lang.Integer getDebtCode () {
		return debtCode;
	}

	/**
	 * Set the value related to the column: debt_code
	 * @param debtCode the debt_code value
	 */
	public void setDebtCode (java.lang.Integer debtCode) {
		this.debtCode = debtCode;
	}



	/**
	 * Return the value associated with the column: issue_kind
	 */
	public java.lang.String getIssueKind () {
		return issueKind;
	}

	/**
	 * Set the value related to the column: issue_kind
	 * @param issueKind the issue_kind value
	 */
	public void setIssueKind (java.lang.String issueKind) {
		this.issueKind = issueKind;
	}



	/**
	 * Return the value associated with the column: phase_id
	 */
	public tw.gov.nta.sql.debt.account.AccountPhaseMain getPhase () {
		return phase;
	}

	/**
	 * Set the value related to the column: phase_id
	 * @param phase the phase_id value
	 */
	public void setPhase (tw.gov.nta.sql.debt.account.AccountPhaseMain phase) {
		this.phase = phase;
	}



	/**
	 * Return the value associated with the column: debt_type_id
	 */
	public tw.gov.nta.sql.debt.DebtTypeRef getDebtType () {
		return debtType;
	}

	/**
	 * Set the value related to the column: debt_type_id
	 * @param debtType the debt_type_id value
	 */
	public void setDebtType (tw.gov.nta.sql.debt.DebtTypeRef debtType) {
		this.debtType = debtType;
	}



	/**
	 * Return the value associated with the column: voucherDets
	 */
	public java.util.Set<tw.gov.nta.sql.account.VoucherDet> getVoucherDets () {
		return voucherDets;
	}

	/**
	 * Set the value related to the column: voucherDets
	 * @param voucherDets the voucherDets value
	 */
	public void setVoucherDets (java.util.Set<tw.gov.nta.sql.account.VoucherDet> voucherDets) {
		this.voucherDets = voucherDets;
	}

	public void addTovoucherDets (tw.gov.nta.sql.account.VoucherDet voucherDet) {
		if (null == getVoucherDets()) setVoucherDets(new java.util.TreeSet<tw.gov.nta.sql.account.VoucherDet>());
		getVoucherDets().add(voucherDet);
	}



	/**
	 * Return the value associated with the column: voucherSourceDets
	 */
	public java.util.Set<tw.gov.nta.sql.account.VoucherSourceDet> getVoucherSourceDets () {
		return voucherSourceDets;
	}

	/**
	 * Set the value related to the column: voucherSourceDets
	 * @param voucherSourceDets the voucherSourceDets value
	 */
	public void setVoucherSourceDets (java.util.Set<tw.gov.nta.sql.account.VoucherSourceDet> voucherSourceDets) {
		this.voucherSourceDets = voucherSourceDets;
	}

	public void addTovoucherSourceDets (tw.gov.nta.sql.account.VoucherSourceDet voucherSourceDet) {
		if (null == getVoucherSourceDets()) setVoucherSourceDets(new java.util.TreeSet<tw.gov.nta.sql.account.VoucherSourceDet>());
		getVoucherSourceDets().add(voucherSourceDet);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.account.VoucherMain)) return false;
		else {
			tw.gov.nta.sql.account.VoucherMain voucherMain = (tw.gov.nta.sql.account.VoucherMain) obj;
			if (null == this.getId() || null == voucherMain.getId()) return false;
			else return (this.getId().equals(voucherMain.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}


}