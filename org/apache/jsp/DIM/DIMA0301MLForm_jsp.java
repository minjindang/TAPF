package org.apache.jsp.DIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DIMA0301MLForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/displaytag-12.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_table_name_id_class;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_column_title;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notEmpty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_format_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_equal_value_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notEqual_value_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_empty_property_name;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_display_table_name_id_class = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_column_title = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_notEmpty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_format_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_type_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_equal_value_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_notEqual_value_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_empty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_display_table_name_id_class.release();
    _jspx_tagPool_display_column_title.release();
    _jspx_tagPool_logic_notEmpty_property_name.release();
    _jspx_tagPool_bean_write_property_name_nobody.release();
    _jspx_tagPool_bean_write_property_name_format_nobody.release();
    _jspx_tagPool_bean_define_type_property_name_id_nobody.release();
    _jspx_tagPool_logic_equal_value_property_name.release();
    _jspx_tagPool_logic_notEqual_value_property_name.release();
    _jspx_tagPool_logic_empty_property_name.release();
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

      out.write("<!-- DIMA0301MLForm.jsp\r\n");
      out.write("程式目的：DIMA03\r\n");
      out.write("程式代號：DIMA03\r\n");
      out.write("程式日期：0950224\r\n");
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
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t");
      //  display:table
      org.displaytag.tags.TableTag _jspx_th_display_table_0 = (org.displaytag.tags.TableTag) _jspx_tagPool_display_table_name_id_class.get(org.displaytag.tags.TableTag.class);
      _jspx_th_display_table_0.setPageContext(_jspx_page_context);
      _jspx_th_display_table_0.setParent(null);
      _jspx_th_display_table_0.setClass("table_list");
      _jspx_th_display_table_0.setName(new String("Dima0301Form.debtMains"));
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
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_display_column_0(_jspx_th_display_table_0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_display_column_1(_jspx_th_display_table_0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_display_column_2(_jspx_th_display_table_0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_display_column_3(_jspx_th_display_table_0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_4 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_4.setPageContext(_jspx_page_context);
          _jspx_th_display_column_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_4.setTitle("收款否");
          int _jspx_eval_display_column_4 = _jspx_th_display_column_4.doStartTag();
          if (_jspx_eval_display_column_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_4.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_4 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_4.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_4);
              _jspx_th_logic_notEmpty_4.setName("row");
              _jspx_th_logic_notEmpty_4.setProperty("id");
              int _jspx_eval_logic_notEmpty_4 = _jspx_th_logic_notEmpty_4.doStartTag();
              if (_jspx_eval_logic_notEmpty_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_4);
                  _jspx_th_bean_define_0.setId("id");
                  _jspx_th_bean_define_0.setName("row");
                  _jspx_th_bean_define_0.setProperty("id");
                  _jspx_th_bean_define_0.setType("java.lang.Integer");
                  int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
                  if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
                  java.lang.Integer id = null;
                  id = (java.lang.Integer) _jspx_page_context.findAttribute("id");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"debtMain[");
                  out.print(row_rowNum);
                  out.write("].id\" value=\"");
                  out.print(id);
                  out.write("\">\r\n");
                  out.write("\t\t\t\t\t\t");
                  //  logic:notEmpty
                  org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_5 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
                  _jspx_th_logic_notEmpty_5.setPageContext(_jspx_page_context);
                  _jspx_th_logic_notEmpty_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_4);
                  _jspx_th_logic_notEmpty_5.setName("row");
                  _jspx_th_logic_notEmpty_5.setProperty("accrue");
                  int _jspx_eval_logic_notEmpty_5 = _jspx_th_logic_notEmpty_5.doStartTag();
                  if (_jspx_eval_logic_notEmpty_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t\t");
                      //  logic:notEmpty
                      org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_6 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
                      _jspx_th_logic_notEmpty_6.setPageContext(_jspx_page_context);
                      _jspx_th_logic_notEmpty_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_5);
                      _jspx_th_logic_notEmpty_6.setName("row");
                      _jspx_th_logic_notEmpty_6.setProperty("get");
                      int _jspx_eval_logic_notEmpty_6 = _jspx_th_logic_notEmpty_6.doStartTag();
                      if (_jspx_eval_logic_notEmpty_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t");
                          //  bean:define
                          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                          _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
                          _jspx_th_bean_define_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_6);
                          _jspx_th_bean_define_1.setId("get");
                          _jspx_th_bean_define_1.setName("row");
                          _jspx_th_bean_define_1.setProperty("get");
                          _jspx_th_bean_define_1.setType("java.lang.String");
                          int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
                          if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
                          java.lang.String get = null;
                          get = (java.lang.String) _jspx_page_context.findAttribute("get");
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t");
                          //  logic:equal
                          org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_0 = (org.apache.struts.taglib.logic.EqualTag) _jspx_tagPool_logic_equal_value_property_name.get(org.apache.struts.taglib.logic.EqualTag.class);
                          _jspx_th_logic_equal_0.setPageContext(_jspx_page_context);
                          _jspx_th_logic_equal_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_6);
                          _jspx_th_logic_equal_0.setName("row");
                          _jspx_th_logic_equal_0.setProperty("get");
                          _jspx_th_logic_equal_0.setValue("Y");
                          int _jspx_eval_logic_equal_0 = _jspx_th_logic_equal_0.doStartTag();
                          if (_jspx_eval_logic_equal_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            do {
                              out.write("\t\t\t\r\n");
                              out.write("\t\t\t\t\t\t\t\t\t");
                              out.print("已收款");
                              out.write("\r\n");
                              out.write("\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"debtMain[");
                              out.print(row_rowNum);
                              out.write("].get\" value=\"on\">\r\n");
                              out.write("\t\t\t\t\t\t\t\t");
                              int evalDoAfterBody = _jspx_th_logic_equal_0.doAfterBody();
                              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                              break;
                            } while (true);
                          }
                          if (_jspx_th_logic_equal_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          _jspx_tagPool_logic_equal_value_property_name.reuse(_jspx_th_logic_equal_0);
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t");
                          //  logic:notEqual
                          org.apache.struts.taglib.logic.NotEqualTag _jspx_th_logic_notEqual_0 = (org.apache.struts.taglib.logic.NotEqualTag) _jspx_tagPool_logic_notEqual_value_property_name.get(org.apache.struts.taglib.logic.NotEqualTag.class);
                          _jspx_th_logic_notEqual_0.setPageContext(_jspx_page_context);
                          _jspx_th_logic_notEqual_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_6);
                          _jspx_th_logic_notEqual_0.setName("row");
                          _jspx_th_logic_notEqual_0.setProperty("get");
                          _jspx_th_logic_notEqual_0.setValue("Y");
                          int _jspx_eval_logic_notEqual_0 = _jspx_th_logic_notEqual_0.doStartTag();
                          if (_jspx_eval_logic_notEqual_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            do {
                              out.write("\r\n");
                              out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"debtMain[");
                              out.print(row_rowNum);
                              out.write("].get\" ");
                              out.print("Y".equals(get)?"checked":"N");
                              out.write(">\r\n");
                              out.write("\t\t\t\t\t\t\t\t");
                              int evalDoAfterBody = _jspx_th_logic_notEqual_0.doAfterBody();
                              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                              break;
                            } while (true);
                          }
                          if (_jspx_th_logic_notEqual_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          _jspx_tagPool_logic_notEqual_value_property_name.reuse(_jspx_th_logic_notEqual_0);
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t");
                          int evalDoAfterBody = _jspx_th_logic_notEmpty_6.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_logic_notEmpty_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_6);
                      out.write("\t\r\n");
                      out.write("\t\t\t\t\t\t\t");
                      //  logic:empty
                      org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_0 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
                      _jspx_th_logic_empty_0.setPageContext(_jspx_page_context);
                      _jspx_th_logic_empty_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_5);
                      _jspx_th_logic_empty_0.setName("row");
                      _jspx_th_logic_empty_0.setProperty("get");
                      int _jspx_eval_logic_empty_0 = _jspx_th_logic_empty_0.doStartTag();
                      if (_jspx_eval_logic_empty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"debtMain[");
                          out.print(row_rowNum);
                          out.write("].get\" >\r\n");
                          out.write("\t\t\t\t\t\t\t");
                          int evalDoAfterBody = _jspx_th_logic_empty_0.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_logic_empty_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_0);
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_logic_notEmpty_5.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_logic_notEmpty_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_5);
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_4);
              out.write("\t\r\n");
              out.write("\t\t\t\t");
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
          out.write("\t\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_5 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_5.setPageContext(_jspx_page_context);
          _jspx_th_display_column_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_5.setTitle("收款日期");
          int _jspx_eval_display_column_5 = _jspx_th_display_column_5.doStartTag();
          if (_jspx_eval_display_column_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_5.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_7 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_7.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_5);
              _jspx_th_logic_notEmpty_7.setName("row");
              _jspx_th_logic_notEmpty_7.setProperty("accrueDate");
              int _jspx_eval_logic_notEmpty_7 = _jspx_th_logic_notEmpty_7.doStartTag();
              if (_jspx_eval_logic_notEmpty_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_2 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_2.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_7);
                  _jspx_th_bean_define_2.setId("accrueDate");
                  _jspx_th_bean_define_2.setName("row");
                  _jspx_th_bean_define_2.setProperty("accrueDate");
                  _jspx_th_bean_define_2.setType("java.util.Date");
                  int _jspx_eval_bean_define_2 = _jspx_th_bean_define_2.doStartTag();
                  if (_jspx_th_bean_define_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_2);
                  java.util.Date accrueDate = null;
                  accrueDate = (java.util.Date) _jspx_page_context.findAttribute("accrueDate");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t<input type=\"text\" name=\"debtMain[");
                  out.print(row_rowNum);
                  out.write("].accrueDate\" value=\"");
                  out.print(gov.dnt.tame.util.DateUtil.date2ROCStr(accrueDate));
                  out.write("\" size='7' maxlength='7'>\r\n");
                  out.write("\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_7.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_7);
              out.write("\r\n");
              out.write("\t\t\t\t\t");
              //  logic:empty
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_1 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_1.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_5);
              _jspx_th_logic_empty_1.setName("row");
              _jspx_th_logic_empty_1.setProperty("accrueDate");
              int _jspx_eval_logic_empty_1 = _jspx_th_logic_empty_1.doStartTag();
              if (_jspx_eval_logic_empty_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t<input type=\"text\" name=\"debtMain[");
                  out.print(row_rowNum);
                  out.write("].accrueDate\" value=\"\" size='7' maxlength='7'>\r\n");
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
              out.write("\t\t\t\t\t");
              out.print(gov.dnt.tame.util.CommonFun.addCalendar("debtMain["+row_rowNum+"].accrueDate",row_rowNum));
              out.write("\r\n");
              out.write("\t\t\t\t");
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
      out.write("\t</tr>\r\n");
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

  private boolean _jspx_meth_display_column_0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_table_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
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
        out.write("\t\t\t\t\t");
        if (_jspx_meth_logic_notEmpty_0(_jspx_th_display_column_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_display_column_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_display_column_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_display_column_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_0);
    return false;
  }

  private boolean _jspx_meth_logic_notEmpty_0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_column_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:notEmpty
    org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_0 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
    _jspx_th_logic_notEmpty_0.setPageContext(_jspx_page_context);
    _jspx_th_logic_notEmpty_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_0);
    _jspx_th_logic_notEmpty_0.setName("row");
    _jspx_th_logic_notEmpty_0.setProperty("bank");
    int _jspx_eval_logic_notEmpty_0 = _jspx_th_logic_notEmpty_0.doStartTag();
    if (_jspx_eval_logic_notEmpty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_bean_write_0(_jspx_th_logic_notEmpty_0, _jspx_page_context))
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

  private boolean _jspx_meth_bean_write_0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEmpty_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
    _jspx_th_bean_write_0.setName("row");
    _jspx_th_bean_write_0.setProperty("bank.bankCode");
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_0);
    return false;
  }

  private boolean _jspx_meth_display_column_1(javax.servlet.jsp.tagext.JspTag _jspx_th_display_table_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
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
        out.write("\t\t\t\t\t");
        if (_jspx_meth_logic_notEmpty_1(_jspx_th_display_column_1, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_display_column_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_display_column_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_display_column_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_1);
    return false;
  }

  private boolean _jspx_meth_logic_notEmpty_1(javax.servlet.jsp.tagext.JspTag _jspx_th_display_column_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:notEmpty
    org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_1 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
    _jspx_th_logic_notEmpty_1.setPageContext(_jspx_page_context);
    _jspx_th_logic_notEmpty_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_1);
    _jspx_th_logic_notEmpty_1.setName("row");
    _jspx_th_logic_notEmpty_1.setProperty("bank");
    int _jspx_eval_logic_notEmpty_1 = _jspx_th_logic_notEmpty_1.doStartTag();
    if (_jspx_eval_logic_notEmpty_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_bean_write_1(_jspx_th_logic_notEmpty_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_logic_notEmpty_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_notEmpty_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_1);
    return false;
  }

  private boolean _jspx_meth_bean_write_1(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEmpty_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_1.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_1);
    _jspx_th_bean_write_1.setName("row");
    _jspx_th_bean_write_1.setProperty("bank.bankName");
    int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
    if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_1);
    return false;
  }

  private boolean _jspx_meth_display_column_2(javax.servlet.jsp.tagext.JspTag _jspx_th_display_table_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_column_2 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_column_2.setPageContext(_jspx_page_context);
    _jspx_th_display_column_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
    _jspx_th_display_column_2.setTitle("得標金額");
    int _jspx_eval_display_column_2 = _jspx_th_display_column_2.doStartTag();
    if (_jspx_eval_display_column_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_display_column_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_display_column_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_display_column_2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_logic_notEmpty_2(_jspx_th_display_column_2, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_display_column_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_display_column_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_display_column_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_2);
    return false;
  }

  private boolean _jspx_meth_logic_notEmpty_2(javax.servlet.jsp.tagext.JspTag _jspx_th_display_column_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:notEmpty
    org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_2 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
    _jspx_th_logic_notEmpty_2.setPageContext(_jspx_page_context);
    _jspx_th_logic_notEmpty_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_2);
    _jspx_th_logic_notEmpty_2.setName("row");
    _jspx_th_logic_notEmpty_2.setProperty("issueAmount");
    int _jspx_eval_logic_notEmpty_2 = _jspx_th_logic_notEmpty_2.doStartTag();
    if (_jspx_eval_logic_notEmpty_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<p align=\"right\">");
        if (_jspx_meth_bean_write_2(_jspx_th_logic_notEmpty_2, _jspx_page_context))
          return true;
        out.write("</p>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_logic_notEmpty_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_notEmpty_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_2);
    return false;
  }

  private boolean _jspx_meth_bean_write_2(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEmpty_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_2 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_format_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_2.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_2);
    _jspx_th_bean_write_2.setName("row");
    _jspx_th_bean_write_2.setProperty("issueAmount");
    _jspx_th_bean_write_2.setFormat("#,###");
    int _jspx_eval_bean_write_2 = _jspx_th_bean_write_2.doStartTag();
    if (_jspx_th_bean_write_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_format_nobody.reuse(_jspx_th_bean_write_2);
    return false;
  }

  private boolean _jspx_meth_display_column_3(javax.servlet.jsp.tagext.JspTag _jspx_th_display_table_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_column_3 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_column_3.setPageContext(_jspx_page_context);
    _jspx_th_display_column_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
    _jspx_th_display_column_3.setTitle("比價金額");
    int _jspx_eval_display_column_3 = _jspx_th_display_column_3.doStartTag();
    if (_jspx_eval_display_column_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_display_column_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_display_column_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_display_column_3.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_logic_notEmpty_3(_jspx_th_display_column_3, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_display_column_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_display_column_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_display_column_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_3);
    return false;
  }

  private boolean _jspx_meth_logic_notEmpty_3(javax.servlet.jsp.tagext.JspTag _jspx_th_display_column_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:notEmpty
    org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_3 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
    _jspx_th_logic_notEmpty_3.setPageContext(_jspx_page_context);
    _jspx_th_logic_notEmpty_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_3);
    _jspx_th_logic_notEmpty_3.setName("row");
    _jspx_th_logic_notEmpty_3.setProperty("compareAmount");
    int _jspx_eval_logic_notEmpty_3 = _jspx_th_logic_notEmpty_3.doStartTag();
    if (_jspx_eval_logic_notEmpty_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<p align=\"right\">");
        if (_jspx_meth_bean_write_3(_jspx_th_logic_notEmpty_3, _jspx_page_context))
          return true;
        out.write("</p>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_logic_notEmpty_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_notEmpty_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_3);
    return false;
  }

  private boolean _jspx_meth_bean_write_3(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEmpty_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_3 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_format_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_3.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_3);
    _jspx_th_bean_write_3.setName("row");
    _jspx_th_bean_write_3.setProperty("compareAmount");
    _jspx_th_bean_write_3.setFormat("#,###");
    int _jspx_eval_bean_write_3 = _jspx_th_bean_write_3.doStartTag();
    if (_jspx_th_bean_write_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_format_nobody.reuse(_jspx_th_bean_write_3);
    return false;
  }
}
