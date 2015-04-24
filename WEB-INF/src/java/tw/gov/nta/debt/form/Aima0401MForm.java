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

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueMain;

public class Aima0401MForm extends SupportForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4662656355648024946L;
	IssueMain issueMain = new IssueMain();
	DebtMain debtMain = new DebtMain();
	public String getDebtName() {
		return issueMain.getDebtName();
	}
	public BigDecimal getIssueAmount() {
		return issueMain.getIssueAmount();
	}
	public Date getIssueDate() {
		return issueMain.getIssueDate();
	}
	public String getIssueSerial() {
		return issueMain.getIssueSerial();
	}
	public void setDebtName(String debtName) {
		issueMain.setDebtName(debtName);
	}
	public void setIssueMainId(Integer id) {
		if(id == null) return;
		if(issueMain == null || issueMain.getId() == null || issueMain.getId().intValue() != id.intValue()){
			IssueMain tIssueMain = new IssueManager().getBean(id);  
			if(tIssueMain != null)
				setIssueMain(tIssueMain);
		}
	}
	public void setIssueAmount(BigDecimal issueAmount) {
		issueMain.setIssueAmount(issueAmount);
	}
	public void setIssueDate(Date issueDate) {
		issueMain.setIssueDate(issueDate);
	}
	public void setIssueSerial(String issueSerial) {
		issueMain.setIssueSerial(issueSerial);
	}
	public DebtMain getDebtMain() {
		return debtMain;
	}
	public void setDebtMain(DebtMain debtMain) {
		this.debtMain = debtMain;
	}
	public IssueMain getIssueMain() {
		return issueMain;
	}
	public void setIssueMain(IssueMain issueMain) {
		this.issueMain = issueMain;
	}
	public BigDecimal getDiversityAmount() {
		return debtMain.getDiversityAmount();
	}
	public BigDecimal getRealAmount() {
		return debtMain.getRealAmount();
	}
	public void setDiversityAmount(BigDecimal diversityAmount) {
		debtMain.setDiversityAmount(diversityAmount);
	}
	public void setRealAmount(BigDecimal realAmount) {
		debtMain.setRealAmount(realAmount);
	}
	public Integer getBudgetCode() {
		return debtMain.getBudgetCode();
	}
	public Integer getDebtCode() {
		return debtMain.getDebtCode();
	}
	public void setBudgetCode(Integer budgetCode) {
		debtMain.setBudgetCode(budgetCode);
	}
	public void setDebtCode(Integer debtCode) {
		debtMain.setDebtCode(debtCode);
	}
	public Integer getIssueMainId() {
		return issueMain.getId();
	}
	public Integer getDebtId() {
		return debtMain.getId();
	}
	public void setDebtId(Integer id) {
		if(id == null) return;
		if(debtMain == null || debtMain.getId() == null || debtMain.getId().intValue() != id.intValue()){
			DebtMain tDebtMain = new DebtManager().getBean(id);  
			if(tDebtMain != null)
				setDebtMain(tDebtMain);
		}
	}
}