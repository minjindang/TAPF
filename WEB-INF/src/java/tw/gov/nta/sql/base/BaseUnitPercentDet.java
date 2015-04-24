package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Unit_percent_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Unit_percent_det"
 */

public abstract class BaseUnitPercentDet  implements Comparable, Serializable {

	public static String REF = "UnitPercentDet";
	public static String PROP_USRID = "usrid";
	public static String PROP_REMARK = "remark";
	public static String PROP_TPERCENT = "tpercent";
	public static String PROP_UNIT_INFO = "unitInfo";
	public static String PROP_TYEAR = "tyear";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_ID = "id";


	// constructors
	public BaseUnitPercentDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUnitPercentDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUnitPercentDet (
		java.lang.Integer id,
		tw.gov.nta.sql.UnitInfoMain unitInfo,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate,
		java.math.BigDecimal tpercent,
		java.lang.String tyear) {

		this.setId(id);
		this.setUnitInfo(unitInfo);
		this.setUsrid(usrid);
		this.setModDate(modDate);
		this.setCreateDate(createDate);
		this.setTpercent(tpercent);
		this.setTyear(tyear);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;
	private java.math.BigDecimal tpercent;
	private java.lang.String tyear;

	// many to one
	private tw.gov.nta.sql.UnitInfoMain unitInfo;



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
	 * Return the value associated with the column: REMARK
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: REMARK
	 * @param remark the REMARK value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: CREATE_DATE
	 */
	public java.util.Date getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: CREATE_DATE
	 * @param createDate the CREATE_DATE value
	 */
	public void setCreateDate (java.util.Date createDate) {
		this.createDate = createDate;
	}



	/**
	 * Return the value associated with the column: TPERCENT
	 */
	public java.math.BigDecimal getTpercent () {
		return tpercent;
	}

	/**
	 * Set the value related to the column: TPERCENT
	 * @param tpercent the TPERCENT value
	 */
	public void setTpercent (java.math.BigDecimal tpercent) {
		this.tpercent = tpercent;
	}



	/**
	 * Return the value associated with the column: TYEAR
	 */
	public java.lang.String getTyear () {
		return tyear;
	}

	/**
	 * Set the value related to the column: TYEAR
	 * @param tyear the TYEAR value
	 */
	public void setTyear (java.lang.String tyear) {
		this.tyear = tyear;
	}



	/**
	 * Return the value associated with the column: UNIT_INFO_ID
	 */
	public tw.gov.nta.sql.UnitInfoMain getUnitInfo () {
		return unitInfo;
	}

	/**
	 * Set the value related to the column: UNIT_INFO_ID
	 * @param unitInfo the UNIT_INFO_ID value
	 */
	public void setUnitInfo (tw.gov.nta.sql.UnitInfoMain unitInfo) {
		this.unitInfo = unitInfo;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.UnitPercentDet)) return false;
		else {
			tw.gov.nta.sql.UnitPercentDet unitPercentDet = (tw.gov.nta.sql.UnitPercentDet) obj;
			if (null == this.getId() || null == unitPercentDet.getId()) return false;
			else return (this.getId().equals(unitPercentDet.getId()));
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