package org.apache.jsp.DIR;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DIRA0601QForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_size_property_name_maxlength_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_size_property_onblur_name_maxlength_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_size_property_onblur_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.release();
    _jspx_tagPool_html_text_size_property_onblur_name_maxlength_nobody.release();
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
      out.write("<table class='table_1' width='100%'>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>年度(起)</td>\r\n");
      out.write("\t\t<td class='table_td' colspan=\"3\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_0(_jspx_page_context))
        return;
      out.write("<font size='2'>  例:\"095\"</font>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>年度(迄)</td>\r\n");
      out.write("\t\t<td class='table_td' colspan=\"3\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_1(_jspx_page_context))
        return;
      out.write("<font size='2'>  例:\"095\"</font>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t<tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("\t\t<td class='table_item'>到期日</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      out.print(gov.dnt.tame.util.CommonFun.addCalendar("date(dueDate)", new Integer(0)));
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<!-- tr>\r\n");
      out.write("\t\t<td class='table_item'>期別(起)</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>期別(迄)</td>\r\n");
      out.write("\t\t<td class='table_td' >\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>借款日(起)</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
//gov.dnt.tame.util.CommonFun.addCalendar("date(startDate)", new Integer(0))
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>借款日(迄)</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_6(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
//gov.dnt.tame.util.CommonFun.addCalendar("date(endDate)", new Integer(1))
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t<tr -->\r\n");
      out.write("</table>");
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

  private boolean _jspx_meth_html_text_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_0.setPageContext(_jspx_page_context);
    _jspx_th_html_text_0.setParent(null);
    _jspx_th_html_text_0.setName("Dira0701Form");
    _jspx_th_html_text_0.setProperty("begAccYear");
    _jspx_th_html_text_0.setSize("10");
    _jspx_th_html_text_0.setMaxlength("3");
    int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
    if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_0);
    return false;
  }

  private boolean _jspx_meth_html_text_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_1.setPageContext(_jspx_page_context);
    _jspx_th_html_text_1.setParent(null);
    _jspx_th_html_text_1.setName("Dira0701Form");
    _jspx_th_html_text_1.setProperty("endAccYear");
    _jspx_th_html_text_1.setSize("10");
    _jspx_th_html_text_1.setMaxlength("3");
    int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
    if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_1);
    return false;
  }

  private boolean _jspx_meth_html_text_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onblur_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_2.setPageContext(_jspx_page_context);
    _jspx_th_html_text_2.setParent(null);
    _jspx_th_html_text_2.setName("Dira0701Form");
    _jspx_th_html_text_2.setProperty("date(dueDate)");
    _jspx_th_html_text_2.setSize("15");
    _jspx_th_html_text_2.setMaxlength("7");
    _jspx_th_html_text_2.setOnblur("");
    int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
    if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onblur_name_maxlength_nobody.reuse(_jspx_th_html_text_2);
    return false;
  }

  private boolean _jspx_meth_html_text_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_3.setPageContext(_jspx_page_context);
    _jspx_th_html_text_3.setParent(null);
    _jspx_th_html_text_3.setName("Dira0701Form");
    _jspx_th_html_text_3.setProperty("startSerial");
    _jspx_th_html_text_3.setSize("10");
    _jspx_th_html_text_3.setMaxlength("10");
    int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
    if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_3);
    return false;
  }

  private boolean _jspx_meth_html_text_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_4 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_4.setPageContext(_jspx_page_context);
    _jspx_th_html_text_4.setParent(null);
    _jspx_th_html_text_4.setName("Dira0701Form");
    _jspx_th_html_text_4.setProperty("endSerial");
    _jspx_th_html_text_4.setSize("10");
    _jspx_th_html_text_4.setMaxlength("10");
    int _jspx_eval_html_text_4 = _jspx_th_html_text_4.doStartTag();
    if (_jspx_th_html_text_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_4);
    return false;
  }

  private boolean _jspx_meth_html_text_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_5 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_5.setPageContext(_jspx_page_context);
    _jspx_th_html_text_5.setParent(null);
    _jspx_th_html_text_5.setName("Dira0701Form");
    _jspx_th_html_text_5.setProperty("date(startDate)");
    _jspx_th_html_text_5.setSize("15");
    _jspx_th_html_text_5.setMaxlength("7");
    int _jspx_eval_html_text_5 = _jspx_th_html_text_5.doStartTag();
    if (_jspx_th_html_text_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_5);
    return false;
  }

  private boolean _jspx_meth_html_text_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_6 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_6.setPageContext(_jspx_page_context);
    _jspx_th_html_text_6.setParent(null);
    _jspx_th_html_text_6.setName("Dira0701Form");
    _jspx_th_html_text_6.setProperty("date(endDate)");
    _jspx_th_html_text_6.setSize("15");
    _jspx_th_html_text_6.setMaxlength("7");
    int _jspx_eval_html_text_6 = _jspx_th_html_text_6.doStartTag();
    if (_jspx_th_html_text_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_6);
    return false;
  }
}
