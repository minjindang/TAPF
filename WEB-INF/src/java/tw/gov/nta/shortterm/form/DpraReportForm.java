/**
 * @author Andrew Sung
 * @create 2006/4/14
 */

package tw.gov.nta.shortterm.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class DpraReportForm extends SupportForm
{
	private static final long serialVersionUID = 1L;

	//this FormBean use for DPRA02 and DPRA03
	private String issueSerial;
	private String title;
	private Integer issueId;
	private Date payDate;
	private Date payDateEnd;
	private Integer debtCode;
	
	public Integer getDebtCode() {
		return debtCode;
	}

	public void setDebtCode(Integer debtCode) {
		this.debtCode = debtCode;
	}

	public Date getPayDateEnd() {
		return payDateEnd;
	}

	public void setPayDateEnd(Date payDateEnd) {
		this.payDateEnd = payDateEnd;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Integer getIssueId()
	{
		return issueId;
	}

	public void setIssueId(Integer issueId)
	{
		this.issueId = issueId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getIssueSerial()
	{
		return issueSerial;
	}

	public void setIssueSerial(String issueSerial)
	{
		this.issueSerial = issueSerial;
	}
	
}
