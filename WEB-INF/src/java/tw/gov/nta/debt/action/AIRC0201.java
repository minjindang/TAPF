package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airc0201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRC0201 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "AIRC02_RPT";

	protected SQLJob insTemp(ActionForm form,String usrId){
		Airc0201Form AIRC0201form = (Airc0201Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME );
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, DEBT_NAME, ISSUE_DATE, DUE_DATE,LIMIT_DATE,");
		sqljob.appendSQL(" ISSUE_AMOUNT, TOTAL_EXG_AMOUNT, TOTAL_BUY_AMOUNT,");
		sqljob.appendSQL(" TOTAL_BACK_AMOUNT, NOPAY_CAPITAL_AMOUNT,");
		sqljob.appendSQL(" PAY_INTEREST_AMOUNT");
		sqljob.appendSQL(" ) ");

		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP, null, ");
		sqljob.appendSQL("max(A.debt_name), max(A.issue_date), max(A.due_date) ,");
		sqljob.appendSQL("'"+new Timestamp(AIRC0201form.getLimitDate().getTime())+"', ");
		sqljob.appendSQL("isnull(max(A.issue_amount),cast(0 as int)), ");
		sqljob.appendSQL("isnull(SUM( B.exg_amount),Cast(0 as int)) AS A_CAPITAL, ");
		sqljob.appendSQL("(select isnull(MAx( C.total_sell_amount),cast(0 as int)) from central_exchange_sell C where A.id=C.issue_id ");
		if( null != AIRC0201form.getLimitDate() )
		{
			sqljob.appendSQL("and Cast(Year(C.BACK_DATE) as varchar(20)) + Cast(Month(C.BACK_DATE) as varchar(20)) <=? ");
			sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRC0201form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRC0201form.getLimitDate()) + 1));
		}
		sqljob.appendSQL(" )AS B_CAPITAL, ");
		
		sqljob.appendSQL("(select isnull(Max( C.total_back_amount),cast(0 as int)) from central_exchange_sell C where A.id=C.issue_id ");
		if( null != AIRC0201form.getLimitDate() )
		{
			sqljob.appendSQL("and Cast(Year(C.BACK_DATE) as varchar(20)) + Cast(Month(C.BACK_DATE) as varchar(20)) <=? ");
			sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRC0201form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRC0201form.getLimitDate()) + 1));
		}
		sqljob.appendSQL(" )AS C_CAPITAL, ");
		sqljob.appendSQL("isnull(max(A.issue_amount),cast(0 as int)) - ");
		sqljob.appendSQL("isnull(SUM( B.exg_amount),cast(0 as int)) - ");
		sqljob.appendSQL("(select isnull(Max(C.total_sell_amount),cast(0 as int)) from central_exchange_sell C where A.id=C.issue_id ");
		if( null != AIRC0201form.getLimitDate() )
		{
			sqljob.appendSQL("and Cast(Year(C.BACK_DATE) as varchar(20)) + Cast(Month(C.BACK_DATE) as varchar(20)) <=? ");
			sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRC0201form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRC0201form.getLimitDate()) + 1));
		}
		sqljob.appendSQL(" ) - ");
		
		sqljob.appendSQL("(select  isnull(Max( C.total_back_amount),cast(0 as int)) from central_exchange_sell C where A.id=C.issue_id ");
		if( null != AIRC0201form.getLimitDate() )
		{
			sqljob.appendSQL("and Cast(Year(C.BACK_DATE) as varchar(20)) + Cast(Month(C.BACK_DATE) as varchar(20)) <=? ");
			sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRC0201form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRC0201form.getLimitDate()) + 1));
		}
		sqljob.appendSQL(" ) , ");
		sqljob.appendSQL("isnull((select SUM(isnull(C.sell_interest_amount,cast(0 as int))+isnull(C.back_interest_amount,cast(0 as int))) from central_exchange_sell C where A.id=C.issue_id ");
		if( null != AIRC0201form.getLimitDate() )
		{
			sqljob.appendSQL("and Cast(Year(C.BACK_DATE) as varchar(20)) + Cast(Month(C.BACK_DATE) as varchar(20)) <=? ");
			sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRC0201form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRC0201form.getLimitDate()) + 1));
		}
		sqljob.appendSQL(" ),cast(0 as int)) as interest ");
		
		sqljob.appendSQL("from issue_main A, central_exchange_month B ");
		sqljob.appendSQL("where A.id=B.issue_id ");
		sqljob.appendSQL("and A.debt_type='A' ");
		sqljob.appendSQL("and A.bond_kind='4' ");
		if( null != AIRC0201form.getLimitDate() )
		{
			sqljob.appendSQL("and B.term_ym<=? ");
			sqljob.addParameter(DateUtil.date2ROCStr(AIRC0201form.getLimitDate()).substring(0,5));
		}
		if( null != AIRC0201form.getBudgetCode() && !"".equals(AIRC0201form.getBudgetCode()) )
		{
			sqljob.appendSQL("and A.budget_code=? ");
			sqljob.addParameter(AIRC0201form.getBudgetCode());
		}
		if( null != AIRC0201form.getIssueSDate() )
		{
			sqljob.appendSQL("and A.issue_date>=? ");
			sqljob.addParameter(AIRC0201form.getIssueSDate());
		}
		if( null != AIRC0201form.getIssueEDate() )
		{
			sqljob.appendSQL("and A.issue_date<=? ");
			sqljob.addParameter(AIRC0201form.getIssueEDate());
		}
		sqljob.appendSQL("group by A.id ");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception
	{
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		//執行 insert
		run.update(connection,insTemp(form,usrId));
	}
}
