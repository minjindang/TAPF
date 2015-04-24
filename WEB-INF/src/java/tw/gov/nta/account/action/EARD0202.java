package tw.gov.nta.account.action;

import gov.dnt.tame.common.CheckNullValue;
import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
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

public class EARD0202 extends DefaultAction {
	
	/*
	 *SELECT  d.debt_name As debt_name,
        e.budget_name,
		f.debit_name,
        a.account_name As account_name,
		SUM(c.account_amount) AS account_total,
		c.account_type
FROM    account_ref a,voucher_main b,voucher_det c,issue_main d,budget_ref e,debit_ref f
WHERE   c.account_code = a.id 
  AND   b.id = c.voucher_id
  AND   d.id = b.issue_id
  AND   d.budget_code = e.id
  AND   d.debt_code = f.id 
  AND  (b.voucher_date <= [查詢日期])
  AND  (b.issue_id = [發行id])  INT
  AND  (b.voucher_type = [傳票類別])  INT
GROUP BY  d.debt_name,a.account_name,e.budget_name,f.debit_name

	*/
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARD02_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
/*
 * //查詢日期 = 會計年度 + 月份 + 該月份第一天
select sum(case b.account_type when 'D' then b.account_amount else 0 end ) As debit_amount,
	   sum(case b.account_type when 'C' then b.account_amount else 0 end ) As credit_amount
  from voucher_main a,voucher_det b
 where a.id = b.voucher_id
   and a.issue_id = [債務名稱]
   and a.post_date is not null
   and b.account_code = [會計科目]
   and a.voucher_date < [查詢日期]
  */
	protected SQLJob firstsql(Integer issudId,Integer accountCode,String voucherDatef){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("");
		sqljob.appendSQL("select sum(case b.account_type when 'D' then b.account_amount else 0 end ) As debit_amount,");
		sqljob.appendSQL("sum(case b.account_type when 'C' then b.account_amount else 0 end ) As credit_amount");
		sqljob.appendSQL("from voucher_main a,voucher_det b");
		sqljob.appendSQL("where a.id = b.voucher_id");
		sqljob.appendSQL("and a.issue_id = "+issudId+"");
		sqljob.appendSQL("and a.post_date is not null");
		sqljob.appendSQL("and b.account_code = "+accountCode+"");
		sqljob.appendSQL(" and a.voucher_date < '"+voucherDatef+"'");
		System.out.println(sqljob.toString());	
		return sqljob;
	}
/*
 * //查詢日期 = 會計年度 + 月份 + 該月份最後一天

select e.account_year,
	   e.serial_no,
	   e.debt_name,
       Year(a.voucher_date) - 1911 As year,
       Month(a.voucher_date) As month,
	   Day(a.voucher_date) As day,
	   a.voucher_no,
	   d.phase_name,
	   c.account_name,
	   case b.account_type when 'D' then b.account_amount else 0 end As debit_amount,
	   case b.account_type when 'C' then b.account_amount else 0 end As credit_amount
  from voucher_main a,voucher_det b,account_ref c,account_phase_main d,issue_main e
 where a.id = b.voucher_id 
   and b.account_code = c.id
   and a.phase_id = d.id
  and a.issue_id = e.id
   and a.post_date is not null
   and a.issue_id = [債務名稱]
   and b.account_code = [會計科目]
   and a.voucher_date <=[查詢日期];
 
 */
	
	
	protected SQLJob mainsql(String voucherDatel,String voucherDate2,Integer issueId,Integer accountCode){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("");
		sqljob.appendSQL("select e.account_year,e.serial_no,e.debt_name,");
		sqljob.appendSQL("Year(a.voucher_date) - 1911 As accyear,");
		sqljob.appendSQL("Month(a.voucher_date) As accmonth,");
		sqljob.appendSQL("Day(a.voucher_date) As accday,");
		sqljob.appendSQL("a.voucher_no,");
		sqljob.appendSQL("a.remark,");
		sqljob.appendSQL("c.account_name,");
		sqljob.appendSQL("case b.account_type when 'D' then b.account_amount else 0 end As debit_amount,");
		sqljob.appendSQL("case b.account_type when 'C' then b.account_amount else 0 end As credit_amount");
		sqljob.appendSQL("from voucher_main a,voucher_det b,account_ref c,issue_main e");
		sqljob.appendSQL(" where a.id = b.voucher_id ");
		sqljob.appendSQL("and b.account_code = c.id");
		sqljob.appendSQL("and a.issue_id = e.id");
		sqljob.appendSQL("and a.post_date is not null");
		sqljob.appendSQL("and a.issue_id = "+issueId+" ");
		sqljob.appendSQL("and b.account_code = "+accountCode+"");
		sqljob.appendSQL("and a.voucher_date <= '"+voucherDatel+"' and a.voucher_date >= dateadd(dd,1,'"+voucherDate2+"')");
		System.out.println(sqljob.toString());	
		return sqljob;
	}
	

