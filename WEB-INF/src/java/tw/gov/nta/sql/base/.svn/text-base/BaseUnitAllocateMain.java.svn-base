package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.math.BigDecimal;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Unit_allocate_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Unit_allocate_main"
 */

public abstract class BaseUnitAllocateMain  implements Comparable, Serializable {

	public static String REF = "UnitAllocateMain";
	public static String PROP_OK_USER = "okUser";
	public static String PROP_REMARK = "remark";
	public static String PROP_OK_DATE = "okDate";
	public static String PROP_UNIT_INFO = "unitInfo";
	public static String PROP_FOUNDB = "foundb";
	public static String PROP_SEND_DATE = "sendDate";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_SRC_MONEY = "srcMoney";
	public static String PROP_ALL_YEAR = "allYear";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_FOUNDA = "founda";
	public static String PROP_MON_KIND = "monKind";
	public static String PROP_OK = "ok";
	public static String PROP_USRID = "usrid";
	public static String PROP_ALL_MONEY = "allMoney";
	public static String PROP_RECV_DATE = "recvDate";
	public static String PROP_ALL_MONTH = "allMonth";
	public static String PROP_ID = "id";
	public static String PROP_Last_Found = "lastFound";
	public static String PROP_Now_Found = "nowFound";
	public static String PROP_GROUPID = "groupid";
	public static String PROP_SEQ_NO = "seqNo";


	// constructors
	public BaseUnitAllocateMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUnitAllocateMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUnitAllocateMain (
		java.lang.Integer id,
		tw.gov.nta.sql.UnitInfoMain unitInfo) {

		this.setId(id);
		this.setUnitInfo(unitInfo);
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
	private java.lang.String allMonth;
	private java.math.BigDecimal allMoney;
	private boolean ok;
	private java.lang.String allYear;
	private java.lang.String monKind;
	private java.util.Date okDate;
	private java.lang.String okUser;
	private java.math.BigDecimal srcMoney;
	private java.util.Date recvDate;
	private java.util.Date sendDate;
	private java.math.BigDecimal founda;
	private java.math.BigDecimal foundb;
	private java.math.BigDecimal lastFound;
	private java.math.BigDecimal nowFound;
	private java.lang.String groupid;
	private java.lang.String seqNo;

	// many to one
	private tw.gov.nta.sql.UnitInfoMain unitInfo;



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



	public java.lang.String getGroupid() {
		return groupid;
	}

	public void setGroupid(java.lang.String groupid) {
		this.groupid = groupid;
	}

	public java.lang.String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(java.lang.String seqNo) {
		this.seqNo = seqNo;
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
	 * Return the value associated with the column: ALL_MONTH
	 */
	public java.lang.String getAllMonth () {
		return allMonth;
	}

	/**
	 * Set the value related to the column: ALL_MONTH
	 * @param allMonth the ALL_MONTH value
	 */
	public void setAllMonth (java.lang.String allMonth) {
		this.allMonth = allMonth;
	}



	/**
	 * Return the value associated with the column: ALL_MONEY
	 */
	public java.math.BigDecimal getAllMoney () {
		return allMoney;
	}

	/**
	 * Set the value related to the column: ALL_MONEY
	 * @param allMoney the ALL_MONEY value
	 */
	public void setAllMoney (java.math.BigDecimal allMoney) {
		this.allMoney = allMoney;
	}



	/**
	 * Return the value associated with the column: IS_OK
	 */
	public boolean isOk () {
		return ok;
	}

	/**
	 * Set the value related to the column: IS_OK
	 * @param ok the IS_OK value
	 */
	public void setOk (boolean ok) {
		this.ok = ok;
	}



	/**
	 * Return the value associated with the column: ALL_YEAR
	 */
	public java.lang.String getAllYear () {
		return allYear;
	}

	/**
	 * Set the value related to the column: ALL_YEAR
	 * @param allYear the ALL_YEAR value
	 */
	public void setAllYear (java.lang.String allYear) {
		this.allYear = allYear;
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
	 * Return the value associated with the column: OK_DATE
	 */
	public java.util.Date getOkDate () {
		return okDate;
	}

	/**
	 * Set the value related to the column: OK_DATE
	 * @param okDate the OK_DATE value
	 */
	public void setOkDate (java.util.Date okDate) {
		this.okDate = okDate;
	}



	/**
	 * Return the value associated with the column: OK_USER
	 */
	public java.lang.String getOkUser () {
		return okUser;
	}

	/**
	 * Set the value related to the column: OK_USER
	 * @param okUser the OK_USER value
	 */
	public void setOkUser (java.lang.String okUser) {
		this.okUser = okUser;
	}



	/**
	 * Return the value associated with the column: SRC_MONEY
	 */
	public java.math.BigDecimal getSrcMoney () {
		return srcMoney;
	}

	/**
	 * Set the value related to the column: SRC_MONEY
	 * @param srcMoney the SRC_MONEY value
	 */
	public void setSrcMoney (java.math.BigDecimal srcMoney) {
		this.srcMoney = srcMoney;
	}



	public java.math.BigDecimal getLastFound() {return lastFound;}
	public void setLastFound(java.math.BigDecimal lastFound) {this.lastFound = lastFound;}

	public java.math.BigDecimal getNowFound() {return nowFound;}
	public void setNowFound(java.math.BigDecimal nowFound) {this.nowFound = nowFound;}

	/**
	 * Return the value associated with the column: RECV_DATE
	 */
	public java.util.Date getRecvDate () {
		return recvDate;
	}

	/**
	 * Set the value related to the column: RECV_DATE
	 * @param recvDate the RECV_DATE value
	 */
	public void setRecvDate (java.util.Date recvDate) {
		this.recvDate = recvDate;
	}



	/**
	 * Return the value associated with the column: SEND_DATE
	 */
	public java.util.Date getSendDate () {
		return sendDate;
	}

	/**
	 * Set the value related to the column: SEND_DATE
	 * @param sendDate the SEND_DATE value
	 */
	public void setSendDate (java.util.Date sendDate) {
		this.sendDate = sendDate;
	}



	/**
	 * Return the value associated with the column: FOUNDA
	 */
	public java.math.BigDecimal getFounda () {
		return founda;
	}

	/**
	 * Set the value related to the column: FOUNDA
	 * @param founda the FOUNDA value
	 */
	public void setFounda (java.math.BigDecimal founda) {
		this.founda = founda;
	}



	/**
	 * Return the value associated with the column: FOUNDB
	 */
	public java.math.BigDecimal getFoundb () {
		return foundb;
	}

	/**
	 * Set the value related to the column: FOUNDB
	 * @param foundb the FOUNDB value
	 */
	public void setFoundb (java.math.BigDecimal foundb) {
		this.foundb = foundb;
	}



	/**
	 * Return the value associated with the column: UNIT_INFO_ID
	 */
	public tw.gov.nta.sql.UnitInfoMain getUnitInfo () {
		return unitInfo;
	}

	/**
	 * Set the value related to the column: UNIT_INFO_ID
	 * @param unitInfo the UNIT_INFO_ID value
	 */
	public void setUnitInfo (tw.gov.nta.sql.UnitInfoMain unitInfo) {
		this.unitInfo = unitInfo;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.UnitAllocateMain)) return false;
		else {
			tw.gov.nta.sql.UnitAllocateMain unitAllocateMain = (tw.gov.nta.sql.UnitAllocateMain) obj;
			if (null == this.getId() || null == unitAllocateMain.getId()) return false;
			else return (this.getId().equals(unitAllocateMain.getId()));
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