package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the debt_type_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="debt_type_ref"
 */

public abstract class BaseDebtTypeRef  implements Comparable, Serializable {

	public static String REF = "DebtTypeRef";
	public static String PROP_TYPE = "type";
	public static String PROP_TYPE_CODE = "typeCode";
	public static String PROP_TYPE_NAME = "typeName";
	public static String PROP_ID = "id";


	// constructors
	public BaseDebtTypeRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDebtTypeRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDebtTypeRef (
		java.lang.Integer id,
		java.lang.String typeCode,
		java.lang.String typeName,
		java.lang.String type) {

		this.setId(id);
		this.setTypeCode(typeCode);
		this.setTypeName(typeName);
		this.setType(type);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String typeCode;
	private java.lang.String typeName;
	private java.lang.String type;



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
	 * Return the value associated with the column: type_code
	 */
	public java.lang.String getTypeCode () {
		return typeCode;
	}

	/**
	 * Set the value related to the column: type_code
	 * @param typeCode the type_code value
	 */
	public void setTypeCode (java.lang.String typeCode) {
		this.typeCode = typeCode;
	}



	/**
	 * Return the value associated with the column: type_name
	 */
	public java.lang.String getTypeName () {
		return typeName;
	}

	/**
	 * Set the value related to the column: type_name
	 * @param typeName the type_name value
	 */
	public void setTypeName (java.lang.String typeName) {
		this.typeName = typeName;
	}



	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.DebtTypeRef)) return false;
		else {
			tw.gov.nta.sql.debt.DebtTypeRef debtTypeRef = (tw.gov.nta.sql.debt.DebtTypeRef) obj;
			if (null == this.getId() || null == debtTypeRef.getId()) return false;
			else return (this.getId().equals(debtTypeRef.getId()));
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