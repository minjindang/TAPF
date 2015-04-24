
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;


public class EARD0402 extends DefaultAction{
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARD04_RPT01 ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO EARD04_RPT01 (USRID,MOD_DATE,remark,");
		//sqljob.appendSQL("issue_serial,issue_amount,diversity_amount,real_amount) ");
		sqljob.appendSQL("issue_serial,issue_amount,diversity_amount,real_amount) ");
		sqljob.appendSQL("select ?,?,null,");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
	//	sqljob.appendSQL("issue_serial");
		sqljob.appendSQL("debt_name+'('+debit_ref.debit_name+')' as debt_name");
		sqljob.appendSQL(",debt_main.issue_amount,");
		sqljob.appendSQL("sum(diversity_amount) as diversity_amount,");
		sqljob.appendSQL("sum(debt_main.real_amount) as real_amount");
		sqljob.appendSQL("from issue_main,debt_main,debit_ref");
		sqljob.appendSQL("where debt_main.debt_code = debit_ref.id ");
		sqljob.appendSQL("and issue_main.id = debt_main.issue_id");
		sqljob.appendSQL("and debt_main.id=?");
		sqljob.appendSQL("group by issue_serial,debt_main.issue_amount,debt_name,debit_ref.debit_name");
		sqljob.addParameter(myForm.getDebtId());
		System.out.print(sqljob.toString());
		return sqljob;
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
//		取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId));
		request.setAttribute("file","EARD04A");
	}
}