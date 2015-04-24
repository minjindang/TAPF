/**
 * @author LinusTseng
 * @date 2006/3/8
 * 處理新增程式，並導向清單
 */

package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.account.form.Ebrd0101Form;

/**
 * 到查詢
 * @author Administrator
 *
 */
public class EBRD0101 extends DefaultAction
{

	@Override
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
		String debtType = String.valueOf(parameter.charAt(1));
		HttpSession session = request.getSession();
		session.setAttribute("SYSID",parameter);
		session.setAttribute("DEBTTYPE",debtType);
		((Ebrd0101Form)form).setDebtType(debtType);

	}


}
