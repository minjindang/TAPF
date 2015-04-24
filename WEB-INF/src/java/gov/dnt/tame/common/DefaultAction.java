/* DefaultAction.java
 * Created on 2004/9/9
 */
package gov.dnt.tame.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ecs.xhtml.tr;

import com.kangdainfo.ast.action.connection.AuthQueryAction;
import com.kangdainfo.ast.action.connection.ConnectionActionException;
import com.kangdainfo.ast.security.auth.AuthContext;

/**
 * @author Anson Tsai
 */
public abstract class DefaultAction extends AuthQueryAction
{
	
	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.AuthQueryAction#createAuthContext(
	 * javax.servlet.http.HttpServletRequest)
	 */
	public AuthContext createAuthContext(HttpServletRequest request)
			throws Exception {
		return AuthContextFactory.getAuthContext(request);
	}

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.ConnectionAction#createConnection()
     */
    public Connection createConnection() throws ConnectionActionException
    {
        try
        {
            Connection conn = DataSourceFactory.getDataSource().getConnection();
            return conn;
        }
        catch (SQLException e)
        {
            throw new ConnectionActionException("sql exception", e);
        }
        catch (NamingException e)
        {
            throw new ConnectionActionException("naming exception", e);
        }
    }
    
    public void setAlertMessage(HttpServletRequest request, String alertMessage)
    {
    	request.setAttribute(Constants.ALERT_BEAN, alertMessage);
    }   
}
