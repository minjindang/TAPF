package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ECRE0701 extends DefaultAction {

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
		job = selCount(myForm,usrId);
        int count = run.getCount(job,"count");
		job = selTmp(myForm,usrId);
		//資料筆數不足11行補足11行
		if(count<11)
		{
			for(int i=count ;i<11;i++)
			{
				job.appendSQL(" union select '"+i+"','','' as bank_name,0,0,0,0 ");
			}
		}
		job.appendSQL("order by bank_name desc");
	    
		run.update(job);

	}
	
	/*
	 * 查詢資料
	 */
	public SQLJob selTmp(AccountQueryForm form,String usrId)
	{
		SQLJob job = new SQLJob();
		String lastDate = form.getSQLLastDate();
		String firstDate = form.getSQLLastDate().substring(0,7)+"/01";
		job.appendSQL("INSERT INTO ECRE07_RPT (USRID, MOD_DATE , " +
				"bank_name, real_amount , pay_amount , sum_interest," +
				"nouse_interest )");	
		
		job.appendSQL("select  ?,?,c.bank_name,(select sum(issue_amount) from debt_main f where f.issue_id = a.id and f.bank_id = b.bank_id ), ");
		job.appendSQL("sum(case when e.repay_date >='"+firstDate+"' and e.repay_date <='"+lastDate+"' then isnull(e.capital_amount,0) else 0 end), ");
		job.appendSQL("sum(case when e.repay_date <= '"+lastDate+"' then isnull(e.capital_amount,0) else 0 end), ");
		job.appendSQL("(select sum(issue_amount) from debt_main f where f.issue_id = a.id and f.bank_id = b.bank_id ) - sum(case when e.repay_date <= '"+lastDate+"' then isnull(e.capital_amount,0) else 0 end) ");
		
		job.appendSQL("from issue_main a,debt_main b,bank_ref c,debt_plan_det d,payment_main e");
		job.appendSQL("where a.id = b.issue_id");
		job.appendSQL("    and b.bank_id = c.id");
		job.appendSQL("    and d.debt_id = b.id");
		job.appendSQL("    and e.plan_id =* d.id");
		job.appendSQL("    and a.debt_type = 'C'");
		job.appendSQL("    and d.delete_mark = 'N'");
		job.appendSQL("    and a.id = ?");
		job.appendSQL("    and b.debt_code <> 35");
		job.appendSQL("group by a.id, a.debt_name,c.bank_name , b.bank_id ");
		
		job.addParameter(usrId);//USRID
		job.addParameter(new Date());
		job.addParameter(form.getIssueId());
		return job;
	}
	//查詢筆數
	public SQLJob selCount(AccountQueryForm form,String usrId)
	{
		SQLJob job = new SQLJob();
		String lastDate = form.getSQLLastDate();
		String firstDate = form.getSQLLastDate().substring(0,7)+"/01";
		job.appendSQL("select count(*) as count from (");
		job.appendSQL("select  c.bank_name");
		job.appendSQL("from issue_main a,debt_main b,bank_ref c,debt_plan_det d,payment_main e");
		job.appendSQL("where a.id = b.issue_id");
		job.appendSQL("    and b.bank_id = c.id");
		job.appendSQL("    and d.debt_id = b.id");
		job.appendSQL("    and e.plan_id =* d.id");
		job.appendSQL("    and a.debt_type = 'C'");
		job.appendSQL("    and d.delete_mark = 'N'");
		job.appendSQL("    and a.id = ?");
		job.appendSQL("    and b.debt_code <> 35");
		job.appendSQL("group by a.id, a.debt_name,c.bank_name , b.bank_id ) as a");

		job.addParameter(form.getIssueId());

		return job;
	}
	/*
	 * 刪除temp table ECRE07_RPT 的舊資料
	 */
	public SQLJob delTmp(String usrId)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("DELETE FROM ECRE07_RPT ");
		
		return job;
	}
}
