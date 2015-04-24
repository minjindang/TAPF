package tw.gov.nta.sql.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the Law_percent_ref_101
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="Law_percent_ref_101"
 */
public abstract class BaseLawPercentRef101 implements Comparable, Serializable {

	public static String REF = "LawPercentRef101";

	public static String PROP_REMARK = "remark";

	public static String PROP_MOD_DATE = "modDate";

	public static String PROP_NATION = "nation";

	public static String PROP_INTEREST = "interest";

	public static String PROP_USRID = "usrid";

	public static String PROP_ID = "id";

	// constructors
	public BaseLawPercentRef101() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLawPercentRef101(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLawPercentRef101(java.lang.Integer id, java.lang.String usrid,
			java.util.Date modDate) {

		this.setId(id);
		this.setUsrid(usrid);
		this.setModDate(modDate);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String usrid;

	private java.util.Date modDate;

	private java.lang.String remark;

	private java.math.BigDecimal nation;

	private java.math.BigDecimal interest;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="org.hibernate.id.IdentityGenerator"
	 *               column="ID"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: USRID
	 */
	public java.lang.String getUsrid() {
		return usrid;
	}

	/**
	 * Set the value related to the column: USRID
	 * 
	 * @param usrid
	 *            the USRID value
	 */
	public void setUsrid(java.lang.String usrid) {
		this.usrid = usrid;
	}

	/**
	 * Return the value associated with the column: MOD_DATE
	 */
	public java.util.Date getModDate() {
		return modDate;
	}

	/**
	 * Set the value related to the column: MOD_DATE
	 * 
	 * @param modDate
	 *            the MOD_DATE value
	 */
	public void setModDate(java.util.Date modDate) {
		this.modDate = modDate;
	}

	/**
	 * Return the value associated with the column: REMARK
	 */
	public java.lang.String getRemark() {
		return remark;
	}

	/**
	 * Set the value related to the column: REMARK
	 * 
	 * @param remark
	 *            the REMARK value
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
	 * Return the value associated with the column: NATION
	 */
	public java.math.BigDecimal getNation() {
		return nation;
	}

	/**
	 * Set the value related to the column: NATION
	 * 
	 * @param nationa
	 *            the NATION value
	 */
	public void setNation(java.math.BigDecimal nation) {
		this.nation = nation;
	}

	/**
	 * Return the value associated with the column: INT
	 */
	public java.math.BigDecimal getInterest() {
		return interest;
	}

	/**
	 * Set the value related to the column: INT
	 * 
	 * @param inta
	 *            the INT value
	 */
	public void setInterest(java.math.BigDecimal interest) {
		this.interest = interest;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof tw.gov.nta.sql.LawPercentRef101))
			return false;
		else {
			tw.gov.nta.sql.LawPercentRef101 LawPercentRef101 = (tw.gov.nta.sql.LawPercentRef101) obj;
			if (null == this.getId() || null == LawPercentRef101.getId())
				return false;
			else
				return (this.getId().equals(LawPercentRef101.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo(Object obj) {
		if (obj.hashCode() > hashCode())
			return 1;
		else if (obj.hashCode() < hashCode())
			return -1;
		else
			return 0;
	}

	public String toString() {
		return super.toString();
	}

}
