package tw.gov.nta.conversion;

import java.sql.Connection;

public interface ConvertInterface {
	String splitLength= "";
	
	abstract public void insertData(Connection connection, String path) throws Exception;
}
