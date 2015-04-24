/* AIRB0601.java 報表
 程式目的：AIRB06
 程式代號：AIRB06
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airb0601Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

public class AIRB0601 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRB06_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId,int month,Map map){
		Airb0601Form myform = (Airb0601Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO AIRB06_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK,BUDGET_CODE,");
		sqljob.appendSQL(" ACCOUNT_YEAR,ACCOUNT_MONTH,ISSUE_SRC_AMOUNT,");
		sqljob.appendSQL(" ISSUE_ADD_AMOUNT,"); 
		sqljob.appendSQL(" PAY_CAPITAL_AMOUNT,ISSUE_TOTAL_AMOUNT,");
		sqljob.appendSQL(" PAY_TOTAL_AMOUNT,NOPAY_CAPITAL_AMOUNT ");
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
		sqljob.addParameter((BigDecimal)map.get("PAY_CAPITAL_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("ISSUE_TOTAL_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("PAY_TOTAL_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("NOPAY_CAPITAL_AMOUNT"));
		System.out.println(sqljob);
		return sqljob;
	}
	public SQLJob selTemp(ActionForm form,String usrId,int month)
	{
		Airb0601Form myform = (Airb0601Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select isnull(SUM(CASE i.bond_kind WHEN '1' THEN D.issue_amount ELSE 0 END),cast(0 as int)) AS ISSUE_SRC_AMOUNT , ");
		sqljob.appendSQL("isnull(SUM(CASE i.bond_kind WHEN '3' THEN D.issue_amount ELSE 0 END), cast(0 as int)) AS ISSUE_ADD_AMOUNT , ");
		sqljob.appendSQL("(select isnull(sum(p.capital_amount), cast(0 as int )) ");
		sqljob.appendSQL("from debt_plan_det p, debt_main B, issue_main A ");
		sqljob.appendSQL("where A.debt_type='A' and B.issue_id=A.id and p.debt_id=B.id ");
		if(null != myform.getRepayDate() && !"".equals(myform.getRepayDate()))
		{
			
			sqljob.appendSQL("and p.repay_date >= ? ");
			Calendar tCalendar = GregorianCalendar.getInstance();
			tCalendar.setTime(new Date((Integer.parseInt(myform.getRepayDate())+11),month,1));
			tCalendar.add(tCalendar.DATE,1);
			sqljob.addParameter(tCalendar.getTime());
			sqljob.appendSQL("and p.repay_date <= ? ");
			Calendar tCalendar2 = GregorianCalendar.getInstance();
			tCalendar2.setTime(DateUtil.getLastDateOfMonth(new Date((Integer.parseInt(myform.getRepayDate())+11),month,1)));
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
		sqljob.appendSQL(") As PAY_CAPITAL_AMOUNT from issue_main i, debt_main d ");
		sqljob.appendSQL("where i.debt_type='A' ");
		sqljob.appendSQL("and i.id=d.issue_id ");
		if(null != myform.getRepayDate() && !"".equals(myform.getRepayDate()))
		{			
			sqljob.appendSQL("and (select Year(a.issue_date) from issue_main A where a.id = i.source_issue_id ) = ? ");
			sqljob.addParameter(Integer.toString(Integer.parseInt(myform.getRepayDate())+1911));
			sqljob.appendSQL("and (select Month(a.issue_date) from issue_main A where a.id = i.source_issue_id ) = ? ");
			sqljob.addParameter(month+1);
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
	@SuppressWarnings({ "deprecation", "static-access" })
	public SQLJob getCapital(ActionForm form,int month)
	{
		//發行累計數
		Airb0601Form myform = (Airb0601Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select SUM(d.issue_amount) as issue_amount ");
		sqljob.appendSQL(" from issue_main i, debt_main d ");
		sqljob.appendSQL(" where i.debt_type='A' ");
		sqljob.appendSQL(" and i.id=d.issue_id ");
		if(null != myform.getRepayDate() && !"".equals(myform.getRepayDate()))
		{
			sqljob.appendSQL("and (select a.issue_date from issue_main A where a.id = i.source_issue_id ) <= ? ");
			Calendar tCalendar = GregorianCalendar.getInstance();
			tCalendar.setTime(DateUtil.getLastDateOfMonth(new Date((Integer.parseInt(myform.getRepayDate())+11),month,1)));
//			tCalendar.add(tCalendar.DATE,1);
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
		System.out.println("===發行累計數=="+sqljob);
		return sqljob;
	}
	@SuppressWarnings({ "static-access", "deprecation" })
	public SQLJob getReturnCapital(ActionForm form,int month)
	{
		//還本累計數
		Airb0601Form myform = (Airb0601Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select SUM(x.capital_amount) as capital_amount ");
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
		System.out.println("===還本累計數=="+sqljob);
		return sqljob;
	}
	//提前買回
	protected SQLJob sqlPayment(ActionForm form,int month){
		SQLJob sqljob = new SQLJob();
		Airb0601Form myform = (Airb0601Form) form;
		
		sqljob.appendSQL("select SUM(p.CAPITAL_AMOUNT) as  capital_amount");
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
		List[] issueCapital = new List[12];
		List[] returnCapital = new List[12];
		List[] advanceCapital =  new List[12];
		
		for(int i=0;i<=11;i++)
		{	
			 list[i] = (List)run.query(selTemp(form,usrId,i),new MapListHandler());
			 issueCapital[i] = (List)run.query(getCapital(form,i),new MapListHandler());
			 returnCapital[i] = (List)run.query(getReturnCapital(form,i),new MapListHandler());
			 advanceCapital[i] = (List)run.query(sqlPayment(form,i),new MapListHandler());
		}
		//執行 insert
		
		BigDecimal ISSUE_TOTAL_AMOUNT = new BigDecimal(0);
		BigDecimal PAY_TOTAL_AMOUNT = new BigDecimal(0);
		BigDecimal NOPAY_CAPITAL_AMOUNT = new BigDecimal(0);

		for (int i=0;i<=11;i++)
		{	
			if(null != list[i] && 0!= list[i].size())
			{	
				for(Iterator it=list[i].iterator();it.hasNext();)
				{	
					Map map = (Map)it.next();
					Map map2 = (Map)((List)issueCapital[i]).get(0);
					Map map3 = (Map)((List)returnCapital[i]).get(0);
					Map map4 = new HashMap();
					
					ISSUE_TOTAL_AMOUNT = (BigDecimal)(null!= map2.get("issue_amount")? map2.get("issue_amount"):new BigDecimal(0));
					PAY_TOTAL_AMOUNT = (BigDecimal)(null!= map3.get("capital_amount")? map3.get("capital_amount"):new BigDecimal(0));
					if(null != advanceCapital[i] && !((List)advanceCapital[i]).isEmpty()){
						if(null!=((Map)advanceCapital[i].get(0)).get("capital_amount")){
							map4 = (Map)advanceCapital[i].get(0);
							BigDecimal capitalAmount = null!= map4.get("capital_amount")? (BigDecimal)map4.get("capital_amount"):new BigDecimal(0);
							PAY_TOTAL_AMOUNT = PAY_TOTAL_AMOUNT.add(capitalAmount);
						}
					}
					NOPAY_CAPITAL_AMOUNT = ISSUE_TOTAL_AMOUNT.subtract(PAY_TOTAL_AMOUNT);
					
					map.put("ISSUE_TOTAL_AMOUNT",ISSUE_TOTAL_AMOUNT);
					map.put("PAY_TOTAL_AMOUNT",PAY_TOTAL_AMOUNT);
					map.put("NOPAY_CAPITAL_AMOUNT",NOPAY_CAPITAL_AMOUNT);

					
					run.update(connection,insTemp(form,usrId,i+1,map));	
				}
			}	
		}
	}


}
