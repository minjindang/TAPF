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

public class TrbtTLNO implements ConvertInterface {
	public void insertData(Connection connection, String path) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		BufferedReader tInputFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"Big5"));
		String tTemp = tInputFileReader.readLine();
		String BONDID; 
		String IPDSTR;
		String ACTNO;
		String BDTNO10;
		String BDTNO50;
		String BDTNO100;
		String BDTNO500;
		String YBDTNO10;
		String YBDTNO50;
		String YBDTNO100;
		String YBDTNO500;
		String MBDTNO;
		String YYMM;
		String IPDEND;
		String FILLER;
		//-----------------------------
//		String id;
//		String issue_id;
//		String bank_id;
//		String interest_count;
//		String exchange_date;
//		String ticket_amount;
//		String ticket_count;
//		String total_amount;
		//----------------

		
		Map tMap = new HashMap();
		while (tTemp != null) {
			if (tTemp.length() < 104)
				continue;
			tTemp.replaceAll("{", "0");
			BONDID = tTemp.substring(0, 6);
			IPDSTR = tTemp.substring(6, 8);
			ACTNO = tTemp.substring(8, 14);
			BDTNO10 = tTemp.substring(14, 19);
			BDTNO50 = tTemp.substring(19, 24);
			BDTNO100 = tTemp.substring(24, 29);
			BDTNO500 = tTemp.substring(29, 34);
			YBDTNO10 = tTemp.substring(34, 39);
			YBDTNO50 = tTemp.substring(39, 44);
			YBDTNO100 = tTemp.substring(44, 49);
			YBDTNO500 = tTemp.substring(49, 54);
			MBDTNO = tTemp.substring(54, 74);
			YYMM = tTemp.substring(74, 79);
			IPDEND = tTemp.substring(79, 81);
			FILLER = tTemp.substring(81, 104);
			// -------------------------------------
			tMap.put("issue_id", ConvertFunction.solBNDID(BONDID.substring(1, 3), BONDID.substring(3, 4), BONDID.substring(4, 6), connection));
			tMap.put("bank_id", ConvertFunction.getBankCodeFromAccount(ACTNO, "ACCOUNT_NO", connection).trim());
			tMap.put("interest_count", IPDSTR);
			//---------
			Calendar tCalendar = Calendar.getInstance();
			tCalendar.set(Calendar.YEAR, Integer.parseInt(YYMM.substring(0, 3)) + 1977);
			tCalendar.set(Calendar.MONTH, Integer.parseInt(YYMM.substring(3, 5)));
			tCalendar.set(Calendar.DAY_OF_MONTH, tCalendar.getMaximum(Calendar.DAY_OF_MONTH));
			tMap.put("exchange_date", tCalendar.get(Calendar.YEAR) + "/" + tCalendar.get(Calendar.MONTH) + "/" + tCalendar.get(Calendar.DAY_OF_MONTH));
			//--------------
			int [] tType = new int[]{100000,500000,1000000,5000000};
			String [] BDTNO = new String[]{BDTNO10,BDTNO50,BDTNO100,BDTNO500};
			String [] YBDTNO = new String[]{YBDTNO10,YBDTNO50,YBDTNO100,YBDTNO500};
			for(int i = 0 ;i < tType.length ; i++){
				tMap.put("ticket_amount", String.valueOf(tType[i]));
				tMap.put("ticket_count", String.valueOf(Integer.valueOf(BDTNO[i]) - Integer.valueOf(YBDTNO[i])));
				tMap.put("total_amount", String.valueOf(Long.valueOf((Integer)tMap.get("ticket_count") * tType[i])));
				run.update(connection, ConvertFunction.insTemp("issue_exchange_ticket_det", tMap));
			}
			// --------------------¤U¤@µ§----------
			tTemp = tInputFileReader.readLine();
		}
	}
}
