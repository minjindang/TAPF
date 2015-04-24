/* AIRC0901.java 報表
 程式目的：AIRC09
 程式代號：AIRC09
 程式日期：0950309
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airc0701Form;
import tw.gov.nta.debt.form.Airc0901Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRC0901 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRC09_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

//	protected SQLJob insTemp(ActionForm form,String usrId){
//		Airc0901Form airc0901Form = (Airc0901Form) form;
//		System.out.println(airc0901Form.getLimitDate());
//		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("INSERT INTO AIRC09_RPT ");
//		sqljob.appendSQL(" ( ");
//		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, ISSUE_SERIAL, ");
//		sqljob.appendSQL(" DEBT_NAME, ");
//		sqljob.appendSQL("  ISSUE_AMOUNT, ");
//		sqljob.appendSQL(" BANK_ID, ");
//		sqljob.appendSQL(" SEP_AMOUNT, CON_AMOUNT, NOSEP_AMOUNT ,SEP_LESS_AMOUNT , TOTAL_AMOUNT");
//		sqljob.appendSQL(" ) ");
//		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP , '', I.ISSUE_SERIAL,");
//		sqljob.appendSQL(" I.DEBT_NAME,");
//		sqljob.appendSQL(" I.ISSUE_AMOUNT, ");
//		sqljob.appendSQL(" (SELECT BANK_NAME FROM BANK_REF WHERE BANK_CODE=Q.ACTNO ) AS BANK_ID, " );
//		sqljob.appendSQL(" Q.AAMT AS SEP_AMOUNT, Q.BAMT AS CON_AMOUNT, Q.CAMT AS NOSEP_AMOUNT , Q.DAMT AS SEP_LESS_AMOUNT , (Q.CAMT + Q.DAMT ) AS  TOTAL_AMOUNT ");
//		sqljob.appendSQL(" FROM ISSUE_MAIN I,TRBSTR3 Q");
//		sqljob.appendSQL("WHERE I.BOND_KIND='4' AND I.ID = Q.ISSUE_ID ");
//		if( null != airc0901Form.getIssueSerial() && !" ".equals(airc0901Form.getIssueSerial()) )
//		{
//			sqljob.appendSQL("AND I.ISSUE_SERIAL=?");
//			sqljob.addParameter(airc0901Form.getIssueSerial());
//		}
//		if( null != airc0901Form.getLimitDate() && !" ".equals(airc0901Form.getLimitDate()) )
//		{
//			sqljob.appendSQL("AND Q.DATE=?");
//			sqljob.addParameter(airc0901Form.getLimitDate());
//		}
//		sqljob.appendSQL("ORDER BY Q.ACTNO ");
//		System.out.println(sqljob.toString());
//		return sqljob;
//	}
	protected SQLJob insTemp(ActionForm form,String usrId){
		Airc0901Form airc0901Form = (Airc0901Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO AIRC09_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, ISSUE_SERIAL, ");
		sqljob.appendSQL(" DEBT_NAME, ");
		sqljob.appendSQL(" ISSUE_AMOUNT, ");
		sqljob.appendSQL(" BANK_NAME , EXG_STOCK , EXG_PRICE ,EXG_AMOUNT , EXG_LESS_AMOUNT, ");
		sqljob.appendSQL(" TOTAL_LESS_AMOUNT ");
		sqljob.appendSQL(" ) ");
		
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP , null , ");
		sqljob.appendSQL("A.issue_serial, A.debt_name, A.issue_amount, ");
		sqljob.appendSQL("C.bank_name, B.exg_stock," );
		sqljob.appendSQL("(select change_price from issue_exgprice_det where issue_id = a.id" );
		if( null != airc0901Form.getLimitDate() && !"".equals(airc0901Form.getLimitDate()) )
		{
			sqljob.appendSQL("and change_date <=? ");
			sqljob.addParameter(airc0901Form.getLimitDate());
		}
		sqljob.appendSQL("),B.exg_amount, B.exg_less_amount, B.total_less_amount ");
		sqljob.appendSQL("from issue_main A, Central_exchange_daily B, Bank_ref C ");
		sqljob.appendSQL("where A.id=B.issue_id ");
		sqljob.appendSQL("and C.id=B.bank_id ");
		sqljob.appendSQL("and A.debt_type='A' ");
		sqljob.appendSQL("and A.bond_kind='4' ");
		if( null != airc0901Form.getIssueSerial() && !"".equals(airc0901Form.getIssueSerial()) )
		{
			sqljob.appendSQL("and A.issue_serial=? ");
			sqljob.addParameter(airc0901Form.getIssueSerial());
		}
		if( null != airc0901Form.getLimitDate() && !"".equals(airc0901Form.getLimitDate()) )
		{
			sqljob.appendSQL("and B.term_date=? ");
			sqljob.addParameter(airc0901Form.getLimitDate());
		}
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
	}

}
