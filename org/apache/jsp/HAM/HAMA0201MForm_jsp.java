package org.apache.jsp.HAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HAMA0201MForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_hidden_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_hidden_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_hidden_property_name_nobody.release();
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.release();
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

      out.write("<!--\r\n");
      out.write("程式目的：HAMA02文字\r\n");
      out.write("程式代號：HAMA02\r\n");
      out.write("程式日期：0950221\r\n");
      out.write("程式作者：FormBean Generator\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_html_hidden_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_html_hidden_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_html_hidden_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table class='table_1' width='100%'>\r\n");
      out.write("\t<!-- \r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item' colspan='4'>國稅：</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>公式計算：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>調節額：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item' colspan='4'>利息：</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>公式計算：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>調節額：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t -->\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>直轄市比例：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>縣市比例：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>鄉鎮市比例：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_6(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item' colspan='6'>地方稅：</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>直轄市比例：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_7(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>縣市比例：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_8(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>鄉鎮市比例：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_9(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item' colspan='6'>利息：</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>直轄市比例：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_10(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>縣市比例：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_11(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>鄉鎮市比例：</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_12(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
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

  private boolean _jspx_meth_html_hidden_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_0.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_0.setParent(null);
    _jspx_th_html_hidden_0.setName("Hama0201Form");
    _jspx_th_html_hidden_0.setProperty("id");
    int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
    if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_0);
    return false;
  }

  private boolean _jspx_meth_html_hidden_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_1 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_1.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_1.setParent(null);
    _jspx_th_html_hidden_1.setName("Hama0201Form");
    _jspx_th_html_hidden_1.setProperty("usrid");
    int _jspx_eval_html_hidden_1 = _jspx_th_html_hidden_1.doStartTag();
    if (_jspx_th_html_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_1);
    return false;
  }

  private boolean _jspx_meth_html_hidden_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_2 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_2.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_2.setParent(null);
    _jspx_th_html_hidden_2.setName("Hama0201Form");
    _jspx_th_html_hidden_2.setProperty("date(createDate)");
    int _jspx_eval_html_hidden_2 = _jspx_th_html_hidden_2.doStartTag();
    if (_jspx_th_html_hidden_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_2);
    return false;
  }

  private boolean _jspx_meth_html_text_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_0.setPageContext(_jspx_page_context);
    _jspx_th_html_text_0.setParent(null);
    _jspx_th_html_text_0.setName("Hama0201Form");
    _jspx_th_html_text_0.setStyle("text-align: right");
    _jspx_th_html_text_0.setProperty("nationa");
    _jspx_th_html_text_0.setSize("14");
    _jspx_th_html_text_0.setMaxlength("24");
    int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
    if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_0);
    return false;
  }

  private boolean _jspx_meth_html_text_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_1.setPageContext(_jspx_page_context);
    _jspx_th_html_text_1.setParent(null);
    _jspx_th_html_text_1.setName("Hama0201Form");
    _jspx_th_html_text_1.setStyle("text-align: right");
    _jspx_th_html_text_1.setProperty("nationb");
    _jspx_th_html_text_1.setSize("14");
    _jspx_th_html_text_1.setMaxlength("24");
    int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
    if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_1);
    return false;
  }

  private boolean _jspx_meth_html_text_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_2.setPageContext(_jspx_page_context);
    _jspx_th_html_text_2.setParent(null);
    _jspx_th_html_text_2.setName("Hama0201Form");
    _jspx_th_html_text_2.setStyle("text-align: right");
    _jspx_th_html_text_2.setProperty("locala");
    _jspx_th_html_text_2.setSize("14");
    _jspx_th_html_text_2.setMaxlength("24");
    int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
    if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_2);
    return false;
  }

  private boolean _jspx_meth_html_text_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_3.setPageContext(_jspx_page_context);
    _jspx_th_html_text_3.setParent(null);
    _jspx_th_html_text_3.setName("Hama0201Form");
    _jspx_th_html_text_3.setStyle("text-align: right");
    _jspx_th_html_text_3.setProperty("localb");
    _jspx_th_html_text_3.setSize("14");
    _jspx_th_html_text_3.setMaxlength("24");
    int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
    if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_3);
    return false;
  }

  private boolean _jspx_meth_html_text_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_4 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_4.setPageContext(_jspx_page_context);
    _jspx_th_html_text_4.setParent(null);
    _jspx_th_html_text_4.setName("Hama0201Form");
    _jspx_th_html_text_4.setStyle("text-align: right");
    _jspx_th_html_text_4.setProperty("nationa");
    _jspx_th_html_text_4.setSize("14");
    _jspx_th_html_text_4.setMaxlength("24");
    int _jspx_eval_html_text_4 = _jspx_th_html_text_4.doStartTag();
    if (_jspx_th_html_text_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_4);
    return false;
  }

  private boolean _jspx_meth_html_text_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_5 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_5.setPageContext(_jspx_page_context);
    _jspx_th_html_text_5.setParent(null);
    _jspx_th_html_text_5.setName("Hama0201Form");
    _jspx_th_html_text_5.setStyle("text-align: right");
    _jspx_th_html_text_5.setProperty("nationb");
    _jspx_th_html_text_5.setSize("14");
    _jspx_th_html_text_5.setMaxlength("24");
    int _jspx_eval_html_text_5 = _jspx_th_html_text_5.doStartTag();
    if (_jspx_th_html_text_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_5);
    return false;
  }

  private boolean _jspx_meth_html_text_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_6 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_6.setPageContext(_jspx_page_context);
    _jspx_th_html_text_6.setParent(null);
    _jspx_th_html_text_6.setName("Hama0201Form");
    _jspx_th_html_text_6.setStyle("text-align: right");
    _jspx_th_html_text_6.setProperty("nationc");
    _jspx_th_html_text_6.setSize("14");
    _jspx_th_html_text_6.setMaxlength("24");
    int _jspx_eval_html_text_6 = _jspx_th_html_text_6.doStartTag();
    if (_jspx_th_html_text_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_6);
    return false;
  }

  private boolean _jspx_meth_html_text_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_7 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_7.setPageContext(_jspx_page_context);
    _jspx_th_html_text_7.setParent(null);
    _jspx_th_html_text_7.setName("Hama0201Form");
    _jspx_th_html_text_7.setStyle("text-align: right");
    _jspx_th_html_text_7.setProperty("locala");
    _jspx_th_html_text_7.setSize("14");
    _jspx_th_html_text_7.setMaxlength("24");
    int _jspx_eval_html_text_7 = _jspx_th_html_text_7.doStartTag();
    if (_jspx_th_html_text_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_7);
    return false;
  }

  private boolean _jspx_meth_html_text_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_8 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_8.setPageContext(_jspx_page_context);
    _jspx_th_html_text_8.setParent(null);
    _jspx_th_html_text_8.setName("Hama0201Form");
    _jspx_th_html_text_8.setStyle("text-align: right");
    _jspx_th_html_text_8.setProperty("localb");
    _jspx_th_html_text_8.setSize("14");
    _jspx_th_html_text_8.setMaxlength("24");
    int _jspx_eval_html_text_8 = _jspx_th_html_text_8.doStartTag();
    if (_jspx_th_html_text_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_8);
    return false;
  }

  private boolean _jspx_meth_html_text_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_9 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_9.setPageContext(_jspx_page_context);
    _jspx_th_html_text_9.setParent(null);
    _jspx_th_html_text_9.setName("Hama0201Form");
    _jspx_th_html_text_9.setStyle("text-align: right");
    _jspx_th_html_text_9.setProperty("localc");
    _jspx_th_html_text_9.setSize("14");
    _jspx_th_html_text_9.setMaxlength("24");
    int _jspx_eval_html_text_9 = _jspx_th_html_text_9.doStartTag();
    if (_jspx_th_html_text_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_9);
    return false;
  }

  private boolean _jspx_meth_html_text_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_10 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_10.setPageContext(_jspx_page_context);
    _jspx_th_html_text_10.setParent(null);
    _jspx_th_html_text_10.setName("Hama0201Form");
    _jspx_th_html_text_10.setStyle("text-align: right");
    _jspx_th_html_text_10.setProperty("inta");
    _jspx_th_html_text_10.setSize("14");
    _jspx_th_html_text_10.setMaxlength("24");
    int _jspx_eval_html_text_10 = _jspx_th_html_text_10.doStartTag();
    if (_jspx_th_html_text_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_10);
    return false;
  }

  private boolean _jspx_meth_html_text_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_11 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_11.setPageContext(_jspx_page_context);
    _jspx_th_html_text_11.setParent(null);
    _jspx_th_html_text_11.setName("Hama0201Form");
    _jspx_th_html_text_11.setStyle("text-align: right");
    _jspx_th_html_text_11.setProperty("intb");
    _jspx_th_html_text_11.setSize("14");
    _jspx_th_html_text_11.setMaxlength("24");
    int _jspx_eval_html_text_11 = _jspx_th_html_text_11.doStartTag();
    if (_jspx_th_html_text_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_11);
    return false;
  }

  private boolean _jspx_meth_html_text_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_12 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_12.setPageContext(_jspx_page_context);
    _jspx_th_html_text_12.setParent(null);
    _jspx_th_html_text_12.setName("Hama0201Form");
    _jspx_th_html_text_12.setStyle("text-align: right");
    _jspx_th_html_text_12.setProperty("intc");
    _jspx_th_html_text_12.setSize("14");
    _jspx_th_html_text_12.setMaxlength("24");
    int _jspx_eval_html_text_12 = _jspx_th_html_text_12.doStartTag();
    if (_jspx_th_html_text_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_12);
    return false;
  }
}
