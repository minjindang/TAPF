package tw.gov.nta.surplusage.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.dao.DebtTypeRefDAO;

import gov.dnt.tame.common.DefaultAction;

public class SetGaraNotePathAction extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
	}

	public void initialize(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.initialize(mapping, form, request, response);
		String parameter = mapping.getParameter();
		HttpSession session = request.getSession();
		request.setAttribute("PATH",parameter);
	}
}
