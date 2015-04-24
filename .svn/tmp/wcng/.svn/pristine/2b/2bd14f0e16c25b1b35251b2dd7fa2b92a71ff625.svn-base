<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<%@ page import="gov.dnt.tame.util.Converter"%>
<%
	pageContext.setAttribute("SystemList", Converter.getCodeListWithSpaceBySql("SELECT CONVERT(varchar,ID) AS valuess,NAME AS label FROM PM0001_DB"));
%>

<logic:notPresent name="blankMap">
	<jsp:useBean id="blankMap" class="java.util.HashMap"/>
</logic:notPresent>

<table class="table_1" width="100%">
	<tr>
		<td class="table_item" width="30%">系統別</td>
		<td class="table_td" width="70%">
			<html:select name="blankMap" property="SYSCODE" onchange="changeFun(this.value)">
				<html:options collection="SystemList" property="valuess" labelProperty="label"/>
			</html:select>
			<font color="#FF0000" size="4">*</font>
		</td>
	</tr>
	<tr>
		<td class="table_item">功能分類</td>
		<td class="table_td">
			<html:select name="blankMap" property="FUNCODE">
				<option value="">請選擇...</option>
			</html:select>
			<font color="#FF0000" size="4">*</font>
		</td>
	</tr>
	<tr>
		<td class="table_item" width="30%">作業名稱</td>
		<td class="table_td" width="70%">
			<html:text name="blankMap" property="QNAME" size="20" maxlength="50"/>
		</td>
	</tr>
	<tr>
		<td class="table_item" width="30%">作業代碼</td>
		<td class="table_td" width="70%">
			<html:text name="blankMap" property="QPATH" size="10" maxlength="10"/>
		</td>
	</tr>
</table>

<table class="table_1" width="100%">
	<tr>
		<td class="table_function" align="right">
			<html:submit styleClass="formcss_rbutton" property="doQry" value="查詢"/>
			<html:reset  styleClass="formcss_rbutton" property="reset" value="清除"/>
		</td>
	</tr>
</table>