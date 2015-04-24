package org.apache.jsp.GAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GAMA0502MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script language=\"Javascript\">\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("function checkForm(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\"accountYear\",\"dataType\",\"banish\");\r\n");
      out.write("\tvar colNames = new Array(\"年度\",\"資料類別\",\"排限/非排限\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(\"【\" + colNames[result] + \"】，未輸入!!\");\r\n");
      out.write("\t\tform.focus(cols[result]);\r\n");
      out.write("\t}\r\n");
      out.write("\treturn result < 0;\r\n");
      out.write("}\r\n");
      out.write("function getAuditAmount(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar keepAmount = parseFloat(replaceAll(form.elements['bigDecimal(keepAmount)'].value,\",\",\"\"));\r\n");
      out.write("\tvar realAmount = parseFloat(replaceAll(form.elements['bigDecimal(realAmount)'].value,\",\",\"\"));\r\n");
      out.write("\tvar auditAmount = keepAmount + realAmount;\r\n");
      out.write("\tauditAmount = auditAmount.toFixed(3);\r\n");
      out.write("\tform.elements['bigDecimal(auditAmount)'].value = addMoneyMask(auditAmount);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getKeepAmount(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar mainAccountYear = \"");
      out.print(request.getAttribute("mainAccountYear"));
      out.write("\";\r\n");
      out.write("\tvar subAmount = parseFloat(replaceAll(form.elements['bigDecimal(subAmount)'].value,\",\",\"\"));\r\n");
      out.write("\tvar keepAmount = parseFloat(replaceAll(form.elements['bigDecimal(oldKeepAmount)'].value,\",\",\"\"));\r\n");
      out.write("\tvar plusdebtAmount = parseFloat(replaceAll(form.elements['bigDecimal(plusdebtAmount)'].value,\",\",\"\"));//當年增加實際數\r\n");
      out.write("\tif(mainAccountYear==form.elements['accountYear'].value)\r\n");
      out.write("\t\tkeepAmount = keepAmount - subAmount;\r\n");
      out.write("\telse\r\n");
      out.write("\t\tkeepAmount = keepAmount - subAmount - plusdebtAmount;\r\n");
      out.write("\tif(keepAmount < 0){\r\n");
      out.write("\t\talert(\"保留數小於0請先執行轉移作業!!\");\r\n");
      out.write("\t\tform.elements['bigDecimal(keepAmount)'].value = addMoneyMask(form.elements['bigDecimal(oldKeepAmount)'].value);\r\n");
      out.write("\t\tform.elements['bigDecimal(subAmount)'].value = addMoneyMask(form.elements['sorSubAmount'].value) ;\r\n");
      out.write("\t\tform.elements['bigDecimal(plusdebtAmount)'].value = addMoneyMask(form.elements['sorPludebtAmount'].value) ;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tkeepAmount = keepAmount.toFixed(3);\r\n");
      out.write("\t\tform.elements['bigDecimal(keepAmount)'].value = addMoneyMask(keepAmount);\r\n");
      out.write("\t\tgetAuditAmount(form);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function changeYear(form)\r\n");
      out.write("{\r\n");
      out.write("\tif(form.accountYear.value != \"\")\r\n");
      out.write("\t\tdoAction(\"GAMA0502M2\");\r\n");
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
