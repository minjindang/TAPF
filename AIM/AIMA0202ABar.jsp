<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doAddDebt' value='新增' onclick="return(addCheck(this.form));"/>
			<html:reset  styleClass='formcss_rbutton' property='reset' value='清除'/>
			<html:submit styleClass='formcss_rbutton' property='goDebtList' value='回清單'/>
		</td>
	</tr>
</table>
