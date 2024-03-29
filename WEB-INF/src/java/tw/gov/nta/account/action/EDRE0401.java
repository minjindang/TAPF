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

public class EDRE0401 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "EDRE04_RPT";

	protected SQLJob getAllIssueMainId(Date qryDate)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT I.id,b.budget_name");
		sqljob.appendSQL(",I.debt_name");
		sqljob.appendSQL("  FROM issue_main I ,budget_ref b");
		sqljob.appendSQL(" WHERE b.id=i.budget_code ");
		//2007/3/5修改
		//sqljob.appendSQL("   AND i.budget_code <> 4 ");
		sqljob.appendSQL("   AND i.debt_code <> 25 ");
		sqljob.appendSQL("   AND i.debt_type='D' ");
		sqljob.appendSQL("   AND I.issue_date<=?");
		sqljob.appendSQL("   group by i.id,b.budget_name,i.debt_name,i.account_year,i.serial_no");
		sqljob.appendSQL("   order by i.account_year,i.serial_no");
		sqljob.addParameter( new Timestamp( qryDate.getTime() ) );
		System.out.println(sqljob);
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
				if(!accountRule.equals("PC02:D;PC02:C")){
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
				//0970630修改=================
				}else if (accountRule.equals("PC02:D;PC02:C")){
					System.out.print("PC02:D;PC02:C");
					
					if(accountType.equals("D")){
						queryString.append(" isnull(sum(case when a.account_code = '"+accountCode+"' then ");
						if("A".equals(accountType)) {
							queryString.append(" case when d.account_type = a.account_type then d.account_amount else d.account_amount * -1 end ");
						}else {
							queryString.append(" case when d.account_type = '"+accountType+"' then d.account_amount else 0 end ");
						}	
						queryString.append(" else 0 end),0) ");
					}else if(accountType.equals("C")){
						queryString.append("- isnull(sum(case when a.account_code = '"+accountCode+"' then ");
						if("A".equals(accountType)) {
							queryString.append(" case when d.account_type = a.account_type then d.account_amount else d.account_amount * -1 end ");
						}else {
							queryString.append(" case when d.account_type = '"+accountType+"' then case when M.phase_id in ('93','95') then case when source_type='S' then d.account_amount else 0 end ");
						}	
						queryString.append(" else 0 end else 0 end else 0 end),0) ");
					}					

//					queryString.append(" else 0 end),0) ");
					if(accountTokenizer.hasMoreTokens()) {
//						queryString.append("+");
					}else {
						queryString.append("as "+columnName+", \n");					
					}
				}
				//0970630修改=================
			}
		}		

		queryString.append(" ? As DEBT_NAME,");
		queryString.append(" ? As usrId,");
		queryString.append(" ? As budget_name ");
		queryString.append("  FROM voucher_main M, voucher_det D ,account_ref A \n");
		queryString.append(" WHERE M.id=D.voucher_id \n");
		queryString.append("   AND A.id=D.account_code \n");
		queryString.append("   AND M.issue_id=? \n");
		queryString.append("   and M.voucher_Date <=? \n");
		queryString.append("   And M.debt_type_id=4 \n");
		queryString.append("   And a.debt_type=4 \n");
		System.out.println(queryString.toString());

		return queryString.toString();
		
	}

	protected SQLJob insTemp(Map map,List prepayDateList)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME);
		sqljob.appendSQL(" ( DEBT_NAME ,");
		sqljob.appendSQL(" PLANPAY_CAPITAL, PLANPAY_INTEREST, PLANPAY_TOTAL, ");
		sqljob.appendSQL("  PREPAY_CAPITAL,  PREPAY_INTEREST,  PREPAY_TOTAL, ");
		sqljob.appendSQL("  NOWPAY_CAPITAL,  NOWPAY_INTEREST,  NOWPAY_TOTAL, ");
		sqljob.appendSQL("     PAY_CAPITAL,     PAY_INTEREST,     PAY_TOTAL, ");
		sqljob.appendSQL("   NOPAY_CAPITAL,   NOPAY_INTEREST,   NOPAY_TOTAL, ");
		sqljob.appendSQL("  DUEPAY_CAPITAL,  DUEPAY_INTEREST,  DUEPAY_TOTAL, ");
		sqljob.appendSQL(" AHEAD_INTEREST, ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK ,budget_name");
		sqljob.appendSQL(" ) VALUES ( ");
		sqljob.appendSQL(" ?,?,?,?,?");
		sqljob.appendSQL(",?,?,?,?,?");
		sqljob.appendSQL(",?,?,?,?,?");
		sqljob.appendSQL(",?,?,?,?,?");
		sqljob.appendSQL(",?,?,?,?");
		sqljob.appendSQL(" ) ");

		sqljob.addParameter( map.get("DEBT_NAME") );
		//1.應償付總額
		sqljob.addParameter( map.get("PLANPAY_CAPITAL") );
		sqljob.addParameter( map.get("PLANPAY_INTEREST") );
		sqljob.addParameter( ((BigDecimal) map.get("PLANPAY_CAPITAL")).add( (BigDecimal) map.get("PLANPAY_INTEREST") ) );
		//2.已到期或提前償付總額
		sqljob.addParameter( map.get("PREPAY_CAPITAL") );
		sqljob.addParameter( map.get("PREPAY_INTEREST") );
		sqljob.addParameter( ((BigDecimal) map.get("PREPAY_CAPITAL")).add( (BigDecimal) map.get("PREPAY_INTEREST") ) );
		//3.未到期數額
		sqljob.addParameter( ((BigDecimal) map.get("PLANPAY_CAPITAL")).subtract( (BigDecimal) map.get("PREPAY_CAPITAL") ) );
		sqljob.addParameter( ((BigDecimal) map.get("PLANPAY_INTEREST")).subtract( ((BigDecimal) map.get("PREPAY_INTEREST") )).subtract( (BigDecimal) map.get("UPGET_INTEREST")) );
		sqljob.addParameter( ((BigDecimal) map.get("PLANPAY_CAPITAL")).subtract( (BigDecimal) map.get("PREPAY_CAPITAL") ).add( ((BigDecimal) map.get("PLANPAY_INTEREST")).subtract( (BigDecimal) map.get("PREPAY_INTEREST") ).subtract( (BigDecimal) map.get("UPGET_INTEREST") ) ));
		//4.已撥付數額
		sqljob.addParameter( map.get("PAY_CAPITAL") );
		sqljob.addParameter( map.get("PAY_INTEREST") );
		sqljob.addParameter( ((BigDecimal) map.get("PAY_CAPITAL")).add( (BigDecimal) map.get("PAY_INTEREST") ) );
		//5.到期尚未撥付數額(2-4)
		sqljob.addParameter( ((BigDecimal) map.get("PREPAY_CAPITAL")).subtract( (BigDecimal) map.get("PAY_CAPITAL") ) );
		sqljob.addParameter( ((BigDecimal) map.get("PREPAY_INTEREST")).subtract( (BigDecimal) map.get("PAY_INTEREST") ) );
		sqljob.addParameter( ((BigDecimal) map.get("PREPAY_CAPITAL")).subtract( (BigDecimal) map.get("PAY_CAPITAL") ).add( ((BigDecimal) map.get("PREPAY_INTEREST")).subtract( (BigDecimal) map.get("PAY_INTEREST") ) ) );
		//6.到期未撥及未到期數額(3+5)
		sqljob.addParameter( ((BigDecimal) map.get("NOWPAY_CAPITAL")).add( ((BigDecimal) map.get("PREPAY_CAPITAL")).subtract( (BigDecimal) map.get("PAY_CAPITAL") ) ) );
		sqljob.addParameter( ((BigDecimal) map.get("NOWPAY_INTEREST")).add( ((BigDecimal) map.get("PREPAY_INTEREST")).subtract( (BigDecimal) map.get("PAY_INTEREST") ) ) );
		sqljob.addParameter( ((BigDecimal) map.get("NOWPAY_CAPITAL")).add( ((BigDecimal) map.get("PREPAY_CAPITAL")).subtract( (BigDecimal) map.get("PAY_CAPITAL") ) ).add( ((BigDecimal) map.get("NOWPAY_INTEREST")).add( ((BigDecimal) map.get("PREPAY_INTEREST")).subtract( (BigDecimal) map.get("PAY_INTEREST") ) ) ) );
		//7.提前償還利息沖銷數
		
		BigDecimal upgetInterestAmount = (BigDecimal) map.get("UPGET_INTEREST");
		sqljob.addParameter(upgetInterestAmount );

		sqljob.addParameter( map.get("usrId") );
		sqljob.addParameter( new Timestamp( new Date().getTime() ) );
		String remark = "";
		
		if(upgetInterestAmount.intValue() > 0) {
			remark = "";
			for(Iterator iterator = prepayDateList.iterator();iterator.hasNext();){
				Map prepayDate = (Map)iterator.next();
				if(!"".equals(remark)){
					remark = remark +"、";
				}
				remark = remark+DateUtil.date2ROCStr((Date)prepayDate.get("repay_date"),"yyy/mm/dd");
			}
			if(!"".equals(remark)){
				remark = remark + "提前償付";
			}
		}
		
		sqljob.addParameter(remark);
		sqljob.addParameter( map.get("budget_name") );
		System.out.println(sqljob);
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

		for(Iterator it=issueIdList.iterator();it.hasNext();)
		{
			
			Map issueMap = (Map) it.next();
			Integer issueId = (Integer) issueMap.get("id");
			String debtName = (String) issueMap.get("debt_name") ;
			String budgetName = (String)issueMap.get("budget_name");
			Object[] parameters = {debtName,usrId,budgetName,issueId,qryDate};
			SQLJob sqljob = new SQLJob(querySql,parameters);
			Map<String,Object> insertMap = (Map) run.query( sqljob, new MapHandler());
			List payDateList = (List)run.query(getPayDateList(issueId),new MapListHandler());
			run.update(connection,insTemp(insertMap,payDateList));

		}
	}

	private SQLJob getPayDateList(Integer issueId) {
		// TODO Auto-generated method stub
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT distinct p.repay_date");
		sqljob.appendSQL("  FROM issue_main I ,payment_main p");
		sqljob.appendSQL(" WHERE p.issue_id = i.id ");
		sqljob.appendSQL("   AND p.repay_date < i.due_date ");
		sqljob.appendSQL("   AND i.id = ? ");
		sqljob.addParameter( issueId );
		System.out.println(sqljob);
		return sqljob;
	}

	private Map getReportAccountInfo(){
		//PC01 國庫應撥數--本金                      
		//PC02 國庫應撥數--利息
		//PD03 應付到期短期借款--本金                  
		//PD04 應付到期短期借款--利息                  
		//PD07 到期已付(本金)
		//PD08 到期已付(利息)
		//
		String[] accountRules = {"PC01:D","PC02:D;PC02:C","PD05:D;PD09:D","PD06:D;PD10:D",
				                 "PD01:A","PD02:A","PD07:C;PC03:D","PD08:C;PC04:D","PD11:C"};
		
		String[] columnName = {"PLANPAY_CAPITAL","PLANPAY_INTEREST","PREPAY_CAPITAL","PREPAY_INTEREST",
								"NOWPAY_CAPITAL","NOWPAY_INTEREST","PAY_CAPITAL","PAY_INTEREST","UPGET_INTEREST"};
		
		Map reportAccountInfo = new HashMap();
		for(int i=0;i<accountRules.length;i++) {
			reportAccountInfo.put(columnName[i],accountRules[i]);
		}
		
		return reportAccountInfo;
	}
}