package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ECRE0201 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "ECRE02_RPT";
	
	protected SQLJob insTemp(AccountQueryForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME);
		sqljob.appendSQL(" ( debt_name, issue_date, due_date, issue_amount, month_capital, ");
		sqljob.appendSQL(" remain_capital, total_interest, month_interest, total_month_interest, ");
		sqljob.appendSQL(" usrid, mod_date, remark ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL("select  a.debt_name ,");
		sqljob.appendSQL("a.issue_date as issue_date ,");
		sqljob.appendSQL("a.due_date as issue_date ,");
		sqljob.appendSQL("case when  Year(a.issue_date)=? and Month(a.issue_date) = ? then a.issue_amount  else 0 end as issue_amount ,");
		sqljob.appendSQL("sum(case when Year(repay_date)=? and Month(repay_date) = ?  then c.capital_amount else 0 end)  as month_capital ,");
		sqljob.appendSQL("(select sum(issue_amount) from debt_main where issue_id = a.id and debt_code  <> 35) ");
		sqljob.appendSQL("- sum(case when repay_date <='"+form.getSQLLastDate()+"' then c.capital_amount else 0 end ) As remain_capital ,");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.str2Date(form.getLastDate().substring(0,5)+"01"));
		calendar.add(Calendar.DATE,-1);
		
		sqljob.appendSQL("sum(case when repay_date <='"+DateUtil.date2Str(calendar.getTime(),"yyyy/MM/dd")+"' then c.interest_amount else 0 end) as total_interest ,");
		sqljob.appendSQL("sum(case when Year(repay_date)=? and Month(repay_date) = ?  then c.interest_amount else 0 end)  as month_interest ,");
		sqljob.appendSQL("sum(case when  repay_date <='"+form.getSQLLastDate()+"' then c.interest_amount else 0 end)  as total_interest,? ,? ,'' ");
		sqljob.appendSQL("from issue_main a,debt_main b,payment_main c ");
		sqljob.appendSQL("where a.id = b.issue_id and b.id *= c.debt_id and a.debt_type='C' and b.debt_code <> 35 and isnumeric(a.serial_no) = 1 and a.issue_date <='"+form.getSQLLastDate()+"' and accrue = 'Y'");
		sqljob.appendSQL("group by a.debt_name,a.issue_date,a.due_date,a.issue_amount,a.account_year,a.serial_no,a.id");
		sqljob.appendSQL(" order by a.account_year,a.serial_no");
		sqljob.addParameter(form.getSQLAccountYear());
		sqljob.addParameter(form.getMonth());
		sqljob.addParameter(form.getSQLAccountYear());
		sqljob.addParameter(form.getMonth());
		sqljob.addParameter(form.getSQLAccountYear());
		sqljob.addParameter(form.getMonth());
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Date());
		System.out.println(sqljob);
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		//執行 insert
		run.update(connection,insTemp((AccountQueryForm)form,usrId));
	}
}
