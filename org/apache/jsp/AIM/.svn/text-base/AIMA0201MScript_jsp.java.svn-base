package org.apache.jsp.AIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AIMA0201MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\tcountDay(document.MainForm);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkForm(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\"addSourceIssueId_options\",\"Date(issueDate)\",\"issueSerial\",\"bondType_options\",\"debtName\",\"issueKind_options\",\"bondSellStatus\",\"rateKind_options\",\"BigDecimal(issueAmount)\",\"BigDecimal(realAmount)\");\r\n");
      out.write("\tvar colNames = new Array(\"原始發行公債名稱\",\"增額發行日期\",\"增額公債代號\",\"增額公債識別碼\",\"增額公債名稱\",\"增額公債形式\",\"可分割公債\",\"利率變動別\",\"發行額\",\"實收數\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(\"【\" + colNames[result] + \"】，未輸入!!\");\r\n");
      out.write("\t\tform.focus(cols[result]);\r\n");
      out.write("\t}\r\n");
      out.write("\treturn result < 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function countDay(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar newDate = form.elements['Date(issueDate)'].value;\r\n");
      out.write("\tvar oldDate = form.elements['soruceIssueDate'].value;\r\n");
      out.write("\tif(\"\" != newDate && \"\" != oldDate)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.getElementById('diff').innerHTML = daycount(oldDate,newDate,'C');\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function count(form){\r\n");
      out.write("\tif(form.elements[\"interestAlternate\"].value != 0)\r\n");
      out.write("\t\tdocument.getElementById(\"repayInterestInterval\").innerHTML = ((form.elements[\"issueInterval\"].value * 12) / form.elements[\"interestAlternate\"].value) + \"月\";\r\n");
      out.write("\tif(form.elements[\"repayAlternate\"].value != 0)\r\n");
      out.write("\t\tdocument.getElementById(\"repayCapitalInterval\").innerHTML = ((form.elements[\"issueInterval\"].value * 12) / form.elements[\"repayAlternate\"].value) + \"月\";\r\n");
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
