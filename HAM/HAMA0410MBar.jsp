<!--
�{���ت��G�k���ɸ�ƺ��@-��ƶפJ�ץ�
�{���N���GHAMA0409
�{������G0991018
�{���@�̡GChris Wu
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->
<script language="javascript">
<!--
function doBodyOnLoad(document)
{
		//do nothing
}
function checkForm(form){
	var isImport = true;
	var filePath = form.filePath.value;
	if(filePath.indexOf('.xls') < 0){
		isImport = false;
		alert('�ɮװ��ɦW���w��.xls');
	}
	return isImport;
}
-->
</script>
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doExcelImport' value='�פJ���' onclick="return checkForm(this.form);"/>
		</td>
	</tr>
</table>
