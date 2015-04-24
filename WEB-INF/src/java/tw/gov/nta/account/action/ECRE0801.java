package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
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

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ECRE0801 extends ExcelReportBaseAction {
	private final static String TEMP_TABLE_NAME = "ECRE08_RPT";

	protected SQLJob getAllBankId(Integer issueId)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT b.bank_id,c.bank_name,sum(b.issue_amount) as issue_amount,sum(b.origin_interest_amount) as origin_interest_amount \n");
		sqljob.appendSQL(",case when a.issue_amount = a.capital_amount then 1 else 0 end as check_over \n ");
		sqljob.appendSQL("from issue_main a,debt_main b,bank_ref c \n ");
		sqljob.appendSQL("where a.id = b.issue_id \n ");
		sqljob.appendSQL("  and b.bank_id = c.id \n ");
		sqljob.appendSQL("  and a.id = ?\n  and b.debt_code <> 35 and b.accrue = 'Y'");
		sqljob.appendSQL("group by b.bank_id,c.bank_name,a.issue_amount,a.capital_amount ");
		sqljob.appendSQL("order by c.bank_name ");
		sqljob.addParameter(issueId);
		System.out.println(sqljob.toString());
		return sqljob;		
	}	
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		AccountQueryForm myform = (AccountQueryForm) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		
		List bankList = (List) run.query( getAllBankId(myform.getIssueId()), new MapListHandler());
		int i=0;
		//執行 insert
		for(Iterator bankIterator = bankList.iterator();bankIterator.hasNext();) {
			i+=1;
			
//		for(int i=0;i<11;i++) {
//			Iterator bankIterator = bankList.iterator();
			Map bank = (Map)bankIterator.next();
			
				Map insertMap = getInsertData(myform.getIssueId(),myform,bank,run);
				insertMap.put("usrid", usrId);
				insertMap.put("mod_date", new Timestamp( new Date().getTime() ));
			
			run.update(connection,insTemp(TEMP_TABLE_NAME,insertMap));
		}
		
		if (i<11){
			
			for(int j=i;j<11;j++)
			{
				Map insertMap = new HashMap();
				insertMap.put("usrid", usrId);
				insertMap.put("mod_date", new Timestamp( new Date().getTime() ));
				
				run.update(connection,insTemp(TEMP_TABLE_NAME,insertMap));
			}
		}
		
	}

	private Map getInsertData(int issueId, AccountQueryForm myform,Map bankMap,SQLRunner run) throws SQLException {
		// TODO Auto-generated method stub
		String lastDate = myform.getSQLLastDate();
		String firstDate = myform.getSQLLastDate().substring(0,7)+"/01";
		Integer bankId = (Integer)bankMap.get("bank_id");
		Map insertMap = countInterest(issueId,lastDate,firstDate,bankId,run);
		insertMap.put("bank_name",bankMap.get("bank_name"));
		insertMap.put("issue_amount",bankMap.get("issue_amount"));
		return insertMap;
	}
	
	public Map countInterest(int issueId, String lastDate, String firstDate ,Integer bankId,SQLRunner run) throws SQLException{
		Map insertMap = new HashMap();
	
		//預估應付利息起
		if(issueId ==3477){
			int i = 0;
		}
		//計算報表日期之前的利息調整
		SQLJob job1 = new SQLJob();
		job1.appendSQL("select isnull(sum(change_interest_amount),0) as change_interest_amount from interest_adjust_main,debt_main  ");
		job1.appendSQL(" where debt_id = debt_main.id and debt_main.debt_code <> 35 and debt_main.bank_id = ? and debt_main.issue_id = ? and debt_main.accrue = 'Y' and adjust_type = 'R' and change_date <='"+lastDate+"'");
		job1.addParameter(bankId);
		job1.addParameter(issueId);
		Map changeInterstAmountMap  = (Map) run.query( job1, new MapHandler());
		
		//計算因為續借增加的利息
		SQLJob job6 = new SQLJob();
		job6.appendSQL("select isnull(sum(add_interest_amount),0) as add_interest_amount from extend_due_date_main,debt_main ");
		job6.appendSQL(" where debt_id = debt_main.id and debt_main.bank_id = ? and debt_main.issue_id = ? and debt_main.debt_code <> 35 and debt_main.accrue = 'Y' and ins_time <='"+lastDate+"'");
		job6.addParameter(bankId);
		job6.addParameter(issueId);
		//System.out.println("job6 ="+job6.toString());
		
		Map addInterstAmountMap  = (Map) run.query( job6, new MapHandler());
		
		SQLJob job8 = new SQLJob();
		job8.appendSQL("select isnull(sum(origin_interest_amount),0) as origin_interest_amount from debt_main ");
		job8.appendSQL(" where debt_main.bank_id = ? and debt_main.issue_id = ? and debt_main.accrue = 'Y' and debt_main.debt_code <> 35");
		job8.addParameter(bankId);
		job8.addParameter(issueId);
		
		Map originInterstAmountMap  = (Map) run.query( job8, new MapHandler());
		//預估利息 = 原始預估利息 + 報表日期前的利息調整 + 因續借增加的利息
		BigDecimal estimateInterest = ((BigDecimal)originInterstAmountMap.get("origin_interest_amount")).add((BigDecimal)changeInterstAmountMap.get("change_interest_amount")).setScale(0,BigDecimal.ROUND_HALF_UP);
		estimateInterest = estimateInterest.add((BigDecimal)addInterstAmountMap.get("add_interest_amount"));
//		BigDecimal saveEstimateInterest = estimateInterest;
//		saveEstimateInterest = saveEstimateInterest.setScale(0,BigDecimal.ROUND_DOWN);
//		insertMap.put("shd_interest",saveEstimateInterest);
		insertMap.put("shd_interest",estimateInterest);
		//預估應付利息end
		//本月支付利息,截至本月底支付例累計數start
		SQLJob job2 = new SQLJob();
		job2.appendSQL("select isnull(sum(case when e.repay_date >='"+firstDate+"' and e.repay_date <='"+lastDate+"'  then e.interest_amount else 0 end),0) as pay_interest,");
		job2.appendSQL("       isnull(sum(case when e.repay_date <= '"+lastDate+"' then e.interest_amount else 0 end),0) as sum_interest ");
		job2.appendSQL("       from  debt_main,payment_main e where e.debt_id = debt_main.id and debt_main.debt_code <> 35 and debt_main.accrue = 'Y' and  debt_main.bank_id = ? and debt_main.issue_id = ? ");
		job2.addParameter(bankId);
		job2.addParameter(issueId);
		
		//System.out.println("job2 ="+job2.toString());
		
		Map payInterestMap  = (Map) run.query( job2, new MapHandler());
		BigDecimal sumInterest = (BigDecimal)payInterestMap.get("sum_interest");
		
		//System.out.println("截至本月底支付例累計數 sumInterest ="+sumInterest);
		
		insertMap.putAll(payInterestMap);
//		本月支付利息,截至本月底支付例累計數start
		SQLJob job3 = new SQLJob();
		job3.appendSQL("select d.id from debt_main d where d.issue_id=? and d.debt_code <> 35 and d.bank_id = ? and d.accrue = 'Y'");
		job3.addParameter(issueId);		
		job3.addParameter(bankId);

		List debtList  = (List) run.query( job3, new MapListHandler());
		
		BigDecimal remark_interest = new BigDecimal(0);
		BigDecimal remain_interest = new BigDecimal(0);
		
		for(Iterator debtIterator = debtList.iterator();debtIterator.hasNext();) {
			Map debtMap = (Map)debtIterator.next();
			Integer debtId = (Integer)debtMap.get("id");
			SQLJob job4 = new SQLJob();
			job4.appendSQL("select isnull(debt_main.issue_amount,0) as issue_amount,isnull(debt_main.origin_interest_amount,0) as origin_interest_amount,isnull(sum(case when e.repay_date <= '"+lastDate+"' then e.capital_amount else 0 end),0) as sum_capital");
			job4.appendSQL("       ,isnull(sum(case when e.repay_date <= '"+lastDate+"' then e.interest_amount else 0 end),0) as sum_interest ");
			job4.appendSQL("       ,isnull(sum(case when e.capital_amount > 0 then e.manage_interest_amount - e.interest_amount else 0 end),0) as sum_discount_amount ");
			job4.appendSQL("       from  debt_main,payment_main e where debt_main.id = ? and e.repay_date <='"+lastDate+"' and debt_main.id = e.debt_id group by debt_main.issue_amount,debt_main.origin_interest_amount ");
			job4.addParameter(debtId);	
			//System.out.println("job4 ="+job4.toString());

			
			SQLJob job5 = new SQLJob();
			job5.appendSQL("select isnull(sum(change_interest_amount),0) as change_interest_amount from interest_adjust_main  ");
			job5.appendSQL(" where debt_id = ? and adjust_type = 'R' and change_date <='"+lastDate+"' ");
			job5.addParameter(debtId);	

			
			SQLJob job7 = new SQLJob();
			job7.appendSQL("select isnull(sum(add_interest_amount),0) as add_interest_amount from extend_due_date_main");
			job7.appendSQL(" where debt_id = ? and ins_time <='"+lastDate+"'");
			job7.addParameter(debtId);
			
			Map addDebtInterstAmountMap  = (Map) run.query( job7, new MapHandler());
			
			Map payCapitalMap  = (Map) run.query( job4, new MapHandler());
			Map adjustAmountMap = (Map)run.query( job5, new MapHandler());
			
			BigDecimal issueAmount = (payCapitalMap!=null && payCapitalMap.get("issue_amount")!=null)?(BigDecimal)payCapitalMap.get("issue_amount"):new BigDecimal(0);
			BigDecimal originInterestAmount = ((payCapitalMap!=null && payCapitalMap.get("origin_interest_amount")!=null)?(BigDecimal)payCapitalMap.get("origin_interest_amount"):new BigDecimal(0))
												.add((BigDecimal)addDebtInterstAmountMap.get("add_interest_amount"));
			BigDecimal adjustAmount = (payCapitalMap!=null && payCapitalMap.get("change_interest_amount")!=null)?(BigDecimal)adjustAmountMap.get("change_interest_amount"):new BigDecimal(0);
			BigDecimal payCapitalAmount = (payCapitalMap!=null && payCapitalMap.get("sum_capital")!=null)?(BigDecimal)payCapitalMap.get("sum_capital"):new BigDecimal(0);
			BigDecimal payInterestAmount = (payCapitalMap!=null && payCapitalMap.get("sum_interest")!=null)?(BigDecimal)payCapitalMap.get("sum_interest"):new BigDecimal(0);
			BigDecimal payDiscountAmount = (payCapitalMap!=null && payCapitalMap.get("sum_discount_amount")!=null)?(BigDecimal)payCapitalMap.get("sum_discount_amount"):new BigDecimal(0);
			BigDecimal debtRemainAmount = originInterestAmount.add(adjustAmount).subtract(payInterestAmount).subtract(payDiscountAmount);
			
			if(payCapitalAmount.longValue() > 0) {
				remark_interest = remark_interest.add(payDiscountAmount);
//				System.out.println("利息沖銷數1 payDiscountAmount ="+payDiscountAmount);
			}
			remain_interest = remain_interest.add(debtRemainAmount);
			//remark_interest = remark_interest.add(debtRemainAmount);
			//System.out.println("利息沖銷數2 debtRemainAmount =originInterestAmount:"+originInterestAmount+" + adjustAmount:"+adjustAmount+" - payInterestAmount:"+payInterestAmount+" - payDiscountAmount:" +payDiscountAmount);
			//System.out.println("利息沖銷數2 debtRemainAmount ="+debtRemainAmount);
		}
		insertMap.put("remark",remark_interest);//利息沖銷數
		//System.out.println("利息沖銷數 remark_interest ="+remark_interest);
		//insertMap.put("nouse_interest",remain_interest);//預估未支付利息數	
		BigDecimal nouseInterest = estimateInterest.setScale(0,BigDecimal.ROUND_DOWN).subtract(sumInterest).subtract(remark_interest);
//		nouseInterest = nouseInterest.setScale(0,BigDecimal.ROUND_DOWN);
		insertMap.put("nouse_interest",nouseInterest);
//		insertMap.put("nouse_interest",estimateInterest.subtract(sumInterest).subtract(remark_interest));
		//System.out.println("預估未支付利息數 nouse_interest  = estimateInterest("+estimateInterest+") - sumInterest("+sumInterest+") - remark_interest("+remark_interest+")");
		return insertMap;
	}
}
