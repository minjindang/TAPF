<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doDetQry' value='���O����'/>
			<html:submit styleClass='formcss_rbutton' property='goQry' value='�^�d��'/>
			<html:submit styleClass='formcss_rbutton' property='doQry' value='�^�M��'/>
			<html:submit styleClass='formcss_rbutton' property='doUpd' value='��s' onclick="javascript:return(checkValue(this.form));"/>
			<html:submit styleClass='formcss_rbutton' property='doDel' value='�R��'/>
			<html:submit styleClass='formcss_rbutton' property='goAdd' value='��s�W'/>
			<html:reset  styleClass='formcss_rbutton' property='reset' value='�_��'/>
		</td>
	</tr>
</table>
