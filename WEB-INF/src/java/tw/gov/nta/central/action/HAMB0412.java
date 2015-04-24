package tw.gov.nta.central.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts.action.ActionForm;
import org.apache.struts.tiles.UntyppedAttribute;
import org.apache.struts.upload.FormFile;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.central.common.UnitInfo;
import tw.gov.nta.central.common.UnitPercent;
import tw.gov.nta.central.form.Hama0301Form;
import tw.gov.nta.central.form.Hamb0401Form;
import tw.gov.nta.sql.UnitInfoMain;
import tw.gov.nta.sql.debt.PaymentMain;
import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

public class HAMB0412 extends DefaultAction {
	private StringBuffer sb ;
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		sb = new StringBuffer();
		Hamb0401Form hama0401Form = (Hamb0401Form) form;
		FormFile file = hama0401Form.getFilePath();
		if(file != null && "application/vnd.ms-excel".equals(file.getContentType())){
			List dataList = parseExcel(file);
			SQLRunner run = new ConnectionSQLRunner(connection);
			
			String max = "01";
			SQLJob maxPatchNo = new SQLJob();
			maxPatchNo.appendSQL(" SELECT MAX(RIGHT(PATCHNO,2)) AS PATCHNO FROM FoundaImport WHERE PATCHNO LIKE ? ");
			maxPatchNo.addParameter(DateUtil.ROCDate() + "%");
			Map maxPatchNoMap = (Map)run.query(maxPatchNo,new MapHandler());
			if(maxPatchNoMap != null && maxPatchNoMap.get("PATCHNO") != null && !"".equals(maxPatchNoMap.get("PATCHNO")))
				max = String.valueOf(Integer.parseInt((String)maxPatchNoMap.get("PATCHNO"))+1);
			if(max.length() <= 2)
				max = "00".substring(0,2-max.length()) + max;
			for(Iterator it = dataList.iterator();it.hasNext();){
				Map foundaImportData = (Map)it.next();
				insertFoundaImportData(run,max,hama0401Form.getImpYear(),hama0401Form.getImpMonKind(),foundaImportData,this.getUserId(request));
				updateUnitAllocateMain(run,hama0401Form.getImpYear(),hama0401Form.getImpMonKind(),foundaImportData,this.getUserId(request));
			}
		}else{
			sb.append("檔案格式有誤，請確認副檔名是否為xls").append("\n");
		}
		String alertMessage = sb.toString();
		if(alertMessage != null && !"".equals(alertMessage))
			setAlertMessage(request,"匯入失敗："+alertMessage);
		else
			setAlertMessage(request,"匯入成功!");
	}
	
	private void updateUnitAllocateMain(SQLRunner run, String impYear, String impMonKind, Map foundaImportData, String userId) throws SQLException{
		String debtName = (String)foundaImportData.get("debtName");
		
		for(int i = 3 ; i <= 12 ; i ++){
			Double foundA = (Double)foundaImportData.get(String.valueOf(i));
			String month = "00".substring(0,2-String.valueOf(i).length()) + String.valueOf(i);
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("UPDATE Unit_Allocate_Main SET FOUNDA = ? , ");
			sqljob.appendSQL("Now_Found=SRC_MONEY-Last_Found-?-FOUNDB,");
			sqljob.appendSQL("ALL_MONEY=SRC_MONEY-Last_Found-?-FOUNDB ");
			sqljob.addParameter(foundA);
			sqljob.addParameter(foundA);
			sqljob.addParameter(foundA);
			sqljob.appendSQL("WHERE SEND_DATE IS NULL AND ALL_MONTH=? AND ");
			sqljob.addParameter(impYear + month);
			sqljob.appendSQL(" UNIT_INFO_ID = (SELECT ID FROM Unit_info_main WHERE UNIT_NAME=?) ");
			sqljob.addParameter(debtName);
			sqljob.appendSQL(" AND MON_KIND=? ");
			sqljob.addParameter(impMonKind);
			run.update(sqljob);
		}
		System.out.println(debtName + " 匯入完成");
	}

	private void insertFoundaImportData(SQLRunner run,String maxNo , String impYear, String impMonKind, Map foundaImportData,String userId)throws SQLException {
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO FoundaImport (PATCHNO,UNIT_INFO_ID,ALLYEAR,MON_KIND");
		sqljob.appendSQL(",FOUNDA03,FOUNDA04,FOUNDA05");
		sqljob.appendSQL(",FOUNDA06,FOUNDA07,FOUNDA08,FOUNDA09,FOUNDA10");
		sqljob.appendSQL(",FOUNDA11,FOUNDA12,MOD_DATE,MOD_ACCOUNT)");
		sqljob.appendSQL(" SELECT TOP 1 ?,ID,?,?,?,?,?,?,?,?,?,?,?,?,getDate(),? FROM UNIT_INFO_MAIN WHERE UNIT_NAME = ? ");
		sqljob.addParameter(DateUtil.ROCDate()+maxNo);
		sqljob.addParameter(impYear);
		sqljob.addParameter(impMonKind);
		for(int i = 3 ; i <= 12 ; i ++){
			sqljob.addParameter(foundaImportData.get(String.valueOf(i)));
		}
		sqljob.addParameter(userId);
		sqljob.addParameter(foundaImportData.get("debtName"));
		run.update(sqljob);
	}

	/**
	 * @param file
	 * @return List
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private List parseExcel(FormFile file) throws FileNotFoundException, IOException
	{
		List<HashMap> list = new LinkedList<HashMap>();
		POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		
		//讀取excel的sheet
		HSSFSheet sheet = wb.getSheetAt(0);
		
		if(sheet.getPhysicalNumberOfRows() >= 3){
			int startMonth = 3;
			HSSFRow checkRow = sheet.getRow(3);
			if(checkRow.getLastCellNum() >= 10){
				int month = startMonth , startCell = 1;
				//先檢查第四行月份名稱是否合格
				for(int i = 1 ; i < startCell ; i ++){
					HSSFCell checkCell = checkRow.getCell((short)i);
					if(checkCell != null && !(month+"月").equals(checkCell.getStringCellValue().trim())){
						sb.append("月份名稱不合格!").append("\n");
						break;
					}
					month ++;
				}
				if(sb != null && "".equals(sb.toString())){
				    for(int j=4; j<sheet.getPhysicalNumberOfRows(); j++)
				    {
			            HSSFRow row = sheet.getRow(j);
			            Map<String,Object> map = new HashMap<String,Object>();
			            int monthCount = startMonth;
			            for(int x=0; x<11; x++){
			            	HSSFCell cell = row.getCell((short) x);
			            	if(x==0){
			            		//鄉鎮縣市名稱
			            		map.put("debtName",cell.getStringCellValue());
			            	}else{
			            		//取得各鄉鎮市月份數值
			            		map.put(String.valueOf(monthCount),cell.getNumericCellValue());
			            		monthCount++;
			            	}
			            }
			            list.add((HashMap)map);
				    }
				}
			}
		}
		return list;
	}
	//UNIT_INFO_MAIN
	protected SQLJob unitInfoMainSQL(String tbank1){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select top 1 * from UNIT_INFO_MAIN ");
		sqljob.appendSQL("where 1=1 ");
		sqljob.appendSQLCondition("tbank1 = ? ");
		sqljob.addParameter(tbank1);
		return sqljob;
	}
	//Unit_allocate_main
	protected SQLJob updateUnitAllocateMainSQL(BigDecimal nowFound, String allMonth, String unitID){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("update Unit_allocate_main set now_found = ? where all_month = ? and unit_info_id = ? and mon_kind = 1");
		sqljob.addParameter(nowFound);
		sqljob.addParameter(allMonth);
		sqljob.addParameter(unitID);
		return sqljob;
	}

}
