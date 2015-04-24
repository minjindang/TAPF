package org.apache.jsp.CPM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CPMA0102AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- CPMA0102AScript.jsp\r\n");
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
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\t\r\n");
      out.write("\tvar capitalAmount = document.getElementsByName(\"capitalAmountPay\");\r\n");
      out.write("\tvar interestAmount = document.getElementsByName(\"interestAmountPay\");\r\n");
      out.write("\tvar totalAmount = document.getElementsByName(\"bigDecimal(totalAmount)\");\r\n");
      out.write("\tfor(i = 0 ; i < capitalAmount.length ; i++){\r\n");
      out.write("\t\ttotalAmount[i].value = Number(replaceAll(capitalAmount[i].value,\",\",\"\")) \r\n");
      out.write("\t\t+ Number(replaceAll(interestAmount[i].value,\",\",\"\"));\r\n");
      out.write("\t\ttotalAmount[i].value = addMoneyMask(totalAmount[i].value);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function changeValue()\r\n");
      out.write("{\t\r\n");
      out.write("\tvar capitalAmount = document.getElementsByName(\"capitalAmountPay\");\r\n");
      out.write("\tvar interestAmount = document.getElementsByName(\"interestAmountPay\");\r\n");
      out.write("\tvar totalAmount = document.getElementsByName(\"bigDecimal(totalAmount)\");\r\n");
      out.write("\tfor(i = 0 ; i < capitalAmount.length ; i++){\r\n");
      out.write("\t\ttotalAmount[i].value = Number(replaceAll(capitalAmount[i].value,\",\",\"\")) \r\n");
      out.write("\t\t+ Number(replaceAll(interestAmount[i].value,\",\",\"\"));\r\n");
      out.write("\t\ttotalAmount[i].value = addMoneyMask(totalAmount[i].value);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("//回復沒有千分位才可做確認 否則會有 BeanUtil 的問題\r\n");
      out.write("function changeMoneyMark()\r\n");
      out.write("{\r\n");
      out.write("\tvar capitalAmount = document.getElementsByName(\"capitalAmountPay\");\r\n");
      out.write("\tvar interestAmount = document.getElementsByName(\"interestAmountPay\");\r\n");
      out.write("\tfor(i = 0 ; i < capitalAmount.length ; i++){\r\n");
      out.write("\t\tcapitalAmount[i].value = Number(replaceAll(capitalAmount[i].value,\",\",\"\")) \r\n");
      out.write("\t\tinterestAmount[i].value = Number(replaceAll(interestAmount[i].value,\",\",\"\"));\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tchangeMoneyMark();\r\n");
      out.write("\tvar ischeck = document.getElementsByName(\"ischeck\");\r\n");
      out.write("\tvar isok = false ;\r\n");
      out.write("\tfor(i = 0 ; i < ischeck.length ; i++){\r\n");
      out.write("\t\tif( true == ischeck[i].checked)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tisok = true ;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t}\r\n");
      out.write("\tif(false == isok)\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"無勾選償還資料!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\treturn isok ;\r\n");
      out.write("}\r\n");
      out.write("function changeInterestAmount(form)\r\n");
      out.write("{\r\n");
      out.write("\tchangeMoneyMark();\r\n");
      out.write("\tform.action = \"CPMA0101Calculate\";\r\n");
      out.write("\tform.submit() ;\r\n");
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
