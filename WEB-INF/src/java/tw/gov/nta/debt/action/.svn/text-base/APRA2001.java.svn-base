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

import tw.gov.nta.debt.form.Apra2001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
public class APRA2001 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "APRA20_RPT";
	
	protected SQLJob SQL1(Apra2001Form myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select distinct ");
		sqljob.appendSQL("bond_period as bond_period,");
		sqljob.appendSQL("SUM(case BK_VALUE1 when '1T' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '1T' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '1T' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '1T' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '1T' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '1T' then P.CURR_PCS6 else 0 end) as T_1, ");
		
		sqljob.appendSQL("SUM(case BK_VALUE1 when '5T' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '5T' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '5T' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '5T' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '5T' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '5T' then P.CURR_PCS6 else 0 end) as T_5, ");
		
		sqljob.appendSQL("SUM(case BK_VALUE1 when '10T' then P.CURR_PCS1 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE2 when '10T' then P.CURR_PCS2 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE3 when '10T' then P.CURR_PCS3 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE4 when '10T' then P.CURR_PCS4 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE5 when '10T' then P.CURR_PCS5 else 0 end)+");
		sqljob.appendSQL("SUM(case BK_VALUE6 when '10T' then P.CURR_PCS6 else 0 end) as T_10, ");
		
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
		sqljob.appendSQL("SUM(P.TOTAL_AMT) as TOTAL_AMT ");
		sqljob.appendSQL("from PAIDC P ");
		sqljob.appendSQL("WHERE ");
//		sqljob.appendSQL("P.bond_code=(select subString(X.remark,1,3) from debt_main X where X.issue_id=?) ");
//		sqljob.addParameter(myForm.getIssueId());
		if(null != myForm.getDebtName() && !"".equals(myForm.getDebtName()))
		{	
			if("BDB甲".equals(myForm.getDebtName()))
			{
				sqljob.appendSQL("bond_code= 'BDB' and bond_mark = '甲' ");
			}
			else if ("BDB乙".equals(myForm.getDebtName()))
			{
				sqljob.appendSQL("bond_code= 'BDB' and bond_mark = '乙' ");
			}	
			else
			{
				sqljob.appendSQL("bond_code= '"+myForm.getDebtName()+"'");
			}
		}
		sqljob.appendSQL("group by bond_period ");
//		sqljob.appendSQL("and (convert(varchar,P.bond_code) ");
//		sqljob.appendSQL("+( case when Len(convert(varchar,P.bond_period)) < 2 then '0'+convert(varchar,P.bond_period) else convert(varchar,P.bond_period) end ) ");
//		sqljob.appendSQL("+(case P.bond_mark when '甲' then '01' when '乙' then '02' else '' end ))=D.remark ");
//		sqljob.appendSQL("group by D.ISSUE_ID ");
		//--order by T.BOND_NAME,B.BANK_FNAME
		System.out.println("APRA20-SQL1"+sqljob.toString());
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
		
		Apra2001Form myForm = (Apra2001Form)form;
		//執行 insert
		List queryList = (List) run.query(SQL1(myForm), new MapListHandler());
		
		Map tMap = null;
		Map dMap = new HashMap();
		for (Iterator it1=queryList.iterator(); it1.hasNext();){
			tMap = (Map)it1.next();
			dMap.putAll(getCommonMap(usrId));
			dMap.put("TICKET_NAME","第"+String.valueOf(tMap.get("bond_period"))+"期");
			dMap.put("TICKET_COUNT_T1",new BigDecimal((Integer)tMap.get("T_1")));
			dMap.put("TICKET_COUNT_T5",new BigDecimal((Integer)tMap.get("T_5")));
			dMap.put("TICKET_COUNT_T10",new BigDecimal((Integer)tMap.get("T_10")));
			dMap.put("TICKET_COUNT_T50",new BigDecimal((Integer)tMap.get("T_50")));
			dMap.put("TICKET_COUNT_T100",new BigDecimal((Integer)tMap.get("T_100")));
			dMap.put("TICKET_COUNT_T500",new BigDecimal((Integer)tMap.get("T_500")));
			dMap.put("TICKET_COUNT_M1",new BigDecimal((Integer)tMap.get("M_1")));
			dMap.put("TICKET_COUNT_M5",new BigDecimal((Integer)tMap.get("M_5")));
			dMap.put("TOTAL_COUNT",new BigDecimal((Integer)tMap.get("TOTAL_PCS")));
			dMap.put("TOTAL_AMOUNT",new BigDecimal((Double)tMap.get("TOTAL_AMT")).setScale(0, BigDecimal.ROUND_HALF_UP));
			run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
			
		}
		
	}
}
