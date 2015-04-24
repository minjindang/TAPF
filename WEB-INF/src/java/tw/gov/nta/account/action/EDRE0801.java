
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;


public class EDRE0801 extends DefaultAction{
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EDRE08_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		AccountQueryForm myform = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		String yearAndMonth = "'" + myform.getAccountYear() + myform.getMonth()+ "'";	
		sqljob.appendSQL("insert into EDRE08_RPT (usrid,debt_name,budget_name,debit_name," +
				"daycount,bank_name,issue_amount,compare_rate,shd_interest,pay_interest," +
				"sum_interest,nouse_interest,remark)");
		
			
		sqljob.appendSQL("select '" + usrId + "',debt_name,e.budget_name,f.debit_name,");
		sqljob.appendSQL("datediff(dd,d.issue_date,d.due_date) As daycount,b.bank_name,a.issue_amount,");
		sqljob.appendSQL("substring(convert(char,round(a.compare_rate,3)),1,5)+'%' compare_rate,");
		sqljob.appendSQL("(select sum(Interest_amount) from Debt_plan_det  where debt_id=a.id and delete_mark='N') as shd_interest,");
		sqljob.appendSQL("sum(c.interest_amount) as pay_interest,");
		sqljob.appendSQL("( SELECT SUM(h.INTEREST_AMOUNT) "); 
		sqljob.appendSQL("FROM debt_main g,payment_main h "); 
		sqljob.appendSQL("WHERE g.id = h.debt_id and g.id = a.id and g.bank_id =a.bank_id ");  
		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar, h.repay_date, 112)-19110000)),7),1,5) <= ");
		sqljob.appendSQL(yearAndMonth);
		sqljob.appendSQL("AND g.accrue = 'Y')  as sum_interest,  ");
		sqljob.appendSQL("0 as nouse_interest, ");
		sqljob.appendSQL(" (select case sum(j.interest_amount) - SUM(k.INTEREST_AMOUNT) when 0 then null else sum(j.interest_amount) - SUM(k.INTEREST_AMOUNT) end ");
		sqljob.appendSQL(" from debt_plan_det j,payment_main k where a.id = j.debt_id and j.debt_id=k.debt_id and j.delete_mark='N'   ");
		sqljob.appendSQL(" and substring(right('0000000'+convert(varchar,(convert(varchar, k.repay_date, 112)-19110000)),7),1,5) <= ");
		sqljob.appendSQL(yearAndMonth);
		sqljob.appendSQL(")  as remark ");
		sqljob.appendSQL("from debt_main a,bank_ref b,payment_main c,issue_main d,budget_ref e,debit_ref f ");
	    sqljob.appendSQL("where a.bank_id = b.id ");
	    if(0 != myform.getIssueId())
	    {	
	    	sqljob.appendSQL("and d.id = ");
	    	sqljob.appendSQL(Integer.toString(myform.getIssueId()));
	    }
        sqljob.appendSQL("and a.id = c.debt_id ");
	    sqljob.appendSQL("and a.issue_id = d.id ");
	    sqljob.appendSQL("and d.budget_code <> 4 and d.budget_code = e.id ");
	    sqljob.appendSQL("and d.debt_code = f.id ");  
	    sqljob.appendSQL("and d.debt_type='D' ");
		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar, c.repay_date, 112)-19110000)),7),1,5) = ");
		sqljob.appendSQL(yearAndMonth);
	  	sqljob.appendSQL("and a.accrue = 'Y' ");
	  	sqljob.appendSQL("group by  a.id,a.bank_id,d.debt_name,e.budget_name,");
		sqljob.appendSQL("f.debit_name,b.bank_name,a.real_amount,datediff(dd,d.issue_date,d.due_date),a.ISSUE_AMOUNT,a.compare_rate,a.origin_interest_amount");

	
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