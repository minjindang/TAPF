/* DIRA0401.java 報表
 程式目的：DIRA0401
 程式代號：DIRA0401
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.surplusage.action;



import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
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
import tw.gov.nta.surplusage.form.Gara2001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA2001 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA20_RPT ");
		return sqljob;
	}
	
	//查debt_code
	public SQLJob SQLdebtCode(String debitName){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select * from debit_ref ");
		sqljob.appendSQL("where debit_name like '"+debitName+"%'");
		
		return sqljob;
	}

	//查詢資料,
	//op = 1 為公債, op = 2 為?借
	public SQLJob selTmp(Gara2001Form form , int op , String op1)
	{
		String reportDate = DateUtil.date2Str(new Date(),"yyyy/MM/dd" );
		SQLJob job = new SQLJob();
		job.appendSQL("SELECT  A.DEBT_CODE, ");
//		job.appendSQL("datediff(yy,A.ISSUE_DATE , DUE_DATE) AS ISSUE_RANGE,");
		job.appendSQL("dbo.countDay(max(a.issue_date),max(a.due_date),max(a.show_type)) AS ISSUE_RANGE,");
		job.appendSQL("	A.DEBT_NAME , A.ISSUE_DATE , A.DUE_DATE,");
		job.appendSQL("	A.SHOW_TYPE, ");
		if(op == 1)
		{
			job.appendSQL(" (A.ISSUE_AMOUNT/"+ form.getAmountUnit() + " - isnull((select sum(capital_amount) from payment_main where issue_id = A.id),0)/"+ form.getAmountUnit() + ") as REMAIN_AMOUNT, ");
		}else
		{
			job.appendSQL(" (((select sum(issue_amount) from debt_main where id=D.id)/"+ form.getAmountUnit() + ") - sum(a.capital_amount)/"+ form.getAmountUnit() + ") as REMAIN_AMOUNT, ");
		}
		//20090223
		job.appendSQL("	(select debt_rate from debt_rate_det where debt_id=D.id and effective_date <= b.repay_date-1 and suspend_date >= b.repay_date-1 and delete_mark='N') as AVERAGE_RATE, ");
//		job.appendSQL("	(select debt_rate from debt_rate_det where debt_id=D.id and effective_date < '"+reportDate+"' and suspend_date > '"+reportDate+"' and delete_mark='N') as AVERAGE_RATE, ");
//		job.appendSQL("	(select effective_date from debt_rate_det where debt_id=D.id and effective_date < '"+reportDate+"' and suspend_date > '"+reportDate+"' and delete_mark='N') as effective_date,");
//		job.appendSQL("	(select suspend_date from debt_rate_det where debt_id=D.id and effective_date < '"+reportDate+"' and suspend_date > '"+reportDate+"' and delete_mark='N') as suspend_date,");
		job.appendSQL("	ISNULL(B.INTEREST_SERIAL,'0') AS INTEREST_SERIAL,  ");
		job.appendSQL(" (ISNULL(B.INTEREST_AMOUNT,0)/"+ form.getAmountUnit() + ") AS INTEREST_AMOUNT");
		job.appendSQL("FROM ISSUE_MAIN A, DEBT_PLAN_DET B ,Debit_ref C , DEBT_MAIN D ");
		job.appendSQL("WHERE ");
		if(op == 1){
			job.appendSQL("	A.Bond_Type=1 ");
			job.appendSQL("	AND A.DEBT_TYPE = 'A' ");
		}else{		
			job.appendSQL("	A.Bond_Type=2 ");
			job.appendSQL("	AND A.DEBT_TYPE = 'C' ");			
		}
		job.appendSQL(" AND D.ISSUE_ID = A.ID AND B.DEBT_ID = D.ID ");		
		if ( form.getIssueYear() != null && !"".equals(form.getIssueYear())){
			job.appendSQL("	AND year(B.REPAY_DATE)-1911 = " + form.getIssueYear() + " ");
		}
		
		job.appendSQL("	AND D.BUDGET_CODE = '2' ");
		
		if(!op1.equals(""))
		{
			job.appendSQL("	AND C.ID in ("+op1+") ");
		}		
		
		if(!op1.equals(""))
		{
			job.appendSQL("	AND D.Debt_code in ("+op1+") ");
		}	
		
		job.appendSQL(" AND ISNULL(B.INTEREST_SERIAL,'0') > 0 ");
		
		job.appendSQL(" group by A.id, A.DEBT_CODE, A.ISSUE_DATE, A.DUE_DATE, A.DEBT_NAME, A.SHOW_TYPE, ");
		job.appendSQL(" A.AVERAGE_RATE, A.CAPITAL_AMOUNT,D.id, ");
		//20090223增加b.repay_date
		job.appendSQL(" B.INTEREST_SERIAL,B.INTEREST_AMOUNT,A.ISSUE_AMOUNT,b.repay_date");

		job.appendSQL(" ORDER BY A.ISSUE_DATE, A.DEBT_CODE , ISNULL(B.INTEREST_SERIAL,'0') , A.DEBT_NAME asc ");
		
		System.out.println("selTmp==>"+job.toString());

		return job;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, 
			Connection connection) throws Exception 
	{
			
		Gara2001Form myForm = (Gara2001Form) form;
		
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		
		//BigDecimal unit = (BigDecimal) myForm.getAmountUnit();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
	
		BigDecimal sum1 = new BigDecimal(0);
		BigDecimal sum2 = new BigDecimal(0);
		BigDecimal sum3 = new BigDecimal(0);
		BigDecimal sum4 = new BigDecimal(0);
		BigDecimal sum5 = new BigDecimal(0);
		BigDecimal sum6 = new BigDecimal(0);
		BigDecimal sum7 = new BigDecimal(0);
		BigDecimal sum8 = new BigDecimal(0);
		BigDecimal sum9 = new BigDecimal(0);
			
		
		Map tMap = new HashMap();
		List<Map> dataList = new ArrayList<Map>();
		Integer index = 0;
//sum1=========================================================================//
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","交通建設基金-公債");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		
		//tCommonMap.
		List queryList1 = (List) run.query(selTmp(myForm,1,"5"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-公債");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum1 = sum1.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum1.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","交通建設基金(公債)小計");
			tMap.put("Interest_amount",sum1);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}
		
//sum2=========================================================================//
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","基隆河整治特別預算-公債");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		
		//tCommonMap.
		queryList1 = (List) run.query(selTmp(myForm,1,"23"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-公債");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum2 = sum2.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum2.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","基隆河整治特別預算(公債)小計");
			tMap.put("Interest_amount",sum2);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}
		
//sum3=========================================================================//
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","北二高特別預算-公債");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		
		//tCommonMap.
		queryList1 = (List) run.query(selTmp(myForm,1,"26"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-公債");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum3 = sum3.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum3.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","北二高特別預算(公債)小計");
			tMap.put("Interest_amount",sum3);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}

//sum4=========================================================================//
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","重大交通建設特別預算-公債");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		
		//tCommonMap.
		queryList1 = (List) run.query(selTmp(myForm,1,"27"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-公債");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum4 = sum4.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum4.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","重大交通建設特別預算(公債)小計");
			tMap.put("Interest_amount",sum4);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}
		
//sum5=========================================================================//	
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","九二一震災特別預算-公債");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		
		queryList1 = (List) run.query(selTmp(myForm,1,"28"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-公債");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum5 = sum5.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum5.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","九二一震災特別預算(公債)小計");
			tMap.put("Interest_amount",sum5);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}	
//sum6=========================================================================//	
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","SARS特別預算-公債");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		
		queryList1 = (List) run.query(selTmp(myForm,1,"29"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-公債");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum6 = sum6.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum6.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","SARS特別預算(公債)小計");
			tMap.put("Interest_amount",sum6);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}	
		
//sum7=========================================================================//	
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","擴大公共投資建設計劃特別預算-公債");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		
		queryList1 = (List) run.query(selTmp(myForm,1,"30, 50, 51"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-公債");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum7 = sum7.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum7.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","擴大公共投資建設計劃特別預算(公債)小計");
			tMap.put("Interest_amount",sum7);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}	
				
//sum8=========================================================================//	
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","高速公路債票-公債");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		
		queryList1 = (List) run.query(selTmp(myForm,1,"33"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-公債");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum8 = sum8.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum8.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","高速公路債票(公債)小計");
			tMap.put("Interest_amount",sum8);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}	
//=========================================================================//	
		
		
	
		sum9=sum1.add(sum2);
		sum9=sum9.add(sum3);
		sum9=sum9.add(sum4);
		sum9=sum9.add(sum5);
		sum9=sum9.add(sum6);
		sum9=sum9.add(sum7);
		sum9=sum9.add(sum8);
		
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Interest_serial","公債部分小計");
		tMap.put("Interest_amount",sum9);
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		
		
//******************************************************************************************************//		
//******************************************************************************************************//
//******************************************************************************************************//		
//******************************************************************************************************//	
		

		BigDecimal sum11 = new BigDecimal(0);
		BigDecimal sum12 = new BigDecimal(0);
		BigDecimal sum13 = new BigDecimal(0);
		BigDecimal sum14 = new BigDecimal(0);
		BigDecimal sum15 = new BigDecimal(0);
		BigDecimal sum16 = new BigDecimal(0);
		BigDecimal sum17 = new BigDecimal(0);
		BigDecimal sum18 = new BigDecimal(0);
		BigDecimal sum19 = new BigDecimal(0);
		
