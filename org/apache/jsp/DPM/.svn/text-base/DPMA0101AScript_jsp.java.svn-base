package org.apache.jsp.DPM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DPMA0101AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- DIMA0101AScript.jsp\r\n");
      out.write("程式目的：DIMA01\r\n");
      out.write("程式代號：DIMA01\r\n");
      out.write("程式日期：0950223\r\n");
      out.write("程式作者：Andrew Sung\r\n");
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
      out.write("\t/*toDay = new Date();\r\n");
      out.write("\tDay=(toDay.getYear()-1911);\r\n");
      out.write("\tif (Day<100)\r\n");
      out.write("\t\tDay=\"0\"+(toDay.getYear()-1911);\r\n");
      out.write("\tif ((toDay.getMonth()+1)<10)\r\n");
      out.write("\t\tDay += \"0\"+(toDay.getMonth()+1);\r\n");
      out.write("\telse Day += toDay.getMonth()+1;\r\n");
      out.write("\tif (toDay.getDate()<10)\r\n");
      out.write("\t\tDay += \"0\"+toDay.getDate() ;\r\n");
      out.write("\telse Day += toDay.getDate();\r\n");
      out.write("\tdocument.MainForm.elements('Date(repayDate)').value = Day;*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\"id_options\", \"Date(repayDate)\");\r\n");
      out.write("\tvar colNames = new Array(\"短期借款名稱\", \"償還日期\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(\"【\" + colNames[result] + \"】未輸入!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif (!(CheckValidDate(form.elements['Date(repayDate)'].value)))\r\n");
      out.write("\t    {\r\n");
      out.write("\t    \tisValid = false;\r\n");
      out.write("\t    \tform.elements['Date(repayDate)'].select();\r\n");
      out.write("\t    \treturn false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t}\t\r\n");
      out.write("\treturn result < 0;\r\n");
      out.write(" \t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkDate(form)\r\n");
      out.write("{\r\n");
      out.write("\tif(form.id.value !=\"\" && form.elements('Date(repayDate)').value !=\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif (CheckValidDate(form.elements('Date(repayDate)').value))\r\n");
      out.write("\t    {\r\n");
      out.write("\t    \tdoAction(\"DPMA0107\");\r\n");
      out.write("\t    }\r\n");
      out.write("\t    else\r\n");
      out.write("\t    {\r\n");
      out.write("\t    \tform.payType.value = \"\";\r\n");
      out.write("\t    \tform.elements('Date(repayDate)').select();\r\n");
      out.write("\t    }\r\n");
      out.write("\t}\r\n");
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
