package org.apache.jsp.getdata;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.dnt.tame.util.CommonFun;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class IssueSerialC_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	String	accountYear	=	request.getParameter("para");
	String	debtType	=	"C";

      out.write("\r\n");
      out.write("<script language=\"JScript\" type=\"text/javascript\">\r\n");

	String	sqlstr	=	"SELECT TOP 1 ";
			sqlstr	+=	" A.SERIAL_NO AS serialNo";
			sqlstr	+=	"  FROM ISSUE_MAIN A ";
			sqlstr	+=	" WHERE A.DEBT_TYPE='"+debtType+"'";
			sqlstr	+=	"   AND A.ACCOUNT_YEAR='"+accountYear+"'";
			sqlstr	+=	" ORDER BY CONVERT(NUMERIC,A.SERIAL_NO) desc ";

	List list = CommonFun.getList(sqlstr);

	Object [] object=null;
	if(list!=null && !list.isEmpty())
	{
		Map map = (Map) list.get(list.size()-1);

		if(map!=null)
		{
			Set set = map.keySet();
			if(set!=null)
			{
				object = set.toArray() ;
				for(int j=0;j<object.length;j++)
				{
					if( object[j]!=null )
					{
						String textName = object[j].toString();
						String textValue = "";

						if(map!=null && map.get(textName)!=null && map.get(textName).toString()!=null)
							textValue = map.get(textName).toString();
						if(textValue==null)
							textValue="";
						if( "serialno".equals( textName ) )
						{
							String serialNo;
							if("".equals(textValue))
							{
								serialNo = "01";
							}
							else
							{
								Integer serial = new Integer(Integer.parseInt(textValue)+1);
								serialNo= serial.toString();
								if(serial.intValue()<10)
									serialNo = "0"+serialNo;
							}

							out.print("\t\t parent.document.getElementById(\"issueSerialid\").innerHTML = '"+Integer.parseInt(accountYear)+"-"+serialNo+"';  \r\n");
							out.print("\t\tparent.MainForm.debtName.value = '"+Integer.parseInt(accountYear)+"-"+serialNo+"中長期借款'; \r\n");
							out.print("\t\tparent.MainForm.serialNo.value = '"+serialNo+"'; \r\n");
							out.print("\t\tparent.MainForm.issueSerial.value = '"+Integer.parseInt(accountYear)+"-"+serialNo+"'; \r\n");
						}
					}
				}
			}
		}
	}
	else
	{
		out.print("\t\t parent.document.getElementById(\"issueSerialid\").innerHTML = '"+accountYear+"-"+"01';  \r\n");
		out.print("\t\tparent.MainForm.issueSerial.value = '"+accountYear+"-"+"01'; \r\n");
		out.print("\t\tparent.MainForm.debtName.value = '"+accountYear+"-01中長期借款'; \r\n");
		out.print("\t\tparent.MainForm.serialNo.value = '01'; \r\n");
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
