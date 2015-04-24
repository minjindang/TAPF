package org.apache.jsp.menu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class menuForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/displaytag-12.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notPresent_name;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_logic_notPresent_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_logic_notPresent_name.release();
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
      out.write("<STYLE type=text/css>\r\n");
      out.write("a       { font-family: \"Verdana\", \"Arial\", \"Helvetica\", \"sans-serif\"; font-size: 13px; color: #003399; text-decoration: none}\r\n");
      out.write("a:link  { color: #003399; text-decoration: none}\r\n");
      out.write("a:hover { color: #FF0066; text-decoration: none}\r\n");
      out.write(".itemMenu { font-family: \"Verdana\"; font-size: 15px; color: #663399; text-decoration: none} \r\n");
      out.write(".titleMenu { color: #000000; font-weight: bold; font-size: 18px;CURSOR: hand;}\r\n");
      out.write("body { background-image:url(../assets/images/bg.gif); }\r\n");
      out.write(" \r\n");
      out.write("</STYLE>\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function change(div)\r\n");
      out.write("{\r\n");
      out.write("\tvar d = document.getElementById(div).style;\r\n");
      out.write("\tif(d.display=='block')\r\n");
      out.write("\t{\r\n");
      out.write("\r\n");

	List hlist = (List) request.getAttribute("titleList");
	if( hlist!=null )
	{
		for (Iterator hit = hlist.iterator();hit.hasNext();)
		{
			Map hmap = (Map) hit.next();
			out.print("document.getElementById('list"+hmap.get("ID").toString()+"').style.display='none';\r\n");
		}
	}


      out.write("\r\n");
      out.write("\t}else {\r\n");

	if( hlist!=null )
	{
		for (Iterator hit2 = hlist.iterator();hit2.hasNext();)
		{
			Map hmap = (Map) hit2.next();
			out.print("document.getElementById('list"+hmap.get("ID").toString()+"').style.display='none';\r\n");
		}
	}


      out.write("\r\n");
      out.write("\td.display='block';\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("\t\r\n");

	List list = (List) request.getAttribute("titleList");
	if( list!=null )
	{
		boolean b = true;
		for (Iterator it = list.iterator();it.hasNext();)
		{

      out.write("\r\n");
      out.write("\t<table width=\"100%\" border=\"1\" align=\"center\" cellpadding=\"1\" cellspacing=\"1\" bordercolor=\"#EBEBEB\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");

			Map map = (Map) it.next();
			String titleID = map.get("ID").toString();
			out.print("<div class=\"titleMenu\" onClick=\"change('list"+titleID+"');\">\r\n");
			out.print( "<img src=\"../assets/images/menu/b011.gif\" width=\"18\" height=\"18\" valign=\"center\" align=\"center\">&nbsp;"+map.get("NAME")+"\r\n" );
			out.print("</div>\r\n");

      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");

	List mlist = (List) request.getAttribute("menuList");
	if( mlist!=null )
	{
		if(b)
			out.print("<div ID=\"list"+titleID+"\" style=\"display:block;\">\r\n");
		else
			out.print("<div ID=\"list"+titleID+"\" style=\"display:none;\">\r\n");
		b = false;
		out.print("<table width=\"100%\">\r\n");
		for (Iterator itl = mlist.iterator();itl.hasNext();)
		{
			Map mmap = (Map) itl.next();
			String PM0002ID = mmap.get("PM0002ID").toString();
			
			if( (titleID).equals(PM0002ID) )
			{

      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"title\">\r\n");
      out.write("\t\t\t\t<table width=\"100%\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\" bordercolor=\"#EBEBEB\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"../assets/images/menu/arrow_r.gif\" width=\"7\" height=\"7\">\r\n");

				out.print("<a href=\"/tapf/do/"+mmap.get("PATH")+"\"");

				if( "PM5001".equals(mmap.get("PATH")) )
					out.print(" target=\"_blank\" ");
				
				out.print(">");
				out.print("<font size='3'>"+mmap.get("NAME")+"</font>");
				out.print("</a>");
				out.print("("+mmap.get("PATH")+")");

      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");

			}
		}
		out.print("</table>\r\n");
		out.print("</div>\r\n");
	}

      out.write('\r');
      out.write('\n');

		}
	}

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_logic_notPresent_0(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_logic_notPresent_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  logic:notPresent
    org.apache.struts.taglib.logic.NotPresentTag _jspx_th_logic_notPresent_0 = (org.apache.struts.taglib.logic.NotPresentTag) _jspx_tagPool_logic_notPresent_name.get(org.apache.struts.taglib.logic.NotPresentTag.class);
    _jspx_th_logic_notPresent_0.setPageContext(_jspx_page_context);
    _jspx_th_logic_notPresent_0.setParent(null);
    _jspx_th_logic_notPresent_0.setName("titleList");
    int _jspx_eval_logic_notPresent_0 = _jspx_th_logic_notPresent_0.doStartTag();
    if (_jspx_eval_logic_notPresent_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_logic_notPresent_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_logic_notPresent_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_logic_notPresent_name.reuse(_jspx_th_logic_notPresent_0);
    return false;
  }
}
