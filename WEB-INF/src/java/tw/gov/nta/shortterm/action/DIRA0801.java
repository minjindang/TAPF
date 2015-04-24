/**
 * @author Andrew Sung
 * @create 2006/4/13
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.ExcelReportRemainAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.shortterm.form.Dira0701Form;
import tw.gov.nta.sql.debt.IssueMain;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class DIRA0801 extends ExcelReportRemainAction
{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM DIRA08_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob selCapitalAmount(Integer id)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT DEBT_ID,CAPITAL_AMOUNT FROM PAYMENT_MAIN WHERE DEBT_ID = ?");
		sqljob.addParameter(id);
		return sqljob;
	}
	
	protected SQLJob selAll(ActionForm form){
		Dira0701Form myForm = (Dira0701Form)form;
		String statrDate = null;
		String endDate = null;
		if(myForm.getStartDate() != null)
			statrDate = DateUtil.date2Str(myForm.getStartDate(),"yyyy/mm/dd");
		if(myForm.getEndDate() != null)
			endDate = DateUtil.date2Str(myForm.getEndDate(),"yyyy/mm/dd");
		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("SELECT A.Account_Year,a.ID AS ISSUE_ID ,B.ID,(SELECT BANK_NAME FROM BANK_REF WHERE ID = B.BANK_ID) AS BANK_NAME,");
		sqljob.appendSQL("SELECT A.Account_Year,a.ID AS ISSUE_ID ,B.ID,(select (case when combination_date is not null and belong_to_bank_id <> 0 and combination_date < A.issue_date");
		sqljob.appendSQL("then (select bank_name from bank_ref B where B.id  = M.belong_to_bank_id) else bank_name end) bank_name");
		sqljob.appendSQL(" from bank_ref M WHERE id = B.bank_id) AS BANK_NAME,");
		sqljob.appendSQL("DATEDIFF(DD,A.ISSUE_DATE,A.DUE_DATE) AS DAYS,A.ISSUE_DATE,A.DUE_DATE,");
		sqljob.appendSQL("A.ISSUE_SERIAL,B.ISSUE_AMOUNT,B.COMPARE_RATE ,");
		sqljob.appendSQL(" b.ISSUE_AMOUNT-isnull((select sum(isnull(capital_amount,0)) from payment_main where debt_id = b.id ),0) AS TOTAL_AMOUNT ");
		sqljob.appendSQL("FROM ISSUE_MAIN A, DEBT_MAIN B");
		sqljob.appendSQL("WHERE DEBT_TYPE ='D' AND A.ID = B.ISSUE_ID ");
		sqljob.appendSQL("AND b.ISSUE_AMOUNT > isnull((select sum(isnull(capital_amount,0)) from payment_main where debt_id = b.id ),0)");
		sqljob.appendSQL("AND B.ISSUE_AMOUNT > 0");
		sqljob.appendSQL("AND B.ACCRUE ='Y'");
		if(myForm.getBegAccYear()!=null &&myForm.getBegAccYear().trim().length()>0)
			sqljob.appendSQL("AND ACCOUNT_YEAR >='"+myForm.getBegAccYear()+"'");
		if(myForm.getEndAccYear()!=null &&myForm.getEndAccYear().trim().length()>0)
				sqljob.appendSQL("AND ACCOUNT_YEAR <= '"+myForm.getEndAccYear()+"'");
		if(myForm.getStartSerial()!= null && !"".equals(myForm.getStartSerial()))
			sqljob.appendSQL("AND ISSUE_SERIAL>='"+myForm.getStartSerial()+"'");
		if(myForm.getEndSerial() != null && !"".equals(myForm.getEndSerial()))
			sqljob.appendSQL("AND ISSUE_SERIAL<='"+myForm.getStartSerial()+"'");
		if(statrDate != null)
			sqljob.appendSQL("AND ISSUE_DATE>='"+statrDate+"'");
		if(endDate != null)
			sqljob.appendSQL("AND ISSUE_DATE<='"+endDate+"'");
		if(myForm.getBudgetCode()!= null && myForm.getBudgetCode()!=0)
			sqljob.appendSQL("AND B.BUDGET_CODE="+myForm.getBudgetCode());
		if(myForm.getDebtCode()!=null && myForm.getDebtCode() != 0)
			sqljob.appendSQL("AND B.DEBT_CODE="+myForm.getDebtCode());
//		else
//			sqljob.appendSQL("AND B.DEBT_CODE <>(SELECT ID FROM DEBIT_REF WHERE DEBIT_TYPE='DA')");
		sqljob.appendSQL("ORDER BY ISSUE_SERIAL");
		System.out.println(sqljob);
		return sqljob;
	}
	
	protected SQLJob insTemp(String usrId,Map map){
		SQLJob sqljob = new SQLJob();
		System.out.println(map);
		sqljob.appendSQL("INSERT INTO DIRA08_RPT");
		sqljob.appendSQL("(USRID, BANK_NAME, ISSUE_SERIAL, ");
		sqljob.appendSQL("DAYS, ISSUE_DATE, DUE_DATE, ");
		sqljob.appendSQL("ISSUE_AMOUNT, COMPARE_RATE, ");
		sqljob.appendSQL("COMPITAL_AMOUNT ");
		sqljob.appendSQL(") ");
		sqljob.appendSQL("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ? )");
		sqljob.addParameter(usrId);
		sqljob.addParameter((map.get("bank_name")!=null)?map.get("bank_name"):"");
		sqljob.addParameter(map.get("issue_serial"));
		sqljob.addParameter(map.get("days"));
		if(map.get("issue_date")!=null)
		{
			String date = DateUtil.date2Str(DateUtil.str2Date(map.get("issue_date").toString()),"yyyy/mm/dd");
			sqljob.addParameter(map.get("issue_date"));
		}
		else 
			sqljob.addParameter("");
		if(map.get("due_date")!=null)
		{
			String date = DateUtil.date2Str(DateUtil.str2Date(map.get("due_date").toString()),"yyyy/mm/dd");
			sqljob.addParameter(map.get("due_date"));
		}
		else 
			sqljob.addParameter("");
		if(map.get("issue_amount")!= null)
			sqljob.addParameter(map.get("issue_amount"));
		else
			sqljob.addParameter(new BigDecimal(0));
		if(map.get("compare_rate")!= null)
			sqljob.addParameter(((BigDecimal)map.get("compare_rate")).divide(new BigDecimal(100)));
		else
			sqljob.addParameter(new BigDecimal(0));
		
		if(map.get("compital_amount")!= null)
			sqljob.addParameter(map.get("compital_amount"));
		else 
			sqljob.addParameter(new BigDecimal(0));
//		if(map.get("total_amount")!= null){
//			BigDecimal capitalAmount = new BigDecimal((map.get("compital_amount")!=null)?map.get("compital_amount").toString():"0") ;
//			BigDecimal borrowAmount = new BigDecimal((map.get("total_amount")!=null)?map.get("total_amount").toString():"0") ;
//			sqljob.addParameter(capitalAmount.divide(borrowAmount,5).setScale(3,BigDecimal.ROUND_HALF_UP));
//		}
//		else 
//			sqljob.addParameter(new BigDecimal(0));
//		System.out.println(sqljob.toString());
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
		SQLJob queryAll = selAll(form);
		List listAll = (List) run.query(queryAll, new MapListHandler()); 
		BigDecimal  totalCompital = new BigDecimal(0);
		BigDecimal  totalCompital2 = new BigDecimal(0);
		String issueSerial =null;
		BigDecimal issueAmount = new BigDecimal(0);
		BigDecimal compitalAmount = new BigDecimal(0);
		BigDecimal borrowAmount = new BigDecimal(0);
		String lastYear = "";
		for(Iterator itAll = listAll.iterator();itAll.hasNext();){
			Map mapAll = (Map)itAll.next();
			if(mapAll != null){	
				BigDecimal yearAmount = new BigDecimal(0);
				if(lastYear.equals(""))
					yearAmount = this.getYearAmountB(connection,mapAll.get("account_year").toString(),new BigDecimal(1));
				else
					yearAmount = this.getYearAmountB(connection,lastYear,new BigDecimal(1));
				if(issueSerial == null){
					issueSerial = mapAll.get("issue_serial").toString();
					Map map = insertSourceIssue ((Integer)mapAll.get("issue_id"),connection,usrId) ;
					mapAll.put("issue_date",map.get("issue_date"));
					mapAll.put("due_date",map.get("due_date"));
					lastYear = mapAll.get("account_year").toString();
				}
				else if(!issueSerial.equals(mapAll.get("issue_serial").toString()) ){
					issueSerial = mapAll.get("issue_serial").toString();
					run.update(connection,"INSERT INTO DIRA08_RPT(USRID,BANK_NAME,ISSUE_AMOUNT,COMPITAL_AMOUNT,TOTAL_AMOUNT)VALUES('"+usrId+"','合計',"+issueAmount+","+compitalAmount+","+this.divideCheck(totalCompital2,yearAmount)+")");
					if(!lastYear.equals(mapAll.get("account_year").toString()))
						totalCompital2 = new BigDecimal(0);
					lastYear = mapAll.get("account_year").toString();
					issueAmount = new BigDecimal(0);
					compitalAmount = new BigDecimal(0);
					Map map = insertSourceIssue ((Integer)mapAll.get("issue_id"),connection,usrId) ;
					mapAll.put("issue_date",map.get("issue_date"));
					mapAll.put("due_date",map.get("due_date"));
				}
				SQLJob queryDebt = selCapitalAmount((Integer)mapAll.get("id"));
				List list = (List) run.query(queryDebt, new MapListHandler()); 
				if(list.size()>0)
				{
					for(Iterator it = list.iterator();it.hasNext();)
					{
						Map map = (Map) it.next();
						if(map != null)
						{
							mapAll.put("compital_amount",((BigDecimal)mapAll.get("issue_amount")).subtract((BigDecimal)map.get("capital_amount")));
							totalCompital = totalCompital.add((BigDecimal)mapAll.get("compital_amount"));
							if(mapAll.get("issue_serial").toString().indexOf("公")>0)
								totalCompital2 = totalCompital2.add(new BigDecimal(0));
							else
								totalCompital2 = totalCompital2.add((BigDecimal)mapAll.get("compital_amount"));
							issueAmount = issueAmount.add((BigDecimal)mapAll.get("issue_amount"));
							compitalAmount = compitalAmount.add((BigDecimal)mapAll.get("compital_amount"));
							borrowAmount= (BigDecimal)mapAll.get("total_amount");
							run.update(connection,insTemp(usrId,mapAll));
						}
					}
				}
				else
				{
					mapAll.put("compital_amount",mapAll.get("issue_amount"));
					totalCompital = totalCompital.add((BigDecimal)mapAll.get("compital_amount"));
					if(mapAll.get("issue_serial").toString().indexOf("公")>0)
						totalCompital2 = totalCompital2.add(new BigDecimal(0));
					else
						totalCompital2 = totalCompital2.add((BigDecimal)mapAll.get("compital_amount"));
					issueAmount = issueAmount.add((BigDecimal)mapAll.get("issue_amount"));
					compitalAmount = compitalAmount.add((BigDecimal)mapAll.get("compital_amount"));
					borrowAmount= (BigDecimal)mapAll.get("total_amount");
					run.update(connection,insTemp(usrId,mapAll));
				}
				if(!itAll.hasNext())
				{
					Map map = new HashMap();
					run.update(connection,"INSERT INTO DIRA08_RPT(USRID,BANK_NAME,ISSUE_AMOUNT,COMPITAL_AMOUNT,TOTAL_AMOUNT)VALUES('"+usrId+"','合計',"+issueAmount+","+compitalAmount+","+this.divideCheck(totalCompital2,yearAmount)+")");

				}
			}
		}
		request.setAttribute("totalCompital",totalCompital);
		request.setAttribute("borrowAmount",borrowAmount);
	}
	@SuppressWarnings("unchecked")
	private Map insertSourceIssue(int issueId,Connection connection,String usrId) throws SQLException {
		SQLRunner run = new ConnectionSQLRunner(connection);
		IssueMain dto = new IssueManager().getBean(issueId);
		Map map = new HashMap();
		map.put("bank_name",dto.getIssueSerial());
		map.put("issue_serial",dto.getIssueSerial());
		map.put("days",DateUtil.getDays(dto.getIssueDate(),dto.getDueDate()));
		map.put("issue_date",dto.getIssueDate());
		map.put("due_date",dto.getDueDate());
		map.put("issue_amount",dto.getIssueAmount());
		map.put("compare_rate",dto.getAverageRate());
		map.put("compital_amount",dto.getIssueAmount().subtract((dto.getCapitalAmount()!= null)?dto.getCapitalAmount():new BigDecimal(0)));
		run.update(connection,insTemp(usrId,map));
		return map;
	}
}
