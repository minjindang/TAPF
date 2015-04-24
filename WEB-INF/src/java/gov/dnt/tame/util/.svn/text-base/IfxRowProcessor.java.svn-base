package gov.dnt.tame.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;

public class IfxRowProcessor extends BasicRowProcessor
{
    private static final IfxRowProcessor instance = new IfxRowProcessor();

    private static final Map<Object,Object> primitiveDefaults;

    static
    {
        primitiveDefaults = new HashMap<Object,Object>();
        primitiveDefaults.put(Integer.TYPE, new Integer(0));
        primitiveDefaults.put(Short.TYPE, new Short((short) 0));
        primitiveDefaults.put(Byte.TYPE, new Byte((byte) 0));
        primitiveDefaults.put(Float.TYPE, new Float(0.0F));
        primitiveDefaults.put(Double.TYPE, new Double(0.0D));
        primitiveDefaults.put(Long.TYPE, new Long(0L));
        primitiveDefaults.put(Boolean.TYPE, Boolean.FALSE);
        primitiveDefaults.put(Character.TYPE, new Character('\0'));
    }

    public IfxRowProcessor()
    {
        super();
    }

    public static BasicRowProcessor instance()
    {
        return instance;
    }

    private PropertyDescriptor[] propertyDescriptors(Class c)
            throws SQLException
    {
        BeanInfo beanInfo = null;
        try
        {
            beanInfo = Introspector.getBeanInfo(c);
        }
        catch (IntrospectionException e)
        {
            throw new SQLException("Bean introspection failed: "
                    + e.getMessage());
        }
        return beanInfo.getPropertyDescriptors();
    }

    private int[] mapColumnsToProperties(ResultSetMetaData rsmd,
            PropertyDescriptor props[]) throws SQLException
    {
        int cols = rsmd.getColumnCount();
        int columnToProperty[] = new int[cols + 1];
        label0: for (int col = 1; col <= cols; col++)
        {
            String columnName = rsmd.getColumnName(col);
            int i = 0;
            do
            {
                if (i >= props.length)
                    continue label0;
                if (columnName.equalsIgnoreCase(props[i].getName()))
                {
                    columnToProperty[col] = i;
                    continue label0;
                }
                columnToProperty[col] = -1;
                i++;
            } while (true);
        }

        return columnToProperty;
    }

    private Object newInstance(Class c) throws SQLException
    {
        try
        {
            return c.newInstance();
        }
        catch (Exception e)
        {
            throw new SQLException("Cannot create " + c.getName() + ": "
                    + e.getMessage());
        }
    }

    private void callSetter(Object target, PropertyDescriptor prop, Object value)
            throws SQLException
    {
        Method setter = prop.getWriteMethod();
        if (setter == null)
            return;
        Class params[] = setter.getParameterTypes();
        try
        {
            if (isCompatibleType(value, params[0]))
                setter.invoke(target, new Object[]
                {
                    value
                });
        }
        catch (IllegalArgumentException e)
        {
            throw new SQLException("Cannot set " + prop.getName() + ": "
                    + e.getMessage());
        }
        catch (IllegalAccessException e)
        {
            throw new SQLException("Cannot set " + prop.getName() + ": "
                    + e.getMessage());
        }
        catch (InvocationTargetException e)
        {
            throw new SQLException("Cannot set " + prop.getName() + ": "
                    + e.getMessage());
        }
    }

    private boolean isCompatibleType(Object value, Class type)
    {
        if (value == null || type.isInstance(value))
            return true;
        if (type.equals(Integer.TYPE)
                && (java.lang.Integer.class).isInstance(value))
            return true;
        if (type.equals(Long.TYPE) && (java.lang.Long.class).isInstance(value))
            return true;
        if (type.equals(Double.TYPE)
                && (java.lang.Double.class).isInstance(value))
            return true;
        if (type.equals(Float.TYPE)
                && (java.lang.Float.class).isInstance(value))
            return true;
        if (type.equals(Short.TYPE)
                && (java.lang.Short.class).isInstance(value))
            return true;
        if (type.equals(Byte.TYPE) && (java.lang.Byte.class).isInstance(value))
            return true;
        if (type.equals(Character.TYPE)
                && (java.lang.Character.class).isInstance(value))
            return true;
        return type.equals(Boolean.TYPE)
                && (java.lang.Boolean.class).isInstance(value);
    }

