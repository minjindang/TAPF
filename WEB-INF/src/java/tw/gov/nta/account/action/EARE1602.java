package tw.gov.nta.account.action;

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

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EARE1602 extends ExcelReportBaseAction {

	private final static String TEMP_TABLE_NAME = "EARE16_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARE16_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL(AccountQueryForm form){
		AccountQueryForm myForm = (AccountQueryForm) form;
		String year = myForm.getAccountYear();
		String month = myForm.getMonth();
		String startDate = Integer.valueOf(year)+1911+"/"+month+"/01";
		String lastDate = (DateUtil.getLastDateOfMonth(year,month)).toString();
		String endDate = Integer.valueOf(lastDate.substring(0,3))+1911+"/"+month+"/"+lastDate.substring(lastDate.length()-2,lastDate.length());
		
		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("select issue.due_date, ");
		sqljob.appendSQL("select issue.id as issue_id, ");
		sqljob.appendSQL("issue.due_date, ");
		sqljob.appendSQL("case when debt.debt_code = issue.debt_code then issue.debt_short_name " +
				"else (issue.debt_short_name + " +
				"(select ' (' +budget_name + ')' from budget_ref where debt.budget_code = id)) end as debt_short_name, ");
		sqljob.appendSQL("issue.issue_interval, ");
		sqljob.appendSQL("issue.interest_alternate, ");
		sqljob.appendSQL("debt.diversity_amount, ");
		sqljob.appendSQL("debt.issue_cost_amount, ");
		sqljob.appendSQL("debt.diversity_amount/issue.interest_alternate as compare_diversity_amount, ");
		sqljob.appendSQL("debt.issue_cost_amount/issue.interest_alternate as compare_issue_cost_amount ");
		sqljob.appendSQL("from issue_main issue, debt_main debt ");
		sqljob.appendSQL("where debt.issue_id = issue.id ");
		sqljob.appendSQL("and issue.debt_type = 'A' ");
		sqljob.appendSQL("and issue.id in " +
				"(select debtPlan.issue_id from debt_plan_det debtPlan " +
				"where debtPlan.issue_id = issue.id and debtPlan.repay_date between '"+startDate+"' and '"+endDate+"')");
		sqljob.appendSQL("and issue.bond_type <> 2 ");
		sqljob.appendSQL("order by issue.issue_date ");

		return sqljob;		
	}
	
	protected SQLJob SQL2(int issueId, AccountQueryForm form) {
		AccountQueryForm myForm = (AccountQueryForm) form;
		String year = myForm.getAccountYear();
		String month = myForm.getMonth();
		String startDate = Integer.valueOf(year)+1911+"/"+month+"/01";
		String lastDate = (DateUtil.getLastDateOfMonth(year,month)).toString();
		String endDate = Integer.valueOf(lastDate.substring(0,3))+1911+"/"+month+"/"+lastDate.substring(lastDate.length()-2,lastDate.length());
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select * from debt_plan_det ");
		sqljob.appendSQL("where issue_id = " + issueId);
		sqljob.appendSQL("and repay_date between '" + startDate + "' and '" + endDate + "'");
		sqljob.appendSQL("and capital_serial <> 1");

		return sqljob;		
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );	
		
		SQLJob sqljob = SQL((AccountQueryForm)form);
		List tList = (List) run.query(sqljob, new MapListHandler());
		Map tMap = null;
//		String obj[] = new String[8];
		
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); ){	
			tMap = (Map) tIterator.next();
			Integer issueId = null!=(Integer)tMap.get("issue_id")?(Integer)tMap.get("issue_id"):0;
			SQLJob sqljobPlan = SQL2(issueId,(AccountQueryForm)form);
			List tListPlan = (List) run.query(sqljobPlan, new MapListHandler());
			Map tMapPlan = null;
			if (null != tListPlan && !tListPlan.isEmpty()) {
				tMapPlan = (Map)tListPlan.get(0);
				if (tMap.get("interest_alternate").equals(tMapPlan.get("interest_serial"))){
					BigDecimal diversityAmount = (BigDecimal)tMap.get("diversity_amount");
					BigDecimal compareDiversityAmount = (BigDecimal)tMap.get("compare_diversity_amount");
					compareDiversityAmount = compareDiversityAmount.setScale(0,BigDecimal.ROUND_DOWN);
					Integer interestAlternate = (Integer)tMap.get("interest_alternate")-1;
					BigDecimal finalDiversityAmount = diversityAmount.subtract((compareDiversityAmount.multiply(new BigDecimal(interestAlternate))));
					tMap.put("compare_diversity_amount",finalDiversityAmount);
				}
			}
			run.update(connection,insTemp(TEMP_TABLE_NAME,tMap));
		}

		AccountQueryForm myForm = (AccountQueryForm) form;
		String year = myForm.getAccountYear();
		String month = myForm.getMonth();
		String startDate = Integer.valueOf(year)+1911+"/"+month+"/01";
		String lastDate = (DateUtil.getLastDateOfMonth(year,month)).toString();
		String endDate = Integer.valueOf(lastDate.substring(0,3))+1911+"/"+month+"/"+lastDate.substring(lastDate.length()-2,lastDate.length());
		String top = "中華民國"+year+"年"+month+"月"+startDate.substring(startDate.length()-2,startDate.length())+"日至"+
					year+"年"+month+"月"+lastDate.substring(lastDate.length()-2,lastDate.length())+"日";
		request.setAttribute("top",top);
		
	}
}
