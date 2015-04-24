/* 
 * $$head$$
 */
package gov.dnt.tame.common;

import com.kangdainfo.ast.sql.FactoryException;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author rayt
 */
public class SQLRunnerDAO extends BaseDAO
{
    public SQLRunnerDAO() throws FactoryException
    {
        this(new SQLRunnerFactoryImpl());
    
    }
    
	public SQLRunnerDAO(SQLRunnerFactory factory) throws FactoryException
	{
		this(factory.getSQLRunner());
	}

	/**
	 * @param runner
	 */
	public SQLRunnerDAO(SQLRunner runner)
	{
		super(runner);
	}

}
