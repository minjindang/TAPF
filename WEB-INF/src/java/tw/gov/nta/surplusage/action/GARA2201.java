/* GARA3101.java 報表
 程式目的：GARA3101
 程式代號：GARA3101
 程式日期：0950602
 程式作者：Avery
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara2201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA2201 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA22_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL1(Gara2201Form myForm,BigDecimal unit,String key)
	{		
		String reportDate = DateUtil.date2Str(new Date(),"yyyy/MM/dd" );
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select A.debt_code,");
		sqljob.appendSQL("A.debt_name,");
		sqljob.appendSQL("A.issue_date,");
		sqljob.appendSQL("A.due_date,");
//		sqljob.appendSQL("year(due_date)-year(issue_date) as issue_range,");
		sqljob.appendSQL("dbo.countDay(max(a.issue_date),max(a.due_date),max(a.show_type))  as issue_range,");
		sqljob.appendSQL("	(select debt_rate from debt_rate_det where debt_id=D.id and effective_date < '"+reportDate+"' and suspend_date > '"+reportDate+"' and delete_mark='N') as Average_rate, ");
		sqljob.appendSQL("(D.issue_amount - (select sum(isnull(capital_amount,0)) from payment_main where debt_id =* d.id group by debt_id))/"+unit+" as remain_amount,");
		sqljob.appendSQL("ISNULL(B.INTEREST_SERIAL,'0') as interest_serial ,");
		sqljob.appendSQL("B.Interest_amount/"+unit+" as Interest_amount ");
		sqljob.appendSQL("from issue_main A, debt_plan_det B , DEBT_MAIN D ");
		sqljob.appendSQL("where b.issue_id = a.id ");
		sqljob.appendSQL(" AND D.ISSUE_ID = A.ID AND B.DEBT_ID = D.ID and B.delete_mark='N'");		
		if (myForm.getIssueYear()!=null){
			sqljob.appendSQL("AND year(B.REPAY_DATE)-1911  = '"+myForm.getIssueYear()+"' ");
		}
		sqljob.appendSQL("and D.BUDGET_CODE = '3' ");
		if ("1".equals(key))
			sqljob.appendSQL("and A.debt_type = 'A' ");
		else
			sqljob.appendSQL("and A.debt_type <> 'A' ");


		sqljob.appendSQL(" AND ISNULL(B.INTEREST_SERIAL,'0') > 0 ");
		sqljob.appendSQL(" group by A.debt_code, A.debt_name, A.issue_date, A.due_date,a.show_type, d.id,D.issue_amount, B.INTEREST_SERIAL, B.Interest_amount, A.account_year, a.serial_no ");
		sqljob.appendSQL(" ORDER BY A.account_year, a.serial_no, A.DEBT_CODE , A.ISSUE_DATE , ISNULL(B.INTEREST_SERIAL,'0') , A.DEBT_NAME ");
		
		System.out.println("sql::"+sqljob);
		return sqljob;
	}


	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gara2201Form myForm = (Gara2201Form) form;
		
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		
		BigDecimal sum1 = new BigDecimal(0);
		BigDecimal sum2 = new BigDecimal(0);
		Map tMap = new HashMap();
//		tCommonMap.
		List queryList1 = (List) run.query(SQL1(myForm,unit,"1"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("debt_name",(String)tMap.get("debt_name")+"-公債");
			sum1 = sum1.add((BigDecimal)tMap.get("Interest_amount"));
			run.update(connection,insTemp("GARA22_RPT",tMap));
		}
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Interest_serial","公債小計");
		tMap.put("Interest_amount",sum1);
		run.update(connection,insTemp("GARA22_RPT",tMap));
		
		queryList1 = (List) run.query(SQL1(myForm,unit,"2"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("debt_name",(String)tMap.get("debt_name")+"-賒借");
			sum2 = sum2.add((BigDecimal)tMap.get("Interest_amount"));
			run.update(connection,insTemp("GARA22_RPT",tMap));
		}
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Interest_serial","賒借小計");
		tMap.put("Interest_amount",sum2);
		run.update(connection,insTemp("GARA22_RPT",tMap));
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Interest_serial","總計");
		tMap.put("Interest_amount",sum1.add(sum2));
		run.update(connection,insTemp("GARA22_RPT",tMap));
	}
}
