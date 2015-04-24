package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
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

public class EDRE0901 extends ExcelReportBaseAction{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EDRE09_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob SQL1(AccountQueryForm myForm,String lastDate,String firstDate){
		SQLJob sqljob = new SQLJob();
//		應付短期借款明細表
		sqljob.appendSQL("select b.id as tId,a.debt_name,");//表頭
		sqljob.appendSQL("e.budget_name,");//預算別
		sqljob.appendSQL("datediff(dd,a.issue_date,a.due_date) as daycount,");//天期
		sqljob.appendSQL("d.bank_name,");
		sqljob.appendSQL("SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.issue_date, 112)-19110000)),7),1,3)+'/'+");
		sqljob.appendSQL("SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.issue_date, 112)-19110000)),7),4,2)+'/'+");
		sqljob.appendSQL("SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.issue_date, 112)-19110000)),7),6,2) as issue_date,"); 
		sqljob.appendSQL("SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.due_date, 112)-19110000)),7),1,3)+'/'+");
		sqljob.appendSQL("SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.due_date, 112)-19110000)),7),4,2)+'/'+");
		sqljob.appendSQL("SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,a.due_date, 112)-19110000)),7),6,2) as due_date,");
		sqljob.appendSQL("substring(convert(char,round(b.compare_rate,3)),1,5)+'%' compare_rate,");//利率
		sqljob.appendSQL("b.issue_amount,");//訂  借  總  額
		sqljob.appendSQL("sum( c.capital_amount) as pay_capital,");//本金償　付　數
		sqljob.appendSQL("b.issue_amount - sum(c.capital_amount) as remain_capital,"); //本金未  償  還  數
		sqljob.appendSQL("(select sum(Interest_amount) from Debt_plan_det  where debt_id=b.id and delete_mark='N') as origin_interest_amount,"); //利息應　付　數
		sqljob.appendSQL("sum(c.interest_amount) as pay_interest,"); //利息償　付　數
		sqljob.appendSQL("0 as remain_interest,");//利息未  償  還  數
		sqljob.appendSQL("(select case sum(interest_amount)- sum(c.interest_amount) when 0 then null else sum(interest_amount)- sum(c.interest_amount) end  from Debt_plan_det  where debt_id=b.id and delete_mark='N') as  remain_interest2 ");//利息未  償  還  數
		sqljob.appendSQL("from issue_main a,debt_main b,payment_main c ,bank_ref d,budget_ref e ");
		sqljob.appendSQL("where a.id = b.issue_id ");
		sqljob.appendSQL("and a.id = c.issue_id ");
		sqljob.appendSQL("and c.debt_id=b.id ");
		sqljob.appendSQL("and b.bank_id = d.id ");
		sqljob.appendSQL("and a.budget_code <> 4 and a.budget_code = e.id ");
		sqljob.appendSQL("and a.debt_type='D' ");
		sqljob.appendSQL("and a.issue_date <= '"+lastDate+"' ");
		sqljob.appendSQL("and a.due_date >= '"+firstDate+"' ");
		sqljob.appendSQL("and a.id = ? and c.repay_date between '"+firstDate+"' and '"+lastDate+"' ");
		sqljob.appendSQL("group by  b.id,a.debt_name,");
		sqljob.appendSQL("e.budget_name,datediff(dd,a.issue_date,a.due_date),");
		sqljob.appendSQL("d.bank_name, a.issue_date, a.due_date, b.compare_rate, ");
		sqljob.appendSQL("b.real_amount, b.origin_interest_amount,b.issue_amount ");
		sqljob.appendSQL("order by 4");
		sqljob.addParameter(myForm.getIssueId());
		System.out.println(sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		AccountQueryForm myForm = (AccountQueryForm)form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		String month = String.valueOf(myForm.getMonth());
		if (month.length() < 2 )
			month = "0"+month;
		String lastDate = myForm.getSQLLastDate();
		String firstDate = lastDate.substring(0,lastDate.length() - 2) + "01";
		List queryList1 = (List) run.query(SQL1(myForm,lastDate,firstDate), new MapListHandler());
		Map tMap = null;
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			
			request.setAttribute("debt_name",tMap.get("debt_name"));
			request.setAttribute("budget_name",tMap.get("budget_name"));
			request.setAttribute("daycount",tMap.get("daycount"));
			System.out.println(" 1  "+tMap);
			System.out.println(" 1  "+insTemp("EDRE09_RPT",tMap));
			run.update(connection,insTemp("EDRE09_RPT",tMap));
			System.out.println(" 2  ");
			
		}
		
		
	} 
}
