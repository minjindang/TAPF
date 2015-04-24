package org.apache.jsp.BIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BIMA0101AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\ttry{\r\n");
      out.write("\t\tvar toDay = new Date();\r\n");
      out.write("\t\tvar Day=(toDay.getYear()-1911);\r\n");
      out.write("\t\tif (Day<100)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tDay=\"0\"+(toDay.getYear()-1911);\r\n");
      out.write("\t\t\tdocument.MainForm.accountYear.value = Day;\r\n");
      out.write("\t\t\tgetIssueSerial(Day,'B');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tDay =(toDay.getYear()-1911);\r\n");
      out.write("\t\t\tdocument.MainForm.accountYear.value = Day;\r\n");
      out.write("\t\t\tgetIssueSerial(Day,'B');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ((toDay.getMonth()+1)<10)\r\n");
      out.write("\t\t\tDay += \"0\"+(toDay.getMonth()+1);\r\n");
      out.write("\t\telse Day+=toDay.getMonth()+1;\r\n");
      out.write("\t\tif (toDay.getDate()<10)\r\n");
      out.write("\t\t\tDay += \"0\"+toDay.getDate();\r\n");
      out.write("\t\telse Day +=toDay.getDate();\r\n");
      out.write("\t\t\tdocument.MainForm.elements['date(issueDate)'].value = Day;\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar cashDueDate = parseInt(Day.substr(0, 3),10)+5;\r\n");
      out.write("    \tif(cashDueDate<100)\r\n");
      out.write("    \t\tcashDueDate = \"0\"+cashDueDate\r\n");
      out.write("    \tdocument.MainForm.elements['date(cashDueDate)'].value = cashDueDate+Day.substr(3, 4);\r\n");
      out.write("    \tdocument.MainForm.elements['bigDecimal(chargeRate)'].value = \"0.3\";\r\n");
      out.write("\t}catch(e){alert(e.message);}\r\n");
      out.write("\t//document.MainForm.elements['bigDecimal(expectAmount)'].value = \"00000000\";\r\n");
      out.write("\t//document.MainForm.elements['bigDecimal(capitalAmount)'].value = \"00000000\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkCapitalAmount(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar\texpectAmount\t=\treplaceAll(form.elements['bigDecimal(expectAmount)'].value,\",\",\"\");\r\n");
      out.write("\tvar\trealAmount \t=\treplaceAll(form.elements['bigDecimal(realAmount)'].value,\",\",\"\");\r\n");
      out.write("\r\n");
      out.write("\tdocument.MainForm.elements['bigDecimal(issueAmount)'].value = expectAmount ;\r\n");
      out.write("\tdocument.getElementById(\"issueAmount\").innerHTML = addMoneyMask(expectAmount) ;\r\n");
      out.write("\tif(expectAmount != \"\" && realAmount != \"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif( parseInt(realAmount) > parseInt(expectAmount) )\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tdocument.MainForm.elements['bigDecimal(realAmount)'].value = \"\";\r\n");
      out.write("\t\t\talert(\"實收額不得大於發行額\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getDays(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\tissueDate\t=\tcurrform.elements['date(issueDate)'].value;\r\n");
      out.write("\tvar\tdueDate \t=\tcurrform.elements['date(dueDate)'].value\r\n");
      out.write("\t\r\n");
      out.write("\tif (!(CheckValidDate(dueDate)))\r\n");
      out.write("    {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("    else\r\n");
      out.write("    {\r\n");
      out.write("    \r\n");
      out.write("    \tvar cashDueDate = parseInt(dueDate.substr(0, 3),10)+5;\r\n");
      out.write("    \tif(issueDate != \"\" && dueDate != \"\")\r\n");
      out.write("    \t{\r\n");
      out.write("\t    \tif(cashDueDate<100)\r\n");
      out.write("\t    \t\tcashDueDate = \"0\"+cashDueDate\r\n");
      out.write("\t    \tcurrform.elements['date(cashDueDate)'].value = cashDueDate+dueDate.substr(3, 4);\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    }\r\n");
      out.write("\tif (!(CheckValidDate(dueDate)))\r\n");
      out.write("    {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("   \telse if (issueDate !=\"\" && dueDate != \"\")\r\n");
      out.write("   \t{\r\n");
      out.write("\t\t//currform.days.value = daycount(issueDate,dueDate,\"C\")\r\n");
      out.write("\t\tvar bigDate = currform.elements['date(issueDate)'].value ;\r\n");
      out.write("\t\tvar endDate = currform.elements['date(dueDate)'].value ;\r\n");
      out.write("\t\tif(\"\" != bigDate && null != bigDate && \"\" != endDate && null != endDate )\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tform.days.value = daycount(bigDate,endDate,\"C\") ;\r\n");
      out.write("\t\t\tdocument.getElementById(\"dayid\").innerHTML = daycount(bigDate,endDate,\"C\") ;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcols = new Array(\r\n");
      out.write("\t\t\"accountYear\",\"issueSerial\",\"budgetCode_options\",\"debtCode_options\",\"date(issueDate)\",\r\n");
      out.write("\t\t\"date(dueDate)\",\"bigDecimal(expectAmount)\",\"bigDecimal(capitalAmount)\",\"bigDecimal(averageRate)\",\"bigDecimal(chargeRate)\",\"issueKind_options\",\"bondType_options\" );\r\n");
      out.write("\tvar colNames = new Array(\r\n");
      out.write("\t\t\"發行年度\",\"發行期別\",\"預算別\",\"債務別\",\"發行日期\",\r\n");
      out.write("\t\t\"到期日期\",\"發行額\",\"實收額\",\"貼現率\",\"手續費比例\",\r\n");
      out.write("\t\t\"國庫券型式\",\"種類\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(\"【\" + colNames[result] + \"】未輸入!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\treturn result < 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getDebtName(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar accountYear = form.accountYear.value;\r\n");
      out.write("\tvar serialNo = form.serialNo.value;\r\n");
      out.write("\t\r\n");
      out.write("\tdocument.MainForm.debtName.value = '財政部國庫券' + Number(accountYear) + '年度第F' + Number(accountYear)+\"-\"+Number(serialNo) + '期';\r\n");
      out.write("}\r\n");
      out.write("//-->\r\n");
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
