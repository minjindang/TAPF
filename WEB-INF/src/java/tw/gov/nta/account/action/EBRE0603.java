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

public class EBRE0603 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EBRE06_RPT01 ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	/*

收解債款日報表(登錄形式) for 國庫券
SELECT issue_main.debt_name,
	   issue_main.issue_date,                  //表頭日期
       budget_ref.BUDGET_NAME,
	   issue_main.ISSUE_AMOUNT,
       issue_main.AVERAGE_RATE, 
       debt_main.DIVERSITY_AMOUNT AS interest_amount, 
       debt_main.REAL_AMOUNT
       debt_main.REMARK
FROM   issue_main,debt_main,budget_ref
WHERE  issue_main.id = debt_main.issue_id
  AND  issue_main.budget_code = budget_ref.id
  AND  issue_main.debt_type = 'B'
  AND  Year(issue_main.issue_date) = [會計年度] + 1911
  AND  Month(issue_main.issue_date) = [月份]
  AND  issue_main.id = [issue_id]
  	 */	
		protected SQLJob insTemp(ActionForm form,String usrId){
			AccountQueryForm myForm = (AccountQueryForm) form;
			Integer accountYear = Integer.parseInt(myForm.getAccountYear())+1911;
			int month = Integer.parseInt(myForm.getMonth())  ;
			Date today = new Date();
			//查詢條件
			Integer issueId = CheckNullValue.checkNullPasueZero(myForm.getIssueId())  ;
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("INSERT INTO EBRE06_RPT01 ");
			sqljob.appendSQL(" ( usrid,mod_date    ,debt_name ," +
					         "    issue_date       ,BUDGET_NAME,ISSUE_AMOUNT," +
					         "    AVERAGE_RATE     , interest_amount," +
					         "    REAL_AMOUNT      , REMARK ) ");
			sqljob.appendSQL("select ?,?,issue_main.debt_name,issue_main.issue_date,budget_ref.BUDGET_NAME,");
			sqljob.addParameter(usrId);
			sqljob.addParameter(today);
			sqljob.appendSQL("issue_main.ISSUE_AMOUNT,issue_main.AVERAGE_RATE,debt_main.DIVERSITY_AMOUNT AS interest_amount,");
			sqljob.appendSQL("debt_main.REAL_AMOUNT,debt_main.REMARK");
			sqljob.appendSQL("FROM   issue_main,debt_main,budget_ref");
			sqljob.appendSQL("WHERE  issue_main.id = debt_main.issue_id");
			sqljob.appendSQL("AND  issue_main.budget_code = budget_ref.id");
			sqljob.appendSQL("AND  issue_main.debt_type = 'B'");
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
			int month = Integer.parseInt(myForm.getMonth())  ;
			Integer issueId = CheckNullValue.checkNullPasueZero(myForm.getIssueId())  ;
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("select top 1 issue_main.debt_name,issue_main.issue_date,budget_ref.BUDGET_NAME,");
			sqljob.appendSQL("issue_main.ISSUE_AMOUNT,issue_main.AVERAGE_RATE,debt_main.DIVERSITY_AMOUNT AS interest_amount,");
			sqljob.appendSQL("debt_main.REAL_AMOUNT,debt_main.REMARK");
			sqljob.appendSQL("FROM   issue_main,debt_main,budget_ref");
			sqljob.appendSQL("WHERE  issue_main.id = debt_main.issue_id");
			sqljob.appendSQL("AND  issue_main.budget_code = budget_ref.id");
			sqljob.appendSQL("AND  issue_main.debt_type = 'B'");
			if (!issueId.equals(0)){
				sqljob.appendSQL("AND  issue_main.id = "+issueId+" ");
			}
			System.out.println(sqljob.toString());
			return sqljob;
		}
		
		
		public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
			//Bira1401Form bira1401Form = (Bira1401Form) form;
			//取得使用者帳號
			request.setAttribute("file","EBRE06A");
			System.out.print("第一項");
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
			if (it1.hasNext()){
				Map mapQry1 = (Map) it1.next();
				//if ( mapQry1.get("debt_name") != null ){
			        request.setAttribute("debtName",CheckNullValue.checkNullPasueEmpty(mapQry1.get("debt_name")));	
			        request.setAttribute("issueDate",DateUtil.date2ROCStr((Date)mapQry1.get("issue_date"),"yyy/MM/dd"));	
			        request.setAttribute("budgetName", CheckNullValue.checkNullPasueEmpty(mapQry1.get("BUDGET_NAME")));
				//}
				
			}
			
        }
}
