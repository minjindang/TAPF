package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the GARA_NOTE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GARA_NOTE"
 */

public abstract class BaseGaraNote  implements Comparable, Serializable {

	public static String REF = "GaraNote";
	public static String PROP_USRID = "usrid";
	public static String PROP_MEMO = "memo";
	public static String PROP_PATH = "path";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_ID = "id";


	// constructors
	public BaseGaraNote () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGaraNote (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseGaraNote (
		java.lang.Integer id,
		java.lang.String path) {

		this.setId(id);
		this.setPath(path);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String memo;
	private java.util.Date modDate;
	private java.lang.String path;
	private java.lang.String usrid;



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
	 * Return the value associated with the column: memo
	 */
	public java.lang.String getMemo () {
		return memo;
	}

	/**
	 * Set the value related to the column: memo
	 * @param memo the memo value
	 */
	public void setMemo (java.lang.String memo) {
		this.memo = memo;
	}



	/**
	 * Return the value associated with the column: mod_date
	 */
	public java.util.Date getModDate () {
		return modDate;
	}

	/**
	 * Set the value related to the column: mod_date
	 * @param modDate the mod_date value
	 */
	public void setModDate (java.util.Date modDate) {
		this.modDate = modDate;
	}



	/**
	 * Return the value associated with the column: path
	 */
	public java.lang.String getPath () {
		return path;
	}

	/**
	 * Set the value related to the column: path
	 * @param path the path value
	 */
	public void setPath (java.lang.String path) {
		this.path = path;
	}



	/**
	 * Return the value associated with the column: usrid
	 */
	public java.lang.String getUsrid () {
		return usrid;
	}

	/**
	 * Set the value related to the column: usrid
	 * @param usrid the usrid value
	 */
	public void setUsrid (java.lang.String usrid) {
		this.usrid = usrid;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.GaraNote)) return false;
		else {
			tw.gov.nta.sql.debt.GaraNote garaNote = (tw.gov.nta.sql.debt.GaraNote) obj;
			if (null == this.getId() || null == garaNote.getId()) return false;
			else return (this.getId().equals(garaNote.getId()));
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