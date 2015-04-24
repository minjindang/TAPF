package tw.gov.nta.conversion;

import gov.dnt.tame.util.DateUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapListHandler;

import tw.gov.nta.sql.debt.AheadpayMain;
import tw.gov.nta.sql.debt.CentralIssueMain;
import tw.gov.nta.sql.debt.dao.AheadpayMainDAO;
import tw.gov.nta.sql.debt.dao.CentralIssueMainDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ConvertTBBCF04 extends ConvertBase {
	private Connection connection = null;
	private SQLRunner run = new ConnectionSQLRunner(this.connection);
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	@Override
	public void deleteTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob sqlJob = new SQLJob();
		sqlJob.appendSQL("DELETE FROM TB0004");
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
		String splitInfo ="B4ID:X:12,B4TKND:X:1,B4BKND:X:1,B4SYER:X:3,B4SDAT:X:8,"
						+"B4SAMT:S9:15,B4CAMT:S9:15,B4BRAT:S9:6,B4BAMT:S9:15,B4AMT:S9:15,B4RAMT:S9:15," 
						+"B4HRAT:9:6,B4LRAT:9:6,B4ARAT:9:6,B4DUE:X:8,B4DAYS:X:3,B4NAME:X:33," 
						+"B4BDAT:X:8";
		setSplitInfo(splitInfo);
		//抓取資料檔案名稱
		setFileName("TBBCF04");
	}

	@Override
	public void transIntoTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
		Map<String, Object> tempMap = new HashMap<String, Object>();
		SQLRunner run = new ConnectionSQLRunner(connection);
		AheadpayMain dto = new AheadpayMain();
		try{
				tempMap.put("B4ID",sourceData.get("B4ID"));
				tempMap.put("B4TKND",sourceData.get("B4TKND"));
				tempMap.put("B4BKND",sourceData.get("B4BKND"));
				tempMap.put("B4SYER",sourceData.get("B5AMT"));
				tempMap.put("B4SYER",sourceData.get("B4SYER"));
				tempMap.put("B4SDAT",DateUtil.date2Str(DateUtil.str2Date(sourceData.get("B4SDAT").toString()), "yyyy/MM/dd"));
				tempMap.put("B4SAMT",sourceData.get("B4SAMT"));
				tempMap.put("B4CAMT",sourceData.get("B4CAMT"));
				tempMap.put("B4BRAT",new BigDecimal(sourceData.get("B4BRAT").toString()).divide(new BigDecimal("1000")));
				tempMap.put("B4BAMT",sourceData.get("B4BAMT"));
				tempMap.put("B4RAMT",sourceData.get("B4RAMT"));
				tempMap.put("B4HRAT",new BigDecimal(sourceData.get("B4HRAT").toString()).divide(new BigDecimal("1000")));
				tempMap.put("B4LRAT",new BigDecimal(sourceData.get("B4LRAT").toString()).divide(new BigDecimal("1000")));
				tempMap.put("B4ARAT",new BigDecimal(sourceData.get("B4ARAT").toString()).divide(new BigDecimal("1000")));
				tempMap.put("B4DUE",DateUtil.date2Str(DateUtil.str2Date(sourceData.get("B4DUE").toString()), "yyyy/MM/dd"));
				tempMap.put("B4DAYS",sourceData.get("B4DAYS"));
				tempMap.put("B4NAME",sourceData.get("B4NAME"));
				if (!sourceData.get("B4BDAT").toString().trim().equals(""))
					tempMap.put("B4BDAT",DateUtil.date2Str(DateUtil.str2Date(sourceData.get("B4BDAT").toString()), "yyyy/MM/dd"));
				System.out.println(tempMap);
				run.update(ConvertFunction.insTemp("TB0004", tempMap));

				//0970624修改
				String issueSerial = ConvertFunction.checkIssueSerial(sourceData.get("B4ID").toString());
				if(Integer.parseInt((String)tempMap.get("B4SYER")) >= 100){
					issueSerial = issueSerial.substring(0,1)+
								  ((String)tempMap.get("B4SYER")).substring(0,1)+
								  issueSerial.substring(2,issueSerial.length());
				}
				
				Integer issueId = Integer.parseInt(ConvertFunction.getIdByIssueSerial(issueSerial,connection));
				dto.setIssueId(issueId);
				
				//查詢該期是否已做過轉檔
				List tList = (List) run.query(sqlTemp(issueId), new MapListHandler());

				if (tList.isEmpty()){
					dto.setIssueSerial(issueSerial);
					dto.setBondType(Integer.parseInt(sourceData.get("B4BKND").toString()));
					dto.setAccountYear(sourceData.get("B4SYER").toString());
					dto.setIssueDate(DateUtil.str2Date(sourceData.get("B4SDAT").toString()));
					dto.setIssueAmount(new BigDecimal(sourceData.get("B4SAMT").toString()).multiply(new BigDecimal(10)));
					dto.setBidAmount(new BigDecimal(sourceData.get("B4CAMT").toString()).multiply(new BigDecimal(10)));
					dto.setBidRate(new BigDecimal(sourceData.get("B4BRAT").toString()).divide(new BigDecimal("1000")));
					dto.setGotbidAmount(new BigDecimal(sourceData.get("B4BAMT").toString()).multiply(new BigDecimal(10)));
					dto.setInterestAmount(new BigDecimal(sourceData.get("B4RAMT").toString()).multiply(new BigDecimal(10)));
					dto.setOrgissueAmount(new BigDecimal(sourceData.get("B4AMT").toString()).multiply(new BigDecimal(10)));
					dto.setLowRate(new BigDecimal(sourceData.get("B4BRAT").toString()).divide(new BigDecimal("1000")));
					dto.setHightRate(new BigDecimal(sourceData.get("B4HRAT").toString()).divide(new BigDecimal("10000")));
					dto.setAverageRate(new BigDecimal(sourceData.get("B4ARAT").toString()).divide(new BigDecimal("10000")));
					dto.setDueDate(DateUtil.str2Date(sourceData.get("B4DUE").toString()));
					dto.setDebtName(sourceData.get("B4NAME").toString());
					dto.setIssueDays(Integer.parseInt(sourceData.get("B4DAYS").toString().trim()));
					if (!sourceData.get("B4BDAT").toString().trim().equals(""))
						dto.setAheadDate(DateUtil.str2Date(sourceData.get("B4BDAT").toString()));				
					dto.isManager();
					dto.setUserId("dnt");
					dto.setModDate(DateUtil.str2Date(DateUtil.date2Str(new Date(),"yyyy/MM/dd" ).toString()));
					AheadpayMainDAO dao = new AheadpayMainDAO();
					dao.save(dto);
					
				}else{
					System.out.println("已轉檔");
				}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
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
			
			while((lineString = reader.readLine())!=null && (!lineString.trim().equals("")) ) {
				key++;
				Map<String,Object> rowDataMap = getRowDataMap(lineString); 

				deleteTable(rowDataMap);	
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

	protected SQLJob sqlTemp(Integer issueId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select * from aheadpay_main where issue_id = "+issueId+ "");
		System.out.println(sqljob.toString());
		return sqljob;
	}
}
