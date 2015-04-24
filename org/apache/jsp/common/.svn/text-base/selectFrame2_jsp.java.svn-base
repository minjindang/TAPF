package org.apache.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.dnt.tame.util.CommonFun;
import gov.dnt.tame.util.Converter;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import gov.dnt.tame.common.LabelValueBean;

public final class selectFrame2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"JScript\" type=\"text/javascript\">\t\t\r\n");

	String current = "parent.MainForm." + request.getParameter("selectName");
	String sql = request.getParameter("sqlstr");
 
	List list = Converter.getCodeListBySql(sql);
	int i = 0;
	
	out.print("var count = " + current + ".length;");
	out.print("for( k = 0 ; k < count  ; k++)\n");
	out.print("{\n");
	out.print(current + ".remove(0);\n");
	out.print("}\n");
	
    out.print(current + ".options.add(parent.document.createElement(\"OPTION\"));\n");
    out.print(current + ".options[0].text=\"請選擇..\";\n");
    out.print(current + ".options[0].value=\"\";\n");
	
	if(list!=null && !list.isEmpty() )
	{
		for (Iterator it = list.iterator();it.hasNext();)
		{
			LabelValueBean param = (LabelValueBean) it.next();
	        out.print(current + ".options.add(parent.document.createElement(\"OPTION\"));\n");
    	    out.print(current + ".options["+(i+1)+"].text=\""+ (String)param.getLabel()+"\";\n");
        	out.print(current + ".options["+(i+1)+"].value=\""+ (String)param.getValuess()+"\";\n");
        	i++;
		}	

	}

      out.write("\t\t\t  \r\n");
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
}
