/* Hamb0301Form.java
 * 在 2006/2/21 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.central.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;

import tw.gov.nta.sql.TaxactionDet;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class Hamb0301Form extends SupportForm
{
	private static final long serialVersionUID = 1L;
	TaxactionDet taxactionDet = new TaxactionDet();
	
	private BigDecimal totMon;		//預定撥付金額
	private BigDecimal fillAmount;	//應撥補金額
	private BigDecimal nationRate;	//直轄市調減比率
	private BigDecimal localRate;	//縣市調減比率
	private BigDecimal intRate;		//鄉鎮市調減比率

	public TaxactionDet getTaxactionDet() {
		return taxactionDet;
	}

	public void setTaxactionDet(TaxactionDet taxactionDet) {
		this.taxactionDet = taxactionDet;
	}

	public BigDecimal getTotMon() {
		return totMon.setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public void setTotMon(BigDecimal totMon) {
		this.totMon = totMon;
	}

	public String getBankno() {
		return taxactionDet.getBankno();
	}

	public Date getCreateDate() {
		return taxactionDet.getCreateDate();
	}

	public Integer getId() {
		return taxactionDet.getId();
	}

	public BigDecimal getIntTax() {
		return taxactionDet.getIntTax().setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getLocalTax() {
		return taxactionDet.getLocalTax().setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public Date getModDate() {
		return taxactionDet.getModDate();
	}

	public String getMonKind() {
		return taxactionDet.getMonKind();
	}

	public String getMonNo() {
		return taxactionDet.getMonNo();
	}

	public BigDecimal getNationTax() {
		return taxactionDet.getNationTax().setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public String getPname() {
		return taxactionDet.getPname();
	}

	public String getRemark() {
		return taxactionDet.getRemark();
	}

	public String getTaxKind() {
		return taxactionDet.getTaxKind();
	}

	public String getTaxMonth() {
		return taxactionDet.getTaxMonth();
	}

	public String getTaxYear() {
		return taxactionDet.getTaxYear();
	}

	public String getUsrid() {
		return taxactionDet.getUsrid();
	}

	public void setBankno(String bankno) {
		taxactionDet.setBankno(bankno);
	}

	public void setCreateDate(Date createDate) {
		taxactionDet.setCreateDate(createDate);
	}

	public void setId(Integer id) {
		taxactionDet.setId(id);
	}

	public void setIntTax(BigDecimal intTax) {
		taxactionDet.setIntTax(intTax);
	}

	public void setLocalTax(BigDecimal localTax) {
		taxactionDet.setLocalTax(localTax);
	}

	public void setModDate(Date modDate) {
		taxactionDet.setModDate(modDate);
	}

	public void setMonKind(String monKind) {
		taxactionDet.setMonKind(monKind);
	}

	public void setMonNo(String monNo) {
		taxactionDet.setMonNo(monNo);
	}

	public void setNationTax(BigDecimal nationTax) {
		taxactionDet.setNationTax(nationTax);
	}

	public void setPname(String pname) {
		taxactionDet.setPname(pname);
	}

	public void setRemark(String remark) {
		taxactionDet.setRemark(remark);
	}

	public void setTaxKind(String taxKind) {
		taxactionDet.setTaxKind(taxKind);
	}

	public void setTaxMonth(String taxMonth) {
		taxactionDet.setTaxMonth(taxMonth);
	}

	public void setTaxYear(String taxYear) {
		taxactionDet.setTaxYear(taxYear);
	}

	public void setUsrid(String usrid) {
		taxactionDet.setUsrid(usrid);
	}

	public BigDecimal getFillAmount() {
		return taxactionDet.getFillAmount().setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public void setFillAmount(BigDecimal fillAmount) {
		taxactionDet.setFillAmount(fillAmount);
	}

	public BigDecimal getIntRate() {
		return taxactionDet.getIntRate().setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public void setIntRate(BigDecimal intRate) {
		taxactionDet.setIntRate(intRate);
	}

	public BigDecimal getLocalRate() {
		return taxactionDet.getLocalRate().setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public void setLocalRate(BigDecimal localRate) {
		taxactionDet.setLocalRate(localRate);
	}

	public BigDecimal getNationRate() {
		return taxactionDet.getNationRate().setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public void setNationRate(BigDecimal nationRate) {
		taxactionDet.setNationRate(nationRate);
	}
	
	
}
