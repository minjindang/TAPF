package org.apache.jsp.DIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DIMA0202MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      _jspx_th_bean_define_0.setId("bank");
      _jspx_th_bean_define_0.setName("Dima0202Form");
      _jspx_th_bean_define_0.setProperty("bank");
      _jspx_th_bean_define_0.setType("tw.gov.nta.sql.debt.BankRef");
      int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
      if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
      tw.gov.nta.sql.debt.BankRef bank = null;
      bank = (tw.gov.nta.sql.debt.BankRef) _jspx_page_context.findAttribute("bank");
      out.write('\r');
      out.write('\n');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_1.setParent(null);
      _jspx_th_bean_define_1.setId("bankCode");
      _jspx_th_bean_define_1.setName("bank");
      _jspx_th_bean_define_1.setProperty("bankCode");
      _jspx_th_bean_define_1.setType("java.lang.String");
      int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
      if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
      java.lang.String bankCode = null;
      bankCode = (java.lang.String) _jspx_page_context.findAttribute("bankCode");
      out.write('\r');
      out.write('\n');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_2 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_2.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_2.setParent(null);
      _jspx_th_bean_define_2.setId("issueAmount");
      _jspx_th_bean_define_2.setName("Dima0202Form");
      _jspx_th_bean_define_2.setProperty("issueAmount");
      _jspx_th_bean_define_2.setType("java.math.BigDecimal");
      int _jspx_eval_bean_define_2 = _jspx_th_bean_define_2.doStartTag();
      if (_jspx_th_bean_define_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_2);
      java.math.BigDecimal issueAmount = null;
      issueAmount = (java.math.BigDecimal) _jspx_page_context.findAttribute("issueAmount");
      out.write('\r');
      out.write('\n');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_3 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_3.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_3.setParent(null);
      _jspx_th_bean_define_3.setId("originInterestAmount");
      _jspx_th_bean_define_3.setName("Dima0202Form");
      _jspx_th_bean_define_3.setProperty("originInterestAmount");
      _jspx_th_bean_define_3.setType("java.math.BigDecimal");
      int _jspx_eval_bean_define_3 = _jspx_th_bean_define_3.doStartTag();
      if (_jspx_th_bean_define_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_3);
      java.math.BigDecimal originInterestAmount = null;
      originInterestAmount = (java.math.BigDecimal) _jspx_page_context.findAttribute("originInterestAmount");
      out.write('\r');
      out.write('\n');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_4 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_4.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_4.setParent(null);
      _jspx_th_bean_define_4.setId("issueDate");
      _jspx_th_bean_define_4.setName("Dima0202Form");
      _jspx_th_bean_define_4.setProperty("date(issueDate)");
      _jspx_th_bean_define_4.setType("java.lang.String");
      int _jspx_eval_bean_define_4 = _jspx_th_bean_define_4.doStartTag();
      if (_jspx_th_bean_define_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_4);
      java.lang.String issueDate = null;
      issueDate = (java.lang.String) _jspx_page_context.findAttribute("issueDate");
      out.write('\r');
      out.write('\n');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_5 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_5.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_5.setParent(null);
      _jspx_th_bean_define_5.setId("dueDate");
      _jspx_th_bean_define_5.setName("Dima0202Form");
      _jspx_th_bean_define_5.setProperty("date(dueDate)");
      _jspx_th_bean_define_5.setType("java.lang.String");
      int _jspx_eval_bean_define_5 = _jspx_th_bean_define_5.doStartTag();
      if (_jspx_th_bean_define_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_5);
      java.lang.String dueDate = null;
      dueDate = (java.lang.String) _jspx_page_context.findAttribute("dueDate");
      out.write("\r\n");
      out.write("<script language=\"Javascript\" src=\"/tapf/assets/scripts/getDataBankId.js\"></script>\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("function getAmount()\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\tissueAmount\t\t=\treplaceAll(currform.elements['bigDecimal(issueAmount)'].value,\",\",\"\");\r\n");
      out.write("\tvar\tcompareRate\t\t=\treplaceAll(currform.elements['bigDecimal(compareRate)'].value,\",\",\"\");\r\n");
      out.write("\tvar\tdays\t\t=\tcurrform.days.value.substring(0,((currform.days.value).length));\r\n");
      out.write("\tvar\toriginInterestAmount=0;\r\n");
      out.write("\tif( 0 !=issueAmount  && 0!=compareRate)\r\n");
      out.write("\t{\t//issueAmount * compareRate/100*days/365;\r\n");
      out.write("\t\tvar issueDate = '");
      out.print(issueDate);
      out.write("';\r\n");
      out.write("\t\tvar dueDate = '");
      out.print(dueDate);
      out.write("';\r\n");
      out.write("\t\tvar bascDate = 365;\r\n");
      out.write("\r\n");
      out.write("\t\tvar year1 = 1911+parseInt(issueDate.substring(0,3),10);\r\n");
      out.write("\t\tvar mon1 = parseInt(issueDate.substring(3,5),10);\r\n");
      out.write("\t\tvar day1 = parseInt(issueDate.substring(5,7),10);\r\n");
      out.write("\t\tvar year2 = 1911+parseInt(dueDate.substring(0,3),10);\r\n");
      out.write("\t\tvar mon2 = parseInt(dueDate.substring(3,5),10);\r\n");
      out.write("\t\tvar day2 = parseInt(dueDate.substring(5,7),10);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar begMyDate = new Date(year1, mon1, day1);\r\n");
      out.write("\t\tvar EbegMyDate = new Date(year1, 12, 31);\r\n");
      out.write("\t\tvar endMyDate = new Date(year2, mon2, day2);\r\n");
      out.write("\t\tvar SbegMyDate = new Date(year2, 1, 1);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (parseInt(year1)-parseInt(year2)==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tbascDate = ((endMyDate-begMyDate) / 86400000 + 1 );\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tbascDate = ((EbegMyDate-begMyDate) / 86400000 + 1 )+((endMyDate-SbegMyDate) / 86400000 + 1 );\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\toriginInterestAmount = Math.round((parseFloat(issueAmount) * (parseFloat(compareRate)/100)*parseFloat(days))/bascDate);\r\n");
      out.write("\t\tcurrform.elements['bigDecimal(originInterestAmount)'].value = Math.round(parseFloat(originInterestAmount));\r\n");
      out.write("\t\tcurrform.elements['bigDecimal(allAmount)'].value = Math.round(parseFloat(originInterestAmount)+parseFloat(issueAmount));\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function getTotalAmount()\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\tissueAmount\t\t=\treplaceAll(currform.elements['bigDecimal(issueAmount)'].value,\",\",\"\");\r\n");
      out.write("\tvar\toriginInterestAmount = replaceAll(currform.elements['bigDecimal(originInterestAmount)'].value,\",\",\"\");\r\n");
      out.write("\t//var day = new Day();\r\n");
      out.write("\tif( 0 !=issueAmount  && 0!=originInterestAmount)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tcurrform.elements['bigDecimal(allAmount)'].value =  addMoneyMask(Math.round(parseFloat(originInterestAmount)+parseFloat(issueAmount)));\r\n");
      out.write("\t\t//return currform.allAmount.value;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write(" \tvar isValid = true;\r\n");
      out.write("    var sError = \"\";\r\n");
      out.write("\tif (\"\" == form.bankCode.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【銀行編號】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.elements['bigDecimal(compareAmount)'].value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【比價金額】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.elements['bigDecimal(compareRate)'].value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【利率】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (false == isValid)\r\n");
      out.write("    {\r\n");
      out.write("    \talert(sError);\r\n");
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
