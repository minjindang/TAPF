/*
 * Created on Mar 27, 2005
 */
package gov.dnt.tame.common;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

import com.kangdainfo.ast.action.connection.QueryActionException;
import com.kangdainfo.ast.common.GlobalForwardNames;

/**
 * @author rayt
 */
public class QueryActionExceptionHandler extends ExceptionHandler
{

    /* (non-Javadoc)
     * @see org.apache.struts.action.ExceptionHandler#execute(java.lang.Exception, org.apache.struts.config.ExceptionConfig, org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ActionForward execute(Exception exception, ExceptionConfig config,
            ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws ServletException
    {
        QueryActionException queryActionException = (QueryActionException) exception;
        Throwable cause = queryActionException.getCause();
        if (cause instanceof SQLException)
        {
            SQLException sqlException = (SQLException) cause;
            if (sqlException.getErrorCode() == 2627)
            {
                return mapping.findForward("exception.duplicateKey");
            }
        }
        return mapping.findForward(GlobalForwardNames.FAILURE);
    }
}
