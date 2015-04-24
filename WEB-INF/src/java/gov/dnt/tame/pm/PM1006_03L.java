package gov.dnt.tame.pm;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class PM1006_03L extends DefaultAction {

	protected SQLJob selectJob(HttpServletRequest request) {
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT A.*, ");
		sqljob.appendSQL(" (SELECT NAME FROM PM0001_DB WHERE ID=A.PM0001ID) AS SYSNAME, ");
		sqljob.appendSQL(" (SELECT NAME FROM PM0002_DB WHERE ID=A.PM0002ID) AS FUNNAME ");
		sqljob.appendSQL(" FROM PM0003_DB A ");
		sqljob.appendSQL(" WHERE ID=?");
        sqljob.addParameter( new Integer(request.getParameter("ID")) );
		return sqljob;
	}    

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
        SQLRunner run = new ConnectionSQLRunner(connection);
        MapHandler mh = new MapHandler();
        SQLJob queryJob = selectJob(request);
        Map map = (Map) run.query(queryJob,mh);
        request.setAttribute("queryMap", map);
	}
}
