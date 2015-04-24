/* AIRB0801.java 報表
 程式目的：AIRB08
 程式代號：AIRB08
 程式日期：0950316
 程式作者：icefire
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airb0801Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import gov.dnt.tame.common.DefaultAction;

public class AIRB0801 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRB08_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId,String kind){
		Airb0801Form AIRB0801form = (Airb0801Form) form;
		kind = AIRB0801form.getKind();
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO AIRB08_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, ACCOUNT_YEAR, BUDGET_CODE,");
		sqljob.appendSQL(" DEBT_NAME, CAPITAL_SERIAL, DUE_DATE, PAY_CAPITAL_AMOUNT");
		sqljob.appendSQL(" ) ");	
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP, null, M.ACCOUNT_YEAR, (SELECT BUDGET_NAME FROM BUDGET_REF WHERE ID=M.BUDGET_CODE),");
		sqljob.appendSQL(" M.DEBT_NAME, P.CAPITAL_SERIAL, DATEADD(day,-1,P.REPAY_DATE), SUM(P.CAPITAL_AMOUNT) AS X1 ");
		sqljob.appendSQL(" FROM ISSUE_MAIN M, DEBT_PLAN_DET P");
		sqljob.appendSQL(" WHERE M.ID=P.ISSUE_ID AND DEBT_TYPE='A' AND P.CAPITAL_SERIAL >= 0 AND P.CAPITAL_AMOUNT > 0 "); 
		
		if( null != AIRB0801form.getRepaydate())
		{
			int a1=Integer.parseInt(AIRB0801form.getRepaydate())*10000+19110101;
			int a2=Integer.parseInt(AIRB0801form.getRepaydate())*10000+19111231;
			String tmp1=String.valueOf(a1);
			String tmp2=String.valueOf(a2);
			sqljob.appendSQL("AND P.REPAY_DATE BETWEEN '"+tmp1+"' AND '"+tmp2+"' ");
		}
		if( 0 != AIRB0801form.getBudgetCode())
		{
			sqljob.appendSQL("AND M.BUDGET_CODE=? ");
			sqljob.addParameter(AIRB0801form.getBudgetCode());
		}
		if( 0 != AIRB0801form.getDebtCode())
		{
			sqljob.appendSQL("AND M.DEBT_CODE=? ");
			sqljob.addParameter(AIRB0801form.getDebtCode());
		}
		if("Y".equals(kind))
			sqljob.appendSQL("AND M.BOND_SELL_STATUS = 'Y' ");
		else if ("N".equals(kind))
			sqljob.appendSQL("AND M.BOND_KIND = '4' ");
		sqljob.appendSQL(" GROUP BY M.ACCOUNT_YEAR , M.BUDGET_CODE,M.DEBT_NAME, P.CAPITAL_SERIAL, P.REPAY_DATE");
		//提前買回
		sqljob.appendSQL("union ");
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP, null, M.ACCOUNT_YEAR, ");
		sqljob.appendSQL("(SELECT BUDGET_NAME FROM BUDGET_REF WHERE ID=D.BUDGET_CODE), ");
		sqljob.appendSQL("M.DEBT_NAME, P.CAPITAL_SERIAL, DATEADD(day,-1,P.REPAY_DATE), ");
		sqljob.appendSQL("SUM(P.CAPITAL_AMOUNT) AS X1 ");
		sqljob.appendSQL("FROM ISSUE_MAIN M, payment_main P, debt_main D ");
		sqljob.appendSQL("WHERE M.ID=P.ISSUE_ID ");
		sqljob.appendSQL("AND DEBT_TYPE='A' ");
		sqljob.appendSQL("AND P.DEBT_ID = D.ID ");
		sqljob.appendSQL("AND P.CAPITAL_SERIAL >= 0 ");
		sqljob.appendSQL("AND P.CAPITAL_AMOUNT > 0 ");
		sqljob.appendSQL("AND P.REPAY_DATE <> P.PLAN_REPAY_DATE ");
		sqljob.appendSQL("AND 'Y' <> (select d.delete_mark from debt_plan_det d where d.id = plan_id) ");
		
		if( null != AIRB0801form.getRepaydate())
		{
			int a1=Integer.parseInt(AIRB0801form.getRepaydate())*10000+19110101;
			int a2=Integer.parseInt(AIRB0801form.getRepaydate())*10000+19111231;
			String tmp1=String.valueOf(a1);
			String tmp2=String.valueOf(a2);
			sqljob.appendSQL("AND P.REPAY_DATE BETWEEN '"+tmp1+"' AND '"+tmp2+"' ");
		}
		if( 0 != AIRB0801form.getBudgetCode())
		{
			sqljob.appendSQL("AND D.BUDGET_CODE=? ");
			sqljob.addParameter(AIRB0801form.getBudgetCode());
		}
		if( 0 != AIRB0801form.getDebtCode())
		{
			sqljob.appendSQL("AND D.DEBT_CODE=? ");
			sqljob.addParameter(AIRB0801form.getDebtCode());
		}
		if("Y".equals(kind))
			sqljob.appendSQL("AND M.BOND_SELL_STATUS = 'Y' ");
		else if ("N".equals(kind))
			sqljob.appendSQL("AND M.BOND_KIND = '4' ");
		sqljob.appendSQL("GROUP BY M.ACCOUNT_YEAR , D.BUDGET_CODE,M.DEBT_NAME, P.CAPITAL_SERIAL, P.REPAY_DATE ");
		sqljob.appendSQL("ORDER BY 8 ");
		
		System.out.println(sqljob.toString());
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得公債類別
		String kind = (String)request.getParameter("kind");
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId,kind));
	}


}
