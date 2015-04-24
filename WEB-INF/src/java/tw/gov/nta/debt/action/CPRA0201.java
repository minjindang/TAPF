/* CPRA0201.java 報表
 程式目的：CPRA02
 程式代號：CPRA02
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.debt.common.InterestCounter;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cpra0201Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;
import tw.gov.nta.sql.debt.dao.DebtRateDetDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CPRA0201 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CPRA02_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId,Integer debtId){
		Cpra0201Form cpra0201form = (Cpra0201Form) form;
		SQLJob sqljob = new SQLJob();
		/**
		 * 主要的SQL
		 */
		
		StringBuffer strBuffer = new StringBuffer("from DebtPlanDet plan Where plan.deleteMark = 'N' and plan.debt.issue.debtType = 'C' ");
		Session session = new DebtPlanDetDAO().createNewSession();
		if(null!= debtId && 0 != debtId )
		{
			strBuffer.append(" AND plan.debt.id = " + debtId );
		}
		if(null!= cpra0201form.getIssueId() && 0 != cpra0201form.getIssueId())
		{
			strBuffer.append(" AND plan.debt.issue.id = " + cpra0201form.getIssueId());
		}
		if(null!= cpra0201form.getBankId() && 0!= cpra0201form.getBankId())
		{
			strBuffer.append(" AND plan.debt.bank.id  = " + cpra0201form.getBankId());
		}
		if(null!= cpra0201form.getTempDate())
		{
			strBuffer.append(" AND plan.repayDate > '" + DateUtil.date2Str(cpra0201form.getTempDate(),"yyyy/MM/dd")+"'");
		}
		strBuffer.append(" order by plan.repayDate");
		Query query = session.createQuery(strBuffer.toString());	
		List myList = query.list();
		
		
		/** 設初始值 */
		String issueserial = "";
		String bankname = "";
		Date issuedate;
		Date duedate;
		BigDecimal issueamount = new BigDecimal(0);
		Date paydates = new Date(1900,1,1);
		Date paydatee = new Date(9999,12,31);
		BigDecimal rate = new BigDecimal(0);
		Integer days = new Integer(0);
		BigDecimal  interestamount= new BigDecimal(0);
		BigDecimal  suminterest = new BigDecimal(0);
		BigDecimal  capitalamount = new BigDecimal(0);
		BigDecimal  sumcapital = new BigDecimal(0);
		Boolean Tvalue = false;
		PayManager payManger = new PayManager();
		/** 拆主要的SQL 取值 */
		if(null != myList && 0 != myList.size())
		{
			for(Iterator it=myList.iterator();it.hasNext();)
			{
				DebtPlanDet myDebtPlan = (DebtPlanDet)it.next();
				
				List list = payManger.getListByPlan(myDebtPlan.getId());
				if(null != list && 0 != list.size())
				{
					continue;
				}	
				issuedate = myDebtPlan.getDebt().getIssue().getIssueDate();
				duedate = myDebtPlan.getDebt().getIssue().getDueDate();	
				capitalamount = myDebtPlan.getCapitalAmount().setScale(0,5);	
				
				if(null != cpra0201form.getTempDecimal() && 0 == cpra0201form.getTempDecimal().compareTo(new BigDecimal(0)))
				{
					break;
				}	
				if(Tvalue == false)
				{	
					if(null != cpra0201form.getTempDate())
					{
						paydates = cpra0201form.getTempDate();
						issueamount = cpra0201form.getTempDecimal();
					}	
					else
					{
						paydates = myDebtPlan.getDebt().getIssue().getIssueDate();
						issueamount = myDebtPlan.getDebt().getIssueAmount();
					}
					Tvalue = true;
				}
				else
				{
					paydates = paydatee;
				}
				paydatee = myDebtPlan.getRepayDate();
				
				/**
				 * 算年利率
				 */
				Session session2 = new DebtRateDetDAO().getSession();
				Criteria criteria2 = session2.createCriteria(DebtRateDet.class); 
				criteria2.add(Expression.eq("debt.id",myDebtPlan.getDebt().getId()));
				criteria2.add(Expression.eq("deleteMark","N"));
				criteria2.add(Expression.le("effectiveDate",paydates));
				criteria2.add(Expression.ge("suspendDate",paydates));
				List myRateList = criteria2.list();
				if(null != myRateList && 0 != myRateList.size())
				{	
					rate = ((DebtRateDet)myRateList.get(0)).getDebtRate();
				}
				
				days = DateUtil.getDays(paydates,paydatee);
				List ratelist = new RateManager().getEffectiveRate(myDebtPlan.getDebt().getId());
				interestamount = new InterestCounter().countInterest(paydates,paydatee,ratelist,issueamount.doubleValue(),0);
				suminterest = suminterest.add(interestamount).setScale(0,5);
				sumcapital = sumcapital.add(myDebtPlan.getCapitalAmount());	
				/** 編輯 insert 的 SQL */
				sqljob.appendSQL("INSERT INTO CPRA02_RPT ");
				sqljob.appendSQL(" (USRID, MOD_DATE,Issue_date,Due_date,Issue_amount,Pay_dateS,Pay_dateE,Rate,days,Interest_amount,Sum_interest,Capital_amount,Sum_capital,remark)");
				sqljob.appendSQL("Values('" + usrId + "', CURRENT_TIMESTAMP ,?,?,?,?,?,?,?,?,?,?,?,null) ;");
				
				if(null == issuedate) issuedate = new Date();
				if(null == duedate) duedate = new Date();
				if(null == issueamount) issueamount = new BigDecimal(0);
				if(null == paydates) paydates = new Date();
				if(null == paydatee) paydatee = new Date();
				if(null == rate) rate = new BigDecimal(0);
				if(null == days) days = new Integer(0);
				if(null == interestamount) interestamount= new BigDecimal(0);
				if(null == suminterest) suminterest = new BigDecimal(0);
				if(null == capitalamount) capitalamount = new BigDecimal(0);
				if(null == sumcapital) sumcapital = new BigDecimal(0);
				
				sqljob.addParameter(DateUtil.date2Str(issuedate,"yyyy/MM/dd"));
				sqljob.addParameter(DateUtil.date2Str(duedate,"yyyy/MM/dd"));
				sqljob.addParameter(issueamount);
				sqljob.addParameter(DateUtil.date2Str(paydates,"yyyy/MM/dd"));
				sqljob.addParameter(DateUtil.date2Str(paydatee,"yyyy/MM/dd"));
				sqljob.addParameter(rate.divide(new BigDecimal(100),5,5));
				sqljob.addParameter(days);
				sqljob.addParameter(interestamount.setScale(0,5));
				sqljob.addParameter(suminterest.setScale(0,5));
				sqljob.addParameter(capitalamount.setScale(0,5));
				sqljob.addParameter(sumcapital.setScale(0,5));
				
				issueamount = issueamount.subtract(capitalamount);
				
				session2.close();

			}
		
		}
		session.close();
		System.out.println(sqljob.toString());
		return sqljob;
	}
	public SQLJob insertOne(ActionForm form,String usrId,Integer debtId)
	{
		Cpra0201Form cpra0201form = (Cpra0201Form) form;
		SQLJob sqljob = new SQLJob();
		StringBuffer str = new StringBuffer();
		str.append("from PaymentMain pay where 1 = 1 ");
		if(null != debtId && 0 != debtId)
		{
			str.append(" and pay.plan.debt.id = ");
			str.append(debtId);
		}
		if(null != cpra0201form.getBankId() && 0 != cpra0201form.getBankId() )
		{
			str.append(" and pay.plan.debt.bank.id = ");
			str.append(cpra0201form.getBankId());
		}
		if(null != cpra0201form.getIssueId() && 0 != cpra0201form.getIssueId())
		{
			str.append(" and pay.plan.debt.issue.id = ");
			str.append(cpra0201form.getIssueId());
		}	
		str.append(" order by pay.repayDate ");
		Session session = new PaymentMainDAO().createNewSession();
		Query query = session.createQuery(str.toString());
		List list = query.list();
		
		BigDecimal tempBigDecimal = new BigDecimal(0);
		BigDecimal sumInterest = new BigDecimal(0);
		BigDecimal sumCapital = new BigDecimal(0);
		BigDecimal rate = new BigDecimal(0);
		Date paydates = null;
		Date paydatee = null;
		Boolean Tvalue = false;
		
		if(null != list && 0 != list.size())
		{
			for(Iterator it=list.iterator();it.hasNext();)
			{
				PaymentMain pay = (PaymentMain)it.next();
				
				sqljob.appendSQL("INSERT INTO CPRA02_RPT ");
				sqljob.appendSQL(" (USRID, MOD_DATE,Issue_date,Due_date,Issue_amount,Pay_dateS,Pay_dateE,Rate,days,Interest_amount,Sum_interest,Capital_amount,Sum_capital,remark)");
				sqljob.appendSQL("Values('" + usrId + "', CURRENT_TIMESTAMP ,?,?,?,?,?,?,?,?,?,?,?,null) ;");
				
				if(Tvalue == false)
				{	
					paydates = pay.getPlan().getDebt().getIssue().getIssueDate();
					tempBigDecimal = pay.getPlan().getDebt().getIssueAmount();
					Tvalue = true;
				}
				else
				{
					paydates = paydatee;
				}
				paydatee = pay.getPlan().getRepayDate();
				
				
				sumInterest = sumInterest.add(pay.getInterestAmount());
				sumCapital = sumCapital.add(pay.getCapitalAmount());
				
				/**
				 * 算年利率
				 */
				Session session2 = new DebtRateDetDAO().getSession();
				Criteria criteria2 = session2.createCriteria(DebtRateDet.class); 
				criteria2.add(Expression.eq("debt.id",pay.getPlan().getDebt().getId()));
				criteria2.add(Expression.eq("deleteMark","N"));
				criteria2.add(Expression.le("effectiveDate",paydates));
				criteria2.add(Expression.ge("suspendDate",paydates));
				List myRateList = criteria2.list();
				if(null != myRateList && 0 != myRateList.size())
				{	
					rate = ((DebtRateDet)myRateList.get(0)).getDebtRate();
				}
				sqljob.addParameter(pay.getPlan().getDebt().getIssue().getIssueDate());
				sqljob.addParameter(pay.getPlan().getDebt().getIssue().getDueDate());
				sqljob.addParameter(tempBigDecimal);
				sqljob.addParameter(pay.getStartDate());
				sqljob.addParameter(pay.getEndDate());
				sqljob.addParameter(rate.divide(new BigDecimal(100),5,5));
				sqljob.addParameter(pay.getInterestDays());
				sqljob.addParameter(pay.getInterestAmount());
				sqljob.addParameter(sumInterest);
				sqljob.addParameter(pay.getCapitalAmount());
				sqljob.addParameter(sumCapital);
				cpra0201form.setTempDecimal(tempBigDecimal);
				cpra0201form.setTempDate(pay.getRepayDate());
				tempBigDecimal = tempBigDecimal.subtract(pay.getPlan().getCapitalAmount());
			}
		}
		
		
		return sqljob;
	}


	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		Cpra0201Form myform = (Cpra0201Form)form;
		SQLJob debt = new SQLJob();
		SQLJob insertOne = new SQLJob();
		SQLJob sqljob = new SQLJob();
		SQLJob updjob = new SQLJob();
		debt.appendSQL("select id , isnull(issue_amount,0) as issue_amount from debt_main where 1 = 1");
		if(null != myform.getIssueId() && 0 != myform.getIssueId())
		{	
			debt.appendSQL("and issue_id = ? ");
			debt.addParameter(myform.getIssueId());
		}
		if(null != myform.getBankId() && 0 != myform.getBankId())
		{
			debt.appendSQL("and bank_id = ? ");
			debt.addParameter(myform.getBankId());
		}	
		List list = (List)run.query(debt,new MapListHandler());
		BigDecimal titleAmount = new BigDecimal(0);
		if(null != list && 0 != list.size())
		{	
			for(Iterator it= list.iterator();it.hasNext();)
			{	
				Map debtMain = (Map)it.next();
				
				insertOne = insertOne(form,usrId,(Integer)debtMain.get("id"));
				if(null != insertOne.getSQL() && !"".equals(insertOne.getSQL()))
				{	
					run.update(connection,insertOne);
				}	
				
				sqljob = insTemp(form,usrId,(Integer)debtMain.get("id"));
				if(null != sqljob.getSQL() && !"".equals(sqljob.getSQL()))
				{	
					run.update(connection,sqljob);
				}
				titleAmount = titleAmount.add((BigDecimal)debtMain.get("issue_amount"));
			}	
		}
		updjob.appendSQL("update CPRA02_RPT set title_amount = ? ");
		updjob.addParameter(titleAmount);
		run.update(connection,updjob);
	}


}
