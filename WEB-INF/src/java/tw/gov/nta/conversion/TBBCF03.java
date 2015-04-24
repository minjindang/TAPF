package tw.gov.nta.conversion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;

public class TBBCF03 implements ConvertInterface{
	public void insertData(Connection connection, String path) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		BufferedReader tInputFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"Big5"));
		String tTemp = tInputFileReader.readLine();
		
		Map tMap = new HashMap();
		while (tTemp != null) {
			if (tTemp.length() < 139)
				continue;
			tMap.put("issue_serial", tTemp.substring(0, 12));
			tMap.put("issue_id", ConvertFunction.getIdByIssueSerial((String)tMap.get("issue_serial"), connection));
			
			tMap.put("bank_code", tTemp.substring(12,22));
			tMap.put("bid_amount", tTemp.substring(28,43));
			tMap.put("gotbid_amount", tTemp.substring(43,58));
			tMap.put("is_use", tTemp.substring(59,60));
			tMap.put("bid_price", tTemp.substring(59, 66));
			tMap.put("price_05", tTemp.substring(66,72));
			tMap.put("price_1", tTemp.substring(72,78));
			tMap.put("price_5", tTemp.substring(78,84));
			tMap.put("price_10", tTemp.substring(84,90));
			tMap.put("price_50", tTemp.substring(90,96));
			tMap.put("price_100", tTemp.substring(96,102));
			tMap.put("price_500", tTemp.substring(102,108));
			tMap.put("price_1000", tTemp.substring(108,114));
			tMap.put("price_5000", tTemp.substring(114,120));
			tMap.put("price_10000", tTemp.substring(120,126));
			tMap.put("price_50000", tTemp.substring(126,132));
			tMap.put("price_100000", tTemp.substring(132,138));
			tMap.put("is_manager", tTemp.substring(138,139));

			Calendar tCalendar = Calendar.getInstance();
			tMap.put("mod_date", tCalendar.get(Calendar.YEAR) + "/" + tCalendar.get(Calendar.MONTH) + "/" + tCalendar.get(Calendar.DAY_OF_MONTH));
			tMap.put("create_date", tMap.get("mod_date"));
			tMap.put("userId", "TAPF");
//			tMap.put("fild_code", "TBBCF03");
			run.update(connection, ConvertFunction.insTemp("central_issue_det", tMap));
			
			// --------------------¤U¤@µ§----------
			tTemp = tInputFileReader.readLine();
		}
	}
}
