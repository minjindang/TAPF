package gov.dnt.tame.pm;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kangdainfo.ast.dao.DAOException;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class PM1002_05D extends DefaultAction {

    public String getAppendString(HttpServletRequest request) throws DAOException
    {
    	String[] id = (String[]) request.getParameterValues("check");
    	StringBuffer sb = new StringBuffer();
    	boolean b = false;
    	if(id!=null && id.length>0)
    	{
    		for (int i = 0 ; i < id.length ; i++)
    		{
        		if(b)
        			sb.append(",");
    			sb.append(id[i]);
    			b = true;
    		}
    	}
    	return sb.toString();
    }

    protected SQLJob delSQLJob(HttpServletRequest request,String appendStr){
        SQLJob sqljob = new SQLJob();
        sqljob.appendSQL(" DELETE FROM PM0005_DB ");
        sqljob.appendSQL(" WHERE ID in ( ");
        sqljob.appendSQL(appendStr);
        sqljob.appendSQL(" ) ");
        return sqljob;
    }

    public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run  = new ConnectionSQLRunner(connection);

		String appendStr = "";
		if( request.getParameter("ID")!=null )
		{
			appendStr = request.getParameter("ID");
			request.setAttribute("nextForward", "toSCN1");
		}
		else
		{
			appendStr = getAppendString(request);
			request.setAttribute("nextForward", "toSCN3");
		}
        SQLJob delJob = delSQLJob(request,appendStr);
        run.update(connection,delJob);
        setAlertMessage(request,Messages.SUCCESS_DELETE);
	}
    
	public ActionForward getSuccessForward(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward((String)request.getAttribute("nextForward"));
	}
}
