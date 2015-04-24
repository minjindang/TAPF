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

public class TBBCF02 implements ConvertInterface {
	public void insertData(Connection connection, String path) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		BufferedReader tInputFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"Big5"));
		String tTemp = tInputFileReader.readLine();
		
		Map tMap = new HashMap();
		while (tTemp != null) {
			if (tTemp.length() < 215)
				continue;
			tMap.put("issue_serial", tTemp.substring(0, 12));
			tMap.put("issue_id", ConvertFunction.getIdByIssueSerial((String)tMap.get("issue_serial"), connection));
			tMap.put("due_date", tTemp.substring(154, 162));
			tMap.put("Debt_name", tTemp.substring(162, 212));
			tMap.put("issue_days", tTemp.substring(212, 215));
			tMap.put("bond_type", tTemp.substring(12, 13));
			tMap.put("issue_kind", tTemp.substring(13, 14));
			tMap.put("account_year", tTemp.substring(14, 17));
			tMap.put("issue_date", tTemp.substring(17, 25));
			tMap.put("issue_amount", tTemp.substring(25, 40));
			tMap.put("Big_Amount", tTemp.substring(40, 55));
			tMap.put("Bid_Rate", tTemp.substring(55, 60));
			tMap.put("reachBid_Amount", tTemp.substring(60, 75));
			tMap.put("gotBid_amount", tTemp.substring(75, 90));
			tMap.put("totalBid_amount", tTemp.substring(90, 105));
			tMap.put("low_rate", tTemp.substring(105, 111));
			tMap.put("hight_rate", tTemp.substring(111, 117));
			tMap.put("average_rate", tTemp.substring(117, 123));
			tMap.put("sell_amount", tTemp.substring(123, 138));
			tMap.put("noUse_amount", tTemp.substring(138, 154));
			tMap.put("is_manager", tTemp.substring(155, 156));
			Calendar tCalendar = Calendar.getInstance();
			tMap.put("mod_date", tCalendar.get(Calendar.YEAR) + "/" + tCalendar.get(Calendar.MONTH) + "/" + tCalendar.get(Calendar.DAY_OF_MONTH));
			tMap.put("create_date", tMap.get("mod_date"));
			tMap.put("userId", "TAPF");
			tMap.put("fild_code", "TBBCF02");
			run.update(connection, ConvertFunction.insTemp("Central_issue_main", tMap));
			
			// --------------------¤U¤@µ§----------
			tTemp = tInputFileReader.readLine();
		}
	}
}
