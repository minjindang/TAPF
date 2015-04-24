/* APRA201.java 報表
 程式目的：APRA02
 程式代號：APRA02
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

import tw.gov.nta.debt.form.Apra0201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA0201 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM APRA02_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Apra0201Form apra0201form = (Apra0201Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO APRA02_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, BUDGET_CODE, ");
		sqljob.appendSQL(" CAPITAL_AMOUNT, INTEREST_AMOUNT, FEE_AMOUNT");
		sqljob.appendSQL(" ) ");	
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP , null , ");
		sqljob.appendSQL(" (SELECT BUDGET_NAME FROM BUDGET_REF WHERE BUDGET_REF.ID=D.BUDGET_CODE) AS BUDGET_CODE ,");
		sqljob.appendSQL(" SUM(P.CAPITAL_AMOUNT) AS CAPITAL_AMOUNT , SUM(P.INTEREST_AMOUNT) AS INTEREST_AMOUNT ," );
		sqljob.appendSQL(" SUM(P.CHARGE_AMOUNT)AS CHARGE_AMOUNT ");
		sqljob.appendSQL(" FROM ISSUE_MAIN I, DEBT_MAIN D,DEBT_PLAN_DET P");
		sqljob.appendSQL(" WHERE I.ID=D.ISSUE_ID AND D.ID=P.DEBT_ID AND I.DEBT_TYPE='A' ");

		if( null != apra0201form.getRepaySdate())
		{
			sqljob.appendSQL("AND P.REPAY_DATE>=? ");
			sqljob.addParameter(apra0201form.getRepaySdate());
		}

		if( null != apra0201form.getRepayEdate())
		{
			sqljob.appendSQL("AND P.REPAY_DATE<=? ");
			sqljob.addParameter(apra0201form.getRepayEdate());
		}
		if( null != apra0201form.getBudgetCode() && !"".equals(apra0201form.getBudgetCode()) )
		{
			sqljob.appendSQL("AND D.BUDGET_CODE=? ");
			sqljob.addParameter(apra0201form.getBudgetCode());
		}
		sqljob.appendSQL("GROUP BY D.BUDGET_CODE");
		sqljob.appendSQL("ORDER BY D.BUDGET_CODE");
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
