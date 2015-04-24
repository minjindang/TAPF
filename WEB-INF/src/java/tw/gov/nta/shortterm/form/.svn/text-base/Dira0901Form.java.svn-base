/**
 * @author Andrew Sung
 * @create 2006/4/13
 */

package tw.gov.nta.shortterm.form;

import gov.dnt.tame.common.SupportForm;

public class Dira0901Form extends SupportForm
{
	private static final long serialVersionUID = 1L;

	private String startAccountYear;
	private String endAccountYear;
	private Integer budgetCode;
	private Integer debtCode;
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
	public String getEndAccountYear()
	{
		return endAccountYear;
	}
	public void setEndAccountYear(String endAccountYear)
	{
		if(endAccountYear.length()==1)
			endAccountYear = "00"+endAccountYear;
		if(endAccountYear.length()==2)
			endAccountYear = "0"+endAccountYear;
		this.endAccountYear = endAccountYear;
	}
	public String getStartAccountYear()
	{
		return startAccountYear;
	}
	public void setStartAccountYear(String startAccountYear)
	{
		if(startAccountYear.length()==1)
			startAccountYear = "00"+startAccountYear;
		if(startAccountYear.length()==2)
			startAccountYear = "0"+startAccountYear;
		this.startAccountYear = startAccountYear;
	}
	
}
