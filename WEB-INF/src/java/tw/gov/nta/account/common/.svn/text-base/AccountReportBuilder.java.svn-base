/**
 * @author Andrew Sung
 * @create 2006/4/25
 */

package tw.gov.nta.account.common;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import tw.gov.nta.sql.account.AccountReportBuild;
import tw.gov.nta.sql.account.dao.AccountReportBuildDAO;


public class AccountReportBuilder
{
	public List getReportAffiliated(String pDebtType){
		Session tSession = new AccountReportBuildDAO().getSession();
		Criteria criteria = tSession.createCriteria(AccountReportBuild.class);
		if(pDebtType != null && "".equals(pDebtType))
			criteria.add(Expression.eq("debtType",pDebtType));
		criteria.addOrder(Order.asc("sequence"));
		List tResultList = criteria.list();
		tSession.close();
		return tResultList;
	}
	
	public void printMonthReport(String pDebtType, String pYear, String pMonth, Integer pBudget, Integer pDebtCode){
		List printList = getReportAffiliated(pDebtType);
		for(Iterator it=printList.iterator();it.hasNext();){
			AccountReportBuilder dto = (AccountReportBuilder)it.next();
			if (dto != null){
				
			}
		}
	}
	
	public void printMonthReport(String pDebtType, String pYear, String pMonth){this.printMonthReport(pDebtType,pYear,pMonth,0,0);}
}
























