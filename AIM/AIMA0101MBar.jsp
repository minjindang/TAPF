<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doUpdIssue' value='��s' onclick="return(checkForm(form));"/>
			<html:submit styleClass='formcss_rbutton' property='doDelIssue' value='�R��'/>
			<html:reset styleClass='formcss_rbutton' property='reset' value='�_��'/>			
			<html:submit styleClass='formcss_rbutton' property='goQryIssue' value='�^�d��'/>
			<html:submit styleClass='formcss_rbutton' property='goAddIssue' value='��s�W'/>
			<html:submit styleClass='formcss_rbutton' property='goDebtList' value='�o����B����'/>
			<html:submit styleClass='formcss_rbutton' property='goTicketList' value='�Ų�����'/>
			<html:submit styleClass='formcss_rbutton' property='goRateList' value='�Q�v����'/>			
		</td>
	</tr>
</table>

<script language="javascript">
alert("�Y�n�i�椽�Ŵ��e�v�I�@�~�A���I��'�o����B����'�C");
</script>