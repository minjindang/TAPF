
package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.Date;
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


public class EARD0403 extends ExcelReportBaseAction{
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARD04_RPT02 ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		return sqljob;
	}

	protected SQLJob SQL1(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select a.debt_name+'('+f.debit_name+')' as debt_short_name,");
		sqljob.appendSQL("a.serial_no,");
		sqljob.appendSQL("a.issue_date,");
		sqljob.appendSQL("b.ticket_name,");
		sqljob.appendSQL("b.ticket_count,");
		sqljob.appendSQL("'' as ticket_no,");
		sqljob.appendSQL("b.ticket_amount,");
		sqljob.appendSQL("a.average_rate,");
		sqljob.appendSQL("b.ticket_amount * b.ticket_count as total_amount ");
		sqljob.appendSQL("from issue_main a,issue_ticket_det b,debt_main c,debit_ref f ");
		sqljob.appendSQL("where c.id = b.debt_id ");
		sqljob.appendSQL("and c.issue_id = a.id ");
		sqljob.appendSQL("and a.debt_code = f.id ");
		sqljob.appendSQL("and c.id = ? ");
		sqljob.appendSQL("and debt_type='A' ");
		sqljob.addParameter(myForm.getDebtId());
		System.out.println("SQL1:"+sqljob.toString());
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		AccountQueryForm myForm = (AccountQueryForm) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		List qryList = (List) run.query(SQL1(myForm),new MapListHandler());
		Map tMap = new HashMap();
		for (Iterator tIterator = qryList.iterator(); tIterator.hasNext();){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			request.setAttribute("debt_short_name",tMap.get("debt_short_name"));
			request.setAttribute("serial_no",tMap.get("serial_no"));
			request.setAttribute("issue_date",DateUtil.date2Str((Date)tMap.get("issue_date"),"yyyy/mm/dd"));
			run.update(connection,insTemp("EARD04_RPT02",tMap));
		}
		request.setAttribute("file","EARD04B");
	}
}