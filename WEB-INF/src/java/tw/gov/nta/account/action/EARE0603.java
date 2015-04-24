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

public class EARE0603 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARE06_RPT01 ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	/*
只有一筆
收解債款日報表(登錄形式) for 公債
SELECT issue_main.debt_name,
	   issue_main.issue_amount /100000 As issue_count, B8
	   issue_main.ISSUE_AMOUNT, C8 13 14
	   issue_main.issue_date,  抬頭
       sum(debt_main.DIVERSITY_AMOUNT) AS diversity_amount,  D9 12
       debt_main.real_amount  D8 13 14
FROM   issue_main,debt_main
WHERE  issue_main.id = debt_main.issue_id
  and  debt_type='A'
  AND  Year(issue_date) = 會計年度
  AND  Month(issue_date) = 會計月份
  AND  (issue_main.id = [issue_id])  	 
group by debt_name,issue_count,ISSUE_AMOUNT,issue_date,diversity_amount,real_amount  
  */	
		
		protected SQLJob taital(ActionForm form,String usrId){
			AccountQueryForm myForm = (AccountQueryForm) form;
			//查詢條件
			Integer debtId = CheckNullValue.checkNullPasueZero(myForm.getDebtId())  ;
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("SELECT issue_main.debt_name + '('+debit_name+')' as debt_name," +
					"debt_main.issue_amount /100000 As issue_count," +
					"debt_main.ISSUE_AMOUNT," +
					"issue_main.issue_date," +
					"case when debt_main.diversity_amount < 0 then 0-(debt_main.diversity_amount) "+
					"     else debt_main.diversity_amount end as diversity_amount,"+
					"     debt_main.payable_interest_amount,"+
//					"(isnull(debt_main.REAL_AMOUNT,0)-(isnull(debt_main.ISSUE_AMOUNT,0)+isnull(issue_main.payable_interest_amount,0))) AS diversity_amount," +
			"debt_main.real_amount");
			sqljob.appendSQL("FROM   issue_main,debt_main,debit_ref ");
			sqljob.appendSQL("WHERE  issue_main.id = debt_main.issue_id ");
			sqljob.appendSQL("and  debt_main.debt_code=debit_ref.id ");
			sqljob.appendSQL("and  debt_type='A'" );
			if (!debtId.equals(0)){
				sqljob.appendSQL("AND  debt_main.id = "+debtId+" ");
			}
			sqljob.appendSQL("group by  debt_main.payable_interest_amount,debt_main.diversity_amount,issue_main.Debt_NAME, debt_main.ISSUE_AMOUNT,issue_main.ISSUE_DATE,debt_main.REAL_AMOUNT,debit_name");
//			sqljob.appendSQL("group by  issue_main.payable_interest_amount,issue_main.Debt_NAME, debt_main.ISSUE_AMOUNT,issue_main.ISSUE_DATE,debt_main.REAL_AMOUNT,debit_name");
			System.out.println(sqljob.toString());
			return sqljob;
		}
		
		
		public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
			//Bira1401Form bira1401Form = (Bira1401Form) form;
			//取得使用者帳號
			request.setAttribute("file","EARE06A");
			System.out.print("第一項");
			String usrId = this.getUserId(request);
			//取得SQLRunner
			SQLRunner run = new ConnectionSQLRunner(connection);
			//執行 delete 
			run.update(connection,delTemp(form,usrId));
			//執行 insert
			//傳下頁表頭區
			request.setAttribute("debtName","");	
	        request.setAttribute("issueCount","");	
	        request.setAttribute("issueAmount","");	
	        request.setAttribute("issueDate","");	
	        request.setAttribute("diversityAmount","");	
	        request.setAttribute("realAmount","");
	        request.setAttribute("payableInterestAmount","");
	        SQLJob queryJob1 = taital(form,usrId);
			List queryList1 = (List) run.query(queryJob1, new MapListHandler());
			Iterator it1 = queryList1.iterator();
			if (it1.hasNext()){
				Map mapQry1 = (Map) it1.next();
				if (mapQry1.get("debt_name") != null ){
					request.setAttribute("debtName",CheckNullValue.checkNullPasueEmpty(mapQry1.get("debt_name")));	
			        request.setAttribute("issueCount",CheckNullValue.checkNullPasueZero(mapQry1.get("issue_count")));	
			        request.setAttribute("issueAmount",CheckNullValue.checkNullPasueZero(mapQry1.get("ISSUE_AMOUNT")));	
			        request.setAttribute("issueDate",DateUtil.date2ROCStr((Date)mapQry1.get("issue_date"),"yyy/MM/dd"));	
			        request.setAttribute("diversityAmount",CheckNullValue.checkNullPasueZero(mapQry1.get("diversity_amount")));	
			        request.setAttribute("realAmount",CheckNullValue.checkNullPasueZero(mapQry1.get("real_amount")));
			        request.setAttribute("payableInterestAmount",CheckNullValue.checkNullPasueZero(mapQry1.get("payable_interest_amount")));
				}
				
			}
			
        }
}
