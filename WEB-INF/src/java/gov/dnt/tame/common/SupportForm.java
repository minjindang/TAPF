package gov.dnt.tame.common;

import gov.dnt.tame.util.DateUtil;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;

public class SupportForm extends ActionForm {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	/** 金額 加千分位 **/
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
	/** 金額 加千分位 **/
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
