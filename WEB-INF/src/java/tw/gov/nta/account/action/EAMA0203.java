/*
 * �b 2006/2/22 �إ�
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

import tw.gov.nta.account.form.Eama0201Form;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.dao.DebtTypeRefDAO;


/**
 * @author AndrewSung
 */
public class EAMA0203 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    }
	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.AuthQueryAction#initialize(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void initialize(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.initialize(mapping, form, request, response);
		String parameter = mapping.getParameter();
		HttpSession session = request.getSession();
		session.setAttribute("SYSID",parameter);
		String debtTypeCode = String.valueOf(parameter.charAt(1));
		DebtTypeRefDAO dao = DebtTypeRefDAO.getInstance();
		Criteria criteria = dao.getSession().createCriteria(DebtTypeRef.class);
		criteria.add(Expression.eq("typeCode",debtTypeCode));
		DebtTypeRef debtType = (DebtTypeRef)criteria.list().get(0);
		session.setAttribute("debtType",debtType);
		session.setAttribute("debtTypeId",debtType.getId());
		Eama0201Form myform = (Eama0201Form)form;
		myform.setDebtType(debtType);
	}
}
