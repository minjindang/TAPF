/* $Id: ErrorDisplay.java,v 1.1 2006/04/25 03:45:20 william Exp $
 * ErrorDisplay.java
 * Created on 2004/11/22
 */
package gov.dnt.tame.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Anson Tsai
 * @version $Revision: 1.1 $
 */
public class ErrorDisplay extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(
	 * javax.servlet.http.HttpServletRequest, 
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException
	{
	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();
	    
	    String code = null;
	    String message = null;
	    String type = null;
	    
	    Object codeObj;
	    Object messageObj;
	    Object typeObj;
	    
	    codeObj = req.getAttribute("javax.servlet.error.status_code");
	    messageObj = req.getAttribute("javax.servlet.error.message");
	    typeObj = req.getAttribute("javax.servlet.error.exception_type");
	    
	    if (null != codeObj) code= codeObj.toString();
	    if (null != messageObj) message= messageObj.toString();
	    if (null != typeObj) type= typeObj.toString();
	    
	    String reason = (null != code ? code : type);
	    
	    out.println("<html>");
	    out.println("<head><title>"+ reason + ": " + message + "</title></head>");
	    out.println("<body>");
	    out.println("<H1>"+ reason + "</H1>");
	    out.println("<H2>"+ message + "<H2>");
	    out.println("<HR>");
	    out.println("<I>存取 "+ req.getRequestURI() + " 時發生錯誤</I>");
	    out.println("</body></html>");
	}
}
