<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
		<!-- �Ȯɥ��� Button �]���S�� SQL -->
			<html:submit styleClass='formcss_rbutton' property='doPrt' value='�C�L����' onclick="javascript:return(checkValue(this.form));"/>
			<html:button  styleClass='formcss_rbutton' property='reset' value='�M�e��' onclick="clearForm(this.form)"/>
		</td>
	</tr>
</table>