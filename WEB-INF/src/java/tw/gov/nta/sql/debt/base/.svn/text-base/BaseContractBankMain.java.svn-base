package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the contract_bank_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="contract_bank_main"
 */

public abstract class BaseContractBankMain  implements Comparable, Serializable {

	public static String REF = "ContractBankMain";
	public static String PROP_BANK = "bank";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_CONTRACT_AMOUNT = "contractAmount";
	public static String PROP_CONTRACT_DATE = "contractDate";
	public static String PROP_USERID = "userid";
	public static String PROP_SOURCE_ID = "sourceId";
	public static String PROP_CONTRACT_YEAR = "contractYear";
	public static String PROP_ID = "id";
	public static String PROP_BORROW_AMOUNT = "borrowAmount";


	// constructors
	public BaseContractBankMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseContractBankMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseContractBankMain (
		java.lang.Integer id,
		tw.gov.nta.sql.debt.BankRef bank,
		java.lang.String contractYear) {

		this.setId(id);
		this.setBank(bank);
		this.setContractYear(contractYear);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String contractYear;
	private java.math.BigDecimal contractAmount;
	private java.math.BigDecimal borrowAmount;
	private java.lang.String userid;
	private java.util.Date modDate;
	private java.util.Date contractDate;
	private java.lang.Integer sourceId;

	// many to one
	private tw.gov.nta.sql.debt.BankRef bank;



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
	 * Return the value associated with the column: CONTRACT_YEAR
	 */
	public java.lang.String getContractYear () {
		return contractYear;
	}

	/**
	 * Set the value related to the column: CONTRACT_YEAR
	 * @param contractYear the CONTRACT_YEAR value
	 */
	public void setContractYear (java.lang.String contractYear) {
		this.contractYear = contractYear;
	}



	/**
	 * Return the value associated with the column: CONTRACT_AMOUNT
	 */
	public java.math.BigDecimal getContractAmount () {
		return contractAmount;
	}

	/**
	 * Set the value related to the column: CONTRACT_AMOUNT
	 * @param contractAmount the CONTRACT_AMOUNT value
	 */
	public void setContractAmount (java.math.BigDecimal contractAmount) {
		this.contractAmount = contractAmount;
	}



	/**
	 * Return the value associated with the column: BORROW_AMOUNT
	 */
	public java.math.BigDecimal getBorrowAmount () {
		return borrowAmount;
	}

	/**
	 * Set the value related to the column: BORROW_AMOUNT
	 * @param borrowAmount the BORROW_AMOUNT value
	 */
	public void setBorrowAmount (java.math.BigDecimal borrowAmount) {
		this.borrowAmount = borrowAmount;
	}



	/**
	 * Return the value associated with the column: USERID
	 */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: USERID
	 * @param userid the USERID value
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
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
	 * Return the value associated with the column: contract_date
	 */
	public java.util.Date getContractDate () {
		return contractDate;
	}

	/**
	 * Set the value related to the column: contract_date
	 * @param contractDate the contract_date value
	 */
	public void setContractDate (java.util.Date contractDate) {
		this.contractDate = contractDate;
	}



	/**
	 * Return the value associated with the column: source_id
	 */
	public java.lang.Integer getSourceId () {
		return sourceId;
	}

	/**
	 * Set the value related to the column: source_id
	 * @param sourceId the source_id value
	 */
	public void setSourceId (java.lang.Integer sourceId) {
		this.sourceId = sourceId;
	}



	/**
	 * Return the value associated with the column: BANK_ID
	 */
	public tw.gov.nta.sql.debt.BankRef getBank () {
		return bank;
	}

	/**
	 * Set the value related to the column: BANK_ID
	 * @param bank the BANK_ID value
	 */
	public void setBank (tw.gov.nta.sql.debt.BankRef bank) {
		this.bank = bank;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.ContractBankMain)) return false;
		else {
			tw.gov.nta.sql.debt.ContractBankMain contractBankMain = (tw.gov.nta.sql.debt.ContractBankMain) obj;
			if (null == this.getId() || null == contractBankMain.getId()) return false;
			else return (this.getId().equals(contractBankMain.getId()));
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