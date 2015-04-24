<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doPrt' value='開啟Excel' onclick="return checkForm(this.form);"/>
			<html:button  styleClass='formcss_rbutton' property='reset' value='清畫面' onclick="clearForm(this.form)"/>
		</td>
	</tr>
</table>