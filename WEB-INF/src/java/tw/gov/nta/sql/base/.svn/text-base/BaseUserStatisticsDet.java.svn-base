package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the User_statistics_det table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="User_statistics_det"
 */

public abstract class BaseUserStatisticsDet  implements Comparable, Serializable {

	public static String REF = "UserStatisticsDet";
	public static String PROP_BANISH = "banish";
	public static String PROP_DATA_TYPE = "dataType";
	public static String PROP_PLUSDEBT_AMOUNT = "plusdebtAmount";
	public static String PROP_REAL_AMOUNT = "realAmount";
	public static String PROP_KEEP_AMOUNT = "keepAmount";
	public static String PROP_SUB_AMOUNT = "subAmount";
	public static String PROP_AUDIT_AMOUNT = "auditAmount";
	public static String PROP_USER_STATISTICS_MAIN = "userStatisticsMain";
	public static String PROP_SUBDEBT_AMOUNT = "subdebtAmount";
	public static String PROP_OLD_KEEP_AMOUNT = "oldKeepAmount";
	public static String PROP_ID = "id";
	public static String PROP_ACCOUNT_YEAR = "accountYear";


	// constructors
	public BaseUserStatisticsDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserStatisticsDet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUserStatisticsDet (
		java.lang.Integer id,
		tw.gov.nta.sql.UserStatisticsMain userStatisticsMain,
		java.lang.String accountYear,
		java.lang.String dataType) {

		this.setId(id);
		this.setUserStatisticsMain(userStatisticsMain);
		this.setAccountYear(accountYear);
		this.setDataType(dataType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String accountYear;
	private java.math.BigDecimal subAmount;
	private java.math.BigDecimal realAmount;
	private java.math.BigDecimal keepAmount;
	private java.math.BigDecimal oldKeepAmount;
	private java.math.BigDecimal auditAmount;
	private java.math.BigDecimal plusdebtAmount;
	private java.math.BigDecimal subdebtAmount;
	private java.lang.String dataType;
	private java.lang.String banish;

	// many to one
	private tw.gov.nta.sql.UserStatisticsMain userStatisticsMain;



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
	 * Return the value associated with the column: account_year
	 */
	public java.lang.String getAccountYear () {
		return accountYear;
	}

	/**
	 * Set the value related to the column: account_year
	 * @param accountYear the account_year value
	 */
	public void setAccountYear (java.lang.String accountYear) {
		this.accountYear = accountYear;
	}



	/**
	 * Return the value associated with the column: sub_amount
	 */
	public java.math.BigDecimal getSubAmount () {
		return subAmount;
	}

	/**
	 * Set the value related to the column: sub_amount
	 * @param subAmount the sub_amount value
	 */
	public void setSubAmount (java.math.BigDecimal subAmount) {
		this.subAmount = subAmount;
	}



	/**
	 * Return the value associated with the column: real_amount
	 */
	public java.math.BigDecimal getRealAmount () {
		return realAmount;
	}

	/**
	 * Set the value related to the column: real_amount
	 * @param realAmount the real_amount value
	 */
	public void setRealAmount (java.math.BigDecimal realAmount) {
		this.realAmount = realAmount;
	}



	/**
	 * Return the value associated with the column: keep_amount
	 */
	public java.math.BigDecimal getKeepAmount () {
		return keepAmount;
	}

	/**
	 * Set the value related to the column: keep_amount
	 * @param keepAmount the keep_amount value
	 */
	public void setKeepAmount (java.math.BigDecimal keepAmount) {
		this.keepAmount = keepAmount;
	}



	/**
	 * Return the value associated with the column: old_keep_amount
	 */
	public java.math.BigDecimal getOldKeepAmount () {
		return oldKeepAmount;
	}

	/**
	 * Set the value related to the column: old_keep_amount
	 * @param oldKeepAmount the old_keep_amount value
	 */
	public void setOldKeepAmount (java.math.BigDecimal oldKeepAmount) {
		this.oldKeepAmount = oldKeepAmount;
	}



	/**
	 * Return the value associated with the column: audit_amount
	 */
	public java.math.BigDecimal getAuditAmount () {
		return auditAmount;
	}

	/**
	 * Set the value related to the column: audit_amount
	 * @param auditAmount the audit_amount value
	 */
	public void setAuditAmount (java.math.BigDecimal auditAmount) {
		this.auditAmount = auditAmount;
	}



	/**
	 * Return the value associated with the column: plusdebt_amount
	 */
	public java.math.BigDecimal getPlusdebtAmount () {
		return plusdebtAmount;
	}

	/**
	 * Set the value related to the column: plusdebt_amount
	 * @param plusdebtAmount the plusdebt_amount value
	 */
	public void setPlusdebtAmount (java.math.BigDecimal plusdebtAmount) {
		this.plusdebtAmount = plusdebtAmount;
	}



	/**
	 * Return the value associated with the column: subdebt_amount
	 */
	public java.math.BigDecimal getSubdebtAmount () {
		return subdebtAmount;
	}

	/**
	 * Set the value related to the column: subdebt_amount
	 * @param subdebtAmount the subdebt_amount value
	 */
	public void setSubdebtAmount (java.math.BigDecimal subdebtAmount) {
		this.subdebtAmount = subdebtAmount;
	}



	/**
	 * Return the value associated with the column: data_type
	 */
	public java.lang.String getDataType () {
		return dataType;
	}

	/**
	 * Set the value related to the column: data_type
	 * @param dataType the data_type value
	 */
	public void setDataType (java.lang.String dataType) {
		this.dataType = dataType;
	}



	/**
	 * Return the value associated with the column: banish
	 */
	public java.lang.String getBanish () {
		return banish;
	}

	/**
	 * Set the value related to the column: banish
	 * @param banish the banish value
	 */
	public void setBanish (java.lang.String banish) {
		this.banish = banish;
	}



	/**
	 * Return the value associated with the column: statistics_id
	 */
	public tw.gov.nta.sql.UserStatisticsMain getUserStatisticsMain () {
		return userStatisticsMain;
	}

	/**
	 * Set the value related to the column: statistics_id
	 * @param userStatisticsMain the statistics_id value
	 */
	public void setUserStatisticsMain (tw.gov.nta.sql.UserStatisticsMain userStatisticsMain) {
		this.userStatisticsMain = userStatisticsMain;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.UserStatisticsDet)) return false;
		else {
			tw.gov.nta.sql.UserStatisticsDet userStatisticsDet = (tw.gov.nta.sql.UserStatisticsDet) obj;
			if (null == this.getId() || null == userStatisticsDet.getId()) return false;
			else return (this.getId().equals(userStatisticsDet.getId()));
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