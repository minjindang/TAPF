package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;

public class Earc0401Form extends SupportForm 
{
	private static final long serialVersionUID = 1L;

	private String startIssueDate;
	private String endIssueDate;
	
	public String getEndIssueDate() 
	{
		return endIssueDate;
	}
	public void setEndIssueDate(String endIssueDate) 
	{
		this.endIssueDate = endIssueDate;
	}
	public String getStartIssueDate() 
	{
		return startIssueDate;
	}
	public void setStartIssueDate(String startIssueDate) 
	{
		this.startIssueDate = startIssueDate;
	}
}
