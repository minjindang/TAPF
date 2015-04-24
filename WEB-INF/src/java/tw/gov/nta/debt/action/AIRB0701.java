/* AIRB0701.java 報表
 程式目的：AIRB07
 程式代號：AIRB07
程式日期：0950316
 程式作者：icefire
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

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

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airb0601Form;
import tw.gov.nta.debt.form.Airb0701Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

public class AIRB0701 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRB07_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId,int month,Map map){
		Airb0701Form myform = (Airb0701Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO AIRB07_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK,BUDGET_CODE,");
		sqljob.appendSQL(" ACCOUNT_YEAR,ACCOUNT_MONTH,ISSUE_SRC_AMOUNT,");
		sqljob.appendSQL(" ISSUE_ADD_AMOUNT,"); 
		sqljob.appendSQL(" PAY_INTEREST_AMOUNT,ISSUE_TOTAL_AMOUNT,");
		sqljob.appendSQL(" PAY_TOTAL_AMOUNT,NOPAY_INTEREST_AMOUNT ");
		sqljob.appendSQL(" ) ");	
		sqljob.appendSQL("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
		
		sqljob.addParameter(usrId);
		sqljob.addParameter(DateUtil.date2Str(new Date(),"yyyy/mm/dd"));
		sqljob.addParameter("");
		sqljob.addParameter("");
		sqljob.addParameter(myform.getRepayDate());
		sqljob.addParameter(month);
		sqljob.addParameter((BigDecimal)map.get("ISSUE_SRC_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("ISSUE_ADD_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("PAY_INTEREST_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("ISSUE_TOTAL_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("PAY_TOTAL_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("NOPAY_INTEREST_AMOUNT"));
	
		System.out.println(sqljob.toString());
		return sqljob;
	}
	public SQLJob selTemp(ActionForm form,String usrId,int month)
	{
		Airb0701Form myform = (Airb0701Form) form;
		SQLJob sqljob = new SQLJob();

		sqljob.appendSQL("select isnull(SUM(CASE i.bond_kind WHEN '1' THEN x.interest_amount ELSE 0 END),cast(0 as int)) AS ISSUE_SRC_AMOUNT , ");
		sqljob.appendSQL("isnull(SUM(CASE i.bond_kind WHEN '3' THEN x.interest_amount ELSE 0 END), cast(0 as int)) AS ISSUE_ADD_AMOUNT , ");
		sqljob.appendSQL("(select isnull(sum(p.interest_amount), cast(0 as int)) ");
		sqljob.appendSQL("from debt_plan_det p, debt_main B, issue_main A  ");
		
		sqljob.appendSQL("where A.debt_type='A' and B.issue_id=A.id and p.debt_id=B.id ");
		if(null != myform.getRepayDate() && !"".equals(myform.getRepayDate()))
		{
			sqljob.appendSQL("and p.repay_date >= ? ");
			Calendar tCalendar = GregorianCalendar.getInstance();
			tCalendar.setTime(new Date((Integer.parseInt(myform.getRepayDate())+11),month-1,1));
			tCalendar.add(tCalendar.DATE,1);
			sqljob.addParameter(tCalendar.getTime());
			sqljob.appendSQL("and p.repay_date <= ? ");
			Calendar tCalendar2 = GregorianCalendar.getInstance();
			tCalendar2.setTime(DateUtil.getLastDateOfMonth(new Date((Integer.parseInt(myform.getRepayDate())+11),month-1,1)));
			tCalendar2.add(tCalendar.DATE,1);
			sqljob.addParameter(tCalendar2.getTime());
			
		}	
		if(null != myform.getDebtCode() && 0 != myform.getDebtCode())
		{
			sqljob.appendSQL("and b.debt_code= ?");
			sqljob.addParameter(myform.getDebtCode());
		}	
		if(null != myform.getBudgetCode() && 0 != myform.getBudgetCode())
		{
			sqljob.appendSQL("and b.budget_code= ? ");
			sqljob.addParameter(myform.getBudgetCode());
		}
		sqljob.appendSQL(") As PAY_INTEREST_AMOUNT from issue_main i, debt_main d, debt_plan_det x ");
		sqljob.appendSQL("where i.debt_type='A' ");
		sqljob.appendSQL("and i.id=d.issue_id and x.debt_id=d.id ");
		if(null != myform.getRepayDate() && !"".equals(myform.getRepayDate()))
		{
			sqljob.appendSQL("and (select Year(a.issue_date) from issue_main A where a.id = i.source_issue_id ) = ? ");
			sqljob.addParameter(Integer.toString(Integer.parseInt(myform.getRepayDate())+1911));
			sqljob.appendSQL("and (select Month(a.issue_date) from issue_main A where a.id = i.source_issue_id ) = ? ");
			sqljob.addParameter(month);
		}	
		if(null != myform.getDebtCode() && 0 != myform.getDebtCode())
		{
			sqljob.appendSQL("and d.debt_code= ?");
			sqljob.addParameter(myform.getDebtCode());
		}	
		if(null != myform.getBudgetCode() && 0 != myform.getBudgetCode())
		{
			sqljob.appendSQL("and d.budget_code= ? ");
			sqljob.addParameter(myform.getBudgetCode());
		}
		System.out.println(sqljob);
		return sqljob ;
	}
	public SQLJob getInterest(ActionForm form,int month)
	{
		//發行累計數
		Airb0701Form myform = (Airb0701Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select SUM(CASE i.bond_kind WHEN '3' THEN x.interest_amount ELSE x.interest_amount END) as interest_amount ");
		sqljob.appendSQL(" from issue_main i, debt_main d, debt_plan_det x ");
		sqljob.appendSQL(" where i.debt_type='A' ");
		sqljob.appendSQL(" and i.id=d.issue_id ");
		sqljob.appendSQL(" and x.debt_id=d.id ");
		if(null != myform.getRepayDate() && !"".equals(myform.getRepayDate()))
		{
			sqljob.appendSQL("and (select a.issue_date from issue_main A where a.id = i.source_issue_id ) <= ? ");
			Calendar tCalendar = GregorianCalendar.getInstance();
			tCalendar.setTime(DateUtil.getLastDateOfMonth(new Date((Integer.parseInt(myform.getRepayDate())+11),month,1)));
			tCalendar.add(tCalendar.DATE,1);
			sqljob.addParameter(tCalendar.getTime());
		}
		if(null != myform.getDebtCode() && 0 != myform.getDebtCode())
		{
			sqljob.appendSQL(" and d.debt_code= ? ");
			sqljob.addParameter(myform.getDebtCode());
		}	
		if(null != myform.getBudgetCode() && 0 != myform.getBudgetCode())
		{
			sqljob.appendSQL(" and d.budget_code= ? ");
			sqljob.addParameter(myform.getBudgetCode());
		}
		System.out.println("===發行利息累計數=="+sqljob);
		return sqljob;
	}
	public SQLJob getReturnInterest(ActionForm form,int month)
	{
		//還本累計數
		Airb0701Form myform = (Airb0701Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select SUM(x.interest_amount) as interest_amount ");
		sqljob.appendSQL(" from issue_main i, debt_main d, debt_plan_det x ");
		sqljob.appendSQL(" where i.debt_type='A' ");
		sqljob.appendSQL(" and i.id=d.issue_id ");
		sqljob.appendSQL(" and x.debt_id=d.id ");
		if(null != myform.getRepayDate() && !"".equals(myform.getRepayDate()))
		{
			sqljob.appendSQL("and x.repay_date <= ? ");
			Calendar tCalendar = GregorianCalendar.getInstance();
			tCalendar.setTime(DateUtil.getLastDateOfMonth(new Date((Integer.parseInt(myform.getRepayDate())+11),month,1)));
			tCalendar.add(tCalendar.DATE,1);
			sqljob.addParameter(tCalendar.getTime());
		}
		if(null != myform.getDebtCode() && 0 != myform.getDebtCode())
		{
			sqljob.appendSQL(" and d.debt_code= ? ");
			sqljob.addParameter(myform.getDebtCode());
		}	
		if(null != myform.getBudgetCode() && 0 != myform.getBudgetCode())
		{
			sqljob.appendSQL(" and d.budget_code= ? ");
			sqljob.addParameter(myform.getBudgetCode());
		}
		System.out.println("===利息累計數=="+sqljob);
		return sqljob;
	}
	//提前買回
	protected SQLJob sqlPayment(ActionForm form,int month){
		SQLJob sqljob = new SQLJob();
		Airb0701Form myform = (Airb0701Form) form;
		
		sqljob.appendSQL("select SUM(p.interest_amount) as  interest_amount");
		sqljob.appendSQL("from issue_main i, payment_main p, debt_main d where 1=1 ");
		sqljob.appendSQL("and i.debt_type = 'A' ");
		sqljob.appendSQL("and i.id = p.issue_id ");
		sqljob.appendSQL("and i.id = d.issue_id ");
		sqljob.appendSQL("and p.debt_id = d.id ");
		sqljob.appendSQL("and p.REPAY_DATE <> p.PLAN_REPAY_DATE ");
		sqljob.appendSQL("and p.CAPITAL_AMOUNT > 0 ");
		if(null != myform.getRepayDate() && !"".equals(myform.getRepayDate()))
		{
			//因提前買回從2010年開始，故可寫死
			sqljob.appendSQL("and p.repay_date >= '2010-01-01' ");
			sqljob.appendSQL("and p.repay_date <= ? ");
			Calendar tCalendar = GregorianCalendar.getInstance();
			tCalendar.setTime(DateUtil.getLastDateOfMonth(new Date((Integer.parseInt(myform.getRepayDate())+11),month,1)));
			tCalendar.add(tCalendar.DATE,1);
			sqljob.addParameter(tCalendar.getTime());
		}
		if(null != myform.getDebtCode() && 0 != myform.getDebtCode())
		{
			sqljob.appendSQL(" and d.debt_code= ? ");
			sqljob.addParameter(myform.getDebtCode());
		}	
		if(null != myform.getBudgetCode() && 0 != myform.getBudgetCode())
		{
			sqljob.appendSQL(" and d.budget_code= ? ");
			sqljob.addParameter(myform.getBudgetCode());
		}

		System.out.println(sqljob.toString());
		return sqljob;
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 select
		List[] list = new List[12];
		List[] issueInterest = new List[12];
		List[] returnInterest = new List[12];
		List[] advanceCapital =  new List[12];
		
		for(int i=0;i<=11;i++)
		{	
			 list[i] = (List)run.query(selTemp(form,usrId,i+1),new MapListHandler());
			 issueInterest[i] = (List)run.query(getInterest(form,i),new MapListHandler());
			 returnInterest[i] = (List)run.query(getReturnInterest(form,i),new MapListHandler());
			 advanceCapital[i] = (List)run.query(sqlPayment(form,i),new MapListHandler());
		}
		//執行 insert
		
		BigDecimal ISSUE_TOTAL_AMOUNT = new BigDecimal(0);
		BigDecimal PAY_TOTAL_AMOUNT = new BigDecimal(0);
		BigDecimal NOPAY_INTEREST_AMOUNT = new BigDecimal(0);
		
		for (int i=0;i<=11;i++)
		{	
			if(null != list[i] && 0!= list[i].size())
			{	
				for(Iterator it=list[i].iterator();it.hasNext();)
				{	
					Map map = (Map)it.next();
					Map map2 = (Map)((List)issueInterest[i]).get(0);
					Map map3 = (Map)((List)returnInterest[i]).get(0);
					Map map4 = new HashMap();
					
					ISSUE_TOTAL_AMOUNT = (BigDecimal)(null!= map2.get("interest_amount")? map2.get("interest_amount"):new BigDecimal(0));
					PAY_TOTAL_AMOUNT = (BigDecimal)(null!= map3.get("interest_amount")? map3.get("interest_amount"):new BigDecimal(0));
					if(null != advanceCapital[i] && !((List)advanceCapital[i]).isEmpty()){
						if(null!=((Map)advanceCapital[i].get(0)).get("interest_amount")){
							map4 = (Map)advanceCapital[i].get(0);
							BigDecimal capitalAmount = null!= map4.get("interest_amount")? (BigDecimal)map4.get("interest_amount"):new BigDecimal(0);
							PAY_TOTAL_AMOUNT = PAY_TOTAL_AMOUNT.add(capitalAmount);
						}
					}
					NOPAY_INTEREST_AMOUNT = ISSUE_TOTAL_AMOUNT.subtract(PAY_TOTAL_AMOUNT);
					
					map.put("ISSUE_TOTAL_AMOUNT",ISSUE_TOTAL_AMOUNT);
					map.put("PAY_TOTAL_AMOUNT",PAY_TOTAL_AMOUNT);
					map.put("NOPAY_INTEREST_AMOUNT",NOPAY_INTEREST_AMOUNT);
					
					run.update(connection,insTemp(form,usrId,i+1,map));	
				}
			}	
		}
	}
}
