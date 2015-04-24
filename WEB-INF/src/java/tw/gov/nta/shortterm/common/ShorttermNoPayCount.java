package tw.gov.nta.shortterm.common;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.debt.dao.DebtMainDAO;

public class ShorttermNoPayCount {
	
	/**
	 * 
	 * @param startDate 計算開始日期
	 * @param endDate 計算結束日期
	 * @param accountYearStart 發行年度起
	 * @param accountYearEnd 發行年度迄
	 * @param type 1 = 短借全部未償餘額
	 * 			   2 = 國庫(排除債務基金及民營化基金)
	 *             3 = 民營化基金(debt_code = 25) 
	 *             4 = 債務基金 (budget_code = 3 || budget_code = 4 && debt_code = 61)
	 * @return
	 */
	private BigDecimal getNoPayAmount( String accountYearStart , String accountYearEnd ,
			Date startDate , Date endDate ,String type){
		Session session = new DebtMainDAO().getSession();
		
		String typeA = "  1=1";
		String typeB = "  #table#.debtCode <>  25 and #table#.debtCode <> 61 and #table#.budgetCode <> 3";
		String typeC = "  #table#.debtCode = 25 and #table#.budgetCode = 4";
		String typeD = "  #table#.budgetCode = 3  or (#table#.budgetCode = 4 and #table#.debtCode = 61 )";
		String[] typeArray = {typeA,typeB,typeC,typeD};
		StringBuffer hqlStr = new StringBuffer();
		//取得所有短借借款總額
		hqlStr.append("select isNull(sum(debt.issueAmount),0) from DebtMain debt where 1=1 \n");
		hqlStr.append(" and debt.issue.debtType ='D' \n");
		if(accountYearStart != null && !accountYearStart.equals(""))
			hqlStr.append(" and debt.issue.accountYear >= :accountYearStart \n");
		if(accountYearEnd != null && !accountYearEnd.equals(""))
			hqlStr.append(" and debt.issue.accountYear <= :accountYearEnd \n");
//		hqlStr.append(" and debt.accrue ='Y' \n");
//		hqlStr.append(" and debt.get = 'Y' \n");
		//依照輸入借款形式取得相關預算債務別
		hqlStr.append(" and "+ typeArray[Integer.parseInt(type)-1].replace("#table#", "debt.issue"));
		if(startDate != null )
			hqlStr.append(" and debt.issue.issueDate >=:startDate \n");
		if(endDate != null )
			hqlStr.append(" and debt.issue.dueDate <=:endDate \n");
		Query query = session.createQuery(hqlStr.toString());
		if(accountYearStart != null && !accountYearStart.equals(""))
			query.setParameter("accountYearStart", accountYearStart);
		if(accountYearEnd != null &&!accountYearEnd.equals(""))
			query.setParameter("accountYearEnd", accountYearEnd);
		if(startDate != null)
			query.setParameter("startDate", startDate);
		if(endDate != null)
			query.setParameter("endDate", endDate);
		
		BigDecimal totalIssueAmount = (BigDecimal)query.list().get(0);

		
		//取得所有已償金額
		hqlStr = new StringBuffer();
		hqlStr.append("select isNull(sum(pay.capitalAmount),0) from PaymentMain pay where 1=1 \n");
		hqlStr.append(" and pay.plan.debt.issue.debtType ='D' \n");
		if(accountYearStart != null && !accountYearStart.equals(""))
			hqlStr.append(" and pay.plan.debt.issue.accountYear >= :accountYearStart \n");
		if(accountYearEnd != null && !accountYearEnd.equals(""))
			hqlStr.append(" and pay.plan.debt.issue.accountYear <= :accountYearEnd \n");
//		hqlStr.append(" and pay.plan.debt.accrue ='Y' \n");
//		hqlStr.append("and pay.plan.debt.get = 'Y' \n");
		hqlStr.append("and pay.plan.deleteMark = 'N'");
		//依照輸入借款形式取得相關預算債務別
		hqlStr.append(" and "+ typeArray[Integer.parseInt(type)-1].replace("#table#", "pay.plan.debt.issue"));
		if(startDate != null)
			hqlStr.append(" and pay.plan.debt.issue.issueDate >=:startDate \n");
		if(endDate != null)
			hqlStr.append(" and pay.plan.debt.issue.dueDate <=:endDate \n");
		query = session.createQuery(hqlStr.toString());
		if(accountYearStart != null && !accountYearStart.equals(""))
			query.setParameter("accountYearStart", accountYearStart);
		if(accountYearEnd != null && !accountYearEnd.equals(""))
			query.setParameter("accountYearEnd", accountYearEnd);
		if(startDate != null)
			query.setParameter("startDate", startDate);
		if(endDate != null)
			query.setParameter("endDate", endDate);
		
		BigDecimal totalCapitalAmount = (BigDecimal)query.list().get(0);

		/**
		* Date dueDate = DateUtil.date2ChineseROC2(new Date());
		* SQLJob sqljob = new SQLJob();
		* sqljob.appendSQL(" select isNull((sum(issue_amount)- ");
		* sqljob.appendSQL("isNull((select sum(capital_amount) from payment_main where issue_id in");
		* sqljob.appendSQL(" (select id from issue_main where due_date > '"+DateUtil.date2Str(new Date())+"' and debt_type='d'"+typeArray[Integer.parseInt(type)-1]+")),0)),0) as noPayAmount");
		* sqljob.appendSQL(" from issue_main i");
		* sqljob.appendSQL(" where  i.debt_type = 'd'"+);
		* sqljob.appendSQL(" and i.due_date > '"+DateUtil.date2Str(new Date())+"'");
		* sqljob.appendSQL("and BUDGET_YEAR <> 'Y' ");
		* if(accountYearStart!=null && !"".equals(accountYearStart))
		*	sqljob.appendSQL("AND ACCOUNT_YEAR >= '"+accountYearStart+"'");
		* if(accountYearEnd!=null && !"".equals(accountYearEnd))
		* 	sqljob.appendSQL("AND ACCOUNT_YEAR <= '"+accountYearEnd+"'");
		* if(startDate != null)
		* 	sqljob.appendSQL("AND ISSUE_DATE >='"+startDate+"'");
		* if(endDate != null)
		*	sqljob.appendSQL("AND ISSUE_DATE <= '"+endDate+"'");
		* System.out.println(sqljob.toString());
		*/
		return totalIssueAmount.subtract(totalCapitalAmount);
	}
	public BigDecimal noPayAmount(String type) throws SQLException{
		return noPayAmount(null , null , null , null , type);
	}
	public BigDecimal noPayAmount() throws SQLException{
		return noPayAmount(null , null , null , null , "1");
	}
	public BigDecimal noPayAmount(String accountYearStart , String accountYearEnd) throws SQLException{
		return noPayAmount(accountYearStart , accountYearEnd , null , null , "1");
	}
	public BigDecimal noPayAmount(String accountYearStart , String accountYearEnd , String type) throws SQLException{
		return noPayAmount(accountYearStart , accountYearEnd , null , null , type);
	}
	public BigDecimal noPayAmount(String accountYearStart , String accountYearEnd ,
			Date startDate , Date endDate ,String type) throws SQLException{
		BigDecimal noPayAmount = new BigDecimal(0);
		noPayAmount = (BigDecimal)getNoPayAmount(accountYearStart,accountYearEnd,startDate,endDate,type);
		return noPayAmount;
	}
}
