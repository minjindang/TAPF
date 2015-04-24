package org.apache.jsp.GAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GAMA0503CScript_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
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
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\t\t//do nothing\r\n");
      out.write("}\r\n");
      out.write("function changeKeepAmount(form){\r\n");
      out.write("\tvar key = \"\";\r\n");
      out.write("\tvar keepUamount1 = form.elements['BigDecimal(keepUamount1)'].value;\r\n");
      out.write("\tvar keepUamount2 = form.elements['BigDecimal(keepUamount2)'].value;\r\n");
      out.write("\tvar keepBamount1 = form.elements['BigDecimal(keepBamount1)'].value;\r\n");
      out.write("\tvar keepBamount2 = form.elements['BigDecimal(keepBamount2)'].value;\r\n");
      out.write("\tvar oddKeepUamount1 = form.elements['BigDecimal(oddKeepUamount1)'].value;\r\n");
      out.write("\tvar oddKeepUamount2 = form.elements['BigDecimal(oddKeepUamount2)'].value;\r\n");
      out.write("\tvar oddKeepBamount1 = form.elements['BigDecimal(oddKeepBamount1)'].value;\r\n");
      out.write("\tvar oddKeepBamount2 = form.elements['BigDecimal(oddKeepBamount2)'].value;\r\n");
      out.write("\tvar bAmount = replaceAll(form.elements['BigDecimal(keepBamount)'].value,\",\",\"\");\r\n");
      out.write("\tvar uAmount = replaceAll(form.elements['BigDecimal(keepUamount)'].value,\",\",\"\");\r\n");
      out.write("\tif(form.changeKey1.checked == true)\r\n");
      out.write("\t\tkey = \"1\";\r\n");
      out.write("\telse if(form.changeKey2.checked == true)\r\n");
      out.write("\t\tkey = \"2\";\t\r\n");
      out.write("\tif(key == \"1\"){\r\n");
      out.write("\t\tdocument.getElementById(\"keepUamount1\").innerHTML = addMoneyMask(parseInt(keepUamount1) - parseInt(uAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"keepUamount2\").innerHTML = addMoneyMask(parseInt(keepUamount2) + parseInt(uAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"keepBamount1\").innerHTML = addMoneyMask(parseInt(keepBamount1) - parseInt(bAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"keepBamount2\").innerHTML = addMoneyMask(parseInt(keepBamount2) + parseInt(bAmount));\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepUamount1\").innerHTML = addMoneyMask(parseInt(oddKeepUamount1) - parseInt(uAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepUamount2\").innerHTML = addMoneyMask(parseInt(oddKeepUamount2) + parseInt(uAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepBamount1\").innerHTML = addMoneyMask(parseInt(oddKeepBamount1) - parseInt(bAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepBamount2\").innerHTML = addMoneyMask(parseInt(oddKeepBamount2) + parseInt(bAmount));\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(key == \"2\"){\r\n");
      out.write("\t\tdocument.getElementById(\"keepUamount1\").innerHTML = addMoneyMask(parseInt(keepUamount1) + parseInt(uAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"keepUamount2\").innerHTML = addMoneyMask(parseInt(keepUamount2) - parseInt(uAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"keepBamount1\").innerHTML = addMoneyMask(parseInt(keepBamount1) + parseInt(bAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"keepBamount2\").innerHTML = addMoneyMask(parseInt(keepBamount2) - parseInt(bAmount));\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepUamount1\").innerHTML = addMoneyMask(parseInt(oddKeepUamount1) + parseInt(uAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepUamount2\").innerHTML = addMoneyMask(parseInt(oddKeepUamount2) - parseInt(uAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepBamount1\").innerHTML = addMoneyMask(parseInt(oddKeepBamount1) + parseInt(bAmount));\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepBamount2\").innerHTML = addMoneyMask(parseInt(oddKeepBamount2) - parseInt(bAmount));\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"keepUamount1\").innerHTML = addMoneyMask(keepUamount1);\r\n");
      out.write("\t\tdocument.getElementById(\"keepUamount2\").innerHTML = addMoneyMask(keepUamount2);\r\n");
      out.write("\t\tdocument.getElementById(\"keepBamount1\").innerHTML = addMoneyMask(keepBamount1);\r\n");
      out.write("\t\tdocument.getElementById(\"keepBamount2\").innerHTML = addMoneyMask(keepBamount2);\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepUamount1\").innerHTML = addMoneyMask(oddKeepUamount1);\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepUamount2\").innerHTML = addMoneyMask(oddKeepUamount2);\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepBamount1\").innerHTML = addMoneyMask(oddKeepBamount1);\r\n");
      out.write("\t\tdocument.getElementById(\"oddKeepBamount2\").innerHTML = addMoneyMask(oddKeepBamount2);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkKey1(form){\r\n");
      out.write("\tif(form.changeKey1.checked == true)\r\n");
      out.write("\t\tform.changeKey2.checked = false;\r\n");
      out.write("\tchangeKeepAmount(form);\r\n");
      out.write("}\r\n");
      out.write("function checkKey2(form){\r\n");
      out.write("\tif(form.changeKey2.checked == true)\r\n");
      out.write("\t\tform.changeKey1.checked = false;\r\n");
      out.write("\tchangeKeepAmount(form);\r\n");
      out.write("}\r\n");
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
