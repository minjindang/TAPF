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

public class ECRF0502 extends ExcelReportBaseAction {
	
	private final static String TEMP_TABLE_NAME = "ECRF05_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM ECRF05_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL(AccountQueryForm form){
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		
		//查尋欄位
		sqljob.appendSQL("select distinct issue.id as issue_id, ");
		sqljob.appendSQL("issue.debt_name, ");
		sqljob.appendSQL("issue.issue_date, ");
		sqljob.appendSQL("(issue.issue_amount-(" +
				"case when (select sum(capital_amount) from payment_main where issue_id = issue.id " +
//				"and repay_date < '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31') > 0 ");
//				"and repay_date < '" + DateUtil.date2Str(myForm.getStartIssueDate(),"yyyy/MM/dd") + "') > 0 ");
				"and repay_date < '" + DateUtil.getYear(myForm.getStartIssueDate()) + "/12/31') > 0 ");
		sqljob.appendSQL("		then (select sum(capital_amount) from payment_main where issue_id = issue.id " +
//				"and repay_date < '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31') ");
//				"and repay_date < '" + DateUtil.date2Str(myForm.getStartIssueDate(),"yyyy/MM/dd") +"') ");
				"and repay_date < '" + DateUtil.getYear(myForm.getStartIssueDate()) + "/12/31')");
		sqljob.appendSQL("		else 0 end )) as principal_amount, ");
		sqljob.appendSQL("(select max(repay_date) from payment_main where issue_id = issue.id and repay_date < '"
//				+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31') as repay_date, ");
//				+ DateUtil.date2Str(myForm.getStartIssueDate(),"yyyy/MM/dd") + "') as repay_date, ");
				+ DateUtil.getYear(myForm.getStartIssueDate()) + "/12/31') as repay_date, ");
		sqljob.appendSQL("issue.due_date ");
		sqljob.appendSQL("from issue_main issue ");
		sqljob.appendSQL("where issue.debt_type = 'C' ");
		sqljob.appendSQL("and issue.issue_amount > ISNULL((select sum(capital_amount) from payment_main where issue.id = issue_id " +
//				"and repay_date < '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31'),0) ");
//				"and repay_date < '" + DateUtil.date2Str(myForm.getStartIssueDate(),"yyyy/MM/dd") + "'),0) ");
				"and repay_date < '" + DateUtil.getYear(myForm.getStartIssueDate()) + "/12/31'),0)");
//		sqljob.appendSQL("and issue.issue_date < '"+(Integer.valueOf(myForm.getAccountYear())+1911)+"/12/31'");
		sqljob.appendSQL("and issue.issue_date < '" + DateUtil.date2Str(myForm.getStartIssueDate(),"yyyy/MM/dd") +"'");
		sqljob.appendSQL("order by issue.issue_date");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQLRate(int issueId){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select debtRate.* ");
		sqljob.appendSQL("from debt_main debt, debt_rate_det debtRate ");
		sqljob.appendSQL("where debt.id = debtRate.debt_id ");
		sqljob.appendSQL("and debtRate.delete_mark = 'N' ");
		sqljob.appendSQL("and debt.issue_id = " + issueId);

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
		AccountQueryForm myForm = (AccountQueryForm) form;
		
		SQLJob sqljob = SQL((AccountQueryForm)form);
		List tList = (List) run.query(sqljob, new MapListHandler());
		Map tMap = null;
		String obj[] = new String[6];
		obj[0] = "";
		
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); ){	
			tMap = (Map) tIterator.next();
			
			String debtName = "";
			debtName = null!=(String)tMap.get("debt_name")?(String)tMap.get("debt_name"):"";
			if (!obj[0].equals(debtName)){	
				if (!obj[0].equals("")){
					Map dMap = new HashMap();
					dMap.put("debt_name",obj[0]);
					dMap.put("issue_date",obj[1]);
					dMap.put("principal_amount",BigDecimal.valueOf(Double.valueOf(obj[2])));
					dMap.put("average_rate",BigDecimal.valueOf(Double.valueOf(obj[3])));
					dMap.put("interest_days",obj[4]);
					dMap.put("interest_amount",BigDecimal.valueOf(Double.valueOf(obj[5])));
					dMap.put("remark","");
					run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
				}
				
				obj[0] = debtName;
				Date issueDate = new Date();
				issueDate = null!=(Date)tMap.get("issue_date")?(Date)tMap.get("issue_date"):null;
				obj[1] = DateUtil.date2ROCStr(issueDate,"yyy/mm/dd");
				BigDecimal principalAmount = null;
				principalAmount = null!=(BigDecimal)tMap.get("principal_amount")?(BigDecimal)tMap.get("principal_amount"):null;
				obj[2] = principalAmount.toString();
				Integer issueId = null!=(Integer)tMap.get("issue_id")?(Integer)tMap.get("issue_id"):0;
				SQLJob sqljobRate = SQLRate(issueId);
				List listRate = (List)run.query(sqljobRate, new MapListHandler());
				BigDecimal averageRate = new BigDecimal(0);
				for(Iterator iteratorRate = listRate.iterator(); iteratorRate.hasNext();){
					Map mapRate = (Map) iteratorRate.next();
//					Integer accountYear = Integer.valueOf(myForm.getAccountYear())+1911;
					Integer accountYear = DateUtil.getYear(myForm.getStartIssueDate());
					Date startYear = (Date)mapRate.get("effective_date");
					Date endYear = (Date)mapRate.get("suspend_date");
//					if (accountYear > startYear.getYear() && accountYear < endYear.getYear())
					if (accountYear >= DateUtil.getYear(startYear) && accountYear <= DateUtil.getYear(endYear))
						averageRate = null!=(BigDecimal)mapRate.get("debt_rate")?(BigDecimal)mapRate.get("debt_rate"):null;
				}
//				BigDecimal averageRate = null;
//				averageRate = null!=(BigDecimal)tMap.get("average_rate")?(BigDecimal)tMap.get("average_rate"):null;
				obj[3] = averageRate.toString();
				
				Date dueDate = new Date();
				dueDate = null!=(Date)tMap.get("due_date")?(Date)tMap.get("due_date"):null;
				Integer interestDays = 0;
//				if (dueDate.before(DateUtil.str2Date(Integer.valueOf(myForm.getAccountYear())+1911+"1231")))
				if (dueDate.before(DateUtil.str2Date(DateUtil.getYear(myForm.getStartIssueDate())+"1231")))
				{
					if (null != tMap.get("repay_date"))
					{
						interestDays = DateUtil.getDays((Date)tMap.get("repay_date"),dueDate)+1;
					}else{
						interestDays = DateUtil.getDays(issueDate,dueDate)+1;
					}
				}else{
					if (null != tMap.get("repay_date"))
					{
//						interestDays = DateUtil.getDays((Date)tMap.get("repay_date"),DateUtil.str2Date((Integer.valueOf(myForm.getAccountYear())+1911)+"1231"))+1;
						interestDays = DateUtil.getDays((Date)tMap.get("repay_date"),DateUtil.str2Date(DateUtil.getYear(myForm.getStartIssueDate())+"1231"))+1;
					}else{
//						interestDays = DateUtil.getDays(issueDate,DateUtil.str2Date((Integer.valueOf(myForm.getAccountYear())+1911)+"1231"))+1;
						interestDays = DateUtil.getDays(issueDate,DateUtil.str2Date(DateUtil.getYear(myForm.getStartIssueDate())+"1231"))+1;
					}
				}				
				
				obj[4] = interestDays.toString();
				Double rateDays = (Double.valueOf(interestDays)/Double.valueOf(365));
				BigDecimal interestAmount = null;
				interestAmount = (principalAmount.multiply(averageRate.divide(new BigDecimal(100)))).multiply(BigDecimal.valueOf(rateDays));
				obj[5] = interestAmount.toString();
			}
		}	
		//填入最後一筆
		Map dMap = new HashMap();
		dMap.put("debt_name",obj[0]);
		dMap.put("issue_date",obj[1]);
		dMap.put("principal_amount",BigDecimal.valueOf(Double.valueOf(obj[2])));
		dMap.put("average_rate",BigDecimal.valueOf(Double.valueOf(obj[3])));
		dMap.put("interest_days",obj[4]);
		dMap.put("interest_amount",BigDecimal.valueOf(Double.valueOf(obj[5])));
		dMap.put("remark","");
		run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
		
		String issueDate = DateUtil.date2ChineseROC2(myForm.getStartIssueDate());
		request.setAttribute("issueDate",issueDate);
	}
}
