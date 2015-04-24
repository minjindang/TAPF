package org.apache.jsp.DIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DIMA0201AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- DIMA0101AScript.jsp\r\n");
      out.write("程式目的：DIMA01\r\n");
      out.write("程式代號：DIMA01\r\n");
      out.write("程式日期：0950223\r\n");
      out.write("程式作者：Eric.Chen\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\tvar toDay = new Date();\r\n");
      out.write("\tvar Day=(toDay.getYear()-1911);\r\n");
      out.write("\tif (Day<100)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tDay=\"0\"+(toDay.getYear()-1911);\r\n");
      out.write("\t\tdocument.MainForm.accountYear.value = Day;\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\tDay =(toDay.getYear()-1911);\r\n");
      out.write("\t\tdocument.MainForm.accountYear.value = Day;\r\n");
      out.write("\t}\r\n");
      out.write("\tif ((toDay.getMonth()+1)<10)\r\n");
      out.write("\t\tDay += \"0\"+(toDay.getMonth()+1);\r\n");
      out.write("\telse Day+=toDay.getMonth()+1;\r\n");
      out.write("\tif (toDay.getDate()<10)\r\n");
      out.write("\t\tDay += \"0\"+toDay.getDate();\r\n");
      out.write("\telse Day +=toDay.getDate();\r\n");
      out.write("\t\r\n");
      out.write("\tdocument.MainForm.debtName.value = Number(document.MainForm.accountYear.value)+\"年度第  期短期借款\";\r\n");
      out.write("\tdocument.MainForm.elements['date(issueDate)'].value = Day;\r\n");
      out.write("\tdocument.MainForm.elements['date(dueDate)'].value = \"\";\r\n");
      out.write("\tdocument.MainForm.days.value = 0;\r\n");
      out.write("\tdocument.MainForm.elements['bigDecimal(expectAmount)'].value = \"\";\r\n");
      out.write("\tdocument.MainForm.serialNo.value = \"\";\r\n");
      out.write("\tdocument.MainForm.issueSerial.value = \"\";\r\n");
      out.write("\tdocument.MainForm.elements('bigDecimal(expectAmount)').value = \"\";\r\n");
      out.write("}\r\n");
      out.write("function getIssueSerial()\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\taccountYear\t\t=\tcurrform.accountYear.value;\r\n");
      out.write("\tvar\tserialNo\t=\tcurrform.serialNo.value;\r\n");
      out.write("\tif( \"\"!=accountYear && \"\"!=serialNo )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar serialTemp = \"\";\r\n");
      out.write("\t\tif(serialNo.charAt(0)== '公'){\r\n");
      out.write("\t\t\tserialTemp = \"公\";\r\n");
      out.write("\t\t\tserialNo = serialNo.substr(1,serialNo.length);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(serialNo.charAt(0)== '債'){\r\n");
      out.write("\t\t\tserialTemp = \"債\";\r\n");
      out.write("\t\t\tserialNo = serialNo.substr(1,serialNo.length);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tcurrform.issueSerial.value = accountYear+\"-\"+currform.serialNo.value\r\n");
      out.write("\t\tcurrform.debtName.value = Number(accountYear)+\"年度\"+serialTemp+\"第\"+Number(serialNo)+\"期短期借款\"\r\n");
      out.write("\t\treturn currform.issueSerial.value;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function getDays()\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\tissueDate\t\t=\tcurrform.elements['date(issueDate)'].value;\r\n");
      out.write("\tvar\tdueDate \t=\tcurrform.elements['date(dueDate)'].value\r\n");
      out.write("\t\r\n");
      out.write("\tif (!(CheckValidDate(issueDate)))\r\n");
      out.write("    {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("\tif (!(CheckValidDate(dueDate)))\r\n");
      out.write("    {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("    if(issueDate !=\"\" && dueDate!=\"\")\r\n");
      out.write("   \t{\r\n");
      out.write("\t\tcurrform.days.value = daycount(issueDate,dueDate,\"C\")\r\n");
      out.write("\t\tdocument.getElementById(\"dayid\").innerHTML = daycount(issueDate,dueDate,\"C\") ;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function getDaysByChange()\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\tissueDate\t\t=\tcurrform.elements['date(issueDate)'].value;\r\n");
      out.write("\tvar\tdueDate \t=\tcurrform.elements['date(dueDate)'].value\r\n");
      out.write("\r\n");
      out.write("\tif ((CheckValidDate(issueDate))&&(CheckValidDate(dueDate)))\r\n");
      out.write("    {\r\n");
      out.write("    \tcurrform.days.value = daycount(issueDate,dueDate,\"C\")\r\n");
      out.write("\t\tdocument.getElementById(\"dayid\").innerHTML = daycount(issueDate,dueDate,\"C\") ;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write(" \tvar isValid = true;\r\n");
      out.write("    var sError = \"\";\r\n");
      out.write("\tif (\"\" == form.accountYear.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【年度】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.serialNo.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【期次】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.debtCode.value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【預算別】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.budgetCode.value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【債務別】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.elements['date(issueDate)'].value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【借款起日】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (\"\" == form.elements['date(dueDate)'].value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【借款迄日】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    /*if (\"\" == form.debtName.value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【名稱】不可空白!!\";\r\n");
      out.write("    }*/\r\n");
      out.write("    if (\"\" == form.elements['bigDecimal(expectAmount)'].value )\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"【預計借款金額】不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (false == isValid)\r\n");
      out.write("    {\r\n");
      out.write("    \talert(sError);\r\n");
      out.write("    }\r\n");
      out.write("\t\treturn isValid;\r\n");
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
