package org.apache.jsp.APR;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class APRA1501QScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- APRA1501AScript.jsp\r\n");
      out.write("程式目的：APRA15檢查是否有輸入值\r\n");
      out.write("程式代號：APRA15\r\n");
      out.write("程式日期：0950221\r\n");
      out.write("程式作者：Andrew Sung\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\" src=\"/tapf/assets/scripts/DateUtil.js\"></script>\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("  //nothing\r\n");
      out.write("}\r\n");
      out.write("function getSelectValue(obj)\r\n");
      out.write("{\r\n");
      out.write("\tif( obj.bankId.value!=\"\" )\r\n");
      out.write("\t\tobj.bankName.value = obj.bankId.options[obj.bankId.selectedIndex].text;\r\n");
      out.write("\telse\r\n");
      out.write("\t\tobj.bankName.value = \"\";\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\"date(closeDate)\",\"bankId\");\r\n");
      out.write("\tvar colNames = new Array(\"【截止日期】\",\"【清算銀行】\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(colNames[result] + \"不可空白!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\tif (!(CheckValidDate(form.elements['date(closeDate)'].value)))\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("    \treturn isValid;\r\n");
      out.write("    }\r\n");
      out.write("\treturn (result < 0);\t\r\n");
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
