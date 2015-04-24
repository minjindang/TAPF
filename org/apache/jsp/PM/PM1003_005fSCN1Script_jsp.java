package org.apache.jsp.PM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PM1003_005fSCN1Script_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/displaytag-12.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_rewrite_page_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_rewrite_page_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_rewrite_page_nobody.release();
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
      out.write("<!-- roleToFunScript.jsp -->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_html_rewrite_0(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_html_rewrite_1(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_html_rewrite_2(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_html_rewrite_3(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_html_rewrite_4(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_html_rewrite_5(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("\tfunction doBodyOnLoad(document)\r\n");
      out.write("\t{\r\n");
      out.write("         menuInit('theMenu', false);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkForm(form)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar roleid = form.GCODE.value;\t\r\n");
      out.write("\t\tif( isBlank(roleid) )\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"請選擇【使用者】!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar group = form.PM0004ID.value;\t\t\r\n");
      out.write("\t\tif( isBlank(group) )\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"請選擇【群組】!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("</script>");
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

  private boolean _jspx_meth_html_rewrite_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:rewrite
    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_0 = (org.apache.struts.taglib.html.RewriteTag) _jspx_tagPool_html_rewrite_page_nobody.get(org.apache.struts.taglib.html.RewriteTag.class);
    _jspx_th_html_rewrite_0.setPageContext(_jspx_page_context);
    _jspx_th_html_rewrite_0.setParent(null);
    _jspx_th_html_rewrite_0.setPage("/assets/scripts/xtree/xtree.js");
    int _jspx_eval_html_rewrite_0 = _jspx_th_html_rewrite_0.doStartTag();
    if (_jspx_th_html_rewrite_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_rewrite_page_nobody.reuse(_jspx_th_html_rewrite_0);
    return false;
  }

  private boolean _jspx_meth_html_rewrite_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:rewrite
    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_1 = (org.apache.struts.taglib.html.RewriteTag) _jspx_tagPool_html_rewrite_page_nobody.get(org.apache.struts.taglib.html.RewriteTag.class);
    _jspx_th_html_rewrite_1.setPageContext(_jspx_page_context);
    _jspx_th_html_rewrite_1.setParent(null);
    _jspx_th_html_rewrite_1.setPage("/assets/scripts/x/x_core.js");
    int _jspx_eval_html_rewrite_1 = _jspx_th_html_rewrite_1.doStartTag();
    if (_jspx_th_html_rewrite_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_rewrite_page_nobody.reuse(_jspx_th_html_rewrite_1);
    return false;
  }

  private boolean _jspx_meth_html_rewrite_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:rewrite
    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_2 = (org.apache.struts.taglib.html.RewriteTag) _jspx_tagPool_html_rewrite_page_nobody.get(org.apache.struts.taglib.html.RewriteTag.class);
    _jspx_th_html_rewrite_2.setPageContext(_jspx_page_context);
    _jspx_th_html_rewrite_2.setParent(null);
    _jspx_th_html_rewrite_2.setPage("/assets/scripts/x/x_dom.js");
    int _jspx_eval_html_rewrite_2 = _jspx_th_html_rewrite_2.doStartTag();
    if (_jspx_th_html_rewrite_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_rewrite_page_nobody.reuse(_jspx_th_html_rewrite_2);
    return false;
  }

  private boolean _jspx_meth_html_rewrite_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:rewrite
    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_3 = (org.apache.struts.taglib.html.RewriteTag) _jspx_tagPool_html_rewrite_page_nobody.get(org.apache.struts.taglib.html.RewriteTag.class);
    _jspx_th_html_rewrite_3.setPageContext(_jspx_page_context);
    _jspx_th_html_rewrite_3.setParent(null);
    _jspx_th_html_rewrite_3.setPage("/assets/scripts/x/x_event");
    int _jspx_eval_html_rewrite_3 = _jspx_th_html_rewrite_3.doStartTag();
    if (_jspx_th_html_rewrite_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_rewrite_page_nobody.reuse(_jspx_th_html_rewrite_3);
    return false;
  }

  private boolean _jspx_meth_html_rewrite_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:rewrite
    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_4 = (org.apache.struts.taglib.html.RewriteTag) _jspx_tagPool_html_rewrite_page_nobody.get(org.apache.struts.taglib.html.RewriteTag.class);
    _jspx_th_html_rewrite_4.setPageContext(_jspx_page_context);
    _jspx_th_html_rewrite_4.setParent(null);
    _jspx_th_html_rewrite_4.setPage("/assets/scripts/x/x_slide.js");
    int _jspx_eval_html_rewrite_4 = _jspx_th_html_rewrite_4.doStartTag();
    if (_jspx_th_html_rewrite_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_rewrite_page_nobody.reuse(_jspx_th_html_rewrite_4);
    return false;
  }

  private boolean _jspx_meth_html_rewrite_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:rewrite
    org.apache.struts.taglib.html.RewriteTag _jspx_th_html_rewrite_5 = (org.apache.struts.taglib.html.RewriteTag) _jspx_tagPool_html_rewrite_page_nobody.get(org.apache.struts.taglib.html.RewriteTag.class);
    _jspx_th_html_rewrite_5.setPageContext(_jspx_page_context);
    _jspx_th_html_rewrite_5.setParent(null);
    _jspx_th_html_rewrite_5.setPage("/assets/scripts/CollapsibleCheckboxMenu.js");
    int _jspx_eval_html_rewrite_5 = _jspx_th_html_rewrite_5.doStartTag();
    if (_jspx_th_html_rewrite_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_rewrite_page_nobody.reuse(_jspx_th_html_rewrite_5);
    return false;
  }
}
