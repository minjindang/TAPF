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

import tw.gov.nta.surplusage.form.Gara3201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA3201 extends ExcelReportRemainAction {

	protected SQLJob SQL1(Gara3201Form myForm,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		//算出各年度的歲出總額
		sqljob.appendSQL("select Account_year,");
		//總預算-預算
		sqljob.appendSQL("sum(case when budget_code=1 then isnull(Budget_uamount,0) else 0 end)/"+unit+" as t1,");
		//總預算-決算
		sqljob.appendSQL("sum(case when budget_code=1 then isnull(Audit_uamount,0) else 0 end)/"+unit+" as t2,");
		sqljob.appendSQL("0/"+unit+" as t3,");
		//北二高
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=26 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=26 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t4,");
		//重大交通
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=27 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=27 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t5,");
		//戰機
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=42 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=42 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t6,");
		//國軍老舊眷村改建
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=38 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=38 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t7,");
		//立法院遷建案
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=44 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=44 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t8,");
		//口蹄疫危機處理
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=43 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=43 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t9,");
		//三商銀
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=40 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=40 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t10,");
		//戰士授田憑據
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=41 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=41 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t11,");
		//加強國防準備
		sqljob.appendSQL("0/"+unit+" as t12,");
		//九二一=決算數未排限
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=28 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=28 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t13,");
		//基隆河=決算數未排限
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=23 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=23 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t14,");
		//sars=決算數未排限
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=29 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=29 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t15,");
		//擴大公共建設投資計畫
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=30 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=30 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t16,");
		//水患及石門
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code in (34,45) and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code in (34,45) and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t17,");
		//省債
		sqljob.appendSQL("sum(case when budget_code=5 and debt_code=35 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=5 and debt_code=35 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t18,");
		sqljob.appendSQL("sum(case when (budget_code =1 or (budget_code in (2,5) and debt_code in (23,26,27,28,29,30,34,35,38,40,41,42,43,44,45))) then isnull(Budget_uamount,0) else 0 end)/"+unit+" as t19,");
		sqljob.appendSQL("sum(case when (budget_code =1 or (budget_code in (2,5) and debt_code in (23,26,27,28,29,30,34,35,38,40,41,42,43,44,45))) then isnull(Audit_uamount,0) else 0 end)/"+unit+" as t20 ");
		sqljob.appendSQL("from Year_amount_ref ");
		sqljob.appendSQL("where data_type = '1' ");
		if (!"".equals(myForm.getIssueSDate()) && !"".equals(myForm.getIssueEDate())){
			sqljob.appendSQL("and account_year between ? and ? ");
			sqljob.addParameter(myForm.getIssueSDate());
			sqljob.addParameter(myForm.getIssueEDate());
		}
		sqljob.appendSQL("and account_year <= '090' ");
		sqljob.appendSQL("group by  Account_year ");
		sqljob.appendSQL("union ");
		
		sqljob.appendSQL("select Account_year,");
		//總預算-預算
		sqljob.appendSQL("sum(case when budget_code=1 then isnull(Budget_uamount,0) else 0 end)/"+unit+" as t1,");
		//總預算-決算
		sqljob.appendSQL("sum(case when budget_code=1 then isnull(Audit_uamount,0) else 0 end)/"+unit+" as t2,");
		sqljob.appendSQL("0/"+unit+" as t3,");
		//北二高
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=26 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=26 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t4,");
		//重大交通
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=27 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=27 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t5,");
		//戰機
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=42 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=42 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t6,");
		//國軍老舊眷村改建
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=38 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=38 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t7,");
		//立法院遷建案
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=44 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=44 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t8,");
		//口蹄疫危機處理
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=43 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=43 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t9,");
		//三商銀
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=40 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=40 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t10,");
		//戰士授田憑據
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=41 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=41 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t11,");
		//加強國防準備
		sqljob.appendSQL("0/"+unit+" as t12,");
		//九二一=決算數未排限
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=28 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=28 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t13,");
		//基隆河=決算數未排限
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=23 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=23 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t14,");
		//sars=決算數未排限
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=29 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=29 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t15,");
		//擴大公共建設投資計畫
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code=30 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code=30 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t16,");
		//水患及石門
		sqljob.appendSQL("sum(case when budget_code=2 and debt_code in (34,45) and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=2 and debt_code in (34,45) and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t17,");
		//省債
		sqljob.appendSQL("sum(case when budget_code=5 and debt_code=35 and Audit_YN='Y' then isnull(Audit_uamount,0) ");
		sqljob.appendSQL("when budget_code=5 and debt_code=35 and Budget_YN='Y' then isnull(Budget_uamount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as t18,");
		sqljob.appendSQL("sum(case when (budget_code =1 or (budget_code in (2,5) and debt_code in (23,26,27,28,29,30,34,35,38,40,41,42,43,44,45))) then isnull(Budget_uamount,0) else 0 end)/"+unit+" as t19,");
		sqljob.appendSQL("sum(case when (budget_code =1 or (budget_code in (2,5) and debt_code in (23,26,27,28,29,30,34,35,38,40,41,42,43,44,45))) then isnull(Audit_uamount,0) else 0 end)/"+unit+" as t20 ");
		sqljob.appendSQL("from Year_amount_ref ");
		sqljob.appendSQL("where data_type = '2' ");
		if (!"".equals(myForm.getIssueSDate()) && !"".equals(myForm.getIssueEDate())){
			sqljob.appendSQL("and account_year between ? and ? ");
			sqljob.addParameter(myForm.getIssueSDate());
			sqljob.addParameter(myForm.getIssueEDate());
		}
		sqljob.appendSQL("and account_year > '090' ");
		sqljob.appendSQL("group by Account_year ");
		sqljob.appendSQL("order by Account_year ");
		System.out.println("GARA3201-SQL1:"+sqljob.toString());
		return sqljob;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception 
	{
		Gara3201Form myForm = (Gara3201Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA32_RPT",usrId));
		//執行 insert
		List queryList1 = (List) run.query(SQL1(myForm,unit), new MapListHandler());
		Map tMap = null;
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			run.update(connection,insTemp("GARA32_RPT",tMap));
		}

	}
}
