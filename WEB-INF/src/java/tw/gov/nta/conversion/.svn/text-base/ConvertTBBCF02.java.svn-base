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
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.CentralIssueMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.CentralIssueMainDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ConvertTBBCF02 extends ConvertBase {
	private Connection connection = null;
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	@Override
	public void deleteTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob sqlJob = new SQLJob();
		sqlJob.appendSQL("DELETE FROM TB0002");
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
//		設定分割規則
		String splitInfo ="B2ID:X:12,B2TKND:X:1,B2BKND:X:1,B2SYER:X:3,B2SDAT:X:8,"
						+"B2SAMT:9:15,B2CAMT:9:15,B2BRAT:9:6,B2FAMT:9:15,B2GAMT:9:15,"
					    +"B2PAMT:9:15,B2HRAT:9:6,B2LRAT:9:6,B2ARAT:9:6,B2LAMT:9:15,"
					    +"B2DAMT:9:15,B2DUE:X:8,B2NAME:X:50";
		setSplitInfo(splitInfo);
		
		//抓取資料檔案名稱
		setFileName("TBBCF02");
	}
	

	@Override
	public void transIntoTable(Map<String, Object> sourceData) {
		System.out.println(sourceData);
		Map<String, Object> tempMap = new HashMap<String, Object>();
		SQLRunner run = new ConnectionSQLRunner(this.connection);
		SQLJob sqlJob = new SQLJob();
		try{
			/*
			 * 央行轉入檔案缺少國庫券名稱、天期
			 * String issueName = sourceData.get("B2NAME").toString().trim();
			 * String issueDays = issueName.substring(issueName.length() - 3, issueName.length());
			 * issueName = (issueName.substring(0,issueName.length()-5)).trim();
			 */
		
			String issueSerial = ConvertFunction.checkIssueSerial(sourceData.get("B2ID").toString());
			if(Integer.parseInt((String)sourceData.get("B2SYER")) >= 100){
				issueSerial = issueSerial.substring(0,1) + ((String)sourceData.get("B2SYER")).substring(0,1) + issueSerial.substring(2,issueSerial.length());
			}else
				tempMap.put("B2ID",issueSerial);
			System.out.println(issueSerial);
			
			/*
			 * 由系統抓取國庫券名稱、天期
			 */
			IssueMainDAO issuMainDao = IssueMainDAO.getInstance();
			Criteria criteria = issuMainDao.getSession().createCriteria(IssueMain.class,"m");
			criteria.add(Expression.eq("m.issueSerial",issueSerial));	
			List collection = criteria.list();
			IssueMain issueMain = null;
			issueMain = (IssueMain) collection.get(0);
			String issueName = issueMain.getDebtName();
			Date issueDate = issueMain.getIssueDate();
			Date dueDate = issueMain.getDueDate();
			Integer issueDays = DateUtil.getDays(issueDate,dueDate);
			
			tempMap.put("B2TKND",sourceData.get("B2TKND"));
			tempMap.put("B2BKND",sourceData.get("B2BKND"));
			tempMap.put("B2SYER",sourceData.get("B2SYER"));
			tempMap.put("B2SDAT",DateUtil.date2Str(DateUtil.str2Date(sourceData.get("B2SDAT").toString()), "yyyy/MM/dd"));
			tempMap.put("B2SAMT",sourceData.get("B2SAMT"));
			tempMap.put("B2CAMT",sourceData.get("B2CAMT"));
			tempMap.put("B2BRAT",new BigDecimal(sourceData.get("B2BRAT").toString()).divide(new BigDecimal("10000")));
			tempMap.put("B2FAMT",sourceData.get("B2FAMT"));
			tempMap.put("B2GAMT",sourceData.get("B2GAMT"));
			tempMap.put("B2PAMT",sourceData.get("B2PAMT"));
			tempMap.put("B2HRAT",new BigDecimal(sourceData.get("B2HRAT").toString()).divide(new BigDecimal("10000")));
			tempMap.put("B2LRAT",new BigDecimal(sourceData.get("B2LRAT").toString()).divide(new BigDecimal("10000")));
			tempMap.put("B2ARAT",new BigDecimal(sourceData.get("B2ARAT").toString()).divide(new BigDecimal("10000")));
			tempMap.put("B2LAMT",sourceData.get("B2LAMT"));
			tempMap.put("B2DAMT",sourceData.get("B2DAMT"));
//			tempMap.put("B2DUE",DateUtil.date2Str(DateUtil.str2Date(sourceData.get("B2DUE").toString()), "yyyy/MM/dd"));
			tempMap.put("B2DUE",DateUtil.date2Str(dueDate,"yyyy/MM/dd"));//由於央行轉入日期缺少一碼， 故由issume_main代入
			tempMap.put("B2NAME",issueName);
			tempMap.put("B2DAYS",issueDays);
			run.update(ConvertFunction.insTemp("TB0002", tempMap));
			sqlJob.appendSQL("delete from Central_issue_main where issue_serial='"+issueSerial+"'");
			run.update(connection,sqlJob);
			//run.update(ConvertFunction.execSP("sp_tb00002",new String[]{ConvertFunction.checkIssueSerial(sourceData.get("B2ID").toString())}));
			CentralIssueMain dto = new CentralIssueMain();
			String year = sourceData.get("B2SYER").toString();
			if(year.length()<3)
				year = "0"+year;
			dto.setAccountYear(year);
			dto.setAverageRate(new BigDecimal(sourceData.get("B2BRAT").toString()).divide(new BigDecimal("10000")));
			dto.setBidAmount(new BigDecimal(sourceData.get("B2CAMT").toString()));
			dto.setBidRate(new BigDecimal(sourceData.get("B2BRAT").toString()).divide(new BigDecimal("10000")));
			dto.setBondType(sourceData.get("B2TKND").toString());
			dto.setCreateDate(new Date());
			dto.setDebtName(issueName);
//			dto.setDueDate(DateUtil.str2Date(sourceData.get("B2DUE").toString()));
			dto.setDueDate(dueDate);
			dto.setGotbidAmount(new BigDecimal(sourceData.get("B2GAMT").toString()));
			dto.setHightRate(new BigDecimal(sourceData.get("B2HRAT").toString()).divide(new BigDecimal("10000")));
			dto.setIssueAmount(new BigDecimal(sourceData.get("B2SAMT").toString()));
			dto.setIssueDate(DateUtil.str2Date(sourceData.get("B2SDAT").toString()));
			dto.setIssueDays(issueDays);
			dto.setIssueId(Integer.parseInt(ConvertFunction.getIdByIssueSerial(issueSerial,connection)));
			dto.setIssueKind(sourceData.get("B2BKND").toString());
			dto.setIssueSerial(issueSerial);
			dto.setLowRate(new BigDecimal(sourceData.get("B2LRAT").toString()).divide(new BigDecimal("10000")));
			dto.setModDate(new Date());
			dto.setNouseAmount(new BigDecimal(sourceData.get("B2DAMT").toString()));
			dto.setReachbidAmount(new BigDecimal(sourceData.get("B2FAMT").toString()));
			dto.setTotalbidAmount(new BigDecimal(sourceData.get("B2PAMT").toString()));
			dto.setUserid("DNT");
			dto.setSellAmount(new BigDecimal(sourceData.get("B2LAMT").toString()));
			CentralIssueMainDAO dao = new CentralIssueMainDAO();
			dao.save(dto);
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

}
