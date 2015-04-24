/* 
 * $$head$$
 */
package gov.dnt.tame.common;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;
/**
 * @author rayt
 */
public class SQLRunnerFactoryImpl extends SQLRunnerFactory
{

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.sql.SQLRunnerFactory#getSQLRunner()
	 */
	public SQLRunner getSQLRunner()
	{
			try {
				return new ConnectionSQLRunner(DataSourceFactory.getDataSource().getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}

}
