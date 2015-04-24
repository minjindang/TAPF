package gov.dnt.tame.pm;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class PM1002_02Q extends DefaultAction {

    protected SQLJob selectJob(HttpServletRequest request){
        SQLJob sqljob = new SQLJob();
        sqljob.appendSQL(" SELECT A.*, ");
        sqljob.appendSQL(" (SELECT NAME FROM PM0004_DB WHERE ID=A.PM0004ID) AS GNAME ");
        sqljob.appendSQL(" FROM PM0005_DB A ");
        sqljob.appendSQL(" WHERE 1=1 ");
        if( request.getParameter("GCODE")!=null && !"".equals(request.getParameter("GCODE")))
        {
        	sqljob.appendSQL(" AND PM0004ID = ?");
        	sqljob.addParameter( new Integer(request.getParameter("GCODE")) );
        }
        if( request.getParameter("QACCOUNT")!=null && !"".equals(request.getParameter("QACCOUNT")))
        {
        	sqljob.appendSQL(" AND ACCOUNT = ?");
        	sqljob.addParameter( request.getParameter("QACCOUNT"));
        }
        if( request.getParameter("QNAME")!=null && !"".equals(request.getParameter("QNAME")))
        {
//        	sqljob.appendSQL(" AND NAME like ?||'%' ");
//        	sqljob.addParameter(request.getParameter("QNAME"));
        	sqljob.appendSQL(" and NAME like ? ");
        	sqljob.addLikeParameter(request.getParameter("QNAME"));
        }
        sqljob.appendSQL(" AND Status <> 9 ");
        sqljob.appendSQL(" ORDER BY ID ");
        System.out.println(sqljob.toString());
        return sqljob;
    }

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		MapListHandler mlh = new MapListHandler();
		SQLJob queryJob = selectJob(request);
		List queryList = (List) run.query(queryJob, mlh);
		request.setAttribute("queryList", queryList);
	}
}
