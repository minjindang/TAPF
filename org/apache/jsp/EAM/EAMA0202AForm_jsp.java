package org.apache.jsp.EAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EAMA0202AForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/displaytag-12.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_hidden_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_select_property_onchange_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_option_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_radio_value_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_size_property_name_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_hidden_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_select_property_onchange_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_option_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_radio_value_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_size_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_hidden_property_name_nobody.release();
    _jspx_tagPool_html_select_property_onchange_name.release();
    _jspx_tagPool_html_option_value.release();
    _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.release();
    _jspx_tagPool_bean_write_property_name_nobody.release();
    _jspx_tagPool_html_radio_value_property_name_nobody.release();
    _jspx_tagPool_html_text_size_property_name_nobody.release();
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
      out.write("程式目的：EAMA02文字\r\n");
      out.write("程式代號：EAMA02\r\n");
      out.write("程式日期：0950301\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_html_hidden_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<table class='table_1' width='100%'>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>會計科目名稱</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_select_0(_jspx_page_context))
        return;
      out.write("\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>會計科目代號</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_bean_write_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>借/貸</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_radio_0(_jspx_page_context))
        return;
      out.write("借\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_radio_1(_jspx_page_context))
        return;
      out.write("貸\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>備註</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_bean_write_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t    <td>抓取公式</td>\r\n");
      out.write("\t\t<td class=\"table_td\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_0(_jspx_page_context))
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
    _jspx_th_html_hidden_0.setName("Eama0202Form");
    _jspx_th_html_hidden_0.setProperty("accountPhase.id");
    int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
    if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_0);
    return false;
  }

  private boolean _jspx_meth_html_select_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:select
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_0 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_property_onchange_name.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_select_0.setPageContext(_jspx_page_context);
    _jspx_th_html_select_0.setParent(null);
    _jspx_th_html_select_0.setName("Eama0202Form");
    _jspx_th_html_select_0.setProperty("accountCode.id");
    _jspx_th_html_select_0.setOnchange("form.action='EAMA0211';form.submit();");
    int _jspx_eval_html_select_0 = _jspx_th_html_select_0.doStartTag();
    if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_select_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_select_0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_html_option_0(_jspx_th_html_select_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_html_optionsCollection_0(_jspx_th_html_select_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_html_select_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_select_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_select_property_onchange_name.reuse(_jspx_th_html_select_0);
    return false;
  }

  private boolean _jspx_meth_html_option_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:option
    org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_0 = (org.apache.struts.taglib.html.OptionTag) _jspx_tagPool_html_option_value.get(org.apache.struts.taglib.html.OptionTag.class);
    _jspx_th_html_option_0.setPageContext(_jspx_page_context);
    _jspx_th_html_option_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_0);
    _jspx_th_html_option_0.setValue("");
    int _jspx_eval_html_option_0 = _jspx_th_html_option_0.doStartTag();
    if (_jspx_eval_html_option_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_option_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_option_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_option_0.doInitBody();
      }
      do {
        out.write('請');
        out.write('選');
        out.write('擇');
        int evalDoAfterBody = _jspx_th_html_option_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_option_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_option_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_option_value.reuse(_jspx_th_html_option_0);
    return false;
  }

  private boolean _jspx_meth_html_optionsCollection_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:optionsCollection
    org.apache.struts.taglib.html.OptionsCollectionTag _jspx_th_html_optionsCollection_0 = (org.apache.struts.taglib.html.OptionsCollectionTag) _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.get(org.apache.struts.taglib.html.OptionsCollectionTag.class);
    _jspx_th_html_optionsCollection_0.setPageContext(_jspx_page_context);
    _jspx_th_html_optionsCollection_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_0);
    _jspx_th_html_optionsCollection_0.setName("Eama0202Form");
    _jspx_th_html_optionsCollection_0.setProperty("allAccountRef");
    _jspx_th_html_optionsCollection_0.setLabel("accountName");
    _jspx_th_html_optionsCollection_0.setValue("id");
    int _jspx_eval_html_optionsCollection_0 = _jspx_th_html_optionsCollection_0.doStartTag();
    if (_jspx_th_html_optionsCollection_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.reuse(_jspx_th_html_optionsCollection_0);
    return false;
  }

  private boolean _jspx_meth_bean_write_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_0.setParent(null);
    _jspx_th_bean_write_0.setName("Eama0202Form");
    _jspx_th_bean_write_0.setProperty("accountCode.accountCode");
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_0);
    return false;
  }

  private boolean _jspx_meth_html_radio_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:radio
    org.apache.struts.taglib.html.RadioTag _jspx_th_html_radio_0 = (org.apache.struts.taglib.html.RadioTag) _jspx_tagPool_html_radio_value_property_name_nobody.get(org.apache.struts.taglib.html.RadioTag.class);
    _jspx_th_html_radio_0.setPageContext(_jspx_page_context);
    _jspx_th_html_radio_0.setParent(null);
    _jspx_th_html_radio_0.setName("Eama0202Form");
    _jspx_th_html_radio_0.setProperty("accountType");
    _jspx_th_html_radio_0.setValue("D");
    int _jspx_eval_html_radio_0 = _jspx_th_html_radio_0.doStartTag();
    if (_jspx_th_html_radio_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_radio_value_property_name_nobody.reuse(_jspx_th_html_radio_0);
    return false;
  }

  private boolean _jspx_meth_html_radio_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:radio
    org.apache.struts.taglib.html.RadioTag _jspx_th_html_radio_1 = (org.apache.struts.taglib.html.RadioTag) _jspx_tagPool_html_radio_value_property_name_nobody.get(org.apache.struts.taglib.html.RadioTag.class);
    _jspx_th_html_radio_1.setPageContext(_jspx_page_context);
    _jspx_th_html_radio_1.setParent(null);
    _jspx_th_html_radio_1.setName("Eama0202Form");
    _jspx_th_html_radio_1.setProperty("accountType");
    _jspx_th_html_radio_1.setValue("C");
    int _jspx_eval_html_radio_1 = _jspx_th_html_radio_1.doStartTag();
    if (_jspx_th_html_radio_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_radio_value_property_name_nobody.reuse(_jspx_th_html_radio_1);
    return false;
  }

  private boolean _jspx_meth_bean_write_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_1.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_1.setParent(null);
    _jspx_th_bean_write_1.setName("Eama0202Form");
    _jspx_th_bean_write_1.setProperty("remark");
    int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
    if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_1);
    return false;
  }

  private boolean _jspx_meth_html_text_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_name_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_0.setPageContext(_jspx_page_context);
    _jspx_th_html_text_0.setParent(null);
    _jspx_th_html_text_0.setName("Eama0202Form");
    _jspx_th_html_text_0.setProperty("formula");
    _jspx_th_html_text_0.setSize("50");
    int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
    if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_name_nobody.reuse(_jspx_th_html_text_0);
    return false;
  }
}