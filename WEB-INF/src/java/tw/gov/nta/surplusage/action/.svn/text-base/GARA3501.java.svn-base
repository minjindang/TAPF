package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA3501 extends DefaultAction 
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{
		// TODO Auto-generated method stub
		AccountQueryForm myForm = (AccountQueryForm) form;
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob job = new SQLJob();
		
		//1.刪除 temp table
		job = delTmp1(usrId,"GARA35_RPT");
		run.update(job);
		
		//2.產生temp table資料
		job = selTmp(myForm);
		List list = (List)run.query(job,new MapListHandler());
		
		//3.新增至temp table GARA35_RPT
		for(int i=0 ; i < list.size() ; i++)
		{
			Map map = (Map)list.get(i);			
			job = insTmp(usrId,map);
			run.update(job);
		}
		Map tempMapA = (Map)((List) run.query(this.getGDPamount(myForm.getAccountYear()), new MapListHandler())).get(0);
		request.setAttribute("amount",(BigDecimal)tempMapA.get("amount"));
		
	}
	
	//新增至temp table GARA35_RPT
	public SQLJob insTmp(String usrId, Map map)
	{
		SQLJob job = new SQLJob();
		//異動人員,異動時間
		//總預算, 新十大建設, 重大交建, 採購高性能戰機, 九二一 , SARS, 
		//特別預算小計, 基隆河整治, 省債, 糧食平準基金, 其它債務小計,債務基金, 乙類公債及借款, 項目
		job.appendSQL("INSERT INTO GARA35_RPT (USRID, MOD_DATE," +
				"T1 , T2, T3, T4, T5, T6, T7, T8, " +
				"SUM1, T9, T10, T11, T12, SUM2, T13 ,SUM3 ) VALUES (" +
				"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) ");
		job.addParameter(usrId);//異動人員,異動時間
		job.addParameter(new Date());//異動時間
		job.addParameter((String)map.get("T1"));//項目,
		job.addParameter((BigDecimal)map.get("T2"));//總預算, 
		job.addParameter((BigDecimal)map.get("T3"));//新十大建設, 
		job.addParameter((BigDecimal)map.get("T4"));//重大交建, 
		job.addParameter((BigDecimal)map.get("T5"));//採購高性能戰機, 
		job.addParameter((BigDecimal)map.get("T6"));//九二一 , 
		job.addParameter((BigDecimal)map.get("T7"));//SARS, 
		job.addParameter((BigDecimal)map.get("T8"));//基隆河整治,
		job.addParameter(new BigDecimal(0));//特別預算小計, 
		job.addParameter((BigDecimal)map.get("T9"));//省債, 
		job.addParameter((BigDecimal)map.get("T10"));//糧食平準基金,
		job.addParameter((BigDecimal)map.get("T11"));//新生地基金,
		job.addParameter((BigDecimal)map.get("T12"));//債務基金, 
		job.addParameter(new BigDecimal(0));//其它債務小計,
		job.addParameter((BigDecimal)map.get("T13"));//乙類公債及借款
		job.addParameter(new BigDecimal(0));//其它債務小計,
		System.out.println(job.toString());
		return job;
	}
	
	public SQLJob getGDPamount(String year){
		SQLJob job = new SQLJob();
		job.appendSQL("select isNull(GDP_Amount,0)/100000000 as amount");
		job.appendSQL("from nation_debit_main");
		job.appendSQL("where nation_code=24");
		job.appendSQL("and account_year='"+year+"'");
		System.out.println(job.toString());
		return job;
	}
	/*
	 * 產生temp table 資料
	 */
	public SQLJob selTmp(AccountQueryForm form)
	{
		String accountYM = form.getAccountYear()+form.getMonth();
		Date queryLastDate = DateUtil.getLastDateOfMonth(DateUtil.str2Date(accountYM + "01"));
		String strLastDate = DateUtil.date2Str(queryLastDate);
		SQLJob job = new SQLJob();
		job.appendSQL("select   '公債' T1 ,");
		//job.appendSQL("sum(case when ( a.budget_code=1 and bond_type ='1' )  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=1) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T2,");
		//job.appendSQL("sum(case when ( a.budget_code=1 and bond_type ='1' ) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T2,");
        //公債新十大建設
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=30)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code in (30,49,50,51,52)) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T3,");
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=30) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T3,");
        //公債重大交建
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=27)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code=27) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T4,");
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=27) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T4,");
        //公債採購高性能戰機
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=42)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code=42) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T5,");
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=42) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T5,");
        //公債九二一
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=28)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code=28) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T6,");
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=28) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T6,");
        //公債sars
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=29)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code=29) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T7,");
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=29) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T7,");
        //公債基隆河整治
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=23)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=2) and (A.debt_code=23) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T8,");
		//job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=23) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T8,");
        //公債省債
		//job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=35)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=5) and (A.debt_code=36) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T9,");
		//job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=35) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T9,");
        //公債糧食平準基金
		//job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=36)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=5) and (A.debt_code=36) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T10,");
		//job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=36) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T10,");
        //公債新生地開發
		//job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=0)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=5) and (A.debt_code=0) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T11,");
		//job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=0) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T11,");
        //公債債務基金
		//job.appendSQL("sum(case when ( a.budget_code='3' and bond_type ='1' )  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 1) AND (A.issue_id=B.id) and (A.budget_code=3)  and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T12,");
		//job.appendSQL("sum(case when ( a.budget_code='3' and bond_type ='1' )  then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T12,");
        //公債乙類
		//job.appendSQL("sum(case when (  bond_type ='2' and c.budget_code<>'3')  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("isnull((select SUM(CAPITAL_AMOUNT)  from  debt_plan_det where (debt_ID IN  (select A.id from debt_main A, issue_main B  where  (B.DEBT_TYPE = 'A') AND (B.BOND_TYPE = 2) AND (A.issue_id=B.id) and (A.budget_code=2) and (B.issue_date<='"+strLastDate+"') )) AND (REPAY_DATE >= '"+strLastDate+"') AND (delete_mark = 'N')),0)/100000000 as T13 ");
		//job.appendSQL("sum(case when (  bond_type ='2' and c.budget_code<>'3')  then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T13 ");
        /*
		job.appendSQL("from issue_main c,debt_main a ");
		job.appendSQL("where c.id = a.issue_id ");
		job.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,c.ISSUE_DATE, 112)-19110000)),7),1,5)<='"+accountYM+"' ");             
		job.appendSQL("and debt_type='A' ");
		*/
		job.appendSQL("union ");
		//借款修改 0950829修改
		job.appendSQL("SELECT ");
		job.appendSQL("(select '國內借款' ) as T1 ,");
		job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 1 ),0) - ");
		job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 1),0))/100000000 as  T2,");
		//國內借款新十大建設
		job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code in (30,49,50,51,52) ),0) - ");
		job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=30 ),0))/100000000 as  T3,");
		//國內借款重大交建
		job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=27 ),0) - ");
		job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=27 ),0))/100000000 as  T4,");

		//國內借款採購高性能戰機
		//修改 20061205 by jack
		if(Integer.parseInt(strLastDate.substring(0,6))<Integer.parseInt("200610")){
//			job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.debt_code=42 ),0) - ");
//			job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.debt_code=42 ),0))/100000000 as  T5,");
			job.appendSQL("(isNull((select top 1 remain_amount from gara35_his where YM ='"+accountYM+"' and debt_code=42),0))/100000000 as T5,");
		}else{
			//修改 20061205 by jack
			job.appendSQL("(isNull((select sum( capital_amount - pay_amount ) from other_plan_debt where debt_code=42 and repay_date>='"+strLastDate+"'),0))/100000000 as T5,");
			//job.appendSQL("(isNull((select sum( capital_amount ) from other_plan_debt where debt_code=42 and repay_date>='"+strLastDate+"'),0))/100000000 as T5,");
			//job.appendSQL("(isNull((select sum(capital_amount) from other_plan_debt where debt_code=42 and repay_date <= '"+strLastDate+"'),0))/100000000 as T5,");
		}
		
		//國內借款九二一
		job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=28 ),0) - ");
		job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=28 ),0))/100000000 as  T6,");
		//國內借款sars
		job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=29 ),0) - ");
		job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=29 ),0))/100000000 as  T7,");
		//國內借款基隆河整治
		job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=23 ),0) - ");
		job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=23 ),0))/100000000 as  T8,");

		//國內借款省債
		//修改 20061205 by jeck
