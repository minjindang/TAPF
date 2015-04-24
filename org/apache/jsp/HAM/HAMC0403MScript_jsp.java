package org.apache.jsp.HAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HAMC0403MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \tvar oNumberMask = new Mask(\"#,###\", \"number\");\r\n");
      out.write("\tvar moneyCols = new Array(\"bigDecimal(srcMoney)\",\"bigDecimal(founda)\",\"bigDecimal(foundb)\",\"bigDecimal(allMoney)\");\r\n");
      out.write("\tfor(var i = 0 ; i < moneyCols.length ; i++)\r\n");
      out.write("\t{\r\n");
      out.write("\t\toNumberMask.attach(document.MainForm.elements[moneyCols[i]]);\r\n");
      out.write("\t\tdocument.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkForm(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\"allYear\",\"allMonth\",\"unitId\",\r\n");
      out.write("\t\t\"bigDecimal(srcMoney)\",\"bigDecimal(founda)\",\r\n");
      out.write("\t\t\"bigDecimal(foundb)\",\"bigDecimal(allMoney)\");\r\n");
      out.write("\tvar colNames = new Array(\"記帳年度\",\"分配年月\",\"受分配單位代號\",\r\n");
      out.write("\t\t\t\"受分配金額\",\"歸扣墊借款\",\r\n");
      out.write("\t\t\t\"代扣地方建設基金\",\"本次撥付金額\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(\"【\" + colNames[result] + \"】，未輸入!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\treturn result < 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function countTotal(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar srcMoney = replaceAll(form.elements['bigDecimal(srcMoney)'].value,\",\",\"\");\r\n");
      out.write("\tvar founda = replaceAll(form.elements['bigDecimal(founda)'].value,\",\",\"\");\r\n");
      out.write("\tvar foundb = replaceAll(form.elements['bigDecimal(foundb)'].value,\",\",\"\");\r\n");
      out.write("\tvar lastFound = replaceAll(form.elements['bigDecimal(lastFound)'].value,\",\",\"\");\r\n");
      out.write("\tvar allMoney = allMoney-founda-foundb-lastFound;\r\n");
      out.write("\tvar nowFound = nowFound-founda-foundb-lastFound;\r\n");
      out.write("\tif(allMoney<0)\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"[歸扣墊借款]+[代扣地方建設基金] 不可大於 [受分配金額]\");\r\n");
      out.write("\t\tdocument.MainForm.elements['bigDecimal(allMoney)'].value = 0;\r\n");
      out.write("\t\t//document.MainForm.elements['bigDecimal(nowFound)'].value = 0;\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.MainForm.elements['bigDecimal(allMoney)'].value = addMoneyMask(allMoney);\r\n");
      out.write("\t\t//document.MainForm.elements['bigDecimal(nowFound)'].value = addMoneyMask(allMoney);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function countFound(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar lastFound = replaceAll(form.elements['bigDecimal(lastFound)'].value,\",\",\"\");//上年度受分配金額\r\n");
      out.write("\tvar srcMoney = replaceAll(form.elements['bigDecimal(srcMoney)'].value,\",\",\"\");//受分配金額\r\n");
      out.write("\tvar founda = replaceAll(form.elements['bigDecimal(founda)'].value,\",\",\"\");//歸扣墊借款\r\n");
      out.write("\tif(null == lastFound || \"\" == lastFound)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tlastFound = 0;\r\n");
      out.write("\t\tform.elements['bigDecimal(lastFound)'].value = 0;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tif(lastFound > 0){\r\n");
      out.write("\t\t\tvar nowFound = srcMoney - lastFound - founda;\r\n");
      out.write("\t\t\tform.elements['bigDecimal(nowFound)'].value = nowFound;//本年度受分配金額\r\n");
      out.write("\t\t\tform.elements['bigDecimal(allMoney)'].value = srcMoney - founda;//本次撥付金額\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tform.elements['bigDecimal(nowFound)'].value = srcMoney - founda;//本年度受分配金額\r\n");
      out.write("\t\t\tvar allMoney = srcMoney - (lastFound*-1) - founda;\r\n");
      out.write("\t\t\tform.elements['bigDecimal(allMoney)'].value = allMoney;//本次撥付金額\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar allMoney = replaceAll(form.elements['bigDecimal(allMoney)'].value,\",\",\"\");//歸扣墊借款\r\n");
      out.write("\tif(allMoney<0)\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"[歸扣墊借款] 不可大於 [受分配金額]\");\r\n");
      out.write("\t\tdocument.MainForm.elements['bigDecimal(allMoney)'].value = 0;\r\n");
      out.write("\t\t//document.MainForm.elements['bigDecimal(nowFound)'].value = 0;\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.MainForm.elements['bigDecimal(allMoney)'].value = addMoneyMask(allMoney);\r\n");
      out.write("\t\t//document.MainForm.elements['bigDecimal(nowFound)'].value = addMoneyMask(allMoney);\r\n");
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
