package tw.gov.nta.sql.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the Unit_info_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Unit_info_main"
 */

public abstract class BaseUnitInfoMain  implements Comparable, Serializable {

	public static String REF = "UnitInfoMain";
	public static String PROP_SBRANCH2 = "sbranch2";
	public static String PROP_REMARK = "remark";
	public static String PROP_TTEL = "ttel";
	public static String PROP_TBANK1 = "tbank1";
	public static String PROP_GROUPID = "groupid";
	public static String PROP_MOD_DATE = "modDate";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_TBANK2 = "tbank2";
	public static String PROP_USRID = "usrid";
	public static String PROP_SBRANCH1 = "sbranch1";
	public static String PROP_TNAME = "tname";
	public static String PROP_SEQ_NO = "seqNo";
	public static String PROP_UNIT_NAME = "unitName";
	public static String PROP_TFAX = "tfax";
	public static String PROP_SBANK2 = "sbank2";
	public static String PROP_SNO1 = "sno1";
	public static String PROP_SNO2 = "sno2";
	public static String PROP_TACCT1 = "tacct1";
	public static String PROP_TEMAIL = "temail";
	public static String PROP_UNIT_ID = "unitId";
	public static String PROP_TACCT2 = "tacct2";
	public static String PROP_MAIL = "mail";
	public static String PROP_NOTEB = "noteb";
	public static String PROP_SBANK1 = "sbank1";
	public static String PROP_NOTEA = "notea";
	public static String PROP_ID = "id";


