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

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.surplusage.form.Gara4201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA4301 extends ExcelReportBaseAction {
	private final static String TEMP_TABLE_NAME = "GARA43_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA43_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL(Gara4201Form myForm){
		SQLJob sqljob = new SQLJob();
		
		Integer year = Integer.valueOf(myForm.getAccountYear()) + 1911;
		sqljob.appendSQL("select i.debt_name, ");
		sqljob.appendSQL("(select bank_name from bank_ref where id = d.bank_id) as bank_name, ");
		sqljob.appendSQL("(i.issue_amount - isnull((select sum(capital_amount) from payment_main " +
				"where issue_id = i.id and year(repay_date) < '"+ year +"'),0)) as issue_amount, ");
		sqljob.appendSQL("(select max(debt_rate) from debt_rate_det where debt_id = d.id) as max_Rate, ");
		sqljob.appendSQL("(select min(debt_rate) from debt_rate_det where debt_id = d.id) as min_Rate, ");
		String paymentSQL = "from payment_main where issue_id = i.id and year(repay_date) = '"+ year +"'),0)";
		sqljob.appendSQL("isnull((select sum(capital_amount) " + paymentSQL + " as capital_amount, ");
		sqljob.appendSQL("isnull((select sum(interest_amount) " + paymentSQL + " as interest_amount ");
		sqljob.appendSQL("from issue_main i, debt_main d ");
		sqljob.appendSQL("where i.id = d.issue_id ");
		sqljob.appendSQL("and debt_type = 'F' ");
		sqljob.appendSQL("and account_year = '096' ");		
		
		System.out.println(sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );	
		Gara4201Form myForm = (Gara4201Form) form;
		
		SQLJob sqljob = SQL((Gara4201Form)form);
		List tList = (List) run.query(sqljob, new MapListHandler());
		Map tMap = null;		

		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			Map dMap = new HashMap();
			dMap.put("debt_name",(String)tMap.get("debt_name")+"\n("+(String)tMap.get("bank_name")+")");
			BigDecimal issueAmount = null!=tMap.get("issue_amount")?(BigDecimal)tMap.get("issue_amount"):null;
			dMap.put("issue_amount",issueAmount);
			BigDecimal maxRate = null!=tMap.get("max_Rate")?(BigDecimal)tMap.get("max_Rate"):null;
			BigDecimal minRate = null!=tMap.get("min_Rate")?(BigDecimal)tMap.get("min_Rate"):null;
			maxRate = maxRate.setScale(3,BigDecimal.ROUND_DOWN);
			minRate = minRate.setScale(3,BigDecimal.ROUND_DOWN);
			dMap.put("rate",String.valueOf(maxRate)+"%~\n"+String.valueOf(minRate)+"%");
			BigDecimal capitalAmount = null!=tMap.get("capital_amount")?(BigDecimal)tMap.get("capital_amount"):null;
			dMap.put("capital_amount",capitalAmount);
			BigDecimal interestAmount = null!=tMap.get("interest_amount")?(BigDecimal)tMap.get("interest_amount"):null;
			dMap.put("interest_amount",interestAmount);
			BigDecimal totAmount = capitalAmount.add(interestAmount);
			dMap.put("tot_amount",totAmount);
			BigDecimal remainAmount = issueAmount.subtract(capitalAmount);
			dMap.put("remain_amount",remainAmount);
			run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));	
		}
		
		request.setAttribute("accountYear",myForm.getAccountYear());
	}
}
