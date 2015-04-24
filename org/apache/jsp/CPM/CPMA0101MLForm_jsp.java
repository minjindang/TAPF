package org.apache.jsp.CPM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.dnt.tame.util.DateUtil;
import java.math.BigDecimal;

public final class CPMA0101MLForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_table_name_id_class;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_column_title;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notEmpty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_empty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_property_name_id_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_hidden_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_table_name_id_class = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_column_title = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_notEmpty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_type_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_empty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_hidden_property_name_nobody.release();
    _jspx_tagPool_display_table_name_id_class.release();
    _jspx_tagPool_display_column_title.release();
    _jspx_tagPool_logic_notEmpty_property_name.release();
    _jspx_tagPool_bean_define_type_property_name_id_nobody.release();
    _jspx_tagPool_logic_empty_property_name.release();
    _jspx_tagPool_bean_define_property_name_id_nobody.release();
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

      out.write("<!-- CPMA0102ALForm.jsp\r\n");
      out.write("程式目的：CPMA01\r\n");
      out.write("程式代號：CPMA01\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table class='table_1' width='100%'>\r\n");
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
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t");
      //  display:table
      org.displaytag.tags.TableTag _jspx_th_display_table_0 = (org.displaytag.tags.TableTag) _jspx_tagPool_display_table_name_id_class.get(org.displaytag.tags.TableTag.class);
      _jspx_th_display_table_0.setPageContext(_jspx_page_context);
      _jspx_th_display_table_0.setParent(null);
      _jspx_th_display_table_0.setClass("table_list");
      _jspx_th_display_table_0.setName(new String("collection"));
      _jspx_th_display_table_0.setUid("row");
      int _jspx_eval_display_table_0 = _jspx_th_display_table_0.doStartTag();
      if (_jspx_eval_display_table_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        java.lang.Object row = null;
        java.lang.Integer row_rowNum = null;
        if (_jspx_eval_display_table_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_table_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_table_0.doInitBody();
        }
        row = (java.lang.Object) _jspx_page_context.findAttribute("row");
        row_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("row_rowNum");
        do {
          out.write(" \r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_0 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_0.setPageContext(_jspx_page_context);
          _jspx_th_display_column_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_0.setTitle("銀行代號");
          int _jspx_eval_display_column_0 = _jspx_th_display_column_0.doStartTag();
          if (_jspx_eval_display_column_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_0.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_0 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_0.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_0);
              _jspx_th_logic_notEmpty_0.setName("row");
              _jspx_th_logic_notEmpty_0.setProperty("plan.debt.bank");
              int _jspx_eval_logic_notEmpty_0 = _jspx_th_logic_notEmpty_0.doStartTag();
              if (_jspx_eval_logic_notEmpty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\t\t\t\r\n");
                  out.write("\t\t\t\t\t");
                  //  logic:notEmpty
                  org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_1 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
                  _jspx_th_logic_notEmpty_1.setPageContext(_jspx_page_context);
                  _jspx_th_logic_notEmpty_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
                  _jspx_th_logic_notEmpty_1.setName("row");
                  _jspx_th_logic_notEmpty_1.setProperty("plan.debt.bank.bankCode");
                  int _jspx_eval_logic_notEmpty_1 = _jspx_th_logic_notEmpty_1.doStartTag();
                  if (_jspx_eval_logic_notEmpty_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      //  bean:define
                      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                      _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
                      _jspx_th_bean_define_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_1);
                      _jspx_th_bean_define_0.setId("bankCode");
                      _jspx_th_bean_define_0.setName("row");
                      _jspx_th_bean_define_0.setProperty("plan.debt.bank.bankCode");
                      _jspx_th_bean_define_0.setType("java.lang.String");
                      int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
                      if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
                      java.lang.String bankCode = null;
                      bankCode = (java.lang.String) _jspx_page_context.findAttribute("bankCode");
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      out.print(bankCode);
                      out.write("\r\n");
                      out.write("\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_logic_notEmpty_1.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_logic_notEmpty_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_1);
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  logic:empty
                  org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_0 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
                  _jspx_th_logic_empty_0.setPageContext(_jspx_page_context);
                  _jspx_th_logic_empty_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
                  _jspx_th_logic_empty_0.setName("row");
                  _jspx_th_logic_empty_0.setProperty("plan.debt.bank.bankCode");
                  int _jspx_eval_logic_empty_0 = _jspx_th_logic_empty_0.doStartTag();
                  if (_jspx_eval_logic_empty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      out.print("");
                      out.write("\r\n");
                      out.write("\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_logic_empty_0.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_logic_empty_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_0);
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_0);
              out.write("\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_0);
          out.write("\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_1 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_1.setPageContext(_jspx_page_context);
          _jspx_th_display_column_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_1.setTitle("銀行名稱");
          int _jspx_eval_display_column_1 = _jspx_th_display_column_1.doStartTag();
          if (_jspx_eval_display_column_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_1.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_2 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_2.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_1);
              _jspx_th_logic_notEmpty_2.setName("row");
              _jspx_th_logic_notEmpty_2.setProperty("plan.debt.bank");
              int _jspx_eval_logic_notEmpty_2 = _jspx_th_logic_notEmpty_2.doStartTag();
              if (_jspx_eval_logic_notEmpty_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\t\t\t\r\n");
                  out.write("\t\t\t\t\t");
                  //  logic:notEmpty
                  org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_3 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
                  _jspx_th_logic_notEmpty_3.setPageContext(_jspx_page_context);
                  _jspx_th_logic_notEmpty_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_2);
                  _jspx_th_logic_notEmpty_3.setName("row");
                  _jspx_th_logic_notEmpty_3.setProperty("plan.debt.bank.bankName");
                  int _jspx_eval_logic_notEmpty_3 = _jspx_th_logic_notEmpty_3.doStartTag();
                  if (_jspx_eval_logic_notEmpty_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      //  bean:define
                      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                      _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
                      _jspx_th_bean_define_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_3);
                      _jspx_th_bean_define_1.setId("bankName");
                      _jspx_th_bean_define_1.setName("row");
                      _jspx_th_bean_define_1.setProperty("plan.debt.bank.bankName");
                      _jspx_th_bean_define_1.setType("java.lang.String");
                      int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
                      if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
                      java.lang.String bankName = null;
                      bankName = (java.lang.String) _jspx_page_context.findAttribute("bankName");
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      out.print(bankName);
                      out.write("\r\n");
                      out.write("\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_logic_notEmpty_3.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_logic_notEmpty_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_3);
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  logic:empty
                  org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_1 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
                  _jspx_th_logic_empty_1.setPageContext(_jspx_page_context);
                  _jspx_th_logic_empty_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_2);
                  _jspx_th_logic_empty_1.setName("row");
                  _jspx_th_logic_empty_1.setProperty("plan.debt.bank.bankName");
                  int _jspx_eval_logic_empty_1 = _jspx_th_logic_empty_1.doStartTag();
                  if (_jspx_eval_logic_empty_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      out.print("");
                      out.write("\r\n");
                      out.write("\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_logic_empty_1.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_logic_empty_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_1);
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_2);
              out.write("\t\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_1);
          out.write("\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_2 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_2.setPageContext(_jspx_page_context);
          _jspx_th_display_column_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_2.setTitle("償還日期");
          int _jspx_eval_display_column_2 = _jspx_th_display_column_2.doStartTag();
          if (_jspx_eval_display_column_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_2.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_4 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_4.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_2);
              _jspx_th_logic_notEmpty_4.setName("row");
              _jspx_th_logic_notEmpty_4.setProperty("repayDate");
              int _jspx_eval_logic_notEmpty_4 = _jspx_th_logic_notEmpty_4.doStartTag();
              if (_jspx_eval_logic_notEmpty_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_2 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_2.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_4);
                  _jspx_th_bean_define_2.setId("repayDate");
                  _jspx_th_bean_define_2.setName("row");
                  _jspx_th_bean_define_2.setProperty("repayDate");
                  _jspx_th_bean_define_2.setType("java.util.Date");
                  int _jspx_eval_bean_define_2 = _jspx_th_bean_define_2.doStartTag();
                  if (_jspx_th_bean_define_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_2);
                  java.util.Date repayDate = null;
                  repayDate = (java.util.Date) _jspx_page_context.findAttribute("repayDate");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  out.print(DateUtil.date2ROCStr(repayDate));
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_4);
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:empty
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_2 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_2.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_2);
              _jspx_th_logic_empty_2.setName("row");
              _jspx_th_logic_empty_2.setProperty("repayDate");
              int _jspx_eval_logic_empty_2 = _jspx_th_logic_empty_2.doStartTag();
              if (_jspx_eval_logic_empty_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  out.print("000/00/00");
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_empty_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_empty_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_2);
              out.write("\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_2);
          out.write("\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_3 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_3.setPageContext(_jspx_page_context);
          _jspx_th_display_column_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_3.setTitle("計息天數");
          int _jspx_eval_display_column_3 = _jspx_th_display_column_3.doStartTag();
          if (_jspx_eval_display_column_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_3.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_5 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_5.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_3);
              _jspx_th_logic_notEmpty_5.setName("row");
              _jspx_th_logic_notEmpty_5.setProperty("interestDays");
              int _jspx_eval_logic_notEmpty_5 = _jspx_th_logic_notEmpty_5.doStartTag();
              if (_jspx_eval_logic_notEmpty_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_3 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_3.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_5);
                  _jspx_th_bean_define_3.setId("interestDays");
                  _jspx_th_bean_define_3.setName("row");
                  _jspx_th_bean_define_3.setProperty("interestDays");
                  _jspx_th_bean_define_3.setType("java.lang.Integer");
                  int _jspx_eval_bean_define_3 = _jspx_th_bean_define_3.doStartTag();
                  if (_jspx_th_bean_define_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_3);
                  java.lang.Integer interestDays = null;
                  interestDays = (java.lang.Integer) _jspx_page_context.findAttribute("interestDays");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  out.print(interestDays);
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_5);
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:empty
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_3 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_3.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_3);
              _jspx_th_logic_empty_3.setName("row");
              _jspx_th_logic_empty_3.setProperty("interestDays");
              int _jspx_eval_logic_empty_3 = _jspx_th_logic_empty_3.doStartTag();
              if (_jspx_eval_logic_empty_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  out.print("0");
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_empty_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_empty_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_3);
              out.write("\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_3);
          out.write("\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_4 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_4.setPageContext(_jspx_page_context);
          _jspx_th_display_column_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_4.setTitle("方式");
          int _jspx_eval_display_column_4 = _jspx_th_display_column_4.doStartTag();
          if (_jspx_eval_display_column_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_4.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_6 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_6.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_4);
              _jspx_th_logic_notEmpty_6.setName("row");
              _jspx_th_logic_notEmpty_6.setProperty("planRepayDate");
              int _jspx_eval_logic_notEmpty_6 = _jspx_th_logic_notEmpty_6.doStartTag();
              if (_jspx_eval_logic_notEmpty_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_4 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_4.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_6);
                  _jspx_th_bean_define_4.setId("planRepayDate");
                  _jspx_th_bean_define_4.setName("row");
                  _jspx_th_bean_define_4.setProperty("planRepayDate");
                  int _jspx_eval_bean_define_4 = _jspx_th_bean_define_4.doStartTag();
                  if (_jspx_th_bean_define_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_property_name_id_nobody.reuse(_jspx_th_bean_define_4);
                  java.lang.Object planRepayDate = null;
                  planRepayDate = (java.lang.Object) _jspx_page_context.findAttribute("planRepayDate");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
request.setAttribute("planRepayDate",planRepayDate);
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_6);
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:empty
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_4 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_4.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_4);
              _jspx_th_logic_empty_4.setName("row");
              _jspx_th_logic_empty_4.setProperty("planRepayDate");
              int _jspx_eval_logic_empty_4 = _jspx_th_logic_empty_4.doStartTag();
              if (_jspx_eval_logic_empty_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
request.setAttribute("planRepayDate",new java.util.Date(1900,1,1));
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_empty_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_empty_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_4);
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_7 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_7.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_4);
              _jspx_th_logic_notEmpty_7.setName("row");
              _jspx_th_logic_notEmpty_7.setProperty("repayDate");
              int _jspx_eval_logic_notEmpty_7 = _jspx_th_logic_notEmpty_7.doStartTag();
              if (_jspx_eval_logic_notEmpty_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_5 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_5.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_7);
                  _jspx_th_bean_define_5.setId("repayDate");
                  _jspx_th_bean_define_5.setName("row");
                  _jspx_th_bean_define_5.setProperty("repayDate");
                  int _jspx_eval_bean_define_5 = _jspx_th_bean_define_5.doStartTag();
                  if (_jspx_th_bean_define_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_property_name_id_nobody.reuse(_jspx_th_bean_define_5);
                  java.lang.Object repayDate = null;
                  repayDate = (java.lang.Object) _jspx_page_context.findAttribute("repayDate");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
request.setAttribute("repayDate",repayDate);
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_7.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_7);
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:empty
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_5 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_5.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_4);
              _jspx_th_logic_empty_5.setName("row");
              _jspx_th_logic_empty_5.setProperty("repayDate");
              int _jspx_eval_logic_empty_5 = _jspx_th_logic_empty_5.doStartTag();
              if (_jspx_eval_logic_empty_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
request.setAttribute("repayDate",new java.util.Date(1900,1,1));
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_empty_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_empty_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_5);
              out.write("\r\n");
              out.write("\t\t\t\t");
 java.util.Date repayDate = (java.util.Date)request.getAttribute("repayDate");
				   java.util.Date planRepayDate = (java.util.Date)request.getAttribute("planRepayDate");		
					if(repayDate.equals(planRepayDate))
					{
						request.setAttribute("DateType","正常還款");
					}	
					if(repayDate.before(planRepayDate))
					{
						request.setAttribute("DateType","提前還款");
					}
					if(repayDate.after(planRepayDate))
					{
						request.setAttribute("DateType","延後還款");
					}
				
              out.write("\r\n");
              out.write("\t\t\t\t");
              out.print(request.getAttribute("DateType"));
              out.write("\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_4);
          out.write("\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_5 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_5.setPageContext(_jspx_page_context);
          _jspx_th_display_column_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_5.setTitle("償還金額");
          int _jspx_eval_display_column_5 = _jspx_th_display_column_5.doStartTag();
          if (_jspx_eval_display_column_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_5.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_8 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_8.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_5);
              _jspx_th_logic_notEmpty_8.setName("row");
              _jspx_th_logic_notEmpty_8.setProperty("capitalAmount");
              int _jspx_eval_logic_notEmpty_8 = _jspx_th_logic_notEmpty_8.doStartTag();
              if (_jspx_eval_logic_notEmpty_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_6 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_6.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_8);
                  _jspx_th_bean_define_6.setId("capitalAmount");
                  _jspx_th_bean_define_6.setName("row");
                  _jspx_th_bean_define_6.setProperty("capitalAmount");
                  _jspx_th_bean_define_6.setType("java.math.BigDecimal");
                  int _jspx_eval_bean_define_6 = _jspx_th_bean_define_6.doStartTag();
                  if (_jspx_th_bean_define_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_6);
                  java.math.BigDecimal capitalAmount = null;
                  capitalAmount = (java.math.BigDecimal) _jspx_page_context.findAttribute("capitalAmount");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
request.setAttribute("capitalAmount",capitalAmount);
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t<p align=\"right\">");
                  out.print(new gov.dnt.tame.common.SupportForm().getAmountDecimal(capitalAmount));
                  out.write("</p>\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_8.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_8);
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:empty
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_6 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_6.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_5);
              _jspx_th_logic_empty_6.setName("row");
              _jspx_th_logic_empty_6.setProperty("capitalAmount");
              int _jspx_eval_logic_empty_6 = _jspx_th_logic_empty_6.doStartTag();
              if (_jspx_eval_logic_empty_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  out.print("<P align=right>0</P>");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
request.setAttribute("capitalAmount",new BigDecimal(0));
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_empty_6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_empty_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_6);
              out.write("\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_5);
          out.write("\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_6 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_6.setPageContext(_jspx_page_context);
          _jspx_th_display_column_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_6.setTitle("償還利息");
          int _jspx_eval_display_column_6 = _jspx_th_display_column_6.doStartTag();
          if (_jspx_eval_display_column_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_6.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_9 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_9.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_6);
              _jspx_th_logic_notEmpty_9.setName("row");
              _jspx_th_logic_notEmpty_9.setProperty("interestAmount");
              int _jspx_eval_logic_notEmpty_9 = _jspx_th_logic_notEmpty_9.doStartTag();
              if (_jspx_eval_logic_notEmpty_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\t\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_7 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_7.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_9);
                  _jspx_th_bean_define_7.setId("interestAmount");
                  _jspx_th_bean_define_7.setName("row");
                  _jspx_th_bean_define_7.setProperty("interestAmount");
                  _jspx_th_bean_define_7.setType("java.math.BigDecimal");
                  int _jspx_eval_bean_define_7 = _jspx_th_bean_define_7.doStartTag();
                  if (_jspx_th_bean_define_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_7);
                  java.math.BigDecimal interestAmount = null;
                  interestAmount = (java.math.BigDecimal) _jspx_page_context.findAttribute("interestAmount");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t");
request.setAttribute("interestAmount",interestAmount);
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t<p align=\"right\">");
                  out.print(new gov.dnt.tame.common.SupportForm().getAmountDecimal(interestAmount.setScale(0,5)));
                  out.write("</p>\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_9.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_9);
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:empty
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_7 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_7.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_6);
              _jspx_th_logic_empty_7.setName("row");
              _jspx_th_logic_empty_7.setProperty("interestAmount");
              int _jspx_eval_logic_empty_7 = _jspx_th_logic_empty_7.doStartTag();
              if (_jspx_eval_logic_empty_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  out.print("<P align=right>0</P>");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
request.setAttribute("interestAmount",new BigDecimal(0));
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_empty_7.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_empty_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_7);
              out.write("\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_6.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_6);
          out.write("\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_7 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_7.setPageContext(_jspx_page_context);
          _jspx_th_display_column_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_7.setTitle("本息合計");
          int _jspx_eval_display_column_7 = _jspx_th_display_column_7.doStartTag();
          if (_jspx_eval_display_column_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_7.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t<p align=\"right\">");
              out.print(new gov.dnt.tame.common.SupportForm().getAmountDecimal(((java.math.BigDecimal)request.getAttribute("capitalAmount")).add((java.math.BigDecimal)(request.getAttribute("interestAmount")))));
              out.write("</p>\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_7.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_7);
          out.write("\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_display_table_0.doAfterBody();
          row = (java.lang.Object) _jspx_page_context.findAttribute("row");
          row_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("row_rowNum");
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_table_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_display_table_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_display_table_name_id_class.reuse(_jspx_th_display_table_0);
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\t\r\n");
      out.write("</talbe>\r\n");
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
    _jspx_th_html_hidden_0.setName("Cpma0101Form");
    _jspx_th_html_hidden_0.setProperty("date(qryrepayDate)");
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
    _jspx_th_html_hidden_1.setName("Cpma0101Form");
    _jspx_th_html_hidden_1.setProperty("debtName");
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
    _jspx_th_html_hidden_2.setName("Cpma0101Form");
    _jspx_th_html_hidden_2.setProperty("issueId");
    int _jspx_eval_html_hidden_2 = _jspx_th_html_hidden_2.doStartTag();
    if (_jspx_th_html_hidden_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_2);
    return false;
  }
}
