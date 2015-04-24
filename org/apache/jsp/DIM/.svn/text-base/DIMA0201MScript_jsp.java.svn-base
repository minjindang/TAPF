package org.apache.jsp.DIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DIMA0201MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_property_name_id_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_bean_define_type_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_bean_define_type_property_name_id_nobody.release();
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
      out.write("程式作者：Eric.Chen\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_0.setParent(null);
      _jspx_th_bean_define_0.setId("issueDate");
      _jspx_th_bean_define_0.setName("Dima0201Form");
      _jspx_th_bean_define_0.setProperty("date(issueDate)");
      _jspx_th_bean_define_0.setType("java.lang.String");
      int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
      if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
      java.lang.String issueDate = null;
      issueDate = (java.lang.String) _jspx_page_context.findAttribute("issueDate");
      out.write('\r');
      out.write('\n');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_1.setParent(null);
      _jspx_th_bean_define_1.setId("dueDate");
      _jspx_th_bean_define_1.setName("Dima0201Form");
      _jspx_th_bean_define_1.setProperty("date(dueDate)");
      _jspx_th_bean_define_1.setType("java.lang.String");
      int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
      if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
      java.lang.String dueDate = null;
      dueDate = (java.lang.String) _jspx_page_context.findAttribute("dueDate");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("var days;\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\t\r\n");
      out.write("\tvar issueDate = '");
      out.print(issueDate);
      out.write("';\r\n");
      out.write("\tvar dueDate = '");
      out.print(dueDate);
      out.write("';\r\n");
      out.write("\tdocument.MainForm.days.value = daycount(issueDate,dueDate,\"C\");\r\n");
      out.write("\tdocument.getElementById(\"dayid\").innerHTML = daycount(issueDate,dueDate,\"C\") ;\r\n");
      out.write("}\r\n");
      out.write("function getIssueSerial()\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\taccountYear\t\t=\tcurrform.accountYear.value;\r\n");
      out.write("\tvar\tserialNo\t=\tcurrform.serialNo.value;\r\n");
      out.write("\tif( \"\"!=accountYear && \"\"!=serialNo )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tcurrform.issueSerial.value = accountYear+\"-\"+serialNo\r\n");
      out.write("\t\treturn currform.issueSerial.value;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function getDays()\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\tissueDate\t\t=\tcurrform.elements['date(issueDate)'].value;\r\n");
      out.write("\tvar\tdueDate \t=\tcurrform.elements['date(dueDate)'].value\r\n");
      out.write("\t\r\n");
      out.write("\tif (!(CheckValidDate(issueDate)))\r\n");
      out.write("    {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("\tif (!(CheckValidDate(dueDate)))\r\n");
      out.write("    {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("\tdays = daycount(issueDate,dueDate,\"C\")\r\n");
      out.write("\tdocument.getElementById(\"dayid\").innerHTML = daycount(issueDate,dueDate,\"C\") ;\r\n");
      out.write("\tcurrform.days.value = days\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write(" \tvar isValid = true;\r\n");
      out.write("    var sError = \"\";\r\n");
      out.write("\tif (\"\" == form.accountYear.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【年度】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.serialNo.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【期次】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.debtCode.value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【預算別】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.budgetCode.value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【債務別】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.elements['date(issueDate)'].value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【借款起日】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.elements['date(dueDate)'].value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【借款迄日】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.debtName.value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【名稱】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.elements['bigDecimal(expectAmount)'].value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【預計借款金額】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (false == isValid)\r\n");
      out.write("    {\r\n");
      out.write("    \talert(sError);\r\n");
      out.write("    }\r\n");
      out.write("\t\treturn isValid;\r\n");
      out.write("}\r\n");
      out.write("function getAmount(num)\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\tissueAmount\t\t=\treplaceAll(currform.elements['debtMain['+num+'].issueAmount'].value,\",\",\"\");\r\n");
      out.write("\tvar\tcompareRate\t\t=\treplaceAll(document.getElementById('compareRate['+num+']').innerHTML,\",\",\"\");\r\n");
      out.write("\tvar\tdays\t\t=\tcurrform.days.value.substring(0,((currform.days.value).length)-1);\r\n");
      out.write("\tif( 0 !=issueAmount  && 0!=compareRate)\r\n");
      out.write("\t{\r\n");
      out.write("\t\toriginInterestAmount = issueAmount * compareRate/100*days/365;\r\n");
      out.write("\t\tdocument.getElementById('originInterestAmount['+num+']').innerHTML = addMoneyMask(Math.round(parseFloat(originInterestAmount)));\r\n");
      out.write("\t\tdocument.getElementById('totalAmount['+num+']').innerHTML = addMoneyMask(Math.round(parseFloat(originInterestAmount)+parseFloat(issueAmount)));\r\n");
      out.write("\t\tcurrform.elements['debtMain['+num+'].originInterestAmount'].value = Math.round(originInterestAmount);\r\n");
      out.write("\t\t//return currform.allAmount.value;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
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
