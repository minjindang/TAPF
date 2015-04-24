/**
 * @author Andrew Sung
 * @create 2006/4/4
 */

package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

public class Apra2901Form extends SupportForm
{
	private static final long serialVersionUID = 1L;
	private String paySmonth;
	private String payEmonth;
	private String bondType;
	
	public String getBondType() {
		return bondType;
	}
	public void setBondType(String bondType) {
		this.bondType = bondType;
	}
	public String getPayEmonth()
	{
		return payEmonth;
	}
	public void setPayEmonth(String payEmonth)
	{
		this.payEmonth = payEmonth;
	}
	public String getPaySmonth()
	{
		return paySmonth;
	}
	public void setPaySmonth(String paySmonth)
	{
		this.paySmonth = paySmonth;
	}
	
}
