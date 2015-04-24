/* AIRC1001.java 報表
 程式目的：AIRC10
 程式代號：AIRC10
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

import tw.gov.nta.debt.form.Airb1201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRB1201 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRB12_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Airb1201Form airb1201Form = (Airb1201Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO AIRB12_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, ISSUE_SERIAL, ");
		sqljob.appendSQL(" DEBT_NAME, ");
		sqljob.appendSQL(" ISSUE_AMOUNT, ");
		sqljob.appendSQL(" BANK_ID, ");
 		sqljob.appendSQL(" SEP_AMOUNT, CON_AMOUNT, NOSEP_AMOUNT ,SEP_LESS_AMOUNT , TOTAL_AMOUNT");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP , null , I.ISSUE_SERIAL,");
		sqljob.appendSQL(" I.DEBT_NAME,");
		sqljob.appendSQL(" I.ISSUE_AMOUNT, ");
		sqljob.appendSQL(" (SELECT top 1 BANK_NAME FROM BANK_REF WHERE BANK_CODE=Q.ACTNO ) AS BANK_ID, " );
		sqljob.appendSQL(" Q.AAMT AS SEP_AMOUNT, Q.BAMT AS CON_AMOUNT, Q.CAMT AS NOSEP_AMOUNT , Q.DAMT AS SEP_LESS_AMOUNT , (Q.CAMT + Q.DAMT ) AS  TOTAL_AMOUNT ");
		sqljob.appendSQL(" FROM ISSUE_MAIN I,TRBSTR3 Q");
		sqljob.appendSQL("WHERE I.BOND_KIND='4' AND I.ID = Q.ISSUE_ID ");
		if( null != airb1201Form.getIssueSerial() && !"".equals(airb1201Form.getIssueSerial()) )
		{
			sqljob.appendSQL("AND I.ISSUE_SERIAL=?");
			sqljob.addParameter(airb1201Form.getIssueSerial());
		}
		System.out.println(airb1201Form.getLimitDate());
		if( null != airb1201Form.getLimitDate() && !"".equals(airb1201Form.getLimitDate()) )
		{
			sqljob.appendSQL("AND YEAR(Q.DATE) - 1911 = ? ");
			sqljob.addParameter(airb1201Form.getLimitDate().toString().substring(0,3));
			sqljob.appendSQL("AND MONTH(Q.DATE)= ? ");
			sqljob.addParameter(airb1201Form.getLimitDate().toString().substring(3,5));
		}
		sqljob.appendSQL("ORDER BY M.BANK_ID");
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
