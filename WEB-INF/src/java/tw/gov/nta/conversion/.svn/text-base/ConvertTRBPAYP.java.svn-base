package tw.gov.nta.conversion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;

import tw.gov.nta.sql.debt.dao.IssueMainDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ConvertTRBPAYP extends ConvertBase {
	
	private Connection connection = null;
	private static final String debt_A_TABLE = "PAIDA";
	private static final String debt_B_TABLE = "FIBTICKET";
	
	public ConvertTRBPAYP(Connection connection) {
		super();
		this.connection = connection;
	}


	@Override
	public void initialize() {
		String splitInfo = 
			"YYY:9:3,"+		//經付年度
			"PERIOD:9:1,"+	//經付期別
			"BOND:X:6,"+		//公債代號
			"PFLAG:X:1,"+	//還本/付息 註記
			"PTIMES:9:3,"+	//還本/付息 期數
			"ACTNO:X:6,"+	//清算銀行存款帳號
			"IAMT:9:15,"+	//撥入基金
			"PAMT:9:15,"+	//本期經付數
			"TAMT:9:15,"+	//累計經付數
			"BAL:9:15,"+		//基金餘額
			"FEE:9:15,"+		//預估手續費
			"RATE:9:4,"+		//費率
			"XAMT:9:15,"+	//調整數
			"AMT:9:15";		//應撥手續費
		this.setSplitInfo(splitInfo);
		this.setFileName("TRBPAYP");
	}

	@Override
	public void transIntoTable(Map<String, Object> sourceData) {
		Map<String, Object> tempMap = new HashMap<String, Object>();
		String bond = (String)sourceData.get("BOND");
		String debtType = bond.substring(0,1);
		SQLRunner run = new ConnectionSQLRunner(this.connection);
		try{
			if (!debtType.equals("T")){
				tempMap.put("P_YEAR",sourceData.get("YYY"));
				tempMap.put("P_PERIOD",sourceData.get("PERIOD"));
				tempMap.put("BOND_ID",sourceData.get("BOND"));
				tempMap.put("P_FLAG",sourceData.get("PFLAG"));
				tempMap.put("P_TIMES",sourceData.get("PTIMES"));
				
				tempMap.put("BANK_CODE",ConvertFunction.getBankCodeFromAccount(sourceData.get("ACTNO").toString(),"ACCOUNT_NO2",this.connection));
				
				tempMap.put("I_AMT",sourceData.get("IAMT"));
				tempMap.put("P_AMT",sourceData.get("PAMT"));
				tempMap.put("T_AMT",sourceData.get("TAMT"));
				tempMap.put("BAL",sourceData.get("BAL"));
				tempMap.put("E_FEE",sourceData.get("FEE"));
				tempMap.put("RATE",sourceData.get("RATE"));
				tempMap.put("X_AMT",sourceData.get("XAMT"));
				tempMap.put("S_FEE",sourceData.get("AMT"));
				run.update(ConvertFunction.insTemp(debt_A_TABLE, tempMap));
			}else{
				tempMap.put("P_YEAR",sourceData.get("YYY"));
				tempMap.put("ISS_PERIOD1",sourceData.get("PERIOD"));
				tempMap.put("BOND_ID",sourceData.get("BOND"));
				tempMap.put("P_FLAG",sourceData.get("PFLAG"));
				tempMap.put("P_TIMES",sourceData.get("PTIMES"));
				
				tempMap.put("BANK_CODE",ConvertFunction.getBankCodeFromAccount(sourceData.get("ACTNO").toString(),"ACCOUNT_NO2",this.connection));
				//tempMap.put("BANK_CODE",sourceData.get("ACTNO"));
				
				tempMap.put("PAY_FUND",sourceData.get("IAMT"));
				tempMap.put("VIA_PAY",sourceData.get("PAMT"));
				tempMap.put("TOTAL_VIAPAY",sourceData.get("TAMT"));
				tempMap.put("FUND_REMAIN",sourceData.get("BAL"));
				tempMap.put("E_FEE",sourceData.get("FEE"));
				tempMap.put("RATE",sourceData.get("RATE"));
				tempMap.put("X_AMT",sourceData.get("XAMT"));
				tempMap.put("S_FEE",sourceData.get("AMT"));
				tempMap.put("ISS_PERIOD",this.getIssPeriod(bond));
				run.update(ConvertFunction.insTemp(debt_B_TABLE, tempMap));
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	@Override
	public void deleteTable(Map<String, Object> sourceData) {
		SQLRunner run = new ConnectionSQLRunner(connection);
		
		try{
			SQLJob sqlJob1 = new SQLJob();
			sqlJob1.appendSQL("DELETE "+ debt_A_TABLE +" WHERE P_YEAR = " + sourceData.get("YYY") + " and P_PERIOD = " + sourceData.get("PERIOD"));
			SQLJob sqlJob2 = new SQLJob();
			sqlJob2.appendSQL("DELETE "+ debt_B_TABLE +" WHERE P_YEAR = " + sourceData.get("YYY") + " and ISS_PERIOD1 = " + sourceData.get("PERIOD"));
			run.update(sqlJob1);
			run.update(sqlJob2);
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	private String getIssPeriod(String bond){
		String flag = bond.substring(4,5);
		String year = bond.substring(1,3);
		String period_1 = bond.substring(5,6);
		String period_2 = bond.substring(4,6);
		String issPeriod = "";
		if (flag.equals("0")){
			issPeriod = "F" + year + "-" + period_1;
		}else{ 
			issPeriod = "F" + year + "-" + period_2;
		}
		return issPeriod;
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
			System.out.println(e);
		}
		
		String lineString = null;
		int key = 0;
		try {
			boolean exists = checkExists();
			while((lineString = reader.readLine())!=null && (!lineString.trim().equals("")) ) {
//				if(!lineString.trim().equals("") && lineString.length()>100)
//				{
//					System.out.println(lineString);
//					System.out.println(lineString.length());
					
					key++;
					Map<String,Object> rowDataMap = getRowDataMap(lineString); 
					//避免資料重複,先刪除相同資料才執行新增
					if(key ==1){
							deleteTable(rowDataMap);
					}	
					transIntoTable(rowDataMap);
					System.out.println(key+"--"+lineString);
				}
//			}
			//fileReader.close();
			reader.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		
	}
}
