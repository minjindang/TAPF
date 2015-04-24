package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Budget_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Budget_ref"
 */

public abstract class BaseBudgetRef  implements Comparable, Serializable {

	public static String REF = "BudgetRef";
	public static String PROP_USRID = "usrid";
	public static String PROP_REMARK = "remark";
	public static String PROP_BUDGET_NAME = "budgetName";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_BUDGET_TYPE = "budgetType";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_ID = "id";


	// constructors
	public BaseBudgetRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBudgetRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBudgetRef (
		java.lang.Integer id,
		java.lang.String budgetType,
		java.lang.String budgetName,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		this.setId(id);
		this.setBudgetType(budgetType);
		this.setBudgetName(budgetName);
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
	private java.lang.String budgetType;
	private java.lang.String budgetName;
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;

	// collections
	private java.util.Set<tw.gov.nta.sql.DebitRef> debitRefs;



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
	 * Return the value associated with the column: BUDGET_TYPE
	 */
	public java.lang.String getBudgetType () {
		return budgetType;
	}

	/**
	 * Set the value related to the column: BUDGET_TYPE
	 * @param budgetType the BUDGET_TYPE value
	 */
	public void setBudgetType (java.lang.String budgetType) {
		this.budgetType = budgetType;
	}



	/**
	 * Return the value associated with the column: BUDGET_NAME
	 */
	public java.lang.String getBudgetName () {
		return budgetName;
	}

	/**
	 * Set the value related to the column: BUDGET_NAME
	 * @param budgetName the BUDGET_NAME value
	 */
	public void setBudgetName (java.lang.String budgetName) {
		this.budgetName = budgetName;
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
	 * Return the value associated with the column: debitRefs
	 */
	public java.util.Set<tw.gov.nta.sql.DebitRef> getDebitRefs () {
		return debitRefs;
	}

	/**
	 * Set the value related to the column: debitRefs
	 * @param debitRefs the debitRefs value
	 */
	public void setDebitRefs (java.util.Set<tw.gov.nta.sql.DebitRef> debitRefs) {
		this.debitRefs = debitRefs;
	}

	public void addTodebitRefs (tw.gov.nta.sql.DebitRef debitRef) {
		if (null == getDebitRefs()) setDebitRefs(new java.util.TreeSet<tw.gov.nta.sql.DebitRef>());
		getDebitRefs().add(debitRef);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.BudgetRef)) return false;
		else {
			tw.gov.nta.sql.BudgetRef budgetRef = (tw.gov.nta.sql.BudgetRef) obj;
			if (null == this.getId() || null == budgetRef.getId()) return false;
			else return (this.getId().equals(budgetRef.getId()));
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