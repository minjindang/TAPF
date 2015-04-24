package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
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

public class EDQC0301 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "EDQC03_RPT";

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );

		AccountQueryForm myForm = (AccountQueryForm) form;
		Date startIssueDate = myForm.getStartIssueDate();
		Date endIssueDate = myForm.getEndIssueDate();

		//2.查詢資料
		SQLJob job = selTmp(startIssueDate,endIssueDate);
		List list = (List)run.query(job,new MapListHandler());
		//3.新增至temp table EDQC03_RPT
		if(null != list)
		{
			for(int i=0 ;i<list.size();i++)
			{
				Map map = (Map)list.get(i);
				System.out.println(map);
				SQLJob job2 = insTmp(map,usrId);
				run.update(job2);
			}
		}
	}

	//新增到temp table EDQC03_RPT
	public SQLJob insTmp(Map map, String usrId)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("INSERT INTO " + TEMP_TABLE_NAME);
		job.appendSQL(" ( ");
		job.appendSQL(" debt_name, daycount, issue_date, due_date, issue_amount, ");
		job.appendSQL(" real_amount, payment_amount,  ");
		job.appendSQL(" USRID, MOD_DATE, REMARK ");
		job.appendSQL(" ) VALUES ( ");
		job.appendSQL(" ?, ?, ?, ?, ?, ?, ?,  ");
		job.appendSQL(" ?, CURRENT_TIMESTAMP, '' ");
		job.appendSQL(" ) ");

		job.addParameter((String)map.get("debt_name"));//debt_name
		job.addParameter((Integer)map.get("daycount"));//daycount
		job.addParameter((String)map.get("issue_date"));//issue_date
		job.addParameter((String)map.get("due_date"));//due_date
		job.addParameter((BigDecimal)map.get("issue_amount"));//issue_amount
		job.addParameter((BigDecimal)map.get("real_amount"));//real_amount
		job.addParameter((BigDecimal)map.get("payment_amount"));//payment_amount
		job.addParameter(usrId);//USRID		
		System.out.println(job);
		return job;
	}

	//查詢資料
	public SQLJob selTmp(Date startDate, Date endDate)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("select   a.debt_name,datediff(dd,a.issue_date,a.due_date) As daycount,");
		job.appendSQL(" isnull( ");
		job.appendSQL("	SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.issue_date, 112)-19110000)),7),1,3)+'/'+");
		job.appendSQL("	SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.issue_date, 112)-19110000)),7),4,2)+'/'+");
		job.appendSQL("	SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.issue_date, 112)-19110000)),7),6,2) ");
		job.appendSQL(" ,'') as issue_date, ");
		job.appendSQL(" isnull( ");
		job.appendSQL("	SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.due_date, 112)-19110000)),7),1,3)+'/'+");
		job.appendSQL("	SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.due_date, 112)-19110000)),7),4,2)+'/'+");
		job.appendSQL("	SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.due_date, 112)-19110000)),7),6,2) ");
		job.appendSQL(" ,'') as due_date, ");
		job.appendSQL("	isnull( a.issue_amount,0) as issue_amount ,");
		job.appendSQL("	case when a.capital_amount = a.issue_amount then a.capital_amount + a.interest_amount else (select isnull(sum(isnull(p.interest_amount,d.interest_amount) + isnull(p.capital_amount,d.capital_amount)),0) from debt_plan_det d,payment_main p  where d.issue_id = a.id and d.id *= p.plan_id and d.delete_mark = 'N') end as real_amount,");
		job.appendSQL("	(select isnull(sum(c.capital_amount + c.interest_amount),0) from payment_main c where issue_id=a.id ) As payment_amount,");
		job.appendSQL("	0 As payment_percent ");
		job.appendSQL("  from issue_main a , debt_main b 	");
		job.appendSQL(" where b.issue_id=a.id");
		job.appendSQL("   and a.budget_code <> 4");
		job.appendSQL("   and b.accrue =  'Y'");
		job.appendSQL("	  and a.debt_type='D'");
		if ( startDate != null && endDate != null ){
			job.appendSQL("   and ( a.issue_date between ? and ? ) ");
			job.addParameter( new Timestamp( startDate.getTime() ) );//[發行日期起]
			job.addParameter( new Timestamp( endDate.getTime() ) );//[發行日期迄]
		}
		job.appendSQL("group by a.capital_amount,a.interest_amount,a.account_year,a.SERIAL_NO,a.id,a.debt_name,a.due_date,a.issue_date,a.issue_amount");
		job.appendSQL("order by a.account_year,a.serial_no");
		System.out.println(job);
		
		return job;
	}
}
