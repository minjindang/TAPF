package tw.gov.nta.surplusage.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;

import tw.gov.nta.sql.debt.Gara04Temp;

public class Gama0701Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String qryAccountYear;
	private Gara04Temp Gara04Temp = new Gara04Temp();
	
	public Gara04Temp getGara04Temp() {
		return Gara04Temp;
	}
	
	public void setGara04Temp(Gara04Temp gara04Temp) {
		Gara04Temp = gara04Temp;
	}
	
	public Integer getId() {
		return Gara04Temp.getId();
	}
	
	public void setId(Integer id) {
		Gara04Temp.setId(id);
	}
	
	public String getAccountYear() {
		return Gara04Temp.getAccountYear();
	}
	
	public void setAccountYear(String accountYear) {
		accountYear=accountYear.trim();
		if (accountYear.length() < 3 && !"".equals(accountYear)){
			for (int i = 0 ; i < 3-accountYear.length() ; i++){
				accountYear = "0" + accountYear;
			}	
		}
		Gara04Temp.setAccountYear(accountYear);
	}
	
	public BigDecimal getBudgetAmount() {
		return Gara04Temp.getBudgetCapital();
	}
	
	public void setBudgetAmount(BigDecimal budgetAmount) {
		Gara04Temp.setBudgetCapital(budgetAmount);
	}
	
	public BigDecimal getFundationAmount() {
		return Gara04Temp.getFundationCapital();
	}
	
	public void setFundationAmount(BigDecimal fundationAmount) {
		Gara04Temp.setFundationCapital(fundationAmount);
	}
	
	public BigDecimal getInterestAmount() {
		return Gara04Temp.getInterestPayed();
	}
	
	public void setInterestAmount(BigDecimal interestAmount) {
		Gara04Temp.setInterestPayed(interestAmount);
	}
	
	public BigDecimal getYearAmount() {
		return Gara04Temp.getYearAmount();
	}
	
	public void setYearAmount(BigDecimal yearAmount) {
		Gara04Temp.setYearAmount(yearAmount);
	}
	
	public String getQryAccountYear() {
		return qryAccountYear;
	}
	
	public void setQryAccountYear(String qryAccountYear) {
		qryAccountYear=qryAccountYear.trim();
		if (qryAccountYear.length() < 3 && !"".equals(qryAccountYear)){
			for (int i = 0 ; i < 3-qryAccountYear.length() ; i++){
				qryAccountYear = "0" + qryAccountYear;
			}	
		}
		this.qryAccountYear = qryAccountYear;
	}
}
