<!--
程式目的：HAMB07文字
程式代號：HAMB07
程式日期：0950223
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
			<!-- <html:submit styleClass='formcss_rbutton' property='doUpdReceive' value='接收回條'/> -->
			<html:submit styleClass='formcss_rbutton' property='doQry' value='查詢'onclick="javascript:return(checkValue(this.form));"/>
			<html:button  styleClass='formcss_rbutton' property='doClear' value='清除' onclick="clearForm(this.form)" />
		</td>
	</tr>
</table>
