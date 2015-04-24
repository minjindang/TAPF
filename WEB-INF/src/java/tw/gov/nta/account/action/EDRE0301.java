
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


public class EDRE0301 extends DefaultAction{
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EDRE03_RPT ");
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO EDRE03_RPT (USRID,MOD_DATE,");
		sqljob.appendSQL("issue_serial,issue_date,due_date,daycount,");
		sqljob.appendSQL("REAL_AMOUNT,pay_capital,remain_capital,ORIGIN_INTEREST_AMOUNT,");
		sqljob.appendSQL("pay_interest,remain_interest,remark) ");
		sqljob.appendSQL("select ?,?,");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Date());
		sqljob.appendSQL("'短期借款'+a.issue_serial,a.issue_date,a.due_date,");
		sqljob.appendSQL("datediff(dd,a.issue_date,a.due_date) As daycount,");
		sqljob.appendSQL("a.issue_amount, SUM(c.CAPITAL_AMOUNT) AS pay_capital,");
		sqljob.appendSQL("a.issue_amount - isnull(SUM(c.CAPITAL_AMOUNT),0) AS remain_capital, ");
//		sqljob.appendSQL("sum(b.ORIGIN_INTEREST_AMOUNT),");
		//0980309修改
		sqljob.appendSQL("(select sum(ORIGIN_INTEREST_AMOUNT) from debt_main where issue_id = a.id and (accrue_date is not null or accrue = 'Y')), ");
		sqljob.appendSQL("SUM(c.INTEREST_AMOUNT) AS pay_interest,");
		//0702修改
		sqljob.appendSQL("(case when  a.issue_amount <> isnull(SUM(c.CAPITAL_AMOUNT),0) then sum(b.ORIGIN_INTEREST_AMOUNT)-isnull(SUM(c.manage_INTEREST_AMOUNT),0) else 0 end),");
		sqljob.appendSQL("case SUM(b.ORIGIN_INTEREST_AMOUNT) - SUM(c.INTEREST_AMOUNT) when 0 then null else SUM(b.ORIGIN_INTEREST_AMOUNT) - SUM(c.INTEREST_AMOUNT) end AS remark "); 
		sqljob.appendSQL("FROM issue_main a CROSS JOIN debt_main b left  JOIN payment_main c  on  c.debt_id=b.id and (right('0000000'+convert(varchar,(convert(varchar,c.repay_date, 112)-19110000)),7)) <= ? ");
		sqljob.addParameter(myForm.getLastDate());
		//0702修改
		//sqljob.appendSQL("where b.issue_id=a.id and b.accrue = 'Y' and a.debt_type='D' and a.budget_code <> 4 ");
		//2007/3/5修改
		sqljob.appendSQL("where b.issue_id=a.id and b.accrue = 'Y' and a.debt_type='D' and a.debt_code <> 25 ");
		sqljob.appendSQL("and (right('0000000'+convert(varchar,(convert(varchar,a.ISSUE_DATE, 112)-19110000)),7)) <= ? ");
		sqljob.addParameter(myForm.getLastDate());
		sqljob.appendSQL("GROUP BY a.issue_serial,a.ISSUE_DATE, a.DUE_DATE,datediff(dd,a.issue_date,a.due_date),a.issue_amount ");
		//0980309修改
		sqljob.appendSQL(",a.id");
		//0702修改
		sqljob.appendSQL("order by 3");
		//0702修改
		/*
		sqljob.appendSQL("'短期借款'+a.issue_serial,a.issue_date,a.due_date,");
		sqljob.appendSQL("datediff(dd,a.issue_date,a.due_date) As daycount,");
		sqljob.appendSQL("a.issue_amount, SUM(c.CAPITAL_AMOUNT) AS pay_capital,");
		sqljob.appendSQL("a.issue_amount - SUM(c.CAPITAL_AMOUNT) AS remain_capital,");
		sqljob.appendSQL("sum(b.ORIGIN_INTEREST_AMOUNT), SUM(c.INTEREST_AMOUNT) AS pay_interest,");
		sqljob.appendSQL("(case when max(c.repay_date)>a.due_date then sum(b.ORIGIN_INTEREST_AMOUNT)-isnull(SUM(c.INTEREST_AMOUNT),0) else 0 end),");
		sqljob.appendSQL("Case When SUM(isnull(c.INTEREST_AMOUNT,0)) <> 0 and SUM(b.ORIGIN_INTEREST_AMOUNT) - SUM(c.INTEREST_AMOUNT) <> 0 then ");
		sqljob.appendSQL("SUM(b.ORIGIN_INTEREST_AMOUNT) - SUM(c.INTEREST_AMOUNT) else null end AS remark ");
		sqljob.appendSQL("FROM issue_main a CROSS JOIN ");
		sqljob.appendSQL("debt_main b CROSS JOIN ");
		sqljob.appendSQL("payment_main c ");
		sqljob.appendSQL("where b.issue_id=a.id" );
		sqljob.appendSQL("and c.debt_id=b.id ");
		sqljob.appendSQL("and a.debt_type='D' ");
		sqljob.appendSQL("and (right('0000000'+convert(varchar,(convert(varchar,a.ISSUE_DATE, 112)-19110000)),7)) <= ? ");
		sqljob.addParameter(myForm.getLastDate());
		sqljob.appendSQL("GROUP BY a.issue_serial,a.ISSUE_DATE, a.DUE_DATE,datediff(dd,a.issue_date,a.due_date),a.issue_amount ");
		*/
		System.out.print(sqljob);
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