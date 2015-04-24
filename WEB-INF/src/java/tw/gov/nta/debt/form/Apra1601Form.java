/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;
public class Apra1601Form extends SupportForm
{
	private static final long serialVersionUID = 1L;
	private Date closeSdate;
	private Date closeEdate;
	public Date getCloseEdate()
	{
		return closeEdate;
	}
	public void setCloseEdate(Date closeEdate)
	{
		this.closeEdate = closeEdate;
	}
	public Date getCloseSdate()
	{
		return closeSdate;
	}
	public void setCloseSdate(Date closeSdate)
	{
		this.closeSdate = closeSdate;
	}
	
}
