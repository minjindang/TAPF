/**
 * @author Andrew Sung
 * @create 2006/3/28
 */

package tw.gov.nta.exchequer.form;

import java.math.BigDecimal;
import java.util.Date;

import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;

public class Bima0202Form extends Bima0201Form
{
	private static final long serialVersionUID = 1L;

	IssueTicketDet issueTicketDet = new IssueTicketDet();
	public IssueTicketDet getIssueTicketDet()
	{
		return issueTicketDet;
	}

	public void setIssueTicketDet(IssueTicketDet issueTicketDet)
	{
		this.issueTicketDet = issueTicketDet;
	}

	public Integer getId()
	{
		return issueTicketDet.getId();
	}

	public IssueMain getIssue()
	{
		return issueTicketDet.getIssue();
	}

	public Date getModDate()
	{
		return issueTicketDet.getModDate();
	}

	public BigDecimal getTicketAmount()
	{
		return issueTicketDet.getTicketAmount();
	}

	public Long getTicketCount()
	{
		return issueTicketDet.getTicketCount();
	}

	public String getTicketName()
	{
		return issueTicketDet.getTicketName();
	}

	public String getUserid()
	{
		return issueTicketDet.getUserid();
	}

	public void setId(Integer id)
	{
		issueTicketDet.setId(id);
	}

	public void setIssue(IssueMain issue)
	{
		issueTicketDet.setIssue(issue);
	}

	public void setModDate(Date modDate)
	{
		issueTicketDet.setModDate(modDate);
	}

	public void setTicketAmount(BigDecimal ticketAmount)
	{
		issueTicketDet.setTicketAmount(ticketAmount);
	}

	public void setTicketCount(Long ticketCount)
	{
		issueTicketDet.setTicketCount(ticketCount);
	}

	public void setTicketName(String ticketName)
	{
		issueTicketDet.setTicketName(ticketName);
	}

	public void setUserid(String userid)
	{
		issueTicketDet.setUserid(userid);
	}
	public void clean()
	{
		issueTicketDet = new IssueTicketDet();
	}
}
