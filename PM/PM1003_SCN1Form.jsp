<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<%@ page import="gov.dnt.tame.util.Converter"%>
<%
	pageContext.setAttribute("NameGroupList", Converter.getCodeListWithSpaceBySql("SELECT  cast(id as varchar(2)) AS valuess,NAME AS label FROM PM0005_DB"));
	pageContext.setAttribute("DeptGroupList", Converter.getCodeListWithSpaceBySql("SELECT  cast(id as varchar(2)) AS valuess,Dept AS label FROM PM0005_DB"));
%>
<logic:notPresent name="blankMap">
	<jsp:useBean id="blankMap" class="java.util.HashMap"/>
</logic:notPresent>

<table class="table_1" width="100%">
<!-- 
	<tr>
		<td class="table_item" width="30%">單位</td>
		<td class="table_td" width="70%">
			<html:select name="blankMap" property="">
				<html:options collection="DeptGroupList" property="valuess" labelProperty="label"/>
			</html:select>
		</td>
	</tr>
 -->
	<tr>
		<td class="table_item">使用者</td>
		<td class="table_td">
			<html:select name="blankMap" property="GCODE">
				<html:options collection="NameGroupList" property="valuess" labelProperty="label"/>
			</html:select>
		</td>
	</tr>
<!-- 
	<tr>
		<td colspan="2">
			<logic:present name="queryList">		
				<display:table class="table_list" name="queryList" id="row">
					<display:column title="群組名稱">
						<bean:define id="ID" name="row" property="ID" type="java.lang.Object"/>
						<html:multibox property="GID" value="<%=ID.toString()%>"/>
						<bean:write name='row' property='GroupName'/>
					</display:column>
				</display:table>
			</logic:present>
		</td>
	</tr>
-->
</table>
<table class="table_1" width="100%">
	<tr>
		<td class="table_function" align="right" colspan="2">
			<html:submit styleClass="formcss_rbutton" property="doQry" value="查詢" onclick="return checkForm(this.form);"/>
		</td>
	</tr>
</table>