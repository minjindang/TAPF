package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Apra2501Form;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA2501 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "APRA25_RPT";

	protected SQLJob insTemp(ActionForm form,String usrId){
		Apra2501Form myForm = (Apra2501Form) form;
		SQLJob sqljob = new SQLJob();		
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME);
		sqljob.appendSQL(" ( budget_id , BUDGET_CODE, ISSUE_MONTH_AMOUNT, ISSUE_YEAR_AMOUNT, ISSUE_TOTAL_AMOUNT, NOPAY_CAPITAL_AMOUNT, ");
		sqljob.appendSQL(" NOPAY_INTEREST_AMOUNT, NOPAY_TOTAL_AMOUNT, ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK ");
		sqljob.appendSQL(" ) ");

		sqljob.appendSQL(" SELECT c.id , C.Budget_Name");
		sqljob.appendSQL(",ISNULL((SELECT SUM(I.ISSUE_AMOUNT) FROM ISSUE_MAIN I WHERE I.BUDGET_CODE=C.ID AND I.debt_type='A' AND YEAR(I.ISSUE_DATE)=YEAR(?) AND MONTH(I.ISSUE_DATE)=MONTH(?) ),0.00) AS ISSUE_MONTH_AMOUNT");
		sqljob.addParameter( myForm.getLimitDate() );
		sqljob.addParameter( myForm.getLimitDate() );
		sqljob.appendSQL(",ISNULL((SELECT SUM(I.ISSUE_AMOUNT) FROM ISSUE_MAIN I WHERE I.BUDGET_CODE=C.ID AND I.debt_type='A' AND YEAR(I.ISSUE_DATE)=YEAR(?) ),0.00) AS ISSUE_YEAR_AMOUNT");
		sqljob.addParameter( myForm.getLimitDate() );
		sqljob.appendSQL(",ISNULL((SELECT SUM(I.ISSUE_AMOUNT) FROM ISSUE_MAIN I WHERE I.BUDGET_CODE=C.ID AND I.debt_type='A' AND I.ISSUE_DATE<=? ),0.00) AS ISSUE_TOTAL_AMOUNT");
		sqljob.addParameter( myForm.getLimitDate() );
		sqljob.appendSQL(",ISNULL((SELECT SUM(P.CAPITAL_AMOUNT)-MAX(I.capital_amount) FROM ISSUE_MAIN I,DEBT_PLAN_DET P WHERE I.ISSUE_DATE<=? AND I.BUDGET_CODE=C.ID AND P.ISSUE_ID=I.ID AND I.debt_type='A' ),0.00) AS NOPAY_CAPITAL_AMOUNT");
		sqljob.addParameter( myForm.getLimitDate() );
		sqljob.appendSQL(",ISNULL((SELECT SUM(P.INTEREST_AMOUNT)-MAX(I.interest_amount) FROM ISSUE_MAIN I,DEBT_PLAN_DET P WHERE I.ISSUE_DATE<=? AND I.BUDGET_CODE=C.ID AND P.ISSUE_ID=I.ID AND I.debt_type='A' ),0.00) AS NOPAY_INTEREST_AMOUNT");
		sqljob.addParameter( myForm.getLimitDate() );
		sqljob.appendSQL(",ISNULL((SELECT SUM(P.CAPITAL_AMOUNT)+SUM(P.INTEREST_AMOUNT)-sum(I.interest_amount)-sum(I.capital_amount) FROM ISSUE_MAIN I,DEBT_PLAN_DET P WHERE I.ISSUE_DATE<=? AND I.BUDGET_CODE=C.ID AND P.ISSUE_ID=I.ID AND I.debt_type='A' ),0.00) AS NOPAY_TOTAL_AMOUNT");
		sqljob.addParameter( myForm.getLimitDate() );

		sqljob.appendSQL(",'"+usrId+"'");
		sqljob.appendSQL(",'"+new Timestamp( new Date().getTime() )+"'");
		sqljob.appendSQL(",''");

		sqljob.appendSQL("  FROM BUDGET_REF C ");
		sqljob.appendSQL(" WHERE 1=1 ");
		if( myForm.getBudgetCode()!=null && myForm.getBudgetCode().intValue() != 0)
		{
			sqljob.appendSQL("   AND C.ID=?");
			sqljob.addParameter( myForm.getBudgetCode() );
		}
		sqljob.appendSQL(" ORDER BY C.Budget_Type ");
		System.out.println(sqljob);
		return sqljob;
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
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
