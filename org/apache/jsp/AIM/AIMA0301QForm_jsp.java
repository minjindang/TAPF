package org.apache.jsp.AIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AIMA0301QForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/displaytag-12.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_size_property_name_maxlength_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.release();
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
      out.write("程式目的：Aima02文字\r\n");
      out.write("程式代號：Aima02\r\n");
      out.write("程式日期：0950306\r\n");
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
      out.write("<table class='table_1' width='100%'>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"394\" class='table_item'>公債代號：</td>\r\n");
      out.write("\t\t\t<td width=\"394\" class='table_td'>");
      if (_jspx_meth_html_text_0(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("\t\t\t<td width=\"394\" class='table_item'>預算別：</td>\r\n");
      out.write("\t\t\t<td width=\"394\" class='table_td'>");
      out.print(gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",null,"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false));
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("\t\t\t<td width=\"394\" class='table_item'>債務別：</td>\r\n");
      out.write("\t\t\t<td width=\"394\" class='table_td'>");
      out.print(gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(),"debtCode",null,false));
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("\t\t\t<td width=\"394\" class='table_item'>交換標的：</td>\r\n");
      out.write("\t\t\t<td width=\"394\" class='table_td'>");
      out.print(gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.ExstockCodeManage.getExstockInfo(),"qryExchangeStockCode","" ,10, false));
      out.write("\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("\t\t\t<td width=\"394\" class='table_item'>發行日期：</td>\r\n");
      out.write("\t\t\t<td width=\"394\" class='table_td'>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_html_text_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"javascript: myCalendar.setCallBackObj('Date(qryIssueDateStart)');myCalendar.show();\"><img src=\"/tapf/assets/images/calendar/dynCalendar.gif\" border=\"0\" align=\"absmiddle\" width=\"16\" height=\"16\" title=\"選擇日期\"/></a>\r\n");
      out.write("\t\t\t\t~\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_html_text_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"javascript: myCalendar.setCallBackObj('Date(qryIssueDateEnd)');myCalendar.show();\"><img src=\"/tapf/assets/images/calendar/dynCalendar.gif\" border=\"0\" align=\"absmiddle\" width=\"16\" height=\"16\" title=\"選擇日期\"/></a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("        </tr>\r\n");
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

  private boolean _jspx_meth_html_text_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_0.setPageContext(_jspx_page_context);
    _jspx_th_html_text_0.setParent(null);
    _jspx_th_html_text_0.setName("Aima0301QForm");
    _jspx_th_html_text_0.setProperty("qryIssueSerial");
    _jspx_th_html_text_0.setSize("15");
    _jspx_th_html_text_0.setMaxlength("12");
    int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
    if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_0);
    return false;
  }

  private boolean _jspx_meth_html_text_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_1.setPageContext(_jspx_page_context);
    _jspx_th_html_text_1.setParent(null);
    _jspx_th_html_text_1.setName("Aima0301QForm");
    _jspx_th_html_text_1.setProperty("Date(qryIssueDateStart)");
    _jspx_th_html_text_1.setSize("7");
    _jspx_th_html_text_1.setMaxlength("7");
    int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
    if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_1);
    return false;
  }

  private boolean _jspx_meth_html_text_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_2.setPageContext(_jspx_page_context);
    _jspx_th_html_text_2.setParent(null);
    _jspx_th_html_text_2.setName("Aima0301QForm");
    _jspx_th_html_text_2.setProperty("Date(qryIssueDateEnd)");
    _jspx_th_html_text_2.setSize("7");
    _jspx_th_html_text_2.setMaxlength("7");
    int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
    if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.reuse(_jspx_th_html_text_2);
    return false;
  }
}
