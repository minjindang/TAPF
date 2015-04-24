/* Hamb0101Form.java
程式目的：HAMB01文字
程式代號：HAMB01
程式日期：0950220
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
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

public class Hamb0101Form extends SupportForm{
	private static final long serialVersionUID = 1L;

	//String allYear;		//記帳年度
	//String allMonth;	//分配年月
	//String unitName;	//受分配單位名稱
	//BigDecimal allMoney;	//受分配金額
	//String monKind;		//撥款種類
	// 資料表 UnitAllocateMain
	UnitAllocateMain myMain = new UnitAllocateMain();
	
	public Date getCreateDate() {
		return myMain.getCreateDate();
	}
	public BigDecimal getFounda() {
		return myMain.getFounda();
	}
	public BigDecimal getFoundb() {
		return myMain.getFoundb();
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
	public String getUsrid() {
		return myMain.getUsrid();
	}
	public boolean isOk() {
		return myMain.isOk();
	}
	public boolean getIsOk() {
		return myMain.isOk();
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
	public void setUsrid(String usrid) {
		myMain.setUsrid(usrid);
	}
	public Date getModDate() {
		return myMain.getModDate();
	}
	public void setModDate(Date modDate) {
		myMain.setModDate(modDate);
	}
	public Integer getId() {
		return myMain.getUnitInfo().getId();
	}
	public String getUnitName() {
		return myMain.getUnitInfo().getUnitName();
	}
	public void setId(Integer id) {
		myMain.getUnitInfo().setId(id);
	}
	public void setUnitName(String unitName) {
		myMain.getUnitInfo().setUnitName(unitName);
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
	public String getMonKind() {
		return myMain.getMonKind();
	}
	public UnitInfoMain getUnitInfo() {
		return myMain.getUnitInfo();
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
	public void setMonKind(String monKind) {
		myMain.setMonKind(monKind);
	}
	public void setUnitInfo(UnitInfoMain unitInfo) {
		myMain.setUnitInfo(unitInfo);
	}
	
	public List getAllYearList() {
        return UnitAllocate.getYearLabelList(getMonKind());
	}

	public List getAllMonthList() {
        return UnitAllocate.getMonthLabelWithYearList(getAllYear(),getMonKind());
	}
	
}
