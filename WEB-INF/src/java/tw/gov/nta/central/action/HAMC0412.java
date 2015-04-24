package tw.gov.nta.central.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
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

public class HAMC0412 extends DefaultAction {
	
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		Boolean isImport= true;
		
		Hamb0401Form hama0401Form = (Hamb0401Form) form;
		List dataList = parseExcel(hama0401Form.getFilePath());
		SQLRunner run = new ConnectionSQLRunner(connection);
		if(null != dataList && !dataList.isEmpty())
			run.update(connection,updateUnitAllocateMain(hama0401Form.getQryYear()));
		
		for(Iterator it = dataList.iterator();it.hasNext();){
			Map planMapData = (Map)it.next();
			String unitName =  (String)planMapData.get("unit_name");
			String[] unitNameR = selectUnitNmae(unitName);
			List unitInfoMainList = (List)run.query(unitInfoMainSQL(unitNameR[0]), new MapListHandler());
			if(null != unitInfoMainList && !unitInfoMainList.isEmpty()){
				Map unitInfoMainMap = (Map)unitInfoMainList.get(0);
				String unitID = unitInfoMainMap.get("id").toString();
				BigDecimal founda = (BigDecimal)planMapData.get("founda");
				run.update(connection,updateUnitAllocateMainSQL(founda,hama0401Form.getQryYear(),unitID,unitNameR[1]));
				run.update(connection,updateUnitAllocateMainSQL2(founda,hama0401Form.getQryYear(),unitID,unitNameR[1]));
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
//		for(int i=0;i<wb.getNumberOfSheets();i++)
//		{
		    HSSFSheet sheet = wb.getSheetAt(0);
		    for(int j=4; j<sheet.getPhysicalNumberOfRows(); j++)
		    {
                HSSFRow row = sheet.getRow(j);
                Map<String,Object> map = new LinkedHashMap<String,Object>();
                for(int x=0; x<10; x++){
                	HSSFCell cell = row.getCell((short) x);
//                	if(x!=0){
	                	if(x==2)//上年度應撥補金額
	                		map.put("founda",(new BigDecimal(cell.getNumericCellValue())).setScale(0,BigDecimal.ROUND_CEILING));
	                	else if(x==0)//地方政府
	                		map.put("unit_name",cell.getStringCellValue());
//                	}else{
//                		if("3".equals(cell.getStringCellValue()))
//                			tmp = 1;
//                	}
                }
                if(tmp == 1)
                	break;
                list.add((LinkedHashMap) map);
		    }
//		}
		return list;
	}
	//UNIT_INFO_MAIN
	protected SQLJob updateUnitAllocateMain(String allMonth){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("update Unit_allocate_main set last_found = 0 ");
		sqljob.appendSQL("where 1=1 ");
		sqljob.appendSQL("and mon_kind = 2 ");
		sqljob.appendSQL("and all_month = ? ");
		sqljob.addParameter(allMonth);
		System.out.println(sqljob.toString());
		return sqljob;
	}
	//UNIT_INFO_MAIN
	protected SQLJob unitInfoMainSQL(String unitName){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select top 1 * from UNIT_INFO_MAIN ");
		sqljob.appendSQL("where 1=1 ");
		sqljob.appendSQLCondition("unit_name = ? ");
		sqljob.addParameter(unitName);
//		System.out.println(sqljob.toString());
		return sqljob;
	}
	//Unit_allocate_main
	protected SQLJob updateUnitAllocateMainSQL(BigDecimal founda, String allMonth, String unitID, String sumType){
		SQLJob sqljob = new SQLJob();
		if("0".equals(sumType)){
			sqljob.appendSQL("update Unit_allocate_main set last_found = ? where all_month = ? and unit_info_id = ? and mon_kind = 2 ");
		}else{
			sqljob.appendSQL("update Unit_allocate_main set last_found = last_found+(?) where all_month = ? and unit_info_id = ? and mon_kind = 2 ");
		}
		sqljob.addParameter(founda);
		sqljob.addParameter(allMonth);
		sqljob.addParameter(unitID);
		if("1".equals(sumType))
			System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob updateUnitAllocateMainSQL2(BigDecimal founda, String allMonth, String unitID, String sumType){
		SQLJob sqljob = new SQLJob();
		if("0".equals(sumType)){
			if(founda.compareTo(new BigDecimal("0")) >= 0){
				sqljob.appendSQL("update Unit_allocate_main set now_found=src_money-last_found,all_money=now_found-founda where all_month = ? and unit_info_id = ? and mon_kind = 2 ");
			}else{
				sqljob.appendSQL("update Unit_allocate_main set now_found=src_money,all_money=src_money+last_found-founda where all_month = ? and unit_info_id = ? and mon_kind = 2 ");
			}
		}else{
			if(founda.compareTo(new BigDecimal("0")) >= 0){
				sqljob.appendSQL("update Unit_allocate_main set now_found=src_money-last_found,all_money=now_found-founda where all_month = ? and unit_info_id = ? and mon_kind = 2 ");
			}else{
				sqljob.appendSQL("update Unit_allocate_main set now_found=src_money,all_money=src_money+last_found-founda where all_month = ? and unit_info_id = ? and mon_kind = 2 ");
			}
		}
//		sqljob.addParameter(founda);
		sqljob.addParameter(allMonth);
		sqljob.addParameter(unitID);
		return sqljob;
	}
	
	protected String[] selectUnitNmae(String unitName){
		String[] returnName = {unitName,"0"};
		String[][] unitNameX = new String[4][];
		//新北市
		unitNameX[0] = new String[] {"台北縣萬里鄉","金山鄉","板橋市","汐止鎮","深坑鄉","石碇鄉","瑞芳鎮","平溪鄉","雙溪鄉","貢寮鄉","新店市","坪林鄉","烏來鄉",
				"永和市","中和市","土城市","三峽鎮","樹林市","鶯歌鎮","三重市","新莊市","泰山鄉","林口鄉","蘆洲市","五股鄉","八里鄉","淡水鎮","三芝鄉","石門鄉",
				"台北縣"};
		//台中市
		unitNameX[1] = new String[] {"台中縣太平市","大里市","霧峰鄉","烏日鄉","豐原市","后里鄉","石岡鄉","東勢鎮","和平鄉","新社鄉","潭子鄉","大雅鄉","神岡鄉",
				"沙鹿鎮","龍井鄉","梧棲鎮","清水鎮","大甲鎮","外埔鄉","大肚鄉","大安鄉","台中縣","台中市"};
		//台南市
		unitNameX[2] = new String[] {"台南縣永康市","歸仁鄉","新化鎮","左鎮鄉","楠西鄉","南化鄉","仁德鄉","關廟鄉","龍崎鄉","官田鄉","麻豆鎮","佳里鎮","西港鄉",
				"將軍鄉","學甲鎮","北門鄉","新營市","後壁鄉","白河鎮","鹽水鎮","柳營鄉","六甲鄉","大內鄉","善化鎮","新市鄉","安定鄉","山上鄉","東山鄉","下營鄉",
				"七股鄉","玉井鄉","台南縣","台南市"};
		//高雄市
		unitNameX[3] = new String[] {"高雄縣仁武鄉","大社鄉","岡山鎮","路竹鄉","阿蓮鄉","田寮鄉","燕巢鄉","橋頭鄉","梓官鄉","彌陀鄉","永安鄉","湖內鄉","鳳山市",
				"大寮鄉","林園鄉","鳥松鄉","大樹鎮","旗山鎮","甲仙鄉","茄定鄉","美濃鎮","內門鄉","杉林鄉","六龜鄉","桃源鄉","三民鄉","茂林鄉","高雄縣"};
		for(int i=0; i<4; i++){
			for(int x=0; x<unitNameX[i].length; x++){
				if(i==0 && unitName.equals(unitNameX[i][x])){
					returnName[0] = "新北市";
					returnName[1] = "1";
				}else if(i==1 && unitName.equals(unitNameX[i][x])){
					returnName[0] = "台中市";
					returnName[1] = "1";
				}else if(i==2 && unitName.equals(unitNameX[i][x])){
					returnName[0] = "台南市";
					returnName[1] = "1";
				}else if(i==3 && unitName.equals(unitNameX[i][x])){
					returnName[0] = "高雄市";
					returnName[1] = "1";
				}
			}
		}
		return returnName;
	}

}
