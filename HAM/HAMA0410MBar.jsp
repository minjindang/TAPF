<!--
程式目的：歸扣借資料維護-資料匯入修正
程式代號：HAMA0409
程式日期：0991018
程式作者：Chris Wu
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
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
		alert('檔案副檔名限定為.xls');
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
			<html:submit styleClass='formcss_rbutton' property='doExcelImport' value='匯入資料' onclick="return checkForm(this.form);"/>
		</td>
	</tr>
</table>
