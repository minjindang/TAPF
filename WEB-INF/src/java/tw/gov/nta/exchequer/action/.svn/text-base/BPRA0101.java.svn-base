/**
 * @author Andrew Sung
 * @create 2006/4/11
 */

package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bpra0101Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;


public class BPRA0101 extends ExcelReportBaseAction
{
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM BPRA01_RPT ");
		
		System.out.println(sqljob.toString());
		return sqljob;
		
	}
	/*
		select B.plan_repay_date, 
		case when B.plan_repay_date > min(B.Repay_date) then  min(B.Repay_date) else null end  repay_date,
		A.debt_name,
		datediff(dd,issue_date,due_date) as date_period,
		sum(distinct a.issue_amount) as issue_amount,
		sum(distinct B.capital_amount) as capital_amount,
		sum(distinct B.interest_amount) as interest_amount,
		A.issue_amount * A.charge_rate as change_amount
		from issue_main A, payment_main B
		where A.id = B.issue_id
		and A.debt_type = 'B'
		--and B.plan_repay_date between '1994-01-01' and '1994-12-31' --應還本日期區間
		group by B.plan_repay_date,A.debt_name,datediff(dd,issue_date,due_date)
		order by B.plan_repay_date
	 */
	protected SQLJob mainTemp(ActionForm form,String usrId){
		Bpra0101Form myForm = (Bpra0101Form)form;
		SQLJob sqljob = new SQLJob();
		//以償還全部本金的期別
		sqljob.appendSQL(" SELECT A.id as ISSUE_ID,'"+usrId+"' as USRID," +
							"B.plan_repay_date as DUE_DATE,");
		sqljob.appendSQL("case when B.plan_repay_date > min(B.Repay_date) then  min(B.Repay_date) else null end  repay_date,");
		sqljob.appendSQL("A.debt_name,");
		sqljob.appendSQL("datediff(dd,issue_date,due_date) as date_period,");
		sqljob.appendSQL("isNull(sum(distinct a.issue_amount),0) as issue_amount,");		
		//計算實收數----------
		sqljob.appendSQL("isNull(B.capital_amount,0) as capital_amount,");		
		sqljob.appendSQL("isNull(sum(distinct B.interest_amount),0) as interest_amount,");		
		//計算經付手續費--------//20090901 chrisWu 手續由0.0004->0.0003
		sqljob.appendSQL("case when B.REPAY_DATE < '2009-09-01' then ");
		sqljob.appendSQL("(sum(distinct B.capital_amount) + sum(distinct B.interest_amount)) * A.charge_rate ");
		sqljob.appendSQL("else (sum(distinct B.capital_amount) + sum(distinct B.interest_amount)) * 0.0003 end as change_amount ");
		sqljob.appendSQL("from issue_main A, payment_main B ");
		sqljob.appendSQL("where A.id = B.issue_id ");
		sqljob.appendSQL("and A.debt_type = 'B' ");
		sqljob.appendSQL("and B.repay_date between ? and ? ");
		sqljob.addParameter(myForm.getRepaySdate());
		sqljob.addParameter(myForm.getRepayEdate());
		sqljob.appendSQL("group by A.id,B.plan_repay_date,A.debt_name,datediff(dd,issue_date,due_date),A.issue_amount,A.charge_rate,B.capital_amount,B.REPAY_DATE ");
	
		//尚未償還本金的期別
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select A.id as ISSUE_ID,'"+usrId+"' as USRID," + 
							"B.repay_date as DUE_DATE,");
		sqljob.appendSQL("null as  repay_date,");
		sqljob.appendSQL("A.debt_name,");
		sqljob.appendSQL("datediff(dd,issue_date,due_date) as date_period, ");
		sqljob.appendSQL("sum(distinct a.issue_amount) as issue_amount, ");
		sqljob.appendSQL("B.capital_amount as capital_amount, ");
		sqljob.appendSQL("sum(distinct B.interest_amount) as interest_amount, ");
		//計算經付手續費--------//20090901 chrisWu 手續由0.0004->0.0003
		sqljob.appendSQL("case when B.REPAY_DATE < '2009-09-01' then ");
		sqljob.appendSQL("(sum(distinct B.capital_amount) + sum(distinct B.interest_amount)) * A.charge_rate ");
		sqljob.appendSQL("else (sum(distinct B.capital_amount) + sum(distinct B.interest_amount)) * 0.0003 end as change_amount ");
		sqljob.appendSQL("from issue_main A, debt_plan_det B ");
		sqljob.appendSQL("where A.id = B.issue_id ");
		sqljob.appendSQL("and A.debt_type = 'B' ");
		sqljob.appendSQL("and B.issue_id not in (select issue_id from payment_main) ");
		sqljob.appendSQL("and B.repay_date between ? and ? ");//應還本日期區間
		sqljob.addParameter(myForm.getRepaySdate());
		sqljob.addParameter(myForm.getRepayEdate());
		sqljob.appendSQL("group by A.id,B.repay_date,A.debt_name,datediff(dd,issue_date,due_date),A.issue_amount,A.charge_rate,B.capital_amount,B.REPAY_DATE ");
		
		//部分提前償還本金的期別
		String tmpInterestAmount = "(sum(distinct a.issue_amount) - sum(distinct C.balance_capital_amount) - (sum(distinct B.capital_amount) - sum(distinct C.capital_amount)))";
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select A.id as ISSUE_ID,'"+usrId+"' as USRID," + 
							"B.repay_date as DUE_DATE,");
		sqljob.appendSQL("null as  repay_date,");
		sqljob.appendSQL("A.debt_name,");
		sqljob.appendSQL("datediff(dd,issue_date,due_date) as date_period,");
		sqljob.appendSQL("sum(distinct a.issue_amount) as issue_amount,");
		sqljob.appendSQL("(sum(distinct B.capital_amount) - sum(distinct C.capital_amount)) as capital_amount,");
		sqljob.appendSQL(""+tmpInterestAmount+" as interest_amount,");
		//計算經付手續費--------//20090901 chrisWu 手續由0.0004->0.0003
		sqljob.appendSQL("case when B.REPAY_DATE < '2009-09-01' then ");
		sqljob.appendSQL("((sum(distinct B.capital_amount) - sum(distinct C.capital_amount)) + "+tmpInterestAmount+") * A.charge_rate ");
		sqljob.appendSQL("else ((sum(distinct B.capital_amount) - sum(distinct C.capital_amount)) + "+tmpInterestAmount+") * 0.0003 end as change_amount ");
		sqljob.appendSQL("from issue_main A, debt_plan_det B, payment_main C ");
		sqljob.appendSQL("where A.id = B.issue_id and B.id = C.plan_id ");
		sqljob.appendSQL("and A.debt_type = 'B' ");
