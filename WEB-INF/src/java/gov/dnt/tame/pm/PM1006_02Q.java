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

public class PM1006_02Q extends DefaultAction {

	protected SQLJob selectJob(HttpServletRequest request){
        SQLJob sqljob = new SQLJob();
        sqljob.appendSQL(" SELECT A.*, ");
        sqljob.appendSQL(" CASE STATE WHEN 'Y' THEN '¬O' WHEN 'N' THEN '§_' ELSE '' END AS STATE_C ");
        sqljob.appendSQL(" FROM PM0003_DB A ");
        sqljob.appendSQL(" WHERE 1=1 ");
        if( request.getParameter("SYSCODE")!=null && !"".equals(request.getParameter("SYSCODE")))
        {
        	sqljob.appendSQL(" AND PM0001ID = ?");
        	sqljob.addParameter( new Integer(request.getParameter("SYSCODE")) );
        }
        if( request.getParameter("FUNCODE")!=null && !"".equals(request.getParameter("FUNCODE")))
        {
        	sqljob.appendSQL(" AND PM0002ID = ?");
        	sqljob.addParameter( new Integer(request.getParameter("FUNCODE")) );
        }
        if( request.getParameter("QNAME")!=null && !"".equals(request.getParameter("QNAME")))
        {
        	sqljob.appendSQL(" AND NAME like ?+'%' ");
        	sqljob.addParameter( request.getParameter("QNAME") );
        }
        if( request.getParameter("QPATH")!=null && !"".equals(request.getParameter("QPATH")))
        {
        	sqljob.appendSQL(" AND PATH = ?");
        	sqljob.addParameter( request.getParameter("QPATH") );
        }
        sqljob.appendSQL(" ORDER BY ID ");
        System.out.println(sqljob.toString());
        return sqljob;
    }

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob queryJob = selectJob(request);
		List queryList = (List) run.query(queryJob, new MapListHandler());
		request.setAttribute("queryList", queryList);
	}
}
