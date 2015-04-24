package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;
import java.math.BigDecimal;
import java.util.Date;
import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.system.common.BudgetCodeManager;
import tw.gov.nta.system.common.DebitCodeManage;

public class Aima0202MForm extends SupportForm
{
	private static final long serialVersionUID = 1L;

	private IssueMain issueMain = new IssueMain();
	private DebtMain debtMain = new DebtMain();
	private BigDecimal repayInterestAmount;
	private String debitCodeName;
	private String budgetCodeName;
	private BigDecimal advanceAmount;		//提前買回本金
	private BigDecimal advanceRate;			//提前買回最低得標利率
	private Date advanceDate;				//提前買回日期
	private BigDecimal advanceInterest;		//應付利息
	private BigDecimal buyAmount;			//買回價款
	private BigDecimal advanceTax;			//應扣累計稅款
	private BigDecimal finalAmount;			//稅後買進金額
	private BigDecimal buyPremium;			//買回溢(折)價
	
	public BigDecimal getBuyPremium() {
		return buyPremium;
	}
	public void setBuyPremium(BigDecimal buyPremium) {
		this.buyPremium = buyPremium;
	}
	public BigDecimal getRepayInterestAmount() {
		return repayInterestAmount;
	}
	public void setRepayInterestAmount(BigDecimal repayInterestAmount) {
		this.repayInterestAmount = repayInterestAmount;
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
	public Integer getIssueMainId() {
		return issueMain.getId();
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
	public String getDebtName() {
		return issueMain.getDebtName();
	}
	public void setDebtName(String debtName) {
		issueMain.setDebtName(debtName);
	}
	public Integer getBudgetCode() {
		return debtMain.getBudgetCode();
	}
	public Integer getDebtCode() {
		return debtMain.getDebtCode();
	}
	public Integer getDebtId() {
		return debtMain.getId();
	}
	public BigDecimal getIssueAmountx() {
		return debtMain.getIssueAmount();
	}
	public void setBudgetCode(Integer budgetCode) {
		debtMain.setBudgetCode(budgetCode);
	}
	public void setDebtCode(Integer debtCode) {
		debtMain.setDebtCode(debtCode);
	}
	public void setDebtId(Integer id) {
		debtMain.setId(id);
	}
	public void setIssueAmountx(BigDecimal issueAmount) {
		debtMain.setIssueAmount(issueAmount);
	}
	public BigDecimal getRealAmount() {
		return debtMain.getRealAmount();
	}
	public void setRealAmount(BigDecimal realAmount) {
		debtMain.setRealAmount(realAmount);
	}	
	public BigDecimal getDiversityAmount () {
		return debtMain.getDiversityAmount();
	}
	public void setDiversityAmount (BigDecimal diversityAmount) {
		debtMain.setDiversityAmount(diversityAmount);
	}
	public BigDecimal getIssueCostAmount () {
		return debtMain.getIssueCostAmount();
	}
	public void setIssueCostAmount (BigDecimal issueCostAmount) {
		debtMain.setIssueCostAmount(issueCostAmount);
	}
	public String getDebitCodeName() {
		return new DebitCodeManage().findDebitName(debtMain.getDebtCode());
	}
	public String getBudgetCodeName() {
		return new BudgetCodeManager().findBudgetName(debtMain.getBudgetCode());
	}
	public BigDecimal getAdvanceAmount() {
		return advanceAmount;
	}
	public void setAdvanceAmount(BigDecimal advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	public Date getAdvanceDate() {
		return advanceDate;
	}
	public void setAdvanceDate(Date advanceDate) {
		this.advanceDate = advanceDate;
	}
	public BigDecimal getAdvanceInterest() {
		return advanceInterest;
	}
	public void setAdvanceInterest(BigDecimal advanceInterest) {
		this.advanceInterest = advanceInterest;
	}
	public BigDecimal getAdvanceRate() {
		return advanceRate;
	}
	public void setAdvanceRate(BigDecimal advanceRate) {
		this.advanceRate = advanceRate;
	}
	public BigDecimal getAdvanceTax() {
		return advanceTax;
	}
	public void setAdvanceTax(BigDecimal advanceTax) {
		this.advanceTax = advanceTax;
	}
	public BigDecimal getBuyAmount() {
		return buyAmount;
	}
	public void setBuyAmount(BigDecimal buyAmount) {
		this.buyAmount = buyAmount;
	}
	public BigDecimal getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
	}
	
}