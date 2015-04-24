package org.apache.jsp.GAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GAMA0401AForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_size_property_name_maxlength_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_checkbox_property_onclick_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_checkbox_property_name_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_checkbox_property_onclick_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_checkbox_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_text_size_property_name_maxlength_nobody.release();
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.release();
    _jspx_tagPool_html_checkbox_property_onclick_name_nobody.release();
    _jspx_tagPool_html_checkbox_property_name_nobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table class='table_1' width='100%'>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item' width='20%'><font color=\"red\">*</font>年度</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_text_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'><font color=\"#ff0000\">*</font>預算別</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      out.print(gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false));
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item' width='20%'><font color=\"#ff0000\">*</font>債務別</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      out.print(gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(0),"debtCode",false));
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item' width='20%'>類別</td>\r\n");
      out.write("\t\t<td class='table_td'>\r\n");
      out.write("\t\t\t");
      out.print(gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("DF"),"dataType","","",10, false));
      out.write("&nbsp;\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table class='table_1' width='100%'>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item' rowspan='4' width='15%'>預算數</td>\r\n");
      out.write("\t\t<td class='table_item' width='15%'>總額</td>\r\n");
      out.write("\t\t<td class='table_td' width='20%'>");
      if (_jspx_meth_html_text_1(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t<td class='table_item' rowspan='4' width='15%'>決算數</td>\r\n");
      out.write("\t\t<td class='table_item' width='15%'>總額</td>\r\n");
      out.write("\t\t<td class='table_td' width='20%'>");
      if (_jspx_meth_html_text_2(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item' width='20%'>排限金額</td>\r\n");
      out.write("\t\t<td class='table_td'>");
      if (_jspx_meth_html_text_3(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t<td class='table_item'>排限金額</td>\r\n");
      out.write("\t\t<td class='table_td'>");
      if (_jspx_meth_html_text_4(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>未排限餘額</td>\r\n");
      out.write("\t\t<td class='table_td'>");
      if (_jspx_meth_html_text_5(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t<td class='table_item'>未排限餘額</td>\r\n");
      out.write("\t\t<td class='table_td'>");
      if (_jspx_meth_html_text_6(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_td' colspan='2'>");
      if (_jspx_meth_html_checkbox_0(_jspx_page_context))
        return;
      out.write("是否為歲(入)出</td>\r\n");
      out.write("\t\t<td class='table_td' colspan='2'>");
      if (_jspx_meth_html_checkbox_1(_jspx_page_context))
        return;
      out.write("是否為歲(入)出</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item' rowspan='4'>實際數</td>\r\n");
      out.write("\t\t<td class='table_item'>總額</td>\r\n");
      out.write("\t\t<td class='table_td'>");
      if (_jspx_meth_html_text_7(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t<td class='table_item' rowspan='4'>保留數</td>\r\n");
      out.write("\t\t<td class='table_item'>總額</td>\r\n");
      out.write("\t\t<td class='table_td'>");
      if (_jspx_meth_html_text_8(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>排限金額</td>\r\n");
      out.write("\t\t<td class='table_td'>");
      if (_jspx_meth_html_text_9(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t<td class='table_item'>排限金額</td>\r\n");
      out.write("\t\t<td class='table_td'>");
      if (_jspx_meth_html_text_10(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_item'>未排限餘額</td>\r\n");
      out.write("\t\t<td class='table_td'>");
      if (_jspx_meth_html_text_11(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t<td class='table_item'>未排限餘額</td>\r\n");
      out.write("\t\t<td class='table_td'>");
      if (_jspx_meth_html_text_12(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class='table_td' colspan='2'>");
      if (_jspx_meth_html_checkbox_2(_jspx_page_context))
        return;
      out.write("是否為歲(入)出</td>\r\n");
      out.write("\t\t<td class='table_td' colspan='2'>");
      if (_jspx_meth_html_checkbox_3(_jspx_page_context))
        return;
      out.write("是否為歲(入)出</td>\r\n");
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

  private boolean _jspx_meth_html_text_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_0.setPageContext(_jspx_page_context);
    _jspx_th_html_text_0.setParent(null);
    _jspx_th_html_text_0.setName("Gama0401Form");
    _jspx_th_html_text_0.setProperty("accountYear");
    _jspx_th_html_text_0.setSize("3");
    _jspx_th_html_text_0.setMaxlength("3");
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
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_1.setPageContext(_jspx_page_context);
    _jspx_th_html_text_1.setParent(null);
    _jspx_th_html_text_1.setName("Gama0401Form");
    _jspx_th_html_text_1.setProperty("bigDecimal(budgetAmount)");
    _jspx_th_html_text_1.setSize("20");
    _jspx_th_html_text_1.setMaxlength("20");
    _jspx_th_html_text_1.setOnkeyup("calculate(this.form);");
    int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
    if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_1);
    return false;
  }

  private boolean _jspx_meth_html_text_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_2.setPageContext(_jspx_page_context);
    _jspx_th_html_text_2.setParent(null);
    _jspx_th_html_text_2.setName("Gama0401Form");
    _jspx_th_html_text_2.setProperty("bigDecimal(auditAmount)");
    _jspx_th_html_text_2.setSize("20");
    _jspx_th_html_text_2.setMaxlength("20");
    _jspx_th_html_text_2.setOnkeyup("calculate(this.form);");
    int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
    if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_2);
    return false;
  }

  private boolean _jspx_meth_html_text_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_3.setPageContext(_jspx_page_context);
    _jspx_th_html_text_3.setParent(null);
    _jspx_th_html_text_3.setName("Gama0401Form");
    _jspx_th_html_text_3.setProperty("bigDecimal(budgetDamount)");
    _jspx_th_html_text_3.setSize("20");
    _jspx_th_html_text_3.setMaxlength("20");
    _jspx_th_html_text_3.setOnkeyup("calculate(this.form);");
    int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
    if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_3);
    return false;
  }

  private boolean _jspx_meth_html_text_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_4 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_4.setPageContext(_jspx_page_context);
    _jspx_th_html_text_4.setParent(null);
    _jspx_th_html_text_4.setName("Gama0401Form");
    _jspx_th_html_text_4.setProperty("bigDecimal(auditDamount)");
    _jspx_th_html_text_4.setSize("20");
    _jspx_th_html_text_4.setMaxlength("20");
    _jspx_th_html_text_4.setOnkeyup("calculate(this.form);");
    int _jspx_eval_html_text_4 = _jspx_th_html_text_4.doStartTag();
    if (_jspx_th_html_text_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_4);
    return false;
  }

  private boolean _jspx_meth_html_text_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_5 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_5.setPageContext(_jspx_page_context);
    _jspx_th_html_text_5.setParent(null);
    _jspx_th_html_text_5.setName("Gama0401Form");
    _jspx_th_html_text_5.setProperty("bigDecimal(budgetUamount)");
    _jspx_th_html_text_5.setSize("20");
    _jspx_th_html_text_5.setMaxlength("20");
    _jspx_th_html_text_5.setOnkeyup("calculate2(this.form);");
    int _jspx_eval_html_text_5 = _jspx_th_html_text_5.doStartTag();
    if (_jspx_th_html_text_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_5);
    return false;
  }

  private boolean _jspx_meth_html_text_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_6 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_6.setPageContext(_jspx_page_context);
    _jspx_th_html_text_6.setParent(null);
    _jspx_th_html_text_6.setName("Gama0401Form");
    _jspx_th_html_text_6.setProperty("bigDecimal(auditUamount)");
    _jspx_th_html_text_6.setSize("20");
    _jspx_th_html_text_6.setMaxlength("20");
    _jspx_th_html_text_6.setOnkeyup("calculate2(this.form);");
    int _jspx_eval_html_text_6 = _jspx_th_html_text_6.doStartTag();
    if (_jspx_th_html_text_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_6);
    return false;
  }

  private boolean _jspx_meth_html_checkbox_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:checkbox
    org.apache.struts.taglib.html.CheckboxTag _jspx_th_html_checkbox_0 = (org.apache.struts.taglib.html.CheckboxTag) _jspx_tagPool_html_checkbox_property_onclick_name_nobody.get(org.apache.struts.taglib.html.CheckboxTag.class);
    _jspx_th_html_checkbox_0.setPageContext(_jspx_page_context);
    _jspx_th_html_checkbox_0.setParent(null);
    _jspx_th_html_checkbox_0.setName("Gama0401Form");
    _jspx_th_html_checkbox_0.setProperty("budgetYn");
    _jspx_th_html_checkbox_0.setOnclick("checkBudget(this.form)");
    int _jspx_eval_html_checkbox_0 = _jspx_th_html_checkbox_0.doStartTag();
    if (_jspx_th_html_checkbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_checkbox_property_onclick_name_nobody.reuse(_jspx_th_html_checkbox_0);
    return false;
  }

  private boolean _jspx_meth_html_checkbox_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:checkbox
    org.apache.struts.taglib.html.CheckboxTag _jspx_th_html_checkbox_1 = (org.apache.struts.taglib.html.CheckboxTag) _jspx_tagPool_html_checkbox_property_onclick_name_nobody.get(org.apache.struts.taglib.html.CheckboxTag.class);
    _jspx_th_html_checkbox_1.setPageContext(_jspx_page_context);
    _jspx_th_html_checkbox_1.setParent(null);
    _jspx_th_html_checkbox_1.setName("Gama0401Form");
    _jspx_th_html_checkbox_1.setProperty("auditYn");
    _jspx_th_html_checkbox_1.setOnclick("checkAudit(this.form)");
    int _jspx_eval_html_checkbox_1 = _jspx_th_html_checkbox_1.doStartTag();
    if (_jspx_th_html_checkbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_checkbox_property_onclick_name_nobody.reuse(_jspx_th_html_checkbox_1);
    return false;
  }

  private boolean _jspx_meth_html_text_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_7 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_7.setPageContext(_jspx_page_context);
    _jspx_th_html_text_7.setParent(null);
    _jspx_th_html_text_7.setName("Gama0401Form");
    _jspx_th_html_text_7.setProperty("bigDecimal(realAmount)");
    _jspx_th_html_text_7.setSize("20");
    _jspx_th_html_text_7.setMaxlength("20");
    _jspx_th_html_text_7.setOnkeyup("calculate(this.form);");
    int _jspx_eval_html_text_7 = _jspx_th_html_text_7.doStartTag();
    if (_jspx_th_html_text_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_7);
    return false;
  }

  private boolean _jspx_meth_html_text_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_8 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_8.setPageContext(_jspx_page_context);
    _jspx_th_html_text_8.setParent(null);
    _jspx_th_html_text_8.setName("Gama0401Form");
    _jspx_th_html_text_8.setProperty("bigDecimal(keepAmount)");
    _jspx_th_html_text_8.setSize("20");
    _jspx_th_html_text_8.setMaxlength("20");
    _jspx_th_html_text_8.setOnkeyup("calculate(this.form);");
    int _jspx_eval_html_text_8 = _jspx_th_html_text_8.doStartTag();
    if (_jspx_th_html_text_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_8);
    return false;
  }

  private boolean _jspx_meth_html_text_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_9 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_9.setPageContext(_jspx_page_context);
    _jspx_th_html_text_9.setParent(null);
    _jspx_th_html_text_9.setName("Gama0401Form");
    _jspx_th_html_text_9.setProperty("bigDecimal(realDamount)");
    _jspx_th_html_text_9.setSize("20");
    _jspx_th_html_text_9.setMaxlength("20");
    _jspx_th_html_text_9.setOnkeyup("calculate(this.form);");
    int _jspx_eval_html_text_9 = _jspx_th_html_text_9.doStartTag();
    if (_jspx_th_html_text_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_9);
    return false;
  }

  private boolean _jspx_meth_html_text_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_10 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_10.setPageContext(_jspx_page_context);
    _jspx_th_html_text_10.setParent(null);
    _jspx_th_html_text_10.setName("Gama0401Form");
    _jspx_th_html_text_10.setProperty("bigDecimal(keepDamount)");
    _jspx_th_html_text_10.setSize("20");
    _jspx_th_html_text_10.setMaxlength("20");
    _jspx_th_html_text_10.setOnkeyup("calculate(this.form);");
    int _jspx_eval_html_text_10 = _jspx_th_html_text_10.doStartTag();
    if (_jspx_th_html_text_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_10);
    return false;
  }

  private boolean _jspx_meth_html_text_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_11 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_11.setPageContext(_jspx_page_context);
    _jspx_th_html_text_11.setParent(null);
    _jspx_th_html_text_11.setName("Gama0401Form");
    _jspx_th_html_text_11.setProperty("bigDecimal(realUamount)");
    _jspx_th_html_text_11.setSize("20");
    _jspx_th_html_text_11.setMaxlength("20");
    _jspx_th_html_text_11.setOnkeyup("calculate2(this.form);");
    int _jspx_eval_html_text_11 = _jspx_th_html_text_11.doStartTag();
    if (_jspx_th_html_text_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_11);
    return false;
  }

  private boolean _jspx_meth_html_text_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_12 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_12.setPageContext(_jspx_page_context);
    _jspx_th_html_text_12.setParent(null);
    _jspx_th_html_text_12.setName("Gama0401Form");
    _jspx_th_html_text_12.setProperty("bigDecimal(keepUamount)");
    _jspx_th_html_text_12.setSize("20");
    _jspx_th_html_text_12.setMaxlength("20");
    _jspx_th_html_text_12.setOnkeyup("calculate2(this.form);");
    int _jspx_eval_html_text_12 = _jspx_th_html_text_12.doStartTag();
    if (_jspx_th_html_text_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_text_size_property_onkeyup_name_maxlength_nobody.reuse(_jspx_th_html_text_12);
    return false;
  }

  private boolean _jspx_meth_html_checkbox_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:checkbox
    org.apache.struts.taglib.html.CheckboxTag _jspx_th_html_checkbox_2 = (org.apache.struts.taglib.html.CheckboxTag) _jspx_tagPool_html_checkbox_property_onclick_name_nobody.get(org.apache.struts.taglib.html.CheckboxTag.class);
    _jspx_th_html_checkbox_2.setPageContext(_jspx_page_context);
    _jspx_th_html_checkbox_2.setParent(null);
    _jspx_th_html_checkbox_2.setName("Gama0401Form");
    _jspx_th_html_checkbox_2.setProperty("realYn");
    _jspx_th_html_checkbox_2.setOnclick("checkReal(this.form);");
    int _jspx_eval_html_checkbox_2 = _jspx_th_html_checkbox_2.doStartTag();
    if (_jspx_th_html_checkbox_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_checkbox_property_onclick_name_nobody.reuse(_jspx_th_html_checkbox_2);
    return false;
  }

  private boolean _jspx_meth_html_checkbox_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:checkbox
    org.apache.struts.taglib.html.CheckboxTag _jspx_th_html_checkbox_3 = (org.apache.struts.taglib.html.CheckboxTag) _jspx_tagPool_html_checkbox_property_name_nobody.get(org.apache.struts.taglib.html.CheckboxTag.class);
    _jspx_th_html_checkbox_3.setPageContext(_jspx_page_context);
    _jspx_th_html_checkbox_3.setParent(null);
    _jspx_th_html_checkbox_3.setName("Gama0401Form");
    _jspx_th_html_checkbox_3.setProperty("keepYn");
    int _jspx_eval_html_checkbox_3 = _jspx_th_html_checkbox_3.doStartTag();
    if (_jspx_th_html_checkbox_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_checkbox_property_name_nobody.reuse(_jspx_th_html_checkbox_3);
    return false;
  }
}
