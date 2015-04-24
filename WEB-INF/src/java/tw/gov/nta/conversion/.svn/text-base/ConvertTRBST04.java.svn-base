package tw.gov.nta.conversion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;

public class ConvertTRBST04 extends ConvertBase {
	private Connection connection = null;
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	@Override
	public void deleteTable(Map<String, Object> sourceData) {
		SQLRunner run = new ConnectionSQLRunner(connection);
		try {
			run.update(ConvertFunction.delTemp("TRBST04", sourceData));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize() {
		String splitInfo = "YYYMM:X:5,ACTNO:X:6,BONDID:X:6,AMT1:9:12,AMT2:9:12,"+
			"AMT3:9:12,AMT4:9:12,AMT5:9:12,AMT6:9:12,AMT7:9:12,AMT8:9:12,"+
			"AMT9:9:12,AMT10:9:12,AMT11:9:12";
		setSplitInfo(splitInfo);
		setFileName("TRBST04");
	}

	@Override
	public void transIntoTable(Map<String, Object> sourceData) {
		try {
			sourceData.put("MOD_DATE",new java.sql.Date(new Date().getTime()));
			sourceData.put("FILE_CODE","TRBST04");
			//估計這支轉檔如果每天執行的話，每次都會將該table相同的資料刪除再新增一次
			//如果造成執行效能低弱的話，必須使用其他處理方式看看
			deleteTable(sourceData);
			SQLRunner run = new ConnectionSQLRunner(connection);
			run.update(ConvertFunction.insTemp("TRBST04", sourceData));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private boolean resetFlag = false;
	@Override
	public void convert() {
		FileReader fileReader = null;
		BufferedReader reader = null;
		try {
			fileReader = new FileReader(getFullFilePath());
			reader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String lineString = null;
		int key = 0;
		try {
			boolean exists = checkExists();
			while((lineString = reader.readLine())!=null && (!lineString.trim().equals("")) ) {
				key++;
				Map<String,Object> rowDataMap = getRowDataMap(lineString); 
				transIntoTable(rowDataMap);
				System.out.println(key+"--"+lineString);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
