package org.apache.jsp.GAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GAMA0501AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(7);
    _jspx_dependants.add("/common/taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-tiles.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/displaytag-12.tld");
    _jspx_dependants.add("/WEB-INF/taglibs/c.tld");
  }

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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\t//calculate(document.MainForm);如果沒按公式規定更新值,跑此會看不到更新後最新的資料\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkForm(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\"accountYear\",\"budgetCode\",\"debtCode\",\"boundCode\",\"inoutType\");\r\n");
      out.write("\tvar colNames = new Array(\"年度\",\"預算別\",\"債務別\",\"自償否\",\"內外債別\");\r\n");
      out.write("\tfor (var k = 0 ; k < cols.length ; k++){\r\n");
      out.write("\t\tif (form.elements[cols[k]].value == \"\"){\r\n");
      out.write("\t\t\talert(\"【\"+colNames[k]+\"】未輸入!!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tif (isNaN(form.accountYear.value))\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"請輸入數字\");\r\n");
      out.write("\t\tform.accountYear.value=\"\";\r\n");
      out.write("\t\tform.accountYear.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function calculate(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar types = new Array(\"budget\",\"audit\",\"real\",\"keep\");\r\n");
      out.write("\tfor(var i = 0 ; i < types.length ; i++)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar cols = new Array(\"Bamount1\",\"Pamount1\",\"Ramount1\",\"Uamount1\",\"Bamount2\",\"Pamount2\",\"Ramount2\",\"Uamount2\");\r\n");
      out.write("\t\tfor(var j = 0 ; j < cols.length ; j++)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar amount = form.elements['bigDecimal('+types[i]+cols[j]+')'].value;\r\n");
      out.write("\t\t\tamount = replaceAll(amount, \",\" , \"\" );\r\n");
      out.write("\t\t\tif( isBlank( TrimAll( amount ) ) )\tamount = String(0);\r\n");
      out.write("\t\t\tform.elements['bigDecimal('+types[i]+cols[j]+')'].value = addMoneyMask( String( amount ) );\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tform.elements['bigDecimal(auditBamount1)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realBamount1)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepBamount1)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(auditUamount1)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realUamount1)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepUamount1)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(auditPamount1)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realPamount1)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepPamount1)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(auditRamount1)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realRamount1)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepRamount1)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(auditBamount2)'].value =addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realBamount2)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepBamount2)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(auditUamount2)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realUamount2)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepUamount2)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(auditPamount2)'].value =addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realPamount2)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepPamount2)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(auditRamount2)'].value =addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realRamount2)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepRamount2)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(realBuamount1)'].value =addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realBamount1)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(realUamount1)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(realBuamount2)'].value =addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realBamount2)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(realUamount2)'].value, \",\" , \"\" )))\t\r\n");
      out.write("}\r\n");
      out.write("function change(form,key)\r\n");
      out.write("{\r\n");
      out.write("\tif(form.accountYear.value != \"\" && form.budgetCode.value != \"\" && form.debtCode.value != \"\" && form.boundCode.value != \"\" && form.inoutType.value != \"\"){\r\n");
      out.write("\t\tkey = \"GAMA0500\"+key\r\n");
      out.write("\t\tdoAction(key);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
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
