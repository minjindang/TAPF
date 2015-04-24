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

import gov.dnt.tame.common.CheckNullValue;
import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EBRE0604 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EBRE06_RPT02 ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	/*
收解債款日報表(債票形式) for 國庫券
SELECT issue_main.debt_name,budget_ref.BUDGET_NAME,
	   issue_main.issue_date,issue_ticket_det.ticket_name,
	   issue_ticket_det.ticket_count,issue_ticket_det.ticket_amount,
	   0 As interest_amount,issue_ticket_det.ticket_count * issue_ticket_det.ticket_amount As total_amount,
	   issue_main.REMARK
FROM   issue_main,budget_ref,issue_ticket_det
WHERE  issue_main.budget_code = budget_ref.id
  And  issue_main.id = issue_ticket_det.issue_id
  AND  Year(issue_main.issue_date) = [會計年度] + 1911
  AND  Month(issue_main.issue_date) = [月份]
  And  issue_main.debt_type = 'B'
  AND  issue_main.id = [issue_id]
  	 */	
		protected SQLJob insTemp(ActionForm form,String usrId){
			AccountQueryForm myForm = (AccountQueryForm) form;
			Date today = new Date();
			//查詢條件
			Integer accountYear = Integer.parseInt(myForm.getAccountYear())+1911;
			int month = Integer.parseInt(myForm.getMonth())  ;
			Integer issueId = CheckNullValue.checkNullPasueZero(myForm.getIssueId())  ;
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("INSERT INTO EBRE06_RPT02 ");
			sqljob.appendSQL(" ( usrid,mod_date,debt_name,BUDGET_NAME,issue_date,");
			sqljob.appendSQL("  ticket_name , ticket_count,ticket_amount, interest_amount,total_amount,");
			sqljob.appendSQL(" REMARK ");
			sqljob.appendSQL(" ) ");
			sqljob.appendSQL("select ?,?,issue_main.debt_name,budget_ref.BUDGET_NAME," +
				                    	"issue_main.issue_date,issue_ticket_det.ticket_name,");
			sqljob.addParameter(usrId);
			sqljob.addParameter(today);
			sqljob.appendSQL("issue_ticket_det.ticket_count,issue_ticket_det.ticket_amount,");
			sqljob.appendSQL("0 As interest_amount,issue_ticket_det.ticket_count * issue_ticket_det.ticket_amount As total_amount," +
					"issue_main.REMARK");
			sqljob.appendSQL("FROM   issue_main,budget_ref,issue_ticket_det");
			sqljob.appendSQL("WHERE  issue_main.budget_code = budget_ref.id");
			sqljob.appendSQL("And  issue_main.id = issue_ticket_det.issue_id");
			sqljob.appendSQL("AND  Year(issue_main.issue_date) = "+accountYear +" ");
			sqljob.appendSQL("AND  Month(issue_main.issue_date) = "+month+"");
			if (!issueId.equals(0)){
				sqljob.appendSQL("AND  issue_main.id = "+issueId+" ");
			}
			System.out.println(sqljob.toString());
			return sqljob;
		}
		
		protected SQLJob taital(ActionForm form,String usrId){
			AccountQueryForm myForm = (AccountQueryForm) form;
			Date today = new Date();
			//查詢條件
			Integer accountYear = Integer.parseInt(myForm.getAccountYear())+1911;
			int month = Integer.parseInt(myForm.getMonth());
			Integer issueId = CheckNullValue.checkNullPasueZero(myForm.getIssueId())  ;
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("select top 1 issue_main.debt_name,budget_ref.BUDGET_NAME," +
				                    	"issue_main.issue_date,issue_ticket_det.ticket_name,");
			sqljob.appendSQL("issue_ticket_det.ticket_count,issue_ticket_det.ticket_amount,");
			sqljob.appendSQL("0 As interest_amount,issue_ticket_det.ticket_count * issue_ticket_det.ticket_amount As total_amount," +
					"issue_main.REMARK");
			sqljob.appendSQL("FROM   issue_main,budget_ref,issue_ticket_det");
			sqljob.appendSQL("WHERE  issue_main.budget_code = budget_ref.id");
			sqljob.appendSQL("And  issue_main.id = issue_ticket_det.issue_id");
			sqljob.appendSQL("AND  Year(issue_main.issue_date) = "+accountYear +" ");
			sqljob.appendSQL("AND  Month(issue_main.issue_date) = "+month+"");
			sqljob.appendSQL("And  issue_main.debt_type = 'B'");
			if (!issueId.equals(0)){
				sqljob.appendSQL("AND  issue_main.id = "+issueId+" ");
			}
			System.out.println(sqljob.toString());
			return sqljob;
		}
		
		
		public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
			//Bira1401Form bira1401Form = (Bira1401Form) form;
			//取得使用者帳號
			request.setAttribute("file","EBRE06B");
			System.out.print("第二項");
			String usrId = this.getUserId(request);
			//取得SQLRunner
			SQLRunner run = new ConnectionSQLRunner(connection);
			//執行 delete 
			run.update(connection,delTemp(form,usrId));
			//執行 insert
			run.update(connection,insTemp(form,usrId));
//			傳下頁表頭區
	        request.setAttribute("debtName","");	
	        request.setAttribute("issueDate", "");
			request.setAttribute("budgetName","");
			SQLJob queryJob1 = taital(form,usrId);
			List queryList1 = (List) run.query(queryJob1, new MapListHandler());
			Iterator it1 = queryList1.iterator();
			Map mapQry1 = (Map) it1.next();
			if (it1.hasNext()){

			//	if (mapQry1.get("debt_name") != null ){
			        request.setAttribute("debtName",CheckNullValue.checkNullPasueEmpty(mapQry1.get("debt_name")));	
			        request.setAttribute("issueDate",DateUtil.date2ROCStr((Date)mapQry1.get("issue_date"),"yyy/MM/dd"));	
			        request.setAttribute("budgetName", CheckNullValue.checkNullPasueEmpty(mapQry1.get("BUDGET_NAME")));
		//		}
			}
		}
}
