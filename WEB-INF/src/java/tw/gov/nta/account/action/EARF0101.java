package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EARF0101 extends DefaultAction{
	
	protected final static String TEMP_TABLE_NAME = "EARF01_RPT";
	
	protected SQLJob delTemp(ActionForm form){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM "+TEMP_TABLE_NAME);
		return sqljob;
	}
	//GBA期初資料SQL
	protected SQLJob getOpeningSQL(ActionForm form){
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		String flag = myForm.getIp();
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select distinct i.id as issueId, ")
			  .append("		d.debt_code as debtCode, ")
			  .append("		d.budget_code as budget_code, ")
			  .append("		1 as Special_Budget, ")
			  .append("		0 as Data_Type, ")
			  .append("		i.account_year as Fiscal_Year, ")
			  .append("		i.account_year as Issue_Year, ")
			  .append("		i.serial_no as Serial_No, ")
			  .append("		i.debt_type as Debt_Type,")
			  .append("		case i.id when i.source_issue_id then 0 else 1 end as Incre_Debt, ")
			  .append("		D.DEBT_SERIAL AS Debt_No, ")
			  .append("		i.debt_name as Debt_Name, ")
			  .append("		right('0000000'+convert(varchar,(convert(varchar,i.issue_date, 112)-19110000)),7) as Issue_Date, ")
			  .append("		right('0000000'+convert(varchar,(convert(varchar,i.due_date, 112)-19110000)),7) as Due_Date, ")
			  .append("     0 as Interest_No, ")
//			  .append("		sum(d.issue_amount) as Issue_Amount, ")
			  //去除中長借96-1重複加總
			  .append(" 	case  when i.id <> 3914 then sum(d.issue_amount) else sum(d.issue_amount)/2 end as Issue_Amount,")
			  .append("		d.real_amount as Real_Amount, ")
			  //去除中長借96-1重複加總
//			  .append("		sum(d.diversity_amount) as Diversity_Amount, ")
			  .append(" 	case  when i.id <> 3914 then sum(d.diversity_amount) else sum(d.diversity_amount)/2 end as Diversity_Amount,")
			  .append("		d.issue_cost_amount as Cost_Amount, ")
			  .append("		sum(case when p.capital_amount <> 0 then p.capital_amount else 0 end) as Pay_Amount, ")
			  .append("		0 as Share_Diversity_Amount, ")
			  .append("		0 as Share_Cost_Amount ")
			  .append(" from issue_main i, debt_main d,	payment_main p")
			  .append(" where i.id = d.issue_id ")
			  .append("		and d.accrue = 'Y' ")
			  .append("		and d.debt_code <> 35 ")
			  .append("		and i.bond_type <> 1 ")
			  .append("		and	ISNUMERIC(i.serial_no) = 1 ");
		StringBuffer sqlGroupStr = new StringBuffer();
		sqlGroupStr.append(" group by i.id,d.debt_code,d.budget_code,i.account_year,i.serial_no,i.source_issue_id,d.debt_serial,i.debt_name")
				   .append(", i.issue_date,p.interest_serial,d.real_amount,d.issue_cost_amount,i.due_date,i.debt_type, p.CAPITAL_AMOUNT");
		//中長借--未還款
		sqljob.appendSQL(sqlStr.toString());
		sqljob.appendSQL("		and i.debt_type = 'C' ");
		if(flag.equals("0")){ //發行
			sqljob.appendSQL("	and d.id *= p.debt_id ");
			sqljob.appendSQL("	and i.issue_date <= '2011/12/31'");
		}
		if(flag.equals("1")){//還本付息
			sqljob.appendSQL("	and d.id *= p.debt_id  ");
			sqljob.appendSQL("	and i.id *= p.issue_id ");
//			sqljob.appendSQL("	and p.repay_date <= '2009/12/31'");
//			sqljob.appendSQL("	and p.repay_date is null");
			sqljob.appendSQL("	and i.issue_date <= '2011/12/31'");
		}
		sqljob.appendSQL("		and (i.issue_amount > i.capital_amount or i.capital_amount is null )");
		sqljob.appendSQL(sqlGroupStr.toString());
		sqljob.appendSQL("		,p.repay_date");
		sqljob.appendSQL(" union ");
		//中長借--已還款,資料中有僅還利息項目
		sqljob.appendSQL(sqlStr.toString());
		sqljob.appendSQL("		and i.debt_type = 'C' ");
		if(flag.equals("0")){ //發行
			sqljob.appendSQL("	and d.id *= p.debt_id ");
			sqljob.appendSQL("	and i.issue_date <= '2011/12/31'");
		}
		if(flag.equals("1")){//還本付息
			sqljob.appendSQL("	and d.id = p.debt_id  ");
			sqljob.appendSQL("	and p.repay_date <= '2011/12/31'");
		}
		sqljob.appendSQL("		and (i.issue_amount = i.capital_amount ");
		sqljob.appendSQL("			and ((select max(p1.repay_date) from payment_main p1 where p1.id = p.id) > '2011/12/31'))");
		sqljob.appendSQL("		and (0 = (select min(pm.capital_amount) from payment_main pm where pm.issue_id = i.id and pm.repay_date > '2011/12/31')");
		sqljob.appendSQL("			and p.capital_amount = (select min(pm.capital_amount) from payment_main pm where pm.issue_id = i.id and pm.repay_date > '2011/12/31'))");
		sqljob.appendSQL(sqlGroupStr.toString());
		sqljob.appendSQL(" union ");
		//中長借--已還款,資料中未有僅還利息項目
		sqljob.appendSQL(sqlStr.toString());
		sqljob.appendSQL("		and i.debt_type = 'C' ");
		if(flag.equals("0")){ //發行
			sqljob.appendSQL("	and d.id *= p.debt_id ");
			sqljob.appendSQL("	and i.issue_date <= '2011/12/31'");
		}
		if(flag.equals("1")){//還本付息
			sqljob.appendSQL("	and d.id = p.debt_id  ");
			sqljob.appendSQL("	and p.repay_date <= '2011/12/31'");
		}
		sqljob.appendSQL(" 		and d.id not in (5853)");
		sqljob.appendSQL("		and (i.issue_amount = i.capital_amount ");
		sqljob.appendSQL("			and ((select max(p1.repay_date) from payment_main p1 where p1.id = p.id) > '2011/12/31'))");
		sqljob.appendSQL("		and (0 < (select min(pm.capital_amount) from payment_main pm where pm.issue_id = i.id and pm.repay_date > '2011/12/31')");
		sqljob.appendSQL("			and p.capital_amount in (select pm.capital_amount from payment_main pm where pm.issue_id = i.id and pm.repay_date > '2011/12/31'))");
		sqljob.appendSQL(sqlGroupStr.toString());	
		sqljob.appendSQL(" union ");
		sqljob.appendSQL("select distinct i.id as issueId, ");
		sqljob.appendSQL("		d.debt_code as debtCode, ");
		sqljob.appendSQL("		d.budget_code as budget_code, ");
		sqljob.appendSQL("		1 as Special_Budget, ");
		sqljob.appendSQL("		0 as Data_Type, ");
		sqljob.appendSQL("		i.account_year as Fiscal_Year, ");
		sqljob.appendSQL("		i.account_year as Issue_Year, ");
		sqljob.appendSQL("		i.serial_no as Serial_No, ");
		sqljob.appendSQL("		i.debt_type as Debt_Type,");
		sqljob.appendSQL("		case i.id when i.source_issue_id then 0 else 1 end as Incre_Debt, ");
		sqljob.appendSQL("		D.DEBT_SERIAL AS Debt_No, ");
		sqljob.appendSQL("		i.debt_name as Debt_Name, ");
		sqljob.appendSQL("		right('0000000'+convert(varchar,(convert(varchar,i.issue_date, 112)-19110000)),7) as Issue_Date, ");
		sqljob.appendSQL("		right('0000000'+convert(varchar,(convert(varchar,i.due_date, 112)-19110000)),7) as Due_Date, ");
		sqljob.appendSQL("      0 as Interest_No, ");
		sqljob.appendSQL("		d.issue_amount as Issue_Amount, ");
		sqljob.appendSQL("		d.real_amount as Real_Amount, ");
		sqljob.appendSQL("		d.diversity_amount as Diversity_Amount, ");
		sqljob.appendSQL("		d.issue_cost_amount as Cost_Amount, ");
		sqljob.appendSQL("		sum(case when p.capital_amount <> 0 then p.capital_amount else 0 end) as Pay_Amount, ");
		sqljob.appendSQL("		0 as Share_Diversity_Amount, ");
		sqljob.appendSQL("		0 as Share_Cost_Amount ");
		sqljob.appendSQL(" from issue_main i, debt_main d,	payment_main p");
		sqljob.appendSQL(" where i.id = d.issue_id ");
		sqljob.appendSQL("		and d.accrue = 'Y' ");
		sqljob.appendSQL("		and d.debt_code <> 35 ");
		sqljob.appendSQL("		and i.bond_type <> 1 ");
		sqljob.appendSQL("		and	ISNUMERIC(i.serial_no) = 1 ");
		sqljob.appendSQL("		and i.debt_type = 'C' ");
		if(flag.equals("0")){ //發行
			sqljob.appendSQL("	and d.id *= p.debt_id ");
			sqljob.appendSQL("	and i.issue_date <= '2011/12/31'");
		}
		if(flag.equals("1")){//還本付息
			sqljob.appendSQL("	and d.id = p.debt_id  ");
			sqljob.appendSQL("	and p.repay_date <= '2011/12/31'");
		}
		sqljob.appendSQL(" 		and d.id in (5853)");
		sqljob.appendSQL("		and (i.issue_amount = i.capital_amount ");
		sqljob.appendSQL("			and ((select max(p1.repay_date) from payment_main p1 where p1.id = p.id) > '2011/12/31'))");
		sqljob.appendSQL("		and (0 < (select min(pm.capital_amount) from payment_main pm where pm.issue_id = i.id and pm.repay_date > '2011/12/31')");
		sqljob.appendSQL("			and p.capital_amount in (select pm.capital_amount from payment_main pm where pm.issue_id = i.id and pm.repay_date > '2011/12/31'))");
		sqljob.appendSQL(" group by i.id,d.debt_code,d.budget_code,i.account_year,i.serial_no,i.source_issue_id,d.debt_serial,i.debt_name");
		sqljob.appendSQL("		, i.issue_date,p.interest_serial,d.real_amount,d.issue_cost_amount,i.due_date,i.debt_type,d.issue_amount, d.diversity_amount");

		sqljob.appendSQL(" union ");
		//公債
		sqljob.appendSQL("select i.id as issueId, ");
		sqljob.appendSQL("		d.debt_code as debtCode, ");
		sqljob.appendSQL("		d.budget_code as budget_code, ");
		sqljob.appendSQL("		1 as Special_Budget, ");
		sqljob.appendSQL("		0 as Data_Type, ");
		sqljob.appendSQL("		i.account_year as Fiscal_Year, ");
		sqljob.appendSQL("		i.account_year as Issue_Year, ");
		sqljob.appendSQL("		i.serial_no as Serial_No, ");
		sqljob.appendSQL("		i.debt_type as Debt_Type, ");
		sqljob.appendSQL("		case i.id when i.source_issue_id then 0 else 1 end as Incre_Debt, ");
		sqljob.appendSQL("		d.debt_serial as debt_no, ");
		sqljob.appendSQL("		i.debt_name as Debt_name, ");
		sqljob.appendSQL("		right('0000000'+convert(varchar,(convert(varchar,i.issue_date, 112)-19110000)),7) as Issue_Date, ");
		sqljob.appendSQL("		right('0000000'+convert(varchar,(convert(varchar,i.due_date, 112)-19110000)),7) as Due_Date, ");
		sqljob.appendSQL("		0 as Interest_No, ");
		sqljob.appendSQL(" 		d.issue_amount as Issue_Amount, ");	
		sqljob.appendSQL("		d.real_amount as Real_Amount, ");
		sqljob.appendSQL("		d.diversity_amount as Diversity_Amount, ");
		sqljob.appendSQL("		d.issue_cost_amount as Cost_Amount, ");
		sqljob.appendSQL("		(select sum(case when p.capital_amount <> 0 then p.capital_amount else 0 end) from payment_main p where p.debt_id=d.id and p.repay_date < '2011/12/31') as Pay_Amount,");
		sqljob.appendSQL("		((d.diversity_amount)/i.interest_alternate)*(select isnull(Max(debt.interest_serial),0) ");
		sqljob.appendSQL(			"from debt_plan_det debt where d.id = debt.debt_id and debt.repay_date<'2011/12/31' and debt.delete_mark <> 'Y') as Share_Diversity_Amount,");
		sqljob.appendSQL("		((d.issue_cost_amount)/i.interest_alternate)*(select isnull(Max(debt.interest_serial),0) " +
									"from debt_plan_det debt where d.id = debt.debt_id and debt.repay_date<'2011/12/31' and debt.delete_mark <> 'Y') as Share_Cost_Amount");
		sqljob.appendSQL(" from issue_main i, debt_main d");
		sqljob.appendSQL(" where i.id=d.issue_id ");
		sqljob.appendSQL(" and i.issue_date < '2011/12/31' ");
		sqljob.appendSQL(" and i.due_date > '2011/12/31' ");
		sqljob.appendSQL(" and debt_type='A'");
		sqljob.appendSQL(" order by i.debt_type, i.i.issue_date");
		
//		sqljob.appendSQL(" union ");
//		//短借(債務基金)
//		sqljob.appendSQL(" select  i.id as issueId,");
//		sqljob.appendSQL(" 		d.debt_code as debtCode, ");
//		sqljob.appendSQL(" 		d.budget_code as budget_code, ");
//		sqljob.appendSQL(" 		1 as Special_Budget, ");
//		sqljob.appendSQL(" 		0 as Data_Type, ");
//		sqljob.appendSQL(" 		i.account_year as Fiscal_Year, ");
//		sqljob.appendSQL("       i.account_year as Issue_Year, ");
//		sqljob.appendSQL("		i.serial_no as Serial_No, ");
//		sqljob.appendSQL("		i.debt_type as Debt_Type, ");
//		sqljob.appendSQL("		case i.id when i.source_issue_id then 0 else 1 end as Incre_Debt, ");
//		sqljob.appendSQL("		D.DEBT_SERIAL AS Debt_No, ");
//		sqljob.appendSQL("		i.debt_name as Debt_Name, ");
//		sqljob.appendSQL("		right('0000000'+convert(varchar,(convert(varchar,i.issue_date, 112)-19110000)),7) as Issue_Date, ");
//		sqljob.appendSQL("		right('0000000'+convert(varchar,(convert(varchar,i.due_date, 112)-19110000)),7) as Due_Date, ");
//		sqljob.appendSQL("      0 as Interest_No, ");
//		sqljob.appendSQL("		sum(d.issue_amount) as Issue_Amount, ");
//		sqljob.appendSQL("		d.real_amount as Real_Amount, ");
//		sqljob.appendSQL("		sum(d.diversity_amount) as Diversity_Amount, "); 
//		sqljob.appendSQL("		d.issue_cost_amount as Cost_Amount, ");
//		sqljob.appendSQL("		p.capital_amount as Pay_Amount, ");
//		sqljob.appendSQL("		0 as Share_Diversity_Amount, ");
//		sqljob.appendSQL("		0 as Share_Cost_Amount ");
//		sqljob.appendSQL(" from issue_main i, debt_main d, payment_main p ");
//		sqljob.appendSQL(" where d.issue_id = i.id ");
//		sqljob.appendSQL("		and i.debt_type in ('D') ");
//		sqljob.appendSQL("		and (i.issue_amount <> i.capital_amount or i.capital_amount = null) ");
//		sqljob.appendSQL("		and i.debt_code = 31");
//		if(flag.equals("0")){ //發行
//			sqljob.appendSQL("  and d.id *= p.debt_id ");
//			sqljob.appendSQL("  and i.issue_date <= '2008/12/31' ") ;
//		}
//		
//		if(flag.equals("1")){//還本付息
//			sqljob.appendSQL("	 and d.id = p.debt_id  ");
//			sqljob.appendSQL("	 and p.repay_date <= '2008/12/31' ");
//		}
//		sqljob.appendSQL("group by i.id,d.debt_code,d.budget_code,i.account_year,i.serial_no,i.source_issue_id,d.debt_serial,i.debt_name,");
//		sqljob.appendSQL(" i.issue_date,p.repay_date,p.interest_serial,d.real_amount,d.issue_cost_amount,p.capital_amount,i.due_date,i.debt_type");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	//GBA平時資料SQL
	protected SQLJob getSql(ActionForm form){
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		//若FLAG為0，則查發行的SQL，若為1，則查還本付息
		Date qrySDate = DateUtil.str2Date( myForm.getAccountYear()+myForm.getMonth()+"01" );
		Date qryEDate = DateUtil.str2Date( DateUtil.getLastDateOfMonth(myForm.getAccountYear(),myForm.getMonth()) );
		String flag = myForm.getIp();
		//公債
		sqljob.appendSQL(" select  i.id as issueId,");
		sqljob.appendSQL(" 		d.debt_code as debtCode, ");
		sqljob.appendSQL(" 		d.budget_code as budget_code, ");
		sqljob.appendSQL(" 		1 as Special_Budget, ");
		sqljob.appendSQL(" 		1 as Data_Type, ");
        sqljob.appendSQL(" 		i.account_year as Fiscal_Year, ");
        sqljob.appendSQL("      i.account_year as Issue_Year, ");
		sqljob.appendSQL("		i.serial_no as Serial_No, ");
		sqljob.appendSQL("		i.debt_type as Debt_Type, ");
		sqljob.appendSQL("		case i.id when i.source_issue_id then 0 else 1 end as Incre_Debt, ");
		sqljob.appendSQL("		D.DEBT_SERIAL AS Debt_No, ");
		sqljob.appendSQL("		i.debt_name as Debt_Name, ");
		sqljob.appendSQL("		right('0000000'+convert(varchar,(convert(varchar,i.issue_date, 112)-19110000)),7) as Issue_Date, ");
		sqljob.appendSQL("		right('0000000'+convert(varchar,(convert(varchar,i.due_date, 112)-19110000)),7) as Due_Date, ");
		sqljob.appendSQL("		right('0000000'+convert(varchar,(convert(varchar,p.repay_date, 112)-19110000)),7) as Interest_Date, ");
		sqljob.appendSQL("		p.interest_serial as Interest_No, ");
		sqljob.appendSQL("		d.issue_amount as Issue_Amount, ");
		sqljob.appendSQL("		d.real_amount as Real_Amount, ");
		sqljob.appendSQL("		d.diversity_amount as Diversity_Amount, "); 
		sqljob.appendSQL("		d.issue_cost_amount as Cost_Amount, ");
		if(flag.equals("0")) 
		{
			sqljob.appendSQL("	p.capital_amount as Pay_Amount, ");
			sqljob.appendSQL("	0 as Share_Diversity_Amount, ");
			sqljob.appendSQL("	0 as Share_Cost_Amount ");
		} else {
			sqljob.appendSQL("	isnull((select sum(case when isnull(p.capital_amount,0) <> 0 then p.capital_amount else 0 end) " +
					"from payment_main p where p.debt_id=d.id),0) as Pay_Amount, ");
//			sqljob.appendSQL("	(d.diversity_amount/i.interest_alternate)*isnull(p.interest_serial,0) as Share_Diversity_Amount,");
//			sqljob.appendSQL("	(d.issue_cost_amount/i.interest_alternate)*isnull(p.interest_serial,0) as Share_Cost_Amount");
			//20091030 chrisWu 修改為單一期別金額
			sqljob.appendSQL("	(d.diversity_amount/i.interest_alternate) as Share_Diversity_Amount,");
			sqljob.appendSQL("	(d.issue_cost_amount/i.interest_alternate) as Share_Cost_Amount");
		}
		sqljob.appendSQL(" from issue_main i, debt_main d, payment_main p ");
		sqljob.appendSQL(" where d.issue_id = i.id ");
		sqljob.appendSQL("		and i.debt_type in ('A') ");
//		sqljob.appendSQL("		and (i.issue_amount <> i.capital_amount or i.capital_amount is null) ");
		sqljob.appendSQL("		and (i.issue_amount >= isnull((select sum(capital_amount) from payment_main where issue_id = i.id),0) or i.capital_amount is null) ");
		//20091030 chrisWu 去除剛好還本，而重覆產生資料的問題
		sqljob.appendSQL("		and p.capital_serial = 0 ");
		if(flag.equals("0")){ //發行
			sqljob.appendSQL("  and d.id *= p.debt_id ");
			sqljob.appendSQL("  and (i.issue_date between '"+DateUtil.date2Str(qrySDate, "yyyy/MM/dd")+"' and '"+DateUtil.date2Str(qryEDate, "yyyy/MM/dd")+"' ) ") ;
		}
		
		if(flag.equals("1")){//還本付息
			sqljob.appendSQL("	 and i.due_date >= '"+DateUtil.date2Str(qrySDate, "yyyy/MM/dd")+"' ");
			sqljob.appendSQL("	 and d.id = p.debt_id  ");
			sqljob.appendSQL("	 and (p.repay_date between '"+DateUtil.date2Str(qrySDate, "yyyy/MM/dd")+"' and '"+DateUtil.date2Str(qryEDate, "yyyy/MM/dd")+"')  ");
			//20091030 chrisWu 去除系統自動產生之年初手續費 userid = EXCEL     
			sqljob.appendSQL("	 and p.userid is null");
		}
		
		sqljob.appendSQL(" union ");
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select  i.id as issueId,")
					   .append("d.debt_code as debtCode, ")
					   .append("d.budget_code as budget_code, ")
					   .append("1 as Special_Budget, ")
					   .append("1 as Data_Type, ")
					   .append("i.account_year as Fiscal_Year, ")
					   .append("i.account_year as Issue_Year, ")
					   .append("i.serial_no as Serial_No, ")
					   .append("i.debt_type as Debt_Type, ")
					   .append("case i.id when i.source_issue_id then 0 else 1 end as Incre_Debt, ")
					   .append("D.DEBT_SERIAL AS Debt_No, ")
					   .append("i.debt_name as Debt_Name, ")
					   .append("right('0000000'+convert(varchar,(convert(varchar,i.issue_date, 112)-19110000)),7) as Issue_Date, ")
					   .append("right('0000000'+convert(varchar,(convert(varchar,i.due_date, 112)-19110000)),7) as Due_Date, ")
					   .append("right('0000000'+convert(varchar,(convert(varchar,p.repay_date, 112)-19110000)),7) as Interest_Date, ")
					   .append("p.interest_serial as Interest_No, ")
					   .append("sum(d.issue_amount) as Issue_Amount, ")
					   .append("d.real_amount as Real_Amount, ")
					   .append("sum(d.diversity_amount) as Diversity_Amount, ") 
					   .append("d.issue_cost_amount as Cost_Amount, ")
					   .append("p.capital_amount as Pay_Amount, ")
					   .append("0 as Share_Diversity_Amount, ")
					   .append("0 as Share_Cost_Amount ")
					   .append("from issue_main i, debt_main d, payment_main p ");
		StringBuffer sqlGroupStr = new StringBuffer();
		sqlGroupStr.append("group by i.id,d.debt_code,d.budget_code,i.account_year,i.serial_no,i.source_issue_id,d.debt_serial,i.debt_name,")
				.append(" i.issue_date,p.repay_date,p.interest_serial,d.real_amount,d.issue_cost_amount,p.capital_amount,i.due_date,i.debt_type")
				.append(",d.id,d.diversity_amount,i.interest_alternate");
		//中長借
		sqljob.appendSQL(sqlStr.toString());
		sqljob.appendSQL(" where d.issue_id = i.id ");
		sqljob.appendSQL("		and i.debt_type in ('C') ");
//		sqljob.appendSQL("		and (i.issue_amount <> i.capital_amount or i.capital_amount = null) ");
		if(flag.equals("0")){ //發行
			sqljob.appendSQL("  and d.id *= p.debt_id ");
			sqljob.appendSQL("  and (i.issue_date between '"+DateUtil.date2Str(qrySDate, "yyyy/MM/dd")+"' and '"+DateUtil.date2Str(qryEDate, "yyyy/MM/dd")+"' ) ") ;
		}
		
		if(flag.equals("1")){//還本付息
			sqljob.appendSQL("	 and d.id = p.debt_id  ");
			sqljob.appendSQL("	 and (p.repay_date between '"+DateUtil.date2Str(qrySDate, "yyyy/MM/dd")+"' and '"+DateUtil.date2Str(qryEDate, "yyyy/MM/dd")+"')  ");
		}
		sqljob.appendSQL(sqlGroupStr.toString());

//		sqljob.appendSQL(" union ");
//		//短借(債務基金)
//		sqljob.appendSQL(sqlStr.toString());
//		sqljob.appendSQL(" where d.issue_id = i.id ");
//		sqljob.appendSQL("		and i.debt_type in ('D') ");
//		sqljob.appendSQL("		and (i.issue_amount <> i.capital_amount or i.capital_amount = null) ");
//		sqljob.appendSQL("		and i.debt_code = 31");
//		if(flag.equals("0")){ //發行
//			sqljob.appendSQL("  and d.id *= p.debt_id ");
//			sqljob.appendSQL("  and (i.issue_date between '"+DateUtil.date2Str(qrySDate, "yyyy/MM/dd")+"' and '"+DateUtil.date2Str(qryEDate, "yyyy/MM/dd")+"' ) ") ;
//		}
//		
//		if(flag.equals("1")){//還本付息
//			sqljob.appendSQL("	 and d.id = p.debt_id  ");
//			sqljob.appendSQL("	 and (p.repay_date between '"+DateUtil.date2Str(qrySDate, "yyyy/MM/dd")+"' and '"+DateUtil.date2Str(qryEDate, "yyyy/MM/dd")+"')  ");
//		}
//		sqljob.appendSQL(sqlGroupStr.toString());
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected Map enCode(ActionForm form,Map tMap, Connection connection) throws SQLException{
		AccountQueryForm myForm = (AccountQueryForm) form;

		//取得SQLRunner		
		SQLRunner run = new ConnectionSQLRunner(connection); 
		
		//將資料格式改為GBA所需的，並寫入temptable中

		Map dMap = new HashMap();			//要寫入temptable的資料
		
		/*
		 * 1==基金別Fundtype== 
		 * debt_main.budget_code=3(債務基金)，此值為2
		 * debt_main.budget_code=1(總預算)，此值為1
		 * debt_main.budget_code=2(特別預算)，此值為1
		 */
		if("3".equals(tMap.get("budget_code").toString())){
			dMap.put("fundkind",2);
		}else if("1".equals(tMap.get("budget_code").toString()) || "2".equals(tMap.get("budget_code").toString()) ){
			dMap.put("fundkind",1);
		}else {
			dMap.put("fundkind",null);
		}

		/*
		 * 2==預算別Budgettype==
		 * 當基金別fundkind 為1時，此欄位才有值
		 * debt_main.budget_code=1(總預算)，此值為1
		 * debt_main.budget_code=2(特別預算)，此值為2
		 */
		if(null != dMap.get("fundkind") && "1".equals((String)dMap.get("fundkind").toString())){
			if("1".equals(tMap.get("budget_code").toString())){
				dMap.put("budgetkind","1");
			}else if("2".equals(tMap.get("budget_code").toString())){
				dMap.put("budgetkind","2");
			}
		}else{
			dMap.put("budgetkind",null);
		}
		
		//3==特別預算種類Special_Budget==
		//當預算別Budgettype為2時，此欄位才有值
		//使用GBA_MAPPING這個TABLE來查對應值
		if("2".equals((String)dMap.get("budgetkind"))){
			dMap.put("specialbudget",getGBAmapping(connection,tMap.get("debtCode").toString()));
		}else{
			dMap.put("specialbudget",null);
		}

		//4==資料別DataType==
		//0:期初資料
		//1:平時資料(目前都只有平時資料) 
		dMap.put("datatype",(String)tMap.get("Data_Type").toString()); 
		
		//5==會計年度Fiscalyear== 
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		String nowYear = String.valueOf(cal.get(Calendar.YEAR) - 1911);
//		if(nowYear.length() < 3)
//			nowYear = "0"+nowYear;
//		dMap.put("fiscalyear",nowYear);
		dMap.put("fiscalyear",myForm.getAccountYear());
//		dMap.put("fiscalyear",tMap.get("Fiscal_Year"));
		
		//6==機關編號Agenno==
		//固定為1710003
		//dMap.put("Agenno",tMap.get("Agenno"));

		//7==發行年度Issueyear==
		dMap.put("issueyear",tMap.get("Issue_Year"));
		
		//8==期次serialno==
		dMap.put("serialno",tMap.get("Serial_No"));
		
		//9==債種debttype==
		//A:公債
		//B:中長借
		dMap.put("debttype",tMap.get("Debt_Type"));
		
		//10==增額發行IncreDebt==
		//0:否
		//1:是
		dMap.put("incredebt",tMap.get("Incre_Debt"));
		
		
		//11==債務編號Debtno==
		dMap.put("debtno",tMap.get("Debt_No"));
		
		
		//12==債務名稱Debtname==
		dMap.put("debtname",tMap.get("Debt_Name"));
		
		
		//13==發行日期Issuedate==
		dMap.put("issuedate",tMap.get("Issue_Date"));
		

		//14==到期日Duedate==
		dMap.put("duedate",tMap.get("Due_Date"));
		
		
//		//15==償還本息日Interestdate==
		dMap.put("interestdate",tMap.get("Interest_Date"));
		
		
//		//16==利息次別Interestno==
		dMap.put("interestno",tMap.get("Interest_No"));
		
		
		//17==發行面額/舉借金額Issueamount== new java.text.DecimalFormat("0.00").format(4.025)		
		dMap.put("issueamount",new java.text.DecimalFormat("0.00").format(tMap.get("Issue_Amount")));
		
		
		//18==實售金額Realamount==
		//當Debt_Type為A(公債)時，此欄位才有值
		if("A".equals((String)tMap.get("Debt_Type"))){
			dMap.put("realamount",new java.text.DecimalFormat("0.00").format(tMap.get("Real_Amount")));
		}else{
			dMap.put("realamount",null);
		}		
		
		//19==債券溢折價Diversityamount==
		//當Debt_Type為A(公債)時，此欄位才有值
		if("A".equals((String)tMap.get("Debt_Type"))){
			dMap.put("diversityamount",new java.text.DecimalFormat("0.00").format(tMap.get("Diversity_Amount")));
		}else{
			dMap.put("diversityamount",null);
		}		
		
		//20==發行成本金額Costamount==
		//當Debt_Type為A(公債)時，此欄位才有值
		if("A".equals((String)tMap.get("Debt_Type"))){
			dMap.put("costamount",tMap.get("Cost_Amount"));
		}else{
			dMap.put("costamount",null);
		}
		
		//21==還本金額Payamount==
		if (null != tMap.get("Pay_Amount"))
			dMap.put("payamount",new java.text.DecimalFormat("0.00").format((BigDecimal)tMap.get("Pay_Amount")));
		
		//22==債券溢折價攤銷金額/累計債券溢折價攤銷金額ShareDiversityamount==
		if("A".equals((String)tMap.get("Debt_Type"))){
			dMap.put("sharediversityamount",new java.text.DecimalFormat("0.00").format(tMap.get("Share_Diversity_Amount")));
		}else{
			dMap.put("costamount",null);
		}
		
		//23==發行成本攤銷金額ShareCostAmount==		
		if("A".equals((String)tMap.get("Debt_Type"))){
			dMap.put("sharecostamount",new java.text.DecimalFormat("0.00").format(tMap.get("Share_Cost_Amount")));
		}else{
			dMap.put("costamount",null);
		}
		
		//債務別
		return dMap;
	}
	
	protected String getGBAmapping(Connection connection,String debtCode) throws SQLException{
		//用debtCode到GBA_MAPPING取得對應值
		String Special_Budget = "";
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL(" SELECT GBA_Code  FROM  GBA_MAPPING ");
		sqljob.appendSQL(" WHERE Debt_code = ?  ");
		sqljob.addParameter(debtCode);
		
		Map map = (Map) run.query(sqljob, new MapHandler());
		
		if(null!=map && !map.isEmpty()){
			Special_Budget = map.get("GBA_Code").toString();			
		}else{
			Special_Budget = "";
		}
		
		return Special_Budget;
		
		
	}
	
	protected SQLJob insTemp(String pTableName,Map pMap){
		SQLJob sqljob = new SQLJob();
		pMap.keySet().iterator();
		sqljob.appendSQL("INSERT INTO " + pTableName);
		sqljob.appendSQL(" ( ");
		for(Iterator tIterator = pMap.keySet().iterator(); tIterator.hasNext(); ){
			sqljob.appendSQL((String)tIterator.next());
			if(tIterator.hasNext())
				sqljob.appendSQL(", "); 
		}
			
		sqljob.appendSQL(" ) VALUES(");
		Object tValue = null;
		for(Iterator tIterator = pMap.keySet().iterator(); tIterator.hasNext(); ){
			tValue = pMap.get(tIterator.next());
			if(tValue == null)
				sqljob.appendSQL("NULL");
			else if(tValue.getClass() == Timestamp.class)
				sqljob.appendSQL("'" + ( (Timestamp) tValue ) + "'");
			else if(tValue.getClass() == Date.class)
				sqljob.appendSQL("'" + new Timestamp( ((Date) tValue).getTime() ) + "'");
			else if (tValue.getClass() == BigDecimal.class)
				sqljob.appendSQL(String.valueOf(((BigDecimal)tValue).doubleValue()));
			else
				sqljob.appendSQL("'" + tValue + "'");
			if(tIterator.hasNext())
				sqljob.appendSQL(", ");
		}
		sqljob.appendSQL(")");

		return sqljob;
	}
	
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		
		//TEMPTABLE裡的欄位名稱必需與主計處要求的欄位名稱相同
		
		//取得使用者帳號
		AccountQueryForm myForm = (AccountQueryForm) form;
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//刪除temptable
		run.update(connection,delTemp(form));
		//insert temptable
		List tList = null;//從各大table中撈出來的資料，未經整理的資料
		if ("0".equals(myForm.getOpening()))
			tList = (List) run.query(getSql(form), new MapListHandler());//一般公債GBA
		else if ("1".equals(myForm.getOpening()))
			tList = (List) run.query(getOpeningSQL(form), new MapListHandler());//期初GBA
		
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); )
		{
			Map tMap = (Map) tIterator.next(); 

			Map dMap = enCode(form,tMap,connection);
			run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));	
		}
	}
}