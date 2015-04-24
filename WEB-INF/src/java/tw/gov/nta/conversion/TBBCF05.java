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

public class TBBCF05 implements ConvertInterface {
	public void insertData(Connection connection, String path) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		BufferedReader tInputFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"Big5"));
		String tTemp = tInputFileReader.readLine();
		
		Map tMap = new HashMap();
		while (tTemp != null) {
			if (tTemp.length() < 65)
				continue;
			tMap.put("issue_serial", tTemp.substring(0, 12));
			tMap.put("issue_id", ConvertFunction.getIdByIssueSerial((String)tMap.get("issue_serial"), connection));
			
			tMap.put("payment_id", "");
			tMap.put("file_no", "TBBCF05");
			tMap.put("bank_code", tTemp.substring(12,22));
			tMap.put("issue_price", tTemp.substring(22,29));
			tMap.put("sell_rate", tTemp.substring(29,35));
			tMap.put("sell_amount", tTemp.substring(35,50));
			tMap.put("free_amount", tTemp.substring(50,65));
			tMap.put("is_manager", "Y");

			Calendar tCalendar = Calendar.getInstance();
			tMap.put("mod_date", tCalendar.get(Calendar.YEAR) + "/" + tCalendar.get(Calendar.MONTH) + "/" + tCalendar.get(Calendar.DAY_OF_MONTH));
			tMap.put("create_date", tMap.get("mod_date"));
			tMap.put("userId", "TAPF");
			run.update(connection, ConvertFunction.insTemp("Aheadpay_main", tMap));
			
			// --------------------¤U¤@µ§----------
			tTemp = tInputFileReader.readLine();
		}
	}
}
