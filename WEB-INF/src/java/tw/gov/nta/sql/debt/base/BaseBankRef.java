package tw.gov.nta.sql.debt.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the bank_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bank_ref"
 */

public abstract class BaseBankRef  implements Comparable, Serializable {

	public static String REF = "BankRef";
	public static String PROP_TPSBANK_CODE = "tpsbankCode";
	public static String PROP_END_DATE = "endDate";
	public static String PROP_REMARK = "remark";
	public static String PROP_FREE_AMOUNT = "freeAmount";
	public static String PROP_BEGIN_DATE = "beginDate";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_BELONG_TO_BANK_ID = "belongToBankId";
	public static String PROP_COMBINATION_BANK_ID = "combinationBankId";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_BANK_CODE = "bankCode";
	public static String PROP_USRID = "usrid";
	public static String PROP_COMBINATION_DATE = "combinationDate";
	public static String PROP_BANK_NAME = "bankName";
	public static String PROP_BUSINESS_KIND = "businessKind";
	public static String PROP_ID = "id";
	public static String PROP_SHORT_BANK_NAME = "shortBankName";


	// constructors
	public BaseBankRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBankRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBankRef (
		java.lang.Integer id,
		java.lang.String bankCode,
		java.lang.String bankName,
		java.lang.String shortBankName,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate,
		java.util.Date beginDate,
		java.util.Date endDate) {

		this.setId(id);
		this.setBankCode(bankCode);
		this.setBankName(bankName);
		this.setShortBankName(shortBankName);
		this.setUsrid(usrid);
		this.setModDate(modDate);
		this.setCreateDate(createDate);
		this.setBeginDate(beginDate);
		this.setEndDate(endDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bankCode;
	private java.lang.String bankName;
	private java.lang.String shortBankName;
	private java.lang.Integer belongToBankId;
	private java.lang.Integer combinationBankId;
	private java.util.Date combinationDate;
	private java.lang.String tpsbankCode;
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;
	private java.util.Date beginDate;
	private java.util.Date endDate;
	private java.lang.String businessKind;
	private java.lang.String freeAmount;

	// collections
	private java.util.Set<tw.gov.nta.sql.debt.DebtMain> debtMains;
	private java.util.Set<tw.gov.nta.sql.debt.ContractBankMain> contractBankMains;



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
	 * Return the value associated with the column: BANK_CODE
	 */
	public java.lang.String getBankCode () {
		return bankCode;
	}

	/**
	 * Set the value related to the column: BANK_CODE
	 * @param bankCode the BANK_CODE value
	 */
	public void setBankCode (java.lang.String bankCode) {
		this.bankCode = bankCode;
	}



	/**
	 * Return the value associated with the column: BANK_NAME
	 */
	public java.lang.String getBankName () {
		return bankName;
	}

	/**
	 * Set the value related to the column: BANK_NAME
	 * @param bankName the BANK_NAME value
	 */
	public void setBankName (java.lang.String bankName) {
		this.bankName = bankName;
	}



	/**
	 * Return the value associated with the column: SHORT_BANK_NAME
	 */
	public java.lang.String getShortBankName () {
		return shortBankName;
	}

	/**
	 * Set the value related to the column: SHORT_BANK_NAME
	 * @param shortBankName the SHORT_BANK_NAME value
	 */
	public void setShortBankName (java.lang.String shortBankName) {
		this.shortBankName = shortBankName;
	}



	/**
	 * Return the value associated with the column: BELONG_TO_BANK_ID
	 */
	public java.lang.Integer getBelongToBankId () {
		return belongToBankId;
	}

	/**
	 * Set the value related to the column: BELONG_TO_BANK_ID
	 * @param belongToBankId the BELONG_TO_BANK_ID value
	 */
	public void setBelongToBankId (java.lang.Integer belongToBankId) {
		this.belongToBankId = belongToBankId;
	}



	/**
	 * Return the value associated with the column: COMBINATION_BANK_ID
	 */
	public java.lang.Integer getCombinationBankId () {
		return combinationBankId;
	}

	/**
	 * Set the value related to the column: COMBINATION_BANK_ID
	 * @param combinationBankId the COMBINATION_BANK_ID value
	 */
	public void setCombinationBankId (java.lang.Integer combinationBankId) {
		this.combinationBankId = combinationBankId;
	}



	/**
	 * Return the value associated with the column: COMBINATION_DATE
	 */
	public java.util.Date getCombinationDate () {
		return combinationDate;
	}

	/**
	 * Set the value related to the column: COMBINATION_DATE
	 * @param combinationDate the COMBINATION_DATE value
	 */
	public void setCombinationDate (java.util.Date combinationDate) {
		this.combinationDate = combinationDate;
	}



	/**
	 * Return the value associated with the column: TPSBANK_CODE
	 */
	public java.lang.String getTpsbankCode () {
		return tpsbankCode;
	}

	/**
	 * Set the value related to the column: TPSBANK_CODE
	 * @param tpsbankCode the TPSBANK_CODE value
	 */
	public void setTpsbankCode (java.lang.String tpsbankCode) {
		this.tpsbankCode = tpsbankCode;
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
	 * Return the value associated with the column: BEGIN_DATE
	 */
	public java.util.Date getBeginDate () {
		return beginDate;
	}

	/**
	 * Set the value related to the column: BEGIN_DATE
	 * @param beginDate the BEGIN_DATE value
	 */
	public void setBeginDate (java.util.Date beginDate) {
		this.beginDate = beginDate;
	}



	/**
	 * Return the value associated with the column: END_DATE
	 */
	public java.util.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: END_DATE
	 * @param endDate the END_DATE value
	 */
	public void setEndDate (java.util.Date endDate) {
		this.endDate = endDate;
	}



	/**
	 * Return the value associated with the column: business_kind
	 */
	public java.lang.String getBusinessKind () {
		return businessKind;
	}

	/**
	 * Set the value related to the column: business_kind
	 * @param businessKind the business_kind value
	 */
	public void setBusinessKind (java.lang.String businessKind) {
		this.businessKind = businessKind;
	}



	/**
	 * Return the value associated with the column: Free_amount
	 */
	public java.lang.String getFreeAmount () {
		return freeAmount;
	}

	/**
	 * Set the value related to the column: Free_amount
	 * @param freeAmount the Free_amount value
	 */
	public void setFreeAmount (java.lang.String freeAmount) {
		this.freeAmount = freeAmount;
	}



	/**
	 * Return the value associated with the column: debtMains
	 */
	public java.util.Set<tw.gov.nta.sql.debt.DebtMain> getDebtMains () {
		return debtMains;
	}

	/**
	 * Set the value related to the column: debtMains
	 * @param debtMains the debtMains value
	 */
	public void setDebtMains (java.util.Set<tw.gov.nta.sql.debt.DebtMain> debtMains) {
		this.debtMains = debtMains;
	}

	public void addTodebtMains (tw.gov.nta.sql.debt.DebtMain debtMain) {
		if (null == getDebtMains()) setDebtMains(new java.util.TreeSet<tw.gov.nta.sql.debt.DebtMain>());
		getDebtMains().add(debtMain);
	}



	/**
	 * Return the value associated with the column: contractBankMains
	 */
	public java.util.Set<tw.gov.nta.sql.debt.ContractBankMain> getContractBankMains () {
		return contractBankMains;
	}

	/**
	 * Set the value related to the column: contractBankMains
	 * @param contractBankMains the contractBankMains value
	 */
	public void setContractBankMains (java.util.Set<tw.gov.nta.sql.debt.ContractBankMain> contractBankMains) {
		this.contractBankMains = contractBankMains;
	}

	public void addTocontractBankMains (tw.gov.nta.sql.debt.ContractBankMain contractBankMain) {
		if (null == getContractBankMains()) setContractBankMains(new java.util.TreeSet<tw.gov.nta.sql.debt.ContractBankMain>());
		getContractBankMains().add(contractBankMain);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.debt.BankRef)) return false;
		else {
			tw.gov.nta.sql.debt.BankRef bankRef = (tw.gov.nta.sql.debt.BankRef) obj;
			if (null == this.getId() || null == bankRef.getId()) return false;
			else return (this.getId().equals(bankRef.getId()));
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