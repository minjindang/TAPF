package org.apache.jsp.PM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.dnt.tame.util.Converter;

public final class PM1003_005fSCN1Form_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/displaytag-12.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notPresent_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_select_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_options_property_labelProperty_collection_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_present_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_table_name_id_class;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_column_title;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_multibox_value_property_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_submit_value_styleClass_property_onclick_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_logic_notPresent_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_select_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_options_property_labelProperty_collection_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_present_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_table_name_id_class = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_column_title = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_type_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_multibox_value_property_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_submit_value_styleClass_property_onclick_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_logic_notPresent_name.release();
    _jspx_tagPool_html_select_property_name.release();
    _jspx_tagPool_html_options_property_labelProperty_collection_nobody.release();
    _jspx_tagPool_logic_present_name.release();
    _jspx_tagPool_display_table_name_id_class.release();
    _jspx_tagPool_display_column_title.release();
    _jspx_tagPool_bean_define_type_property_name_id_nobody.release();
    _jspx_tagPool_html_multibox_value_property_nobody.release();
    _jspx_tagPool_bean_write_property_name_nobody.release();
    _jspx_tagPool_html_submit_value_styleClass_property_onclick_nobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	pageContext.setAttribute("NameGroupList", Converter.getCodeListWithSpaceBySql("SELECT  cast(id as varchar(2)) AS valuess,NAME AS label FROM PM0005_DB"));
	pageContext.setAttribute("DeptGroupList", Converter.getCodeListWithSpaceBySql("SELECT  cast(id as varchar(2)) AS valuess,Dept AS label FROM PM0005_DB"));

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_logic_notPresent_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table class=\"table_1\" width=\"100%\">\r\n");
      out.write("<!-- \r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class=\"table_item\" width=\"30%\">單位</td>\r\n");
      out.write("\t\t<td class=\"table_td\" width=\"70%\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_select_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write(" -->\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class=\"table_item\">使用者</td>\r\n");
      out.write("\t\t<td class=\"table_td\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_select_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("<!-- \r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t");
      //  logic:present
      org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_0 = (org.apache.struts.taglib.logic.PresentTag) _jspx_tagPool_logic_present_name.get(org.apache.struts.taglib.logic.PresentTag.class);
      _jspx_th_logic_present_0.setPageContext(_jspx_page_context);
      _jspx_th_logic_present_0.setParent(null);
      _jspx_th_logic_present_0.setName("queryList");
      int _jspx_eval_logic_present_0 = _jspx_th_logic_present_0.doStartTag();
      if (_jspx_eval_logic_present_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\t\t\r\n");
          out.write("\t\t\t\t");
          //  display:table
          org.displaytag.tags.TableTag _jspx_th_display_table_0 = (org.displaytag.tags.TableTag) _jspx_tagPool_display_table_name_id_class.get(org.displaytag.tags.TableTag.class);
          _jspx_th_display_table_0.setPageContext(_jspx_page_context);
          _jspx_th_display_table_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_present_0);
          _jspx_th_display_table_0.setClass("table_list");
          _jspx_th_display_table_0.setName(new String("queryList"));
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
              out.write("\t\t\t\t\t");
              //  display:column
              org.displaytag.tags.ColumnTag _jspx_th_display_column_0 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
              _jspx_th_display_column_0.setPageContext(_jspx_page_context);
              _jspx_th_display_column_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
              _jspx_th_display_column_0.setTitle("群組名稱");
              int _jspx_eval_display_column_0 = _jspx_th_display_column_0.doStartTag();
              if (_jspx_eval_display_column_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_display_column_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_display_column_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_display_column_0.doInitBody();
                }
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_0);
                  _jspx_th_bean_define_0.setId("ID");
                  _jspx_th_bean_define_0.setName("row");
                  _jspx_th_bean_define_0.setProperty("ID");
                  _jspx_th_bean_define_0.setType("java.lang.Object");
                  int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
                  if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
                  java.lang.Object ID = null;
                  ID = (java.lang.Object) _jspx_page_context.findAttribute("ID");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
                  //  html:multibox
                  org.apache.struts.taglib.html.MultiboxTag _jspx_th_html_multibox_0 = (org.apache.struts.taglib.html.MultiboxTag) _jspx_tagPool_html_multibox_value_property_nobody.get(org.apache.struts.taglib.html.MultiboxTag.class);
                  _jspx_th_html_multibox_0.setPageContext(_jspx_page_context);
                  _jspx_th_html_multibox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_0);
                  _jspx_th_html_multibox_0.setProperty("GID");
                  _jspx_th_html_multibox_0.setValue(ID.toString());
                  int _jspx_eval_html_multibox_0 = _jspx_th_html_multibox_0.doStartTag();
                  if (_jspx_th_html_multibox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_html_multibox_value_property_nobody.reuse(_jspx_th_html_multibox_0);
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
                  if (_jspx_meth_bean_write_0(_jspx_th_display_column_0, _jspx_page_context))
                    return;
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
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
              out.write("\t\t\t\t");
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
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_logic_present_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_logic_present_name.reuse(_jspx_th_logic_present_0);
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("-->\r\n");
      out.write("</table>\r\n");
      out.write("<table class=\"table_1\" width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class=\"table_function\" align=\"right\" colspan=\"2\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_submit_0(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_logic_notPresent_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    //  logic:notPresent
    org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_0 = (org.apache.struts.taglib.logic.NotPresentTag) _jspx_tagPool_logic_notPresent_name.get(org.apache.struts.taglib.logic.NotPresentTag.class);
    _jspx_th_logic_notPresent_0.setPageContext(_jspx_page_context);
    _jspx_th_logic_notPresent_0.setParent(null);
    _jspx_th_logic_notPresent_0.setName("blankMap");
    int _jspx_eval_logic_notPresent_0 = _jspx_th_logic_notPresent_0.doStartTag();
    if (_jspx_eval_logic_notPresent_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        out.write('	');
        java.util.HashMap blankMap = null;
        synchronized (_jspx_page_context) {
          blankMap = (java.util.HashMap) _jspx_page_context.getAttribute("blankMap", PageContext.PAGE_SCOPE);
          if (blankMap == null){
            blankMap = new java.util.HashMap();
            _jspx_page_context.setAttribute("blankMap", blankMap, PageContext.PAGE_SCOPE);
          }
        }
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_logic_notPresent_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_notPresent_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_logic_notPresent_name.reuse(_jspx_th_logic_notPresent_0);
    return false;
  }

  private boolean _jspx_meth_html_select_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:select
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_0 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_property_name.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_select_0.setPageContext(_jspx_page_context);
    _jspx_th_html_select_0.setParent(null);
    _jspx_th_html_select_0.setName("blankMap");
    _jspx_th_html_select_0.setProperty("");
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
        if (_jspx_meth_html_options_0(_jspx_th_html_select_0, _jspx_page_context))
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
    _jspx_tagPool_html_select_property_name.reuse(_jspx_th_html_select_0);
    return false;
  }

  private boolean _jspx_meth_html_options_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:options
    org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_0 = (org.apache.struts.taglib.html.OptionsTag) _jspx_tagPool_html_options_property_labelProperty_collection_nobody.get(org.apache.struts.taglib.html.OptionsTag.class);
    _jspx_th_html_options_0.setPageContext(_jspx_page_context);
    _jspx_th_html_options_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_0);
    _jspx_th_html_options_0.setCollection("DeptGroupList");
    _jspx_th_html_options_0.setProperty("valuess");
    _jspx_th_html_options_0.setLabelProperty("label");
    int _jspx_eval_html_options_0 = _jspx_th_html_options_0.doStartTag();
    if (_jspx_th_html_options_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_options_property_labelProperty_collection_nobody.reuse(_jspx_th_html_options_0);
    return false;
  }

  private boolean _jspx_meth_html_select_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:select
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_1 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_property_name.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_select_1.setPageContext(_jspx_page_context);
    _jspx_th_html_select_1.setParent(null);
    _jspx_th_html_select_1.setName("blankMap");
    _jspx_th_html_select_1.setProperty("GCODE");
    int _jspx_eval_html_select_1 = _jspx_th_html_select_1.doStartTag();
    if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_select_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_select_1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_html_options_1(_jspx_th_html_select_1, _jspx_page_context))
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
    _jspx_tagPool_html_select_property_name.reuse(_jspx_th_html_select_1);
    return false;
  }

  private boolean _jspx_meth_html_options_1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:options
    org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_1 = (org.apache.struts.taglib.html.OptionsTag) _jspx_tagPool_html_options_property_labelProperty_collection_nobody.get(org.apache.struts.taglib.html.OptionsTag.class);
    _jspx_th_html_options_1.setPageContext(_jspx_page_context);
    _jspx_th_html_options_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_1);
    _jspx_th_html_options_1.setCollection("NameGroupList");
    _jspx_th_html_options_1.setProperty("valuess");
    _jspx_th_html_options_1.setLabelProperty("label");
    int _jspx_eval_html_options_1 = _jspx_th_html_options_1.doStartTag();
    if (_jspx_th_html_options_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_options_property_labelProperty_collection_nobody.reuse(_jspx_th_html_options_1);
    return false;
  }

  private boolean _jspx_meth_bean_write_0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_column_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_0);
    _jspx_th_bean_write_0.setName("row");
    _jspx_th_bean_write_0.setProperty("GroupName");
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_0);
    return false;
  }

  private boolean _jspx_meth_html_submit_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_html_submit_0 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_html_submit_value_styleClass_property_onclick_nobody.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_html_submit_0.setPageContext(_jspx_page_context);
    _jspx_th_html_submit_0.setParent(null);
    _jspx_th_html_submit_0.setStyleClass("formcss_rbutton");
    _jspx_th_html_submit_0.setProperty("doQry");
    _jspx_th_html_submit_0.setValue("查詢");
    _jspx_th_html_submit_0.setOnclick("return checkForm(this.form);");
    int _jspx_eval_html_submit_0 = _jspx_th_html_submit_0.doStartTag();
    if (_jspx_th_html_submit_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_submit_value_styleClass_property_onclick_nobody.reuse(_jspx_th_html_submit_0);
    return false;
  }
}
