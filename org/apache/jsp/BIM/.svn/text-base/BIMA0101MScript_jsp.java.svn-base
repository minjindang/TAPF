package org.apache.jsp.BIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BIMA0101MScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_property_name_id_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_bean_define_type_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_bean_define_type_property_name_id_nobody.release();
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
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_0.setParent(null);
      _jspx_th_bean_define_0.setId("issueDate");
      _jspx_th_bean_define_0.setName("Bima0101Form");
      _jspx_th_bean_define_0.setProperty("date(issueDate)");
      _jspx_th_bean_define_0.setType("java.lang.String");
      int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
      if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
      java.lang.String issueDate = null;
      issueDate = (java.lang.String) _jspx_page_context.findAttribute("issueDate");
      out.write('\r');
      out.write('\n');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_1.setParent(null);
      _jspx_th_bean_define_1.setId("dueDate");
      _jspx_th_bean_define_1.setName("Bima0101Form");
      _jspx_th_bean_define_1.setProperty("date(dueDate)");
      _jspx_th_bean_define_1.setType("java.lang.String");
      int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
      if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
      java.lang.String dueDate = null;
      dueDate = (java.lang.String) _jspx_page_context.findAttribute("dueDate");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\tvar oNumberMask = new Mask(\"0.###\", \"number\");\r\n");
      out.write("\tvar moneyCols = new Array(\"bigDecimal(averageRate)\",\"bigDecimal(chargeRate)\");\r\n");
      out.write("\tfor(var i = 0 ; i < moneyCols.length ; i++)\r\n");
      out.write("\t{\r\n");
      out.write("\t\toNumberMask.attach(document.MainForm.elements[moneyCols[i]]);\r\n");
      out.write("\t\tdocument.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);\r\n");
      out.write("\t}\r\n");
      out.write("  \t/*var toDay = new Date();\r\n");
      out.write("\tvar Day=(toDay.getYear()-1911);\r\n");
      out.write("\tif (Day<100)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tDay=\"0\"+(toDay.getYear()-1911);\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\tDay =(toDay.getYear()-1911);\r\n");
      out.write("\t}\r\n");
      out.write("\tif ((toDay.getMonth()+1)<10)\r\n");
      out.write("\t\tDay += \"0\"+(toDay.getMonth()+1);\r\n");
      out.write("\telse Day+=toDay.getMonth()+1;\r\n");
      out.write("\tif (toDay.getDate()<10)\r\n");
      out.write("\t\tDay += \"0\"+toDay.getDate();\r\n");
      out.write("\telse Day +=toDay.getDate();\r\n");
      out.write("\r\n");
      out.write("\tdocument.MainForm.elements['date(modDate)'].value = Day;\r\n");
      out.write("\tvar issueDate = '");
      out.print(issueDate);
      out.write("';\r\n");
      out.write("\tvar dueDate = '");
      out.print(dueDate);
      out.write("';\r\n");
      out.write("\tdocument.MainForm.days.value = daycount(issueDate,dueDate,\"C\");\r\n");
      out.write("\tdocument.getElementById(\"days\").innerHTML = daycount(issueDate,dueDate,\"C\");*/\r\n");
      out.write("}\r\n");
      out.write("function checkCapitalAmount()\r\n");
      out.write("{\r\n");
      out.write("  \tvar\tcurrform\t=\tdocument.MainForm;\r\n");
      out.write("\tvar\texpectAmount\t\t=\tcurrform.elements['bigDecimal(expectAmount)'].value;\r\n");
      out.write("\tvar\tcapitalAmount \t=\tcurrform.elements['bigDecimal(capitalAmount)'].value\r\n");
      out.write("\tcurrform.elements['bigDecimal(issueAmount)'].value = expectAmount;\r\n");
      out.write("\tdocument.getElementById(\"issueAmount\").innerHTML = addMoneyMask(expectAmount) ;\r\n");
      out.write("\tif(parseInt(capitalAmount)>parseInt(expectAmount))\r\n");
      out.write("\t{\r\n");
      out.write("\t\tcurrform.elements['bigDecimal(capitalAmount)'].value = \"\";\r\n");
      out.write("\t\talert(\"實收額不得大於發行額\");\r\n");
      out.write("\t}\t\r\n");
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
      out.write("    else\r\n");
      out.write("    {\r\n");
      out.write("    \tvar cashDueDate = parseInt(issueDate.substr(0, 3),10)+5;\r\n");
      out.write("    \tif(cashDueDate<100)\r\n");
      out.write("    \t\tcashDueDate = \"0\"+cashDueDate\r\n");
      out.write("    \tcurrform.elements['date(cashDueDate)'].value = cashDueDate+dueDate.substr(3, 4);\r\n");
      out.write("    }\r\n");
      out.write("\tif (!(CheckValidDate(dueDate)))\r\n");
      out.write("    {\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("   \telse if (issueDate !=\"\" && dueDate != \"\")\r\n");
      out.write("   \t{\r\n");
      out.write("\t\tcurrform.days.value = daycount(issueDate,dueDate,\"C\");\r\n");
      out.write("\t\tdocument.getElementById(\"dayid\").innerHTML = daycount(issueDate,dueDate,\"C\") ;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar\tcols = new Array(\r\n");
      out.write("\t\t\"accountYear\",\"issueSerial\",\"budgetCode_options\",\"debtCode_options\",\"date(issueDate)\",\r\n");
      out.write("\t\t\"date(dueDate)\",\"bigDecimal(expectAmount)\",\"bigDecimal(capitalAmount)\",\"bigDecimal(averageRate)\",\"bigDecimal(chargeRate)\" );\r\n");
      out.write("\tvar colNames = new Array(\r\n");
      out.write("\t\t\"發行年度\",\"發行期別\",\"預算別\",\"債務別\",\"發行日期\",\r\n");
      out.write("\t\t\"到期日期\",\"發行額\",\"實收額\",\"貼現率\",\"手續費比例\");\r\n");
      out.write("\tvar result = checkFormEmpty(form, cols);\r\n");
      out.write("\tif(result >= 0){\r\n");
      out.write("\t\talert(\"【\" + colNames[result] + \"】未輸入!!\");\r\n");
      out.write("\t}\r\n");
      out.write("\treturn result < 0;\r\n");
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
