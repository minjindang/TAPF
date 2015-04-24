package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Taxaction_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Taxaction_det"
 */

public abstract class BaseTaxactionDet  implements Comparable, Serializable {

	public static String REF = "TaxactionDet";
	public static String PROP_TAX_MONTH = "taxMonth";
	public static String PROP_TAX_YEAR = "taxYear";
	public static String PROP_REMARK = "remark";
	public static String PROP_NATION_TAX = "nationTax";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_INT_TAX = "intTax";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_MON_KIND = "monKind";
	public static String PROP_MON_NO = "monNo";
	public static String PROP_BANKNO = "bankno";
	public static String PROP_USRID = "usrid";
	public static String PROP_PNAME = "pname";
	public static String PROP_TAX_KIND = "taxKind";
	public static String PROP_LOCAL_TAX = "localTax";
	public static String PROP_ID = "id";
	public static String PROP_FILL_AMOUNT = "fillAmount";
	public static String PROP_NATION_RATE = "nationRate";
	public static String PROP_LOCAL_RATE = "localRate";
	public static String PROP_INT_RATE = "intRate";


	// constructors
	public BaseTaxactionDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTaxactionDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTaxactionDet (
		java.lang.Integer id,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate,
		java.lang.String taxKind,
		java.lang.String taxYear,
		java.lang.String taxMonth) {

		this.setId(id);
		this.setUsrid(usrid);
		this.setModDate(modDate);
		this.setCreateDate(createDate);
		this.setTaxKind(taxKind);
		this.setTaxYear(taxYear);
		this.setTaxMonth(taxMonth);
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
	private java.math.BigDecimal nationTax;
	private java.math.BigDecimal localTax;
	private java.math.BigDecimal intTax;
	private java.lang.String taxKind;
	private java.lang.String monNo;
	private java.lang.String bankno;
	private java.lang.String monKind;
	private java.lang.String pname;
	private java.lang.String taxYear;
	private java.lang.String taxMonth;
	private java.math.BigDecimal fillAmount;
	private java.math.BigDecimal nationRate;
	private java.math.BigDecimal localRate;
	private java.math.BigDecimal intRate;



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
	 * Return the value associated with the column: NATION_TAX
	 */
	public java.math.BigDecimal getNationTax () {
		return nationTax;
	}

	/**
	 * Set the value related to the column: NATION_TAX
	 * @param nationTax the NATION_TAX value
	 */
	public void setNationTax (java.math.BigDecimal nationTax) {
		this.nationTax = nationTax;
	}



	/**
	 * Return the value associated with the column: LOCAL_TAX
	 */
	public java.math.BigDecimal getLocalTax () {
		return localTax;
	}

	/**
	 * Set the value related to the column: LOCAL_TAX
	 * @param localTax the LOCAL_TAX value
	 */
	public void setLocalTax (java.math.BigDecimal localTax) {
		this.localTax = localTax;
	}


	public java.math.BigDecimal getFillAmount() {
		return fillAmount;
	}

	public void setFillAmount(java.math.BigDecimal fillAmount) {
		this.fillAmount = fillAmount;
	}

	public java.math.BigDecimal getIntRate() {
		return intRate;
	}

	public void setIntRate(java.math.BigDecimal intRate) {
		this.intRate = intRate;
	}

	public java.math.BigDecimal getLocalRate() {
		return localRate;
	}

	public void setLocalRate(java.math.BigDecimal localRate) {
		this.localRate = localRate;
	}

	public java.math.BigDecimal getNationRate() {
		return nationRate;
	}

	public void setNationRate(java.math.BigDecimal nationRate) {
		this.nationRate = nationRate;
	}

	/**
	 * Return the value associated with the column: INT_TAX
	 */
	public java.math.BigDecimal getIntTax () {
		return intTax;
	}

	/**
	 * Set the value related to the column: INT_TAX
	 * @param intTax the INT_TAX value
	 */
	public void setIntTax (java.math.BigDecimal intTax) {
		this.intTax = intTax;
	}



	/**
	 * Return the value associated with the column: TAX_KIND
	 */
	public java.lang.String getTaxKind () {
		return taxKind;
	}

	/**
	 * Set the value related to the column: TAX_KIND
	 * @param taxKind the TAX_KIND value
	 */
	public void setTaxKind (java.lang.String taxKind) {
		this.taxKind = taxKind;
	}



	/**
	 * Return the value associated with the column: MON_NO
	 */
	public java.lang.String getMonNo () {
		return monNo;
	}

	/**
	 * Set the value related to the column: MON_NO
	 * @param monNo the MON_NO value
	 */
	public void setMonNo (java.lang.String monNo) {
		this.monNo = monNo;
	}



	/**
	 * Return the value associated with the column: BANKNO
	 */
	public java.lang.String getBankno () {
		return bankno;
	}

	/**
	 * Set the value related to the column: BANKNO
	 * @param bankno the BANKNO value
	 */
	public void setBankno (java.lang.String bankno) {
		this.bankno = bankno;
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
	 * Return the value associated with the column: PNAME
	 */
	public java.lang.String getPname () {
		return pname;
	}

	/**
	 * Set the value related to the column: PNAME
	 * @param pname the PNAME value
	 */
	public void setPname (java.lang.String pname) {
		this.pname = pname;
	}



	/**
	 * Return the value associated with the column: TAX_YEAR
	 */
	public java.lang.String getTaxYear () {
		return taxYear;
	}

	/**
	 * Set the value related to the column: TAX_YEAR
	 * @param taxYear the TAX_YEAR value
	 */
	public void setTaxYear (java.lang.String taxYear) {
		this.taxYear = taxYear;
	}



	/**
	 * Return the value associated with the column: TAX_MONTH
	 */
	public java.lang.String getTaxMonth () {
		return taxMonth;
	}

	/**
	 * Set the value related to the column: TAX_MONTH
	 * @param taxMonth the TAX_MONTH value
	 */
	public void setTaxMonth (java.lang.String taxMonth) {
		this.taxMonth = taxMonth;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.TaxactionDet)) return false;
		else {
			tw.gov.nta.sql.TaxactionDet taxactionDet = (tw.gov.nta.sql.TaxactionDet) obj;
			if (null == this.getId() || null == taxactionDet.getId()) return false;
			else return (this.getId().equals(taxactionDet.getId()));
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