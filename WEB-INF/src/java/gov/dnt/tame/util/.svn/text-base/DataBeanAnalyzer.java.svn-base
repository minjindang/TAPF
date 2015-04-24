/* $Id: DataBeanAnalyzer.java,v 1.1 2006/04/25 03:45:21 william Exp $
 * Created on Oct 8, 2004
 */
package gov.dnt.tame.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author rayt
 */
public class DataBeanAnalyzer
{
    public static final String DELIMITER = ",";
    public static final int DELIMITER_LENGTH = DELIMITER.length();
    
    private Object bean = null;
    private boolean isIgnoreNull = true;
    
    private PropertyDescriptor [] descriptors = null;
    private StringBuffer insertColumns = new StringBuffer();
    private StringBuffer insertValues = new StringBuffer();
    private StringBuffer wherePart = new StringBuffer();
    private StringBuffer setPart = new StringBuffer();
    private Object [] parameters = null;
    
    public DataBeanAnalyzer(Object bean) throws AnalyzerException
    {
        this(bean, true);
    }
    
    public DataBeanAnalyzer(Object bean, boolean isIgnoreNull) throws AnalyzerException
    {
        this.bean = bean;
        this.isIgnoreNull = isIgnoreNull;
        analyze();
    }
    
    private void analyze() throws AnalyzerException
    {
        boolean isFirst = true;
        
        descriptors = PropertyUtils.getPropertyDescriptors(bean);
        List<Object> parameterList = new LinkedList<Object>();
        
        try
        {
            for (int i = 0; i < descriptors.length; i++)
            {
                PropertyDescriptor descriptor = descriptors[i];
                
                String name = descriptor.getName();
                Object value = PropertyUtils.getProperty(bean, name);
                
                if ("class".equals(name))
                {
                    continue;
                }
                if (isIgnoreNull && value == null)
                {
                    continue;
                }
                
                insertColumns.append(name + DELIMITER);
                insertValues.append("?" + DELIMITER);
                if (!isFirst)
                {
                    wherePart.append(" and ");
                }
                wherePart.append(name + " = ?" + DELIMITER);
                setPart.append(name + " = ?" + DELIMITER);
                isFirst = false;
                
                parameterList.add(value);
            }
            insertColumns.setLength(insertColumns.length() - DELIMITER_LENGTH);
            insertValues.setLength(insertValues.length() - DELIMITER_LENGTH);
            wherePart.setLength(wherePart.length() - DELIMITER_LENGTH);
            setPart.setLength(setPart.length() - DELIMITER_LENGTH);
            
            parameters = new Object [parameterList.size()];
            
            int i = 0;
            for (Iterator<Object> it = parameterList.iterator(); it.hasNext();)
            {
                Object row = it.next();
                parameters[i] = row;
                i++;
            }
        }
        catch (IllegalAccessException e)
        {
            throw new AnalyzerException("illegal access exception", e);
        }
        catch (InvocationTargetException e)
        {
            throw new AnalyzerException("invocation target exception", e);
        }
        catch (NoSuchMethodException e)
        {
            throw new AnalyzerException("no such method exception", e);
        }
    }
    
    public int getNumberOfFields()
    {
        return descriptors.length;
    }
    /**
     * @return Returns the descriptors.
     */
    public PropertyDescriptor[] getDescriptors()
    {
        return descriptors;
    }
    /**
     * @param descriptors The descriptors to set.
     */
    public void setDescriptors(PropertyDescriptor[] descriptors)
    {
        this.descriptors = descriptors;
    }
    /**
     * @return Returns the insertColumns.
     */
    public StringBuffer getInsertColumns()
    {
        return insertColumns;
    }
    /**
     * @param insertColumns The insertColumns to set.
     */
    public void setInsertColumns(StringBuffer insertColumns)
    {
        this.insertColumns = insertColumns;
    }
    /**
     * @return Returns the insertValues.
     */
    public StringBuffer getInsertValues()
    {
        return insertValues;
    }
    /**
     * @param insertValues The insertValues to set.
     */
    public void setInsertValues(StringBuffer insertValues)
    {
        this.insertValues = insertValues;
    }
    /**
     * @return Returns the parameters.
     */
    public Object[] getParameters()
    {
        return parameters;
    }
    /**
     * @param parameters The parameters to set.
     */
    public void setParameters(Object[] parameters)
    {
        this.parameters = parameters;
    }
    /**
     * @return Returns the wherePart.
     */
    public StringBuffer getWherePart()
    {
        return wherePart;
    }
    /**
     * @param wherePart The wherePart to set.
     */
    public void setWherePart(StringBuffer wherePart)
    {
        this.wherePart = wherePart;
    }
    /**
     * @return Returns the setPart.
     */
    public StringBuffer getSetPart()
    {
        return setPart;
    }
    /**
     * @param setPart The setPart to set.
     */
    public void setSetPart(StringBuffer setPart)
    {
        this.setPart = setPart;
    }
}
