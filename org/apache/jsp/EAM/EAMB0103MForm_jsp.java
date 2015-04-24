package org.apache.jsp.EAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.math.BigDecimal;
import tw.gov.nta.sql.account.VoucherDet;

public final class EAMB0103MForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_select_property_onchange_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_select_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_option_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_hidden_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_table_name_id_class;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notEmpty_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_scope_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_column;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_column_title_style;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_textarea_rows_property_name_cols_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_column_title_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notEmpty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_iterate_name_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_equal_value_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_format_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_select_property_onchange_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_select_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_option_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_hidden_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_table_name_id_class = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_notEmpty_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_scope_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_column = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_column_title_style = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_textarea_rows_property_name_cols_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_column_title_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_notEmpty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_iterate_name_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_equal_value_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_format_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_select_property_onchange_name.release();
    _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.release();
    _jspx_tagPool_html_select_property_name.release();
    _jspx_tagPool_html_option_value.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_html_hidden_property_name_nobody.release();
    _jspx_tagPool_display_table_name_id_class.release();
    _jspx_tagPool_logic_notEmpty_name.release();
    _jspx_tagPool_bean_write_scope_property_name_nobody.release();
    _jspx_tagPool_display_column.release();
    _jspx_tagPool_display_column_title_style.release();
    _jspx_tagPool_bean_define_property_name_id_nobody.release();
    _jspx_tagPool_html_textarea_rows_property_name_cols_nobody.release();
    _jspx_tagPool_display_column_title_nobody.release();
    _jspx_tagPool_logic_notEmpty_property_name.release();
    _jspx_tagPool_logic_iterate_name_id.release();
    _jspx_tagPool_logic_equal_value_property_name.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_bean_write_property_name_nobody.release();
    _jspx_tagPool_bean_write_property_name_format_nobody.release();
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

      out.write("<!-- EAMB0103MForm.jsp -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
    char sysId =  ((String)session.getAttribute("SYSID")).charAt(5);
    String sysType = String.valueOf(sysId).trim();
    if ("3".equals(sysType)){

      out.write("\r\n");
      out.write("   \t傳票日期：<input type=\"text\" name=\"date(voucherDate)\" maxlength=\"7\" value=\"");
      out.print(request.getAttribute("date(voucherDate)"));
      out.write("\"/> \r\n");
      out.write("   \t傳票類型： \r\n");
      out.write("   \t");
      if (_jspx_meth_html_select_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t債務別：\r\n");
      out.write("   \t");
      if (_jspx_meth_html_select_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<br>\r\n");
      out.write("\t　　摘要：\r\n");
      out.write("\t<input type=\"textarea\" name=\"remark\" size=\"100\" value=\"");
      out.print(request.getAttribute("remark") );
      out.write("\" />\r\n");
      out.write("\t<br>\r\n");
      out.write("\t會計階段：\r\n");
      out.write("   \t");
      if (_jspx_meth_html_select_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<input type=\"hidden\" name=\"mark\" value=\"1\" />\r\n");
      out.write("\t");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
	}
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_html_hidden_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_html_hidden_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      //  display:table
      org.displaytag.tags.TableTag _jspx_th_display_table_0 = (org.displaytag.tags.TableTag) _jspx_tagPool_display_table_name_id_class.get(org.displaytag.tags.TableTag.class);
      _jspx_th_display_table_0.setPageContext(_jspx_page_context);
      _jspx_th_display_table_0.setParent(null);
      _jspx_th_display_table_0.setClass("table_list");
      _jspx_th_display_table_0.setName(new String("sessionScope.voucherList"));
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
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  logic:notEmpty
          org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_0 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
          _jspx_th_logic_notEmpty_0.setPageContext(_jspx_page_context);
          _jspx_th_logic_notEmpty_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_logic_notEmpty_0.setName("row");
          int _jspx_eval_logic_notEmpty_0 = _jspx_th_logic_notEmpty_0.doStartTag();
          if (_jspx_eval_logic_notEmpty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t");
              if (_jspx_meth_bean_write_0(_jspx_th_logic_notEmpty_0, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("\t\t\t");
if (!"3".equals(sysType)){
              out.write("\r\n");
              out.write("\t\t\t\t");
              if (_jspx_meth_display_column_0(_jspx_th_logic_notEmpty_0, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  display:column
              org.displaytag.tags.ColumnTag _jspx_th_display_column_1 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title_style.get(org.displaytag.tags.ColumnTag.class);
              _jspx_th_display_column_1.setPageContext(_jspx_page_context);
              _jspx_th_display_column_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
              _jspx_th_display_column_1.setTitle("傳票日期");
              _jspx_th_display_column_1.setStyle("width: 20");
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
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_1);
                  _jspx_th_bean_define_0.setId("voucherDate");
                  _jspx_th_bean_define_0.setName("row");
                  _jspx_th_bean_define_0.setProperty("voucherDate");
                  int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
                  if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
                  java.lang.Object voucherDate = null;
                  voucherDate = (java.lang.Object) _jspx_page_context.findAttribute("voucherDate");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");

						String voucherROCDate = gov.dnt.tame.util.DateUtil.date2ROCStr((java.util.Date)voucherDate);
					
                  out.write("\r\n");
                  out.write("\t\t\t\t\t<input type=\"text\" name=\"date(voucherDate)\" value='");
                  out.print(voucherROCDate );
                  out.write("' size='7' />\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_display_column_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_display_column_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_display_column_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_display_column_title_style.reuse(_jspx_th_display_column_1);
              out.write("\r\n");
              out.write("\t\t\t\t");
              if (_jspx_meth_display_column_2(_jspx_th_logic_notEmpty_0, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("\t\t\t");
}else{
              out.write("\r\n");
              out.write("\t\t\t\t");
              if (_jspx_meth_display_column_3(_jspx_th_logic_notEmpty_0, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("\t\t\t");
}
              out.write("\r\n");
              out.write("\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_1 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_1.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
              _jspx_th_logic_notEmpty_1.setName("row");
              _jspx_th_logic_notEmpty_1.setProperty("voucherDets");
              int _jspx_eval_logic_notEmpty_1 = _jspx_th_logic_notEmpty_1.doStartTag();
              if (_jspx_eval_logic_notEmpty_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_1);
                  _jspx_th_bean_define_1.setId("voucher");
                  _jspx_th_bean_define_1.setName("row");
                  _jspx_th_bean_define_1.setProperty("voucherDets");
                  int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
                  if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
                  java.lang.Object voucher = null;
                  voucher = (java.lang.Object) _jspx_page_context.findAttribute("voucher");
                  out.write("\r\n");
                  out.write("\t\t\t");
                  //  display:column
                  org.displaytag.tags.ColumnTag _jspx_th_display_column_4 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column.get(org.displaytag.tags.ColumnTag.class);
                  _jspx_th_display_column_4.setPageContext(_jspx_page_context);
                  _jspx_th_display_column_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_1);
                  int _jspx_eval_display_column_4 = _jspx_th_display_column_4.doStartTag();
                  if (_jspx_eval_display_column_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_display_column_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_display_column_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_display_column_4.doInitBody();
                    }
                    do {
                      out.write("\r\n");
                      out.write("\t\t\t    <font size=\"8\">\r\n");
                      out.write("\t\t\t\t\t<table class=\"table_list\" border=\"2\">\r\n");
                      out.write("\t\t\t\t\t<tr>\r\n");
                      out.write("\t\t\t\t\t\t<th><font size=\"2\">會計科目</font></th>\r\n");
                      out.write("\t\t\t\t\t\t<th><font size=\"2\">借方金額</font></th>\r\n");
                      out.write("\t\t\t\t\t\t<th><font size=\"2\">貸方金額</font></th>\r\n");
                      out.write("\t\t\t\t\t\t</font>\r\n");
                      out.write("\t\t\t\t\t</tr>\r\n");
                      out.write("\t\t\t\t\t");
 BigDecimal balance = new BigDecimal(0);
                      out.write("\r\n");
                      out.write("\t\t\t\t\t");
                      //  logic:iterate
                      org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_0 = (org.apache.struts.taglib.logic.IterateTag) _jspx_tagPool_logic_iterate_name_id.get(org.apache.struts.taglib.logic.IterateTag.class);
                      _jspx_th_logic_iterate_0.setPageContext(_jspx_page_context);
                      _jspx_th_logic_iterate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_4);
                      _jspx_th_logic_iterate_0.setId("detail");
                      _jspx_th_logic_iterate_0.setName("voucher");
                      int _jspx_eval_logic_iterate_0 = _jspx_th_logic_iterate_0.doStartTag();
                      if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        java.lang.Object detail = null;
                        if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                          out = _jspx_page_context.pushBody();
                          _jspx_th_logic_iterate_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                          _jspx_th_logic_iterate_0.doInitBody();
                        }
                        detail = (java.lang.Object) _jspx_page_context.findAttribute("detail");
                        do {
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t<tr>\r\n");
                          out.write("\t\t\t\t\t\t\t<td>\r\n");
                          out.write("\t\t\t\t\t\t\t\t\r\n");
                          out.write("\t\t\t\t\t\t\t\t");
                          if (_jspx_meth_logic_equal_0(_jspx_th_logic_iterate_0, _jspx_page_context))
                            return;
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t<font size=\"2\">\r\n");
                          out.write("\t\t\t\t\t\t\t\t");
if ("3".equals(sysType)){
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t\t<a href=\"EAMB0111?account=");
                          if (_jspx_meth_c_out_0(_jspx_th_logic_iterate_0, _jspx_page_context))
                            return;
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t\t         &issueMain.id=");
                          if (_jspx_meth_c_out_1(_jspx_th_logic_iterate_0, _jspx_page_context))
                            return;
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t\t         &issueMain.debtType=");
                          if (_jspx_meth_c_out_2(_jspx_th_logic_iterate_0, _jspx_page_context))
                            return;
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t\t         &phaseId=");
                          if (_jspx_meth_c_out_3(_jspx_th_logic_iterate_0, _jspx_page_context))
                            return;
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t\t         &voucherType=");
                          if (_jspx_meth_c_out_4(_jspx_th_logic_iterate_0, _jspx_page_context))
                            return;
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t\t         &date(voucherDate)=");
                          if (_jspx_meth_c_out_5(_jspx_th_logic_iterate_0, _jspx_page_context))
                            return;
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t\t         &remark=");
                          if (_jspx_meth_c_out_6(_jspx_th_logic_iterate_0, _jspx_page_context))
                            return;
                          out.write("\" >\r\n");
                          out.write("\t\t\t\t\t\t\t\t");
} 
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t");
                          if (_jspx_meth_bean_write_2(_jspx_th_logic_iterate_0, _jspx_page_context))
                            return;
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t");
if ("3".equals(sysType)){
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t</a>\r\n");
                          out.write("\t\t\t\t\t\t\t\t");
} 
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t</font>\r\n");
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t</td>\r\n");
                          out.write("\t\t\t\t\t\t\t<td align=\"right\">\r\n");
                          out.write("\t\t\t\t\t\t\t\t<div align=\"right\">\r\n");
                          out.write("\t\t\t\t\t\t\t\t\t");
 	
											VoucherDet voucherDet = (VoucherDet)detail;
											BigDecimal accountAmount = voucherDet.getAccountAmount();
									
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t\t");
                          //  logic:equal
                          org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_1 = (org.apache.struts.taglib.logic.EqualTag) _jspx_tagPool_logic_equal_value_property_name.get(org.apache.struts.taglib.logic.EqualTag.class);
                          _jspx_th_logic_equal_1.setPageContext(_jspx_page_context);
                          _jspx_th_logic_equal_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
                          _jspx_th_logic_equal_1.setValue("D");
                          _jspx_th_logic_equal_1.setName("detail");
                          _jspx_th_logic_equal_1.setProperty("accountType");
                          int _jspx_eval_logic_equal_1 = _jspx_th_logic_equal_1.doStartTag();
                          if (_jspx_eval_logic_equal_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            do {
                              out.write("\r\n");
                              out.write("\t\t\t\t\t\t\t\t\t\t<font size=\"2\">");
                              if (_jspx_meth_bean_write_3(_jspx_th_logic_equal_1, _jspx_page_context))
                              return;
                              out.write("</font>\r\n");
                              out.write("\t\t\t\t\t\t\t\t\t\t");

											balance = balance.add(accountAmount);
										
                              out.write("\r\n");
                              out.write("\t\t\t\t\t\t\t\t\t");
                              int evalDoAfterBody = _jspx_th_logic_equal_1.doAfterBody();
                              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                              break;
                            } while (true);
                          }
                          if (_jspx_th_logic_equal_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          _jspx_tagPool_logic_equal_value_property_name.reuse(_jspx_th_logic_equal_1);
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
                          out.write("\t\t\t\t\t\t\t</td>\r\n");
                          out.write("\t\t\t\t\t\t\t<td>\r\n");
                          out.write("\t\t\t\t\t\t\t\t<div align=\"right\">\r\n");
                          out.write("\t\t\t\t\t\t\t\t\t");
                          //  logic:equal
                          org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_2 = (org.apache.struts.taglib.logic.EqualTag) _jspx_tagPool_logic_equal_value_property_name.get(org.apache.struts.taglib.logic.EqualTag.class);
                          _jspx_th_logic_equal_2.setPageContext(_jspx_page_context);
                          _jspx_th_logic_equal_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
                          _jspx_th_logic_equal_2.setValue("C");
                          _jspx_th_logic_equal_2.setName("detail");
                          _jspx_th_logic_equal_2.setProperty("accountType");
                          int _jspx_eval_logic_equal_2 = _jspx_th_logic_equal_2.doStartTag();
                          if (_jspx_eval_logic_equal_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            do {
                              out.write("\r\n");
                              out.write("\t\t\t\t\t\t\t\t\t\t<font size=\"2\">");
                              if (_jspx_meth_bean_write_4(_jspx_th_logic_equal_2, _jspx_page_context))
                              return;
                              out.write("</font>\r\n");
                              out.write("\t\t\t\t\t\t\t\t\t\t");
 
											balance = balance.subtract(accountAmount);
										
                              out.write("\r\n");
                              out.write("\t\t\t\t\t\t\t\t\t");
                              int evalDoAfterBody = _jspx_th_logic_equal_2.doAfterBody();
                              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                              break;
                            } while (true);
                          }
                          if (_jspx_th_logic_equal_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          _jspx_tagPool_logic_equal_value_property_name.reuse(_jspx_th_logic_equal_2);
                          out.write("\r\n");
                          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
                          out.write("\t\t\t\t\t\t\t</td>\r\n");
                          out.write("\t\t\t\t\t\t</tr>\r\n");
                          out.write("\t\t\t\t\t");
                          int evalDoAfterBody = _jspx_th_logic_iterate_0.doAfterBody();
                          detail = (java.lang.Object) _jspx_page_context.findAttribute("detail");
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                        if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                          out = _jspx_page_context.popBody();
                      }
                      if (_jspx_th_logic_iterate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      _jspx_tagPool_logic_iterate_name_id.reuse(_jspx_th_logic_iterate_0);
                      out.write("\r\n");
                      out.write("\t\t\t\t\t<tr>\r\n");
                      out.write("\t\t\t\t\t\t<td align=\"right\"><font size=\"2\">餘額</font></td>\r\n");
                      out.write("\t\t\t\t\t\t");
if (balance.compareTo(new BigDecimal(0)) >= 0){ 
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t\t<td><div align=\"right\"><font size=\"2\">");
                      out.print(java.text.DecimalFormat.getInstance().format(balance.doubleValue()));
                      out.write("</font></div></td>\r\n");
                      out.write("\t\t\t\t\t\t\t<td></td>\r\n");
                      out.write("\t\t\t\t\t\t");
}else{
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t\t<td></td>\r\n");
                      out.write("\t\t\t\t\t\t\t<td><div align=\"right\"><font size=\"2\">");
                      out.print(java.text.DecimalFormat.getInstance().format(balance.abs().doubleValue()));
                      out.write("</font></div></td>\r\n");
                      out.write("\t\t\t\t\t\t");
}
                      out.write("\r\n");
                      out.write("\t\t\t\t\t</tr>\r\n");
                      out.write("\t\t\t\t\t</table>\r\n");
                      out.write("\t\t\t\t</font>\r\n");
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
                  _jspx_tagPool_display_column.reuse(_jspx_th_display_column_4);
                  out.write("\r\n");
                  out.write("\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_1);
              out.write('\r');
              out.write('\n');
              out.write('	');
              int evalDoAfterBody = _jspx_th_logic_notEmpty_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_logic_notEmpty_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_logic_notEmpty_name.reuse(_jspx_th_logic_notEmpty_0);
          out.write(' ');
          out.write('\r');
          out.write('\n');
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
      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_html_select_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:select
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_0 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_property_onchange_name.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_select_0.setPageContext(_jspx_page_context);
    _jspx_th_html_select_0.setParent(null);
    _jspx_th_html_select_0.setName("Eamb0103Form");
    _jspx_th_html_select_0.setProperty("voucherType");
    _jspx_th_html_select_0.setOnchange("form.action='EAMB0115';form.submit();");
    int _jspx_eval_html_select_0 = _jspx_th_html_select_0.doStartTag();
    if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_select_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_select_0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_html_optionsCollection_0(_jspx_th_html_select_0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
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

  private boolean _jspx_meth_html_optionsCollection_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:optionsCollection
    org.apache.struts.taglib.html.OptionsCollectionTag _jspx_th_html_optionsCollection_0 = (org.apache.struts.taglib.html.OptionsCollectionTag) _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.get(org.apache.struts.taglib.html.OptionsCollectionTag.class);
    _jspx_th_html_optionsCollection_0.setPageContext(_jspx_page_context);
    _jspx_th_html_optionsCollection_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_0);
    _jspx_th_html_optionsCollection_0.setName("Eamb0103Form");
    _jspx_th_html_optionsCollection_0.setProperty("phaseTypes");
    _jspx_th_html_optionsCollection_0.setLabel("value");
    _jspx_th_html_optionsCollection_0.setValue("key");
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
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_1 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_property_name.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_select_1.setPageContext(_jspx_page_context);
    _jspx_th_html_select_1.setParent(null);
    _jspx_th_html_select_1.setName("Eamb0103Form");
    _jspx_th_html_select_1.setProperty("debtCode");
    int _jspx_eval_html_select_1 = _jspx_th_html_select_1.doStartTag();
    if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_select_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_select_1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_html_optionsCollection_1(_jspx_th_html_select_1, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
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

  private boolean _jspx_meth_html_optionsCollection_1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:optionsCollection
    org.apache.struts.taglib.html.OptionsCollectionTag _jspx_th_html_optionsCollection_1 = (org.apache.struts.taglib.html.OptionsCollectionTag) _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.get(org.apache.struts.taglib.html.OptionsCollectionTag.class);
    _jspx_th_html_optionsCollection_1.setPageContext(_jspx_page_context);
    _jspx_th_html_optionsCollection_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_1);
    _jspx_th_html_optionsCollection_1.setName("Eamb0103Form");
    _jspx_th_html_optionsCollection_1.setProperty("debtCodeList");
    _jspx_th_html_optionsCollection_1.setLabel("debitName");
    _jspx_th_html_optionsCollection_1.setValue("id");
    int _jspx_eval_html_optionsCollection_1 = _jspx_th_html_optionsCollection_1.doStartTag();
    if (_jspx_th_html_optionsCollection_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.reuse(_jspx_th_html_optionsCollection_1);
    return false;
  }

  private boolean _jspx_meth_html_select_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:select
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_2 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_property_onchange_name.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_select_2.setPageContext(_jspx_page_context);
    _jspx_th_html_select_2.setParent(null);
    _jspx_th_html_select_2.setName("Eamb0103Form");
    _jspx_th_html_select_2.setProperty("phaseId");
    _jspx_th_html_select_2.setOnchange("form.action='EAMB0115';form.submit();");
    int _jspx_eval_html_select_2 = _jspx_th_html_select_2.doStartTag();
    if (_jspx_eval_html_select_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_select_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_select_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_select_2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("   \t\t");
        if (_jspx_meth_html_option_0(_jspx_th_html_select_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_html_optionsCollection_2(_jspx_th_html_select_2, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        int evalDoAfterBody = _jspx_th_html_select_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_select_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_select_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_select_property_onchange_name.reuse(_jspx_th_html_select_2);
    return false;
  }

  private boolean _jspx_meth_html_option_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:option
    org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_0 = (org.apache.struts.taglib.html.OptionTag) _jspx_tagPool_html_option_value.get(org.apache.struts.taglib.html.OptionTag.class);
    _jspx_th_html_option_0.setPageContext(_jspx_page_context);
    _jspx_th_html_option_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_2);
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

  private boolean _jspx_meth_html_optionsCollection_2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:optionsCollection
    org.apache.struts.taglib.html.OptionsCollectionTag _jspx_th_html_optionsCollection_2 = (org.apache.struts.taglib.html.OptionsCollectionTag) _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.get(org.apache.struts.taglib.html.OptionsCollectionTag.class);
    _jspx_th_html_optionsCollection_2.setPageContext(_jspx_page_context);
    _jspx_th_html_optionsCollection_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_2);
    _jspx_th_html_optionsCollection_2.setName("Eamb0103Form");
    _jspx_th_html_optionsCollection_2.setProperty("phaseList");
    _jspx_th_html_optionsCollection_2.setLabel("phaseName");
    _jspx_th_html_optionsCollection_2.setValue("id");
    int _jspx_eval_html_optionsCollection_2 = _jspx_th_html_optionsCollection_2.doStartTag();
    if (_jspx_th_html_optionsCollection_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_optionsCollection_value_property_name_label_nobody.reuse(_jspx_th_html_optionsCollection_2);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.el.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest("${sessionScope.debtTypeCode eq 'A' }");
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t發行方式：\r\n");
        out.write("\t   \t");
        if (_jspx_meth_html_select_3(_jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_html_select_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:select
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_3 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_property_name.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_select_3.setPageContext(_jspx_page_context);
    _jspx_th_html_select_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_html_select_3.setName("Eamb0103Form");
    _jspx_th_html_select_3.setProperty("issueKind");
    int _jspx_eval_html_select_3 = _jspx_th_html_select_3.doStartTag();
    if (_jspx_eval_html_select_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_select_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_select_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_select_3.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_html_option_1(_jspx_th_html_select_3, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_html_option_2(_jspx_th_html_select_3, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_html_select_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_select_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_select_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_select_property_name.reuse(_jspx_th_html_select_3);
    return false;
  }

  private boolean _jspx_meth_html_option_1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:option
    org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_1 = (org.apache.struts.taglib.html.OptionTag) _jspx_tagPool_html_option_value.get(org.apache.struts.taglib.html.OptionTag.class);
    _jspx_th_html_option_1.setPageContext(_jspx_page_context);
    _jspx_th_html_option_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_3);
    _jspx_th_html_option_1.setValue("0");
    int _jspx_eval_html_option_1 = _jspx_th_html_option_1.doStartTag();
    if (_jspx_eval_html_option_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_option_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_option_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_option_1.doInitBody();
      }
      do {
        out.write('登');
        out.write('錄');
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

  private boolean _jspx_meth_html_option_2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:option
    org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_2 = (org.apache.struts.taglib.html.OptionTag) _jspx_tagPool_html_option_value.get(org.apache.struts.taglib.html.OptionTag.class);
    _jspx_th_html_option_2.setPageContext(_jspx_page_context);
    _jspx_th_html_option_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_3);
    _jspx_th_html_option_2.setValue("1");
    int _jspx_eval_html_option_2 = _jspx_th_html_option_2.doStartTag();
    if (_jspx_eval_html_option_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_option_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_option_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_option_2.doInitBody();
      }
      do {
        out.write('債');
        out.write('票');
        int evalDoAfterBody = _jspx_th_html_option_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_option_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_option_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_option_value.reuse(_jspx_th_html_option_2);
    return false;
  }

  private boolean _jspx_meth_html_hidden_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_0.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_0.setParent(null);
    _jspx_th_html_hidden_0.setName("Eamb0103Form");
    _jspx_th_html_hidden_0.setProperty("issueMain.id");
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
    _jspx_th_html_hidden_1.setName("Eamb0103Form");
    _jspx_th_html_hidden_1.setProperty("issueMain.debtType");
    int _jspx_eval_html_hidden_1 = _jspx_th_html_hidden_1.doStartTag();
    if (_jspx_th_html_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_1);
    return false;
  }

  private boolean _jspx_meth_bean_write_0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEmpty_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_scope_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
    _jspx_th_bean_write_0.setName("row");
    _jspx_th_bean_write_0.setProperty("id");
    _jspx_th_bean_write_0.setScope("page");
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_scope_property_name_nobody.reuse(_jspx_th_bean_write_0);
    return false;
  }

  private boolean _jspx_meth_display_column_0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEmpty_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_column_0 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_column_0.setPageContext(_jspx_page_context);
    _jspx_th_display_column_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
    int _jspx_eval_display_column_0 = _jspx_th_display_column_0.doStartTag();
    if (_jspx_eval_display_column_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_display_column_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_display_column_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_display_column_0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<input type=\"checkbox\" name=\"mark\" checked=\"checked\" value=\"");
        if (_jspx_meth_bean_write_1(_jspx_th_display_column_0, _jspx_page_context))
          return true;
        out.write("\" />\r\n");
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
    _jspx_tagPool_display_column.reuse(_jspx_th_display_column_0);
    return false;
  }

  private boolean _jspx_meth_bean_write_1(javax.servlet.jsp.tagext.JspTag _jspx_th_display_column_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_scope_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_1.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_0);
    _jspx_th_bean_write_1.setName("row");
    _jspx_th_bean_write_1.setScope("page");
    _jspx_th_bean_write_1.setProperty("voucherSer");
    int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
    if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_scope_property_name_nobody.reuse(_jspx_th_bean_write_1);
    return false;
  }

  private boolean _jspx_meth_display_column_2(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEmpty_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_column_2 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title_style.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_column_2.setPageContext(_jspx_page_context);
    _jspx_th_display_column_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
    _jspx_th_display_column_2.setTitle("摘要");
    _jspx_th_display_column_2.setStyle("width: 30%");
    int _jspx_eval_display_column_2 = _jspx_th_display_column_2.doStartTag();
    if (_jspx_eval_display_column_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_display_column_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_display_column_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_display_column_2.doInitBody();
      }
      do {
        out.write(" \r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_html_textarea_0(_jspx_th_display_column_2, _jspx_page_context))
          return true;
        out.write("\r\n");
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
    _jspx_tagPool_display_column_title_style.reuse(_jspx_th_display_column_2);
    return false;
  }

  private boolean _jspx_meth_html_textarea_0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_column_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:textarea
    org.apache.struts.taglib.html.TextareaTag _jspx_th_html_textarea_0 = (org.apache.struts.taglib.html.TextareaTag) _jspx_tagPool_html_textarea_rows_property_name_cols_nobody.get(org.apache.struts.taglib.html.TextareaTag.class);
    _jspx_th_html_textarea_0.setPageContext(_jspx_page_context);
    _jspx_th_html_textarea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_2);
    _jspx_th_html_textarea_0.setName("row");
    _jspx_th_html_textarea_0.setProperty("remark");
    _jspx_th_html_textarea_0.setCols("35");
    _jspx_th_html_textarea_0.setRows("4");
    int _jspx_eval_html_textarea_0 = _jspx_th_html_textarea_0.doStartTag();
    if (_jspx_th_html_textarea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_textarea_rows_property_name_cols_nobody.reuse(_jspx_th_html_textarea_0);
    return false;
  }

  private boolean _jspx_meth_display_column_3(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_notEmpty_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_column_3 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title_nobody.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_column_3.setPageContext(_jspx_page_context);
    _jspx_th_display_column_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
    _jspx_th_display_column_3.setTitle("");
    int _jspx_eval_display_column_3 = _jspx_th_display_column_3.doStartTag();
    if (_jspx_th_display_column_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_display_column_title_nobody.reuse(_jspx_th_display_column_3);
    return false;
  }

  private boolean _jspx_meth_logic_equal_0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_iterate_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:equal
    org.apache.struts.taglib.logic.EqualTag _jspx_th_logic_equal_0 = (org.apache.struts.taglib.logic.EqualTag) _jspx_tagPool_logic_equal_value_property_name.get(org.apache.struts.taglib.logic.EqualTag.class);
    _jspx_th_logic_equal_0.setPageContext(_jspx_page_context);
    _jspx_th_logic_equal_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
    _jspx_th_logic_equal_0.setValue("C");
    _jspx_th_logic_equal_0.setName("detail");
    _jspx_th_logic_equal_0.setProperty("accountType");
    int _jspx_eval_logic_equal_0 = _jspx_th_logic_equal_0.doStartTag();
    if (_jspx_eval_logic_equal_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('　');
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

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_iterate_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
    _jspx_th_c_out_0.setValue("${detail.account.id}");
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_iterate_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
    _jspx_th_c_out_1.setValue("${Eamb0103Form.issueMain.id}");
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_iterate_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
    _jspx_th_c_out_2.setValue("${Eamb0103Form.issueMain.debtType}");
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
    return false;
  }

  private boolean _jspx_meth_c_out_3(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_iterate_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_3 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_out_3.setPageContext(_jspx_page_context);
    _jspx_th_c_out_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
    _jspx_th_c_out_3.setValue("${Eamb0103Form.phaseId}");
    int _jspx_eval_c_out_3 = _jspx_th_c_out_3.doStartTag();
    if (_jspx_th_c_out_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
    return false;
  }

  private boolean _jspx_meth_c_out_4(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_iterate_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_4 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_out_4.setPageContext(_jspx_page_context);
    _jspx_th_c_out_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
    _jspx_th_c_out_4.setValue("${Eamb0103Form.voucherType}");
    int _jspx_eval_c_out_4 = _jspx_th_c_out_4.doStartTag();
    if (_jspx_th_c_out_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
    return false;
  }

  private boolean _jspx_meth_c_out_5(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_iterate_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_5 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_out_5.setPageContext(_jspx_page_context);
    _jspx_th_c_out_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
    _jspx_th_c_out_5.setValue("${Eamb0103Form.makeDate}");
    int _jspx_eval_c_out_5 = _jspx_th_c_out_5.doStartTag();
    if (_jspx_th_c_out_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_5);
    return false;
  }

  private boolean _jspx_meth_c_out_6(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_iterate_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_6 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_out_6.setPageContext(_jspx_page_context);
    _jspx_th_c_out_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
    _jspx_th_c_out_6.setValue("${Eamb0103Form.remark}");
    int _jspx_eval_c_out_6 = _jspx_th_c_out_6.doStartTag();
    if (_jspx_th_c_out_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_6);
    return false;
  }

  private boolean _jspx_meth_bean_write_2(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_iterate_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_2 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_2.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
    _jspx_th_bean_write_2.setName("detail");
    _jspx_th_bean_write_2.setProperty("account.accountName");
    int _jspx_eval_bean_write_2 = _jspx_th_bean_write_2.doStartTag();
    if (_jspx_th_bean_write_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_2);
    return false;
  }

  private boolean _jspx_meth_bean_write_3(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_equal_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_3 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_format_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_3.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_equal_1);
    _jspx_th_bean_write_3.setName("detail");
    _jspx_th_bean_write_3.setProperty("accountAmount");
    _jspx_th_bean_write_3.setFormat("####,###");
    int _jspx_eval_bean_write_3 = _jspx_th_bean_write_3.doStartTag();
    if (_jspx_th_bean_write_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_format_nobody.reuse(_jspx_th_bean_write_3);
    return false;
  }

  private boolean _jspx_meth_bean_write_4(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_equal_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_4 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_format_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_4.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_equal_2);
    _jspx_th_bean_write_4.setName("detail");
    _jspx_th_bean_write_4.setProperty("accountAmount");
    _jspx_th_bean_write_4.setFormat("####,###");
    int _jspx_eval_bean_write_4 = _jspx_th_bean_write_4.doStartTag();
    if (_jspx_th_bean_write_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_format_nobody.reuse(_jspx_th_bean_write_4);
    return false;
  }
}
