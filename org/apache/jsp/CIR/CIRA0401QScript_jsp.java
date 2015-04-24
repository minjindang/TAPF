package org.apache.jsp.CIR;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CIRA0401QScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!--\tCIRA0401QScript.jsp\r\n");
      out.write("程式目的：CIRA0401中長期借款債務概況總表\r\n");
      out.write("程式代號：CIRA0401\r\n");
      out.write("程式日期：0950316\r\n");
      out.write("程式作者：ERIC CHEN\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("  //nothing\r\n");
      out.write("}\r\n");
      out.write("function changeValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tgetLabel(form);\r\n");
      out.write("\tform.action = \"CIRA04\";\r\n");
      out.write("\tform.submit();\r\n");
      out.write("}\r\n");
      out.write("function getSelectValue(obj)\r\n");
      out.write("{\r\n");
      out.write("\tif( obj.baseUnit.value!=\"\" )\r\n");
      out.write("\t\tobj.baseUnitValue.value = obj.baseUnit.options[obj.baseUnit.selectedIndex].text;\r\n");
      out.write("\telse\r\n");
      out.write("\t\tobj.baseUnitValue.value = \"\";\r\n");
      out.write("}\r\n");
      out.write("function getLabel(obj)\r\n");
      out.write("{\r\n");
      out.write("\tif( obj.debtCode.value!=\"\" )\r\n");
      out.write("\t\tobj.debtLabel.value = obj.debtCode.options[obj.debtCode.selectedIndex].text;\r\n");
      out.write("\telse\r\n");
      out.write("\t\tobj.debtLabel.value = \"\";\r\n");
      out.write("\t\t\r\n");
      out.write("\tif( obj.budgetCode.value!=\"\" )\r\n");
      out.write("\t\tobj.budgetLabel.value = obj.budgetCode.options[obj.budgetCode.selectedIndex].text;\r\n");
      out.write("\telse\r\n");
      out.write("\t\tobj.budgetLabel.value = \"\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\"status\" ,\"date(baseDate)\" ,\"baseUnit\");\r\n");
      out.write("\tvar colNames = new Array(\"【償還狀態】\" , \"【計算基準日】\", \"【金額單位】\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(colNames[result] + \"不可空白!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\t if (form.elements['date(endDate)'].value < form.elements['date(startDate)'].value)\r\n");
      out.write("    {\r\n");
      out.write("        alert(\"結束日期不可小於啟始日期!!\");\r\n");
      out.write("        result = 1 ; \r\n");
      out.write("    }\r\n");
      out.write("\treturn (result < 0);\r\n");
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
