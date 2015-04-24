<!--
程式目的：受分配單位資料維護
程式代號：HAMA04
程式日期：1000920
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doQry' value='查詢'/>
			<html:button  styleClass='formcss_rbutton' property='doClear' value='清除' onclick="clearForm(this.form)"/>
		</td>
	</tr>
</table>