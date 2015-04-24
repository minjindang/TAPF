package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the extend_due_date_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="extend_due_date_main"
 */

public abstract class BaseExtendDueDateMain  implements Comparable, Serializable {

	public static String REF = "ExtendDueDateMain";
	public static String PROP_INS_TIME = "insTime";
	public static String PROP_ADD_INTEREST_AMOUNT = "addInterestAmount";
	public static String PROP_DEBT = "debt";
	public static String PROP_INS_USR = "insUsr";
	public static String PROP_OLD_DUE_DATE = "oldDueDate";
	public static String PROP_NEW_DUE_DATE = "newDueDate";
	public static String PROP_ID = "id";


	// constructors
	public BaseExtendDueDateMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseExtendDueDateMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseExtendDueDateMain (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.DebtMain debt,
		java.util.Date oldDueDate,
		java.util.Date newDueDate,
		java.math.BigDecimal addInterestAmount,
		java.lang.String insUsr,
		java.util.Date insTime) {

		this.setId(id);
		this.setDebt(debt);
		this.setOldDueDate(oldDueDate);
		this.setNewDueDate(newDueDate);
		this.setAddInterestAmount(addInterestAmount);
		this.setInsUsr(insUsr);
		this.setInsTime(insTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date oldDueDate;
	private java.util.Date newDueDate;
	private java.math.BigDecimal addInterestAmount;
	private java.lang.String insUsr;
	private java.util.Date insTime;

	// many to one
	private tw.gov.nta.sql.debt.DebtMain debt;



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
	 * Return the value associated with the column: old_due_date
	 */
	public java.util.Date getOldDueDate () {
		return oldDueDate;
	}

	/**
	 * Set the value related to the column: old_due_date
	 * @param oldDueDate the old_due_date value
	 */
	public void setOldDueDate (java.util.Date oldDueDate) {
		this.oldDueDate = oldDueDate;
	}



	/**
	 * Return the value associated with the column: new_due_date
	 */
	public java.util.Date getNewDueDate () {
		return newDueDate;
	}

	/**
	 * Set the value related to the column: new_due_date
	 * @param newDueDate the new_due_date value
	 */
	public void setNewDueDate (java.util.Date newDueDate) {
		this.newDueDate = newDueDate;
	}



	/**
	 * Return the value associated with the column: add_interest_amount
	 */
	public java.math.BigDecimal getAddInterestAmount () {
		return addInterestAmount;
	}

	/**
	 * Set the value related to the column: add_interest_amount
	 * @param addInterestAmount the add_interest_amount value
	 */
	public void setAddInterestAmount (java.math.BigDecimal addInterestAmount) {
		this.addInterestAmount = addInterestAmount;
	}



	/**
	 * Return the value associated with the column: ins_usr
	 */
	public java.lang.String getInsUsr () {
		return insUsr;
	}

	/**
	 * Set the value related to the column: ins_usr
	 * @param insUsr the ins_usr value
	 */
	public void setInsUsr (java.lang.String insUsr) {
		this.insUsr = insUsr;
	}



	/**
	 * Return the value associated with the column: ins_time
	 */
	public java.util.Date getInsTime () {
		return insTime;
	}

	/**
	 * Set the value related to the column: ins_time
	 * @param insTime the ins_time value
	 */
	public void setInsTime (java.util.Date insTime) {
		this.insTime = insTime;
	}



	/**
	 * Return the value associated with the column: DEBT_ID
	 */
	public tw.gov.nta.sql.debt.DebtMain getDebt () {
		return debt;
	}

	/**
	 * Set the value related to the column: DEBT_ID
	 * @param debt the DEBT_ID value
	 */
	public void setDebt (tw.gov.nta.sql.debt.DebtMain debt) {
		this.debt = debt;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.ExtendDueDateMain)) return false;
		else {
			tw.gov.nta.sql.debt.ExtendDueDateMain extendDueDateMain = (tw.gov.nta.sql.debt.ExtendDueDateMain) obj;
			if (null == this.getId() || null == extendDueDateMain.getId()) return false;
			else return (this.getId().equals(extendDueDateMain.getId()));
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