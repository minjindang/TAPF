package tw.gov.nta.debt.common;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Vector;

public class DebtMainVectors {
	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String get;
	private java.lang.String accrue;
	private java.lang.String accrueDate;

	public String getGet() {
		return get;
	}
	public void setGet(String get) {
		if( "on".equals( get ) )
			this.get = "Y";
		else
			this.get = "N";
	}
	public String getAccrue() {
		return accrue;
	}
	public void setAccrue(String accrue) {
		if( "on".equals( accrue ) )
			this.accrue = "Y";
		else
			this.accrue = "N";
	}
	public String getAccrueDate() {
		return accrueDate;
	}
	public void setAccrueDate(String accrueDate) {
		this.accrueDate = accrueDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	private String originInterestAmount;
	private String issueAmount;
	public String getIssueAmount()
	{
		return issueAmount;
	}
	public void setIssueAmount(String issueAmount)
	{
		this.issueAmount = issueAmount;
	}

	private Vector paymentMains = new Vector();
	//payMentMains
	public void setPaymentMains(Vector paymentMains)
    {
        this.paymentMains = paymentMains;
    }
	public Collection getPaymentMains()
	{
		return paymentMains;
	}
	public void setPaymentMains(Collection payMentMains)
	{
		this.paymentMains = new Vector(paymentMains);
	}
	public Object getPaymentMains(int index)
	{
		if (this.paymentMains.size() <= index)
		{
			PayMentMainVectors payMentMainVectors = new PayMentMainVectors();
			setPaymentMains(index, payMentMainVectors);
			return payMentMainVectors;
		}
		else
		{
			Object obj = paymentMains.get(index);
			if (obj == null)
			{
				PayMentMainVectors payMentMainVectors = new PayMentMainVectors();
				setPaymentMains(index, payMentMainVectors);
				return payMentMainVectors;
			}
			else
				return obj;
		}
	}
	public void setPaymentMains(int index, Object paymentMain)
	{
		if (this.paymentMains.size() <= index)
			paymentMains.setSize(index + 1);
		this.paymentMains.set(index, paymentMain);
	}
	public String getOriginInterestAmount() {
		return originInterestAmount;
	}
	public void setOriginInterestAmount(String originInterestAmount) {
		this.originInterestAmount = originInterestAmount;
	}
	

}
