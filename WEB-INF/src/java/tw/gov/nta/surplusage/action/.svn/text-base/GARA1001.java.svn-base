/* DIRA0401.java 報表
 程式目的：DIRA0401
 程式代號：DIRA0401
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara1001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA1001 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA10_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob SQL1(Gara1001Form myForm,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select ");
//		年度
		sqljob.appendSQL("(case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088上半及089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end) as account_year,");
		sqljob.appendSQL("(case account_kind ");
		sqljob.appendSQL("when '1' then '(預)' ");
		sqljob.appendSQL("when '2' then '(決)' ");
		sqljob.appendSQL("when '3' then '(院決)' ");
		sqljob.appendSQL("when '4' then '(實)' ");
		sqljob.appendSQL("else ''");
		sqljob.appendSQL("end) as account_kind,");
//		公債發行、總預算、甲類、非十大建設
		sqljob.appendSQL("sum(case when (debt_type = 'A' and budget_code = '1' and bound_code ='1 'and is_account='N ') then issue_amount else 0 end)/? as T1 ,");
//		公債發行、特別預算、甲類 、非十大建設
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code = '2' and bound_code ='1' and is_account='N' ) then issue_amount else 0 end)/? as T2 ,");
//		公債發行、特別預算、乙類 、非十大建設
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code = '2' and bound_code ='2' and is_account='N' ) then issue_amount else 0 end)/? as T3 ,");
//		公債發行、十大建設(不管預算別)
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and is_account='Y')then issue_amount else 0 end)/? as T4 ,");
//		公債發行、非十大建設、債務基金=>未償餘額
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and is_account='N'and budget_code='3' )then issue_amount else 0 end)/? as T5,");
//		借款、 甲類 、非十大建設、非債務基金
		sqljob.appendSQL("sum(case when ( debt_type in ( 'B','C','D')and bound_code ='1' and is_account='N' and budget_code<>'3' )then issue_amount else 0 end )/? as T6,");
//		借款、 乙類 、非十大建設、非債務基金
		sqljob.appendSQL("sum(case when ( debt_type in ( 'B','C','D')and bound_code ='2' and is_account='N' and budget_code<>'3' )then issue_amount else 0 end)/? as T7,");
//		借款、十大建設(不管預算別)
		sqljob.appendSQL("sum(case when ( debt_type in ( 'B','C','D') and is_account='Y' )then issue_amount else 0 end)/? as T8,");
//		借款、非十大建設、債務基金
		sqljob.appendSQL("sum(case when ( debt_type in ( 'B','C','D') and is_account='N' and budget_code = '3') then issue_amount else 0 end)/? as T9 ");
		sqljob.appendSQL("from central_statistics_main ");
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		if (null != myForm.getStartYear() && null != myForm.getEndYear()){
			sqljob.appendSQL("where account_year between ? and ? ");
			sqljob.addParameter(myForm.getStartYear());
			sqljob.addParameter(myForm.getEndYear());
		}
//		where Account_year between Account_syear and Account_eyear
		sqljob.appendSQL("group by ");
		sqljob.appendSQL("case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088上半及089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end ,");
		sqljob.appendSQL("case account_kind ");
		sqljob.appendSQL("when '1' then '(預)' ");
		sqljob.appendSQL("when '2' then '(決)' ");
		sqljob.appendSQL("when '3' then '(院決)' ");
		sqljob.appendSQL("when '4' then '(實)' ");
		sqljob.appendSQL("else '' end ");
		sqljob.appendSQL("order by 1,2 ");

		return sqljob;
	}

	protected SQLJob SQL2(Map pMap,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select budget_amount/? as budget_amount ");
		sqljob.appendSQL("From nation_debit_main a , nation_ref b ");
		sqljob.appendSQL("Where a.nation_code = b.id ");
		sqljob.appendSQL("and b.nation_no='TW' ");
		sqljob.addParameter(unit);
		if(pMap.get("account_year") != null){
			sqljob.appendSQL("and account_year= case ");
			sqljob.appendSQL("when (? ='088上半及089'  ) then '089'");
			sqljob.appendSQL("else ? end");
			sqljob.addParameter((String)pMap.get("account_year"));
			sqljob.addParameter((String)pMap.get("account_year"));
		}
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gara1001Form myForm = (Gara1001Form) form;
		BigDecimal unit = myForm.getAmountUnit();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		List queryList1 = (List) run.query(SQL1(myForm,unit), new MapListHandler());
		Map tMap = null;
		List tTempList = null;
//		tCommonMap.
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tTempList = ((List)run.query(SQL2(tMap,unit),new MapListHandler()));
			if(tTempList != null && tTempList.size() > 0)
				tMap.putAll((Map)tTempList.get(0));
			else 
				tMap.put("budget_amount",new BigDecimal(0));
			tMap.put("item",(String)tMap.get("account_year")+(String)tMap.get("account_kind"));
			tMap.put("t23_total",((BigDecimal)tMap.get("t2")).add((BigDecimal)tMap.get("t3")));
			tMap.put("t1234_total",((BigDecimal)tMap.get("t1")).add((BigDecimal)tMap.get("t23_total")).add((BigDecimal)tMap.get("t4")));
			tMap.put("t678_total",((BigDecimal)tMap.get("t6")).add((BigDecimal)tMap.get("t7")).add((BigDecimal)tMap.get("t8")));
			tMap.put("t126_total",((BigDecimal)tMap.get("t1")).add((BigDecimal)tMap.get("t2")).add((BigDecimal)tMap.get("t6")));
			tMap.put("t27_total",((BigDecimal)tMap.get("t2")).add((BigDecimal)tMap.get("t7")));
			tMap.put("t1314_total",((BigDecimal)tMap.get("t126_total")).add((BigDecimal)tMap.get("t27_total")));
			if (((BigDecimal)tMap.get("budget_amount")).intValue() != 0){
				tMap.put("Atotal_rate",((BigDecimal)tMap.get("t126_total")).divide((BigDecimal)tMap.get("budget_amount"),4,5));
				tMap.put("Btotal_rate",((BigDecimal)tMap.get("t27_total")).divide((BigDecimal)tMap.get("budget_amount"),4,5));
				tMap.put("total_rate",((BigDecimal)tMap.get("Atotal_rate")).add((BigDecimal)tMap.get("Btotal_rate")));
			}
			else{
				tMap.put("Atotal_rate",new BigDecimal(0));
				tMap.put("Btotal_rate",new BigDecimal(0));
				tMap.put("total_rate",new BigDecimal(0));
			}
			run.update(connection,insTemp("GARA10_RPT",tMap));
		}

	}
}
