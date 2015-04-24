package tw.gov.nta.account.action;

import gov.dnt.tame.common.CheckNullValue;
import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.account.form.AccountQueryForm;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EARD0102 extends DefaultAction {
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARD01_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
		
	protected SQLJob mainsql(AccountQueryForm myform,String queryDate){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("");
		sqljob.appendSQL("select isnull(sum(case b.account_type when 'D' then b.account_amount else 0 end),0) As debit_amount,");
		sqljob.appendSQL("isnull(sum(case b.account_type when 'C' then b.account_amount else 0 end),0) As credit_amount");
		sqljob.appendSQL("from voucher_main a,voucher_det b,issue_main c");
		sqljob.appendSQL("where a.id = b.voucher_id");
		sqljob.appendSQL("  and a.issue_id = c.id");
		sqljob.appendSQL("  and b.account_code = "+myform.getAccountId());
		if(myform.getIssueId() != 0) {
			sqljob.appendSQL(" and a.issue_id = "+myform.getIssueId());
		}else if(myform.getIssueYear() != null && !("".equals(myform.getIssueYear()))){
			sqljob.appendSQL(" and c.account_year='"+myform.getIssueYear()+"'");
		}
		sqljob.appendSQL(" and a.voucher_date <='"+queryDate+"' ");
		sqljob.appendSQL(" and a.debt_type_id = "+myform.getDebtType().getId());
		
		if(!"3".equals(myform.getIssueKind()))
			sqljob.appendSQL(" and a.issue_kind = " + myform.getIssueKind());//發行狀態1債票0登錄
		
		System.out.println(sqljob.toString());	
		return sqljob;
	}
	

	protected SQLJob insertJob(AccountQueryForm myform,Map queryResult,String usrId,BigDecimal balanceAmount){
		BigDecimal debitAmount  = CheckNullValue.checkNullPasueZero(queryResult.get("debit_amount"))   ;
		BigDecimal creditAmount = CheckNullValue.checkNullPasueZero(queryResult.get("credit_amount"))  ;
		String balanceType = "";
		
		balanceAmount = balanceAmount.add(debitAmount.subtract(creditAmount).setScale(0,4));
		
		if(balanceAmount.compareTo(new BigDecimal(0)) > 0) {
			balanceType = "借";
		}else if(balanceAmount.compareTo(new BigDecimal(0)) < 0) {
			balanceType = "貸";
		}
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO EARD01_RPT");
		sqljob.appendSQL("(year_no,month_no,account_name,debit_amount,credit_amount,balance_type,balance_amount,usrid) ");
		sqljob.appendSQL("VALUES (?,?,?,?,?,?,?,?)");
		sqljob.addParameter((String)queryResult.get("year_no"));
		sqljob.addParameter((String)queryResult.get("month_no"));
		sqljob.addParameter((String)queryResult.get("account_name"));
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
		//----
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(myForm,usrId));
		//第一筆
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.str2Date(myForm.getLastDate()));
		calendar.set(Calendar.DATE,1);
		calendar.add(Calendar.DATE,-1);
		
		int startYear = Integer.parseInt(myForm.getStartDate().substring(0,3));
		int endYear = Integer.parseInt(myForm.getEndDate().substring(0,3));
		int startMonth = Integer.parseInt(myForm.getStartDate().substring(3,5));
		int endMonth = Integer.parseInt(myForm.getEndDate().substring(3,5));
		String findDate = "";
		if(12 == endMonth){
			if(endYear<100)
				findDate = "0"+(endYear+1)+"01";
			else
				findDate = (endYear+1)+"01";
		}else{
			if(endYear<100 && (endMonth+1)<10)
				findDate = "0"+endYear+"0"+(endMonth+1);
			else if(endYear<100)
				findDate = "0"+endYear+(endMonth+1);
			else if((endMonth+1)<10)
				findDate = endYear+"0"+(endMonth+1);
			else
				findDate = String.valueOf(endYear)+String.valueOf(endMonth+1);
		}
		
		int monthInt = startMonth;
		while(startYear<=endYear)
		{
			String year = "";
			if(startYear<100)
				year = "0"+startYear;
			else
				year = String.valueOf(startYear);
			String month = "";
			if(monthInt<10)
				month = "0"+monthInt;
			else
				month = String.valueOf(monthInt);
			if(!findDate.equals(year+month))
			{
				String newData = DateUtil.getLastDateOfMonth(year,month);
				//第一筆
				calendar = Calendar.getInstance();
				calendar.setTime(DateUtil.str2Date(newData));
				calendar.set(Calendar.DATE,1);
				calendar.add(Calendar.DATE,-1);
				SQLJob queryJob1 = mainsql(myForm,DateUtil.date2Str(calendar.getTime(),"yyyy/MM/dd"));
				Map<String,Object> queryResult = (Map<String,Object>) run.query(queryJob1, new MapHandler());
				
				BigDecimal balanceAmount = new BigDecimal(0);
				queryResult.put("account_name","截至上月底止累計");
				queryResult.put("year_no","");
				queryResult.put("month_no","");
				run.update(connection,insertJob(myForm,queryResult,usrId,balanceAmount));	
				
				BigDecimal lastMonthDebitAmount  = (BigDecimal)queryResult.get("debit_amount")   ;
				BigDecimal lastMonthCreditAmount = (BigDecimal)queryResult.get("credit_amount")  ;	
				
				SQLJob queryJob2 = mainsql(myForm,DateUtil.date2Str(DateUtil.str2Date(newData),"yyyy/MM/dd"));
				Map<String,Object> queryResult2 = (Map<String,Object>) run.query(queryJob2, new MapHandler());
				queryResult2.put("account_name","截至"+newData.substring(0,3)+"年"+newData.substring(3,5)+"月止累計");
				queryResult2.put("year_no","");
				queryResult2.put("month_no","");		
				BigDecimal MonthDebitAmount = (BigDecimal)queryResult2.get("debit_amount");
				BigDecimal MonthCreditAmount = (BigDecimal)queryResult2.get("credit_amount");
				
				Map<String,Object> queryResult3 = new HashMap<String,Object>();
				queryResult3.put("debit_amount",MonthDebitAmount.subtract(lastMonthDebitAmount));
				queryResult3.put("credit_amount",MonthCreditAmount.subtract(lastMonthCreditAmount));
				queryResult3.put("account_name","本月合計");
				queryResult3.put("year_no",newData.substring(0,3));
				queryResult3.put("month_no",newData.substring(3,5));
				run.update(connection,insertJob(myForm,queryResult3,usrId,balanceAmount));			
				
				run.update(connection,insertJob(myForm,queryResult2,usrId,balanceAmount));	
			}else{
				break;
			}
			monthInt++;
			if(monthInt > 12)
			{
				startYear++;
				monthInt = 1;
			}
		}
		
