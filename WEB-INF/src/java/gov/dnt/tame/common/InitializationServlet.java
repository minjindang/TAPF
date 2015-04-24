/* $Id: InitializationServlet.java,v 1.1 2006/04/25 03:43:36 william Exp $
 * Created on Oct 8, 2004
 */
package gov.dnt.tame.common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author rayt
 */
public class InitializationServlet extends HttpServlet
{

    private static final long serialVersionUID = 7832346936520008827L;

    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init()
     */
    public void init() throws ServletException
    {
        // does not seem to solve problems at all,
        // removed for now
        //ConvertUtils.register(new ROCDateStringConverter(), String.class);
        //ConvertUtils.register(new ROCDateConverter(), Date.class);
    }
}
