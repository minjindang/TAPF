package gov.dnt.tame.sys;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kangdainfo.ast.common.BeanNames;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CheckLoginAction extends DefaultAction {
	
    public static final String USER_ID_BEAN = BeanNames.USER_ID_BEAN;
    ConvertPassword convertPassword = new ConvertPassword();

	protected SQLJob authCheck(HttpServletRequest request)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT A.*, ");
		sqljob.appendSQL(" (SELECT NAME FROM PM0004_DB WHERE ID=A.PM0004ID) AS GNAME ");
		sqljob.appendSQL(" FROM PM0005_DB A ");
		sqljob.appendSQL(" WHERE A.ACCOUNT=? ");
		sqljob.appendSQL(" AND A.PASSWORD=? ");
		sqljob.addParameter( request.getParameter("account") );
		sqljob.addParameter( convertPassword.convertPasswordtoMd5(request.getParameter("password")));
		
		System.out.println("使用者 ： "+request.getParameter("account") + " 登入");
		System.out.println("登入時間："+DateUtil.getSystemDateTime());
		
		return sqljob;
	}

	protected SQLJob updAuthSuccess(HttpServletRequest request)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("UPDATE PM0005_DB SET ");
		sqljob.appendSQL(" LAST_LOGIN=?, ");
		sqljob.addParameter(DateUtil.getSystemDate());
		sqljob.appendSQL(" STATUS=0 ");
		sqljob.appendSQL(" WHERE ACCOUNT=? ");
		sqljob.appendSQL(" AND PASSWORD=? ");
		sqljob.addParameter( request.getParameter("account") );
		sqljob.addParameter( convertPassword.convertPasswordtoMd5(request.getParameter("password")));
		return sqljob;
	}

	protected SQLJob updAuthError(HttpServletRequest request)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("UPDATE PM0005_DB SET ");
		sqljob.appendSQL(" STATUS=STATUS+1 ");
		sqljob.appendSQL(" WHERE ACCOUNT=? ");
		sqljob.addParameter( (String) request.getParameter("account") );
		return sqljob;
	}
	
	protected SQLJob getMenuID(HttpServletRequest request)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("Select Min(PM0001ID) as PM0001ID From PM0003_DB Where ID in ( ");
		sqljob.appendSQL("		SELECT PM0003ID FROM PM0006_DB WHERE PM0004ID=( ");
		sqljob.appendSQL("		SELECT PM0004ID FROM PM0005_DB WHERE ACCOUNT=?)) ");
		sqljob.addParameter( (String) request.getParameter("account") );
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		MapHandler mh = new MapHandler();
		String path = "";
		Map menuMap = (Map) run.query( getMenuID(request),mh );
		
		if (menuMap==null || menuMap.isEmpty()||menuMap.get("PM0001ID")==null)
			path = "/do/MENU?ID=1" ;
		else
			path = "/do/MENU?ID=" + menuMap.get("PM0001ID").toString() ;	

		if(request.getParameter("account")==null || "".equals(request.getParameter("account")))
		{
			setAlertMessage(request,"帳號錯誤!");
			request.setAttribute("nextForward","failure");
		}
		if(request.getParameter("password")==null || "".equals(request.getParameter("password")))
		{
			setAlertMessage(request,"密碼錯誤!");
			request.setAttribute("nextForward","failure");
		}
		
		Map authMap = (Map) run.query( authCheck(request),mh );
		if(authMap==null)
		{
			run.update(connection,updAuthError(request));
			setAlertMessage(request,Messages.LOGIN_ERROR);
			request.setAttribute("nextForward","failure");
		}
		else
		{
			int status = Integer.parseInt(authMap.get("STATUS").toString());
			if(status<3)
			{
				run.update(connection,updAuthSuccess(request));

				HttpSession session = request.getSession(true);
		   		session.setAttribute(USER_ID_BEAN,authMap);
				session.setAttribute("ID",authMap.get("ID"));
		   		session.setAttribute("NAME",authMap.get("NAME"));
		   		session.setAttribute("ACCOUNT",authMap.get("ACCOUNT"));
		   		session.setAttribute("DEPTID",authMap.get("PM0004ID"));
		   		session.setAttribute("DEPT",authMap.get("GNAME"));
		   		session.setAttribute("LEVEL",authMap.get("LVL"));

		   		if(authMap.get("LAST_LOGIN")==null || "".equals(authMap.get("LAST_LOGIN").toString()))
				{
					path = "/do/PM1001?FIRST=Y";
					setAlertMessage(request,"首次登入請先更新密碼!");
				}
		   		session.setAttribute("AUTHORITY", authMap.get("ACCOUNT").toString() );

		   		request.setAttribute("nextForward","success");
			}
			else
			{
				setAlertMessage(request,"登入失敗次數達三次，請洽詢您的系統管理者。");
				request.setAttribute("nextForward","failure");
			}
		}
		request.setAttribute("path",path);
	}
	
	public ActionForward getSuccessForward(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward((String)request.getAttribute("nextForward"));
	}
}
