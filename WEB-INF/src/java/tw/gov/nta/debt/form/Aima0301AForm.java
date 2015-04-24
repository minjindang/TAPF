/*
程式目的：AIMA01文字
程式代號：AIMA01
程式日期：0950306
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueExchangeDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;
import tw.gov.nta.sql.debt.dao.IssueExchangeDetDAO;

public class Aima0301AForm extends SupportForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 480800375095837531L;
	IssueMain issueMain = new IssueMain();
	IssueExchangeDet issueExchangeDet = new IssueExchangeDet();

	public IssueMain getIssueMain() {
		return issueMain;
	}

	public void setIssueMain(IssueMain issueMain) {
		this.issueMain = issueMain;
	}

	public String getAccountYear() {
		return issueMain.getAccountYear();
	}

	public BigDecimal getAverageRate() {
		return issueMain.getAverageRate();
	}

	public String getBondKind() {
		return issueMain.getBondKind();
	}

	public String getBondSellStatus() {
		return issueMain.getBondSellStatus();
	}

	public String getBondType() {
		return issueMain.getBondType();
	}

	public Integer getBudgetCode() {
		return issueMain.getBudgetCode();
	}

	public BigDecimal getCapitalAmount() {
		return issueMain.getCapitalAmount();
	}

	public Date getCashDueDate() {
		return issueMain.getCashDueDate();
	}

	public BigDecimal getChargeRate() {
		return issueMain.getChargeRate();
	}

	public Integer getDebtCode() {
		return issueMain.getDebtCode();
	}

	public Set<DebtMain> getDebtMains() {
		return issueMain.getDebtMains();
	}

	public String getDebtName() {
		return issueMain.getDebtName();
	}

	public String getDebtType() {
		return issueMain.getDebtType();
	}

	public Date getDueDate() {
		return issueMain.getDueDate();
	}

	public BigDecimal getExpectAmount() {
		return issueMain.getExpectAmount();
	}

	public Date getFirstInterestDate() {
		return issueMain.getFirstInterestDate();
	}

	public Date getFirstRepayDate() {
		return issueMain.getFirstRepayDate();
	}

	public Integer getIssueMainId() {
		return issueMain.getId();
	}

	public Integer getInterestAlternate() {
		return issueMain.getInterestAlternate();
	}

	public BigDecimal getInterestAmount() {
		return issueMain.getInterestAmount();
	}

	public BigDecimal getIssueAmount() {
		return issueMain.getIssueAmount();
	}

	public Date getIssueDate() {
		return issueMain.getIssueDate();
	}

	public Integer getIssueInterval() {
		return issueMain.getIssueInterval();
	}

	public String getIssueKind() {
		return issueMain.getIssueKind();
	}

	public String getIssueSerial() {
		return issueMain.getIssueSerial();
	}

	public Date getModDate() {
		return issueMain.getModDate();
	}

	public Integer getPayLimit() {
		return issueMain.getPayLimit();
	}

	public String getRateKind() {
		return issueMain.getRateKind();
	}

	public String getRemark() {
		return issueMain.getRemark();
	}

	public Integer getRepayAlternate() {
		return issueMain.getRepayAlternate();
	}

	public BigDecimal getSellAmount() {
		return issueMain.getSellAmount();
	}

	public String getSellStatus() {
		return issueMain.getSellStatus();
	}

	public String getSerialNo() {
		return issueMain.getSerialNo();
	}

	public String getShowType() {
		return issueMain.getShowType();
	}

	public Integer getSourceIssueId() {
		return issueMain.getSourceIssueId();
	}

	public void setAccountYear(String accountYear) {
		issueMain.setAccountYear(accountYear);
	}

	public void setAverageRate(BigDecimal averageRate) {
		issueMain.setAverageRate(averageRate);
	}

	public void setBondKind(String bondKind) {
		issueMain.setBondKind(bondKind);
	}

	public void setBondSellStatus(String bondSellStatus) {
		issueMain.setBondSellStatus(bondSellStatus);
	}

	public void setBondType(String bondType) {
		issueMain.setBondType(bondType);
	}

	public void setBudgetCode(Integer budgetCode) {
		issueMain.setBudgetCode(budgetCode);
	}

	public void setCapitalAmount(BigDecimal capitalAmount) {
		issueMain.setCapitalAmount(capitalAmount);
	}

	public void setCashDueDate(Date cashDueDate) {
		issueMain.setCashDueDate(cashDueDate);
	}

	public void setChargeRate(BigDecimal chargeRate) {
		issueMain.setChargeRate(chargeRate);
	}

	public void setDebtCode(Integer debtCode) {
		issueMain.setDebtCode(debtCode);
	}

	public void setDebtMains(Set<DebtMain> debtMains) {
		issueMain.setDebtMains(debtMains);
	}

	public void setDebtName(String debtName) {
		issueMain.setDebtName(debtName);
	}

	public void setDebtType(String debtType) {
		issueMain.setDebtType(debtType);
	}

	public void setDueDate(Date dueDate) {
		issueMain.setDueDate(dueDate);
	}

	public void setExpectAmount(BigDecimal expectAmount) {
		issueMain.setExpectAmount(expectAmount);
	}

	public void setFirstInterestDate(Date firstInterestDate) {
		issueMain.setFirstInterestDate(firstInterestDate);
	}

	public void setFirstRepayDate(Date firstRepayDate) {
		issueMain.setFirstRepayDate(firstRepayDate);
	}

	public void setIssueMainId(Integer id) {
		if(id == null) return;
		if(issueMain == null || issueMain.getId() == null || issueMain.getId().intValue() != id.intValue()){
			IssueMain tIssueMain = new IssueManager().getBean(id);
			if(tIssueMain != null)
				setIssueMain(tIssueMain);
		}
	}

	public void setInterestAlternate(Integer interestAlternate) {
		issueMain.setInterestAlternate(interestAlternate);
	}

	public void setInterestAmount(BigDecimal interestAmount) {
		issueMain.setInterestAmount(interestAmount);
	}

	public void setIssueAmount(BigDecimal issueAmount) {
		issueMain.setIssueAmount(issueAmount);
	}

	public void setIssueDate(Date issueDate) {
		issueMain.setIssueDate(issueDate);
	}

	public void setIssueInterval(Integer issueInterval) {
		issueMain.setIssueInterval(issueInterval);
	}

	public void setIssueKind(String issueKind) {
		issueMain.setIssueKind(issueKind);
	}

	public void setIssueSerial(String issueSerial) {
		issueMain.setIssueSerial(issueSerial);
	}

	public void setIssueTicketDets(Set<IssueTicketDet> issueTicketDets) {
		issueMain.setIssueTicketDets(issueTicketDets);
	}

	public void setModDate(Date modDate) {
		issueMain.setModDate(modDate);
	}

	public void setPayLimit(Integer payLimit) {
		issueMain.setPayLimit(payLimit);
	}

	public void setRateKind(String rateKind) {
		issueMain.setRateKind(rateKind);
	}

	public void setRemark(String remark) {
		issueMain.setRemark(remark);
	}

	public void setRepayAlternate(Integer repayAlternate) {
		issueMain.setRepayAlternate(repayAlternate);
	}

	public void setSellAmount(BigDecimal sellAmount) {
		issueMain.setSellAmount(sellAmount);
	}

	public void setSellStatus(String sellStatus) {
		issueMain.setSellStatus(sellStatus);
	}

	public void setSerialNo(String serialNo) {
		issueMain.setSerialNo(serialNo);
	}

	public void setShowType(String showType) {
		issueMain.setShowType(showType);
	}

	public void setSourceIssueId(Integer sourceIssueId) {
		issueMain.setSourceIssueId(sourceIssueId);
	}

	public IssueExchangeDet getIssueExchangeDet() {
		return issueExchangeDet;
	}

	public void setIssueExchangeDet(IssueExchangeDet issueExchangeDet) {
		this.issueExchangeDet = issueExchangeDet;
	}

	public BigDecimal getBackRate() {
		return issueExchangeDet.getBackRate();
	}

	public Integer getBankCode() {
		return issueExchangeDet.getBankCode();
	}

	public BigDecimal getExchangeAmount() {
		return issueExchangeDet.getExchangeAmount();
	}

	public BigDecimal getExchangeLessAmount() {
		return issueExchangeDet.getExchangeLessAmount();
	}

	public BigDecimal getExchangeStockAmount() {
		return issueExchangeDet.getExchangeStockAmount();
	}

	public Integer getExchangeStockCode() {
		return issueExchangeDet.getExchangeStockCode();
	}

	public BigDecimal getForeignCapital() {
		return issueExchangeDet.getForeignCapital();
	}

	public BigDecimal getGetPrice() {
		return issueExchangeDet.getGetPrice();
	}

	public Integer getIssueExchangeId() {
		return issueExchangeDet.getId();
	}

	public BigDecimal getLiberateStockAmount() {
		return issueExchangeDet.getLiberateStockAmount();
	}

	public BigDecimal getOriginalPrice() {
		return issueExchangeDet.getOriginalPrice();
	}

	public BigDecimal getSaleRate() {
		return issueExchangeDet.getSaleRate();
	}

	public BigDecimal getTotalStockAmount() {
		return issueExchangeDet.getTotalStockAmount();
	}

	public void setBackRate(BigDecimal backRate) {
		issueExchangeDet.setBackRate(backRate);
	}

	public void setBankCode(Integer bankCode) {
		issueExchangeDet.setBankCode(bankCode);
	}

	public void setExchangeAmount(BigDecimal exchangeAmount) {
		issueExchangeDet.setExchangeAmount(exchangeAmount);
	}

	public void setExchangeLessAmount(BigDecimal exchangeLessAmount) {
		issueExchangeDet.setExchangeLessAmount(exchangeLessAmount);
	}

	public void setExchangeStockAmount(BigDecimal exchangeStockAmount) {
		issueExchangeDet.setExchangeStockAmount(exchangeStockAmount);
	}

	public void setExchangeStockCode(Integer exchangeStockCode) {
		issueExchangeDet.setExchangeStockCode(exchangeStockCode);
	}

	public void setForeignCapital(BigDecimal foreignCapital) {
		issueExchangeDet.setForeignCapital(foreignCapital);
	}

	public void setGetPrice(BigDecimal getPrice) {
		issueExchangeDet.setGetPrice(getPrice);
	}

	public void setIssueExchangeId(Integer id) {
		if(id == null) return;
		if(issueExchangeDet == null || issueExchangeDet.getId() == null || issueExchangeDet.getId().intValue() != id.intValue()){
			IssueExchangeDet tIssueExchangeDet = new IssueExchangeDetDAO().get(id);  
			if(tIssueExchangeDet != null)
				setIssueExchangeDet(tIssueExchangeDet);
		}
	}

	public void setLiberateStockAmount(BigDecimal liberateStockAmount) {
		issueExchangeDet.setLiberateStockAmount(liberateStockAmount);
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		issueExchangeDet.setOriginalPrice(originalPrice);
	}

	public void setSaleRate(BigDecimal saleRate) {
		issueExchangeDet.setSaleRate(saleRate);
	}

	public void setTotalStockAmount(BigDecimal totalStockAmount) {
		issueExchangeDet.setTotalStockAmount(totalStockAmount);
	}
	
	public void setLessCapitalAmount(BigDecimal pAmount){
		
	}
	
	public BigDecimal getLessCapitalAmount(){
		return issueMain.getIssueAmount().subtract(issueMain.getCapitalAmount());
	}
	
	
}