package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Law_percent_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Law_percent_ref"
 */

public abstract class BaseLawPercentRef  implements Comparable, Serializable {

	public static String REF = "LawPercentRef";
	public static String PROP_REMARK = "remark";
	public static String PROP_NATIONC = "nationc";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_LOCALA = "locala";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_NATIONB = "nationb";
	public static String PROP_INTC = "intc";
	public static String PROP_USRID = "usrid";
	public static String PROP_LOCALB = "localb";
	public static String PROP_INTB = "intb";
	public static String PROP_NATIONA = "nationa";
	public static String PROP_LOCALC = "localc";
	public static String PROP_ID = "id";
	public static String PROP_INTA = "inta";


	// constructors
	public BaseLawPercentRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLawPercentRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLawPercentRef (
		java.lang.Integer id,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		this.setId(id);
		this.setUsrid(usrid);
		this.setModDate(modDate);
		this.setCreateDate(createDate);
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
	private java.math.BigDecimal nationa;
	private java.math.BigDecimal nationb;
	private java.math.BigDecimal nationc;
	private java.math.BigDecimal locala;
	private java.math.BigDecimal localb;
	private java.math.BigDecimal localc;
	private java.math.BigDecimal inta;
	private java.math.BigDecimal intb;
	private java.math.BigDecimal intc;



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
	 * Return the value associated with the column: NATIONA
	 */
	public java.math.BigDecimal getNationa () {
		return nationa;
	}

	/**
	 * Set the value related to the column: NATIONA
	 * @param nationa the NATIONA value
	 */
	public void setNationa (java.math.BigDecimal nationa) {
		this.nationa = nationa;
	}



	/**
	 * Return the value associated with the column: NATIONB
	 */
	public java.math.BigDecimal getNationb () {
		return nationb;
	}

	/**
	 * Set the value related to the column: NATIONB
	 * @param nationb the NATIONB value
	 */
	public void setNationb (java.math.BigDecimal nationb) {
		this.nationb = nationb;
	}



	/**
	 * Return the value associated with the column: NATIONC
	 */
	public java.math.BigDecimal getNationc () {
		return nationc;
	}

	/**
	 * Set the value related to the column: NATIONC
	 * @param nationc the NATIONC value
	 */
	public void setNationc (java.math.BigDecimal nationc) {
		this.nationc = nationc;
	}



	/**
	 * Return the value associated with the column: LOCALA
	 */
	public java.math.BigDecimal getLocala () {
		return locala;
	}

	/**
	 * Set the value related to the column: LOCALA
	 * @param locala the LOCALA value
	 */
	public void setLocala (java.math.BigDecimal locala) {
		this.locala = locala;
	}



	/**
	 * Return the value associated with the column: LOCALB
	 */
	public java.math.BigDecimal getLocalb () {
		return localb;
	}

	/**
	 * Set the value related to the column: LOCALB
	 * @param localb the LOCALB value
	 */
	public void setLocalb (java.math.BigDecimal localb) {
		this.localb = localb;
	}



	/**
	 * Return the value associated with the column: LOCALC
	 */
	public java.math.BigDecimal getLocalc () {
		return localc;
	}

	/**
	 * Set the value related to the column: LOCALC
	 * @param localc the LOCALC value
	 */
	public void setLocalc (java.math.BigDecimal localc) {
		this.localc = localc;
	}



	/**
	 * Return the value associated with the column: INTA
	 */
	public java.math.BigDecimal getInta () {
		return inta;
	}

	/**
	 * Set the value related to the column: INTA
	 * @param inta the INTA value
	 */
	public void setInta (java.math.BigDecimal inta) {
		this.inta = inta;
	}



	/**
	 * Return the value associated with the column: INTB
	 */
	public java.math.BigDecimal getIntb () {
		return intb;
	}

	/**
	 * Set the value related to the column: INTB
	 * @param intb the INTB value
	 */
	public void setIntb (java.math.BigDecimal intb) {
		this.intb = intb;
	}



	/**
	 * Return the value associated with the column: INTC
	 */
	public java.math.BigDecimal getIntc () {
		return intc;
	}

	/**
	 * Set the value related to the column: INTC
	 * @param intc the INTC value
	 */
	public void setIntc (java.math.BigDecimal intc) {
		this.intc = intc;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.LawPercentRef)) return false;
		else {
			tw.gov.nta.sql.LawPercentRef lawPercentRef = (tw.gov.nta.sql.LawPercentRef) obj;
			if (null == this.getId() || null == lawPercentRef.getId()) return false;
			else return (this.getId().equals(lawPercentRef.getId()));
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