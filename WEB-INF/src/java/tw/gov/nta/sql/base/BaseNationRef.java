package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Nation_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Nation_ref"
 */

public abstract class BaseNationRef  implements Comparable, Serializable {

	public static String REF = "NationRef";
	public static String PROP_USRID = "usrid";
	public static String PROP_NATION_NO = "nationNo";
	public static String PROP_REMARK = "remark";
	public static String PROP_NATION_CNAME = "nationCname";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_NATION_ENAME = "nationEname";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_ID = "id";
	public static String PROP_CONTINENT_NO = "continentNo";


	// constructors
	public BaseNationRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNationRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseNationRef (
		java.lang.Integer id,
		java.lang.String nationNo,
		java.lang.String continentNo,
		java.lang.String nationCname,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		this.setId(id);
		this.setNationNo(nationNo);
		this.setContinentNo(continentNo);
		this.setNationCname(nationCname);
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
	private java.lang.String nationNo;
	private java.lang.String continentNo;
	private java.lang.String nationCname;
	private java.lang.String nationEname;
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;

	// collections
	private java.util.Set<tw.gov.nta.sql.NationDebitMain> nationDebitMains;



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
	 * Return the value associated with the column: NATION_NO
	 */
	public java.lang.String getNationNo () {
		return nationNo;
	}

	/**
	 * Set the value related to the column: NATION_NO
	 * @param nationNo the NATION_NO value
	 */
	public void setNationNo (java.lang.String nationNo) {
		this.nationNo = nationNo;
	}



	/**
	 * Return the value associated with the column: CONTINENT_NO
	 */
	public java.lang.String getContinentNo () {
		return continentNo;
	}

	/**
	 * Set the value related to the column: CONTINENT_NO
	 * @param continentNo the CONTINENT_NO value
	 */
	public void setContinentNo (java.lang.String continentNo) {
		this.continentNo = continentNo;
	}



	/**
	 * Return the value associated with the column: NATION_CNAME
	 */
	public java.lang.String getNationCname () {
		return nationCname;
	}

	/**
	 * Set the value related to the column: NATION_CNAME
	 * @param nationCname the NATION_CNAME value
	 */
	public void setNationCname (java.lang.String nationCname) {
		this.nationCname = nationCname;
	}



	/**
	 * Return the value associated with the column: NATION_ENAME
	 */
	public java.lang.String getNationEname () {
		return nationEname;
	}

	/**
	 * Set the value related to the column: NATION_ENAME
	 * @param nationEname the NATION_ENAME value
	 */
	public void setNationEname (java.lang.String nationEname) {
		this.nationEname = nationEname;
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
	 * Return the value associated with the column: nationDebitMains
	 */
	public java.util.Set<tw.gov.nta.sql.NationDebitMain> getNationDebitMains () {
		return nationDebitMains;
	}

	/**
	 * Set the value related to the column: nationDebitMains
	 * @param nationDebitMains the nationDebitMains value
	 */
	public void setNationDebitMains (java.util.Set<tw.gov.nta.sql.NationDebitMain> nationDebitMains) {
		this.nationDebitMains = nationDebitMains;
	}

	public void addTonationDebitMains (tw.gov.nta.sql.NationDebitMain nationDebitMain) {
		if (null == getNationDebitMains()) setNationDebitMains(new java.util.TreeSet<tw.gov.nta.sql.NationDebitMain>());
		getNationDebitMains().add(nationDebitMain);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.NationRef)) return false;
		else {
			tw.gov.nta.sql.NationRef nationRef = (tw.gov.nta.sql.NationRef) obj;
			if (null == this.getId() || null == nationRef.getId()) return false;
			else return (this.getId().equals(nationRef.getId()));
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