<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doUpdDebt' value='��s' onclick="return(checkForm(form));"/>
			<html:submit styleClass='formcss_rbutton' property='doDelDebt' value='�R��'/>
			<html:reset styleClass='formcss_rbutton' property='reset' value='�_��'/>
			<html:submit styleClass='formcss_rbutton' property='goDebtList' value='�^�M��'/>
			<html:submit styleClass='formcss_rbutton' property='goAddDebt' value='����ӷs�W'/>
			<html:submit styleClass='formcss_rbutton' property='goAdvance' value='�촣�e�v�I'/>
		</td>
	</tr>
</table>
