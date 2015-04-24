package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Exstock_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Exstock_ref"
 */

public abstract class BaseExstockRef  implements Comparable, Serializable {

	public static String REF = "ExstockRef";
	public static String PROP_USRID = "usrid";
	public static String PROP_REMARK = "remark";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_STOCK_NAME = "stockName";
	public static String PROP_STOCK_ID = "stockId";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_ID = "id";


	// constructors
	public BaseExstockRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseExstockRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseExstockRef (
		java.lang.Integer id,
		java.lang.String stockId,
		java.lang.String stockName,
		java.lang.String usrid,
		java.util.Date modDate,
		java.util.Date createDate) {

		this.setId(id);
		this.setStockId(stockId);
		this.setStockName(stockName);
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
	private java.lang.String stockId;
	private java.lang.String stockName;
	private java.lang.String usrid;
	private java.util.Date modDate;
	private java.lang.String remark;
	private java.util.Date createDate;



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
	 * Return the value associated with the column: STOCK_ID
	 */
	public java.lang.String getStockId () {
		return stockId;
	}

	/**
	 * Set the value related to the column: STOCK_ID
	 * @param stockId the STOCK_ID value
	 */
	public void setStockId (java.lang.String stockId) {
		this.stockId = stockId;
	}



	/**
	 * Return the value associated with the column: STOCK_NAME
	 */
	public java.lang.String getStockName () {
		return stockName;
	}

	/**
	 * Set the value related to the column: STOCK_NAME
	 * @param stockName the STOCK_NAME value
	 */
	public void setStockName (java.lang.String stockName) {
		this.stockName = stockName;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.ExstockRef)) return false;
		else {
			tw.gov.nta.sql.ExstockRef exstockRef = (tw.gov.nta.sql.ExstockRef) obj;
			if (null == this.getId() || null == exstockRef.getId()) return false;
			else return (this.getId().equals(exstockRef.getId()));
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