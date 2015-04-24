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

public class TBBCF04 implements ConvertInterface {
	public void insertData(Connection connection, String path) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		BufferedReader tInputFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"Big5"));
		String tTemp = tInputFileReader.readLine();
		
		Map tMap = new HashMap();
		while (tTemp != null) {
			if (tTemp.length() < 193)
				continue;
			tMap.put("issue_serial", tTemp.substring(0, 12));
			tMap.put("issue_id", ConvertFunction.getIdByIssueSerial((String)tMap.get("issue_serial"), connection));
			
			tMap.put("payment_id", "");
			tMap.put("file_no", "TBBCF04");
			tMap.put("bond_type", tTemp.substring(12,13));
			tMap.put("issue_kind", tTemp.substring(13,14));
			tMap.put("account_year", tTemp.substring(14,17));
			tMap.put("issue_date", tTemp.substring(17,25));
			tMap.put("issue_amount", tTemp.substring(25,40));
			tMap.put("bid_amount", tTemp.substring(40,55));
			tMap.put("Bid_Rate", tTemp.substring(55,61));
			tMap.put("gotBig_amount", tTemp.substring(61,76));
			tMap.put("issue_amount", tTemp.substring(76,91));
			tMap.put("interest_amount", tTemp.substring(91,106));
			tMap.put("low_rate", tTemp.substring(106,112));
			tMap.put("hight_rate", tTemp.substring(112,118));
			tMap.put("average_rate", tTemp.substring(118,124));
			tMap.put("due_date", tTemp.substring(124,132));
			tMap.put("Debt_name", tTemp.substring(135,185));
			tMap.put("issue_days", tTemp.substring(132,135));
			tMap.put("ahead_date", tTemp.substring(186,193));
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
