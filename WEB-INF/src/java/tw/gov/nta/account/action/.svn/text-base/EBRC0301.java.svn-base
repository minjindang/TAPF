package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EBRC0301 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EBRC03_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		AccountQueryForm ebrc0301Form = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("insert into EBRC03_RPT (usrid,issue_serial,K100,K500,K1000,K5000,amount,budget_name ) ");
		sqljob.appendSQL("select ");
		sqljob.appendSQL("'" + usrId + "' , ");
		sqljob.appendSQL("a.issue_serial, ");
		sqljob.appendSQL("sum(case b.ticket_amount when 100000 then b.stock_count else 0 end) , ");
		sqljob.appendSQL("sum(case b.ticket_amount when 500000 then b.stock_count else 0 end) , ");
		sqljob.appendSQL("sum(case b.ticket_amount when 1000000 then b.stock_count else 0 end) , ");
		sqljob.appendSQL("sum(case b.ticket_amount when 5000000 then b.stock_count else 0 end) , ");
		sqljob.appendSQL("sum(b.ticket_amount * b.stock_count) As total_amount , ");
		sqljob.appendSQL("c.budget_name ");
		sqljob.appendSQL("from issue_main a,issue_stock_ticket_det b ,budget_ref c ");
		sqljob.appendSQL("where a.id = b.issue_id and b.debt_type = 2 and a.budget_code = c.id ");  
		
		if(  0!= ebrc0301Form.getIssueId())
		{
			sqljob.appendSQL("and a.id = ?");
			sqljob.addParameter(ebrc0301Form.getIssueId());
		}
		if(null != ebrc0301Form.getQueryDate())
		{
			sqljob.appendSQL("and b.stock_date <= ?");
			sqljob.addParameter(ebrc0301Form.getQueryDate());
		}
		sqljob.appendSQL("group by a.issue_serial , c.budget_name");
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
