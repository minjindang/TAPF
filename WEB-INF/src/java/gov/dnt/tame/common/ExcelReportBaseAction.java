package gov.dnt.tame.common;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.kangdainfo.ast.sql.SQLJob;

public abstract class ExcelReportBaseAction extends DefaultAction {

	private Log log = LogFactory.getLog(this.getClass());
	private static Map<String,Object> commonMap = new HashMap<String,Object>();

	public SQLJob delSQLJob(String pTableName,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" DELETE FROM " + pTableName);
		//sqljob.appendSQL(" WHERE USRID=?");
		//sqljob.addParameter( usrId );
		log.trace("delSQLJob:" +sqljob);
		System.out.println(sqljob);
		return sqljob;
	}
	
	public SQLJob delSQLJob(String pTableName,String usrId,String sqlStr){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" DELETE FROM " + pTableName + " where 1=1 ");
		sqljob.appendSQL(sqlStr);
		//sqljob.appendSQL(" WHERE USRID=?");
		//sqljob.addParameter( usrId );
		log.trace("delSQLJob:" +sqljob);
		System.out.println(sqljob);
		return sqljob;
	}

	protected SQLJob insTemp(String pTableName,Map pMap){
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
			else if(tValue.getClass() == Timestamp.class)
				sqljob.appendSQL("'" + ( (Timestamp) tValue ) + "'");
			else if(tValue.getClass() == Date.class)
				sqljob.appendSQL("'" + new Timestamp( ((Date) tValue).getTime() ) + "'");
			else if (tValue.getClass() == BigDecimal.class)
				sqljob.appendSQL(String.valueOf(((BigDecimal)tValue).doubleValue()));
			else
				sqljob.appendSQL("'" + tValue + "'");
			if(tIterator.hasNext())
				sqljob.appendSQL(", ");
		}
		sqljob.appendSQL(")");
		//劵
//		System.out.println(sqljob.toString());
//		log.trace("InsertSQL:" +sqljob);
		return sqljob;
	}

	protected Date time2date(Timestamp pTime){
		return new Date(((Timestamp)pTime).getTime());
	}

	protected static Map<String,Object> getCommonMap(String usrId){
		if(commonMap.isEmpty()){
			commonMap.put("usrid", usrId);
			commonMap.put("mod_date", new Timestamp( new Date().getTime() ));
			commonMap.put("remark", "");
		}
		return commonMap;
	}
}
