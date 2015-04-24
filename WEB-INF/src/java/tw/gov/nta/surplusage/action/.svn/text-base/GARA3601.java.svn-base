package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.StringUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.sql.NationDebitMain;
import tw.gov.nta.sql.NationRef;
import tw.gov.nta.sql.YearAmountRef;
import tw.gov.nta.surplusage.common.YearAmountManager;
import tw.gov.nta.system.common.DebitCodeManage;
import tw.gov.nta.system.common.NationDebitManager;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA3601 extends ExcelReportRemainAction
{
	private final static String TEMP_TABLE_NAME = "GARA36_RPT";

	protected SQLJob selectTemp(AccountQueryForm form){
		String accountYM = form.getAccountYear()+form.getMonth();
		String qryYear = form.getAccountYear();
		Date queryLastDate = DateUtil.getLastDateOfMonth(DateUtil.str2Date(accountYM + "01"));
		String strLastDate = DateUtil.date2Str(queryLastDate);
		//System.out.println("debtTypeS:"+debtAll);
		SQLJob sqljob = new SQLJob();
		//總預算公債01
		sqljob.appendSQL("select  '01' AS TYPE, ");
		//總預算公債-預算數
		sqljob.appendSQL("isNull((select sum( issue_amount) from Central_statistics_main where debt_type = 'A' and bound_code = '1' and  budget_code='1' and account_kind='2' and account_year<"+qryYear+"),0)/100000000 - ");
		sqljob.appendSQL("isNull((select  sum(pay_amount) from Central_statistics_main where debt_type = 'A' and bound_code = '1'  and  debt_code <> '35'  and  is_account<>'Y'  and  budget_code= '1' and account_kind='2' and account_year<"+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum( issue_amount) from Central_statistics_main where debt_type = 'A' and bound_code = '1' and  budget_code='1' and account_kind='1' and account_year="+qryYear+"),0)/100000000 - ");
		sqljob.appendSQL("isNull((select  sum(pay_amount) from Central_statistics_main where debt_type = 'A' and bound_code = '1'  and  debt_code <> '35'  and  is_account<>'Y'  and  budget_code= '1' and account_kind='1' and account_year="+qryYear+"),0)/100000000 as AA1,");
		//總預算公債-實際數
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=1) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as AA2 ");
			
		//特別預算公債(甲類)02
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '02' AS TYPE, ");
		//特別預算公債(甲類)-預算數
		sqljob.appendSQL("isNull((select sum( issue_amount) from Central_statistics_main where debt_type = 'A'  and bound_code = '1' and  budget_code = '2'   and account_kind='2' and account_year<"+qryYear+"),0)/100000000 - ");
		sqljob.appendSQL("isNull((select  sum(pay_amount) from Central_statistics_main where debt_type = 'A' and bound_code = '1'   and  debt_code <> '35'   and  budget_code= '2' and account_kind='2' and account_year<"+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum( issue_amount) from Central_statistics_main where debt_type = 'A'  and bound_code = '1' and  budget_code = '2'  and account_kind='1' and account_year="+qryYear+"),0)/100000000 - ");
		sqljob.appendSQL("isNull((select  sum(pay_amount) from Central_statistics_main where debt_type = 'A' and bound_code = '1'  and  debt_code <> '35'  and  budget_code= '2' and account_kind='1' and account_year="+qryYear+"),0)/100000000 as AA1,");
		//特別預算公債(甲類)-實際數
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2)  and (B.issue_date<='"+strLastDate+"') and (A.debt_code in (30,27,42,28,29,23,49,50,51,52)) )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as AA2 ");
		
		//債務基金公債03
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '03' AS TYPE, ");
		//債務基金公債-預算數
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type = 'A' and budget_code = '3' and account_kind='2' and account_year<"+qryYear+"),0)/100000000 - ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type = 'A' and budget_code = '3' and debt_code <> '35' and is_account<>'Y' and account_kind='2' and account_year<"+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type = 'A' and budget_code = '3' and account_kind='1' and account_year="+qryYear+"),0)/100000000 - ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type = 'A' and budget_code = '3' and debt_code <> '35' and is_account<>'Y' and account_kind='1' and account_year="+qryYear+"),0)/100000000 as AA1, ");
		//債務基金公債-實際數
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=3)  and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as AA2 ");
		
		//甲類公債合計04
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '04' AS TYPE, ");
		sqljob.appendSQL("0.0 as AA1, ");
		sqljob.appendSQL("0.0 as AA2 ");
		
		//總預算國內借款05
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '05' AS TYPE, ");
		//總預算國內借款-預算數
		sqljob.appendSQL("(case when 072<="+qryYear+" then 1982000000.0 else 0.0 end)/100000000 + ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '1' and account_kind='2' and account_year<"+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '1' and account_kind='2' and account_year<"+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum(audit_adjust_amount) from current_adjust_main where  account_year<"+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '1' and account_kind='1' and account_year="+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '1' and account_kind='1' and account_year="+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select budget_adjust_amount from current_adjust_main where  account_year="+qryYear+"),0)/100000000 as AA1, ");
		//總預算國內借款-實際數
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 1 ),0) - "); 
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 1),0))/100000000 as AA2 ");
		
		//總預算國外借款06
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '06' AS TYPE, ");
		sqljob.appendSQL("0.0 as AA1, ");
		sqljob.appendSQL("0.0 as AA2 ");
		
		//特別預算借款07
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '07' AS TYPE, ");
		//特別預算借款-預算數 debt_code not in 26,44
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '2' and bound_code<>'2' and debt_code not in (44,42) and account_kind='2' and account_year<"+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '2' and bound_code<>'2' and debt_code not in (44,42) and account_kind='2' and account_year<"+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '2' and bound_code<>'2' and debt_code not in (44,42) and account_kind='1' and account_year="+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '2' and bound_code<>'2' and debt_code not in (44,42) and account_kind='1' and account_year="+qryYear+"),0)/100000000 as AA1, ");
		//特別預算借款-實際數 debt_code in 30,29,23
		//modify by jack 20061205
		if(Integer.parseInt(strLastDate.substring(0,6))<Integer.parseInt("200610"))
		{
			sqljob.appendSQL("isNull(");
			sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id=B.id and A.issue_amount>0 and B.issue_date<='"+strLastDate+"' and B.debt_type='C' and B.bond_type=2 and A.budget_code=2 and A.debt_code in (30,49,50,51,52,27,28,29,23) ),0) - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B,issue_main C where A.debt_id=B.id and B.issue_id=C.id and A.capital_amount>0 and A.repay_date<='"+strLastDate+"' and C.debt_type='C' and C.bond_type=2 and B.budget_code=2 and B.debt_code in (30,27,28,29,23) ),0))+( isNull((select top 1 remain_amount from gara35_his where YM ='"+accountYM+"' and debt_code=42),0) )");
			sqljob.appendSQL(",0)/100000000 as AA2 ");
		}
		else
		{
			sqljob.appendSQL("isNull(");
			sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id=B.id and A.issue_amount>0 and B.issue_date<='"+strLastDate+"' and B.debt_type='C' and B.bond_type=2 and A.budget_code=2 and A.debt_code in (30,49,50,51,52,27,28,29,23) ),0) - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B,issue_main C where A.debt_id=B.id and B.issue_id=C.id and A.capital_amount>0 and A.repay_date<='"+strLastDate+"' and C.debt_type='C' and C.bond_type=2 and B.budget_code=2 and B.debt_code in (30,27,28,29,23) ),0))+(isNull((select sum( capital_amount - pay_amount ) from other_plan_debt where debt_code=42 and repay_date>='"+strLastDate+"'),0))");
			sqljob.appendSQL(",0)/100000000 as AA2 ");
		}

		/*
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code in (30,27,28,29,23,49,50,51,52) ),0) - "); 
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code in (30,27,28,29,23,49,50,51,52) ),0))/100000000 + ");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.debt_code = 42 ),0) -  ");
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2  and B.debt_code =42 ),0))/100000000 as AA2 ");
		*/

		//省債08
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '08' AS TYPE, ");
		//省債-預算數
		sqljob.appendSQL("(case when 089<="+qryYear+" then 904769000000.0 else 0.0 end)/100000000 + ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=35 and is_account ='N' and account_kind='2' and account_year<"+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=35 and is_account ='N' and account_kind='2' and account_year<"+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=35 and is_account ='N' and account_kind='1' and account_year="+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=35 and is_account ='N' and account_kind='1' and account_year="+qryYear+"),0)/100000000 as AA1, ");
		//省債-實際數
		//modify by jack 20061205
		if(Integer.parseInt(strLastDate.substring(0,6))<Integer.parseInt("200610"))
		{
			sqljob.appendSQL("isNull((select top 1 remain_amount from gara35_his where YM ='"+accountYM+"' and debt_code=35),0)/100000000 as AA2");
		}
		else
		{
			sqljob.appendSQL("isNull((select sum(isnull(capital_amount,0)-isnull(pay_amount,0))  from other_plan_debt where debt_code=35 and repay_date>='"+strLastDate+"'),0)/100000000 as AA2 ");
		}

		//sqljob.appendSQL("isNull((select sum(pay_amount) from other_plan_debt where debt_code=35 and pay_date between convert(datetime,'"+getQryDateByPatterm(null,qryYear+"0101")+"') and convert(datetime,'"+getQryDateByPatterm(null,strLastDate)+"')),0)/100000000 as AA2 ");
		//sqljob.appendSQL("isNull((select sum(capital_amount) from other_plan_debt where debt_code=35 and repay_date between convert(datetime,'"+getQryDateByPatterm(null,qryYear+"0101")+"') and convert(datetime,'"+getQryDateByPatterm(null,strLastDate)+"') ),0)/100000000 as AA2 ");
		//sqljob.appendSQL("0.0 as AA2 ");
		
		//糧食平準基金09
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '09' AS TYPE, ");
		//糧食平準基金-預算數
		sqljob.appendSQL("(case when 089<="+qryYear+" then 93976000000.0 else 0.0 end)/100000000 + ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=36 and is_account ='N' and account_kind='2' and account_year<"+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=36 and is_account ='N' and account_kind='2' and account_year<"+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=36 and is_account ='N' and account_kind='1' and account_year="+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=36 and is_account ='N' and account_kind='1' and account_year="+qryYear+"),0)/100000000 as AA1, ");
		//糧食平準基金-實際數
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=36 ),0) - "); 
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=36 ),0))/100000000 as AA2 ");
		
		//新生地開發10
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '10' AS TYPE, ");
		//新生地開發-預算數
		sqljob.appendSQL("(case when 094<="+qryYear+" then 450000000.0 else 0.0 end)/100000000 + ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=48 and is_account ='N' and account_kind='2' and account_year<"+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=48 and is_account ='N' and account_kind='2' and account_year<"+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=48 and is_account ='N' and account_kind='1' and account_year="+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '5' and debt_code=48 and is_account ='N' and account_kind='1' and account_year="+qryYear+"),0)/100000000 as AA1, ");;
		//新生地開發-實際數
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=0 ),0) - "); 
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=0 ),0))/100000000 as AA2 ");
		
		//債務基金11
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '11' AS TYPE, ");
		//債務基金-預算數
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '3'   and account_kind='2' and account_year<"+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '3' and account_kind='2' and account_year<"+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '3' and account_kind='1' and account_year="+qryYear+"),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type IN ('C','E') and budget_code = '3' and account_kind='1' and account_year="+qryYear+"),0)/100000000 as AA1, ");
		//債務基金-實際數
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 3 ),0) - "); 
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 3 ),0))/100000000 as AA2 ");
		
		//賒借合計12
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '12' AS TYPE, ");
		sqljob.appendSQL("0.0 as AA1, ");
		sqljob.appendSQL("0.0 as AA2 ");
		
		//非自償債務合計13
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '13' AS TYPE, ");
		sqljob.appendSQL("0.0 as AA1, ");
		sqljob.appendSQL("0.0 as AA2 ");
		
		//乙類公債未償餘額14
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '14' AS TYPE, ");
		//乙類公債未償餘額-預算數
		sqljob.appendSQL("isNull((select sum( issue_amount) from Central_statistics_main where debt_type = 'A'  and bound_code = '2' and  budget_code in ('2','1') and is_account ='N' and account_year<'091'  and account_kind='2' and account_year<"+qryYear+"),0)/100000000 - ");
		sqljob.appendSQL("isNull((select  sum(pay_amount) from Central_statistics_main where debt_type = 'A'  and bound_code = '2' and account_year<'091'  and  debt_code <> '35' and  is_account<>'Y' and account_kind='2' and account_year<"+qryYear+"),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum( issue_amount) from Central_statistics_main where debt_type = 'A'  and bound_code = '2' and  budget_code in ('2','1') and is_account ='N' and account_year<'091'  and account_kind='1' and account_year="+qryYear+"),0)/100000000 - ");
		sqljob.appendSQL("isNull((select  sum(pay_amount) from Central_statistics_main where debt_type = 'A'  and bound_code = '2' and account_year<'091'  and  debt_code <> '35' and  is_account<>'Y' and account_kind='1' and account_year="+qryYear+"),0)/100000000 as AA1, ");
		//乙類公債未償餘額-實際數
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 2) AND (A.issue_id=B.id) and (A.budget_code = 2) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as AA2 ");
		
		//乙類借款未償餘額15
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '15' AS TYPE, ");
		//乙類借款未償餘額-預算數
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type = 'C' and bound_code = '2'  and budget_code = '2'   and account_kind='2' and account_year<095),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type = 'C' and bound_code = '2'  and budget_code = '2'   and account_kind='2' and account_year<095),0)/100000000+ ");
		sqljob.appendSQL("isNull((select sum(issue_amount) from Central_statistics_main where debt_type = 'C' and bound_code = '2'  and budget_code = '2'    and account_kind='1' and account_year=095),0)/100000000- ");
		sqljob.appendSQL("isNull((select sum(pay_amount) from Central_statistics_main where debt_type = 'C' and bound_code = '2'  and budget_code = '2'   and account_kind='1' and account_year=095),0)/100000000 as AA1, ");
		//乙類借款未償餘額-實際數
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 1 and A.budget_code = 2),0) - "); 
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 1 and B.budget_code = 2),0))/100000000 as AA2 ");
		
		//自償性債務合計
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '16' AS TYPE,");
		sqljob.appendSQL("0.0 as AA1,");
		sqljob.appendSQL("0.0 as AA2 ");
		
		//債務未償餘額總計
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select  '17' AS TYPE,");
		sqljob.appendSQL("0.0 as AA1,");
		sqljob.appendSQL("0.0 as AA2 ");
		System.out.println("GARA3602-selectTemp:"+sqljob.toString());
		return sqljob;
	}
	
	//備註用
	public static SQLJob selRemark(AccountQueryForm form)
	{
		String accountYM = form.getAccountYear()+form.getMonth();
		Date queryLastDate = DateUtil.getLastDateOfMonth(DateUtil.str2Date(accountYM + "01"));
		String strLastDate = DateUtil.date2Str(queryLastDate);
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT ");
//		--國內借款重大交建
		sqljob.appendSQL("case when (isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '2006/9/30' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=27 ),0) - ");
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '2006/9/30' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=27 ),0))/100000000 <> 0 then '重大交通建設特別預算' else '' end as  T1,");
//		--國內借款九二一
		sqljob.appendSQL("case when (isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '2006/9/30' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=28 ),0) - ");
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '2006/9/30' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=28 ),0))/100000000 <> 0 then '九二一震災重建特別預算' else '' end as  T2,");
//		--國內借款基隆河整治
		sqljob.appendSQL("case when (isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '2006/9/30' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=23 ),0) - ");
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '2006/9/30' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=23 ),0))/100000000 <> 0 then '基隆河整治特別預算' else '' end as  T3,");
//		--國內借款sars
		sqljob.appendSQL("case when (isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '2006/9/30' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=29 ),0) - ");
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '2006/9/30' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=29 ),0))/100000000 <> 0 then 'SARS防治及紓困特別預算' else '' end as  T4,");
		//--國內借款新十大建設
		sqljob.appendSQL("case when (isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '2006/9/30' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code in (30,49,50,51,52) ),0) - ");
		sqljob.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '2006/9/30' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=30 ),0))/100000000 <> 0 then '擴大公共建設投資計畫特別預算' else '' end as  T5,");
		//--國內借款採購高性能戰機
		if(Integer.parseInt(strLastDate.substring(0,6))<Integer.parseInt("200610")){
			sqljob.appendSQL("case when (isNull((select top 1 remain_amount from gara35_his where YM ='"+accountYM+"' and debt_code=42),0))/100000000 <> 0 then '採購高性能戰機' else '' as T6");
		}else{
			sqljob.appendSQL("case when (isNull((select sum( capital_amount - pay_amount ) from other_plan_debt where debt_code=42 and repay_date>='2006/9/30'),0))/100000000 <> 0 then '' else '' end as T6");
		}
		
		System.out.println("GARA3602-selTmpSQL:"+sqljob.toString());
		return sqljob;
	}
	protected SQLJob insTemp(List list,String usrId)
	{
		SQLJob sqljob = new SQLJob();
		for(Iterator it=list.iterator();it.hasNext();)
		{
			Map map = (Map) it.next();
			if( !"X".equals( (String) map.get("type") ) )
			{
				sqljob.appendSQL( " INSERT INTO " + TEMP_TABLE_NAME );
				sqljob.appendSQL( " ( BUDGET_AMOUNT, REAL_AMOUNT, T1, T2, T3, " );
				sqljob.appendSQL( " T4, T5, T6, T7, TYPE, " );
				sqljob.appendSQL( " USRID, MOD_DATE, REMARK ) " );
				sqljob.appendSQL( " VALUES ( " );
				sqljob.appendSQL( String.valueOf( map.get("budget_amount")==null?"0":map.get("budget_amount") ) + "," );
				sqljob.appendSQL( String.valueOf( map.get("real_amount")==null?"0":map.get("real_amount") ) + "," );
				sqljob.appendSQL( String.valueOf( map.get("T1")==null?"0":map.get("T1") ) + "," );
				sqljob.appendSQL( String.valueOf( map.get("T2")==null?"0":map.get("T2") ) + "," );
				sqljob.appendSQL( String.valueOf( map.get("T3")==null?"0":map.get("T3") ) + "," );
				sqljob.appendSQL( String.valueOf( map.get("T4")==null?"0":map.get("T4") ) + "," );
				sqljob.appendSQL( String.valueOf( map.get("T5")==null?"0":map.get("T5") ) + "," );
				sqljob.appendSQL( String.valueOf( map.get("T6")==null?"0":map.get("T6") ) + "," );
				sqljob.appendSQL( String.valueOf( map.get("T7")==null?"0":map.get("T7") ) + "," );
				sqljob.appendSQL( "'" + (String) map.get("type") + "'," );
				sqljob.appendSQL( "'"+usrId+"', CURRENT_TIMESTAMP, '' " );
				sqljob.appendSQL( " ) " );
			}
		}
		System.out.println(sqljob);
		return sqljob;
	}
	protected static SQLJob selGara36data(String accountYear)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL( "SELECT data1 , data2 FROM gara36data" );
		sqljob.appendSQL( " WHERE YEAR = ?" );
		sqljob.addParameter(accountYear);
		System.out.println(sqljob);
		return sqljob;
	}
	protected SQLJob selGNP(int accountYear)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL( "SELECT ISNULL(GNP_AMOUNT,0) as GNP_AMOUNT  FROM NATION_DEBIT_MAIN" );
		sqljob.appendSQL( " WHERE NATION_CODE = 24" );
		sqljob.appendSQL( " AND ACCOUNT_YEAR = ?" );
		sqljob.addParameter(accountYear);
		System.out.println(sqljob);
		return sqljob;
	}
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );

		AccountQueryForm myForm = (AccountQueryForm) form;
		//String debtType = getDebitRef90(connection);
		List tempList = (List) run.query(selectTemp( myForm), new MapListHandler());
		Map tMap = null;
		Map dMap = new HashMap();
		List dataList = new ArrayList();
		//歲出
		BigDecimal yearAmount = new BigDecimal(0);
		//GNP
		BigDecimal GNPAmount = new BigDecimal(0);
		//前三年GNP
		BigDecimal perGNPAmount =new BigDecimal(0);
		//預算數
		BigDecimal budgetAmount = new BigDecimal(0);
		//實際數
		BigDecimal realAmount = new BigDecimal(0);
		//sumAmount[]={type04,type12,type13,type16,type17}
		BigDecimal[] sumAmountB = {new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)};
		BigDecimal[] sumAmountR = {new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)};
		//當年度GNP
		GNPAmount = (BigDecimal)((Map)((List) run.query(selGNP( Integer.parseInt(myForm.getAccountYear())), new MapListHandler())).get(0)).get("gnp_amount");
		//當年度歲出
		YearAmountRef dto = new YearAmountRef();
		dto.setAccountYear( myForm.getAccountYear() );
		dto.setBudgetCode(0);
		dto.setDebtCode(0);
		List<YearAmountRef> collection = new YearAmountManager().query(dto);
		for(Iterator it = collection.iterator();it.hasNext();){
			YearAmountRef pYearAmountRef = (YearAmountRef)it.next();
			yearAmount = yearAmount.add(pYearAmountRef.getBudgetAmount());
		}
		int sumIndex = 0;
		String type="";
		for (Iterator it1=tempList.iterator(); it1.hasNext();){
			tMap = (Map) it1.next();
			dMap = new HashMap();
			
//			yearAmount = this.getYearAmount(connection,myForm.getAccountYear(),new BigDecimal(100000000),"2");
//			GNPAmount = this.getGNP(connection,myForm.getAccountYear(),new BigDecimal(100000000));
			perGNPAmount = this.getPerGNP(connection,myForm.getAccountYear(),new BigDecimal(100000000));
			
			type = (String)tMap.get("TYPE");
			budgetAmount = (BigDecimal)tMap.get("AA1");
			realAmount = (BigDecimal)tMap.get("AA2");
			
			sumAmountB[sumIndex]=sumAmountB[sumIndex].add(budgetAmount);
			sumAmountR[sumIndex]=sumAmountR[sumIndex].add(realAmount);
			
			dMap.put("type",type);
			
			if (type.equals("04") || type.equals("12") || type.equals("16")){
				dMap.put("budget_amount",sumAmountB[sumIndex]);//預
				dMap.put("real_amount",sumAmountR[sumIndex]);//實
				sumIndex++;
			}else if(type.equals("13")){
				sumAmountB[sumIndex]=sumAmountB[0].add(sumAmountB[1]);
				sumAmountR[sumIndex]=sumAmountR[0].add(sumAmountR[1]);
				dMap.put("budget_amount",sumAmountB[sumIndex]);//預
				dMap.put("real_amount",sumAmountR[sumIndex]);//實
				sumIndex++;
			}else if(type.equals("17")){
				sumAmountB[sumIndex]=sumAmountB[2].add(sumAmountB[3]);
				sumAmountR[sumIndex]=sumAmountR[2].add(sumAmountR[3]);
				dMap.put("budget_amount",sumAmountB[sumIndex]);//預
				dMap.put("real_amount",sumAmountR[sumIndex]);//實
			}else{
				dMap.put("budget_amount",budgetAmount);//預
				dMap.put("real_amount",realAmount);//實
			}
			
			dMap.put("t1",this.divideCheck(((BigDecimal)dMap.get("real_amount")).setScale(2,4),(BigDecimal)dMap.get("budget_amount")));
			dMap.put("t2",this.divideCheck(((BigDecimal)dMap.get("budget_amount")).setScale(2,4),this.divideCheck(yearAmount,new BigDecimal(100000000)).setScale(2,4)));
			dMap.put("t3",this.divideCheck(((BigDecimal)dMap.get("real_amount")).setScale(2,4),this.divideCheck(yearAmount,new BigDecimal(100000000)).setScale(2,4)));
			dMap.put("t4",this.divideCheck(((BigDecimal)dMap.get("budget_amount")).setScale(2,4),this.divideCheck(GNPAmount,new BigDecimal(100000000)).setScale(2,4)));
			dMap.put("t5",this.divideCheck(((BigDecimal)dMap.get("real_amount")).setScale(2,4),this.divideCheck(GNPAmount,new BigDecimal(100000000)).setScale(2,4)));
			dMap.put("t6",this.divideCheck(((BigDecimal)dMap.get("budget_amount")).setScale(2,4),perGNPAmount));
			dMap.put("t7",this.divideCheck(((BigDecimal)dMap.get("real_amount")).setScale(2,BigDecimal.ROUND_HALF_UP),perGNPAmount));
			dataList.add(dMap);
		}
		
		//執行 insert
		//run.update(connection, insTemp( dataList, usrId ) );
		String remark1 = Integer.parseInt(myForm.getAccountYear()) + "年度GNP為"+new StringUtil().addThousandMark2(GNPAmount.divide(new BigDecimal(100000000),2,BigDecimal.ROUND_HALF_UP))+"億元" ;
		
		request.setAttribute("remark1",setRemark1(myForm.getAccountYear(),connection));
		request.setAttribute("remark2",setRemark2(myForm,connection,"1")+";"+remark1);
		request.setAttribute("remark3",setRemark3(myForm.getAccountYear()));
		request.setAttribute(TEMP_TABLE_NAME,dataList);
	}
	private static String getGara36Data(String accountYear , String key , Connection connection ) throws SQLException{
		SQLRunner run = new ConnectionSQLRunner(connection);
		List tempList = (List) run.query(selGara36data(accountYear), new MapListHandler());
		return (String) ((Map)tempList.get(0)).get("data"+key);
	}
	private String setRemark1(String accountYear,Connection connection) throws SQLException{
		return getGara36Data(accountYear,"1",connection);
	}
	public static String setRemark2(AccountQueryForm form,Connection connection,String key) throws SQLException{
		SQLRunner run = new ConnectionSQLRunner(connection);
		String accountYear = form.getAccountYear();
		String remark = "" ;
		String remark1 = "" ;
		if(key.equals("1")){
			Map remarkMap = (Map)((List) run.query(selRemark(form), new MapListHandler())).get(0);
			remark1 = "特別預算公債及借款(甲類)，含";
			for(int i = 1 ;i<=6 ;i++){
				if(!remarkMap.get("t"+String.valueOf(i)).equals("")){
					remark1 = remark1 + remarkMap.get("t"+String.valueOf(i));
					if( i != 6 && !remarkMap.get("t"+String.valueOf(i+1)).equals(""))
						remark1 = remark1 +"、";
					else
						remark1 = remark1 +"；";
				}
					
			}
		}
		YearAmountRef dto = new YearAmountRef();
		dto.setAccountYear( accountYear );
		dto.setBudgetCode(0);
		dto.setDebtCode(0);
		BigDecimal totalAmount = new BigDecimal(0);
		List<YearAmountRef> collection = new YearAmountManager().query(dto);
		for(Iterator it = collection.iterator();it.hasNext();){
			YearAmountRef pYearAmountRef = (YearAmountRef)it.next();
			totalAmount = totalAmount.add(pYearAmountRef.getBudgetAmount());
			if(!pYearAmountRef.getDebtCode().equals(24)){

			}	
			if(!remark.equals(""))
				remark = remark + "+";
			remark = remark + new DebitCodeManage().get(pYearAmountRef.getDebtCode()).getDebitName();
			remark = remark + new StringUtil().addThousandMark2(pYearAmountRef.getBudgetAmount().divide(new BigDecimal(100000000),2,BigDecimal.ROUND_HALF_UP))+"億元";
		}
		return remark1+Integer.parseInt(accountYear) + "年度歲出為"+new StringUtil().addThousandMark2(totalAmount.divide(new BigDecimal(100000000),2,BigDecimal.ROUND_HALF_UP))+"億元="+remark+((key.equals("1"))?getGara36Data(accountYear,"2",connection):"");
	}
	private String setRemark3(String accountYear){
		String remark = "";
		NationDebitMain dto = new NationDebitMain();
		Integer year = Integer.parseInt(accountYear);
		BigDecimal gnpAmount = new BigDecimal(0);
		for(int i = year - 3 ; i < year ;i ++){
			dto.setAccountYear(0 + String.valueOf(i));
			NationRef pNationRef = new NationRef();
			pNationRef.setId(24);
			dto.setNationCode(pNationRef);
			List list = new NationDebitManager().query(dto);
			for(Iterator it = list.iterator();it.hasNext();){
				NationDebitMain pNationDebitMain = (NationDebitMain)it.next();
				remark = remark + pNationDebitMain.getAccountYear() + "年度";
				remark = remark + new StringUtil().addThousandMark2(pNationDebitMain.getGnpAmount().divide(new BigDecimal(100000000),2,BigDecimal.ROUND_HALF_UP))+"億元";
				gnpAmount = gnpAmount.add(pNationDebitMain.getGnpAmount());
			}
			if(i < year-1)
				remark = remark + "，";
		}
		return remark+";前3年度GNP平均數為"+new StringUtil().addThousandMark2((gnpAmount.divide(new BigDecimal(3),0,BigDecimal.ROUND_HALF_UP)).divide(new BigDecimal(100000000),2,BigDecimal.ROUND_HALF_UP))+"億元";
	}
	private String getQryDateByPatterm(String patterm,String rocDate)
	{
		SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
		if( null!=patterm && "".equals( patterm ) )
			YYYY_MM_DD = new SimpleDateFormat(patterm);
		
		Date newDate = DateUtil.str2Date(rocDate);
		return YYYY_MM_DD.format(newDate);
	}
}
