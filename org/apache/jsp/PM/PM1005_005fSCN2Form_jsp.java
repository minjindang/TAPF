package org.apache.jsp.PM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kangdainfo.ast.webmenu.menu.MenuComponent;
import com.kangdainfo.ast.webmenu.menu.MenuContext;
import com.kangdainfo.ast.webmenu.display.MenuDisplayer;
import com.kangdainfo.ast.webmenu.permission.PermissionAdaptor;
import com.kangdainfo.ast.webmenu.display.CollapsibleCheckboxMenuDisplayer;

public final class PM1005_005fSCN2Form_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/displaytag-12.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_submit_value_styleClass_property_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_reset_value_styleClass_property_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_submit_value_styleClass_property_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_reset_value_styleClass_property_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.release();
    _jspx_tagPool_html_reset_value_styleClass_property_nobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table class=\"table_function\" width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"right\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_submit_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            ");
      if (_jspx_meth_html_reset_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_submit_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<input type=\"hidden\" name=\"roleid\" value=\"");
      out.print(request.getParameter("roleid"));
      out.write("\">\r\n");
      out.write("<table class=\"table_1\" width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t");

		try
		{
			MenuComponent[] menus = ((MenuContext) application.getAttribute(".menuContext")).getMenuComponents();
			MenuDisplayer displayer = new CollapsibleCheckboxMenuDisplayer();
			displayer.init(pageContext);
			displayer.setPermissionAdaptor((PermissionAdaptor) request.getAttribute("permissions"));
			((CollapsibleCheckboxMenuDisplayer)displayer).setCheckboxName("items");
			for (int i=0; i<menus.length; ++i)
				displayer.display(menus[i]);
		}
		catch (Exception e)
		{
			out.println("Exception: " + e);
			e.printStackTrace();
		}
	
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table class=\"table_function\" width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"right\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_submit_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            ");
      if (_jspx_meth_html_reset_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_html_submit_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
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

  private boolean _jspx_meth_html_submit_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_html_submit_0 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_html_submit_value_styleClass_property_nobody.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_html_submit_0.setPageContext(_jspx_page_context);
    _jspx_th_html_submit_0.setParent(null);
    _jspx_th_html_submit_0.setStyleClass("formcss_rbutton");
    _jspx_th_html_submit_0.setProperty("doUpd");
    _jspx_th_html_submit_0.setValue("確定");
    int _jspx_eval_html_submit_0 = _jspx_th_html_submit_0.doStartTag();
    if (_jspx_th_html_submit_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_0);
    return false;
  }

  private boolean _jspx_meth_html_reset_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:reset
    org.apache.struts.taglib.html.ResetTag _jspx_th_html_reset_0 = (org.apache.struts.taglib.html.ResetTag) _jspx_tagPool_html_reset_value_styleClass_property_nobody.get(org.apache.struts.taglib.html.ResetTag.class);
    _jspx_th_html_reset_0.setPageContext(_jspx_page_context);
    _jspx_th_html_reset_0.setParent(null);
    _jspx_th_html_reset_0.setStyleClass("formcss_rbutton");
    _jspx_th_html_reset_0.setProperty("reset");
    _jspx_th_html_reset_0.setValue("復原");
    int _jspx_eval_html_reset_0 = _jspx_th_html_reset_0.doStartTag();
    if (_jspx_th_html_reset_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_reset_value_styleClass_property_nobody.reuse(_jspx_th_html_reset_0);
    return false;
  }

  private boolean _jspx_meth_html_submit_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_html_submit_1 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_html_submit_value_styleClass_property_nobody.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_html_submit_1.setPageContext(_jspx_page_context);
    _jspx_th_html_submit_1.setParent(null);
    _jspx_th_html_submit_1.setStyleClass("formcss_rbutton");
    _jspx_th_html_submit_1.setProperty("goQry");
    _jspx_th_html_submit_1.setValue("回查詢");
    int _jspx_eval_html_submit_1 = _jspx_th_html_submit_1.doStartTag();
    if (_jspx_th_html_submit_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_1);
    return false;
  }

  private boolean _jspx_meth_html_submit_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_html_submit_2 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_html_submit_value_styleClass_property_nobody.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_html_submit_2.setPageContext(_jspx_page_context);
    _jspx_th_html_submit_2.setParent(null);
    _jspx_th_html_submit_2.setStyleClass("formcss_rbutton");
    _jspx_th_html_submit_2.setProperty("doUpd");
    _jspx_th_html_submit_2.setValue("確定");
    int _jspx_eval_html_submit_2 = _jspx_th_html_submit_2.doStartTag();
    if (_jspx_th_html_submit_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_2);
    return false;
  }

  private boolean _jspx_meth_html_reset_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:reset
    org.apache.struts.taglib.html.ResetTag _jspx_th_html_reset_1 = (org.apache.struts.taglib.html.ResetTag) _jspx_tagPool_html_reset_value_styleClass_property_nobody.get(org.apache.struts.taglib.html.ResetTag.class);
    _jspx_th_html_reset_1.setPageContext(_jspx_page_context);
    _jspx_th_html_reset_1.setParent(null);
    _jspx_th_html_reset_1.setStyleClass("formcss_rbutton");
    _jspx_th_html_reset_1.setProperty("reset");
    _jspx_th_html_reset_1.setValue("復原");
    int _jspx_eval_html_reset_1 = _jspx_th_html_reset_1.doStartTag();
    if (_jspx_th_html_reset_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_reset_value_styleClass_property_nobody.reuse(_jspx_th_html_reset_1);
    return false;
  }

  private boolean _jspx_meth_html_submit_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_html_submit_3 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_html_submit_value_styleClass_property_nobody.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_html_submit_3.setPageContext(_jspx_page_context);
    _jspx_th_html_submit_3.setParent(null);
    _jspx_th_html_submit_3.setStyleClass("formcss_rbutton");
    _jspx_th_html_submit_3.setProperty("goQry");
    _jspx_th_html_submit_3.setValue("回查詢");
    int _jspx_eval_html_submit_3 = _jspx_th_html_submit_3.doStartTag();
    if (_jspx_th_html_submit_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_3);
    return false;
  }
}
