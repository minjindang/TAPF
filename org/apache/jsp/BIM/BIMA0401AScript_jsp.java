package org.apache.jsp.BIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BIMA0401AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

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
      response.setContentType("text/html;charset=Big5");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getDays(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\tissueDate\t\t=\tcurrform.elements['date(issueDate)'].value;\r\n");
      out.write("\tvar\tdueDate \t=\tcurrform.elements['date(dueDate)'].value\r\n");
      out.write("\t\r\n");
      out.write("\tif (!(CheckValidDate(issueDate)) || !(CheckValidDate(dueDate)))\r\n");
      out.write("    {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("   \telse if (issueDate !=\"\" && dueDate != \"\")\r\n");
      out.write("   \t{\r\n");
      out.write("\t\tvar bigDate = currform.elements['date(issueDate)'].value ;\r\n");
      out.write("\t\tvar endDate = currform.elements['date(dueDate)'].value ;\r\n");
      out.write("\t\tif(\"\" != bigDate && null != bigDate && \"\" != endDate && null != endDate )\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tdocument.getElementById(\"issueDays\").innerHTML = daycount(bigDate,endDate,\"C\") ;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
      out.write("</script>");
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
