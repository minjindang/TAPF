package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EBRE0401 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "EBRE04_RPT";

	protected SQLJob getAllIssueMainId(Date qryDate)
	{

		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT i.id");
		sqljob.appendSQL(",i.debt_name");
		sqljob.appendSQL(",case when datediff(dd, i.issue_date, i.due_date) = 92 then 91 else datediff(dd, i.issue_date, i.due_date) end  as daycount");
		sqljob.appendSQL(",b.budget_name, case when i.bond_type = '' then '2' else i.bond_type end as bond_type");
		sqljob.appendSQL("  FROM issue_main I, budget_ref B");
		sqljob.appendSQL(" WHERE I.budget_code=B.id");
		sqljob.appendSQL("   AND I.debt_type='B'");
		sqljob.appendSQL("   AND I.sell_status <> '2' ");
		sqljob.appendSQL("   AND I.issue_date<=?");
		sqljob.appendSQL("   order by  case when i.bond_type = '' then 2 else i.bond_type end,case when datediff(dd, i.issue_date, i.due_date) = 92 then 91 else datediff(dd, i.issue_date, i.due_date) end ,issue_serial");
		sqljob.addParameter( new Timestamp( qryDate.getTime() ) );
		System.out.println(sqljob.toString());
		return sqljob;		
	}

	protected String getVoucherAmountSql()
	{
		//產生各項資料
			
		Map reportAccountInfo = getReportAccountInfo();
		StringBuffer queryString = new StringBuffer();
		queryString.append("SELECT ");
		
		for(Iterator iterator=reportAccountInfo.keySet().iterator();iterator.hasNext();) {
			String columnName = (String)iterator.next();
			String accountRule = (String)reportAccountInfo.get(columnName);
			
			StringTokenizer accountTokenizer = new StringTokenizer(accountRule,";");
			while(accountTokenizer.hasMoreTokens()) {
				String detailAccount = accountTokenizer.nextToken(); 
				StringTokenizer typeTokenizer = new StringTokenizer(detailAccount,":");
				
				String accountCode = typeTokenizer.nextToken();
				String accountType = typeTokenizer.nextToken();
				queryString.append(" isnull(sum(case when a.account_code = '"+accountCode+"' then ");
				if("A".equals(accountType)) {
					queryString.append(" case when d.account_type = a.account_type then d.account_amount else d.account_amount * -1 end ");
				}else {
					queryString.append(" case when d.account_type = '"+accountType+"' then d.account_amount else 0 end ");
				}	
				queryString.append(" else 0 end),0) ");
				if(accountTokenizer.hasMoreTokens()) {
					queryString.append("+");
				}else {
					queryString.append("as "+columnName+", \n");
				}
			}
		}		
		queryString.append(" ? As DAYCOUNT, ");
		queryString.append(" ? As DEBT_NAME,");
		queryString.append(" ? As usrId,");
		queryString.append(" ? As BUDGET_NAME ");
		queryString.append("  FROM voucher_main M, voucher_det D ,account_ref A \n");
		queryString.append(" WHERE M.id=D.voucher_id \n");
		queryString.append("   AND A.id=D.account_code \n");
		queryString.append("   AND M.issue_id=? \n");
		queryString.append("   and M.voucher_Date <=? \n");
		queryString.append("   And M.debt_type_id=2 \n");
		queryString.append("   And a.debt_type=2 \n");
		System.out.println(queryString.toString());

		return queryString.toString();
		
	}

	protected SQLJob insTemp(Map map)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME);
		sqljob.appendSQL(" ( DEBT_NAME, DAYCOUNT, BUDGET_NAME, ");
		sqljob.appendSQL(" CAPITAL_AMOUNT1, INTEREST_AMOUNT1, TOTAL_AMOUNT1, ");
		sqljob.appendSQL(" CAPITAL_AMOUNT2, INTEREST_AMOUNT2, TOTAL_AMOUNT2, ");
		sqljob.appendSQL(" CAPITAL_AMOUNT3, INTEREST_AMOUNT3, TOTAL_AMOUNT3, ");
		sqljob.appendSQL(" CAPITAL_AMOUNT4, INTEREST_AMOUNT4, TOTAL_AMOUNT4, ");
		sqljob.appendSQL(" CAPITAL_AMOUNT5, INTEREST_AMOUNT5, TOTAL_AMOUNT5, ");
		sqljob.appendSQL(" CAPITAL_AMOUNT6, INTEREST_AMOUNT6, TOTAL_AMOUNT6, ");
		sqljob.appendSQL(" CAPITAL_AMOUNT7, INTEREST_AMOUNT7, TOTAL_AMOUNT7, ");
		sqljob.appendSQL(" RETURN_INTEREST_AMOUNT, ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK ");
		sqljob.appendSQL(" ) VALUES ( ");
		sqljob.appendSQL(" ?,?,?,?,?");
		sqljob.appendSQL(",?,?,?,?,?");
		sqljob.appendSQL(",?,?,?,?,?");
		sqljob.appendSQL(",?,?,?,?,?");
		sqljob.appendSQL(",?,?,?,?,?");
		sqljob.appendSQL(",?,?,?");
		sqljob.appendSQL(" ) ");
		
		BigDecimal capitalAmount=null,interestAmount = null;
		sqljob.addParameter( map.get("DEBT_NAME") );
		sqljob.addParameter( map.get("DAYCOUNT") );
		sqljob.addParameter( map.get("BUDGET_NAME") );
		//應償付金額
		capitalAmount = (BigDecimal) map.get("CAPITAL_AMOUNT1");
		interestAmount = (BigDecimal)map.get("INTEREST_AMOUNT1");
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));
		//撥入基金總額
		capitalAmount = (BigDecimal) map.get("CAPITAL_AMOUNT2");
		interestAmount = (BigDecimal)map.get("INTEREST_AMOUNT2");
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));
		//償付國庫券
		capitalAmount = (BigDecimal) map.get("CAPITAL_AMOUNT3");
		interestAmount = (BigDecimal)map.get("INTEREST_AMOUNT3");
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));
		//基金存款餘額(兌付期限內已撥未付)
		capitalAmount = ((BigDecimal) map.get("CAPITAL_AMOUNT2")).subtract((BigDecimal) map.get("CAPITAL_AMOUNT3"));
		interestAmount = ((BigDecimal) map.get("INTEREST_AMOUNT2")).subtract((BigDecimal) map.get("INTEREST_AMOUNT3"));
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));		

		//基金剩餘收回數
		capitalAmount = (BigDecimal) map.get("CAPITAL_AMOUNT5");
		interestAmount = (BigDecimal)map.get("INTEREST_AMOUNT5");
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));
		//撥入基金淨額
		capitalAmount = ((BigDecimal) map.get("CAPITAL_AMOUNT2")).subtract((BigDecimal) map.get("CAPITAL_AMOUNT5"));
		interestAmount = ((BigDecimal) map.get("INTEREST_AMOUNT2")).subtract((BigDecimal) map.get("INTEREST_AMOUNT5"));
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));	
		
		//未到期數額
		capitalAmount = (BigDecimal) map.get("CAPITAL_AMOUNT7");
		interestAmount = (BigDecimal)map.get("INTEREST_AMOUNT7");
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));

		//提前買回利息沖銷數
		BigDecimal rebackAmount = ((BigDecimal) map.get("UNPAYABLE_INTEREST_AMOUNT")).subtract((BigDecimal) map.get("PAYMENT_INTEREST_AMOUNT"));
		sqljob.addParameter(rebackAmount);	
		
		sqljob.addParameter( map.get("usrId") );
		sqljob.addParameter( new Timestamp( new Date().getTime() ) );
		
		String remark = "";
		if (rebackAmount.intValue() > 0 && !"".equals(map.get("BUDGET_NAME"))) {
			remark = "提前買回";
		}
		sqljob.addParameter(remark);
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );

		AccountQueryForm myForm = (AccountQueryForm) form;
		Date qryDate = DateUtil.str2Date( DateUtil.getLastDateOfMonth(myForm.getAccountYear(),myForm.getMonth()) );
		List issueIdList = (List) run.query( getAllIssueMainId(qryDate), new MapListHandler());
		String querySql = getVoucherAmountSql();
		String sourceBondType = "";
		Map reportAccountInfo = getReportAccountInfo();
		Map<String,Object> sumMap = new HashMap<String,Object>();
		Map<String,Object> totalMap = new HashMap<String,Object>();
		//初始化map
		for(Iterator iterator=reportAccountInfo.keySet().iterator();iterator.hasNext();) {
			String columnName = (String)iterator.next();
			sumMap.put(columnName,new BigDecimal(0));
			totalMap.put(columnName,new BigDecimal(0));
		}
		
		for(Iterator it=issueIdList.iterator();it.hasNext();)
		{
			
			Map issueMap = (Map) it.next();
			String bondType = (String) issueMap.get("bond_type");
			Integer dayCount = (Integer) issueMap.get("daycount");
			Integer issueId = (Integer) issueMap.get("id");
			String debtName = (String) issueMap.get("debt_name") ;
			String budgetName = (String)issueMap.get("budget_name");
			Object[] parameters = {dayCount,debtName,usrId,budgetName,issueId,qryDate};
			SQLJob sqljob = new SQLJob(querySql,parameters);

			Map<String,Object> insertMap = (Map) run.query( sqljob, new MapHandler());

			if(sourceBondType!=null &&!sourceBondType.equals(bondType)&&!sourceBondType.equals("")) {
				sumMap.put("DEBT_NAME","小         計" );
				sumMap.put("DAYCOUNT",0);
				sumMap.put("BUDGET_NAME","" );
				sumMap.put("usrId",usrId);
				
				run.update(connection,insTemp(sumMap));
				sumMap = new HashMap<String,Object>();
				
			}
			//初始化map
			for(Iterator iterator=reportAccountInfo.keySet().iterator();iterator.hasNext();) {
				String columnName = (String)iterator.next();
				BigDecimal tempAmount = (BigDecimal)sumMap.get(columnName);
				BigDecimal totalAmount = (BigDecimal)totalMap.get(columnName);
				
				if(tempAmount == null)
					tempAmount = new BigDecimal(0);

				if(totalAmount == null)
					totalAmount = new BigDecimal(0);
				
				tempAmount = tempAmount.add((BigDecimal)insertMap.get(columnName));
				totalAmount = totalAmount.add((BigDecimal)insertMap.get(columnName));
				sumMap.put(columnName,tempAmount);
				totalMap.put(columnName,totalAmount);
			
			}			
			sourceBondType = bondType;
			run.update(connection,insTemp(insertMap));

			if(!it.hasNext()) {
				sumMap.put("DEBT_NAME","    小         計        " );
				sumMap.put("DAYCOUNT",0);
				sumMap.put("BUDGET_NAME","" );
				sumMap.put("usrId",usrId);
				run.update(connection,insTemp(sumMap));
				
				totalMap.put("DEBT_NAME","    總         計        " );
				totalMap.put("DAYCOUNT",0);
				totalMap.put("BUDGET_NAME","" );
				totalMap.put("usrId",usrId);
				run.update(connection,insTemp(totalMap));
			}
		}
	}

	private Map getReportAccountInfo(){
		//PC01 國庫應撥數--本金                      
		//PC02 國庫應撥數--利息
		//PD03 應付到期短期借款--本金                  
		//PD04 應付到期短期借款--利息                  
		//PD07 到期已付(本金)
		//PD08 到期已付(利息)
		//
		String[] accountRules = {"PC01:D","PC02:D","PC04:D","PC05:D","PC07:D","PC08:D",
				                 "PC10:D","PC11:D","PD01:A","PD02:A","PD02:D","PD14:C;PD08:C"};
		
		String[] columnName = {"CAPITAL_AMOUNT1","INTEREST_AMOUNT1","CAPITAL_AMOUNT2","INTEREST_AMOUNT2","CAPITAL_AMOUNT3","INTEREST_AMOUNT3",
								"CAPITAL_AMOUNT5","INTEREST_AMOUNT5","CAPITAL_AMOUNT7","INTEREST_AMOUNT7","UNPAYABLE_INTEREST_AMOUNT","PAYMENT_INTEREST_AMOUNT"};
		
		Map reportAccountInfo = new HashMap();
		for(int i=0;i<accountRules.length;i++) {
			reportAccountInfo.put(columnName[i],accountRules[i]);
		}
		
		return reportAccountInfo;
	}
}