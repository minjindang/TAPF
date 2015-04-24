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
		requestBean.put("Page3",request.getParameter("Page3"));
	pageContext.setAttribute("requestBean", requestBean);
%>
<html:hidden name="requestBean" property="SYSCODE"/>
<html:hidden name="requestBean" property="FUNCODE"/>
<html:hidden name="requestBean" property="QNAME"/>
<html:hidden name="requestBean" property="QPATH"/>
<html:hidden name="requestBean" property="Page3"/>

<logic:notPresent name="queryMap">
	<jsp:useBean id="queryMap" class="java.util.HashMap"/>
</logic:notPresent>

<html:hidden name="queryMap" property="ID"/>
<table class="table_1" width="100%">
	<tr>
		<td class="table_item">系統別</td>
		<td class="table_td">
			<bean:write name="queryMap" property="SYSNAME"/>
		</td>
	</tr>
	<tr>
		<td class="table_item">功能分類</td>
		<td class="table_td">
			<bean:write name="queryMap" property="FUNNAME"/>
		</td>
	</tr>
	<tr>
		<td class="table_item">作業名稱</td>
		<td class="table_td">
			<html:text name="queryMap" property="NAME" size="25" maxlength="25"/>
		</td>
	</tr>
	<tr>
		<td class="table_item">作業代碼</td>
		<td class="table_td">
			<html:text name="queryMap" property="PATH" size="10" maxlength="10"/>
		</td>
	</tr>
	<tr>
		<td class="table_item" width="30%">顯示</td>
		<td class="table_td" width="70%">
			<html:radio name="queryMap" property="STATE" value="Y"/>是
			<html:radio name="queryMap" property="STATE" value="N"/>否
		</td>
	</tr>
	<tr>
		<td class="table_item">備註</td>
		<td class="table_td">
			<html:textarea name="queryMap" property="NOTE" rows="2" cols="80"/>
		</td>
	</tr>
</table>

