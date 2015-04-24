package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Airc0601Form;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRC0601 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "AIRC06_RPT";

	protected SQLJob insTemp(ActionForm form,String usrId){
		Airc0601Form AIRC0601form = (Airc0601Form) form;
		String tmp2 = "公債";
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO AIRC06_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK ,");
		sqljob.appendSQL(" ISSUE_SERIAL,DEBT_NAME,term_no,");
		sqljob.appendSQL(" BANK_NAME,pay_fund,pay_month_amount,total_amount,"); 
		sqljob.appendSQL(" less_fund_amount ");
		sqljob.appendSQL(" ) ");	
		
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP, null ,");
		sqljob.appendSQL("A.issue_serial, A.debt_name, B.term_no, "); 
	    sqljob.appendSQL("C.bank_name, B.pay_fund, B.pay_month_amount, B.total_amount, B.less_fund_amount "); 
		sqljob.appendSQL("from issue_main A, central_bond_fund_less B, Bank_ref C "); 
		sqljob.appendSQL("where A.id=B.issue_id "); 
		sqljob.appendSQL("and C.id=B.bank_id "); 
		sqljob.appendSQL("and A.debt_type='A' "); 
		sqljob.appendSQL("and A.bond_kind='4' "); 
		if( null != AIRC0601form.getLimitDate() && !"".equals(AIRC0601form.getLimitDate()) )
		{
			sqljob.appendSQL("and B.term_ym=? "); 
			sqljob.addParameter(AIRC0601form.getLimitDate());
		}
		if( null != AIRC0601form.getissueSerial() )
		{
			sqljob.appendSQL("and A.issue_serial=? "); 
			sqljob.addParameter(AIRC0601form.getissueSerial());
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
