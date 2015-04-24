package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.form.Rama0101Form;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
import gov.dnt.tame.util.DateUtil;

public class RAMA0103 extends DefaultAction{
	
	protected SQLJob delTemp(ActionForm form){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM RAMA01_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	 protected SQLJob insTemp(ActionForm form){
		 Rama0101Form myForm =(Rama0101Form)form;

		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO RAMA01_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" Issue_ID,Plan_ID, Repay_Date, Debt_Name,");
		sqljob.appendSQL(" Capital_Serial,Interest_Serial, Capital_Amount, Interest_Amount,");
		sqljob.appendSQL(" Repay_Handle,Repay_Number, Account_Date, Account_Number,");
		sqljob.appendSQL(" Fund_Number,Secretary_Date");
		sqljob.appendSQL(" ) ");	
		sqljob.appendSQL(" Select ");
		sqljob.appendSQL(" Issue_ID,Plan_ID, Repay_Date, Debt_Name,");
		sqljob.appendSQL(" Capital_Serial,Interest_Serial, Capital_Amount, Interest_Amount,");
		sqljob.appendSQL(" Repay_Handle,Repay_Number, Account_Date, Account_Number,");
		sqljob.appendSQL(" Fund_Number,Secretary_Date");
		sqljob.appendSQL(" FROM National_debt_DueDate_Main");
		sqljob.appendSQL(" WHERE 1 =1");
		if(!"".equals(myForm.getRepayDateS()) && null != myForm.getRepayDateS() && !"".equals(myForm.getRepayDateE()) && null != myForm.getRepayDateE())
		{
			sqljob.appendSQL( " and Repay_Date BETWEEN '" + DateUtil.ROCDate2Date(myForm.getRepayDateS()) + "'");
			sqljob.appendSQL( " and '" + DateUtil.ROCDate2Date(myForm.getRepayDateE()) + "'");
		}
		System.out.println("RAMA01_RPT SQL : " + sqljob.toString());
		return sqljob;
	}
	
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(form));
		run.update(connection,insTemp(form));
	}
}
