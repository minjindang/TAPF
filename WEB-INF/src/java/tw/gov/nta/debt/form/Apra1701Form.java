/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;
public class Apra1701Form extends SupportForm
{
	private static final long serialVersionUID = 1L;

	private Date closeDate;

	public Date getCloseDate()
	{
		return closeDate;
	}

	public void setCloseDate(Date closeDate)
	{
		this.closeDate = closeDate;
	}
	
}
