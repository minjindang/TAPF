<!--
�{���ت��G���Ŵ��e�v�I���Ӫ�
�{���N���GAIRB13
�{������G0990304
�{���@�̡GCHRIS WU
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>	
	<tr>
		<td class='table_item'>���ź���</td>
		<td class='table_td'>	
			<select name="bondKind" >	
				<option value ="1">�@�뤽��</option>
				<option value ="3">�W�B����</option>
			</select>
		</td>
	<tr>
		<td class='table_item'><font color="red">*</font>�v�I���</td>
		<td class='table_td'>
			<html:text name='Airb1301Form' property='date(repayDateS)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayDateS)", new Integer(0))%>
			~
			<html:text name='Airb1301Form' property='date(repayDateE)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayDateE)", new Integer(1))%>
		</td>
	</tr>
</table>