<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='goExcel' value='開啟Excel' onclick="javascript:return(checkValue(this.form));"/>
			<html:reset styleClass='formcss_rbutton' property='reset' value='清畫面'/>
		</td>
	</tr>
</table>
