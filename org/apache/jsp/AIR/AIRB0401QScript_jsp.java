package org.apache.jsp.AIR;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AIRB0401QScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!--\r\n");
      out.write("程式目的：中央政府公債各年度公債付息數額明細表\r\n");
      out.write("程式代號：AIRB04\r\n");
      out.write("程式日期：0950317\r\n");
      out.write("程式作者：icefire\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("  //nothing\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write(" \tvar isValid = true;\r\n");
      out.write("    var sError = \"\";\r\n");
      out.write("    if (\"\" != form.elements['repay_SDate'].value && \r\n");
      out.write("        \"\" != form.elements['repay_EDate'].value)\r\n");
      out.write("    {\r\n");
      out.write("      if (form.elements['repay_SDate'].value>\r\n");
      out.write("              form.elements['repay_EDate'].value)\r\n");
      out.write("         {\r\n");
      out.write("           isValid = false;\r\n");
      out.write("\t\t   sError += \"\\n\";\r\n");
      out.write("           sError += \"付息年度起 不可大於 迄!!\";\r\n");
      out.write("         }\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.elements['repay_SDate'].value )\r\n");
      out.write("    {\r\n");
      out.write("           isValid = false;\r\n");
      out.write("\t\t   sError += \"\\n\";\r\n");
      out.write("           sError += \"付息年度起 不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.elements['repay_EDate'].value )\r\n");
      out.write("    {\r\n");
      out.write("           isValid = false;\r\n");
      out.write("\t\t   sError += \"\\n\";\r\n");
      out.write("           sError += \"付息年度迄 不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("\tif (false == isValid)\r\n");
      out.write("    {\r\n");
      out.write("    \talert(sError);\r\n");
      out.write("    }\r\n");
      out.write("\t\treturn isValid;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
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
