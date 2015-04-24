package tw.gov.nta.sql.debt.base;

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
	public static String PROP_VOUCHER_TYPE = "voucherType";
	public static String PROP_USRID = "usrid";
	public static String PROP_USERED = "usered";
	public static String PROP_PROCEDUCE_CODE = "proceduceCode";
	public static String PROP_SOURCE_TYPE = "sourceType";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_VOUCHER_NO = "voucherNo";
	public static String PROP_SOURCE_ID = "sourceId";
	public static String PROP_ID = "id";
	public static String PROP_DELETE = "delete";


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
		java.lang.Integer sourceId,
		java.lang.String sourceType,
		java.lang.String voucherNo,
		java.lang.Integer proceduceCode,
		java.lang.String voucherType) {

		this.setId(id);
		this.setSourceId(sourceId);
		this.setSourceType(sourceType);
		this.setVoucherNo(voucherNo);
		this.setProceduceCode(proceduceCode);
		this.setVoucherType(voucherType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer sourceId;
	private java.lang.String sourceType;
	private java.lang.String voucherNo;
	private java.lang.Integer proceduceCode;
	private java.lang.String voucherType;
	private java.util.Date voucherDate;
	private boolean usered;
	private boolean delete;
	private java.lang.String usrid;
	private java.util.Date modDate;

	// collections
	private java.util.Set<tw.gov.nta.sql.debt.VoucherDet> voucherDets;



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
	 * Return the value associated with the column: PROCEDUCE_CODE
	 */
	public java.lang.Integer getProceduceCode () {
		return proceduceCode;
	}

	/**
	 * Set the value related to the column: PROCEDUCE_CODE
	 * @param proceduceCode the PROCEDUCE_CODE value
	 */
	public void setProceduceCode (java.lang.Integer proceduceCode) {
		this.proceduceCode = proceduceCode;
	}



	/**
	 * Return the value associated with the column: VOUCHER_TYPE
	 */
	public java.lang.String getVoucherType () {
		return voucherType;
	}

	/**
	 * Set the value related to the column: VOUCHER_TYPE
	 * @param voucherType the VOUCHER_TYPE value
	 */
	public void setVoucherType (java.lang.String voucherType) {
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
	 * Return the value associated with the column: IS_USERED
	 */
	public boolean isUsered () {
		return usered;
	}

	/**
	 * Set the value related to the column: IS_USERED
	 * @param usered the IS_USERED value
	 */
	public void setUsered (boolean usered) {
		this.usered = usered;
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
	 * Return the value associated with the column: voucherDets
	 */
	public java.util.Set<tw.gov.nta.sql.debt.VoucherDet> getVoucherDets () {
		return voucherDets;
	}

	/**
	 * Set the value related to the column: voucherDets
	 * @param voucherDets the voucherDets value
	 */
	public void setVoucherDets (java.util.Set<tw.gov.nta.sql.debt.VoucherDet> voucherDets) {
		this.voucherDets = voucherDets;
	}

	public void addTovoucherDets (tw.gov.nta.sql.debt.VoucherDet voucherDet) {
		if (null == getVoucherDets()) setVoucherDets(new java.util.TreeSet<tw.gov.nta.sql.debt.VoucherDet>());
		getVoucherDets().add(voucherDet);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.VoucherMain)) return false;
		else {
			tw.gov.nta.sql.debt.VoucherMain voucherMain = (tw.gov.nta.sql.debt.VoucherMain) obj;
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