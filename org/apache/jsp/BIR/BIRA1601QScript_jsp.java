package org.apache.jsp.BIR;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BIRA1601QScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- BIRA1701AScript.jsp\r\n");
      out.write("程式目的：BIRA17檢查是否有輸入值\r\n");
      out.write("程式代號：BIRA17\r\n");
      out.write("程式日期：0950522\r\n");
      out.write("程式作者：Avery Yeh\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("  //nothing\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("    if (!CheckValidDate(form.elements['date(issueSdate)'].value)){\r\n");
      out.write("\t\tform.elements['date(issueSdate)'].value = \"\";\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif (!CheckValidDate(form.elements['date(issueEdate)'].value)){\r\n");
      out.write("\t\tform.elements['date(issueEdate)'].value = \"\";\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif (form.elements['date(issueSdate)'].value > form.elements['date(issueEdate)'].value){\r\n");
      out.write("\t\talert(\"發行日期起需小於等於發行日期迄\");\r\n");
      out.write("\t\tform.elements['date(issueSdate)'].value = \"\";\r\n");
      out.write("\t\tform.elements['date(issueEdate)'].value = \"\";\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("    if (\"0\" == form.amountUnit.value )\r\n");
      out.write("    {\r\n");
      out.write("    \tform.amountUnit.value = \"1\";\r\n");
      out.write("    }\r\n");
      out.write("\treturn true;\r\n");
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
