package org.apache.jsp.CPM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.dnt.tame.util.DateUtil;
import java.math.BigDecimal;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.sql.debt.DebtPlanDet;

public final class CPMA0102ALForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notEmpty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_empty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_hidden_value_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_hidden_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_value_style_size_readonly_property_onblur_name_maxlength_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_style_readonly_property_name_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_display_table_name_id_class = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_column_title = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_type_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_notEmpty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_empty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_hidden_value_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_hidden_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_value_style_size_readonly_property_onblur_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_style_readonly_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_display_table_name_id_class.release();
    _jspx_tagPool_display_column_title.release();
    _jspx_tagPool_bean_define_type_property_name_id_nobody.release();
    _jspx_tagPool_logic_notEmpty_property_name.release();
    _jspx_tagPool_logic_empty_property_name.release();
    _jspx_tagPool_html_hidden_value_property_name_nobody.release();
    _jspx_tagPool_html_hidden_property_name_nobody.release();
    _jspx_tagPool_html_text_value_style_size_readonly_property_onblur_name_maxlength_nobody.release();
    _jspx_tagPool_html_text_style_readonly_property_name_nobody.release();
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
          out.write("\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_0 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_0.setPageContext(_jspx_page_context);
          _jspx_th_display_column_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_0.setTitle("償還否");
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
              //  bean:define
              org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
              _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
              _jspx_th_bean_define_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_0);
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
              out.write("\t\t\t\t");

					DebtPlanDet debtPlanDet = (DebtPlanDet)row;
					tw.gov.nta.debt.common.PayManager payManager = new tw.gov.nta.debt.common.PayManager();
					BigDecimal issueAmount = debtPlanDet.getDebt().getIssueAmount();
					BigDecimal payAmount = payManager.getCapitalByDebt(debtPlanDet.getDebt().getId().intValue());
					if(issueAmount.compareTo(payAmount)==0){
						out.println("以償還");
					}
					else{
						out.println("<input type='hidden' name='paymentId' value='"+id+"'/>");
						out.println("<input type='checkbox' name='ischeck' value='"+row_rowNum+"'/>");
					}
				
              out.write("\r\n");
              out.write("\t\t\t\t\r\n");
              out.write("\t\t\t\t\r\n");
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
          _jspx_th_display_column_1.setTitle("銀行代號");
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
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_0 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_0.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_1);
              _jspx_th_logic_notEmpty_0.setName("row");
              _jspx_th_logic_notEmpty_0.setProperty("debt.id");
              int _jspx_eval_logic_notEmpty_0 = _jspx_th_logic_notEmpty_0.doStartTag();
              if (_jspx_eval_logic_notEmpty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
                  _jspx_th_bean_define_1.setId("debtId");
                  _jspx_th_bean_define_1.setName("row");
                  _jspx_th_bean_define_1.setProperty("debt.id");
                  _jspx_th_bean_define_1.setType("java.lang.Integer");
                  int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
                  if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
                  java.lang.Integer debtId = null;
                  debtId = (java.lang.Integer) _jspx_page_context.findAttribute("debtId");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t<input type=\"hidden\" name=\"debtMainId\" value=\"");
                  out.print(debtId);
                  out.write("\"/>\t\t\r\n");
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
              out.write("\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_1 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_1.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_1);
              _jspx_th_logic_notEmpty_1.setName("row");
              _jspx_th_logic_notEmpty_1.setProperty("debt.bank");
              int _jspx_eval_logic_notEmpty_1 = _jspx_th_logic_notEmpty_1.doStartTag();
              if (_jspx_eval_logic_notEmpty_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\t\t\t\r\n");
                  out.write("\t\t\t\t\t");
                  //  logic:notEmpty
                  org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_2 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
                  _jspx_th_logic_notEmpty_2.setPageContext(_jspx_page_context);
                  _jspx_th_logic_notEmpty_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_1);
                  _jspx_th_logic_notEmpty_2.setName("row");
                  _jspx_th_logic_notEmpty_2.setProperty("debt.bank.bankCode");
                  int _jspx_eval_logic_notEmpty_2 = _jspx_th_logic_notEmpty_2.doStartTag();
                  if (_jspx_eval_logic_notEmpty_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      //  bean:define
                      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_2 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                      _jspx_th_bean_define_2.setPageContext(_jspx_page_context);
                      _jspx_th_bean_define_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_2);
                      _jspx_th_bean_define_2.setId("bankCode");
                      _jspx_th_bean_define_2.setName("row");
                      _jspx_th_bean_define_2.setProperty("debt.bank.bankCode");
                      _jspx_th_bean_define_2.setType("java.lang.String");
                      int _jspx_eval_bean_define_2 = _jspx_th_bean_define_2.doStartTag();
                      if (_jspx_th_bean_define_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_2);
                      java.lang.String bankCode = null;
                      bankCode = (java.lang.String) _jspx_page_context.findAttribute("bankCode");
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      out.print(bankCode);
                      out.write("\r\n");
                      out.write("\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_logic_notEmpty_2.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_logic_notEmpty_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_2);
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  logic:empty
                  org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_0 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
                  _jspx_th_logic_empty_0.setPageContext(_jspx_page_context);
                  _jspx_th_logic_empty_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_1);
                  _jspx_th_logic_empty_0.setName("row");
                  _jspx_th_logic_empty_0.setProperty("debt.bank.bankCode");
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
          _jspx_th_display_column_2.setTitle("銀行名稱");
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
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_3 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_3.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_2);
              _jspx_th_logic_notEmpty_3.setName("row");
              _jspx_th_logic_notEmpty_3.setProperty("debt.bank");
              int _jspx_eval_logic_notEmpty_3 = _jspx_th_logic_notEmpty_3.doStartTag();
              if (_jspx_eval_logic_notEmpty_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\t\t\t\r\n");
                  out.write("\t\t\t\t\t");
                  //  logic:notEmpty
                  org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_4 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
                  _jspx_th_logic_notEmpty_4.setPageContext(_jspx_page_context);
                  _jspx_th_logic_notEmpty_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_3);
                  _jspx_th_logic_notEmpty_4.setName("row");
                  _jspx_th_logic_notEmpty_4.setProperty("debt.bank.bankName");
                  int _jspx_eval_logic_notEmpty_4 = _jspx_th_logic_notEmpty_4.doStartTag();
                  if (_jspx_eval_logic_notEmpty_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      //  bean:define
                      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_3 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                      _jspx_th_bean_define_3.setPageContext(_jspx_page_context);
                      _jspx_th_bean_define_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_4);
                      _jspx_th_bean_define_3.setId("bankName");
                      _jspx_th_bean_define_3.setName("row");
                      _jspx_th_bean_define_3.setProperty("debt.bank.bankName");
                      _jspx_th_bean_define_3.setType("java.lang.String");
                      int _jspx_eval_bean_define_3 = _jspx_th_bean_define_3.doStartTag();
                      if (_jspx_th_bean_define_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_3);
                      java.lang.String bankName = null;
                      bankName = (java.lang.String) _jspx_page_context.findAttribute("bankName");
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      out.print(bankName);
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
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  logic:empty
                  org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_1 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
                  _jspx_th_logic_empty_1.setPageContext(_jspx_page_context);
                  _jspx_th_logic_empty_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_3);
                  _jspx_th_logic_empty_1.setName("row");
                  _jspx_th_logic_empty_1.setProperty("debt.bank.bankName");
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
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_3);
              out.write("\t\r\n");
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
          _jspx_th_display_column_3.setTitle("借款總額");
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
              _jspx_th_logic_notEmpty_5.setProperty("debt.issueAmount");
              int _jspx_eval_logic_notEmpty_5 = _jspx_th_logic_notEmpty_5.doStartTag();
              if (_jspx_eval_logic_notEmpty_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_4 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_4.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_5);
                  _jspx_th_bean_define_4.setId("issueAmount");
                  _jspx_th_bean_define_4.setName("row");
                  _jspx_th_bean_define_4.setProperty("debt.issueAmount");
                  _jspx_th_bean_define_4.setType("java.math.BigDecimal");
                  int _jspx_eval_bean_define_4 = _jspx_th_bean_define_4.doStartTag();
                  if (_jspx_th_bean_define_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_4);
                  java.math.BigDecimal issueAmount = null;
                  issueAmount = (java.math.BigDecimal) _jspx_page_context.findAttribute("issueAmount");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t<p align=\"right\">");
                  out.print(new java.text.DecimalFormat("#,##0").format(issueAmount));
                  out.write("</p>\r\n");
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
              if (_jspx_meth_logic_empty_2(_jspx_th_display_column_3, _jspx_page_context))
                return;
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
          _jspx_th_display_column_4.setTitle("計畫日期");
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
              _jspx_th_logic_notEmpty_6.setProperty("repayDate");
              int _jspx_eval_logic_notEmpty_6 = _jspx_th_logic_notEmpty_6.doStartTag();
              if (_jspx_eval_logic_notEmpty_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_5 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_5.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_6);
                  _jspx_th_bean_define_5.setId("repayDate");
                  _jspx_th_bean_define_5.setName("row");
                  _jspx_th_bean_define_5.setProperty("repayDate");
                  _jspx_th_bean_define_5.setType("java.util.Date");
                  int _jspx_eval_bean_define_5 = _jspx_th_bean_define_5.doStartTag();
                  if (_jspx_th_bean_define_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_5);
                  java.util.Date repayDate = null;
                  repayDate = (java.util.Date) _jspx_page_context.findAttribute("repayDate");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  html:hidden
                  org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_value_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
                  _jspx_th_html_hidden_0.setPageContext(_jspx_page_context);
                  _jspx_th_html_hidden_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_6);
                  _jspx_th_html_hidden_0.setName("Cpma0101Form");
                  _jspx_th_html_hidden_0.setProperty("date(planRepayDate)");
                  _jspx_th_html_hidden_0.setValue(DateUtil.date2Str(repayDate));
                  int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
                  if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_html_hidden_value_property_name_nobody.reuse(_jspx_th_html_hidden_0);
                  out.write("\t\r\n");
                  out.write("\t\t\t\t\t");
                  out.print(DateUtil.date2ROCStr(repayDate));
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
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_3 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_3.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_4);
              _jspx_th_logic_empty_3.setName("row");
              _jspx_th_logic_empty_3.setProperty("repayDate");
              int _jspx_eval_logic_empty_3 = _jspx_th_logic_empty_3.doStartTag();
              if (_jspx_eval_logic_empty_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  out.print("000/00/00");
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
          _jspx_th_display_column_5.setTitle("利息起算日期");
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
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_7 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_7.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_5);
              _jspx_th_logic_notEmpty_7.setName("row");
              _jspx_th_logic_notEmpty_7.setProperty("debt.interestDate");
              int _jspx_eval_logic_notEmpty_7 = _jspx_th_logic_notEmpty_7.doStartTag();
              if (_jspx_eval_logic_notEmpty_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\t\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_6 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_6.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_7);
                  _jspx_th_bean_define_6.setId("interestDate");
                  _jspx_th_bean_define_6.setName("row");
                  _jspx_th_bean_define_6.setProperty("debt.interestDate");
                  _jspx_th_bean_define_6.setType("java.util.Date");
                  int _jspx_eval_bean_define_6 = _jspx_th_bean_define_6.doStartTag();
                  if (_jspx_th_bean_define_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_6);
                  java.util.Date interestDate = null;
                  interestDate = (java.util.Date) _jspx_page_context.findAttribute("interestDate");
                  out.write("\t\r\n");
                  out.write("\t\t\t\t\t");
