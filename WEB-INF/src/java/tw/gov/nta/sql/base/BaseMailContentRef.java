package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Mail_content_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Mail_content_ref"
 */

public abstract class BaseMailContentRef  implements Comparable, Serializable {

	public static String REF = "MailContentRef";
	public static String PROP_USRID = "usrid";
	public static String PROP_REMARK = "remark";
	public static String PROP_TITLEA = "titlea";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_CONTENTB = "contentb";
	public static String PROP_CONTENTA = "contenta";
	public static String PROP_TITLEB = "titleb";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_ID = "id";
	public static String PROP_MON_KIND = "monKind";


	// constructors
	public BaseMailContentRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMailContentRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMailContentRef (
		java.lang.Integer id,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate,
		java.lang.String monKind,
		java.lang.String titlea,
		java.lang.String titleb,
		java.lang.String contenta,
		java.lang.String contentb) {

		this.setId(id);
		this.setUsrid(usrid);
		this.setModDate(modDate);
		this.setCreateDate(createDate);
		this.setMonKind(monKind);
		this.setTitlea(titlea);
		this.setTitleb(titleb);
		this.setContenta(contenta);
		this.setContentb(contentb);
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
	private java.lang.String monKind;
	private java.lang.String titlea;
	private java.lang.String titleb;
	private java.lang.String contenta;
	private java.lang.String contentb;



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
	 * Return the value associated with the column: MON_KIND
	 */
	public java.lang.String getMonKind () {
		return monKind;
	}

	/**
	 * Set the value related to the column: MON_KIND
	 * @param monKind the MON_KIND value
	 */
	public void setMonKind (java.lang.String monKind) {
		this.monKind = monKind;
	}



	/**
	 * Return the value associated with the column: TITLEA
	 */
	public java.lang.String getTitlea () {
		return titlea;
	}

	/**
	 * Set the value related to the column: TITLEA
	 * @param titlea the TITLEA value
	 */
	public void setTitlea (java.lang.String titlea) {
		this.titlea = titlea;
	}



	/**
	 * Return the value associated with the column: TITLEB
	 */
	public java.lang.String getTitleb () {
		return titleb;
	}

	/**
	 * Set the value related to the column: TITLEB
	 * @param titleb the TITLEB value
	 */
	public void setTitleb (java.lang.String titleb) {
		this.titleb = titleb;
	}



	/**
	 * Return the value associated with the column: CONTENTA
	 */
	public java.lang.String getContenta () {
		return contenta;
	}

	/**
	 * Set the value related to the column: CONTENTA
	 * @param contenta the CONTENTA value
	 */
	public void setContenta (java.lang.String contenta) {
		this.contenta = contenta;
	}



	/**
	 * Return the value associated with the column: CONTENTB
	 */
	public java.lang.String getContentb () {
		return contentb;
	}

	/**
	 * Set the value related to the column: CONTENTB
	 * @param contentb the CONTENTB value
	 */
	public void setContentb (java.lang.String contentb) {
		this.contentb = contentb;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.MailContentRef)) return false;
		else {
			tw.gov.nta.sql.MailContentRef mailContentRef = (tw.gov.nta.sql.MailContentRef) obj;
			if (null == this.getId() || null == mailContentRef.getId()) return false;
			else return (this.getId().equals(mailContentRef.getId()));
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