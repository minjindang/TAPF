package tw.gov.nta.sql.account.base;

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
	public static String PROP_ACCOUNT = "account";
	public static String PROP_VOUCHER = "voucher";
	public static String PROP_ACCOUNT_AMOUNT = "accountAmount";
	public static String PROP_ACCOUNT_TYPE = "accountType";
	public static String PROP_ID = "id";


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
		tw.gov.nta.sql.account.VoucherMain voucher,
		tw.gov.nta.sql.account.AccountRef account,
		java.math.BigDecimal accountAmount,
		java.lang.String accountType) {

		this.setId(id);
		this.setVoucher(voucher);
		this.setAccount(account);
		this.setAccountAmount(accountAmount);
		this.setAccountType(accountType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal accountAmount;
	private java.lang.String accountType;

	// many to one
	private tw.gov.nta.sql.account.VoucherMain voucher;
	private tw.gov.nta.sql.account.AccountRef account;



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
	 * Return the value associated with the column: account_amount
	 */
	public java.math.BigDecimal getAccountAmount () {
		return accountAmount;
	}

	/**
	 * Set the value related to the column: account_amount
	 * @param accountAmount the account_amount value
	 */
	public void setAccountAmount (java.math.BigDecimal accountAmount) {
		this.accountAmount = accountAmount;
	}



	/**
	 * Return the value associated with the column: account_type
	 */
	public java.lang.String getAccountType () {
		return accountType;
	}

	/**
	 * Set the value related to the column: account_type
	 * @param accountType the account_type value
	 */
	public void setAccountType (java.lang.String accountType) {
		this.accountType = accountType;
	}



	/**
	 * Return the value associated with the column: voucher_id
	 */
	public tw.gov.nta.sql.account.VoucherMain getVoucher () {
		return voucher;
	}

	/**
	 * Set the value related to the column: voucher_id
	 * @param voucher the voucher_id value
	 */
	public void setVoucher (tw.gov.nta.sql.account.VoucherMain voucher) {
		this.voucher = voucher;
	}



	/**
	 * Return the value associated with the column: account_code
	 */
	public tw.gov.nta.sql.account.AccountRef getAccount () {
		return account;
	}

	/**
	 * Set the value related to the column: account_code
	 * @param account the account_code value
	 */
	public void setAccount (tw.gov.nta.sql.account.AccountRef account) {
		this.account = account;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.account.VoucherDet)) return false;
		else {
			tw.gov.nta.sql.account.VoucherDet voucherDet = (tw.gov.nta.sql.account.VoucherDet) obj;
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