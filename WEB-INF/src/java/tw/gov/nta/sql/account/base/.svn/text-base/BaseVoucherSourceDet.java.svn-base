package tw.gov.nta.sql.account.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the voucher_source_Det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="voucher_source_Det"
 */

public abstract class BaseVoucherSourceDet  implements Comparable, Serializable {

	public static String REF = "VoucherSourceDet";
	public static String PROP_VOUCHER = "voucher";
	public static String PROP_SOURCE_ID = "sourceId";
	public static String PROP_ID = "id";


	// constructors
	public BaseVoucherSourceDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVoucherSourceDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseVoucherSourceDet (
		java.lang.Integer id,
		java.lang.Integer sourceId) {

		this.setId(id);
		this.setSourceId(sourceId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer sourceId;

	// many to one
	private tw.gov.nta.sql.account.VoucherMain voucher;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IdentityGenerator"
     *  column="id"
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
	 * Return the value associated with the column: SOURCE_ID
	 */
	public java.lang.Integer getSourceId () {
		return sourceId;
	}

	/**
	 * Set the value related to the column: SOURCE_ID
	 * @param sourceId the SOURCE_ID value
	 */
	public void setSourceId (java.lang.Integer sourceId) {
		this.sourceId = sourceId;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.account.VoucherSourceDet)) return false;
		else {
			tw.gov.nta.sql.account.VoucherSourceDet voucherSourceDet = (tw.gov.nta.sql.account.VoucherSourceDet) obj;
			if (null == this.getId() || null == voucherSourceDet.getId()) return false;
			else return (this.getId().equals(voucherSourceDet.getId()));
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