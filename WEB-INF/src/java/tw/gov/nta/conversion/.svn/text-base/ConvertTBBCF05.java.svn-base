package tw.gov.nta.conversion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ConvertTBBCF05 extends ConvertBase {
	private Connection connection = null;
	private SQLRunner run = new ConnectionSQLRunner(this.connection);
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	@Override
	public void deleteTable(Map<String, Object> sourceData) {
//		// TODO Auto-generated method stub
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob sqlJob = new SQLJob();
		sqlJob.appendSQL("DELETE FROM TB0005");
		try {
			run.update(sqlJob);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		String splitInfo ="B5ID:X:12,B5ACCT:X:10,B5PRIC:S9:7,B5BRAT:9:6,B5AMT:9:15,B5TAX:9:15";
		setSplitInfo(splitInfo);
		//抓取資料檔案名稱
		setFileName("TBBCF05");
	}

	@Override
	public void transIntoTable(Map<String, Object> sourceData) {
//		 TODO Auto-generated method stub
		Map<String, Object> tempMap = new HashMap<String, Object>();
		SQLRunner run = new ConnectionSQLRunner(connection);
		try{
			String issueSerial = ConvertFunction.checkIssueSerial(sourceData.get("B5ID").toString());
			tempMap.put("B5ID",issueSerial);
			tempMap.put("B5ACCT",sourceData.get("B5ACCT"));
			tempMap.put("B5PRIC",sourceData.get("B5PRIC"));
			tempMap.put("B5BRAT",new BigDecimal(sourceData.get("B5BRAT").toString()).divide(new BigDecimal("1000")));
			tempMap.put("B5AMT",sourceData.get("B5AMT"));
			tempMap.put("B5TAX",sourceData.get("B5TAX"));
			System.out.println(tempMap);
			run.update(ConvertFunction.insTemp("TB0005", tempMap));
			run.update(ConvertFunction.execSP("sp_tb00003",new String[]{issueSerial}));
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
