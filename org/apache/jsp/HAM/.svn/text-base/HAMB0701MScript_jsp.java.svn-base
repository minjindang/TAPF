package org.apache.jsp.HAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HAMB0701MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!--\t電子郵件接收紀錄維護\r\n");
      out.write("程式目的：HAMB07文字\r\n");
      out.write("程式代號：HAMB07\r\n");
      out.write("程式日期：0950223\r\n");
      out.write("程式作者：FormBean Generator\r\n");
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
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write(" \tvar isValid = true;\r\n");
      out.write("    var sError = \"\";\r\n");
      out.write("    var str1 = form.houMinSec.value ;\r\n");
      out.write("\tvar str2 = form.elements['date(recvDate)'].value;\r\n");
      out.write("    \r\n");
      out.write("    if (\"\" == form.elements['date(recvDate)'].value || (form.elements['date(recvDate)'].value.length) < 7 )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"請輸入7碼回條接收日期!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.houMinSec.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【回條接收時間】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("\telse\r\n");
      out.write("\t{\t\r\n");
      out.write("\t\tswitch(str1.length)\r\n");
      out.write("\t\t{\t\r\n");
      out.write("\t\t\tcase 1 :\t\r\n");
      out.write("\t\t\t\t\tstr1 = \"0\" + str1 + \"0000\" ;\t\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\tcase 2 :\t\r\n");
      out.write("\t\t\t\t\tstr1 = str1 + \"0000\" ;\t\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\tcase 3 :\t\r\n");
      out.write("\t\t\t\t\tstr1 = str1 + \"000\" ;\t\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\tcase 4 :\t\r\n");
      out.write("\t\t\t\t\tstr1 = str1 + \"00\" ;\t\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\tcase 5 :\t\r\n");
      out.write("\t\t\t\t\tstr1 = str1 + \"0\" ;\t\r\n");
      out.write("\t\t\t\t\tbreak;\t\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("    if (false == isValid)\r\n");
      out.write("    {\r\n");
      out.write("    \talert(sError);\r\n");
      out.write("    }\r\n");
      out.write("    else \r\n");
      out.write("    {\r\n");
      out.write("    \tform.elements['date(recvDate)'].value = str2 + str1 ;\r\n");
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
