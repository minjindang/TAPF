package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ECRE0901 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM ECRE09_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
/*
 * select   c.debt_name,d.budget_name,e.debit_name,
         datediff(dd,c.issue_date,c.due_date) As dayCount,
         b.bank_name, a.issue_amount, a.real_amount
from     debt_main a,bank_ref b,issue_main c,budget_ref d,debit_ref e
where    a.bank_id = b.id
 and     a.issue_id = c.id
 and     c.budget_code = d.id
 and     c.debt_code = e.id
 and     year(c.issue_date) = [查詢年] + 1911
 and     month(c.issue_date) = [查詢月] 
 and     c.id = [issue_id]
 and     a.accrue = 'Y'

 */	
	protected SQLJob insTemp(AccountQueryForm form,String usrId){
		Date today = new Date();
		//查詢條件;
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO ECRE09_RPT ");
		sqljob.appendSQL(" ( usrid,mod_date,bank_name , issue_amount, ");
		sqljob.appendSQL(" real_amount, remark ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL("select ?,?,b.bank_name, a.issue_amount, a.issue_amount ,a.remark");
		sqljob.appendSQL("from     debt_main a,bank_ref b,issue_main c");
		sqljob.addParameter(usrId);
		sqljob.addParameter(today);
		sqljob.appendSQL("where    a.bank_id = b.id");
		sqljob.appendSQL("and     a.issue_id = c.id");
		sqljob.appendSQL("and     c.id = ?");
		sqljob.appendSQL("and     a.accrue = 'Y'");
		
		sqljob.addParameter(form.getIssueId());
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//Bira1401Form bira1401Form = (Bira1401Form) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp((AccountQueryForm)form,usrId));
	
	}
}
