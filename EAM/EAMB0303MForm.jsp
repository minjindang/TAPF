<!--
�{���ت��GEAMA02��r
�{���N���GEAMA02
�{������G0950301
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<html:hidden name="Eama0202Form" property="accountPhase.id"/>
<html:hidden name="Eama0202Form" property="id"/>
			<html:hidden name="Eama0202Form" property="accountCode.id"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�|�p��إN��</td>
		<td class='table_td'>
			<bean:write name='Eama0202Form' property="accountCode.accountCode" ignore="true" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>�|�p��ئW��</td>
		<td class='table_td'>
			<bean:write name='Eama0202Form' property="accountCode.accountName" ignore="true"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>��/�U</td>
		<td class='table_td'>
			<html:radio name="Eama0202Form" property="accountType" value="D"/>��
			<html:radio name="Eama0202Form" property="accountType" value="C"/>�U
		</td>
	</tr>
	<tr>
		<td class='table_item'>���B</td>
		<td class='table_td'><html:text name="Eamb0301" property="BigDecimal(accountAmount)"/></td>
	</tr>
</table>