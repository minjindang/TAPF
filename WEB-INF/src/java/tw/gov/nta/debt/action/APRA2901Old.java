package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Apra2801Form;
import tw.gov.nta.debt.form.Apra2901Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA2901Old extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "APRA29_RPT";
	protected SQLJob selTempC(ActionForm form,String usrId){
		Apra2901Form myForm = (Apra2901Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select id,repay_date,capital_amount from debt_plan_det where 1=1");
		sqljob.appendSQL("and issue_id in(select id from issue_main where debt_type='C')");
		sqljob.appendSQL("and delete_mark='N'");
		sqljob.appendSQL("and report_flag=0");
		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,repay_date, 112)-19110000)),7),1,5)>= ?");
		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,repay_date, 112)-19110000)),7),1,5)<= ?");
		sqljob.addParameter(myForm.getPaySmonth());
		sqljob.addParameter(myForm.getPayEmonth());
		System.out.println(sqljob);
		return sqljob;
		
	}
	protected SQLJob updTemp(Date date , BigDecimal amount){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("update " +TEMP_TABLE_NAME +" set");
		sqljob.appendSQL("LONG_INTEREST_AMOUNT = LONG_INTEREST_AMOUNT+" +amount.doubleValue()+"/100000000");
		sqljob.appendSQL("where REPAY_DATE = '"+new DateUtil().date2Str(date, "yyyy/MM/dd")+"'");
		System.out.println(sqljob);
		return sqljob;
		
	}
	protected SQLJob updTempAll(){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("update " +TEMP_TABLE_NAME +" set");
		sqljob.appendSQL("TOTAL_AMOUNT = FLIGHT_CAPITAL_AMOUNT + FLIGHT_INTEREST_AMOUNT ");
		sqljob.appendSQL("+LONG_CAPITAL_AMOUNT+LONG_INTEREST_AMOUNT+SHORT_CAPITAL_AMOUNT+SHORT_INTEREST_AMOUNT");
		sqljob.appendSQL("+SHORTFUND_CAPITAL_AMOUNT+SHORTFUND_INTEREST_AMOUNT+BOND_CAPITAL_AMOUNT+BOND_INTEREST_AMOUNT");
		sqljob.appendSQL("+NATION_CAPITAL_AMOUNT+NATION_INTEREST_AMOUNT");
		System.out.println(sqljob);
		return sqljob;
		
	}
	protected SQLJob updTempAll(Map map){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("update " +TEMP_TABLE_NAME +" set");
		sqljob.appendSQL("FLIGHT_CAPITAL_AMOUNT = FLIGHT_CAPITAL_AMOUNT + ? ,");
		sqljob.appendSQL("FLIGHT_INTEREST_AMOUNT =FLIGHT_INTEREST_AMOUNT + ? ,");
		sqljob.appendSQL("LONG_CAPITAL_AMOUNT = LONG_CAPITAL_AMOUNT + ? ,");
		sqljob.appendSQL("LONG_INTEREST_AMOUNT = LONG_INTEREST_AMOUNT + ? ,");
		sqljob.appendSQL("SHORT_CAPITAL_AMOUNT = SHORT_CAPITAL_AMOUNT + ? , ");
		sqljob.appendSQL("SHORT_INTEREST_AMOUNT = SHORT_INTEREST_AMOUNT + ? , ");
		sqljob.appendSQL("SHORTFUND_CAPITAL_AMOUNT = SHORTFUND_CAPITAL_AMOUNT + ? , ");
		sqljob.appendSQL("SHORTFUND_INTEREST_AMOUNT = SHORTFUND_INTEREST_AMOUNT + ? , ");
		sqljob.appendSQL("BOND_CAPITAL_AMOUNT = BOND_CAPITAL_AMOUNT + ? , ");
		sqljob.appendSQL("BOND_INTEREST_AMOUNT = BOND_INTEREST_AMOUNT + ? , ");
		sqljob.appendSQL("NATION_CAPITAL_AMOUNT = NATION_CAPITAL_AMOUNT + ? , ");
		sqljob.appendSQL("NATION_INTEREST_AMOUNT = NATION_INTEREST_AMOUNT + ?  ");
		sqljob.appendSQL("WHERE REPAY_DATE = ? ");
		sqljob.addParameter( (map.get("FLIGHT_CAPITAL_AMOUNT")!=null)?map.get("FLIGHT_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("FLIGHT_INTEREST_AMOUNT")!=null)?map.get("FLIGHT_INTEREST_AMOUNT"):0);
		sqljob.addParameter( (map.get("LONG_CAPITAL_AMOUNT")!=null)?map.get("LONG_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("LONG_INTEREST_AMOUNT")!=null)?map.get("LONG_INTEREST_AMOUNT"):0);
		sqljob.addParameter( (map.get("SHORT_CAPITAL_AMOUNT")!=null)?map.get("SHORT_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("SHORT_INTEREST_AMOUNT")!=null)?map.get("SHORT_INTEREST_AMOUNT"):0);
		sqljob.addParameter( (map.get("SHORTFUND_CAPITAL_AMOUNT")!=null)?map.get("SHORTFUND_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("SHORTFUND_INTEREST_AMOUNT")!=null)?map.get("SHORTFUND_INTEREST_AMOUNT"):0);
		sqljob.addParameter( (map.get("BOND_CAPITAL_AMOUNT")!=null)?map.get("BOND_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("BOND_INTEREST_AMOUNT")!=null)?map.get("BOND_INTEREST_AMOUNT"):0);
		sqljob.addParameter( (map.get("NATION_CAPITAL_AMOUNT")!=null)?map.get("NATION_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("NATION_INTEREST_AMOUNT")!=null)?map.get("NATION_INTEREST_AMOUNT"):0);
		sqljob.addParameter( (Date)map.get("REPAY_DATE"));
		System.out.println(sqljob);
		return sqljob;
		
	}
	protected SQLJob insTemp(ActionForm form,String usrId){
		Apra2901Form myForm = (Apra2901Form) form;
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME );
		sqljob.appendSQL(" ( REPAY_DATE, FLIGHT_CAPITAL_AMOUNT, FLIGHT_INTEREST_AMOUNT, LONG_CAPITAL_AMOUNT, LONG_INTEREST_AMOUNT, ");
		sqljob.appendSQL(" SHORT_CAPITAL_AMOUNT, SHORT_INTEREST_AMOUNT, SHORTFUND_CAPITAL_AMOUNT, SHORTFUND_INTEREST_AMOUNT, BOND_CAPITAL_AMOUNT, ");
		sqljob.appendSQL(" BOND_INTEREST_AMOUNT, NATION_CAPITAL_AMOUNT, NATION_INTEREST_AMOUNT, TOTAL_AMOUNT, ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK ");
		sqljob.appendSQL(" ) ");

		sqljob.appendSQL("SELECT P.REPAY_DATE");
		sqljob.appendSQL(",ISNULL(SUM((CASE WHEN I.DEBT_TYPE='E' AND I.DEBT_CODE = 58 THEN P.CAPITAL_AMOUNT ELSE 0 END)),0)/100000000  AS FLIGHT_CAPITAL_AMOUNT");
		sqljob.appendSQL(",ISNULL(SUM((CASE WHEN I.DEBT_TYPE='E' AND I.DEBT_CODE = 58 THEN (P.CHARGE_AMOUNT*P.TRANSFER_CAPITAL_AMOUNT*TRANSFER_INTEREST_AMOUNT /365/100) ELSE 0 END)),0)/100000000 AS FLIGHT_INTEREST_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN I.DEBT_TYPE='C' AND P.REPORT_FLAG = 0 THEN P.CAPITAL_AMOUNT ELSE 0 END))/100000000 AS LONG_CAPITAL_AMOUNT");
		sqljob.appendSQL(",0 ");
		sqljob.appendSQL(",SUM((CASE WHEN I.DEBT_TYPE='D' AND I.DEBT_CODE<>25 THEN P.CAPITAL_AMOUNT ELSE 0 END))/100000000 AS SHORT_CAPITAL_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN I.DEBT_TYPE='D' AND I.DEBT_CODE<>25 THEN P.INTEREST_AMOUNT ELSE 0 END))/100000000 AS SHORT_INTEREST_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN I.DEBT_TYPE='D' AND I.DEBT_CODE=25 THEN P.CAPITAL_AMOUNT ELSE 0 END))/100000000 AS SHORTFUND_CAPITAL_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN I.DEBT_TYPE='D' AND I.DEBT_CODE=25 THEN P.INTEREST_AMOUNT ELSE 0 END))/100000000 AS SHORTFUND_INTEREST_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN I.DEBT_TYPE='A' THEN P.CAPITAL_AMOUNT ELSE 0 END))/100000000 AS BOND_CAPITAL_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN I.DEBT_TYPE='A' THEN P.INTEREST_AMOUNT ELSE 0 END))/100000000 AS BOND_INTEREST_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN I.DEBT_TYPE='B' THEN P.CAPITAL_AMOUNT ELSE 0 END))/100000000 AS NATION_CAPITAL_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN I.DEBT_TYPE='B' THEN P.INTEREST_AMOUNT ELSE 0 END))/100000000 AS NATION_INTEREST_AMOUNT");
		sqljob.appendSQL(",SUM( ISNULL(P.CAPITAL_AMOUNT,0) )+SUM( ISNULL(P.INTEREST_AMOUNT,0) )/100000000 AS TOTAL_AMOUNT");

		sqljob.appendSQL(",'"+usrId+"'");
		sqljob.appendSQL(",'"+new Timestamp( new Date().getTime() )+"'");
		sqljob.appendSQL(",''");

		sqljob.appendSQL("  FROM ISSUE_MAIN I,DEBT_PLAN_DET P");
		sqljob.appendSQL(" WHERE I.ID=P.ISSUE_ID");
		sqljob.appendSQL("   AND substring(right('0000000'+convert(varchar,(convert(varchar,P.REPAY_DATE, 112)-19110000)),7),1,5)>=?");
		sqljob.appendSQL("   AND substring(right('0000000'+convert(varchar,(convert(varchar,P.REPAY_DATE, 112)-19110000)),7),1,5)<=?");
		sqljob.appendSQL(" GROUP BY REPAY_DATE");
		sqljob.appendSQL(" ORDER BY REPAY_DATE");
		sqljob.addParameter( myForm.getPaySmonth() );
		sqljob.addParameter( myForm.getPayEmonth() );
		System.out.println("insTemp====>"+sqljob);
		return sqljob;
	}
	protected SQLJob insTempAll(Map map,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " +TEMP_TABLE_NAME);
		sqljob.appendSQL("(REPAY_DATE,FLIGHT_CAPITAL_AMOUNT , FLIGHT_INTEREST_AMOUNT ,LONG_CAPITAL_AMOUNT ,LONG_INTEREST_AMOUNT");
		sqljob.appendSQL(" ,SHORT_CAPITAL_AMOUNT ,SHORT_INTEREST_AMOUNT ,SHORTFUND_CAPITAL_AMOUNT ,SHORTFUND_INTEREST_AMOUNT");
		sqljob.appendSQL(" ,BOND_CAPITAL_AMOUNT ,BOND_INTEREST_AMOUNT ,NATION_CAPITAL_AMOUNT ,NATION_INTEREST_AMOUNT,USRID, MOD_DATE, REMARK)");
		sqljob.appendSQL("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'')");
		sqljob.addParameter( (map.get("REPAY_DATE")!=null)?map.get("REPAY_DATE"):"");
		sqljob.addParameter( (map.get("FLIGHT_CAPITAL_AMOUNT")!=null)?map.get("FLIGHT_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("FLIGHT_INTEREST_AMOUNT")!=null)?map.get("FLIGHT_INTEREST_AMOUNT"):0);
		sqljob.addParameter( (map.get("LONG_CAPITAL_AMOUNT")!=null)?map.get("LONG_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("LONG_INTEREST_AMOUNT")!=null)?map.get("LONG_INTEREST_AMOUNT"):0);
		sqljob.addParameter( (map.get("SHORT_CAPITAL_AMOUNT")!=null)?map.get("SHORT_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("SHORT_INTEREST_AMOUNT")!=null)?map.get("SHORT_INTEREST_AMOUNT"):0);
		sqljob.addParameter( (map.get("SHORTFUND_CAPITAL_AMOUNT")!=null)?map.get("SHORTFUND_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("SHORTFUND_INTEREST_AMOUNT")!=null)?map.get("SHORTFUND_INTEREST_AMOUNT"):0);
		sqljob.addParameter( (map.get("BOND_CAPITAL_AMOUNT")!=null)?map.get("BOND_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("BOND_INTEREST_AMOUNT")!=null)?map.get("BOND_INTEREST_AMOUNT"):0);
		sqljob.addParameter( (map.get("NATION_CAPITAL_AMOUNT")!=null)?map.get("NATION_CAPITAL_AMOUNT"):0);
		sqljob.addParameter( (map.get("NATION_INTEREST_AMOUNT")!=null)?map.get("NATION_INTEREST_AMOUNT"):0);
		sqljob.addParameter( usrId);
		sqljob.addParameter( new Date());

		System.out.println(sqljob);
		return sqljob;
		
	}
	protected SQLJob selTempTable(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" SELECT REPAY_DATE, FLIGHT_CAPITAL_AMOUNT, FLIGHT_INTEREST_AMOUNT, LONG_CAPITAL_AMOUNT, LONG_INTEREST_AMOUNT, ");
		sqljob.appendSQL(" SHORT_CAPITAL_AMOUNT, SHORT_INTEREST_AMOUNT, SHORTFUND_CAPITAL_AMOUNT, SHORTFUND_INTEREST_AMOUNT, BOND_CAPITAL_AMOUNT, ");
		sqljob.appendSQL(" BOND_INTEREST_AMOUNT, NATION_CAPITAL_AMOUNT, NATION_INTEREST_AMOUNT, TOTAL_AMOUNT FROM "+TEMP_TABLE_NAME);
		System.out.println(sqljob);
		return sqljob;
		
	}
	protected SQLJob selTempTable2(Date date){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" SELECT REPAY_DATE, FLIGHT_CAPITAL_AMOUNT, FLIGHT_INTEREST_AMOUNT, LONG_CAPITAL_AMOUNT, LONG_INTEREST_AMOUNT, ");
		sqljob.appendSQL(" SHORT_CAPITAL_AMOUNT, SHORT_INTEREST_AMOUNT, SHORTFUND_CAPITAL_AMOUNT, SHORTFUND_INTEREST_AMOUNT, BOND_CAPITAL_AMOUNT, ");
		sqljob.appendSQL(" BOND_INTEREST_AMOUNT, NATION_CAPITAL_AMOUNT, NATION_INTEREST_AMOUNT, TOTAL_AMOUNT FROM "+TEMP_TABLE_NAME+" WHERE REPAY_DATE = ?");
		sqljob.addParameter(date);
		System.out.println(sqljob);
		return sqljob;
		
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		//執行 insert
		run.update(connection,insTemp(form,usrId));
		List list= (List) run.query(selTempC(form, usrId), new MapListHandler());
		System.out.println(list);
		for(Iterator it = list.iterator();it.hasNext();){
			Map map = (Map)it.next();
			Integer id = (Integer)map.get("id");
			BigDecimal captialAmount = (BigDecimal)map.get("capital_amount");
			BigDecimal interestAmount = new PlanManager().getMiddlePlanInterestAmount(id.intValue());
			run.update(connection,updTemp((Date)map.get("repay_date"),interestAmount));
		}
		List listTempTable= (List) run.query(selTempTable(form, usrId), new MapListHandler());
		List tempList = new LinkedList();
		for(Iterator it = listTempTable.iterator();it.hasNext();){
			Map map = (Map)it.next();
			if(((BigDecimal)map.get("BOND_CAPITAL_AMOUNT")).compareTo(new BigDecimal(0))!= 0 || ((BigDecimal)map.get("BOND_INTEREST_AMOUNT")).compareTo(new BigDecimal(0))!=0){
				if(((BigDecimal)map.get("FLIGHT_CAPITAL_AMOUNT")).compareTo(new BigDecimal(0))==0 && ((BigDecimal)map.get("FLIGHT_INTEREST_AMOUNT")).compareTo(new BigDecimal(0))==0 
						&& ((BigDecimal)map.get("LONG_CAPITAL_AMOUNT")).compareTo(new BigDecimal(0))==0 && ((BigDecimal)map.get("LONG_INTEREST_AMOUNT")).compareTo(new BigDecimal(0))==0
						&& ((BigDecimal)map.get("SHORTFUND_CAPITAL_AMOUNT")).compareTo(new BigDecimal(0))==0 && ((BigDecimal)map.get("SHORTFUND_INTEREST_AMOUNT")).compareTo(new BigDecimal(0))==0
						&& ((BigDecimal)map.get("SHORT_CAPITAL_AMOUNT")).compareTo(new BigDecimal(0))==0 && ((BigDecimal)map.get("SHORT_INTEREST_AMOUNT")).compareTo(new BigDecimal(0))==0
						&& ((BigDecimal)map.get("NATION_CAPITAL_AMOUNT")).compareTo(new BigDecimal(0))==0 && ((BigDecimal)map.get("NATION_INTEREST_AMOUNT")).compareTo(new BigDecimal(0))==0){
					Calendar tCalendar = GregorianCalendar.getInstance();
					tCalendar.setTime((Date)map.get("REPAY_DATE"));
					tCalendar.add(tCalendar.DATE, -1);
					map.put("REPAY_DATE",tCalendar.getTime());
					tempList.add(map);
				}
				else{
					Map tempMap = new HashMap();
					Calendar tCalendar = GregorianCalendar.getInstance();
					tCalendar.setTime((Date)map.get("REPAY_DATE"));
					tCalendar.add(tCalendar.DATE, -1);
					tempMap.put("REPAY_DATE",tCalendar.getTime());
					tempMap.put("BOND_CAPITAL_AMOUNT", (map.get("BOND_CAPITAL_AMOUNT")!= null)?map.get("BOND_CAPITAL_AMOUNT"):0);
					tempMap.put("BOND_INTEREST_AMOUNT", (map.get("BOND_INTEREST_AMOUNT")!= null)?map.get("BOND_INTEREST_AMOUNT"):0);
					map.put("BOND_CAPITAL_AMOUNT",0);
					map.put("BOND_INTEREST_AMOUNT",0);
					tempList.add(map);
					tempList.add(tempMap);
				}
			}
			else{
				tempList.add(map);
			}
		}
		listTempTable.clear();
		listTempTable.addAll(tempList);
		List checkList = new LinkedList();
		for(int i = 0 ; i <  listTempTable.size();i++){
			int code = 0;
			Map map = (Map)listTempTable.get(i);
			for(Iterator it2 = tempList.iterator();it2.hasNext();){
				Map mapTempList = (Map)it2.next();
				Calendar tCalendar1 = GregorianCalendar.getInstance();
				Calendar tCalendar2 = GregorianCalendar.getInstance();
				tCalendar1.setTime((Date)map.get("REPAY_DATE"));
				tCalendar2.setTime((Date)mapTempList.get("REPAY_DATE"));
				if(tCalendar1.compareTo(tCalendar2) == 0)
					code++;
			}
			if(code>1){
				checkList.add(map);
				listTempTable.remove(i);
			}
		}
		run.update(connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		for(Iterator it = listTempTable.iterator();it.hasNext();){
			Map map = (Map)it.next();
			run.update(connection,insTempAll(map,usrId));
		}
		for(Iterator it = checkList.iterator();it.hasNext();){
			Map map = (Map)it.next();
			listTempTable = (List) run.query(selTempTable(form, usrId), new MapListHandler());
			if(((List)run.query(selTempTable2((Date)map.get("REPAY_DATE")), new MapListHandler())).size()>0){
				run.update(connection,updTempAll(map));
			}
			else{
				run.update(connection,insTempAll(map,usrId));
			}
		}
		run.update(connection,updTempAll());
	}
}
