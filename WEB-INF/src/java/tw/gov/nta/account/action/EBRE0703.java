/* EBRE0703.java 報表
 程式目的：EBRE0703
 程式代號：EBRE0703
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

public class EBRE0703 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EBRE07_RPT1 ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob SQL1(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select debt_name,");
		sqljob.appendSQL("issue_serial,");
		sqljob.appendSQL("datediff(dd,issue_date, due_date) as daycount,");
		sqljob.appendSQL("issue_amount,");
		sqljob.appendSQL("budget_name, issue_main.id ");
		sqljob.appendSQL("from issue_main,budget_ref ");
		sqljob.appendSQL("where issue_main.budget_code = budget_ref.id ");
		sqljob.appendSQL("and issue_main.id = ? ");
		sqljob.addParameter(myForm.getIssueId());
		return sqljob;
	}

	protected SQLJob SQL2(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select sum(capital_amount + interest_amount) As payment_amount ");
		sqljob.appendSQL("from payment_main ");
		sqljob.appendSQL("where payment_main.issue_id = ? ");
		sqljob.appendSQL("and Year(payment_main.repay_date) = ? ");
		sqljob.appendSQL("and Month(payment_main.repay_date) = ? ");
		sqljob.addParameter(myForm.getIssueId());
		sqljob.addParameter(myForm.getSQLAccountYear());
		sqljob.addParameter(String.valueOf(myForm.getMonth()));
		return sqljob;
	}
	
	protected SQLJob SQL3(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select sum(payment_main.capital_amount + payment_main.interest_amount) As accupayment_amount ");
		sqljob.appendSQL("from issue_main,payment_main ");
		sqljob.appendSQL("where issue_main.id = payment_main.issue_id ");
		sqljob.appendSQL("and issue_main.id = ? ");
		sqljob.appendSQL("and payment_main.repay_date < ? ");
		sqljob.addParameter(myForm.getIssueId());
		sqljob.addParameter(myForm.getSQLLastDate());
		System.out.print(sqljob);
		return sqljob;
	}
	protected SQLJob SQL4(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select issue_amount - capital_amount - interest_amount As nonpay_amount");
		sqljob.appendSQL("from issue_main");
		sqljob.appendSQL("where issue_main.due_date < getDate() ");
		sqljob.appendSQL("and issue_main.id = ? ");
		sqljob.addParameter(myForm.getIssueId());
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	protected Map setDMap (Map tMap,String key){
		Map dMap = new HashMap();
		dMap.put(key,new BigDecimal(0));
		if (tMap != null && !tMap.isEmpty()){
			if (tMap.get(key) == null)
				dMap.put(key,new BigDecimal(0));
			else
				dMap.put(key,(BigDecimal)tMap.get(key));
		}			
		return dMap;
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
		dMap.put("daycount",tMap.get("daycount"));
		dMap.put("issue_amount",(BigDecimal)tMap.get("issue_amount"));
		tMap = (Map) run.query(SQL2(myForm), new MapHandler());
		dMap.putAll(setDMap(tMap,"payment_amount"));
		tMap = (Map) run.query(SQL3(myForm), new MapHandler());
		dMap.putAll(setDMap(tMap,"accupayment_amount"));
		tMap = (Map) run.query(SQL4(myForm), new MapHandler());
		dMap.putAll(setDMap(tMap,"nonpay_amount"));
		run.update(connection,insTemp("EBRE07_RPT1",dMap));
		request.setAttribute("file","EBRE07A");
	}
}
