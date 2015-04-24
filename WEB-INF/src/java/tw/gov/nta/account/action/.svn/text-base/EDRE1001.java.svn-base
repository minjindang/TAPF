
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


public class EDRE1001 extends DefaultAction{
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EDRE10_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO EDRE10_RPT (USRID,MOD_DATE,");
		sqljob.appendSQL("issue_serial,issue_date,due_date,daycount,");
		sqljob.appendSQL("REAL_AMOUNT,pay_capital,remain_capital,ORIGIN_INTEREST_AMOUNT,");
		sqljob.appendSQL("pay_interest,remain_interest,remark) ");
		sqljob.appendSQL("select ?,?,");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Date());
		sqljob.appendSQL("'短期借款'+a.issue_serial,a.issue_date,a.due_date,");
		sqljob.appendSQL("datediff(dd,a.issue_date,a.due_date) As daycount,");
		sqljob.appendSQL("a.issue_amount,0 AS pay_capital,");
		sqljob.appendSQL("a.issue_amount remain_capital,");
		sqljob.appendSQL("sum(b.ORIGIN_INTEREST_AMOUNT),0 AS pay_interest,");
		sqljob.appendSQL("sum(b.ORIGIN_INTEREST_AMOUNT) AS remain_interest,");
		sqljob.appendSQL("Case When SUM(isnull(c.INTEREST_AMOUNT,0)) <> 0 and SUM(b.ORIGIN_INTEREST_AMOUNT) - SUM(c.INTEREST_AMOUNT) <> 0 then ");
//		sqljob.appendSQL("Case When (isnull(c.MANAGE_AMOUNT,0)) <> 0 and SUM(b.ORIGIN_INTEREST_AMOUNT) - SUM(c.INTEREST_AMOUNT) <> 0 then ");
		sqljob.appendSQL("'' end AS remark ");
		sqljob.appendSQL("FROM issue_main a CROSS JOIN ");
		sqljob.appendSQL("debt_main b LEFT JOIN ");
		sqljob.appendSQL("payment_main c on c.debt_id=b.id");
		sqljob.appendSQL("where b.issue_id=a.id" );
		sqljob.appendSQL("and a.capital_amount = 0");
//		sqljob.appendSQL("and c.balance_capital_amount <> 0");
		sqljob.appendSQL("and a.budget_code <> 4 and a.debt_type='D' ");
		sqljob.appendSQL("and (right('0000000'+convert(varchar,(convert(varchar,a.ISSUE_DATE, 112)-19110000)),7)) <= ? ");
		sqljob.appendSQL("and (right('0000000'+convert(varchar,(convert(varchar,a.due_date, 112)-19110000)),7) )> ? ");
		sqljob.addParameter(myForm.getYearLastDate());
		sqljob.addParameter(myForm.getYearLastDate());
		sqljob.appendSQL("GROUP BY a.issue_serial,a.ISSUE_DATE, a.DUE_DATE,datediff(dd,a.issue_date,a.due_date),a.issue_amount ");
		
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