////sum11=========================================================================//
//		tMap.clear();
//		tMap.putAll(getCommonMap(usrId));
//		tMap.put("Issue_name","交通建設基金-賒借");
//		this.addListData(dataList,index++,tMap);
////		run.update(connection,insTemp("GARA20_RPT",tMap));
//		tMap.clear();
//		queryList1 = (List) run.query(selTmp(myForm,2,"5"), new MapListHandler());
//		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
//			tMap = (Map) tIterator.next();
//			tMap.putAll(getCommonMap(usrId));
//			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-賒借");
//			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
//			if(InterestAmount !=null && InterestAmount.floatValue()>0){
//				sum11 = sum11.add(InterestAmount);
//				this.addListData(dataList,index++,tMap);
////				run.update(connection,insTemp("GARA20_RPT",tMap));
//			}
//		}
//		
//		tMap.clear();
//		if (sum11.floatValue()>0){
//			tMap.putAll(getCommonMap(usrId));
//			tMap.put("Interest_serial","交通建設基金(賒借)小計");
//			tMap.put("Interest_amount",sum11);
//			this.addListData(dataList,index++,tMap);
//			//run.update(connection,insTemp("GARA20_RPT",tMap));
//		}else{
//			dataList.remove(--index);
//		}		
//		sum11=========================================================================//
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","水患治理特別預算-賒借");
		this.addListData(dataList,index++,tMap);
		tMap.clear();
		queryList1 = (List) run.query(selTmp(myForm,2,"53,54"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-賒借");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum11 = sum11.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
			}
		}
		
		tMap.clear();
		if (sum11.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","水患治理特別預算-賒借");
			tMap.put("Interest_amount",sum11);
			this.addListData(dataList,index++,tMap);
		}else{
			dataList.remove(--index);
		}	
