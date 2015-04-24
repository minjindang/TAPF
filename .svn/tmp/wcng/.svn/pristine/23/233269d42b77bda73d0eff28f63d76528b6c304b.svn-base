package org.apache.jsp.menu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
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
      out.write("<html>\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3.org/TR/html4/frameset.dtd\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>國庫署  債務資訊管理系統</title>\r\n");
      out.write("\t<meta http-equiv=\"Expires\" content=\"-1\" />\r\n");
      out.write("\t<meta http-equiv=\"Pragma\" content=\"no-cache\" />\r\n");
      out.write("\t<meta http-equiv=\"Cache-Control\" content=\"no-cache\" />\r\n");
      out.write("\t<meta http-equiv=\"content-type\" content=\"text/html; charset=MS950\" />\r\n");
      out.write("</head>\r\n");
      out.write("<STYLE type=text/css>\r\n");
      out.write("DIV.buttonBar {\r\n");
      out.write("\tCURSOR: hand;\r\n");
      out.write("\tPADDING-LEFT: 0px;\r\n");
      out.write("\tZ-INDEX: 1;\r\n");
      out.write("\tPOSITION: absolute;\r\n");
      out.write("\tTOP: 78px;\r\n");
      out.write("\tLEFT: 10px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</STYLE>\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function getML(id)\r\n");
      out.write("{\r\n");
      out.write("\tif (id!=\"\")\r\n");
      out.write("\t    parent.bottom.location.href = \"/tapf/do/MENU?ID=\"+id;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function doLogout()\r\n");
      out.write("{\r\n");
      out.write("\tparent.location.href = \"/tapf/do/Logout\";\r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("<body background=\"../assets/images/header2/back.gif\">\r\n");
      out.write("<DIV class=\"buttonBar\">\r\n");
      out.write("\r\n");
      out.write("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t<tr>\r\n");

		List list = (List) request.getAttribute("menuBar");
		int i=1;
		for (Iterator it = list.iterator();it.hasNext();)
		{
			Map param = (Map) it.next();
			if(!param.isEmpty())
			{
				String	id		=	param.get("ID").toString();
				String	name	=	(String) param.get("NAME");

      out.write("\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<img hspace=\"0\" border=\"0\" src=\"../assets/images/button/");
      out.print(id);
      out.write("b.gif\"\r\n");
      out.write("\t\t\t\tonclick=\"getML('");
      out.print(id);
      out.write("');\"\r\n");
      out.write("\t\t\t\tonMouseOver=\"this.src='../assets/images/button/");
      out.print(id);
      out.write("a.gif'\"\r\n");
      out.write("\t\t\t\tonMouseOut=\"this.src='../assets/images/button/");
      out.print(id);
      out.write("b.gif'\"\r\n");
      out.write("\t\t\t\talt=\"");
      out.print(name);
      out.write("\"/>\r\n");

			}
			i++;

      out.write("\r\n");
      out.write("\t\t</td>\r\n");

		}

      out.write("\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<img border=\"0\" src=\"../assets/images/button/homeb.gif\"\r\n");
      out.write("\t\t\t\tonclick=\"doLogout();\"\r\n");
      out.write("\t\t\t\tonMouseOver=\"this.src='../assets/images/button/homea.gif'\"\r\n");
      out.write("\t\t\t\tonMouseOut=\"this.src='../assets/images/button/homeb.gif'\"\r\n");
      out.write("\t\t\t\talt=\"回首頁\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</DIV>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
