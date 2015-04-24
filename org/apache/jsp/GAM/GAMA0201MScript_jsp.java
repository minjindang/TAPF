package org.apache.jsp.GAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GAMA0201MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script language=\"javascript\">\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\t//do nothing\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkForm(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\r\n");
      out.write("\t\t\"accountYear\",\"nationRefId\",\"bigDecimal(gdpAmount)\",\"bigDecimal(gnpAmount)\",\"bigDecimal(pergnpAmount)\",\r\n");
      out.write("\t\t\"bigDecimal(remainRate)\",\"bigDecimal(borrowAmount)\",\"bigDecimal(budgetAmount)\",\r\n");
      out.write("\t\t\"bigDecimal(nopayAmount)\");\r\n");
      out.write("\tvar colNames = new Array(\r\n");
      out.write("\t\t\"年度\",\"國別\",\"GDP\",\"GNP\",\"前三年平均GNP\",\r\n");
      out.write("\t\t\"債務餘額/GDP比例\",\"公債賒借發行總額\",\"歲出總額(預算數)\",\r\n");
      out.write("\t\t\"未償餘額\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(\"【\" + colNames[result] + \"】，未輸入!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\treturn result < 0;\r\n");
      out.write("}\r\n");
      out.write("function checkDate(form)\r\n");
      out.write("{\r\n");
      out.write("\tif(form.nationRefId.value !=\"\" && form.accountYear.value !=\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdoAction(\"GAMA0201M\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
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
