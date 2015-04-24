/**
 * @author AndrewSung
 * @date 2006/3/10
 */

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

import tw.gov.nta.debt.form.Apra1901Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
public class APRA1901 extends ExcelReportBaseAction
{

	private final static String TEMP_TABLE_NAME = "APRA19_RPT";
	
	protected SQLJob SQL1(Apra1901Form myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select distinct ");
		sqljob.appendSQL("(select X.debt_name from issue_main X where X.id=D.issue_id) as debt_name,");
		sqljob.appendSQL("P.PRI_TIMES, ");
		sqljob.appendSQL("P.INT_TIMES, ");
		sqljob.appendSQL("SUM(case BK_VALUE1 when '50T' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '50T' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '50T' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '50T' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '50T' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '50T' then P.CURR_PCS6 else 0 end) as T_50, ");

		sqljob.appendSQL("SUM(case BK_VALUE1 when '100T' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '100T' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '100T' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '100T' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '100T' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '100T' then P.CURR_PCS6 else 0 end) as T_100, ");

		sqljob.appendSQL("SUM(case BK_VALUE1 when '500T' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '500T' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '500T' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '500T' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '500T' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '500T' then P.CURR_PCS6 else 0 end) as T_500, ");

		sqljob.appendSQL("SUM(case BK_VALUE1 when '1M' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '1M' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '1M' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '1M' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '1M' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '1M' then P.CURR_PCS6 else 0 end) as M_1, ");

		sqljob.appendSQL("SUM(case BK_VALUE1 when '5M' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '5M' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '5M' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '5M' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '5M' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '5M' then P.CURR_PCS6 else 0 end) as M_5, ");
		sqljob.appendSQL("SUM(P.TOTAL_PCS) as TOTAL_PCS, ");
		sqljob.appendSQL("SUM(P.TOTAL_AMT) as TOTAL_AMT,");
		sqljob.appendSQL("B.BANK_FNAME,");
		sqljob.appendSQL("B.BANK_CODE ");
		sqljob.appendSQL("from DEBT_MAIN D,PAIDC P, BANKF B ");
		sqljob.appendSQL("WHERE ");
		sqljob.appendSQL("P.EVAL_DATE <= ? ");
		sqljob.addParameter(myForm.getCloseDate());
		sqljob.appendSQL("and D.issue_id= ? ");
		sqljob.addParameter(myForm.getIssueId());
		sqljob.appendSQL("and B.BANK_CODE = ? ");
		sqljob.addParameter(myForm.getBankId());
		sqljob.appendSQL("and (convert(varchar,P.bond_code) ");
		sqljob.appendSQL("+( case when Len(convert(varchar,P.bond_period)) < 2 then '0'+convert(varchar,P.bond_period) else convert(varchar,P.bond_period) end ) ");
		sqljob.appendSQL("+(case P.bond_mark when '甲' then '01' when '乙' then '02' else '' end ))=D.remark ");
		sqljob.appendSQL("and B.BANK_CODE=P.BANK_CODE ");
		sqljob.appendSQL("group by D.ISSUE_ID,P.INT_TIMES, P.PRI_TIMES,B.BANK_FNAME,B.BANK_CODE ");
		//--order by T.BOND_NAME,B.BANK_FNAME
		System.out.println("APRA19-SQL1"+sqljob.toString());
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
		
		Apra1901Form myForm = (Apra1901Form)form;
		//執行 insert
		List queryList = (List) run.query(SQL1(myForm), new MapListHandler());
		
		Map tMap = null;
		Map dMap = new HashMap();
		for (Iterator it1=queryList.iterator(); it1.hasNext();){
			tMap = (Map)it1.next();
			dMap.putAll(getCommonMap(usrId));
			dMap.put("DEBT_NAME",(String)tMap.get("debt_name"));
			dMap.put("BANK_NAME",(String)tMap.get("BANK_FNAME"));
			dMap.put("CAPITAL_SERIAL",(Integer)tMap.get("PRI_TIMES"));
			dMap.put("INTEREST_SERIAL",(Integer)tMap.get("INT_TIMES"));
			dMap.put("COUNT_50K",new BigDecimal((Integer)tMap.get("T_50")));
			dMap.put("COUNT_100K",new BigDecimal((Integer)tMap.get("T_100")));
			dMap.put("COUNT_500K",new BigDecimal((Integer)tMap.get("T_500")));
			dMap.put("COUNT_1000K",new BigDecimal((Integer)tMap.get("M_1")));
			dMap.put("COUNT_10000K",new BigDecimal((Integer)tMap.get("M_5")));
			dMap.put("TICKET_COUNT",new BigDecimal((Integer)tMap.get("TOTAL_PCS")));
			dMap.put("TOTAL_AMOUNT",new BigDecimal((Double)tMap.get("TOTAL_AMT")));
			run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
			request.setAttribute("bankCName",(String)tMap.get("BANK_FNAME"));
		}
	}
}
