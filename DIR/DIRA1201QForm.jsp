<!--
�{���ت��G�����F�������٥��I������
�{���N���GAIRB01
�{������G0950317
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color='red'>*</font>�~��:</td>
		<td class='table_td'>
			<html:text name='Dira1201Form' property='accountYear' size='3' maxlength='3'/>
			
		</td>
	<tr>
    <td class='table_item'>�p���Ǥ�:</td>
		<td class='table_td'>
			<html:text name='Dira1201Form' property='date(baseDate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(baseDate)",new Integer(0))%>	
		</td>
	</tr>
</table>