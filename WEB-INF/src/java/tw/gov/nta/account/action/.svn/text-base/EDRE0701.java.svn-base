
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;


public class EDRE0701 extends DefaultAction{
	
	public void executeQuery(ActionForm form, HttpServletRequest request, 
			Connection connection) throws Exception 
	{
		AccountQueryForm myForm = (AccountQueryForm) form;
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		
		SQLJob job = new SQLJob();
		
		//1.先刪除舊資料
		job = delTmp(usrId);
		run.update(job);
		
		//2.查詢資料
		job = selTmp(myForm);
		List list  = (List)run.query(job,new MapListHandler());
		
		//3.新增資料
		for(int i=0;i<list.size();i++)
		{
			Map map = (Map)list.get(i);
			request.setAttribute("debtName",map.get("debt_name"));
			request.setAttribute("budgetName",map.get("budget_name"));
			request.setAttribute("debitName",map.get("debit_name"));
			request.setAttribute("dayCount",map.get("daycount"));
			job = insTmp(usrId,map);
			run.update(job);
		}
	
	}
	
	/*
	 * 新增資料至temp table EDRE07_RPT
	 */
	public SQLJob insTmp(String usrId,Map map)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("INSERT INTO EDRE07_RPT (USRID, MOD_DATE , " +
				"bank_name, real_amount , pay_amount , sum_interest," +
				"nouse_interest,remark ) VALUES (" +
				"? , ? , ? , ? , ? , ? , ? ,? )");
		job.addParameter(usrId);//USRID
		job.addParameter(new Date());//MOD_DATE
		job.addParameter((String)map.get("bank_name"));//bank_name
		job.addParameter((BigDecimal)map.get("issue_amount"));//real_amount
		job.addParameter((BigDecimal)map.get("mon_payed_capital"));//pay_amount
		job.addParameter((BigDecimal)map.get("total_payed_capital"));//sum_interest
		job.addParameter((BigDecimal)map.get("total_unpayed_capital"));//nouse_interest
		job.addParameter((String)map.get("remark"));//備註
		System.out.println(job);
		return job;
	}
	
	/*
	 * 查詢資料
	 */
	public SQLJob selTmp(AccountQueryForm form)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("select distinct a.id,d.debt_name,e.budget_name,f.debit_name,");
		job.appendSQL("	datediff(dd,d.issue_date,d.due_date) As daycount, b.bank_name, ");
		job.appendSQL("	sum(a.issue_amount) as issue_amount, ");//--承貸金額
		job.appendSQL("	(SELECT  SUM(h.CAPITAL_AMOUNT) FROM  debt_main g,payment_main h ");
		job.appendSQL("		WHERE  g.id = h.debt_id and  g.id =  a.id ");
		job.appendSQL("			and  g.bank_id = a.bank_id ");
		job.appendSQL("		and substring(right('0000000'+convert(varchar,(convert(varchar, h.repay_date, 112)-19110000)),7),1,5) = ?  ");//會計年度+查詢月份  
		job.appendSQL("		AND g.accrue = 'Y')  as mon_payed_capital, ");//--本月償還 
		job.appendSQL("	(SELECT  SUM(h.CAPITAL_AMOUNT) FROM  debt_main g,payment_main h ");
		job.appendSQL("		WHERE  g.id = h.debt_id and  g.id =  a.id ");
		job.appendSQL("		and  g.bank_id = a.bank_id ");
		job.appendSQL("		And  ( ");
		job.appendSQL("	(substring(right('0000000'+convert(varchar,(convert(varchar, h.repay_date, 112)-19110000)),7),4,2) <= ? ");//查詢月份  
		job.appendSQL("	And substring(right('0000000'+convert(varchar,(convert(varchar, h.repay_date, 112)-19110000)),7),1,3) = ? ");//會計年度
		job.appendSQL("	) or ( substring(right('0000000'+convert(varchar,(convert(varchar, h.repay_date, 112)-19110000)),7),1,3) < ? )) ");//會計年度
		job.appendSQL("	AND g.accrue = 'Y') as total_payed_capital, ");//--截止本月底償還
		job.appendSQL("	sum(isnull(a.issue_amount,0))- (SELECT  SUM(h.CAPITAL_AMOUNT) FROM  debt_main g,payment_main h ");
		job.appendSQL("	WHERE  g.id = h.debt_id  and  g.id =  a.id and  g.bank_id = a.bank_id ");
		job.appendSQL(" And  ( (substring(right('0000000'+convert(varchar,(convert(varchar, h.repay_date, 112)-19110000)),7),4,2) <= ? ");//查詢月份  
		job.appendSQL("	And substring(right('0000000'+convert(varchar,(convert(varchar, h.repay_date, 112)-19110000)),7),1,3) = ? )");//會計年度
		job.appendSQL("	or ( substring(right('0000000'+convert(varchar,(convert(varchar, h.repay_date, 112)-19110000)),7),1,3) < ? )) ");//會計年度
		job.appendSQL("	AND g.accrue = 'Y') as total_unpayed_capital, ");//--未償還
		job.appendSQL("	( case when c.repay_date < g.repay_date then '提前償還' else '' end ) as remark ");//--備註
		job.appendSQL("from debt_main a,bank_ref b,payment_main c,issue_main d,budget_ref e,debit_ref f,debt_plan_det g ");
		job.appendSQL("where a.bank_id = b.id and a.id = c.debt_id ");
		job.appendSQL("	and a.issue_id = d.id and g.id = c.plan_id ");
		job.appendSQL("	and d.budget_code <> 4 and d.budget_code = e.id and d.debt_code = f.id ");
		job.appendSQL(" and d.id = ?");
		job.appendSQL("	and d.debt_type='D' and substring(right('0000000'+convert(varchar,(convert(varchar, c.repay_date, 112)-19110000)),7),1,5) = ? ");//會計年度+查詢月份
		job.appendSQL("	and a.accrue = 'Y' ");
		job.appendSQL("group by  a.id,d.debt_name,e.budget_name,f.debit_name,b.bank_name,a.real_amount,datediff(dd,d.issue_date,d.due_date),a.bank_id, c.repay_date, g.repay_date ");
		
		job.addParameter(form.getAccountYear() + form.getMonth());//會計年度+查詢月份  
		job.addParameter(form.getMonth());//查詢月份  
		job.addParameter(form.getAccountYear());//會計年度
		job.addParameter(form.getAccountYear());//會計年度
		job.addParameter(form.getMonth());//查詢月份  
		job.addParameter(form.getAccountYear());//會計年度
		job.addParameter(form.getAccountYear());//會計年度
		job.addParameter(form.getIssueId());//會計年度
		job.addParameter(form.getAccountYear() + form.getMonth());//會計年度+查詢月份
		System.out.println(job);
		

		return job;
	}
	
	/*
	 * 刪除temp table EDRE07_RPT 的舊資料
	 */
	public SQLJob delTmp(String usrId)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("DELETE FROM EDRE07_RPT ");
		//job.appendSQL("WHERE USRID = ? ");

		//job.addParameter(usrId);
		
		return job;
	}
}