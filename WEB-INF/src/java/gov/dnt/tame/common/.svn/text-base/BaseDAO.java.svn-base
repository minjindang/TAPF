/* 
 * $$head$$
 */
package gov.dnt.tame.common;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
import com.kangdainfo.ast.sql.SQLRunnerException;

/**
 * @author rayt
 */
public abstract class BaseDAO
{
	private SQLRunner sqlRunner = null;

	private MapHandler mapHandler = new MapHandler();
	private MapListHandler mapListHandler = new MapListHandler();

	public BaseDAO(SQLRunner runner)
	{
		this.sqlRunner = runner;
	}

	/**
	 * @return
	 */
	public SQLRunner getSqlRunner()
	{
		return sqlRunner;
	}

	/**
	 * @param runner
	 */
	public void setSqlRunner(SQLRunner runner)
	{
		sqlRunner = runner;
	}

	/**
	 * Run an update <code>SQLJob</code> and return number of rows
	 * affected.
	 * 
	 * @param job           SQLJob to be executed
	 * @return              Number of rows affected
	 * @throws SQLRunnerException
	 */
	public int update(SQLJob job) throws SQLRunnerException
	{
		try
		{
			return getSqlRunner().update(job);
		}
		catch (SQLException e)
		{
			throw new SQLRunnerException("sql exception", e);
		}
	}

	/**
	 * Run an insert <code>SQLJob</code>.
	 * This method does not return the last inserted ID.
	 * 
	 * @param job           SQLJob to be executed.
	 * @throws SQLException
	 * @throws NamingException
	 */
	public void insert(SQLJob job) throws SQLRunnerException
	{
		update(job);
	}

	/**
	 * Run an insert <code>SQLJob</code> and return the last inserted ID.
	 * 
	 * @param tableName         Name of the table
	 * @param job
	 * @return
	 * @throws SQLException
	 * @throws NamingException
	 */
	public long insert(String tableName, SQLJob job)
		throws SQLRunnerException
	{
		try
		{
			return getSqlRunner().insert(tableName, job);
		}
		catch (SQLException e)
		{
			throw new SQLRunnerException("sql exception", e);
		}
	}

	/**
	 * Return the last inserted ID for a table give by <code>tableName</code>
	 * 
	 * @param tableName         Name of the table to find the last inserted ID.
	 * @return                  The last inserted ID.
	 * @throws SQLException
	 * @throws NamingException
	 */
	public long getLastInsertId(String tableName)
		throws SQLRunnerException
	{
		try
		{
			return getSqlRunner().getLastInsertId(tableName);
		}
		catch (SQLException e)
		{
			throw new SQLRunnerException("sql exception", e);
		}
	}

	public int delete(SQLJob job) throws SQLRunnerException
	{
		return update(job);
	}

	/**
	 * Select a single row from the query and store the
	 * resulting row into a <code>Map</code>.
	 * 
	 * @param job           SQLJob to be executed.
	 * @return              A Map of the selected row.
	 * @throws SQLException
	 */
	public Map selectMap(SQLJob job) throws SQLRunnerException
	{
		try
		{
			return (Map) getSqlRunner().query(job, mapHandler);
		}
		catch (SQLException e)
		{
			throw new SQLRunnerException("sql exception", e);
		}
	}

	public List selectList(SQLJob job) throws SQLRunnerException
	{
		try
		{
			return (List) getSqlRunner().query(job, mapListHandler);
		}
		catch (SQLException e)
		{
			throw new SQLRunnerException("sql exception", e);
		}
	}

	/**
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public int getCount(SQLJob sql) throws SQLRunnerException
	{
		try
		{
			return getSqlRunner().getCount(sql);
		}
		catch (SQLException e)
		{
			throw new SQLRunnerException("sql exception", e);
		}
	}

	/**
	 * @param sql
	 * @param column
	 * @return
	 * @throws SQLException
	 */
	public int getCount(SQLJob sql, String column) throws SQLRunnerException
	{
		try
		{
			return getSqlRunner().getCount(sql, column);
		}
		catch (SQLException e)
		{
			throw new SQLRunnerException("sql exception", e);
		}
	}

}
