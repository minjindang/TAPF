<!-- GAMA0905MBar.jsp
�{���ت��GGAMA09
�{���N���GGAMA09
�{������G0980409
�{���@�̡GChris
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doUpdCap' value='��s'/>
			<html:reset styleClass='formcss_rbutton' property='reset' value='�_��'/>
			<logic:equal value=""  scope="" parameter="showDate">
				<html:submit styleClass='formcss_rbutton' property='doDelCap' value='�R��'/>
			</logic:equal>
			<html:submit styleClass='formcss_rbutton' property='goUp2' value='�^�W��'/>
		</td>
	</tr>
</table>