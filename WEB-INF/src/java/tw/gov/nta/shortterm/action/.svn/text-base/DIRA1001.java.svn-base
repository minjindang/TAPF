/**
 * @author Andrew Sung
 * @create 2006/4/18
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

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.shortterm.form.Dira0701Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class DIRA1001 extends ExcelReportRemainAction
{
	
	protected SQLJob SQL1(Dira0701Form myForm){
		SQLJob sqljob = new SQLJob();
		//sql by Mic
		/*
		sqljob.appendSQL("select issue_serial,issue_date,");
		sqljob.appendSQL("isNull((select sum(isnull(A_total,0)) from v_debtB where kind = '1' and date1 between  issue_main.issue_date and  issue_main.due_date),0) as issue_total,");
		sqljob.appendSQL("isNull((select sum(isnull(A_total,0)) from v_debtB where kind = '2' and date1 between  issue_main.issue_date and  issue_main.due_date),0) as capital_total,");
		sqljob.appendSQL("isNull((select sum(isnull(B_total,0)) from v_debtB where kind = '2' and date1 between  issue_main.issue_date and  issue_main.due_date),0) as Interest_total,");
		sqljob.appendSQL("isNull((select sum(isnull(B_total,0)) from v_debtB where kind = '1' and date1 between  issue_main.issue_date and  issue_main.due_date),0) as sub_amount ");
		sqljob.appendSQL("from issue_main");
		sqljob.appendSQL("where debt_type = 'D' ");
		*/
		sqljob.appendSQL("select ");
		sqljob.appendSQL("Right('000'+convert(varchar(3),case when year(A.issue_date) < 2000 ");
		sqljob.appendSQL("and month(A.issue_date) > 6 ");
		sqljob.appendSQL("then year(A.issue_date)+1 else year(A.issue_date) end-1911),3) as year1,");
		sqljob.appendSQL("A.issue_serial,A.issue_date,A.due_date,A.issue_amount from issue_main A ");
		sqljob.appendSQL("where A.debt_type='D' ");
		sqljob.appendSQL("and A.issue_date <= '"+new Timestamp(new Date().getTime())+"' ");
		//if(myForm.getStartSerial()!= null && !"".equals(myForm.getStartSerial()))
			//sqljob.appendSQL("AND A.ISSUE_SERIAL>='"+myForm.getStartSerial()+"'");
		//if(myForm.getEndSerial() != null && !"".equals(myForm.getEndSerial()))
			//sqljob.appendSQL("AND A.ISSUE_SERIAL<='"+myForm.getEndSerial()+"'");

		if(myForm.getBudgetCode()!=null && myForm.getBudgetCode() != 0)
			sqljob.appendSQL("AND A.BUDGET_CODE = "+myForm.getBudgetCode());
		if(myForm.getDebtCode()!=null && myForm.getDebtCode() != 0)
			sqljob.appendSQL("AND A.DEBT_CODE="+myForm.getDebtCode());
