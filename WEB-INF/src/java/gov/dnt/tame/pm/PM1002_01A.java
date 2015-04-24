package gov.dnt.tame.pm;

import gov.dnt.tame.common.Constants;
import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.sys.ConvertPassword;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class PM1002_01A extends DefaultAction {
	
	ConvertPassword convertPassword = new ConvertPassword();
    
	protected SQLJob insSQLJob(HttpServletRequest request){
        SQLJob sqljob = new SQLJob();
        sqljob.appendSQL("Insert Into PM0005_DB ( ");
        sqljob.appendSQL(" PM0004ID, ACCOUNT, NAME, ");
//        sqljob.appendSQL(" PM0004ID, ACCOUNT, PASSWORD, NAME, ");
        sqljob.appendSQL(" IDNO, DEPT, TITLE, TEL, MOBILE, ");
        sqljob.appendSQL(" EMAIL, STATUS, AGENTACCOUNT, USER_ID, MOD_DATE, ");
        sqljob.appendSQL(" LVL ) ");
        sqljob.appendSQL(" VALUES ( ");
//        sqljob.appendSQL(" ?,?,?,?, ");
        sqljob.appendSQL(" ?,?,?, ");
        sqljob.appendSQL(" ?,?,?,?,?, ");
        sqljob.appendSQL(" ?,0,?,?,?,? ");
        sqljob.appendSQL("  ) ");
        sqljob.addParameter( new Integer(request.getParameter("PM0004ID")) );
        sqljob.addParameter(request.getParameter("ACCOUNT"));
//        sqljob.addParameter(convertPassword.convertPasswordtoMd5(request.getParameter("PASSWORD")));
        sqljob.addParameter(request.getParameter("NAME"));
        
        sqljob.addParameter(request.getParameter("IDNO"));
        sqljob.addParameter(request.getParameter("DEPT"));
        sqljob.addParameter("");
        sqljob.addParameter(request.getParameter("TEL"));
        sqljob.addParameter(request.getParameter("MOBILE"));
        
        sqljob.addParameter(request.getParameter("EMAIL"));
        
        sqljob.addParameter(request.getParameter("AGENTACCOUNT"));
    	sqljob.addParameter(this.getUserId(request));
    	sqljob.addParameter( DateUtil.getSystemDate() );
    	sqljob.addParameter(request.getParameter("LVL"));
        return sqljob;
    }

	protected SQLJob getSQLJob(HttpServletRequest request){
        SQLJob sqljob = new SQLJob();
        sqljob.appendSQL("SELECT * FROM PM0005_DB WHERE ACCOUNT=?");
        sqljob.addParameter(request.getParameter("ACCOUNT"));
        return sqljob;
    }

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,insSQLJob(request));
		
		MapHandler mh = new MapHandler();
		SQLJob queryJob = getSQLJob(request);
		Map queryMap = (Map) run.query(queryJob, mh);
		
        request.setAttribute("PM0005ID",queryMap.get("ID")); 
        setAlertMessage(request,Messages.SUCCESS_ADD);
	}
	
	public ActionForward getSuccessForward(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return super.getParameterForward(mapping, "?ID=" + request.getAttribute("PM0005ID"), Constants.SUCCESS);
	}

}
