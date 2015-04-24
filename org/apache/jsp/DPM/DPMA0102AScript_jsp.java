package org.apache.jsp.DPM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DPMA0102AScript_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/taglibs/struts-bean.tld");
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

      out.write("\r\n");
      out.write("\r\n");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_0.setParent(null);
      _jspx_th_bean_define_0.setId("issueDate");
      _jspx_th_bean_define_0.setName("Dpma0101Form");
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
      _jspx_th_bean_define_1.setName("Dpma0101Form");
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
      out.write("{\t\r\n");
      out.write("\tvar capitalAmount = document.getElementsByName(\"capitalAmountPay\");\r\n");
      out.write("\tvar interestAmount = document.getElementsByName(\"interestAmountPay\");\r\n");
      out.write("\tvar totalAmount = document.getElementsByName(\"bigDecimal(totalAmount)\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function countTotal(num)\r\n");
      out.write("{\r\n");
      out.write("\tvar currform = document.MainForm;\r\n");
      out.write("\tvar capitalAmount = replaceAll(currform.elements['debtPlanDet['+num+'].capitalAmount'].value,\",\",\"\");\r\n");
      out.write("\tvar interestAmount = replaceAll(currform.elements['debtPlanDet['+num+'].interestAmount'].value,\",\",\"\");\r\n");
      out.write("\r\n");
      out.write("\tif(isNaN(parseFloat(capitalAmount)))\r\n");
      out.write("\t\tcapitalAmount = \"0\";\r\n");
      out.write("\tif(isNaN(parseFloat(interestAmount)))\r\n");
      out.write("\t\tinterestAmount = \"0\";\r\n");
      out.write("\r\n");
      out.write("\tif( isValidAmount(capitalAmount) && isValidAmount(interestAmount) ){\r\n");
      out.write("\t\tcurrform.elements['debtPlanDet['+num+'].totalCount'].value = addMoneyMask(parseFloat(capitalAmount)+parseFloat(interestAmount));\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tcurrform.elements['debtPlanDet['+num+'].totalCount'].value = 0;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("//回復沒有千分位才可做確認 否則會有 BeanUtil 的問題\r\n");
      out.write("function changeMoneyMark()\r\n");
      out.write("{\r\n");
      out.write("\tvar capitalAmount = document.getElementsByName(\"capitalAmountPay\");\r\n");
      out.write("\tvar interestAmount = document.getElementsByName(\"interestAmountPay\");\r\n");
      out.write("\tfor(i = 0 ; i < capitalAmount.length ; i++){\r\n");
      out.write("\t\tcapitalAmount[i].value = Number(replaceAll(capitalAmount[i].value,\",\",\"\")); \r\n");
      out.write("\t\tinterestAmount[i].value = Number(replaceAll(interestAmount[i].value,\",\",\"\"));\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function changeInterestAmount(form)\r\n");
      out.write("{\r\n");
      out.write("\tchangeMoneyMark();\r\n");
      out.write("\tform.action = \"DPMA0101Calculate\";\r\n");
      out.write("\tform.submit() ;\r\n");
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
