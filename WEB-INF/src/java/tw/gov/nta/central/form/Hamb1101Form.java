package tw.gov.nta.central.form;
import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
//import java.util.Date;

import tw.gov.nta.sql.TaxactionDet101;
public class Hamb1101Form  extends SupportForm {
	private static final long serialVersionUID = 1L;
	TaxactionDet101 taxactionDet101 = new TaxactionDet101();
	
	//private BigDecimal totMon;		//預定撥付金額
	//private BigDecimal fillAmount;	//應撥補金額
	//private BigDecimal nationRate;	//直轄市調減比率
	//private BigDecimal localRate;	//縣市調減比率
	//private BigDecimal intRate;		//鄉鎮市調減比率

	public TaxactionDet101 getTaxactionDet() {
		return taxactionDet101;
	}

	public void setTaxactionDet(TaxactionDet101 taxactionDet) {
		this.taxactionDet101 = taxactionDet;
	}

	public BigDecimal getTotMon() {
		return taxactionDet101.getTotMon().setScale(0,BigDecimal.ROUND_HALF_UP);
	}
	
	public void setTotMon(BigDecimal totMon) {
		taxactionDet101.setTotMon(totMon);
	}


	public Integer getId() {
		return taxactionDet101.getId();
	}	

	public String getTaxMonth() {
		return taxactionDet101.getTaxMonth();
	}

	public String getTaxYear() {
		return taxactionDet101.getTaxYear();
	}
	
	public BigDecimal getNationTax() {
		return taxactionDet101.getNationTax().setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public String getFinancialCheck(){
		return taxactionDet101.getFinancialCheck();
	}
	
	public BigDecimal getFinancial(){
		return taxactionDet101.getFinancial();
	}	
	
	public BigDecimal getIntTax() {
		return taxactionDet101.getIntTax().setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getFillAmount() {
		return taxactionDet101.getFillAmount().setScale(0,BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getNationRate() {
		return taxactionDet101.getNationRate().setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getLocalRate() {
		return taxactionDet101.getLocalRate().setScale(0,BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getIntRate() {
		return taxactionDet101.getIntRate().setScale(0,BigDecimal.ROUND_HALF_UP);
	}

	public void setId(Integer id) {
		taxactionDet101.setId(id);
	}

	public void setTaxYear(String taxYear) {
		taxactionDet101.setTaxYear(taxYear);
	}


	public void setTaxMonth(String taxMonth) {
		taxactionDet101.setTaxMonth(taxMonth);
	}

	public void setNationTax(BigDecimal nationTax) {
		taxactionDet101.setNationTax(nationTax);
	}
	public void setFinancialCheck(String financialCheck){
		taxactionDet101.setFinancialCheck(financialCheck);
	}
	
	public void setFinancial(BigDecimal financial){
		taxactionDet101.setFinancial(financial);
	}
	
	public void setIntTax(BigDecimal intTax) {
		taxactionDet101.setIntTax(intTax);
	}	
	
	public void setFillAmount(BigDecimal fillAmount) {
		taxactionDet101.setFillAmount(fillAmount);
	}	
	
	public void setNationRate(BigDecimal nationRate) {
		taxactionDet101.setNationRate(nationRate);
	}
	
	public void setLocalRate(BigDecimal localRate) {
		taxactionDet101.setLocalRate(localRate);
	}	
	
	public void setIntRate(BigDecimal intRate) {
		taxactionDet101.setIntRate(intRate);
	}	

}