	// constructors
	public BaseUnitInfoMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUnitInfoMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUnitInfoMain (
		java.lang.Integer id,
		java.util.Date modDate) {

		this.setId(id);
		this.setModDate(modDate);
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
	private java.lang.String unitId;
	private java.lang.String unitName;
	private java.lang.String sbank1;
	private java.lang.String sbranch1;
	private java.lang.String sno1;
	private java.lang.String sbank2;
	private java.lang.String sbranch2;
	private java.lang.String sno2;
	private java.lang.String tbank1;
	private java.lang.String tacct1;
	private java.lang.String tbank2;
	private java.lang.String tacct2;
	private java.lang.String temail;
	private java.lang.String tname;
	private java.lang.String ttel;
	private java.lang.String tfax;
	private java.lang.String mail;
	private java.lang.String notea;
	private java.lang.String noteb;
	private java.lang.String groupid;
	private java.lang.String seqNo;

	// collections
	private java.util.Set<tw.gov.nta.sql.UnitAllocateMain> unitAllocateMains;
	private java.util.Set<tw.gov.nta.sql.UnitPercentDet> unitPercentDets;
	//2011/9/20 因HAMA04需要 由Powewn Hsueh 新增
	private java.util.Set<tw.gov.nta.sql.UnitPercentDet101> unitPercentDets101;

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
	 * Return the value associated with the column: UNIT_ID
	 */
	public java.lang.String getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (java.lang.String unitId) {
		this.unitId = unitId;
	}



	/**
	 * Return the value associated with the column: UNIT_NAME
	 */
	public java.lang.String getUnitName () {
		return unitName;
	}

	/**
	 * Set the value related to the column: UNIT_NAME
	 * @param unitName the UNIT_NAME value
	 */
	public void setUnitName (java.lang.String unitName) {
		this.unitName = unitName;
	}



	/**
	 * Return the value associated with the column: SBANK1
	 */
	public java.lang.String getSbank1 () {
		return sbank1;
	}

	/**
	 * Set the value related to the column: SBANK1
	 * @param sbank1 the SBANK1 value
	 */
	public void setSbank1 (java.lang.String sbank1) {
		this.sbank1 = sbank1;
	}



	/**
	 * Return the value associated with the column: SBRANCH1
	 */
	public java.lang.String getSbranch1 () {
		return sbranch1;
	}

	/**
	 * Set the value related to the column: SBRANCH1
	 * @param sbranch1 the SBRANCH1 value
	 */
	public void setSbranch1 (java.lang.String sbranch1) {
		this.sbranch1 = sbranch1;
	}



	/**
	 * Return the value associated with the column: SNO1
	 */
	public java.lang.String getSno1 () {
		return sno1;
	}

	/**
	 * Set the value related to the column: SNO1
	 * @param sno1 the SNO1 value
	 */
	public void setSno1 (java.lang.String sno1) {
		this.sno1 = sno1;
	}



	/**
	 * Return the value associated with the column: SBANK2
	 */
	public java.lang.String getSbank2 () {
		return sbank2;
	}

	/**
	 * Set the value related to the column: SBANK2
	 * @param sbank2 the SBANK2 value
	 */
	public void setSbank2 (java.lang.String sbank2) {
		this.sbank2 = sbank2;
	}



	/**
	 * Return the value associated with the column: SBRANCH2
	 */
	public java.lang.String getSbranch2 () {
		return sbranch2;
	}

	/**
	 * Set the value related to the column: SBRANCH2
	 * @param sbranch2 the SBRANCH2 value
	 */
	public void setSbranch2 (java.lang.String sbranch2) {
		this.sbranch2 = sbranch2;
	}



	/**
	 * Return the value associated with the column: SNO2
	 */
	public java.lang.String getSno2 () {
		return sno2;
	}

	/**
	 * Set the value related to the column: SNO2
	 * @param sno2 the SNO2 value
	 */
	public void setSno2 (java.lang.String sno2) {
		this.sno2 = sno2;
	}



	/**
	 * Return the value associated with the column: TBANK1
	 */
	public java.lang.String getTbank1 () {
		return tbank1;
	}

	/**
	 * Set the value related to the column: TBANK1
	 * @param tbank1 the TBANK1 value
	 */
	public void setTbank1 (java.lang.String tbank1) {
		this.tbank1 = tbank1;
	}



	/**
	 * Return the value associated with the column: TACCT1
	 */
	public java.lang.String getTacct1 () {
		return tacct1;
	}

	/**
	 * Set the value related to the column: TACCT1
	 * @param tacct1 the TACCT1 value
	 */
	public void setTacct1 (java.lang.String tacct1) {
		this.tacct1 = tacct1;
	}



	/**
	 * Return the value associated with the column: TBANK2
	 */
	public java.lang.String getTbank2 () {
		return tbank2;
	}

	/**
	 * Set the value related to the column: TBANK2
	 * @param tbank2 the TBANK2 value
	 */
	public void setTbank2 (java.lang.String tbank2) {
		this.tbank2 = tbank2;
	}



	/**
	 * Return the value associated with the column: TACCT2
	 */
	public java.lang.String getTacct2 () {
		return tacct2;
	}

	/**
	 * Set the value related to the column: TACCT2
	 * @param tacct2 the TACCT2 value
	 */
	public void setTacct2 (java.lang.String tacct2) {
		this.tacct2 = tacct2;
	}



	/**
	 * Return the value associated with the column: TEMAIL
	 */
	public java.lang.String getTemail () {
		return temail;
	}

	/**
	 * Set the value related to the column: TEMAIL
	 * @param temail the TEMAIL value
	 */
	public void setTemail (java.lang.String temail) {
		this.temail = temail;
	}



	/**
	 * Return the value associated with the column: TNAME
	 */
	public java.lang.String getTname () {
		return tname;
	}

	/**
	 * Set the value related to the column: TNAME
	 * @param tname the TNAME value
	 */
	public void setTname (java.lang.String tname) {
		this.tname = tname;
	}



	/**
	 * Return the value associated with the column: TTEL
	 */
	public java.lang.String getTtel () {
		return ttel;
	}

	/**
	 * Set the value related to the column: TTEL
	 * @param ttel the TTEL value
	 */
	public void setTtel (java.lang.String ttel) {
		this.ttel = ttel;
	}



	/**
	 * Return the value associated with the column: TFAX
	 */
	public java.lang.String getTfax () {
		return tfax;
	}

	/**
	 * Set the value related to the column: TFAX
	 * @param tfax the TFAX value
	 */
	public void setTfax (java.lang.String tfax) {
		this.tfax = tfax;
	}



	/**
	 * Return the value associated with the column: MAIL
	 */
	public java.lang.String getMail () {
		return mail;
	}

	/**
	 * Set the value related to the column: MAIL
	 * @param mail the MAIL value
	 */
	public void setMail (java.lang.String mail) {
		this.mail = mail;
	}



	/**
	 * Return the value associated with the column: NOTEA
	 */
	public java.lang.String getNotea () {
		return notea;
	}

	/**
	 * Set the value related to the column: NOTEA
	 * @param notea the NOTEA value
	 */
	public void setNotea (java.lang.String notea) {
		this.notea = notea;
	}



	/**
	 * Return the value associated with the column: NOTEB
	 */
	public java.lang.String getNoteb () {
		return noteb;
	}

	/**
	 * Set the value related to the column: NOTEB
	 * @param noteb the NOTEB value
	 */
	public void setNoteb (java.lang.String noteb) {
		this.noteb = noteb;
	}



	/**
	 * Return the value associated with the column: GROUPID
	 */
	public java.lang.String getGroupid () {
		return groupid;
	}

	/**
	 * Set the value related to the column: GROUPID
	 * @param groupid the GROUPID value
	 */
	public void setGroupid (java.lang.String groupid) {
		this.groupid = groupid;
	}



	/**
	 * Return the value associated with the column: seq_no
	 */
	public java.lang.String getSeqNo () {
		return seqNo;
	}

	/**
	 * Set the value related to the column: seq_no
	 * @param seqNo the seq_no value
	 */
	public void setSeqNo (java.lang.String seqNo) {
		this.seqNo = seqNo;
	}



	/**
	 * Return the value associated with the column: unitAllocateMains
	 */
	public java.util.Set<tw.gov.nta.sql.UnitAllocateMain> getUnitAllocateMains () {
		return unitAllocateMains;
	}

	/**
	 * Set the value related to the column: unitAllocateMains
	 * @param unitAllocateMains the unitAllocateMains value
	 */
	public void setUnitAllocateMains (java.util.Set<tw.gov.nta.sql.UnitAllocateMain> unitAllocateMains) {
		this.unitAllocateMains = unitAllocateMains;
	}

	public void addTounitAllocateMains (tw.gov.nta.sql.UnitAllocateMain unitAllocateMain) {
		if (null == getUnitAllocateMains()) setUnitAllocateMains(new java.util.TreeSet<tw.gov.nta.sql.UnitAllocateMain>());
		getUnitAllocateMains().add(unitAllocateMain);
	}



	/**
	 * Return the value associated with the column: unitPercentDets
	 */
	public java.util.Set<tw.gov.nta.sql.UnitPercentDet> getUnitPercentDets () {
		return unitPercentDets;
	}
	
	/**因HAMA04需要 新增
	 * Return the value associated with the column: unitPercentDets101
	 */
	public java.util.Set<tw.gov.nta.sql.UnitPercentDet101> getUnitPercentDets101 () {
		return unitPercentDets101;
	}


	/**
	 * Set the value related to the column: unitPercentDets
	 * @param unitPercentDets the unitPercentDets value
	 */
	public void setUnitPercentDets (java.util.Set<tw.gov.nta.sql.UnitPercentDet> unitPercentDets) {
		this.unitPercentDets = unitPercentDets;
	}
	
	/**
	 * Set the value related to the column: unitPercentDets
	 * @param unitPercentDets the unitPercentDets value
	 */
	public void setUnitPercentDets101 (java.util.Set<tw.gov.nta.sql.UnitPercentDet101> unitPercentDets101) {
		this.unitPercentDets101 = unitPercentDets101;
	}

	public void addTounitPercentDets (tw.gov.nta.sql.UnitPercentDet unitPercentDet) {
		if (null == getUnitPercentDets()) setUnitPercentDets(new java.util.TreeSet<tw.gov.nta.sql.UnitPercentDet>());
		getUnitPercentDets().add(unitPercentDet);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof tw.gov.nta.sql.UnitInfoMain)) return false;
		else {
			tw.gov.nta.sql.UnitInfoMain unitInfoMain = (tw.gov.nta.sql.UnitInfoMain) obj;
			if (null == this.getId() || null == unitInfoMain.getId()) return false;
			else return (this.getId().equals(unitInfoMain.getId()));
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