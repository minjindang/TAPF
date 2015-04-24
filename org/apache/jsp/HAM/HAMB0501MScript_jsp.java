package org.apache.jsp.HAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HAMB0501MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_present_name;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_logic_present_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_logic_present_name.release();
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

      out.write("<!-- Andrew Sung -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\t");
      if (_jspx_meth_logic_present_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write(" \tvar isValid = true;\r\n");
      out.write("    var sError = \"\";\r\n");
      out.write("\tif (\"\" == form.titlea.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【未扣墊借】主旨不可空白!!\";\r\n");
      out.write("        form.titlea.focus();\r\n");
      out.write("        alert(sError);\r\n");
      out.write("\t\treturn isValid;\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.titleb.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【已扣墊借】主旨不可空白!!\";\r\n");
      out.write("        form.titleb.focus();\r\n");
      out.write("        alert(sError);\r\n");
      out.write("\t\treturn isValid;\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.contenta.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【未扣墊借】內容不可空白!!\";\r\n");
      out.write("        form.contenta.focus();\r\n");
      out.write("        alert(sError);\r\n");
      out.write("\t\treturn isValid;\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.contentb.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【已扣墊借】內容不可空白!!\";\r\n");
      out.write("        form.contentb.focus();\r\n");
      out.write("        alert(sError);\r\n");
      out.write("\t\treturn isValid;\r\n");
      out.write("    }\r\n");
      out.write("\treturn isValid;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_logic_present_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:present
    org.apache.struts.taglib.logic.PresentTag _jspx_th_logic_present_0 = (org.apache.struts.taglib.logic.PresentTag) _jspx_tagPool_logic_present_name.get(org.apache.struts.taglib.logic.PresentTag.class);
    _jspx_th_logic_present_0.setPageContext(_jspx_page_context);
    _jspx_th_logic_present_0.setParent(null);
    _jspx_th_logic_present_0.setName("historyBack");
    int _jspx_eval_logic_present_0 = _jspx_th_logic_present_0.doStartTag();
    if (_jspx_eval_logic_present_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\twindow.history.back();\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_logic_present_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_present_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_logic_present_name.reuse(_jspx_th_logic_present_0);
    return false;
  }
}
