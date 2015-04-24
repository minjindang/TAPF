package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Airc0101Form;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRC0101 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "AIRC01_RPT";

	protected SQLJob insTemp(ActionForm form,String usrId){
		Airc0101Form AIRC0101form = (Airc0101Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME );
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, DEBT_NAME, BUDGET_CODE,");
		sqljob.appendSQL(" DEBT_CODE, BOND_TYPE, ISSUE_DATE , DUE_DATE , ISSUE_AMOUNT,");
		sqljob.appendSQL(" GET_PRICE, SELL_AMOUNT, BACK_RATE, SALE_RATE,");
		sqljob.appendSQL(" FOREIGN_CAPITAL, EXCHANGE_STOCK_CODE,");
		sqljob.appendSQL(" ORIGINAL_PRICE, BANK_NAME ");
		sqljob.appendSQL(" ) ");	
		
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP, null, ");
		sqljob.appendSQL("A.debt_name, (select budget_name from budget_ref where id = A.budget_code ) ,");
		sqljob.appendSQL("(select debit_name from debit_ref where id = A.debt_code) , (case A.bond_type when '1' then '非自償' when '2' then '自償' end) , A.issue_date , A.due_date , ");	
		sqljob.appendSQL("A.issue_amount, B.get_price, A.sell_amount, B.back_rate/100, B.sale_rate/100, ");	
		sqljob.appendSQL("B.foreign_capital, (select stock_name from exstock_ref where id = B.exchange_stock_code ), B.original_price, C.bank_name ");	
		sqljob.appendSQL("from issue_main A, issue_exchange_det B, bank_ref C ");	
		sqljob.appendSQL("where A.id=B.issue_id ");	
		sqljob.appendSQL("and B.bank_code=C.id ");	
		sqljob.appendSQL("and A.debt_type='A' ");	
		sqljob.appendSQL("and A.bond_kind='4' ");	
		if( null != AIRC0101form.getBudgetCode() && !"".equals(AIRC0101form.getBudgetCode()) )
		{
			sqljob.appendSQL("and A.budget_code=? ");	
			sqljob.addParameter(AIRC0101form.getBudgetCode());
		}
		if( null != AIRC0101form.getIssueSDate() )
		{
			sqljob.appendSQL("and A.issue_date>=? ");	 
			sqljob.addParameter(AIRC0101form.getIssueSDate());
		}
		if( null != AIRC0101form.getIssueEDate() )
		{
			sqljob.appendSQL("and A.issue_date<=? ");	
			sqljob.addParameter(AIRC0101form.getIssueEDate());
		}
		System.out.println(sqljob);
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
