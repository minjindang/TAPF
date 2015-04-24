/* AIRC0701.java 報表
 程式目的：AIRC07
 程式代號：AIRC07
 程式日期：0950308
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

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRC0701 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRC07_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Airc0701Form airc0701Form = (Airc0701Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO AIRC07_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, ISSUE_SERIAL, ");
		sqljob.appendSQL(" DEBT_NAME, ");
		sqljob.appendSQL(" ISSUE_AMOUNT, ");
		sqljob.appendSQL(" BANK_NAME , EXG_STOCK , EXG_AMOUNT , EXG_LESS_AMOUNT, ");
		sqljob.appendSQL(" TOTAL_LESS_AMOUNT ");
		sqljob.appendSQL(" ) ");
		
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP , null , ");
		sqljob.appendSQL("A.issue_serial, A.debt_name, A.issue_amount, ");
		sqljob.appendSQL("C.bank_name, B.exg_stock, B.exg_amount, B.exg_less_amount, B.total_less_amount ");
		sqljob.appendSQL("from issue_main A, Central_exchange_month B, Bank_ref C ");
		sqljob.appendSQL("where A.id=B.issue_id ");
		sqljob.appendSQL("and C.id=B.bank_id ");
		sqljob.appendSQL("and A.debt_type='A' ");
		sqljob.appendSQL("and A.bond_kind='4' ");
		if( null != airc0701Form.getIssueSerial() && !"".equals(airc0701Form.getIssueSerial()) )
		{
			sqljob.appendSQL("and A.issue_serial=? ");
			sqljob.addParameter(airc0701Form.getIssueSerial());
		}
		if( null != airc0701Form.getLimitDate() && !"".equals(airc0701Form.getLimitDate()) )
		{
			sqljob.appendSQL("and B.term_ym=? ");
			sqljob.addParameter(airc0701Form.getLimitDate());
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
