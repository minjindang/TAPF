package org.apache.jsp.AIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AIMA0103MForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_hidden_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_format_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_empty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notEmpty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_property_onblur_name_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_hidden_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_format_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_empty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_notEmpty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_type_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_property_onblur_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_hidden_property_name_nobody.release();
    _jspx_tagPool_bean_write_property_name_nobody.release();
    _jspx_tagPool_bean_write_property_name_format_nobody.release();
    _jspx_tagPool_logic_empty_property_name.release();
    _jspx_tagPool_logic_notEmpty_property_name.release();
    _jspx_tagPool_bean_define_type_property_name_id_nobody.release();
    _jspx_tagPool_html_text_property_onblur_name_nobody.release();
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write(' ');
      if (_jspx_meth_html_hidden_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write(' ');
      if (_jspx_meth_html_hidden_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<table class='table_1' width='100%'>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class='table_item'>公債代號：</td>\r\n");
      out.write("\t\t\t<td class='table_td'>");
      if (_jspx_meth_bean_write_0(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t\t<td class='table_item'>發行日期：</td>\r\n");
      out.write("\t\t\t<td class='table_td'>");
      if (_jspx_meth_bean_write_1(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("\t\t\t<td class='table_item'>發行金額：</td>\r\n");
      out.write("\t\t\t<td class='table_td'>");
      if (_jspx_meth_bean_write_2(_jspx_page_context))
        return;
      out.write("元</td>\r\n");
      out.write("\t\t\t<td class='table_item'>公債名稱：</td>\r\n");
      out.write("\t\t\t<td class='table_td'>");
      if (_jspx_meth_bean_write_3(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("\t\t\t<td class='table_item'>面額：</td>\r\n");
      out.write("\t\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t\t");
      //  logic:empty
      org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_0 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
      _jspx_th_logic_empty_0.setPageContext(_jspx_page_context);
      _jspx_th_logic_empty_0.setParent(null);
      _jspx_th_logic_empty_0.setName("Aima0103MForm");
      _jspx_th_logic_empty_0.setProperty("ticketAmount");
      int _jspx_eval_logic_empty_0 = _jspx_th_logic_empty_0.doStartTag();
      if (_jspx_eval_logic_empty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          out.print(gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY"),"ticketAmount","","","countTotalAmount(this.form);",10,false));
          out.write("元\r\n");
          out.write("\t\t\t\t");
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
      //  logic:notEmpty
      org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_0 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
      _jspx_th_logic_notEmpty_0.setPageContext(_jspx_page_context);
      _jspx_th_logic_notEmpty_0.setParent(null);
      _jspx_th_logic_notEmpty_0.setName("Aima0103MForm");
      _jspx_th_logic_notEmpty_0.setProperty("ticketAmount");
      int _jspx_eval_logic_notEmpty_0 = _jspx_th_logic_notEmpty_0.doStartTag();
      if (_jspx_eval_logic_notEmpty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          //  bean:define
          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
          _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
          _jspx_th_bean_define_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
          _jspx_th_bean_define_0.setId("ticketAmount");
          _jspx_th_bean_define_0.setName("Aima0103MForm");
          _jspx_th_bean_define_0.setProperty("ticketAmount");
          _jspx_th_bean_define_0.setType("java.lang.String");
          int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
          if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
          java.lang.String ticketAmount = null;
          ticketAmount = (java.lang.String) _jspx_page_context.findAttribute("ticketAmount");
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          out.print(gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY"),"ticketAmount",new java.math.BigDecimal(ticketAmount).setScale(0).toString(),"","countTotalAmount(this.form);",10,false));
          out.write("元\r\n");
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
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td class='table_item'>張數：</td>\r\n");
      out.write("\t\t\t<td class='table_td'>");
      if (_jspx_meth_html_text_0(_jspx_page_context))
        return;
      out.write("張</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("\t\t\t<td class='table_item'>金額：</td>\r\n");
      out.write("\t\t\t<td colspan=\"3\" class='table_td' id=\"totalAmount\">");
      if (_jspx_meth_bean_write_4(_jspx_page_context))
        return;
      out.write("元</td>\r\n");
      out.write("        </tr>\r\n");
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

  private boolean _jspx_meth_html_hidden_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_0.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_0.setParent(null);
    _jspx_th_html_hidden_0.setName("Aima0103MForm");
    _jspx_th_html_hidden_0.setProperty("issueMainId");
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
    _jspx_th_html_hidden_1.setName("Aima0103MForm");
    _jspx_th_html_hidden_1.setProperty("issueTicketDetId");
    int _jspx_eval_html_hidden_1 = _jspx_th_html_hidden_1.doStartTag();
    if (_jspx_th_html_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_1);
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
    _jspx_th_bean_write_0.setName("Aima0103MForm");
    _jspx_th_bean_write_0.setProperty("issueSerial");
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
    _jspx_th_bean_write_1.setName("Aima0103MForm");
    _jspx_th_bean_write_1.setProperty("DateFormat(issueDate)");
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
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_2 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_format_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_2.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_2.setParent(null);
    _jspx_th_bean_write_2.setName("Aima0103MForm");
    _jspx_th_bean_write_2.setProperty("BigDecimal(issueAmount)");
    _jspx_th_bean_write_2.setFormat("#,###");
    int _jspx_eval_bean_write_2 = _jspx_th_bean_write_2.doStartTag();
    if (_jspx_th_bean_write_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_format_nobody.reuse(_jspx_th_bean_write_2);
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
    _jspx_th_bean_write_3.setName("Aima0103MForm");
    _jspx_th_bean_write_3.setProperty("debtName");
    int _jspx_eval_bean_write_3 = _jspx_th_bean_write_3.doStartTag();
    if (_jspx_th_bean_write_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_3);
    return false;
  }

  private boolean _jspx_meth_html_text_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_property_onblur_name_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_0.setPageContext(_jspx_page_context);
    _jspx_th_html_text_0.setParent(null);
    _jspx_th_html_text_0.setName("Aima0103MForm");
    _jspx_th_html_text_0.setProperty("ticketCount");
    _jspx_th_html_text_0.setOnblur("countTotalAmount(this.form);total(this.form);");
    int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
    if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_property_onblur_name_nobody.reuse(_jspx_th_html_text_0);
    return false;
  }

  private boolean _jspx_meth_bean_write_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_4 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_format_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_4.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_4.setParent(null);
    _jspx_th_bean_write_4.setName("Aima0103MForm");
    _jspx_th_bean_write_4.setProperty("BigDecimal(totalAmount)");
    _jspx_th_bean_write_4.setFormat("#,###");
    int _jspx_eval_bean_write_4 = _jspx_th_bean_write_4.doStartTag();
    if (_jspx_th_bean_write_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_format_nobody.reuse(_jspx_th_bean_write_4);
    return false;
  }
}
