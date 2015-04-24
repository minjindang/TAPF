/**
 * @author Andrew Sung
 * @create 2006/4/13
 */

package tw.gov.nta.shortterm.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Dira0701Form extends SupportForm
{
	private static final long serialVersionUID = 1L;

	private String accountYear;
	private String begAccYear;
	private String endAccYear;
	private String startSerial;
	private String endSerial;
	private Date startDate;
	private Date endDate;
	private Integer budgetCode;
	private Integer debtCode;
	private Date dueDate;
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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
	public Date getEndDate()
	{
		return endDate;
	}
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
	public String getEndSerial()
	{
		return endSerial;
	}
	public void setEndSerial(String endSerial)
	{
		this.endSerial = endSerial;
	}
	public Date getStartDate()
	{
		return startDate;
	}
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}
	public String getStartSerial()
	{
		return startSerial;
	}
	public void setStartSerial(String startSerial)
	{
		this.startSerial = startSerial;
	}
	public String getBegAccYear() {
		return begAccYear;
	}
	public void setBegAccYear(String begAccYear) {
		this.begAccYear = begAccYear;
	}
	public String getEndAccYear() {
		return endAccYear;
	}
	public void setEndAccYear(String endAccYear) {
		this.endAccYear = endAccYear;
	}
	
}
