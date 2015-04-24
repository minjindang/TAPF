package org.apache.jsp.CPM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CPMA0101AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- CPMA0101AScript.jsp\r\n");
      out.write("程式目的：CPMA01\r\n");
      out.write("程式代號：CPMA01\r\n");
      out.write("程式日期：0950306\r\n");
      out.write("程式作者：Eric.Chen\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("  //nothing\r\n");
      out.write("}\r\n");
      out.write("function changeList(form)\r\n");
      out.write("{\r\n");
      out.write("\tif( form.debtName.value!= \"\" )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tform.issueId.value = form.debtName.options.value ;\r\n");
      out.write("\t}\t\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\tform.issueId.value = 0;\r\n");
      out.write("\t}\r\n");
      out.write("\tform.action = \"CPMA0101LIST\";\r\n");
      out.write("\tform.submit() ;\r\n");
      out.write("}\r\n");
      out.write("function showType(form)\r\n");
      out.write("{\t\r\n");
      out.write("\tif (form.elements['date(planRepayDate)'].value > form.elements['date(qryrepayDate)'].value)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tform.debtType.value = \"2提前還款\" ;\r\n");
      out.write("\t\tdocument.getElementById(\"debtTypeid\").innerHTML = \"2提前還款\" ;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if  (form.elements['date(planRepayDate)'].value == form.elements['date(qryrepayDate)'].value)\r\n");
      out.write("\t{\t\r\n");
      out.write("\t\tform.debtType.value = \"0正常還款\" ;\r\n");
      out.write("\t\tdocument.getElementById(\"debtTypeid\").innerHTML = \"0正常還款\" ;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if  (form.elements['date(planRepayDate)'].value < form.elements['date(qryrepayDate)'].value )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tform.debtType.value = \"1延後還款\" ;\r\n");
      out.write("\t\tdocument.getElementById(\"debtTypeid\").innerHTML = \"1延後還款\" ;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array( \"debtName\" , \"date(planRepayDate)\" , \"date(qryrepayDate)\" );\r\n");
      out.write("\tvar colNames = new Array(\"【中長期借款名稱】\" , \"【預期償還日期】\" , \"【實際償還日期】\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0)\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(colNames[result] + \"不可空白!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\tif (\"0\" == form.debtName.value )\r\n");
      out.write("    {\r\n");
      out.write("        alert(\"中長期借款名稱不可空白!!\");\r\n");
      out.write("        result = 1 ;\r\n");
      out.write("    }\r\n");
      out.write("    if (\"0\" == form.elements['date(planRepayDate)'].value)\r\n");
      out.write("    {\r\n");
      out.write("        alert(\"預期償還日期不可空白!!\");\r\n");
      out.write("        result = 1 ;\r\n");
      out.write("    }\r\n");
      out.write("\treturn (result < 0);\r\n");
      out.write("}\r\n");
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
