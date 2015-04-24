package tw.gov.nta.conversion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;

public class TPSBF7 implements ConvertInterface {

	public void insertData(Connection connection, String path) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		BufferedReader tInputFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"Big5"));
		String tTemp = tInputFileReader.readLine();
		String YYMM;
		String BANK;
		String BONDID;
		String PFLAG;
		String PTIMES;
		String PVAL;
		String SIGN;
		String NO;
		String AMT;
		String NOL;
		String AML;
		String NOT;
		String AMTT;
		//----------------
//		String BND_ID;
//		String EVL_DTE;
//		String TPSPICD;
//		String TPSPIPD;
//		String TPSPVAL;
//		String TPSNO;
//		String TPSAMT;
//		String TPSNOL;
//		String TPSAML;
		
		Map tMap = new HashMap();
		while (tTemp != null) {
			if (tTemp.length() < 77)
				continue;

			tTemp = tTemp.replaceAll("\\{", "0");
			YYMM = tTemp.substring(0, 5);
			BANK = tTemp.substring(5, 12);
			BONDID = tTemp.substring(12, 18);
			PFLAG = tTemp.substring(18, 19);
			PTIMES = tTemp.substring(19, 21);
			PVAL = tTemp.substring(21, 22);
			SIGN = tTemp.substring(22, 23);
			NO = tTemp.substring(23, 28);
			AMT = tTemp.substring(28, 41);
			NOL = tTemp.substring(41, 46);
			AML = tTemp.substring(46, 59);
			NOT = tTemp.substring(59, 64);
			AMTT = tTemp.substring(64, 77);
			// -------------------------------------
			Calendar tCalendar = Calendar.getInstance();
			tCalendar.set(Calendar.YEAR, Integer.parseInt(YYMM.substring(0, 3)) + 1911);
			tCalendar.set(Calendar.MONTH, Integer.parseInt(YYMM.substring(3, 5)));
			tCalendar.set(Calendar.DAY_OF_MONTH, tCalendar.getMaximum(Calendar.DAY_OF_MONTH));
			if(tCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				tCalendar.roll(Calendar.DAY_OF_MONTH, 1);
			tMap.put("EVL_DTE", tCalendar.get(Calendar.YEAR) + "/" + tCalendar.get(Calendar.MONTH) + "/" + tCalendar.get(Calendar.DAY_OF_MONTH));
			tMap.put("BND_ID", ConvertFunction.solBNDID(BONDID.substring(1, 3), BONDID.substring(3, 4), BONDID.substring(4, 6), connection));
			tMap.put("BANK_ID", ConvertFunction.getBankCode(BANK, connection));
			tMap.put("TPSPVAL", ConvertFunction.getIssVal(PVAL));
			tMap.put("TPSNO", ConvertFunction.reCalNum2(NO.substring(0, NO.length() - 1)).add(ConvertFunction.traToNum(NO.substring(NO.length() - 1))));
			tMap.put("TPSAMT", new BigDecimal(String.valueOf(ConvertFunction.reCalNum(AMT))));
			tMap.put("TPSNOL", String.valueOf(ConvertFunction.reCalNum2(NOL.substring(0, NOL.length() - 1)).add(ConvertFunction.traToNum(NOL.substring(NOL.length() - 1)))));
			tMap.put("TPSAML", String.valueOf(ConvertFunction.reCalNum(AML)));
			tMap.put("TPSPICD", PFLAG);
			tMap.put("TPSPIPD", PTIMES);
			tMap.put("TPSSIGN", SIGN);
			tMap.put("TPSNOT", String.valueOf(ConvertFunction.reCalNum2(NOT.substring(0, NOT.length() - 1)).add(ConvertFunction.traToNum(NOT.substring(NOT.length() - 1)))));
			tMap.put("TPSAMTT", new BigDecimal(String.valueOf(ConvertFunction.reCalNum(AMTT))));
			run.update(connection, ConvertFunction.insTemp("TPSBF7", tMap));
			
			// --------------------¤U¤@µ§----------
			tTemp = tInputFileReader.readLine();
		}
	}
}
