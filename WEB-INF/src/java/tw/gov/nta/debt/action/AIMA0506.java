/**
*
* @author Andrew Sung
* @createDate 2006/6/23
*/
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.debt.form.Aima0501Form;
import tw.gov.nta.sql.debt.IssueExgpriceDet;
import tw.gov.nta.sql.debt.dao.IssueExgpriceDetDAO;

public class AIMA0506 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Aima0501Form myForm = (Aima0501Form)form;
		Session tSession = new IssueExgpriceDetDAO().getSession();
		Criteria criteria = tSession.createCriteria(IssueExgpriceDet.class);
//		if(myForm.getId() != 0)
//			criteria.add(Expression.eq("id", myForm.getId()));
		if(myForm.getIssueId()!= 0)
			criteria.add(Expression.eq("issue.id", myForm.getIssueId()));
		List list = criteria.list();
		tSession.close();
		request.setAttribute("collection",list);
	}
}
