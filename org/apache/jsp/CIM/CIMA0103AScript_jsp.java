package org.apache.jsp.CIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CIMA0103AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  //nothing\r\n");
      out.write("}\r\n");
      out.write("function rateLimit(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar tempValue = 0;\r\n");
      out.write("    var tempCount = form.elements['bigDecimal(debtRate)'].value;\r\n");
      out.write("    var tempLength = tempCount.length;\r\n");
      out.write("    if( tempCount.indexOf(\".\")< 0 )\r\n");
      out.write("    {\r\n");
      out.write("        tempValue = 0 ;\r\n");
      out.write("    }\t\r\n");
      out.write("    else\r\n");
      out.write("    {\r\n");
      out.write("        tempValue = tempCount.indexOf(\".\") - 3 ;\r\n");
      out.write("    }\r\n");
      out.write("    form.elements['bigDecimal(debtRate)'].value = tempCount.substring(tempValue,tempLength);\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array( \"date(effectiveDate)\" , \"date(suspendDate)\" , \"bigDecimal(debtRate)\");\r\n");
      out.write("\tvar colNames = new Array(\"【利率生效日期】\", \"【利率終止日期】\" , \"【利率】\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(colNames[result] + \"不可空白!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\tif (form.elements['date(effectiveDate)'].value > form.elements['date(suspendDate)'].value)\r\n");
      out.write("    {\r\n");
      out.write("        alert(\"利率生效日期不可大於利率終止日期!!\");\r\n");
      out.write("        result = 1 ;\r\n");
      out.write("    }\r\n");
      out.write("\treturn (result < 0);\r\n");
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
