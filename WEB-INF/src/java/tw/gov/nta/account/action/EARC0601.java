
package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
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

public class EARC0601 extends ExcelReportBaseAction{
	
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARC06_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		return sqljob;
	}

	protected SQLJob SQL1(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		String queryDate = myForm.getSQLLastDate();
		String queryStartDate = queryDate.substring(0,queryDate.length() - 2) + "01";
		sqljob.appendSQL("select a.debt_name+'('+f.debit_name+')' as debt_name,");
		sqljob.appendSQL("max(case when b.ticket_amount=100000 then b.ticket_count else 0 end) As Aplan_100k_count,"); 
		sqljob.appendSQL("max(case when b.ticket_amount=500000 then b.ticket_count else 0 end) As Aplan_500k_count,"); 
		sqljob.appendSQL("max(case when b.ticket_amount=1000000 then b.ticket_count else 0 end) As Aplan_1m_count, ");
		sqljob.appendSQL("max(case when b.ticket_amount=5000000 then b.ticket_count else 0 end) As Aplan_5m_count, ");
		sqljob.appendSQL("max(a.issue_amount) as plan_payment_amount,");
		sqljob.appendSQL("max(case when c.ticket_amount = 100000 then c.ticket_count else 0 end) As Bplan_100k_count, ");
		sqljob.appendSQL("max(case when c.ticket_amount = 500000  then c.ticket_count else 0 end) As Bplan_500k_count, ");
		sqljob.appendSQL("max(case when c.ticket_amount = 1000000  then c.ticket_count else 0 end) As Bplan_1m_count, ");
		sqljob.appendSQL("max(case when c.ticket_amount = 5000000  then c.ticket_count else 0 end) As Bplan_5m_count, ");
		sqljob.appendSQL("max(total_amount )  as exchange_amount, ");
		sqljob.appendSQL("max(case when c.ticket_amount = 100000 then c.accum_count else 0 end) as Cplan_100k_count,");
		sqljob.appendSQL("max(case when c.ticket_amount = 500000 then c.accum_count else 0 end) as Cplan_500k_count,");
		sqljob.appendSQL("max(case when c.ticket_amount = 1000000 then c.accum_count else 0 end) as Cplan_1m_count,");
		sqljob.appendSQL("max(case when c.ticket_amount = 5000000 then c.accum_count else 0 end) as Cplan_5m_count,");
		sqljob.appendSQL("max(c.accum_amount) as accum_amount,");
		sqljob.appendSQL("c.exchange_date");
		sqljob.appendSQL(" from issue_main a,issue_ticket_det b ,issue_exchange_ticket_det c ,debt_main d,debit_ref f");
		sqljob.appendSQL("where a.id = b.issue_id and c.debt_id = d.id and a.id = d.issue_id and d.debt_code = f.id ");
		sqljob.appendSQL("and exchange_date between '"+queryStartDate+"' and '"+queryDate+"' ");
		sqljob.appendSQL("group by a.debt_name,c.exchange_date,c.debt_id,f.debit_name");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected String checkNull(Object key){
		if (key == null)
			key="0";
		return String.valueOf(key);
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
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = new HashMap();
		for (Iterator tIterator = queryList1.iterator();tIterator.hasNext();){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Dplan_100k_count",(new BigDecimal(checkNull(tMap.get("Aplan_100k_count")))).subtract(new BigDecimal(checkNull(tMap.get("Cplan_100k_count")))));
			tMap.put("Dplan_500k_count",(new BigDecimal(checkNull(tMap.get("Aplan_500k_count")))).subtract(new BigDecimal(checkNull(tMap.get("Cplan_500k_count")))));
			tMap.put("Dplan_1m_count",(new BigDecimal(checkNull(tMap.get("Aplan_1m_count")))).subtract(new BigDecimal(checkNull(tMap.get("Cplan_1m_count")))));
			tMap.put("Dplan_5m_count",(new BigDecimal(checkNull(tMap.get("Aplan_5m_count")))).subtract(new BigDecimal(checkNull(tMap.get("Cplan_5m_count")))));
			tMap.put("D_amount",(new BigDecimal(checkNull(tMap.get("plan_payment_amount")))).subtract(new BigDecimal(checkNull(tMap.get("accum_amount")))));
			request.setAttribute("titelName",(String)tMap.get("debt_name"));
			request.setAttribute("titelName",(String)tMap.get("debt_name"));
			run.update(connection,insTemp("EARC06_RPT",tMap));
		}
	}
}