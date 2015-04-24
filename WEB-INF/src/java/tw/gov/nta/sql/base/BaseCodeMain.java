package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Code_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Code_main"
 */

public abstract class BaseCodeMain  implements Comparable, Serializable {

	public static String REF = "CodeMain";
	public static String PROP_USRID = "usrid";
	public static String PROP_REMARK = "remark";
	public static String PROP_KIND_NAME = "kindName";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_KIND_NO = "kindNo";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_ID = "id";


	// constructors
	public BaseCodeMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCodeMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCodeMain (
		java.lang.Integer id,
		java.lang.String kindNo,
		java.lang.String kindName,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		this.setId(id);
		this.setKindNo(kindNo);
		this.setKindName(kindName);
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
	private java.lang.String kindNo;
	private java.lang.String kindName;
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;

	// collections
	private java.util.Set<tw.gov.nta.sql.CodeDet> codeDets;



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
	 * Return the value associated with the column: KIND_NO
	 */
	public java.lang.String getKindNo () {
		return kindNo;
	}

	/**
	 * Set the value related to the column: KIND_NO
	 * @param kindNo the KIND_NO value
	 */
	public void setKindNo (java.lang.String kindNo) {
		this.kindNo = kindNo;
	}



	/**
	 * Return the value associated with the column: KIND_NAME
	 */
	public java.lang.String getKindName () {
		return kindName;
	}

	/**
	 * Set the value related to the column: KIND_NAME
	 * @param kindName the KIND_NAME value
	 */
	public void setKindName (java.lang.String kindName) {
		this.kindName = kindName;
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
	 * Return the value associated with the column: codeDets
	 */
	public java.util.Set<tw.gov.nta.sql.CodeDet> getCodeDets () {
		return codeDets;
	}

	/**
	 * Set the value related to the column: codeDets
	 * @param codeDets the codeDets value
	 */
	public void setCodeDets (java.util.Set<tw.gov.nta.sql.CodeDet> codeDets) {
		this.codeDets = codeDets;
	}

	public void addTocodeDets (tw.gov.nta.sql.CodeDet codeDet) {
		if (null == getCodeDets()) setCodeDets(new java.util.TreeSet<tw.gov.nta.sql.CodeDet>());
		getCodeDets().add(codeDet);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.CodeMain)) return false;
		else {
			tw.gov.nta.sql.CodeMain codeMain = (tw.gov.nta.sql.CodeMain) obj;
			if (null == this.getId() || null == codeMain.getId()) return false;
			else return (this.getId().equals(codeMain.getId()));
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