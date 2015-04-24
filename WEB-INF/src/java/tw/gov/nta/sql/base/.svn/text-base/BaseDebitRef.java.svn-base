package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Debit_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Debit_ref"
 */

public abstract class BaseDebitRef  implements Comparable, Serializable {

	public static String REF = "DebitRef";
	public static String PROP_USRID = "usrid";
	public static String PROP_REMARK = "remark";
	public static String PROP_DEBIT_TYPE = "debitType";
	public static String PROP_DEBIT_NAME = "debitName";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_ID = "id";
	public static String PROP_BUDGET_CODE = "budgetCode";


	// constructors
	public BaseDebitRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDebitRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDebitRef (
		java.lang.Integer id,
		tw.gov.nta.sql.BudgetRef budgetCode,
		java.lang.String debitType,
		java.lang.String debitName,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		this.setId(id);
		this.setBudgetCode(budgetCode);
		this.setDebitType(debitType);
		this.setDebitName(debitName);
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
	private java.lang.String debitType;
	private java.lang.String debitName;
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;

	// many to one
	private tw.gov.nta.sql.BudgetRef budgetCode;



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
	 * Return the value associated with the column: DEBIT_TYPE
	 */
	public java.lang.String getDebitType () {
		return debitType;
	}

	/**
	 * Set the value related to the column: DEBIT_TYPE
	 * @param debitType the DEBIT_TYPE value
	 */
	public void setDebitType (java.lang.String debitType) {
		this.debitType = debitType;
	}



	/**
	 * Return the value associated with the column: DEBIT_NAME
	 */
	public java.lang.String getDebitName () {
		return debitName;
	}

	/**
	 * Set the value related to the column: DEBIT_NAME
	 * @param debitName the DEBIT_NAME value
	 */
	public void setDebitName (java.lang.String debitName) {
		this.debitName = debitName;
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
	 * Return the value associated with the column: BUDGET_CODE
	 */
	public tw.gov.nta.sql.BudgetRef getBudgetCode () {
		return budgetCode;
	}

	/**
	 * Set the value related to the column: BUDGET_CODE
	 * @param budgetCode the BUDGET_CODE value
	 */
	public void setBudgetCode (tw.gov.nta.sql.BudgetRef budgetCode) {
		this.budgetCode = budgetCode;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.DebitRef)) return false;
		else {
			tw.gov.nta.sql.DebitRef debitRef = (tw.gov.nta.sql.DebitRef) obj;
			if (null == this.getId() || null == debitRef.getId()) return false;
			else return (this.getId().equals(debitRef.getId()));
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