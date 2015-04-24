package org.apache.jsp.AIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AIMA0301AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\t\t//do nothing\r\n");
      out.write("}\r\n");
      out.write("function countMoney(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar issueAmount = form.elements['BigDecimal(issueAmount)'].value;\r\n");
      out.write("\tvar getPrice = form.elements['BigDecimal(getPrice)'].value;\r\n");
      out.write("\tvar sellAmount = form.elements['BigDecimal(sellAmount)'];\r\n");
      out.write("\tif(null != issueAmount && \"\" != issueAmount && null != getPrice && \"\" != getPrice )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tsellAmount.value =  addMoneyMask(Number(replaceAll(issueAmount,\",\",\"\")) * (Number(replaceAll(getPrice,\",\",\"\")) / 100) - Number(replaceAll(issueAmount,\",\",\"\"))) ;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkForm(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(     \"issueSerial\" , \"debtName\",  \"bondType\",   \"budgetCode\", \"debtCode\", \"serialNo\", \"issueDate\", \"issueAmount\", \"Date(issueDate)\", \"BigDecimal(issueAmount)\" ,\"issueInterval\", \"BigDecimal(averageRate)\", \"BigDecimal(backRate)\", \"BigDecimal(saleRate)\", \"BigDecimal(originalPrice)\", \"BigDecimal(getPrice)\", \"BigDecimal(foreignCapital)\", \"exchangeStockCode\", \"bankCode\");\r\n");
      out.write("\tvar colNames = new Array(\"公債代號\",       \"公債名稱\", \"公債識別碼\", \"預算別\",     \"債務別\",   \"公債期次\", \"發行日期\",  \"發行額\",      \"發行日期\",        \"發行額\",                  \"期限\",          \"利率年息\",                \"收回收益率\",           \"賣回收益率\",           \"原始交換價格\",              \"得標價格\",             \"外資得標上限\",               \"交換標的\",          \"服務處理機構\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(\"【\" + colNames[result] + \"】，未輸入!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\treturn result < 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function count(form){\r\n");
      out.write("\tvar issueDate = form.elements[\"Date(issueDate)\"].value;\r\n");
      out.write("\tvar issueInterval = form.elements[\"issueInterval\"].value;\r\n");
      out.write("\tif(issueDate == null || issueInterval == null || issueDate.length != 7 || issueInterval == \"\")\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\tvar year = Number(issueDate.substring(0, 3)) + Number(issueInterval);\r\n");
      out.write("\tvar date = year + issueDate.substring(3);\r\n");
      out.write("\t\r\n");
      out.write("\tfor(var i = 0 ; i < 7 - date.length ; i++)\r\n");
      out.write("\t\tdate = \"0\" + date;\r\n");
      out.write("\t//document.getElementById(\"dueDate\").innerHTML = date;\r\n");
      out.write("\tdocument.MainForm.elements[\"Date(dueDate)\"].value = date;\r\n");
      out.write("}\r\n");
      out.write("function count2(form){\r\n");
      out.write("\tvar issueDate = form.elements[\"Date(issueDate)\"].value;\r\n");
      out.write("\tvar dueDate = form.elements[\"Date(dueDate)\"].value;\r\n");
      out.write("\tif(issueDate == null || dueDate == null || issueDate.length != 7 || dueDate.length != 7 )\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\tvar issueInterval = Number(dueDate.substring(0, 3)) - Number(issueDate.substring(0, 3));\r\n");
      out.write("\tdocument.MainForm.elements[\"issueInterval\"].value = issueInterval;\r\n");
      out.write("}\r\n");
      out.write("function changeList(form)\r\n");
      out.write("{\r\n");
      out.write("\tdoAction(\"AIMA0301AList\");\r\n");
      out.write("}\r\n");
      out.write("function getDebtName(form)\r\n");
      out.write("{\r\n");
      out.write("\tif(form.issueSerial.value != \"\")\r\n");
      out.write("\t\tdocument.MainForm.elements['debtName'].value = form.issueSerial.value + \"交換公債\";\r\n");
      out.write("\telse\r\n");
      out.write("\t\tdocument.MainForm.elements['debtName'].value = \"\";\r\n");
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
