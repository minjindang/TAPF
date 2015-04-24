
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;


public class EARC0301 extends DefaultAction{
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARC03_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO EARC03_RPT (USRID,MOD_DATE,remark,");
		sqljob.appendSQL("issue_serial,capital_serial,interest_serial,ticket_name,repay_date,");
		sqljob.appendSQL("ticket_count,total_amount,accum_count,accum_amount) ");
		sqljob.appendSQL("select ?,?,null,");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
		sqljob.appendSQL("issue_main.issue_serial,");
		sqljob.appendSQL("payment_main.capital_serial,");
		sqljob.appendSQL("payment_main.interest_serial,");
		sqljob.appendSQL("ticket_name,");   //面額
		sqljob.appendSQL("repay_date,");    //兌付日期
		sqljob.appendSQL("ticket_count,");   //本次張數
		sqljob.appendSQL("isnull(payment_main.capital_amount,0) + isnull(payment_main.interest_amount,0) as total_amount,");   //本次金額
		sqljob.appendSQL("accum_count,");   //累計張數
		sqljob.appendSQL("accum_amount ");  //累計金額
		sqljob.appendSQL("from issue_main,payment_main,payment_ticket_det ");
		sqljob.appendSQL("where issue_main.id = payment_main.issue_id ");
		sqljob.appendSQL("and payment_main.id = payment_ticket_det.payment_id ");
		sqljob.appendSQL("and payment_main.repay_date >= issue_main.cash_due_date ");
		sqljob.appendSQL("and year(payment_main.repay_date) = ? ");
		sqljob.appendSQL("and month(payment_main.repay_date) = ? ");
		sqljob.appendSQL("and issue_main.debt_type = 'A' and payment_ticket_det.ticket_count <> 0  ");
		sqljob.appendSQL("order by  issue_main.account_year,issue_main.serial_no,payment_main.capital_serial desc,payment_main.interest_serial ");
		sqljob.addParameter(myForm.getSQLAccountYear());
		sqljob.addParameter(myForm.getMonth());
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
//		取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId));
	}
}