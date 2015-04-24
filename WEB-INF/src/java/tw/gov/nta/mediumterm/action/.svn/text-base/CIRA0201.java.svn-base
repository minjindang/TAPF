/**
 * @author Andrew Sung
 * @create 2006/3/31
 */

package tw.gov.nta.mediumterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra1501Form;
import tw.gov.nta.mediumterm.form.Cira0201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CIRA0201 extends DefaultAction
{
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CARA02_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob insTemp(ActionForm form,String usrId,Integer issueId,Integer baseUnit){
		Apra1501Form myForm = (Apra1501Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO CARA02_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USERID, ISSUE_NAME,ISSUE_DATE, DUE_DATE, ");
		sqljob.appendSQL(" ISSUE_AMOUNT, UNIT, BANK_NAME, COMPARE_AMOUNT, COMPARE_RATE, ");
		sqljob.appendSQL(" ACCRUE, ACCRUE_AMOUNT");
		sqljob.appendSQL(" ) ");
		
		sqljob.appendSQL("SELECT '"+usrId+"' ,A.ISSUE_NAME,A.ISSUE_DATE,A.DUE_DATE,");
		sqljob.appendSQL("A.ISSUE_AMOUNT, "+baseUnit+", B.COMPARE_AMOUNT, B.COMPARE_RATE");
		sqljob.appendSQL("B.ACCRUE, B.ISSUE_AMOUNT");
		sqljob.appendSQL("FROM ISSUE_MAIN A,DEBT_MAIN B");
		sqljob.appendSQL("WHERE A.ID=B.ISSUE_ID AND A.ID="+issueId);
		System.out.println(sqljob.toString());
		return sqljob;
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Cira0201Form myForm = (Cira0201Form)form;
		//取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId,myForm.getIssueId(),myForm.getBaseUnit()));

	}

}
