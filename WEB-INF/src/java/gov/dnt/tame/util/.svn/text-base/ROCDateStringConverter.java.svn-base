/* $Id: ROCDateStringConverter.java,v 1.1 2006/04/25 03:45:19 william Exp $
 * Created on Oct 8, 2004
 */
package gov.dnt.tame.util;

import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.StringConverter;

/**
 * @author rayt
 */
public class ROCDateStringConverter implements Converter
{
    private StringConverter converter = null;
    
    /**
     * 
     */
    public ROCDateStringConverter()
    {
        converter = new StringConverter();
    }
    
    /* (non-Javadoc)
     * @see org.apache.commons.beanutils.Converter#convert(java.lang.Class, java.lang.Object)
     */
    public Object convert(Class clazz, Object value)
    {
        if (value instanceof Date)
        {
            try
            {
                return DateUtil.date2ROCStr((Date) value);
            }
            catch (Exception e)
            {
                throw new ConversionException(e);
            }
        }
        else
        {
            return converter.convert(clazz, value);
        }
    }

}
