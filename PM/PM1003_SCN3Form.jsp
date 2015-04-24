<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="gov.dnt.tame.util.Converter"%>
<%
	pageContext.setAttribute("UserGroupList", Converter.getCodeListWithSpaceBySql("SELECT CONVERT(varchar,ID) AS valuess,NAME AS label FROM PM0004_DB ORDER BY ID"));
%>

<%
	java.util.Map requestBean = new java.util.HashMap();
		requestBean.put("GCODE",request.getParameter("GCODE"));
		requestBean.put("QACCOUNT",request.getParameter("QACCOUNT"));
		requestBean.put("NAME",request.getParameter("NAME"));
		requestBean.put("comeFrom",request.getParameter("comeFrom")==null?"A":request.getParameter("comeFrom"));
		requestBean.put("Page3",request.getParameter("Page3"));
	pageContext.setAttribute("requestBean", requestBean);
%>
<html:hidden name="requestBean" property="GCODE"/>
<html:hidden name="requestBean" property="QACCOUNT"/>
<html:hidden name="requestBean" property="NAME"/>
<html:hidden name="requestBean" property="comeFrom"/>
<html:hidden name="requestBean" property="Page3"/>

<logic:notPresent name="queryMap">
	<jsp:useBean id="queryMap" class="java.util.HashMap"/>
	<%
		queryMap.put("STATUS","0");
	%>
</logic:notPresent>

<html:hidden name="queryMap" property="ID"/>
<table class="table_1" width="100%">
	<tr>
		<td class="table_item" width="20%">姓名</td>
		<td class="table_td" width="30%">
			<html:text name="queryMap" property="NAME" size="20" maxlength="20"/>
		</td>
	</tr>
	<tr>
		<td class="table_item" width="20%">單位</td>
		<td class="table_td" width="30%">
			<html:text name="queryMap" property="DEPT" size="20" maxlength="20"/>
		</td>
	</tr>
	<tr>
		<td class="table_item" width="20%">群組</td>
		<td class="table_td" width="30%">
			<html:select name="queryMap" property="PM0004ID">
				<html:options collection="UserGroupList" property="valuess" labelProperty="label"/>
			</html:select>
		</td>
	</tr>
</table>

<table class="table_function" width="100%">
	<tr>
		<td align="right">
			<html:submit property="doUpd" value="更新" styleClass="formcss_rbutton" onclick="return checkForm(this.form);"/>
			<html:submit property="doQry" value="回清單" styleClass="formcss_rbutton"/>
		</td>
	</tr>
</table>

