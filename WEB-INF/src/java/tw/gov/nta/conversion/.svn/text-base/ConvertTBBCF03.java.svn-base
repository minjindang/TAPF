package tw.gov.nta.conversion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ConvertTBBCF03 extends ConvertBase {
	private Connection connection = null;
	private SQLRunner run = new ConnectionSQLRunner(this.connection);
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	@Override
	public void deleteTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
//		SQLRunner run = new ConnectionSQLRunner(connection);
//		SQLJob sqlJob = new SQLJob();
//		sqlJob.appendSQL("DELETE FROM TB0003");
//		try {
//			run.update(sqlJob);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		String splitInfo ="B3ID:X:12,B3ACCT:X:10,B3BRAT:9:6,B3AMT:9:15,"
						+"B3GAMT:9:15,B3FLAG:X:1,B3PRIC:S9:7,B3B5H:S9:6,B3B1T:S9:6,"
						+"B3B5T:S9:6,B3B10T:S9:6,B3B50T:S9:6,B3B100T:S9:6,B3B500T:S9:6,"
						+"B3B1M:S9:6,B3B5M:S9:6,B3B10M:S9:6,B3B50M:S9:6,B3BD100M:S9:6";
		setSplitInfo(splitInfo);
		//抓取資料檔案名稱
		setFileName("TBBCF03");
	}

	@Override
	public void transIntoTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
		Map<String, Object> tempMap = new HashMap<String, Object>();
		SQLRunner run = new ConnectionSQLRunner(connection);
		try{
			String issueSerial = ConvertFunction.checkIssueSerial(sourceData.get("B3ID").toString());
			tempMap.put("B3ID",issueSerial);
			tempMap.put("B3ACCT",sourceData.get("B3ACCT"));
			tempMap.put("B3BRAT",new BigDecimal(sourceData.get("B3BRAT").toString()).divide(new BigDecimal("1000")));
			tempMap.put("B3AMT",sourceData.get("B3AMT"));
			tempMap.put("B3GAMT",sourceData.get("B3GAMT"));
			tempMap.put("B3FLAG",sourceData.get("B3FLAG"));
			tempMap.put("B3PRIC",sourceData.get("B3PRIC"));
			tempMap.put("B3B5H",sourceData.get("B3B5H"));
			tempMap.put("B3B1T",sourceData.get("B3B1T"));
			tempMap.put("B3B5T",sourceData.get("B3B5T"));
			tempMap.put("B3B10T",sourceData.get("B3B10T"));
			tempMap.put("B3B50T",sourceData.get("B3B50T"));
			tempMap.put("B3B100T",sourceData.get("B3100T"));
			tempMap.put("B3B500T",sourceData.get("B3500T"));
			tempMap.put("B3B1M",sourceData.get("B3B1M"));
			tempMap.put("B3B5M",sourceData.get("B3B5M"));
			tempMap.put("B3B10M",sourceData.get("B3B10M"));
			tempMap.put("B3B50M",sourceData.get("B3B50M"));
			tempMap.put("B3B100M",sourceData.get("B3100M"));
			System.out.println(tempMap);
			run.update(ConvertFunction.insTemp("TB0003", tempMap));
			run.update(ConvertFunction.execSP("sp_tb00003",new String[]{issueSerial}));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
