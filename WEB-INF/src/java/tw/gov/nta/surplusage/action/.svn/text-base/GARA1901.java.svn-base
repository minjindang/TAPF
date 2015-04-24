package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara1901Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA1901 extends ExcelReportRemainAction 
{

	protected SQLJob SQL1(String year,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select Right('000'+convert(varchar(3),");  
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) as year1,");
		//公債發行數
		sqljob.appendSQL("sum(case when (kind = '1') and A.debt_type='A' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_A,");
		//公債還本數
		sqljob.appendSQL("sum(case when (kind = '2') and A.debt_type='A' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_A,");
		//國庫券發行數
		sqljob.appendSQL("sum(case when (kind = '3') and A.debt_type='B' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_B,");
		//國庫券還本數
		sqljob.appendSQL("sum(case when (kind = '4') and A.debt_type='B' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_B,");
		//中長借發行數
		sqljob.appendSQL("sum(case when (kind = '5') and A.debt_type='C' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_C,");
		//中長借還本數
		sqljob.appendSQL("sum(case when (kind = '6') and A.debt_type='C' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_C,");
		//短期借款發行數
		sqljob.appendSQL("sum(case when (kind = '7') and A.debt_type='D' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_D,");
		//短期借款還本數
		sqljob.appendSQL("sum(case when (kind = '8') and A.debt_type='D' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_D ");
		sqljob.appendSQL("from issue_main A,v_ReMain B ");
		sqljob.appendSQL("where A.issue_serial = B.issue_serial ");
		sqljob.appendSQL("and B.date1 <= '"+new Timestamp(new Date().getTime())+"' ");
		sqljob.appendSQL("and Right('000'+convert(varchar(3),");  
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) < " + year +" ");
		sqljob.appendSQL("group by Right('000'+convert(varchar(3),");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) ");
		sqljob.appendSQL("order by Right('000'+convert(varchar(3),");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) ");

		System.out.println("GARA1901-SQL1::"+sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL2(String year,String month,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select month(B.date1) as month1,");
		//公債發行數
		sqljob.appendSQL("sum(case when (kind = '1') and A.debt_type='A' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_A,");
		//公債還本數
		sqljob.appendSQL("sum(case when (kind = '2') and A.debt_type='A' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_A,");
		//公債付息
		sqljob.appendSQL("sum(case when (kind = '2') and A.debt_type='A' then isnull(B_total,0) else 0 end)/"+unit+" as interest_total_A,");
		//國庫券發行數
		sqljob.appendSQL("sum(case when (kind = '3') and A.debt_type='B' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_B,");
		//國庫券還本數
		sqljob.appendSQL("sum(case when (kind = '4') and A.debt_type='B' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_B,");
		//國庫券付息
		sqljob.appendSQL("sum(case when (kind = '4') and A.debt_type='B' then isnull(B_total,0) else 0 end)/"+unit+" as interest_total_B,");
		//中長借發行數
		sqljob.appendSQL("sum(case when (kind = '5') and A.debt_type='C' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_C,");
		//中長借還本數
		sqljob.appendSQL("sum(case when (kind = '6') and A.debt_type='C' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_C,");
		//中長借付息
		sqljob.appendSQL("sum(case when (kind = '6') and A.debt_type='C' then isnull(B_total,0) else 0 end)/"+unit+" as interest_total_C,");
		//短期借款發行數
		sqljob.appendSQL("sum(case when (kind = '7') and A.debt_type='D' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_D,");
		//短期借款還本數
		sqljob.appendSQL("sum(case when (kind = '8') and A.debt_type='D' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_D,");
		//短期借款付息
		sqljob.appendSQL("sum(case when (kind = '8') and A.debt_type='D' then isnull(B_total,0) else 0 end)/"+unit+" as interest_total_D ");
		sqljob.appendSQL("from issue_main A,v_ReMain B ");
		sqljob.appendSQL("where A.issue_serial = B.issue_serial ");
		sqljob.appendSQL("and B.date1 <= '"+new Timestamp(new Date().getTime())+"' ");
		sqljob.appendSQL("and month(B.date1) = " + month + " ");
		sqljob.appendSQL("and Right('000'+convert(varchar(3),");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1");
		sqljob.appendSQL("else  year(B.date1)end-1911),3) = " + year + " ");
		sqljob.appendSQL("group by month(B.date1) ");
		sqljob.appendSQL("order by month(B.date1) ");
		System.out.println("GARA1101-SQL2::"+sqljob.toString());
		return sqljob;
	}
	protected SQLJob SQLTotalA(String year,String month,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		String accountYM = year+month;
		Date queryLastDate = DateUtil.getLastDateOfMonth(DateUtil.str2Date(accountYM + "01"));
		String strLastDate = DateUtil.date2Str(queryLastDate);
		sqljob.appendSQL("select (");
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT) from debt_plan_det where (debt_ID IN (select A.id from debt_main A, issue_main B where (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=1) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)+");
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT) from debt_plan_det where (debt_ID IN (select A.id from debt_main A, issue_main B where (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code in (30,49,50,51,52)) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0) +");
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT) from debt_plan_det where (debt_ID IN (select A.id from debt_main A, issue_main B where (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code=27) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0) +");
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT) from debt_plan_det where (debt_ID IN (select A.id from debt_main A, issue_main B where (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code=42) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0) +");
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT) from debt_plan_det where (debt_ID IN (select A.id from debt_main A, issue_main B where (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code=28) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0) +");
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT) from debt_plan_det where (debt_ID IN (select A.id from debt_main A, issue_main B where (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code=29) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0) +");
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT) from debt_plan_det where (debt_ID IN (select A.id from debt_main A, issue_main B where (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code=23) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0) +");
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT) from debt_plan_det where (debt_ID IN (select A.id from debt_main A, issue_main B where (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=5) and (A.debt_code=36) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0) +");
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT) from debt_plan_det where (debt_ID IN (select A.id from debt_main A, issue_main B where (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=5) and (A.debt_code=36) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0) +");
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT) from debt_plan_det where (debt_ID IN (select A.id from debt_main A, issue_main B where (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=5) and (A.debt_code=0) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0) +");
		sqljob.appendSQL("isnull((select SUM(CAPITAL_AMOUNT) from debt_plan_det where (debt_ID IN (select A.id from debt_main A, issue_main B where (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=3) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)");
		sqljob.appendSQL(")/"+unit+" as  total");
		return sqljob;
	}
	protected SQLJob SQLTotalC(String year,String month,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		String accountYM = year+month;
		Date queryLastDate = DateUtil.getLastDateOfMonth(DateUtil.str2Date(accountYM + "01"));
		String strLastDate = DateUtil.date2Str(queryLastDate);
		sqljob.appendSQL("SELECT (");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id = B.id and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 1 ),0)                                     - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B, issue_main C where A.debt_id = B.id and B.issue_id = C.id and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 1),0)) +");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id = B.id and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code in (30,49,50,51,52) ),0) - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B, issue_main C where A.debt_id = B.id and B.issue_id = C.id and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code in (30,49,50,51,52) ),0))+");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id = B.id and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=27 ),0)                  - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B, issue_main C where A.debt_id = B.id and B.issue_id = C.id and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=27 ),0))+");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id = B.id and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.debt_code=42 ),0)                                        - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B, issue_main C where A.debt_id = B.id and B.issue_id = C.id and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.debt_code=42 ),0)) +");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id = B.id and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=28 ),0)                  - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B, issue_main C where A.debt_id = B.id and B.issue_id = C.id and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=28 ),0)) +");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id = B.id and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=29 ),0)                  - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B, issue_main C where A.debt_id = B.id and B.issue_id = C.id and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=29 ),0)) +");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id = B.id and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=23 ),0)                  - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B, issue_main C where A.debt_id = B.id and B.issue_id = C.id and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=23 ),0)) +");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id = B.id and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.debt_code=35 ),0)                                        - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B, issue_main C where A.debt_id = B.id and B.issue_id = C.id and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.debt_code=35 ),0)) +");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id = B.id and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=36 ),0)                  - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B, issue_main C where A.debt_id = B.id and B.issue_id = C.id and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=36 ),0)) +");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id = B.id and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=0 ),0)                   - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B, issue_main C where A.debt_id = B.id and B.issue_id = C.id and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=0 ),0)) +");
		sqljob.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from debt_main A,issue_main B where A.issue_id = B.id and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 3 ),0)                                     - isNull((select sum(A.CAPITAL_AMOUNT) from payment_main A,debt_main B, issue_main C where A.debt_id = B.id and B.issue_id = C.id and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 3 ),0))");
		sqljob.appendSQL(")/"+unit+" as  total");
		return sqljob;
	}
	
	protected SQLJob SQLOtherRemainAmount(String year,String month,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		String accountYM = year+month;
		Date qryFirstDate = DateUtil.str2Date(accountYM + "01");
		sqljob.appendSQL("select isNull(sum(isnull(capital_amount,0)-isnull(pay_amount,0))/"+unit+",0) as other_remain");
		sqljob.appendSQL("from other_plan_debt");
		sqljob.appendSQL("where repay_date >= '"+new Timestamp(qryFirstDate.getTime())+"'");
		return sqljob;
	}
	
	protected SQLJob SQLOtherCapitalAmount(String year,String month,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		String accountYM = year+month;
		Date qryFirstDate = DateUtil.str2Date(accountYM + "01");
		Date qryLastDate = DateUtil.getLastDateOfMonth(DateUtil.str2Date(accountYM + "01"));
		sqljob.appendSQL("select isNull(sum(pay_amount)/"+unit+",0) as other_capital");
		sqljob.appendSQL("from other_plan_debt ");
		sqljob.appendSQL("where  pay_date between ? and ? ");
		sqljob.addParameter(qryFirstDate);
		sqljob.addParameter(qryLastDate);
		return sqljob;
	}
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, 
			Connection connection) throws Exception 
	{
		Gara1901Form myForm = (Gara1901Form) form;
		String accountYear = myForm.getAccountYear();
		String accountMonth = myForm.getAccountMonth();
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA19_RPT",usrId));
		//執行 insert
		
		//計算未償餘額
		List queryList1 = (List) run.query(SQL1(String.valueOf(accountYear),unit), new MapListHandler());
		Map countMap = null;
		BigDecimal lastYearNoPay_A = new BigDecimal(0);
		BigDecimal lastYearNoPay_B = new BigDecimal(0);
		BigDecimal lastYearNoPay_C = new BigDecimal(0);
		BigDecimal lastYearNoPay_D = new BigDecimal(0);
		//歷年
		for (Iterator it1=queryList1.iterator(); it1.hasNext();){
			countMap = (Map)it1.next();
			lastYearNoPay_A = lastYearNoPay_A.add((BigDecimal)countMap.get("issue_total_A")).subtract((BigDecimal)countMap.get("capital_total_A"));
			lastYearNoPay_B = lastYearNoPay_B.add((BigDecimal)countMap.get("issue_total_B")).subtract((BigDecimal)countMap.get("capital_total_B"));
			lastYearNoPay_C = lastYearNoPay_C.add((BigDecimal)countMap.get("issue_total_C")).subtract((BigDecimal)countMap.get("capital_total_C"));
			lastYearNoPay_D = lastYearNoPay_D.add((BigDecimal)countMap.get("issue_total_D")).subtract((BigDecimal)countMap.get("capital_total_D"));
		}
		
		
		//當年月份	
		String month[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		for (int i=0 ; i < month.length ; i++){
			if (Integer.parseInt(accountMonth) >= Integer.parseInt(month[i])){
				countMap = (Map) run.query(SQL2(accountYear,month[i],unit), new MapHandler());
				lastYearNoPay_A = lastYearNoPay_A.add((BigDecimal)countMap.get("issue_total_A")).subtract((BigDecimal)countMap.get("capital_total_A"));
				lastYearNoPay_B = lastYearNoPay_B.add((BigDecimal)countMap.get("issue_total_B")).subtract((BigDecimal)countMap.get("capital_total_B"));
				lastYearNoPay_C = lastYearNoPay_C.add((BigDecimal)countMap.get("issue_total_C")).subtract((BigDecimal)countMap.get("capital_total_C"));
				lastYearNoPay_D = lastYearNoPay_D.add((BigDecimal)countMap.get("issue_total_D")).subtract((BigDecimal)countMap.get("capital_total_D"));
			}
		}

		Map dMap = new HashMap();
		Map tempMapA = (Map)((List) run.query(SQLTotalA(accountYear,accountMonth,unit), new MapListHandler())).get(0);
		BigDecimal tempA = (BigDecimal)tempMapA.get("total");
		Map tempMapC = (Map)((List) run.query(SQLTotalC(accountYear,accountMonth,unit), new MapListHandler())).get(0);
		BigDecimal tempC = (BigDecimal)tempMapC.get("total");
		
		//======================================================================
		Map otherRemainMap = (Map)((List) run.query(SQLOtherRemainAmount(accountYear,accountMonth,unit), new MapListHandler())).get(0);
		BigDecimal otherRemain = (BigDecimal)otherRemainMap.get("other_remain");
		Map otherCapitalMap = (Map)((List) run.query(SQLOtherCapitalAmount(accountYear,accountMonth,unit), new MapListHandler())).get(0);
		BigDecimal otherCapital = (BigDecimal)otherCapitalMap.get("other_capital");
		
		dMap.putAll(getCommonMap(usrId));
		dMap.put("Aamount",tempA);
		dMap.put("Camount",tempC.add(otherRemain));
		dMap.put("Bamount",lastYearNoPay_B);
		dMap.put("Damount",lastYearNoPay_D);
		run.update(connection,insTemp("GARA19_RPT",dMap));
		
		String [] amountKind = {"issue_total","capital_total","interest_total"};
		for (int i=0 ; i < amountKind.length ; i++){
			dMap.putAll(getCommonMap(usrId));
			dMap.put("Aamount",countMap.get(amountKind[i]+"_A"));
			if(amountKind[i].equals("capital_total")){
				dMap.put("Camount",otherCapital.add((BigDecimal)countMap.get(amountKind[i]+"_C")));
			}else{
				dMap.put("Camount",countMap.get(amountKind[i]+"_C"));
			}
			dMap.put("Bamount",countMap.get(amountKind[i]+"_B"));
			dMap.put("Damount",countMap.get(amountKind[i]+"_D"));
			run.update(connection,insTemp("GARA19_RPT",dMap));
			dMap = new HashMap();
		}
	}
}