//		SQLJob queryJob1 = mainsql(myForm,DateUtil.date2Str(calendar.getTime(),"yyyy/MM/dd"));
//		Map<String,Object> queryResult = (Map<String,Object>) run.query(queryJob1, new MapHandler());
//		
//		BigDecimal balanceAmount = new BigDecimal(0);
//		queryResult.put("account_name","截至上月底止累計");
//		queryResult.put("year_no","");
//		queryResult.put("month_no","");
//		run.update(connection,insertJob(myForm,queryResult,usrId,balanceAmount));	
//		
//		BigDecimal lastMonthDebitAmount  = (BigDecimal)queryResult.get("debit_amount")   ;
//		BigDecimal lastMonthCreditAmount = (BigDecimal)queryResult.get("credit_amount")  ;	
//		
//		SQLJob queryJob2 = mainsql(myForm,myForm.getSQLLastDate());
//		Map<String,Object> queryResult2 = (Map<String,Object>) run.query(queryJob2, new MapHandler());
//		queryResult2.put("account_name","截至"+myForm.getAccountYear()+"年"+myForm.getMonth()+"月止累計");
//		queryResult2.put("year_no","");
//		queryResult2.put("month_no","");		
//		BigDecimal MonthDebitAmount = (BigDecimal)queryResult2.get("debit_amount");
//		BigDecimal MonthCreditAmount = (BigDecimal)queryResult2.get("credit_amount");
//		
//		Map<String,Object> queryResult3 = new HashMap<String,Object>();
//		queryResult3.put("debit_amount",MonthDebitAmount.subtract(lastMonthDebitAmount));
//		queryResult3.put("credit_amount",MonthCreditAmount.subtract(lastMonthCreditAmount));
//		queryResult3.put("account_name","本月合計");
//		queryResult3.put("year_no",myForm.getAccountYear());
//		queryResult3.put("month_no",myForm.getMonth());
//		run.update(connection,insertJob(myForm,queryResult3,usrId,balanceAmount));			
//		
//		run.update(connection,insertJob(myForm,queryResult2,usrId,balanceAmount));	
		//		System.out.println("mapQry1.get(year_no) ："+queryResult.get("year_no")+"mapQry1.get(month_no)："+queryResult.get("month_no")+"mapQry1.get(account_name)："+mapQry1.get("account_name")+"debitAmount："+debitAmount+"creditAmount："+creditAmount+"blanceType："+blanceType+"blanceAmount："+blanceAmount+"usrId："+usrId);
		
	
		
		 
	}
}

