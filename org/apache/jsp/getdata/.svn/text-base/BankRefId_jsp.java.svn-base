package org.apache.jsp.getdata;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.dnt.tame.util.CommonFun;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class BankRefId_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	String	para	=	request.getParameter("para");
	System.out.println(para);

      out.write("\r\n");
      out.write("<script language=\"JScript\" type=\"text/javascript\">\r\n");

	String	sqlstr	=	"SELECT ";
			sqlstr	+=	" A.BANK_CODE AS bankCode, ";
			sqlstr	+=	" A.BANK_NAME AS bankName, ";
			sqlstr	+=	" A.ID AS ID ";
			sqlstr	+=	" FROM BANK_REF A ";
			sqlstr	+=	" WHERE A.BANK_CODE='"+para+"'";
			sqlstr	+=	" and A.belong_to_bank_id = '0'";
	System.out.println(sqlstr);
	List list = CommonFun.getList(sqlstr);
	Object [] object=null;
	if(list!=null && list.size()>0)
	{
		Map map = (Map) list.get(0);
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
						if(textName!=null)
						{
							System.out.println(textName);
							if(map!=null && map.get(textName)!=null && map.get(textName).toString()!=null)
								textValue = map.get(textName).toString();
							System.out.println(textValue);
							if(textValue==null)
								textValue="";
							if( "bankcode".equals( textName ) )
								out.print("\t\tparent.MainForm.bankCode.value = '"+textValue+"'; \r\n");
							if( "id".equals( textName ) )
								out.print("\t\tparent.MainForm.bankId.value = '"+textValue+"'; \r\n");
						}
					}
				}
			}
		}
	}
	else
	{
		out.print("\t\talert('查無資料!'); \r\n");
		out.print("\t\ttry{\r\n");
		out.print("\t\t\tparent.MainForm.bankId.value='';\r\n");
		out.print("\t\t\tparent.MainForm.bankCode.value='';\r\n");
		out.print("\t\t}catch(e){}\r\n");
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
