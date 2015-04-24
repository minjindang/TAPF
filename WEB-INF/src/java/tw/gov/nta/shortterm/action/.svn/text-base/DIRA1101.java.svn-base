/**
 * @author Andrew Sung
 * @create 2006/4/18
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.ExcelReportRemainAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.shortterm.form.Dira0701Form;
import tw.gov.nta.sql.debt.DebtMain;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class DIRA1101 extends ExcelReportRemainAction
{
	
	protected SQLJob selTemp(ActionForm form){
		Dira0701Form myForm = (Dira0701Form)form;
		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("SELECT B.ID,B.ISSUE_ID,(SELECT BANK_NAME FROM BANK_REF WHERE ID = B.BANK_ID) AS BANK_NAME, ");
		sqljob.appendSQL("SELECT B.ID,B.ISSUE_ID,(select (case when combination_date is not null and belong_to_bank_id <> 0 and combination_date < A.issue_date");
		sqljob.appendSQL("then (select bank_name from bank_ref B where B.id  = M.belong_to_bank_id) else bank_name end) BANK_NAME");
		sqljob.appendSQL(" from bank_ref M WHERE id = B.bank_id) AS BANK_NAME,");
		sqljob.appendSQL("(select sum(origin_interest_amount) from debt_main where issue_id = A.id ) AS SUM_ORIGIN_AMOUNT , ");
		sqljob.appendSQL("A.ISSUE_SERIAL,DATEDIFF(DD, A.ISSUE_DATE, A.DUE_DATE) AS DAYS,");
		sqljob.appendSQL("A.ISSUE_DATE, A.DUE_DATE, B.COMPARE_RATE, B.ISSUE_AMOUNT ,isNull(B.ORIGIN_INTEREST_AMOUNT,0) as ORIGIN_INTEREST_AMOUNT ,");
		sqljob.appendSQL("B.REMARK,");
		sqljob.appendSQL("(SELECT max(REPAY_DATE)");
		sqljob.appendSQL("FROM payment_main");
		sqljob.appendSQL("WHERE (DEBT_ID = B.id) AND (REPAY_DATE <> A.DUE_DATE) ) as REPAY_DATE");
		sqljob.appendSQL("FROM ISSUE_MAIN A, DEBT_MAIN B");
		sqljob.appendSQL("WHERE B.ISSUE_ID = A.ID AND DEBT_TYPE ='D'");
		sqljob.appendSQL("AND B.ACCRUE ='Y'");
		if(myForm.getAccountYear()!=null && !"".equals(myForm.getAccountYear()))
			sqljob.appendSQL("AND A.ACCOUNT_YEAR = "+myForm.getAccountYear());
		
		if(myForm.getStartSerial()!=null && !"".equals(myForm.getStartSerial()))
			sqljob.appendSQL("AND A.ISSUE_SERIAL >= '"+myForm.getStartSerial()+"'");
		
		if(myForm.getEndSerial()!=null && !"".equals(myForm.getEndSerial()))
			sqljob.appendSQL("AND A.ISSUE_SERIAL <= '"+myForm.getEndSerial()+"'");
		
		if(myForm.getStartDate()!=null)
			sqljob.appendSQL("AND A.ISSUE_DATE >= '"+DateUtil.date2Str(myForm.getStartDate(),"yyyy/mm/dd")+"'");
		
		if(myForm.getEndDate()!=null)
			sqljob.appendSQL("AND A.ISSUE_DATE <= '"+DateUtil.date2Str(myForm.getEndDate(),"yyyy/mm/dd")+"'");
		
		if(myForm.getDebtCode()!=0 )
			sqljob.appendSQL("AND A.DEBT_CODE = "+myForm.getDebtCode());
		
		if(myForm.getBudgetCode()!=0 )
			sqljob.appendSQL("AND A.BUDGET_CODE = "+myForm.getBudgetCode());
		
		sqljob.appendSQL("ORDER BY A.ACCOUNT_YEAR,A.SERIAL_NO,B.COMPARE_RATE");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob updTemp(String issueSerial , BigDecimal interestAmount){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("UPDATE DIRA11_RPT SET INTEREST_AMOUNT = ? WHERE ISSUE_SERIAL = ? AND BANK_NAME = ISSUE_SERIAL");
		sqljob.addParameter(interestAmount);
		sqljob.addParameter(issueSerial);
		return sqljob;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delSQLJob("DIRA11_RPT",usrId));
		SQLJob query = selTemp(form);
		List list = (List) run.query(query, new MapListHandler()); 
		String issueSerial =null;
		BigDecimal interestAmount = new BigDecimal(0);
		for(Iterator it=list.iterator();it.hasNext() ;)
		{
			Map map = (Map)it.next();
			System.out.println(map);
			if(issueSerial == null || !issueSerial.equals(map.get("issue_serial").toString()) )
			{
				if(issueSerial != null)
					run.update(connection,updTemp(issueSerial,interestAmount));
				issueSerial = map.get("issue_serial").toString();
				Map mapIssueMain = new HashMap();
				DebtMain dto = new DebtManager().getBean((Integer)map.get("id"));
				issueSerial = dto.getIssue().getIssueSerial();
				mapIssueMain.put("bank_name",dto.getIssue().getIssueSerial());
				mapIssueMain.put("issue_serial",dto.getIssue().getIssueSerial());
				mapIssueMain.put("days",DateUtil.getDays(dto.getIssue().getIssueDate(),dto.getIssue().getDueDate()));
				mapIssueMain.put("issue_date",dto.getIssue().getIssueDate());
				mapIssueMain.put("due_date",dto.getIssue().getDueDate());
				mapIssueMain.put("issue_amount",dto.getIssue().getIssueAmount());
				mapIssueMain.put("compare_rate",dto.getIssue().getAverageRate());
				mapIssueMain.put("interest_amount",map.get("sum_origin_amount"));
				mapIssueMain.put("remark",dto.getIssue().getRemark());
				run.update(connection,insTemp("DIRA11_RPT",mapIssueMain));
				interestAmount = new BigDecimal(0);
			}
			if(issueSerial.equals(map.get("issue_serial").toString()) )
			{
				issueSerial = map.get("issue_serial").toString();
				Map mapIssueMain = new HashMap();
				mapIssueMain.put("bank_name",map.get("bank_name"));
				mapIssueMain.put("issue_serial",map.get("issue_serial"));
				mapIssueMain.put("days",map.get("days"));
				mapIssueMain.put("issue_date",map.get("issue_date"));
				mapIssueMain.put("due_date",map.get("due_date"));
				mapIssueMain.put("issue_amount",map.get("issue_amount"));
				mapIssueMain.put("compare_rate",map.get("compare_rate"));
				mapIssueMain.put("interest_amount",map.get("origin_interest_amount"));
				mapIssueMain.put("remark","");
				mapIssueMain.put("repay_date",map.get("repay_date"));
				run.update(connection,insTemp("DIRA11_RPT",mapIssueMain));
				interestAmount = interestAmount.add((BigDecimal)map.get("origin_interest_amount"));
			}
		}
	}
}
