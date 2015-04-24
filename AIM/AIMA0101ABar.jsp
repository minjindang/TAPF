<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doAddIssue' value='新增' onclick="return checkForm(form);" />
			<html:reset  styleClass='formcss_rbutton' property='reset' value='清除'/>
			<html:submit styleClass='formcss_rbutton' property='goQryIssue' value='到查詢'/>
		</td>
	</tr>
</table>

<script language="javascript">
alert("若要進行公債提前償付作業，請先點選'到查詢'，並查詢該公債期別。");
</script>