request.setAttribute("interestDate",interestDate);
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
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_4 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_4.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_5);
              _jspx_th_logic_empty_4.setName("row");
              _jspx_th_logic_empty_4.setProperty("debt.interestDate");
              int _jspx_eval_logic_empty_4 = _jspx_th_logic_empty_4.doStartTag();
              if (_jspx_eval_logic_empty_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  logic:notEmpty
                  org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_8 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
                  _jspx_th_logic_notEmpty_8.setPageContext(_jspx_page_context);
                  _jspx_th_logic_notEmpty_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_empty_4);
                  _jspx_th_logic_notEmpty_8.setName("row");
                  _jspx_th_logic_notEmpty_8.setProperty("debt.issue.issueDate");
                  int _jspx_eval_logic_notEmpty_8 = _jspx_th_logic_notEmpty_8.doStartTag();
                  if (_jspx_eval_logic_notEmpty_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n");
                      out.write("\t\t\t\t\t\t");
                      //  bean:define
                      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_7 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                      _jspx_th_bean_define_7.setPageContext(_jspx_page_context);
                      _jspx_th_bean_define_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_8);
                      _jspx_th_bean_define_7.setId("interestDate");
                      _jspx_th_bean_define_7.setName("row");
                      _jspx_th_bean_define_7.setProperty("debt.issue.issueDate");
                      _jspx_th_bean_define_7.setType("java.util.Date");
                      int _jspx_eval_bean_define_7 = _jspx_th_bean_define_7.doStartTag();
                      if (_jspx_th_bean_define_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_7);
                      java.util.Date interestDate = null;
                      interestDate = (java.util.Date) _jspx_page_context.findAttribute("interestDate");
                      out.write("\t\r\n");
                      out.write("\t\t\t\t\t\t");
