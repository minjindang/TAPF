package org.apache.jsp.EAQ;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EAQC0101QScript_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

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
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("  //nothing\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkForm(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar alertMessage = \"\";\r\n");

	String[] txtparam = {"【記帳年度】"};

	for (int j = 0; j < txtparam.length; j++)
	{
		out.print("\t\tif( isBlank(ele"+j+") )\r");
		out.print("\t\t\talertMessage += \""+txtparam[j]+"，不可空白!\\r\";\r");
	}

      out.write("\r\n");
      out.write("\tif(alertMessage!=\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(alertMessage);\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkForm2(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar alertMessage = \"\";\r\n");

	String[] param2 = {"qryYear","filePath"};
	String[] txtparam2 = {"記帳年度","檔案路徑"};

	for (int k = 0; k < param2.length; k++)
	{
		out.print("\t\tvar ele"+k+" = form.elements['"+param2[k]+"'].value;\r");
	}

	for (int j = 0; j < txtparam2.length; j++)
	{
		out.print("\t\tif( isBlank(ele"+j+") )\r");
		out.print("\t\t\talertMessage += \""+txtparam2[j]+"，未輸入!\\r\";\r");
	}

      out.write("\r\n");
      out.write("\tif(alertMessage!=\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(alertMessage);\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
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
