package tw.gov.nta.central.form;
import gov.dnt.tame.common.SupportForm;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.struts.upload.FormFile;
import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.sql.UnitAllocateMain;
import tw.gov.nta.sql.UnitInfoMain;
public class Hamb1201Form extends SupportForm{
	private static final long serialVersionUID = 1L;
	private UnitAllocateMain unitAllocateMain = new UnitAllocateMain();
	private UnitInfoMain unitInfoMain = new UnitInfoMain();
	private BigDecimal financialPerMonth ;
	private String qryAllYear;
	private String qryAllMonth;
	private String qryUnitId;
	private String qryUnitName;
	private BigDecimal qryTotal;
	private int page;
	private String qryYear;				//記帳年度
	private FormFile filePath = null; 	//檔案路徑

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
	public Integer getUnitInfoId() {
		return this.unitAllocateMain.getUnitInfo().getId();
	}
	public void setFinancialPerMonth(BigDecimal financialPerMonth){
		this.financialPerMonth = financialPerMonth;
	}
	public void setUnitInfoId(Integer unitInfoId) {
		unitInfoMain = new UnitInfoMain(unitInfoId);
		unitAllocateMain.setUnitInfo(unitInfoMain);
	}
	public void setUnitInfo(UnitInfoMain unitInfo) {
		unitAllocateMain.setUnitInfo(unitInfo);
	}
	public UnitInfoMain getUnitInfo() {
		return unitAllocateMain.getUnitInfo();
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public UnitAllocateMain getUnitAllocateMain() {
		return unitAllocateMain;
	}
	public void setUnitAllocateMain(UnitAllocateMain unitAllocateMain) {
		this.unitAllocateMain = unitAllocateMain;
	}
	public String getQryAllMonth() {
		return qryAllMonth;
	}
	public void setQryAllMonth(String qryAllMonth) {
		this.qryAllMonth = qryAllMonth;
	}
	public String getQryAllYear() {
		return qryAllYear;
	}
	public void setQryAllYear(String qryAllYear) {
		this.qryAllYear = qryAllYear;
	}
	public String getQryUnitId() {
		return qryUnitId;
	}
	public void setQryUnitId(String qryUnitId) {
		this.qryUnitId = qryUnitId;
	}
	public String getQryUnitName() {
		return qryUnitName;
	}
	public void setQryUnitName(String qryUnitName) throws UnsupportedEncodingException {
		qryUnitName = java.net.URLDecoder.decode(qryUnitName,"UTF-8");
		this.qryUnitName = qryUnitName;
	}
	public BigDecimal getFinancialPerMonth(){
		return this.financialPerMonth ;
	}
	public BigDecimal getAllMoney() {
		return unitAllocateMain.getAllMoney().setScale(0,BigDecimal.ROUND_HALF_UP);
	}
	public String getAllMonth() {
		return unitAllocateMain.getAllMonth();
	}
	public String getAllYear() {
		return unitAllocateMain.getAllYear();
	}
	public Date getCreateDate() {
		return unitAllocateMain.getCreateDate();
	}
	public BigDecimal getFounda() {
		return unitAllocateMain.getFounda().setScale(0,BigDecimal.ROUND_HALF_UP);
	}
	public BigDecimal getFoundb() {
		return unitAllocateMain.getFoundb().setScale(0,BigDecimal.ROUND_HALF_UP);
	}
	public Integer getId() {
		return unitAllocateMain.getId();
	}
	public Date getModDate() {
		return unitAllocateMain.getModDate();
	}
	public String getMonKind() {
		return unitAllocateMain.getMonKind();
	}
	public Date getOkDate() {
		return unitAllocateMain.getOkDate();
	}
	public String getOkUser() {
		return unitAllocateMain.getOkUser();
	}
	public Date getRecvDate() {
		return unitAllocateMain.getRecvDate();
	}
	public String getRemark() {
		return unitAllocateMain.getRemark();
	}
	public Date getSendDate() {
		return unitAllocateMain.getSendDate();
	}
	public BigDecimal getSrcMoney() {
		return unitAllocateMain.getSrcMoney().setScale(0,BigDecimal.ROUND_HALF_UP);
	}
	public BigDecimal getLastFound() {
		return unitAllocateMain.getLastFound().setScale(0,BigDecimal.ROUND_HALF_UP);
	}
	public BigDecimal getNowFound() {
		return unitAllocateMain.getNowFound().setScale(0,BigDecimal.ROUND_HALF_UP);
	}
	public String getUsrid() {
		return unitAllocateMain.getUsrid();
	}
	public boolean isOk() {
		return unitAllocateMain.isOk();
	}
	public void setAllMoney(BigDecimal allMoney) {
		unitAllocateMain.setAllMoney(allMoney);
	}
	public void setAllMonth(String allMonth) {
		unitAllocateMain.setAllMonth(allMonth);
	}
	public void setAllYear(String allYear) {
		unitAllocateMain.setAllYear(allYear);
	}
	public void setCreateDate(Date createDate) {
		unitAllocateMain.setCreateDate(createDate);
	}
	public void setFounda(BigDecimal founda) {
		unitAllocateMain.setFounda(founda);
	}
	public void setFoundb(BigDecimal foundb) {
		unitAllocateMain.setFoundb(foundb);
	}
	public void setId(Integer id) {
		unitAllocateMain.setId(id);
	}
	public void setModDate(Date modDate) {
		unitAllocateMain.setModDate(modDate);
	}
	public void setMonKind(String monKind) {
		unitAllocateMain.setMonKind(monKind);
	}
	public void setOk(boolean ok) {
		unitAllocateMain.setOk(ok);
	}
	public void setOkDate(Date okDate) {
		unitAllocateMain.setOkDate(okDate);
	}
	public void setOkUser(String okUser) {
		unitAllocateMain.setOkUser(okUser);
	}
	public void setRecvDate(Date recvDate) {
		unitAllocateMain.setRecvDate(recvDate);
	}
	public void setRemark(String remark) {
		unitAllocateMain.setRemark(remark);
	}
	public void setSendDate(Date sendDate) {
		unitAllocateMain.setSendDate(sendDate);
	}
	public void setSrcMoney(BigDecimal srcMoney) {
		unitAllocateMain.setSrcMoney(srcMoney);
	}
	public void setNowFound(BigDecimal nowFound) {
		unitAllocateMain.setNowFound(nowFound);
	}
	public void setLastFound(BigDecimal lastFound){
		unitAllocateMain.setLastFound(lastFound);
	}
	public void setUsrid(String usrid) {
		unitAllocateMain.setUsrid(usrid);
	}
	public String getUnitId() {
		return unitInfoMain.getUnitId();
	}
	public String getUnitName() {
		return unitInfoMain.getUnitName();
	}
	public void setUnitId(String unitId) {
		unitInfoMain.setUnitId(unitId);
	}
	public void setUnitName(String unitName) {
		unitInfoMain.setUnitName(unitName);
	}
	public BigDecimal getQryTotal() {
		return qryTotal.setScale(0,BigDecimal.ROUND_HALF_UP);
	}
	public void setQryTotal(BigDecimal qryTotal) {
		this.qryTotal = qryTotal;
	}
	public String getNotea() {
		return unitInfoMain.getNotea();
	}
	public void setNotea(String notea) {
		unitInfoMain.setNotea(notea);
	}
	
	public List getQryAllYearList() {
        return UnitAllocate.getYearLabelList(getMonKind());
	}

	public List getQryAllMonthList() {
        return UnitAllocate.getMonthLabelWithYearList(getQryAllYear(),getMonKind());
	}
}
