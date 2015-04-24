package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra2201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA2201 extends ExcelReportBaseAction
{
private final static String TEMP_TABLE_NAME = "APRA22_RPT";
	
	protected SQLJob SQL1(Apra2201Form myForm){
		String qryYear = myForm.getKillYear();
		Date qryLastDate = DateUtil.str2Date(qryYear+"1231");
		System.out.println("qryLastDate"+qryLastDate);
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select distinct P.bond_code,");
		sqljob.appendSQL("(select X.debt_name from issue_main X where X.id=D.issue_id) as debt_name,");
		sqljob.appendSQL("SUM(P.TOTAL_PCS) as TOTAL_PCS,"); 
		sqljob.appendSQL("SUM(P.TOTAL_AMT) as TOTAL_AMT,");
		sqljob.appendSQL("(select X.cash_due_date from issue_main X where X.id=D.issue_id) as cash_due_date ");
		sqljob.appendSQL("from DEBT_MAIN D,PAIDC P ");
		sqljob.appendSQL("WHERE ");
		sqljob.appendSQL("(convert(varchar,P.bond_code) ");
		sqljob.appendSQL("+( case when Len(convert(varchar,P.bond_period)) < 2 then '0'+convert(varchar,P.bond_period) else convert(varchar,P.bond_period) end ) ");
		sqljob.appendSQL("+(case P.bond_mark when '甲' then '01' when '乙' then '02' else '' end ))=D.remark ");
		sqljob.appendSQL("and (select X.cash_due_date from issue_main X where X.id=D.issue_id) <= ? ");
		sqljob.addParameter(qryLastDate);
		sqljob.appendSQL("group by D.ISSUE_ID,P.bond_code ");
		sqljob.appendSQL("order by P.bond_code ");
		
		System.out.println("APRA22-SQL1"+sqljob.toString());
		return sqljob;
	}
	
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		
		Apra2201Form myForm = (Apra2201Form)form;
		//執行 insert
		List queryList = (List) run.query(SQL1(myForm), new MapListHandler());
		
		Map tMap = null;
		Map dMap = new HashMap();
		for (Iterator it1=queryList.iterator(); it1.hasNext();){
			tMap = (Map)it1.next();
			dMap.putAll(getCommonMap(usrId));
			dMap.put("DEBT_NAME",(String)tMap.get("debt_name"));
			dMap.put("TICKET_COUNT",new BigDecimal((Integer)tMap.get("TOTAL_PCS")));
			dMap.put("TOTAL_AMOUNT",new BigDecimal((Double)tMap.get("TOTAL_AMT")));
			dMap.put("CASH_DUE_DATE",(Date)tMap.get("cash_due_date"));
			run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
		}
	}
}
