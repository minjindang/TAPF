package org.apache.jsp.AIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AIMA0101AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(7);
    _jspx_dependants.add("/common/taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-tiles.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/displaytag-12.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/c.tld");
  }

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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("var calendar = \r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\tdocument.MainForm.elements['payLimit'].value = \"5\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function checkForm(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\"issueSerial\" , \"bondKind\", \"bondType\", \"issueKind\", \"accountYear\", \"debtName\", \"Date(issueDate)\", \"BigDecimal(issueAmount)\", \"issueInterval\", \"rateKind\", \"BigDecimal(averageRate)\", \"Date(firstInterestDate)\", \"interestAlternate\", \"Date(firstRepayDate)\", \"repayAlternate\", \"payLimit\");\r\n");
      out.write("\tvar colNames = new Array(\"公債代號\", \"公債發行種類\", \"公債識別碼\", \"公債型式\", \"會計年度\", \"公債名稱\", \"發行日期\", \"發行額\", \"期限\", \"利率變動別\", \"利率年息\", \"首次付息日期\", \"付息次數\", \"首次還本日期\", \"還本次數\", \"有效兌付期限\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(\"【\" + colNames[result] + \"】，未輸入!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\treturn result < 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function count(form){\r\n");
      out.write("\tif(form.elements[\"interestAlternate\"].value != 0)\r\n");
      out.write("\t\tdocument.getElementById(\"repayInterestInterval\").innerHTML = ((form.elements[\"issueInterval\"].value * 12) / form.elements[\"interestAlternate\"].value) + \"月\";\r\n");
      out.write("\tif(form.elements[\"repayAlternate\"].value != 0)\r\n");
      out.write("\t\tdocument.getElementById(\"repayCapitalInterval\").innerHTML = ((form.elements[\"issueInterval\"].value * 12) / form.elements[\"repayAlternate\"].value) + \"月\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function changeList(form)\r\n");
      out.write("{\r\n");
      out.write("\tdoAction(\"AIMA0101ALIST\");\r\n");
      out.write("}\r\n");
      out.write("function changeIssueSerial(form){\r\n");
      out.write("\tif(form.serialNo.value != \"\"){\r\n");
      out.write("\t\tserialNo = form.serialNo.value;\r\n");
      out.write("\t\tif(parseInt(serialNo) < 10)\r\n");
      out.write("\t\t\tserialNo = \"0\"+serialNo;\r\n");
      out.write("\t\tdocument.MainForm.issueSerial.value = form.accountYear.value+\"-\"+serialNo;\r\n");
      out.write("\t\tdocument.getElementById(\"issueSerialLabel\").innerHTML = form.accountYear.value+\"-\"+serialNo;\r\n");
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
