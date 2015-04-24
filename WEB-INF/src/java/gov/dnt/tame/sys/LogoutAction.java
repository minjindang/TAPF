package gov.dnt.tame.sys;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;

public class LogoutAction extends DefaultAction {

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		HttpSession session = request.getSession(false);
        if (session != null)
        {
        	session.invalidate();
        }
	}
}
