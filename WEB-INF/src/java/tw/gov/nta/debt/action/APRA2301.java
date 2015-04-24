package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra2301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA2301 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "APRA23_RPT";
	
	protected SQLJob SQL1(Apra2301Form myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select distinct ");
		sqljob.appendSQL("(select X.debt_name from issue_main X where X.id=D.issue_id) as debt_name,");
		sqljob.appendSQL("P.PRI_TIMES,");
		sqljob.appendSQL("P.INT_TIMES,");
		sqljob.appendSQL("SUM(case BK_VALUE1 when '10T' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '10T' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '10T' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '10T' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '10T' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '10T' then P.CURR_PCS6 else 0 end) as T_10,");
		
		sqljob.appendSQL("SUM(case BK_VALUE1 when '50T' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '50T' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '50T' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '50T' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '50T' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '50T' then P.CURR_PCS6 else 0 end) as T_50,"); 

		sqljob.appendSQL("SUM(case BK_VALUE1 when '100T' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '100T' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '100T' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '100T' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '100T' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '100T' then P.CURR_PCS6 else 0 end) as T_100,"); 

		sqljob.appendSQL("SUM(case BK_VALUE1 when '500T' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '500T' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '500T' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '500T' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '500T' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '500T' then P.CURR_PCS6 else 0 end) as T_500,"); 

		sqljob.appendSQL("SUM(case BK_VALUE1 when '1M' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '1M' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '1M' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '1M' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '1M' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '1M' then P.CURR_PCS6 else 0 end) as M_1,"); 

		sqljob.appendSQL("SUM(case BK_VALUE1 when '5M' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '5M' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '5M' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '5M' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '5M' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '5M' then P.CURR_PCS6 else 0 end) as M_5,"); 

		sqljob.appendSQL("SUM(P.TOTAL_PCS) as TOTAL_PCS,"); 
		sqljob.appendSQL("SUM(P.TOTAL_AMT) as TOTAL_AMT ");
		sqljob.appendSQL("from DEBT_MAIN D,PAIDC P ");
		sqljob.appendSQL("WHERE ");
		sqljob.appendSQL("D.issue_id=? ");
		sqljob.addParameter(myForm.getIssueId());
		sqljob.appendSQL("and (convert(varchar,P.bond_code) ");
		sqljob.appendSQL("+( case when Len(convert(varchar,P.bond_period)) < 2 then '0'+convert(varchar,P.bond_period) else convert(varchar,P.bond_period) end ) ");
		sqljob.appendSQL("+(case P.bond_mark when '��' then '01' when '�A' then '02' else '' end ))=D.remark ");
		sqljob.appendSQL("group by D.issue_id,P.PRI_TIMES, P.INT_TIMES ");
		sqljob.appendSQL("order by P.PRI_TIMES, P.INT_TIMES ");
		System.out.println("APRA23-SQL1"+sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		
		Apra2301Form myForm = (Apra2301Form)form;
		//���� insert
		List queryList = (List) run.query(SQL1(myForm), new MapListHandler());
		
		Map tMap = null;
		Map dMap = new HashMap();
		for (Iterator it1=queryList.iterator(); it1.hasNext();){
			tMap = (Map)it1.next();
			dMap.putAll(getCommonMap(usrId));
			dMap.put("DEBT_NAME",(String)tMap.get("debt_name"));
			
			dMap.put("CAPITAL_SERIAL",new BigDecimal((Integer)tMap.get("PRI_TIMES")));
			dMap.put("INTEREST_SERIAL",new BigDecimal((Integer)tMap.get("INT_TIMES")));
			dMap.put("TICKET_1",new BigDecimal((Integer)tMap.get("T_10")));
			dMap.put("TICKET_5",new BigDecimal((Integer)tMap.get("T_50")));
			dMap.put("TICKET_10",new BigDecimal((Integer)tMap.get("T_100")));
			dMap.put("TICKET_50",new BigDecimal((Integer)tMap.get("T_500")));
			dMap.put("TICKET_100",new BigDecimal((Integer)tMap.get("M_1")));
			dMap.put("TICKET_500",new BigDecimal((Integer)tMap.get("M_5")));
			dMap.put("TICKET_COUNT",new BigDecimal((Integer)tMap.get("TOTAL_PCS")));
			dMap.put("TOTAL_AMOUNT",new BigDecimal((Double)tMap.get("TOTAL_AMT")));
			run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
		}
		
	}
}
