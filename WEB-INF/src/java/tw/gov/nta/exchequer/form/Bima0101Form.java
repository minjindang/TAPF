/* Bima0101Form.java
 祘ΑヘBIMA01
 祘Α腹BIMA01
 祘Αら戳0950301
 祘ΑEric.Chen
 --------------------------------------------------------
 ээら戳эヘ
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.form;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.DateUtil;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.IssueMain;

public class Bima0101Form extends ActionForm {
	private static final long serialVersionUID = 1L;

	private String days;
	private Integer qrydebtCode;	//琩高ノ
	private Integer qrybudgetCode;	//琩高ノ
	private String qryaccountYear;	//琩高ノ
	private Integer qrydebtName;		//琩高ノ
	private BigDecimal totalAmount;	//眎计*肂 ticketCount * ticketAmount
	private Integer issueId;
	
	IssueMain issueMain = new IssueMain();

	public String getDays()
	{
		if(issueMain.getIssueDate()!= null && issueMain.getDueDate()!=null)
			return DateUtil.getDays(issueMain.getIssueDate(),issueMain.getDueDate()).toString()+"ら";
		else return days;
	}

	public void setDays(Date issueDate,Date dueDate)
	{
		this.days = DateUtil.getDays(issueDate,dueDate).toString()+"ら";
	}

	public IssueMain getIssueMain()
	{
		return issueMain;
	}

	public void setIssueMain(IssueMain issueMain)
	{
		this.issueMain = issueMain;
	}

	public String getQryaccountYear()
	{
		return qryaccountYear;
	}

	public void setQryaccountYear(String qryaccountYear)
	{
		this.qryaccountYear = qryaccountYear;
	}

	public Integer getQrybudgetCode()
	{
		return qrybudgetCode;
	}

	public void setQrybudgetCode(Integer qrybudgetCode)
	{
		this.qrybudgetCode = qrybudgetCode;
	}

	public Integer getQrydebtCode()
	{
		return qrydebtCode;
	}

	public void setQrydebtCode(Integer qrydebtCode)
	{
		this.qrydebtCode = qrydebtCode;
	}

	public Integer getQrydebtName()
	{
		return qrydebtName;
	}

	public void setQrydebtName(Integer qrydebtName)
	{
		this.qrydebtName = qrydebtName;
	}

	public BigDecimal getTotalAmount()
	{
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount)
	{
		this.totalAmount = totalAmount;
	}

	public String getAccountYear()
	{
		return issueMain.getAccountYear();
	}

	public BigDecimal getAverageRate()
	{
		return issueMain.getAverageRate();
	}

	public String getBondKind()
	{
		return issueMain.getBondKind();
	}

	public String getBondSellStatus()
	{
		return issueMain.getBondSellStatus();
	}

	public String getBondType()
	{
		return issueMain.getBondType();
	}

	public Integer getBudgetCode()
	{
		return issueMain.getBudgetCode();
	}

	public BigDecimal getCapitalAmount()
	{
		return issueMain.getCapitalAmount();
	}

	public Date getCashDueDate()
	{
		return issueMain.getCashDueDate();
	}

	public BigDecimal getChargeRate()
	{
		return issueMain.getChargeRate();
	}

	public Integer getDebtCode()
	{
		return issueMain.getDebtCode();
	}

	public String getDebtName()
	{
		return issueMain.getDebtName();
	}

	public String getDebtType()
	{
		return issueMain.getDebtType();
	}

	public Date getDueDate()
	{
		return issueMain.getDueDate();
	}

	public BigDecimal getExpectAmount()
	{
		return issueMain.getExpectAmount();
	}

	public Date getFirstInterestDate()
	{
		return issueMain.getFirstInterestDate();
	}

	public Date getFirstRepayDate()
	{
		return issueMain.getFirstRepayDate();
	}

	public Integer getId()
	{
		return issueMain.getId();
	}

	public Integer getInterestAlternate()
	{
		return issueMain.getInterestAlternate();
	}

	public BigDecimal getInterestAmount()
	{
		return issueMain.getInterestAmount();
	}

	public BigDecimal getIssueAmount()
	{
		return issueMain.getIssueAmount();
	}

	public Date getIssueDate()
	{
		return issueMain.getIssueDate();
	}

	public Integer getIssueInterval()
	{
		return issueMain.getIssueInterval();
	}

	public String getIssueKind()
	{
		return issueMain.getIssueKind();
	}

	public String getIssueSerial()
	{
		return issueMain.getIssueSerial();
	}

	public Date getModDate()
	{
		return issueMain.getModDate();
	}

	public Integer getPayLimit()
	{
		return issueMain.getPayLimit();
	}

	public String getRateKind()
	{
		return issueMain.getRateKind();
	}

	public String getRemark()
	{
		return issueMain.getRemark();
	}

	public Integer getRepayAlternate()
	{
		return issueMain.getRepayAlternate();
	}

	public BigDecimal getSellAmount()
	{
		return issueMain.getSellAmount();
	}

	public String getSellStatus()
	{
		return issueMain.getSellStatus();
	}

	public String getSerialNo()
	{
		return issueMain.getSerialNo();
	}

	public String getShowType()
	{
		return issueMain.getShowType();
	}

	public Integer getSourceIssueId()
	{
		return issueMain.getSourceIssueId();
	}

	public String getUserid()
	{
		return issueMain.getUserid();
	}

	public void setAccountYear(String accountYear)
	{
		issueMain.setAccountYear(accountYear);
	}

	public void setAverageRate(BigDecimal averageRate)
	{
		issueMain.setAverageRate(averageRate);
	}

	public void setBondKind(String bondKind)
	{
		issueMain.setBondKind(bondKind);
	}

	public void setBondSellStatus(String bondSellStatus)
	{
		issueMain.setBondSellStatus(bondSellStatus);
	}

	public void setBondType(String bondType)
	{
		issueMain.setBondType(bondType);
	}

	public void setBudgetCode(Integer budgetCode)
	{
		issueMain.setBudgetCode(budgetCode);
	}

	public void setCapitalAmount(BigDecimal capitalAmount)
	{
		issueMain.setCapitalAmount(capitalAmount);
	}

	public void setCashDueDate(Date cashDueDate)
	{
		issueMain.setCashDueDate(cashDueDate);
	}

	public void setChargeRate(BigDecimal chargeRate)
	{
		issueMain.setChargeRate(chargeRate);
	}

	public void setDebtCode(Integer debtCode)
	{
		issueMain.setDebtCode(debtCode);
	}

	public void setDebtName(String debtName)
	{
		issueMain.setDebtName(debtName);
	}

	public void setDebtType(String debtType)
	{
		issueMain.setDebtType(debtType);
	}

	public void setDueDate(Date dueDate)
	{
		issueMain.setDueDate(dueDate);
		if(issueMain.getIssueDate()!=null)
			this.setDays(issueMain.getIssueDate(),dueDate);
	}

	public void setExpectAmount(BigDecimal expectAmount)
	{
		issueMain.setExpectAmount(expectAmount);
	}

	public void setFirstInterestDate(Date firstInterestDate)
	{
		issueMain.setFirstInterestDate(firstInterestDate);
	}

	public void setFirstRepayDate(Date firstRepayDate)
	{
		issueMain.setFirstRepayDate(firstRepayDate);
	}

	public void setId(Integer id)
	{
		issueMain.setId(id);
	}

	public void setInterestAlternate(Integer interestAlternate)
	{
		issueMain.setInterestAlternate(interestAlternate);
	}

	public void setInterestAmount(BigDecimal interestAmount)
	{
		issueMain.setInterestAmount(interestAmount);
	}

	public void setIssueAmount(BigDecimal issueAmount)
	{
		issueMain.setIssueAmount(issueAmount);
	}

	public void setIssueDate(Date issueDate)
	{
		issueMain.setIssueDate(issueDate);
		if(issueMain.getDueDate()!=null)
			this.setDays(issueDate,issueMain.getDueDate());
	}

	public void setIssueInterval(Integer issueInterval)
	{
		issueMain.setIssueInterval(issueInterval);
	}

	public void setIssueKind(String issueKind)
	{
		issueMain.setIssueKind(issueKind);
	}

	public void setIssueSerial(String issueSerial)
	{
		issueMain.setIssueSerial(issueSerial);
	}

	public void setModDate(Date modDate)
	{
		issueMain.setModDate(modDate);
	}

	public void setPayLimit(Integer payLimit)
	{
		issueMain.setPayLimit(payLimit);
	}

	public void setRateKind(String rateKind)
	{
		issueMain.setRateKind(rateKind);
	}

	public void setRemark(String remark)
	{
		issueMain.setRemark(remark);
	}

	public void setRepayAlternate(Integer repayAlternate)
	{
		issueMain.setRepayAlternate(repayAlternate);
	}

	public void setSellAmount(BigDecimal sellAmount)
	{
		issueMain.setSellAmount(sellAmount);
	}

	public void setSellStatus(String sellStatus)
	{
		issueMain.setSellStatus(sellStatus);
	}

	public void setSerialNo(String serialNo)
	{
		issueMain.setSerialNo(serialNo);
	}

	public void setShowType(String showType)
	{
		issueMain.setShowType(showType);
	}

	public void setSourceIssueId(Integer sourceIssueId)
	{
		issueMain.setSourceIssueId(sourceIssueId);
	}

	public void setUserid(String userid)
	{
		issueMain.setUserid(userid);
	}

	public Date getCreateDate()
	{
		return issueMain.getCreateDate();
	}

	public void setCreateDate(Date createDate)
	{
		issueMain.setCreateDate(createDate);
	}

	public Integer getIssueId()
	{
		return issueId;
	}

	public void setIssueId(Integer issueId)
	{
		this.issueId = issueId;
	}

	public void clean()
	{
		this.issueMain = new IssueMain();
		this.days = new String();
		this.qrydebtCode = new Integer(0);	//琩高ノ
		this.qrybudgetCode = new Integer(0);	//琩高ノ
		this.qryaccountYear= new String();	//琩高ノ
		this.qrydebtName= new Integer(0);		//琩高ノ
		this.totalAmount = new BigDecimal(0);	//眎计*肂 ticketCount * ticketAmount
		this.issueId  = new Integer(0);
		
	}

	public BigDecimal getRealAmount() {
		return issueMain.getRealAmount();
	}

	public void setRealAmount(BigDecimal realAmount) {
		issueMain.setRealAmount(realAmount);
	}
	private Log log = LogFactory.getLog(SupportForm.class);
    
	public final Object getBigDecimal(String key)
	{
		try
		{
			BigDecimal	obj	=	(BigDecimal)	PropertyUtils.getProperty(this, (String) key);			
			if( null == obj )	return	null;
			if( "".equals(obj.toString().trim()) )	return	null;
			if( "0E-10".equals(obj.toString().trim()) )	return	"0.0";
			return obj.setScale(3,BigDecimal.ROUND_HALF_UP);
		}
		catch (IllegalAccessException e)
		{
			logTrace(e.getMessage(), e);
		}
		catch (InvocationTargetException e)
		{
			logTrace(e.getMessage(), e);
		}
		catch (NoSuchMethodException e)
		{
			logTrace(e.getMessage(), e);
		}        
		return null;
	}
    
    public final void setBigDecimal(String key, Object obj)
    {
    	try
    	{
    		String bigDecimal = (String) obj;
            if ((null == obj) || "".equals(obj.toString().trim()) )
            {
                PropertyUtils.setProperty(this, key, new BigDecimal(0));
            }
            else
            {
            	if( bigDecimal.indexOf(",")>-1 )
            		bigDecimal = bigDecimal.replaceAll(",","");
                PropertyUtils.setProperty(this, key, new BigDecimal(bigDecimal));
            }
        }
        catch (IllegalAccessException e)
        {
            logTrace(e.getMessage(), e);
        }
        catch (InvocationTargetException e)
        {
            logTrace(e.getMessage(), e);
        }
        catch (NoSuchMethodException e)
        {
            logTrace(e.getMessage(), e);
        }        
    }
    public final Object getDateFormat(String key)
    {
        try
        {
            Date date = (Date) PropertyUtils.getProperty(this, (String) key);
            if (date == null)
            {
                return null;
            }
            return DateUtil.date2ROCStr(date,"yyy/mm/dd");
        }
        catch (IllegalAccessException e)
        {
            logTrace(e.getMessage(), e);
        }
        catch (InvocationTargetException e)
        {
            logTrace(e.getMessage(), e);
        }
        catch (NoSuchMethodException e)
        {
            logTrace(e.getMessage(), e);
        }
        
        return null;
    }
    public final Object getDate(String key)
    {
        try
        {
            Date date = (Date) PropertyUtils.getProperty(this, (String) key);
            if (date == null)
            {
                return null;
            }
            return DateUtil.date2ROCStr(date);
        }
        catch (IllegalAccessException e)
        {
            logTrace(e.getMessage(), e);
        }
        catch (InvocationTargetException e)
        {
            logTrace(e.getMessage(), e);
        }
        catch (NoSuchMethodException e)
        {
            logTrace(e.getMessage(), e);
        }
        
        return null;
    }
    public final void  setDate(String key, Object obj)
    {
        try
        {
			String date = (String) obj;
			if( date.length()>8 )
				PropertyUtils.setProperty(this, key, DateUtil.str2Time(date));
			else
				PropertyUtils.setProperty(this, key, DateUtil.str2Date(date));
        }
        catch (IllegalAccessException e)
        {
            logTrace(e.getMessage(), e);
        }
        catch (InvocationTargetException e)
        {
            logTrace(e.getMessage(), e);
        }
        catch (NoSuchMethodException e)
        {
            logTrace(e.getMessage(), e);
        }
    }

	protected String convertToString(Date date)
	{
		return DateUtil.date2Str(date);
	}
	
	protected String convertToString(Object obj)
	{
		return (obj == null ? null : obj.toString());
	}
	
	protected Date convertToDate(String str)
	{
		return (str == null ? null : DateUtil.str2Date(str));
	}
	
	protected BigDecimal convertToBigDecimal(String str)
	{
		return (str == null ? null : new BigDecimal(str));
	}
	
	private void logTrace(String message, Exception e)
	{
	    if (log.isTraceEnabled())
	    {
	        log.trace(message, e);
	    }
	}
	
	/** 肂 だ **/
	public Object getAmountDecimal(String key)
	{
		try
		{
			BigDecimal	obj	=	(BigDecimal)	PropertyUtils.getProperty(this, (String) key);		
			
			StringBuffer newMoney = new StringBuffer();
			String oldMoney = obj.setScale(0,5).toString();
			int amountLength = oldMoney.length() ;
			
			for(int i = amountLength;i>0;i--)
			{		
				newMoney.append(oldMoney.substring((amountLength - i),(amountLength - i + 1)));
				if(((i - 1)%3) == 0 && i!=1)
				{
					newMoney.append(",");
				}
			}
			return newMoney.toString();
		}
		catch (Exception e)
		{
			System.out.println("my amount_decimal error message" + e);
		}       
		return null;
	}
	/** 肂 だ **/
	public Object getAmountDecimal(BigDecimal obj)
	{
		try
		{
			StringBuffer newMoney = new StringBuffer();
			String oldMoney = obj.setScale(0,5).toString();
			int amountLength = oldMoney.length() ;
			
			for(int i = amountLength;i>0;i--)
			{		
				newMoney.append(oldMoney.substring((amountLength - i),(amountLength - i + 1)));
				if(((i - 1)%3) == 0 && i!=1)
				{
					newMoney.append(",");
				}
			}
			return newMoney.toString();
		}
		catch (Exception e)
		{
			System.out.println("my amount_decimal error message" + e);
		}       
		return null;
	}
	public BigDecimal setAmountDecimal(String key , Object obj)
	{
		try
    	{
    		String bigDecimal = (String) obj;
            if ((null == obj) || "".equals(obj.toString().trim()) )
            {
                PropertyUtils.setProperty(this, key, new BigDecimal(0));
            }
            else
            {
            	if( bigDecimal.indexOf(",")>-1 )
            		bigDecimal = bigDecimal.replaceAll(",","");
                PropertyUtils.setProperty(this, key, new BigDecimal(bigDecimal));
            }
        }
        catch (IllegalAccessException e)
        {
            logTrace(e.getMessage(), e);
        }
        catch (InvocationTargetException e)
        {
            logTrace(e.getMessage(), e);
        }
        catch (NoSuchMethodException e)
        {
            logTrace(e.getMessage(), e);
        }        
		return null;
	}
}