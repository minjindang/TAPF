package gov.dnt.tame.pm;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class PM1006_04U extends DefaultAction {

    protected SQLJob updSQLJob(HttpServletRequest request){
        SQLJob sqljob = new SQLJob();
        sqljob.appendSQL(" UPDATE PM0003_DB SET ");
        sqljob.appendSQL(" NAME=?, ");
        sqljob.appendSQL(" PATH=?, ");
        sqljob.appendSQL(" STATE=?, ");
        sqljob.appendSQL(" NOTE=? ");
        sqljob.appendSQL(" WHERE ID=? ");
      	sqljob.addParameter(request.getParameter("NAME"));
      	sqljob.addParameter(request.getParameter("PATH"));
      	sqljob.addParameter(request.getParameter("STATE")==null?"N":request.getParameter("STATE"));
      	sqljob.addParameter(request.getParameter("NOTE"));
      	sqljob.addParameter(new Integer(request.getParameter("ID")));
		System.out.println(sqljob.toString());
        return sqljob;
    }

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
        SQLJob updJob = updSQLJob(request);
        run.update(connection,updJob);
        setAlertMessage(request,Messages.SUCCESS_MODIFY);
	}
}
