package org.apache.jsp.AIM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AIMA0104LForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_hidden_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_format_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_table_name_id_class;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_display_column_title;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_property_name_id_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_hidden_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_format_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_table_name_id_class = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_display_column_title = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_type_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_hidden_property_name_nobody.release();
    _jspx_tagPool_bean_write_property_name_nobody.release();
    _jspx_tagPool_bean_write_property_name_format_nobody.release();
    _jspx_tagPool_display_table_name_id_class.release();
    _jspx_tagPool_display_column_title.release();
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
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_html_hidden_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<table class='table_1' width='100%'>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>公債代號</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_bean_write_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>發行日期</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_bean_write_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>發行金額</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_bean_write_2(_jspx_page_context))
        return;
      out.write(" 元\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan='6'>\r\n");
      out.write("\t\t\t");
      //  display:table
      org.displaytag.tags.TableTag _jspx_th_display_table_0 = (org.displaytag.tags.TableTag) _jspx_tagPool_display_table_name_id_class.get(org.displaytag.tags.TableTag.class);
      _jspx_th_display_table_0.setPageContext(_jspx_page_context);
      _jspx_th_display_table_0.setParent(null);
      _jspx_th_display_table_0.setClass("table_list");
      _jspx_th_display_table_0.setName(new String("collection"));
      _jspx_th_display_table_0.setUid("row");
      int _jspx_eval_display_table_0 = _jspx_th_display_table_0.doStartTag();
      if (_jspx_eval_display_table_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        java.lang.Object row = null;
        java.lang.Integer row_rowNum = null;
        if (_jspx_eval_display_table_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_table_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_table_0.doInitBody();
        }
        row = (java.lang.Object) _jspx_page_context.findAttribute("row");
        row_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("row_rowNum");
        do {
          out.write("\r\n");
          out.write("\t\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_0 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_0.setPageContext(_jspx_page_context);
          _jspx_th_display_column_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_0.setTitle("實施日期起");
          int _jspx_eval_display_column_0 = _jspx_th_display_column_0.doStartTag();
          if (_jspx_eval_display_column_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_0.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t");
              //  bean:define
              org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
              _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
              _jspx_th_bean_define_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_0);
              _jspx_th_bean_define_0.setId("issueMainId");
              _jspx_th_bean_define_0.setName("Aima0104MForm");
              _jspx_th_bean_define_0.setProperty("issueMainId");
              _jspx_th_bean_define_0.setType("java.lang.Integer");
              int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
              if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
              java.lang.Integer issueMainId = null;
              issueMainId = (java.lang.Integer) _jspx_page_context.findAttribute("issueMainId");
              out.write("\r\n");
              out.write("\t\t\t\t\t");
              //  bean:define
              org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
              _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
              _jspx_th_bean_define_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_0);
              _jspx_th_bean_define_1.setId("seqNo");
              _jspx_th_bean_define_1.setName("row");
              _jspx_th_bean_define_1.setProperty("seqNo");
              _jspx_th_bean_define_1.setType("java.lang.Integer");
              int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
              if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_bean_define_type_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
              java.lang.Integer seqNo = null;
              seqNo = (java.lang.Integer) _jspx_page_context.findAttribute("seqNo");
              out.write("\r\n");
              out.write("\t\t\t\t");

					String	myLink	=	"AIMA0123?";
					myLink	+= "issueMainId=" + issueMainId;
					myLink += "&seqNo=" + seqNo;
				
              out.write("\r\n");
              out.write("\t\t\t\t<A href=\"");
              out.print(myLink);
              out.write("\">\r\n");
              out.write("\t\t\t\t\t");

					tw.gov.nta.sql.debt.DebtRateDet tDebtRateDet = (tw.gov.nta.sql.debt.DebtRateDet)row;
					if(tDebtRateDet != null && tDebtRateDet.getEffectiveDate() != null)
						//out.print(new java.util.Date(tDebtRateDet.getEffectiveDate().getTime()).toString().substring(0,10));
						out.print(gov.dnt.tame.util.DateUtil.date2ROCStr(tDebtRateDet.getEffectiveDate(),"yyy/MM/dd"));
					
              out.write("\r\n");
              out.write("\t\t\t\t</A>\r\n");
              out.write("\t\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_0);
          out.write("\r\n");
          out.write("\t\t\t\t");
          //  display:column
          org.displaytag.tags.ColumnTag _jspx_th_display_column_1 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
          _jspx_th_display_column_1.setPageContext(_jspx_page_context);
          _jspx_th_display_column_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
          _jspx_th_display_column_1.setTitle("實施日期迄");
          int _jspx_eval_display_column_1 = _jspx_th_display_column_1.doStartTag();
          if (_jspx_eval_display_column_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_display_column_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_display_column_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_display_column_1.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t");

					tw.gov.nta.sql.debt.DebtRateDet tDebtRateDet = (tw.gov.nta.sql.debt.DebtRateDet)row;
					if(tDebtRateDet != null && tDebtRateDet.getSuspendDate() != null)
						//out.print(new gov.dnt.tame.util.DateUtil.date2ROCStr(new java.util.Date(tDebtRateDet.getSuspendDate().getTime()).toString().substring(0,10)));
						out.print(gov.dnt.tame.util.DateUtil.date2ROCStr(tDebtRateDet.getSuspendDate(),"yyy/MM/dd"));
					
              out.write("\r\n");
              out.write("\t\t\t\t");
              int evalDoAfterBody = _jspx_th_display_column_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_display_column_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_display_column_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_1);
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_display_column_2(_jspx_th_display_table_0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_display_table_0.doAfterBody();
          row = (java.lang.Object) _jspx_page_context.findAttribute("row");
          row_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("row_rowNum");
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_table_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_display_table_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_display_table_name_id_class.reuse(_jspx_th_display_table_0);
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
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

  private boolean _jspx_meth_html_hidden_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_0.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_0.setParent(null);
    _jspx_th_html_hidden_0.setName("Aima0104MForm");
    _jspx_th_html_hidden_0.setProperty("issueMainId");
    int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
    if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_property_name_nobody.reuse(_jspx_th_html_hidden_0);
    return false;
  }

  private boolean _jspx_meth_bean_write_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_0.setParent(null);
    _jspx_th_bean_write_0.setName("Aima0104MForm");
    _jspx_th_bean_write_0.setProperty("issueSerial");
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_0);
    return false;
  }

  private boolean _jspx_meth_bean_write_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_1.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_1.setParent(null);
    _jspx_th_bean_write_1.setName("Aima0104MForm");
    _jspx_th_bean_write_1.setProperty("DateFormat(issueDate)");
    int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
    if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_1);
    return false;
  }

  private boolean _jspx_meth_bean_write_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_2 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_format_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_2.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_2.setParent(null);
    _jspx_th_bean_write_2.setName("Aima0104MForm");
    _jspx_th_bean_write_2.setProperty("BigDecimal(issueAmount)");
    _jspx_th_bean_write_2.setFormat("#,###");
    int _jspx_eval_bean_write_2 = _jspx_th_bean_write_2.doStartTag();
    if (_jspx_th_bean_write_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_format_nobody.reuse(_jspx_th_bean_write_2);
    return false;
  }

  private boolean _jspx_meth_display_column_2(javax.servlet.jsp.tagext.JspTag _jspx_th_display_table_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_column_2 = (org.displaytag.tags.ColumnTag) _jspx_tagPool_display_column_title.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_column_2.setPageContext(_jspx_page_context);
    _jspx_th_display_column_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_table_0);
    _jspx_th_display_column_2.setTitle("利率％");
    int _jspx_eval_display_column_2 = _jspx_th_display_column_2.doStartTag();
    if (_jspx_eval_display_column_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_display_column_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_display_column_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_display_column_2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_bean_write_3(_jspx_th_display_column_2, _jspx_page_context))
          return true;
        out.write("%\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_display_column_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_display_column_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_display_column_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_display_column_title.reuse(_jspx_th_display_column_2);
    return false;
  }

  private boolean _jspx_meth_bean_write_3(javax.servlet.jsp.tagext.JspTag _jspx_th_display_column_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_3 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_format_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_3.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_column_2);
    _jspx_th_bean_write_3.setName("row");
    _jspx_th_bean_write_3.setProperty("debtRate");
    _jspx_th_bean_write_3.setFormat("0.000");
    int _jspx_eval_bean_write_3 = _jspx_th_bean_write_3.doStartTag();
    if (_jspx_th_bean_write_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_format_nobody.reuse(_jspx_th_bean_write_3);
    return false;
  }
}
