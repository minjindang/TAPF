/**
 * @author Andrew Sung
 * @create 2006/4/3
 */

package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

import java.util.Date;
import java.util.List;

public class Apra1901Form extends SupportForm
{
	private static final long serialVersionUID = 1L;
	private Date closeDate;
	private Integer issueId;
	private Integer bankId;
	private String bankName;
	private String debtName;
	private String issueSerial;
	public String getIssueSerial() {
		return issueSerial;
	}
	public void setIssueSerial(String issueSerial) {
		this.issueSerial = issueSerial;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getDebtName() {
		return debtName;
	}
	public void setDebtName(String debtName) {
		this.debtName = debtName;
	}
	public Integer getBankId()
	{
		return bankId;
	}
	public void setBankId(Integer bankId)
	{
		this.bankId = bankId;
	}
	public Date getCloseDate()
	{
		return closeDate;
	}
	public void setCloseDate(Date closeDate)
	{
		this.closeDate = closeDate;
	}
	public Integer getIssueId()
	{
		return issueId;
	}
	public void setIssueId(Integer issueId)
	{
		this.issueId = issueId;
	}
	public List getDebtNameList()
	{
        return ListToolManager.getList("select id , debtName from IssueMain where debtType = 'A'");
	}
	public List getBankNameList()
	{
		return ListToolManager.getList("select id , bankName from BankRef");
	}
}
