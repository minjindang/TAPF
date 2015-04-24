/*
 * 在 2006/2/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bira0801Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class BIRA0801 extends ExcelReportBaseAction{
	protected SQLJob SQL1(ActionForm form,String usrId){
		Bira0801Form myForm = (Bira0801Form)form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select '" + usrId + "' as usrid,? as mod_date,A.remark as remark,A.debt_name,"); //DEBT_NAME
		sqljob.addParameter(new Timestamp (new Date().getTime()));
		sqljob.appendSQL("datediff(dd,A.issue_date,A.due_date) as date_period,"); //DATE_PERIOD
		sqljob.appendSQL("A.issue_date,");//ISSUE_DATE
		sqljob.appendSQL("A.due_date,");//DUE_DATE
		sqljob.appendSQL("A.average_rate/100 as average_rate,"); //AVERAGE_RATE
		sqljob.appendSQL("min(B.Repay_date) as Repay_date, ");//REPAY_DATE
		sqljob.appendSQL("max(isnull(B.average_rate,0)) as average_rate1,");//AVERAGE_RATE1
		//sqljob.appendSQL("isNull(A.issue_amount,0) as issue_amount,");//ISSUE_AMOUNT
		//sqljob.appendSQL("isNull(sum(B.capital_amount),0) as REAL_AMOUNT,");//REAL_AMOUNT
		//sqljob.appendSQL("isNull(sum(B.interest_amount),0) as interest_amount,");//INTEREST_AMOUNT
		sqljob.appendSQL("isNull(sum(B.BALANCE_CAPITAL_AMOUNT ),0) as issue_amount,");//ISSUE_AMOUNT
		sqljob.appendSQL("isNull(sum(B.manage_capital_amount),0) as REAL_AMOUNT,");//REAL_AMOUNT
		sqljob.appendSQL("isNull(sum(B.manage_interest_amount),0) as interest_amount,");//INTEREST_AMOUNT
		sqljob.appendSQL("(sum(B.BALANCE_CAPITAL_AMOUNT) - sum(B.manage_interest_amount) - sum(B.manage_capital_amount)) as REDUCE_AMOUNT");//REDUCE_AMOUNT
//		sqljob.appendSQL("(A.issue_amount - A.capital_amount -A.interest_amount) as REDUCE_AMOUNT");//REDUCE_AMOUNT
		sqljob.appendSQL("from issue_main A left outer join payment_main B on  B.issue_id = A.id");
		sqljob.appendSQL("where A.debt_type = 'B' and (A.issue_amount - A.capital_amount -A.interest_amount) > 0 ");
		if (null != myForm.getIssueSdate() && null != myForm.getIssueEdate()){
			sqljob.appendSQL("and A.issue_date between ? and ? ");
			sqljob.addParameter(myForm.getIssueSdate());
			sqljob.addParameter(myForm.getIssueEdate());
		}
		if (!"".equals(myForm.getBudgetCode())){
			sqljob.appendSQL("and A.budget_code = ? ");
			sqljob.addParameter(myForm.getBudgetCode());
		}
		sqljob.appendSQL("group by A.debt_name,datediff(dd,issue_date,due_date),A.issue_date,A.due_date,A.issue_amount,A.interest_amount,A.capital_amount,A.average_rate,A.remark");
	 	                  
		sqljob.appendSQL("order by A.issue_date");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("BIRA08_RPT",usrId));
		List queryList = (List) run.query(SQL1(form,usrId), new MapListHandler());
		Map tMap = null;
		for (Iterator it1=queryList.iterator(); it1.hasNext();){
			tMap = (Map) it1.next();
			if (tMap.get("Repay_date") == null){
				tMap.put("Repay_date",tMap.get("due_date"));
			}
			// || tMap.get("due_date").equals(tMap.get("Repay_date"))
			if (!((Date)tMap.get("Repay_date")).before((Date)tMap.get("due_date"))){
				tMap.put("Repay_date",null);
				tMap.put("average_rate1",null);
				tMap.put("REDUCE_AMOUNT",null);
			}
			if (tMap.get("REDUCE_AMOUNT") != null && ((BigDecimal)tMap.get("REDUCE_AMOUNT")).doubleValue() <= 0.0){
				tMap.put("REDUCE_AMOUNT",null);
			}
//			if(tMap.get("debt_name").toString().equals("財政部乙種國庫券83年度第F83-3期"))
//				tMap.put("REDUCE_AMOUNT","36067397");
			run.update(connection,insTemp("BIRA08_RPT",tMap));
		}
		
	}
}
