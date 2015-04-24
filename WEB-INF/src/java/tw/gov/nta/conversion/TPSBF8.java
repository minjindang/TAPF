package tw.gov.nta.conversion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class TPSBF8 implements ConvertInterface {

	public void insertData(Connection connection, String path) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		BufferedReader tInputFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"Big5"));
		String tTemp = tInputFileReader.readLine();
		String YY;
		String PD;
		String BANK;
		String BONDID;
		String IPD;
		String PPD;
		String PVAL;
		String SIGN;
		String NO;
		String AMT;
		String PNO;
		String PAMT;
		Map tMap = new HashMap();
		while (tTemp != null) {
			if (tTemp.length() < 59)
				continue;
			YY = tTemp.substring(0, 3);
			PD = tTemp.substring(3, 4);
			BANK = tTemp.substring(4, 11);
			BONDID = tTemp.substring(11, 17);
			IPD = tTemp.substring(17, 19);
			PPD = tTemp.substring(19, 21);
			PVAL = tTemp.substring(21, 22);
			SIGN = tTemp.substring(22, 23);
			NO = tTemp.substring(23, 28);
			AMT = tTemp.substring(28, 41);
			PNO = tTemp.substring(41, 46);
			PAMT = tTemp.substring(46, 59);
			// -------------------------------------
			if ("1".equals(PD))
				tMap.put("EVAL_DATE", String.valueOf(Integer.parseInt(YY) + 1977)+ "/06/30");
			else if ("2".equals(PD))
				tMap.put("EVAL_DATE", String.valueOf(Integer.parseInt(YY) + 1977)+ "/12/31");
			tMap.put("BANK_CODE", ConvertFunction.getBankCode(BANK, connection));
			tMap.put("BND_ID", ConvertFunction.solBNDID(BONDID.substring(1, 3), BONDID.substring(3, 4), BONDID.substring(4, 6), connection));
			tMap.put("BK_VAL", ConvertFunction.getIssVal(PVAL));
			tMap.put("DET_PCS", String.valueOf(ConvertFunction.traToNum(NO)));
			tMap.put("DET_AMT", String.valueOf(ConvertFunction.traToNum(AMT).divide(new BigDecimal(100)) ));
			tMap.put("PAY_PCS", String.valueOf(ConvertFunction.traToNum(PNO)));
			tMap.put("PAY_AMT", String.valueOf(ConvertFunction.traToNum(PAMT).divide(new BigDecimal(100))));
			tMap.put("INT_TIME", IPD);
			tMap.put("PAY_TIME", PPD);
			tMap.put("SIGN_REM", SIGN);
			run.update(connection, ConvertFunction.insTemp("TPSBF8", tMap));
			//--------------------¤U¤@µ§----------
			tTemp = tInputFileReader.readLine();
		}
	}
}
