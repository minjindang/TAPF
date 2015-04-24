package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EBRE0802 extends DefaultAction {
	
	/*
	 *SELECT  d.debt_name As debt_name,
        e.budget_name,
		f.debit_name,
        a.account_name As account_name,
		SUM(c.account_amount) AS account_total,
		c.account_type
FROM    account_ref a,voucher_main b,voucher_det c,issue_main d,budget_ref e,debit_ref f
WHERE   c.account_code = a.id 
  AND   b.id = c.voucher_id
  AND   d.id = b.issue_id
  AND   d.budget_code = e.id
  AND   d.debt_code = f.id 
  AND  (b.voucher_date <= [查詢日期])
  AND  (b.issue_id = [發行id])  INT
  AND  (b.voucher_type = [傳票類別])  INT
GROUP BY  d.debt_name,a.account_name,e.budget_name,f.debit_name

	*/
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EBRE08_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	
	protected SQLJob mainsql(AccountQueryForm myform,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("");
		sqljob.appendSQL("INSERT INTO EBRE08_RPT ");
		sqljob.appendSQL("SELECT '"+usrId+"',GetDate(),DATEDIFF(DD,issue_main.ISSUE_DATE, issue_main.DUE_DATE) AS DayCount,");
		sqljob.appendSQL("   issue_main.ISSUE_SERIAL, ");
		sqljob.appendSQL("   issue_main.ISSUE_DATE, ");
		sqljob.appendSQL("   issue_main.DUE_DATE, ");
		sqljob.appendSQL("   issue_main.issue_amount, ");
		sqljob.appendSQL("   issue_main.issue_amount, ");
		sqljob.appendSQL("   sum(debt_main.REAL_AMOUNT) AS REAL_AMOUNT, ");
		sqljob.appendSQL("   sum(debt_main.DIVERSITY_AMOUNT) AS interest_amount, ");
		sqljob.appendSQL("   issue_main.issue_amount AS payable_amount,'' ");
		sqljob.appendSQL("FROM   issue_main,debt_main");
		sqljob.appendSQL("WHERE  issue_main.id = debt_main.issue_id ");
		sqljob.appendSQL("And  (issue_main.DEBT_TYPE = 'B') ");
		sqljob.appendSQL("And  (issue_main.issue_date <= ?  ) " );
		sqljob.appendSQL("And  (issue_main.due_date > ?  ) " );
		sqljob.addParameter(myform.getSQLYearLastDate());
		sqljob.addParameter(myform.getSQLYearLastDate());
		sqljob.appendSQL("Group by DATEDIFF(DD,issue_main.ISSUE_DATE, issue_main.DUE_DATE),");
		sqljob.appendSQL("issue_main.ISSUE_SERIAL, ");
		sqljob.appendSQL("issue_main.ISSUE_DATE, ");
		sqljob.appendSQL("issue_main.DUE_DATE, ");
		sqljob.appendSQL("issue_main.ISSUE_AMOUNT ");
		System.out.println(sqljob);	
		
		return sqljob;
	}
	

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	
	
		AccountQueryForm myForm = (AccountQueryForm) form;
		String usrId = this.getUserId(request);
		// 查詢條件
		String queryYear  = myForm.getSQLAccountYear();
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(myForm,usrId));
	    SQLJob queryJob = mainsql(myForm,usrId);
	    run.update(connection,queryJob);
	}
}

