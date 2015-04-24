/* CPRB0301.java 報表
 程式目的：CPRB03
 程式代號：CPRB03
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

import tw.gov.nta.debt.form.Cprb0301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CPRB0301 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CPRB03_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Cprb0301Form cprb0301Form = (Cprb0301Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO CPRB03_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, Repay_date,Issue_amount,Last_amount,Effective_rate,Interest_days,manage_Interest_amount,Interest_amount,Capital_sum,Interest_sum )");
		sqljob.appendSQL(" SELECT '"+usrId+"', CURRENT_TIMESTAMP , null " +
				",  B.repay_date , B.capital_amount , (A.issue_amount - (Select sum(capital_amount) from payment_main where issue_id = A.id AND repay_date <= B.repay_date)) , " +
				"   (Select debt_rate from debt_rate_det where delete_mark='N' AND debt_id = C.id AND effective_date <= B.repay_date AND suspend_date >= B.repay_date) , " +
				" B.Interest_days , B.manage_Interest_amount , B.Interest_amount , (Select sum(capital_amount) from payment_main where issue_id = A.id AND repay_date <= B.repay_date ) , " +
				" (Select sum(interest_amount) from payment_main where issue_id = A.id AND repay_date <= B.repay_date) ");
		

		sqljob.appendSQL(" FROM issue_main A, payment_main B, debt_main C");
		sqljob.appendSQL(" WHERE B.issue_id = A.id AND C.issue_id = A.id AND B.issue_id = A.id ") ;	

		if( null != cprb0301Form.getIssueSerial() && !"".equals(cprb0301Form.getIssueSerial()))
		{    
			sqljob.appendSQL("AND A.issue_serial =? ");
			sqljob.addParameter(cprb0301Form.getIssueSerial());
		
		}
		if( null != cprb0301Form.getStartDate() )
		{    
			sqljob.appendSQL("AND B.repay_date >=? ");
			sqljob.addParameter(cprb0301Form.getStartDate());
		
		}
		if( null != cprb0301Form.getEndDate())
		{    
			sqljob.appendSQL("AND B.repay_date <=? ");
			sqljob.addParameter(cprb0301Form.getEndDate());
		
		}
		sqljob.appendSQL(" order by B.repay_date ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId));
	}


}
