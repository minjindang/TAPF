<!--
程式目的：歸扣借資料維護-資料匯入修正
程式代號：HAMA0409
程式日期：0991018
程式作者：Chris Wu
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:button styleClass='formcss_rbutton' property='reset' value='清除' onclick="clearForm(this.form);"/>
			<html:submit styleClass='formcss_rbutton' property='doImport' value='匯入' onclick="return checkForm2(this.form);"/>
		</td>
	</tr>
</table>
