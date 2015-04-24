/* Harb0801Form.java
�{���ت��GHARB08��r
�{���N���GHARB08
�{������G0950221
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.central.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.sql.UnitAllocateMain;
import tw.gov.nta.sql.UnitInfoMain;

/**
 * @author EricChen
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class Harb0801Form extends SupportForm {
	
	private static final long serialVersionUID = 1L;
	private Date recvSdate;	//�^�������ҩl���
	private Date recvEdate;	//�^�������פ���
	//private String unitName;
	UnitAllocateMain myMain = new UnitAllocateMain();
	UnitInfoMain info = new UnitInfoMain();
	public String getUnitId() {
		return info.getUnitId();
	}
	public void setUnitId(String unitId) {
		info.setUnitId(unitId);
	}
	public String getUnitName() {
		
		return info.getUnitName();
	}
	public void setUnitName(String unitName) {
		info.setUnitName(unitName);
	}

	public UnitAllocateMain getMyMain() {
		return myMain;
	}

	public void setMyMain(UnitAllocateMain myMain) {
		this.myMain = myMain;
	}
	public Date getRecvEdate() {
		return recvEdate;
	}
	public void setRecvEdate(Date recvEdate) {
		this.recvEdate = recvEdate;
	}
	public Date getRecvSdate() {
		return recvSdate;
	}
	public void setRecvSdate(Date recvSdate) {
		this.recvSdate = recvSdate;
	}
	public BigDecimal getAllMoney() {
		return myMain.getAllMoney();
	}

	public String getAllMonth() {
		return myMain.getAllMonth();
	}

	public String getAllYear() {
		return myMain.getAllYear();
	}

	public Date getCreateDate() {
		return myMain.getCreateDate();
	}

	public BigDecimal getFounda() {
		return myMain.getFounda();
	}

	public BigDecimal getFoundb() {
		return myMain.getFoundb();
	}

	public Integer getId() {
		return myMain.getId();
	}

	public Date getModDate() {
		return myMain.getModDate();
	}

	public String getMonKind() {
		return myMain.getMonKind();
	}

	public Date getOkDate() {
		return myMain.getOkDate();
	}

	public String getOkUser() {
		return myMain.getOkUser();
	}

	public Date getRecvDate() {
		return myMain.getRecvDate();
	}

	public String getRemark() {
		return myMain.getRemark();
	}

	public Date getSendDate() {
		return myMain.getSendDate();
	}

	public BigDecimal getSrcMoney() {
		return myMain.getSrcMoney();
	}

	public UnitInfoMain getUnitInfo() {
		return myMain.getUnitInfo();
	}

	public String getUsrid() {
		return myMain.getUsrid();
	}

	public boolean isOk() {
		return myMain.isOk();
	}

	public void setAllMoney(BigDecimal allMoney) {
		myMain.setAllMoney(allMoney);
	}

	public void setAllMonth(String allMonth) {
		myMain.setAllMonth(allMonth);
	}

	public void setAllYear(String allYear) {
		myMain.setAllYear(allYear);
	}

	public void setCreateDate(Date createDate) {
		myMain.setCreateDate(createDate);
	}

	public void setFounda(BigDecimal founda) {
		myMain.setFounda(founda);
	}

	public void setFoundb(BigDecimal foundb) {
		myMain.setFoundb(foundb);
	}

	public void setId(Integer id) {
		myMain.setId(id);
	}

	public void setModDate(Date modDate) {
		myMain.setModDate(modDate);
	}

	public void setMonKind(String monKind) {
		myMain.setMonKind(monKind);
	}

	public void setOk(boolean ok) {
		myMain.setOk(ok);
	}

	public void setOkDate(Date okDate) {
		myMain.setOkDate(okDate);
	}

	public void setOkUser(String okUser) {
		myMain.setOkUser(okUser);
	}

	public void setRecvDate(Date recvDate) {
		myMain.setRecvDate(recvDate);
	}

	public void setRemark(String remark) {
		myMain.setRemark(remark);
	}

	public void setSendDate(Date sendDate) {
		myMain.setSendDate(sendDate);
	}

	public void setSrcMoney(BigDecimal srcMoney) {
		myMain.setSrcMoney(srcMoney);
	}

	public void setUnitInfo(UnitInfoMain unitInfo) {
		myMain.setUnitInfo(unitInfo);
	}

	public void setUsrid(String usrid) {
		myMain.setUsrid(usrid);
	}
	
	public List getAllYearList() {
        return UnitAllocate.getYearLabelList(getMonKind());
	}

	public List getAllMonthList() {
        return UnitAllocate.getMonthLabelWithYearList(getAllYear(),getMonKind());
	}
	
}
