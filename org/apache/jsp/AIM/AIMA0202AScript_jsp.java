package org.apache.jsp.AIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AIMA0202AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_bean_write_property_name_nobody.release();
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
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("function total(form)\r\n");
      out.write("{\r\n");
      out.write("\tissueAmount = ");
      if (_jspx_meth_bean_write_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\ttotalIssueAmount = ");
      out.print( request.getAttribute("totalIssueAmount") );
      out.write(";\r\n");
      out.write("\tissueAmountx = replaceAll(form.elements['BigDecimal(issueAmountx)'].value,\",\",\"\");\r\n");
      out.write("\tif( Number(issueAmountx) + Number(totalIssueAmount) <= issueAmount)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.MainForm.elements['BigDecimal(issueAmountx)'].value = addMoneyMask(issueAmountx);\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"總發行額大於發行金額，請重新輸入!\");\r\n");
      out.write("\t\tdocument.MainForm.elements['BigDecimal(issueAmountx)'].value = \"0\";\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkAmount(form)\r\n");
      out.write("{\r\n");
      out.write("\tissueRealAmount = ");
      out.print( request.getAttribute("issueRealAmount") );
      out.write(";\r\n");
      out.write("\ttotalRealAmount = ");
      out.print( request.getAttribute("totalRealAmount") );
      out.write(";\r\n");
      out.write("\tissueAmount = Number(replaceAll(form.elements['BigDecimal(issueAmountx)'].value,\",\",\"\"));\r\n");
      out.write("\trealAmount = Number(replaceAll(form.elements['BigDecimal(realAmount)'].value,\",\",\"\"));\r\n");
      out.write("\tif( Number(realAmount) + Number(totalRealAmount) > Number(issueRealAmount)){\r\n");
      out.write("\t\talert(\"總實收額大於實收額，請重新輸入!\");\r\n");
      out.write("\t\tdocument.MainForm.elements['BigDecimal(realAmount)'].value = \"0\";\r\n");
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

  private boolean _jspx_meth_bean_write_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_0.setParent(null);
    _jspx_th_bean_write_0.setName("Aima0202MForm");
    _jspx_th_bean_write_0.setProperty("issueAmount");
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_0);
    return false;
  }
}
