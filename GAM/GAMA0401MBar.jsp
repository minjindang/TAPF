<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doUpd' value='更新'/>
			<html:submit styleClass='formcss_rbutton' property='doDel' value='刪除'/>
			<html:reset  styleClass='formcss_rbutton' property='reset' value='復原'/>
			<html:submit styleClass='formcss_rbutton' property='doQry' value='回清單'/>
		</td>
	</tr>
</table>