//		else
//			sqljob.appendSQL("AND A.DEBT_CODE <>(SELECT ID FROM DEBIT_REF WHERE DEBIT_TYPE='DA')");
		sqljob.appendSQL("order by A.issue_date,A.issue_serial ");
		//sqljob.appendSQL("order by issue_serial");
		System.out.println("DIRA1001-SQL1:"+sqljob);
		return sqljob;
	}
	
	protected SQLJob SQL2(Dira0701Form myForm,Date lastRepayDate,Date thisRepayDate,String issueSerial){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select isNull(sum(B.capital_amount),0) as capital_amount ");
		sqljob.appendSQL("from issue_main A,PAYMENT_MAIN B ");
		sqljob.appendSQL("where A.id = B.issue_id ");
		sqljob.appendSQL("and A.debt_type = 'D' ");
		sqljob.appendSQL("and repay_date <= '"+new Timestamp(new Date().getTime())+"' ");
		sqljob.appendSQL("and repay_date > '"+new Timestamp(lastRepayDate.getTime())+"' ");
		sqljob.appendSQL("and A.issue_serial = '"+issueSerial+"' ");
		//sqljob.appendSQL("and repay_date <= '"+new Timestamp(thisRepayDate.getTime())+"' ");
		if(myForm.getBudgetCode()!=null && myForm.getBudgetCode() != 0)
			sqljob.appendSQL("AND A.BUDGET_CODE = "+myForm.getBudgetCode());
		if(myForm.getDebtCode()!=null && myForm.getDebtCode() != 0)
			sqljob.appendSQL("AND A.DEBT_CODE="+myForm.getDebtCode());
//		else
//			sqljob.appendSQL("AND A.DEBT_CODE <>(SELECT ID FROM DEBIT_REF WHERE DEBIT_TYPE='DA')");
		System.out.println("BIRA0701-SQL2:" + sqljob);
		return sqljob;
	}
	protected SQLJob SQL3(String issueSerial){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select issue_date from  issue_main ");
		sqljob.appendSQL("where debt_type='D' and issue_serial = '"+issueSerial+"' ");
		System.out.println("BIRA0701-SQL2:" + sqljob);
		return sqljob;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dira0701Form myForm = (Dira0701Form)form;
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,this.delSQLJob("DIRA10_RPT",usrId));
		//執行 insert
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = null;
		Map dMap = new HashMap();
		//截至每期借款日之未償餘額
		BigDecimal thisNoPayAmount = new BigDecimal(0);
		//截至上期借款日之未償餘額
		BigDecimal lastNoPayAmount = new BigDecimal(0);
		Date lastDate = DateUtil.str2Date(DateUtil.getLastDateOfMonth("000","01"));
		Date chooseSDate = DateUtil.str2Date(DateUtil.getLastDateOfMonth("000","01"));
		Date chooseEDate = new Date();
		//開始期別的發行日
		if (myForm.getStartSerial()!= null && !"".equals(myForm.getStartSerial())){
			Map queryMap = (Map) run.query(SQL3(myForm.getStartSerial()), new MapHandler());
			if (queryMap != null)
				chooseSDate = (Date) queryMap.get("issue_date");
		}
		//結束期別的發行日
		if(myForm.getEndSerial() != null && !"".equals(myForm.getEndSerial())){
			Map queryMap = (Map) run.query(SQL3(myForm.getEndSerial()), new MapHandler());
			if (queryMap != null)
				chooseEDate = (Date) queryMap.get("issue_date");
		}
		//取最小區間
		if ((myForm.getEndDate() != null && myForm.getStartDate() != null)){
			if (myForm.getEndDate().before(chooseEDate))
				chooseEDate = myForm.getEndDate();
			if (!myForm.getStartDate().before(chooseSDate))
				chooseSDate = myForm.getStartDate();
		}
		
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); )
		{
			tMap = (Map) tIterator.next();
			dMap.putAll(getCommonMap(usrId));
			//期別
			dMap.put("ISSUE_SERIAL",(String)tMap.get("issue_serial"));
			if (String.valueOf(tMap.get("issue_serial")).equals("096-03")){
				System.out.println("test");
			}
			//借款日
			dMap.put("ISSUE_DATE",(Date)tMap.get("issue_date"));
			//截至上期借款日之未償餘額
			dMap.put("LAST_ISSUE_AMOUNT",lastNoPayAmount);
			//發行額
			dMap.put("ISSUE_AMOUNT",(BigDecimal)tMap.get("issue_amount"));
			//還本額
			Map queryMap = (Map) run.query(SQL2(myForm,lastDate,(Date) dMap.get("ISSUE_DATE"),String.valueOf(tMap.get("issue_serial"))), new MapHandler());
			dMap.put("CAPITAL_AMOUNT",(BigDecimal)queryMap.get("capital_amount"));
			//截至本期借款日未償餘額
			thisNoPayAmount=lastNoPayAmount.add((BigDecimal)dMap.get("ISSUE_AMOUNT")).subtract((BigDecimal)dMap.get("CAPITAL_AMOUNT"));
			dMap.put("THIS_ISSUE_AMOUNT",thisNoPayAmount);
			//歲支出
			dMap.put("TOTAL_AMOUNT",this.getYearAmountB(connection,(String)tMap.get("year1"),new BigDecimal(1)));
			//未償/歲支出
			dMap.put("TOTAL_AMOUNT_PERCENT",this.divideCheck(thisNoPayAmount,(BigDecimal)dMap.get("TOTAL_AMOUNT")));
			if ((myForm.getEndDate() != null && myForm.getStartDate() != null) || (myForm.getStartSerial()!= null && !"".equals(myForm.getStartSerial())) || (myForm.getEndSerial() != null && !"".equals(myForm.getEndSerial()))){
				if (!chooseEDate.before((Date)tMap.get("issue_date"))
						&& !((Date)tMap.get("issue_date")).before(chooseSDate)) {
					run.update(connection,insTemp("DIRA10_RPT",dMap));
				}
			}
			else
				run.update(connection,insTemp("DIRA10_RPT",dMap));
			lastNoPayAmount = thisNoPayAmount;
			lastDate = (Date)dMap.get("ISSUE_DATE");
		}
	}
}
