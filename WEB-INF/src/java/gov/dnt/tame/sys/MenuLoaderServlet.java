/*
 * Created on Apr 27, 2005
 */
package gov.dnt.tame.sys;

import gov.dnt.tame.common.DataSourceFactory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import com.kangdainfo.ast.webmenu.loader.MenuLoader;
import com.kangdainfo.ast.webmenu.menu.MenuContext;

/**
 * @author rayt
 */
public class MenuLoaderServlet extends HttpServlet
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException
    {
        Connection connection = null;
        try
        {
            DataSource ds = DataSourceFactory.getDataSource();
            connection = ds.getConnection();
            loadMenu(connection);
        }
        catch (NamingException e)
        {
            throw new ServletException("naming exception", e);
        }
        catch (SQLException e)
        {
            throw new ServletException("sql exception", e);
        }
        finally
        {
            if (connection != null) {
                try
                {
                    connection.close();
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }
    
    public static void loadMenu(ServletContext servletCtx, Connection connection)
    {
        MenuLoader loader = new DefaultMenuLoader(connection);
        MenuContext menuCtx = MenuContext.getInstance(servletCtx, true);
        menuCtx.addLoader(loader);
        menuCtx.load();
        servletCtx.setAttribute(".menuContext", menuCtx);
    }
    
    public void loadMenu(Connection connection)
    {
        loadMenu(getServletContext(), connection);
    }
}
