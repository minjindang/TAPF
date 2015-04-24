/* $Id: ROCDateConverter.java,v 1.1 2006/04/25 03:45:20 william Exp $
 * Created on Oct 8, 2004
 */
package gov.dnt.tame.util;

import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

/**
 * @author rayt
 */
public class ROCDateConverter implements Converter
{

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.commons.beanutils.Converter#convert(java.lang.Class,
     *      java.lang.Object)
     */
    public Object convert(Class clazz, Object value)
    {
        if (value instanceof Date)
        {
            return value;
        }

        try
        {
            return DateUtil.str2Date(value.toString());
        }
        catch (Exception e)
        {
            throw new ConversionException(e);
        }
    }
}