package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.sql.debt.DebtMain;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EARE0701 extends DefaultAction {
	
	protected SQLJob delTemp(ActionForm form,String usrId,String tableName){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM ");
		sqljob.appendSQL(tableName);
		System.out.println(sqljob);
		return sqljob;
	}
	
	protected SQLJob EARE0701_RPT(ActionForm form,String usrId){
		AccountQueryForm myform = (AccountQueryForm)form;
		String queryDate = myform.getSQLLastDate();
		String queryStartDate = queryDate.substring(0,queryDate.length() - 2) + "01";
		String issueId = String.valueOf(myform.getIssueId());
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("insert into EARE0701_RPT ( ");
		sqljob.appendSQL("USRID,MOD_DATE,REMARK,capital_serial,manage_capital_amount,capital_amount,total_payment,unpayed_capital,repay_date ) ");    
		sqljob.appendSQL("(select '"+usrId +"',CURRENT_TIMESTAMP,null,");    
		sqljob.appendSQL("c.capital_serial, sum(d.capital_amount), ");  
		sqljob.appendSQL("sum (case when d.repay_date between '"+queryStartDate+"' and '"+queryDate+"' then d.capital_amount else 0 end) as pay_amount, ");  
		sqljob.appendSQL("sum ( isnull(d.capital_amount,0)) , ");  
		sqljob.appendSQL("0 as remain_amount, ");  
		sqljob.appendSQL("dateadd(DD,-1,c.repay_date) as repay_date ");  
		sqljob.appendSQL("from  debt_plan_det c, payment_main d,issue_main i ");  
		sqljob.appendSQL("where c.id = d.plan_id and c.issue_id = i.id");  		
		sqljob.appendSQL("and c.interest_serial = d.interest_serial ");  
		sqljob.appendSQL("and c.capital_serial = d.capital_serial ");  
		sqljob.appendSQL("and c.capital_serial <> 0 ");  
		sqljob.appendSQL("and c.repay_date <= '"+queryDate+"' ");  
		sqljob.appendSQL("and d.repay_type = '0' "); 
		//20090831 chrisWu 合併計算相同債務別(增額與原發行)
		List<DebtMain> debtDataList = myform.getDebtList();
		DebtMain debtData = new DebtMain();
		for(DebtMain debtDataMap: debtDataList)
		{
			if (debtDataMap.getId().equals(myform.getDebtId()))
				debtData = debtDataMap;
		}
		if (myform.getDebtList().size() > 1)
		{
			sqljob.appendSQL("and c.debt_id = ? ");
			sqljob.addParameter(myform.getDebtId());
		} else {
			sqljob.appendSQL("and (i.source_issue_id = (select source_issue_id from issue_main where id = ? ) " +
					"and (select budget_code from debt_main where id = d.debt_id) = ? )");
			sqljob.addParameter(myform.getIssueId());
			sqljob.addParameter(debtData.getBudgetCode());			
		}
		sqljob.appendSQL("and (select budget_code from debt_main where id = ? ) = ? ");
		sqljob.addParameter(myform.getDebtId());
		sqljob.addParameter(debtData.getBudgetCode());		
		sqljob.appendSQL("and c.delete_mark <> 'Y' and d.repay_date = d.plan_repay_date ");
		sqljob.appendSQL("group by  c.capital_serial,c.repay_date ");  
		//20101228chris wu加入公債提前買回   
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select '"+usrId +"',CURRENT_TIMESTAMP,null,");    
		sqljob.appendSQL("c.capital_serial, sum(d.capital_amount), ");  
		sqljob.appendSQL("sum (case when d.repay_date between '"+queryStartDate+"' and '"+queryDate+"' then d.capital_amount else 0 end) as pay_amount, ");  
		sqljob.appendSQL("sum ( isnull(d.capital_amount,0)) , ");  
		sqljob.appendSQL("0 as remain_amount, ");  
		sqljob.appendSQL("dateadd(DD,-1,d.repay_date) as repay_date ");  
		sqljob.appendSQL("from  debt_plan_det c, payment_main d,issue_main i ");  
		sqljob.appendSQL("where c.id = d.plan_id and c.issue_id = i.id");  	
		sqljob.appendSQL("and i.debt_type = 'A' ");
		sqljob.appendSQL("and d.capital_serial <> 0 ");  
		sqljob.appendSQL("and d.repay_date <= '"+queryDate+"' ");  
		sqljob.appendSQL("and d.repay_date >='2010/01/01'");
		sqljob.appendSQL("and d.repay_date <> d.plan_repay_date ");
		sqljob.appendSQL("and d.repay_type = '0' "); 
		//20090831 chrisWu 合併計算相同債務別(增額與原發行)
		for(DebtMain debtDataMap: debtDataList)
		{
			if (debtDataMap.getId().equals(myform.getDebtId()))
				debtData = debtDataMap;
		}
		if (myform.getDebtList().size() > 1)
		{
			sqljob.appendSQL("and c.debt_id = ? ");
			sqljob.addParameter(myform.getDebtId());
		} else {
			sqljob.appendSQL("and (i.source_issue_id = (select source_issue_id from issue_main where id = ? ) " +
					"and (select budget_code from debt_main where id = d.debt_id) = ? )");
			sqljob.addParameter(myform.getIssueId());
			sqljob.addParameter(debtData.getBudgetCode());			
		}
		sqljob.appendSQL("and (select budget_code from debt_main where id = ? ) = ? ");
		sqljob.addParameter(myform.getDebtId());
		sqljob.addParameter(debtData.getBudgetCode());		
		sqljob.appendSQL("group by  c.capital_serial,d.repay_date)"); 
		System.out.println(sqljob);
		return sqljob;
	}
	
	protected SQLJob EARE0702_RPT(ActionForm form,String usrId,Map map){
		SQLJob sqljob = new SQLJob();
		AccountQueryForm myform = (AccountQueryForm)form;
		String queryDate = myform.getSQLLastDate();
		String queryStartDate = queryDate.substring(0,queryDate.length() - 2) + "01";
		sqljob.appendSQL("insert into EARE0702_RPT ( ");
		sqljob.appendSQL("USRID,MOD_DATE,capital_serial,repay_date, "); 
		sqljob.appendSQL("plan_of_100k,plan_of_500k,plan_of_1000k,plan_of_5000k,plan_amount,");
		sqljob.appendSQL("amount_of_100k,amount_of_500k,amount_of_1000k,amount_of_5000k,total_amount,");
		sqljob.appendSQL("payment_of_100k,payment_of_500k,payment_of_1000k,payment_of_5000k,mon_total_payment )");
		sqljob.appendSQL("select ?,?,?,?,?,?,?,?,?,");
		
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Date());
		sqljob.addParameter(((Integer)map.get("capital_serial")));
		sqljob.addParameter((Date)map.get("repay_date"));
		sqljob.addParameter((Long)map.get("A1"));
		sqljob.addParameter((Long)map.get("A2"));
		sqljob.addParameter((Long)map.get("A3"));
		sqljob.addParameter((Long)map.get("A4"));
		sqljob.addParameter((BigDecimal)map.get("Sum"));

		sqljob.appendSQL("sum(case when  b.ticket_amount = 100000 ");
		sqljob.appendSQL("and  a.repay_date between '"+queryStartDate+"' and '"+queryDate+"' then b.ticket_count else 0 end) , ");
		sqljob.appendSQL("sum(case when  b.ticket_amount = 500000 ");
		sqljob.appendSQL("and  a.repay_date between '"+queryStartDate+"' and '"+queryDate+"' then b.ticket_count else 0 end) , ");
		sqljob.appendSQL("sum(case when  b.ticket_amount = 1000000 ");
		sqljob.appendSQL("and  a.repay_date between '"+queryStartDate+"' and '"+queryDate+"' then b.ticket_count else 0 end) , ");
		sqljob.appendSQL("sum(case when  b.ticket_amount = 5000000  ");
		sqljob.appendSQL("and  a.repay_date between '"+queryStartDate+"' and '"+queryDate+"' then b.ticket_count else 0 end) , ");
		
		sqljob.appendSQL("((sum(case when  b.ticket_amount = 100000 and  a.repay_date between '"+queryStartDate+"' and '"+queryDate+"' then b.ticket_count else 0 end)) * 100000 +");
		sqljob.appendSQL("(sum(case when  b.ticket_amount = 500000 and  a.repay_date between '"+queryStartDate+"' and '"+queryDate+"' then b.ticket_count else 0 end)) * 500000 +");
		sqljob.appendSQL("(sum(case when  b.ticket_amount = 1000000 and  a.repay_date between '"+queryStartDate+"' and '"+queryDate+"' then b.ticket_count else 0 end)) * 1000000 +");
		sqljob.appendSQL("(sum(case when  b.ticket_amount = 5000000 and  a.repay_date between '"+queryStartDate+"' and '"+queryDate+"' then b.ticket_count else 0 end)) * 5000000), ");

		sqljob.appendSQL("sum(case when  b.ticket_amount = 100000 then b.ticket_count else 0 end) , ");
		sqljob.appendSQL("sum(case when  b.ticket_amount = 500000 then b.ticket_count else 0 end) , ");
		sqljob.appendSQL("sum(case when  b.ticket_amount = 1000000  then b.ticket_count else 0 end) , ");
		sqljob.appendSQL("sum(case when  b.ticket_amount = 5000000  then b.ticket_count else 0 end) , ");
		
		sqljob.appendSQL("((sum(case when  b.ticket_amount = 100000 then b.ticket_count else 0 end)) * 100000 +");
		sqljob.appendSQL("(sum(case when  b.ticket_amount = 500000 then b.ticket_count else 0 end)) * 500000 +");
		sqljob.appendSQL("(sum(case when  b.ticket_amount = 1000000 then b.ticket_count else 0 end)) * 1000000 +");
		sqljob.appendSQL("(sum(case when  b.ticket_amount = 5000000 then b.ticket_count else 0 end)) * 5000000)");		
		
		sqljob.appendSQL("from payment_main a, payment_ticket_det b ");
		sqljob.appendSQL("where a.id = b.payment_id ");
		sqljob.appendSQL("and a.plan_id = ? and a.repay_type = '1' and a.repay_type = '1'");
		sqljob.addParameter(((Integer)map.get("plan_id")));
		sqljob.appendSQL("and a.repay_date <= '"+queryDate+"' ");
		
		System.out.println("EARE0702_RPT ： "+sqljob);
		return sqljob;
	}
	public SQLJob getDebtTicket(ActionForm form)
	{
		AccountQueryForm myform = (AccountQueryForm)form;

		SQLJob sqljob = new SQLJob();
		String queryDate = myform.getSQLLastDate();
		sqljob.appendSQL("select a.id as plan_id,a.capital_serial,dateadd(DD,-1,a.repay_date) as repay_date,");
		sqljob.appendSQL("          sum(case when  b.ticket_amount = 100000  then b.ticket_count else 0 end) ");
		sqljob.appendSQL("          - (select isnull(sum(c.ticket_count),0) from issue_exchange_ticket_det c  ");
		sqljob.appendSQL("             where   a.debt_id *= c.debt_id  ");
		sqljob.appendSQL("                and a.interest_serial *= c.interest_serial ");
		sqljob.appendSQL("                and a.capital_serial *= c.capital_serial  ");
		sqljob.appendSQL("                and  c.ticket_amount = 100000  ");
		sqljob.appendSQL("               and c. exchange_date <= '"+queryDate+"' )  as A1 ,  ");
		sqljob.appendSQL("          sum(case when  b.ticket_amount = 500000  then b.ticket_count else 0 end) ");
		sqljob.appendSQL("          - (select isnull(sum(c.ticket_count),0) from issue_exchange_ticket_det c  ");
		sqljob.appendSQL("             where   a.debt_id *= c.debt_id  ");
		sqljob.appendSQL("               and a.interest_serial *= c.interest_serial ");
		sqljob.appendSQL("                and a.capital_serial *= c.capital_serial  ");
		sqljob.appendSQL("               and  c.ticket_amount = 500000  ");
		sqljob.appendSQL("                and c. exchange_date <= '"+queryDate+"' )  as A2 ,  ");
		sqljob.appendSQL("          sum(case when  b.ticket_amount = 1000000  then b.ticket_count else 0 end) ");
		sqljob.appendSQL("          - (select isnull(sum(c.ticket_count),0) from issue_exchange_ticket_det c  ");
		sqljob.appendSQL("             where   a.debt_id *= c.debt_id  ");
		sqljob.appendSQL("                and a.interest_serial *= c.interest_serial ");
		sqljob.appendSQL("                and a.capital_serial *= c.capital_serial  ");
		sqljob.appendSQL("                and  c.ticket_amount = 1000000  ");
		sqljob.appendSQL("                and c. exchange_date <= '"+queryDate+"' )  as A3 ,  ");
		sqljob.appendSQL("          sum(case when  b.ticket_amount = 5000000  then b.ticket_count else 0 end) ");
		sqljob.appendSQL("          - (select isnull(sum(c.ticket_count),0) from issue_exchange_ticket_det c  ");
		sqljob.appendSQL("             where   a.debt_id *= c.debt_id  ");
		sqljob.appendSQL("                and a.interest_serial *= c.interest_serial ");
		sqljob.appendSQL("                and a.capital_serial *= c.capital_serial  ");
		sqljob.appendSQL("                and  c.ticket_amount = 5000000  ");
		sqljob.appendSQL("                and c. exchange_date <= '"+queryDate+"' )  as A4 , ");
		sqljob.appendSQL("           a.capital_amount -  (select isnull(sum(c.total_amount) / 4,0) from issue_exchange_ticket_det c  ");
		sqljob.appendSQL("		             where   a.debt_id *= c.debt_id  ");
		sqljob.appendSQL("		                and a.interest_serial *= c.interest_serial ");
		sqljob.appendSQL("		                and a.capital_serial *= c.capital_serial  ");
		sqljob.appendSQL("		                and c. exchange_date <= '"+queryDate+"' ) as Sum");
		sqljob.appendSQL("from debt_plan_det a,issue_ticket_det b ");
		sqljob.appendSQL("where a.debt_id = b.debt_id  ");
		sqljob.appendSQL("    and a.repay_date <= '"+queryDate+"'  ");
		sqljob.appendSQL("    and a.debt_id = ?  ");
		sqljob.appendSQL("    and a.capital_serial <>0  ");
		sqljob.appendSQL("group by a.debt_id, a.id, a.repay_date,a.interest_serial,a.capital_serial,a.capital_amount ");
		sqljob.addParameter(myform.getDebtId());
		System.out.println("getDebtTicket ： "+sqljob);
		return sqljob;
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{	
	}
	
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception
	{
		AccountQueryForm myform = (AccountQueryForm)form;
		String findforward = new String();
		String tableName = new String();
		if("0".equals(myform.getIssueKind()))	//登錄
		{
			tableName = "EARE0701_RPT";
			findforward = "file1";
		}
		else									//債票
		{
			tableName = "EARE0702_RPT";
			findforward = "file2";
		}
		//取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId,tableName));
		//執行 insert
		SQLJob sqljob = new SQLJob();
		if("EARE0701_RPT".equals(tableName))
		{
			sqljob = EARE0701_RPT(form,usrId);
			run.update(connection,sqljob);
		}
		else
		{	
				List list = (List)run.query(getDebtTicket(form), new MapListHandler());
				if(null != list && 0 != list.size())
				{
					for(Iterator it=list.iterator();it.hasNext();)
					{
						Map map = (Map)it.next();
						System.out.println(map.containsValue("plan_id"));
						
						sqljob =  EARE0702_RPT(form,usrId,map);
						run.update(connection,sqljob);
					}	
				}	

		}		
		String debtName = selIssueName(myform,connection);
		request.setAttribute("debtName",debtName);
		return mapping.findForward(findforward);
	}	
	
	public String selIssueName(AccountQueryForm form,Connection connection)throws Exception
	{
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob job = new SQLJob();
		String querySql = "select debt_name+'('+isnull(debit_name,'')+')' as debt_name" +
				" from issue_main,debt_main,debit_ref " +
				" where issue_main.id = debt_main.issue_id " +
				" and debit_ref.id =* debt_main.debt_code "+
				" and debt_main.issue_id = ? and debt_main.id = ?";
		job.appendSQL(querySql);
		job.addParameter(form.getIssueId());
		int debtId = form.getDebtId();
		job.addParameter(debtId);
		Map map = (Map)run.query(job,new MapHandler());
		return (String)map.get("DEBT_NAME");
	}
}
