
package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;


public class EARE0901 extends ExcelReportBaseAction{
	private final static String TEMP_TABLE_NAME = "EARE09_RPT";

	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
//		取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		SQLJob sqljob = getMainList((AccountQueryForm)form);
		List mainList = (List)run.query(sqljob,new MapListHandler());
		for(Iterator mainIterator = mainList.iterator();mainIterator.hasNext();) {
			Map mainMap = (Map)mainIterator.next();
			setDate(mainMap,run);
			queryAmount(mainMap,(AccountQueryForm)form,run);
			mainMap.putAll(getCommonMap(usrId));
			run.update(connection,insTemp(TEMP_TABLE_NAME,mainMap));	
		}
		//執行 insert

	}
	
	private void setDate(Map mainMap,SQLRunner run) {
		// TODO Auto-generated method stub
		String accountYear = (String)mainMap.get("account_year");
		
		if("".equals(accountYear.trim())||accountYear ==null){
			return;
		}

		String[] startEndDate = getStartEndDate(accountYear);
		SQLJob sqljob1 = new SQLJob();
		sqljob1.appendSQL("select min(i.issue_date) as issue_date,max(i.due_date) as due_date");
		sqljob1.appendSQL("from issue_main i ");
		sqljob1.appendSQL("where i.bond_type = '1' and (exists(select 1 from debt_main where issue_id = i.id and  debt_code <> 27) or (i.issue_date > '1997/06/30' and (exists(select 1 from debt_main where issue_id = i.id and  debt_code = 27)))) and debt_type = 'A' and i.issue_date>='"+startEndDate[0]+"' and i.issue_date<='"+startEndDate[1]+"'");
		try {
			Map testMap = (Map)run.query(sqljob1,new MapHandler());
			mainMap.putAll(testMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String[] getStartEndDate(String accountYear){
		if(accountYear!=null&&"".equals(accountYear)) return null;
		
		int year = Integer.valueOf(accountYear);
		ArrayList<String> startEndDate = new ArrayList<String>();
		if(year<89){
			startEndDate.add(String.valueOf(year+1911-1)+"/07/01");
			startEndDate.add(String.valueOf(year+1911)+"/06/30");
		}else if(year==89){
			startEndDate.add("1999/07/01");
			startEndDate.add("2000/12/31");
		}else{
			startEndDate.add(String.valueOf(year+1911)+"/01/01");
			startEndDate.add(String.valueOf(year+1911)+"/12/31");
		}
		
		String[] accountStartEndDate = {(String)startEndDate.get(0),(String)startEndDate.get(1)};
		return accountStartEndDate;
	}
	private void queryAmount(Map mainMap,AccountQueryForm myform,SQLRunner run) throws SQLException {
		// TODO Auto-generated method stub
		String lastYear = myform.getSQLYearLastDate();
		int lastYearNo = Integer.parseInt(lastYear.substring(0,4));
		String beforelastYear = String.valueOf(lastYearNo - 1)+lastYear.substring(4);
		String accountYear = (String)mainMap.get("account_year");
		Integer type = (Integer)mainMap.get("type");
		String[] startEndDate = getStartEndDate(accountYear);
		SQLJob sqljob1 = new SQLJob();
		SQLJob sqljob2 = new SQLJob();
		SQLJob sqljob3 = new SQLJob();
		sqljob1.appendSQL("select sum(d.issue_amount) as issue_amount,sum(d.issue_amount) as real_amount");
		sqljob1.appendSQL("from issue_main i,debt_main d");
		sqljob1.appendSQL("where i.id = d.issue_id ");

		sqljob2.appendSQL("select sum(p.capital_amount) as payment_amount");
		sqljob2.appendSQL(" from issue_main i,debt_main d,debt_plan_det p");
		sqljob2.appendSQL(" where i.id = d.issue_id ");
		sqljob2.appendSQL("    and d.id = p.debt_id and debt_type = 'A'");
		sqljob2.appendSQL("    and p.repay_date <='"+lastYear+"'");

		sqljob3.appendSQL("select sum(p.capital_amount) as remain_capital,sum(p.interest_amount) as remain_interest");
		sqljob3.appendSQL("from issue_main i,debt_main d,debt_plan_det p");
		sqljob3.appendSQL("where i.id = d.issue_id and debt_type = 'A'");
		sqljob3.appendSQL("    and d.id = p.debt_id");
		sqljob3.appendSQL("    and p.repay_date > '"+lastYear+"'");
		
		if(type == 1) {
			String type1Where = " and i.bond_type = '1' and (exists(select 1 from debt_main where issue_id = i.id and  debt_code <> 27) or (i.issue_date > '1997/06/30' and (exists(select 1 from debt_main where issue_id = i.id and  debt_code = 27)))) and debt_type = 'A' and i.issue_date>='"+startEndDate[0]+"' and i.issue_date<='"+startEndDate[1]+"'";
			sqljob1.appendSQL(type1Where);
			sqljob2.appendSQL(type1Where);
			sqljob3.appendSQL(type1Where);
		}else {
			String type2Where = " and i.bond_type = '1' and i.issue_date <= '1997/06/30' and exists(select 1 from debt_main where issue_id = i.id and  debt_code = 27) ";
			sqljob1.appendSQL(type2Where);
			sqljob2.appendSQL(type2Where);
			sqljob3.appendSQL(type2Where);
		}
		System.out.println(sqljob1.toString());
		System.out.println(sqljob2.toString());
		System.out.println(sqljob3.toString());		
		mainMap.remove("account_year");
		mainMap.remove("type");
		mainMap.putAll((Map)run.query(sqljob1,new MapHandler()));
		mainMap.putAll((Map)run.query(sqljob2,new MapHandler()));
		mainMap.putAll((Map)run.query(sqljob3,new MapHandler()));
		
	}

	private SQLJob getMainList(AccountQueryForm form) {
		// TODO Auto-generated method stub
		String lastDate = form.getSQLYearLastDate();
		int lastYear = Integer.parseInt(lastDate.substring(0,4));
		String lastYearDate = String.valueOf(lastYear - 1) + lastDate.substring(4);
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select  null as issue_date,null as due_date,i.account_year ,1 as type,");
		sqljob.appendSQL("'中央政府建設公債'+i.account_year+'年度'+case when i.bond_type = '2' then '乙' else '甲' end + '類'");
		sqljob.appendSQL("+'1-'+cast(max(cast(i.serial_no as integer)) as varchar)+'期債票' as debt_name");
		sqljob.appendSQL("from issue_main i");
		sqljob.appendSQL("where i.due_date >'"+lastYearDate+"' and i.issue_date <= '"+lastDate+"'");
		sqljob.appendSQL("and (exists(select 1 from debt_main where issue_id = i.id and  debt_code <> 27) or (account_year >='087' and (exists(select 1 from debt_main where issue_id = i.id and  debt_code = 27)))) ");
		sqljob.appendSQL("and i.bond_type = '1' and debt_type = 'A'");
		sqljob.appendSQL("group by  i.account_year,i.BOND_TYPE");
		sqljob.appendSQL("union all");
		sqljob.appendSQL("select  min(issue_date) as issue_date,max(due_date) as due_date,'' as account_year,");
		sqljob.appendSQL("2 as type,'重大交通建設公債'+case when i.bond_type = '2' then '乙' else '甲' end + '類債票1-'+cast(count(1) as varchar)+'期'  as debt_name");
		sqljob.appendSQL("from issue_main i");
		sqljob.appendSQL("where i.issue_date <= '"+lastDate+"'");
		sqljob.appendSQL("and i.issue_date <= '1997/06/30' and exists(select 1 from debt_main where issue_id = i.id and  debt_code = 27)");
		sqljob.appendSQL("and i.bond_type = '1' and debt_type = 'A'");
		sqljob.appendSQL("group by  i.BOND_TYPE");
		
		System.out.println(sqljob.toString());
		return sqljob;
	}
}