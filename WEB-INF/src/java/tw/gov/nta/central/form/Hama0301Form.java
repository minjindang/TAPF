/*
�{���ت��GHAMA03��r
�{���N���GHAMA03
�{������G0950220
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡GMindy
�ק����G0950220
�ק�ت��G����get�Bset�M����
--------------------------------------------------------
*/
package tw.gov.nta.central.form;

import java.math.BigDecimal;
import java.util.Date;

import gov.dnt.tame.common.SupportForm;

import org.apache.struts.upload.FormFile;

import tw.gov.nta.sql.UnitInfoMain;
import tw.gov.nta.sql.UnitPercentDet;

public class Hama0301Form extends SupportForm{

	private static final long serialVersionUID = 1L;

	private UnitPercentDet unitPercentDet = new UnitPercentDet();

	private String qryYear;				//�O�b�~��
	private FormFile filePath = null; 	//�ɮ׸��|

	private int page;

	public FormFile getFilePath() {
		return filePath;
	}
	public void setFilePath(FormFile filePath) {
		this.filePath = filePath;
	}
	public String getQryYear() {
		return qryYear;
	}
	public void setQryYear(String qryYear) {
		this.qryYear = qryYear;
	}
	public UnitPercentDet getUnitPercentDet() {
		return unitPercentDet;
	}
	public void setUnitPercentDet(UnitPercentDet unitPercentDet) {
		this.unitPercentDet = unitPercentDet;
	}
	public Date getCreateDate() {
		return unitPercentDet.getCreateDate();
	}
	public Integer getId() {
		return unitPercentDet.getId();
	}
	public Date getModDate() {
		return unitPercentDet.getModDate();
	}
	public String getRemark() {
		return unitPercentDet.getRemark();
	}
	public BigDecimal getTpercent() {
		return unitPercentDet.getTpercent();
	}
	public String getTyear() {
		return unitPercentDet.getTyear();
	}
	public UnitInfoMain getUnitInfo() {
		return unitPercentDet.getUnitInfo();
	}
	public String getUsrid() {
		return unitPercentDet.getUsrid();
	}
	public void setCreateDate(Date createDate) {
		unitPercentDet.setCreateDate(createDate);
	}
	public void setId(Integer id) {
		unitPercentDet.setId(id);
	}
	public void setModDate(Date modDate) {
		unitPercentDet.setModDate(modDate);
	}
	public void setRemark(String remark) {
		unitPercentDet.setRemark(remark);
	}
	public void setTpercent(BigDecimal tpercent) {
		unitPercentDet.setTpercent(tpercent);
	}
	public void setTyear(String tyear) {
		unitPercentDet.setTyear(tyear);
	}
	public void setUnitInfo(UnitInfoMain unitInfo) {
		unitPercentDet.setUnitInfo(unitInfo);
	}
	public void setUsrid(String usrid) {
		unitPercentDet.setUsrid(usrid);
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}