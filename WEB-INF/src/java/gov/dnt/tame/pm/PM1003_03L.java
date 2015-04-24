package gov.dnt.tame.pm;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class PM1003_03L extends DefaultAction {

	protected SQLJob selectJob(HttpServletRequest request) {
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT * FROM PM0005_DB WHERE ID=?");
        sqljob.addParameter( request.getParameter("GCODE") );
        //System.out.println("SQL : "+ sqljob);
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
