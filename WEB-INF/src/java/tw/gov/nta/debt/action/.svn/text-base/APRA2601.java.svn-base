package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra2601Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA2601 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "APRA26_RPT";

	protected SQLJob insTemp(ActionForm form,String usrId){
		Apra2601Form myForm = (Apra2601Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME);
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" DEBT_NAME, CAPITAL_CNT, INTEREST_CNT, TOTAL_AMT, ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK ");
		sqljob.appendSQL(" ) ");
		
		sqljob.appendSQL("select (select debt_name from issue_main where id=max(A.id)) as debt_name , ");
		sqljob.appendSQL("'1 ~ ' + cast(max(B.capital_serial) as varchar(255)) as maxC, ");
		sqljob.appendSQL("'1 ~ ' + cast(max(B.interest_serial) as varchar(255)) as maxI, ");
		sqljob.appendSQL("null , '" + usrId+"' , CURRENT_TIMESTAMP , null ");
		sqljob.appendSQL("from issue_main A, debt_plan_det B ");
		sqljob.appendSQL("where A.debt_type='A' ");
		sqljob.appendSQL("and A.id=B.issue_id ");
		sqljob.appendSQL("and A.cash_due_date >=? ");
		sqljob.appendSQL("AND A.cash_due_date <=? ");
//		sqljob.appendSQL("group by A.id, A.issue_serial ");
//		sqljob.appendSQL("order by A.issue_serial ");
		sqljob.appendSQL("group by debt_name ");
		sqljob.addParameter( myForm.getDueSdate() );
		sqljob.addParameter( myForm.getDueEdate() );
		System.out.println(sqljob);
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception
	{
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//執行 delete 
		run.update(connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		//執行 insert
		run.update(connection,insTemp(form,usrId));
	}
}