    public Object toBean(ResultSet rs, Class type) throws SQLException
    {
        PropertyDescriptor props[] = propertyDescriptors(type);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnToProperty[] = mapColumnsToProperties(rsmd, props);
        int cols = rsmd.getColumnCount();
        return createBean(rs, type, props, columnToProperty, cols);
    }

    public List<Object> toBeanList(ResultSet rs, Class type) throws SQLException
    {
        List<Object> results = new ArrayList<Object>();
        if (!rs.next())
            return results;
        PropertyDescriptor props[] = propertyDescriptors(type);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnToProperty[] = mapColumnsToProperties(rsmd, props);
        int cols = rsmd.getColumnCount();
        do
            results.add(createBean(rs, type, props, columnToProperty, cols));
        while (rs.next());
        return results;
    }

    private Object createBean(ResultSet rs, Class type,
            PropertyDescriptor props[], int columnToProperty[], int cols)
            throws SQLException
    {
        Object bean = newInstance(type);
        for (int i = 1; i <= cols; i++)
        {
            if (columnToProperty[i] == -1)
                continue;
            int colType = rs.getMetaData().getColumnType(i);
            Object value = null;
            switch (colType)
            {
                case Types.VARCHAR:
                case Types.LONGVARCHAR:
                    value = rs.getString(i);
                    break;
                default:
                    value = rs.getObject(i);
            }

            PropertyDescriptor prop = props[columnToProperty[i]];
            Class<?> propType = prop.getPropertyType();
            if (propType != null && value == null && propType.isPrimitive())
                value = primitiveDefaults.get(propType);
            callSetter(bean, prop, value);
        }

        return bean;
    }

    public Map<Object, Object> toMap(ResultSet rs) throws SQLException
    {
        Map<Object,Object> result = new IfxCaseInsensitiveHashMap();
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();

        for (int i = 1; i <= cols; i++)
        {

            int colType = rs.getMetaData().getColumnType(i);
            Object value = null;
            switch (colType)
            {
                case Types.VARCHAR:
                case Types.LONGVARCHAR:
                    value = rs.getString(i);
                    break;
                default:
                    value = rs.getObject(i);
            }
            result.put(rsmd.getColumnName(i), value);
        }

        return result;
    }

    /**
     * A Map that converts all keys to lowercase Strings for case insensitive
     * lookups. This is needed for the toMap() implementation because databases
     * don't consistenly handle the casing of column names.
     */
    protected static class IfxCaseInsensitiveHashMap extends LinkedHashMap
    {
    	private static final long serialVersionUID = 1L;

        /**
         * @see java.util.LinkedHashMap#containsKey(java.lang.Object)
         */
        public boolean containsKey(Object key)
        {
            return super.containsKey(key.toString().toLowerCase());
        }

        /**
         * @see java.util.Map#get(java.lang.Object)
         */
        public Object get(Object key)
        {
            return super.get(key.toString().toLowerCase());
        }

        /**
         * @see java.util.Map#put(java.lang.Object, java.lang.Object)
         */
        public Object put(Object key, Object value)
        {
            return super.put(key.toString().toLowerCase(), value);
        }

        /**
         * @see java.util.Map#putAll(java.util.Map)
         */
        public void putAll(Map m)
        {
            Iterator iter = m.keySet().iterator();
            while (iter.hasNext())
            {
                Object key = iter.next();
                Object value = m.get(key);
                this.put(key, value);
            }
        }

        /**
         * @see java.util.Map#remove(java.lang.ObjecT)
         */
        public Object remove(Object key)
        {
            return super.remove(key.toString().toLowerCase());
        }
    }
}