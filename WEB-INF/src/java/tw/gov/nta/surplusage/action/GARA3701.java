package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA3701 extends ExcelReportRemainAction
{
	private final static String TEMP_TABLE_NAME = "GARA37_RPT";

	protected SQLJob SQL1(String year,String month)
	{
		String firstDay = String.valueOf(Integer.parseInt(year)+1911)+"/01/01";
		String lastDay = DateUtil.date2Str(DateUtil.str2Date(DateUtil.getLastDateOfMonth(year,month)),"yyyy/MM/dd");
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select '1' flag,'"+year+"'+'年度公債及借款預算數' as debit_name,");
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='1' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0)/100000000 as T1,");//預算甲類
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='2' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0)/100000000 as T2,");//預算乙類
		sqljob.appendSQL("(isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='1' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0) +");
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='2' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0))/100000000 as T3,");//預算類小計
		//抓原始檔
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"'  and  ((a.debt_type in ('A','E')  and a.bond_type = '1')or (a.debt_type in ('C')  and a.bond_type = '2')) and d.budget_code = '1')/100000000,0) as T4_1 ,");//已發行甲類
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"'  and  ((a.debt_type in ('A','E')  and a.bond_type = '2')or (a.debt_type in ('C')  and a.bond_type = '1')) and d.budget_code = '1')/100000000,0) as T4_2 ,");//已發行乙類
		sqljob.appendSQL("0 as T5_1,");
		sqljob.appendSQL("0 as T5_2,");
		sqljob.appendSQL("0 as T6_1,");
		sqljob.appendSQL("0 as T6_2,");
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='1' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0)/100000000 -");
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"'  and  ((a.debt_type in ('A','E')  and a.bond_type = '1')or (a.debt_type in ('C')  and a.bond_type = '2')) and d.budget_code = '1')/100000000,0) as T7_1,");
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='2' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0)/100000000 -");
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"'  and  ((a.debt_type in ('A','E')  and a.bond_type = '2')or (a.debt_type in ('C')  and a.bond_type = '1')) and d.budget_code = '1')/100000000,0) as T7_2,");
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='1' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0)/100000000 +");
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='2' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0)/100000000 -");
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"'  and  ((a.debt_type in ('A','E')  and a.bond_type = '1')or (a.debt_type in ('C')  and a.bond_type = '2')) and d.budget_code = '1')/100000000,0) -");
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"'  and  ((a.debt_type in ('A','E')  and a.bond_type = '2')or (a.debt_type in ('C')  and a.bond_type = '2')) and d.budget_code = '2')/100000000,0) as T7_3");
		sqljob.appendSQL("from central_statistics_main b ");
		sqljob.appendSQL("where b.account_year='"+year+"'");
		sqljob.appendSQL("and b.budget_code='1' ");
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select '2' flag,'"+year+"'+'年度公債及借款追加預算數',");
		sqljob.appendSQL("0 as T1,");//預算甲類          
		sqljob.appendSQL("0 as T2,");//預算乙類
		sqljob.appendSQL("0 as T3,");//預算類小計
		sqljob.appendSQL("0 as T4_1,");//已發行甲類
		sqljob.appendSQL("0 as T4_2,");//已發行乙類
		sqljob.appendSQL("0 as T5_1,0 as T5_2,0 as T6_1,0 as T6_2,");
		sqljob.appendSQL("0 as T7_1,");
		sqljob.appendSQL("0 as T7_2,");
		sqljob.appendSQL("0 as T7_3 ");
		sqljob.appendSQL("from issue_main a,Year_amount_ref b ");
		sqljob.appendSQL("where a.account_year='"+year+"'");
		sqljob.appendSQL("and month(a.issue_date) <= "+Integer.parseInt(month)+" ");
		sqljob.appendSQL("and a.account_year=b.account_year ");
		sqljob.appendSQL("and a.budget_code='1' ");
		sqljob.appendSQL("and a.budget_code=b.budget_code ");
		sqljob.appendSQL("and a.debt_code=b.debt_code ");
		sqljob.appendSQL("group by  a.budget_code");
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select '3' flag,a.account_year+'年度公債及借款保留數',");
		//sqljob.appendSQL("isNull(min(keep_amount),0)/100000000 as T1, ");//預算甲類
		sqljob.appendSQL("isNull( ( a.odd_keep_Bamount1 + a.odd_keep_Uamount1 + a.odd_keep_Bamount2 + a.odd_keep_Uamount2 ) ,0)/100000000 as T1, ");//預算甲類
		sqljob.appendSQL("0 as T2,");//預算乙類
		sqljob.appendSQL("isNull( ( a.odd_keep_Bamount1 + a.odd_keep_Uamount1 + a.odd_keep_Bamount2 + a.odd_keep_Uamount2 ) ,0)/100000000 as T3,");//預算類小計
		//sqljob.appendSQL("isNull(min(keep_amount),0)/100000000 as T3,");//預算類小計
		sqljob.appendSQL("0 as T4_1,");//已發行甲類
		sqljob.appendSQL("0 as T4_2,");//已發行乙類
		sqljob.appendSQL("0 as T5_1,");
		sqljob.appendSQL("0 as T5_2,");
		sqljob.appendSQL("0 as T6_1,");
		sqljob.appendSQL("0 as T6_2,"); 
		sqljob.appendSQL("isNull( ( a.odd_keep_Bamount1 + a.odd_keep_Uamount1 + a.odd_keep_Bamount2 + a.odd_keep_Uamount2 ) ,0)/100000000 as T7_1,");
		//sqljob.appendSQL("isNull(min(keep_amount),0)/100000000 as T7_1,");
		sqljob.appendSQL("0 as T7_2,");
		sqljob.appendSQL("isNull( ( a.odd_keep_Bamount1 + a.odd_keep_Uamount1 + a.odd_keep_Bamount2 + a.odd_keep_Uamount2 ) ,0)/100000000 as T7_3");
		//sqljob.appendSQL("isNull(min(keep_amount),0)/100000000 as T7_3 ");
		sqljob.appendSQL("from user_statistics_main a left outer join user_statistics_det b on  a.id = b.statistics_id ");
		sqljob.appendSQL("where a.account_year<='"+year+"' ");
		sqljob.appendSQL("and b.keep_amount >0");
		sqljob.appendSQL("and a.budget_code='1' ");
		//sqljob.appendSQL("group by a.account_year");
		sqljob.appendSQL("group by a.account_year, a.odd_keep_Bamount1, a.odd_keep_Uamount1, a.odd_keep_Bamount2, a.odd_keep_Uamount2");
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select '4' flag,(select debit_name from debit_ref where id=b.debt_code) as debit_name,");
		sqljob.appendSQL("isNull(sum(case when b.bound_code='1' and b.account_year = '"+year+"' then b.budget_bamount1+b.budget_bamount2 else 0 end),0)/100000000+isNull( ( b.odd_keep_Bamount1 + b.odd_keep_Bamount2 + b.odd_keep_Uamount1 + b.odd_keep_Uamount2 ) ,0)/100000000 as T1,");//預算甲類 
		//sqljob.appendSQL("isNull(sum(case when b.bound_code='1' and b.account_year = '"+year+"' then b.budget_bamount1+b.budget_bamount2 else 0 end),0)/100000000+isNull( min(keep_amount),0)/100000000 as T1,");//預算甲類 
		sqljob.appendSQL("isNull(sum(case when b.bound_code='2' and b.account_year <='091' and b.account_year = '"+year+"' then b.budget_uamount1+b.budget_uamount2 else 0 end),0)/100000000 as T2, ");//預算乙類
		sqljob.appendSQL("isNull(sum(case when b.bound_code='1' and b.account_year = '"+year+"' then b.budget_bamount1+b.budget_bamount2 else 0 end),0)/100000000+isNull( ( b.odd_keep_Bamount1 + b.odd_keep_Bamount2 + b.odd_keep_Uamount1 + b.odd_keep_Uamount2 ),0)/100000000 +");
		//sqljob.appendSQL("isNull(sum(case when b.bound_code='1' and b.account_year = '"+year+"' then b.budget_bamount1+b.budget_bamount2 else 0 end),0)/100000000+isNull( min(keep_amount),0)/100000000 +");
		sqljob.appendSQL("isNull(sum(case when b.bound_code='2' and b.account_year <='091' and b.account_year = '"+year+"' then b.budget_uamount1+b.budget_uamount2 else 0 end),0)/100000000 as T3, ");//預算小計
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"' and b.debt_code = d.debt_code and  ((a.debt_type in ('A','E')  and a.bond_type = '1')or (a.debt_type in ('C')  and a.bond_type = '2')) and d.budget_code = '2')/100000000,0) as T4_1,");//已發行甲類
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"' and b.debt_code = d.debt_code and  ((a.debt_type in ('A','E')  and a.bond_type = '2')or (a.debt_type in ('C')  and a.bond_type = '1')) and d.budget_code = '2')/100000000,0) as T4_2,");//已發行乙類
		sqljob.appendSQL("0 as T5_1,");
		sqljob.appendSQL("0 as T5_2,");
		sqljob.appendSQL("0 as T6_1,");
		sqljob.appendSQL("0 as T6_2,");
		sqljob.appendSQL("isNull(sum(case when b.bound_code='1' and b.account_year = '"+year+"' then b.budget_bamount1+b.budget_bamount2 else 0 end),0)/100000000+isNull( ( b.odd_keep_Bamount1 + b.odd_keep_Bamount2 + b.odd_keep_Uamount1 + b.odd_keep_Uamount2 ),0)/100000000 -");
		//sqljob.appendSQL("isNull(sum(case when b.bound_code='1' and b.account_year = '"+year+"' then b.budget_bamount1+b.budget_bamount2 else 0 end),0)/100000000+isNull( min(keep_amount),0)/100000000 -");
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"' and b.debt_code = d.debt_code and  ((a.debt_type in ('A','E')  and a.bond_type = '1')or (a.debt_type in ('C')  and a.bond_type = '2')) and d.budget_code = '2')/100000000,0)  as T7_1, ");//未執行數甲類
		sqljob.appendSQL("isNull(sum(case when b.bound_code='2' and b.account_year <='091' and b.account_year = '"+year+"' then b.budget_uamount1+b.budget_uamount2 else 0 end),0)/100000000 -");
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"' and b.debt_code = d.debt_code and  ((a.debt_type in ('A','E')  and a.bond_type = '2')or (a.debt_type in ('C')  and a.bond_type = '1')) and d.budget_code = '2')/100000000,0)  as T7_2, ");//未執行數乙類
		sqljob.appendSQL("isNull(sum(case when b.bound_code='1' and b.account_year = '"+year+"' then b.budget_bamount1+b.budget_bamount2 else 0 end),0)/100000000+isNull( ( b.odd_keep_Bamount1 + b.odd_keep_Bamount2 + b.odd_keep_Uamount1 + b.odd_keep_Uamount2 ),0)/100000000 +");
		//sqljob.appendSQL("isNull(sum(case when b.bound_code='1' and b.account_year = '"+year+"' then b.budget_bamount1+b.budget_bamount2 else 0 end),0)/100000000+isNull( min(keep_amount),0)/100000000 +");
		sqljob.appendSQL("isNull(sum(case when b.bound_code='2' and b.account_year <='091' and b.account_year ='"+year+"' then b.budget_uamount1+b.budget_uamount2 else 0 end),0)/100000000 -");
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"' and b.debt_code = d.debt_code and  ((a.debt_type in ('A','E')  and a.bond_type = '1')or (a.debt_type in ('C')  and a.bond_type = '2')) and d.budget_code = '2')/100000000,0) -");
		sqljob.appendSQL("isNull(( select  sum(d.issue_amount)  from issue_main a, debt_main d where a.id = d.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"' and b.debt_code = d.debt_code and  ((a.debt_type in ('A','E')  and a.bond_type = '2')or (a.debt_type in ('C')  and a.bond_type = '1')) and d.budget_code = '2')/100000000,0)  as T7_3 ");//未執行數合計
		sqljob.appendSQL("from user_statistics_main b left outer join user_statistics_det c on  b.id = c.statistics_id");
		sqljob.appendSQL("where b.budget_code=2");
		//sqljob.appendSQL("group by b.debt_code");
		sqljob.appendSQL("group by b.debt_code, b.odd_keep_Bamount1, b.odd_keep_Bamount2, b.odd_keep_Uamount1, b.odd_keep_Uamount2");
		sqljob.appendSQL("having isNull(sum(case when b.bound_code='1' and b.account_year = '"+year+"' then b.budget_bamount1+b.budget_uamount1+b.budget_bamount2+b.budget_uamount2 else 0 end),0)/100000000");
		sqljob.appendSQL("+isNull( min(keep_amount),0)/100000000  >0");
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select '5' flag,'三、債務基金' as debit_name,");
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='1' and account_kind='1' then b.issue_amount else 0 end),0)/100000000 as T1, ");//預算甲類         
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='2' and account_kind='1'  then b.issue_amount else 0 end),0)/100000000 as T2,");//預算乙類
		sqljob.appendSQL("(isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='1' and account_kind='1'  then b.issue_amount else 0 end),0) + ");
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='2' and account_kind='1'  then b.issue_amount else 0 end),0))/100000000 as T3,");//預算類小計
		//抓原始檔
		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"' ");
		sqljob.appendSQL("and (( a.debt_type in ('A','E') and a.bond_type = '1') or ( a.debt_type in ('C') and a.bond_type = '2')) and b.budget_code = '3' )/100000000,0) as T4_1 ,");//已發行甲類
		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"'");
		sqljob.appendSQL("and (( a.debt_type in ('A','E') and a.bond_type = '2') or ( a.debt_type in ('C') and a.bond_type = '1')) and b.budget_code = '3')/100000000,0) as T4_2,");//已發行乙類
		sqljob.appendSQL("0 as T5_1,");
		sqljob.appendSQL("0 as T5_2,");
		sqljob.appendSQL("0 as T6_1,");
		sqljob.appendSQL("0 as T6_2,"); 
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='1' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"' ");
		sqljob.appendSQL("and (( a.debt_type in ('A','E') and a.bond_type = '1') or ( a.debt_type in ('C') and a.bond_type = '2')) and b.budget_code = '3' )/100000000,0) as T7_1,");
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='2' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"'");
		sqljob.appendSQL("and (( a.debt_type in ('A','E') and a.bond_type = '2') or ( a.debt_type in ('C') and a.bond_type = '1')) and b.budget_code = '3')/100000000,0) as T7_2,");
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='1' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000+");
		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='2' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"' ");
		sqljob.appendSQL("and (( a.debt_type in ('A','E') and a.bond_type = '1') or ( a.debt_type in ('C') and a.bond_type = '2')) and b.budget_code = '3' )/100000000,0) -");
		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between  '"+firstDay+"' and  '"+lastDay+"'");
		sqljob.appendSQL("and (( a.debt_type in ('A','E') and a.bond_type = '2') or ( a.debt_type in ('C') and a.bond_type = '1')) and b.budget_code = '3')/100000000,0) as T7_3 ");
		sqljob.appendSQL("from central_statistics_main b  ");
		sqljob.appendSQL("where b.account_year='"+year+"'");
		sqljob.appendSQL("and b.budget_code=3 ");
		sqljob.appendSQL("group by b.debt_code ");
		sqljob.appendSQL("order by 1 ");
