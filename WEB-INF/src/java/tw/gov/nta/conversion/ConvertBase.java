package tw.gov.nta.conversion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;

public abstract class ConvertBase {
	protected String splitInfo = "";
	protected String fileName = "";
	protected String filePath = "C:\\dntConversion\\";
	protected String fileType = "txt";
	private Connection connection = null;
	private String tableName = "";
	private boolean resetFlag = false;
	
	/**
	 * @return the splitLength
	 */
	
	public String getFullFilePath() {
		return filePath + fileName + "." + fileType;
		//return filePath + fileName;
	}
	

	/**
	 * @param splitLength the splitLength to set
	 */
	public void setSplitInfo(String splitInfo) {
		this.splitInfo = splitInfo;
	}
	
	abstract public void initialize();

	public void initialize(String year,String month,boolean resetFlag){
		this.resetFlag = resetFlag;
		initialize();
	}
	
	
	public void convert() {
		FileReader fileReader = null;
		BufferedReader reader = null;
		try {
			fileReader = new FileReader(getFullFilePath());
			reader = new BufferedReader(fileReader);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String lineString = null;
		int key = 0;
		try {
			boolean exists = checkExists();
			while((lineString = reader.readLine())!=null && (!lineString.trim().equals("")) ) {
				key++;
				Map<String,Object> rowDataMap = getRowDataMap(lineString); 
				//避免資料重複,先刪除相同資料才執行新增
				if(!this.resetFlag&&exists){
					return;
				}
				
				if(key ==1){
					if(this.resetFlag){
						deleteTable(rowDataMap);
					}
				}	
				transIntoTable(rowDataMap);
				System.out.println(key+"--"+lineString);
			}
			//fileReader.close();
			reader.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected boolean checkExists() {
		return true;
	}

	protected Map<String,Object> getRowDataMap(String line) {
		// TODO Auto-generated method stub
//		System.out.println();
		Map<String,Object> dataMap = new HashMap<String, Object>();
		String[] splitArray = splitInfo.split(",");
		int index = 0;

		for(int i=0;i<splitArray.length;i++) {
			String dataColumnName = splitArray[i].split(":")[0];
			String dataColumnType = splitArray[i].split(":")[1];
			int oldIndex = index;
			index = index+Integer.parseInt(splitArray[i].split(":")[2]);
			String dataString = line.substring(oldIndex,index);
			dataMap.put(dataColumnName,convertValue(dataString,dataColumnType));
		}

		return dataMap;
	}

	protected Object convertValue(String dataString, String dataColumnType) {
		// TODO Auto-generated method stub
		Object dataValue = null;
		
		if(dataString==null||dataString.length()==0
				||dataColumnType==null||dataColumnType.length()==0) {
			return dataValue;
		}
		
		if("x".equalsIgnoreCase(dataColumnType)) {
			dataValue = dataString;
		}else if("9".equals(dataColumnType)) {
			dataValue = ConvertFunction.transToCounts(dataString);
		}else if("S9".equals(dataColumnType)) {
			dataValue = ConvertFunction.transToAmount(dataString);
		}
		
		return dataValue;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		if(tableName==null || "".equals(tableName)) {
			return fileName;
		}
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	abstract public void transIntoTable(Map<String, Object> sourceData);
	abstract public void deleteTable(Map<String, Object> sourceData);
	//	轉檔年月的最後一天
	Date getRepayDate(String YYMM){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Calendar calendar = Calendar.getInstance();
		if(YYMM.length()==5){
			calendar.set(Calendar.YEAR,
					Integer.parseInt(YYMM.substring(0, 3)) + 1911);
			calendar
			.set(Calendar.MONTH, Integer.parseInt(YYMM.substring(3, 5)) - 1);
		}else{
			calendar.set(Calendar.YEAR,
					Integer.parseInt(YYMM.substring(0, 2)) + 1911);
			calendar
			.set(Calendar.MONTH, Integer.parseInt(YYMM.substring(2, 4)) - 1);
		}
		
//		System.out.println(YYMM+"長度"+YYMM.length());
		if (YYMM.length()==5 && (Integer.parseInt(YYMM.substring(3, 5)))==2){
			calendar.set(Calendar.DATE,28);
//			System.out.println(YYMM+" 3~5 字元："+Integer.parseInt(YYMM.substring(3, 5)));
		}
		else if(YYMM.length()==4 && (Integer.parseInt(YYMM.substring(2, 4)))==2){
			calendar.set(Calendar.DATE,28);
//			System.out.println(YYMM+" 2~4 字元："+Integer.parseInt(YYMM.substring(2, 4)));
		}
		else if(YYMM.length()==6 && (Integer.parseInt(YYMM.substring(4, 6)))==2){
			calendar.set(Calendar.DATE,28);
		}
		else{
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		}

		String repayDateString = df.format(calendar.getTime());

		Date repayDate = null;
		try {
			repayDate = df.parse(repayDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			repayDate = calendar.getTime();
		}


		return repayDate;
	}

}
