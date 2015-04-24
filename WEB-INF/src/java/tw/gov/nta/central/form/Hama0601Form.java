package tw.gov.nta.central.form;

import gov.dnt.tame.common.SupportForm;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.struts.upload.FormFile;
import tw.gov.nta.sql.UnitInfoMain;
import tw.gov.nta.sql.UnitPercentDet101;

public class Hama0601Form extends SupportForm{
	private static final long serialVersionUID = 1L;

	private UnitPercentDet101 unitPercentDet101 = new UnitPercentDet101();

	private String qryYear;				//記帳年度
	private FormFile filePath = null; 	//檔案路徑

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
	public UnitPercentDet101 getUnitPercentDet() {
		return unitPercentDet101;
	}
	public void setUnitPercentDet(UnitPercentDet101 unitPercentDet101) {
		this.unitPercentDet101 = unitPercentDet101;
	}
	
	public Integer getId() {
		return unitPercentDet101.getId();
	}
	public Date getModDate() {
		return unitPercentDet101.getModDate();
	}
	public String getRemark() {
		return unitPercentDet101.getRemark();
	}
	public BigDecimal getTpercent() {
		return unitPercentDet101.getTpercent();
	}
	public String getTyear() {
		return unitPercentDet101.getTyear();
	}
	public BigDecimal getFinancial() {
		return unitPercentDet101.getFinancial();
	}
	public UnitInfoMain getUnitInfo() {
		return unitPercentDet101.getUnitInfo();
	}
	public String getUsrid() {
		return unitPercentDet101.getUsrid();
	}
	public void setId(Integer id) {
		unitPercentDet101.setId(id);
	}
	public void setModDate(Date modDate) {
		unitPercentDet101.setModDate(modDate);
	}
	public void setRemark(String remark) {
		unitPercentDet101.setRemark(remark);
	}
	public void setTpercent(BigDecimal tpercent) {
		unitPercentDet101.setTpercent(tpercent);
	}
	public void setFinancial(BigDecimal financial) {
		unitPercentDet101.setFinancial(financial);
	}
	public void setTyear(String tyear) {
		unitPercentDet101.setTyear(tyear);
	}
	public void setUnitInfo(UnitInfoMain unitInfo) {
		unitPercentDet101.setUnitInfo(unitInfo);
	}
	public void setUsrid(String usrid) {
		unitPercentDet101.setUsrid(usrid);
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
