package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.shortterm.form.Dira1401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class DIRA1402 extends ExcelReportBaseAction {

	private final static String TEMP_TABLE_NAME = "DIRA14_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM DIRA14_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	//年度簽約銀行&最高金額
	protected SQLJob SQLyearBank(String contractYear){
		SQLJob sqljob = new SQLJob();
		//bank_name：簽約銀行名稱；contract_amount：最高簽約金額
		sqljob.appendSQL("select * from contract_bank_main con, bank_ref bank ");
		sqljob.appendSQL("where con.bank_id = bank.id ");
		sqljob.appendSQL("and con.contract_year = '"+contractYear+"'");
		sqljob.appendSQL("order by con.contract_year desc ,bank.bank_code ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	//相同銀行在不同年度下的最高金額
	protected SQLJob SQLyearBank(String contractYear,Integer bankId){
		SQLJob sqljob = new SQLJob();
		//bank_name：簽約銀行名稱；contract_amount：最高簽約金額
		sqljob.appendSQL("select * from contract_bank_main con, bank_ref bank ");
		sqljob.appendSQL("where con.bank_id = bank.id ");
		sqljob.appendSQL("and con.contract_year = '"+contractYear+"'");
		sqljob.appendSQL("and con.bank_id = '"+bankId+"'");
		sqljob.appendSQL("order by con.contract_year desc ,bank.bank_code ");
		System.out.println(sqljob.toString());
		return sqljob;		
	}
	//查尋下一個會計年度中，還未統計的銀行&金額
	protected SQLJob SQLyearBankNext(String contractYear){
		SQLJob sqljob = new SQLJob();
		//bank_name：簽約銀行名稱；contract_amount：最高簽約金額
		sqljob.appendSQL("select * from contract_bank_main con, bank_ref bank ");
		sqljob.appendSQL("where con.bank_id = bank.id ");
		sqljob.appendSQL("and con.contract_year = '"+contractYear+"'");
		sqljob.appendSQL("and con.bank_id not in (select bank_id from DIRA14_RPT ) ");
		sqljob.appendSQL("order by con.contract_year desc ,bank.bank_code ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	//另訂新約銀行
	protected SQLJob SQLseparatelyBank(){
		SQLJob sqljob = new SQLJob();
		//bank_code：銀行代號
		sqljob.appendSQL("select  * from bank_ref ");
		sqljob.appendSQL("where id in ( ");
		sqljob.appendSQL("select debt.bank_id ");
		sqljob.appendSQL("from debt_main debt, issue_main issue ");
		sqljob.appendSQL("where debt.issue_id = issue.id ");
		sqljob.appendSQL("and issue.debt_type = 'D' ");
		sqljob.appendSQL("and debt.budget_year = 'Y') ");
		sqljob.appendSQL("and id not in (select bank_id from DIRA14_RPT) ");
		sqljob.appendSQL("order by bank_code ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	//非另訂新約銀行最高金額
	protected SQLJob SQLyearAmount(String accountYear, String bankCode){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select debt.* ");
		sqljob.appendSQL("from debt_main debt, issue_main issue ");
		sqljob.appendSQL("where debt.issue_id = issue.id ");
		sqljob.appendSQL("and issue.debt_type = 'D' ");
		sqljob.appendSQL("and issue.account_year = '" + accountYear + "'");
		sqljob.appendSQL("and debt.accrue = 'Y' ");
		sqljob.appendSQL("and debt.bank_id in (select bank.id from bank_ref bank where bank.bank_code = '"+bankCode+"') ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	//另訂新約銀行最高金額
	protected SQLJob SQLseparatelyAmount(String accountYear, String bankCode){
		SQLJob sqljob = new SQLJob();

		sqljob.appendSQL("select debt.* ");
		sqljob.appendSQL("from debt_main debt, issue_main issue ");
		sqljob.appendSQL("where debt.issue_id = issue.id ");
		sqljob.appendSQL("and issue.debt_type = 'D' ");
		sqljob.appendSQL("and issue.account_year = '" + accountYear + "'");
		sqljob.appendSQL("and debt.accrue = 'Y' ");
		sqljob.appendSQL("and debt.budget_year = 'Y' ");
		sqljob.appendSQL("and debt.bank_id in (select bank.id from bank_ref bank where bank.bank_code = '"+bankCode+"') ");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );

		Dira1401Form myForm = (Dira1401Form) form;
		//年度1&2
		String year1 = "0"+String.valueOf(Integer.valueOf(myForm.getAccountYear())-1);
		String year2 = (String)myForm.getAccountYear();
		int bankNo = 1;
		//取年度簽約銀行
		SQLJob sqljob = SQLyearBank(year1);
		List yearBankList = (List) run.query(sqljob, new MapListHandler());
		Map yearBankMap = null;
		for(Iterator yearBankIterator = yearBankList.iterator(); yearBankIterator.hasNext();){
			yearBankMap = (Map)yearBankIterator.next();
			Integer bankId = null!=(Integer)yearBankMap.get("id")?(Integer)yearBankMap.get("id"):0;
			
			Map dMap = new HashMap();
			dMap.put("bank_no",bankNo);
			bankNo++;
			dMap.put("bank_id",(Integer)yearBankMap.get("bank_id"));
			dMap.put("bank_name",(String)yearBankMap.get("bank_name"));
			dMap.put("new_year_bank1",getIntegral((BigDecimal)yearBankMap.get("contract_amount")));
			dMap.put("tot_amount1",getIntegral((BigDecimal)yearBankMap.get("contract_amount")));
			SQLJob yearBankNumSQL = SQLyearAmount(year1,(String)yearBankMap.get("bank_code"));
			List yearBankNumList = (List) run.query(yearBankNumSQL, new MapListHandler());
			if (yearBankNumList.size()>0)
				dMap.put("tot_times1",yearBankNumList.size());
			SQLJob sqljob2 = SQLyearBank(year2,bankId);
			List yearBankList2 = (List) run.query(sqljob2, new MapListHandler());
			if (yearBankList2.size() > 0){
				Map yearBankMap2 = new HashMap();
				yearBankMap2 = (Map)yearBankList2.get(0);
				dMap.put("new_year_bank2",getIntegral((BigDecimal)yearBankMap2.get("contract_amount")));
				dMap.put("tot_amount2",getIntegral((BigDecimal)yearBankMap2.get("contract_amount")));
			}
			yearBankNumSQL = SQLyearAmount(year2,(String)yearBankMap.get("bank_code"));
			yearBankNumList = (List) run.query(yearBankNumSQL, new MapListHandler());
			if (yearBankNumList.size()>0)
				dMap.put("tot_times2",yearBankNumList.size());
			run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));				
		}
		sqljob = SQLyearBankNext(year2);
		yearBankList = (List) run.query(sqljob, new MapListHandler());
		for(Iterator yearBankIterator = yearBankList.iterator(); yearBankIterator.hasNext();){
			yearBankMap = (Map)yearBankIterator.next();
			Map dMap = new HashMap();
			dMap.put("bank_no",bankNo);
			bankNo++;
			dMap.put("bank_id",(Integer)yearBankMap.get("bank_id"));
			dMap.put("bank_name",(String)yearBankMap.get("bank_name"));
			dMap.put("new_year_bank2",getIntegral((BigDecimal)yearBankMap.get("contract_amount")));
			dMap.put("tot_amount2",getIntegral((BigDecimal)yearBankMap.get("contract_amount")));
			run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));	
		}
		//另訂年度新約銀行
		sqljob = SQLseparatelyBank();
		yearBankList = (List) run.query(sqljob, new MapListHandler());
		for(Iterator yearBankIterator = yearBankList.iterator(); yearBankIterator.hasNext();){
			yearBankMap = (Map)yearBankIterator.next();
			//第一個年度
			SQLJob sqljob2 = SQLseparatelyAmount(year1,(String)yearBankMap.get("bank_code"));
			List yearBankList2 = (List) run.query(sqljob2, new MapListHandler());
			int tmp = 1;
			Integer bankId = 0;
			BigDecimal amount = new BigDecimal(0);
			for(Iterator yearBankIterator2 = yearBankList2.iterator(); yearBankIterator2.hasNext();){
				Map yearBankMap2 = new HashMap();
				yearBankMap2 = (Map)yearBankIterator2.next();
				amount = amount.add((BigDecimal)yearBankMap2.get("issue_amount"));
				bankId = null!=(Integer)yearBankMap2.get("bank_id")?(Integer)yearBankMap2.get("bank_id"):0;
				tmp++;
			}
			Map dMap = new HashMap();
			if (tmp > 1){
				dMap.put("other_year_num1",tmp);
				dMap.put("other_year_bank1",getIntegral(amount));
				dMap.put("tot_amount1",String.valueOf(getIntegral(amount)));
				dMap.put("tot_times1",tmp);
			}
			//第二個年度
			sqljob2 = SQLseparatelyAmount(year2,(String)yearBankMap.get("bank_code"));
			yearBankList2 = (List) run.query(sqljob2, new MapListHandler());
			int tmp2 = 1;
			bankId = 0;
			amount = new BigDecimal(0);
			for(Iterator yearBankIterator2 = yearBankList2.iterator(); yearBankIterator2.hasNext();){
				Map yearBankMap2 = new HashMap();
				yearBankMap2 = (Map)yearBankIterator2.next();
				amount = amount.add((BigDecimal)yearBankMap2.get("issue_amount"));
				bankId = null!=(Integer)yearBankMap2.get("bank_id")?(Integer)yearBankMap2.get("bank_id"):0;
				tmp2++;
			}
			if (tmp2 > 1) {
				dMap.put("other_year_num2",tmp2);
				dMap.put("other_year_bank2",getIntegral(amount));
				dMap.put("tot_amount2",getIntegral(amount));
				dMap.put("tot_times2",tmp2);
			}
			if (tmp>1 || tmp2>1){
				dMap.put("bank_no",bankNo);
				bankNo++;
				dMap.put("bank_id",bankId);
				dMap.put("bank_name",(String)yearBankMap.get("bank_name"));
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));					
			}
		}

		request.setAttribute("title",year1+"至"+year2+"銀行歷年簽約下一年度額度報表");
		request.setAttribute("year1",year1+"年度");
		request.setAttribute("year2",year2+"年度");
	}

	private BigDecimal getIntegral(BigDecimal amount){
		String amountString = String.valueOf(amount);
		BigDecimal amountIntegral = new BigDecimal(0);
		int amountLength = amountString.indexOf(".");
		amountIntegral = new BigDecimal(amountString.substring(0,amountLength));
		return amountIntegral;
	}
}
