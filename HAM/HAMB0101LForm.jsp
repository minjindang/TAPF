<!-- HAMB0101LFrom.jsp
�{���ت��GHAMB01��r
�{���N���GHAMB01
�{������G0950220
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'>�O�b�~�� </td>
		<td class='table_td' >
			<bean:write name='Hamb0101Form' property='allYear'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���t�~��</td>
		<td class='table_td'>
			<bean:write name='Hamb0101Form' property='allMonth'/>
			<html:hidden name='Hamb0101Form' property='isOk'/>
		</td>
	</tr>
</table>