//		sqljob.appendSQL("select '1' flag,條件年度+'年度公債及借款預算數' as debit_name,");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='1' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0)/100000000 as T1,");//預算甲類          
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='2' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0)/100000000 as T2,");//預算乙類
//		sqljob.appendSQL("(isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='1' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0) +");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and b.bound_code='2' and b.account_kind='1' and b.is_account='N' then b.issue_amount else 0 end),0))/100000000 as T3,");//預算類小計
//		//抓原始檔
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '1' and a.bond_type = '1')/100000000,0) as T4_1 ,");//已發行甲類
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '1' and a.bond_type = '2')/100000000,0) as T4_2,");//已發行乙類
//		sqljob.appendSQL("0 as T5_1,0 as T5_2,0 as T6_1,0 as T6_2,");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='1' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '1' and a.bond_type = '1')/100000000,0) as T7_1,");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='2' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '1' and a.bond_type = '2')/100000000,0) as T7_2,");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='1' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000+");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='2' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '1' and a.bond_type = '2')/100000000 -");
//		sqljob.appendSQL("( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '1' and a.bond_type = '2')/100000000,0) as T7_3 ");
//		sqljob.appendSQL("from central_statistics_main b ");
//		sqljob.appendSQL("where b.account_year='"+year+"' ");
//		sqljob.appendSQL("and b.budget_code='1' ");
//		sqljob.appendSQL("union ");
//		sqljob.appendSQL("select '2' flag,'"+year+"'+'年度公債及借款追加預算數',");
//		sqljob.appendSQL("0 as T1,");//預算甲類          
//		sqljob.appendSQL("0 as T2,");//預算乙類
//		sqljob.appendSQL("0 as T3,");//預算類小計
//		sqljob.appendSQL("0 as T4_1,");//已發行甲類
//		sqljob.appendSQL("0 as T4_2,");//已發行乙類
//		sqljob.appendSQL("0 as T5_1,0 as T5_2,0 as T6_1,0 as T6_2,");
//		sqljob.appendSQL("0 as T7_1,");
//		sqljob.appendSQL("0 as T7_2,");
//		sqljob.appendSQL("0 as T7_3 ");
//		sqljob.appendSQL("from issue_main a,Year_amount_ref b ");
//		sqljob.appendSQL("where a.account_year='"+year+"' ");
//		sqljob.appendSQL("and month(a.issue_date) <= "+Integer.parseInt(month)+" ");
//		sqljob.appendSQL("and a.account_year=b.account_year ");
//		sqljob.appendSQL("and a.budget_code='1' ");
//		sqljob.appendSQL("and a.budget_code=b.budget_code ");
//		sqljob.appendSQL("and a.debt_code=b.debt_code ");
//		sqljob.appendSQL("union ");
//		sqljob.appendSQL("select '3' flag,'"+year+"'+'年度公債及借款保留數',");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='1' and account_kind='3' and is_account='N' then b.issue_amount else 0 end),0)/100000000 as T1,");//預算甲類          
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='2' and account_kind='3' and is_account='N' then b.issue_amount else 0 end),0)/100000000 as T2,");//預算乙類
//		sqljob.appendSQL("(isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='1' and account_kind='3' and is_account='N' then b.issue_amount else 0 end),0) +"); 
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='2' and account_kind='3' and is_account='N' then b.issue_amount else 0 end),0))/100000000 as T3,");//預算類小計
//		sqljob.appendSQL("0 as T4_1,");//已發行甲類
//		sqljob.appendSQL("0 as T4_2,");//已發行乙類
//		sqljob.appendSQL("0 as T5_1,0 as T5_2,0 as T6_1,0 as T6_2,"); 
//		sqljob.appendSQL("(isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='1' and account_kind='3' and is_account='N' then b.issue_amount else 0 end),0) ");
//		sqljob.appendSQL(")/100000000 as T7_1,");
//		sqljob.appendSQL("(isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='2' and account_kind='3' and is_account='N' then b.issue_amount else 0 end),0) ");
//		sqljob.appendSQL(")/100000000 as T7_2,");
//		sqljob.appendSQL("(isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='1' and account_kind='3' and is_account='N' then b.issue_amount else 0 end),0) +"); 
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=1 and bound_code='2' and account_kind='3' and is_account='N' then b.issue_amount else 0 end),0) ");
//		sqljob.appendSQL(")/100000000 as T7_3 ");
//		sqljob.appendSQL("from central_statistics_main b ");
//		sqljob.appendSQL("where b.account_year<='"+year+"' ");
//		sqljob.appendSQL("and b.budget_code='1' ");
//		sqljob.appendSQL("union ");
//		sqljob.appendSQL("select '4' flag,(select debit_name from debit_ref where id=b.debt_code) as debit_name,");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=2 and bound_code='1' and account_kind='1' then b.issue_amount else 0 end),0)/100000000 as T1,");//預算甲類          
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=2 and bound_code='2' and account_kind='1'  then b.issue_amount else 0 end),0)/100000000 as T2,");//預算乙類
//		sqljob.appendSQL("(isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=2 and bound_code='1' and account_kind='1'  then b.issue_amount else 0 end),0) + ");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=2 and bound_code='2' and account_kind='1'  then b.issue_amount else 0 end),0))/100000000 as T3,");//預算類小計
//		//抓原始檔
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '2' and a.bond_type = '1')/100000000,0) as T4_1 ,");//已發行甲類
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '2' and a.bond_type = '2')/100000000,0) as T4_2,");//已發行乙類
//		sqljob.appendSQL("0 as T5_1,0 as T5_2,0 as T6_1,0 as T6_2,");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=2 and bound_code='1' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '2' and a.bond_type = '1')/100000000,0) as T7_1,");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=2 and bound_code='2' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '2' and a.bond_type = '2')/100000000,0) as T7_2,");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=2 and bound_code='1' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000 +");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=2 and bound_code='2' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '2' and a.bond_type = '2')/100000000 -");
//		sqljob.appendSQL("( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '2' and a.bond_type = '2')/100000000,0) as T7_3 ");
//		sqljob.appendSQL("from central_statistics_main b ");
//		sqljob.appendSQL("where b.account_year='"+year+"' ");
//		sqljob.appendSQL("and b.budget_code=2 ");
//		sqljob.appendSQL("group by b.debt_code ");
//		sqljob.appendSQL("union ");
//		sqljob.appendSQL("select '5' flag,'三、債務基金' as debit_name,");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='1' and account_kind='1' then b.issue_amount else 0 end),0)/100000000 as T1,");//預算甲類          
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='2' and account_kind='1'  then b.issue_amount else 0 end),0)/100000000 as T2,");//預算乙類
//		sqljob.appendSQL("(isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='1' and account_kind='1'  then b.issue_amount else 0 end),0) + ");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='2' and account_kind='1'  then b.issue_amount else 0 end),0))/100000000 as T3,");//預算類小計
//		//抓原始檔
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '3' and a.bond_type = '1')/100000000,0) as T4_1 ,");//已發行甲類
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '3' and a.bond_type = '2')/100000000,0) as T4_2,");//已發行乙類
//		sqljob.appendSQL("0 as T5_1,0 as T5_2,0 as T6_1,0 as T6_2,"); 
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='1' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '3' and a.bond_type = '1')/100000000,0) as T7_1,");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='2' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '3' and a.bond_type = '2')/100000000,0) as T7_2,");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='1' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000+");
//		sqljob.appendSQL("isNull(sum(case when b.debt_type in ('A','C','E') and b.budget_code=3 and bound_code='2' and account_kind='1' and is_account='N' then b.issue_amount else 0 end),0)/100000000-");
//		sqljob.appendSQL("isNull(( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '3' and a.bond_type = '2')/100000000 -");
//		sqljob.appendSQL("( select  sum(b.issue_amount)  from issue_main a, debt_main b where a.id = b.issue_id  and a.issue_date between '"+firstDay+"' and  '"+lastDay+"' ");
//		sqljob.appendSQL("and  a.debt_type in ('A','C','E') and b.budget_code = '3' and a.bond_type = '2')/100000000,0) as T7_3 ");
//		sqljob.appendSQL("from central_statistics_main b  ");
//		sqljob.appendSQL("where b.account_year='"+year+"' ");
//		sqljob.appendSQL("and b.budget_code=3 ");
//		sqljob.appendSQL("group by b.debt_code ");
//		sqljob.appendSQL("order by 1 ");
		System.out.println("GARA3701-SQL1:"+sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		AccountQueryForm myForm = (AccountQueryForm) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
	
		List flagAList = new ArrayList();
		List flagBList = new ArrayList();
		List flagCList = new ArrayList();
		//查出資料
		List queryList1 = (List) run.query(SQL1(myForm.getAccountYear(),myForm.getMonth()), new MapListHandler());
		//將資料分類
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			Map checkMap = (Map) tIterator.next();
			if ("1".equals((String)checkMap.get("flag")) || "2".equals((String)checkMap.get("flag")) || "3".equals((String)checkMap.get("flag")))
				flagAList.add(checkMap);
			else if ("4".equals((String)checkMap.get("flag")))
				flagBList.add(checkMap);
			else
				flagCList.add(checkMap);
		}
		//預設陣列值
		BigDecimal [] subtotal1 = new BigDecimal[12];
		BigDecimal [] subtotal2 = new BigDecimal[12];
		BigDecimal [] subtotal3 = new BigDecimal[12];
		for (int i = 0 ; i<subtotal1.length ; i++){
			subtotal1[i] = new BigDecimal(0);
			subtotal2[i] = new BigDecimal(0);
			subtotal3[i] = new BigDecimal(0);
		}
		
		boolean checkA = false;
		boolean checkB = false;
		Map tMap = new HashMap();
		//寫入flag1,2,3的資料
		for(Iterator it1 = flagAList.iterator(); it1.hasNext(); ){
			if (checkA == false){
				tMap.putAll(getCommonMap(usrId));
				tMap.put("debit_name","一、總預算");
				run.update(connection,insTemp("GARA37_RPT",tMap));
				checkA = true;
				tMap.clear();
			}
			tMap = (Map) it1.next();
			tMap.putAll(getCommonMap(usrId));
			subtotal1[0] = subtotal1[0].add((BigDecimal)tMap.get("T1"));
			subtotal1[1] = subtotal1[1].add((BigDecimal)tMap.get("T2"));
			subtotal1[2] = subtotal1[2].add((BigDecimal)tMap.get("T3"));
			subtotal1[3] = subtotal1[3].add((BigDecimal)tMap.get("T4_1"));
			subtotal1[4] = subtotal1[4].add((BigDecimal)tMap.get("T4_2"));
			subtotal1[5] = subtotal1[5].add(new BigDecimal((Integer)tMap.get("T5_1")));
			subtotal1[6] = subtotal1[6].add(new BigDecimal((Integer)tMap.get("T5_2")));
			subtotal1[7] = subtotal1[7].add(new BigDecimal((Integer)tMap.get("T6_1")));
			subtotal1[8] = subtotal1[8].add(new BigDecimal((Integer)tMap.get("T6_2")));
			subtotal1[9] = subtotal1[9].add((BigDecimal)tMap.get("T7_1"));
			subtotal1[10] = subtotal1[10].add((BigDecimal)tMap.get("T7_2"));
			subtotal1[11] = subtotal1[11].add((BigDecimal)tMap.get("T7_3"));
			run.update(connection,insTemp("GARA37_RPT",tMap));
		}
		if (checkA == true){
			tMap.put("debit_name","小　　　　　　計");
			tMap.put("T1",subtotal1[0]);
			tMap.put("T2",subtotal1[1]);
			tMap.put("T3",subtotal1[2]);
			tMap.put("T4_1",subtotal1[3]);
			tMap.put("T4_2",subtotal1[4]);
			tMap.put("T5_1",subtotal1[5]);
			tMap.put("T5_2",subtotal1[6]);
			tMap.put("T6_1",subtotal1[7]);
			tMap.put("T6_2",subtotal1[8]);
			tMap.put("T7_1",subtotal1[9]);
			tMap.put("T7_2",subtotal1[10]);
			tMap.put("T7_3",subtotal1[11]);
			run.update(connection,insTemp("GARA37_RPT",tMap));
		}
		
		//寫入flag4資料
		tMap = new HashMap();
		for(Iterator it1 = flagBList.iterator(); it1.hasNext(); ){
			if (checkB == false){
				tMap.putAll(getCommonMap(usrId));
				tMap.put("debit_name","二、特別預算");
				run.update(connection,insTemp("GARA37_RPT",tMap));
				checkB = true;
				tMap.clear();
			}
			tMap = (Map) it1.next();
			tMap.putAll(getCommonMap(usrId));
			subtotal2[0] = subtotal2[0].add((BigDecimal)tMap.get("T1"));
			subtotal2[1] = subtotal2[1].add((BigDecimal)tMap.get("T2"));
			subtotal2[2] = subtotal2[2].add((BigDecimal)tMap.get("T3"));
			subtotal2[3] = subtotal2[3].add((BigDecimal)tMap.get("T4_1"));
			subtotal2[4] = subtotal2[4].add((BigDecimal)tMap.get("T4_2"));
			subtotal2[5] = subtotal2[5].add(new BigDecimal((Integer)tMap.get("T5_1")));
			subtotal2[6] = subtotal2[6].add(new BigDecimal((Integer)tMap.get("T5_2")));
			subtotal2[7] = subtotal2[7].add(new BigDecimal((Integer)tMap.get("T6_1")));
			subtotal2[8] = subtotal2[8].add(new BigDecimal((Integer)tMap.get("T6_2")));
			subtotal2[9] = subtotal2[9].add((BigDecimal)tMap.get("T7_1"));
			subtotal2[10] = subtotal2[10].add((BigDecimal)tMap.get("T7_2"));
			subtotal2[11] = subtotal2[11].add((BigDecimal)tMap.get("T7_3"));
			run.update(connection,insTemp("GARA37_RPT",tMap));
		}
		if (checkB == true){
			tMap.put("debit_name","小　　　　　　計");
			tMap.put("T1",subtotal2[0]);
			tMap.put("T2",subtotal2[1]);
			tMap.put("T3",subtotal2[2]);
			tMap.put("T4_1",subtotal2[3]);
			tMap.put("T4_2",subtotal2[4]);
			tMap.put("T5_1",subtotal2[5]);
			tMap.put("T5_2",subtotal2[6]);
			tMap.put("T6_1",subtotal2[7]);
			tMap.put("T6_2",subtotal2[8]);
			tMap.put("T7_1",subtotal2[9]);
			tMap.put("T7_2",subtotal2[10]);
			tMap.put("T7_3",subtotal2[11]);
			run.update(connection,insTemp("GARA37_RPT",tMap));
		}
		
		//寫入flag5資料
		for(Iterator it1 = flagCList.iterator(); it1.hasNext(); ){
			tMap = (Map) it1.next();
			tMap.putAll(getCommonMap(usrId));
			run.update(connection,insTemp("GARA37_RPT",tMap));
			subtotal3[0] = subtotal3[0].add((BigDecimal)tMap.get("T1"));
			subtotal3[1] = subtotal3[1].add((BigDecimal)tMap.get("T2"));
			subtotal3[2] = subtotal3[2].add((BigDecimal)tMap.get("T3"));
			subtotal3[3] = subtotal3[3].add((BigDecimal)tMap.get("T4_1"));
			subtotal3[4] = subtotal3[4].add((BigDecimal)tMap.get("T4_2"));
			subtotal3[5] = subtotal3[5].add(new BigDecimal((Integer)tMap.get("T5_1")));
			subtotal3[6] = subtotal3[6].add(new BigDecimal((Integer)tMap.get("T5_2")));
			subtotal3[7] = subtotal3[7].add(new BigDecimal((Integer)tMap.get("T6_1")));
			subtotal3[8] = subtotal3[8].add(new BigDecimal((Integer)tMap.get("T6_2")));
			subtotal3[9] = subtotal3[9].add((BigDecimal)tMap.get("T7_1"));
			subtotal3[10] = subtotal3[10].add((BigDecimal)tMap.get("T7_2"));
			subtotal3[11] = subtotal3[11].add((BigDecimal)tMap.get("T7_3"));
		}
		tMap.put("debit_name","總　　　　　　計");
		tMap.put("T1",subtotal1[0].add(subtotal2[0]).add(subtotal3[0]));
		tMap.put("T2",subtotal1[1].add(subtotal2[1]).add(subtotal3[1]));
		tMap.put("T3",subtotal1[2].add(subtotal2[2]).add(subtotal3[2]));
		tMap.put("T4_1",subtotal1[3].add(subtotal2[3]).add(subtotal3[3]));
		tMap.put("T4_2",subtotal1[4].add(subtotal2[4]).add(subtotal3[4]));
		tMap.put("T5_1",subtotal1[5].add(subtotal2[5]).add(subtotal3[5]));
		tMap.put("T5_2",subtotal1[6].add(subtotal2[6]).add(subtotal3[6]));
		tMap.put("T6_1",subtotal1[7].add(subtotal2[7]).add(subtotal3[7]));
		tMap.put("T6_2",subtotal1[8].add(subtotal2[8]).add(subtotal3[8]));
		tMap.put("T7_1",subtotal1[9].add(subtotal2[9]).add(subtotal3[9]));;
		tMap.put("T7_2",subtotal1[10].add(subtotal2[10]).add(subtotal3[10]));
		tMap.put("T7_3",subtotal1[11].add(subtotal2[11]).add(subtotal3[11]));
		run.update(connection,insTemp("GARA37_RPT",tMap));
		BigDecimal amount = new BigDecimal(0);
		if (Integer.parseInt(myForm.getAccountYear()) < 90)
			amount = this.getYearAmountKind(connection,myForm.getAccountYear(),new BigDecimal(100000000),"1","1");
		else if (Integer.parseInt(myForm.getAccountYear()) >= 90)
			amount = this.getYearAmountKind(connection,myForm.getAccountYear(),new BigDecimal(100000000),"2","1");
		request.setAttribute("amount",amount);
	}
}
