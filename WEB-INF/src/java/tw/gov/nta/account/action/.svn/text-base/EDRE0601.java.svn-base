package tw.gov.nta.account.action;

import gov.dnt.tame.common.CheckNullValue;
import gov.dnt.tame.common.DefaultAction;
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

public class EDRE0601 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EDRE06_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
/*
select   c.debt_name,d.budget_name,e.debit_name,datediff(dd,c.issue_date,c.due_date) As dayCount,
         b.bank_name, a.issue_amount, a.real_amount,a.remark
from     debt_main a,bank_ref b,issue_main c,budget_ref d,debit_ref e
where    a.bank_id = b.id
 and     a.issue_id = c.id
 and     c.budget_code = d.id
 and     c.debt_code = e.id
 and     a.issue_id = [發行id]
 and     a.accrue = 'y'


 */	
	protected SQLJob insTemp(ActionForm form,String usrId){
		AccountQueryForm myForm = (AccountQueryForm) form;
		Date today = new Date();
		//查詢條件
		Integer issueId = CheckNullValue.checkNullPasueZero(myForm.getIssueId())  ;
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" INSERT INTO EDRE06_RPT ");
		sqljob.appendSQL(" ( usrid,mod_date,debt_name ,budget_name,debit_name,dayCount, ");
		sqljob.appendSQL("  bank_name, issue_amount, real_amount,remark ");
		sqljob.appendSQL(" ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" select ?,?,c.debt_name,d.budget_name,e.debit_name,datediff(dd,c.issue_date,c.due_date) As dayCount,");
		sqljob.appendSQL(" b.bank_name, a.issue_amount, a.issue_amount,''");
		sqljob.appendSQL(" from     debt_main a,bank_ref b,issue_main c,budget_ref d,debit_ref e ");
		sqljob.addParameter(usrId);
		sqljob.addParameter(today);
		sqljob.appendSQL(" where    a.bank_id = b.id ");
		sqljob.appendSQL(" and     a.issue_id = c.id ");
		sqljob.appendSQL(" and     c.budget_code <> 4 ");
		sqljob.appendSQL(" and     c.budget_code = d.id ");
		sqljob.appendSQL(" and     c.debt_code = e.id ");
		if (!issueId.equals(0)){
			sqljob.appendSQL(" and  a.issue_id = "+issueId+" ");
		}
		sqljob.appendSQL(" and     a.accrue = 'Y'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob taital(ActionForm form,String usrId){
		AccountQueryForm myForm = (AccountQueryForm) form;
		//查詢條件
		Integer issueId = CheckNullValue.checkNullPasueZero(myForm.getIssueId())  ;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select top 1 c.debt_name,d.budget_name,e.debit_name,datediff(dd,c.issue_date,c.due_date) As dayCount,c.issue_date,");
		sqljob.appendSQL(" b.bank_name, a.issue_amount, a.real_amount,a.remark");
		sqljob.appendSQL(" from     debt_main a,bank_ref b,issue_main c,budget_ref d,debit_ref e");
		sqljob.appendSQL(" where    a.bank_id = b.id ");
		sqljob.appendSQL(" and     a.issue_id = c.id ");
		sqljob.appendSQL(" and     c.budget_code = d.id ");
		sqljob.appendSQL(" and     c.debt_code = e.id ");
		if (!issueId.equals(0)){
			sqljob.appendSQL(" and  a.issue_id = "+issueId+" ");
		}
		sqljob.appendSQL("  and     a.accrue = 'Y'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId));
//		傳下頁表頭區
        request.setAttribute("debtName","");	
		request.setAttribute("budgetName","");
		request.setAttribute("debitName", "");
		request.setAttribute("dayCount", "");
		request.setAttribute("issueDate","");	
        SQLJob queryJob1 = taital(form,usrId);
		List queryList1 = (List) run.query(queryJob1, new MapListHandler());
		Iterator it1 = queryList1.iterator();
		if (it1.hasNext()){
		    Map mapQry1 = (Map) it1.next();
		    request.setAttribute("issueDate",DateUtil.date2ROCStr((Date)mapQry1.get("issue_date"),"yyy/MM/dd"));
		    request.setAttribute("debtName",CheckNullValue.checkNullPasueEmpty(mapQry1.get("debt_name")));	
			request.setAttribute("budgetName",CheckNullValue.checkNullPasueEmpty(mapQry1.get("budget_name")));
			request.setAttribute("debitName", CheckNullValue.checkNullPasueEmpty(mapQry1.get("debit_name")));
			if( mapQry1.get("dayCount") != null ){
				request.setAttribute("dayCount", mapQry1.get("dayCount").toString() );
			}
			
			
		}
	}}
