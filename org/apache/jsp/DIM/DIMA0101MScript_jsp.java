package org.apache.jsp.DIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DIMA0101MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- DIMA0101MScript.jsp\r\n");
      out.write("程式目的：DIMA01\r\n");
      out.write("程式代號：DIMA01\r\n");
      out.write("程式日期：0950223\r\n");
      out.write("程式作者：Eric.Chen\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("  //nothing\r\n");
      out.write("}\r\n");
      out.write("function countValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tif( 0 <= replaceAll(form.elements['bigDecimal(contractAmount)'].value,\",\",\"\") )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tform.elements['bigDecimal(enableborrow)'].value = (\r\n");
      out.write("\t\tNumber(replaceAll(form.elements['bigDecimal(contractAmount)'].value,\",\",\"\"))  - \r\n");
      out.write("\t\tNumber(replaceAll(form.elements['bigDecimal(borrowAmount)'].value,\",\",\"\")));\r\n");
      out.write("\t\tdocument.getElementById(\"enableborrowid\").innerHTML =  addMoneyMask((\r\n");
      out.write("\t\tNumber(replaceAll(form.elements['bigDecimal(contractAmount)'].value,\",\",\"\"))  - \r\n");
      out.write("\t\tNumber(replaceAll(form.elements['bigDecimal(borrowAmount)'].value,\",\",\"\"))));\r\n");
      out.write("\t}\t\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\tform.elements['bigDecimal(enableborrow)'].value = \"\";\r\n");
      out.write("\t\tform.elements['bigDecimal(contractAmount)'].value = \"\";\r\n");
      out.write("\t\tdocument.getElementById(\"enableborrowid\").innerHTML = \"\";\r\n");
      out.write("\t}\r\n");
      out.write("\treturn false;\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\"bigDecimal(contractAmount)\");\r\n");
      out.write("\tvar colNames = new Array(\"【借款總額】\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(colNames[result] + \"不可空白!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\treturn result < 0;\r\n");
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
