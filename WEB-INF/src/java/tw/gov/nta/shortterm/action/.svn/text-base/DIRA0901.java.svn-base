/**
 * @author Andrew Sung
 * @create 2006/4/13
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.shortterm.form.Dira0901Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class DIRA0901 extends ExcelReportRemainAction
{
	protected SQLJob SQL1(Dira0901Form myForm){

		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select");
		sqljob.appendSQL("Right('000'+convert(varchar(3),case when year(issue_date) < 2000 ");
		sqljob.appendSQL("and month(issue_date) > 6 ");
		sqljob.appendSQL("then year(issue_date)+1 else year(issue_date) end-1911),3) as year1,");
		sqljob.appendSQL("isNull(sum(issue_amount),0) as issue_amount from issue_main ");
		sqljob.appendSQL("where debt_type='D' ");
//		sqljob.appendSQL("and account_year >= '"+myForm.getStartAccountYear()+"' ");
		sqljob.appendSQL("and account_year <= '"+myForm.getEndAccountYear()+"' ");
		sqljob.appendSQL("and issue_date <= '"+new Timestamp(new Date().getTime())+"' ");
		if(myForm.getBudgetCode()!=null && myForm.getBudgetCode() != 0)
			sqljob.appendSQL("AND BUDGET_CODE = "+myForm.getBudgetCode());
		if(myForm.getDebtCode()!=null && myForm.getDebtCode() != 0)
			sqljob.appendSQL("AND DEBT_CODE = "+myForm.getDebtCode());
//		else
//			sqljob.appendSQL("AND DEBT_CODE <>(SELECT ID FROM DEBIT_REF WHERE DEBIT_TYPE='DA')");
		sqljob.appendSQL("");
		sqljob.appendSQL("group by Right('000'+convert(varchar(3),case when year(issue_date) < 2000 ");
		sqljob.appendSQL("and month(issue_date) > 6 ");
		sqljob.appendSQL("then year(issue_date)+1 else year(issue_date) end-1911),3) ");
		sqljob.appendSQL("order by Right('000'+convert(varchar(3),case when year(issue_date) < 2000 ");
		sqljob.appendSQL("and month(issue_date) > 6 ");
		sqljob.appendSQL("then year(issue_date)+1 else year(issue_date) end-1911),3) ");
		System.out.println("DIRA0901-SQL1:"+sqljob);
		return sqljob;
	}
	protected SQLJob SQL2(Dira0901Form myForm,String year){
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT isNull(SUM(CAPITAL_AMOUNT),0) AS capital_amount");
		sqljob.appendSQL("FROM payment_main");
		sqljob.appendSQL("WHERE (ISSUE_ID IN");
		sqljob.appendSQL(" (SELECT id");
		sqljob.appendSQL(" FROM issue_main");
		sqljob.appendSQL(" WHERE debt_type = 'D' ");
		if(myForm.getBudgetCode()!=null && myForm.getBudgetCode() != 0)
			sqljob.appendSQL("AND BUDGET_CODE = "+myForm.getBudgetCode());
		if(myForm.getDebtCode()!=null && myForm.getDebtCode() != 0)
			sqljob.appendSQL("AND DEBT_CODE = "+myForm.getDebtCode());
//		else
//			sqljob.appendSQL("AND DEBT_CODE <> (SELECT ID FROM DEBIT_REF WHERE DEBIT_TYPE='DA')");
		sqljob.appendSQL(" )) ");
		
		if(Integer.parseInt(year) == 89)
			sqljob.appendSQL(" AND (REPAY_DATE >= '"+String.valueOf(88+1911)+"/1/1')  ");
		else
			sqljob.appendSQL(" AND (REPAY_DATE >= '"+String.valueOf(Integer.parseInt(year)+1911)+"/1/1')  ");
		sqljob.appendSQL(" AND (REPAY_DATE <= '"+String.valueOf(Integer.parseInt(year)+1911)+"/12/31')");
		System.out.println("BIRA0601-SQL2:"+sqljob);
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dira0901Form myForm = (Dira0901Form)form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//刪除資料
		run.update(connection,this.delSQLJob("DIRA09_RPT",usrId));
		//執行 insert
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = null;
		Map dMap = new HashMap();
		
		//年底未償餘額
		BigDecimal thisNoPayAmount = new BigDecimal(0);
		//年初未償餘額
		BigDecimal lastNoPayAmount = new BigDecimal(0);
		
		
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); )
		{			
			tMap = (Map) tIterator.next();
			dMap.putAll(getCommonMap(usrId));
			
			//年度
			dMap.put("ACCOUNT_YEAR",tMap.get("year1"));
			
			//當年發行額
			dMap.put("BORROW",(BigDecimal)tMap.get("issue_amount"));
			
			//當年還本金
			Map queryMap = (Map) run.query(SQL2(myForm,(String) dMap.get("ACCOUNT_YEAR")), new MapHandler());
			dMap.put("CAPITAL_AMOUNT",(BigDecimal)queryMap.get("capital_amount"));
			
			//dMap.put("capital_total",(BigDecimal)tMap.get("issue_total"));
			//當年歲(支)出
			dMap.put("TOTAL_BORROW",this.getYearAmountB(connection,(String)dMap.get("ACCOUNT_YEAR"),new BigDecimal(1)));
			
			//年初未償餘額(年初未償餘額=前一年年底未償餘額)
			dMap.put("LAST_YEAR_BORROW",lastNoPayAmount);
			
//			dMap.put("LAST_YEAR_BORROW", tMap.get(""));
			//年底未償餘額(前一年未償餘額+發行總數-總還本數)
			thisNoPayAmount= lastNoPayAmount.add((BigDecimal)dMap.get("BORROW")).subtract((BigDecimal)dMap.get("CAPITAL_AMOUNT"));
			dMap.put("THIS_YEAR_BORROW",thisNoPayAmount);
			//未償餘額/歲(支)出
			dMap.put("BORROW_PERCENT",this.divideCheck(thisNoPayAmount,(BigDecimal)dMap.get("TOTAL_BORROW")));
			
			if (!" ".equals(myForm.getStartAccountYear()) && !" ".equals(myForm.getEndAccountYear())){
				if (Integer.parseInt(myForm.getStartAccountYear()) <= Integer.parseInt((String)dMap.get("ACCOUNT_YEAR")) 
						&& Integer.parseInt(myForm.getEndAccountYear()) >= Integer.parseInt((String)dMap.get("ACCOUNT_YEAR"))){
					if (Integer.parseInt((String)dMap.get("ACCOUNT_YEAR")) >= Integer.parseInt(myForm.getStartAccountYear()))
					{	
					run.update(connection,insTemp("DIRA09_RPT",dMap));
					}
				}
			}
			else
				if (Integer.parseInt((String)dMap.get("ACCOUNT_YEAR")) >= Integer.parseInt(myForm.getStartAccountYear()))
				{	
				run.update(connection,insTemp("DIRA09_RPT",dMap));
				}
			
			lastNoPayAmount = thisNoPayAmount;
			
		}
	}
}













