/* GARA4001.java 報表
 程式目的：GARA4001
 程式代號：GARA4001
 程式日期：0950626
 程式作者：Avery Yeh
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara4001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA4001 extends ExcelReportRemainAction 
{
	//主SQL撈出 Account_year年度,debt_Y 列入債限,debt_N 不列入債限
	protected SQLJob SQL1(Gara4001Form myForm,BigDecimal unit)
	{
		SQLJob sqljob = new SQLJob();
		/*
		sqljob.appendSQL("select (a.account_year) as accountYear,");
		sqljob.appendSQL("isNull(sum((case when a.is_debt='Y' and a.account_kind='4' then issue_amount else 0 end)),0) as debtY,");
		sqljob.appendSQL("isNull(sum((case when a.is_debt='N' and a.account_kind='4' then issue_amount else 0 end)),0) as debtN ");
		sqljob.appendSQL("from central_statistics_main a,nation_debit_main b ");
		sqljob.appendSQL("where a.account_year = b.account_year ");
		
		sqljob.appendSQL("and b.nation_code= 24 ");
		sqljob.appendSQL("group by a.account_year ");
		*/
		sqljob.appendSQL("select (account_year) as accountYear,");
//		sqljob.appendSQL("isNull(sum(case when ( is_debt='Y' and account_type='Y' )  then isnull(issue_amount,0)  else 0 end ),0)/"+unit+" as debtY,");
//		sqljob.appendSQL("isNull(sum(case when ( is_debt='N' and account_type='Y' )  then isnull(issue_amount,0)  else 0 end ),0)/"+unit+" as debtN ");
		sqljob.appendSQL("sum(case when ( account_year<091 and is_debt='Y' and bound_code in ('1','2')  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("when ( account_year>=091 and is_debt='Y' and bound_code = '1'  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+"  as debtY ,");
		//當年度舉借不列入債限	
		sqljob.appendSQL("sum(case when ( account_year<091 and is_debt='N' and bound_code in ('1','2')  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("when ( account_year>=091 and is_debt='N' and bound_code = '1'  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+"  as debtN ");
		sqljob.appendSQL("from central_statistics_main ");
		sqljob.appendSQL("where 1=1 ");
		if (!"".equals(myForm.getAccountSYear()) && !"".equals(myForm.getAccountEYear())){
			sqljob.appendSQL("and account_year between ? and ? ");
			sqljob.addParameter(myForm.getAccountSYear());
			sqljob.addParameter(myForm.getAccountEYear());
		}
		sqljob.appendSQL("group by account_year ");
		sqljob.appendSQL("order by account_year ");
		System.out.println("GARA40-SQL1:"+sqljob.toString());
		return sqljob;
	}

	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, 
			Connection connection) throws Exception 
	{
		Gara4001Form myForm = (Gara4001Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA40_RPT",usrId));
		//執行 insert
		Map tMap = null;
		List queryList1 = (List) run.query(SQL1(myForm,unit), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("budgetAmount",this.getYearAmount(connection,(String)tMap.get("accountYear"),unit,"2"));
			tMap.put("debtTotal",this.divideCheck((BigDecimal)tMap.get("debtY"),(BigDecimal)tMap.get("budgetAmount")));
			run.update(connection,insTemp("GARA40_RPT",tMap));
		}
	}
	
}
