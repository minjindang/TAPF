package org.apache.jsp.GAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GAMA0102MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  document.getElementById(\"totalAmountid\").innerHTML =  \r\n");
      out.write("  addMoneyMask(Number(replaceAll(document.forms[0].elements['bigDecimal(issueAmountDet)'].value,\",\",\"\")) +  \r\n");
      out.write("  Number(replaceAll(document.forms[0].elements['bigDecimal(originInterestAmount)'].value,\",\",\"\")) );\r\n");
      out.write("  document.forms[0].elements['bigDecimal(totalAmount)'].value =  \r\n");
      out.write("  Number(replaceAll(document.forms[0].elements['bigDecimal(issueAmountDet)'].value,\",\",\"\")) +  \r\n");
      out.write("  Number(replaceAll(document.forms[0].elements['bigDecimal(originInterestAmount)'].value,\",\",\"\")) ;\r\n");
      out.write("}\r\n");
      out.write("function changeValue(form)\r\n");
      out.write("{\t\r\n");
      out.write("\tform.action = \"GAMA0102MLOAD\";\r\n");
      out.write("\tform.submit();\r\n");
      out.write("}\r\n");
      out.write("function changeAmount(form)\r\n");
      out.write("{\r\n");
      out.write("\tform.action = \"GAMA0102MCOUNT\";\r\n");
      out.write("\tform.submit();\r\n");
      out.write("}\r\n");
      out.write("function getSelectValue(form)\r\n");
      out.write("{\t\r\n");
      out.write("\tobj = form.bankCode_options;\r\n");
      out.write("\tgetBankRefId(form.bankCode.value);\r\n");
      out.write("\tif( obj.value!=\"\" )\r\n");
      out.write("\t\treturn obj.options[obj.selectedIndex].text;\r\n");
      out.write("\telse\r\n");
      out.write("\t\treturn \"\";\r\n");
      out.write("}\r\n");
      out.write("function rateLimit(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar tempValue = 0;\r\n");
      out.write("    var tempCount = form.elements['bigDecimal(compareRate)'].value;\r\n");
      out.write("    var tempLength = tempCount.length;\r\n");
      out.write("    if( tempCount.indexOf(\".\")< 0 )\r\n");
      out.write("    {\r\n");
      out.write("        tempValue = 0 ;\r\n");
      out.write("    }\t\r\n");
      out.write("    else\r\n");
      out.write("    {\r\n");
      out.write("        tempValue = tempCount.indexOf(\".\") - 3 ;\r\n");
      out.write("    }\r\n");
      out.write("    form.elements['bigDecimal(compareRate)'].value = tempCount.substring(tempValue,tempLength);\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write(" \tvar cols = new Array(\"budgetYear\",\"budgetCodeDebt\" , \"debtCodeDebt\", \"bankCode\" , \"bigDecimal(compareAmount)\" , \"bigDecimal(compareRate)\" , \"bigDecimal(issueAmountDet)\");\r\n");
      out.write("\tvar colNames = new Array(\"【預算年度】\",\"【預算別】\", \"【債務別】\", \"【銀行編號】\" , \"【比價金額】\" ,  \"【投標利率】\" , \"【得標金額】\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(colNames[result] + \"不可空白!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\tif(\"\" == form.bankId.value && result < 0 )\r\n");
      out.write("    {\r\n");
      out.write("    \talert(\"【銀行名稱】不可空白!\");\r\n");
      out.write("    \tresult = 1;\r\n");
      out.write("    }\r\n");
      out.write("    if (form.elements['date(dueDate)'].value < form.elements['date(issueDate)'].value )\r\n");
      out.write("    {\r\n");
      out.write("        alert(\"借款起日不可大於借款迄日!!\");\r\n");
      out.write("        result = 1;\r\n");
      out.write("    }\r\n");
      out.write("    if(\"\" == form.elements['bigDecimal(originInterestAmount)'].value && result < 0)\r\n");
      out.write("    {\r\n");
      out.write("    \talert(\"【利息】不可空白!\");\r\n");
      out.write("    \t result = 1;\r\n");
      out.write("    }\r\n");
      out.write("    if(\"\" == form.elements['bigDecimal(totalAmount)'].value && result < 0)\r\n");
      out.write("    {\r\n");
      out.write("    \talert(\"【本息合計】不可空白!\");\r\n");
      out.write("    \t result = 1;\r\n");
      out.write("    }\r\n");
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
