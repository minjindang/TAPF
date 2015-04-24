package tw.gov.nta.account.action;

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

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ECRF0301 extends ExcelReportBaseAction {
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM ECRF03_RPT ");
		sqljob.appendSQL("DELETE FROM ECRF03TITLE_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	/** 取得主要銀行筆數及資料 主SQL **/
	protected SQLJob selTempTitle(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		AccountQueryForm myform = (AccountQueryForm)form;
		sqljob.appendSQL("select distinct bank_id ");
		sqljob.appendSQL("from debt_main ");
		sqljob.appendSQL("where accrue = 'Y' and debt_code <> 35 ");
		if(0 != myform.getIssueId())
		{
			sqljob.appendSQL("and issue_id = ? ");
			sqljob.addParameter(myform.getIssueId());
		}
		sqljob.appendSQL("union all select distinct 0 from debit_ref ");
		System.out.println(sqljob);
		return sqljob;
	}
	
	/** 取得欄位資料 **/
	public SQLJob valueSQL(int issueId,int bankId,String usrId)
	{
		SQLJob sqljob = new SQLJob();	

		sqljob.appendSQL("select max(a.bank_id) as bank_id , ");
		sqljob.appendSQL("isnull(d.repay_date,c.repay_date) as repay_date , ");
		sqljob.appendSQL("sum( case when d.interest_amount is  null  and (d.repay_date is null or d.repay_date =* c.repay_date) then c.interest_amount else  d.interest_amount end) as interest_amount, ");
		sqljob.appendSQL("sum(b.change_interest_amount) as change_interest_amount");
		sqljob.appendSQL("from  debt_main a, interest_adjust_main b, debt_plan_det c,payment_main d");
		sqljob.appendSQL("where a.id = c.debt_id and c.id *= b.plan_id and  c.id *= d.plan_id  and a.issue_id = ? and a.bank_id = ? and c.delete_mark = 'N'");
		sqljob.appendSQL("group by  a.issue_id,a.bank_id, isnull(d.repay_date,c.repay_date)");
		sqljob.appendSQL("order by  isnull(d.repay_date,c.repay_date)");
		sqljob.addParameter(issueId);
		sqljob.addParameter(bankId);
		System.out.print(sqljob.toString());
//		}
//		else
//		{
//			sqljob.appendSQL("select cast(9999 as int) as bank_id ,");
//			sqljob.appendSQL("isnull(d.repay_date,c.repay_date)  as repay_date , "); 
//			sqljob.appendSQL("sum( case when d.interest_amount is  null then c.interest_amount else  d.interest_amount end) as interest_amount, ");
//			sqljob.appendSQL("(select sum(interest_amount)  from payment_main e  where debt_id = a.id  and repay_date <=isnull(d.repay_date,c.repay_date) ) "); 
//			sqljob.appendSQL("+ ");
//			sqljob.appendSQL("(select sum( interest_amount) from debt_plan_det  e  where debt_id = a.id  and repay_date>=isnull(d.repay_date,c.repay_date) ) "); 
//			sqljob.appendSQL("as sum_interest_amount, null , null ");
//			sqljob.appendSQL("from  debt_main a, interest_adjust_main b, debt_plan_det c left outer join  payment_main d on c.id = d.plan_id ");
//			sqljob.appendSQL("where a.id = c.debt_id ");
//			sqljob.appendSQL("	and a.id = b.debt_id ");
//			if(0 != myform.getIssueId())
//			{
//				sqljob.appendSQL("and a.issue_id = ? ");
//				sqljob.addParameter(myform.getIssueId());
//			}
//			sqljob.appendSQL(" group by isnull(d.repay_date,c.repay_date) , a.id, c.repay_date , d.repay_date ");
//		}
		System.out.println(sqljob);
		return sqljob;
	}
	
	public SQLJob sumValueSQL(int issueId,String usrId)
	{
		SQLJob sqljob = new SQLJob();	

		sqljob.appendSQL("select 9999 as bank_id , ");
		sqljob.appendSQL("isnull(d.repay_date,c.repay_date)  as repay_date , ");
		sqljob.appendSQL("( case when d.interest_amount is  null and (d.repay_date is null or d.repay_date =* c.repay_date) then c.interest_amount else  d.interest_amount end) as interest_amount, ");
		sqljob.appendSQL("(b.change_interest_amount) as change_interest_amount");
		sqljob.appendSQL("from  debt_main a, interest_adjust_main b, debt_plan_det c,payment_main d");
		sqljob.appendSQL("where a.id = c.debt_id and c.id *= b.plan_id and  c.id *= d.plan_id  and a.issue_id = ? and a.debt_code <> 35 and c.delete_mark ='N'");
//		sqljob.appendSQL("group by  a.issue_id, isnull(d.repay_date,c.repay_date)");
		sqljob.appendSQL("order by  isnull(d.repay_date,c.repay_date)");
		sqljob.addParameter(issueId);
//		}
//		else
//		{
//			sqljob.appendSQL("select cast(9999 as int) as bank_id ,");
//			sqljob.appendSQL("isnull(d.repay_date,c.repay_date)  as repay_date , "); 
//			sqljob.appendSQL("sum( case when d.interest_amount is  null then c.interest_amount else  d.interest_amount end) as interest_amount, ");
//			sqljob.appendSQL("(select sum(interest_amount)  from payment_main e  where debt_id = a.id  and repay_date <=isnull(d.repay_date,c.repay_date) ) "); 
//			sqljob.appendSQL("+ ");
//			sqljob.appendSQL("(select sum( interest_amount) from debt_plan_det  e  where debt_id = a.id  and repay_date>=isnull(d.repay_date,c.repay_date) ) "); 
//			sqljob.appendSQL("as sum_interest_amount, null , null ");
//			sqljob.appendSQL("from  debt_main a, interest_adjust_main b, debt_plan_det c left outer join  payment_main d on c.id = d.plan_id ");
//			sqljob.appendSQL("where a.id = c.debt_id ");
//			sqljob.appendSQL("	and a.id = b.debt_id ");
//			if(0 != myform.getIssueId())
//			{
//				sqljob.appendSQL("and a.issue_id = ? ");
//				sqljob.addParameter(myform.getIssueId());
//			}
//			sqljob.appendSQL(" group by isnull(d.repay_date,c.repay_date) , a.id, c.repay_date , d.repay_date ");
//		}
		System.out.println(sqljob);
		return sqljob;
	}	
	/** 塞欄位資料 **/
	public SQLJob insertSQL(ActionForm form,String usrId,Map map)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("insert into ECRF03_RPT (bank_id,change_date,interest_amount," +
		 "total_interest,different_interest,rate,capital_amount) ");
		sqljob.appendSQL(" values(?,?,?,?,?,?,?)");
		sqljob.addParameter(null!=(Integer)map.get("bank_id")?(Integer)map.get("bank_id"):new Integer(0));
		sqljob.addParameter(null!=(Date)map.get("repay_date")?(Date)map.get("repay_date"):new Date());
		sqljob.addParameter(null!=(BigDecimal)map.get("interest_amount")?((BigDecimal)map.get("interest_amount")):new BigDecimal(0));
		sqljob.addParameter(null!=(BigDecimal)map.get("sum_interest_amount")?(BigDecimal)map.get("sum_interest_amount"):new BigDecimal(0));
		sqljob.addParameter(null!=(BigDecimal)map.get("change_interest_amount")?((BigDecimal)map.get("change_interest_amount")).setScale(0,BigDecimal.ROUND_HALF_UP):new BigDecimal(0));
		sqljob.addParameter(null!=(BigDecimal)map.get("debt_rate")?(BigDecimal)map.get("debt_rate"):new BigDecimal(0));
		sqljob.addParameter(null!=(BigDecimal)map.get("capital_amount")?(BigDecimal)map.get("capital_amount"):new BigDecimal(0));
		System.out.println(sqljob);
		return sqljob;
	}
	/** 塞表頭資料 **/
	protected SQLJob insTitle(ActionForm form,String usrId,Map map){
		SQLJob sqljob = new SQLJob();
		AccountQueryForm myform = (AccountQueryForm)form;
		sqljob.appendSQL("");
		sqljob.appendSQL("insert into ECRF03TITLE_RPT (bank_id,bank_name,compare_rate,issue_serial,issue_date,year_range,origin_interest_amount) ");
		sqljob.appendSQL("");
		sqljob.appendSQL(" select ");
		if(new Integer(0).equals((Integer)map.get("bank_id")))
		{
			sqljob.appendSQL(" 9999 , '全部' , null , null , null , null , ");
			sqljob.appendSQL(" sum(d.origin_interest_amount) ");	
			sqljob.appendSQL("from debt_main d");
		    sqljob.appendSQL(" where d.issue_id = ? ");
			sqljob.appendSQL(" and d.debt_code <> 35 ");
			sqljob.addParameter(myform.getIssueId());		
		}
		else
		{
			sqljob.appendSQL(" b.id , b.bank_name , ");
			sqljob.appendSQL(" max(d.compare_rate)/100 , max(i.issue_serial) , max(i.issue_date) , dbo.countDay(max(i.issue_date),max(i.due_date),'D'), ");
			sqljob.appendSQL(" isnull(sum(d.origin_interest_amount),0) ");
			sqljob.appendSQL("from bank_ref b,debt_main d ,issue_main i");
		    sqljob.appendSQL(" where b.id = d.bank_id ");
			sqljob.appendSQL("and i.id = d.issue_id ");
			sqljob.appendSQL("and d.debt_code <> 35 ");
			if(0 != myform.getIssueId())
			{
				sqljob.appendSQL("and d.issue_id = ? ");
				sqljob.addParameter(myform.getIssueId());
			}	
			sqljob.appendSQL("and d.bank_id = ? ");
			sqljob.addParameter((Integer)map.get("bank_id"));
		    sqljob.appendSQL(" group by b.id , b.bank_name , d.issue_id ");	    
		}	
		System.out.println(sqljob);
		return sqljob;
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		//取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		AccountQueryForm myform = (AccountQueryForm)form;
		
		//取得銀行列表
		List list = (List)run.query(selTempTitle(form,usrId),new MapListHandler());
		List list2 = null;
		SQLJob sqljob = new SQLJob();
		
		if(null != list && 0 != list.size())
		{
			for(Iterator it=list.iterator();it.hasNext();)
			{
			
				Map<String,Object> map = (Map)it.next();
				Integer bankId = (Integer)map.get("bank_id");
				
				if(bankId != 0) {
					//取得各家銀行金額
					list2 = (List)run.query(valueSQL(myform.getIssueId(),bankId,usrId),new MapListHandler());
				}else {
					//取得總額
//					list2 = (List)run.query(sumValueSQL(myform.getIssueId(),usrId),new MapListHandler());
					list2 = new ArrayList();
					List listTotal = (List)run.query(sumValueSQL(myform.getIssueId(),usrId),new MapListHandler());
					Date repayDate = null;
					int tmp = 0;
					BigDecimal interestAmount = new BigDecimal("0");
					BigDecimal changeInterestAmount = new BigDecimal("0");
					for(Iterator total = listTotal.iterator();total.hasNext();){
						Map totalMap = (Map)total.next();
						if(null == repayDate || !repayDate.equals((Date)totalMap.get("repay_date"))){
							if(null != repayDate){
								Map newMap = new HashMap();
								newMap.put("bank_id",9999);
								newMap.put("repay_date",repayDate);
								newMap.put("interest_amount",interestAmount);
								newMap.put("change_interest_amount",changeInterestAmount);
								list2.add(tmp,newMap);
								tmp++;
							}
							repayDate = (Date)totalMap.get("repay_date");
							interestAmount = null!=totalMap.get("interest_amount")?((BigDecimal)totalMap.get("interest_amount")).setScale(0,BigDecimal.ROUND_HALF_UP):new BigDecimal("0");
//							changeInterestAmount = null!=totalMap.get("change_interest_amount")?((BigDecimal)totalMap.get("change_interest_amount")).setScale(0,BigDecimal.ROUND_HALF_UP):new BigDecimal("0");
							changeInterestAmount = null!=totalMap.get("change_interest_amount")?((BigDecimal)totalMap.get("change_interest_amount")):new BigDecimal("0");
						}else{
							interestAmount = interestAmount.add(null!=totalMap.get("interest_amount")?((BigDecimal)totalMap.get("interest_amount")).setScale(0,BigDecimal.ROUND_HALF_UP):new BigDecimal("0"));
//							changeInterestAmount = changeInterestAmount.add(null!=totalMap.get("change_interest_amount")?((BigDecimal)totalMap.get("change_interest_amount")).setScale(0,BigDecimal.ROUND_HALF_UP):new BigDecimal("0"));
							changeInterestAmount = changeInterestAmount.add(null!=totalMap.get("change_interest_amount")?((BigDecimal)totalMap.get("change_interest_amount")):new BigDecimal("0"));
						}
					}
					Map newMap = new HashMap();
					newMap.put("bank_id",9999);
					newMap.put("repay_date",repayDate);
					newMap.put("interest_amount",interestAmount);
					newMap.put("change_interest_amount",changeInterestAmount);
					list2.add(tmp,newMap);
				}
				//塞入表頭
				sqljob = insTitle(form,usrId,map);
				run.update(connection,sqljob);
				
				int i=0;
	
				for(Iterator it2 = list2.iterator();it2.hasNext();)
				{	
					i=i+1;
					
					Map map2 = (Map)it2.next();
					SQLJob sqljob2 = new SQLJob();
					//取得利率
					sqljob2.appendSQL("select  max( debt_rate) as debt_rate from debt_rate_det,debt_main ");
					sqljob2.appendSQL(" where debt_id = debt_main.id and debt_main.issue_id = ?  and debt_main.debt_code <> 35 and delete_mark = 'N' and ");
					sqljob2.appendSQL("dateadd ( day,-1,?) between effective_date  and suspend_date  ");
					sqljob2.addParameter(myform.getIssueId());
					sqljob2.addParameter(map2.get("repay_date"));
					if(bankId !=0) {
						sqljob2.appendSQL(" and debt_main.bank_id = ?");
						sqljob2.addParameter(bankId);
					}
					
					//取得發行金額跟原始預估利息
					SQLJob sqljob3 = new SQLJob();
					sqljob3.appendSQL("select sum(issue_amount) as issue_amount,sum(origin_interest_amount) as origin_interest_amount from debt_main where debt_main.issue_id = ? and debt_main.debt_code <> 35");
					sqljob3.addParameter(myform.getIssueId());
					if(bankId !=0) {
						sqljob3.appendSQL(" and debt_main.bank_id = ?");
						sqljob3.addParameter(bankId);
					}
					System.out.println("發行金額跟原始預估利息："+sqljob3);
					
					Map map3 = (Map)run.query(sqljob3,new MapHandler());
					BigDecimal issueAmount = (BigDecimal)map3.get("issue_amount");
					BigDecimal originInterestAmount = ((BigDecimal)map3.get("origin_interest_amount")).setScale(0,BigDecimal.ROUND_HALF_UP);
					
					//取得剩餘本金
					SQLJob sqljob4 = new SQLJob();
					sqljob4.appendSQL("select ? - isnull(sum(isnull(capital_amount,0)),0) as capital_amount from payment_main  e,debt_main  ");
					sqljob4.appendSQL(" where e.debt_id = debt_main.id and debt_main.issue_id = ?  and e.repay_date <= ? ");
					sqljob4.addParameter(issueAmount);
					sqljob4.addParameter(myform.getIssueId());
					sqljob4.addParameter(map2.get("repay_date"));
					if(bankId !=0) {
						sqljob4.appendSQL(" and debt_main.bank_id = ?");
						sqljob4.addParameter(bankId);
					}
//					取得預估利息差額
					SQLJob sqljob5 = new SQLJob();
					
					if (i==1){
						
						sqljob5.appendSQL(" select ? as sum_interest_amount from interest_adjust_main e,debt_main  ");
//						sqljob5.appendSQL("where debt_id = debt_main.id and debt_main.issue_id = ? and change_date <= ? ");
						sqljob5.appendSQL("where debt_main.id *= debt_id and debt_main.issue_id = ? and change_date < ? ");
						sqljob5.addParameter(originInterestAmount);
						sqljob5.addParameter(myform.getIssueId());
						sqljob5.addParameter(map2.get("repay_date"));
						if(bankId !=0) {
							sqljob5.appendSQL(" and debt_main.bank_id = ?");
							sqljob5.addParameter(bankId);
						}
					}else{
						
//						sqljob5.appendSQL(" select ? + isnull(sum(isnull(change_interest_amount,0)),0) as sum_interest_amount from interest_adjust_main e,debt_main  ");
						sqljob5.appendSQL(" select ? + isnull((isnull(change_interest_amount,0)),0) as sum_interest_amount from interest_adjust_main e,debt_main  ");
//						sqljob5.appendSQL(" select ? + isnull(sum(isnull(change_interest_amount,0)),0) as sum_interest_amount from interest_adjust_main e,debt_main  ");
//						sqljob5.appendSQL("where debt_id = debt_main.id and debt_main.issue_id = ? and change_date <= ? ");
						sqljob5.appendSQL("where debt_main.id *= debt_id and debt_main.issue_id = ? and change_date < ? ");
						sqljob5.addParameter(originInterestAmount);
						sqljob5.addParameter(myform.getIssueId());
						sqljob5.addParameter(map2.get("repay_date"));
						if(bankId !=0) {
							sqljob5.appendSQL(" and debt_main.bank_id = ?");
							sqljob5.addParameter(bankId);
						}
					}
					

					
					System.out.println("預估利息總額 ： "+sqljob5);
					
					//取得付息金額
					SQLJob sqljob7 = new SQLJob();
//					sqljob7.appendSQL("select sum(d.interest_amount) as interest_amount ");
					sqljob7.appendSQL("select d.interest_amount ");
					sqljob7.appendSQL("from  debt_main a, payment_main  d");
					sqljob7.appendSQL("where a.id = d.debt_id  and a.issue_id = ? and a.debt_code <> 35 and d.repay_date =? ");
					sqljob7.addParameter(myform.getIssueId());
					sqljob7.addParameter(map2.get("repay_date"));
					if(bankId !=0) {
						sqljob7.appendSQL(" and a.bank_id = ?");
						sqljob7.addParameter(bankId);
					}				
					
					System.out.println("預估利息金額 ： "+sqljob7);
					
//					Map map7 = (Map)run.query(sqljob7,new MapHandler());
					BigDecimal paymentInterestAmount = null;
					List job7List = (List)run.query(sqljob7,new MapListHandler());
					if(null != job7List && !job7List.isEmpty()){
						paymentInterestAmount = new BigDecimal("0");
						for(Iterator job7 = job7List.iterator();job7.hasNext();){
							Map jobMap7 = (Map)job7.next();
							paymentInterestAmount = paymentInterestAmount.add(((BigDecimal)jobMap7.get("interest_amount")).setScale(0,BigDecimal.ROUND_HALF_UP));
						}
					}
//					BigDecimal paymentInterestAmount = (BigDecimal)map7.get("interest_amount");
					
					BigDecimal interestAmount = new BigDecimal(0);
					
					//如果還沒有付息金額(未付)就取得預估付息金額
					if(paymentInterestAmount == null) {
						
						SQLJob sqljob6 = new SQLJob();
//						sqljob6.appendSQL("select  sum(c.interest_amount) as interest_amount ");
						sqljob6.appendSQL("select c.interest_amount ");
						sqljob6.appendSQL("from  debt_main a, debt_plan_det c");
						sqljob6.appendSQL("where a.id = c.debt_id  and a.issue_id = ? and a.debt_code <> 35 and c.repay_date =? and delete_mark = 'N'");
						sqljob6.addParameter(myform.getIssueId());
						sqljob6.addParameter(map2.get("repay_date"));
						if(bankId !=0) {
							sqljob6.appendSQL(" and a.bank_id = ?");
							sqljob6.addParameter(bankId);
						}		
//						Map map6 = (Map)run.query(sqljob6,new MapHandler());
						List job6List = (List)run.query(sqljob6,new MapListHandler());
						for(Iterator job6 = job6List.iterator();job6.hasNext();){
							Map jobMap6 = (Map)job6.next();
							interestAmount = interestAmount.add(((BigDecimal)jobMap6.get("interest_amount")).setScale(0,BigDecimal.ROUND_HALF_UP));
						}
						
//						interestAmount = (BigDecimal)map6.get("interest_amount");
					}else{
						interestAmount = paymentInterestAmount;
					}
					
					Map remainCapitalMap = (Map)run.query(sqljob4,new MapHandler());
					BigDecimal remainCapitalAmount = (BigDecimal)remainCapitalMap.get("capital_amount");
					
					if((remainCapitalAmount!=null && remainCapitalAmount.intValue()!=0)||paymentInterestAmount!=null){
						map2.put("interest_amount",interestAmount);
					}else{
						map2.put("interest_amount",new BigDecimal(0));
					}
					map2.putAll((Map)run.query(sqljob2,new MapHandler()));
					map2.putAll(remainCapitalMap);
//					map2.putAll((Map)run.query(sqljob5,new MapHandler()));
					List job5List = (List)run.query(sqljob5,new MapListHandler());
					BigDecimal sumInterestAmount = new BigDecimal("0");
					int tmp = 0;
					for(Iterator job5 = job5List.iterator();job5.hasNext();){
						Map jobMap5 = (Map)job5.next();
						sumInterestAmount = sumInterestAmount.add(((BigDecimal)jobMap5.get("sum_interest_amount")).setScale(0,BigDecimal.ROUND_HALF_UP));
						if(tmp != 0)
							sumInterestAmount = sumInterestAmount.subtract(originInterestAmount);
						tmp++;
					}
					map2.put("sum_interest_amount",sumInterestAmount);
					if(interestAmount == null || interestAmount.longValue() ==0) {
						map2.put("sum_interest_amount",new BigDecimal(0));
					}
					run.update(connection,insertSQL(form,usrId,map2));
				}	
				
			}	
		}	
	}
	
	/** 取得第一筆的預估利息總額 **/
	public BigDecimal getOriginInterestAmount(SQLRunner run , int bankId , int issueId) throws Exception
	{
	
		SQLJob sqljob = new SQLJob();
		Map result = null;
		BigDecimal tempDecimal = new BigDecimal(0);
		sqljob.appendSQL("select sum(isnull(origin_interest_amount,0)) as sumInterestAmount from debt_main ");
		sqljob.appendSQL("where  issue_id = ? ");
		sqljob.addParameter(issueId);
		if(bankId ==0) {
			sqljob.appendSQL(" and bank_id = ? ");
			sqljob.addParameter(bankId);
		}
		
		result = (Map)run.query(sqljob,new MapHandler());
		tempDecimal = (BigDecimal)result.get("sumInterestAmount");
		if (tempDecimal == null) {
			tempDecimal = new BigDecimal(0);
		}
		
		return tempDecimal; 
	}
}
