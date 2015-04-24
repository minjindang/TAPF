package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Code_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Code_det"
 */

public abstract class BaseCodeDet  implements Comparable, Serializable {

	public static String REF = "CodeDet";
	public static String PROP_USRID = "usrid";
	public static String PROP_REMARK = "remark";
	public static String PROP_KIND = "kind";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_CODE_NAME = "codeName";
	public static String PROP_CODE_NO = "codeNo";
	public static String PROP_ID = "id";
	public static String PROP_CODE_TYPE = "codeType";


	// constructors
	public BaseCodeDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCodeDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCodeDet (
		java.lang.Integer id,
		tw.gov.nta.sql.CodeMain kind,
		java.lang.String codeNo,
		java.lang.String codeName,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		this.setId(id);
		this.setKind(kind);
		this.setCodeNo(codeNo);
		this.setCodeName(codeName);
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
	private java.lang.String codeNo;
	private java.lang.String codeName;
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;
	private java.lang.String codeType;

	// many to one
	private tw.gov.nta.sql.CodeMain kind;



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
	 * Return the value associated with the column: CODE_NO
	 */
	public java.lang.String getCodeNo () {
		return codeNo;
	}

	/**
	 * Set the value related to the column: CODE_NO
	 * @param codeNo the CODE_NO value
	 */
	public void setCodeNo (java.lang.String codeNo) {
		this.codeNo = codeNo;
	}



	/**
	 * Return the value associated with the column: CODE_NAME
	 */
	public java.lang.String getCodeName () {
		return codeName;
	}

	/**
	 * Set the value related to the column: CODE_NAME
	 * @param codeName the CODE_NAME value
	 */
	public void setCodeName (java.lang.String codeName) {
		this.codeName = codeName;
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
	 * Return the value associated with the column: CODE_TYPE
	 */
	public java.lang.String getCodeType () {
		return codeType;
	}

	/**
	 * Set the value related to the column: CODE_TYPE
	 * @param codeType the CODE_TYPE value
	 */
	public void setCodeType (java.lang.String codeType) {
		this.codeType = codeType;
	}



	/**
	 * Return the value associated with the column: KIND_ID
	 */
	public tw.gov.nta.sql.CodeMain getKind () {
		return kind;
	}

	/**
	 * Set the value related to the column: KIND_ID
	 * @param kind the KIND_ID value
	 */
	public void setKind (tw.gov.nta.sql.CodeMain kind) {
		this.kind = kind;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.CodeDet)) return false;
		else {
			tw.gov.nta.sql.CodeDet codeDet = (tw.gov.nta.sql.CodeDet) obj;
			if (null == this.getId() || null == codeDet.getId()) return false;
			else return (this.getId().equals(codeDet.getId()));
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