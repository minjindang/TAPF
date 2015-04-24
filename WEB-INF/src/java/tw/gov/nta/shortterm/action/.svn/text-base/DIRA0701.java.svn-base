/**
 * @author Andrew Sung
 * @create 2006/4/13
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.shortterm.form.Dira0701Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class DIRA0701 extends DefaultAction
{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM DIRA07_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
//	protected SQLJob selAll(ActionForm form){
//		Dira0701Form myForm = (Dira0701Form)form;
//		String statrDate = null;
//		String endDate = null;
//		if(myForm.getStartDate() != null)
//			statrDate = DateUtil.date2Str(myForm.getStartDate(),"yyyy/mm/dd");
//		if(myForm.getEndDate() != null)
//			endDate = DateUtil.date2Str(myForm.getEndDate(),"yyyy/mm/dd");
//		SQLJob sqljob = new SQLJob();		
//		sqljob.appendSQL("SELECT ISSUE_SERIAL, ISSUE_AMOUNT, ISSUE_DATE, DUE_DATE,");
//		sqljob.appendSQL("(SELECT SUM(COMPARE_AMOUNT)FROM DEBT_MAIN");
//		sqljob.appendSQL("WHERE ISSUE_ID = ISSUE_MAIN.ID) AS COMPARE_SUM, ");
//		sqljob.appendSQL("(SELECT MAX(COMPARE_RATE) FROM DEBT_MAIN");
//		sqljob.appendSQL("WHERE ISSUE_ID = ISSUE_MAIN.ID) AS MAX_COMPARE_RATE,");
//		sqljob.appendSQL("(SELECT MIN(COMPARE_RATE)FROM DEBT_MAIN");
//		sqljob.appendSQL("WHERE ISSUE_ID = ISSUE_MAIN.ID) AS MIN_COMPARE_RATE, ");
//		sqljob.appendSQL("(SELECT SUM(ORIGIN_INTEREST_AMOUNT)");
//		sqljob.appendSQL("FROM DEBT_MAIN WHERE ISSUE_ID = ISSUE_MAIN.ID) AS INTEREST_AMOUNT, ");
//		sqljob.appendSQL("AVERAGE_RATE FROM ISSUE_MAIN");
//		sqljob.appendSQL("WHERE DEBT_TYPE ='D'");
//		if(myForm.getAccountYear()!=null && " ".equals(myForm.getAccountYear()))
//			sqljob.appendSQL("AND ACCOUNT_YEAR ='"+myForm.getAccountYear()+"'");
//		if(myForm.getStartSerial()!= null && " ".equals(myForm.getStartSerial()))
//			sqljob.appendSQL("AND SERIAL_NO>'"+myForm.getStartSerial()+"'");
//		if(myForm.getEndSerial() != null && " ".equals(myForm.getEndSerial()))
//			sqljob.appendSQL("AND SERIAL_NO<'"+myForm.getStartSerial()+"'");
//		if(statrDate != null)
//			sqljob.appendSQL("AND ISSUE_DATE>'"+statrDate+"'");
//		if(endDate != null)
//		sqljob.appendSQL("AND DUE_DATE<'"+endDate+"'");
//		if(myForm.getBudgetCode()!= null && myForm.getBudgetCode()!=0)
//			sqljob.appendSQL("AND BUDGET_CODE="+myForm.getBudgetCode());
//		if(myForm.getDebtCode()!=null && myForm.getDebtCode() != 0)
//			sqljob.appendSQL("AND DEBT_CODE="+myForm.getDebtCode());
//		System.out.println(sqljob);
//		return sqljob;
//	}
	
	protected SQLJob insTemp(String usrId,ActionForm form){
		Dira0701Form myForm = (Dira0701Form)form;
		String statrDate = null;
		String endDate = null;
		if(myForm.getStartDate() != null)
			statrDate = DateUtil.date2Str(myForm.getStartDate(),"yyyy/mm/dd");
		if(myForm.getEndDate() != null)
			endDate = DateUtil.date2Str(myForm.getEndDate(),"yyyy/mm/dd");
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO DIRA07_RPT");
		sqljob.appendSQL("(USRID, ISSUE_SERIAL, CAPITAL_AMOUNT, ");
		sqljob.appendSQL("DAYS, ISSUE_DATE, DUE_DATE, ");
		sqljob.appendSQL("COMPARE_SUM, COMPARE_PERCENT, ");
		sqljob.appendSQL("MAX_RATE, MIN_RATE, ");
		sqljob.appendSQL("AVERAGE_RATE, INTETEST_AMOUNT) ");
		
		sqljob.appendSQL("SELECT '"+usrId+"', ISSUE_SERIAL, MAX(A.ISSUE_AMOUNT), ");
		sqljob.appendSQL("DATEDIFF(DD,MAX(ISSUE_DATE), MAX(DUE_DATE))AS DAYS, ");
		sqljob.appendSQL("MAX(ISSUE_DATE), MAX(DUE_DATE), ");
		sqljob.appendSQL("SUM(B.COMPARE_AMOUNT), ");
		sqljob.appendSQL("(SUM(B.COMPARE_AMOUNT)/(CASE MAX(A.ISSUE_AMOUNT) WHEN 0 THEN 1 ELSE MAX(A.ISSUE_AMOUNT) END)),");
		sqljob.appendSQL("MAX(COMPARE_RATE) /100, MIN(COMPARE_RATE)/100, MAX(AVERAGE_RATE)/100, ");
		sqljob.appendSQL("(select SUM(ORIGIN_INTEREST_AMOUNT)from debt_main where issue_id = a.id and accrue='Y') ");
		sqljob.appendSQL("FROM ISSUE_MAIN A, DEBT_MAIN B ");
		sqljob.appendSQL("WHERE A.DEBT_TYPE='D' ");
		sqljob.appendSQL("AND B.ISSUE_ID=A.ID ");
		sqljob.appendSQL(" ");
		if(myForm.getAccountYear()!=null && myForm.getAccountYear().trim().length()>0)
			sqljob.appendSQL("AND A.ACCOUNT_YEAR ='"+myForm.getAccountYear()+"'");
		if(myForm.getStartSerial()!= null && myForm.getStartSerial().trim().length()>0)
			sqljob.appendSQL("AND A.SERIAL_NO>='"+myForm.getStartSerial()+"'");
		if(myForm.getEndSerial() != null && myForm.getEndSerial().trim().length()>0)
			sqljob.appendSQL("AND A.SERIAL_NO<='"+myForm.getEndSerial()+"'");
		if(statrDate != null)
			sqljob.appendSQL("AND A.ISSUE_DATE>='"+statrDate+"'");
		if(endDate != null)
			sqljob.appendSQL("AND A.ISSUE_DATE<='"+endDate+"'");
		if(myForm.getBudgetCode()!= null && myForm.getBudgetCode()!=0)
			sqljob.appendSQL("AND A.BUDGET_CODE="+myForm.getBudgetCode());
		if(myForm.getDebtCode()!=null && myForm.getDebtCode() != 0)
			sqljob.appendSQL("AND A.DEBT_CODE="+myForm.getDebtCode());
		sqljob.appendSQL("GROUP BY ISSUE_SERIAL,a.id");
		
		
//		sqljob.appendSQL("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//		sqljob.addParameter(usrId);
//		sqljob.addParameter(map.get("issue_serial"));
//		if(map.get("issue_amount")!= null)
//			sqljob.addParameter(map.get("issue_amount"));
//		else
//			sqljob.addParameter(new BigDecimal(0));
//		sqljob.addParameter(map.get("days"));
//		if(map.get("issue_date")!=null)
//		{
//			String date = DateUtil.date2Str(DateUtil.str2Date(map.get("issue_date").toString()),"yyyy/mm/dd");
//			sqljob.addParameter(date);
//		}
//		else 
//			sqljob.addParameter("");
//		if(map.get("due_date")!=null)
//		{
//			String date = DateUtil.date2Str(DateUtil.str2Date(map.get("due_date").toString()),"yyyy/mm/dd");
//			sqljob.addParameter(date);
//		}
//		else 
//			sqljob.addParameter("");
//		if(map.get("compare_sum")!= null)
//			sqljob.addParameter(map.get("compare_sum"));
//		else 
//			sqljob.addParameter(new BigDecimal(0));
//		if(map.get("compare_percent")!= null)
//			sqljob.addParameter(map.get("compare_percent"));
//		else
//			sqljob.addParameter(new BigDecimal(0));
//		if(map.get("max_compare_rate")!= null)
//			sqljob.addParameter(map.get("max_compare_rate"));
//		else
//			sqljob.addParameter(new BigDecimal(0));
//		if(map.get("min_compare_rate")!= null)
//			sqljob.addParameter(map.get("min_compare_rate"));
//		else
//			sqljob.addParameter(new BigDecimal(0));
//		if(map.get("average_rate")!= null)
//			sqljob.addParameter(map.get("average_rate"));
//		else
//			sqljob.addParameter(new BigDecimal(0));
//		if(map.get("interest_amount")!= null) 
//			sqljob.addParameter(map.get("interest_amount"));
//		else
//			sqljob.addParameter(new BigDecimal(0));
		System.out.println(sqljob);
		return sqljob;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(form,usrId));
		run.update(connection,insTemp(usrId,form));
//		SQLJob queryAll = selAll(form);
//		List listAll = (List) run.query(queryAll, new MapListHandler()); 
//		List tempList = new LinkedList();
//		for(Iterator itAll = listAll.iterator();itAll.hasNext();)
//		{
//			Map mapAll = (Map)itAll.next();
//			if(mapAll != null)
//			{
//				if(mapAll.get("issue_date") != null && mapAll.get("due_date") != null)
//				{
//					mapAll.put("days",DateUtil.getDays((Date)mapAll.get("issue_date"),(Date)mapAll.get("due_date")));
//				}
//				else
//				{
//					mapAll.put("days",new BigDecimal(0));
//				}
//				if(mapAll.get("compare_sum")!= null &&(mapAll.get("issue_amount")!= null && "0".equals(mapAll.get("issue_amount").toString())))
//				{
//					mapAll.put("compare_percent",((BigDecimal)mapAll.get("compare_sum")).divide((BigDecimal)mapAll.get("issue_amount"),4,5));
//				}
//				else if(mapAll.get("compare_sum")!= null)
//					mapAll.put("compare_percent",mapAll.get("compare_sum"));
//				else
//					mapAll.put("compare_percent",new BigDecimal(0));
//				run.update(connection,insTemp(usrId,mapAll));
//			}
//		}
	}
}
