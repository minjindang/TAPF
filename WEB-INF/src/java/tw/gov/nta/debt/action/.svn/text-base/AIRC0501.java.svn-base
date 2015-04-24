package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Airc0501Form;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRC0501 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "AIRC05_RPT";

	protected SQLJob insTemp(ActionForm form,String usrId){
		Airc0501Form AIRC0501form = (Airc0501Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME );
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, ISSUE_SERIAL,");
		sqljob.appendSQL(" DEBT_NAME, ISSUE_AMOUNT, BACK_DATE,");
		sqljob.appendSQL(" BACK_RATE, BANK_NAME, TOTAL_SELL_AMOUNT,"); 
		sqljob.appendSQL(" SELL_INTEREST_AMOUNT, TOTAL_BACK_AMOUNT,");
		sqljob.appendSQL(" BACK_INTEREST_AMOUNT ");
		sqljob.appendSQL(" ) ");	
		
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP, null , A.issue_serial, A.debt_name, A.issue_amount, B.back_date, B.back_rate, ");
		sqljob.appendSQL("C.bank_name, B.TOTAL_SELL_AMOUNT, B.SELL_INTEREST_AMOUNT, B.TOTAL_BACK_AMOUNT, B.BACK_INTEREST_AMOUNT ");
		sqljob.appendSQL("from issue_main A, Central_exchange_sell B, Bank_ref C ");
		sqljob.appendSQL("where A.id=B.issue_id ");
        sqljob.appendSQL("and C.id=B.bank_id ");
        sqljob.appendSQL("and A.debt_type='A' ");
        sqljob.appendSQL("and A.bond_kind='4' ");
        if( null != AIRC0501form.getissueSerial())
		{
        	sqljob.appendSQL("and A.issue_serial=? ");
			sqljob.addParameter(AIRC0501form.getissueSerial());
		}
        if( null != AIRC0501form.getLimitDate())
		{
        	sqljob.appendSQL("and B.back_date=? ");
			sqljob.addParameter(AIRC0501form.getLimitDate());
		}
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
