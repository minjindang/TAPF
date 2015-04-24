package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.shortterm.form.Dira1301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class DIRA1302 extends ExcelReportBaseAction {

	private final static String TEMP_TABLE_NAME = "DIRA13_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM DIRA13_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQLbnakId(String startYear, String endYear) {
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select debt.bank_id ");
		sqljob.appendSQL("from debt_main debt, issue_main issue ");
		sqljob.appendSQL("where issue.id = debt.issue_id ");
		sqljob.appendSQL("and issue.debt_type = 'D' ");
//		sqljob.appendSQL("and issue.budget_code in (3,4) ");
		sqljob.appendSQL("and issue.account_year between '"+startYear+"' and '"+endYear+"' ");
		sqljob.appendSQL("group by debt.bank_id ");
		sqljob.appendSQL("order by debt.bank_id ");
		
		return sqljob;
	}
	
	protected SQLJob SQLbankNum (String bankId, String year) {
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select bank.bank_name ");
		sqljob.appendSQL("from debt_main debt, issue_main issue, bank_ref bank ");
		sqljob.appendSQL("where issue.id = debt.issue_id ");
		sqljob.appendSQL("and issue.debt_type = 'D' ");
//		sqljob.appendSQL("and issue.budget_code in (3,4) ");
		sqljob.appendSQL("and bank.id = debt.bank_id ");
		sqljob.appendSQL("and issue.account_year = " + year);
		sqljob.appendSQL("and debt.bank_id = " + bankId);
		
		return sqljob;
	}
	
	protected SQLJob SQLbankDate (String bankId, String year) {
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select issue.issue_serial, ");
		sqljob.appendSQL("debt.issue_amount / 100000000 as issue_amount ");
		sqljob.appendSQL("from debt_main debt, issue_main issue ");
		sqljob.appendSQL("where issue.id = debt.issue_id ");
		sqljob.appendSQL("and issue.debt_type = 'D' ");
//		sqljob.appendSQL("and issue.budget_code in (3,4) ");
		sqljob.appendSQL("and issue.account_year = " + year);
		sqljob.appendSQL("and debt.bank_id = " + bankId);
		sqljob.appendSQL("order by debt.bank_id, issue.account_year");		
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
		
		Dira1301Form myForm = (Dira1301Form) form;
		//五年內的會計年度
		String year[] = new String[5];
		for (int i=0; i<5; i++) {
			if(Integer.valueOf(myForm.getAccountYear())-(4-i) < 100)
				year[i] = "0"+String.valueOf(Integer.valueOf(myForm.getAccountYear())-(4-i));
			else
				year[i] = String.valueOf(Integer.valueOf(myForm.getAccountYear())-(4-i));
		}
		//取會計年度期間的所有短借銀行
		SQLJob sqljob = SQLbnakId(year[0],year[4]);
		List bankIdList = (List) run.query(sqljob, new MapListHandler());
		Map bankIdMap = null;
		String bankId[] = new String[bankIdList.size()];
		int tmp = 0;
		int yearNum[] = new int[5];
		BigDecimal yearAmount[] = new BigDecimal[5];
		for (int i=0; i<5; i++)
			yearAmount[i] = new BigDecimal(0);
		for(Iterator bankIdIterator = bankIdList.iterator(); bankIdIterator.hasNext();){
			bankIdMap = (Map) bankIdIterator.next();
			bankId[tmp] = String.valueOf(bankIdMap.get("bank_id"));
			int maxBankNum = 0;
			List bankNumList = null;
			String bankName = "";
			for (int i=0; i<5; i++){
				//取每一間銀行的在不同會計年度中的期別數量
				sqljob = SQLbankNum(bankId[tmp],year[i]);
				bankNumList = (List) run.query(sqljob, new MapListHandler());
				if (bankNumList.size() > maxBankNum)
					maxBankNum = bankNumList.size();	
				Map bankNameMap = null;
				//取銀行的中文名稱
				for (Iterator bankNameIterator = bankNumList.iterator(); bankNameIterator.hasNext();){
					bankNameMap = (Map) bankNameIterator.next();
					bankName = (String)bankNameMap.get("bank_name");
					System.out.println(bankName);
				}			
			}
			//依各銀行將各會計年度的資料取出
			String obj[][] = new String[10][maxBankNum];
			List bankDateList = null;
			Map bankDateMap = null;
			for (int i=0; i<5; i++){
				System.out.println("年度："+year[i]);
				sqljob = SQLbankDate(bankId[tmp],year[i]);
				bankDateList = (List) run.query(sqljob, new MapListHandler());
				if (null != bankDateList && !bankDateList.isEmpty()) {
					int index = 0;
					for (Iterator bankDateIterator = bankDateList.iterator(); bankDateIterator.hasNext();) {
						bankDateMap = (Map) bankDateIterator.next();
						obj[i*2][index] = (String)bankDateMap.get("issue_serial");
						obj[i*2+1][index] = String.valueOf(bankDateMap.get("issue_amount"));
						System.out.println("期別："+obj[i*2][index]+",金額："+obj[i*2+1][index]);
						index++;
					}
				}
			}
			//寫入資料
			int firstRun = 0;
			int totNum = 0; 
			BigDecimal totAmount = new BigDecimal(0);
			for (int i=0; i<maxBankNum; i++){
				Map dMap = new HashMap();
				for (int j=0; j<5; j++){
					if (firstRun == 0){
						dMap.put("bank_no",String.valueOf(tmp+1));
						dMap.put("bank_name",bankName);				
					} else {
						dMap.put("bank_no","");
						dMap.put("bank_name","");
					}
					
					if (null != obj[j*2][i]){
						switch (j) {
						case 0:
							dMap.put("issue_serial_1",obj[j*2][i]);
							dMap.put("issue_amount_1",obj[j*2+1][i]);
							totNum++;
							totAmount = totAmount.add(BigDecimal.valueOf(Double.valueOf(obj[j*2+1][i])));
							yearNum[j] = yearNum[j] + 1;
							yearAmount[j] = yearAmount[j].add(BigDecimal.valueOf(Double.valueOf(obj[j*2+1][i])));
							break;
						case 1:
							dMap.put("issue_serial_2",obj[j*2][i]);
							dMap.put("issue_amount_2",obj[j*2+1][i]);
							totNum++;
							totAmount = totAmount.add(BigDecimal.valueOf(Double.valueOf(obj[j*2+1][i])));
							yearNum[j] = yearNum[j] + 1;
							yearAmount[j] = yearAmount[j].add(BigDecimal.valueOf(Double.valueOf(obj[j*2+1][i])));
							break;
						case 2:
							dMap.put("issue_serial_3",obj[j*2][i]);
							dMap.put("issue_amount_3",obj[j*2+1][i]);
							totNum++;
							totAmount = totAmount.add(BigDecimal.valueOf(Double.valueOf(obj[j*2+1][i])));
							yearNum[j] = yearNum[j] + 1;
							yearAmount[j] = yearAmount[j].add(BigDecimal.valueOf(Double.valueOf(obj[j*2+1][i])));
							break;
						case 3:
							dMap.put("issue_serial_4",obj[j*2][i]);
							dMap.put("issue_amount_4",obj[j*2+1][i]);
							totNum++;
							totAmount = totAmount.add(BigDecimal.valueOf(Double.valueOf(obj[j*2+1][i])));
							yearNum[j] = yearNum[j] + 1;
							yearAmount[j] = yearAmount[j].add(BigDecimal.valueOf(Double.valueOf(obj[j*2+1][i])));
							break;
						case 4:
							dMap.put("issue_serial_5",obj[j*2][i]);
							dMap.put("issue_amount_5",obj[j*2+1][i]);
							totNum++;
							totAmount = totAmount.add(BigDecimal.valueOf(Double.valueOf(obj[j*2+1][i])));
							yearNum[j] = yearNum[j] + 1;
							yearAmount[j] = yearAmount[j].add(BigDecimal.valueOf(Double.valueOf(obj[j*2+1][i])));
							break;
						}
					}
				}
				
				if (i == maxBankNum-1){
					dMap.put("tot_serial",totNum);
					dMap.put("tot_amount",totAmount);
				}
				
				firstRun++;		
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));				
			}
			tmp++;
		}
		//寫入合計
		Map dMap = new HashMap();
		dMap.put("bank_name","合計");
		dMap.put("issue_serial_1",yearNum[0]);
		dMap.put("issue_amount_1",yearAmount[0]);
		dMap.put("issue_serial_2",yearNum[1]);
		dMap.put("issue_amount_2",yearAmount[1]);
		dMap.put("issue_serial_3",yearNum[2]);
		dMap.put("issue_amount_3",yearAmount[2]);
		dMap.put("issue_serial_4",yearNum[3]);
		dMap.put("issue_amount_4",yearAmount[3]);
		dMap.put("issue_serial_5",yearNum[4]);
		dMap.put("issue_amount_5",yearAmount[4]);
		int totYearNum = 0;
		BigDecimal totYearAmount = new BigDecimal(0);
		for (int i=0; i<5; i++){
			totYearNum = totYearNum + yearNum[i];
			totYearAmount = totYearAmount.add(yearAmount[i]);
		}
		dMap.put("tot_serial",totYearNum);
		dMap.put("tot_amount",totYearAmount);
		run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));

		request.setAttribute("title",year[0]+"至"+year[4]+"年度各銀行貸款概況(含短借：債務基金及民營化基金借款)");
		request.setAttribute("column1",year[0]+"年度");
		request.setAttribute("column2",year[1]+"年度");
		request.setAttribute("column3",year[2]+"年度");
		request.setAttribute("column4",year[3]+"年度");
		request.setAttribute("column5",year[4]+"年度");
	}
}
