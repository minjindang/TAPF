package org.apache.jsp.CPM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.dnt.tame.util.DateUtil;

public final class CPMA0101MForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/displaytag-12.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notEmpty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_empty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_hidden_property_name_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_notEmpty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_type_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_empty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_hidden_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_bean_write_property_name_nobody.release();
    _jspx_tagPool_logic_notEmpty_property_name.release();
    _jspx_tagPool_bean_define_type_property_name_id_nobody.release();
    _jspx_tagPool_logic_empty_property_name.release();
    _jspx_tagPool_html_hidden_property_name_nobody.release();
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

      out.write("<!-- CPMA0101MForm.jsp\r\n");
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
      out.write("<table class='table_1' width='100%'>\r\n");
      out.write("\t<tr>\t\r\n");
      out.write("\t\t<td class='table_item'>名稱</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_bean_write_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>借款期間</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t\t\t");
      //  logic:notEmpty
      org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_0 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
      _jspx_th_logic_notEmpty_0.setPageContext(_jspx_page_context);
      _jspx_th_logic_notEmpty_0.setParent(null);
      _jspx_th_logic_notEmpty_0.setName("Cpma0101Form");
      _jspx_th_logic_notEmpty_0.setProperty("issueDate");
      int _jspx_eval_logic_notEmpty_0 = _jspx_th_logic_notEmpty_0.doStartTag();
      if (_jspx_eval_logic_notEmpty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          //  bean:define
          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
          _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
          _jspx_th_bean_define_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
          _jspx_th_bean_define_0.setId("issueDate");
          _jspx_th_bean_define_0.setName("Cpma0101Form");
          _jspx_th_bean_define_0.setProperty("issueDate");
          _jspx_th_bean_define_0.setType("java.util.Date");
          int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
          if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
          java.util.Date issueDate = null;
          issueDate = (java.util.Date) _jspx_page_context.findAttribute("issueDate");
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          out.print(DateUtil.date2ROCStr(issueDate));
          out.write(" ~\r\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_logic_notEmpty_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_logic_notEmpty_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t");
      //  logic:empty
      org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_0 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
      _jspx_th_logic_empty_0.setPageContext(_jspx_page_context);
      _jspx_th_logic_empty_0.setParent(null);
      _jspx_th_logic_empty_0.setName("Cpma0101Form");
      _jspx_th_logic_empty_0.setProperty("issueDate");
      int _jspx_eval_logic_empty_0 = _jspx_th_logic_empty_0.doStartTag();
      if (_jspx_eval_logic_empty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          out.print("0000000");
          out.write(" ~\r\n");
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
      out.write("\t\t\t\t\t");
      //  logic:notEmpty
      org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_1 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
      _jspx_th_logic_notEmpty_1.setPageContext(_jspx_page_context);
      _jspx_th_logic_notEmpty_1.setParent(null);
      _jspx_th_logic_notEmpty_1.setName("Cpma0101Form");
      _jspx_th_logic_notEmpty_1.setProperty("dueDate");
      int _jspx_eval_logic_notEmpty_1 = _jspx_th_logic_notEmpty_1.doStartTag();
      if (_jspx_eval_logic_notEmpty_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          //  bean:define
          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
          _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
          _jspx_th_bean_define_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_1);
          _jspx_th_bean_define_1.setId("dueDate");
          _jspx_th_bean_define_1.setName("Cpma0101Form");
          _jspx_th_bean_define_1.setProperty("dueDate");
          _jspx_th_bean_define_1.setType("java.util.Date");
          int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
          if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
          java.util.Date dueDate = null;
          dueDate = (java.util.Date) _jspx_page_context.findAttribute("dueDate");
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          out.print(DateUtil.date2ROCStr(dueDate));
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
      org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_1 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
      _jspx_th_logic_empty_1.setPageContext(_jspx_page_context);
      _jspx_th_logic_empty_1.setParent(null);
      _jspx_th_logic_empty_1.setName("Cpma0101Form");
      _jspx_th_logic_empty_1.setProperty("dueDate");
      int _jspx_eval_logic_empty_1 = _jspx_th_logic_empty_1.doStartTag();
      if (_jspx_eval_logic_empty_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          out.print("0000000");
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
      out.write("\t\t</td>\t\r\n");
      out.write("\t\t<td class='table_item'>借款期限</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t\t");
      out.print(request.getAttribute("DayCount").toString());
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\t\r\n");
      out.write("\t\t<td class='table_item'>計劃借款金額</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t<p align=\"right\">");
      if (_jspx_meth_bean_write_1(_jspx_page_context))
        return;
      out.write("</p>\r\n");
      out.write("\t\t</td>\t\r\n");
      out.write("\t\t<td class='table_item'>實際借款金額</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t<p align=\"right\">");
      if (_jspx_meth_bean_write_2(_jspx_page_context))
        return;
      out.write("</p>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>已償金額</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t<p align=\"right\">");
      if (_jspx_meth_bean_write_3(_jspx_page_context))
        return;
      out.write("</p>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class='table_item'>未償金額</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_2 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_2.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_2.setParent(null);
      _jspx_th_bean_define_2.setId("issueAmount");
      _jspx_th_bean_define_2.setName("Cpma0101Form");
      _jspx_th_bean_define_2.setProperty("bigDecimal(issueAmount)");
      _jspx_th_bean_define_2.setType("java.math.BigDecimal");
      int _jspx_eval_bean_define_2 = _jspx_th_bean_define_2.doStartTag();
      if (_jspx_th_bean_define_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_2);
      java.math.BigDecimal issueAmount = null;
      issueAmount = (java.math.BigDecimal) _jspx_page_context.findAttribute("issueAmount");
      out.write("\r\n");
      out.write("\t\t\t");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_3 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_3.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_3.setParent(null);
      _jspx_th_bean_define_3.setId("capitalAmount");
      _jspx_th_bean_define_3.setName("Cpma0101Form");
      _jspx_th_bean_define_3.setProperty("bigDecimal(capitalAmount)");
      _jspx_th_bean_define_3.setType("java.math.BigDecimal");
      int _jspx_eval_bean_define_3 = _jspx_th_bean_define_3.doStartTag();
      if (_jspx_th_bean_define_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_3);
      java.math.BigDecimal capitalAmount = null;
      capitalAmount = (java.math.BigDecimal) _jspx_page_context.findAttribute("capitalAmount");
      out.write("\r\n");
      out.write("\t\t\t<p align=\"right\">");
      out.print(new gov.dnt.tame.common.SupportForm().getAmountDecimal(issueAmount.subtract(capitalAmount)));
      out.write("</p>\t\r\n");
      out.write("\t\t</td>\r\n");
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

  private boolean _jspx_meth_bean_write_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_0.setParent(null);
    _jspx_th_bean_write_0.setName("Cpma0101Form");
    _jspx_th_bean_write_0.setProperty("debtName");
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_0);
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
    _jspx_th_bean_write_1.setName("Cpma0101Form");
    _jspx_th_bean_write_1.setProperty("amountDecimal(expectAmount)");
    int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
    if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_1);
    return false;
  }

  private boolean _jspx_meth_bean_write_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_2 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_2.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_2.setParent(null);
    _jspx_th_bean_write_2.setName("Cpma0101Form");
    _jspx_th_bean_write_2.setProperty("amountDecimal(issueAmount)");
    int _jspx_eval_bean_write_2 = _jspx_th_bean_write_2.doStartTag();
    if (_jspx_th_bean_write_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_2);
    return false;
  }

  private boolean _jspx_meth_bean_write_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_3 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_3.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_3.setParent(null);
    _jspx_th_bean_write_3.setName("Cpma0101Form");
    _jspx_th_bean_write_3.setProperty("amountDecimal(capitalAmount)");
    int _jspx_eval_bean_write_3 = _jspx_th_bean_write_3.doStartTag();
    if (_jspx_th_bean_write_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_3);
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
    _jspx_th_html_hidden_0.setName("Cpma0101Form");
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
    _jspx_th_html_hidden_1.setName("Cpma0101Form");
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
    _jspx_th_html_hidden_2.setName("Cpma0101Form");
    _jspx_th_html_hidden_2.setProperty("qrydebtName");
    int _jspx_eval_html_hidden_2 = _jspx_th_html_hidden_2.doStartTag();
    if (_jspx_th_html_hidden_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_2);
    return false;
  }
}
