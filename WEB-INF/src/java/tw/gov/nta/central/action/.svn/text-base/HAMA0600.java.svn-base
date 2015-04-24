package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.form.Hama0601Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class HAMA0600 extends DefaultAction {
	protected SQLJob delTemp(ActionForm form, String usrId) {
		Hama0601Form myForm = (Hama0601Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM HAMA06_RPT");
		sqljob.appendSQL("  WHERE TYEAR = '" + myForm.getQryYear() + "'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form, String usrId) {
		Hama0601Form myForm = (Hama0601Form) form;
		SQLJob sqljob = new SQLJob();
		//insert sql
		sqljob.appendSQL("INSERT INTO HAMA06_RPT ");
		sqljob.appendSQL(" ( UNIT_INFO_Name, TPERCENT, FINANCIAL ,TYEAR ) ");
		sqljob.appendSQL(" SELECT b.UNIT_NAME,a.TPERCENT,a.FINANCIAL , a.TYEAR  FROM  UNIT_PERCENT_DET_101 as a ");
		sqljob.appendSQL(" Left join Unit_info_main as b on a.UNIT_INFO_ID = b.ID ");
		sqljob.appendSQL("  WHERE a.TYEAR = '" + myForm.getQryYear() + "'");
		sqljob.appendSQL(" order by b.GROUPID ,b.UNIT_ID");
		System.out.println("HAMA06_RPT : " + sqljob.toString());
		return sqljob;
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		String usrId = this.getUserId(request);
		// ¨ú±oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		// °õ¦æ delete
		Hama0601Form myForm = (Hama0601Form) form;
		System.out.println(myForm.getQryYear());
		run.update(connection, delTemp(form, usrId));
		run.update(connection, insTemp(form, usrId));
	}
}
