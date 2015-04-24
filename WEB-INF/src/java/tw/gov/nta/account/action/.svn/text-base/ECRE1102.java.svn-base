package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
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

public class ECRE1102 extends ExcelReportBaseAction {
	
	private final static String TEMP_TABLE_NAME = "ECRE11_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM ECRE11_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select (select budget_name from budget_ref where d.budget_code = id) as budget_name, ");
		sqljob.appendSQL("(select debit_name from debit_ref where d.debt_code = id) as debit_name, ");
		sqljob.appendSQL("i.issue_serial, ");
//		sqljob.appendSQL("i.issue_amount, ");
		sqljob.appendSQL("(select sum(x.issue_amount) from debt_main x where x.issue_id = i.id and d.debt_code = x.debt_code) as issue_amount, ");
		sqljob.appendSQL("i.issue_date, ");
		sqljob.appendSQL("i.due_date, ");
		sqljob.appendSQL("p.repay_date as real_repay_date, ");
		sqljob.appendSQL("p.interest_amount, ");
		sqljob.appendSQL("(select dp.repay_date from debt_plan_det dp where dp.id = p.plan_id) as repay_date ");
		sqljob.appendSQL("from issue_main i, payment_main p, debt_main d ");
		sqljob.appendSQL("where i.id = p.issue_id ");
		sqljob.appendSQL("and i.id = d.issue_id ");
		sqljob.appendSQL("and p.debt_id = d.id ");
		sqljob.appendSQL("and i.debt_type = 'C' ");
		sqljob.appendSQL("and d.budget_code not in (4,5)");
		if (null != myForm.getStartIssueDate() && !myForm.getStartIssueDate().equals(""))
			sqljob.appendSQL("and i.issue_date <= '" + DateUtil.date2Str(myForm.getStartIssueDate(),"yyyy/MM/dd") + "'");
		if (0 != myForm.getBudgetCode())
			sqljob.appendSQL("and d.budget_code = " + myForm.getBudgetCode());
		sqljob.appendSQL(" and p.repay_date <= '2010/03/01' ");
		sqljob.appendSQL(" union all ");
		sqljob.appendSQL("select distinct  (select budget_name from budget_ref where d.budget_code = id) as budget_name, ");
		sqljob.appendSQL("(select debit_name from debit_ref where d.debt_code = id) as debit_name, ");
		sqljob.appendSQL("i.issue_serial, ");
