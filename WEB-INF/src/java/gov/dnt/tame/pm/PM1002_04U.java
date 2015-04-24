package gov.dnt.tame.pm;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class PM1002_04U extends DefaultAction {

    protected SQLJob updSQLJob(HttpServletRequest request){
        SQLJob sqljob = new SQLJob();
        sqljob.appendSQL(" UPDATE PM0005_DB SET ");
        if (null != request.getParameter("NAME") && !"".equals(request.getParameter("NAME")))
        {
	        sqljob.appendSQL(" NAME=?, ");
	      	sqljob.addParameter(request.getParameter("NAME"));
        }
        if(null != request.getParameter("PM0004ID") && !"".equals(request.getParameter("PM0004ID")))
        {
	      	sqljob.appendSQL(" PM0004ID=?, ");
	      	sqljob.addParameter(new Integer(request.getParameter("PM0004ID")));
        }
        if(null != request.getParameter("ACCOUNT") && !"".equals(request.getParameter("ACCOUNT")))
        {
	        sqljob.appendSQL(" ACCOUNT=?, ");
	      	sqljob.addParameter(request.getParameter("ACCOUNT"));
        }
        if(null != request.getParameter("PASSWORD") && !"".equals(request.getParameter("PASSWORD")))
        {
	        sqljob.appendSQL(" PASSWORD=?, ");
	      	sqljob.addParameter(request.getParameter("PASSWORD"));
        }
        if(null != request.getParameter("DEPT") && !"".equals(request.getParameter("DEPT")))
        {
	        sqljob.appendSQL(" DEPT=?, ");
	      	sqljob.addParameter(request.getParameter("DEPT"));
        }
        if(null != request.getParameter("EMAIL") && !"".equals(request.getParameter("EMAIL")))
        {
	      	sqljob.appendSQL(" EMAIL=?, ");
	      	sqljob.addParameter(request.getParameter("EMAIL"));
        }
        if(null != request.getParameter("TEL") && !"".equals(request.getParameter("TEL")))
        {
	      	sqljob.appendSQL(" TEL=?, ");
	      	sqljob.addParameter(request.getParameter("TEL"));
        }
        if(null != request.getParameter("MOBILE") && !"".equals(request.getParameter("MOBILE")))
        {
	      	sqljob.appendSQL(" MOBILE=?, ");
	      	sqljob.addParameter(request.getParameter("MOBILE"));
        }
        if(null != request.getParameter("AGENTACCOUNT") && !"".equals(request.getParameter("AGENTACCOUNT")))
        {
	      	sqljob.appendSQL(" AGENTACCOUNT=?, ");
	      	sqljob.addParameter(request.getParameter("AGENTACCOUNT"));
        }
        if(null != request.getParameter("STATUS") && !"".equals(request.getParameter("STATUS")))
        {
	      	sqljob.appendSQL(" STATUS=?, ");
	      	sqljob.addParameter(new Integer(request.getParameter("STATUS")));
        }
        if(null != request.getParameter("LVL") && !"".equals(request.getParameter("LVL")))
        {
	      	sqljob.appendSQL(" LVL=?, ");
	      	sqljob.addParameter(request.getParameter("LVL"));
        }
        if(null != request.getParameter("IDNO") && !"".equals(request.getParameter("IDNO")))
        {
	      	sqljob.appendSQL(" IDNO=?, ");
	      	sqljob.addParameter(request.getParameter("IDNO"));
        }
        sqljob.appendSQL(" USER_ID=?, ");
        sqljob.appendSQL(" MOD_DATE=? ");
        sqljob.appendSQL(" WHERE ID=? ");
        sqljob.addParameter(this.getUserId(request));
		sqljob.addParameter(DateUtil.getSystemDate());
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
