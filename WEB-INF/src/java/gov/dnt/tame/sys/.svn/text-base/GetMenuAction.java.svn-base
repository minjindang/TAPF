package gov.dnt.tame.sys;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GetMenuAction extends DefaultAction {

	protected SQLJob queryJob(HttpServletRequest request)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT PM0002ID,NAME ,PATH ");
		sqljob.appendSQL(" FROM PM0003_DB ");
		sqljob.appendSQL(" WHERE STATE='Y' ");
		sqljob.appendSQL(" AND PM0001ID=? ");
		sqljob.addParameter( new Integer(request.getParameter("ID")) );
		sqljob.appendSQL(" AND ID IN ( ");
		sqljob.appendSQL(" SELECT PM0003ID FROM PM0006_DB WHERE PM0004ID=( ");
		sqljob.appendSQL(" SELECT PM0004ID FROM PM0005_DB WHERE ACCOUNT=?");
		sqljob.addParameter( request.getSession().getAttribute("ACCOUNT") );		
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" ORDER BY PATH ");
		return sqljob;
	}

	protected SQLJob getTitleJob(HttpServletRequest request)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT * ");
		sqljob.appendSQL(" FROM PM0002_DB ");
		sqljob.appendSQL(" WHERE STATE='Y' ");
		sqljob.appendSQL(" AND PM0001ID=? ");
		sqljob.addParameter( new Integer(request.getParameter("ID")) );
		sqljob.appendSQL(" AND ID IN ( ");
		sqljob.appendSQL("SELECT PM0002ID ");
		sqljob.appendSQL(" FROM PM0003_DB ");
		sqljob.appendSQL(" WHERE STATE='Y' ");
		sqljob.appendSQL(" AND PM0001ID=? ");
		sqljob.addParameter( new Integer(request.getParameter("ID")) );
		sqljob.appendSQL(" AND ID IN ( ");
		sqljob.appendSQL(" SELECT PM0003ID FROM PM0006_DB WHERE PM0004ID=( ");
		sqljob.appendSQL(" SELECT PM0004ID FROM PM0005_DB WHERE ACCOUNT=?");
		sqljob.addParameter( request.getSession().getAttribute("ACCOUNT") );		
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" order by ID ");
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		MapListHandler mlh = new MapListHandler();

//		List list = (List) run.query( queryJob(request), mlh );
		List list =null;
		try{
			list = (List) run.query( queryJob(request), mlh );
		}catch(Exception e){
			
		}
		request.setAttribute("menuList",list);
		
//		List titleList = (List) run.query( getTitleJob(request), mlh );
		List titleList = null;
		try{
			titleList = (List) run.query( getTitleJob(request), mlh );
		}catch(Exception e){
			
		}
		
		request.setAttribute("titleList",titleList);
	}
}
