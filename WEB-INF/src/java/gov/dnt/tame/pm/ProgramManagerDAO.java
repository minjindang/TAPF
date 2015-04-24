package gov.dnt.tame.pm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.kangdainfo.ast.sql.BaseDAO;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;

public class ProgramManagerDAO extends BaseDAO {
	private final static String Program_Name_ColumnName = "NAME";
	private final static String Program_Name_QuerySQL = "SELECT NAME FROM PM0003_DB WHERE PATH=?";
	
	private Log log = LogFactory.getLog(this.getClass());
	private Connection connection;

	public ProgramManagerDAO(Connection connection) {
		super(new ConnectionSQLRunner(connection));
	}

	public String getProgramName(String programId) throws SQLException
	{
		String programName = "";
		try {
			SQLJob job = new SQLJob(Program_Name_QuerySQL);
			job.addParameter( programId );
			Map map = (Map) getSqlRunner().query(job,new MapHandler());
			programName = (String) map.get(Program_Name_ColumnName);
		} catch (SQLException e) {
			log.error("Error printing report", e);
			throw e;
		}
		return "".equals(programName)?"NONAME":programName;
	}

	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
