/**
 * @author Andrew Sung
 * @create 2006/4/13
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.ExcelReportRemainAction;
import gov.dnt.tame.util.DateUtil;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.shortterm.common.ShorttermNoPayCount;
import tw.gov.nta.shortterm.form.Dira0701Form;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class DIRA0501 extends ExcelReportRemainAction
{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM DIRA05_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		
		return sqljob;
	}
	
	protected SQLJob insTemp(String usrId,ActionForm form){
		Dira0701Form myForm = (Dira0701Form)form;
		String statrDate = null;
		String endDate = null;
		if(myForm.getStartDate() != null)
			statrDate = DateUtil.date2Str(myForm.getStartDate(),"yyyy/mm/dd");
		if(myForm.getEndDate() != null)
			endDate = DateUtil.date2Str(myForm.getEndDate(),"yyyy/mm/dd");
		SQLJob sqljob = new SQLJob();

		
		sqljob.appendSQL("SELECT '"+usrId+"' AS USRID, ");
		sqljob.appendSQL("case when (select sum(capital_amount) from payment_main where debt_id = b.id) = b.issue_amount then ");
		sqljob.appendSQL("case when isnull((select max(repay_date) from payment_main where debt_id = b.id),a.due_date) < a.due_date  ");
		sqljob.appendSQL("then '*' else " +
				"case when isnull((select max(repay_date) from payment_main where debt_id = b.id),a.due_date) > a.due_date " +
				"then '**' else '' end end else '' end + ");
		sqljob.appendSQL("MAX(A.ISSUE_SERIAL) AS ISSUE_SERIAL, (MAX(A.ISSUE_AMOUNT)/100000000) AS ISSUE_AMOUNT, ");
		sqljob.appendSQL("DATEDIFF(DD,MAX(ISSUE_DATE), MAX(DUE_DATE)) AS DAYS, ");
		sqljob.appendSQL(" MAX(ISSUE_DATE) AS ISSUE_DATE, MAX(DUE_DATE) AS DUE_DATE,");
		sqljob.appendSQL("(SUM(B.COMPARE_AMOUNT)/100000000) AS COMPARE_AMOUNT, ");
		sqljob.appendSQL("(SELECT ISNULL(MAX(COMPARE_RATE),0) FROM DEBT_MAIN WHERE ISSUE_ID = A.ID AND ACCRUE = 'Y') / 100 AS MAX_COMPARE_RATE, MIN(COMPARE_RATE) / 100 AS MIN_COMPARE_RATE,");
		sqljob.appendSQL("(SUM(B.COMPARE_AMOUNT)/(CASE MAX(A.ISSUE_AMOUNT) WHEN 0 THEN 1 ELSE MAX(A.ISSUE_AMOUNT) END)) AS COMPARE_MULTIPLE,");
		sqljob.appendSQL("case when isnull((select max(repay_date) from payment_main where debt_id = b.id),a.due_date) < a.due_date then ");
		sqljob.appendSQL("b.issue_amount * (max(a.average_rate)/100) * datediff(day,max(a.issue_date),(select max(repay_date) from payment_main where debt_id = b.id)) / 365 else ");
		sqljob.appendSQL("(SELECT SUM(ORIGIN_INTEREST_AMOUNT) FROM DEBT_MAIN WHERE ISSUE_ID = A.ID AND ACCRUE='Y') end AS INTEREST, ");
		sqljob.appendSQL("MAX(A.AVERAGE_RATE) / 100 AS AVERAGE_RATE, ");
		sqljob.appendSQL("A.REMARK AS REMARK ");
		sqljob.appendSQL("FROM ISSUE_MAIN A, DEBT_MAIN B ");
		sqljob.appendSQL("WHERE A.ID=B.ISSUE_ID ");
		sqljob.appendSQL("AND A.DEBT_TYPE='D' ");
		if(myForm.getBegAccYear()!=null && !"".equals(myForm.getBegAccYear()))
			sqljob.appendSQL("AND A.ACCOUNT_YEAR >= '"+myForm.getBegAccYear()+"'");
		if(myForm.getEndAccYear()!=null && !"".equals(myForm.getEndAccYear()))
			sqljob.appendSQL("AND A.ACCOUNT_YEAR <= '"+myForm.getEndAccYear()+"'");
		if(myForm.getStartSerial()!= null && !"".equals(myForm.getStartSerial()))
			sqljob.appendSQL("AND A.SERIAL_NO >= '"+myForm.getStartSerial()+"'");
		if(myForm.getEndSerial() != null && !"".equals(myForm.getEndSerial()))
			sqljob.appendSQL("AND A.SERIAL_NO <='"+myForm.getEndSerial()+"'");
		if(statrDate != null)
			sqljob.appendSQL("AND A.ISSUE_DATE >='"+statrDate+"'");
		else
			sqljob.appendSQL("AND A.ISSUE_DATE <='"+new Timestamp(new Date().getTime())+"'");
		if(endDate != null)
			sqljob.appendSQL("AND A.ISSUE_DATE <= '"+endDate+"'");
		if(myForm.getBudgetCode()!= null && myForm.getBudgetCode()!=0)
			sqljob.appendSQL("AND A.BUDGET_CODE="+myForm.getBudgetCode());
		if(myForm.getDebtCode()!=null && myForm.getDebtCode() != 0)
			sqljob.appendSQL("AND A.DEBT_CODE="+myForm.getDebtCode());
		sqljob.appendSQL("GROUP BY A.ID, B.ISSUE_ID,A.REMARK ,b.id,b.issue_amount,a.due_date ");
		if(myForm.getBudgetCode()!= null && myForm.getBudgetCode()==0 && myForm.getDebtCode()!=null && myForm.getDebtCode() == 0)
			sqljob.appendSQL("ORDER BY MAX(ISSUE_DATE) ");
		else
			sqljob.appendSQL("ORDER BY MAX(A.ISSUE_SERIAL) ");
		System.out.println(sqljob);
		return sqljob;
		
	}
	
	protected SQLJob countTotal(String usrId,ActionForm form){
		Dira0701Form myForm = (Dira0701Form)form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select sum(issue_amount/100000000) as total from issue_main where debt_type = 'D'");
		sqljob.appendSQL("and due_date >='"+new Timestamp(new Date().getTime())+"' ");
		if(myForm.getBudgetCode()!= null && myForm.getBudgetCode()!=0)
			sqljob.appendSQL("AND BUDGET_CODE="+myForm.getBudgetCode());
		if(myForm.getDebtCode()!=null && myForm.getDebtCode() != 0)
			sqljob.appendSQL("AND DEBT_CODE="+myForm.getDebtCode());
		System.out.println(sqljob.toString());
		
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dira0701Form myForm = (Dira0701Form)form;
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(form,usrId));
		List list = (List)run.query(insTemp(usrId,form),new MapListHandler());
		BigDecimal totalAmount = new BigDecimal(0);
		for(Iterator it = list.iterator();it.hasNext();){
			Map mapAll = (Map)it.next();
			String[] issueSerial = {"089-01","089-02","089-03","089-04","089-05","089-06",
					"089-07","089-11","090-01","090-02","090-03","090-05","091-02","091-03","091-04","091-05"};
			String[] amount = {"539","769","607","884","800","742",
					"697","562","1187","1472","1317","835","1425","1300","1455","1610"};
			for(int i = 0 ; i < issueSerial.length ; i++){
				if(mapAll.get("issue_serial").toString().equals(issueSerial[i])){
					mapAll.put("compare_amount", new BigDecimal(amount[i]));
					mapAll.put("compare_multiple", this.divideCheck((BigDecimal)mapAll.get("compare_amount"), (BigDecimal)mapAll.get("issue_amount")));
					
				}
			}
			totalAmount = totalAmount.add((BigDecimal)mapAll.get("issue_amount"));
			run.update(connection,this.insTemp("DIRA05_RPT", mapAll));
		}
		String memo ="";
		if(myForm.getBudgetCode()==0){
			memo = "(內含短期借款"+new ShorttermNoPayCount().noPayAmount(myForm.getBegAccYear(),myForm.getEndAccYear(),myForm.getStartDate(),myForm.getEndDate(),"2").divide(new BigDecimal(100000000),0,4)+"億元及債務基金"+new ShorttermNoPayCount().noPayAmount(myForm.getBegAccYear(),myForm.getEndAccYear(),myForm.getStartDate(),myForm.getEndDate(),"4").divide(new BigDecimal(100000000),0,4)+"億元,民營化基金"+new ShorttermNoPayCount().noPayAmount(myForm.getBegAccYear(),myForm.getEndAccYear(),myForm.getStartDate(),myForm.getEndDate(),"3").divide(new BigDecimal(100000000),0,4)+"億元)";
		}
		String total = "";
//		type 
//		1 = 短借全部未償餘額
//		2 = 國庫(排除債務基金及民營化基金)
//		3 = 民營化基金(debt_code = 25) 
//		4 = 債務基金 (budget_code = 3 || budget_code = 4 && debt_code = 61)
		if(myForm.getBudgetCode()==0)
			total = ""+new ShorttermNoPayCount().noPayAmount(myForm.getBegAccYear(),myForm.getEndAccYear(),myForm.getStartDate(),myForm.getEndDate(),"1").divide(new BigDecimal(100000000),0,4);
		else if (myForm.getBudgetCode()!=0 && myForm.getBudgetCode()!=25 && myForm.getBudgetCode()!=3 &&(myForm.getBudgetCode()!=4 && myForm.getDebtCode()!=61))
			total = ""+new ShorttermNoPayCount().noPayAmount(myForm.getBegAccYear(),myForm.getEndAccYear(),myForm.getStartDate(),myForm.getEndDate(),"2").divide(new BigDecimal(100000000),0,4);

		else if (myForm.getBudgetCode()==4)
			total = ""+new ShorttermNoPayCount().noPayAmount(myForm.getBegAccYear(),myForm.getEndAccYear(),myForm.getStartDate(),myForm.getEndDate(),"3").divide(new BigDecimal(100000000),0,4);
		else if (myForm.getBudgetCode()==3 ||(myForm.getBudgetCode()==4 && myForm.getDebtCode()==61))
			total = ""+new ShorttermNoPayCount().noPayAmount(myForm.getBegAccYear(),myForm.getEndAccYear(),myForm.getStartDate(),myForm.getEndDate(),"4").divide(new BigDecimal(100000000),0,4);
		
		request.setAttribute("memo",memo);
		request.setAttribute("total",total);
		
//		List listTotal = (List) run.query(countTotal(usrId,form),new MapListHandler());
////		String total = (String)listTotal.get(0).toString();
//		Map tMap = null;	
//		for(Iterator tIterator = listTotal.iterator(); tIterator.hasNext(); )
//		{			
//			tMap = (Map) tIterator.next();			
//			request.setAttribute("total",tMap.get("total"));
//		}
		


	}
}
