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

public class EARE1502 extends ExcelReportBaseAction {
	
	private final static String TEMP_TABLE_NAME = "EARE15_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARE15_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL(AccountQueryForm form){
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		
		//查尋欄位
		sqljob.appendSQL("select distinct issue.debt_short_name, ");
		sqljob.appendSQL("issue.issue_date, ");
		sqljob.appendSQL("(issue.issue_amount-(case when (select sum(capital_amount) from payment_main where issue_id = issue.id) > 0 " +
				"and repay_date < '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31' ");
		sqljob.appendSQL("		then (select sum(capital_amount) from payment_main where issue_id = issue.id " +
				"and repay_date < '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31') ");
		sqljob.appendSQL("		else 0 end )) as principal_amount, ");
		sqljob.appendSQL("issue.average_rate, ");
		sqljob.appendSQL("debtPlan.interest_amount,");
		sqljob.appendSQL("DateDiff(day,debtPlan.repay_date,'"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31') as interest_days, ");
		sqljob.appendSQL("(case when issue.interest_alternate > issue.issue_interval " +
				"then 365/(issue.interest_alternate/issue.issue_interval) else 365*(issue.issue_interval/interest_alternate) end) as tot_days, ");
		sqljob.appendSQL("issue.source_issue_id, ");
		sqljob.appendSQL("issue.bond_kind ");
		sqljob.appendSQL("from issue_main issue, debt_plan_det debtPlan");
		sqljob.appendSQL("where issue.debt_type = 'A' ");
		sqljob.appendSQL("and issue.issue_amount > ISNULL((select sum(capital_amount) from payment_main where issue.id = issue_id " +
				"and repay_date < '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31'),0)");
		sqljob.appendSQL("and debtPlan.issue_id = issue.id ");
		sqljob.appendSQL("and debtPlan.interest_amount > 0 ");
		sqljob.appendSQL("and debtPlan.repay_date = (select max(repay_date) from debt_plan_det where issue_id = issue.id and repay_date between '"
				+(Integer.valueOf(myForm.getAccountYear())+1911)+"/01/01' and '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31') ");
		sqljob.appendSQL("and issue.bond_type <> 2 ");
		//補上當年度發行公債
		sqljob.appendSQL("union");
		sqljob.appendSQL("select distinct issue.debt_short_name, ");
		sqljob.appendSQL("issue.issue_date, ");
		sqljob.appendSQL("(issue.issue_amount-(case when (select sum(capital_amount) from payment_main where issue_id = issue.id " +
				"and repay_date < '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31') > 0 ");
		sqljob.appendSQL("		then (select sum(capital_amount) from payment_main where issue_id = issue.id " +
				"and repay_date < '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31') ");
		sqljob.appendSQL("		else 0 end )) as principal_amount, ");
		sqljob.appendSQL("issue.average_rate, ");
		sqljob.appendSQL("debtPlan.interest_amount,");
		sqljob.appendSQL("DateDiff(day, issue.issue_date, '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31') as interest_days, ");
		sqljob.appendSQL("(case when issue.interest_alternate > issue.issue_interval " +
				"then 365/(issue.interest_alternate/issue.issue_interval) else 365*(issue.issue_interval/interest_alternate) end) as tot_days, ");
		sqljob.appendSQL("issue.source_issue_id, ");
		sqljob.appendSQL("issue.bond_kind ");
		sqljob.appendSQL("from issue_main issue, debt_plan_det debtPlan");
		sqljob.appendSQL("where issue.debt_type = 'A' ");
		sqljob.appendSQL("and issue.issue_amount > ISNULL((select sum(capital_amount) from payment_main where issue.id = issue_id " +
				"and repay_date < '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31'),0)");
		sqljob.appendSQL("and debtPlan.issue_id = issue.id ");
		sqljob.appendSQL("and debtPlan.interest_amount > 0 ");
		sqljob.appendSQL("and issue.issue_date between '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/01/01' and '"
				+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31'");
		sqljob.appendSQL("and issue.bond_type <> 2 ");
		sqljob.appendSQL("order by source_issue_id, bond_kind");
		
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
		String obj[] = new String[8];
		obj[0] = "";
		obj[7] = "";
		
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); ){	
			tMap = (Map) tIterator.next();
			Integer sourceIssueId = null!=(Integer)tMap.get("source_issue_id")?(Integer)tMap.get("source_issue_id"):0;
			if (!obj[7].equals(String.valueOf(sourceIssueId))){
				if (!obj[7].equals("")){
					Map dMap = new HashMap();
					dMap.put("debt_short_name",obj[0]);
					dMap.put("issue_date",obj[1]);
					dMap.put("principal_amount",BigDecimal.valueOf(Double.valueOf(obj[2])));
					dMap.put("average_rate",BigDecimal.valueOf(Double.valueOf(obj[3])));
					dMap.put("interest_days",obj[4]);
					Double interest = 0.0;
					interest = Double.valueOf(obj[6])*(Double.valueOf(obj[4])/Double.valueOf(obj[5]));
					dMap.put("interest_amount",BigDecimal.valueOf(interest));
					dMap.put("remark","");
					run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
				}
				
				String debtShortName = null!=(String)tMap.get("debt_short_name")?(String)tMap.get("debt_short_name"):"";
				obj[0] = debtShortName;
				Date issueDate = new Date();
				issueDate = null!=(Date)tMap.get("issue_date")?(Date)tMap.get("issue_date"):null;
				obj[1] = DateUtil.date2ROCStr(issueDate,"yyy/mm/dd");
				BigDecimal principalAmount = null;
				principalAmount = null!=(BigDecimal)tMap.get("principal_amount")?(BigDecimal)tMap.get("principal_amount"):null;
				obj[2] = principalAmount.toString();
				BigDecimal averageRate = null;
				averageRate = null!=(BigDecimal)tMap.get("average_rate")?(BigDecimal)tMap.get("average_rate"):null;
				obj[3] = averageRate.toString();
				Integer interestDays = 0;
				interestDays = null!=(Integer)tMap.get("interest_days")?(Integer)tMap.get("interest_days")+1:0;
				obj[4] = interestDays.toString();
				Integer totDays = 0;
				totDays = null!=(Integer)tMap.get("tot_days")?(Integer)tMap.get("tot_days"):0;
				obj[5] = totDays.toString();
				BigDecimal interestAmount = null;
				interestAmount = null!=(BigDecimal)tMap.get("interest_amount")?(BigDecimal)tMap.get("interest_amount"):null; 
				obj[6] = interestAmount.toString();
				obj[7] = String.valueOf(sourceIssueId);
			}else{
				BigDecimal interestAmount = null!=(BigDecimal)tMap.get("interest_amount")?(BigDecimal)tMap.get("interest_amount"):null;
				BigDecimal principalAmount = null!=(BigDecimal)tMap.get("principal_amount")?(BigDecimal)tMap.get("principal_amount"):null;
				obj[6] = String.valueOf(Double.valueOf(obj[6]) + Double.valueOf(interestAmount.toString()));
				obj[2] = String.valueOf(principalAmount.add(new BigDecimal(obj[2])));
			}
		}
		//填入最後一筆
		Map dMap = new HashMap();
		dMap.put("debt_short_name",obj[0]);
		dMap.put("issue_date",obj[1]);
		dMap.put("principal_amount",BigDecimal.valueOf(Double.valueOf(obj[2])));
		dMap.put("average_rate",BigDecimal.valueOf(Double.valueOf(obj[3])));
		dMap.put("interest_days",obj[4]);
		Double interest = 0.0;
		interest = Double.valueOf(obj[6])*(Double.valueOf(obj[4])/Double.valueOf(obj[5]));
		dMap.put("interest_amount",BigDecimal.valueOf(interest));
		dMap.put("remark","");
		run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
		
		AccountQueryForm myForm = (AccountQueryForm) form;
		String accountYear = myForm.getAccountYear();
		request.setAttribute("accountYear",accountYear);
	}
	
}
