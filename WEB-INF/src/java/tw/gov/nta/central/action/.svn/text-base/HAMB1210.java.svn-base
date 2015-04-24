package tw.gov.nta.central.action;
import gov.dnt.tame.common.DefaultAction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import tw.gov.nta.central.form.Hamb1201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
public class HAMB1210 extends DefaultAction {
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		Boolean isImport= true;
		
		Hamb1201Form hama1201Form = (Hamb1201Form) form;
		List dataList = parseExcel(hama1201Form.getFilePath());
		SQLRunner run = new ConnectionSQLRunner(connection);
		
		for(Iterator it = dataList.iterator();it.hasNext();){
			Map planMapData = (Map)it.next();
			String tbank1 =  (String)planMapData.get("tbank1");
			List unitInfoMainList = (List)run.query(unitInfoMainSQL(tbank1), new MapListHandler());
			if(null != unitInfoMainList && !unitInfoMainList.isEmpty()){
				Map unitInfoMainMap = (Map)unitInfoMainList.get(0);
				String unitID = unitInfoMainMap.get("id").toString();
				BigDecimal nowFound = (BigDecimal)planMapData.get("nowFound");
				run.update(connection,updateUnitAllocateMainSQL(nowFound,hama1201Form.getQryYear(),unitID));
			}
		}
		setAlertMessage(request,"匯入成功!");
	}
	
	/**
	 * @param file
	 * @return List
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List parseExcel(FormFile file) throws FileNotFoundException, IOException
	{
		List<LinkedHashMap> list = new LinkedList<LinkedHashMap>();
		POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		
		//讀取excel的sheet
		int tmp = 0;
		for(int i=0;i<wb.getNumberOfSheets();i++)
		{
		    HSSFSheet sheet = wb.getSheetAt(i);
		    for(int j=7; j<sheet.getPhysicalNumberOfRows(); j++)
		    {
                HSSFRow row = sheet.getRow(j);
                Map<String,Object> map = new LinkedHashMap<String,Object>();
                for(int x=0; x<10; x++){
                	HSSFCell cell = row.getCell((short) x);
                	if(x!=0){
	                	if(x==9)//匯款金額
	                		map.put("nowFound",(new BigDecimal(cell.getNumericCellValue())).setScale(0,BigDecimal.ROUND_CEILING));
	                	else if(x==8)//收款人名稱
	                		map.put("tbank1",cell.getStringCellValue());
                	}else{
                		if("3".equals(cell.getStringCellValue()))
                			tmp = 1;
                	}
                }
                if(tmp == 1)
                	break;
                list.add((LinkedHashMap) map);
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
