<!--
�{���ت��G�����n���Ũ��٥��I��������I�l�B����`��
�{���N���GAIRC06
�{������G0950227
�{���@�̡GJackDu
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�Ũ�N��:</td>
		<td class='table_td'>
			<html:HIDDEN name='AIRC0601Form' property='issue_serial' size='5' maxlength='5'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�~��:</td>
		<td class='table_td'>
			<html:text name='AIRC0601Form' property='date(limit_date)' size='5' maxlength='5'/>
		</td>
	</tr>
</table>