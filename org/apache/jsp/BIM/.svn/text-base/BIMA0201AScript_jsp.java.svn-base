package org.apache.jsp.BIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.dnt.tame.util.DateUtil;
import java.util.Date;

public final class BIMA0201AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-logic.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_empty_property_name;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_logic_empty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_logic_empty_property_name.release();
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

      out.write("<!-- BIMA0201AScript.jsp\r\n");
      out.write("程式目的：BIMA02\r\n");
      out.write("程式代號：BIMA02\r\n");
      out.write("程式日期：0950223\r\n");
      out.write("程式作者：Eric.Chen\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("修改作者　　修改日期　　　修改目的\r\n");
      out.write("--------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("function doBodyOnLoad(document)\r\n");
      out.write("{\r\n");
      out.write("\t");
      //  logic:empty
      org.apache.struts.taglib.logic.EmptyTag _jspx_th_logic_empty_0 = (org.apache.struts.taglib.logic.EmptyTag) _jspx_tagPool_logic_empty_property_name.get(org.apache.struts.taglib.logic.EmptyTag.class);
      _jspx_th_logic_empty_0.setPageContext(_jspx_page_context);
      _jspx_th_logic_empty_0.setParent(null);
      _jspx_th_logic_empty_0.setName("Bima0201Form");
      _jspx_th_logic_empty_0.setProperty("repayDate");
      int _jspx_eval_logic_empty_0 = _jspx_th_logic_empty_0.doStartTag();
      if (_jspx_eval_logic_empty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  \t\tdocument.MainForm.elements['date(repayDate)'].value =");
out.println("'"+DateUtil.date2ROCStr(new Date())+"'");
          out.write(";\r\n");
          out.write("  \t");
          int evalDoAfterBody = _jspx_th_logic_empty_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_logic_empty_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_logic_empty_property_name.reuse(_jspx_th_logic_empty_0);
      out.write("\r\n");
      out.write("  \tdocument.MainForm.elements['date(modDate)'].value =");
out.println("'"+DateUtil.date2ROCStr(new Date())+"'");
      out.write(";\r\n");
      out.write("  \t//document.MainForm.elements['date(createDate)'].value =");
out.println("'"+DateUtil.date2ROCStr(new Date())+"'");
      out.write(";\r\n");
      out.write("}\r\n");
      out.write("function checkValue(form)\r\n");
      out.write("{\r\n");
      out.write("\tvar isValid = true;\r\n");
      out.write("    var sError = \"\";\r\n");
      out.write("\tif (\"\" == form.issueId.value)\r\n");
      out.write("    {\r\n");
      out.write("    \tisValid = false;\r\n");
      out.write("\t\tsError += \"\\n\";\r\n");
      out.write("        sError += \"原始發行期別不可空白!!\";\r\n");
      out.write("    }\r\n");
      out.write("    if (false == isValid)\r\n");
      out.write("    {\r\n");
      out.write("    \talert(sError);\r\n");
      out.write("    }\r\n");
      out.write("\t\treturn isValid;\r\n");
      out.write("}\r\n");
      out.write("function changeAmount(form){\r\n");
      out.write("\tif(form.buyStatus.value == \"0\")\r\n");
      out.write("\t\tform.elements['bigDecimal(buyAmount)'].value = 0;\r\n");
      out.write("}\r\n");
      out.write("function getIssue(form){\r\n");
      out.write("\tif(form.issueId.value != \"\" )\r\n");
      out.write("\t\tdoAction('BIMA0204C')\r\n");
      out.write("}\r\n");
      out.write("function setIssue2(form)\r\n");
      out.write("{\r\n");
      out.write("\tif(\"\" != form.elements['bigDecimal(balanceCapitalAmount)'].value && \"\" != form.elements['bigDecimal(capitalAmount)'].value)\r\n");
      out.write("\t{\r\n");
      out.write("\t\t//document.getElementById(\"issue2\").innerHTML = addMoneyMask(\r\n");
      out.write("\t\t//Number(replaceAll(form.elements['bigDecimal(issueAmount)'].value,\",\",\"\"))\r\n");
      out.write("\t\t//- Number(replaceAll(form.elements['bigDecimal(balanceCapitalAmount)'].value,\",\",\"\")) );\r\n");
      out.write("\t}\t\r\n");
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
