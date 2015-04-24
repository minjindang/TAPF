/* BeanHandlerDAOImp.java
 * Created on 2004/9/15
 */
package gov.dnt.tame.util;

import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kangdainfo.ast.dao.DAOException;
import com.kangdainfo.ast.dao.SQLRunnerDAOImpl;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
import com.kangdainfo.ast.sql.dialect.Dialect;
import com.kangdainfo.ast.sql.dialect.InformixDialect;

/**
 * @author Anson Tsai
 */
public class BeanHandlerDAOImp extends SQLRunnerDAOImpl
{
    private RowProcessor rowProcessor = null;
    
    /**
     * @param connection
     */
    public BeanHandlerDAOImp(Connection connection)
    {
        this(connection, new InformixDialect(), new IfxRowProcessor());
    }
    
    public BeanHandlerDAOImp(Connection connection, Dialect dialect, RowProcessor rowProcessor)
    {
        super(connection);
        getRunner().setDialect(new InformixDialect());
        this.rowProcessor = rowProcessor;
    }

    /**
     * @param runner
     */
    public BeanHandlerDAOImp(SQLRunner runner)
    {
        super(runner);
        getRunner().setDialect(new InformixDialect());
    }

    /**
     * @deprecated use createBeanListHandler(Class) intead.
     * @param beanName
     * @return
     * @throws DAOException
     */
    public BeanListHandler createBeanListHandler(String beanName)
            throws DAOException
    {
        try
        {
            return new BeanListHandler(Class.forName(beanName), rowProcessor);
        }
        catch (ClassNotFoundException e)
        {
            throw new DAOException("class not found exception", e);
        }
    }

    public BeanListHandler createBeanListHandler(Class<?> clazz)
            throws DAOException
    {
        return new BeanListHandler(clazz, rowProcessor);
    }
    
    public BeanHandler createBeanHandler(Class clazz)
    {
        return new BeanHandler(clazz, rowProcessor);
    }

    /**
     * @deprecated use queryList(SQLJob, Class) intead.
     * @param job
     * @param BeanName
     * @return Collection
     * @throws DAOException
     */
    protected Collection query(SQLJob job, String beanName) throws DAOException
    {
        return (Collection) query(job, createBeanListHandler(beanName));
    }
    
    /**
     * @deprecated use queryList(SQLJob, Clawss) instead
     * @param job
     * @param clazz
     * @return
     * @throws DAOException
     */
    protected Collection query(SQLJob job, Class<?> clazz) throws DAOException
    {
        return (Collection) query(job, createBeanListHandler(clazz));
    }
    
    protected List queryList(SQLJob job, Class<?> clazz) throws DAOException
    {
        return (List) query(job, createBeanListHandler(clazz));
    }

    /**
     * @deprecated use queryBean(SQLJob, Class) instead
     * @param sqlJob
     * @param BeanName
     * @return Object
     * @throws DAOException
     */
    protected Object queryBean(SQLJob sqlJob, String BeanName)
            throws DAOException
    {
        Collection collection = query(sqlJob, BeanName);
        if (collection != null && collection.size() > 0)
        {
            Iterator i = collection.iterator();
            if (i.hasNext())
                return i.next();
        }
        return null;
    }
    
    protected Object queryBean(SQLJob job, Class clazz) throws DAOException
    {
        return query(job, createBeanHandler(clazz));
    }

    public long insert(String table, Object bean) throws DAOException
    {
        return insert(table, bean, true);
    }

    public long insert(String tableName, Object bean, boolean ignoreNull)
            throws DAOException
    {
        try
        {
            DataBeanAnalyzer analyzer = new DataBeanAnalyzer(bean);
            SQLJob job = new SQLJob("insert into " + tableName + " (");
            job.appendSQL(analyzer.getInsertColumns().toString());
            job.appendSQL(") values (");
            job.appendSQL(analyzer.getInsertValues().toString());
            job.appendSQL(")");
            job.addParameter(analyzer.getParameters());
            return insert(tableName, job);
        }
        catch (AnalyzerException e)
        {
            throw new DAOException("analyzer exception", e);
        }
    }

    public int update(String tableName, Object bean, String where, Object [] whereParameters) throws DAOException
    {
        return update(tableName, bean, where, whereParameters, true);
    }
    
    public int update(String tableName, Object bean,
            String where, Object[] whereParameters, boolean ignoreNull) throws DAOException
    {
        try
        {
            DataBeanAnalyzer analyzer = new DataBeanAnalyzer(bean);
            SQLJob job = new SQLJob("update " + tableName);
            job.appendSQL("set " + analyzer.getSetPart().toString());
            job.addParameter(analyzer.getParameters());
            if (where != null)
            {
                job.appendSQL("where");
                job.appendSQL(where);
                job.addParameter(whereParameters);
            }
            return update(job);
        }
        catch (AnalyzerException e)
        {
            throw new DAOException("analyzer exception", e);
        }
    }

}