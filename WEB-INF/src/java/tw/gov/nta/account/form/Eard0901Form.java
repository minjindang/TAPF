/**
 * @author Andrew Sung
 * @create 2006/4/21
 */

package tw.gov.nta.account.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

@SuppressWarnings({"unused","serial"})
public class Eard0901Form extends SupportForm
{
	private String debtType;
	private Integer budgetCode;
	private Integer debtCode;
	private Date startIssueDate;
	private Date endIssueDate;
	private Date startDueDate;
	private Date endDueDate;
	private String accountYear;
	private String issueSeries;
	private String debtName;
	private String reportType;
	
	public String getReportType()
	{
		return reportType;
	}
	public void setReportType(String reportType)
	{
		this.reportType = reportType;
	}
	public String getAccountYear()
	{
		return accountYear;
	}
	public void setAccountYear(String accountYear)
	{
		this.accountYear = accountYear;
	}
	public Integer getBudgetCode()
	{
		return budgetCode;
	}
	public void setBudgetCode(Integer budgetCode)
	{
		this.budgetCode = budgetCode;
	}
	public Integer getDebtCode()
	{
		return debtCode;
	}
	public void setDebtCode(Integer debtCode)
	{
		this.debtCode = debtCode;
	}
	public String getDebtName()
	{
		return debtName;
	}
	public void setDebtName(String debtName)
	{
		this.debtName = debtName;
	}
	public String getDebtType()
	{
		return debtType;
	}
	public void setDebtType(String debtType)
	{
		this.debtType = debtType;
	}
	public Date getEndDueDate()
	{
		return endDueDate;
	}
	public void setEndDueDate(Date endDueDate)
	{
		this.endDueDate = endDueDate;
	}
	public Date getEndIssueDate()
	{
		return endIssueDate;
	}
	public void setEndIssueDate(Date endIssueDate)
	{
		this.endIssueDate = endIssueDate;
	}
	public String getIssueSeries()
	{
		return issueSeries;
	}
	public void setIssueSeries(String issueSeries)
	{
		this.issueSeries = issueSeries;
	}
	public Date getStartDueDate()
	{
		return startDueDate;
	}
	public void setStartDueDate(Date startDueDate)
	{
		this.startDueDate = startDueDate;
	}
	public Date getStartIssueDate()
	{
		return startIssueDate;
	}
	public void setStartIssueDate(Date startIssueDate)
	{
		this.startIssueDate = startIssueDate;
	}
	
}
