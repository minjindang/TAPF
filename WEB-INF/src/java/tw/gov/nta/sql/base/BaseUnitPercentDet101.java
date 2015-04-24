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
public abstract class BaseUnitPercentDet101 implements Comparable, Serializable {
	
	public static String REF = "UnitPercentDet101";
	public static String PROP_USRID = "usrid";
	public static String PROP_REMARK = "remark";
	public static String PROP_TPERCENT = "tpercent";
	public static String PROP_FINANCIAL = "financial";
	public static String PROP_UNIT_INFO = "unitInfo";
	public static String PROP_TYEAR = "tyear";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_ID = "id";


	// constructors
	public BaseUnitPercentDet101 () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUnitPercentDet101 (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUnitPercentDet101 (
		java.lang.Integer id,
		tw.gov.nta.sql.UnitInfoMain unitInfo,
		java.lang.String usrid,
		java.util.Date modDate,
		java.math.BigDecimal financial,
		java.math.BigDecimal tpercent,
		java.lang.String tyear) {

		this.setId(id);
		this.setUnitInfo(unitInfo);
		this.setUsrid(usrid);
		this.setModDate(modDate);
		this.setFinancial(financial);
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
	private java.math.BigDecimal tpercent;
	private java.math.BigDecimal financial;
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
	 * Return the value associated with the column: FINANCIAL
	 */
	public java.math.BigDecimal getFinancial () {
		return financial;
	}

	/**
	 * Set the value related to the column: FINANCIAL
	 * @param financial the FINANCIAL value
	 */
	public void setFinancial (java.math.BigDecimal financial) {
		this.financial = financial;
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
			tw.gov.nta.sql.UnitPercentDet101 unitPercentDet101 = (tw.gov.nta.sql.UnitPercentDet101) obj;
			if (null == this.getId() || null == unitPercentDet101.getId()) return false;
			else return (this.getId().equals(unitPercentDet101.getId()));
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
