package tw.gov.nta.central.common;

import gov.dnt.tame.util.DateUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.io.FileUtils;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class Service {
	private String LengthFillter(String pData, int pLength){
		if(pData.getBytes().length == pLength)
			return pData;
		if(pData.getBytes().length > pLength)
			return pData.substring(0,pLength);
		return LengthFillter("0" + pData, pLength);
	}
	private String LengthFillterEmpty(String pData, int pLength){
		if(pData.getBytes().length == pLength)
			return pData;
		if(pData.getBytes().length > pLength)
			return pData.substring(0,pLength);
		return LengthFillterEmpty( pData + " ", pLength);
	}
	private String LengthFillterEmptyLeft(String pData, int pLength){
		if(pData.getBytes().length == pLength)
			return pData;
		if(pData.getBytes().length > pLength)
			return pData.substring(0,pLength);
		return LengthFillterEmptyLeft( " "+pData , pLength);
	}
	public String ChangeName(String pData,String pUnitName,String pAmount){
		//$1政府中央統籌分配款$2元
		System.out.println(pData.length());
		String newData = "";
		newData += pData.substring(0,pData.indexOf("$1"))+pUnitName+pData.substring(pData.indexOf("$1")+2,pData.indexOf("$2"))+pAmount+pData.substring(pData.indexOf("$2")+2,pData.length());
		System.out.println(newData);
		return newData;
	}
	public void executeQuery(String pYear, String pMonth, String pKind, String pPath, Connection connection) throws Exception {
		System.out.println(pPath);
		BufferedWriter tOutputFileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pPath), "Big5"));
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//SQL1
		SQLJob tSqlJob1 = new SQLJob();
		tSqlJob1.appendSQL("Select BANKNO,MON_NO,MON_KIND,PNAME From Taxaction_det where 1 = 1");
		if(pYear != null && !"".equals(pYear))
			tSqlJob1.appendSQL(" and TAX_YEAR=" + pYear );
		if(pYear != null && !"".equals(pMonth))
			tSqlJob1.appendSQL(" and TAX_MONTH=" + pMonth );
		if(pYear != null && !"".equals(pKind))
			tSqlJob1.appendSQL(" and TAX_KIND=" + pKind );
		//SQL2
		SQLJob tSqlJob2 = new SQLJob();
		tSqlJob2.appendSQL("Select A.UNIT_NAME,A.SNO1,A.TACCT1,A.TBANK1,A.SNO2,A.TACCT2,A.TBANK2,A.NOTEA,A.NOTEB,B.Now_Found ,B.All_MONEY,B.FoundA,B.FoundB From Unit_info_main A, Unit_allocate_main B where 1 = 1 And A.ID = B.Unit_Info_id ");
		if(pYear != null && !"".equals(pYear))
			tSqlJob2.appendSQL(" and B.All_YEAR=" + pYear);
		if(pYear != null && !"".equals(pMonth))
			tSqlJob2.appendSQL(" and B.All_MONTH=" + pMonth );
		if(pYear != null && !"".equals(pKind))
			tSqlJob2.appendSQL(" and B.MON_KIND=" + pKind );
		tSqlJob2.appendSQL("ORDER BY a.groupid,A.SEQ_NO");
		//-----------------------
		System.out.println(tSqlJob1.toString());
		System.out.println(tSqlJob2.toString());
		List queryList1 = (List) run.query(tSqlJob1, new MapListHandler());
		if(queryList1.size() != 0){
	
			Map tMap = (Map) queryList1.get(0);
//			Calendar tCalendar = Calendar.getInstance();
			String tBankNo = LengthFillter((tMap.get("BANKNO") != null )?(String)tMap.get("BANKNO"):"0", 3);
			String monNo = (String)tMap.get("MON_NO");
			String tMon_No = "";
			if(!"1".equals(monNo.substring(0,1)))
				tMon_No = LengthFillter((tMap.get("MON_NO") != null )?(String)tMap.get("MON_NO"):"0", 10);
			else {
				tMon_No = LengthFillter((tMap.get("MON_NO") != null )?(String)tMap.get("MON_NO"):"0", 11);
				tMon_No = tMon_No.substring(1,tMon_No.length());
			}
			//String tYear = String.valueOf(tCalendar.get(Calendar.YEAR) - 1911); 原設計為系統日經USER測試更改為SQL1.MON_NO
			String tDate = "";
//			if(!"1".equals(monNo.substring(0,1)))
				tDate = tMon_No.substring(0,6);
//			else
//				tDate = tMon_No.substring(1,6);
//			String tMonth = LengthFillter(String.valueOf(tCalendar.get(Calendar.MONTH)), 2);
//			String tDay = LengthFillter(String.valueOf(tCalendar.get(Calendar.DAY_OF_MONTH)), 2);
			String tPName = LengthFillterEmpty((tMap.get("PNAME")!= null)?(String)tMap.get("PNAME"):" ", 68);
			String tmonKind = LengthFillter((tMap.get("MON_KIND") != null )?(String)tMap.get("MON_KIND"):"0", 2);
			//首筆
			//tOutputFileWriter.write("1" + tBankNo + tMon_No + "00000" + tYear + tMonth + tDay + LengthFillterEmpty("\n",23) + tPName + LengthFillterEmpty("\n",68));
			tOutputFileWriter.write("1" + tBankNo + tMon_No + "00000" + tDate + LengthFillterEmpty(" ",23) + tPName + LengthFillterEmpty(" ",68));
			tOutputFileWriter.newLine();
			tOutputFileWriter.flush();
			tMap = null;
			int tIndex = 0;
			String tSno;
			String tTacct;
			String tTbank;
			String tAllMoney;
			String tNote;
			BigDecimal tAllMoneyDecimal = new BigDecimal(0);
			BigDecimal tFoundA;
			BigDecimal tFoundB;
			BigDecimal tTotalMoney = new BigDecimal(0);
			for(Iterator tIterator = ((List)run.query(tSqlJob2, new MapListHandler())).iterator(); tIterator.hasNext(); ){
				tIndex++;
				tMap = (Map) tIterator.next();
				System.out.println(tMap);
				tSno = LengthFillter((tMap.get("SNO" + pKind)!= null )?(String)tMap.get("SNO" + pKind):"0", 7);
				tTacct = LengthFillter((tMap.get("TACCT" + pKind) != null )?(String)tMap.get("TACCT" + pKind):"0", 14);
				tTbank = LengthFillterEmpty((tMap.get("TBANK" + pKind) != null )?(String)tMap.get("TBANK" + pKind):" ", 68);
				if("1".equals(pKind))
					tNote = (tMap.get("NOTEA") != null)?(String)tMap.get("NOTEA"):" ";
				else
					tNote = (tMap.get("NOTEB") != null )?(String)tMap.get("NOTEB"):" ";
//				tAllMoney_Decimal = (tMap.get("All_MONEY") != null )?(BigDecimal)tMap.get("All_MONEY"):new BigDecimal(0);
//				tFoundA = (tMap.get("FoundA") != null )?(BigDecimal)tMap.get("FoundA"):new BigDecimal(0);
//				tFoundB = (tMap.get("FoundB") != null )?(BigDecimal)tMap.get("FoundB"):new BigDecimal(0);
//				tAllMoney_Decimal = tAllMoney_Decimal.subtract(tFoundA).subtract(tFoundB).setScale(2,5);
//				tTotalMoney = tTotalMoney.add(tAllMoney_Decimal).setScale(2);
//				tAllMoney = String.valueOf(tAllMoney_Decimal.setScale(0,5));
				if("1".equals(pKind))
					tAllMoney = (tMap.get("Now_Found") != null )?new BigDecimal(tMap.get("Now_Found").toString()).setScale(0,BigDecimal.ROUND_HALF_UP).toString():"0";
				else
					tAllMoney = (tMap.get("All_MONEY") != null )?new BigDecimal(tMap.get("All_MONEY").toString()).setScale(0,BigDecimal.ROUND_HALF_UP).toString():"0";
				tAllMoneyDecimal = new BigDecimal(tAllMoney);
				tAllMoney = LengthFillterEmptyLeft(tAllMoney,12);
				tTotalMoney = tTotalMoney.add(tAllMoneyDecimal).setScale(0,BigDecimal.ROUND_HALF_UP);
				//明細
				//tOutputFileWriter.write("2" + tBankNo + tMon_No + LengthFillter(String.valueOf(tIndex), 5) + tYear + tMonth + tDay + tSno + tMon_No + tTacct + tTbank + LengthFillter(tAllMoney.split("0")[0], 12) + LengthFillter(tAllMoney.split("0")[1], 2) + tNote);
				tOutputFileWriter.write("2" + tBankNo + tMon_No + LengthFillterEmptyLeft(String.valueOf(tIndex), 5) + tDate + tSno + tmonKind + tTacct + tTbank + tAllMoney + "00" + ChangeName(tNote,(String)tMap.get("UNIT_NAME"),tAllMoney));
				tOutputFileWriter.newLine();
			}
//			String tTotalMoneys = String.valueOf(tTotalMoney.setScale(0,5));
//			System.out.println(tTotalMoneys);
			//尾筆
			//tOutputFileWriter.write("3" + tBankNo + tMon_No + "99999" + tYear + tMonth + tDay + LengthFillter(String.valueOf(tIndex), 4) + LengthFillter(tTotalMoneys.split("0")[0], 12) + LengthFillter(tTotalMoneys.split("0")[1], 2) + "                                                                                                                                         ");
			tOutputFileWriter.write("3" + tBankNo + tMon_No + "99999" + tDate + LengthFillterEmptyLeft(String.valueOf(tIndex), 4) + LengthFillterEmptyLeft(tTotalMoney.toString(), 12) + "00" + LengthFillterEmpty(" ",137));
			tOutputFileWriter.newLine();
		}
		tOutputFileWriter.flush();
		tOutputFileWriter.close();
	}
	public void executeQuery(String pYear, String pMonth, String pKind, String pPath, Connection connection,  HttpServletResponse response) throws Exception {
		this.executeQuery(pYear, pMonth, pKind, pPath, connection);
		this.DownLoad(response,pPath);
	}
	@SuppressWarnings("static-access")
	public void DownLoad(HttpServletResponse response , String pPath)throws Exception {
//		response.setLocale(java.util.Locale.TAIWAN);
		response.setContentType("application/text");
		File outFile = new File(pPath);
		byte[] bytes = FileUtils.readFileToByteArray(outFile);
		String tPath = new String(pPath.getBytes("Big5"), "ISO-8859-1");
		response.setHeader("Content-disposition","attachment; filename=\"payment.txt\"");
		OutputStream os = response.getOutputStream();
		os.write(bytes);
		os.flush();
		os.close();
		response.setStatus( response.SC_OK );
		response.flushBuffer();
	}
}
