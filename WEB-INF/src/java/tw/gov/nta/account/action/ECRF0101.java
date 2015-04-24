package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.DebtRateDetDAO;
 
public class ECRF0101 extends DefaultAction {
	

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM ECRF01_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	public SQLJob insTemp(ActionForm form,String usrId)
	{
		SQLJob sqljob = new SQLJob();
		AccountQueryForm myform = (AccountQueryForm)form;
		Session session = DebtRateDetDAO.getInstance().getSession();
		StringBuffer queryString = new StringBuffer();
		String tempString = new String();
		
		int i = 0;
		
	
		queryString.append("from IssueMain issue where issue.debtType = 'C' and issue.id <> 3471 ");
		
		if(null != myform.getReportType() && "依年度".equals(myform.getReportType()))
		{
			if(null != myform.getIssueYear() && !"".equals(myform.getIssueYear()))
			{	
				queryString.append(" and issue.accountYear = :accountYear ");
			}	
		}
		else if(null != myform.getReportType() && "依期別".equals(myform.getReportType()))
		{
			if(0 != myform.getIssueId())
			{
				queryString.append(" and issue.id = :issueId ");
			}
		}	
		
		queryString.append(" order by issue.accountYear,issue.serialNo ");
		Query issueQuery = session.createQuery(queryString.toString());
		
		if(null != myform.getReportType() && "依年度".equals(myform.getReportType()))
		{
			if(null != myform.getIssueYear() && !"".equals(myform.getIssueYear()))
			{	
				issueQuery.setParameter("accountYear",myform.getIssueYear());
			}	
		}
		else if(null != myform.getReportType() && "依期別".equals(myform.getReportType()))
		{
			if(0 != myform.getIssueId())
			{
				issueQuery.setParameter("issueId",myform.getIssueId());
			}
		}
		
		List issueList = issueQuery.list();
		int rowNum = 1 ;
		
		for(Iterator issueIterator = issueList.iterator();issueIterator.hasNext();) {
			IssueMain issue = (IssueMain)issueIterator.next();
			i = i+1;
			BigDecimal totalIssueAmount = new BigDecimal(0);
			BigDecimal totalCapitalAmountA= new BigDecimal(0);
			BigDecimal totalCapitalAmountB= new BigDecimal(0);
			BigDecimal totalCapitalAmountT= new BigDecimal(0);
			BigDecimal totalInterestAmountA= new BigDecimal(0);
			BigDecimal totalInterestAmountB= new BigDecimal(0);
			BigDecimal totalInterestAmountT= new BigDecimal(0);
			if (issue.getAccountYear()=="095" && issue.getSerialNo()=="09"){
				System.out.println("test");
			}
			queryString = new StringBuffer();
			queryString.append("from DebtMain debt where debt.issue =:issue and debt.budgetCode <> 0 and debt.debtCode <> 35 and debt.accrue = 'Y' ");
			queryString.append(" order by debt.id ");
			Query debtQuery = session.createQuery(queryString.toString());
			debtQuery.setParameter("issue",issue);
			List debtList = debtQuery.list();
			

			for(Iterator iterator = debtList.iterator();iterator.hasNext();) {
				
				

				DebtMain debt = (DebtMain)iterator.next();
				queryString = new StringBuffer();
				queryString.append("from DebtRateDet rate where rate.debt = :debt and rate.deleteMark = 'N'  ");
				queryString.append(" order by rate.effectiveDate ");
				Query rateQuery = session.createQuery(queryString.toString());
				rateQuery.setParameter("debt",debt);				
				List rateList = rateQuery.list();
				
				if(debt.getId().equals(5824))
					System.out.println("95-01");
				
				String bankName = new String();
				if(!bankName.equals(debt.getBank().getBankName()) )
				{	
					int day1 = Integer.parseInt(DateUtil.date2ROCStr(issue.getIssueDate()).substring(5,7),10);
					int day2 = Integer.parseInt(DateUtil.date2ROCStr(issue.getDueDate()).substring(5,7),10);
					sqljob.appendSQL(" insert into ECRF01_RPT (group_serial,issue_serial,limit_year,issue_date," +
							"due_date,bank_name,issue_amount,repay_date,debt_rate,capital_amountA,capital_amountB,capital_amountT" +
							",interest_amountA,interest_amountB,interest_amountT,remark ) values( ");
					sqljob.appendSQL("'"+issue.getIssueSerial()+"'");
					sqljob.appendSQL(",");
					sqljob.appendSQL(1!=rowNum?"null":"'"+issue.getIssueSerial()+"期'");
					sqljob.appendSQL(",");
					if(day1==day2){
						sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.daycount(issue.getIssueDate(),issue.getDueDate(),"D")+"'");
					}
					else{
						sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.daycount(issue.getIssueDate(),issue.getDueDate(),"F")+"'");
					}
					//sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.daycount(issue.getIssueDate(),issue.getDueDate(),"D")+"'");
					sqljob.appendSQL(",");
					sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.date2Str(issue.getIssueDate(),"yyyy/mm/dd")+"'");
					sqljob.appendSQL(",");
					sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.date2Str(issue.getDueDate(),"yyyy/mm/dd")+"'");
					sqljob.appendSQL(",");
					sqljob.appendSQL("'"+debt.getBank().getBankName()+"'");
					sqljob.appendSQL(",");
					sqljob.appendSQL(debt.getIssueAmount().toString());
					sqljob.appendSQL(",");
					sqljob.appendSQL("'"+DateUtil.date2Str(issue.getIssueDate(),"yyyy/mm/dd")+"'");
					sqljob.appendSQL(",");
					sqljob.appendSQL(debt.getCompareRate().divide(new BigDecimal(100)).toString());
					sqljob.appendSQL(",");
					sqljob.appendSQL("null");
					sqljob.appendSQL(",");
					sqljob.appendSQL("null");
					sqljob.appendSQL(",");
					sqljob.appendSQL("null");
					sqljob.appendSQL(",");
					sqljob.appendSQL("null");
					sqljob.appendSQL(",");
					sqljob.appendSQL("null");
					sqljob.appendSQL(",");
					sqljob.appendSQL("null");
					sqljob.appendSQL(",");
					sqljob.appendSQL("'"+i+"'");
					sqljob.appendSQL(") ");
					rowNum = rowNum + 1 ; 
					bankName = debt.getBank().getBankName();
				}	
				
				
				for(Iterator rateIterator = rateList.iterator();rateIterator.hasNext();) {
					
					DebtRateDet rateDet = (DebtRateDet)rateIterator.next();
					queryString = new StringBuffer();
					queryString.append("from PaymentMain payment where payment.plan.debt = :debt and payment.repayDate between :effectDate and :suspendDate  ");
					queryString.append(" order by payment.repayDate ");
					Query paymentQuery = session.createQuery(queryString.toString());			
					paymentQuery.setParameter("debt",debt);
					paymentQuery.setParameter("effectDate",rateDet.getEffectiveDate());
					paymentQuery.setParameter("suspendDate",rateDet.getSuspendDate());
					List paymentList = paymentQuery.list();
					
					BigDecimal debtRate= new BigDecimal(0);
					
					//抓取未還本的資料
//					if(paymentList.size()==0){
//						sqljob.appendSQL(" insert into ECRF01_RPT (group_serial,issue_serial,limit_year,issue_date," +
//								"due_date,bank_name,issue_amount,repay_date,debt_rate,capital_amountA,capital_amountB,capital_amountT" +
//								",interest_amountA,interest_amountB,interest_amountT,remark ) values( ");
//						sqljob.appendSQL("'"+issue.getIssueSerial()+"'");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL(1!=rowNum?"null":"'"+issue.getIssueSerial()+"期'");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.daycount(issue.getIssueDate(),issue.getDueDate(),"D")+"'");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.date2Str(issue.getIssueDate(),"yyyy/mm/dd")+"'");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.date2Str(issue.getDueDate(),"yyyy/mm/dd")+"'");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL("'"+debt.getBank().getBankName()+"'");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL(debt.getIssueAmount().toString());
//						sqljob.appendSQL(",");
//						sqljob.appendSQL("'"+DateUtil.date2Str(issue.getIssueDate(),"yyyy/mm/dd")+"'");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL(debt.getCompareRate().divide(new BigDecimal(100)).toString());
//						sqljob.appendSQL(",");
//						sqljob.appendSQL("null");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL("null");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL("null");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL("null");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL("null");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL("null");
//						sqljob.appendSQL(",");
//						sqljob.appendSQL("'"+i+"'");
//						sqljob.appendSQL(") ");
//					}
						
					
						
					
					for(Iterator paymentIterator = paymentList.iterator();paymentIterator.hasNext();) {				
						
						i = i+1;
						
						PaymentMain payment = (PaymentMain)paymentIterator.next();
						DebtPlanDet plan = payment.getPlan();
						sqljob.appendSQL(" insert into ECRF01_RPT (group_serial,issue_serial,limit_year,issue_date," +
								"due_date,bank_name,issue_amount,repay_date,debt_rate,capital_amountA,capital_amountB,capital_amountT" +
								",interest_amountA,interest_amountB,interest_amountT,remark ) values( ");

						if(!bankName.equals(plan.getDebt().getBank().getBankName()) )
						{	
							/*
							if (rowNum>2){
								sqljob.appendSQL("'"+issue.getIssueSerial()+"'");
								sqljob.appendSQL(",");
								sqljob.appendSQL(1!=rowNum?"null":"'"+issue.getIssueSerial()+"期'");
								sqljob.appendSQL(",");
								sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.daycount(issue.getIssueDate(),issue.getDueDate(),"D")+"'");
								sqljob.appendSQL(",");
								sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.date2Str(issue.getIssueDate(),"yyyy/mm/dd")+"'");
								sqljob.appendSQL(",");
								sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.date2Str(issue.getDueDate(),"yyyy/mm/dd")+"'");
								sqljob.appendSQL(",");
								sqljob.appendSQL("'"+debt.getBank().getBankName()+"'");
								sqljob.appendSQL(",");
								sqljob.appendSQL(debt.getIssueAmount().toString());
								sqljob.appendSQL(",");
								sqljob.appendSQL("'"+DateUtil.date2Str(issue.getIssueDate(),"yyyy/mm/dd")+"'");
								sqljob.appendSQL(",");
								sqljob.appendSQL(debt.getCompareRate().divide(new BigDecimal(100)).toString());
								sqljob.appendSQL(",");
								sqljob.appendSQL("null");
								sqljob.appendSQL(",");
								sqljob.appendSQL("null");
								sqljob.appendSQL(",");
								sqljob.appendSQL("null");
								sqljob.appendSQL(",");
								sqljob.appendSQL("null");
								sqljob.appendSQL(",");
								sqljob.appendSQL("null");
								sqljob.appendSQL(",");
								sqljob.appendSQL("null");
								sqljob.appendSQL(",");
								sqljob.appendSQL("'"+i+"'");
								sqljob.appendSQL(") ");
							}
							sqljob.appendSQL(" insert into ECRF01_RPT (group_serial,issue_serial,limit_year,issue_date," +
									"due_date,bank_name,issue_amount,repay_date,debt_rate,capital_amountA,capital_amountB,capital_amountT" +
									",interest_amountA,interest_amountB,interest_amountT,remark ) values( ");
							
							
							rowNum = rowNum + 1 ; 
							bankName = plan.getDebt().getBank().getBankName();
							*/
						}	
						if(1==rowNum)
						{
							tempString = plan.getDebt().getIssue().getIssueSerial();
						}	
						if(!tempString.equals(plan.getDebt().getIssue().getIssueSerial()) && null != plan.getDebt().getIssue().getIssueSerial() && !"".equals(plan.getDebt().getIssue().getIssueSerial()))
						{
							tempString = plan.getDebt().getIssue().getIssueSerial();
						}
						//0.塞入issue.grooupSerial    
						sqljob.appendSQL("'"+plan.getDebt().getIssue().getIssueSerial()+"'");
						sqljob.appendSQL(",");
						//1.塞入issue.issueSerial    第一筆塞 其他不用
						sqljob.appendSQL(1!=rowNum?"null":"'"+tempString+"'");
						sqljob.appendSQL(",");
						//2.塞入issue.dueDate.getYear - issue.issueDate.getYear 的年  第一筆塞 其他不用
						sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.daycount(plan.getDebt().getIssue().getIssueDate(),plan.getDebt().getIssue().getDueDate(),"D")+"'");
						sqljob.appendSQL(",");
						//3.塞入issue.issueDate		第一筆塞 其他不用
						sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.date2Str(plan.getDebt().getIssue().getIssueDate(),"yyyy/mm/dd")+"'");
						sqljob.appendSQL(",");
						//4.塞入issue.dueDate		第一筆塞 其他不用
						sqljob.appendSQL(1!=rowNum?"null":"'"+DateUtil.date2Str(plan.getDebt().getIssue().getDueDate(),"yyyy/mm/dd")+"'");
						sqljob.appendSQL(",");
						//5.塞入debt.bankId 至bankRef抓bankName 第一筆塞 其他不用
						sqljob.appendSQL(bankName.equals(plan.getDebt().getBank().getBankName())?"null":"'"+plan.getDebt().getBank().getBankName()+"'");
						sqljob.appendSQL(",");
						//6.塞入debt.issueAmount				第一筆塞 其他不用
						sqljob.appendSQL(bankName.equals(plan.getDebt().getBank().getBankName())?"null":plan.getDebt().getIssueAmount().toString());
						sqljob.appendSQL(",");
						//7.塞入payment.repayDate
						sqljob.appendSQL("'"+DateUtil.date2Str(payment.getRepayDate(),"yyyy/mm/dd")+"'");
						sqljob.appendSQL(",");
						//8.塞入rate.debtRate		跟上一個一樣時不塞
						sqljob.appendSQL(debtRate.equals(rateDet.getDebtRate())?"null":rateDet.getDebtRate().divide(new BigDecimal(100)).toString());
						sqljob.appendSQL(",");
						debtRate = rateDet.getDebtRate();
						//9.如果payment.capitalAmount > 0 && payment.repayDate >= plan.repayDate 塞入 payment.capitalAmount
						sqljob.appendSQL(((1==payment.getCapitalAmount().compareTo(new BigDecimal(0))) && (payment.getRepayDate().after(plan.getRepayDate())) || payment.getRepayDate().equals(plan.getRepayDate()))?payment.getCapitalAmount().toString():"null");
						sqljob.appendSQL(",");
						//10.如果payment.capitalAmount > 0 && payment.repayDate < plan.repayDate 塞入 payment.capitalAmount
						sqljob.appendSQL(((1==payment.getCapitalAmount().compareTo(new BigDecimal(0))) && payment.getRepayDate().before(plan.getRepayDate()))?payment.getCapitalAmount().toString():"null");
						sqljob.appendSQL(",");
						//11.該debt的累積還本金額(9 + 10)
						sqljob.appendSQL((((1==payment.getCapitalAmount().compareTo(new BigDecimal(0))) && (payment.getRepayDate().after(plan.getRepayDate())) || payment.getRepayDate().equals(plan.getRepayDate()))?payment.getCapitalAmount():new BigDecimal(0)
								.add(((1==payment.getCapitalAmount().compareTo(new BigDecimal(0))) && payment.getRepayDate().before(plan.getRepayDate()))?payment.getCapitalAmount():new BigDecimal(0))).toString());
						sqljob.appendSQL(",");
						//12.如果payment.interestAmount > 0 && payment.repayDate >= plan.repayDate 塞入 payment.interestAmount
						sqljob.appendSQL(((1==payment.getInterestAmount().compareTo(new BigDecimal(0))) && (payment.getRepayDate().after(plan.getRepayDate())) || payment.getRepayDate().equals(plan.getRepayDate()))?payment.getInterestAmount().toString():"null");
						sqljob.appendSQL(",");
						//13.如果payment.interestAmount > 0 && payment.repayDate < plan.repayDate 塞入 payment.interestAmount
						sqljob.appendSQL(((1==payment.getInterestAmount().compareTo(new BigDecimal(0))) && payment.getRepayDate().before(plan.getRepayDate()))?payment.getInterestAmount().toString():"null");
						sqljob.appendSQL(",");
						//14.該debt的累積還本金額(12 + 13)
						sqljob.appendSQL((((1==payment.getInterestAmount().compareTo(new BigDecimal(0))) && (payment.getRepayDate().after(plan.getRepayDate())) || payment.getRepayDate().equals(plan.getRepayDate()))?payment.getInterestAmount():new BigDecimal(0)
								.add(((1==payment.getInterestAmount().compareTo(new BigDecimal(0))) && payment.getRepayDate().before(plan.getRepayDate()))?payment.getInterestAmount():new BigDecimal(0))).toString());
						sqljob.appendSQL(",");
						//備註塞0
						sqljob.appendSQL("'"+i+"'");
						sqljob.appendSQL(")");
						   
						//------------
						//9.如果payment.capitalAmount > 0 && payment.repayDate >= plan.repayDate 累計到期還本數
						if((1==payment.getCapitalAmount().compareTo(new BigDecimal(0))) && 
								(payment.getRepayDate().after(plan.getRepayDate())) || 
								payment.getRepayDate().equals(plan.getRepayDate()))
							totalCapitalAmountA = totalCapitalAmountA.add(payment.getCapitalAmount());
						else
							totalCapitalAmountA = totalCapitalAmountA.add(new BigDecimal(0));
						

						//10.如果payment.capitalAmount > 0 && payment.repayDate < plan.repayDate 塞入 payment.capitalAmount
						if((1==payment.getCapitalAmount().compareTo(new BigDecimal(0))) && payment.getRepayDate().before(plan.getRepayDate()))
							totalCapitalAmountB = totalCapitalAmountB.add(payment.getCapitalAmount());
						else
							totalCapitalAmountB = totalCapitalAmountB.add(new BigDecimal(0));


						//11.該debt的累積還本金額(9 + 10)
						totalCapitalAmountT = totalCapitalAmountA.add(totalCapitalAmountB);
						

						//12.如果payment.interestAmount > 0 && payment.repayDate >= plan.repayDate 塞入 payment.interestAmount
						if((1==payment.getInterestAmount().compareTo(new BigDecimal(0))) && 
								(payment.getRepayDate().after(plan.getRepayDate())) || 
								payment.getRepayDate().equals(plan.getRepayDate()))
							totalInterestAmountA = totalInterestAmountA.add(payment.getInterestAmount());
						else
							totalInterestAmountA = totalInterestAmountA.add(new BigDecimal(0));
						//sqljob.appendSQL(((1==payment.getInterestAmount().compareTo(new BigDecimal(0))) && (payment.getRepayDate().after(plan.getRepayDate())) || payment.getRepayDate().equals(plan.getRepayDate()))?payment.getInterestAmount().toString():"null");
		
						//13.如果payment.interestAmount > 0 && payment.repayDate < plan.repayDate 塞入 payment.interestAmount
						if((1==payment.getInterestAmount().compareTo(new BigDecimal(0))) && payment.getRepayDate().before(plan.getRepayDate()))
							totalInterestAmountB = totalInterestAmountB.add(payment.getInterestAmount());
						else
							totalInterestAmountB = totalInterestAmountB.add(new BigDecimal(0));
						//sqljob.appendSQL(((1==payment.getInterestAmount().compareTo(new BigDecimal(0))) && payment.getRepayDate().before(plan.getRepayDate()))?payment.getInterestAmount().toString():"null");
			
						//14.該debt的累積還本金額(12 + 13)
						totalInterestAmountT = totalInterestAmountA.add(totalInterestAmountB);
						//sqljob.appendSQL((((1==payment.getInterestAmount().compareTo(new BigDecimal(0))) && (payment.getRepayDate().after(plan.getRepayDate())) || payment.getRepayDate().equals(plan.getRepayDate()))?payment.getInterestAmount():new BigDecimal(0)
						//		.add(((1==payment.getInterestAmount().compareTo(new BigDecimal(0))) && payment.getRepayDate().before(plan.getRepayDate()))?payment.getInterestAmount():new BigDecimal(0))).toString());
						
						
						
						//------------
					}
					
				}
				
				//合計中長借每期舉借金額
				totalIssueAmount = totalIssueAmount.add(debt.getIssueAmount());


			}
			//塞issue的合計
			rowNum = 1 ;
			
			sqljob.appendSQL(" insert into ECRF01_RPT (group_serial,issue_serial,limit_year,issue_date," +
					"due_date,bank_name,issue_amount,repay_date,debt_rate,capital_amountA,capital_amountB,capital_amountT" +
					",interest_amountA,interest_amountB,interest_amountT,remark ) values( ");
				sqljob.appendSQL(""+issue.getIssueSerial()+"");
				sqljob.appendSQL(",");
				sqljob.appendSQL("'"+issue.getIssueSerial()+"期合計'");
				sqljob.appendSQL(",");
				sqljob.appendSQL("null");
				sqljob.appendSQL(",");
				sqljob.appendSQL("null");
				sqljob.appendSQL(",");
				sqljob.appendSQL("null");
				sqljob.appendSQL(",");
				sqljob.appendSQL("null");
				sqljob.appendSQL(",");
				sqljob.appendSQL(totalIssueAmount.toString());
				sqljob.appendSQL(",");
				sqljob.appendSQL("null");
				sqljob.appendSQL(",");
				sqljob.appendSQL("null");
				sqljob.appendSQL(",");
				sqljob.appendSQL(totalCapitalAmountA.toString());
				sqljob.appendSQL(",");
				sqljob.appendSQL(totalCapitalAmountB.toString());
				sqljob.appendSQL(",");
				sqljob.appendSQL(totalCapitalAmountT.toString());
				sqljob.appendSQL(",");
				sqljob.appendSQL(totalInterestAmountA.toString());
				sqljob.appendSQL(",");
				sqljob.appendSQL(totalInterestAmountB.toString());
				sqljob.appendSQL(",");
				sqljob.appendSQL(totalInterestAmountT.toString());
				sqljob.appendSQL(",");
				sqljob.appendSQL("'"+i+"'");
				sqljob.appendSQL(") ");
			
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
		SQLJob sqljob = new SQLJob();
		sqljob = insTemp(form,usrId);
		if(null != sqljob.getSQL() && !"".equals(sqljob.getSQL()) && !"null".equals(sqljob.getSQL()))
		{	
			run.update(connection,insTemp(form,usrId));
		}

	}


}
