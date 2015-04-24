/**
 * @author LinusTseng
 * @date 2006/3/8
 * 處理新增程式，並導向清單
 */

package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;

import tw.gov.nta.account.form.Eama0301Form;
import tw.gov.nta.account.form.Eamb0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;


public class EAMA0301 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Eamb0101Form myForm = (Eamb0101Form)form;

		IssueMainDAO dao = IssueMainDAO.getInstance();
		StringBuffer queryString = new StringBuffer();
		
		queryString.append(" from DebtMain d ");
		queryString.append(" where d.issue.debtType = :debtType ");
		
		if (null!=myForm.getAccountYear() && !"".equals(myForm.getAccountYear())) {
			queryString.append(" and d.issue.accountYear = '"+myForm.getAccountYear()+"'");
		}
		
		if (myForm.getBudgetCode()!=null && !myForm.getBudgetCode().equals(0)) {
			queryString.append(" and d.budgetCode = "+myForm.getBudgetCode());
		}
		
		if (myForm.getDebtCode() != null && !myForm.getDebtCode().equals(0)) {
			queryString.append(" and d.debtCode = "+myForm.getDebtCode());
		}
		
		if (null!=myForm.getDebtName() && !"".equals(myForm.getDebtName())) {
			queryString.append(" and d.debtCode like '%"+myForm.getDebtName()+"%'");
		}

		
		if (null!=myForm.getIssueKind() && !"".equals(myForm.getIssueKind())) {
			queryString.append(" and d.issueKind = '"+myForm.getIssueKind().trim()+"'");
		
		}

		try {
			if (null!=myForm.getStartIssueDate() && !"".equals(myForm.getStartIssueDate())) {
				Date startIssueDate = DateUtil.str2Date(myForm.getStartIssueDate());
				if (startIssueDate == null)
					throw new Exception("發行開始日期有誤");
				
				queryString.append(" and d.issue.issueDate >= '" + DateUtil.date2Str(startIssueDate,"yyyy/MM/dd") +"'");
			}

			if (null!=myForm.getEndIssueDate() && !"".equals(myForm.getEndIssueDate())) {
				Date endIssueDate = DateUtil.str2Date(myForm.getEndIssueDate());
				if (endIssueDate == null)
					throw new Exception("發行結束日期有誤");

				queryString.append(" and d.issue.issueDate <= '" + DateUtil.date2Str(endIssueDate,"yyyy/MM/dd") +"'");
			}
			
			if (null!=myForm.getStartDueDate() && !"".equals(myForm.getStartDueDate())) {
				Date startDueDate = DateUtil.str2Date(myForm.getStartDueDate());
				if (startDueDate == null)
					throw new Exception("到期開始日期有誤");

				queryString.append(" and d.issue.dueDate >= '" + DateUtil.date2Str(startDueDate,"yyyy/MM/dd") +"'");
			}
			
			if (null!=myForm.getEndDueDate() && !"".equals(myForm.getEndDueDate())) {
				Date endDueDate = DateUtil.str2Date(myForm.getEndDueDate());
				if (endDueDate == null)
					throw new Exception("到期結束日期有誤");

				queryString.append(" and d.issue.dueDate <= '" + DateUtil.date2Str(endDueDate,"yyyy/MM/dd") +"'");
			}
			
			
			queryString.append(" order by d.issue.issueSerial,d.issue.issueDate,d.budgetCode,d.debtCode");
			List<Eama0301Form> collection = new ArrayList<Eama0301Form>();
			
//			System.out.println(queryString.toString());
			Query query = dao.getSession().createQuery(queryString.toString());
			
			query.setString("debtType","A");
			
			List debtList = query.list();
			
			for(Iterator iterator=debtList.iterator();iterator.hasNext();){
				Eama0301Form myform = new Eama0301Form();
				myform.setDebtMain((DebtMain)iterator.next());
				collection.add(myform);
			}
			
			request.setAttribute("collection",collection);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			setAlertMessage(request,ex.getMessage());
		}
		

	}


}
