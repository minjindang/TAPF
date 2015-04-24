/* CPRA0201.java 報表
 程式目的：CPRA02
 程式代號：CPRA02
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cpra0301Form;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;
import tw.gov.nta.sql.debt.dao.DebtRateDetDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CPRA0301 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CPRA03_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Cpra0301Form myform = (Cpra0301Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO CPRA03_RPT ");
		sqljob.appendSQL(" (USRID, MOD_DATE, remark , Bank_name , Issue_amount , Issue_date , Due_date , Pay_dates , Pay_datee , days , Interest , Capital , sum , Rate )");
//		sqljob.appendSQL("select '" + usrId + "', CURRENT_TIMESTAMP ,'央行業務局 「 銀行業同業存款第  號 」 帳戶 ' , (select bank_name from bank_ref where id=A.bank_id) , sum(isnull(A.issue_amount,0)), ");
//		sqljob.appendSQL("select '" + usrId + "', CURRENT_TIMESTAMP ,'央行業務局 「 銀行業同業存款第  號 」 帳戶 ' , (select bank_name from bank_ref where id=A.bank_id) , sum(isnull(B.capital_amount,0)), ");
		sqljob.appendSQL("select '" + usrId + "', CURRENT_TIMESTAMP ,'央行業務局 「 銀行業存款第  號 」 帳戶 ' , (select bank_name from bank_ref where id=A.bank_id) ,");
		sqljob.appendSQL("case when sum(isnull(B.capital_amount,0)) > 0 then sum(isnull(B.capital_amount,0)) else sum(isnull(A.issue_amount,0)) end as issue_amount,");
		sqljob.appendSQL("(select issue_date from issue_main where id = max(A.issue_id) ),(select due_date from issue_main where id = max(A.issue_id) ) ,");
		sqljob.appendSQL("B.start_date, B.end_date, B.interest_days, sum(isnull(B.interest_amount,0)), sum(isnull(B.capital_amount,0)), sum(isnull(B.interest_amount,0) + isnull(B.capital_amount,0)), ");
//		sqljob.appendSQL("isnull((select isnull(debt_rate,0)/100 from debt_rate_det C where C.debt_id=max(A.id) and delete_mark='N' and effective_date<=B.start_date and suspend_date>=B.start_date),0) ");
		sqljob.appendSQL("(C.debt_rate/100) ");
		sqljob.appendSQL("from debt_main A, payment_main B, debt_rate_det C ");
		sqljob.appendSQL("where A.id=B.debt_id ");
		if(null != myform.getIssueId() && 0 != myform.getIssueId())
		{
			sqljob.appendSQL("and A.issue_id= ? ");
			sqljob.addParameter(myform.getIssueId());
		}	
		if(null != myform.getPayDate())
		{	
			sqljob.appendSQL("and B.repay_date= ? ");
			sqljob.addParameter(myform.getPayDate()); 
		}
		sqljob.appendSQL("and c.debt_id = a.id and delete_mark='N' and effective_date<=B.start_date and suspend_date>=B.start_date ");
		sqljob.appendSQL("group by A.bank_id, B.repay_date, B.start_date, B.end_date, B.interest_days, C.debt_rate ");
		
		System.out.println(sqljob);
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
		SQLJob sqljob = insTemp(form,usrId);
		if(null != sqljob.getSQL() && !"".equals(sqljob.getSQL()))
		{	
			run.update(connection,sqljob);
			Cpra0301Form myform = (Cpra0301Form) form;
			String note = (String)myform.getNote();
			String newNote = "=\"" + note.substring(0,12) +  "\" & TEXT(C10,\"mm月dd日 \")&\""  + note.substring(12,note.length()) + "\"";
//			myform.setNote(newNote);
			request.setAttribute("note",newNote);
		}	
	}


}
