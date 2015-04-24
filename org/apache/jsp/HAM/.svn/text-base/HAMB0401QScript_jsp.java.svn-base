package org.apache.jsp.HAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HAMB0401QScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\tfunction doBodyOnLoad(document)\r\n");
      out.write("\t{\r\n");
      out.write("\t  //nothing\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction getSelectValue(obj)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif( obj.value!=\"\" )\r\n");
      out.write("\t\t\treturn obj.options[obj.selectedIndex].text;\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t\treturn \"\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction checkForm(form)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar cols = new Array(\"qryAllYear\",\"qryAllMonth\");\r\n");
      out.write("\t\tvar colNames = new Array(\"記帳年度\", \"分配年月\");\r\n");
      out.write("\t\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\t\tif(result >= 0){\r\n");
      out.write("\t\t\talert(\"【\" + colNames[result] + \"】，未輸入!!\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn result < 0;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkFill(form)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar cols = new Array(\"qryAllYear\",\"qryAllMonth\",\"faillAmount\");\r\n");
      out.write("\t\tvar colNames = new Array(\"記帳年度\", \"分配年月\",\"應撥補金額\");\r\n");
      out.write("\t\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\t\tif(result >= 0){\r\n");
      out.write("\t\t\talert(\"【\" + colNames[result] + \"】，未輸入!!\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn result < 0;\t\t\r\n");
      out.write("\t}\r\n");
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
