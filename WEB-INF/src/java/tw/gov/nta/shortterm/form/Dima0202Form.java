/**
 * @author AndrewSung
 * @date 2006/3/7
 */

package tw.gov.nta.shortterm.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.InterestAdjustMain;
import tw.gov.nta.sql.debt.IssueMain;
public class Dima0202Form extends Dima0201Form
{
	private static final long serialVersionUID = 1L;
	DebtMain debtMain = new DebtMain();
	private BigDecimal allAmount;
	private Integer bankId;
	private String debtName;
	private Date issueDate;
	private Date dueDate;
	private String AccountYear;
	
	public String getAccountYear() {
		return AccountYear;
	}

	public void setAccountYear(String accountYear) {
		AccountYear = accountYear;
	}

	public String getDebtName() {
		return debtName;
	}

	public void setDebtName(String debtName) {
		this.debtName = debtName;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Integer getBankId()
	{
		return bankId;
	}

	public void setBankId(Integer bankId)
	{
		this.bankId = bankId;
	}

	public BigDecimal getAllAmount()
	{
		return allAmount;
	}

	public void setAllAmount(BigDecimal allAmount)
	{
		this.allAmount = allAmount;
	}
	public DebtMain getDebtMain()
	{
		return debtMain;
	}

	public void setDebtMain(DebtMain debtMain)
	{
		
		this.debtMain = debtMain;
	}

	public String getAccrue()
	{
		return debtMain.getAccrue();
	}

	public Date getAccrueDate()
	{
		return debtMain.getAccrueDate();
	}

	public BankRef getBank()
	{
		return debtMain.getBank();
	}

	public Integer getBudgetCode()
	{
		return debtMain.getBudgetCode();
	}

	public BigDecimal getCompareAmount()
	{
		return debtMain.getCompareAmount();
	}

	public BigDecimal getCompareRate()
	{
		return debtMain.getCompareRate();
	}

	public Integer getDebtCode()
	{
		return debtMain.getDebtCode();
	}

	public Set<DebtPlanDet> getDebtPlanDets()
	{
		return debtMain.getDebtPlanDets();
	}

	public Set<DebtRateDet> getDebtRateDets()
	{
		return debtMain.getDebtRateDets();
	}

	public Integer getId()
	{
		return debtMain.getId();
	}

	public Set<InterestAdjustMain> getInterestAdjustMains()
	{
		return debtMain.getInterestAdjustMains();
	}

	public IssueMain getIssue()
	{
		return debtMain.getIssue();
	}

	public BigDecimal getIssueAmount()
	{
		return debtMain.getIssueAmount();
	}

	public BigDecimal getOriginInterestAmount()
	{
		return debtMain.getOriginInterestAmount();
	}

	public BigDecimal getRealAmount()
	{
		return debtMain.getRealAmount();
	}

	public void setAccrue(String accrue)
	{
		debtMain.setAccrue(accrue);
	}

	public void setAccrueDate(Date accrueDate)
	{
		debtMain.setAccrueDate(accrueDate);
	}

	public void setBank(BankRef bank)
	{
		debtMain.setBank(bank);
	}

	public void setBudgetCode(Integer budgetCode)
	{
		debtMain.setBudgetCode(budgetCode);
	}

	public void setCompareAmount(BigDecimal compareAmount)
	{
		debtMain.setCompareAmount(compareAmount);
	}

	public void setCompareRate(BigDecimal compareRate)
	{
		debtMain.setCompareRate(compareRate);
	}

	public void setDebtCode(Integer debtCode)
	{
		debtMain.setDebtCode(debtCode);
	}

	public void setDebtPlanDets(Set<DebtPlanDet> debtPlanDets)
	{
		debtMain.setDebtPlanDets(debtPlanDets);
	}

	public void setDebtRateDets(Set<DebtRateDet> debtRateDets)
	{
		debtMain.setDebtRateDets(debtRateDets);
	}

	public void setId(Integer id)
	{
		debtMain.setId(id);
	}

	public void setInterestAdjustMains(Set<InterestAdjustMain> interestAdjustMains)
	{
		debtMain.setInterestAdjustMains(interestAdjustMains);
	}

	public void setIssue(IssueMain issue)
	{
		debtMain.setIssue(issue);
	}

	public void setIssueAmount(BigDecimal issueAmount)
	{
		debtMain.setIssueAmount(issueAmount);
	}

	public void setOriginInterestAmount(BigDecimal originInterestAmount)
	{
		debtMain.setOriginInterestAmount(originInterestAmount);
	}

	public void setRealAmount(BigDecimal realAmount)
	{
		debtMain.setRealAmount(realAmount);
	}

	public String getRemark() {
		return debtMain.getRemark();
	}

	public void setRemark(String remark) {
		debtMain.setRemark(remark);
	}

	public String getBudgetYear() {
		return debtMain.getBudgetYear();
	}

	public void setBudgetYear(String budgetYear) {
		if(budgetYear.equals("on"))
			debtMain.setBudgetYear("Y");
		else
			debtMain.setBudgetYear("N");
	}
	
	
}
