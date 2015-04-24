package org.apache.jsp.CIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CIMA0102AForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_size_property_onblur_name_maxlength_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_select_property_onchange_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_option_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notEmpty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_empty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_equal_value_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notEqual_value_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_checkbox_value_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_style_size_property_onmousemove_name_maxlength_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_style_size_property_onblur_name_maxlength_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_hidden_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_size_property_onblur_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_select_property_onchange_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_option_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_notEmpty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_type_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_empty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_equal_value_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_notEqual_value_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_checkbox_value_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_style_size_property_onmousemove_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_style_size_property_onblur_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_hidden_property_name_nobody.release();
    _jspx_tagPool_html_text_size_property_onblur_name_maxlength_nobody.release();
    _jspx_tagPool_html_select_property_onchange_name.release();
    _jspx_tagPool_html_option_value.release();
    _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.release();
    _jspx_tagPool_logic_notEmpty_property_name.release();
    _jspx_tagPool_bean_define_type_property_name_id_nobody.release();
    _jspx_tagPool_logic_empty_property_name.release();
    _jspx_tagPool_bean_define_property_name_id_nobody.release();
    _jspx_tagPool_logic_equal_value_property_name.release();
    _jspx_tagPool_logic_notEqual_value_property_name.release();
    _jspx_tagPool_html_checkbox_value_property_name_nobody.release();
    _jspx_tagPool_html_text_style_size_property_name_maxlength_nobody.release();
    _jspx_tagPool_html_text_style_size_property_onmousemove_name_maxlength_nobody.release();
    _jspx_tagPool_html_text_style_size_property_onblur_name_maxlength_nobody.release();
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

      out.write("<!-- CIMA0101AForm.jsp\r\n");
      out.write("程式目的：CIMA01\r\n");
      out.write("程式代號：CIMA01\r\n");
      out.write("程式日期：0950306\r\n");
      out.write("程式作者：Eric.Chen\r\n");
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
      out.write("<table class='table_1' width='100%'>\r\n");
      out.write("\t\t");
      if (_jspx_meth_html_hidden_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_html_hidden_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_html_hidden_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_html_hidden_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_html_hidden_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_html_hidden_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_html_hidden_6(_jspx_page_context))
        return;
      out.write("\t\r\n");
      out.write("\t\t");
      if (_jspx_meth_html_hidden_7(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_html_hidden_8(_jspx_page_context))
        return;
      out.write("\t\t\r\n");
      out.write("\t\t");
      if (_jspx_meth_html_hidden_9(_jspx_page_context))
        return;
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>預算年度</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>預算別</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_select_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>債務別</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_select_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'><font color=\"red\">*</font>銀行編號<br><font color=\"red\">*</font>銀行名稱</br></td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      //  logic:notEmpty
      org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_1 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
      _jspx_th_logic_notEmpty_1.setPageContext(_jspx_page_context);
      _jspx_th_logic_notEmpty_1.setParent(null);
      _jspx_th_logic_notEmpty_1.setName("Cima0101Form");
      _jspx_th_logic_notEmpty_1.setProperty("bankCode");
      int _jspx_eval_logic_notEmpty_1 = _jspx_th_logic_notEmpty_1.doStartTag();
      if (_jspx_eval_logic_notEmpty_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t");
          //  bean:define
          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
          _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
          _jspx_th_bean_define_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_1);
          _jspx_th_bean_define_0.setId("bankCode");
          _jspx_th_bean_define_0.setName("Cima0101Form");
          _jspx_th_bean_define_0.setProperty("bankCode");
          _jspx_th_bean_define_0.setType("java.lang.String");
          int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
          if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
          java.lang.String bankCode = null;
          bankCode = (java.lang.String) _jspx_page_context.findAttribute("bankCode");
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          out.print(gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BankCodeManage.getBankCodeDIM(),"bankCode",bankCode,"bankCode","getSelectValue(this.form)"));
          out.write("\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_logic_notEmpty_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_logic_notEmpty_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_1);
      out.write("\r\n");
      out.write("\t\t\t");
      //  logic:empty
      org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_0 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
      _jspx_th_logic_empty_0.setPageContext(_jspx_page_context);
      _jspx_th_logic_empty_0.setParent(null);
      _jspx_th_logic_empty_0.setName("Cima0101Form");
      _jspx_th_logic_empty_0.setProperty("bankCode");
      int _jspx_eval_logic_empty_0 = _jspx_th_logic_empty_0.doStartTag();
      if (_jspx_eval_logic_empty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t");
          out.print(gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BankCodeManage.getBankCodeDIM(),"bankCode","","bankCode","getSelectValue(this.form)"));
          out.write("\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_logic_empty_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_logic_empty_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_0);
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_hidden_10(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>廢標否</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      //  logic:notEmpty
      org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_2 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
      _jspx_th_logic_notEmpty_2.setPageContext(_jspx_page_context);
      _jspx_th_logic_notEmpty_2.setParent(null);
      _jspx_th_logic_notEmpty_2.setName("Cima0101Form");
      _jspx_th_logic_notEmpty_2.setProperty("compareFlag");
      int _jspx_eval_logic_notEmpty_2 = _jspx_th_logic_notEmpty_2.doStartTag();
      if (_jspx_eval_logic_notEmpty_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t");
          //  bean:define
          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
          _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
          _jspx_th_bean_define_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_2);
          _jspx_th_bean_define_1.setId("compareFlag");
          _jspx_th_bean_define_1.setName("Cima0101Form");
          _jspx_th_bean_define_1.setProperty("compareFlag");
          int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
          if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_bean_define_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
          java.lang.Object compareFlag = null;
          compareFlag = (java.lang.Object) _jspx_page_context.findAttribute("compareFlag");
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_logic_equal_0(_jspx_th_logic_notEmpty_2, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_logic_notEqual_0(_jspx_th_logic_notEmpty_2, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_logic_notEmpty_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_logic_notEmpty_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_2);
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_logic_empty_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'><font color=\"red\">*</font>比價金額</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'><font color=\"red\">*</font>利率</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'><font color=\"red\">*</font>得標金額</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'><font color=\"red\">*</font>利息</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t<p align=\"right\">");
      if (_jspx_meth_bean_write_0(_jspx_page_context))
        return;
      out.write("</p>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
      if (_jspx_meth_html_hidden_11(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item' width=\"30%\"><font color=\"red\">*</font>本息合計</td>\r\n");
      out.write("\t\t<td class='table_td' width=\"40%\" id=\"totalAmountid\" align=\"right\">\r\n");
      out.write("\t\t\t<p align=\"right\">");
      if (_jspx_meth_bean_write_1(_jspx_page_context))
        return;
      out.write("</p>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td width=\"30%\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
      if (_jspx_meth_html_hidden_12(_jspx_page_context))
        return;
      out.write("\t\r\n");
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
    _jspx_th_html_hidden_0.setName("Cima0101Form");
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
    _jspx_th_html_hidden_1.setName("Cima0101Form");
    _jspx_th_html_hidden_1.setProperty("qryaccountYear");
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
    _jspx_th_html_hidden_2.setName("Cima0101Form");
    _jspx_th_html_hidden_2.setProperty("qryserialNo");
    int _jspx_eval_html_hidden_2 = _jspx_th_html_hidden_2.doStartTag();
    if (_jspx_th_html_hidden_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_2);
    return false;
  }

  private boolean _jspx_meth_html_hidden_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_3 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_3.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_3.setParent(null);
    _jspx_th_html_hidden_3.setName("Cima0101Form");
    _jspx_th_html_hidden_3.setProperty("qryissueSerial");
    int _jspx_eval_html_hidden_3 = _jspx_th_html_hidden_3.doStartTag();
    if (_jspx_th_html_hidden_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_3);
    return false;
  }

  private boolean _jspx_meth_html_hidden_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_4 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_4.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_4.setParent(null);
    _jspx_th_html_hidden_4.setName("Cima0101Form");
    _jspx_th_html_hidden_4.setProperty("qrydebtName");
    int _jspx_eval_html_hidden_4 = _jspx_th_html_hidden_4.doStartTag();
    if (_jspx_th_html_hidden_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_4);
    return false;
  }

  private boolean _jspx_meth_html_hidden_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_5 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_5.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_5.setParent(null);
    _jspx_th_html_hidden_5.setName("Cima0101Form");
    _jspx_th_html_hidden_5.setProperty("date(issueDate)");
    int _jspx_eval_html_hidden_5 = _jspx_th_html_hidden_5.doStartTag();
    if (_jspx_th_html_hidden_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_5);
    return false;
  }

  private boolean _jspx_meth_html_hidden_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_6 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_6.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_6.setParent(null);
    _jspx_th_html_hidden_6.setName("Cima0101Form");
    _jspx_th_html_hidden_6.setProperty("date(dueDate)");
    int _jspx_eval_html_hidden_6 = _jspx_th_html_hidden_6.doStartTag();
    if (_jspx_th_html_hidden_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_6);
    return false;
  }

  private boolean _jspx_meth_html_hidden_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_7 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_7.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_7.setParent(null);
    _jspx_th_html_hidden_7.setName("Cima0101Form");
    _jspx_th_html_hidden_7.setProperty("bankId");
    int _jspx_eval_html_hidden_7 = _jspx_th_html_hidden_7.doStartTag();
    if (_jspx_th_html_hidden_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_7);
    return false;
  }

  private boolean _jspx_meth_html_hidden_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_8 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_8.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_8.setParent(null);
    _jspx_th_html_hidden_8.setName("Cima0101Form");
    _jspx_th_html_hidden_8.setProperty("debtId");
    int _jspx_eval_html_hidden_8 = _jspx_th_html_hidden_8.doStartTag();
    if (_jspx_th_html_hidden_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_8);
    return false;
  }

  private boolean _jspx_meth_html_hidden_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_9 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_9.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_9.setParent(null);
    _jspx_th_html_hidden_9.setName("Cima0101Form");
    _jspx_th_html_hidden_9.setProperty("bigDecimal(planAmount)");
    int _jspx_eval_html_hidden_9 = _jspx_th_html_hidden_9.doStartTag();
    if (_jspx_th_html_hidden_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_9);
    return false;
  }

  private boolean _jspx_meth_html_text_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onblur_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_0.setPageContext(_jspx_page_context);
    _jspx_th_html_text_0.setParent(null);
    _jspx_th_html_text_0.setName("Cima0101Form");
    _jspx_th_html_text_0.setProperty("budgetYear");
    _jspx_th_html_text_0.setMaxlength("3");
    _jspx_th_html_text_0.setSize("5");
    _jspx_th_html_text_0.setOnblur("compareValue(this.form)");
    int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
    if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onblur_name_maxlength_nobody.reuse(_jspx_th_html_text_0);
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
    _jspx_th_html_select_0.setName("Cima0101Form");
    _jspx_th_html_select_0.setProperty("budgetCodeDebt");
    _jspx_th_html_select_0.setOnchange("changeValue(this.form)");
    int _jspx_eval_html_select_0 = _jspx_th_html_select_0.doStartTag();
    if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_select_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_select_0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_html_option_0(_jspx_th_html_select_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
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
    _jspx_th_html_option_0.setValue("0");
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
    _jspx_th_html_optionsCollection_0.setName("Cima0101Form");
    _jspx_th_html_optionsCollection_0.setProperty("budgetList");
    _jspx_th_html_optionsCollection_0.setLabel("budgetName");
    _jspx_th_html_optionsCollection_0.setValue("id");
    int _jspx_eval_html_optionsCollection_0 = _jspx_th_html_optionsCollection_0.doStartTag();
    if (_jspx_th_html_optionsCollection_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.reuse(_jspx_th_html_optionsCollection_0);
    return false;
  }

  private boolean _jspx_meth_html_select_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:select
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_1 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_property_onchange_name.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_select_1.setPageContext(_jspx_page_context);
    _jspx_th_html_select_1.setParent(null);
    _jspx_th_html_select_1.setName("Cima0101Form");
    _jspx_th_html_select_1.setProperty("debtCodeDebt");
    _jspx_th_html_select_1.setOnchange("compareValue(this.form)");
    int _jspx_eval_html_select_1 = _jspx_th_html_select_1.doStartTag();
    if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_select_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_select_1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_html_option_1(_jspx_th_html_select_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_logic_notEmpty_0(_jspx_th_html_select_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_html_select_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_select_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_select_property_onchange_name.reuse(_jspx_th_html_select_1);
    return false;
  }

  private boolean _jspx_meth_html_option_1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:option
    org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_1 = (org.apache.struts.taglib.html.OptionTag) _jspx_tagPool_html_option_value.get(org.apache.struts.taglib.html.OptionTag.class);
    _jspx_th_html_option_1.setPageContext(_jspx_page_context);
    _jspx_th_html_option_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_1);
    _jspx_th_html_option_1.setValue("0");
    int _jspx_eval_html_option_1 = _jspx_th_html_option_1.doStartTag();
    if (_jspx_eval_html_option_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_option_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_option_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_option_1.doInitBody();
      }
      do {
        out.write('請');
        out.write('選');
        out.write('擇');
        int evalDoAfterBody = _jspx_th_html_option_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_option_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_option_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_option_value.reuse(_jspx_th_html_option_1);
    return false;
  }

  private boolean _jspx_meth_logic_notEmpty_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:notEmpty
    org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_0 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
    _jspx_th_logic_notEmpty_0.setPageContext(_jspx_page_context);
    _jspx_th_logic_notEmpty_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_1);
    _jspx_th_logic_notEmpty_0.setName("Cima0101Form");
    _jspx_th_logic_notEmpty_0.setProperty("debtList");
    int _jspx_eval_logic_notEmpty_0 = _jspx_th_logic_notEmpty_0.doStartTag();
    if (_jspx_eval_logic_notEmpty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_html_optionsCollection_1(_jspx_th_logic_notEmpty_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_logic_notEmpty_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_notEmpty_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_0);
    return false;
  }

  private boolean _jspx_meth_html_optionsCollection_1(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEmpty_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:optionsCollection
    org.apache.struts.taglib.html.OptionsCollectionTag _jspx_th_html_optionsCollection_1 = (org.apache.struts.taglib.html.OptionsCollectionTag) _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.get(org.apache.struts.taglib.html.OptionsCollectionTag.class);
    _jspx_th_html_optionsCollection_1.setPageContext(_jspx_page_context);
    _jspx_th_html_optionsCollection_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
    _jspx_th_html_optionsCollection_1.setName("Cima0101Form");
    _jspx_th_html_optionsCollection_1.setProperty("debtList");
    _jspx_th_html_optionsCollection_1.setLabel("debitName");
    _jspx_th_html_optionsCollection_1.setValue("id");
    int _jspx_eval_html_optionsCollection_1 = _jspx_th_html_optionsCollection_1.doStartTag();
    if (_jspx_th_html_optionsCollection_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.reuse(_jspx_th_html_optionsCollection_1);
    return false;
  }

  private boolean _jspx_meth_html_hidden_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_10 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_10.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_10.setParent(null);
    _jspx_th_html_hidden_10.setName("Cima0101Form");
    _jspx_th_html_hidden_10.setProperty("bankName");
    int _jspx_eval_html_hidden_10 = _jspx_th_html_hidden_10.doStartTag();
    if (_jspx_th_html_hidden_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_10);
    return false;
  }

  private boolean _jspx_meth_logic_equal_0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEmpty_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:equal
    org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_0 = (org.apache.struts.taglib.logic.EqualTag) _jspx_tagPool_logic_equal_value_property_name.get(org.apache.struts.taglib.logic.EqualTag.class);
    _jspx_th_logic_equal_0.setPageContext(_jspx_page_context);
    _jspx_th_logic_equal_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_2);
    _jspx_th_logic_equal_0.setName("Cima0101Form");
    _jspx_th_logic_equal_0.setProperty("compareFlag");
    _jspx_th_logic_equal_0.setValue("Y");
    int _jspx_eval_logic_equal_0 = _jspx_th_logic_equal_0.doStartTag();
    if (_jspx_eval_logic_equal_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\t\t\r\n");
        out.write("\t\t\t\t\t\t<input type=\"checkbox\" name=\"checkGetMark\" value=\"Y\" checked=\"checked\"/>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_logic_equal_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_equal_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_logic_equal_value_property_name.reuse(_jspx_th_logic_equal_0);
    return false;
  }

  private boolean _jspx_meth_logic_notEqual_0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEmpty_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:notEqual
    org.apache.struts.taglib.logic.NotEqualTag _jspx_th_logic_notEqual_0 = (org.apache.struts.taglib.logic.NotEqualTag) _jspx_tagPool_logic_notEqual_value_property_name.get(org.apache.struts.taglib.logic.NotEqualTag.class);
    _jspx_th_logic_notEqual_0.setPageContext(_jspx_page_context);
    _jspx_th_logic_notEqual_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_2);
    _jspx_th_logic_notEqual_0.setName("Cima0101Form");
    _jspx_th_logic_notEqual_0.setProperty("compareFlag");
    _jspx_th_logic_notEqual_0.setValue("Y");
    int _jspx_eval_logic_notEqual_0 = _jspx_th_logic_notEqual_0.doStartTag();
    if (_jspx_eval_logic_notEqual_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\t\t\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_html_checkbox_0(_jspx_th_logic_notEqual_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_logic_notEqual_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_notEqual_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_logic_notEqual_value_property_name.reuse(_jspx_th_logic_notEqual_0);
    return false;
  }

  private boolean _jspx_meth_html_checkbox_0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEqual_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:checkbox
    org.apache.struts.taglib.html.CheckboxTag _jspx_th_html_checkbox_0 = (org.apache.struts.taglib.html.CheckboxTag) _jspx_tagPool_html_checkbox_value_property_name_nobody.get(org.apache.struts.taglib.html.CheckboxTag.class);
    _jspx_th_html_checkbox_0.setPageContext(_jspx_page_context);
    _jspx_th_html_checkbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEqual_0);
    _jspx_th_html_checkbox_0.setName("Cima0101Form");
    _jspx_th_html_checkbox_0.setProperty("checkGetMark");
    _jspx_th_html_checkbox_0.setValue("Y");
    int _jspx_eval_html_checkbox_0 = _jspx_th_html_checkbox_0.doStartTag();
    if (_jspx_th_html_checkbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_checkbox_value_property_name_nobody.reuse(_jspx_th_html_checkbox_0);
    return false;
  }

  private boolean _jspx_meth_logic_empty_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:empty
    org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_1 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
    _jspx_th_logic_empty_1.setPageContext(_jspx_page_context);
    _jspx_th_logic_empty_1.setParent(null);
    _jspx_th_logic_empty_1.setName("Cima0101Form");
    _jspx_th_logic_empty_1.setProperty("compareFlag");
    int _jspx_eval_logic_empty_1 = _jspx_th_logic_empty_1.doStartTag();
    if (_jspx_eval_logic_empty_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_html_checkbox_1(_jspx_th_logic_empty_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_logic_empty_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_empty_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_1);
    return false;
  }

  private boolean _jspx_meth_html_checkbox_1(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_empty_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:checkbox
    org.apache.struts.taglib.html.CheckboxTag _jspx_th_html_checkbox_1 = (org.apache.struts.taglib.html.CheckboxTag) _jspx_tagPool_html_checkbox_value_property_name_nobody.get(org.apache.struts.taglib.html.CheckboxTag.class);
    _jspx_th_html_checkbox_1.setPageContext(_jspx_page_context);
    _jspx_th_html_checkbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_empty_1);
    _jspx_th_html_checkbox_1.setName("Cima0101Form");
    _jspx_th_html_checkbox_1.setProperty("checkGetMark");
    _jspx_th_html_checkbox_1.setValue("Y");
    int _jspx_eval_html_checkbox_1 = _jspx_th_html_checkbox_1.doStartTag();
    if (_jspx_th_html_checkbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_checkbox_value_property_name_nobody.reuse(_jspx_th_html_checkbox_1);
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
    _jspx_th_html_text_1.setName("Cima0101Form");
    _jspx_th_html_text_1.setStyle("text-align: right");
    _jspx_th_html_text_1.setProperty("bigDecimal(compareAmount)");
    _jspx_th_html_text_1.setSize("65");
    _jspx_th_html_text_1.setMaxlength("20");
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
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_onmousemove_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_2.setPageContext(_jspx_page_context);
    _jspx_th_html_text_2.setParent(null);
    _jspx_th_html_text_2.setName("Cima0101Form");
    _jspx_th_html_text_2.setStyle("text-align: right");
    _jspx_th_html_text_2.setProperty("bigDecimal(compareRate)");
    _jspx_th_html_text_2.setSize("65");
    _jspx_th_html_text_2.setMaxlength("20");
    _jspx_th_html_text_2.setOnmousemove("rateLimit(this.form)");
    int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
    if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_onmousemove_name_maxlength_nobody.reuse(_jspx_th_html_text_2);
    return false;
  }

  private boolean _jspx_meth_html_text_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_size_property_onblur_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_3.setPageContext(_jspx_page_context);
    _jspx_th_html_text_3.setParent(null);
    _jspx_th_html_text_3.setName("Cima0101Form");
    _jspx_th_html_text_3.setStyle("text-align: right");
    _jspx_th_html_text_3.setProperty("bigDecimal(issueAmountDet)");
    _jspx_th_html_text_3.setSize("65");
    _jspx_th_html_text_3.setMaxlength("50");
    _jspx_th_html_text_3.setOnblur("changeAmount(this.form)");
    int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
    if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_size_property_onblur_name_maxlength_nobody.reuse(_jspx_th_html_text_3);
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
    _jspx_th_bean_write_0.setName("Cima0101Form");
    _jspx_th_bean_write_0.setProperty("bigDecimal(originInterestAmount)");
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_0);
    return false;
  }

  private boolean _jspx_meth_html_hidden_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_11 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_11.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_11.setParent(null);
    _jspx_th_html_hidden_11.setName("Cima0101Form");
    _jspx_th_html_hidden_11.setProperty("bigDecimal(originInterestAmount)");
    int _jspx_eval_html_hidden_11 = _jspx_th_html_hidden_11.doStartTag();
    if (_jspx_th_html_hidden_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_11);
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
    _jspx_th_bean_write_1.setName("Cima0101Form");
    _jspx_th_bean_write_1.setProperty("bigDecimal(totalAmount)");
    int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
    if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_1);
    return false;
  }

  private boolean _jspx_meth_html_hidden_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_12 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_12.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_12.setParent(null);
    _jspx_th_html_hidden_12.setName("Cima0101Form");
    _jspx_th_html_hidden_12.setProperty("bigDecimal(totalAmount)");
    int _jspx_eval_html_hidden_12 = _jspx_th_html_hidden_12.doStartTag();
    if (_jspx_th_html_hidden_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_12);
    return false;
  }
}
