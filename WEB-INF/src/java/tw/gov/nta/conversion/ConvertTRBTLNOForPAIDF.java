package tw.gov.nta.conversion;

import gov.dnt.tame.util.DateUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.sql.debt.IssueMain;


public class ConvertTRBTLNOForPAIDF extends ConvertBase {
	private Connection connection = null;
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	@Override
	public void deleteTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
		SQLRunner run = new ConnectionSQLRunner(connection);
		try {
			run.update(ConvertFunction.delTemp("PAIDF", sourceData));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		String splitInfo = "BONDID:X:6,IPDSTR:9:2,ACTNO:X:6,BDTNO100TM:9:5,BDTNO500TM:9:5," +
		"BDTNO1M:9:5,BDTNO5M:9:5,YBDTNO100TM:9:5,YBDTNO500TM:9:5,YBDTNO1M:9:5," +
		"YBDTNO5M:9:5,MBDTNO100TM:9:5,MBDTNO500TM:9:5,MBDTNO1M:9:5,MBDTNO5M:9:5," +
		"YYMM:X:5,IPDEND:9:2,FILLER:X:23";
		setSplitInfo(splitInfo);
//		setFileName("TRBTLNOForPAIDF");
		setFileName("TRBTLNO");
	}

	@Override
	public void transIntoTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
		Map<String, Object> tempMap = new HashMap<String, Object>();
		try {
			String msYear = sourceData.get("BONDID").toString().substring(1,3);
			String msType = sourceData.get("BONDID").toString().substring(3,4);
			String msPrd = sourceData.get("BONDID").toString().substring(4,6);
			String bondId = ConvertFunction.solBNDID(msYear,msType,msPrd);
			System.out.println(bondId);
			String lastDate = DateUtil.date2Str(DateUtil.str2Date(DateUtil.ROCDate2Date(DateUtil.getLastDateOfMonth(sourceData.get("YYMM").toString().substring(0,3), sourceData.get("YYMM").toString().substring(3,5)))), "yyyy/MM/dd");
			IssueMain issueMain = new IssueMain();
			issueMain = new IssueManager().getBean(Integer.parseInt(ConvertFunction.solBNDID(msYear,msType,msPrd,connection)));
			if(sourceData.get("ACTNO").toString().equals("002112"))
				tempMap.put("BANK_CODE",ConvertFunction.getBankCodeFromAccount( "034212", "ACCOUNT_NO",connection));
			else
				tempMap.put("BANK_CODE",ConvertFunction.getBankCodeFromAccount( sourceData.get("ACTNO").toString(), "ACCOUNT_NO",connection));
			tempMap.put("BOND_POLICY", "A");
			if(bondId.substring(1,3).equals("BDB") || bondId.substring(1,3).equals("BCB"))
				tempMap.put("BUDGET_CODE", "B");
			else
				tempMap.put("BUDGET_CODE", "A");
			tempMap.put("BOND_CODE",bondId.substring(0,3));
			tempMap.put("BOND_PERIOD", Integer.parseInt(bondId.substring(5,7)));
			tempMap.put("BOND_MARK", (issueMain.getBondType().equals("1"))?"甲":"乙");
			tempMap.put("PRI_TIMES", "0");
			tempMap.put("INT_TIMES", sourceData.get("IPDSTR"));
			tempMap.put("PCS100T", String.valueOf(Integer.parseInt(sourceData.get("BDTNO100TM").toString())-Integer.parseInt(sourceData.get("MBDTNO100TM").toString())));
			tempMap.put("PCS500T", String.valueOf(Integer.parseInt(sourceData.get("BDTNO500TM").toString())-Integer.parseInt(sourceData.get("MBDTNO500TM").toString())));
			tempMap.put("PCS1M", String.valueOf(Integer.parseInt(sourceData.get("BDTNO1M").toString())-Integer.parseInt(sourceData.get("MBDTNO1M").toString())));
			tempMap.put("PCS5M", String.valueOf(Integer.parseInt(sourceData.get("BDTNO5M").toString())-Integer.parseInt(sourceData.get("MBDTNO5M").toString())));
			//(dblB100TM - dblM100TM) + (dblB500TM - dblM500TM) + (dblB1M - dblM1M) + (dblB5M - dblM5M)
			tempMap.put("TOTAL_PCS", String.valueOf(Integer.parseInt(tempMap.get("PCS100T").toString()) + Integer.parseInt(tempMap.get("PCS500T").toString()) + Integer.parseInt(tempMap.get("PCS1M").toString()) + Integer.parseInt(tempMap.get("PCS5M").toString())));
			//(dblB100TM - dblM100TM) * 100000 + (dblB500TM - dblM500TM) * 500000 + (dblB1M - dblM1M) * 1000000 + (dblB5M - dblM5M) * 5000000
			tempMap.put("TOTAL_AMT", String.valueOf((Integer.parseInt(tempMap.get("PCS100T").toString()) * 100000) + (Integer.parseInt(tempMap.get("PCS500T").toString()) * 500000) + (Integer.parseInt(tempMap.get("PCS1M").toString()) * 1000000) + (Integer.parseInt(tempMap.get("PCS5M").toString()) * 5000000)));
			tempMap.put("TX_DATE",lastDate);
			tempMap.put("new_user", "DNT_Convert");
			deleteTable(tempMap);
			SQLRunner run = new ConnectionSQLRunner(connection);
			run.update(ConvertFunction.insTemp("PAIDF", tempMap));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
//				if(!this.resetFlag&&exists){
//					return;
//				}				
//				if(key ==1){
//					if(this.resetFlag){
//						deleteTable(rowDataMap);
//					}
//				}	
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
