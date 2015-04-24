<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<%
	java.util.Map requestBean = new java.util.HashMap();
		requestBean.put("SYSCODE",request.getParameter("SYSCODE"));
		requestBean.put("FUNCODE",request.getParameter("FUNCODE"));
		requestBean.put("QNAME",request.getParameter("QNAME"));
		requestBean.put("QPATH",request.getParameter("QPATH"));
	pageContext.setAttribute("requestBean", requestBean);
%>
<html:hidden name="requestBean" property="SYSCODE"/>
<html:hidden name="requestBean" property="FUNCODE"/>
<html:hidden name="requestBean" property="QNAME"/>
<html:hidden name="requestBean" property="QPATH"/>

<table class="table_1" width="100%">
<tr>
	<td>
		<logic:present name="queryList">		
			<display:table class="table_list" name="queryList" id="row">
				<display:column title="序號" style="width:10%">
					<bean:write name='row' property='ID'/>
				</display:column>
				<display:column title="作業名稱">
					<bean:define id="ID" name="row" property="ID" type="java.lang.Object"/>
					<%
						String myLink = "PM1006_03L?ID="+ID;
							myLink += "&SYSCODE="+request.getParameter("SYSCODE");
							myLink += "&FUNCODE="+request.getParameter("FUNCODE");
							myLink += "&QNAME="+request.getParameter("QNAME");
							myLink += "&QPATH="+request.getParameter("QPATH");
							myLink += "&Page3="+request.getAttribute("Page");
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='NAME'/>
					</A>&nbsp;
				</display:column>
				<display:column title="作業代碼">
					<bean:write name='row' property='PATH'/>&nbsp;
				</display:column>
				<display:column title="顯示">
					<bean:write name='row' property='STATE_C'/>&nbsp;
				</display:column>
			</display:table>
		</logic:present>
	</td>
</tr>
</table>

<table class="table_function" width="100%">
<%=((null == request.getAttribute("HIDDENDATA"))?"":request.getAttribute("HIDDENDATA"))%>
<%
		String PAGEBAR = (String) request.getAttribute("PAGEBAR");
		if(null != PAGEBAR)
		{
%>
	<tr>
		<td align="right">
			<%=PAGEBAR%>
		</td>
	</tr>
<% 
		}
%>
	<tr>
		<td align="right">
<%
	java.util.List list = (java.util.List) request.getAttribute("queryList");
	if(list.size()>0)
	{
%>
			<html:button property="selectAll" value="全選" styleClass="formcss_rbutton" onclick="checkedAll(this.form);" />
			<html:button property="cancelAll" value="全部取消" styleClass="formcss_rbutton" onclick="notCheckedAll(this.form);" />
			<html:submit property="muDel" value="刪除" styleClass="formcss_rbutton" onclick="return confirm('確定要刪除?');"/>
<%
	}
%>
			<html:submit property="goQry" value="回查詢" styleClass="formcss_rbutton"/>
		</td>
	</tr>
</table>