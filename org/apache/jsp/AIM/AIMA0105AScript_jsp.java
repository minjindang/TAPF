package org.apache.jsp.AIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AIMA0105AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\t//var oNumberMask = new Mask(\"#,###\", \"number\");\r\n");
      out.write("\t//var moneyCols = new Array(\"BigDecimal(buyAmount)\",\"BigDecimal(advanceInterest)\",\"BigDecimal(advanceTax)\",\"BigDecimal(finalAmount)\",\"BigDecimal(buyPremium)\");\r\n");
      out.write("\t//for(var i = 0 ; i < moneyCols.length ; i++)\r\n");
      out.write("\t//{\r\n");
      out.write("\t\t//oNumberMask.attach(document.MainForm.elements[moneyCols[i]]);\r\n");
      out.write("\t\t//document.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);\r\n");
      out.write("\t//}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkData(form)\r\n");
      out.write("{\r\n");
      out.write("\tadvanceAmount = replaceAll(form.elements['BigDecimal(advanceAmount)'].value,\",\",\"\");\r\n");
      out.write("\tadvanceRate = form.elements['BigDecimal(advanceRate)'].value;\r\n");
      out.write("\tadvanceDate = form.elements['Date(advanceDate)'].value;\r\n");
      out.write("\t\r\n");
      out.write("\tvar message = \"\";\r\n");
      out.write("\tif(null == advanceAmount || \"\" == advanceAmount || \"0\" == advanceAmount)\r\n");
      out.write("\t\tmessage += \"[提前買回金額]未輸入!!\\n\";\r\n");
      out.write("\tif(null == advanceRate || \"\" == advanceRate)\r\n");
      out.write("\t\tmessage += \"[最低得僄利率]未輸入!!\\n\";\r\n");
      out.write("\tif(null == advanceDate || \"\" == advanceDate)\r\n");
      out.write("\t\tmessage += \"[提前買回日期]未輸入!!\\n\"\r\n");
      out.write("\t\t\r\n");
      out.write("\tif(\"\" == message) {\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\talert(message);\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkData1(form)\r\n");
      out.write("{\r\n");
      out.write("\tadvanceAmount = form.elements['BigDecimal(advanceAmount)'].value;\r\n");
      out.write("\tadvanceRate = form.elements['BigDecimal(advanceRate)'].value;\r\n");
      out.write("\tadvanceDate = form.elements['Date(advanceDate)'].value;\r\n");
      out.write("\t\r\n");
      out.write("\tvar message = \"\";\r\n");
      out.write("\tif(null == advanceAmount || \"\" == advanceAmount || \"0\" == advanceAmount)\r\n");
      out.write("\t\tmessage += \"[提前買回金額]未輸入!!\\n\";\r\n");
      out.write("\tif(null == advanceRate || \"\" == advanceRate)\r\n");
      out.write("\t\tmessage += \"[最低得僄利率]未輸入!!\\n\";\r\n");
      out.write("\tif(null == advanceDate || \"\" == advanceDate)\r\n");
      out.write("\t\tmessage += \"[提前買回日期]未輸入!!\\n\"\r\n");
      out.write("\tbuyAmount = form.elements['BigDecimal(buyAmount)'].value;\r\n");
      out.write("\tif(\"\" == message && (null == buyAmount || \"\" == buyAmount || \"0\" == buyAmount))\r\n");
      out.write("\t\tmessage += \"尚未執行[試算]，請先執行[試算]後，確認各項無誤後，再新增!!\";\r\n");
      out.write("\t\t\r\n");
      out.write("\tif(\"\" == message) {\r\n");
      out.write("\t\tmessage += \"您輸入的[提前買回金額]為\"+advanceAmount+\"\\n\";\r\n");
      out.write("\t\tmessage += \"您輸入的[最低得僄利率]為\"+advanceRate+\"\\n\";\r\n");
      out.write("\t\tmessage += \"您輸入的[提前買回日期]為\"+advanceDate+\"\\n\";\r\n");
      out.write("\t\talert(message);\r\n");
      out.write("\t\tadvanceInterest = form.elements['BigDecimal(advanceInterest)'].value;\r\n");
      out.write("\t\tbuyPremium = form.elements['BigDecimal(buyPremium)'].value;\r\n");
      out.write("\t\tadvanceTax = form.elements['BigDecimal(advanceTax)'].value;\r\n");
      out.write("\t\tfinalAmount = form.elements['BigDecimal(finalAmount)'].value;\r\n");
      out.write("\t\tmessage = \"計算後的[買回價款]為\"+buyAmount+\"\\n\";\r\n");
      out.write("\t\tmessage += \"計算後的[應計利息]為\"+advanceInterest+\"\\n\";\r\n");
      out.write("\t\tmessage += \"計算後的[買回溢(折)價]為\"+buyPremium+\"\\n\";\r\n");
      out.write("\t\tmessage += \"計算後的[應扣累計稅款]為\"+advanceTax+\"\\n\";\r\n");
      out.write("\t\tmessage += \"計算後的[稅後買進金額]為\"+finalAmount+\"\\n\";\r\n");
      out.write("\t\tmessage += \"請確認計算後各項金額是否正確!!!\";\r\n");
      out.write("\t\talert(message);\r\n");
      out.write("\t\treturn confirm(\"新增後將無法修改，是否確認新增!!\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\talert(message);\r\n");
      out.write("\t\treturn false;\r\n");
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
