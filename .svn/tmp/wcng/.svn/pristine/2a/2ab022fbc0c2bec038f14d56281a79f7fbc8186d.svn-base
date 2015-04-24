package org.apache.jsp.HAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HAMC0301MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- HAMB0301MScript.jsp\r\n");
      out.write("程式目的：HAMB03檢查是否有輸入值\r\n");
      out.write("程式代號：HAMB03\r\n");
      out.write("程式日期：0950221\r\n");
      out.write("程式作者：Eric.Chen\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\t//add Money Mask\r\n");
      out.write("\t//patterm(#,###) => 123,456,789\r\n");
      out.write("\t//patterm($#,###.000) => $123,456,789.000\r\n");
      out.write("\tvar oNumberMask = new Mask(\"#,###\", \"number\");\r\n");
      out.write("\tvar moneyCols = new Array(\"bigDecimal(nationTax)\",\"bigDecimal(localTax)\",\"bigDecimal(intTax)\",\"bigDecimal(totMon)\");\r\n");
      out.write("\tfor(var i = 0 ; i < moneyCols.length ; i++)\r\n");
      out.write("\t{\r\n");
      out.write("\t\toNumberMask.attach(document.MainForm.elements[moneyCols[i]]);\r\n");
      out.write("\t\tdocument.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array( \"taxYear\" , \"taxMonth\" , \"bigDecimal(nationTax)\" , \"bigDecimal(localTax)\" , \"bigDecimal(intTax)\" , \"bigDecimal(totMon)\");\r\n");
      out.write("\tvar colNames = new Array(\"【記帳年度】\", \"【分配年月】\" , \"【國稅收入】\" , \"【地方收入】\" , \"【利息收入】\" , \"【預定撥付】\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(colNames[result] + \"不可空白!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\treturn (result < 0);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkValue1(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array( \"taxYear\" , \"taxMonth\" , \"bigDecimal(nationTax)\" , \"bigDecimal(localTax)\" , \"bigDecimal(intTax)\" , \"bigDecimal(totMon)\");\r\n");
      out.write("\tvar colNames = new Array(\"【記帳年度】\", \"【分配年月】\" , \"【國稅收入】\" , \"【地方收入】\" , \"【利息收入】\" , \"【預定撥付】\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(colNames[result] + \"不可空白!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\tif (result < 0){\r\n");
      out.write("\t\t//if (!checkIsOk(form.taxYear.value+form.taxMonth.value)){\r\n");
      out.write("\t\t\treturn checkAlloted(form.taxYear.value+form.taxMonth.value);\r\n");
      out.write("\t//\t}\r\n");
      out.write("\t\t//\treturn false;\t\r\n");
      out.write("\t}\r\n");
      out.write("\treturn (result < 0);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getHiddenValues()\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\ttaxYear\t\t=\tcurrform.taxYear.value;\r\n");
      out.write("\tvar\ttaxMonth\t=\tcurrform.taxMonth.value\r\n");
      out.write("\tif( \"\"!=taxYear && \"\"!=taxMonth )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tcurrform.action='HAMC0303';\r\n");
      out.write("\t\tcurrform.submit();\r\n");
      out.write("\t}\r\n");
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
