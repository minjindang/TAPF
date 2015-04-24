package tw.gov.nta.surplusage.common;

import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tw.gov.nta.surplusage.form.Gara3901Form;

import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class Gara39Report {
	public SQLJob selectSheet1(Gara3901Form form)
	{
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");

		//0951208
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select " );
		sqljob.appendSQL("case  " );
		sqljob.appendSQL("when (a.debt_type='A' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '1') then '公債'  " );
		sqljob.appendSQL("when (a.debt_type='C' and c.debt_code<>'42' and c.debt_code<>'35' and isnull(delete_mark,'N')='N' and bond_type = '2') then '中長期借款'  " );
		sqljob.appendSQL("else '' end as debt_type, " );
		sqljob.appendSQL("round(sum(case  when DATEPART( yy , b.repay_date )-1911='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year1  " );
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1912='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year2  	" );
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1913='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year3  " );
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1914='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year4 " );
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1915='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year5  " );
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1916='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year6 " );
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1917='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year7 " );
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1918='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year8  " );
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1919='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year9 " );
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1920='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year10 " );
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1921='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year11 " );
		sqljob.appendSQL(",round(sum(case when DATEPART( yy , b.repay_date )-1922 >= '"+year+"' and DATEPART( yy , b.repay_date )-1926 <= "+year+" and b.capital_amount >0 then b.capital_amount else 0 end) ,2) as year_5_1,  " );
		sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1927 >= '"+year+"' and DATEPART( yy , b.repay_date )-1931 <= "+year+" and b.capital_amount >0 then b.capital_amount else 0 end) ,2) as year_5_2, " );
		sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1932 >= '"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end) ,2) as year_5_3 " );
		sqljob.appendSQL("from issue_main a,Debt_plan_det b,debt_main c " );
		sqljob.appendSQL("where a.id = b.issue_id " );
		sqljob.appendSQL("and b.debt_id = c.id " );
		sqljob.appendSQL("and isnull(report_flag,'0') = '0' " );
		sqljob.appendSQL("and isnull(b.delete_mark,'N') = 'N' " );
		sqljob.appendSQL("and a.issue_date <= '"+strLastDate+"' " );
		sqljob.appendSQL("and (  " );
		sqljob.appendSQL("(a.debt_type='A' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '1') or  " );
		sqljob.appendSQL("(a.debt_type='C'  and  isnull(delete_mark,'N')= 'N' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '2') " );
		sqljob.appendSQL(") " );
		sqljob.appendSQL("group by (case " );
		sqljob.appendSQL("when (a.debt_type='A' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '1') then '公債' " );
		sqljob.appendSQL("when (a.debt_type='C' and c.debt_code<>'42' and c.debt_code<>'35' and isnull(delete_mark,'N')='N' and bond_type = '2') then '中長期借款' " );
		sqljob.appendSQL("else '' end) " );
		sqljob.appendSQL("union " );
		sqljob.appendSQL("select " );
		sqljob.appendSQL("case " );
		sqljob.appendSQL("when (b.debt_code=42 ) then '戰機借款'" ); 
		sqljob.appendSQL("when (b.debt_code=35 ) then '省債' " );
		sqljob.appendSQL("else '' end as debt_type," );
		sqljob.appendSQL("round(sum(case  when DATEPART( yy , b.repay_date )-1911='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year1" ); 
		sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1912='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
		sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1912='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2)  as year2" ); 
		sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1913='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
		sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1913='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)) ,2) as year3 " );
		sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1914='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
        sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1914='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year4" ); 
		sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1915='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
		sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1915='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year5" ); 
		sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1916='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
     	sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1916='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year6" ); 
		sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1917='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
        sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1917='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year7" ); 
		sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1918='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
		sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1918='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year8" ); 
		sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1919='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
		sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1919='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year9" ); 
		sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1920='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
		sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1920='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year10" ); 
		sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1921='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
		sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1921='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year11" );
		sqljob.appendSQL(",round((sum(case when DATEPART( yy , b.repay_date )-1922 >= '"+year+"' and DATEPART( yy , b.repay_date )-1926 <= "+year+" and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
		sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1922 >= '"+year+"' and DATEPART( yy , b.repay_date )-1926 >= "+year+" and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year_5_1" ); 
		sqljob.appendSQL(",round((sum(case when DATEPART( yy , b.repay_date )-1927 >= '"+year+"' and DATEPART( yy , b.repay_date )-1931 <= "+year+" and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
		sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1927 >= '"+year+"' and DATEPART( yy , b.repay_date )-1931 >= "+year+" and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year_5_2" ); 
		sqljob.appendSQL(",round((sum(case when DATEPART( yy , b.repay_date )-1932 >= '"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
		sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1932 >= '"+year+"' and b.pay_amount >0 and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)) ,2) as year_5_3" ); 
		sqljob.appendSQL("from Other_plan_debt b" );
		sqljob.appendSQL("where year(b.issue_date) <= "+(Integer.parseInt(year)+1911)  );
		sqljob.appendSQL("group by (case " );
		sqljob.appendSQL("when (b.debt_code=42 ) then '戰機借款'" ); 
		sqljob.appendSQL("when (b.debt_code=35 ) then '省債'" ); 
		sqljob.appendSQL("else '' end)" );
		
		System.out.println("1"+sqljob);
		return sqljob;
	}
	public SQLJob selectSheet2(Gara3901Form form,String debtType)
	{
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		SQLJob sqljob = new SQLJob();
		//用於公債及中常期借款
		if(debtType.trim().equals("A") || debtType.trim().equals("C")){
			sqljob.appendSQL("select " );
			sqljob.appendSQL("(select code_name from code_det where kind_id=3 and code_no=debt_type) as debt_type," );
			sqljob.appendSQL("Debt_name," );
			sqljob.appendSQL("datediff(yy,issue_date,due_date) as date_period," );
			sqljob.appendSQL("right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) as issue_date," );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1911 when '"+year+"' then b.capital_amount else 0 end),2) as year1," ); 
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1912 when '"+year+"' then b.capital_amount else 0 end),2) as year2, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1913 when '"+year+"' then b.capital_amount else 0 end),2) as year3, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1914 when '"+year+"' then b.capital_amount else 0 end),2) as year4, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1915 when '"+year+"' then b.capital_amount else 0 end),2) as year5, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1916 when '"+year+"' then b.capital_amount else 0 end),2) as year6, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1917 when '"+year+"' then b.capital_amount else 0 end),2) as year7, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1918 when '"+year+"' then b.capital_amount else 0 end),2) as year8, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1919 when '"+year+"' then b.capital_amount else 0 end),2) as year9, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1920 when '"+year+"' then b.capital_amount else 0 end),2) as year10, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1921 when '"+year+"' then b.capital_amount else 0 end),2) as year11, " );
			sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1922 >= '"+year+"' and DATEPART( yy , b.repay_date )-1926 <= '"+year+"' then b.capital_amount else 0 end) ,2) as year_5_1," ); 
			sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1927 >= '"+year+"' and DATEPART( yy , b.repay_date )-1931 <= '"+year+"' then b.capital_amount else 0 end) ,2) as year_5_2," );
			//sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1928 >= '"+year+"' and DATEPART( yy , b.repay_date )-1932 <= '"+year+"' then b.capital_amount else 0 end) ,2) as year_5_2,　" ); 
			sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1932 >= '"+year+"' then b.capital_amount else 0 end) ,2) as year_5_3 " );
			sqljob.appendSQL("from issue_main a,debt_main c,Debt_plan_det b" );
			sqljob.appendSQL("where a.id = b.issue_id" );
			sqljob.appendSQL("and c.id = b.debt_id" );
			sqljob.appendSQL("and a.id = c.issue_id" );
			if(debtType.trim().equals("A"))
				sqljob.appendSQL("and a.debt_type='A' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '1'" ); 
			else
				sqljob.appendSQL("and a.debt_type='C'  and  isnull(delete_mark,'N')= 'N' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '2'" );
			sqljob.appendSQL("and  year(b.repay_date) >= "+(Integer.parseInt(year)+1911)  );
			sqljob.appendSQL("and isnull(report_flag,'0') = '0'" );
			sqljob.appendSQL("and a.issue_date <= '"+strLastDate+"'" );
			sqljob.appendSQL("group by issue_date,Debt_name,due_date,debt_type" );

		}else{
			//用於戰機借款及省債
			//戰機借款之債務別代碼為42,省債之債務別代碼為35
			sqljob.appendSQL("select " );
			sqljob.appendSQL("(select debit_name from debit_ref where  id="+(debtType.trim().equals("F")?"42":"35")+") as debt_type," );
			sqljob.appendSQL("Debt_name," );
			sqljob.appendSQL("years," );
			sqljob.appendSQL("right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) as issue_date," );
			sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1911 = '"+year+"' and b.capital_amount >0  then isnull(b.capital_amount,0) else 0 end),2) as year1," );              
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1912 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1912 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year2," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1913 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1913 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year3, " );
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1914 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1914 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year4," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1915 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1915 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year5," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1916 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1916 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year6," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1917 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1917 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year7," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1918 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1918 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year8," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1919 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1919 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year9," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1920= '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1920= '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year10," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1921 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1921 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year11," );
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1922 >= '"+year+"' and DATEPART( yy , b.repay_date )-1926 <= "+year+" and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1922 >= '"+year+"' and DATEPART( yy , b.repay_date )-1926 >= "+year+" and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year_5_1," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1927 >= '"+year+"' and DATEPART( yy , b.repay_date )-1931 <= "+year+" and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1927 >= '"+year+"' and DATEPART( yy , b.repay_date )-1931 >= "+year+" and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year_5_2," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1932 >= '"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1932 >= '"+year+"' and b.pay_amount >0 and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)) ,2) as year_5_3 from other_plan_debt b" );
			sqljob.appendSQL("where year(b.issue_date) <= "+(Integer.parseInt(year)+1911)  );
			//若輸入債務別為"戰機借款"則傳入債務別代碼42,若為"省債"則傳入債務別代碼35
			sqljob.appendSQL("and debt_code ="+ (debtType.trim().equals("F")?"42":"35"));
			sqljob.appendSQL("group by issue_date,Debt_name,years" );

		}
		System.out.println("2"+debtType+":"+sqljob);
		return sqljob;
	}
	public SQLJob selectSheet3(Gara3901Form form,String debtType)
	{
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		SQLJob sqljob = new SQLJob();
		if(debtType.trim().equals("A") || debtType.trim().equals("C")){
			sqljob.appendSQL("select " );
			sqljob.appendSQL("month(b.repay_date) as mon," );
			sqljob.appendSQL("round(sum(case  when DATEPART( yy , b.repay_date )-1911='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2)  as year1" ); 
			sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1912='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year2 " );
			sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1913='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year3 " );
			sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1914='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year4 " );
			sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1915='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year5 " );
			sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1916='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year6 " );
			sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1917='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year7 " );
			sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1918='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year8 " );
			sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1919='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year9 " );
			sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1920='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year10 " );
			sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1921='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year11 " );
			sqljob.appendSQL(",round(sum(case when DATEPART( yy , b.repay_date )-1922 >= '"+year+"' and DATEPART( yy , b.repay_date )-1926 <= "+year+" and b.capital_amount >0 then b.capital_amount else 0 end) ,2) as year_5_1," ); 
			sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1927 >= '"+year+"' and DATEPART( yy , b.repay_date )-1931 <= "+year+" and b.capital_amount >0 then b.capital_amount else 0 end) ,2) as year_5_2, " );
			sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1932 >= '"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end) ,2) as year_5_3 " );
			sqljob.appendSQL("from issue_main a,Debt_plan_det b,debt_main c" );
			sqljob.appendSQL("where a.id = b.issue_id" );
			sqljob.appendSQL("and b.debt_id = c.id" );
			sqljob.appendSQL("and isnull(report_flag,'0') = '0'" );
			sqljob.appendSQL("and isnull(b.delete_mark,'N') = 'N'" );
			sqljob.appendSQL("and a.issue_date <= '"+strLastDate+"'" );
			sqljob.appendSQL("and ( " );
			sqljob.appendSQL("(a.debt_type='A' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '1') or" ); 
			sqljob.appendSQL("(a.debt_type='C'  and  isnull(delete_mark,'N')= 'N' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '2')" ); 
			sqljob.appendSQL(") " );
			sqljob.appendSQL("group by month(b.repay_date)" );
			sqljob.appendSQL("order by month(b.repay_date)" );
		}else{
			sqljob.appendSQL("select " );
			sqljob.appendSQL("month(b.repay_date) as mon," );
			sqljob.appendSQL("round(sum(case  when DATEPART( yy , b.repay_date )-1911='"+year+"' and b.capital_amount >0 then b.capital_amount else 0 end),2) as year1" ); 
			sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1912='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1912='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2)  as year2" ); 
			sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1913='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1913='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)) ,2) as year3" ); 
			sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1914='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1914='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year4" ); 
			sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1915='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1915='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year5" ); 
			sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1916='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1916='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year6" ); 
			sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1917='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1917='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year7" ); 
			sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1918='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1918='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year8" ); 
			sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1919='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1919='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year9" ); 
			sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1920='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1920='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year10" ); 
			sqljob.appendSQL(",round((sum(case  when DATEPART( yy , b.repay_date )-1921='"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case  when DATEPART( yy , b.repay_date )-1921='"+year+"' and b.pay_amount >0 and pay_date <= '"+strLastDate+"' then isnull(pay_amount,0) else 0 end)),2) as year11" );
			sqljob.appendSQL(",round((sum(case when DATEPART( yy , b.repay_date )-1922 >= '"+year+"' and DATEPART( yy , b.repay_date )-1926 <= "+year+" and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1922 >= '"+year+"' and DATEPART( yy , b.repay_date )-1926 >= "+year+" and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year_5_1" ); 
			sqljob.appendSQL(",round((sum(case when DATEPART( yy , b.repay_date )-1927 >= '"+year+"' and DATEPART( yy , b.repay_date )-1931 <= "+year+" and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1927 >= '"+year+"' and DATEPART( yy , b.repay_date )-1931 >= "+year+" and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year_5_2" ); 
			sqljob.appendSQL(",round((sum(case when DATEPART( yy , b.repay_date )-1932 >= '"+year+"' and b.capital_amount >0 and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1932 >= '"+year+"' and b.pay_amount >0 and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)) ,2) as year_5_3" ); 
			sqljob.appendSQL("from Other_plan_debt b" );
			sqljob.appendSQL("where year(b.issue_date)  <= "+(Integer.parseInt(year)+1911)  );
			sqljob.appendSQL("group by month(b.repay_date)" );
		}
		System.out.println("3"+sqljob);
		return sqljob;
	}
	public SQLJob selectSheet4(Gara3901Form form,String debtType)
	{
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		SQLJob sqljob = new SQLJob();
		//用於公債及中長期借款的各月還本數
		if(debtType.trim().equals("A") || debtType.trim().equals("C")){

			sqljob.appendSQL("select " );
			sqljob.appendSQL("DATEPART( mm , b.repay_date ) as mon," ); 
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1911 when '"+year+"' then b.capital_amount else 0 end),2) as year1," ); 
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1912 when '"+year+"' then b.capital_amount else 0 end),2) as year2," ); 
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1913 when '"+year+"' then b.capital_amount else 0 end),2) as year3, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1914 when '"+year+"' then b.capital_amount else 0 end),2) as year4, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1915 when '"+year+"' then b.capital_amount else 0 end),2) as year5, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1916 when '"+year+"' then b.capital_amount else 0 end),2) as year6, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1917 when '"+year+"' then b.capital_amount else 0 end),2) as year7, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1918 when '"+year+"' then b.capital_amount else 0 end),2) as year8, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1919 when '"+year+"' then b.capital_amount else 0 end),2) as year9, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1920 when '"+year+"' then b.capital_amount else 0 end),2) as year10, " );
			sqljob.appendSQL("round(sum(case DATEPART( yy , b.repay_date )-1921 when '"+year+"' then b.capital_amount else 0 end),2) as year11 " );
			sqljob.appendSQL("from issue_main a,debt_main c,Debt_plan_det b" );
			sqljob.appendSQL("where a.id = b.issue_id" );
			sqljob.appendSQL("and c.id = b.debt_id" );
			sqljob.appendSQL("and a.id = c.issue_id" );
			//若輸入債務別為"公債",則用下列之條件
			if(debtType.trim().equals("A"))
				sqljob.appendSQL("and a.debt_type='A' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '1'" );
			else
			//若輸入債務別為"中長借",則用下列之條件
				sqljob.appendSQL("and a.debt_type='C'  and  isnull(delete_mark,'N')= 'N' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '2'" );
			sqljob.appendSQL("and  year(b.repay_date) >= "+(Integer.parseInt(year)+1911)  );
			sqljob.appendSQL("and isnull(report_flag,'0') = '0'" );
			sqljob.appendSQL("and a.issue_date <= '"+strLastDate+"'" );
			sqljob.appendSQL("group by DATEPART( mm , b.repay_date )" ); 
			sqljob.appendSQL("order by 1" );

		}else{
		//用於戰機借款及省債各月份預計還本數
		//戰機借款之債務別代碼為42,省債之債務別代碼為35

			sqljob.appendSQL("select " );
			sqljob.appendSQL("DATEPART( mm , b.repay_date ) as mon," ); 
			sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1911 = '"+year+"' and b.capital_amount >0  then isnull(b.capital_amount,0) else 0 end),2) as year1," );              
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1912 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1912 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year2," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1913 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1913 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year3," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1914 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1914 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year4," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1915 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1915 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year5," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1916 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1916 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year6," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1917 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1917 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year7," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1918 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1918 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year8," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1919 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1919 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year9," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1920= '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1920= '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year10," ); 
			sqljob.appendSQL("round((sum(case when DATEPART( yy , b.repay_date )-1921 = '"+year+"' and b.capital_amount >0  and b.repay_date >= '"+strLastDate+"' then isnull(b.capital_amount,0) else 0 end) -" );
			sqljob.appendSQL("sum(case when DATEPART( yy , b.repay_date )-1921 = '"+year+"' and b.pay_amount >0  and b.pay_date <= '"+strLastDate+"' then isnull(b.pay_amount,0) else 0 end)),2) as year11" );
			sqljob.appendSQL("from Other_plan_debt b " );
			sqljob.appendSQL("where year(b.issue_date) <= "+(Integer.parseInt(year)+1911)  );
			//若輸入債務別為"戰機借款"則傳入債務別代碼42,若為"省債"則傳入債務別代碼35" );
			sqljob.appendSQL("and debt_code ="+ (debtType.trim().equals("F")?"42":"35"));
			sqljob.appendSQL("group by DATEPART( mm , b.repay_date )" ); 
			sqljob.appendSQL("order by 1" );
		}
		System.out.println("4"+debtType+":"+sqljob);
		return sqljob;
	}
	public SQLJob selectSheet4(Gara3901Form form)
	{
		//第一段
		//找出各年度公債及中常期借款提前償還金額
		//於原程式SQL1查出公債及中常期借款各年度落點後,再減去此SQL所計算出來各年公債及中常期借款提前償還金額
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");

		//0951208
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select");
		sqljob.appendSQL("case");
		sqljob.appendSQL("when (a.debt_type='A' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '1') then '公債'");
		sqljob.appendSQL("when (a.debt_type='C' and c.debt_code<>'42' and c.debt_code<>'35' and isnull(delete_mark,'N')='N' and bond_type = '2') then '中長期借款'");
		sqljob.appendSQL("else '' end as debt_type,");
		sqljob.appendSQL("round(sum(case  when DATEPART( yy , b.repay_date )-1911='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year1");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1912='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year2");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1913='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year3");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1914='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year4");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1915='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year5");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1916='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year6");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1917='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year7");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1918='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year8");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1919='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year9");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1920='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year10");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1921='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year11");
		sqljob.appendSQL(",round(sum(case when DATEPART( yy , b.repay_date )-1923 >= '"+year+"' and DATEPART( yy , b.repay_date )-1927 <= "+year+" and d.capital_amount >0 then d.capital_amount else 0 end) ,2) as year_5_1,");
		sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1928 >= '"+year+"' and DATEPART( yy , b.repay_date )-1932 <= "+year+" and d.capital_amount >0 then d.capital_amount else 0 end) ,2) as year_5_2,");
		sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1933 >= '"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end) ,2) as year_5_3");
		sqljob.appendSQL("from issue_main a,Debt_plan_det b,debt_main c,payment_main d");
		sqljob.appendSQL("where a.id = b.issue_id");
		sqljob.appendSQL("and b.debt_id = c.id");
		sqljob.appendSQL("and a.id = d.issue_id");
		sqljob.appendSQL("and b.id = d.plan_id");
		sqljob.appendSQL("and c.id = d.debt_id");
		sqljob.appendSQL("and isnull(report_flag,'0') = '0'");
		sqljob.appendSQL("and isnull(b.delete_mark,'N') = 'N'");
		sqljob.appendSQL("and d.plan_repay_date > d.repay_date");
		sqljob.appendSQL("and a.issue_date <= '"+strLastDate+"'");

		sqljob.appendSQL("and (");
		sqljob.appendSQL("(a.debt_type='A' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '1') or");
		sqljob.appendSQL("(a.debt_type='C'  and  isnull(delete_mark,'N')= 'N' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '2')");
		sqljob.appendSQL(")");
		
		sqljob.appendSQL("group by (case");
		sqljob.appendSQL("when (a.debt_type='A' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '1') then '公債'");
		sqljob.appendSQL("when (a.debt_type='C' and c.debt_code<>'42' and c.debt_code<>'35' and isnull(delete_mark,'N')='N' and bond_type = '2') then '中長期借款'");
		sqljob.appendSQL("else '' end)");
		System.out.println("4"+sqljob);
		return sqljob;
	}
	public SQLJob selectSheet5(Gara3901Form form)
	{
		//--第二段
		//--找出各年度之各月份公債及中常期借款提前償還金額
		//--於原程式SQL3查出各年度之相對月份公債及中常期借款各年度落點後,再減去此SQL所計算出來各年之相對月份公債及中常期借款提前償還金額
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		SQLJob sqljob = new SQLJob();
		//用於公債及中常期借款
		
		sqljob.appendSQL("select");
		sqljob.appendSQL("month(b.repay_date) as mon,");
		sqljob.appendSQL("round(sum(case  when DATEPART( yy , b.repay_date )-1911='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2)  as year1");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1912='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year2");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1913='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year3");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1914='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year4");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1915='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year5");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1916='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year6");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1917='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year7");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1918='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year8");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1919='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year9");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1920='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year10");
		sqljob.appendSQL(",round(sum(case  when DATEPART( yy , b.repay_date )-1921='"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end),2) as year11");
		sqljob.appendSQL(",round(sum(case when DATEPART( yy , b.repay_date )-1922 >= '"+year+"' and DATEPART( yy , b.repay_date )-1926 >= "+year+" and d.capital_amount >0 then d.capital_amount else 0 end) ,2) as year_5_1,");
		sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1927 >= '"+year+"' and DATEPART( yy , b.repay_date )-1931 >= "+year+" and d.capital_amount >0 then d.capital_amount else 0 end) ,2) as year_5_2,");
		sqljob.appendSQL("round(sum(case when DATEPART( yy , b.repay_date )-1932 >= '"+year+"' and d.capital_amount >0 then d.capital_amount else 0 end) ,2) as year_5_3");
		sqljob.appendSQL("from issue_main a,Debt_plan_det b,debt_main c,payment_main d");
		sqljob.appendSQL("where a.id = b.issue_id");
		sqljob.appendSQL("and b.debt_id = c.id");
		sqljob.appendSQL("and a.id = d.issue_id");
		sqljob.appendSQL("and b.id = d.plan_id");
		sqljob.appendSQL("and c.id = d.debt_id");
		sqljob.appendSQL("and isnull(report_flag,'0') = '0'");
		sqljob.appendSQL("and isnull(b.delete_mark,'N') = 'N'");
		sqljob.appendSQL("and d.plan_repay_date > d.repay_date");
		sqljob.appendSQL("and a.issue_date <= '"+strLastDate+"'");

		sqljob.appendSQL("and (");
		sqljob.appendSQL("(a.debt_type='A' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '1') or");
		sqljob.appendSQL("(a.debt_type='C'  and  isnull(delete_mark,'N')= 'N' and c.debt_code<>'42' and c.debt_code<>'35' and bond_type = '2')");
		sqljob.appendSQL(")");
		sqljob.appendSQL("group by month(b.repay_date)");
		sqljob.appendSQL("order by month(b.repay_date)");
		System.out.println("5:"+sqljob);
		return sqljob;
	}
	public void insertSheet1(Connection connection, SQLRunner run, List list,String usrId) throws SQLException
	{
		for(Iterator it=list.iterator();it.hasNext();)
		{
			Map map = (Map) it.next();
			String	debtType	=	(String)	(map.get("debt_type")==null?"":map.get("debt_type"));
			BigDecimal	year1	=	(BigDecimal)	(map.get("year1")==null?new BigDecimal(0.0):map.get("year1"));
			BigDecimal	year2	=	(BigDecimal)	(map.get("year2")==null?new BigDecimal(0.0):map.get("year2"));
			BigDecimal	year3	=	(BigDecimal)	(map.get("year3")==null?new BigDecimal(0.0):map.get("year3"));
			BigDecimal	year4	=	(BigDecimal)	(map.get("year4")==null?new BigDecimal(0.0):map.get("year4"));
			BigDecimal	year5	=	(BigDecimal)	(map.get("year5")==null?new BigDecimal(0.0):map.get("year5"));
			BigDecimal	year6	=	(BigDecimal)	(map.get("year6")==null?new BigDecimal(0.0):map.get("year6"));
			BigDecimal	year7	=	(BigDecimal)	(map.get("year7")==null?new BigDecimal(0.0):map.get("year7"));
			BigDecimal	year8	=	(BigDecimal)	(map.get("year8")==null?new BigDecimal(0.0):map.get("year8"));
			BigDecimal	year9	=	(BigDecimal)	(map.get("year9")==null?new BigDecimal(0.0):map.get("year9"));
			BigDecimal	year10	=	(BigDecimal)	(map.get("year10")==null?new BigDecimal(0.0):map.get("year10"));
			BigDecimal	year11	=	(BigDecimal)	(map.get("year11")==null?new BigDecimal(0.0):map.get("year11"));
			BigDecimal	subTotal=	year1.add(year2).add(year3).add(year4).add(year5).add(year6).add(year7).add(year8).add(year9).add(year10).add(year11);
			BigDecimal	year_5_1=	(BigDecimal)	(map.get("year_5_1")==null?new BigDecimal(0.0):map.get("year_5_1"));
			BigDecimal	year_5_2=	(BigDecimal)	(map.get("year_5_2")==null?new BigDecimal(0.0):map.get("year_5_2"));
			BigDecimal	year_5_3=	(BigDecimal)	(map.get("year_5_3")==null?new BigDecimal(0.0):map.get("year_5_3"));
			BigDecimal	total	=	subTotal.add(year_5_1).add(year_5_2).add(year_5_3);

			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("INSERT INTO GARA39_RPT1 ");
			sqljob.appendSQL(" ( year1, year2, year3, year4, year5, ");
			sqljob.appendSQL(" year6, year7, year8, year9, year10, ");
			sqljob.appendSQL(" year11, SUBTOTAL, year_5_1, year_5_2, year_5_3, ");
			sqljob.appendSQL(" TOTAL, debt_type, USRID, MOD_DATE, REMARK ) ");
			sqljob.appendSQL(" VALUES ( ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,CURRENT_TIMESTAMP,'' ) ");
			sqljob.addParameter( year1 );
			sqljob.addParameter( year2 );
			sqljob.addParameter( year3 );
			sqljob.addParameter( year4 );
			sqljob.addParameter( year5 );
			sqljob.addParameter( year6 );
			sqljob.addParameter( year7 );
			sqljob.addParameter( year8 );
			sqljob.addParameter( year9 );
			sqljob.addParameter( year10 );
			sqljob.addParameter( year11 );
			sqljob.addParameter( subTotal );
			sqljob.addParameter( year_5_1 );
			sqljob.addParameter( year_5_2 );
			sqljob.addParameter( year_5_3 );
			sqljob.addParameter( total );
			sqljob.addParameter( debtType );
			sqljob.addParameter( usrId );
			System.out.println(sqljob);
			run.update(connection, sqljob );
		}
	}

	public void insertSheet2(Connection connection, SQLRunner run, List list,String usrId) throws SQLException
	{
		for(Iterator it=list.iterator();it.hasNext();)
		{
			Map map = (Map) it.next();
			String	debtType	=	(String)	(map.get("debt_type")==null?"":map.get("debt_type"));
			String	debtName	=	(String)	(map.get("debt_name")==null?"":map.get("debt_name"));
			Integer	datePeriod	=	(Integer)	(map.get("date_period")==null?(new Integer(0)):map.get("date_period"));
			String	issueDate	=	(String)	(map.get("issue_date")==null?"":map.get("issue_date"));
			BigDecimal	year1	=	(BigDecimal)	(map.get("year1")==null?new BigDecimal(0.0):map.get("year1"));
			BigDecimal	year2	=	(BigDecimal)	(map.get("year2")==null?new BigDecimal(0.0):map.get("year2"));
			BigDecimal	year3	=	(BigDecimal)	(map.get("year3")==null?new BigDecimal(0.0):map.get("year3"));
			BigDecimal	year4	=	(BigDecimal)	(map.get("year4")==null?new BigDecimal(0.0):map.get("year4"));
			BigDecimal	year5	=	(BigDecimal)	(map.get("year5")==null?new BigDecimal(0.0):map.get("year5"));
			BigDecimal	year6	=	(BigDecimal)	(map.get("year6")==null?new BigDecimal(0.0):map.get("year6"));
			BigDecimal	year7	=	(BigDecimal)	(map.get("year7")==null?new BigDecimal(0.0):map.get("year7"));
			BigDecimal	year8	=	(BigDecimal)	(map.get("year8")==null?new BigDecimal(0.0):map.get("year8"));
			BigDecimal	year9	=	(BigDecimal)	(map.get("year9")==null?new BigDecimal(0.0):map.get("year9"));
			BigDecimal	year10	=	(BigDecimal)	(map.get("year10")==null?new BigDecimal(0.0):map.get("year10"));
			BigDecimal	year11	=	(BigDecimal)	(map.get("year11")==null?new BigDecimal(0.0):map.get("year11"));
			BigDecimal	subTotal=	year1.add(year2).add(year3).add(year4).add(year5).add(year6).add(year7).add(year8).add(year9).add(year10).add(year11);
			BigDecimal	year_5_1=	(BigDecimal)	(map.get("year_5_1")==null?new BigDecimal(0.0):map.get("year_5_1"));
			BigDecimal	year_5_2=	(BigDecimal)	(map.get("year_5_2")==null?new BigDecimal(0.0):map.get("year_5_2"));
			BigDecimal	year_5_3=	(BigDecimal)	(map.get("year_5_3")==null?new BigDecimal(0.0):map.get("year_5_3"));
			BigDecimal	total	=	subTotal.add(year_5_1).add(year_5_2).add(year_5_3);

			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("INSERT INTO GARA39_RPT2 ");
			sqljob.appendSQL(" ( debt_type, DEBT_NAME, DATE_PERIOD, ISSUE_DATE, year1, year2, ");
			sqljob.appendSQL(" year3, year4, year5, year6, year7, ");
			sqljob.appendSQL(" year8, year9, year10, year11, SUBTOTAL, ");
			sqljob.appendSQL(" year_5_1, year_5_2, year_5_3, TOTAL, USRID, ");
			sqljob.appendSQL(" MOD_DATE, REMARK ) ");
			sqljob.appendSQL(" VALUES ( ?,?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,?,?,");
			sqljob.appendSQL(" CURRENT_TIMESTAMP,'' ) ");
			sqljob.addParameter( debtType );
			sqljob.addParameter( debtName );
			sqljob.addParameter( datePeriod );
			sqljob.addParameter( issueDate );
			sqljob.addParameter( year1 );
			sqljob.addParameter( year2 );
			sqljob.addParameter( year3 );
			sqljob.addParameter( year4 );
			sqljob.addParameter( year5 );
			sqljob.addParameter( year6 );
			sqljob.addParameter( year7 );
			sqljob.addParameter( year8 );
			sqljob.addParameter( year9 );
			sqljob.addParameter( year10 );
			sqljob.addParameter( year11 );
			sqljob.addParameter( subTotal );
			sqljob.addParameter( year_5_1 );
			sqljob.addParameter( year_5_2 );
			sqljob.addParameter( year_5_3 );
			sqljob.addParameter( total );
			sqljob.addParameter( usrId );
			System.out.println(sqljob);
			run.update(connection, sqljob );
		}
	}

	public void insertSheet3(Connection connection, SQLRunner run, List list,String usrId) throws SQLException
	{
		for(Iterator it=list.iterator();it.hasNext();)
		{
			Map map = (Map) it.next();
			Integer	mon	=	(Integer)	(map.get("mon")==null?(new Integer(0)):map.get("mon"));
			BigDecimal	year1	=	(BigDecimal)	(map.get("year1")==null?new BigDecimal(0.0):map.get("year1"));
			BigDecimal	year2	=	(BigDecimal)	(map.get("year2")==null?new BigDecimal(0.0):map.get("year2"));
			BigDecimal	year3	=	(BigDecimal)	(map.get("year3")==null?new BigDecimal(0.0):map.get("year3"));
			BigDecimal	year4	=	(BigDecimal)	(map.get("year4")==null?new BigDecimal(0.0):map.get("year4"));
			BigDecimal	year5	=	(BigDecimal)	(map.get("year5")==null?new BigDecimal(0.0):map.get("year5"));
			BigDecimal	year6	=	(BigDecimal)	(map.get("year6")==null?new BigDecimal(0.0):map.get("year6"));
			BigDecimal	year7	=	(BigDecimal)	(map.get("year7")==null?new BigDecimal(0.0):map.get("year7"));
			BigDecimal	year8	=	(BigDecimal)	(map.get("year8")==null?new BigDecimal(0.0):map.get("year8"));
			BigDecimal	year9	=	(BigDecimal)	(map.get("year9")==null?new BigDecimal(0.0):map.get("year9"));
			BigDecimal	year10	=	(BigDecimal)	(map.get("year10")==null?new BigDecimal(0.0):map.get("year10"));
			BigDecimal	year11	=	(BigDecimal)	(map.get("year11")==null?new BigDecimal(0.0):map.get("year11"));

			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("INSERT INTO GARA39_RPT3 ");
			sqljob.appendSQL(" ( mon, year1, year2, year3, year4, ");
			sqljob.appendSQL(" year5, year6, year7, year8, year9, ");
			sqljob.appendSQL(" year10, year11, USRID, MOD_DATE, REMARK ) ");
			sqljob.appendSQL(" VALUES ( ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,CURRENT_TIMESTAMP,'' ) ");
			sqljob.addParameter( mon );
			sqljob.addParameter( year1 );
			sqljob.addParameter( year2 );
			sqljob.addParameter( year3 );
			sqljob.addParameter( year4 );
			sqljob.addParameter( year5 );
			sqljob.addParameter( year6 );
			sqljob.addParameter( year7 );
			sqljob.addParameter( year8 );
			sqljob.addParameter( year9 );
			sqljob.addParameter( year10 );
			sqljob.addParameter( year11 );
			sqljob.addParameter( usrId );
			System.out.println(sqljob);
			run.update(connection, sqljob );
		}
	}

	public SQLJob getMaxDebtA(Gara3901Form form){
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		SQLJob job = new SQLJob();
		job.appendSQL("select A.debt_name,A.issue_date from issue_main A");
		job.appendSQL("where A.debt_type='A'");
		job.appendSQL("and A.issue_date = (select max(B.issue_date) from issue_main B");
		job.appendSQL("where B.debt_type='A' and B.issue_date <= '"+strLastDate+"')");
		return job;
	}
	public SQLJob getMaxDebtC(Gara3901Form form){
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		SQLJob job = new SQLJob();
		job.appendSQL("select A.debt_name,A.issue_date from issue_main A");
		job.appendSQL("where A.debt_type='C'");
		job.appendSQL("and A.issue_date = (select max(B.issue_date) from issue_main B");
		job.appendSQL("where B.debt_type='C' and B.issue_date <= '"+strLastDate+"')");
		return job;
	}
}
