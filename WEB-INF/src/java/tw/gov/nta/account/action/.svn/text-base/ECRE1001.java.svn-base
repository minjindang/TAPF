package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.dao.BudgetRefDAO;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ECRE1001 extends ExcelReportBaseAction{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM ECRE10_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL1(AccountQueryForm myForm){
		
		int year = Integer.parseInt(myForm.getAccountYear());
		year += 1911;
		System.out.print(year);
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select a.id as issue_id,a.debt_name, ");
		sqljob.appendSQL("min(e.bank_name)+case when count(distinct b.bank_id) > 1 then '等'+ cast(count(distinct b.bank_id) as varchar)+'家銀行' else '' end as bank_name,");
		sqljob.appendSQL("a.issue_date as issue_date ,");
		sqljob.appendSQL("a.due_date as due_date ,");
//		sqljob.appendSQL("(select sum(issue_amount) from debt_main where (select ) and issue_id = a.id and debt_code  <> 35) as real_amount,");
		sqljob.appendSQL("(select sum(issue_amount) from debt_main where issue_id = a.id and debt_code  <> 35) as real_amount,");
		
		//是否只顯示95年度償還本金?
//		sqljob.appendSQL("(select sum(capital_amount) from payment_main where issue_id = a.id and repay_date between '"+ year +"/01/01' and '"+myForm.getSQLYearLastDate()+"' group by issue_id) as pay_capital, ");
		sqljob.appendSQL("(select sum(capital_amount) from payment_main where issue_id = a.id and repay_date <= '"+myForm.getSQLYearLastDate()+"' group by issue_id) as pay_capital, ");
		
//		sqljob.appendSQL("sum(isnull(c.capital_amount,0)) AS pay_capital,");
		
		//
//		sqljob.appendSQL("(select sum(issue_amount) from debt_main where issue_id = a.id and debt_code  <> 35) - sum(isnull(c.capital_amount,0)) AS remain_capital,");
		sqljob.appendSQL("(select sum(issue_amount) from debt_main where issue_id = a.id and debt_code  <> 35) - isnull((select sum(capital_amount) from payment_main where issue_id = a.id and repay_date <= '"+myForm.getSQLYearLastDate()+"' group by issue_id),0) AS remain_capital,");
		
		sqljob.appendSQL("round(cast((case when (select sum(issue_amount) from debt_main where issue_id = a.id and debt_code  <> 35) - isnull((select sum(capital_amount) from payment_main where issue_id = a.id and repay_date <= '"+myForm.getSQLYearLastDate()+"' group by issue_id),0) > 0 then ((select sum(interest_amount) from debt_plan_det p where p.issue_id = a.id  and p.delete_mark='N' ) - (select sum(interest_amount) from payment_main x where x.issue_id = a.id )) else '0' end)as decimal(20,4)),0) as pay_interest");
//		sqljob.appendSQL("(select sum(interest_amount) from debt_plan_det p where p.issue_id = a.id and p.repay_date >= '"+String.valueOf(Integer.valueOf(myForm.getAccountYear())+1911)+"/1/1' ) as pay_interest ");
//		sqljob.appendSQL("from issue_main a,debt_main b,payment_main c,bank_ref e,debt_plan_det f");
//		sqljob.appendSQL("where a.id = b.issue_id ");
//		sqljob.appendSQL("and f.id = c.plan_id");
//		sqljob.appendSQL("and b.id = f.debt_id ");
//		sqljob.appendSQL("and b.bank_id = e.id");
		
		sqljob.appendSQL("from issue_main a");
		sqljob.appendSQL("left join debt_main b on a.id = b.issue_id");
		sqljob.appendSQL("left join payment_main c on a.id = c.issue_id");
		sqljob.appendSQL("left join bank_ref e on b.bank_id = e.id");
		sqljob.appendSQL("left join debt_plan_det f on a.id = f.issue_id and b.id = f.debt_id");
		sqljob.appendSQL("where debt_type = 'C' ");
		sqljob.appendSQL("and b.accrue = 'Y'");
		sqljob.appendSQL("and b.debt_code <> 35");
		sqljob.appendSQL("and a.account_year <> '"+myForm.getAccountYear()+"'");
		sqljob.appendSQL("and f.delete_mark = 'N' and a.bond_type <> 1 and ISNUMERIC(a.serial_no) = 1 ");
		sqljob.appendSQL("and a.ISSUE_DATE <= '"+myForm.getSQLYearLastDate()+"' ");
		sqljob.appendSQL("and (a.issue_amount > a.capital_amount or a.capital_amount is null or (a.issue_amount=a.capital_amount and  c.repay_date >='"+year+"/1/1')) ");
		sqljob.appendSQL("group by a.id,a.debt_name,a.issue_date, a.due_date,a.id,a.issue_serial");
		sqljob.appendSQL("order by a.issue_serial");
		System.out.println(sqljob.toString());
		return sqljob;		
	}
	
	protected SQLJob SQL2(AccountQueryForm myForm){
		
		int year = Integer.parseInt(myForm.getAccountYear());
		year += 1911;
		System.out.print(year);
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select a.id as issue_id,a.debt_name, ");
		sqljob.appendSQL("min(e.bank_name)+case when count(distinct b.bank_id) > 1 then '等'+ cast(count(distinct b.bank_id) as varchar)+'家銀行' else '' end as bank_name,");
		sqljob.appendSQL("a.issue_date as issue_date ,");
		sqljob.appendSQL("a.due_date as due_date ,");
		sqljob.appendSQL("(select sum(issue_amount) from debt_main where issue_id = a.id and debt_code  <> 35) as real_amount,");
		
		//是否只顯示95年度償還本金?
		sqljob.appendSQL("(select sum(capital_amount) from payment_main where issue_id = a.id and repay_date <= '"+myForm.getSQLYearLastDate()+"' group by issue_id) as pay_capital, ");
		sqljob.appendSQL("(select sum(issue_amount) from debt_main where issue_id = a.id and debt_code  <> 35) - isnull((select sum(capital_amount) from payment_main where issue_id = a.id and repay_date <= '"+myForm.getSQLYearLastDate()+"' group by issue_id),0) AS remain_capital,");
		
		
		sqljob.appendSQL("round(cast((select sum(interest_amount) from debt_plan_det p where p.issue_id = a.id and p.repay_date >= '"+String.valueOf(Integer.valueOf(myForm.getAccountYear())+1911)+"/1/1' and p.delete_mark <> 'Y')as decimal(20,4)),0) as pay_interest ");
		sqljob.appendSQL("from issue_main a,debt_main b,bank_ref e,debt_plan_det f");
		sqljob.appendSQL("where a.id = b.issue_id ");
		sqljob.appendSQL("and b.id = f.debt_id ");
		sqljob.appendSQL("and b.bank_id = e.id");
		sqljob.appendSQL("and debt_type = 'C' ");
		sqljob.appendSQL("and b.accrue = 'Y'");
		sqljob.appendSQL("and b.debt_code <> 35");
		sqljob.appendSQL("and a.account_year = '"+myForm.getAccountYear()+"'");
		sqljob.appendSQL("and f.delete_mark = 'N' and a.bond_type <> 1 and ISNUMERIC(a.serial_no) = 1 ");
		sqljob.appendSQL("and a.ISSUE_DATE <= '"+myForm.getSQLYearLastDate()+"' ");
//		sqljob.appendSQL("and (a.issue_amount > a.capital_amount or a.capital_amount is null ) ");
		sqljob.appendSQL("group by a.id,a.debt_name,a.issue_date, a.due_date,a.id,a.issue_serial");
		sqljob.appendSQL("order by a.issue_serial");
		System.out.println(sqljob.toString());
		return sqljob;		
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		AccountQueryForm myForm = (AccountQueryForm)form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = null;
		Session session = DebtMainDAO.getInstance().getSession();
		String queryString = "select debt.budgetCode,sum(debt.issueAmount) from DebtMain debt " +
				"where debt.issue.id = :issueId and debt.budgetCode <> 35 " +
				"group by debt.budgetCode";
		Query query = session.createQuery(queryString);
		
		DecimalFormat df = new DecimalFormat("#,###");
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			//塞入備註
			int issueId = (Integer)tMap.get("issue_id");
			query.setInteger("issueId",issueId);
			List debtList = query.list();
			StringBuffer remark = new StringBuffer();
			for(Iterator iterator = debtList.iterator();iterator.hasNext();) {
				Object[] result = (Object[])iterator.next();
				int budgetCode = (Integer)result[0];
					
				String budgetName = ((BudgetRef)BudgetRefDAO.getInstance().get(budgetCode,session)).getBudgetName().trim();
				if(debtList.size()==1) {
					remark.append(budgetName);
				}else {
					BigDecimal issueAmount = (BigDecimal)result[1];
					remark.append(budgetName+"發行"+df.format(issueAmount)+"元");
				}
			}

			//借ECRE0801的公式來算預估利息
			ECRE0801 ecre0801 = new ECRE0801();
			//計算結欠利息
			List bankList = (List) run.query( ecre0801.getAllBankId(issueId), new MapListHandler());
			//執行 insert
			BigDecimal remainInterestAmount = new BigDecimal(0);
			for(Iterator bankIterator = bankList.iterator();bankIterator.hasNext();) {
				Map bank = (Map)bankIterator.next();
				Map insertMap = ecre0801.countInterest(issueId,myForm.getSQLLastDate(),myForm.getSQLLastDate().substring(0,7)+"/01",(Integer)bank.get("bank_id"),run);
				remainInterestAmount = remainInterestAmount.add((BigDecimal)insertMap.get("nouse_interest"));
			}
			
			tMap.remove("issue_id");
			tMap.putAll(getCommonMap(usrId));
			tMap.put("remark",remark.toString());
			if (null == tMap.get("pay_capital") || "".equals(tMap.get("pay_capital")))
				tMap.put("pay_capital",0);
			if (null == tMap.get("remain_capital") || "".equals(tMap.get("remain_capital")))
				tMap.put("remain_capital",0);
			if (null == tMap.get("pay_interest") || "".equals(tMap.get("pay_interest")) || ((BigDecimal)tMap.get("remain_capital")).compareTo(new BigDecimal("0")) == 0)
				tMap.put("pay_interest",0);
			else
				tMap.put("pay_interest",remainInterestAmount);
			run.update(connection,insTemp("ECRE10_RPT",tMap));
		}
		
		List queryList2 = (List) run.query(SQL2(myForm), new MapListHandler());
		Map tMap2 = null;
		Session session2 = DebtMainDAO.getInstance().getSession();
		String queryString2 = "select debt.budgetCode,sum(debt.issueAmount) from DebtMain debt " +
				"where debt.issue.id = :issueId and debt.budgetCode <> 35 " +
				"group by debt.budgetCode";
		Query query2 = session.createQuery(queryString2);
		
		DecimalFormat df2 = new DecimalFormat("#,###");
		for(Iterator tIterator = queryList2.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			//塞入備註
			int issueId = (Integer)tMap.get("issue_id");
			query2.setInteger("issueId",issueId);
			List debtList = query2.list();
			StringBuffer remark = new StringBuffer();
			for(Iterator iterator = debtList.iterator();iterator.hasNext();) {
				Object[] result = (Object[])iterator.next();
				int budgetCode = (Integer)result[0];
					
				String budgetName = ((BudgetRef)BudgetRefDAO.getInstance().get(budgetCode,session)).getBudgetName().trim();
				if(debtList.size()==1) {
					remark.append(budgetName);
				}else {
					BigDecimal issueAmount = (BigDecimal)result[1];
					remark.append(budgetName+"發行"+df.format(issueAmount)+"元");
				}
			}


			//借ECRE0801的公式來算預估利息
			ECRE0801 ecre0801 = new ECRE0801();
			//計算結欠利息
			List bankList = (List) run.query( ecre0801.getAllBankId(issueId), new MapListHandler());
			//執行 insert
			BigDecimal remainInterestAmount = new BigDecimal(0);
			for(Iterator bankIterator = bankList.iterator();bankIterator.hasNext();) {
				Map bank = (Map)bankIterator.next();
				Map insertMap = ecre0801.countInterest(issueId,myForm.getSQLLastDate(),myForm.getSQLLastDate().substring(0,7)+"/01",(Integer)bank.get("bank_id"),run);
				remainInterestAmount = remainInterestAmount.add((BigDecimal)insertMap.get("nouse_interest"));
			}
			
			tMap.remove("issue_id");
			tMap.putAll(getCommonMap(usrId));
			tMap.put("remark",remark.toString());
			if (null == tMap.get("pay_capital") || "".equals(tMap.get("pay_capital")))
				tMap.put("pay_capital",0);
			if (null == tMap.get("remain_capital") || "".equals(tMap.get("remain_capital")))
				tMap.put("remain_capital",0);
			if (null == tMap.get("pay_interest") || "".equals(tMap.get("pay_interest")))
				tMap.put("pay_interest",0);
			if (null == tMap.get("remain_capital") || "".equals(tMap.get("remain_capital")) || ((BigDecimal)tMap.get("remain_capital")).compareTo(new BigDecimal("0")) == 0)
				tMap.put("pay_interest",0);
			else
				tMap.put("pay_interest",remainInterestAmount);
			run.update(connection,insTemp("ECRE10_RPT",tMap));
		}
		
	} 
}