	protected SQLJob insertJob(Object accyear,  Object accmonth ,Object accday,     
			                   Object voucherNo, Object phaseName,Object debitAmount,
			                   Object creditAmount,String  balanceType,BigDecimal balanceAmount,String usrId
			                   ){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO EARD02_RPT");
		sqljob.appendSQL("(accyear,accmonth,accday,voucher_no,phase_name,debit_amount,credit_amount,balance_type,balance_amount,usrid) ");
		sqljob.appendSQL("VALUES (?,?,?,?,?,?,?,?,?,?)");
		sqljob.addParameter(accyear);
		sqljob.addParameter(accmonth);
		sqljob.addParameter(accday);
		sqljob.addParameter(voucherNo);
		sqljob.addParameter(phaseName==null?"":phaseName);
		sqljob.addParameter(debitAmount);
		sqljob.addParameter(creditAmount);
		sqljob.addParameter(balanceType);
		sqljob.addParameter(balanceAmount.abs());
		sqljob.addParameter(usrId);
		System.out.println(sqljob.toString());
		return sqljob;
	}
	

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		AccountQueryForm myForm = (AccountQueryForm) form;
		String usrId = this.getUserId(request);
        // 查詢條件區
		String voucherDatel = myForm.getSQLLastDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.str2Date(myForm.getLastDate()));
		calendar.set(Calendar.DATE,1);
		calendar.add(Calendar.DATE,-1);
		
        Integer accountCode = myForm.getAccountId();
        Integer issueId = CheckNullValue.checkNullPasueZero(myForm.getIssueId());		

		//----
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(myForm,usrId));
	    //計算變數
		BigDecimal debitAmount = new BigDecimal(0);
		BigDecimal balanceAmount = new BigDecimal(0);
		BigDecimal creditAmount = new BigDecimal(0);
		
		BigDecimal LastDebitAmount = new BigDecimal(0);
		BigDecimal LastCreditAmount = new BigDecimal(0);
		//第一筆
		String voucherDate2 = DateUtil.date2Str(calendar.getTime(),"yyyy/MM/dd");
		SQLJob queryJob1 = firstsql(issueId,accountCode,voucherDate2);
		List queryList1 = (List) run.query(queryJob1, new MapListHandler());
		Iterator it1 = queryList1.iterator();
		Map mapQry1 = (Map) it1.next();
		if (mapQry1 != null){
			String balanceType = "";
			LastDebitAmount  = CheckNullValue.checkNullPasueZero(mapQry1.get("debit_amount"));
			LastCreditAmount = CheckNullValue.checkNullPasueZero(mapQry1.get("credit_amount"));
			balanceAmount = balanceAmount.add(LastDebitAmount.subtract(LastCreditAmount)).setScale(0,4);

			if(balanceAmount.compareTo(new BigDecimal(0)) > 0) {
				balanceType = "借";
			}else if(balanceAmount.compareTo(new BigDecimal(0)) < 0) {
				balanceType = "貸";
			}
			run.update(connection,insertJob("","","","","月初餘額",LastDebitAmount,LastCreditAmount,balanceType,balanceAmount.abs(),usrId));
		}
		//明細
		debitAmount = new BigDecimal(0);
		creditAmount = new BigDecimal(0);
		BigDecimal monthBalanceAmount = new BigDecimal(0);
		BigDecimal monthDebitAmount = new BigDecimal(0);
		BigDecimal monthCreditAmount = new BigDecimal(0);
		//---
		SQLJob queryJob2 = mainsql(voucherDatel,voucherDate2,issueId,accountCode);
		List queryList2 = (List) run.query(queryJob2, new MapListHandler());
		for(Iterator it2=queryList2.iterator();it2.hasNext();){
	    	Map mapQry2 = (Map) it2.next();
	    	String balanceType = "";
			if (mapQry2 != null){
 				debitAmount  = CheckNullValue.checkNullPasueZero(mapQry2.get("debit_amount"))   ;
 				creditAmount = CheckNullValue.checkNullPasueZero(mapQry2.get("credit_amount"))  ;
 				monthDebitAmount = monthDebitAmount.add(debitAmount);
 				monthCreditAmount = monthCreditAmount.add(creditAmount);
 				balanceAmount = balanceAmount.add((debitAmount.subtract(creditAmount)).setScale(0,4));
 				monthBalanceAmount = monthBalanceAmount.add((debitAmount.subtract(creditAmount)).setScale(0,4));
 				
				if(balanceAmount.compareTo(new BigDecimal(0)) > 0) {
					balanceType = "借";
				}else if(balanceAmount.compareTo(new BigDecimal(0)) < 0) {
					balanceType = "貸";
				}				
				run.update(connection,insertJob(mapQry2.get("accyear"),mapQry2.get("accmonth"),mapQry2.get("accday"),
						   mapQry2.get("voucher_no"),mapQry2.get("remark"),debitAmount,creditAmount,balanceType,balanceAmount.abs(),usrId));
			}
		}	
		
		String balanceType = "";
		
		if(monthBalanceAmount.compareTo(new BigDecimal(0)) > 0) {
			balanceType = "借";
		}else if(monthBalanceAmount.compareTo(new BigDecimal(0)) < 0) {
			balanceType = "貸";
		}
	
		run.update(connection,insertJob("","","","","本月合計",monthDebitAmount,monthCreditAmount,balanceType,monthBalanceAmount.abs(),usrId));
		
		balanceType = "";
		if(balanceAmount.compareTo(new BigDecimal(0)) > 0) {
			balanceType = "借";
			debitAmount = balanceAmount;
		}else if(balanceAmount.compareTo(new BigDecimal(0)) < 0) {
			balanceType = "貸";
			creditAmount = balanceAmount.abs();
		}
	
		run.update(connection,insertJob("","","","","截至本月底累計",LastDebitAmount.add(monthDebitAmount),LastCreditAmount.add(monthCreditAmount),balanceType,balanceAmount.abs(),usrId));
	}
}

