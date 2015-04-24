/**
*
* @author Andrew Sung
* @createDate 2006/6/3
*/
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airb0101Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRB0101 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRB01_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	 

	@SuppressWarnings("static-access")
	//表頭資訊部分
	protected SQLJob selMain(ActionForm form){
		Airb0101Form myForm = (Airb0101Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("Select A.id,A.debt_name, A.issue_date, A.due_date, isNull((select sum(C.issue_amount) from debt_main C where C.issue_id=A.id ");
		if (!"".equals(myForm.getBudgetCode())){
			sqljob.appendSQL("and C.budget_code = ? ");
			sqljob.addParameter(myForm.getBudgetCode());
		}
		if (!"".equals(myForm.getDebtCode())){
			sqljob.appendSQL("and C.debt_code = ? ");
			sqljob.addParameter(myForm.getDebtCode());
		}
		sqljob.appendSQL("),0) as issue_amount,");
		sqljob.appendSQL("(select isnull(sum(isnull(ticket_count,cast(0 as int))),cast(0 as int)) from issue_ticket_det where issue_id = A.id ) as ticket_count, isNull(A.average_rate,0) as average_rate,");
		sqljob.appendSQL("A.bond_kind, A.bond_sell_status, A.pay_limit,A.SOURCE_ISSUE_ID, ");
		//20110824徐先生要求要增額發行，要顯示原發行日
		sqljob.appendSQL("(select issue_date from issue_main where id = a.source_issue_id) as origin_issue_date");
		sqljob.appendSQL("from issue_main A ");
		sqljob.appendSQL("where A.debt_type='A' ");
		sqljob.appendSQL("and A.issue_date = ? ");
		sqljob.addParameter(myForm.getIssueDate());
		System.out.println("head :" + sqljob);
		return sqljob;
	}
	//清單資料
	protected SQLJob selList(ActionForm form,String issueId){
		Airb0101Form myForm = (Airb0101Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT A.repay_date,"); 
		sqljob.appendSQL("(case when max(a.capital_serial) = 0 then sum(case when B.bond_kind = '1' then C.issue_amount else 0 end ) else 0 end ) as issue_amount1,");// 原始
		sqljob.appendSQL("(case when max(a.capital_serial) = 0 then sum(case when B.bond_kind = '3' then C.issue_amount else 0 end ) else 0 end ) as issue_amount2,");//增額
		sqljob.appendSQL("(case when max(a.capital_serial) = 0 then sum(case when B.bond_kind in ( '1','3') then C.issue_amount else 0 end ) else 0 end ) as issue_amount3,");// 小計,
		sqljob.appendSQL("sum(case when B.bond_kind = '1' then A.capital_amount  else 0 end ) as capital_amount1,");// 原始
		sqljob.appendSQL("sum(case when B.bond_kind = '3' then A.capital_amount else 0 end ) as capital_amount2,");//增額
		sqljob.appendSQL("sum(case when B.bond_kind in ( '1','3') then A.capital_amount else 0 end ) as capital_amount3,");// 小計,
		sqljob.appendSQL("sum(case when B.bond_kind = '1' then A.interest_amount else 0 end ) as interest_amount1,");// 原始
		sqljob.appendSQL("sum(case when B.bond_kind = '3' then A.origin_interest_amount  else 0 end ) as interest_amount2,");//增額
		sqljob.appendSQL("sum(case when B.bond_kind in ( '1','3') then A.origin_interest_amount  else 0 end ) as interest_amount3,");// 小計,
		sqljob.appendSQL("max(capital_serial) as capital_serial, max(interest_serial) as interest_serial ");
		sqljob.appendSQL("FROM debt_plan_det A, issue_main B, debt_main C ");
		sqljob.appendSQL("WHERE A.debt_id=C.id ");
		sqljob.appendSQL("and C.issue_id=B.id ");
		sqljob.appendSQL("and ((B.id = ? ) ");
		sqljob.appendSQL("or (B.source_issue_id = ? )) ");
		sqljob.appendSQL("and delete_mark='N' ");
		sqljob.addParameter(issueId);
		sqljob.addParameter(issueId);
		if (!"".equals(myForm.getBudgetCode())){
			sqljob.appendSQL("and C.budget_code = ? ");
			sqljob.addParameter(myForm.getBudgetCode());
		}
		if (!"".equals(myForm.getDebtCode())){
			sqljob.appendSQL("and C.debt_code = ? ");
			sqljob.addParameter(myForm.getDebtCode());
		}
		sqljob.appendSQL("group by A.repay_date ");
		sqljob.appendSQL("order by A.repay_date,interest_serial");
		
		System.out.println(sqljob.toString());
		return sqljob;
	}
	//頁尾資料
	protected SQLJob selBack(ActionForm form,String issueId){
		Airb0101Form myForm = (Airb0101Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select A.bond_kind , B.budget_code, B.debt_code, A.issue_date, isNull(B.issue_amount,0) as issue_amount,");
		sqljob.appendSQL("(case when A.bond_kind = '4' then '可分割公債' when A.bond_sell_status='Y' then '可分割公債' else  '' end) as kind ");
		sqljob.appendSQL("from issue_main A, debt_main B ");
		sqljob.appendSQL("where A.source_issue_id = (select c.source_issue_id from issue_main c where c.id=?) ");
//		sqljob.appendSQL("where A.source_issue_id=? ");
		sqljob.appendSQL("and B.issue_id=A.id ");
		sqljob.addParameter(issueId);
		if (!"".equals(myForm.getBudgetCode())){
			sqljob.appendSQL("and B.budget_code = ? ");
			sqljob.addParameter(myForm.getBudgetCode());
		}
		if (!"".equals(myForm.getDebtCode())){
			sqljob.appendSQL("and B.debt_code = ? ");
			sqljob.addParameter(myForm.getDebtCode());
		}
		sqljob.appendSQL(" order by A.bond_kind ");
		return sqljob;
	}
	
	protected Date dateYearAdd(Date date,int year,int month,int Day){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR,year);
		c.set(Calendar.MONTH,month-1);
		c.set(Calendar.DATE,Day);
		return c.getTime();
	}
	//提前買回
	protected SQLJob sqlPayment(String issueId, String repayDate){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select i.bond_kind,p.CAPITAL_AMOUNT,p.interest_amount ");
		sqljob.appendSQL("from issue_main i, payment_main p, debt_plan_det d ");
		sqljob.appendSQL("where i.source_issue_id = ? ");
		sqljob.appendSQL("and i.debt_type = 'A' ");
		sqljob.appendSQL("and i.id = p.issue_id ");
		sqljob.appendSQL("and i.id = d.issue_id ");
		sqljob.appendSQL("and p.plan_id = d.id ");
		sqljob.appendSQL("and p.REPAY_DATE <> p.PLAN_REPAY_DATE ");
		sqljob.appendSQL("and p.CAPITAL_AMOUNT > 0 ");
		sqljob.appendSQL("and p.REPAY_DATE < ?");

		sqljob.addParameter(issueId);
		sqljob.addParameter(repayDate);
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
		run.update(connection,delTemp(form,usrId));
		//找出表頭資料
		SQLJob selIssueMain = selMain(form);
		Map mainMap = (Map)run.query(selIssueMain,new MapHandler());
		if (mainMap != null && !mainMap.isEmpty()){
			//將表頭資料放入request中給下一個action使用
			request.setAttribute("mainMap",mainMap);
			String issueId = String.valueOf(mainMap.get("SOURCE_ISSUE_ID"));
			
			//表尾資料
			SQLJob selIssueBack = selBack(form,issueId);
			List backList = (List)run.query(selIssueBack,new MapListHandler());
			if (mainMap != null && !mainMap.isEmpty())
				request.setAttribute("backList",backList);
			//依表頭找到的issue_main.id找出清單資料
			SQLJob selList = selList(form,issueId);
			List qryList = (List)run.query(selList,new MapListHandler());
			Map dMap = new HashMap();
			Map d1Map = new HashMap();
			Map d2Map = new HashMap();
			BigDecimal totalCapitalAmount = new BigDecimal(0);
			BigDecimal totalInterestAmount = new BigDecimal(0);
			for(Iterator it1=qryList.iterator();it1.hasNext();){
				Map mapQry1 = (Map) it1.next();
				
				dMap.putAll(getCommonMap(usrId));
				d1Map.putAll(getCommonMap(usrId));
				d2Map.putAll(getCommonMap(usrId));
				
				dMap.put("account_year",DateUtil.date2ROCStr((Date)mapQry1.get("repay_date"),"yyy/mm/dd").substring(0,3));
				d1Map.put("account_year",DateUtil.date2ROCStr((Date)mapQry1.get("repay_date"),"yyy/mm/dd").substring(0,3));
				d2Map.put("account_year",DateUtil.date2ROCStr((Date)mapQry1.get("repay_date"),"yyy/mm/dd").substring(0,3));
				
//				截止兌付期限
				Date payDate = null;
				if (Integer.parseInt((String)dMap.get("account_year")) > 88)
					payDate = dateYearAdd((Date)mainMap.get("due_date"),Integer.parseInt(String.valueOf(mainMap.get("pay_limit"))),12,31);
				else
					payDate = dateYearAdd((Date)mainMap.get("due_date"),Integer.parseInt(String.valueOf(mainMap.get("pay_limit"))),6,30);
				dMap.put("pay_limit",payDate);
				d1Map.put("pay_limit",payDate);
				d2Map.put("pay_limit",payDate);
				
				Calendar tCalendar = GregorianCalendar.getInstance();
				tCalendar.setTime((Date)mapQry1.get("repay_date"));
				tCalendar.add(Calendar.DATE,-1);
				
				dMap.put("repay_date",tCalendar.getTime());
				d1Map.put("repay_date",tCalendar.getTime());
				d2Map.put("repay_date",tCalendar.getTime());
				
				dMap.put("issue_amount",mapQry1.get("issue_amount1"));
				d1Map.put("issue_amount",mapQry1.get("issue_amount2"));
				d2Map.put("issue_amount",mapQry1.get("issue_amount3"));
				
				dMap.put("capital_serial",mapQry1.get("capital_serial"));
				d1Map.put("capital_serial",mapQry1.get("capital_serial"));
				d2Map.put("capital_serial",mapQry1.get("capital_serial"));

				List listPayment = (List)run.query(sqlPayment(issueId,mapQry1.get("repay_date").toString()),new MapListHandler());
				BigDecimal rCapitalAmount1 = new BigDecimal("0");
				BigDecimal rInterestAmount1 = new BigDecimal("0");
				BigDecimal rCapitalAmount3 = new BigDecimal("0");
				BigDecimal rInterestAmount3 = new BigDecimal("0");
				if(null != listPayment && !listPayment.isEmpty()){
					for(Iterator itPayment = listPayment.iterator();itPayment.hasNext();){
						Map mapPayment = (Map)itPayment.next();
						if("1".equals((String)mapPayment.get("bond_kind"))){
							rCapitalAmount1 = rCapitalAmount1.add((BigDecimal)mapPayment.get("capital_amount"));
							rInterestAmount1 = rInterestAmount1.add((BigDecimal)mapPayment.get("interest_amount"));
						}else{
							rCapitalAmount3 = rCapitalAmount3.add((BigDecimal)mapPayment.get("capital_amount"));
							rInterestAmount3 = rInterestAmount3.add((BigDecimal)mapPayment.get("interest_amount"));
						}
					}					
				}
				BigDecimal capitalAmount1 = (BigDecimal)mapQry1.get("capital_amount1");
				dMap.put("capital_amount",capitalAmount1.subtract(rCapitalAmount1));
				BigDecimal capitalAmount2 = (BigDecimal)mapQry1.get("capital_amount2");
				d1Map.put("capital_amount",capitalAmount2.subtract(rCapitalAmount3));
				BigDecimal capitalAmount3 = (BigDecimal)mapQry1.get("capital_amount3");
				d2Map.put("capital_amount",capitalAmount3.subtract(rCapitalAmount1).subtract(rCapitalAmount3));
				totalCapitalAmount = totalCapitalAmount.add(capitalAmount3.subtract(rCapitalAmount1).subtract(rCapitalAmount3));
				
				dMap.put("interest_serial",mapQry1.get("interest_serial"));
				d1Map.put("interest_serial",mapQry1.get("interest_serial"));
				d2Map.put("interest_serial",mapQry1.get("interest_serial"));

				BigDecimal interestAmount1 = (BigDecimal)mapQry1.get("interest_amount1");
				dMap.put("interest_amount",interestAmount1.subtract(rInterestAmount1));
				BigDecimal interestAmount2 = (BigDecimal)mapQry1.get("interest_amount2");
				d1Map.put("interest_amount",interestAmount2.subtract(rInterestAmount3));
				BigDecimal interestAmount3 = (BigDecimal)mapQry1.get("interest_amount3");
				d2Map.put("interest_amount",interestAmount3.subtract(rInterestAmount1).subtract(rInterestAmount3));
				totalInterestAmount = totalInterestAmount.add(interestAmount3.subtract(rInterestAmount1).subtract(rInterestAmount3));
				
				dMap.put("total_amount",((BigDecimal)mapQry1.get("capital_amount1")).add((BigDecimal)mapQry1.get("interest_amount1")));
				d1Map.put("total_amount",((BigDecimal)mapQry1.get("capital_amount2")).add((BigDecimal)mapQry1.get("interest_amount2")));
				d2Map.put("total_amount",((BigDecimal)mapQry1.get("capital_amount3")).add((BigDecimal)mapQry1.get("interest_amount3")));
				
				dMap.put("bond_kind","原始");
				d1Map.put("bond_kind","增額");
				d2Map.put("bond_kind","小計");
				
				run.update(connection,insTemp("AIRB01_RPT",dMap));
				run.update(connection,insTemp("AIRB01_RPT",d1Map));
				run.update(connection,insTemp("AIRB01_RPT",d2Map));
				
				request.setAttribute("totalCapitalAmount", totalCapitalAmount);
				request.setAttribute("totalInterestAmount", totalInterestAmount);
			}
		}
		
		
	}
}