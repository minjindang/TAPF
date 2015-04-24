/* AIRB1001.java 報表
 程式目的：AIRB10
 程式代號：AIRB10
程式日期：0950316
 程式作者：icefire
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airb1001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRB1001 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRB10_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("static-access")
	protected SQLJob insTemp(ActionForm form,String usrId){
		Airb1001Form AIRB1001form = (Airb1001Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO AIRB10_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK,BUDGET_CODE , BOND_TYPE ,");
		sqljob.appendSQL(" ISSUE_MONTH_AMOUNT,ISSUE_YEAR_AMOUNT,");
		sqljob.appendSQL(" ISSUE_TOTAL_AMOUNT,NOPAY_CAPITAL_AMOUNT,");
		sqljob.appendSQL(" NOPAY_INTEREST_AMOUNT , NOPAY_TOTAL_AMOUNT ");
		sqljob.appendSQL(" ) ");
		
		sqljob.appendSQL(" select '" + usrId + "' , CURRENT_TIMESTAMP , NULL , (select budget_name from budget_ref where id=b.id), case when i.bond_type = '1' then '甲類' when i.bond_type = '2' then '乙類' end , ");
		sqljob.appendSQL(" (select sum(x.issue_amount) from debt_main x, issue_main y where x.issue_id=y.id and x.budget_code=b.id and y.debt_type='A' and y.bond_type=i.bond_type and Cast(Year(y.issue_date) as Varchar(10)) + Cast(Month(y.issue_date) as Varchar(10)) = ? ), ");
		sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRB1001form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRB1001form.getLimitDate())+ 1 ));
		sqljob.appendSQL(" (select sum(x.issue_amount) from debt_main x, issue_main y where x.issue_id=y.id and x.budget_code=b.id and y.debt_type='A' and y.bond_type=i.bond_type and Cast(Year(y.issue_date) as Varchar(10)) =?  and  y.issue_date <= ?), ");
		//sqljob.appendSQL(" (select sum(x.issue_amount) from debt_main x, issue_main y where x.issue_id=y.id and x.budget_code=b.id and y.debt_type='A' and y.bond_type=i.bond_type and y.issue_date <= ? ), ");
		sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRB1001form.getLimitDate())));
		sqljob.addParameter(AIRB1001form.getLimitDate());
		sqljob.appendSQL(" (select sum(x.issue_amount) from debt_main x, issue_main y where x.issue_id=y.id and x.budget_code=b.id and y.debt_type='A' and y.bond_type=i.bond_type and y.issue_date <= ? ), ");
		sqljob.addParameter(AIRB1001form.getLimitDate());
		sqljob.appendSQL("(SELECT  SUM(CAPITAL_AMOUNT) FROM debt_plan_det WHERE (delete_mark = 'N') AND (DEBT_ID IN");
		sqljob.appendSQL("(SELECT D.id FROM issue_main A, debt_main D WHERE D.issue_id = A.id AND A.debt_type = 'A' AND A.bond_type=i.bond_type and D.budget_code = b.id AND A.issue_date <= ?)) AND (REPAY_DATE > ?))," );
		sqljob.addParameter(AIRB1001form.getLimitDate());
		sqljob.addParameter(AIRB1001form.getLimitDate());
		sqljob.appendSQL("(SELECT  SUM(interest_amount) FROM debt_plan_det WHERE (delete_mark = 'N') AND (DEBT_ID IN");
		sqljob.appendSQL("(SELECT D.id FROM issue_main A, debt_main D WHERE D.issue_id = A.id AND A.debt_type = 'A' AND A.bond_type=i.bond_type and D.budget_code = b.id AND A.issue_date <= ?)) AND (REPAY_DATE > ?))," );
		sqljob.addParameter(AIRB1001form.getLimitDate());
		sqljob.addParameter(AIRB1001form.getLimitDate());
		sqljob.appendSQL("(SELECT  SUM(CAPITAL_AMOUNT) FROM debt_plan_det WHERE (delete_mark = 'N') AND (DEBT_ID IN");
		sqljob.appendSQL("(SELECT D.id FROM issue_main A, debt_main D WHERE D.issue_id = A.id AND A.debt_type = 'A' AND A.bond_type=i.bond_type and D.budget_code = b.id AND A.issue_date <= ?)) AND (REPAY_DATE > ?))+" );
		sqljob.addParameter(AIRB1001form.getLimitDate());
		sqljob.addParameter(AIRB1001form.getLimitDate());
		sqljob.appendSQL("(SELECT  SUM(interest_amount) FROM debt_plan_det WHERE (delete_mark = 'N') AND (DEBT_ID IN");
		sqljob.appendSQL("(SELECT D.id FROM issue_main A, debt_main D WHERE D.issue_id = A.id AND A.debt_type = 'A' AND A.bond_type=i.bond_type and D.budget_code = b.id AND A.issue_date <= ?)) AND (REPAY_DATE > ?))" );
		sqljob.addParameter(AIRB1001form.getLimitDate());
		sqljob.addParameter(AIRB1001form.getLimitDate());
		
//		sqljob.appendSQL(" (select sum(z.capital_amount)-sum(p.capital_amount) from debt_main x, issue_main y, debt_plan_det z, payment_main p ");
//		sqljob.appendSQL(" where x.issue_id=y.id and x.budget_code=b.id and y.debt_type='A' and y.bond_type=i.bond_type and z.debt_id=x.id and p.debt_id=x.id and Cast(Year(y.issue_date) as Varchar(10)) + Cast(Month(y.issue_date) as Varchar(10)) <= ?  and Cast(Year(p.repay_date) as Varchar(10)) + Cast(Month(p.repay_date) as Varchar(10)) <= ? ), ");
//		sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRB1001form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRB1001form.getLimitDate())+ 1 ));
//		sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRB1001form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRB1001form.getLimitDate())+ 1 ));
//		sqljob.appendSQL(" (select sum(z.origin_interest_amount)-sum(p.interest_amount) from debt_main x, issue_main y, debt_plan_det z, payment_main p ");
//		sqljob.appendSQL(" where x.issue_id=y.id and x.budget_code=b.id and y.debt_type='A' and y.bond_type=i.bond_type and z.debt_id=x.id and p.debt_id=x.id and Cast(Year(y.issue_date) as Varchar(10)) + Cast(Month(y.issue_date) as Varchar(10)) <= ?  and Cast(Year(p.repay_date) as Varchar(10)) + Cast(Month(p.repay_date) as Varchar(10)) <= ? ), ");
//		sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRB1001form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRB1001form.getLimitDate())+ 1 ));
//		sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRB1001form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRB1001form.getLimitDate())+ 1 ));
//		sqljob.appendSQL(" (select sum(z.capital_amount)-sum(p.capital_amount) from debt_main x, issue_main y, debt_plan_det z, payment_main p ");
//		sqljob.appendSQL(" where x.issue_id=y.id and x.budget_code=b.id and y.debt_type='A' and y.bond_type=i.bond_type and z.debt_id=x.id and p.debt_id=x.id and Cast(Year(y.issue_date) as Varchar(10)) + Cast(Month(y.issue_date) as Varchar(10)) <= ?  and Cast(Year(p.repay_date) as Varchar(10)) + Cast(Month(p.repay_date) as Varchar(10)) <= ? ) +  ");
//		sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRB1001form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRB1001form.getLimitDate())+ 1 ));
//		sqljob.addParameter(Integer.toString(DateUtil. getYear(AIRB1001form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRB1001form.getLimitDate())+ 1 ));
//		sqljob.appendSQL(" (select sum(z.origin_interest_amount)-sum(p.interest_amount) from debt_main x, issue_main y, debt_plan_det z, payment_main p ");
//		sqljob.appendSQL(" where x.issue_id=y.id and x.budget_code=b.id and y.debt_type='A' and y.bond_type=i.bond_type and z.debt_id=x.id and p.debt_id=x.id and Cast(Year(y.issue_date) as Varchar(10)) + Cast(Month(y.issue_date) as Varchar(10)) <= ?  and Cast(Year(p.repay_date) as Varchar(10)) + Cast(Month(p.repay_date) as Varchar(10)) <= ? ) ");
//		sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRB1001form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRB1001form.getLimitDate())+ 1 ));
//		sqljob.addParameter(Integer.toString(DateUtil.getYear(AIRB1001form.getLimitDate())) + Integer.toString(DateUtil.getMonth(AIRB1001form.getLimitDate())+ 1 ));
		
		sqljob.appendSQL(" from issue_main i, budget_ref b ");
		sqljob.appendSQL(" where i.debt_type='A' ");
		sqljob.appendSQL(" and i.bond_type in(1,2) ");
		if(null != AIRB1001form.getBudgetCode() && 0 != AIRB1001form.getBudgetCode())
		{
			sqljob.appendSQL(" and b.id= ? ");
			sqljob.addParameter(AIRB1001form.getBudgetCode());
		}	
		sqljob.appendSQL(" group by b.id, i.bond_type ");
		sqljob.appendSQL(" order by b.id, i.bond_type ");
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
