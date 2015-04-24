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

public class ECRF0401 extends DefaultAction {

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
		//3.新增至temp table ECRF04_RPT
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

	//新增到temp table ECRF04_RPT
	public SQLJob insTmp(Map map)
	{
		System.out.println(map);
		SQLJob job = new SQLJob();
		job.appendSQL("INSERT INTO ECRF04_RPT (USRID , MOD_DATE , " +
				"debt_name , issue_date , due_date , issue_amount, " +
				"payable_amount , payed_amount , unpay_amount" +
				") VALUES (" +
				"?, ?, ?, ?, ?, ?, ?, ?, ? ) ");

		job.addParameter((String)map.get("usrId"));//USRID
		job.addParameter((Date)(map.get("newDate")));//MOD_DATE
		job.addParameter((String)map.get("debt_name"));//debt_name
		job.addParameter(map.get("issue_date"));//issue_date
		job.addParameter(map.get("due_date"));//due_date
		job.addParameter((BigDecimal)map.get("issue_amount"));//issue_amount
		job.addParameter((BigDecimal)map.get("payable_amount"));//payable_amount
		job.addParameter((BigDecimal)map.get("payed_amount"));//payed_amount
		job.addParameter((BigDecimal)map.get("unpay_amount"));//unpay_amount
		
		return job;
	}

	//查詢資料
	public SQLJob selTmp(AccountQueryForm form)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("select a.debt_name, ");
		job.appendSQL("	a.issue_date,a.due_date,");
		job.appendSQL("	isnull(sum(b.issue_amount),0) As issue_amount, ");
		job.appendSQL("	isnull(sum(b.issue_amount),0) + isnull(sum(b.origin_interest_amount),0) + (select isnull(sum(isnull(change_interest_amount,0)),0) from interest_adjust_main,debt_main  where debt_id = debt_main.id and debt_main.issue_id = a.id and debt_main.debt_code <> 35 and adjust_type = 'R') As payable_amount, ");
		job.appendSQL("	(select isnull(sum(isnull(capital_amount,0)),0) + isnull(sum(isnull(interest_amount,0)),0) from payment_main ,debt_main  where debt_id = debt_main.id and debt_main.issue_id = a.id and debt_main.debt_code <> 35 ) As payed_amount, ");
		job.appendSQL("	 (select isnull(sum(isnull(change_interest_amount,0)),0) from interest_adjust_main,debt_main  where debt_id = debt_main.id and debt_main.issue_id = a.id and debt_main.debt_code <> 35 and adjust_type = 'M') as unpay_amount");
		job.appendSQL(" from issue_main a,debt_main b ");
		job.appendSQL(" where a.id = b.issue_id 	");
		job.appendSQL(" and a.debt_type = 'C'  and ISNUMERIC(a.serial_no) = 1 ");
		job.appendSQL("   and b.accrue = 'Y' and b.debt_code <> 35 ");
		job.appendSQL("and  (convert(varchar,a.issue_date, 112)-19110000)  between ?  and ? ");
		job.appendSQL("group by a.account_year,a.serial_no,a.debt_name,a.issue_date,a.due_date,a.id,a.capital_amount,a.interest_amount ");
		job.appendSQL("order by a.account_year,a.serial_no ");
		job.addParameter(DateUtil.date2ROCStr(form.getStartIssueDate()));//[發行日期起]
		job.addParameter(DateUtil.date2ROCStr(form.getEndIssueDate()));//[發行日期迄]
		System.out.println(job.toString());	
		return job;
	}
	//刪除舊的資料
	public SQLJob delTmp(String usrId)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("DELETE FROM ECRF04_RPT ");
		//job.appendSQL("WHERE USRID = ? ");
		//job.addParameter(usrId);

		return job;
	}

}
