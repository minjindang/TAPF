package org.apache.jsp.ECR;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ECRF0101QScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("  //nothing\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write(" \tvar isValid = true;\r\n");
      out.write(" \tif(\"\" != form.reportType.value)\r\n");
      out.write(" \t{\r\n");
      out.write("\t\tif(\"依期別\" == form.reportType.value)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t \tif(null == form.issueId.value || 0 == form.issueId.value || \"\" == form.issueId.value)\r\n");
      out.write("\t\t \t{\r\n");
      out.write("\t\t \t\talert(\"請選擇一期債務名稱!\");\r\n");
      out.write("\t\t \t\tisValid = false;\r\n");
      out.write("\t\t \t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(\"依年度\" == form.reportType.value)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tif(null == form.issueYear.value || \"\" == form.issueYear.value)\r\n");
      out.write("\t\t \t{\r\n");
      out.write("\t\t \t\talert(\"請輸入年度!\");\r\n");
      out.write("\t\t \t\tisValid = false;\r\n");
      out.write("\t\t \t}\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"請選擇報表顯示方式!\");\r\n");
      out.write("\t\tisValid = false;\r\n");
      out.write("\t} \t\r\n");
      out.write("\treturn isValid;\r\n");
      out.write("}\r\n");
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
