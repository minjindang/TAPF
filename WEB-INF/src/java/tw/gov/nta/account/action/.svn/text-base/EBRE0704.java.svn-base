/* EBRE0704.java 報表
 程式目的：EBRE0704
 程式代號：EBRE0704
 程式日期：0950602
 程式作者：Avery.Yeh
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EBRE0704 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EBRE07_RPT2 ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob SQL1(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select issue_main.debt_name,");
		sqljob.appendSQL("budget_ref.budget_name,");
		sqljob.appendSQL("issue_main.issue_serial,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 50000 then ticket_count else 0 end),0) As amount_of_50k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 100000 then ticket_count else 0 end),0) As amount_of_100k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 500000 then ticket_count else 0 end),0) As amount_of_500k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 1000000 then ticket_count else 0 end),0) As amount_of_1000k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 50000 then ticket_count else 0 end),0) As amount_of_50000,");
		sqljob.appendSQL("isNull(issue_amount,0) as issue_amount");
		sqljob.appendSQL("from issue_main,issue_ticket_det,budget_ref ");
		sqljob.appendSQL("where issue_main.id = issue_ticket_det.issue_id ");
		sqljob.appendSQL("and budget_ref.id = issue_main.budget_code ");
		sqljob.appendSQL("and issue_main.id = ? ");
		sqljob.appendSQL("group by issue_main.debt_name,");
		sqljob.appendSQL("budget_ref.budget_name,");
		sqljob.appendSQL("issue_main.issue_serial,");
		sqljob.appendSQL("issue_amount ");
		sqljob.addParameter(myForm.getIssueId());
		return sqljob;
	}

	protected SQLJob SQL2(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select isNull(sum(case ticket_amount when 50000 then ticket_count else 0 end),0) As payment_of_50k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 100000 then ticket_count else 0 end),0) As payment_of_100k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 500000 then ticket_count else 0 end),0) As payment_of_500k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 1000000 then ticket_count else 0 end),0) As payment_of_1000k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 50000 then ticket_count else 0 end),0) As payment_of_50000,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 50000 then ticket_count * 50000 ");
		sqljob.appendSQL("when 100000 then ticket_count * 100000 ");
		sqljob.appendSQL("when 500000 then ticket_count * 500000 ");
		sqljob.appendSQL("when 1000000 then ticket_count * 1000000 ");
		sqljob.appendSQL("else 0 end),0) As total_payment ");
		sqljob.appendSQL("from issue_main,payment_main,payment_ticket_det,budget_ref ");
		sqljob.appendSQL("where issue_main.id = payment_main.issue_id ");
		sqljob.appendSQL("and payment_main.id = payment_ticket_det.payment_id ");
		sqljob.appendSQL("and budget_ref.id = issue_main.budget_code ");
		sqljob.appendSQL("and issue_main.id = ? ");
		sqljob.appendSQL("and Year(payment_main.repay_date) = ? ");
		sqljob.appendSQL("and Month(payment_main.repay_date) = ? ");
		sqljob.addParameter(myForm.getIssueId());
		sqljob.addParameter(myForm.getAccountYear());
		sqljob.addParameter(String.valueOf(myForm.getMonth()));
		return sqljob;
	}
	
	protected SQLJob SQL3(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select isNull(sum(case ticket_amount when 50000 then ticket_count else 0 end),0) As accupayment_of_50k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 100000 then ticket_count else 0 end),0) As accupayment_of_100k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 500000 then ticket_count else 0 end),0) As accupayment_of_500k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 1000000 then ticket_count else 0 end),0) As accupayment_of_1000k,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 50000 then ticket_count else 0 end),0) As accupayment_of_50000,");
		sqljob.appendSQL("isNull(sum(case ticket_amount when 50000 then ticket_count * 50000 ");
		sqljob.appendSQL("when 100000 then ticket_count * 100000 ");
		sqljob.appendSQL("when 500000 then ticket_count * 500000 ");
		sqljob.appendSQL("when 1000000 then ticket_count * 1000000 ");
		sqljob.appendSQL("else 0 end),0) As total_accupayment ");
		sqljob.appendSQL("from issue_main,payment_main,payment_ticket_det ");
		sqljob.appendSQL("where issue_main.id = payment_main.issue_id ");
		sqljob.appendSQL("and payment_main.id = payment_ticket_det.payment_id ");
		sqljob.appendSQL("and issue_main.id = ? ");
		sqljob.appendSQL("and Not ((Year(payment_main.repay_date) > ? ) ");
		sqljob.appendSQL("or (Year(payment_main.repay_date) = ? ");
		sqljob.appendSQL("and Month(payment_main.repay_date) > ? ))");
		sqljob.addParameter(myForm.getIssueId());
		sqljob.addParameter(myForm.getAccountYear());
		sqljob.addParameter(myForm.getAccountYear());
		sqljob.addParameter(String.valueOf(myForm.getMonth()));
		return sqljob;
	}
	protected SQLJob SQL4(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select isNull((issue_amount - capital_amount - interest_amount),0) As nonpay_amount");
		sqljob.appendSQL("from issue_main");
		sqljob.appendSQL("where issue_main.due_date < getDate() ");
		sqljob.appendSQL("and issue_main.id = ? ");
		sqljob.addParameter(myForm.getIssueId());
		return sqljob;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		AccountQueryForm myForm = (AccountQueryForm) form;

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		Map dMap = new HashMap();
		dMap.putAll(getCommonMap(usrId));
		Map tMap = new HashMap();
		tMap = (Map) run.query(SQL1(myForm), new MapHandler());
		request.setAttribute("debt_name",(String)tMap.get("debt_name"));
		request.setAttribute("budget_name",(String)tMap.get("budget_name"));
		dMap.put("issue_serial",(String)tMap.get("issue_serial"));
		dMap.put("amount_of_50k",tMap.get("amount_of_50k"));
		dMap.put("amount_of_100k",tMap.get("amount_of_100k"));
		dMap.put("amount_of_500k",tMap.get("amount_of_500k"));
		dMap.put("amount_of_1000k",tMap.get("amount_of_1000k"));
		dMap.put("amount_of_50000",tMap.get("amount_of_50000"));
		dMap.put("issue_amount",(BigDecimal)tMap.get("issue_amount"));
		tMap = (Map) run.query(SQL2(myForm), new MapHandler());
		dMap.putAll(tMap);
		tMap = (Map) run.query(SQL3(myForm), new MapHandler());
		dMap.putAll(tMap);
		tMap = (Map) run.query(SQL4(myForm), new MapHandler());
		dMap.putAll(tMap);
		run.update(connection,insTemp("EBRE07_RPT2",dMap));
		request.setAttribute("file","EBRE07B");
	}
}