//sum12=========================================================================//
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","基隆河整治特別預算-賒借");
		this.addListData(dataList,index++,tMap);
		tMap.clear();
		queryList1 = (List) run.query(selTmp(myForm,2,"23"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-賒借");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum12 = sum12.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
			}
		}
		
		tMap.clear();
		if (sum12.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","基隆河整治特別預算(賒借)小計");
			tMap.put("Interest_amount",sum12);
			this.addListData(dataList,index++,tMap);
		}else{
			dataList.remove(--index);
		}		
		
//sum13=========================================================================//
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","北二高特別預算-賒借");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		queryList1 = (List) run.query(selTmp(myForm,2,"26"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-賒借");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum13 = sum13.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum13.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","北二高特別預算(賒借)小計");
			tMap.put("Interest_amount",sum13);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}		
		
//sum14=========================================================================//
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","重大交通建設特別預算-賒借");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		queryList1 = (List) run.query(selTmp(myForm,2,"27"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-賒借");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum14 = sum14.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum14.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","重大交通建設特別預算(賒借)小計");
			tMap.put("Interest_amount",sum14);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}	
			
//sum15=========================================================================//
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","九二一震災特別預算-賒借");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		queryList1 = (List) run.query(selTmp(myForm,2,"28"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-賒借");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum15 = sum15.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum15.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","九二一震災特別預算(賒借)小計");
			tMap.put("Interest_amount",sum15);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}	
			