//		if(Integer.parseInt(strLastDate.substring(0,4))<2006)
		if(Integer.parseInt(strLastDate.substring(0,6))<Integer.parseInt("200610"))
		{
//			job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.debt_code=35 ),0) - ");
//			job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.debt_code=35 ),0))/100000000 as  T9,");
			job.appendSQL("(isNull((select top 1 remain_amount from gara35_his where YM ='"+accountYM+"' and debt_code=35),0))/100000000 as T9,");
		}
		else
		{
			//修改 20061205 by jeck
			job.appendSQL("(isNull((select sum( capital_amount - pay_amount ) from other_plan_debt where debt_code=35 and repay_date>='"+strLastDate+"'),0))/100000000 as T9,");
			//job.appendSQL("(isNull((select sum( capital_amount ) from other_plan_debt where debt_code=35 and repay_date>='"+strLastDate+"'),0))/100000000 as T9,");
			//job.appendSQL("(isNull((select sum(capital_amount) from other_plan_debt where debt_code=35 and repay_date <= '"+strLastDate+"'),0))/100000000 as T9,");
		}

		//國內借款糧食平準基金
		if(Integer.parseInt(strLastDate.substring(0,4))<2006){
			job.appendSQL("(isNull((select top 1 remain_amount from gara35_his where YM ='"+accountYM+"' and debt_code=36),0))/100000000 as T10,");
		}else{
			job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=36 ),0) - ");
			job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=36 ),0))/100000000 as  T10,");
		}
		
		//國內借款新生地開發
		if(Integer.parseInt(strLastDate.substring(0,4))<2006){
			job.appendSQL("(isNull((select remain_amount from gara35_his where YM ='"+accountYM+"' and debt_code=48),0))/100000000 as T11,");
		}else{
			job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 2 and A.debt_code=0 ),0) - ");
			job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 2 and B.debt_code=0 ),0))/100000000 as  T11,");
		}
		
		//國內借款債務基金
		job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 2 and A.budget_code = 3 ),0) - ");
		job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 2 and B.budget_code = 3 ),0))/100000000 as  T12,");
		//國內借款乙類
		job.appendSQL("(isNull((select sum(A.ISSUE_AMOUNT) from  debt_main A ,issue_main B where A.issue_id = B.id  and A.issue_amount > 0 and B.issue_date <= '"+strLastDate+"' and B.debt_type = 'C' and B.bond_type = 1 and A.budget_code = 2),0) - ");
		job.appendSQL("isNull((select sum(A.CAPITAL_AMOUNT) from  payment_main A,debt_main B, issue_main C where A.debt_id  = B.id and B.issue_id = C.id  and A.capital_amount >0 and A.repay_date <= '"+strLastDate+"' and C.debt_type = 'C' and C.bond_type = 1 and B.budget_code = 2),0))/100000000 as  T13 ");
		/* old 國內借款sql
		job.appendSQL("select   '國內借款' T1 ,");           
		job.appendSQL("sum(case when ( a.budget_code='1' and bond_type ='1' )  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( a.budget_code='1' and bond_type ='1' ) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T2,");
        //國內借款新十大建設
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=30)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=30) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T3,");
        //國內借款重大交建
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=27)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=27) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T4,");
        //國內借款採購高性能戰機
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=42)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=42) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T5,");
        //國內借款九二一
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=28)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=28) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T6,");
        //國內借款sars
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=29)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=29) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T7,");
        //國內借款基隆河整治
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=23)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( a.budget_code='2' and bond_type ='1' and a.debt_code=23) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T8,");
        //國內借款省債
		job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=35)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=35) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T9,");
        //國內借款糧食平準基金
		job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=36)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=36) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T10,");
        //國內借款新生地開發
		job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=0)  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( a.budget_code='5' and bond_type ='1' and a.debt_code=0) then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T11,");
        //國內借款債務基金
		job.appendSQL("sum(case when ( a.budget_code='3' and bond_type ='1' )  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( a.budget_code='3' and bond_type ='1' )  then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T12,");
        //國內借款乙類
		job.appendSQL("sum(case when ( bond_type ='2' and c.budget_code<>'3' )  then  isnull(a.issue_amount,0) else 0 end)/100000000-");
		job.appendSQL("sum(case when ( bond_type ='2' and c.budget_code<>'3' )  then isnull(dbo.sp_get_debtamt(a.id,'"+accountYM+"'),0) else 0 end)/100000000 as T13 ");
        
		job.appendSQL("from issue_main c,debt_main a ");
		job.appendSQL("where c.id = a.issue_id ");
		job.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,c.issue_date, 112)-19110000)),7),1,5)<='"+accountYM+"' ");             
		job.appendSQL("and debt_type in ('C','E') ");
		*/
        job.appendSQL("union ");
        job.appendSQL("select  '國外借款(美元)' T1 ,0.0 as T2,0.0 as T3,0.0 as T4,0.0 as T5,0.0 as T6,0.0 as T7,0.0 as T8,0.0 as T9,0.0 as T10,0.0 as T11,0.0 as T12,0.0 as T13 ");
		System.out.println("GARA3501-selTmpSQL:"+job.toString());
		return job;
	}
	
	
	/*
	 * 刪除temp table 的舊資料
	 */
	public SQLJob delTmp1(String usrId,String tableName)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("DELETE FROM " + tableName + " ");
		//job.appendSQL("WHERE USRID = ? ");
		//job.addParameter(usrId);
		return job;
	}

}
