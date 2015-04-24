package gov.dnt.tame.pm;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.sys.ConvertPassword;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class PM1001_01U extends DefaultAction {
	
	ConvertPassword convertPassword = new ConvertPassword();

    protected SQLJob updSQLJob(HttpServletRequest request){
        SQLJob sqljob = new SQLJob();
        sqljob.appendSQL(" UPDATE PM0005_DB SET ");
        sqljob.appendSQL(" OLDPASSWD=PASSWORD, ");
        sqljob.appendSQL(" PASSWORD=? ");
        sqljob.appendSQL(" WHERE ACCOUNT=? ");
      	sqljob.addParameter(convertPassword.convertPasswordtoMd5(request.getParameter("PASSWORD")));
        sqljob.addParameter(this.getUserId(request));
        return sqljob;
    }
    
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		
		String passwd = (String) request.getParameter("PASSWORD");
		String cpasswd = (String) request.getParameter("CPASSWORD");
		String errMsg = ""; 

		if(passwd.length() < 7)
		{
			errMsg = errMsg + "【密碼】長度不可低於7碼，請重新執行!\\n";
		}
		
		if (!(passwd.matches("^.*\\p{Alpha}.*$") && passwd.matches(".*[\\p{Digit}]{1,}+.*") && passwd.matches(".*[\\p{Punct}]{1,}+.*"))) 
		{
			errMsg = errMsg + "【密碼】必須要包含數字、文字、大小寫、特殊符號，請重新執行!\\n";
		}

		if( "".equals(passwd) )
		{
			errMsg = errMsg + "【密碼】不可空白，請重新執行!\\n";
		}
		if( "".equals(cpasswd) )
		{
			errMsg = errMsg + "【確認密碼】不可空白，請重新執行!\\n";
		}
		
		if(!errMsg.equals(""))
		{
			setAlertMessage(request,errMsg);
			throw new Exception("passwd error");
		}
		
		if( cpasswd.equals(passwd) )
		{
			if ("Y".equals(request.getParameter("FIRST")))
			{
			  request.setAttribute("nextForward","FIRST");
			  run.update(connection,updSQLJob(request));
		      setAlertMessage(request,Messages.SUCCESS_FIRSTPASS_CHANGE);
			}
			else
			{	
			  request.setAttribute("nextForward","success");	
	          run.update(connection,updSQLJob(request));
	          setAlertMessage(request,Messages.SUCCESS_MODIFY);
			}
		}
		else
		{   
			request.setAttribute("nextForward","failure");
	        setAlertMessage(request,"【密碼】與【確認密碼】不符，請重新執行!");
	        throw new Exception("passwd error");
		}	
	}
	public ActionForward getSuccessForward(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward((String)request.getAttribute("nextForward"));
	}
}