//		sqljob.appendSQL("and A.capital_amount < (select sum(real_amount) from debt_main debt where debt.issue_id = A.id ) ");
		sqljob.appendSQL("and isnull((select sum(capital_amount) from payment_main where issue_id = a.id),0) < (select sum(real_amount) from debt_main debt where debt.issue_id = A.id ) ");
		sqljob.appendSQL("and B.repay_date between ? and ? ");//應還本日期區間
		sqljob.addParameter(myForm.getRepaySdate());
		sqljob.addParameter(myForm.getRepayEdate());
		sqljob.appendSQL("group by A.id,B.repay_date,A.debt_name,datediff(dd,issue_date,due_date),A.issue_amount,A.charge_rate ");
		
//		sqljob.appendSQL("order by B.plan_repay_date ");
		sqljob.appendSQL("order by due_date, repay_date DESC");
		
		String[] sqlArry = sqljob.toString().split("union");
		System.out.println("已償還本金:"+sqlArry[0].toString());
		System.out.println("未償還本金:"+sqlArry[1].toString());
		System.out.println("部分未償還本金:"+sqlArry[2].toString());
		return sqljob;
	}
	
	protected SQLJob tmpTableData(){
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select * from BPRA01_RPT ");
		
		return sqljob;
	}
	
	protected SQLJob repayDataTable(Integer issue_id){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select plan_repay_date,repay_date from payment_main where issue_id = ?");
		sqljob.addParameter(issue_id);
		return sqljob;
	}
	
	protected SQLJob selectDebtPlanDetIsNull(ActionForm form){
		Bpra0101Form myForm = (Bpra0101Form)form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select plan_id from payment_main where 1=1");
		sqljob.appendSQL(" and issue_id in (select id from issue_main where debt_type = 'B')");
		sqljob.appendSQL(" and repay_date between ? and ?");
		sqljob.appendSQL(" and (capital_amount = 0 or interest_amount = 0)");
		sqljob.addParameter(myForm.getRepaySdate());
		sqljob.addParameter(myForm.getRepayEdate());
		System.out.println("selectDebtPlanDetIsNull:"+sqljob.toString());
		return sqljob;		
	}	
	/**
	 * 因國庫券轉檔程式，無法對CAPITAL_AMOUNT, INTEREST_AMOUNT寫入資料，
	 * 故於此報表作業中，查尋應償付，但寫入為0之資料，重新補入
	 * @param planId
	 * @return
	 */
	protected SQLJob updateDebtPlanDet(Integer planId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("update payment_main set ");
		sqljob.appendSQL("capital_amount = (select capital_amount from debt_plan_det where id = ?) ");
		sqljob.appendSQL(",interest_amount = (select interest_amount from debt_plan_det where id = ?) ");
		sqljob.appendSQL("where plan_id = ? ");
		sqljob.addParameter(planId);
		sqljob.addParameter(planId);
		sqljob.addParameter(planId);
		System.out.println("updateDebtPlanDet:"+sqljob.toString());
		return sqljob;		
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception
	{
		Bpra0101Form myForm = (Bpra0101Form)form;
		//區間日期
		Date repaySdate = myForm.getRepaySdate();
		Date repayEdate = myForm.getRepayEdate();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert		
		Map tMap = new HashMap();
		Map tmpMap = new HashMap();
		
		List nullDebtPlanDet = (List)run.query(selectDebtPlanDetIsNull(myForm), new MapListHandler());
		for(Iterator tIterator = nullDebtPlanDet.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			Integer planId = (Integer)tMap.get("plan_id");
			run.update(connection,updateDebtPlanDet(planId));
		}		
		
		List tList = (List) run.query(mainTemp(form,usrId), new MapListHandler());
		Integer issueId = 0;
		int i=1;
		BigDecimal capitalAmount = new BigDecimal(0);
		BigDecimal interestAmount = new BigDecimal(0);
		BigDecimal changeAmount = new BigDecimal(0);
		BigDecimal tmpInterestAmount = new BigDecimal(0);

		String tmpDebtName = null;
		//資料Map
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); )
		{
			//是否有提前買回
			tMap = (Map) tIterator.next();
			Map dMap = new HashMap();
			Integer issue_id = (Integer)tMap.get("ISSUE_ID");
			List repayDateList = (List)run.query(repayDataTable(issue_id), new MapListHandler());
			if (repayDateList.size() >= 1)
			{
				for(Iterator repayDateIterator = repayDateList.iterator(); repayDateIterator.hasNext();)
				{
					Map map = new HashMap();
					map = (Map)repayDateIterator.next();
					Date repayDate = (Date)map.get("repay_date");
					//提前買回日是否超出區間
					if (repayDate.before(repaySdate))
					{
						myForm.setRepaySdate(repayDate);
						myForm.setRepayEdate(repayDate);
						List repayDateList2 = (List)run.query(mainTemp(myForm,usrId), new MapListHandler());
						for (Iterator rIterator = repayDateList2.iterator(); rIterator.hasNext();)
						{
							Map rMap = new HashMap(); 
							rMap = (Map)rIterator.next();
							dMap = new HashMap();
							Integer issue_id2 = (Integer)rMap.get("ISSUE_ID");
							if (issue_id.equals(issue_id2))
							{
								dMap.put("DUE_DATE",(Date)rMap.get("DUE_DATE"));
								dMap.put("DEBT_NAME",(String)rMap.get("DEBT_NAME"));
								dMap.put("DATE_PERIOD",(Integer)rMap.get("DATE_PERIOD"));
								dMap.put("ISSUE_AMOUNT",(BigDecimal)rMap.get("ISSUE_AMOUNT"));
								tmpDebtName = (String)rMap.get("DEBT_NAME");
								interestAmount = interestAmount.add((BigDecimal)rMap.get("INTEREST_AMOUNT"));
								capitalAmount = capitalAmount.add((BigDecimal) rMap.get("CAPITAL_AMOUNT"));
								changeAmount = changeAmount.add((BigDecimal) rMap.get("CHANGE_AMOUNT"));
								dMap.put("ISSUE_ID",(Integer)rMap.get("ISSUE_ID"));
								dMap.put("USRID",(String)rMap.get("USRID"));
								dMap.put("REPAY_DATE",(Date)rMap.get("REPAY_DATE"));
								dMap.put("CAPITAL_AMOUNT",capitalAmount);
								dMap.put("INTEREST_AMOUNT",interestAmount);
								dMap.put("ISSUE_PAY",changeAmount);
								capitalAmount = new BigDecimal(0);
								interestAmount = new BigDecimal(0);
								changeAmount = new BigDecimal(0);
								run.update(connection,insTemp("BPRA01_RPT",dMap));
							}
						}
					}
				}
			}
			//是否與上一筆相同"國庫券名稱"
			if (tmpDebtName == null || !tmpDebtName.equals((String)tMap.get("DEBT_NAME")))
			{
				dMap.put("DUE_DATE",(Date)tMap.get("DUE_DATE"));
				dMap.put("DEBT_NAME",(String)tMap.get("DEBT_NAME"));
				dMap.put("DATE_PERIOD",(Integer)tMap.get("DATE_PERIOD"));
				dMap.put("ISSUE_AMOUNT",(BigDecimal)tMap.get("ISSUE_AMOUNT"));
				tmpDebtName = (String)tMap.get("DEBT_NAME");
			} else {
				dMap = new HashMap();
			}
			//填入實際資料
			interestAmount = interestAmount.add((BigDecimal)tMap.get("INTEREST_AMOUNT"));
			capitalAmount = capitalAmount.add((BigDecimal) tMap.get("CAPITAL_AMOUNT"));
			changeAmount = changeAmount.add((BigDecimal) tMap.get("CHANGE_AMOUNT"));
			dMap.put("ISSUE_ID",(Integer)tMap.get("ISSUE_ID"));
			dMap.put("USRID",(String)tMap.get("USRID"));
			dMap.put("REPAY_DATE",(Date)tMap.get("REPAY_DATE"));
			dMap.put("CAPITAL_AMOUNT",capitalAmount);
			dMap.put("INTEREST_AMOUNT",interestAmount);
			dMap.put("ISSUE_PAY",changeAmount);
			capitalAmount = new BigDecimal(0);
			interestAmount = new BigDecimal(0);
			changeAmount = new BigDecimal(0);
			run.update(connection,insTemp("BPRA01_RPT",dMap));
			
			//當到期日超出區間
			Date dueDate = (Date)tMap.get("DUE_DATE");
			if (dueDate.after(repayEdate))
			{
				myForm.setRepaySdate(dueDate);
				myForm.setRepayEdate(dueDate);
				List repayDateList2 = (List)run.query(mainTemp(myForm,usrId), new MapListHandler());
				for (Iterator rIterator = repayDateList2.iterator(); rIterator.hasNext();)
				{
					Map rMap = new HashMap(); 
					rMap = (Map)rIterator.next();
					dMap = new HashMap();
					Integer issue_id2 = (Integer)rMap.get("ISSUE_ID");
					if (issue_id.equals(issue_id2))
					{
						interestAmount = interestAmount.add((BigDecimal)rMap.get("INTEREST_AMOUNT"));
						capitalAmount = capitalAmount.add((BigDecimal) rMap.get("CAPITAL_AMOUNT"));
						changeAmount = changeAmount.add((BigDecimal) rMap.get("CHANGE_AMOUNT"));
						dMap.put("ISSUE_ID",(Integer)rMap.get("ISSUE_ID"));
						dMap.put("USRID",(String)rMap.get("USRID"));
						dMap.put("REPAY_DATE",(Date)rMap.get("REPAY_DATE"));
						dMap.put("CAPITAL_AMOUNT",capitalAmount);
						dMap.put("INTEREST_AMOUNT",interestAmount);
						dMap.put("ISSUE_PAY",changeAmount);
						capitalAmount = new BigDecimal(0);
						interestAmount = new BigDecimal(0);
						changeAmount = new BigDecimal(0);
						run.update(connection,insTemp("BPRA01_RPT",dMap));
					}
				}
			}
		}
	}
}
