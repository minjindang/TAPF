<!--
�{���ت��GHAMA03��r
�{���N���GHAMA03
�{������G0950220
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doQry' value='�d��' onclick="return checkForm(this.form);"/>
			<html:button styleClass='formcss_rbutton' property='reset' value='�M��' onclick="clearForm(this.form);"/>
			<html:submit styleClass='formcss_rbutton' property='export' value='�ץX' onclick="return checkForm(this.form);"/>
			<html:submit styleClass='formcss_rbutton' property='import' value='�פJ' onclick="return checkForm2(this.form);"/>
		</td>
	</tr>
</table>
