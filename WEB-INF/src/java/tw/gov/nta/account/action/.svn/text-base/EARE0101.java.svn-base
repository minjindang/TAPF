package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.account.form.AccountQueryForm;

public class EARE0101 extends DefaultAction
{
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// do nothing
	}

	@Override
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception 
	{
		AccountQueryForm myForm = (AccountQueryForm)form;
		request.getSession().setAttribute("SYSID",myForm.getReportType());
        return mapping.findForward(myForm.getReportType());
        
	}
}
