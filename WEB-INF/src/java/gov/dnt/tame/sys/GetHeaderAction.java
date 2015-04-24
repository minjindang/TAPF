package gov.dnt.tame.sys;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GetHeaderAction extends DefaultAction {

	protected SQLJob queryJob(String account)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT * FROM PM0001_DB ");
		sqljob.appendSQL(" WHERE ID IN ( ");
		sqljob.appendSQL(" SELECT PM0001ID FROM PM0003_DB ");
		sqljob.appendSQL(" WHERE ID IN ( ");
		sqljob.appendSQL(" SELECT PM0003ID FROM PM0006_DB WHERE PM0004ID=( ");
		sqljob.appendSQL(" SELECT PM0004ID FROM PM0005_DB WHERE ACCOUNT=? ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" GROUP BY PM0001ID ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" ORDER BY SORT ");
		sqljob.addParameter( account );
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		
		HttpSession sess = request.getSession(true);
		if(sess==null)
		{
			setAlertMessage(request,"Session timeout!");
			request.setAttribute("whereforward", "failure");
		}
		else
		{
			String account = (String) sess.getAttribute("ACCOUNT");
			MapListHandler mlh = new MapListHandler();
			List list = (List) run.query( queryJob(account), mlh );
			if(list==null)
			{
				setAlertMessage(request,"您目前沒有可以使用的權限");
				request.setAttribute("whereforward", "failure");
			}
			else
			{
				request.setAttribute("menuBar", list);
		   		request.setAttribute("whereforward", "success");
			}
		}
	}
	public ActionForward getSuccessForward(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward((String) request.getAttribute("whereforward"));
	}
}
