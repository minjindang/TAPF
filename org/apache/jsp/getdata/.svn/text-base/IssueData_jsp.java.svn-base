package org.apache.jsp.getdata;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.debt.common.PayManager;
import gov.dnt.tame.util.DateUtil;
import java.util.*;

public final class IssueData_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"JScript\" type=\"text/javascript\">\r\n");

	Integer	issueId	= Integer.parseInt(request.getParameter("issueId"));
	String	repayDate	=	request.getParameter("repayDate");
	String	capitalSerial	=	request.getParameter("capitalSerial");
	if(issueId != 0)
	{
		IssueMain issueMain = new tw.gov.nta.debt.common.IssueManager().getBean(issueId);
		String days = DateUtil.getDays(issueMain.getIssueDate(),DateUtil.str2Date(repayDate)).toString();
		out.print("\t\tparent.MainForm.debtName.value ='"+issueMain.getDebtName()+"'; \r\n");
		out.print("\t\tparent.document.getElementById(\"debt\").innerHTML ='"+issueMain.getDebtName()+"'; \r\n");
		//out.print(tw.gov.nta.exchequer.action.BIMA0200.getIssueData(issueId));
		out.print("\t\tparent.MainForm.elements['date(issueDate)'].value = '"+issueMain.getIssueDate()+"'; \r\n");
		out.print("\t\tparent.MainForm.interestDays.value = \""+days+"\"; \r\n");
		if(issueMain.getIssueAmount() != null)
		{
			//out.print("\t\tparent.MainForm.elements['bigDecimal(issueAmount)'].value = '"+issueMain.getIssueAmount()+"'; \r\n");
			//out.print("\t\tparent.MainForm.issueAmount2.value = '"+issueMain.getIssueAmount()+"'; \r\n");
			out.print("\t\tparent.document.getElementById(\"issue\").innerHTML ='"+issueMain.getIssueAmount()+"'; \r\n");
			out.print("\t\tparent.document.getElementById(\"issue2\").innerHTML ='"+issueMain.getIssueAmount()+"'; \r\n");
		}
		else
		{
			//out.print("\t\tparent.MainForm.elements['bigDecimal(issueAmount)'].value = ''; \r\n");
			//out.print("\t\tparent.MainForm.issueAmount2.value = ''; \r\n");
			out.print("\t\tparent.document.getElementById(\"issue\").innerHTML =''; \r\n");
			out.print("\t\tparent.document.getElementById(\"issue2\").innerHTML =''; \r\n");
		}
		List payList = new PayManager().getDataByIssue(issueMain.getId());
		String capitalSerialTemp = null;
		if (payList.size()==0)
		{
			capitalSerialTemp = "A";
		}
		else
		{
			for(Iterator it=payList.iterator();it.hasNext();)
			{
				PaymentMain paymentMainDto = (PaymentMain)it.next();
				capitalSerialTemp = String.valueOf((char)(((int)(paymentMainDto.getCapitalSerial().charAt(0)))+1));
			}
		}
		out.print("\t\tparent.MainForm.capitalSerial.value = '"+ capitalSerialTemp+"'; \r\n");
	}
	else
	{
		out.print("\t\tparent.MainForm.debtName.value =''; \r\n");
		out.print("\t\tparent.document.getElementById(\"debt\").innerHTML ='&nbsp;'; \r\n");
		out.print("\t\tparent.MainForm.elements['date(issueDate)'].value = ''; \r\n");
		out.print("\t\tparent.MainForm.interestDays.value = \"\"; \r\n");
		//out.print("\t\tparent.MainForm.elements['bigDecimal(issueAmount)'].value = ''; \r\n");
		//out.print("\t\tparent.MainForm.issueAmount2.value = ''; \r\n");
		out.print("\t\tparent.MainForm.capitalSerial.value = ''; \r\n");
		out.print("\t\tparent.document.getElementById(\"issue\").innerHTML ='&nbsp;'; \r\n");
		out.print("\t\tparent.document.getElementById(\"issue2\").innerHTML ='&nbsp;'; \r\n");
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
