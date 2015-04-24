package org.apache.jsp.GAM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GAMA0401AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getTotal(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar budgetAmount = 0;\r\n");
      out.write("\tif( form.elements['budgetYn'].checked )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tbudgetAmount = form.elements['bigDecimal(budgetAmount)'].value;\r\n");
      out.write("\t\tbudgetAmount = replaceAll(budgetAmount, \",\" , \"\" );\r\n");
      out.write("\t\tbudgetAmount = Number(budgetAmount);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar auditAmount = 0;\r\n");
      out.write("\tif( form.elements['auditYn'].checked )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tauditAmount = form.elements['bigDecimal(auditAmount)'].value;\r\n");
      out.write("\t\tauditAmount = replaceAll(auditAmount, \",\" , \"\" );\r\n");
      out.write("\t\tauditAmount = Number(auditAmount);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar realAmount = 0;\r\n");
      out.write("\tif( form.elements['realYn'].checked )\r\n");
      out.write("\t{\r\n");
      out.write("\t\trealAmount = form.elements['bigDecimal(realAmount)'].value;\r\n");
      out.write("\t\trealAmount = replaceAll(realAmount, \",\" , \"\" );\r\n");
      out.write("\t\trealAmount = Number(realAmount);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar keepAmount = 0;\r\n");
      out.write("\tif( form.elements['keepYn'].checked )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tkeepAmount = form.elements['bigDecimal(keepAmount)'].value;\r\n");
      out.write("\t\tkeepAmount = replaceAll(keepAmount, \",\" , \"\" );\r\n");
      out.write("\t\tkeepAmount = Number(keepAmount);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar total = document.getElementById('total');\r\n");
      out.write("\tif( total!=null )\r\n");
      out.write("\t\ttotal.innerHTML = addMoneyMask( String( budgetAmount + auditAmount + realAmount + keepAmount) );\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkForm(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar cols = new Array(\"accountYear\",\"budgetCode_options\",\"debtCode_options\",\"dataType_options\");\r\n");
      out.write("\tvar colNames = new Array(\"年度\",\"預算別\",\"債務別\",\"類別\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(\"【\" + colNames[result] + \"】，未輸入!!\");\r\n");
      out.write("\t\tform.focus(cols[result]);\r\n");
      out.write("\t}\r\n");
      out.write("\treturn result < 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function calculate(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar types = new Array(\"budget\",\"audit\",\"real\",\"keep\");\r\n");
      out.write("\tfor(var i = 0 ; i < types.length ; i++)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar amount = form.elements['bigDecimal('+types[i]+'Amount)'].value;\r\n");
      out.write("\t\tamount = replaceAll(amount, \",\" , \"\" );\r\n");
      out.write("\t\tif( isBlank( TrimAll( amount ) ) )\tamount = String(0);\r\n");
      out.write("\r\n");
      out.write("\t\tvar damount = form.elements['bigDecimal('+types[i]+'Damount)'].value;\r\n");
      out.write("\t\tdamount = replaceAll(damount, \",\" , \"\" );\r\n");
      out.write("\t\tif( isBlank( TrimAll( damount ) ) )\tdamount = String(0);\r\n");
      out.write("\r\n");
      out.write("\t\tform.elements['bigDecimal('+types[i]+'Amount)'].value = addMoneyMask( String( amount ) );\r\n");
      out.write("\t\tform.elements['bigDecimal('+types[i]+'Damount)'].value = addMoneyMask( String( damount ) );\r\n");
      out.write("\t\tform.elements['bigDecimal('+types[i]+'Uamount)'].value = addMoneyMask( String( amount - damount ) );\r\n");
      out.write("\t}\r\n");
      out.write("\tform.elements['bigDecimal(auditAmount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realAmount)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepAmount)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(auditDamount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realDamount)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepDamount)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(auditUamount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realUamount)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepUamount)'].value, \",\" , \"\" )))\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function calculate2(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar types = new Array(\"budget\",\"audit\",\"real\",\"keep\");\r\n");
      out.write("\tfor(var i = 0 ; i < types.length ; i++)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar uamount = form.elements['bigDecimal('+types[i]+'Uamount)'].value;\r\n");
      out.write("\t\tuamount = replaceAll(uamount, \",\" , \"\" );\r\n");
      out.write("\t\tif( isBlank( TrimAll( uamount ) ) )\tuamount = String(0);\r\n");
      out.write("\r\n");
      out.write("\t\tvar damount = form.elements['bigDecimal('+types[i]+'Damount)'].value;\r\n");
      out.write("\t\tdamount = replaceAll(damount, \",\" , \"\" );\r\n");
      out.write("\t\tif( isBlank( TrimAll( damount ) ) )\tdamount = String(0);\r\n");
      out.write("\r\n");
      out.write("\t\tform.elements['bigDecimal('+types[i]+'Amount)'].value = addMoneyMask( String( uamount -  damount) );\r\n");
      out.write("\t\tform.elements['bigDecimal('+types[i]+'Damount)'].value = addMoneyMask( String( damount ) );\r\n");
      out.write("\t\tform.elements['bigDecimal('+types[i]+'Uamount)'].value = addMoneyMask( String( uamount ) );\r\n");
      out.write("\t}\r\n");
      out.write("\tform.elements['bigDecimal(auditAmount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realAmount)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepAmount)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(auditDamount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realDamount)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepDamount)'].value, \",\" , \"\" )))\r\n");
      out.write("\tform.elements['bigDecimal(auditUamount)'].value = addMoneyMask(Number(replaceAll(form.elements['bigDecimal(realUamount)'].value, \",\" , \"\" )) + Number(replaceAll(form.elements['bigDecimal(keepUamount)'].value, \",\" , \"\" )))\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("function checkBudget(form)\r\n");
      out.write("{\r\n");
      out.write("\tif(form.budgetYn.checked == true ){\r\n");
      out.write("\t\tform.auditYn.checked =false;\r\n");
      out.write("\t\tform.realYn.checked =false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkAudit(form)\r\n");
      out.write("{\r\n");
      out.write("\tif(form.auditYn.checked == true ){\r\n");
      out.write("\t\tform.budgetYn.checked =false;\r\n");
      out.write("\t\tform.realYn.checked =false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function checkReal(form)\r\n");
      out.write("{\r\n");
      out.write("\tif(form.auditYn.checked == true ){\r\n");
      out.write("\t\tform.budgetYn.checked =false;\r\n");
      out.write("\t\tform.auditYn.checked =false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
