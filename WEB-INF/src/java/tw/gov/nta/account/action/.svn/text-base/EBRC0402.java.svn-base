package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EBRC0402 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EBRC04_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	
	protected SQLJob mainsql(Date queryStartDate,Date queryEndDate,String usrId){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("");
		sqljob.appendSQL(" INSERT INTO EBRC04_RPT ");
		sqljob.appendSQL(" SELECT '"+usrId+"',GetDate(),'',");
		sqljob.appendSQL(" issue_main.debt_name,");
		sqljob.appendSQL(" issue_main.account_year,");
		sqljob.appendSQL(" issue_main.issue_serial,");
		sqljob.appendSQL(" datediff(dd,issue_main.issue_date,issue_main.due_date) AS daycount,");
		sqljob.appendSQL(" issue_main.average_rate,");
		sqljob.appendSQL(" issue_main.issue_date,");
		sqljob.appendSQL(" issue_main.due_date,");
		sqljob.appendSQL(" debt_main.issue_amount,");
		sqljob.appendSQL(" debt_main.real_amount,");
		sqljob.appendSQL(" case when issue_main.capital_amount = issue_main.real_amount then issue_main.capital_amount + issue_main.interest_amount else sum(debt_plan_det.capital_amount +  debt_plan_det.interest_amount) end As payable_amount,");
		sqljob.appendSQL(" isnull(issue_main.capital_amount,0) + isnull(issue_main.interest_amount,0) as payment_amount");
		sqljob.appendSQL(" from issue_main ,debt_main,debt_plan_det");
		sqljob.appendSQL(" where issue_main.id = debt_main.issue_id");
		sqljob.appendSQL(" and debt_main.id = debt_plan_det.debt_id");
		sqljob.appendSQL(" and debt_type = 'B'");
		sqljob.appendSQL(" and debt_plan_det.delete_mark = 'N' ");
		sqljob.appendSQL(" and issue_main.sell_status <> '2' ");
		sqljob.appendSQL(" AND issue_main.issue_date >= '"+df.format(queryStartDate)+"'");
		sqljob.appendSQL(" AND issue_main.issue_date <= '"+df.format(queryEndDate)+"'");
		sqljob.appendSQL(" group by  issue_main.capital_amount,issue_main.interest_amount,issue_main.real_amount,issue_main.debt_name,");
		sqljob.appendSQL(" issue_main.account_year,");
		sqljob.appendSQL(" issue_main.issue_serial,");
		sqljob.appendSQL(" datediff(dd,issue_main.issue_date,issue_main.due_date),");
		sqljob.appendSQL(" issue_main.average_rate,");
		sqljob.appendSQL(" issue_main.issue_date,");
		sqljob.appendSQL(" issue_main.due_date,");
		sqljob.appendSQL("debt_main.issue_amount,");
		sqljob.appendSQL("debt_main.real_amount,");
		sqljob.appendSQL("isnull(issue_main.capital_amount,0) + isnull(issue_main.interest_amount,0)");
		System.out.println(sqljob.toString());	
		return sqljob;
	}
	

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	
	
		AccountQueryForm myform = (AccountQueryForm) form;
		String usrId = this.getUserId(request);
		// ¬d¸ß±ø¥ó
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(myform,usrId));
	    SQLJob queryJob = mainsql(myform.getStartIssueDate(),myform.getEndIssueDate(),usrId);
	    run.update(connection,queryJob);
	}
}

