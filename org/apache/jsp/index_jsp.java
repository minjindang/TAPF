package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!--  logic:redirect forward=\"welcome\"/-->\r\n");
      out.write("<SCRIPT LANGUAGE=\"JavaScript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doOpenNW() \r\n");
      out.write("{\r\n");
      out.write("    currform = document.container;\r\n");
      out.write("    var aWindow=window.open(\"do/Login\",\"DynamicWindowsName\",\"width=\"+(screen.availWidth-10)+\",height=\"+(screen.availHeight-36)+\",top=0,left=0,scrollbars=yes,titlebar=yes,fullscreen=no\");\r\n");
      out.write("    aWindow.document.write(\"<center>???...???...</center>\");\r\n");
      out.write("    aWindow.document.close;\r\n");
      out.write("    aWindow.location = \"do/Login\";\r\n");
      out.write("    aWindow.focus;\r\n");
      out.write("    window.opener=null;\r\n");
      out.write("\twindow.close();\r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<body oncontextmenu=\"return false\" onload=\"javascript:doOpenNW()\">");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