//		sqljob.appendSQL("i.issue_amount, ");
		sqljob.appendSQL("(select sum(x.issue_amount) from debt_main x where x.issue_id = i.id and d.debt_code = x.debt_code) as issue_amount, ");
		sqljob.appendSQL("i.issue_date, ");
		sqljob.appendSQL("i.due_date, ");
		sqljob.appendSQL("'' as real_repay_date, ");
		sqljob.appendSQL("0 as interest_amount, ");
		sqljob.appendSQL("'' as repay_date ");
		sqljob.appendSQL("from issue_main i, debt_main d, debt_plan_det dp ");
		sqljob.appendSQL("where i.id = d.issue_id ");
		sqljob.appendSQL("and i.id = dp.issue_id ");
		sqljob.appendSQL("and d.id = dp.debt_id ");
		sqljob.appendSQL("and i.debt_type = 'C' ");
		sqljob.appendSQL("and d.budget_code not in (4,5)");
		sqljob.appendSQL("and d.issue_amount <> isnull((select sum(capital_amount) from payment_main where debt_id = d.id),0) ");
		if (null != myForm.getStartIssueDate() && !myForm.getStartIssueDate().equals(""))
			sqljob.appendSQL("and i.issue_date <= '" + DateUtil.date2Str(myForm.getStartIssueDate(),"yyyy/MM/dd") + "'");
		if (0 != myForm.getBudgetCode())
			sqljob.appendSQL("and d.budget_code = " + myForm.getBudgetCode());
		sqljob.appendSQL("order by 1 DESC,3,2,4 ");		
		
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected Map getDate(Map tMap){
		Map<String,Object> gMap = new HashMap<String,Object>();
		BigDecimal interestAmount1 = new BigDecimal(0);
		BigDecimal interestAmount2 = new BigDecimal(0);
		
		String budgetName = null!=tMap.get("budget_name")?(String)tMap.get("budget_name"):"";
		String debitName = null!=tMap.get("debit_name")?(String)tMap.get("debit_name"):"";
		String issueSerial = null!=tMap.get("issue_serial")?(String)tMap.get("issue_serial"):"";
		BigDecimal issueAmount = null!=tMap.get("issue_amount")?(BigDecimal)tMap.get("issue_amount"):new BigDecimal(0);
		issueAmount = issueAmount.setScale(0,BigDecimal.ROUND_DOWN);
		Date issueDate = null!=tMap.get("issue_date")?(Date)tMap.get("issue_date"):null;
		Date dueDate = null!=tMap.get("due_date")?(Date)tMap.get("due_date"):null;
		Date repayDate = null!=tMap.get("repay_date")?(Date)tMap.get("repay_date"):null;
		Date realRepayDate = null!=tMap.get("real_repay_date")?(Date)tMap.get("real_repay_date"):null;
		if (null != repayDate && realRepayDate.equals(repayDate)) {
			interestAmount1 = interestAmount1.add((BigDecimal)tMap.get("interest_amount"));
		} else if (null != repayDate && realRepayDate.before(repayDate)) {
			interestAmount2 = interestAmount2.add((BigDecimal)tMap.get("interest_amount"));
		}		

		gMap.put("budgetName",budgetName);
		gMap.put("debitName",debitName);
		gMap.put("issueSerial",issueSerial);
		gMap.put("issueAmount",issueAmount);
		gMap.put("issueDate",issueDate);
		gMap.put("dueDate",dueDate);
		gMap.put("repayDate",repayDate);
		gMap.put("realRepayDate",realRepayDate);
		gMap.put("interestAmount1",interestAmount1);
		gMap.put("interestAmount2",interestAmount2);
		
		return gMap;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );	
		AccountQueryForm myForm = (AccountQueryForm) form;

		SQLJob sqljob = SQL((AccountQueryForm)form);
		List tList = (List) run.query(sqljob, new MapListHandler());
		Map tMap = null;
		String obj[] = new String[3];
		obj[0] = "";
		String budgetName = "";
		String debitName = "";
		String issueSerial = "";
		String tmpIssueSerial = "";
		Date issueDate = null;
		Date dueDate = null;
		Date repayDate = null;
		Date realRepayDate = null;
		BigDecimal issueAmount = new BigDecimal(0);
		BigDecimal interestAmount1 = new BigDecimal(0);
		BigDecimal interestAmount2 = new BigDecimal(0);
		BigDecimal accsumInterestAmount1 = new BigDecimal(0); //到期付息數 
		BigDecimal accsumInterestAmount2 = new BigDecimal(0); //提前付息數 
		BigDecimal accsumAmount = new BigDecimal(0); //累積付息數
		int tListSize = 0;
		int tmp = 0;//1:合計寫入
		int tmp2 = 0;//1:單筆寫入

		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); ){	
			tMap = (Map) tIterator.next();
			Map gMap = getDate(tMap);
			//填入第一筆資料
			if (obj[0].equals("")){
				obj[0] = (String)gMap.get("budgetName");
				obj[1] = (String)gMap.get("debitName");
				obj[2] = (String)gMap.get("issueSerial");
				repayDate = (Date)gMap.get("repayDate");
				realRepayDate = (Date)gMap.get("realRepayDate");
				interestAmount1 = (BigDecimal)gMap.get("interestAmount1");
				interestAmount2 = (BigDecimal)gMap.get("interestAmount2");
				accsumInterestAmount1 = accsumInterestAmount1.add(interestAmount1);
				accsumInterestAmount2 = accsumInterestAmount2.add(interestAmount2);
				accsumAmount = interestAmount1.add(interestAmount2);
				issueDate = (Date)gMap.get("issueDate");
				dueDate = (Date)gMap.get("dueDate");
				issueAmount = (BigDecimal)gMap.get("issueAmount");
				tListSize++;
			} else {
				//判斷"預算別"&"債務別"&"舉借期別"
				if (!obj[0].equals((String)gMap.get("budgetName")) || !obj[1].equals((String)gMap.get("debitName")) 
						|| !obj[2].equals((String)gMap.get("issueSerial")) || tListSize == tList.size()) {
					
					Map dMap = new HashMap();
					
					if (!issueSerial.equals((String)gMap.get("issueSerial"))) {
						if (!issueSerial.equals("")) {
							tmpIssueSerial = obj[2] + "期合計";
							tmp = 1;
						}
					}
					dMap.put("budget_name",obj[0]);
					dMap.put("debit_name",obj[1]);
					dMap.put("issue_serial",obj[2]+"期");
					dMap.put("issue_amount",issueAmount);
					dMap.put("issue_date",issueDate);
					dMap.put("due_date",dueDate);

					obj[0] = (String)gMap.get("budgetName");
					obj[1] = (String)gMap.get("debitName");
					obj[2] = (String)gMap.get("issueSerial");
					
					issueAmount = (BigDecimal)gMap.get("issueAmount");
					issueDate = (Date)gMap.get("issueDate");
					dueDate = (Date)gMap.get("dueDate");
					if (!"1900-01-01 00:00:00.0".equals(realRepayDate.toString()))
						dMap.put("repay_date",realRepayDate);
					else
						dMap.put("repay_date",null);
					dMap.put("interest_amount1",interestAmount1);
					dMap.put("interest_amount2",interestAmount2);
					run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
					if (1 == tmp) {
						dMap = new HashMap();
						dMap.put("issue_serial",tmpIssueSerial);
						dMap.put("interest_amount1",accsumInterestAmount1);
						dMap.put("interest_amount2",accsumInterestAmount2);
						dMap.put("accsum_amount",accsumAmount);
						run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
						tmp = 0;
						accsumInterestAmount1 = new BigDecimal(0);
						accsumInterestAmount2 = new BigDecimal(0);
						accsumAmount = new BigDecimal(0);
					}
					tListSize++;
					//最後一筆
					if (tListSize == tList.size()) {
						dMap = new HashMap();
						dMap.put("budget_name",(String)gMap.get("budgetName"));
						dMap.put("debit_name",(String)gMap.get("debitName"));
						dMap.put("issue_serial",(String)gMap.get("issueSerial")+"期");	
						dMap.put("issue_amount",(BigDecimal)gMap.get("issueAmount"));
						dMap.put("issue_date",(Date)gMap.get("issueDate"));
						dMap.put("due_date",(Date)gMap.get("dueDate"));
						if (!"1900-01-01 00:00:00.0".equals(gMap.get("realRepayDate").toString()))
							dMap.put("repay_date",(Date)gMap.get("realRepayDate"));
						else
							dMap.put("repay_date",null);
						dMap.put("interest_amount1",(BigDecimal)gMap.get("interestAmount1"));
						dMap.put("interest_amount2",(BigDecimal)gMap.get("interestAmount2"));	
						if(!accsumInterestAmount1.equals((BigDecimal)gMap.get("interestAmount1")) || 
								!accsumInterestAmount2.equals((BigDecimal)gMap.get("interestAmount2")))
						{
							accsumInterestAmount1 = accsumInterestAmount1.add((BigDecimal)gMap.get("interestAmount1"));
							accsumInterestAmount2 = accsumInterestAmount2.add((BigDecimal)gMap.get("interestAmount2"));
							accsumAmount = accsumAmount.add((BigDecimal)gMap.get("interestAmount1"));
							accsumAmount = accsumAmount.add((BigDecimal)gMap.get("interestAmount2"));
						}
						run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));	
						dMap = new HashMap();
						dMap.put("issue_serial",(String)gMap.get("issueSerial")+"期合計");
						dMap.put("interest_amount1",accsumInterestAmount1);
						dMap.put("interest_amount2",accsumInterestAmount2);
						dMap.put("accsum_amount",accsumAmount);
						run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
					}
					repayDate = (Date)gMap.get("repayDate");
					realRepayDate = (Date)gMap.get("realRepayDate");
					interestAmount1 = (BigDecimal)gMap.get("interestAmount1");
					interestAmount2 = (BigDecimal)gMap.get("interestAmount2");
					accsumInterestAmount1 = accsumInterestAmount1.add(interestAmount1);
					accsumInterestAmount2 = accsumInterestAmount2.add(interestAmount2);
					accsumAmount = accsumAmount.add(interestAmount1);
					accsumAmount = accsumAmount.add(interestAmount2);
				//"償還日"&"實際償還日"
				} else if (!repayDate.equals((Date)gMap.get("repayDate")) || !realRepayDate.equals((Date)gMap.get("realRepayDate"))) {
					tmp2 = 0;
					Map dMap = new HashMap();
					budgetName = (String)gMap.get("budgetName");
					debitName = (String)gMap.get("debitName");
					issueSerial = (String)gMap.get("issueSerial");
					dMap.put("budget_name",budgetName);
					dMap.put("debit_name",debitName);
					dMap.put("issue_serial",issueSerial+"期");
					dMap.put("issue_amount",issueAmount);
					dMap.put("issue_date",issueDate);
					dMap.put("due_date",dueDate);
					obj[0] = (String)gMap.get("budgetName");
					obj[1] = (String)gMap.get("debitName");
					obj[2] = (String)gMap.get("issueSerial");
					
					
					issueAmount = (BigDecimal)gMap.get("issueAmount");
					issueDate = (Date)gMap.get("issueDate");
					dueDate = (Date)gMap.get("dueDate");
					if (!"1900-01-01 00:00:00.0".equals(realRepayDate.toString()))
						dMap.put("repay_date",realRepayDate);
					else
						dMap.put("repay_date",null);
					dMap.put("interest_amount1",interestAmount1);
					dMap.put("interest_amount2",interestAmount2);
					run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
					repayDate = (Date)gMap.get("repayDate");
					realRepayDate = (Date)gMap.get("realRepayDate");
					interestAmount1 = (BigDecimal)gMap.get("interestAmount1");
					interestAmount2 = (BigDecimal)gMap.get("interestAmount2");
					accsumInterestAmount1 = accsumInterestAmount1.add(interestAmount1);
					accsumInterestAmount2 = accsumInterestAmount2.add(interestAmount2);
					accsumAmount = accsumAmount.add(interestAmount1);
					accsumAmount = accsumAmount.add(interestAmount2);
					tListSize++;
					//最後一筆
					if (tListSize == tList.size()) {
						dMap = new HashMap();
						dMap.put("budget_name",(String)gMap.get("budgetName"));
						dMap.put("debit_name",(String)gMap.get("debitName"));
						dMap.put("issue_serial",(String)gMap.get("issueSerial")+"期");	
						dMap.put("issue_amount",(BigDecimal)gMap.get("issueAmount"));
						dMap.put("issue_date",(Date)gMap.get("issueDate"));
						dMap.put("due_date",(Date)gMap.get("dueDate"));
						if (!"1900-01-01 00:00:00.0".equals(gMap.get("realRepayDate").toString()))
							dMap.put("repay_date",(Date)gMap.get("realRepayDate"));
						else
							dMap.put("repay_date",null);
						dMap.put("interest_amount1",(BigDecimal)gMap.get("interestAmount1"));
						dMap.put("interest_amount2",(BigDecimal)gMap.get("interestAmount2"));
						if(!accsumInterestAmount1.equals((BigDecimal)gMap.get("interestAmount1")) || 
								!accsumInterestAmount2.equals((BigDecimal)gMap.get("interestAmount2")))
						{
							accsumInterestAmount1 = accsumInterestAmount1.add((BigDecimal)gMap.get("interestAmount1"));
							accsumInterestAmount2 = accsumInterestAmount2.add((BigDecimal)gMap.get("interestAmount2"));
							accsumAmount = accsumAmount.add((BigDecimal)gMap.get("interestAmount1"));
							accsumAmount = accsumAmount.add((BigDecimal)gMap.get("interestAmount2"));
						}
						run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));	
						dMap = new HashMap();
						dMap.put("issue_serial",(String)gMap.get("issueSerial")+"期合計");
						dMap.put("interest_amount1",accsumInterestAmount1);
						dMap.put("interest_amount2",accsumInterestAmount2);
						dMap.put("accsum_amount",accsumAmount);
						run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
					}
				} else {
					interestAmount1 = interestAmount1.add((BigDecimal)gMap.get("interestAmount1"));
					accsumInterestAmount1 = accsumInterestAmount1.add((BigDecimal)gMap.get("interestAmount1"));
					accsumAmount = accsumAmount.add((BigDecimal)gMap.get("interestAmount1"));
					interestAmount2 = interestAmount2.add((BigDecimal)gMap.get("interestAmount2"));
					accsumInterestAmount2 = accsumInterestAmount2.add((BigDecimal)gMap.get("interestAmount2"));
					accsumAmount = accsumAmount.add((BigDecimal)gMap.get("interestAmount2"));
					tListSize++;
					//最後一筆
					if (tListSize == tList.size()) {
						Map dMap = new HashMap();
						dMap.put("budget_name",(String)gMap.get("budgetName"));
						dMap.put("debit_name",(String)gMap.get("debitName"));
						dMap.put("issue_serial",(String)gMap.get("issueSerial")+"期");	
						dMap.put("issue_amount",(BigDecimal)gMap.get("issueAmount"));
						dMap.put("issue_date",(Date)gMap.get("issueDate"));
						dMap.put("due_date",(Date)gMap.get("dueDate"));
						if (!"1900-01-01 00:00:00.0".equals(gMap.get("realRepayDate").toString()))
							dMap.put("repay_date",(Date)gMap.get("realRepayDate"));
						else
							dMap.put("repay_date",null);
						dMap.put("interest_amount1",(BigDecimal)gMap.get("interestAmount1"));
						dMap.put("interest_amount2",(BigDecimal)gMap.get("interestAmount2"));	
						if(!accsumInterestAmount1.equals((BigDecimal)gMap.get("interestAmount1")) || 
								!accsumInterestAmount2.equals((BigDecimal)gMap.get("interestAmount2")))
						{
							accsumInterestAmount1 = accsumInterestAmount1.add((BigDecimal)gMap.get("interestAmount1"));
							accsumInterestAmount2 = accsumInterestAmount2.add((BigDecimal)gMap.get("interestAmount2"));
							accsumAmount = accsumAmount.add((BigDecimal)gMap.get("interestAmount1"));
							accsumAmount = accsumAmount.add((BigDecimal)gMap.get("interestAmount2"));
						}
						run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));	
						dMap = new HashMap();
						dMap.put("issue_serial",(String)gMap.get("issueSerial")+"期合計");
						dMap.put("interest_amount1",accsumInterestAmount1);
						dMap.put("interest_amount2",accsumInterestAmount2);
						dMap.put("accsum_amount",accsumAmount);
						run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
					}
				}
			}
		}		
		
		request.setAttribute("startIssueDate",DateUtil.date2ChineseROC2((Date)myForm.getStartIssueDate()));
		
	}

}
