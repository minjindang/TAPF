package tw.gov.nta.sql.base;
import java.lang.Comparable;
import java.math.BigDecimal;
import java.io.Serializable;
public abstract class BaseTaxactionDet101 implements Comparable, Serializable{
	
	public static String REF = "TaxactionDet101";
	public static String PROP_ID = "id";
	public static String PROP_TAX_MONTH = "taxMonth";
	public static String PROP_TAX_YEAR = "taxYear";	
	public static String PROP_NATION_TAX = "nationTax";	
	public static String PROP_FINANCIAL_CHECK = "financialCheck";	
	public static String PROP_FINANCIAL = "financial";	
	public static String PROP_INT_TAX = "intTax";	
	public static String PROP_FILL_AMOUNT = "fillAmount";
	public static String PROP_NATION_RATE = "nationRate";
	public static String PROP_LOCAL_RATE = "localRate";
	public static String PROP_INT_RATE = "intRate";


	// constructors
	public BaseTaxactionDet101 () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTaxactionDet101 (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTaxactionDet101 (
		java.lang.Integer id,
		java.lang.String taxYear,
		java.lang.String taxMonth,
		java.math.BigDecimal nationTax,
		String financialCheck,
		java.math.BigDecimal financial,
		java.math.BigDecimal intTax,	
		java.math.BigDecimal fillAmount,
		java.math.BigDecimal nationRate,
		java.math.BigDecimal localRate,
		java.math.BigDecimal intRate,
		java.math.BigDecimal totMon) {

		this.setId(id);
		this.setTaxYear(taxYear);
		this.setTaxMonth(taxMonth);
		this.setNationTax(nationTax);
		this.setFinancialCheck(financialCheck);
		this.setFinancial(financial);
		this.setIntTax(intTax);
		this.setFillAmount(fillAmount);
		this.setNationRate(nationRate);
		this.setLocalRate(localRate);
		this.setIntRate(intRate);
		this.setTotMon(totMon);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String taxYear;
	private java.lang.String taxMonth;
	private java.math.BigDecimal nationTax;
	private String financialCheck;
	private java.math.BigDecimal financial;
	private java.math.BigDecimal intTax;	
	private java.math.BigDecimal fillAmount;
	private java.math.BigDecimal nationRate;
	private java.math.BigDecimal localRate;
	private java.math.BigDecimal intRate;
	private java.math.BigDecimal totMon;


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
	
	

	public java.math.BigDecimal getFinancial() {
		return financial;
	}

	public void setFinancial(java.math.BigDecimal financial) {
		this.financial = financial;
	}

	public String getFinancialCheck() {
		return financialCheck;
	}

	public void setFinancialCheck(String financialCheck) {
		this.financialCheck = financialCheck;
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

	/**
	 * Return the value associated with the column: TAX_MONTH
	 */
	public BigDecimal getTotMon () {
		return totMon;
	}

	/**
	 * Set the value related to the column: TAX_MONTH
	 * @param taxMonth the TAX_MONTH value
	 */
	public void setTotMon (BigDecimal totMon) {
		this.totMon = totMon;
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
