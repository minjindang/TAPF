package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EARC0501 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARC05_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		AccountQueryForm accountQueryForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("insert into EARC05_RPT (usrid,debt_name,issue_serial,HUNDRED_THOUSAND_COUNT," +
				"FIVE_HUNDRED_THOUSAND_COUNT,MILLION_COUNT,FIVE_MILLION_COUNT,TOTAL_AMOUNT) ");

		sqljob.appendSQL("select ");
		sqljob.appendSQL("'" + usrId + "' , ");
		sqljob.appendSQL("a.debt_name,a.debt_short_name as issue_serial, ");
		sqljob.appendSQL("sum(case b.ticket_amount when 100000 then b.stock_count else 0 end) As count_10K, ");
	    sqljob.appendSQL("sum(case b.ticket_amount when 500000 then b.stock_count else 0 end) As count_50K, ");
	    sqljob.appendSQL("sum(case b.ticket_amount when 1000000 then b.stock_count else 0 end) As count_100K, ");
	    sqljob.appendSQL("sum(case b.ticket_amount when 5000000 then b.stock_count else 0 end) As count_500K, ");
	    sqljob.appendSQL("sum(b.ticket_amount * b.stock_count) As total_amount ");
	    sqljob.appendSQL("from issue_main a,issue_stock_ticket_det b ");
	    sqljob.appendSQL("where a.id = b.issue_id  ");
	    sqljob.appendSQL(" and b.debt_type = 1");
	    sqljob.appendSQL(" and b.stock_date <= '"+accountQueryForm.getSQLLastDate()+"'");
	    sqljob.appendSQL("and a.debt_type='A' ");
	    sqljob.appendSQL("group by a.debt_name,a.issue_serial,a.debt_short_name ");  
		System.out.println(sqljob.toString());
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId));
		
	}

}
