/**
 * @author AndrewSung
 * @date 2006/3/8
 */

package tw.gov.nta.system.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.CentralStatisticsMain;
import tw.gov.nta.sql.dao.BudgetRefDAO;
public class Gama0301Form extends SupportForm
{
	private static final long serialVersionUID = 1L;

	CentralStatisticsMain csMain = new CentralStatisticsMain();
	
	private String qryAccountYear;
	private Integer qryBudgetCode;
	private Integer qryDebtCode;
	private String qryDebtType;
	private String qryBoundCode;
	private boolean qryDebt;
	private String qryAccountKind;
	private String budgetName;
	
	public String getBudgetName()
	{
		return budgetName;
	}

	public void setBudgetName(Integer id)
	{
		System.out.println(id);
		BudgetRef dto = new BudgetRef ();
		BudgetRefDAO dao = new BudgetRefDAO();
		dto=dao.get(new Integer(id));
		this.budgetName = dto.getBudgetName();
	}

	public String getQryAccountKind()
	{
		return qryAccountKind;
	}

	public void setQryAccountKind(String qryAccountKind)
	{
		this.qryAccountKind = qryAccountKind;
	}

	public String getQryAccountYear()
	{
		return qryAccountYear;
	}

	public void setQryAccountYear(String qryAccountYear)
	{
		this.qryAccountYear = qryAccountYear;
	}

	public String getQryBoundCode()
	{
		return qryBoundCode;
	}

	public void setQryBoundCode(String qryBoundCode)
	{
		this.qryBoundCode = qryBoundCode;
	}

	public Integer getQryBudgetCode()
	{
		return qryBudgetCode;
	}

	public void setQryBudgetCode(Integer qryBudgetCode)
	{
		this.qryBudgetCode = qryBudgetCode;
	}

	public Integer getQryDebtCode()
	{
		return qryDebtCode;
	}

	public void setQryDebtCode(Integer qryDebtCode)
	{
		this.qryDebtCode = qryDebtCode;
	}

	public String getQryDebtType()
	{
		return qryDebtType;
	}

	public void setQryDebtType(String qryDebtType)
	{
		this.qryDebtType = qryDebtType;
	}

	public boolean isQrysDebt()
	{
		return qryDebt;
	}

	public void setQryDebt(boolean qryDebt)
	{
		this.qryDebt = qryDebt;
	}

	public CentralStatisticsMain getCsMain()
	{
		return csMain;
	}

	public void setCsMain(CentralStatisticsMain csMain)
	{
		this.csMain = csMain;
	}

	public String getAccountKind()
	{
		return csMain.getAccountKind();
	}

	public String getAccountYear()
	{
		return csMain.getAccountYear();
	}

	public String getBoundCode()
	{
		return csMain.getBoundCode();
	}

	public Integer getBudgetCode()
	{
		return csMain.getBudgetCode();
	}

	public Integer getDebtCode()
	{
		return csMain.getDebtCode();
	}

	public String getDebtType()
	{
		return csMain.getDebtType();
	}

	public Integer getId()
	{
		return csMain.getId();
	}

	public BigDecimal getInterestAmount()
	{
		return csMain.getInterestAmount();
	}

	public BigDecimal getIssueAmount()
	{
		return csMain.getIssueAmount();
	}

	public BigDecimal getPayAmount()
	{
		return csMain.getPayAmount();
	}

	public BigDecimal getRemainAmount()
	{
		return csMain.getRemainAmount();
	}

	public boolean isAccount()
	{
		return csMain.isAccount();
	}

	public boolean isDebt()
	{
		return csMain.isDebt();
	}

	public void setAccount(boolean account)
	{
		csMain.setAccount(account);
	}

	public void setAccountKind(String accountKind)
	{
		csMain.setAccountKind(accountKind);
	}

	public void setAccountYear(String accountYear)
	{
		csMain.setAccountYear(accountYear);
	}

	public void setBoundCode(String boundCode)
	{
		csMain.setBoundCode(boundCode);
	}

	public void setBudgetCode(Integer budgetCode)
	{
		csMain.setBudgetCode(budgetCode);
	}

	public void setDebt(boolean debt)
	{
		csMain.setDebt(debt);
	}

	public void setDebtCode(Integer debtCode)
	{
		csMain.setDebtCode(debtCode);
	}

	public void setDebtType(String debtType)
	{
		csMain.setDebtType(debtType);
	}

	public void setId(Integer id)
	{
		csMain.setId(id);
	}

	public void setInterestAmount(BigDecimal interestAmount)
	{
		csMain.setInterestAmount(interestAmount);
	}

	public void setIssueAmount(BigDecimal issueAmount)
	{
		csMain.setIssueAmount(issueAmount);
	}

	public void setPayAmount(BigDecimal payAmount)
	{
		csMain.setPayAmount(payAmount);
	}

	public void setRemainAmount(BigDecimal remainAmount)
	{
		csMain.setRemainAmount(remainAmount);
	}

	public String getYearKind() {
		return csMain.getYearKind();
	}

	public void setYearKind(String yearKind) {
		csMain.setYearKind(yearKind);
	}
	
}
