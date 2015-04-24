package tw.gov.nta.conversion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapListHandler;

import tw.gov.nta.sql.debt.IssueMain;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ConvertFunction {
	public static String solBNDID(String msYear, String msType, String msPRD, Connection connection) throws SQLException {
		return getIdByIssueSerial(solBNDID(msYear, msType, msPRD), connection);
	}
	public static String solBNDID(String msYear, String msType, String msPRD) {
//		 '''''''''''''''''''''''''''''''''''''
		// '目的:由年度(msYear),類別(msType)
		// '期別(msPrd)取得公債代號(BND_ID)
		// '''''''''''''''''''''''''''''''''''''
		String bndId = null;
		String tempPRD = "0" + msPRD;
		if ("6".equals(msType)) {
			msType = "BCB";
			if ("87".equals(msYear))
				bndId = "BCB0502";
			else
				bndId = msType + tempPRD.substring(tempPRD.length() - 2) + "01";
		}
		if ("4".equals(msType))
			bndId = "BDB" + tempPRD.substring(tempPRD.length() - 2) + "02";
		if ("3".equals(msType))
			bndId = "BDB" + tempPRD.substring(tempPRD.length() - 2) + "01";
		if ("1".equals(msType))
			bndId = msYear + "B" + tempPRD.substring(tempPRD.length() - 2) + "01";

		if(bndId == null || "".equals(bndId.trim()))
			return null;
		return bndId;
	}
	public static String getIdByIssueSerial(String issueSerial, Connection connection) throws SQLException{
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select id from issue_main where issue_serial ='" + issueSerial+"'");
		System.out.println(sqljob.toString());
		List tTempList = ((List) run.query(sqljob, new MapListHandler()));
		if (tTempList == null || tTempList.size() == 0)
			return null;
		return String.valueOf(((Integer)((Map) tTempList.get(0)).get("ID")).intValue());		
	}
	public static String getIssVal(String msIssVal){
		return getIssVal(msIssVal,"1");
	}
	public static String getIssVal(String msIssVal,String type) {
		// type 1 = 數字 ; 2 = 國字
		if(type.equals("1")){
			if ("A".equals(msIssVal))
				return "50000";
			if ("B".equals(msIssVal))
				return "100000";
			if ("C".equals(msIssVal))
				return "500000";
			if ("D".equals(msIssVal))
				return "1000000";
			if ("E".equals(msIssVal))
				return "5000000";
		}
		else{
			if ("A".equals(msIssVal))
				return "五萬";
			if ("B".equals(msIssVal))
				return "十萬";
			if ("C".equals(msIssVal))
				return "五十萬";
			if ("D".equals(msIssVal))
				return "一百萬";
			if ("E".equals(msIssVal))
				return "五百萬";
		}
		return "";
	}
	
	public static String getBankCode(String msKey, Connection connection)
			throws Exception {
		if (msKey == null || "".equals(msKey))
			return null;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT TPSBANK FROM BANKF WHERE TPSBANK = '"
				+ msKey + "'");
		SQLRunner run = new ConnectionSQLRunner(connection);
		List tTempList = ((List) run.query(sqljob, new MapListHandler()));
		if (tTempList == null || tTempList.size() == 0)
			return null;
		sqljob = new SQLJob();
		String bank = ((Map) tTempList.get(0)).get("TPSBANK").toString().substring(0,3);
		sqljob.appendSQL("select id from bank_ref where BANK_CODE =" +((Map) tTempList.get(0)).get("TPSBANK").toString().substring(0,3));
		tTempList = ((List) run.query(sqljob, new MapListHandler()));
		if (tTempList == null || tTempList.size() == 0){
			return null;
		}
		return String.valueOf(((Integer)((Map) tTempList.get(0)).get("ID")).intValue());
	}
	public static String getBankCodeFromAccount(String msKey, String msKey2,
			Connection connection) throws Exception {
		if (msKey == null || msKey2 == null || "".equals(msKey)
				|| "".equals(msKey2))
			return "";
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT BANK_CODE FROM BANKF WHERE " + msKey2 + " = '"
				+ msKey + "'");
		SQLRunner run = new ConnectionSQLRunner(connection);
		List tTempList = ((List) run.query(sqljob, new MapListHandler()));
		if (tTempList == null || tTempList.size() == 0)
			return "";
		return String.valueOf( ((Map) tTempList.get(0)).get("BANK_CODE"));
	}
	
	public static String getTPSBANK(String msKey, String msKey2,
			Connection connection) throws Exception {
		if (msKey == null || msKey2 == null || "".equals(msKey)
				|| "".equals(msKey2))
			return "";
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT TPSBANK FROM BANKF WHERE " + msKey2 + " = '"
				+ msKey + "'");
		SQLRunner run = new ConnectionSQLRunner(connection);
		List tTempList = ((List) run.query(sqljob, new MapListHandler()));
		if (tTempList == null || tTempList.size() == 0)
			return "";
		return String.valueOf( ((Map) tTempList.get(0)).get("TPSBANK"));
	}

	public static BigDecimal traToNum(String msVal) {
		// 沒效率的寫法，姑且用之
		try {
			return new BigDecimal(msVal);
		} catch (NumberFormatException e) {
			String[] A = new String[] { "{", "A", "B", "C", "D", "E", "F", "G","H", "I" };
			//String lastWord = msVal.substring(0,msVal.length() - 1);
			for (int i = 0; i < A.length; i++) {
				if (A[i].equals(msVal))
					return new BigDecimal(msVal.subSequence(0, msVal.length() - 1)
							+ String.valueOf(i));
			}
			String B[] = new String[] { "}", "J", "K", "L", "M", "N", "O", "P",	"Q", "R" };
			for (int i = 0; i < B.length; i++) {
				if (B[i].equals(msVal))
					return new BigDecimal(Integer.parseInt(msVal.subSequence(0, msVal.length() - 1)+String.valueOf(i))* -1);
			}
		}
		return new BigDecimal(0);
	}

	public static String traString(String msString) {
		return msString.replaceAll("{", "0");
	}

	public static BigDecimal reCalNum2(String msString) {
		// Dim i As Integer
		int i = msString.indexOf("}");
		if (msString.startsWith("0000", 0))
			msString = msString.substring(msString.length()-3,msString.length()-1);
			//msString = msString.substring(3, 5);
		if (i > -1)
			return new BigDecimal(Double.parseDouble(msString.substring(0, i) + 0
					+ msString.substring(i + 1, msString.length()))
					* -1);
		else
			return new BigDecimal(msString);
	}
	

	public static BigDecimal reCalNum(String msString){
		int i = msString.indexOf("}");
		if(i > -1)
		   return new BigDecimal(Double.parseDouble(msString.substring(0, i) + 0 + msString.substring(i + 1, msString.length())) * -1 / 100);
		else
		   return new BigDecimal(Double.parseDouble(msString) / 100);
	}
	protected static SQLJob insTemp(String pTableName,Map pMap){
		SQLJob sqljob = new SQLJob();
		pMap.keySet().iterator();
		sqljob.appendSQL("INSERT INTO " + pTableName);
		sqljob.appendSQL(" ( ");
		for(Iterator tIterator = pMap.keySet().iterator(); tIterator.hasNext(); ){
			sqljob.appendSQL((String)tIterator.next());
			if(tIterator.hasNext())
				sqljob.appendSQL(", "); 
		}
		sqljob.appendSQL(" ) VALUES(");
		Object tValue = null;
		for(Iterator tIterator = pMap.keySet().iterator(); tIterator.hasNext(); ){
			tValue = pMap.get(tIterator.next());
			if(tValue == null)
				sqljob.appendSQL("NULL");
			else
				sqljob.appendSQL("'" + tValue + "'");
			if(tIterator.hasNext())
				sqljob.appendSQL(", "); 
		}
		sqljob.appendSQL(")");
		System.out.println("InsertSQL:" + sqljob);
		return sqljob;
	}
	protected static SQLJob delTemp(String pTableName,Map pMap){
		SQLJob sqljob = new SQLJob();
		pMap.keySet().iterator();
		sqljob.appendSQL("DELETE FROM " + pTableName + " where 1=1 ");
		for(Iterator tIterator = pMap.keySet().iterator(); tIterator.hasNext(); ){
			sqljob.appendSQL(" and  ");
			String key = (String)tIterator.next();
			sqljob.appendSQL(key +" = '"+ pMap.get(key)+"'");
		}
		System.out.println("DeleteSQL:" + sqljob);
		return sqljob;
	}
	
	static public BigDecimal transToCounts(String countString) {
		try {
			return new BigDecimal(countString);
		} catch (NumberFormatException e) {
			int stringLength = countString.length();
			String checkString = countString.substring(stringLength - 1, stringLength);
			String[] A = new String[] { "{", "A", "B", "C", "D", "E", "F", "G","H", "I" };
			for (int i = 0; i < A.length; i++) {
				if (A[i].equals(checkString))
					return new BigDecimal(countString.substring(0,stringLength - 1)	+ String.valueOf(i));
			}
			
			String B[] = new String[] { "}", "J", "K", "L", "M", "N", "O", "P",	"Q", "R" };
			for (int i = 0; i < B.length; i++) {
				if (B[i].equals(checkString))
					return new BigDecimal("-"+countString.substring(0,stringLength - 1)+String.valueOf(i));
			}
		}
		return new BigDecimal(0);
	}
	
	static public BigDecimal transToAmount(String amountString) {
		try {
			BigDecimal tempAmount = null;
			if(amountString.indexOf("{")>-1) {
				tempAmount = new BigDecimal(amountString.substring(0,amountString.indexOf("{")));
			}else if(amountString.indexOf("}")>-1){
				tempAmount = new BigDecimal("-"+amountString.substring(0,amountString.indexOf("}")));
			}else {
				tempAmount = new BigDecimal(amountString);
			}
			
			tempAmount = tempAmount.divide(new BigDecimal(10));
			
			return tempAmount;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return new BigDecimal(0);
	}	

	
	static public Integer transToIssueId(String bondId,org.hibernate.Session session) throws Exception {
		String year = bondId.substring(1,3);
		String type = bondId.substring(3,4);
		String period = bondId.substring(4,6);
		String bndId = getBondId(year, type, period);
		
		return getIdByIssueSerial(bndId,session);
	}
	
	private static String getBondId(String year, String type, String period){
		// '''''''''''''''''''''''''''''''''''''
		// '目的:由年度(msYear),類別(msType)
		// '期別(msPrd)取得公債代號(BND_ID)
		// '''''''''''''''''''''''''''''''''''''
		String bndId = null;
		String tempPeriod = "0" + period;
		if ("6".equals(type)) {
			type = "BCB";
			
			if ("87".equals(year))
				bndId = "BCB0502";
			else
				bndId = type + tempPeriod.substring(tempPeriod.length() - 2) + "01";
		}
		if ("4".equals(type))
			bndId = "BDB" + tempPeriod.substring(tempPeriod.length() - 2) + "02";
		if ("3".equals(type))
			bndId = "BDB" + tempPeriod.substring(tempPeriod.length() - 2) + "01";
		if ("1".equals(type))
			bndId = year + "B" + tempPeriod.substring(tempPeriod.length() - 2) + "01";

		if(bndId == null || "".equals(bndId.trim()))
			return null;
		
		System.out.println("$$$BndId:"+bndId);
		
		return bndId;
	}
	

	
	private static Integer getIdByIssueSerial(String issueSerial,org.hibernate.Session session) throws Exception{
		org.hibernate.Query query = session.createQuery("from IssueMain t where t.issueSerial = ?");
		query.setString(0,issueSerial);
		System.out.println(issueSerial);
		List resultList = query.list();
		if (resultList == null || resultList.size() == 0) {
			throw new Exception("找不到對應的發行ID");
		}	

		return ((IssueMain)query.uniqueResult()).getId();	
	}	
	public static SQLJob execSP(String spName , String[] value){
		SQLJob sqlJob = new SQLJob();
		sqlJob.appendSQL("EXEC "+spName);
		if(value != null && value.length >0){
			for(int i = 0 ; i<value.length;i++){
				sqlJob.appendSQL(value[i]);
				if(i < value.length -1 )
					sqlJob.appendSQL(",");
			}
		}
		return sqlJob;
	}
	public static SQLJob execSP(String spName ){
		return execSP(spName,null );
	}
	public static String checkIssueSerial(String issueSerial ){
		int indexStart = issueSerial.indexOf("F");
		int indexMidden = issueSerial.indexOf("-");
		String year = issueSerial.substring(indexStart + 1, indexMidden);
		String serial = issueSerial.substring(indexMidden + 1, issueSerial.length());
		if (year.length()<3)
			year = "0"+year;
		if (serial.length()<2)
			serial = "0"+serial;
		issueSerial = "F"+year+"_"+serial;
		System.out.println(issueSerial);
		return issueSerial;
	}
}
