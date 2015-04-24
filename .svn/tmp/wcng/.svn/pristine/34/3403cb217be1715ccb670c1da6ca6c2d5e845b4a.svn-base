package org.apache.jsp.HAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RAMA0101MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- RAMA0101MScript.jsp\r\n");
      out.write("程式目的：RAMA01檢查是否有輸入值\r\n");
      out.write("程式代號：RAMA01\r\n");
      out.write("程式日期：1001005\r\n");
      out.write("程式作者：Powen Hsueh\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("\r\n");
      out.write("//確認\r\n");
      out.write("function checkValue1(form)\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("\t{\r\n");
      out.write("\t  //nothing\r\n");
      out.write("\t   \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("function setRowIndex(x)\r\n");
      out.write("{\r\n");
      out.write("\tvar clickedRowIndex = document.getElementById(\"clickedRowIndex\");\r\n");
      out.write("\tclickedRowIndex.value = x.rowIndex;\r\n");
      out.write("\t//alert(\"Row index is: \" + clickedRowIndex.value);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkPermission(typeId)\r\n");
      out.write("{\r\n");
      out.write("\t//alert(document.MainForm.elements.length);\r\n");
      out.write("\tvar clickedRowIndex = document.getElementById(\"clickedRowIndex\").value;\r\n");
      out.write("\tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar currentUserDeptId = currform.CurrentUserDeptId.value;\r\n");
      out.write("\t//var repayDate = document.getElementsByName('repayDate');\r\n");
      out.write("\tvar repayHandle = document.getElementsByName('repayHandle');\r\n");
      out.write("\tvar repayNumber = document.getElementsByName('repayNumber');\r\n");
      out.write("\tvar accountDate = document.getElementsByName('accountDate');\r\n");
      out.write("\tvar accountNumber = document.getElementsByName('accountNumber');\r\n");
      out.write("\tvar fundNumber = document.getElementsByName('fundNumber');\r\n");
      out.write("\tvar secretaryDate = document.getElementsByName('secretaryDate');\r\n");
      out.write("\t/*alert(clickedRowIndex);\r\n");
      out.write("\talert(repayHandle[clickedRowIndex-3].value);\r\n");
      out.write("\talert(repayNumber[clickedRowIndex-3].value);\r\n");
      out.write("\talert(accountDate[clickedRowIndex-3].value);\r\n");
      out.write("\talert(accountNumber[clickedRowIndex-3].value);\r\n");
      out.write("\talert(fundNumber[clickedRowIndex-3].value);\r\n");
      out.write("\talert(secretaryDate[clickedRowIndex-3].value);\r\n");
      out.write("\talert(fundNumber[clickedRowIndex-3].value);\r\n");
      out.write("\talert(rowIndex);\r\n");
      out.write("\talert(document.getElementById(\"grid\"));\r\n");
      out.write("\talert(document.getElementById(\"grid\").rows[rowIndex].cells[2]);*/\r\n");
      out.write("\t//var cel= document.getElementById(\"grid\").rows[rowIndex].getElementsByName(\"fundNumber\").value;\r\n");
      out.write("\t\r\n");
      out.write("    //alert(cel);\r\n");
      out.write("   \r\n");
      out.write("\t//alert(\"currentUserDeptId : \" + currentUserDeptId);\r\n");
      out.write("\t//alert(\"typeId : \" + typeId);\r\n");
      out.write("\t//第三組\r\n");
      out.write("\tif( (currentUserDeptId ==  8|| currentUserDeptId == 10) && typeId == 1){\r\n");
      out.write("\t\tif(secretaryDate[clickedRowIndex-3].value){\r\n");
      out.write("\t\t\talert('秘書室輸入資料後,不可再修改!!');\r\n");
      out.write("\t\t\tcurrform.action='RAMA01';\r\n");
      out.write("\t\t\tcurrform.submit();\t\r\n");
      out.write("\t\t\treturn \"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//會計室\r\n");
      out.write("\telse if ((currentUserDeptId == 2 || currentUserDeptId == 21) && typeId == 2){\r\n");
      out.write("\t\tif(secretaryDate[clickedRowIndex-3].value){\r\n");
      out.write("\t\t\talert('秘書室輸入資料後,不可再修改!!');\r\n");
      out.write("\t\t\tcurrform.action='RAMA01';\r\n");
      out.write("\t\t\tcurrform.submit();\t\r\n");
      out.write("\t\t\treturn \"\";\r\n");
      out.write("\t\t}else if(!repayHandle[clickedRowIndex-3].value || !repayNumber[clickedRowIndex-3].value){\r\n");
      out.write("\t\t\talert('第3組使用者未輸入資料前不可輸入!!');\r\n");
      out.write("\t\t\tcurrform.action='RAMA01';\r\n");
      out.write("\t\t\tcurrform.submit();\t\r\n");
      out.write("\t\t\treturn \"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//秘書室\r\n");
      out.write("\telse if (currentUserDeptId == 22 && typeId == 3){\r\n");
      out.write("\t\tif(!accountDate[clickedRowIndex-3].value || !fundNumber[clickedRowIndex-3].value){\r\n");
      out.write("\t\t\talert('會計室使用者輸入資料前,不可輸入!!');\r\n");
      out.write("\t\t\tcurrform.action='RAMA01';\r\n");
      out.write("\t\t\tcurrform.submit();\t\r\n");
      out.write("\t\t\treturn \"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\talert('無權限編輯!!');\r\n");
      out.write("\t\t//secretaryDate[0].focus();\r\n");
      out.write("\t\tcurrform.action='RAMA01';\r\n");
      out.write("\t\tcurrform.submit();\r\n");
      out.write("\t\treturn \"\";\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\t//currform.action='RAMA02';\r\n");
      out.write("\t\t//currform.submit();\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
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
