package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra2401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA2401 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "APRA24_RPT";

	protected SQLJob selTemp(ActionForm form,String usrId){
		Apra2401Form myForm = (Apra2401Form) form;
		SQLJob sqljob = new SQLJob();
		
//		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME );
//		sqljob.appendSQL(" ( MONEY_TYPE , DEBT_NAME, ISSUE_DATE, AVERAGE_RATE, ISSUE_INTERVAL, ISSUE_AMOUNT, ");
//		sqljob.appendSQL(" CAPITAL_AMOUNT, CAPITAL_NOPAY, SH_INTEREST_AMOUNT, INTEREST_AMOUNT, INTEREST_NOPAY, ");
//		sqljob.appendSQL(" USRID, MOD_DATE, REMARK ");
//		sqljob.appendSQL(" ) ");

		sqljob.appendSQL("SELECT '新台幣' as MONEY_TYPE, I.DEBT_NAME as DEBT_NAME");
		sqljob.appendSQL(",I.ISSUE_DATE as ISSUE_DATE");
		sqljob.appendSQL(",I.AVERAGE_RATE as AVERAGE_RATE");
		sqljob.appendSQL(",I.ISSUE_INTERVAL as ISSUE_INTERVAL");
		sqljob.appendSQL(",isnull(SUM(D.capital_amount),cast(0 as int)) as ISSUE_AMOUNT");
		sqljob.appendSQL(",(select isnull(SUM(CAPITAL_AMOUNT),cast(0 as int)) from debt_plan_det p where p.issue_id=I.id and p.repay_date<=?)AS CAPITAL_AMOUNT ");
		sqljob.addParameter(myForm.getIssueDate());
		sqljob.appendSQL(",isnull(SUM(D.capital_amount),cast(0 as int)) - (select isnull(SUM(CAPITAL_AMOUNT),cast(0 as int)) from debt_plan_det p where p.issue_id=I.id and p.repay_date<=?) as CAPITAL_NOPAY ");
		sqljob.addParameter(myForm.getIssueDate());
		sqljob.appendSQL(",SUM(D.Interest_amount)AS SH_INTEREST_AMOUNT");
		sqljob.appendSQL(",(select isnull(SUM(interest_AMOUNT),cast(0 as int)) from debt_plan_det p where p.issue_id=I.id and p.repay_date<=?)AS INTEREST_AMOUNT");
		sqljob.addParameter(myForm.getIssueDate());
		sqljob.appendSQL(",isnull(SUM(D.Interest_amount),cast(0 as int)) - (select isnull(SUM(interest_AMOUNT),cast(0 as int)) from debt_plan_det p where p.issue_id=I.id and p.repay_date<=?) AS INTEREST_NOPAY ");
		sqljob.addParameter(myForm.getIssueDate());
		sqljob.appendSQL(",'"+usrId+"' as USRID");
		sqljob.appendSQL(",'"+new Timestamp( new Date().getTime() )+"' as MOD_DATE");
		sqljob.appendSQL(",'' as REMARK");
		sqljob.appendSQL(",(select issue_date from issue_main where id = I.source_issue_id) as SOURCE_ISSUE_DATE");
		sqljob.appendSQL(" FROM ISSUE_MAIN I,DEBT_PLAN_DET D ");
		sqljob.appendSQL(" WHERE I.ID=D.ISSUE_ID");
		sqljob.appendSQL("   AND I.DEBT_TYPE='A'");
		if(null != myForm.getIssueEDate())
		{	
			sqljob.appendSQL("   AND I.ISSUE_DATE <=?");
			sqljob.addParameter( myForm.getIssueEDate() );
		}	
		if(null != myForm.getIssueSDate())
		{
			sqljob.appendSQL("   AND I.ISSUE_DATE >=?");
			sqljob.addParameter( myForm.getIssueSDate() );
		}	
		sqljob.appendSQL(" and d.delete_mark <> 'Y'");
		sqljob.appendSQL(" GROUP BY I.DEBT_NAME,I.BOND_TYPE,I.ISSUE_DATE,I.AVERAGE_RATE,I.ISSUE_INTERVAL,I.ISSUE_AMOUNT, I.id , source_issue_id");
		sqljob.appendSQL(" ORDER BY I.ISSUE_DATE");

		System.out.println(sqljob.toString());
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		//執行 insert
		List list = (List)run.query(selTemp(form,usrId),new MapListHandler());
		String[] debtName = new String[]{"四十八年短期公債甲類債票","四十八年短期公債乙類債票","四十九年短期公債甲類第一期債票","四十九年短期公債乙類債票",
				"四十九年短期公債甲類第二期債票","五十五年度愛國公債第一期債票","五十五年度愛國公債第二期債票","五十六年度愛國公債","五十七年度愛國公債","高速公路一期工程第三期債票"};
		BigDecimal[] interestAmount = new BigDecimal[]{new BigDecimal("99279495"),new BigDecimal("9000000"),new BigDecimal("47451240"),new BigDecimal("9000000"),
				new BigDecimal("49105395"),new BigDecimal("88334622"),new BigDecimal("59902022"),new BigDecimal("145979940"),new BigDecimal("176669524"),new BigDecimal("293200000")};
		for(Iterator it = list.iterator(); it.hasNext();){
			Map map = (Map)it.next();
			System.out.println(map);
			for(int i = 0 ; i < debtName.length ; i++){
				if(map.get("debt_name").equals(debtName[i])){
					map.put("sh_interest_amount", interestAmount[i]);
					map.put("interest_amount", interestAmount[i]);
					break;
				}
			}
			run.update( connection,this.insTemp(TEMP_TABLE_NAME, map));
		}
	}
}
