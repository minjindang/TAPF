package org.apache.jsp.getdata;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.dnt.tame.common.LabelValueBean;
import java.util.*;

public final class DebtCode_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script language=\"JScript\" type=\"text/javascript\">\r\n");

	Integer	budgetCode	= new Integer(Integer.parseInt(request.getParameter("budgetCode")));
	String debtCode = (String)request.getParameter("debtCodeOption");
	List list = new LinkedList();
	list = tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(budgetCode);
	if(list.size()!=0)
	{
		out.print("parent.MainForm."+debtCode+".value =\"\";");
		out.print("parent.MainForm."+debtCode+"_options.length = 0;");
		out.print("parent.MainForm."+debtCode+"_options.options[0] = new Option(\"請選擇\", \"\");");
		int i = 1;
		for (Iterator it = list.iterator(); it.hasNext();)
        {
			LabelValueBean bean = (LabelValueBean)it.next();
			//out.print("parent.MainForm.debtCode.options["+i+"].value = "+bean.getValuess()+";");
			//out.print("parent.MainForm.debtCode.options["+i+"].label = "+bean.getLabel()+";");
			out.print("parent.MainForm."+debtCode+"_options.options["+i+"] = new Option(\""+bean.getLabel()+"\", \""+bean.getValuess()+"\");");
			i++;
		}
	}
	else
	{
		out.print("parent.MainForm."+debtCode+".value =\"\";");
		out.print("parent.MainForm."+debtCode+"_options.length = 0;");
		out.print("parent.MainForm."+debtCode+"_options.options[0] = new Option(\"請選擇\", \"\");");
	}

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
}
