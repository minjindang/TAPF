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
import java.sql.Timestamp;
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


public class EARE0604 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARE06_RPT02 ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	/*
收解債款日報表(債票形式) for 公債
SELECT issue_main.debt_name,
	   issue_ticket_det.ticket_name,
	   issue_ticket_det.ticket_count,
	   issue_ticket_det.ticket_amount,
	   issue_main.issue_date,
	   ticket_count * ticket_amount As total_amount,
	   sum(debt_main.DIVERSITY_AMOUNT) AS diversity_amount
FROM   issue_main,issue_ticket_det,debt_main
WHERE  issue_main.id = debt_main.issue_id
  and issue_main.id = issue_ticket_det.issue_id
  and debt_type='A'
  AND  Year(issue_date) = 會計年度
  AND  Month(issue_date) = 會計月份
  AND  (issue_main.id = [issue_id])
  	 */	
		protected SQLJob insTemp(ActionForm form,String usrId){
			AccountQueryForm myForm = (AccountQueryForm) form;
//			查詢條件
			Timestamp today = new Timestamp( new Date().getTime() );
		    Integer debtId = CheckNullValue.checkNullPasueZero(myForm.getDebtId())  ;
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL(" INSERT INTO EARE06_RPT02 ");
			sqljob.appendSQL(" ( usrid,mod_date,debt_name,ticket_name,ticket_count,ticket_amount, total_amount,remark ) ");
			sqljob.appendSQL(" select ?,?,issue_main.debt_name,issue_ticket_det.ticket_name,issue_ticket_det.ticket_count,issue_ticket_det.ticket_amount,ticket_count * ticket_amount As total_amount,issue_main.REMARK ");
			sqljob.addParameter(usrId);
			sqljob.addParameter(today);
			sqljob.appendSQL(" FROM   issue_main,issue_ticket_det " +
			          		" WHERE  issue_main.id = issue_ticket_det.issue_id " +
				        	" and debt_type='A' ");
            if (!debtId.equals(0)){
				sqljob.appendSQL(" AND  debt_main.id = "+debtId+" ");
			}
			System.out.println(sqljob.toString());
			return sqljob;
		}

		protected SQLJob last(ActionForm form,String usrId){
			AccountQueryForm myForm = (AccountQueryForm) form;
//			查詢條件
			Timestamp today = new Timestamp( new Date().getTime() );
			Integer AccountYear = Integer.parseInt(myForm.getAccountYear())+1911  ;
		    String Month       = CheckNullValue.checkNullPasueEmpty(myForm.getMonth());
		    Integer issueId = CheckNullValue.checkNullPasueZero(myForm.getIssueId())  ;
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("INSERT INTO EARE06_RPT02 ");
			sqljob.appendSQL(" ( usrid,mod_date,ticket_name,total_amount) ");
			sqljob.appendSQL("select top 1 ?,?,'本日溢(折)價或現息合計',sum(debt_main.DIVERSITY_AMOUNT) AS diversity_amount");
			sqljob.addParameter(usrId);
		 	sqljob.addParameter(today);
			sqljob.appendSQL("FROM   issue_main,issue_ticket_det,debt_main");
			sqljob.appendSQL("WHERE  issue_main.id = debt_main.issue_id");
			sqljob.appendSQL("and issue_main.id = issue_ticket_det.issue_id");
			sqljob.appendSQL("and debt_type='A'");
			sqljob.appendSQL("AND  Year(issue_date) = '"+AccountYear+"'");
			sqljob.appendSQL("AND  Month(issue_date) = '"+Month+"'");
            if (!issueId.equals(0)){
				sqljob.appendSQL("AND  issue_main.id = "+issueId+" ");
			}
			
            System.out.println(sqljob);
			return sqljob;
		}

		
		protected SQLJob taital(ActionForm form,String usrId){
			AccountQueryForm myForm = (AccountQueryForm) form;
//			查詢條件
			Timestamp today = new Timestamp( new Date().getTime() );
			Integer AccountYear = Integer.parseInt(myForm.getAccountYear())+1911  ;
		    String Month       = CheckNullValue.checkNullPasueEmpty(myForm.getMonth());
		    Integer issueId = CheckNullValue.checkNullPasueZero(myForm.getIssueId())  ;
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("SELECT top 1 issue_main.debt_name,issue_ticket_det.ticket_name,issue_ticket_det.ticket_count,issue_ticket_det.ticket_amount,issue_main.issue_date,ticket_count * ticket_amount As total_amount");
			sqljob.appendSQL("FROM   issue_main,issue_ticket_det,debt_main");
			sqljob.appendSQL("WHERE  issue_main.id = debt_main.issue_id and issue_main.id = issue_ticket_det.issue_id and debt_type='A'");
			sqljob.appendSQL("AND  Year(issue_date) = '"+AccountYear+"'");
			sqljob.appendSQL("AND  Month(issue_date) = '"+Month+"'");
            if (!issueId.equals(0)){
				sqljob.appendSQL("AND  issue_main.id = "+issueId+" ");
			}
			System.out.println(sqljob.toString());
			return sqljob;
		}

		public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
			//Bira1401Form bira1401Form = (Bira1401Form) form;
			//取得使用者帳號
			request.setAttribute("file","EARE06B");
			System.out.print("第二項");
			String usrId = this.getUserId(request);
			//取得SQLRunner
			SQLRunner run = new ConnectionSQLRunner(connection);
			//執行 delete 
			run.update(connection,delTemp(form,usrId));
			//執行 insert
			run.update(connection,insTemp(form,usrId));
			//執行 最後一筆
			run.update(connection,last(form,usrId));
//			傳下頁表頭區
	        request.setAttribute("debtName","");	
	        request.setAttribute("issueDate","");	
	        SQLJob queryJob1 = taital(form,usrId);
			List queryList1 = (List) run.query(queryJob1, new MapListHandler());
			Iterator it1 = queryList1.iterator();
			if (it1.hasNext()){
				Map mapQry1 = (Map) it1.next();				
				if (mapQry1.get("debt_name") != null ){
			        request.setAttribute("debtName",CheckNullValue.checkNullPasueEmpty(mapQry1.get("debt_name")));	
			        request.setAttribute("issueDate",DateUtil.date2ROCStr((Date)mapQry1.get("issue_date"),"yyy/MM/dd"));	
				}
			}
		}
}
