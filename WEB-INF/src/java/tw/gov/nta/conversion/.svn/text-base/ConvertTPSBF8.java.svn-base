package tw.gov.nta.conversion;

import gov.dnt.tame.util.Numeral2Chinese;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.sql.debt.dao.IssueExchangeTicketMainDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class ConvertTPSBF8 extends ConvertBase {
	private IssueMainDAO dao = new IssueMainDAO();
	private Session session = dao.createNewSession();
	private Connection connection = session.connection();
	@Override
	public void initialize() {
		String splitInfo = "YY:9:3,PD:9:1,BANK:X:7,BONDID:X:6,IPD:9:2,"
			+ "PPD:9:2,PVAL:X:1,SIGN:X:1,NO:9:5,AMT:9:13,"
			+ "PNO:9:5,PAMT:S9:13";
	setSplitInfo(splitInfo);
	setFileName("TPSBF8");
	}
	@Override
	public void transIntoTable(Map<String, Object> sourceData){
		Map<String, Object> tempMap = new HashMap<String, Object>();
		int year = Integer.parseInt(sourceData.get("YY").toString())+11;
		try{
			if(sourceData.get("PD").toString().equals("1"))
				tempMap.put("EVAL_DATE",new Date(year,5,30));
			else
				tempMap.put("EVAL_DATE",new Date(year,11,31));
			tempMap.put("BANK_CODE",ConvertFunction.getBankCodeFromAccount( sourceData.get("BANK").toString(), "tpsbank",connection));
			String msYear = sourceData.get("BONDID").toString().substring(1,3);
			String msType = sourceData.get("BONDID").toString().substring(3,4);
			String msPrd = sourceData.get("BONDID").toString().substring(4,6);
			tempMap.put("BND_ID", ConvertFunction.solBNDID(msYear,msType,msPrd));
			tempMap.put("INT_TIME", sourceData.get("IPD"));
			tempMap.put("PAY_TIME", sourceData.get("PPD"));
			tempMap.put("BK_VAL", ConvertFunction.getIssVal(sourceData.get("PVAL").toString(),"2"));
			tempMap.put("SIGN_REM", sourceData.get("SIGN"));
			tempMap.put("DET_PCS", sourceData.get("NO").toString());
			tempMap.put("DET_AMT", ConvertFunction.transToAmount(sourceData.get("AMT").toString()).multiply(new BigDecimal(0.1)));
			tempMap.put("PAY_PCS", sourceData.get("PNO"));
			tempMap.put("PAY_AMT", ConvertFunction.transToAmount(sourceData.get("PAMT").toString()).multiply(new BigDecimal(1000)));
			SQLRunner run = new ConnectionSQLRunner(connection);
			run.update(ConvertFunction.insTemp(this.getTableName(), tempMap));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	@Override
	public void deleteTable(Map<String, Object> sourceData){
		//避免資料重複,先刪除相同資料才執行新增
		try{
			SQLRunner run = new ConnectionSQLRunner(connection);
			SQLJob sqlJob = new SQLJob();
			int year = Integer.parseInt(sourceData.get("YY").toString())+11;
			Date evalDate = new Date(year, 0, 0);
			if(sourceData.get("PD").toString().equals("1"))
				evalDate = new Date(year,5,30);
			else
				evalDate = new Date(year,11,31);
			String[] tableName = {"TPSBF8"};
			for(int i = 0 ; i < tableName.length ; i++){
				sqlJob.appendSQL("DELETE FROM "+ tableName[i] +" WHERE EVAL_DATE = '" + evalDate + "'");
			}
			run.update(sqlJob);
		}
		catch(Exception e){
			System.out.println(e);
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
				
				if(key ==1){
					deleteTable(rowDataMap);
				}
				
				transIntoTable(rowDataMap);
			}
			//fileReader.close();
			reader.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