request.setAttribute("interestDate",interestDate);
                      out.write("\r\n");
                      out.write("\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_logic_notEmpty_8.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_logic_notEmpty_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_8);
                  out.write("\t\r\n");
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

					java.util.Date startDate = (java.util.Date)(request.getAttribute("interestDate"));
					request.setAttribute("startDate",startDate);
				
              out.write("\r\n");
              out.write("\t\t\t\t");
              out.print(DateUtil.date2ROCStr(startDate));
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  html:hidden
              org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_1 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_value_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
              _jspx_th_html_hidden_1.setPageContext(_jspx_page_context);
              _jspx_th_html_hidden_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_5);
              _jspx_th_html_hidden_1.setName("Cpma0101Form");
              _jspx_th_html_hidden_1.setProperty("interestDate");
              _jspx_th_html_hidden_1.setValue(DateUtil.date2Str((java.util.Date)(request.getAttribute("startDate")),"yyyy/MM/dd"));
              int _jspx_eval_html_hidden_1 = _jspx_th_html_hidden_1.doStartTag();
              if (_jspx_th_html_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_html_hidden_value_property_name_nobody.reuse(_jspx_th_html_hidden_1);
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
          _jspx_th_display_column_6.setTitle("還款日期");
          int _jspx_eval_display_column_6 = _jspx_th_display_column_6.doStartTag();
          if (_jspx_eval_display_column_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_6.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t");
              if (_jspx_meth_html_hidden_2(_jspx_th_display_column_6, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_9 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_9.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_6);
              _jspx_th_logic_notEmpty_9.setName("Cpma0101Form");
              _jspx_th_logic_notEmpty_9.setProperty("qryrepayDate");
              int _jspx_eval_logic_notEmpty_9 = _jspx_th_logic_notEmpty_9.doStartTag();
              if (_jspx_eval_logic_notEmpty_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_8 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_8.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_9);
                  _jspx_th_bean_define_8.setId("qryrepayDate");
                  _jspx_th_bean_define_8.setName("Cpma0101Form");
                  _jspx_th_bean_define_8.setProperty("qryrepayDate");
                  _jspx_th_bean_define_8.setType("java.util.Date");
                  int _jspx_eval_bean_define_8 = _jspx_th_bean_define_8.doStartTag();
                  if (_jspx_th_bean_define_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_8);
                  java.util.Date qryrepayDate = null;
                  qryrepayDate = (java.util.Date) _jspx_page_context.findAttribute("qryrepayDate");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  out.print(DateUtil.date2ROCStr(qryrepayDate));
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
request.setAttribute("qryrepayDate",qryrepayDate);
                  out.write("\r\n");
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
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_5 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_5.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_6);
              _jspx_th_logic_empty_5.setName("Cpma0101Form");
              _jspx_th_logic_empty_5.setProperty("qryrepayDate");
              int _jspx_eval_logic_empty_5 = _jspx_th_logic_empty_5.doStartTag();
              if (_jspx_eval_logic_empty_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  out.print("000/00/00");
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
          out.write("\t\t\t\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_7 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_7.setPageContext(_jspx_page_context);
          _jspx_th_display_column_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_7.setTitle("天期");
          int _jspx_eval_display_column_7 = _jspx_th_display_column_7.doStartTag();
          if (_jspx_eval_display_column_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_7.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  bean:define
              org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_9 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
              _jspx_th_bean_define_9.setPageContext(_jspx_page_context);
              _jspx_th_bean_define_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_7);
              _jspx_th_bean_define_9.setId("issueDate");
              _jspx_th_bean_define_9.setName("row");
              _jspx_th_bean_define_9.setProperty("debt.issue.issueDate");
              _jspx_th_bean_define_9.setType("java.util.Date");
              int _jspx_eval_bean_define_9 = _jspx_th_bean_define_9.doStartTag();
              if (_jspx_th_bean_define_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_9);
              java.util.Date issueDate = null;
              issueDate = (java.util.Date) _jspx_page_context.findAttribute("issueDate");
              out.write("\t\r\n");
              out.write("\t\t\t\t");

					java.util.Date startDate = (java.util.Date)(request.getAttribute("interestDate"));
					java.util.Date endDate = (java.util.Date)(request.getAttribute("qryrepayDate"));
					Integer days = new Integer(0);
					if(null == startDate)
					{
						startDate = issueDate;
					}
					if(null == endDate)
					{
						endDate = issueDate;
					}
					days = gov.dnt.tame.util.DateUtil.getDays(startDate,endDate);
				
              out.write("\r\n");
              out.write("\t\t\t\t");
              out.print(days);
              out.write("\r\n");
              out.write("\t\t\t<input type=\"hidden\" name=\"date(endDate)\" value=\"");
              out.print(DateUtil.date2Str(endDate));
              out.write("\" />\t\r\n");
              out.write("\t\t\t<input type=\"hidden\" name=\"date(startDate)\" value=\"");
              out.print(DateUtil.date2Str(startDate));
              out.write("\" />\t\t\r\n");
              out.write("\t\t\t<input type=\"hidden\" name=\"days\" value=\"");
              out.print(days);
              out.write("\" />\t\r\n");
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
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_8 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_8.setPageContext(_jspx_page_context);
          _jspx_th_display_column_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_8.setTitle("利率");
          int _jspx_eval_display_column_8 = _jspx_th_display_column_8.doStartTag();
          if (_jspx_eval_display_column_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_8.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  bean:define
              org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_10 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
              _jspx_th_bean_define_10.setPageContext(_jspx_page_context);
              _jspx_th_bean_define_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_8);
              _jspx_th_bean_define_10.setId("Debtid");
              _jspx_th_bean_define_10.setName("row");
              _jspx_th_bean_define_10.setProperty("debt.id");
              _jspx_th_bean_define_10.setType("java.lang.Integer");
              int _jspx_eval_bean_define_10 = _jspx_th_bean_define_10.doStartTag();
              if (_jspx_th_bean_define_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_10);
              java.lang.Integer Debtid = null;
              Debtid = (java.lang.Integer) _jspx_page_context.findAttribute("Debtid");
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  bean:define
              org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_11 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
              _jspx_th_bean_define_11.setPageContext(_jspx_page_context);
              _jspx_th_bean_define_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_8);
              _jspx_th_bean_define_11.setId("issueDate");
              _jspx_th_bean_define_11.setName("row");
              _jspx_th_bean_define_11.setProperty("debt.issue.issueDate");
              _jspx_th_bean_define_11.setType("java.util.Date");
              int _jspx_eval_bean_define_11 = _jspx_th_bean_define_11.doStartTag();
              if (_jspx_th_bean_define_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_11);
              java.util.Date issueDate = null;
              issueDate = (java.util.Date) _jspx_page_context.findAttribute("issueDate");
              out.write("\t\r\n");
              out.write("\t\t\t\t");

					java.util.Date startDate = (java.util.Date)(request.getAttribute("interestDate"));
					tw.gov.nta.debt.common.RateManager myRate = new tw.gov.nta.debt.common.RateManager();
					if(null == startDate)
					{
						startDate = issueDate;
					}
					BigDecimal	debtRate = myRate.getEffectiveRate(Debtid.intValue(),startDate);
					request.setAttribute("debtRate",debtRate);
				
              out.write("\r\n");
              out.write("\t\t\t\t");
              out.print(debtRate.setScale(3,5));
              out.write("\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_8.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_8);
          out.write("\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_9 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_9.setPageContext(_jspx_page_context);
          _jspx_th_display_column_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_9.setTitle("累計償本金額");
          int _jspx_eval_display_column_9 = _jspx_th_display_column_9.doStartTag();
          if (_jspx_eval_display_column_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_9.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_9.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  bean:define
              org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_12 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
              _jspx_th_bean_define_12.setPageContext(_jspx_page_context);
              _jspx_th_bean_define_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_9);
              _jspx_th_bean_define_12.setId("id");
              _jspx_th_bean_define_12.setName("row");
              _jspx_th_bean_define_12.setProperty("debt.id");
              _jspx_th_bean_define_12.setType("java.lang.Integer");
              int _jspx_eval_bean_define_12 = _jspx_th_bean_define_12.doStartTag();
              if (_jspx_th_bean_define_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_12);
              java.lang.Integer id = null;
              id = (java.lang.Integer) _jspx_page_context.findAttribute("id");
              out.write("\t\r\n");
              out.write("\t\t\t\t ");

					 	tw.gov.nta.debt.common.PayManager amount = new tw.gov.nta.debt.common.PayManager();
				 		BigDecimal capitalAmountPay = new BigDecimal(0);
				 		capitalAmountPay = amount.getCapitalByDebt(id.intValue()).setScale(0,5);
				 		if (null != capitalAmountPay )
				 		{
				 			request.setAttribute("capitalAmountPay",capitalAmountPay);
				 		}
				 		else
				 		{
				 			request.setAttribute("capitalAmountPay",new BigDecimal(0));
				 		}	
				 
              out.write("\r\n");
              out.write("\t\t\t\t<p align=\"right\">");
              out.print(new gov.dnt.tame.common.SupportForm().getAmountDecimal((java.math.BigDecimal)request.getAttribute("capitalAmountPay")));
              out.write("</p>\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_9.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_9);
          out.write("\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_10 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_10.setPageContext(_jspx_page_context);
          _jspx_th_display_column_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_10.setTitle("實際金額");
          int _jspx_eval_display_column_10 = _jspx_th_display_column_10.doStartTag();
          if (_jspx_eval_display_column_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_10.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_10.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\r\n");
              out.write("\t\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_10 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_10.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_10);
              _jspx_th_logic_notEmpty_10.setName("row");
              _jspx_th_logic_notEmpty_10.setProperty("capitalAmount");
              int _jspx_eval_logic_notEmpty_10 = _jspx_th_logic_notEmpty_10.doStartTag();
              if (_jspx_eval_logic_notEmpty_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_13 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_13.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_10);
                  _jspx_th_bean_define_13.setId("capitalAmount");
                  _jspx_th_bean_define_13.setName("row");
                  _jspx_th_bean_define_13.setProperty("capitalAmount");
                  _jspx_th_bean_define_13.setType("java.math.BigDecimal");
                  int _jspx_eval_bean_define_13 = _jspx_th_bean_define_13.doStartTag();
                  if (_jspx_th_bean_define_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_13);
                  java.math.BigDecimal capitalAmount = null;
                  capitalAmount = (java.math.BigDecimal) _jspx_page_context.findAttribute("capitalAmount");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_14 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_14.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_10);
                  _jspx_th_bean_define_14.setId("id");
                  _jspx_th_bean_define_14.setName("row");
                  _jspx_th_bean_define_14.setProperty("id");
                  _jspx_th_bean_define_14.setType("java.lang.Integer");
                  int _jspx_eval_bean_define_14 = _jspx_th_bean_define_14.doStartTag();
                  if (_jspx_th_bean_define_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_14);
                  java.lang.Integer id = null;
                  id = (java.lang.Integer) _jspx_page_context.findAttribute("id");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
 
					String thisPay = "";
					if(request.getAttribute("thisPay") != null)
						thisPay = request.getAttribute("thisPay").toString();
					if(thisPay.equals("") || !thisPay.equals("T")){
						DebtPlanDet debtPlanDet = (DebtPlanDet)row;
						tw.gov.nta.debt.common.PayManager payManager = new tw.gov.nta.debt.common.PayManager();
						request.setAttribute("capitalAmountDebtPlan",capitalAmount);
						//BigDecimal value1 = (java.math.BigDecimal)(request.getAttribute("capitalAmountDebtPlan"));
						if(capitalAmount.compareTo(new BigDecimal(0))==0)
							request.setAttribute("capitalAmountGuess",new BigDecimal(0));
						else{
							BigDecimal value1 = capitalAmount;
							BigDecimal value2 = payManager.getCapitalByDebt(debtPlanDet.getDebt().getId().intValue());
							request.setAttribute("capitalAmountGuess",value1.subtract(value2).setScale(0,5));
						}
					}
					else{
						request.setAttribute("capitalAmountGuess",capitalAmount);
					}
					
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_10.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_10);
              out.write("\r\n");
              out.write("\t\t\t\t");
              //  logic:empty
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_6 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_6.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_10);
              _jspx_th_logic_empty_6.setName("row");
              _jspx_th_logic_empty_6.setProperty("capitalAmount");
              int _jspx_eval_logic_empty_6 = _jspx_th_logic_empty_6.doStartTag();
              if (_jspx_eval_logic_empty_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
request.setAttribute("capitalAmountGuess",new BigDecimal(0));
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
              //  html:text
              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_value_style_size_readonly_property_onblur_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
              _jspx_th_html_text_0.setPageContext(_jspx_page_context);
              _jspx_th_html_text_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_10);
              _jspx_th_html_text_0.setName("Cpma0101Form");
              _jspx_th_html_text_0.setProperty("capitalAmountPay");
              _jspx_th_html_text_0.setStyle("text-align:right;border-top:0 px;border-bottom:0 px;border-left:0 px;border-right:0 px");
              _jspx_th_html_text_0.setSize("10");
              _jspx_th_html_text_0.setMaxlength("20");
              _jspx_th_html_text_0.setValue(((java.math.BigDecimal)(request.getAttribute("capitalAmountGuess"))).toString());
              _jspx_th_html_text_0.setReadonly(false);
              _jspx_th_html_text_0.setOnblur("changeInterestAmount(this.form)");
              int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
              if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_html_text_value_style_size_readonly_property_onblur_name_maxlength_nobody.reuse(_jspx_th_html_text_0);
              out.write("\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_10.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_10);
          out.write("\r\n");
          out.write("\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_11 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_11.setPageContext(_jspx_page_context);
          _jspx_th_display_column_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_11.setTitle("實際利息");
          int _jspx_eval_display_column_11 = _jspx_th_display_column_11.doStartTag();
          if (_jspx_eval_display_column_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_11.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_11.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_11 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_11.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_11);
              _jspx_th_logic_notEmpty_11.setName("row");
              _jspx_th_logic_notEmpty_11.setProperty("debt");
              int _jspx_eval_logic_notEmpty_11 = _jspx_th_logic_notEmpty_11.doStartTag();
              if (_jspx_eval_logic_notEmpty_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_15 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_15.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_11);
                  _jspx_th_bean_define_15.setId("Debtid");
                  _jspx_th_bean_define_15.setName("row");
                  _jspx_th_bean_define_15.setProperty("debt.id");
                  _jspx_th_bean_define_15.setType("java.lang.Integer");
                  int _jspx_eval_bean_define_15 = _jspx_th_bean_define_15.doStartTag();
                  if (_jspx_th_bean_define_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_15);
                  java.lang.Integer Debtid = null;
                  Debtid = (java.lang.Integer) _jspx_page_context.findAttribute("Debtid");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_16 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_16.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_11);
                  _jspx_th_bean_define_16.setId("qryrepayDate");
                  _jspx_th_bean_define_16.setName("Cpma0101Form");
                  _jspx_th_bean_define_16.setProperty("qryrepayDate");
                  _jspx_th_bean_define_16.setType("java.util.Date");
                  int _jspx_eval_bean_define_16 = _jspx_th_bean_define_16.doStartTag();
                  if (_jspx_th_bean_define_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_16);
                  java.util.Date qryrepayDate = null;
                  qryrepayDate = (java.util.Date) _jspx_page_context.findAttribute("qryrepayDate");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_17 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_17.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_11);
                  _jspx_th_bean_define_17.setId("issueDate");
                  _jspx_th_bean_define_17.setName("row");
                  _jspx_th_bean_define_17.setProperty("debt.issue.issueDate");
                  _jspx_th_bean_define_17.setType("java.util.Date");
                  int _jspx_eval_bean_define_17 = _jspx_th_bean_define_17.doStartTag();
                  if (_jspx_th_bean_define_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_17);
                  java.util.Date issueDate = null;
                  issueDate = (java.util.Date) _jspx_page_context.findAttribute("issueDate");
                  out.write("\t\r\n");
                  out.write("\t\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_18 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_18.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_11);
                  _jspx_th_bean_define_18.setId("issueAmount");
                  _jspx_th_bean_define_18.setName("row");
                  _jspx_th_bean_define_18.setProperty("debt.issueAmount");
                  _jspx_th_bean_define_18.setType("java.math.BigDecimal");
                  int _jspx_eval_bean_define_18 = _jspx_th_bean_define_18.doStartTag();
                  if (_jspx_th_bean_define_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_18);
                  java.math.BigDecimal issueAmount = null;
                  issueAmount = (java.math.BigDecimal) _jspx_page_context.findAttribute("issueAmount");
                  out.write("\t\t\r\n");
                  out.write("\t\t\t\t\t\t");
                  //  bean:define
                  org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_19 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
                  _jspx_th_bean_define_19.setPageContext(_jspx_page_context);
                  _jspx_th_bean_define_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_11);
                  _jspx_th_bean_define_19.setId("capitalAmount");
                  _jspx_th_bean_define_19.setName("row");
                  _jspx_th_bean_define_19.setProperty("capitalAmount");
                  _jspx_th_bean_define_19.setType("java.math.BigDecimal");
                  int _jspx_eval_bean_define_19 = _jspx_th_bean_define_19.doStartTag();
                  if (_jspx_th_bean_define_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_19);
                  java.math.BigDecimal capitalAmount = null;
                  capitalAmount = (java.math.BigDecimal) _jspx_page_context.findAttribute("capitalAmount");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");

							String thisPay = "";
							if(request.getAttribute("thisPay") != null)
								thisPay = request.getAttribute("thisPay").toString();
							tw.gov.nta.debt.common.InterestCounter myCounter = new tw.gov.nta.debt.common.InterestCounter();
							tw.gov.nta.debt.common.PayManager myPayManager = new tw.gov.nta.debt.common.PayManager();
							tw.gov.nta.debt.common.RateManager myRate = new tw.gov.nta.debt.common.RateManager();
							BigDecimal capitalAmountPay = (java.math.BigDecimal)request.getAttribute("capitalAmountPay");
							BigDecimal countAmount = new BigDecimal(0);
							BigDecimal interestAmount = new BigDecimal(0);
							java.util.Date startDate = (java.util.Date)(request.getAttribute("interestDate"));
							if(thisPay.equals("") || !thisPay.equals("T")){
								if(null != issueAmount)
									countAmount = issueAmount.subtract(capitalAmountPay);
							}
							else 
								countAmount = capitalAmount;
							if(null == startDate)
								startDate = issueDate;
							try{
								interestAmount = myCounter.countInterest(startDate
										,qryrepayDate
										,myRate.getEffectiveRate(Debtid.intValue())
										,countAmount.doubleValue(),0) ;
							}
							catch(Exception e){}
							if(null != interestAmount)	{	
								request.setAttribute("interestAmount",interestAmount.setScale(0,BigDecimal.ROUND_HALF_DOWN));
							}
							else{
								request.setAttribute("interestAmount",new BigDecimal(0));
							}	
						
                  out.write("\t\r\n");
                  out.write("\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_11.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_11);
              out.write("\r\n");
              out.write("\t\t\t\t\t");
              //  logic:empty
              org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_7 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
              _jspx_th_logic_empty_7.setPageContext(_jspx_page_context);
              _jspx_th_logic_empty_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_11);
              _jspx_th_logic_empty_7.setName("row");
              _jspx_th_logic_empty_7.setProperty("debt");
              int _jspx_eval_logic_empty_7 = _jspx_th_logic_empty_7.doStartTag();
              if (_jspx_eval_logic_empty_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t");
request.setAttribute("interestAmount",new BigDecimal(0));
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_logic_empty_7.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_empty_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_7);
              out.write("\t\t\t\r\n");
              out.write("\t\t\t");
              //  html:text
              org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_value_style_size_readonly_property_onblur_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
              _jspx_th_html_text_1.setPageContext(_jspx_page_context);
              _jspx_th_html_text_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_11);
              _jspx_th_html_text_1.setName("Cpma0101Form");
              _jspx_th_html_text_1.setProperty("interestAmountPay");
              _jspx_th_html_text_1.setStyle("text-align:right;border-top:0 px;border-bottom:0 px;border-left:0 px;border-right:0 px");
              _jspx_th_html_text_1.setSize("10");
              _jspx_th_html_text_1.setMaxlength("20");
              _jspx_th_html_text_1.setOnblur("changeValue()");
              _jspx_th_html_text_1.setValue(((java.math.BigDecimal)(request.getAttribute("interestAmount"))).toString());
              _jspx_th_html_text_1.setReadonly(false);
              int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
              if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_html_text_value_style_size_readonly_property_onblur_name_maxlength_nobody.reuse(_jspx_th_html_text_1);
              out.write("\r\n");
              out.write("\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_11.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_11);
          out.write("\r\n");
          out.write("\t\t\t");
          if (_jspx_meth_display_column_12(_jspx_th_display_table_0, _jspx_page_context))
            return;
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

  private boolean _jspx_meth_logic_empty_2(javax.servlet.jsp.tagext.JspTag _jspx_th_display_column_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:empty
    org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_2 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
    _jspx_th_logic_empty_2.setPageContext(_jspx_page_context);
    _jspx_th_logic_empty_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_3);
    _jspx_th_logic_empty_2.setName("row");
    _jspx_th_logic_empty_2.setProperty("debt.issueAmount");
    int _jspx_eval_logic_empty_2 = _jspx_th_logic_empty_2.doStartTag();
    if (_jspx_eval_logic_empty_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<P align=right>0</P>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_logic_empty_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_empty_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_2);
    return false;
  }

  private boolean _jspx_meth_html_hidden_2(javax.servlet.jsp.tagext.JspTag _jspx_th_display_column_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_2 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_2.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_6);
    _jspx_th_html_hidden_2.setName("Cpma0101Form");
    _jspx_th_html_hidden_2.setProperty("date(qryrepayDate)");
    int _jspx_eval_html_hidden_2 = _jspx_th_html_hidden_2.doStartTag();
    if (_jspx_th_html_hidden_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_2);
    return false;
  }

  private boolean _jspx_meth_display_column_12(javax.servlet.jsp.tagext.JspTag _jspx_th_display_table_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_column_12 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_column_12.setPageContext(_jspx_page_context);
    _jspx_th_display_column_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
    _jspx_th_display_column_12.setTitle("實際本息合計");
    int _jspx_eval_display_column_12 = _jspx_th_display_column_12.doStartTag();
    if (_jspx_eval_display_column_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_display_column_12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_display_column_12.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_display_column_12.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_html_text_2(_jspx_th_display_column_12, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_display_column_12.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_display_column_12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_display_column_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_12);
    return false;
  }

  private boolean _jspx_meth_html_text_2(javax.servlet.jsp.tagext.JspTag _jspx_th_display_column_12, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_style_readonly_property_name_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_2.setPageContext(_jspx_page_context);
    _jspx_th_html_text_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_12);
    _jspx_th_html_text_2.setName("Cpma0101Form");
    _jspx_th_html_text_2.setProperty("bigDecimal(totalAmount)");
    _jspx_th_html_text_2.setStyle("text-align:right;border-top:0 px;border-bottom:0 px;border-left:0 px;border-right:0 px");
    _jspx_th_html_text_2.setReadonly(false);
    int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
    if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_style_readonly_property_name_nobody.reuse(_jspx_th_html_text_2);
    return false;
  }
}
