package org.apache.jsp.BIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BIMA0102MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- BIMA0102MScript.jsp\r\n");
      out.write("程式目的：BIMA01\r\n");
      out.write("程式代號：BIMA01\r\n");
      out.write("程式日期：0950302\r\n");
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
      _jspx_th_bean_define_0.setId("ticketAmount");
      _jspx_th_bean_define_0.setName("Bima0102Form");
      _jspx_th_bean_define_0.setProperty("ticketAmount");
      _jspx_th_bean_define_0.setType("java.math.BigDecimal");
      int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
      if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
      java.math.BigDecimal ticketAmount = null;
      ticketAmount = (java.math.BigDecimal) _jspx_page_context.findAttribute("ticketAmount");
      out.write('\r');
      out.write('\n');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_1.setParent(null);
      _jspx_th_bean_define_1.setId("ticketCount");
      _jspx_th_bean_define_1.setName("Bima0102Form");
      _jspx_th_bean_define_1.setProperty("ticketCount");
      _jspx_th_bean_define_1.setType("java.lang.Long");
      int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
      if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
      java.lang.Long ticketCount = null;
      ticketCount = (java.lang.Long) _jspx_page_context.findAttribute("ticketCount");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("  \tvar ticketAmount = ");
      out.print(ticketAmount);
      out.write(";\r\n");
      out.write("\tvar ticketCount = ");
      out.print(ticketCount);
      out.write(";\r\n");
      out.write("\tdocument.MainForm.elements['bigDecimal(totalAmount)'].value = addMoneyMask(ticketAmount*ticketCount);\r\n");
      out.write("\t//document.MainForm.elements['bigDecimal(ticketAmount)'].selectedIndex = 1;\r\n");
      out.write("\tdocument.MainForm.elements['bigDecimal(ticketAmount)'].value = ticketAmount;\r\n");
      out.write("}\r\n");
      out.write("function getTotalAmount()\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\tticketAmount\t\t=\tcurrform.elements['bigDecimal(ticketAmount)'].value;\r\n");
      out.write("\tvar\tticketCount \t=\tcurrform.ticketCount.value\r\n");
      out.write("\t\r\n");
      out.write("\tif (ticketAmount != \"\" && ticketCount != \"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tcurrform.elements['bigDecimal(totalAmount)'].value = addMoneyMask(Number(replaceAll(ticketAmount,\",\",\"\"))* Number(replaceAll(ticketCount,\",\",\"\")));\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write(" \tvar isValid = true;\r\n");
      out.write("    var sError = \"\";\r\n");
      out.write("    if (\"\" == form.elements['bigDecimal(ticketAmount)'].value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"面額種類不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("     if (\"\" == form.ticketCount.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"張數不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (false == isValid)\r\n");
      out.write("    {\r\n");
      out.write("    \talert(sError);\r\n");
      out.write("    }\r\n");
      out.write("\t\treturn isValid;\r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
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
