<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<%@ page import="gov.dnt.tame.util.Converter"%>
<%
	pageContext.setAttribute("UserGroupList", Converter.getCodeListWithSpaceBySql("SELECT CONVERT(varchar,ID) AS valuess,NAME AS label FROM PM0004_DB"));
%>

<logic:notPresent name="blankMap">
	<jsp:useBean id="blankMap" class="java.util.HashMap"/>
</logic:notPresent>

<table class="table_1" width="100%">
	<tr>
		<td class="table_item" width="30%">群組別</td>
		<td class="table_td" width="70%">
			<html:select name="blankMap" property="roleid">
				<html:options collection="UserGroupList" property="valuess" labelProperty="label"/>
			</html:select>
			<font color="#FF0000" size="4">*</font>
		</td>
	</tr>
</table>

<table class="table_1" width="100%">
	<tr>
		<td class="table_function" align="right">
			<html:submit styleClass="formcss_rbutton" property="doQry" value="查詢" onclick="return checkForm(this.form);"/>
			<html:reset  styleClass="formcss_rbutton" property="reset" value="清除"/>
		</td>
	</tr>
</table>