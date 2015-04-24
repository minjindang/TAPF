package org.apache.jsp.GAR;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GARA1101QScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- GARA1101QScript.jsp\r\n");
      out.write("程式目的：GARA1101Q檢查是否有輸入值\r\n");
      out.write("程式代號：GARA11\r\n");
      out.write("程式日期：0950518\r\n");
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
      out.write(" \tvar isValid = true;\r\n");
      out.write("    var sError = \"\";\r\n");
      out.write("    if (\"\" == form.startYear.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【發行年度】不可空白!!\";\r\n");
      out.write("        form.startYear.focus();\r\n");
      out.write("        alert(sError);\r\n");
      out.write("        return isValid;\r\n");
      out.write("    }\r\n");
      out.write("    if (!CheckValidDate(form.elements['date(createDate)'].value)){\r\n");
      out.write("\t\tform.elements['date(createDate)'].value = \"\";\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("    if (\"0\" == form.amountUnit.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tform.amountUnit.value = \"1\";\r\n");
      out.write("    }\r\n");
      out.write("\treturn isValid;\r\n");
      out.write("}\r\n");
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
