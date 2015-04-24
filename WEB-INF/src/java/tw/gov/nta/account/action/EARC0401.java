package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

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

public class EARC0401 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{
		// TODO Auto-generated method stub
		AccountQueryForm myForm = (AccountQueryForm)form;
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		
		//1.刪除舊的資料
		SQLJob job = delTmp(usrId);
		run.update(job);
		
		//2.查詢資料
		job = selTmp(myForm);
		List list = (List)run.query(job,new MapListHandler());
		//3.新增至temp table EARC04_RPT
		if(null != list)
		{
			for(int i=0 ;i<list.size();i++)
			{
				Map map = (Map)list.get(i);
				map.put("usrID",usrId);
				map.put("newDate", new Date());
				SQLJob job2 = insTmp(map);
				run.update(job2);
			}
		}
	}
	
	//新增到temp table EARC04_RPT
	public SQLJob insTmp(Map map)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("INSERT INTO EARC04_RPT (USRID , MOD_DATE , " +
				"issue_name , issue_date , due_date , issue_amount, " +
				"meet_amount , pay_amount , pay_rate ) VALUES (" +
				"?, ?, ?, ?, ?, ?, ?, ?, ?) ");

		job.addParameter((String)map.get("usrId"));//USRID
		job.addParameter((Date)(map.get("newDate")));//MOD_DATE
		job.addParameter((String)map.get("issue_name"));//issue_name
		job.addParameter(map.get("issue_date"));//issue_date
		job.addParameter(map.get("due_date"));//due_date
		job.addParameter((BigDecimal)map.get("issue_amount"));//issue_amount
		job.addParameter((BigDecimal)map.get("payable_amount"));//meet_amount
		job.addParameter((BigDecimal)map.get("payment_amount"));//pay_amount
		job.addParameter((BigDecimal)map.get("payment_persent"));//pay_rate
		return job;
	}

	//查詢資料
	public SQLJob selTmp(AccountQueryForm form)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("SELECT  issue_main.account_year,debt_main.debt_serial,isnull(issue_main.debt_short_name,'')+'('+debit_ref.debit_name+')' as issue_name , ");
		job.appendSQL(" isnull(substring(right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7),1,3)+'/'+ " +
				" substring(right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7),4,2)+'/'+ " +
				" substring(right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7),6,2) ,'')as issue_date, ");
		job.appendSQL(" substring(right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7),1,3)+'/'+ " +
				" substring(right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7),4,2)+'/'+ " +
				" substring(right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7),6,2) as due_date,  ");
		job.appendSQL("isnull (debt_main.issue_amount,0) AS issue_amount , ");
		job.appendSQL(" isnull(SUM(debt_plan_det.capital_amount + debt_plan_det.interest_amount)  ,0) AS payable_amount, ");
		job.appendSQL(" isnull(SUM(case when debt_plan_det.repay_date <= getDate() then debt_plan_det.capital_amount + debt_plan_det.interest_amount else 0 end)  ,0) AS payment_amount, ");
		job.appendSQL(" isnull(isnull(SUM(case when debt_plan_det.repay_date <= getDate() then debt_plan_det.capital_amount + debt_plan_det.interest_amount else 0 end)  ,0) / isnull(sum(debt_plan_det.capital_amount + debt_plan_det.interest_amount),1) * 100,0) AS payment_persent, ");
		job.appendSQL(" isnull(issue_main.capital_amount,0) as capital_amount , isnull(issue_main.interest_amount,0) AS interest_amount  ");
		job.appendSQL("from    issue_main,debt_plan_det,debt_main,debit_ref ");
		job.appendSQL("where   issue_main.id = debt_plan_det.issue_id  ");
		job.appendSQL("  AND   issue_main.id = debt_main.issue_id  ");
		job.appendSQL("  AND   debt_main.id = debt_plan_det.debt_id  ");
		job.appendSQL("  AND   debt_main.debt_code = debit_ref.id  ");
		job.appendSQL("  AND   (issue_main.DEBT_TYPE = 'A') ");
		job.appendSQL("  AND   right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) >= ? ");//[發行日期起]
		job.appendSQL("  AND   right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <= ? ");//[發行日期迄]
		job.appendSQL("GROUP BY  issue_main.account_year,issue_main.debt_short_name,  issue_main.ISSUE_DATE,  issue_main.DUE_DATE, ");
		job.appendSQL("	debt_main.issue_amount, issue_main.CAPITAL_AMOUNT, issue_main.INTEREST_AMOUNT,debt_main.debt_serial,issue_main.payable_interest_amount,debit_ref.debit_name ");
		job.appendSQL("	ORDER BY issue_main.account_year,debt_main.debt_serial ");
		job.addParameter(DateUtil.date2ROCStr(form.getStartIssueDate()));//[發行日期起]
		job.addParameter(DateUtil.date2ROCStr(form.getEndIssueDate()));//[發行日期迄]
		System.out.println(job.toString());
		return job;
	}
	//刪除舊的資料
	public SQLJob delTmp(String usrId)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("DELETE FROM EARC04_RPT ");
		//job.appendSQL("WHERE USRID = ? ");
		//job.addParameter(usrId);

		return job;
	}
}
