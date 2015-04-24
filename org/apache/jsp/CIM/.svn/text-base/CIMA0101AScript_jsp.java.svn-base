package org.apache.jsp.CIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.dnt.tame.util.DateUtil;

public final class CIMA0101AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- CIMA0101AScript.jsp -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\tclearForm(document.forms[0]);\r\n");
      out.write("\tdocument.getElementById(\"issueSerialid\").innerHTML = \"\";\r\n");
      out.write("\tdocument.getElementById(\"dayid\").innerHTML = \"\";\r\n");
      out.write("\tgetSerial(document.forms[0]);\r\n");
      out.write("\tdocument.forms[0].elements['date(issueDate)'].value = ");
      out.print("'"+DateUtil.ROCDate()+"'");
      out.write(";\r\n");
      out.write("\tdocument.forms[0].elements['bigDecimal(expectAmount)'].value = '00,000,000';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function changeValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tform.action = \"CIMA01\" ;\r\n");
      out.write("\tform.submit() ;\r\n");
      out.write("}\r\n");
      out.write("function changeYear(form)\r\n");
      out.write("{\r\n");
      out.write("\tif(100 > Number(form.accountYear.value) && 0 != Number(form.accountYear.value))\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif(3 > form.accountYear.value.length)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tform.accountYear.value = \"0\" + form.accountYear.value;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function changeDate(form)\r\n");
      out.write("{\t\t\r\n");
      out.write("\t\tvar bigDate = form.elements['date(issueDate)'].value ;\r\n");
      out.write("\t\tvar endDate = form.elements['date(dueDate)'].value ;\r\n");
      out.write("\t\tvar showType = form.showType.value;\r\n");
      out.write("\t\tif(\"\" != bigDate && null != bigDate && \"\" != endDate && null != endDate && \"\" != showType && null != showType)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tform.textCount.value = daycount(bigDate,endDate,form.showType.value) ;\r\n");
      out.write("\t\t\tdocument.getElementById(\"dayid\").innerHTML = daycount(bigDate,endDate,form.showType.value) ;\r\n");
      out.write("\t\t}\r\n");
      out.write("}\r\n");
      out.write("function getSerial(form)\r\n");
      out.write("{\r\n");
      out.write("\tif(\"\" != form.accountYear.value \r\n");
      out.write("\t&& \"\" != form.serialNo.value \r\n");
      out.write("\t&& null != form.accountYear.value \r\n");
      out.write("\t&& null != form.serialNo.value )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.getElementById(\"issueSerialid\").innerHTML = Number(form.accountYear.value) + \"-\" + form.serialNo.value ;\r\n");
      out.write("\t\tform.issueSerial.value = Number(form.accountYear.value) + \"-\" + form.serialNo.value ;\r\n");
      out.write("\t\tform.debtName.value = Number(form.accountYear.value) + \"-\" + form.serialNo.value + \"中長期借款\";\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\"showType\" , \"accountYear\", \"serialNo\", \"issueSerial\" , \"date(issueDate)\" , \"date(dueDate)\" , \"bigDecimal(expectAmount)\" );\r\n");
      out.write("\tvar colNames = new Array(\"【顯示類別】\", \"【年度】\", \"【期次】\", \"【期別】\" , \"【借款起日】\" ,  \"【借款迄日】\" , \"【預計借款金額】\" );\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(colNames[result] + \"不可空白!!\");\r\n");
      out.write("\t}\r\n");
      out.write("    if (form.elements['date(dueDate)'].value < form.elements['date(issueDate)'].value )\r\n");
      out.write("    {\r\n");
      out.write("        alert(\"借款起日不可大於借款迄日!!\");\r\n");
      out.write("        result = 1;\r\n");
      out.write("    }\r\n");
      out.write("    if(\"\" == form.textCount.value && result < 0)\r\n");
      out.write("    {\r\n");
      out.write("    \talert(\"借款天期不可空白!!\");\r\n");
      out.write("        result = 1;\r\n");
      out.write("    }\r\n");
      out.write("\treturn result < 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
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
