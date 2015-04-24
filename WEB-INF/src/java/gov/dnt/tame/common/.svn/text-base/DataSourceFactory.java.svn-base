/* DataSourceFactory.java
 * Created on 2004/9/9
 */
package gov.dnt.tame.common;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.kangdainfo.ast.sql.DataSourceAdaptor;

/**
 * @author Anson Tsai
 */
public abstract class DataSourceFactory
{
    public static final String DATA_SOURCE_JNDI = Constants.DATA_SOURCE_JNDI;
   
    public static DataSource getDataSource() throws NamingException
    {
        return DataSourceAdaptor.getDataSource(DATA_SOURCE_JNDI);
    }
}
