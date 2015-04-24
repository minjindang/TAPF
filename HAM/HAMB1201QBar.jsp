<!--
程式目的：HAMB12文字
程式代號：HAMB12
程式日期：1000929
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doQry2' value='查詢' onclick="return checkForm(this.form);"/>
			<html:submit styleClass='formcss_rbutton' property='doQry' value='維護' onclick="return checkForm(this.form);"/>
			<html:submit styleClass='formcss_rbutton' property='makeDisk' value='製作磁片' onclick="checkForm(this.form);"/>
			<html:button styleClass='formcss_rbutton' property='doClear' value='清除' onclick="clearForm(this.form)"/>
			<html:submit styleClass='formcss_rbutton' property='toImport' value='到匯入撥付金額' onclick=""/>
			<html:submit styleClass='formcss_rbutton' property='toLastFound' value='到匯入上年度受分配金額' onclick=""/>
		</td>
	</tr>
</table>
