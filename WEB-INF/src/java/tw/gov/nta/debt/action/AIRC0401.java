package tw.gov.nta.debt.action;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Airc0401Form;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

public class AIRC0401 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "AIRC04_RPT";

	protected SQLJob insTemp(ActionForm form,String usrId){
		Airc0401Form AIRC0401form = (Airc0401Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME );
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, DEBT_NAME, EXCHANGE_STOCK_CODE,");
		sqljob.appendSQL(" TOTAL_EXG_STOCK, LIBERATE_STOCK_AMOUNT, EXCHANGE_LESS_AMOUNT,");
		sqljob.appendSQL(" EXCHANGE_AMOUNT, CHG_REASON");
		sqljob.appendSQL(" ) ");	

		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP, null, ");
		sqljob.appendSQL("max(A.debt_name), (select stock_name from exstock_ref x where x.id=max(C.exchange_stock_code)), ");
		sqljob.appendSQL("SUM( B.exg_stock) AS A_CAPITAL, ");
		sqljob.appendSQL("SUM( B.exg_amount - B.exg_less_amount) AS B_CAPITAL, ");
		sqljob.appendSQL("SUM( B.exg_less_amount) AS C_CAPITAL, ");
		sqljob.appendSQL("sum( B.exg_amount) D_CAPITAL,");
		sqljob.appendSQL("null ");
		sqljob.appendSQL("from issue_main A, central_exchange_month B, issue_exchange_det C");
		sqljob.appendSQL("where A.id=B.issue_id ");
		sqljob.appendSQL("and A.id=C.issue_id ");
		sqljob.appendSQL("and A.debt_type='A' ");
		sqljob.appendSQL("and A.bond_kind='4' ");
		if( null != AIRC0401form.getLimitDate() )
		{
			sqljob.appendSQL("and B.term_ym<=? ");
			sqljob.addParameter(DateUtil.date2ROCStr(AIRC0401form.getLimitDate()).substring(0,5));
		}
		if( null != AIRC0401form.getIssueSDate() )
		{
			sqljob.appendSQL("and A.issue_date>=? ");
			sqljob.addParameter(AIRC0401form.getIssueSDate());
		}
		if( null != AIRC0401form.getIssueEDate() )
		{
			sqljob.appendSQL("and A.issue_date<=? ");
			sqljob.addParameter(AIRC0401form.getIssueEDate());
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