<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="gov.dnt.tame.util.Converter"%>
<%
	pageContext.setAttribute("UserGroupList", Converter.getCodeListWithSpaceBySql("SELECT  cast(id as varchar(2)) AS valuess,NAME AS label FROM PM0004_DB"));
%>

<logic:notPresent name="blankMap">
	<jsp:useBean id="blankMap" class="java.util.HashMap"/>
</logic:notPresent>

<table class="table_1" width="100%">
	<tr>
		<td class="table_item">�ϥΪ̸s��</td>
		<td class="table_td">
			<html:select name="blankMap" property="GCODE">
				<html:options collection="UserGroupList" property="valuess" labelProperty="label"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class="table_item" width="30%">�ϥΪ̱b��</td>
		<td class="table_td" width="70%">
			<html:text name="blankMap" property="QACCOUNT" size="20" maxlength="20"/>
		</td>
	</tr>
	<tr>
		<td class="table_item">�ϥΪ̦W��</td>
		<td class="table_td">
			<html:text name="blankMap" property="QNAME" size="40" maxlength="40"/> 
		</td>
	</tr>
</table>

<table class="table_1" width="100%">
	<tr>
		<td class="table_function" align="right">
			<html:submit styleClass="formcss_rbutton" property="doQry" value="�d��"/>
			<html:reset  styleClass="formcss_rbutton" property="reset" value="�M��"/>
			<html:submit styleClass="formcss_rbutton" property="goAdd" value="��s�W"/>
		</td>
	</tr>
</table>