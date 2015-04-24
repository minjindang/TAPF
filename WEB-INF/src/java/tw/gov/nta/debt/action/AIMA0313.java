/**
*
* @author Andrew Sung
* @createDate 2006/6/22
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

import tw.gov.nta.debt.form.Aima0301AForm;
import tw.gov.nta.sql.debt.IssueExgpriceDet;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;

public class AIMA0313 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Aima0301AForm myForm = (Aima0301AForm) form;
		Session tSession = new DebtMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(IssueExgpriceDet.class);
		criteria.add(Expression.eq("issue.id", myForm.getIssueMainId()));
		List tResult = criteria.list();
		tSession.close();
		request.setAttribute("collection", tResult);
	}

}
