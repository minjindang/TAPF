package org.apache.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class md3form_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-tiles.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_tiles_insert_page_flush_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_tiles_insert_page_flush_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_tiles_insert_page_flush_nobody.release();
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
      response.setContentType("text/html;charset=MS950");
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
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td align=\"center\" class=\"title\">");
      out.print(request.getAttribute("title"));
      out.write("</td></tr></table>\r\n");
      out.write("\r\n");
      out.write("<form name=\"MainForm\" action=\"");
      out.print(request.getAttribute("action"));
      out.write("\" method=\"post\">\r\n");

	String mform = request.getAttribute("mform").toString();
	String mbar = request.getAttribute("mbar").toString();
	String dform = request.getAttribute("dform").toString();
	String dbar = request.getAttribute("dbar").toString();
	String lform = request.getAttribute("lform").toString();
	String lbar = request.getAttribute("lbar").toString();
	String llform = request.getAttribute("llform").toString();
	String llbar = request.getAttribute("llbar").toString();

      out.write('\r');
      out.write('\n');
      out.write('	');
      //  tiles:insert
      org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_0 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_page_flush_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
      _jspx_th_tiles_insert_0.setPageContext(_jspx_page_context);
      _jspx_th_tiles_insert_0.setParent(null);
      _jspx_th_tiles_insert_0.setPage(mform);
      _jspx_th_tiles_insert_0.setFlush(true);
      int _jspx_eval_tiles_insert_0 = _jspx_th_tiles_insert_0.doStartTag();
      if (_jspx_th_tiles_insert_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_tiles_insert_page_flush_nobody.reuse(_jspx_th_tiles_insert_0);
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  tiles:insert
      org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_1 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_page_flush_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
      _jspx_th_tiles_insert_1.setPageContext(_jspx_page_context);
      _jspx_th_tiles_insert_1.setParent(null);
      _jspx_th_tiles_insert_1.setPage(mbar);
      _jspx_th_tiles_insert_1.setFlush(true);
      int _jspx_eval_tiles_insert_1 = _jspx_th_tiles_insert_1.doStartTag();
      if (_jspx_th_tiles_insert_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_tiles_insert_page_flush_nobody.reuse(_jspx_th_tiles_insert_1);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      //  tiles:insert
      org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_2 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_page_flush_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
      _jspx_th_tiles_insert_2.setPageContext(_jspx_page_context);
      _jspx_th_tiles_insert_2.setParent(null);
      _jspx_th_tiles_insert_2.setPage(dform);
      _jspx_th_tiles_insert_2.setFlush(true);
      int _jspx_eval_tiles_insert_2 = _jspx_th_tiles_insert_2.doStartTag();
      if (_jspx_th_tiles_insert_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_tiles_insert_page_flush_nobody.reuse(_jspx_th_tiles_insert_2);
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  tiles:insert
      org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_3 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_page_flush_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
      _jspx_th_tiles_insert_3.setPageContext(_jspx_page_context);
      _jspx_th_tiles_insert_3.setParent(null);
      _jspx_th_tiles_insert_3.setPage(dbar);
      _jspx_th_tiles_insert_3.setFlush(true);
      int _jspx_eval_tiles_insert_3 = _jspx_th_tiles_insert_3.doStartTag();
      if (_jspx_th_tiles_insert_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_tiles_insert_page_flush_nobody.reuse(_jspx_th_tiles_insert_3);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      //  tiles:insert
      org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_4 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_page_flush_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
      _jspx_th_tiles_insert_4.setPageContext(_jspx_page_context);
      _jspx_th_tiles_insert_4.setParent(null);
      _jspx_th_tiles_insert_4.setPage(lform);
      _jspx_th_tiles_insert_4.setFlush(true);
      int _jspx_eval_tiles_insert_4 = _jspx_th_tiles_insert_4.doStartTag();
      if (_jspx_th_tiles_insert_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_tiles_insert_page_flush_nobody.reuse(_jspx_th_tiles_insert_4);
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  tiles:insert
      org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_5 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_page_flush_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
      _jspx_th_tiles_insert_5.setPageContext(_jspx_page_context);
      _jspx_th_tiles_insert_5.setParent(null);
      _jspx_th_tiles_insert_5.setPage(lbar);
      _jspx_th_tiles_insert_5.setFlush(true);
      int _jspx_eval_tiles_insert_5 = _jspx_th_tiles_insert_5.doStartTag();
      if (_jspx_th_tiles_insert_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_tiles_insert_page_flush_nobody.reuse(_jspx_th_tiles_insert_5);
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
      //  tiles:insert
      org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_6 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_page_flush_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
      _jspx_th_tiles_insert_6.setPageContext(_jspx_page_context);
      _jspx_th_tiles_insert_6.setParent(null);
      _jspx_th_tiles_insert_6.setPage(llform);
      _jspx_th_tiles_insert_6.setFlush(true);
      int _jspx_eval_tiles_insert_6 = _jspx_th_tiles_insert_6.doStartTag();
      if (_jspx_th_tiles_insert_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_tiles_insert_page_flush_nobody.reuse(_jspx_th_tiles_insert_6);
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  tiles:insert
      org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_7 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_page_flush_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
      _jspx_th_tiles_insert_7.setPageContext(_jspx_page_context);
      _jspx_th_tiles_insert_7.setParent(null);
      _jspx_th_tiles_insert_7.setPage(llbar);
      _jspx_th_tiles_insert_7.setFlush(true);
      int _jspx_eval_tiles_insert_7 = _jspx_th_tiles_insert_7.doStartTag();
      if (_jspx_th_tiles_insert_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_tiles_insert_page_flush_nobody.reuse(_jspx_th_tiles_insert_7);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("<iframe name=\"reqfram\" width=\"-1\" height=\"-1\" frameborder=\"0\" title=\"iframe\" >\r\n");
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
}