//sum16=========================================================================//	
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","SARS防疫及紓困特別預算-賒借");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		queryList1 = (List) run.query(selTmp(myForm,2,"29"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-賒借");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum16 = sum16.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum16.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","SARS防疫及紓困特別預算(賒借)小計");
			tMap.put("Interest_amount",sum16);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}	
		
//sum17=========================================================================//	
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","擴大公共投資建設計劃特別預算-賒借");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		List queryDebtCode = (List)run.query(SQLdebtCode("擴大公共投資建設計劃特別預算"), new MapListHandler());
		String debtCode = null;
		for (Iterator iteratorDebtCode = queryDebtCode.iterator(); iteratorDebtCode.hasNext();){
			Map MapCode = (Map)iteratorDebtCode.next();
			if (null != debtCode)
				debtCode = debtCode +","+ String.valueOf((Integer)MapCode.get("id"));
			else
				debtCode = String.valueOf((Integer)MapCode.get("id"));
		}
//		queryList1 = (List) run.query(selTmp(myForm,2,"30,49,50,51,52"), new MapListHandler());
		queryList1 = (List) run.query(selTmp(myForm,2,debtCode), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-賒借");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum17 = sum17.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum17.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","擴大公共投資建設計劃特別預算(賒借)小計");
			tMap.put("Interest_amount",sum17);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}	
			
//sum18=========================================================================//
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Issue_name","高速公路債票-賒借");
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		tMap.clear();
		queryList1 = (List) run.query(selTmp(myForm,2,"33"), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-賒借");
			BigDecimal InterestAmount = (BigDecimal)tMap.get("Interest_amount");
			if(InterestAmount !=null && InterestAmount.floatValue()>0){
				sum18 = sum18.add(InterestAmount);
				this.addListData(dataList,index++,tMap);
//				run.update(connection,insTemp("GARA20_RPT",tMap));
			}
		}
		
		tMap.clear();
		if (sum18.floatValue()>0){
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Interest_serial","高速公路債票(賒借)小計");
			tMap.put("Interest_amount",sum18);
			this.addListData(dataList,index++,tMap);
			//run.update(connection,insTemp("GARA20_RPT",tMap));
		}else{
			dataList.remove(--index);
		}	
		
//=========================================================================//
		sum19=sum11.add(sum12);
		sum19=sum19.add(sum13);
		sum19=sum19.add(sum14);
		sum19=sum19.add(sum15);
		sum19=sum19.add(sum16);
		sum19=sum19.add(sum17);
		sum19=sum19.add(sum18);
		
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Interest_serial","賒借部分小計");
		tMap.put("Interest_amount",sum19);
		this.addListData(dataList,index++,tMap);
//		run.update(connection,insTemp("GARA20_RPT",tMap));
		

		for(int i=0;i<index;i++){
			run.update(connection,insTemp("GARA20_RPT",dataList.get(i)));
		}
		/*		
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Interest_serial","總計");
		tMap.put("Interest_amount",sum1.add(sum2));
		run.update(connection,insTemp("GARA20_RPT",tMap));
		
		*/
		
		
	}	
	
	@SuppressWarnings("unchecked")
	private void addListData(List<Map> l,int i,Map m){
		Map aMap = new HashMap();
		aMap.putAll(m);
		l.add(i,aMap);
	}
	
}
