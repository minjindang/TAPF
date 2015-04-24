package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the voucher_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="voucher_det"
 */

public abstract class BaseVoucherDet  implements Comparable, Serializable {

	public static String REF = "VoucherDet";
	public static String PROP_DEBT_AMOUNT = "debtAmount";
	public static String PROP_USRID = "usrid";
	public static String PROP_VOUCHER = "voucher";
	public static String PROP_CREDIT_AMOUNT = "creditAmount";
	public static String PROP_DEBT_CODE = "debtCode";
	public static String PROP_DEBT_ACCOUNT = "debtAccount";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_CREDIT_ACCOUNT = "creditAccount";
	public static String PROP_ID = "id";
	public static String PROP_BUDGET_CODE = "budgetCode";


	// constructors
	public BaseVoucherDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVoucherDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseVoucherDet (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.VoucherMain voucher,
		java.lang.Integer debtCode,
		java.lang.Integer budgetCode,
		java.lang.String debtAccount,
		java.lang.String creditAccount) {

		this.setId(id);
		this.setVoucher(voucher);
		this.setDebtCode(debtCode);
		this.setBudgetCode(budgetCode);
		this.setDebtAccount(debtAccount);
		this.setCreditAccount(creditAccount);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer debtCode;
	private java.lang.Integer budgetCode;
	private java.lang.String debtAccount;
	private java.lang.String creditAccount;
	private java.math.BigDecimal debtAmount;
	private java.math.BigDecimal creditAmount;
	private java.lang.String usrid;
	private java.util.Date modDate;

	// many to one
	private tw.gov.nta.sql.debt.VoucherMain voucher;



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
	 * Return the value associated with the column: DEBT_CODE
	 */
	public java.lang.Integer getDebtCode () {
		return debtCode;
	}

	/**
	 * Set the value related to the column: DEBT_CODE
	 * @param debtCode the DEBT_CODE value
	 */
	public void setDebtCode (java.lang.Integer debtCode) {
		this.debtCode = debtCode;
	}



	/**
	 * Return the value associated with the column: BUDGET_CODE
	 */
	public java.lang.Integer getBudgetCode () {
		return budgetCode;
	}

	/**
	 * Set the value related to the column: BUDGET_CODE
	 * @param budgetCode the BUDGET_CODE value
	 */
	public void setBudgetCode (java.lang.Integer budgetCode) {
		this.budgetCode = budgetCode;
	}



	/**
	 * Return the value associated with the column: DEBT_ACCOUNT
	 */
	public java.lang.String getDebtAccount () {
		return debtAccount;
	}

	/**
	 * Set the value related to the column: DEBT_ACCOUNT
	 * @param debtAccount the DEBT_ACCOUNT value
	 */
	public void setDebtAccount (java.lang.String debtAccount) {
		this.debtAccount = debtAccount;
	}



	/**
	 * Return the value associated with the column: CREDIT_ACCOUNT
	 */
	public java.lang.String getCreditAccount () {
		return creditAccount;
	}

	/**
	 * Set the value related to the column: CREDIT_ACCOUNT
	 * @param creditAccount the CREDIT_ACCOUNT value
	 */
	public void setCreditAccount (java.lang.String creditAccount) {
		this.creditAccount = creditAccount;
	}



	/**
	 * Return the value associated with the column: DEBT_AMOUNT
	 */
	public java.math.BigDecimal getDebtAmount () {
		return debtAmount;
	}

	/**
	 * Set the value related to the column: DEBT_AMOUNT
	 * @param debtAmount the DEBT_AMOUNT value
	 */
	public void setDebtAmount (java.math.BigDecimal debtAmount) {
		this.debtAmount = debtAmount;
	}



	/**
	 * Return the value associated with the column: CREDIT_AMOUNT
	 */
	public java.math.BigDecimal getCreditAmount () {
		return creditAmount;
	}

	/**
	 * Set the value related to the column: CREDIT_AMOUNT
	 * @param creditAmount the CREDIT_AMOUNT value
	 */
	public void setCreditAmount (java.math.BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}



	/**
	 * Return the value associated with the column: USRID
	 */
	public java.lang.String getUsrid () {
		return usrid;
	}

	/**
	 * Set the value related to the column: USRID
	 * @param usrid the USRID value
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
	 * Return the value associated with the column: VOUCHER_ID
	 */
	public tw.gov.nta.sql.debt.VoucherMain getVoucher () {
		return voucher;
	}

	/**
	 * Set the value related to the column: VOUCHER_ID
	 * @param voucher the VOUCHER_ID value
	 */
	public void setVoucher (tw.gov.nta.sql.debt.VoucherMain voucher) {
		this.voucher = voucher;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.VoucherDet)) return false;
		else {
			tw.gov.nta.sql.debt.VoucherDet voucherDet = (tw.gov.nta.sql.debt.VoucherDet) obj;
			if (null == this.getId() || null == voucherDet.getId()) return false;
			else return (this.getId().equals(voucherDet.getId()));
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